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

public class BigDecimalMapping implements TypeMapping<Number> {

  private final UniformRandomProvider uniformRandomProvider = RandomSource.XO_RO_SHI_RO_128_PP.create();

  @Override
  public final String getFieldType() {
    return "BigDecimal";
  }

  @Override
  public final String getFunctionType() {
    return "decimalType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "decimalValue";
  }

  @Override
  public final Number getRandomDefaultValue(final FieldValidations fieldValidations) {
    final Number randomDefaultValue;

    if (Objects.nonNull(fieldValidations) && ObjectUtils.anyNotNull(fieldValidations.getMin(), fieldValidations.getMax())) {
      final int minValue = ObjectUtils.defaultIfNull(fieldValidations.getMin(), 0);
      final int maxValue = ObjectUtils.defaultIfNull(fieldValidations.getMax(), (int) Double.MAX_VALUE);

      randomDefaultValue = uniformRandomProvider.nextDouble(minValue, maxValue);
    } else {
      randomDefaultValue = uniformRandomProvider.nextDouble(Double.MIN_VALUE, Double.MAX_VALUE);
    }

    return randomDefaultValue;
  }
}
