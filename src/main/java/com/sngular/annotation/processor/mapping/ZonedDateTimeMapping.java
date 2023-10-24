/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.mapping;

import java.time.ZonedDateTime;

import com.sngular.annotation.processor.model.FieldValidations;

public class ZonedDateTimeMapping implements TypeMapping<ZonedDateTime> {

  @Override
  public final String getFieldType() {
    return "java.time.ZonedDateTime";
  }

  @Override
  public final String getFunctionType() {
    return "datetime";
  }

  @Override
  public final String getFunctionOnlyValue() {
    return "datetimeValue";
  }

  @Override
  public final ZonedDateTime getRandomDefaultValue(final FieldValidations fieldValidations) {
    return ZonedDateTime.now();
  }

  @Override
  public final String getFormatValue() {
    return "yyyy-MM-dd'T'HH:mm:ss[.SSSSSS][.SSS]XXX['['VV']']";
  }
}
