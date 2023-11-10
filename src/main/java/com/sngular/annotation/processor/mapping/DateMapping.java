/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.mapping;

import java.time.Instant;
import java.util.Date;

import com.sngular.annotation.processor.model.FieldValidations;
import org.apache.commons.rng.UniformRandomProvider;

public class DateMapping implements TypeMapping<Date> {

  @Override
  public final String getFieldType() {
    return "Date";
  }

  @Override
  public final String getFunctionType() {
    return "date";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "dateValue";
  }

  @Override
  public final Date getRandomDefaultValue(final FieldValidations fieldValidations, final UniformRandomProvider uniformRandomProvider) {
    return Date.from(Instant.now());
  }

  @Override
  public final String getFormatValue() {
    return "yyyy-MM-dd['['ZZZ']']";
  }
}
