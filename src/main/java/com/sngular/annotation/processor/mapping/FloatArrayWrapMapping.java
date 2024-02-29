package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of Float.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class FloatArrayWrapMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "Float[]";
  }

  @Override
  public final String getFunctionType() {
    return "floatArrayWrapType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "floatArrayWrapValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "123456789012345678901234567890.402823F";
  }

  @Override
  public final String getSuffixValue() {
    return "F";
  }
}