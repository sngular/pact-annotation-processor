/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

public class BigIntegerArrayMapping implements TypeMapping<String> {

  @Override
  public final String getFieldType() {
    return "BigInteger[]";
  }

  @Override
  public final String getFunctionType() {
    return "bigIntegerArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "bigIntegerArrayValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "12345678901234567890123456789012345678901234567890123456789012345678901234567890";
  }
}
