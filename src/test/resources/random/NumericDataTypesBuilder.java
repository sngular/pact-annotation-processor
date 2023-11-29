package com.sngular.annotation.examples;

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
import com.sngular.annotation.examples.NumericDataTypes;

public class NumericDataTypesBuilder {
  int age = 18;

  public NumericDataTypesBuilder setAge(final int age) {
    this.age = age;
    return this;
  }

  public DslPart build() {
    PactDslJsonBody pactDslJsonBody = new PactDslJsonBody();
    if (Objects.nonNull(age)) {
      pactDslJsonBody.integerType("age", age);
    }

    return pactDslJsonBody;
  }
  public NumericDataTypes buildExpectedInstance() {
    NumericDataTypes object = new NumericDataTypes();
    object.setAge(this.age);
    return object;
  }
  private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
  }

}

