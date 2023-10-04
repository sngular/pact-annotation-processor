package com.sngular.annotation.processor.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FieldValidations {

  int min;

  int max;

  String regex;

}
