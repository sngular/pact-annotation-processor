package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

/** Represents an array of boolean.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class BooleanArrayMapping implements TypeMapping<String> {

  private final UniformRandomProvider uniformRandomProvider = RandomSource.XO_RO_SHI_RO_128_PP.create();

  @Override
  public final String getFieldType() {
    return "boolean[]";
  }

  @Override
  public final String getFunctionType() {
    return "booleanArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "booleanArrayValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "true";
  }
}
