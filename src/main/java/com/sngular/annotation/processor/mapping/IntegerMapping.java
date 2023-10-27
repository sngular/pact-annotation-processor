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

public class IntegerMapping implements TypeMapping<Integer> {

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
      return RandomUtils.nextInt(ObjectUtils.defaultIfNull(fieldValidations.getMin(), Integer.MIN_VALUE),
                                 ObjectUtils.defaultIfNull(fieldValidations.getMax(), Integer.MAX_VALUE));
    }
    return RandomUtils.nextInt(0, Integer.MAX_VALUE);
  }
}
