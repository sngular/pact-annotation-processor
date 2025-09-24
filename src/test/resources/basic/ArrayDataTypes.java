package com.sngular.resources.basic;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;
import com.sngular.annotation.pact.DslExclude;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.Date;

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

  @Example(array = {"-9223372036854775807l",
          "9223372036854775807L",
          "-0l",
          "0L",
          "-3.402823e38",
          "0.0",
          "al"} )
  private long[] longArray;

  @Example(array = {"-9223372036854775807l",
                    "9223372036854775807L",
                    "-0l",
                    "0L",
                    "-3.402823e38",
                    "-0.0",
                    "aL"} )
  private Long[] longArrayWrap;

  @Example(array = {"-82233720368547758080000001f",
                    "100.0F",
                    "-123456789012345678901234567890123456789f",
                    "123456789012345678901234567890123456789F",
                    "-3.402823e38",
                    "0.0",
                    "af"} )
  private float[] floatArray;

  @Example(array = {"-1234567890123456789012345678901234567890.79769313486232d",
                    "1000.0D",
                    "-123456789012345678901234567890123456789d",
                    "123456789012345678901234567890123456789D",
                    "-3.402823e300d",
                    "-0.0",
                    "aF"} )
  private Float[] floatArrayWrap;

  @Example(array = {"-1234567890123456789012345678901234567890.79769313486232d",
                  "1000.0D",
                  "1234567890123456789012345678901234567890123456789012345678901234567890D",
                  "-2.12345678901234d",
                  "3.402823e307D",
                  "0.0",
                  "ad"} )
  private double[] doubleArray;

  @Example(array = {"-1234567890123456789012345678901234567890.79769313486232d",
                  "1000.0D",
                  "1234567890123456789012345678901234567890123456789012345678901234567890D",
                  "-2.12345678901234d",
                  "3.402823e307D",
                  "-0.0",
                  "aD"} )
  private Double[] doubleArrayWrap;

  @Example(array = {"-8223372036854775808000000182233720368547758000182233720368547758080000001",
          "9542233720368547758080000001822334563456435643720367867865758000182233720352345368547758080000001",
          "100.0",
          "0",
          "-0",
          "abc"})
  private BigInteger[] bigIntegerArray;

  @Example(array = {"-8223372036854775808000000182233720368547758000182233720368547758080000001.8000182233720368547758080000001",
          "954223372036854775808000000135643720367867865758000182233720352345368547758080000001.58000182233720352345368547758080000001",
          "100.0",
          "0",
          "-0",
          "abc"})
  private BigDecimal[] bigDecimalArray;

  @Example(array = {"28/02/2024 00:00",
                    "28/02/2024 23:59",
                    "30/02/2024 00:00",
                    "28/03/2024 25:00",
                    "28/04/2024 23:70",
                    "00/00/0000 00:00",
                    "12345",
                    "100.100",
                    "abc"}, format = "dd/MM/yyyy HH:mm")
  private ZonedDateTime[] zonedDateTimeArray;

  @Example(array = {"2024-02-28 00:00",
                    "2024-02-28 23:59",
                    "2024-02-30 00:00",
                    "2024-03-28 25:00",
                    "2024-04-28 23:70",
                    "0000-00-00 00:00",
                    "12345",
                    "100.100",
                    "abc"}, format = "yyyy-MM-dd HH:mm")
  private ZonedDateTime[] zonedDateTimeArray2;

  @Example(array = {"28/02/2024",
                    "28/02/2024",
                    "30/02/2024",
                    "28/03/2024",
                    "28/04/2024",
                    "00/00/0000",
                    "12345",
                    "100.100",
                    "abc"}, format = "dd/MM/yyyy")
  private Date[] dateArray;

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

  public ZonedDateTime[] getZonedDateTimeArray2() {
    return zonedDateTimeArray2;
  }

  public void setZonedDateTimeArray2(ZonedDateTime[] zonedDateTimeArray2) {
    this.zonedDateTimeArray2 = zonedDateTimeArray2;
  }

  public Date[] getDateArray() {
    return dateArray;
  }

  public void setDateArray(Date[] dateArray) {
    dateArray = dateArray;
  }
}