/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.exception;

public class PactProcessorException extends RuntimeException {

  private static final String ERROR_MESSAGE = "Error processing element %s";

  public PactProcessorException(final String ex) {
    super(String.format(ERROR_MESSAGE, ex));
  }
}
