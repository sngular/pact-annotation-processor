package com.sngular.annotation.processor.mapping;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;

@FunctionalInterface
public interface CustomDslModifier {

  PactDslJsonBody apply(final PactDslJsonBody pactDslJsonBody);

}