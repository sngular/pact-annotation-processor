package com.sngular.resources.basic;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;

@PactDslBodyBuilder
public class NumericDataTypes {

  @Example("10")
  private Integer integer;

  @Example("20")
  private int primitiveInt;

  @Example("30")
  private Long longObject;

  @Example("40")
  private long primitiveLong;

  //  @Example("50")
  //  private Float floatObject;
  //
  //  @Example("60")
  //  private float primitiveFloat;
  //
  //  @Example("70")
  //  private BigInteger bigInteger;
  //
  //  @Example("80")
  //  private BigDecimal bigDecimal;
}