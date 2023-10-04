package com.sngular.annotation.processor.mapping;

import java.util.Objects;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomUtils;

public class LongMapping implements TypeMapping<Long> {

  @Override
  public String getFieldType() {
    return "long";
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
  public Long getRandomDefaultValue(final FieldValidations fieldValidations) {
    if (Objects.nonNull(fieldValidations)) {
      return RandomUtils.nextLong((Long) ObjectUtils.defaultIfNull(fieldValidations.getMin(), Long.MIN_VALUE),
                                  (Long) ObjectUtils.defaultIfNull(fieldValidations.getMax(), Long.MAX_VALUE));
    }
    return RandomUtils.nextLong(0, Long.MAX_VALUE);
  }

  @Override
  public String getSuffixValue() {
    return "L";
  }
}
