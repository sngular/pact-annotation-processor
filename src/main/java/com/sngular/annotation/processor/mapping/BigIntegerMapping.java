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

public class BigIntegerMapping implements TypeMapping<Integer> {

  @Override
  public final String getFieldType() {
    return "BigInteger";
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
  public final Integer getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    final int randomDefaultValue;

    if (Objects.nonNull(fieldValidations) && ObjectUtils.anyNotNull(fieldValidations.getMin(), fieldValidations.getMax())) {
      final int minValue = ObjectUtils.defaultIfNull(fieldValidations.getMin(), Integer.MIN_VALUE);
      final int maxValue = ObjectUtils.defaultIfNull(fieldValidations.getMax(), Integer.MAX_VALUE);

      randomDefaultValue = uniformRandomProvider.nextInt(minValue, maxValue);
    } else {
      randomDefaultValue = uniformRandomProvider.nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    return randomDefaultValue;
  }
}
