package com.sngular.resources.basic;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;

@PactDslBodyBuilder
public class CharacterDataTypes {

  @Example("nameExample")
  private String name;

  @Example("a")
  private char primitiveChar;

  @Example("b")
  private Character charObject;

  @Example("true")
  private boolean primitiveBoolean;

  @Example("false")
  private Boolean booleanObject;

  protected String getName() {
    return name;
  }

  protected void setName(final String name) {
    this.name = name;
  }

  public char getPrimitiveChar() {
    return primitiveChar;
  }

  public void setPrimitiveChar(char primitiveChar) {
    this.primitiveChar = primitiveChar;
  }

  public Character getCharObject() {
    return charObject;
  }

  public void setCharObject(Character charObject) {
    this.charObject = charObject;
  }

  public boolean isPrimitiveBoolean() {
    return primitiveBoolean;
  }

  public void setPrimitiveBoolean(boolean primitiveBoolean) {
    this.primitiveBoolean = primitiveBoolean;
  }

  public Boolean getBooleanObject() {
    return booleanObject;
  }

  public void setBooleanObject(Boolean booleanObject) {
    this.booleanObject = booleanObject;
  }
}