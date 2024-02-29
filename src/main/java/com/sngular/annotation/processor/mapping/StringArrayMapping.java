/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.rng.UniformRandomProvider;

import java.util.Objects;


/** Represents an array of String.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public class StringArrayMapping implements TypeMapping<String> {

  public static final int DEFAULT_MAX = 15;

  public static final int DEFAULT_MIN = 1;

  @Override
  public final String getFieldType() {
    return "String[]";
  }

  @Override
  public final String getFunctionType() {
    return "stringArrayType";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "stringArrayValue";
  }

  @Override
  public final String getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return "\"defaultValue\"";
  }
}
