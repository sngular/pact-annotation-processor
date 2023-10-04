/*
 *  This Source Code Form is subject to the terms of the Mozilla Public
 *  * License, v. 2.0. If a copy of the MPL was not distributed with this
 *  * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package com.sngular.annotation.processor.template;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.sngular.annotation.processor.model.ClassBuilderTemplate;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

public class TemplateFactory {

  private static final String SCHEMA_ROOT = "schema";

  private final Configuration cfg = new Configuration(Configuration.VERSION_2_3_32);

  public TemplateFactory() throws TemplateException {
    cfg.setTemplateLoader(new ClasspathTemplateLoader());
    cfg.setDefaultEncoding("UTF-8");
    cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
    cfg.setLogTemplateExceptions(true);
    cfg.setSetting("c_format", "Java");
  }

  public void writeTemplateToFile(final String templateName, final ClassBuilderTemplate classBuilder, final Writer writer) throws IOException, TemplateException {
    final Template template = cfg.getTemplate(templateName);

    Map<String, Object> root = new HashMap<>();
    root.put(SCHEMA_ROOT, classBuilder);
    template.process(root, writer);
    writer.close();
  }
}
