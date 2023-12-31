package com.sngular.annotation.examples;

import java.util.Date;
import java.time.ZonedDateTime;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;

@PactDslBodyBuilder
public class DateDataTypes {

  @Example(value = "23/04/2023 12:00", format = "dd/MM/yyyy HH:mm")
  private ZonedDateTime formattedZoneDateTime;

  @Example(value = "2023-12-03T10:15:30+01:00[Europe/Madrid]")
  private ZonedDateTime defaultFormatZoneDateTime;

  @Example(value = "2023-04-23")
  private Date defaultFormatDate;

  @Example(value = "23-04-2023", format = "dd-MM-yyyy")
  private Date formattedDate;

  protected ZonedDateTime getFormattedZoneDateTime() {
    return formattedZoneDateTime;
  }

  protected void setFormattedZoneDateTime(final ZonedDateTime formattedZoneDateTime) {
    this.formattedZoneDateTime = formattedZoneDateTime;
  }

  protected ZonedDateTime getDefaultFormatZoneDateTime() {
    return defaultFormatZoneDateTime;
  }

  protected void setDefaultFormatZoneDateTime(final ZonedDateTime defaultFormatZoneDateTime) {
    this.defaultFormatZoneDateTime = defaultFormatZoneDateTime;
  }

  protected Date getDefaultFormatDate() {
    return defaultFormatDate;
  }

  protected void setDefaultFormatDate(final Date defaultFormatDate) {
    this.defaultFormatDate = defaultFormatDate;
  }

  protected Date getFormattedDate() {
    return formattedDate;
  }

  protected void setFormattedDate(final Date formattedDate) {
    this.formattedDate = formattedDate;
  }
}