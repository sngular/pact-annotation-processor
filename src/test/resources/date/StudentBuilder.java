package com.sngular.annotation.examples;

import java.math.BigDecimal;
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

public class StudentBuilder {
  String name = "exampleName";

  ZonedDateTime age = ZonedDateTime.parse("23/04/2023 12:00",  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));

  Date join = DateFormat.getDateInstance().parse("2023-04-23", new ParsePosition(0));

  public StudentBuilder setName(final String name) {
    this.name = name;
    return this;
  }
  public StudentBuilder setAge(final ZonedDateTime age) {
    this.age = age;
    return this;
  }
  public StudentBuilder setJoin(final Date join) {
    this.join = join;
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
    if (Objects.nonNull(join)) {
      pactDslJsonBody.date("join", "yyyy-MM-dd['['ZZZ']']", join);
    }
    return pactDslJsonBody;
  }

  private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
  }

}

