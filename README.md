# Pact Builder DSL

[![Codacy Badge](https://app.codacy.com/project/badge/Grade/67f7406f9b79477faae81cc93ed79395)](https://app.codacy.com/gh/sngular/pact-annotation-processor/dashboard?utm_source=gh&utm_medium=referral&utm_content=&utm_campaign=Badge_grade)[![Maven Central](https://img.shields.io/maven-central/v/com.sngular/pact-annotation-processor?label=Maven%20Central)](https://central.sonatype.com/artifact/com.sngular/pact-annotation-processor)

This is a helper tool for Contract Testing with [Pact](https://docs.pact.io/).
An annotation processor designed to generate DslPart objects for the body definitions based on annotations included in your model classes.

The focus is to simplify JVM contract testing implementation, minimizing the amount of boilerplate code needed.

Specially useful when defining body validations for interactions with complex models.

## Table of Contents

- [Pact Builder DSL](#pact-builder-dsl)
- [Getting Started](#getting-started)
  - [Requirements](#requirements)
  - [Compatibility with pact-jvm](#compatibility-with-pact-jvm)
  - [Configuration](#configuration)
- [Usage](#usage)
  - [Annotations](#annotations)
  - [Builder](#builder)
- [Roadmap](#roadmap)
- [Contributing](#contributing)
- [License](#license)
- [Contact](#contact)

## Getting Started

### Requirements

- JDK +17

- Having inside your project a verification library of your choice to have the `@Max` and `@Min` annotations available, such as [Jakarta](https://central.sonatype.com/artifact/jakarta.validation/jakarta.validation-api), [Spring Boot](https://central.sonatype.com/artifact/org.springframework.boot/spring-boot-starter-validation) or similar.

### Compatibility with pact-jvm

|                                      Pact Builder DSL                                      |  Pact JVM  |
|:------------------------------------------------------------------------------------------:|:----------:|
| [1.0.0](https://central.sonatype.com/artifact/com.sngular/pact-annotation-processor/1.0.0) |   +4.6.3   |
| [1.1.0](https://central.sonatype.com/artifact/com.sngular/pact-annotation-processor/1.1.0) |   +4.6.3   |
| [1.2.0](https://central.sonatype.com/artifact/com.sngular/pact-annotation-processor/1.1.0) |   +4.6.3   |

### Configuration

The only configuration needed for starting using the library is adding the dependency to your build automation tool:

Maven

```xml
  <dependencies>
    ...
    <dependency>
      <groupId>com.sngular</groupId>
      <artifactId>pact-annotation-processor</artifactId>
      <version>1.2.0</version>
    </dependency>
    ...
  </dependencies>
```

Gradle

```groovy
implementation('com.sngular:pact-annotation-processor:1.2.0')
```

## Usage

To enable the code generation in a model class, you should annotate it as `@PactDslBodyBuilder`.
That is the only requirement, all other annotations are optional and used for customising the generated code.

### Annotations

We have developed 3 annotations to give support to your needs,

- `@PactDslBodyBuilder` : To indicate which class you need to generate pact to.
- `@Example`: To define constants values to set in your Pact Body.
- `DslExclude`: To Exclude some property to be included in the builder.

and support 2 standard Java annotations for validation

- `@Min`: From Jakarta or Javax (or other validation tools) to indicate the
minimum value to be cover for this property.
- `@Max`: From Jakarta or Javax (or other validation tools) to indicate the
maximum value to be cover for this property.

|            Annotation | Required | Level | Description                                                                                                                                 |
|----------------------:|:--------:|:-----:|:--------------------------------------------------------------------------------------------------------------------------------------------|
| `@PactDslBodyBuilder` |   true   | Class | Main annotation, to be included in classes that want to be processed.                                                                       |
|            `@Example` |  false   | Field | Used to provide an specific value for a field. If not present in a field, the value created will be random.                                 |
|                `@Min` |  false   | Field | Defines the maximum value for numeric fields, or number of elements if applied to collections. Will be ignored if an `@Example` is present. |
|                `@Max` |  false   | Field | Defines the minimum value for numeric fields, or number of elements if applied to collections. Will be ignored if an `@Example` is present. |
|         `@DslExclude` |  false   | Field | Ignore de generation of example values.                                                                                                     |

> `@Example` values are always provided as String. If a specific format is
 required lets say for date
> and datetime properties, then a format field should be provided,
 otherwise it will fall back to default
> format. For date and datetime default format are:
>
> - `yyyy-MM-dd['['ZZZ']']` : for dates
>
> - `yyyy-MM-dd'T'HH:mm:ss[.SSSSSS][.SSS]XXX['['VV']']` : for datetimes. Zone should be provided with this format.

#### Example

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

  @Example("2023-12-13")
  private Date creationDate;

  @Example("Jose")
  private String name;

  @Max(12)
  @Min(1)
  private int number;

  @Example("4")
  private long aLong;

  private ZonedDateTime init;
  
  private City city;

}
```

### Builder

Once the code is compiled, builder will be generated and available under `generated-sources` in your build directory.

You will need to add the required import, and make use of the related builder class.

#### Example

```java
import com.sngular.model.AddressBuilder;
        
AddressBuilder addressBuilder = new AddressBuilder();
DslPart bodyDslPart = addressBuilder.build();


@Pact(consumer = "consumer-poc", provider = "provider-poc")
public RequestResponsePact getStudents(PactDslWithProvider builder) {
        AddressBuilder addressBuilder = new AddressBuilder();
        DslPart bodyDslPart = studentBuilder.build();
        
        return builder.given("Address exist")
        .uponReceiving("get all address")
        .path("/address/")
        .method("GET")
        .willRespondWith()
        .status(200)
        .headers(Map.of("Content-Type", "application/json"))
        .body(bodyDslPart)
        .toPact();
}
```

## Notes

- Dates: Regarding Timestamp and Date, we should use keep in mind the default
  formats will be used to parse those values:
  - For Dates, we are using `"yyyy-MM-dd['['ZZZ']']"` as default format
  - For Timestamps, we are using
  `"yyyy-MM-dd'T'HH:mm:ss[.SSSSSS][.SSS]XXX['['VV']']"`
  as default format for datetime (ZonedDateTime)
  If you need and specific format the `@Example` support a format property
  to handle them.
=======
### Expected Instance Builder

In certain situations, especially when using the `@Example` annotation in all
of your model data objects, you may prefer to perform classic manual
instance creation for your validations in the `@Test` methods:

```java
@Test
@PactTestFor(pactMethod = "getAddressTest")
void getAddressTest(MockServer mockServer) {
        RestTemplate restTemplate = new RestTemplateBuilder().rootUri(mockServer.getUrl()).build();
        Address response = new BasicService(restTemplate).getAdress("...");

        // Manual instance creation for validation
        Address expectedAddress = new Address();
        expectedAddress.setName("Jose");
        expectedAddress.setNumber(12);
        // ...

        assertEquals(expectedAddress, response);
        }
```

However, in many situations, especially when dealing with random values being generated,
you may prefer to delegate the instance creation to the library itself.
This is the purpose of the `buildExpectedInstance()` method, which generates an
instance of the model object initialized with the values generated (or set
by you with `@Example`) for the given object:

```java

@Test
@PactTestFor(pactMethod = "getAddressTest")
void getAddressTest(MockServer mockServer) {
        RestTemplate restTemplate = new RestTemplateBuilder().rootUri(mockServer.getUrl()).build();
        Address response = new BasicService(restTemplate).getAdress("...");

        // Using buildExpectedInstance() for instance creation
        Address expectedAddress = new AddressBuilder().buildExpectedInstance();

        assertEquals(expectedAddress, response);
        }

```

## Roadmap

Roadmap available under [GitHub Projects section](https://github.com/orgs/sngular/projects/2).

See the [open issues](https://github.com/sngular/pact-annotation-processor/issues) for a full list of proposed features (and known issues).

## Contributing

Contributions are what makes the open source community special. Any contributions you make are greatly appreciated.

If you have a suggestion that would make this library better,
please [review our contributing guidelines](https://github.com/sngular/pact-annotation-processor/blob/main/CONTRIBUTING.md).

Or you can simply [open a feature request issue](https://github.com/sngular/pact-annotation-processor/issues/new/choose).

## License

Distributed under Mozilla Public License Version 2.0. See [LICENSE](https://github.com/sngular/pact-annotation-processor/blob/main/LICENSE) for more information

## Contact

OS3 team: [os3@sngular.com](mailto:os3@sngular.com)

Sngular - [GitHub Org](https://github.com/sngular)

<https://www.sngular.com>
