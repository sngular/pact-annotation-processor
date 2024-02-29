package com.sngular.resources.basic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.ZoneId;
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
import com.sngular.resources.basic.NumericDataTypes;
import java.util.Arrays;

public class NumericDataTypesBuilder {

  int integer = 10;

  int primitiveInt = 20;

  long longObject = 30L;

  long primitiveLong = 40L;

  float floatObject = 50.1234F;

  float primitiveFloat = 60.2345F;

  double doubleObject = 70.3456D;

  double primitiveDouble = 80.4567D;

  short shortObject = 90;

  short primitiveShort = 100;

  byte byteObject = 110;

  byte primitiveByte = 120;

  BigInteger bigIntegerObject = new BigInteger("1303812548123548216");

  BigDecimal bigDecimalObject = new BigDecimal("1402354872534672834.2345");

  public NumericDataTypesBuilder setInteger(final int integer) {
    this.integer = integer;
    return this;
  }

  public NumericDataTypesBuilder setPrimitiveInt(final int primitiveInt) {
    this.primitiveInt = primitiveInt;
    return this;
  }

  public NumericDataTypesBuilder setLongObject(final long longObject) {
    this.longObject = longObject;
    return this;
  }

  public NumericDataTypesBuilder setPrimitiveLong(final long primitiveLong) {
    this.primitiveLong = primitiveLong;
    return this;
  }

  public NumericDataTypesBuilder setFloatObject(final float floatObject) {
    this.floatObject = floatObject;
    return this;
  }

  public NumericDataTypesBuilder setPrimitiveFloat(final float primitiveFloat) {
    this.primitiveFloat = primitiveFloat;
    return this;
  }

  public NumericDataTypesBuilder setDoubleObject(final double doubleObject) {
    this.doubleObject = doubleObject;
    return this;
  }

  public NumericDataTypesBuilder setPrimitiveDouble(final double primitiveDouble) {
    this.primitiveDouble = primitiveDouble;
    return this;
  }

  public NumericDataTypesBuilder setShortObject(final short shortObject) {
    this.shortObject = shortObject;
    return this;
  }

  public NumericDataTypesBuilder setPrimitiveShort(final short primitiveShort) {
    this.primitiveShort = primitiveShort;
    return this;
  }

  public NumericDataTypesBuilder setByteObject(final byte byteObject) {
    this.byteObject = byteObject;
    return this;
  }

  public NumericDataTypesBuilder setPrimitiveByte(final byte primitiveByte) {
    this.primitiveByte = primitiveByte;
    return this;
  }

  public NumericDataTypesBuilder setBigIntegerObject(final BigInteger bigIntegerObject) {
    this.bigIntegerObject = bigIntegerObject;
    return this;
  }

  public NumericDataTypesBuilder setBigDecimalObject(final BigDecimal bigDecimalObject) {
    this.bigDecimalObject = bigDecimalObject;
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

    return pactDslJsonBody;
  }

  public NumericDataTypes buildExpectedInstance() {
    NumericDataTypes object = new NumericDataTypes();
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
    return object;
  }

  private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
  }

  public static long[] getLongArray(String[] numbers) {
    long[] result = new long[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Long.parseLong(numbers[i]);
      } catch (NumberFormatException nfe) {
        System.out.println("long value expected but was: "+numbers[i]);
        result[i] = 0l;
      }
    return result;
  }

  public static Long[] getLongArrayWrap(String[] numbers) {
    Long[] result = new Long[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Long.parseLong(numbers[i]);
      } catch (NumberFormatException nfe) {
        System.out.println("Long value expected but was: "+numbers[i]);
        result[i] = 0L;
      }
    return result;
  }

  public static float[] getFloatArray(String[] numbers) {
    float[] result = new float[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Float.parseFloat(numbers[i]);
      } catch (NumberFormatException nfe) {
        System.out.println("float value expected but was: "+numbers[i]);
        result[i] = 0.0f;
      }
    return result;
  }

  public static Float[] getFloatArrayWrap(String[] numbers) {
    Float[] result = new Float[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Float.parseFloat(numbers[i]);
      } catch (NumberFormatException nfe) {
        System.out.println("Float value expected but was: "+numbers[i]);
        result[i] = 0.0F;
      }
    return result;
  }

  public static double[] getDoubleArray(String[] numbers) {
    double[] result = new double[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Double.parseDouble(numbers[i]);
      } catch (NumberFormatException nfe) {
        System.out.println("double value expected but was: "+numbers[i]);
        result[i] = 0.0d;
      }
    return result;
  }

  public static Double[] getDoubleArrayWrap(String[] numbers) {
    Double[] result = new Double[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Double.parseDouble(numbers[i]);
      } catch (NumberFormatException nfe) {
        System.out.println("Double value expected but was: "+numbers[i]);
        result[i] = 0.0D;
      }
    return result;
  }

  public static BigInteger[] getBigIntegerArray(String[] numbers) {
    BigInteger[] result = new BigInteger[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = new BigInteger(numbers[i]);
      } catch (NumberFormatException nfe) {
        System.out.println("BigInteger value expected but was: "+numbers[i]);
        result[i] = new BigInteger("0");
      }
    return result;
  }

  public static BigDecimal[] getBigDecimalArray(String[] numbers) {
    BigDecimal[] result = new BigDecimal[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = new BigDecimal(numbers[i]);
      } catch (NumberFormatException nfe) {
        System.out.println("BigDecimal value expected but was: "+numbers[i]);
        result[i] = new BigDecimal("0.0");
      }
    return result;
  }

  public static ZonedDateTime[] getZonedDateTimeArray(String[] numbers, String format) {
    ZonedDateTime[] result = new ZonedDateTime[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try {
        result[i] = LocalDateTime
                .parse(numbers[i],DateTimeFormatter.ofPattern(format))
                .atZone(ZoneId.systemDefault())
                .withZoneSameInstant(ZoneId.systemDefault());

      } catch (DateTimeException dte) {
        System.out.println("Format["+format+"] expected but was: "+numbers[i]);
        System.out.println("    "+dte.getMessage());
        result[i] = ZonedDateTime.now();
      }
    return result;
  }

  public static Date[] getDateArray(String[] numbers, String format) {
    Date[] result = new Date[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try {
        result[i] = new SimpleDateFormat(format).parse(numbers[i]);
      } catch (Exception dte) {
        System.out.println("Format["+format+"] expected but was: "+numbers[i]);
        System.out.println("    "+dte.getMessage());
        result[i] = new Date();
      }
    return result;
  }
}