# PactAnnotationBuilder

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/4a9be5a4b6ab48afba293b2315edd47e)]()[![Maven Central](https://img.shields.io/maven-central/v/com.sngular/?label=Maven%20Central)]()

This is an annotation processor designed to generate Pact Dsl Builders based on annotated classes.

## Index

- [Pact Annotation Builder](#pact-annotation-builder)
- [Main Configuration](#main-configuration)
  - [How to add the annotations](#how-to-add-the-annotations)
  - [How to use the Builders](#how-to-use-the-builders)

## Main Configuration

This plugin allows developers to automatize the creation of code for build Pact Request Bodies for Pact Consumer Contracts.

### How to configure the POM file

Just add the dependency on the 
```xml
  <dependencies>
    ...
    <dependency>
      <groupId>com.sngular</groupId>
      <artifactId>pact-annotation-processor</artifactId>
      <version>1.0-SNAPSHOT</version>
    </dependency>
    ...
  </dependencies>
```

### How to add the annotations

To maintain the generation of the different builders each class should be annotated as `@PactDslBodyBuilder`.
If you want to provide son specific value for a field, then use the annotation `@Example` with the value you want to be added as default in the builder

```java
package com.sngular.model;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.ZonedDateTime;

@PactDslBodyBuilder
public class Address {

  @Example("2023-12-03T10:15:30+01:00[Europe/Madrid]")
  private ZonedDateTime deliveryTime;

  @Example("Jose")
  private String name;

  @Max(12)
  @Min(1)
  @Example("4")
  private int number;

  private ZonedDateTime init;


  private City city;

}
```
Other annotations you can use in order to configure value and builder generation are `@Max` `@Min`. Which will indicate the minimum and maximum values that property can have. In case of collections it will delimitate the number of elements that collection will contain.

### How to use the builders

Once the code is compiled, builders will be generated and available to build Pact Json Bodies. Just only need to add the import you required and add the values you want to overwrite
So this code 
```java
    personBuilder
        .setAddress(new com.sngular.model.AddressBuilder()
             .setCity(new com.sngular.model.CityBuilder()
                      .setCoords(BigDecimal.valueOf(8.7))
                      .setCityName("Ourense")))
    .build();
```
will generate this output

```json
{
  "address":
  {
    "city":
    {
      "cityName":"Ourense",
      "coords":8.7,
      "isCapital":true,
      "objectList":["2023-10-25[[+02:00]]"]
    },
    "deliveryTime":"2023-12-03T10:15:30.000000.000+01:00[Europe/Madrid]",
    "init":"2023-10-25T17:47:09.637165.637+02:00[Europe/Madrid]",
    "name":"Jose",
    "number":4
  },
  "age":1572804885,
  "name":"7z2",
  "wallet":1.6901720963006214E+308
}
```