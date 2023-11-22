package com.sngular.resources.basic;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;

@PactDslBodyBuilder
public class CharacterDataTypes {

  @Example("nameExample")
  private String name;

  //  @Example("a")
  //  private char charField;
  //
  //  @Example("charArray")
  //  private char[] charArrayField;

  protected String getName() {
    return name;
  }

  protected void setName(final String name) {
    this.name = name;
  }
}