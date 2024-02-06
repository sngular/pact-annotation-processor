package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of Long.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class LongArrayWrapMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "Long[]";
  }

  @Override
  public final String getFunctionType() {
    return "longArrayWrapType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "longArrayWrapType";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "9223372036854775807L";
  }

  @Override
  public final String getSuffixValue() {
    return "L";
  }
}