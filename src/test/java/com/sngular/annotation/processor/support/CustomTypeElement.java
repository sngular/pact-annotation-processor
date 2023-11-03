package com.sngular.annotation.processor.support;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.Set;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.ElementVisitor;
import javax.lang.model.element.Modifier;
import javax.lang.model.element.Name;
import javax.lang.model.element.NestingKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.element.TypeParameterElement;
import javax.lang.model.type.TypeMirror;

public class CustomTypeElement implements TypeElement {

  private final List<CustomTypeElement> fields;

  private final CustomType customType;

  protected CustomTypeElement(final CustomType customType, final List<CustomTypeElement> fields) {
    this.customType = customType;
    this.fields = fields;
  }

  @Override
  public TypeMirror asType() {
    return customType;
  }

  @Override
  public List<? extends Element> getEnclosedElements() {
    return fields;
  }

  @Override
  public NestingKind getNestingKind() {
    return null;
  }

  @Override
  public Name getQualifiedName() {
    return null;
  }

  @Override
  public Name getSimpleName() {
    return null;
  }

  @Override
  public TypeMirror getSuperclass() {
    return null;
  }

  @Override
  public List<? extends TypeMirror> getInterfaces() {
    return null;
  }

  @Override
  public List<? extends TypeParameterElement> getTypeParameters() {
    return null;
  }

  @Override
  public Element getEnclosingElement() {
    return null;
  }

  @Override
  public ElementKind getKind() {
    return ElementKind.FIELD;
  }

  @Override
  public Set<Modifier> getModifiers() {
    return null;
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
  public <R, P> R accept(final ElementVisitor<R, P> v, final P p) {
    return null;
  }
}