package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;


/** Represents an array of Character.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class CharArrayWrapMapping implements TypeMapping<String> {
  @Override
  public final String getFieldType() {
    return "Character[]";
  }

  @Override
  public final String getFunctionType() {
    return "charArrayWrapType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "charArrayWrapValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "'X'";
  }
}