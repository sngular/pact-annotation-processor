package com.sngular.model;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import com.sngular.annotation.processor.mapping.CustomDslModifier;

public class MyAnotherCustomModifier implements CustomDslModifier {
    @Override
    public PactDslJsonBody apply(PactDslJsonBody pactDslJsonBody) {
        return pactDslJsonBody.integerType("othertestCustom");
    }
}
