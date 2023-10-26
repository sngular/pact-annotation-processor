/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.mapping;

import com.sngular.annotation.processor.model.FieldValidations;

public interface TypeMapping<T> {

  String getFieldType();

  String getFunctionType();

  String getFunctionOnlyValue();

  T getRandomDefaultValue(final FieldValidations fieldValidations);

  default String getSuffixValue() {
    return null;
  }

  default String getFormatValue() {
    return null;
  }
}
