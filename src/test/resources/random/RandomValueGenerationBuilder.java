package com.sngular.annotation.examples;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslJsonRootValue;
import com.sngular.annotation.processor.mapping.CustomDslModifier;
import com.sngular.annotation.examples.RandomValueGeneration;
import java.util.Arrays;

public class RandomValueGenerationBuilder {

  int integer = 0;

  int primitiveInt = 0;

  long longObject = 0L;

  long primitiveLong = 0L;

  float floatObject = 0.0F;

  float primitiveFloat = 0.0F;

  double doubleObject = 0.0D;

  double primitiveDouble = 0.0D;

  short shortObject = 0;

  short primitiveShort = 0;

  byte byteObject = 0;

  byte primitiveByte = 0;

  BigInteger bigIntegerObject = new BigInteger("0");

  BigDecimal bigDecimalObject = new BigDecimal("0");

  String[] stringArray = {"defaultValue"};
  String stringArrayName = "stringArray";

  boolean[] booleanArray = {true};
  String booleanArrayName = "booleanArray";

  Boolean[] booleanArrayWrap = {false};
  String booleanArrayWrapName = "booleanArrayWrap";

  byte[] byteArray = {-128};
  String byteArrayName = "byteArray";

  Byte[] byteArrayWrap = {127};
  String byteArrayWrapName = "byteArrayWrap";

  short[] shortArray = {-32768};
  String shortArrayName = "shortArray";

  Short[] shortArrayWrap = {32767};
  String shortArrayWrapName = "shortArrayWrap";

  int[] intArray = {-2147483648};
  String intArrayName = "intArray";

  Integer[] intArrayWrap = {2147483647};
  String intArrayWrapName = "intArrayWrap";

  char[] charArray = {'x'};
  String charArrayName = "charArray";

  Character[] charArrayWrap = {'X'};
  String charArrayWrapName = "charArrayWrap";

  String[] inLongArray = {"-9223372036854775808l"};
  long[] longArray = getLongArray(inLongArray);
  String longArrayName = "longArray";

  String[] inLongArrayWrap = {"9223372036854775807L"};
  Long[] longArrayWrap = getLongArrayWrap(inLongArrayWrap);
  String longArrayWrapName = "longArrayWrap";

  String[] inFloatArray = {"-123456789012345678901234567890.402823f"};
  float[] floatArray = getFloatArray(inFloatArray);
  String floatArrayName = "floatArray";

  String[] inFloatArrayWrap = {"123456789012345678901234567890.402823F"};
  Float[] floatArrayWrap = getFloatArrayWrap(inFloatArrayWrap);
  String floatArrayWrapName = "floatArrayWrap";

  String[] inDoubleArray = {"-1234567890123456789012345678901234567890.79769313486232d"};
  double[] doubleArray = getDoubleArray(inDoubleArray);
  String doubleArrayName = "doubleArray";

  String[] inDoubleArrayWrap = {"1234567890123456789012345678901234567890.79769313486232D"};
  Double[] doubleArrayWrap = getDoubleArrayWrap(inDoubleArrayWrap);
  String doubleArrayWrapName = "doubleArrayWrap";

  public RandomValueGenerationBuilder setInteger(final int integer) {
    this.integer = integer;
    return this;
  }

  public RandomValueGenerationBuilder setPrimitiveInt(final int primitiveInt) {
    this.primitiveInt = primitiveInt;
    return this;
  }

  public RandomValueGenerationBuilder setLongObject(final long longObject) {
    this.longObject = longObject;
    return this;
  }

  public RandomValueGenerationBuilder setPrimitiveLong(final long primitiveLong) {
    this.primitiveLong = primitiveLong;
    return this;
  }

  public RandomValueGenerationBuilder setFloatObject(final float floatObject) {
    this.floatObject = floatObject;
    return this;
  }

  public RandomValueGenerationBuilder setPrimitiveFloat(final float primitiveFloat) {
    this.primitiveFloat = primitiveFloat;
    return this;
  }

  public RandomValueGenerationBuilder setDoubleObject(final double doubleObject) {
    this.doubleObject = doubleObject;
    return this;
  }

  public RandomValueGenerationBuilder setPrimitiveDouble(final double primitiveDouble) {
    this.primitiveDouble = primitiveDouble;
    return this;
  }

  public RandomValueGenerationBuilder setShortObject(final short shortObject) {
    this.shortObject = shortObject;
    return this;
  }

  public RandomValueGenerationBuilder setPrimitiveShort(final short primitiveShort) {
    this.primitiveShort = primitiveShort;
    return this;
  }

  public RandomValueGenerationBuilder setByteObject(final byte byteObject) {
    this.byteObject = byteObject;
    return this;
  }

  public RandomValueGenerationBuilder setPrimitiveByte(final byte primitiveByte) {
    this.primitiveByte = primitiveByte;
    return this;
  }

  public RandomValueGenerationBuilder setBigIntegerObject(final BigInteger bigIntegerObject) {
    this.bigIntegerObject = bigIntegerObject;
    return this;
  }

  public RandomValueGenerationBuilder setBigDecimalObject(final BigDecimal bigDecimalObject) {
    this.bigDecimalObject = bigDecimalObject;
    return this;
  }

  public RandomValueGenerationBuilder setStringArray(final String[] stringArray) {
    this.stringArray = stringArray;
    return this;
  }

  public RandomValueGenerationBuilder setBooleanArray(final boolean[] booleanArray) {
    this.booleanArray = booleanArray;
    return this;
  }

  public RandomValueGenerationBuilder setBooleanArrayWrap(final Boolean[] booleanArrayWrap) {
    this.booleanArrayWrap = booleanArrayWrap;
    return this;
  }

  public RandomValueGenerationBuilder setByteArray(final byte[] byteArray) {
    this.byteArray = byteArray;
    return this;
  }

  public RandomValueGenerationBuilder setByteArrayWrap(final Byte[] byteArrayWrap) {
    this.byteArrayWrap = byteArrayWrap;
    return this;
  }

  public RandomValueGenerationBuilder setShortArray(final short[] shortArray) {
    this.shortArray = shortArray;
    return this;
  }

  public RandomValueGenerationBuilder setShortArrayWrap(final Short[] shortArrayWrap) {
    this.shortArrayWrap = shortArrayWrap;
    return this;
  }

  public RandomValueGenerationBuilder setIntArray(final int[] intArray) {
    this.intArray = intArray;
    return this;
  }

  public RandomValueGenerationBuilder setIntArrayWrap(final Integer[] intArrayWrap) {
    this.intArrayWrap = intArrayWrap;
    return this;
  }

  public RandomValueGenerationBuilder setCharArray(final char[] charArray) {
    this.charArray = charArray;
    return this;
  }

  public RandomValueGenerationBuilder setCharArrayWrap(final Character[] charArrayWrap) {
    this.charArrayWrap = charArrayWrap;
    return this;
  }

  public RandomValueGenerationBuilder setLongArray(final long[] longArray) {
    this.longArray = longArray;
    return this;
  }

  public RandomValueGenerationBuilder setLongArrayWrap(final Long[] longArrayWrap) {
    this.longArrayWrap = longArrayWrap;
    return this;
  }

  public RandomValueGenerationBuilder setFloatArray(final float[] floatArray) {
    this.floatArray = floatArray;
    return this;
  }

  public RandomValueGenerationBuilder setFloatArrayWrap(final Float[] floatArrayWrap) {
    this.floatArrayWrap = floatArrayWrap;
    return this;
  }

  public RandomValueGenerationBuilder setDoubleArray(final double[] doubleArray) {
    this.doubleArray = doubleArray;
    return this;
  }

  public RandomValueGenerationBuilder setDoubleArrayWrap(final Double[] doubleArrayWrap) {
    this.doubleArrayWrap = doubleArrayWrap;
    return this;
  }

  public DslPart build() {
    PactDslJsonBody pactDslJsonBody = new PactDslJsonBody();

    if (Objects.nonNull(integer)) {
      pactDslJsonBody.integerType("integer", integer);
    }

    if (Objects.nonNull(primitiveInt)) {
      pactDslJsonBody.integerType("primitiveInt", primitiveInt);
    }

    if (Objects.nonNull(longObject)) {
      pactDslJsonBody.integerType("longObject", longObject);
    }

    if (Objects.nonNull(primitiveLong)) {
      pactDslJsonBody.integerType("primitiveLong", primitiveLong);
    }

    if (Objects.nonNull(floatObject)) {
      pactDslJsonBody.decimalType("floatObject", (double) floatObject);
    }

    if (Objects.nonNull(primitiveFloat)) {
      pactDslJsonBody.decimalType("primitiveFloat", (double) primitiveFloat);
    }

    if (Objects.nonNull(doubleObject)) {
      pactDslJsonBody.decimalType("doubleObject", doubleObject);
    }

    if (Objects.nonNull(primitiveDouble)) {
      pactDslJsonBody.decimalType("primitiveDouble", primitiveDouble);
    }

    if (Objects.nonNull(shortObject)) {
      pactDslJsonBody.integerType("shortObject", (int) shortObject);
    }

    if (Objects.nonNull(primitiveShort)) {
      pactDslJsonBody.integerType("primitiveShort", (int) primitiveShort);
    }

    if (Objects.nonNull(byteObject)) {
      pactDslJsonBody.integerType("byteObject", (int) byteObject);
    }

    if (Objects.nonNull(primitiveByte)) {
      pactDslJsonBody.integerType("primitiveByte", (int) primitiveByte);
    }

    if (Objects.nonNull(bigIntegerObject)) {
      pactDslJsonBody.integerType("bigIntegerObject", bigIntegerObject.intValue());
    }

    if (Objects.nonNull(bigDecimalObject)) {
      pactDslJsonBody.decimalType("bigDecimalObject", bigDecimalObject);
    }

    if (Objects.nonNull(stringArray)) {
      pactDslJsonBody.array(stringArrayName).stringValue(Arrays.toString(stringArray)).closeArray();
    }

    if (Objects.nonNull(booleanArray)) {
      pactDslJsonBody.array(booleanArrayName).stringValue(Arrays.toString(booleanArray)).closeArray();
    }

    if (Objects.nonNull(booleanArrayWrap)) {
      pactDslJsonBody.array(booleanArrayWrapName).stringValue(Arrays.toString(booleanArrayWrap)).closeArray();
    }

    if (Objects.nonNull(byteArray)) {
      pactDslJsonBody.array(byteArrayName).stringValue(Arrays.toString(byteArray)).closeArray();
    }

    if (Objects.nonNull(byteArrayWrap)) {
      pactDslJsonBody.array(byteArrayWrapName).stringValue(Arrays.toString(byteArrayWrap)).closeArray();
    }

    if (Objects.nonNull(shortArray)) {
      pactDslJsonBody.array(shortArrayName).stringValue(Arrays.toString(shortArray)).closeArray();
    }

    if (Objects.nonNull(shortArrayWrap)) {
      pactDslJsonBody.array(shortArrayWrapName).stringValue(Arrays.toString(shortArrayWrap)).closeArray();
    }

    if (Objects.nonNull(intArray)) {
      pactDslJsonBody.array(intArrayName).stringValue(Arrays.toString(intArray)).closeArray();
    }

    if (Objects.nonNull(intArrayWrap)) {
      pactDslJsonBody.array(intArrayWrapName).stringValue(Arrays.toString(intArrayWrap)).closeArray();
    }

    if (Objects.nonNull(charArray)) {
      pactDslJsonBody.array(charArrayName).stringValue(Arrays.toString(charArray)).closeArray();
    }

    if (Objects.nonNull(charArrayWrap)) {
      pactDslJsonBody.array(charArrayWrapName).stringValue(Arrays.toString(charArrayWrap)).closeArray();
    }

    if (Objects.nonNull(longArray)) {
      pactDslJsonBody.array(longArrayName).stringValue(Arrays.toString(longArray)).closeArray();
    }

    if (Objects.nonNull(longArrayWrap)) {
      pactDslJsonBody.array(longArrayWrapName).stringValue(Arrays.toString(longArrayWrap)).closeArray();
    }

    if (Objects.nonNull(floatArray)) {
      pactDslJsonBody.array(floatArrayName).stringValue(Arrays.toString(floatArray)).closeArray();
    }

    if (Objects.nonNull(floatArrayWrap)) {
      pactDslJsonBody.array(floatArrayWrapName).stringValue(Arrays.toString(floatArrayWrap)).closeArray();
    }

    if (Objects.nonNull(doubleArray)) {
      pactDslJsonBody.array(doubleArrayName).stringValue(Arrays.toString(doubleArray)).closeArray();
    }

    if (Objects.nonNull(doubleArrayWrap)) {
      pactDslJsonBody.array(doubleArrayWrapName).stringValue(Arrays.toString(doubleArrayWrap)).closeArray();
    }
    return pactDslJsonBody;
  }

  public RandomValueGeneration buildExpectedInstance() {
    RandomValueGeneration object = new RandomValueGeneration();
    object.setInteger(this.integer);
    object.setPrimitiveInt(this.primitiveInt);
    object.setLongObject(this.longObject);
    object.setPrimitiveLong(this.primitiveLong);
    object.setFloatObject(this.floatObject);
    object.setPrimitiveFloat(this.primitiveFloat);
    object.setDoubleObject(this.doubleObject);
    object.setPrimitiveDouble(this.primitiveDouble);
    object.setShortObject(this.shortObject);
    object.setPrimitiveShort(this.primitiveShort);
    object.setByteObject(this.byteObject);
    object.setPrimitiveByte(this.primitiveByte);
    object.setBigIntegerObject(this.bigIntegerObject);
    object.setBigDecimalObject(this.bigDecimalObject);
    object.setStringArray(this.stringArray);
    object.setBooleanArray(this.booleanArray);
    object.setBooleanArrayWrap(this.booleanArrayWrap);
    object.setByteArray(this.byteArray);
    object.setByteArrayWrap(this.byteArrayWrap);
    object.setShortArray(this.shortArray);
    object.setShortArrayWrap(this.shortArrayWrap);
    object.setIntArray(this.intArray);
    object.setIntArrayWrap(this.intArrayWrap);
    object.setCharArray(this.charArray);
    object.setCharArrayWrap(this.charArrayWrap);
    object.setLongArray(this.longArray);
    object.setLongArrayWrap(this.longArrayWrap);
    object.setFloatArray(this.floatArray);
    object.setFloatArrayWrap(this.floatArrayWrap);
    object.setDoubleArray(this.doubleArray);
    object.setDoubleArrayWrap(this.doubleArrayWrap);
    return object;
  }

  private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
  }

  public static long[] getLongArray(String[] numbers) {
    long[] result = new long[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Long.parseLong(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0l; }
    return result;
  }

  public static Long[] getLongArrayWrap(String[] numbers) {
    Long[] result = new Long[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Long.parseLong(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0L; }
    return result;
  }

  public static float[] getFloatArray(String[] numbers) {
    float[] result = new float[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Float.parseFloat(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0.0f; }
    return result;
  }

  public static Float[] getFloatArrayWrap(String[] numbers) {
    Float[] result = new Float[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Float.parseFloat(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0.0F; }
    return result;
  }

  public static double[] getDoubleArray(String[] numbers) {
    double[] result = new double[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Double.parseDouble(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0.0d; }
    return result;
  }

  public static Double[] getDoubleArrayWrap(String[] numbers) {
    Double[] result = new Double[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Double.parseDouble(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0.0D; }
    return result;
  }
}