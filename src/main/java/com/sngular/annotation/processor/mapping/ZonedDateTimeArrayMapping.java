package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

public class ZonedDateTimeArrayMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "ZonedDateTime[]";
  }

  @Override
  public final String getFunctionType() {
    return "zonedDateTimeArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "zonedDateTimeArrayValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "2024-02-28T13:59-06:00[America/Mexico_City]";
  }

  @Override
  public final String getFormatValue() {
    return "yyyy-MM-dd'T'HH:mm:ss[.SSSSSS][.SSS]XXX['['VV']']";
  }
}
