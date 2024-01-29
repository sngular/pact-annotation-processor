package com.sngular.annotation.processor;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.JavaFileObjects;
import org.junit.jupiter.api.Test;

import static com.google.testing.compile.CompilationSubject.assertThat;
import static com.google.testing.compile.Compiler.javac;

public class ArrayTest {

  @Test
  public void arrays() {

    Compilation compilation = javac().withProcessors(new PactDslProcessor()).compile(JavaFileObjects.forResource("basic/ArrayDataTypes.java"));
    assertThat(compilation).succeeded();
    assertThat(compilation).generatedSourceFile("com/sngular/resources/basic/ArrayDataTypesBuilder")
                           .hasSourceEquivalentTo(JavaFileObjects.forResource("basic/ArrayDataTypesBuilder.java"));
  }
}
