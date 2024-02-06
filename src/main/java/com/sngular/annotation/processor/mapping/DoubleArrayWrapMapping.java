package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.rng.UniformRandomProvider;

import java.util.Objects;

public class DoubleArrayWrapMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "Double[]";
  }

  @Override
  public final String getFunctionType() {
    return "doubleArrayWrapType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "doubleArrayWrapValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "1234567890123456789012345678901234567890.79769313486232D";
  }

  @Override
  public final String getSuffixValue() {
    return "D";
  }
}
