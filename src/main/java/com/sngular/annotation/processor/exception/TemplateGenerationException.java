package com.sngular.annotation.processor.exception;

public class TemplateGenerationException extends RuntimeException {

  private static final String ERROR_MESSAGE = "Error processing template builder for annotation %s";

  public TemplateGenerationException(final String annotationName, final Exception ex) {
    super(String.format(ERROR_MESSAGE, annotationName), ex);
  }
}
