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

public class DecimalMapping implements TypeMapping<Number> {

  @Override
  public final String getFieldType() {
    return "java.math.BigDecimal";
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
  public final Number getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    final double result;
    if (Objects.nonNull(fieldValidations) && ObjectUtils.anyNotNull(fieldValidations.getMin(), fieldValidations.getMax())) {

      final int minValue = ObjectUtils.defaultIfNull(fieldValidations.getMin(), (int) Byte.MIN_VALUE);
      final int maxValue = ObjectUtils.defaultIfNull(fieldValidations.getMax(), (int) Byte.MAX_VALUE);

      result = uniformRandomProvider.nextDouble(minValue, maxValue);
    } else {

      result = uniformRandomProvider.nextDouble(0, Double.MAX_VALUE);
    }
    return result;
  }
}
