package com.sngular.resources.basic;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;
import com.sngular.annotation.pact.DslExclude;

@PactDslBodyBuilder
public class ArrayDataTypes {

  @Example(array = {"abc","bef","ghi"} )
  private String[] stringArray;

  @DslExclude
  private String[] stringArrayExclude;

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
}