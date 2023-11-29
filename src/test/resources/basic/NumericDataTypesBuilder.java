package com.sngular.resources.basic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.text.DateFormat;
import java.text.ParsePosition;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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

    return pactDslJsonBody;
  }
  public NumericDataTypes buildExpectedInstance() {
    NumericDataTypes object = new NumericDataTypes();
    object.setInteger(this.integer);
    object.setPrimitiveInt(this.primitiveInt);
    object.setLongObject(this.longObject);
    object.setPrimitiveLong(this.primitiveLong);
    return object;
  }
  private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
  }

}