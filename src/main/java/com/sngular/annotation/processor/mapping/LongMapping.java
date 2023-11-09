/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.mapping;

import java.util.Objects;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

public class LongMapping implements TypeMapping<Long> {

  private final UniformRandomProvider uniformRandomProvider = RandomSource.XO_RO_SHI_RO_128_PP.create();

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
    if (Objects.nonNull(fieldValidations) && ObjectUtils.anyNotNull(fieldValidations.getMin(), fieldValidations.getMax())) {

      final long minValue = Objects.nonNull(fieldValidations.getMin()) ? fieldValidations.getMin() : Long.MIN_VALUE;
      final long maxValue = Objects.nonNull(fieldValidations.getMax()) ? fieldValidations.getMax() : Long.MIN_VALUE;

      return uniformRandomProvider.nextLong(minValue, maxValue);
    }

    return uniformRandomProvider.nextLong(0, Long.MAX_VALUE);
  }

  @Override
  public final String getSuffixValue() {
    return "L";
  }
}
