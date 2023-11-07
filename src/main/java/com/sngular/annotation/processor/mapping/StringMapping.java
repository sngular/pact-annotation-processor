/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.mapping;

import java.util.Objects;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

public class StringMapping implements TypeMapping<String> {

  private final UniformRandomProvider uniformRandomProvider = RandomSource.XO_RO_SHI_RO_128_PP.create();

  public static final int DEFAULT_MAX = 15;

  public static final int DEFAULT_MIN = 1;

  @Override
  public final String getFieldType() {
    return "java.lang.String";
  }

  @Override
  public final String getFunctionType() {
    return "stringType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "stringValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations) {
    final int length;

    if (Objects.nonNull(fieldValidations) && ObjectUtils.anyNotNull(fieldValidations.getMin(), fieldValidations.getMax())) {
      final int minLength = ObjectUtils.defaultIfNull(fieldValidations.getMin(), DEFAULT_MIN);
      final int maxLength = ObjectUtils.defaultIfNull(fieldValidations.getMax(), DEFAULT_MAX);

      length = uniformRandomProvider.nextInt(minLength, maxLength);
    } else {
      length = uniformRandomProvider.nextInt(DEFAULT_MIN, DEFAULT_MAX);
    }

    return RandomStringUtils.randomAlphanumeric(length);
  }
}
