package com.sngular.annotation.examples;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;

@PactDslBodyBuilder
public class Student {

  @Example("exampleName")
  private String name;

  private int age;

}