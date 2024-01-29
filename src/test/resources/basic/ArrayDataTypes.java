package com.sngular.resources.basic;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;
import com.sngular.annotation.pact.DslExclude;

@PactDslBodyBuilder
public class ArrayDataTypes {

  @Example("stringArrayExample")
  private String[] stringArray;

  @DslExclude
  private String[] stringArrayExclude;

  private String[] stringArrayDefault;

  public String[] getStringArray() {
    return stringArray;
  }

  public void setStringArray(String[] stringArray) {
    this.stringArray = stringArray;
  }

  public String[] getStringArrayExclude() {
    return stringArrayExclude;
  }

  public void setStringArrayExclude(String[] stringArrayExclude) {
    this.stringArrayExclude = stringArrayExclude;
  }

  public String[] getStringArrayDefault() {
    return stringArrayDefault;
  }

  public void setStringArrayDefault(String[] stringArrayDefault) {
    this.stringArrayDefault = stringArrayDefault;
  }
}