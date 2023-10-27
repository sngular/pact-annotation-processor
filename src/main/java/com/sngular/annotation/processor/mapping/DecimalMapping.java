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
  public final Number getRandomDefaultValue(final FieldValidations fieldValidations) {
    if (Objects.nonNull(fieldValidations) && ObjectUtils.anyNotNull(fieldValidations.getMin(), fieldValidations.getMax())) {
      return RandomUtils.nextDouble(ObjectUtils.defaultIfNull((double) fieldValidations.getMin(), Double.MIN_VALUE),
                                    ObjectUtils.defaultIfNull((double) fieldValidations.getMax(), Double.MAX_VALUE));
    }
    return RandomUtils.nextDouble(0, Double.MAX_VALUE);
  }
}
