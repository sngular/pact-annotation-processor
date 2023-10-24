/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.AnnotationValue;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Name;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.DeclaredType;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

import com.google.auto.service.AutoService;
import com.google.common.collect.ImmutableMap;
import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;
import com.sngular.annotation.processor.exception.TemplateFactoryException;
import com.sngular.annotation.processor.exception.TemplateGenerationException;
import com.sngular.annotation.processor.mapping.BooleanMapping;
import com.sngular.annotation.processor.mapping.ByteMapping;
import com.sngular.annotation.processor.mapping.CharMapping;
import com.sngular.annotation.processor.mapping.DateMapping;
import com.sngular.annotation.processor.mapping.DecimalMapping;
import com.sngular.annotation.processor.mapping.IntegerMapping;
import com.sngular.annotation.processor.mapping.LongMapping;
import com.sngular.annotation.processor.mapping.ShortMapping;
import com.sngular.annotation.processor.mapping.StringMapping;
import com.sngular.annotation.processor.mapping.TypeMapping;
import com.sngular.annotation.processor.mapping.ZonedDateTimeMapping;
import com.sngular.annotation.processor.model.ClassBuilderTemplate;
import com.sngular.annotation.processor.model.DslComplexField;
import com.sngular.annotation.processor.model.DslComplexTypeEnum;
import com.sngular.annotation.processor.model.DslField;
import com.sngular.annotation.processor.model.DslSimpleField;
import com.sngular.annotation.processor.model.FieldValidations;
import com.sngular.annotation.processor.template.ClasspathTemplateLoader;
import com.sngular.annotation.processor.template.TemplateFactory;
import freemarker.template.TemplateException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.IteratorUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jetbrains.annotations.NotNull;

@Slf4j
@AutoService(Processor.class)
@SupportedAnnotationTypes("com.sngular.annotation.pact.PactDslBodyBuilder")
public class PactDslProcessor extends AbstractProcessor {

  static final Map<String, TypeMapping> TYPE_MAPPING = ImmutableMap.<String, TypeMapping>builder()
                                                                   .put("int", new IntegerMapping())
                                                                   .put("short", new ShortMapping())
                                                                   .put("byte", new ByteMapping())
                                                                   .put("long", new LongMapping())
                                                                  .put("char", new CharMapping())
                                                                  .put("java.lang.String", new StringMapping())
                                                                  .put("double", new DecimalMapping())
                                                                  .put("java.math.BigDecimal", new DecimalMapping())
                                                                  .put("boolean", new BooleanMapping())
                                                                  .put("date", new DateMapping())
                                                                  .put("java.time.ZonedDateTime", new ZonedDateTimeMapping())
                                                                  .put("java.util.Date", new DateMapping())
                                                                  .build();

  private static final String CUSTOM_MODIFIERS = "customModifiers";

  private Elements elementUtils;

  private Types typeUtils;

  @Override
  public final SourceVersion getSupportedSourceVersion() {
    return SourceVersion.latestSupported();
  }

  @Override
  public final boolean process(final Set<? extends TypeElement> annotations, final RoundEnvironment roundEnv) {
    final TemplateFactory templateFactory;
    try {
      templateFactory = new TemplateFactory();
    } catch (final TemplateException e) {
      throw new TemplateFactoryException(e);
    }
    elementUtils = processingEnv.getElementUtils();
    typeUtils = processingEnv.getTypeUtils();
    final Set<? extends Element> elementsAnnotatedWith = roundEnv.getElementsAnnotatedWith(PactDslBodyBuilder.class);
    IteratorUtils
        .transformedIterator(elementsAnnotatedWith.iterator(), this::composeBuilderTemplate).forEachRemaining(builderTemplate -> {
          try {
            final var builderFile = processingEnv.getFiler().createSourceFile(builderTemplate.completePath());
            templateFactory.writeTemplateToFile(ClasspathTemplateLoader.TEMPLATE_DSL_BUILDER, builderTemplate, builderFile.openWriter());
          } catch (IOException | TemplateException e) {
            throw new TemplateGenerationException("PactDslBodyBuilder", e);
          }
        });
    return true;
  }

  private ClassBuilderTemplate composeBuilderTemplate(final Element element) {
    final List<? extends Element> fieldElements = getFieldElements(element);
    final var qualifiedName = ((TypeElement) element).getQualifiedName().toString();
    String packageName = null;
    final int lastDot = qualifiedName.lastIndexOf('.');
    if (lastDot > 0) {
      packageName = qualifiedName.substring(0, lastDot);
    }

    final var builderClassName = qualifiedName + "Builder";
    final var builderSimpleClassName = qualifiedName.substring(lastDot + 1);
    return ClassBuilderTemplate.builder()
                               .fileName(builderClassName)
                               .className(builderSimpleClassName)
                               .modelPackage(packageName)
                               .fieldList(getFields(fieldElements))
                               .customModifiers(extractCustomModifiers(element))
                               .build();
  }

  @NotNull
  private static List<? extends Element> getFieldElements(final Element element) {
    return IterableUtils.toList(IterableUtils.filteredIterable(element.getEnclosedElements(), elt -> elt.getKind().isField()));
  }

  @NotNull
  private List<DslField> getFields(final List<? extends Element> fieldElements) {
    return IterableUtils.toList(IterableUtils.transformedIterable(fieldElements, fieldElement -> composeDslField(fieldElement, false)));
  }

  private List<String> getAnnotationValueAsType(final AnnotationMirror annotationMirror, final String key) {
    final var annotationValue = getAnnotationValue(annotationMirror, key);
    if (annotationValue == null) {
      return List.of();
    }
    return Arrays.asList(annotationValue.toString()
                                        .replace(" ", "").replace("{", "")
                                        .replace("}", "").replace("\"", "")
                                        .split(","));
  }

  private AnnotationValue getAnnotationValue(final AnnotationMirror annotationMirror, final String key) {
    for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : annotationMirror.getElementValues().entrySet()) {
      if (entry.getKey().getSimpleName().toString().equals(key)) {
        return entry.getValue();
      }
    }
    return null;
  }

  private DslField composeDslField(final Element fieldElement, final boolean insideCollection) {
    final Optional<TypeMapping> mappingOp = extractMappingByType(fieldElement);
    if (mappingOp.isEmpty()) {
      return composeDslComplexField(fieldElement);
    } else {
      return composeDslSimpleField(fieldElement, mappingOp.get(), insideCollection);
    }
  }

  private DslComplexField composeDslComplexField(final Element element) {
    final Optional<TypeElement> typeElementOp = Optional.ofNullable(elementUtils.getTypeElement(element.asType().toString()));
    final var validationBuilder = FieldValidations.builder();
    if (typeElementOp.isPresent()) {
      final List<? extends Element> fieldElements = getFieldElements(typeElementOp.get());
      for (var annotation : element.asType().getAnnotationMirrors()) {
        if (annotation.getAnnotationType().toString().toUpperCase().endsWith("MAX")) {
          validationBuilder.max(((Long) Objects.requireNonNull(getAnnotationValue(annotation, "value")).getValue()).intValue());
        } else {
          validationBuilder.min(((Long) Objects.requireNonNull(getAnnotationValue(annotation, "value")).getValue()).intValue());
        }
      }
      return DslComplexField.builder()
                            .name(element.getSimpleName().toString())
                            .fieldType(element.asType().toString())
                            .fields(getFields(fieldElements))
                            .complexType(DslComplexTypeEnum.OBJECT)
                            .fieldValidations(validationBuilder.build())
                            .build();
    } else {
      //is collection
      final var type = element.asType();
      var typeStr = type.toString();
      if (CollectionUtils.isNotEmpty(type.getAnnotationMirrors())) {
        for (var annotation : type.getAnnotationMirrors()) {
          typeStr = typeStr.replace(annotation.toString(), "");
          if (annotation.getAnnotationType().toString().toUpperCase().endsWith("MAX")) {
            validationBuilder.max(((Long) Objects.requireNonNull(getAnnotationValue(annotation, "value")).getValue()).intValue());
          } else {
            validationBuilder.min(((Long) Objects.requireNonNull(getAnnotationValue(annotation, "value")).getValue()).intValue());
          }
        }
        typeStr = typeStr.replace(", ", "");
      }
      return DslComplexField.builder()
                            .name(element.getSimpleName().toString())
                            .fieldType(typeStr)
                            .fields(extractTypes(element))
                            .fieldValidations(validationBuilder.build())
                            .complexType(DslComplexTypeEnum.COLLECTION).build();
    }
  }

  @NotNull
  private List<DslField> extractTypes(final Element element) {
    final var listOfCustomMods = CollectionUtils.collect(((DeclaredType) element.asType()).getTypeArguments(), typeUtils::asElement);
    return new ArrayList<>(CollectionUtils.collect(listOfCustomMods, e -> composeDslField(e, true)));

  }

  private List<String> extractCustomModifiers(final Element element) {
    final List<String> customModList = new ArrayList<>();
    final var listOfCustomMods = CollectionUtils.collect(element.getAnnotationMirrors(), a -> getAnnotationValueAsType(a, CUSTOM_MODIFIERS));
    CollectionUtils.collect(listOfCustomMods, customModList::addAll);
    return customModList;
  }

  private DslSimpleField composeDslSimpleField(final Element fieldElement, final TypeMapping mapping, final boolean insideCollection) {
    final var simpleFieldBuilder = DslSimpleField.builder()
                         .name(getNameOrNull(fieldElement.getSimpleName()))
                         .fieldType(mapping.getFieldType())
                         .functionByType(insideCollection ? mapping.getFunctionOnlyValue() : mapping.getFunctionType())
                         .onlyValueFunction(insideCollection)
                         .suffixValue(mapping.getSuffixValue())
                         .formatValue(mapping.getFormatValue());
    if (Objects.nonNull(fieldElement.getAnnotation(Example.class))) {
      simpleFieldBuilder.defaultValue(getDefaultValue(fieldElement, mapping.getFieldType()));
    } else {
      simpleFieldBuilder.defaultValue(mapping.getRandomDefaultValue(null));
    }
    return simpleFieldBuilder.build();
  }

  private String getNameOrNull(final Name simpleName) {
    return simpleName.toString().matches("[A-Z].*") ? null : simpleName.toString();
  }

  private static Object getDefaultValue(final Element fieldElement, final String type) {
    final Object realValue;
    final String value = fieldElement.getAnnotation(Example.class).value();
    if (StringUtils.isNumeric(value)) {
      realValue = switch (type.toLowerCase()) {
        case "integer", "int" -> NumberUtils.toInt(value);
        case "float" -> NumberUtils.toFloat(value);
        case "double" -> NumberUtils.toDouble(value);
        case "bigdecimal" -> NumberUtils.createNumber(value);
        default -> throw new IllegalStateException("Unexpected value: " + type);
      };
    } else {
      realValue = value;
    }
    return realValue;
  }

  private Optional<TypeMapping> extractMappingByType(final Element element) {

    final var type = element.asType();
    return switch (type.getKind()) {
      case BOOLEAN -> Optional.of(TYPE_MAPPING.get("boolean"));
      case BYTE -> Optional.of(TYPE_MAPPING.get("byte"));
      case SHORT -> Optional.of(TYPE_MAPPING.get("short"));
      case INT -> Optional.of(TYPE_MAPPING.get("int"));
      case LONG -> Optional.of(TYPE_MAPPING.get("long"));
      case CHAR -> Optional.of(TYPE_MAPPING.get("char"));
      case FLOAT -> Optional.of(TYPE_MAPPING.get("float"));
      case DOUBLE -> Optional.of(TYPE_MAPPING.get("double"));
      case DECLARED -> Optional.ofNullable(TYPE_MAPPING.get(type.toString()));
      default -> Optional.empty();
    };
  }

}

