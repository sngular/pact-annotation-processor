package com.sngular.model;

import com.sngular.annotation.pact.Example;
import com.sngular.annotation.pact.PactDslBodyBuilder;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.time.ZonedDateTime;


@PactDslBodyBuilder
public class Address {

    @Example("2023-12-03T10:15:30+01:00 Europe/Madrid")
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
