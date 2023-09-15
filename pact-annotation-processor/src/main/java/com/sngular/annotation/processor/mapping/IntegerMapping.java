package com.sngular.annotation.processor.mapping;

import java.util.Objects;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomUtils;

public class IntegerMapping implements TypeMapping<Integer> {

  @Override
  public String getFieldType() {
    return "int";
  }

  @Override
  public String getFunctionType() {
    return "integerType";
  }

  @Override
  public String getFunctionOnlyValue() {
    return "integerValue";
  }

  @Override
  public Integer getRandomDefaultValue(final FieldValidations fieldValidations) {
    if (Objects.nonNull(fieldValidations)) {
      return RandomUtils.nextInt(ObjectUtils.defaultIfNull(fieldValidations.getMin(), Integer.MIN_VALUE),
                                 ObjectUtils.defaultIfNull(fieldValidations.getMax(), Integer.MAX_VALUE));
    }
    return RandomUtils.nextInt(0, Integer.MAX_VALUE);
  }
}
