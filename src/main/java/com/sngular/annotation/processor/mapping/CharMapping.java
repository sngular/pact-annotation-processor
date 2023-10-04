package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.RandomStringUtils;

public class CharMapping implements TypeMapping<String> {

  @Override
  public String getFieldType() {
    return "char";
  }
  @Override
  public String getFunctionType() {
    return "charType";
  }

  @Override
  public String getFunctionOnlyValue() {
    return "charValue";
  }

  @Override
  public String getRandomDefaultValue(final FieldValidations fieldValidations) {
    return RandomStringUtils.randomAlphanumeric(1);
  }
}
