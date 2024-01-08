/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.rng.UniformRandomProvider;

public class CharMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "char";
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
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return RandomStringUtils.randomAlphanumeric(1);
  }
}
