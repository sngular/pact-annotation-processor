package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of float.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class FloatArrayMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "float[]";
  }

  @Override
  public final String getFunctionType() {
    return "floatArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "floatArrayValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "-123456789012345678901234567890.402823f";
  }

  @Override
  public final String getSuffixValue() {
    return "F";
  }
}