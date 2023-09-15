package com.sngular.model;


import java.math.BigDecimal;

import com.sngular.annotation.pact.PactDslBodyBuilder;

@PactDslBodyBuilder(customModifiers = {"com.sngular.model.MyCustomModifier", "com.sngular.model.MyAnotherCustomModifier"})
public class Person {

    private int age;

    private String name;

    private Address address;

    private BigDecimal wallet;
}

