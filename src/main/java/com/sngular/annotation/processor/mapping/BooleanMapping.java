/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;
import org.apache.commons.rng.simple.RandomSource;

public class BooleanMapping implements TypeMapping<Boolean> {

  UniformRandomProvider uniformRandomProvider = RandomSource.XO_RO_SHI_RO_128_PP.create();

  @Override
  public final String getFieldType() {
    return "boolean";
  }

  @Override
  public final String getFunctionType() {
    return "booleanType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "booleanValue";
  }

  @Override
  public final Boolean getRandomDefaultValue(final FieldValidations fieldValidations) {
    return uniformRandomProvider.nextBoolean();
  }
}
