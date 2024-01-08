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
import com.sngular.annotation.examples.DateDataTypes;


public class DateDataTypesBuilder {
  ZonedDateTime formattedZoneDateTime = ZonedDateTime.parse("23/04/2023 12:00",  DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
  ZonedDateTime defaultFormatZoneDateTime = ZonedDateTime.parse("2023-12-03T10:15:30+01:00[Europe/Madrid]",  DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss[.SSSSSS][.SSS]XXX['['VV']']"));
  Date defaultFormatDate = new SimpleDateFormat("yyyy-MM-dd").parse("2023-04-23");
  Date formattedDate = new SimpleDateFormat("dd-MM-yyyy").parse("23-04-2023");

  public DateDataTypesBuilder() throws ParseException {}

  public DateDataTypesBuilder setFormattedZoneDateTime(final ZonedDateTime formattedZoneDateTime) {
    this.formattedZoneDateTime = formattedZoneDateTime;
    return this;
  }
  public DateDataTypesBuilder setDefaultFormatZoneDateTime(final ZonedDateTime defaultFormatZoneDateTime) {
    this.defaultFormatZoneDateTime = defaultFormatZoneDateTime;
    return this;
  }
  public DateDataTypesBuilder setDefaultFormatDate(final Date defaultFormatDate) {
    this.defaultFormatDate = defaultFormatDate;
    return this;
  }
  public DateDataTypesBuilder setFormattedDate(final Date formattedDate) {
    this.formattedDate = formattedDate;
    return this;
  }

  public DslPart build() {
    PactDslJsonBody pactDslJsonBody = new PactDslJsonBody();
    if (Objects.nonNull(formattedZoneDateTime)) {
      pactDslJsonBody.datetime("formattedZoneDateTime", "dd/MM/yyyy HH:mm", formattedZoneDateTime.toInstant());
    }
    if (Objects.nonNull(defaultFormatZoneDateTime)) {
      pactDslJsonBody.datetime("defaultFormatZoneDateTime", "yyyy-MM-dd'T'HH:mm:ss[.SSSSSS][.SSS]XXX['['VV']']", defaultFormatZoneDateTime.toInstant());
    }
    if (Objects.nonNull(defaultFormatDate)) {
      pactDslJsonBody.date("defaultFormatDate", "yyyy-MM-dd", defaultFormatDate);
    }
    if (Objects.nonNull(formattedDate)) {
      pactDslJsonBody.date("formattedDate", "dd-MM-yyyy", formattedDate);
    }

    return pactDslJsonBody;
  }
  public DateDataTypes buildExpectedInstance() {
    DateDataTypes object = new DateDataTypes();
    object.setFormattedZoneDateTime(this.formattedZoneDateTime);
    object.setDefaultFormatZoneDateTime(this.defaultFormatZoneDateTime);
    object.setDefaultFormatDate(this.defaultFormatDate);
    object.setFormattedDate(this.formattedDate);
    return object;
  }
  private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
  }

}

