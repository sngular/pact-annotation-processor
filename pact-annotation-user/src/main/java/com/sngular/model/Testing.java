package com.sngular.model;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;

public class Testing {

    public static void main(String[] args) {
        DslPart result = com.sngular.model.PersonBuilder.defaultBuild();
        System.out.println("Default / json generated: " + result);

        var personBuilder = new com.sngular.model.PersonBuilder();
        PactDslJsonBody pactDslJsonBody = new PactDslJsonBody();
        personBuilder
          .setAddress(new com.sngular.model.AddressBuilder()
                        .setCity(new com.sngular.model.CityBuilder().setCityName("Ourense"))).build(pactDslJsonBody);

        System.out.println("Partial / json generated: " + pactDslJsonBody);
    }
}
