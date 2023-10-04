package com.sngular.annotation.processor.mapping;

import java.util.Objects;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomUtils;

public class ByteMapping implements TypeMapping<Integer> {

  @Override
  public String getFieldType() {
    return "byte";
  }

  @Override
  public String getFunctionType() {
    return "byteType";
  }

  @Override
  public String getFunctionOnlyValue() {
    return "byteValue";
  }

  @Override
  public Integer getRandomDefaultValue(final FieldValidations fieldValidations) {
    if (Objects.nonNull(fieldValidations)) {
      return RandomUtils.nextInt(ObjectUtils.defaultIfNull(fieldValidations.getMin(), (int) Byte.MIN_VALUE),
                                 ObjectUtils.defaultIfNull(fieldValidations.getMax(), (int) Byte.MAX_VALUE));
    }
    return RandomUtils.nextInt(0, Integer.MAX_VALUE);
  }
}
