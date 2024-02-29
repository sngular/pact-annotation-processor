package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of char.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class CharArrayMapping implements TypeMapping<String> {
  @Override
  public final String getFieldType() {
    return "char[]";
  }

  @Override
  public final String getFunctionType() {
    return "charArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "charArrayValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "'x'";
  }
}