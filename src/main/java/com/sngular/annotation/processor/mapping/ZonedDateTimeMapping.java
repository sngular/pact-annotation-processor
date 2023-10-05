package com.sngular.annotation.processor.mapping;

import java.time.ZonedDateTime;

import com.sngular.annotation.processor.model.FieldValidations;

public class ZonedDateTimeMapping implements TypeMapping<ZonedDateTime> {

  @Override
  public String getFieldType() {
    return "java.time.ZonedDateTime";
  }

  @Override
  public String getFunctionType() {
    return "datetime";
  }

  @Override
  public String getFunctionOnlyValue() {
    return "datetimeValue";
  }

  @Override
  public ZonedDateTime getRandomDefaultValue(final FieldValidations fieldValidations) {
    return ZonedDateTime.now();
  }

  @Override
  public String getFormatValue() {
    return "yyyy-MM-dd'T'HH:mm:ss[.SSSSSS][.SSS]XXX['['VV']']";
  }
}
