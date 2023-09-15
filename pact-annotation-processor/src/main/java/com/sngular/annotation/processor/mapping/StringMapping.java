package com.sngular.annotation.processor.mapping;

import java.util.Objects;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public class StringMapping implements TypeMapping<String> {

  public static final int DEFAULT_MAX = 15;

  public static final int DEFAULT_MIN = 1;

  @Override
  public String getFieldType() {
    return "java.lang.String";
  }

  @Override
  public String getFunctionType() {
    return "stringType";
  }

  @Override
  public String getFunctionOnlyValue() {
    return "stringValue";
  }

  @Override
  public String getRandomDefaultValue(final FieldValidations fieldValidations) {
    int count;
    if (Objects.nonNull(fieldValidations)) {
      count = RandomUtils.nextInt(ObjectUtils.defaultIfNull(fieldValidations.getMin(), DEFAULT_MIN),
                                  ObjectUtils.defaultIfNull(fieldValidations.getMax(), DEFAULT_MAX));
    } else {
      count = RandomUtils.nextInt(DEFAULT_MIN, DEFAULT_MAX);
    }
    return RandomStringUtils.randomAlphanumeric(count);
  }
}
