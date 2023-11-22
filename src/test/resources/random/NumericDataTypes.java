package com.sngular.annotation.examples;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;

@PactDslBodyBuilder
public class NumericDataTypes {

  private int age;

  protected int getAge() {
    return age;
  }

  protected void setAge(final int age) {
    this.age = age;
  }
}