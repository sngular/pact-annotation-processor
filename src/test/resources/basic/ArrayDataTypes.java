package com.sngular.resources.basic;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;
import com.sngular.annotation.pact.DslExclude;

import java.util.Optional;

@PactDslBodyBuilder
public class ArrayDataTypes {

  @Example(array = {"abc","bef","ghi"} )
  private String[] stringArray;

  @DslExclude
  private String[] stringArrayExclude;

  @Example(array = {"true","false"})
  private boolean[] booleanArray;

  @Example(array = {"false","true"})
  private Boolean[] booleanArrayWrap;

  @Example(array = {"1","2","3","4","5"})
  private byte[] byteArray;

  @Example(array = {"6","7","8","9","10"})
  private Byte[] byteArrayWrap;

  @Example(array = {"11","12","13","14","15"} )
  private short[] shortArray;

  @Example(array = {"16","17","18","19","20"} )
  private Short[] shortArrayWrap;

  @Example(array = {"-2147483648"} )
  private int[] intArray;

  @Example(array = {"2147483647"} )
  private Integer[] intArrayWrap;

  @Example(array = {"j","k","l"} )
  private char[] charArray;

  @Example(array = {"m","n","o"} )
  private Character[] charArrayWrap;

  @Example(array = {"-123456789012345678901234567890.402823L"} )
  private long[] longArray;

  @Example(array = {"-1234567890123456789012345678901234567890.79769313486232D"} )
  private double[] doubleArray;

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

  public double[] getDoubleArray() {
    return doubleArray;
  }

  public void setDoubleArray(double[] doubleArray) {
    this.doubleArray = doubleArray;
  }

}