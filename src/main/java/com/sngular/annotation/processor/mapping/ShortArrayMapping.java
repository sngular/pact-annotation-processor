package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of short.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class ShortArrayMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "short[]";
  }

  @Override
  public final String getFunctionType() {
    return "shortArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "shortArrayValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return 	"-32768";
  }
}