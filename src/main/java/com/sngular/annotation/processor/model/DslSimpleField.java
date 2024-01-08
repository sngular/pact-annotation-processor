/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@Builder
@EqualsAndHashCode(callSuper = true)
public class DslSimpleField extends DslField {

  String fieldType;

  String functionByType;

  Object defaultValue;

  String suffixValue;

  String formatValue;

  FieldValidations fieldValidations;

  boolean onlyValueFunction;

  boolean empty;

  public static class DslSimpleFieldBuilder {}
}


