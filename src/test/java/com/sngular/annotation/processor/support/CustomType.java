package com.sngular.annotation.processor.support;

import java.lang.annotation.Annotation;
import java.util.List;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import javax.lang.model.type.TypeVariable;
import javax.lang.model.type.TypeVisitor;

public class CustomType implements TypeVariable {

  private TypeKind typeKind;

    @Override
    public Element asElement() {
      return null;
    }

    @Override
    public TypeMirror getUpperBound() {
      return null;
    }

    @Override
    public TypeMirror getLowerBound() {
      return null;
    }

    @Override
    public TypeKind getKind() {
      return typeKind;
    }

    @Override
    public List<? extends AnnotationMirror> getAnnotationMirrors() {
      return null;
    }

    @Override
    public <A extends Annotation> A getAnnotation(final Class<A> annotationType) {
      return null;
    }

    @Override
    public <A extends Annotation> A[] getAnnotationsByType(final Class<A> annotationType) {
      return null;
    }

    @Override
    public <R, P> R accept(final TypeVisitor<R, P> v, final P p) {
      return null;
    }
  }