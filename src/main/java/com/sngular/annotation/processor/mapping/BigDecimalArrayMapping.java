package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

public class BigDecimalArrayMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "BigDecimal[]";
  }

  @Override
  public final String getFunctionType() {
    return "bigDecimalArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "bigDecimalArrayValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "12345678901234567890123456789012345678901234567890123456789012345678901234567890.901234567890123456789012345678901234567890";
  }
}
