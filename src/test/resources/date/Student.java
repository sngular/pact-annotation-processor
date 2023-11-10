package com.sngular.annotation.examples;

import java.util.Date;
import java.time.ZonedDateTime;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;

@PactDslBodyBuilder
public class Student {

  @Example("exampleName")
  private String name;

  @Example(value = "23/04/2023 12:00", format = "dd/MM/yyyy HH:mm")
  private ZonedDateTime age;

  @Example(value = "2023-04-23")
  private Date join;

}