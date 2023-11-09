package com.sngular.annotation.processor;

import com.google.testing.compile.Compilation;
import com.google.testing.compile.CompilationSubject;
import com.google.testing.compile.Compiler;
import com.google.testing.compile.JavaFileObjects;
import org.apache.commons.rng.RestorableUniformRandomProvider;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class RandomValueGenerationTest {

  @Test
  public void test() {
    var theMock = Mockito.mock(RestorableUniformRandomProvider.class);
    var processor = new PactDslProcessor();
    processor.setRandomSource(theMock);
    Mockito.when(theMock.nextInt(0, Integer.MAX_VALUE)).thenReturn(18);
    Compilation compilation = Compiler.javac().withProcessors(processor).compile(JavaFileObjects.forResource("random/Student.java"));
    CompilationSubject.assertThat(compilation).succeeded();
    CompilationSubject.assertThat(compilation).generatedSourceFile("com/sngular/annotation/examples/StudentBuilder")
                      .hasSourceEquivalentTo(JavaFileObjects.forResource("random/StudentBuilder.java"));

  }
}
