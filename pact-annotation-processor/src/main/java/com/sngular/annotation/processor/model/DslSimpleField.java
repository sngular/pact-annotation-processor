package com.sngular.annotation.processor.model;

import lombok.EqualsAndHashCode;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DslSimpleField extends DslField {

  String fieldType;

  String functionByType;

  Object defaultValue;

  String suffixValue;

  String formatValue;

  FieldValidations fieldValidations;

  boolean onlyValueFunction;
}


