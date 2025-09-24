package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

public class DateArrayMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "Date[]";
  }

  @Override
  public final String getFunctionType() {
    return "dateArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "dateArrayValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "Wed Feb 28 13:59:00 CST 2024";
  }

  @Override
  public final String getFormatValue() {
    return "yyyy-MM-dd";
  }
}
