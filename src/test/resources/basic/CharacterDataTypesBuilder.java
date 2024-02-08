package com.sngular.resources.basic;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslJsonRootValue;
import com.sngular.annotation.processor.mapping.CustomDslModifier;
import com.sngular.resources.basic.CharacterDataTypes;
import java.util.Arrays;

public class CharacterDataTypesBuilder {
  String name = "nameExample";

  String primitiveChar = "a";

  String charObject = "b";

  boolean primitiveBoolean = true;

  boolean booleanObject = false;

  public CharacterDataTypesBuilder setName(final String name) {
    this.name = name;
    return this;
  }

  public CharacterDataTypesBuilder setPrimitiveChar(final String primitiveChar) {
    this.primitiveChar = primitiveChar;
    return this;
  }

  public CharacterDataTypesBuilder setCharObject(final String charObject) {
    this.charObject = charObject;
    return this;
  }

  public CharacterDataTypesBuilder setPrimitiveBoolean(final boolean primitiveBoolean) {
    this.primitiveBoolean = primitiveBoolean;
    return this;
  }

  public CharacterDataTypesBuilder setBooleanObject(final boolean booleanObject) {
    this.booleanObject = booleanObject;
    return this;
  }

  public DslPart build() {
    PactDslJsonBody pactDslJsonBody = new PactDslJsonBody();
    if (Objects.nonNull(name)) {
      pactDslJsonBody.stringType("name", name);
    }

    if (Objects.nonNull(primitiveChar)) {
      pactDslJsonBody.stringType("primitiveChar", primitiveChar);
    }

    if (Objects.nonNull(charObject)) {
      pactDslJsonBody.stringType("charObject", charObject);
    }

    if (Objects.nonNull(primitiveBoolean)) {
      pactDslJsonBody.booleanType("primitiveBoolean", primitiveBoolean);
    }

    if (Objects.nonNull(booleanObject)) {
      pactDslJsonBody.booleanType("booleanObject", booleanObject);
    }

    return pactDslJsonBody;
  }

  public CharacterDataTypes buildExpectedInstance() {
    CharacterDataTypes object = new CharacterDataTypes();
    object.setName(this.name);
    object.setPrimitiveChar(this.primitiveChar.charAt(0));
    object.setCharObject(this.charObject.charAt(0));
    object.setPrimitiveBoolean(this.primitiveBoolean);
    object.setBooleanObject(this.booleanObject);
    return object;
  }

  private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
  }

  public static long[] getLongArray(String[] numbers) {
    long[] result = new long[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Long.parseLong(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0l; }
    return result;
  }

  public static Long[] getLongArrayWrap(String[] numbers) {
    Long[] result = new Long[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Long.parseLong(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0L; }
    return result;
  }

  public static float[] getFloatArray(String[] numbers) {
    float[] result = new float[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Float.parseFloat(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0.0f; }
    return result;
  }

  public static Float[] getFloatArrayWrap(String[] numbers) {
    Float[] result = new Float[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Float.parseFloat(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0.0F; }
    return result;
  }

  public static double[] getDoubleArray(String[] numbers) {
    double[] result = new double[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Double.parseDouble(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0.0d; }
    return result;
  }

  public static Double[] getDoubleArrayWrap(String[] numbers) {
    Double[] result = new Double[numbers.length];
    for (int i = 0; i < numbers.length; i++)
      try { result[i] = Double.parseDouble(numbers[i]);
      } catch (NumberFormatException nfe) { result[i] = 0.0D; }
    return result;
  }
}