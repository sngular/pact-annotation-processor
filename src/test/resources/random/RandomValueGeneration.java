package com.sngular.annotation.examples;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.ZonedDateTime;
import java.util.Date;

@PactDslBodyBuilder
public class RandomValueGeneration {

  public Integer integer;

  public int primitiveInt;

  public Long longObject;

  public long primitiveLong;

  public Float floatObject;

  public float primitiveFloat;

  public Double doubleObject;

  public double primitiveDouble;

  public Short shortObject;

  public short primitiveShort;

  public Byte byteObject;

  public byte primitiveByte;

  public BigInteger bigIntegerObject;

  public BigDecimal bigDecimalObject;

  public String[] stringArray;

  public boolean[] booleanArray;

  public Boolean[] booleanArrayWrap;

  public byte[] byteArray;

  public Byte[] byteArrayWrap;

  public short[] shortArray;

  public Short[] shortArrayWrap;

  public int[] intArray;

  public Integer[] intArrayWrap;

  public char[] charArray;

  public Character[] charArrayWrap;

  long[] longArray;

  Long[] longArrayWrap;

  float[] floatArray;

  Float[] floatArrayWrap;

  double[] doubleArray;

  Double[] doubleArrayWrap;

  BigInteger[] bigIntegerArray;

  BigDecimal[] bigDecimalArray;

  ZonedDateTime[] zonedDateTimeArray;

  Date[] dateArray;

  public Integer getInteger() {
    return integer;
  }

  public void setInteger(final Integer integer) {
    this.integer = integer;
  }

  public int getPrimitiveInt() {
    return primitiveInt;
  }

  public void setPrimitiveInt(final int primitiveInt) {
    this.primitiveInt = primitiveInt;
  }

  public Long getLongObject() {
    return longObject;
  }

  public void setLongObject(final Long longObject) {
    this.longObject = longObject;
  }

  public long getPrimitiveLong() {
    return primitiveLong;
  }

  public void setPrimitiveLong(final long primitiveLong) {
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

  public String[] getStringArray() {
    return stringArray;
  }

  public void setStringArray(String[] stringArray) {
    this.stringArray = stringArray;
  }

  public boolean[] getBooleanArray() {
    return booleanArray;
  }

  public void setBooleanArray(boolean[] booleanArray) {
    this.booleanArray = booleanArray;
  }

  public Boolean[] getBooleanArrayWrap() {
    return booleanArrayWrap;
  }

  public void setBooleanArrayWrap(Boolean[] booleanArrayWrap) {
    this.booleanArrayWrap = booleanArrayWrap;
  }

  public byte[] getByteArray() {
    return byteArray;
  }

  public void setByteArray(byte[] byteArray) {
    this.byteArray = byteArray;
  }

  public Byte[] getByteArrayWrap() {
    return byteArrayWrap;
  }

  public void setByteArrayWrap(Byte[] byteArrayWrap) {
    this.byteArrayWrap = byteArrayWrap;
  }

  public short[] getShortArray() {
    return shortArray;
  }

  public void setShortArray(short[] shortArray) {
    this.shortArray = shortArray;
  }

  public Short[] getShortArrayWrap() {
    return shortArrayWrap;
  }

  public void setShortArrayWrap(Short[] shortArrayWrap) {
    this.shortArrayWrap = shortArrayWrap;
  }

  public int[] getIntArray() {
    return intArray;
  }

  public void setIntArray(int[] intArray) {
    this.intArray = intArray;
  }

  public Integer[] getIntArrayWrap() {
    return intArrayWrap;
  }

  public void setIntArrayWrap(Integer[] intArrayWrap) {
    this.intArrayWrap = intArrayWrap;
  }

  public char[] getCharArray() {
    return charArray;
  }

  public void setCharArray(char[] charArray) {
    this.charArray = charArray;
  }

  public Character[] getCharArrayWrap() {
    return charArrayWrap;
  }

  public void setCharArrayWrap(Character[] charArrayWrap) {
    this.charArrayWrap = charArrayWrap;
  }

  public long[] getLongArray() {
    return longArray;
  }

  public void setLongArray(long[] longArray) {
    this.longArray = longArray;
  }

  public Long[] getLongArrayWrap() {
    return longArrayWrap;
  }

  public void setLongArrayWrap(Long[] longArrayWrap) {
    this.longArrayWrap = longArrayWrap;
  }

  public float[] getFloatArray() {
    return floatArray;
  }

  public void setFloatArray(float[] floatArray) {
    this.floatArray = floatArray;
  }

  public Float[] getFloatArrayWrap() {
    return floatArrayWrap;
  }

  public void setFloatArrayWrap(Float[] floatArrayWrap) {
    this.floatArrayWrap = floatArrayWrap;
  }

  public double[] getDoubleArray() {
    return doubleArray;
  }

  public void setDoubleArray(double[] doubleArray) {
    this.doubleArray = doubleArray;
  }

  public Double[] getDoubleArrayWrap() {
    return doubleArrayWrap;
  }

  public void setDoubleArrayWrap(Double[] doubleArrayWrap) {
    this.doubleArrayWrap = doubleArrayWrap;
  }

  public BigInteger[] getBigIntegerArray() {
    return bigIntegerArray;
  }

  public void setBigIntegerArray(BigInteger[] bigIntegerArray) {
    this.bigIntegerArray = bigIntegerArray;
  }

  public BigDecimal[] getBigDecimalArray() {
    return bigDecimalArray;
  }

  public void setBigDecimalArray(BigDecimal[] bigDecimalArray) {
    this.bigDecimalArray = bigDecimalArray;
  }

  public ZonedDateTime[] getZonedDateTimeArray() {
    return zonedDateTimeArray;
  }

  public void setZonedDateTimeArray(ZonedDateTime[] zonedDateTimeArray) {
    this.zonedDateTimeArray = zonedDateTimeArray;
  }

  public Date[] getDateArray() {
    return dateArray;
  }

  public void setDateArray(Date[] dateArray) {
    this.dateArray = dateArray;
  }
}