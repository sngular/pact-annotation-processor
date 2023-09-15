package com.sngular.annotation.processor.mapping;

import java.util.Objects;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomUtils;

public class DecimalMapping implements TypeMapping<Number> {

  @Override
  public String getFieldType() {
    return "java.math.BigDecimal";
  }

  @Override
  public String getFunctionType() {
    return "decimalType";
  }

  @Override
  public String getFunctionOnlyValue() {
    return "decimalValue";
  }

  @Override
  public Number getRandomDefaultValue(final FieldValidations fieldValidations) {
    if (Objects.nonNull(fieldValidations)) {
      return RandomUtils.nextDouble(ObjectUtils.defaultIfNull((double) fieldValidations.getMin(), Double.MIN_VALUE),
                                    ObjectUtils.defaultIfNull((double) fieldValidations.getMax(), Double.MAX_VALUE));
    }
    return RandomUtils.nextDouble(0, Double.MAX_VALUE);
  }
}
