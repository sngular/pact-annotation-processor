package com.sngular.annotation.processor;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.CompilationSubject;
import com.google.testing.compile.Compiler;
import com.google.testing.compile.JavaFileObjects;
import org.junit.jupiter.api.Test;

public class DateFormatTest {

  @Test
  public void basicDatesUsage() {

    Compilation compilation = Compiler.javac().withProcessors(new PactDslProcessor()).compile(JavaFileObjects.forResource("date/DateDataTypes.java"));
    CompilationSubject.assertThat(compilation).succeeded();
    CompilationSubject.assertThat(compilation).generatedSourceFile("com/sngular/annotation/examples/DateDataTypesBuilder")
                        .hasSourceEquivalentTo(JavaFileObjects.forResource("date/DateDataTypesBuilder.java"));

  }
}
