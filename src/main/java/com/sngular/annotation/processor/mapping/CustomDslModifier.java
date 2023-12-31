/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.mapping;

import au.com.dius.pact.consumer.dsl.PactDslJsonBody;

@FunctionalInterface
public interface CustomDslModifier {

  PactDslJsonBody apply(final PactDslJsonBody pactDslJsonBody);

}