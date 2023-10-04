package com.sngular.annotation.processor.mapping;

import java.time.Instant;
import java.util.Date;

import com.sngular.annotation.processor.model.FieldValidations;

public class DateMapping implements TypeMapping<Date> {

  @Override
  public String getFieldType() {
    return "java.util.Date";
  }

  @Override
  public String getFunctionType() {
    return "date";
  }

  @Override
  public String getFunctionOnlyValue() {
    return "dateValue";
  }

  @Override
  public Date getRandomDefaultValue(final FieldValidations fieldValidations) {
    return Date.from(Instant.now());
  }

  @Override
  public String getFormatValue() {
    return "yyyy-MM-dd";
  }
}
