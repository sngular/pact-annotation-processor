package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of int.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class IntArrayMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "int[]";
  }

  @Override
  public final String getFunctionType() {
    return "intArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "intArrayValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "-2147483648";
  }
}