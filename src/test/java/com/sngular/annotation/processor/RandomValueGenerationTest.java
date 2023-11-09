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

public class RandomValueGenerationTest {

  @Test
  public void test() {
    try (MockedStatic<RandomUtils> utilities = Mockito.mockStatic(RandomUtils.class)) {
      utilities.when(() -> RandomUtils.nextInt(0, Integer.MAX_VALUE)).thenReturn(18);
      Assertions.assertThat(RandomUtils.nextInt(0, Integer.MAX_VALUE)).isEqualTo(18);
      Compilation compilation = Compiler.javac().withProcessors(new PactDslProcessor()).compile(JavaFileObjects.forResource("random/Student.java"));
      CompilationSubject.assertThat(compilation).succeeded();
      CompilationSubject.assertThat(compilation).generatedSourceFile("com/sngular/annotation/examples/StudentBuilder")
                        .hasSourceEquivalentTo(JavaFileObjects.forResource("random/StudentBuilder.java"));

    }
  }
}
