/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.model;

import java.util.List;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class ClassBuilderTemplate {

  String modelPackage;

  String fileName;

  String className;

  List<DslField> fieldList;

  List<String> customModifiers;

  public String completePath() {
    return String.format("%s.%s", modelPackage, fileName);
  }
}

