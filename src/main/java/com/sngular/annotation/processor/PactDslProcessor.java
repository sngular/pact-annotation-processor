/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
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
import com.sngular.annotation.pact.DslExclude;
import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;
import com.sngular.annotation.processor.exception.PactProcessorException;
import com.sngular.annotation.processor.exception.TemplateFactoryException;
import com.sngular.annotation.processor.exception.TemplateGenerationException;
import com.sngular.annotation.processor.mapping.*;
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
import org.apache.commons.rng.RestorableUniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;
import org.jetbrains.annotations.NotNull;

@Slf4j
@AutoService(Processor.class)
@SupportedAnnotationTypes("com.sngular.annotation.pact.PactDslBodyBuilder")
public class PactDslProcessor extends AbstractProcessor {

  static final Map<String, TypeMapping<?>> TYPE_MAPPING = ImmutableMap.<String, TypeMapping<?>>builder()
                                                                   .put("int", new IntegerMapping())
                                                                   .put("Integer", new IntegerMapping())
                                                                   .put("BigInteger", new BigIntegerMapping())
                                                                   .put("short", new ShortMapping())
                                                                   .put("Short", new ShortMapping())
                                                                   .put("byte", new ByteMapping())
                                                                   .put("Byte", new ByteMapping())
                                                                   .put("long", new LongMapping())
                                                                   .put("Long", new LongMapping())
                                                                   .put("char", new CharMapping())
                                                                   .put("Character", new CharMapping())
                                                                   .put("String", new StringMapping())
                                                                   .put("float", new FloatMapping())
                                                                   .put("Float", new FloatMapping())
                                                                   .put("double", new DoubleMapping())
                                                                   .put("Double", new DoubleMapping())
                                                                   .put("BigDecimal", new BigDecimalMapping())
                                                                   .put("boolean", new BooleanMapping())
                                                                   .put("Boolean", new BooleanMapping())
                                                                   .put("date", new DateMapping())
                                                                   .put("java.time.ZonedDateTime", new ZonedDateTimeMapping())
                                                                   .put("ZonedDateTime", new ZonedDateTimeMapping())
                                                                   .put("java.util.Date", new DateMapping())
                                                                   .put("Date", new DateMapping())
                                                                    .put("String[]", new StringArrayMapping())
                                                                    .put("java.lang.String[]", new StringArrayMapping())
                                                                    .put("boolean[]", new BooleanArrayMapping())
                                                                    .put("java.lang.Boolean[]", new BooleanArrayWrapMapping())
                                                                    .put("byte[]", new ByteArrayMapping())
                                                                    .put("java.lang.Byte[]", new ByteArrayWrapMapping())
                                                                    .put("short[]", new ShortArrayMapping())
                                                                    .put("java.lang.Short[]", new ShortArrayWrapMapping())
                                                                    .put("int[]", new IntArrayMapping())
                                                                    .put("java.lang.Integer[]", new IntArrayWrapMapping())
                                                                    .put("long[]", new LongArrayMapping())
                                                                    .put("java.lang.Long[]", new LongArrayWrapMapping())
                                                                    .put("char[]", new CharArrayMapping())
                                                                    .put("java.lang.Character[]", new CharArrayWrapMapping())
                                                                    .put("float[]", new FloatArrayMapping())
                                                                    .put("java.lang.Float[]", new FloatArrayWrapMapping())
                                                                    .put("double[]", new DoubleArrayMapping())
                                                                    .put("java.lang.Double[]", new DoubleArrayWrapMapping())
                                                                   .build();

  private static final String CUSTOM_MODIFIERS = "customModifiers";

  private Elements elementUtils;

  private Types typeUtils;

  private RestorableUniformRandomProvider randomSource = RandomSource.XO_RO_SHI_RO_128_PP.create();

  public PactDslProcessor() {
  }

  public PactDslProcessor(final RestorableUniformRandomProvider randomSource) {
    this.randomSource = randomSource;
  }

  @NotNull
  private static List<? extends Element> getFieldElements(final Element element) {
    return IterableUtils.toList(IterableUtils.filteredIterable(element.getEnclosedElements(), elt -> elt.getKind().isField()));
  }

  private static String getFormat(final Element fieldElement, final String defaultFormat) {
    final String value = fieldElement.getAnnotation(Example.class).format();
    return StringUtils.defaultIfEmpty(value, defaultFormat);
  }

  private static String getFormatArray(final Element fieldElement, final String defaultFormat) {
    String[] value = fieldElement.getAnnotation(Example.class).array();
    return StringUtils.defaultIfEmpty(PactDslProcessor.getStringFromArray(value,defaultFormat), defaultFormat);
  }

  private static String getStringFromArray(String[] value, String defaultFormat) {

      String arrayToString = "";

      for (int i = 0; i < value.length; i++) {

        switch (TypeArray.get(defaultFormat)) {
          case STRING_ARRAY:
            if (i == value.length-1) {
              arrayToString += "\"" + value[i] + "\"";
            } else {
              arrayToString += "\"" + value[i] + "\",";
            }
            break;

          case BOOLEAN_ARRAY:
          case BYTE_ARRAY:
          case SHORT_ARRAY:
          case INT_ARRAY:
          case LONG_ARRAY:
          case FLOAT_ARRAY:
          case DOUBLE_ARRAY:
            if (i == value.length-1) {
              arrayToString += value[i] ;
            } else {
              arrayToString += value[i] + ",";
            }
            break;

          case CHAR_ARRAY:
            if (i == value.length-1) {
              arrayToString += "'" + value[i] + "'";
            } else {
              arrayToString += "'" + value[i] + "',";
            }
            break;

          default:
            arrayToString = "not_found_type_array";
        }
      }
      return arrayToString;
  }

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

    final var builderSimpleClassName = qualifiedName.substring(lastDot + 1);
    final var builderClassName = builderSimpleClassName + "Builder";
    return ClassBuilderTemplate.builder()
                               .fileName(builderClassName)
                               .className(builderSimpleClassName)
                               .modelPackage(packageName)
                               .fieldList(getFields(fieldElements))
                               .customModifiers(extractCustomModifiers(element))
                               .build();
  }

  @NotNull
  private List<DslField> getFields(final List<? extends Element> fieldElements) {
    return IterableUtils.toList(IterableUtils.transformedIterable(fieldElements, fieldElement -> composeDslField(fieldElement, false)));
  }

  private List<String> getAnnotationValueAsType(final AnnotationMirror annotationMirror, final String key) {
    final var valueAsTypeList = new ArrayList<String>();
    final var annotationValue = getAnnotationValue(annotationMirror, key);
    if (annotationValue != null) {
      valueAsTypeList.addAll(List.of(annotationValue.toString()
                                                    .replace(" ", "").replace("{", "")
                                                    .replace("}", "").replace("\"", "")
                                                    .split(",")));
    }
    return valueAsTypeList;
  }

  private AnnotationValue getAnnotationValue(final AnnotationMirror annotationMirror, final String key) {
    AnnotationValue annotationValue = null;
    for (Map.Entry<? extends ExecutableElement, ? extends AnnotationValue> entry : annotationMirror.getElementValues().entrySet()) {
      if (entry.getKey().getSimpleName().toString().equals(key)) {
        annotationValue = entry.getValue();
      }
    }
    return annotationValue;
  }

  private DslField composeDslField(final Element fieldElement, final boolean insideCollection) {
    final DslField result;
    final Optional<TypeMapping<?>> mappingOp = extractMappingByType(fieldElement);
    if (mappingOp.isEmpty()) {
      if (checkIfOwn(fieldElement)) {
        result = composeDslComplexField(fieldElement);
      } else {
        final String type = extractType(fieldElement);
        if (type.endsWith("List") || type.endsWith("Map") || type.endsWith("Set") || type.endsWith("Collection")) {
          result = composeCollection(fieldElement);
        } else {
          result = composeDslComplexField(fieldElement);
        }
      }
    } else {
      result = composeDslSimpleField(fieldElement, mappingOp.get(), insideCollection);
    }
    return result;
  }

  private DslComplexField composeDslComplexField(final Element element) {
    return DslComplexField.builder()
                          .name(element.getSimpleName().toString())
                          .fieldType(element.asType().toString())
                          .needBuilder(checkIfOwn(element))
                          .complexType(DslComplexTypeEnum.OBJECT)
                          .fieldValidations(extractValidations(element))
                          .empty(Objects.nonNull(element.getAnnotation(DslExclude.class)))
                          .build();
  }

  private DslComplexField composeCollection(final Element element) {
    final var typeStr = cleanType(element);
    return DslComplexField.builder()
                          .name(element.getSimpleName().toString())
                          .fieldType(typeStr)
                          .fields(extractTypes(element))
                          .fieldValidations(extractValidations(element))
                          .complexType(DslComplexTypeEnum.COLLECTION)
                          .empty(Objects.nonNull(element.getAnnotation(DslExclude.class)))
                          .build();
  }

  private boolean checkIfOwn(final Element element) {
    final var typePackage = elementUtils.getPackageOf(typeUtils.asElement(element.asType())).toString();
    final var parentType = elementUtils.getPackageOf(typeUtils.asElement(element.getEnclosingElement().asType())).toString();
    return parentType.equalsIgnoreCase(typePackage);
  }

  private String extractType(final Element element) {
    return ((TypeElement) typeUtils.asElement(element.asType())).getQualifiedName().toString();
  }

  private String cleanType(final Element element) {
    var finalType = element.asType().toString();
    for (var annotation : element.asType().getAnnotationMirrors()) {
      finalType = finalType.replace(annotation.toString(), "");
    }
    return finalType.replace(", ", "");
  }

  private FieldValidations extractValidations(final Element element) {
    final var validationBuilder = FieldValidations.builder();

    int minValue = 0;
    int maxValue = 0;
    final var type = element.asType();
    if (CollectionUtils.isNotEmpty(type.getAnnotationMirrors())) {
      for (var annotation : type.getAnnotationMirrors()) {
        if (annotation.getAnnotationType().toString().toUpperCase().endsWith("MAX")) {
          maxValue = ((Long) Objects.requireNonNull(getAnnotationValue(annotation, "value")).getValue()).intValue();
          validationBuilder.max(maxValue);
        } else {
          minValue = ((Long) Objects.requireNonNull(getAnnotationValue(annotation, "value")).getValue()).intValue();
          validationBuilder.min(minValue);
        }
      }
      //For random size calculation: defaults to +10 elements max if not defined.
      maxValue = (maxValue == 0) ? (minValue + 10) : maxValue;
      validationBuilder.randomSize(new Random().nextInt(maxValue - minValue + 1) + minValue);
    }
    return validationBuilder.build();
  }

  @NotNull
  private List<DslField> extractTypes(final Element element) {
    final List<DslField> listOfFields;
    final var listOfCustomMods = new ArrayList<>(CollectionUtils.collect(((DeclaredType) element.asType()).getTypeArguments(), typeUtils::asElement));
    if (listOfCustomMods.size() > 1) {
      listOfFields = new ArrayList<>(CollectionUtils.collect(listOfCustomMods, e -> composeDslField(e, true)));
    } else {
      listOfFields = List.of(
          composeDslSimpleField(listOfCustomMods.get(0),
                                extractMappingByType(listOfCustomMods.get(0))
                                    .orElseThrow(() -> new PactProcessorException(listOfCustomMods.get(0).getSimpleName().toString())),
                                true));
    }
    return listOfFields;
  }

  private List<String> extractCustomModifiers(final Element element) {
    final List<String> customModList = new ArrayList<>();
    final var listOfCustomMods = CollectionUtils.collect(element.getAnnotationMirrors(), a -> getAnnotationValueAsType(a, CUSTOM_MODIFIERS));
    CollectionUtils.collect(listOfCustomMods, customModList::addAll);
    return customModList;
  }

  private DslSimpleField composeDslSimpleField(final Element fieldElement, final TypeMapping<?> mapping, final boolean insideCollection) {
    final var validationBuilder = createValidationBuilder(fieldElement);
    final var simpleFieldBuilder = createSimpleFieldBuilder(fieldElement, mapping, insideCollection, validationBuilder);

    return simpleFieldBuilder.build();
  }

  private FieldValidations.FieldValidationsBuilder createValidationBuilder(final Element fieldElement) {
    final var validationBuilder = FieldValidations.builder();

    for (var annotation : fieldElement.asType().getAnnotationMirrors()) {
      if (annotation.getAnnotationType().toString().toUpperCase().endsWith("MAX")) {
        validationBuilder.max(((Long) Objects.requireNonNull(getAnnotationValue(annotation, "value")).getValue()).intValue());
      } else {
        validationBuilder.min(((Long) Objects.requireNonNull(getAnnotationValue(annotation, "value")).getValue()).intValue());
      }
    }

    return validationBuilder;
  }

  private DslSimpleField.DslSimpleFieldBuilder createSimpleFieldBuilder(final Element fieldElement, final TypeMapping<?> mapping,
      final boolean insideCollection, final FieldValidations.FieldValidationsBuilder validationBuilder) {
    final var simpleFieldBuilder = DslSimpleField.builder()
                                                 .name(getNameOrNull(fieldElement.getSimpleName()))
                                                 .fieldType(mapping.getFieldType())
                                                 .functionByType(insideCollection ? mapping.getFunctionOnlyValue() : mapping.getFunctionType())
                                                 .onlyValueFunction(insideCollection)
                                                 .suffixValue(mapping.getSuffixValue())
                                                 .formatValue(mapping.getFormatValue())
                                                 .fieldValidations(validationBuilder.build())
                                                 .empty(false);

    if (Objects.nonNull(fieldElement.getAnnotation(DslExclude.class))) {
        simpleFieldBuilder.empty(true);

    } else if (Objects.nonNull(fieldElement.getAnnotation(Example.class))) {

        if (fieldElement.getAnnotation(Example.class).array().length != 0) {
            simpleFieldBuilder.defaultValue(getFormatArray(fieldElement, mapping.getFieldType()));
            simpleFieldBuilder.formatValue(null);
        } else {
            simpleFieldBuilder.defaultValue(getDefaultValue(fieldElement, mapping.getFieldType()));
            simpleFieldBuilder.formatValue(getFormat(fieldElement, mapping.getFormatValue()));
        }
    } else {
        simpleFieldBuilder.defaultValue(mapping.getRandomDefaultValue(validationBuilder.build(), randomSource));
        simpleFieldBuilder.formatValue(mapping.getFormatValue());
    }

    return simpleFieldBuilder;
  }

  private String getNameOrNull(final Name simpleName) {
    return simpleName.toString().matches("[A-Z].*") ? null : simpleName.toString();
  }

  private static Object getDefaultValue(final Element fieldElement, final String type) {
    final Object realValue;
    final String value = fieldElement.getAnnotation(Example.class).value();
    if (NumberUtils.isCreatable(value)) {
      realValue = switch (type) {
        case "int", "Integer" -> NumberUtils.toInt(value);
        case "BigInteger" -> NumberUtils.createBigInteger(value);
        case "long", "Long" -> NumberUtils.toLong(value);
        case "short", "Short" -> NumberUtils.toShort(value);
        case "byte", "Byte" -> NumberUtils.toByte(value);
        case "float", "Float" -> NumberUtils.toFloat(value);
        case "double", "Double" -> NumberUtils.toDouble(value);
        case "BigDecimal" -> NumberUtils.createBigDecimal(value);
        default -> throw new IllegalStateException("Unexpected value: " + type);
      };
    } else {
      realValue = value;
    }
    return realValue;
  }

  private Optional<TypeMapping<?>> extractMappingByType(final Element element) {

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
      case ARRAY -> Optional.of(TYPE_MAPPING.get(type.toString()));
      case DECLARED -> Optional.ofNullable(TYPE_MAPPING.get(this.typeUtils.asElement(type).getSimpleName().toString()));
      default -> Optional.empty();
    };
  }
}

