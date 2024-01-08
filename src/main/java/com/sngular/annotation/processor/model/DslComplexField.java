/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.model;

import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@EqualsAndHashCode(callSuper = true)
public class DslComplexField extends DslField {

  @NonNull DslComplexTypeEnum complexType;

  List<DslField> fields;

  String fieldType;

  FieldValidations fieldValidations;

  boolean needBuilder;

  boolean empty;

  @Builder
  private DslComplexField(
      final String name, @NonNull final DslComplexTypeEnum complexType, final List<DslField> fields, final String fieldType, final FieldValidations fieldValidations,
      final boolean needBuilder, final boolean empty) {
    super(name);
    this.complexType = complexType;
    this.fields = fields;
    this.fieldType = fieldType;
    this.fieldValidations = fieldValidations;
    this.needBuilder = needBuilder;
    this.empty = empty;
  }

  public static class DslComplexFieldBuilder {}
}
