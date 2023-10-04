package com.sngular.annotation.processor.exception;

public class TemplateFactoryException extends RuntimeException {

  private static final String ERROR_MESSAGE = "Error processing template factory";

  public TemplateFactoryException(final Exception ex) {
    super(ERROR_MESSAGE, ex);
  }
}
