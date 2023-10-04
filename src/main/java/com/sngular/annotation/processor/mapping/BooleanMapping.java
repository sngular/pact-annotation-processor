package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.RandomUtils;

public class BooleanMapping implements TypeMapping<Boolean> {

  @Override
  public String getFieldType() {
    return "boolean";
  }

  @Override
  public String getFunctionType() {
    return "booleanType";
  }

  @Override
  public String getFunctionOnlyValue() {
    return "booleanValue";
  }

  @Override
  public Boolean getRandomDefaultValue(final FieldValidations fieldValidations) {
    return RandomUtils.nextBoolean();
  }
}
