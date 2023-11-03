package com.sngular.annotation.processor.support;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;

import javax.tools.SimpleJavaFileObject;

public class CustomFileObject extends SimpleJavaFileObject {

    public CustomFileObject(final URI uri, final Kind kind) {
      super(uri, kind);
    }

    @Override
    public OutputStream openOutputStream() throws IOException {
      return new FileOutputStream(this.getName());
    }
  }