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

public class ByteMapping implements TypeMapping<Integer> {

  @Override
  public final String getFieldType() {
    return "byte";
  }

  @Override
  public final String getFunctionType() {
    return "byteType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "byteValue";
  }

  @Override
  public final Integer getRandomDefaultValue(final FieldValidations fieldValidations) {
    if (Objects.nonNull(fieldValidations) && ObjectUtils.anyNotNull(fieldValidations.getMin(), fieldValidations.getMax())) {
      return RandomUtils.nextInt(ObjectUtils.defaultIfNull(fieldValidations.getMin(), (int) Byte.MIN_VALUE),
                                 ObjectUtils.defaultIfNull(fieldValidations.getMax(), (int) Byte.MAX_VALUE));
    }
    return RandomUtils.nextInt(0, Integer.MAX_VALUE);
  }
}
