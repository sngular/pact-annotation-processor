/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.model;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class FieldValidations {

  Integer min;

  Integer max;

  Integer randomSize;

  String regex;

}
