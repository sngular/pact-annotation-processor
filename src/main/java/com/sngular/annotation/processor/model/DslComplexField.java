package com.sngular.annotation.processor.model;

import java.util.List;

import lombok.EqualsAndHashCode;
import lombok.NonNull;
import lombok.Value;
import lombok.experimental.SuperBuilder;

@Value
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class DslComplexField extends DslField {

  @NonNull DslComplexTypeEnum complexType;

  List<DslField> fields;

  String fieldType;

  FieldValidations fieldValidations;

}
