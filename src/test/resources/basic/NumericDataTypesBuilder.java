package com.sngular.resources.basic;

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
import com.sngular.resources.basic.NumericDataTypes;

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
}