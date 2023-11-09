package com.sngular.annotation.processor;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.CompilationSubject;
import com.google.testing.compile.Compiler;
import com.google.testing.compile.JavaFileObjects;
import org.apache.commons.lang3.RandomUtils;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class DateFormatTest {

  @Test
  public void test() {

    Compilation compilation = Compiler.javac().withProcessors(new PactDslProcessor()).compile(JavaFileObjects.forResource("date/Student.java"));
    CompilationSubject.assertThat(compilation).succeeded();
    CompilationSubject.assertThat(compilation).generatedSourceFile("com/sngular/annotation/examples/StudentBuilder")
                        .hasSourceEquivalentTo(JavaFileObjects.forResource("date/StudentBuilder.java"));

  }
}
