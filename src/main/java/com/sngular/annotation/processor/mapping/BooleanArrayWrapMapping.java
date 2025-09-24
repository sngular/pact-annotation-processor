package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of Boolean.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class BooleanArrayWrapMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "Boolean[]";
  }

  @Override
  public final String getFunctionType() {
    return "booleanArrayWrapType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "booleanArrayWrapValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "false";
  }
}