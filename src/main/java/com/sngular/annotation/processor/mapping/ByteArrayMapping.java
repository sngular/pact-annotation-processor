package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of byte.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class ByteArrayMapping implements TypeMapping<Integer> {

  @Override
  public final String getFieldType() {
    return "byte[]";
  }

  @Override
  public final String getFunctionType() {
    return "byteArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "byteArrayValue";
  }

  @Override
  public final Integer getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return -128;
  }
}
