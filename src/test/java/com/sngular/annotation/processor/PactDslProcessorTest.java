package com.sngular.annotation.processor;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import java.util.Set;

import javax.annotation.processing.Filer;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.TypeVisitor;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;
import javax.tools.JavaFileObject.Kind;
import javax.tools.SimpleJavaFileObject;

import com.sngular.annotation.pact.PactDslBodyBuilder;
import com.sngular.annotation.processor.support.CustomFileObject;
import com.sngular.annotation.processor.support.CustomTypeElement;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class PactDslProcessorTest {

  @Mock
  private RoundEnvironment roundEnvironment;

  @Mock
  private Elements elements;

  @Mock
  private Types types;

  @Mock
  private Filer filer;

  private PactDslProcessor processor;

  @BeforeEach
  public void setUp() {
    final var processingEnvironment = Mockito.mock(ProcessingEnvironment.class);
    processor = new PactDslProcessor();

    processor.init(processingEnvironment);
    when(processingEnvironment.getElementUtils()).thenReturn(elements);
    when(processingEnvironment.getTypeUtils()).thenReturn(types);
    when(processingEnvironment.getFiler()).thenReturn(filer);
  }

  @Test
  void process() throws IOException {


    final var example = Mockito.mock(TypeElement.class);
    final var names = Mockito.mock(Name.class);
    when(names.toString()).thenReturn("People");
    final var fileObject = new CustomFileObject(URI.create("PeopleBuilder.java"), Kind.CLASS);
    when(filer.createSourceFile(anyString())).thenReturn(fileObject);
    when(example.getQualifiedName()).thenReturn(names);
    final var typeElement = new CustomTypeElement();
    when(example.getEnclosedElements()).then(answer -> List.of(typeElement));
    when(roundEnvironment.getElementsAnnotatedWith(PactDslBodyBuilder.class)).then(answer -> Set.of(example));
    processor.process(Collections.emptySet(), roundEnvironment);
  }






}