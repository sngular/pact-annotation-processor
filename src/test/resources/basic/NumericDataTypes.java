package com.sngular.resources.basic;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;

import java.math.BigInteger;
import java.math.BigDecimal;

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

  @Example("50.1234")
  private Float floatObject;

  @Example("60.2345")
  private float primitiveFloat;

  @Example("70.3456")
  private Double doubleObject;

  @Example("80.4567")
  private double primitiveDouble;

  @Example("90")
  private Short shortObject;

  @Example("100")
  private short primitiveShort;

  @Example("110")
  private Byte byteObject;

  @Example("120")
  private byte primitiveByte;

  @Example("1303812548123548216")
  private BigInteger bigIntegerObject;

  @Example("1402354872534672834.2345")
  private BigDecimal bigDecimalObject;

  protected Integer getInteger() {
    return integer;
  }

  protected void setInteger(final Integer integer) {
    this.integer = integer;
  }

  protected int getPrimitiveInt() {
    return primitiveInt;
  }

  protected void setPrimitiveInt(final int primitiveInt) {
    this.primitiveInt = primitiveInt;
  }

  protected Long getLongObject() {
    return longObject;
  }

  protected void setLongObject(final Long longObject) {
    this.longObject = longObject;
  }

  protected long getPrimitiveLong() {
    return primitiveLong;
  }

  protected void setPrimitiveLong(final long primitiveLong) {
    this.primitiveLong = primitiveLong;
  }

  public Float getFloatObject() {
    return floatObject;
  }

  public void setFloatObject(Float floatObject) {
    this.floatObject = floatObject;
  }

  public float getPrimitiveFloat() {
    return primitiveFloat;
  }

  public void setPrimitiveFloat(float primitiveFloat) {
    this.primitiveFloat = primitiveFloat;
  }

  public Double getDoubleObject() {
    return doubleObject;
  }

  public void setDoubleObject(Double doubleObject) {
    this.doubleObject = doubleObject;
  }

  public double getPrimitiveDouble() {
    return primitiveDouble;
  }

  public void setPrimitiveDouble(double primitiveDouble) {
    this.primitiveDouble = primitiveDouble;
  }

  public Short getShortObject() {
    return shortObject;
  }

  public void setShortObject(Short shortObject) {
    this.shortObject = shortObject;
  }

  public short getPrimitiveShort() {
    return primitiveShort;
  }

  public void setPrimitiveShort(short primitiveShort) {
    this.primitiveShort = primitiveShort;
  }

  public Byte getByteObject() {
    return byteObject;
  }

  public void setByteObject(Byte byteObject) {
    this.byteObject = byteObject;
  }

  public byte getPrimitiveByte() {
    return primitiveByte;
  }

  public void setPrimitiveByte(byte primitiveByte) {
    this.primitiveByte = primitiveByte;
  }

  public BigInteger getBigIntegerObject() {
    return bigIntegerObject;
  }

  public void setBigIntegerObject(BigInteger bigIntegerObject) {
    this.bigIntegerObject = bigIntegerObject;
  }

  public BigDecimal getBigDecimalObject() {
    return bigDecimalObject;
  }

  public void setBigDecimalObject(BigDecimal bigDecimalObject) {
    this.bigDecimalObject = bigDecimalObject;
  }
}