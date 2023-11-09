package com.sngular.annotation.examples;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslJsonRootValue;
import com.sngular.annotation.processor.mapping.CustomDslModifier;

import java.util.Objects;
import java.util.Date;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
import java.util.List;

public class StudentBuilder {
  java.lang.String name = "exampleName";

  java.time.ZonedDateTime age = ZonedDateTime.parse("23/04/2023 12:00",  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

  public StudentBuilder setName(final java.lang.String name) {
    this.name = name;
    return this;
  }
  public StudentBuilder setAge(final java.time.ZonedDateTime age) {
    this.age = age;
    return this;
  }

  public DslPart build() {
    PactDslJsonBody pactDslJsonBody = new PactDslJsonBody();
    if (Objects.nonNull(name)) {
      pactDslJsonBody.stringType("name", name);
    }
    if (Objects.nonNull(age)) {
      pactDslJsonBody.datetime("age", "dd/MM/yyyy HH:mm", age.toInstant());
    }
    return pactDslJsonBody;
  }

  private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
  }

}

