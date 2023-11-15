package com.sngular.annotation.processor;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.jupiter.api.Test;

public class BasicDataTypeTest {

  @Test
  public void characters() {

    Compilation compilation = javac().withProcessors(new PactDslProcessor()).compile(JavaFileObjects.forResource("basic/CharacterDataTypes.java"));
    assertThat(compilation).succeeded();
    assertThat(compilation).generatedSourceFile("com/sngular/resources/basic/CharacterDataTypesBuilder")
                           .hasSourceEquivalentTo(JavaFileObjects.forResource("basic/CharacterDataTypesBuilder.java"));
  }

  @Test
  public void numbers() {

    Compilation compilation = javac().withProcessors(new PactDslProcessor()).compile(JavaFileObjects.forResource("basic/NumericDataTypes.java"));
    assertThat(compilation).succeeded();
    assertThat(compilation).generatedSourceFile("com/sngular/resources/basic/NumericDataTypesBuilder")
                           .hasSourceEquivalentTo(JavaFileObjects.forResource("basic/NumericDataTypesBuilder.java"));
  }
}
