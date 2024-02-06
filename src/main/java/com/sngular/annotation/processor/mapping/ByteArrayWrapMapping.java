package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

/** Represents an array of Byte.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class ByteArrayWrapMapping implements TypeMapping<Integer> {

  @Override
  public final String getFieldType() {
    return "Byte[]";
  }

  @Override
  public final String getFunctionType() {
    return "byteArrayWrapType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "byteArrayWrapValue";
  }

  @Override
  public final Integer getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return 127;
  }
}
