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

public class IntegerMapping implements TypeMapping<Integer> {

  UniformRandomProvider uniformRandomProvider = RandomSource.XO_RO_SHI_RO_128_PP.create();

  @Override
  public final String getFieldType() {
    return "int";
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
  public final Integer getRandomDefaultValue(final FieldValidations fieldValidations) {
    if (Objects.nonNull(fieldValidations) && ObjectUtils.anyNotNull(fieldValidations.getMin(), fieldValidations.getMax())) {

      int minValue = ObjectUtils.defaultIfNull(fieldValidations.getMin(), (int) Byte.MIN_VALUE);
      int maxValue = ObjectUtils.defaultIfNull(fieldValidations.getMax(), (int) Byte.MAX_VALUE);

      return uniformRandomProvider.nextInt(minValue, maxValue);
    }

    return uniformRandomProvider.nextInt(0, Integer.MAX_VALUE);
  }
}
