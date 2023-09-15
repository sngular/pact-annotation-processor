package com.sngular.annotation.processor.mapping;

import java.util.Objects;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomUtils;

public class ShortMapping implements TypeMapping<Integer> {

  @Override
  public String getFieldType() {
    return "short";
  }

  @Override
  public String getFunctionType() {
    return "shortType";
  }

  @Override
  public String getFunctionOnlyValue() {
    return "shortValue";
  }

  @Override
  public Integer getRandomDefaultValue(final FieldValidations fieldValidations) {
    if (Objects.nonNull(fieldValidations)) {
      return RandomUtils.nextInt(ObjectUtils.defaultIfNull(fieldValidations.getMin(), (int) Short.MIN_VALUE),
                                 ObjectUtils.defaultIfNull(fieldValidations.getMax(), (int) Short.MAX_VALUE));
    }
    return RandomUtils.nextInt(0, Integer.MAX_VALUE);
  }
}
