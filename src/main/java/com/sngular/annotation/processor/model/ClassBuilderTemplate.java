package com.sngular.annotation.processor.model;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClassBuilderTemplate {

  String modelPackage;

  String fileName;

  String className;

  List<DslField> fieldList;

  List<String> customModifiers;

  public String completePath() {
    return String.format("%s.%s", modelPackage, fileName);
  }
}

