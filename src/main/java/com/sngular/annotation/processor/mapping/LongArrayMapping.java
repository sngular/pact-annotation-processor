package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of long.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class LongArrayMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "long[]";
  }

  @Override
  public final String getFunctionType() {
    return "longArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "longArrayType";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "-9223372036854775808l";
  }

  @Override
  public final String getSuffixValue() {
    return "L";
  }
}