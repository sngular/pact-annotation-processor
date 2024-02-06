package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of int.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class IntArrayWrapMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "Integer[]";
  }

  @Override
  public final String getFunctionType() {
    return "intArrayWrapType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "intArrayWrapValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "2147483647";
  }
}
