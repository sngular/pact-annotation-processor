package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of Short.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class ShortArrayWrapMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "Short[]";
  }

  @Override
  public final String getFunctionType() {
    return "shortArrayWrapType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "shortArrayWrapValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "32767";
  }
}