package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;

public interface TypeMapping<T> {

  String getFieldType();

  String getFunctionType();

  String getFunctionOnlyValue();

  T getRandomDefaultValue(final FieldValidations fieldValidations);

  default String getSuffixValue() {
    return "";
  }

  default String getFormatValue() {
    return null;
  }
}
