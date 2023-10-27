/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.mapping;

import java.util.Objects;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomUtils;

public class LongMapping implements TypeMapping<Long> {

  @Override
  public final String getFieldType() {
    return "long";
  }

  @Override
  public final String getFunctionType() {
    return "integerType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "integerValue";
  }

  @Override
  public final Long getRandomDefaultValue(final FieldValidations fieldValidations) {
    final long value;
    if (Objects.nonNull(fieldValidations) && ObjectUtils.anyNotNull(fieldValidations.getMin(), fieldValidations.getMax())) {
      final long min = Objects.nonNull(fieldValidations.getMin()) ? fieldValidations.getMin() : Long.MIN_VALUE;
      final long max = Objects.nonNull(fieldValidations.getMax()) ? fieldValidations.getMax() : Long.MIN_VALUE;
      value = RandomUtils.nextLong(min, max);
    } else {
      value = RandomUtils.nextLong(0, Long.MAX_VALUE);
    }
    return value;
  }

  @Override
  public final String getSuffixValue() {
    return "L";
  }
}
