/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.exception;

public class TemplateGenerationException extends RuntimeException {

  private static final String ERROR_MESSAGE = "Error processing template builder for annotation %s";

  public TemplateGenerationException(final String annotationName, final Exception ex) {
    super(String.format(ERROR_MESSAGE, annotationName), ex);
  }
}
