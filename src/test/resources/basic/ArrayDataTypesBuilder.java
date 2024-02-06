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
import com.sngular.resources.basic.ArrayDataTypes;
import java.util.Arrays;

public class ArrayDataTypesBuilder {

    String[] stringArray = {"abc","bef","ghi"};
    String stringArrayName = "stringArray";

    boolean[] booleanArray = {true, false};
    String booleanArrayName = "booleanArray";

    Boolean[] booleanArrayWrap = {false, true};
    String booleanArrayWrapName = "booleanArrayWrap";

    byte[] byteArray = {1,2,3,4,5};
    String byteArrayName = "byteArray";

    Byte[] byteArrayWrap = {6,7,8,9,10};
    String byteArrayWrapName = "byteArrayWrap";

    short[] shortArray = {11,12,13,14,15};
    String shortArrayName = "shortArray";

    Short[] shortArrayWrap = {16,17,18,19,20};
    String shortArrayWrapName = "shortArrayWrap";

    int[] intArray = {-2147483648};
    String intArrayName = "intArray";

    Integer[] intArrayWrap = {2147483647};
    String intArrayWrapName = "intArrayWrap";

    char[] charArray = {'j','k','l'};
    String charArrayName = "charArray";

    Character[] charArrayWrap = {'m','n','o'};
    String charArrayWrapName = "charArrayWrap";

    // se requiere "inLongArray" para poder crear "longArray", ya que si se pasa
    // el valor String directo a long[], tenemos conflicto
    String[] inLongArray = {"-123456789012345678901234567890.402823L"};
    long[] longArray = Arrays.stream(inLongArray).mapToLong(Long::parseLong).toArray();
    String longArrayName = "longArray";

    String[] inDoubleArray = {"-1234567890123456789012345678901234567890.79769313486232D"};
    double[] doubleArray = Arrays.stream(inDoubleArray).mapToDouble(Double::parseDouble).toArray();
    String doubleArrayName = "doubleArray";


    public ArrayDataTypesBuilder setStringArray(final String[] stringArray) {
        this.stringArray = stringArray;
        return this;
    }

    public ArrayDataTypesBuilder setBooleanArray(final boolean[] booleanArray) {
        this.booleanArray = booleanArray;
        return this;
    }

    public ArrayDataTypesBuilder setBooleanArrayWrap(final Boolean[] booleanArrayWrap) {
        this.booleanArrayWrap = booleanArrayWrap;
        return this;
    }

    public ArrayDataTypesBuilder setByteArray(final byte[] byteArray) {
        this.byteArray = byteArray;
        return this;
    }

    public ArrayDataTypesBuilder setByteArrayWrap(final Byte[] byteArrayWrap) {
        this.byteArrayWrap = byteArrayWrap;
        return this;
    }

    public ArrayDataTypesBuilder setShortArray(final short[] shortArray) {
        this.shortArray = shortArray;
        return this;
    }

    public ArrayDataTypesBuilder setShortArrayWrap(final Short[] shortArrayWrap) {
        this.shortArrayWrap = shortArrayWrap;
        return this;
    }

    public ArrayDataTypesBuilder setIntArray(final int[] intArray) {
        this.intArray = intArray;
        return this;
    }

    public ArrayDataTypesBuilder setIntArrayWrap(final Integer[] intArrayWrap) {
        this.intArrayWrap = intArrayWrap;
        return this;
    }

    public ArrayDataTypesBuilder setCharArray(final char[] charArray) {
        this.charArray = charArray;
        return this;
    }

    public ArrayDataTypesBuilder setCharArrayWrap(final Character[] charArrayWrap) {
        this.charArrayWrap = charArrayWrap;
        return this;
    }

    public ArrayDataTypesBuilder setLongArray(final long[] longArray) {
        this.longArray = longArray;
        return this;
    }

    public ArrayDataTypesBuilder setDoubleArray(final double[] doubleArray) {
        this.doubleArray = doubleArray;
        return this;
    }


    public DslPart build() {
        PactDslJsonBody pactDslJsonBody = new PactDslJsonBody();

        if (Objects.nonNull(stringArray)) {
            pactDslJsonBody.array(stringArrayName).stringValue(Arrays.toString(stringArray)).closeArray();
        }

        if (Objects.nonNull(booleanArray)) {
            pactDslJsonBody.array(booleanArrayName).stringValue(Arrays.toString(booleanArray)).closeArray();
        }

        if (Objects.nonNull(booleanArrayWrap)) {
            pactDslJsonBody.array(booleanArrayWrapName).stringValue(Arrays.toString(booleanArrayWrap)).closeArray();
        }

        if (Objects.nonNull(byteArray)) {
            pactDslJsonBody.array(byteArrayName).stringValue(Arrays.toString(byteArray)).closeArray();
        }

        if (Objects.nonNull(byteArrayWrap)) {
            pactDslJsonBody.array(byteArrayWrapName).stringValue(Arrays.toString(byteArrayWrap)).closeArray();
        }

        if (Objects.nonNull(shortArray)) {
            pactDslJsonBody.array(shortArrayName).stringValue(Arrays.toString(shortArray)).closeArray();
        }

        if (Objects.nonNull(shortArrayWrap)) {
            pactDslJsonBody.array(shortArrayWrapName).stringValue(Arrays.toString(shortArrayWrap)).closeArray();
        }

        if (Objects.nonNull(intArray)) {
            pactDslJsonBody.array(intArrayName).stringValue(Arrays.toString(intArray)).closeArray();
        }

        if (Objects.nonNull(intArrayWrap)) {
            pactDslJsonBody.array(intArrayWrapName).stringValue(Arrays.toString(intArrayWrap)).closeArray();
        }

        if (Objects.nonNull(charArray)) {
            pactDslJsonBody.array(charArrayName).stringValue(Arrays.toString(charArray)).closeArray();
        }

        if (Objects.nonNull(charArrayWrap)) {
            pactDslJsonBody.array(charArrayWrapName).stringValue(Arrays.toString(charArrayWrap)).closeArray();
        }

        if (Objects.nonNull(longArray)) {
            pactDslJsonBody.array(longArrayName).stringValue(Arrays.toString(longArray)).closeArray();
        }

        if (Objects.nonNull(doubleArray)) {
            pactDslJsonBody.array(doubleArrayName).stringValue(Arrays.toString(doubleArray)).closeArray();
        }
        return pactDslJsonBody;
    }

    public ArrayDataTypes buildExpectedInstance() {
        ArrayDataTypes object = new ArrayDataTypes();
        object.setStringArray(this.stringArray);
        object.setBooleanArray(this.booleanArray);
        object.setBooleanArrayWrap(this.booleanArrayWrap);
        object.setByteArray(this.byteArray);
        object.setByteArrayWrap(this.byteArrayWrap);
        object.setShortArray(this.shortArray);
        object.setShortArrayWrap(this.shortArrayWrap);
        object.setIntArray(this.intArray);
        object.setIntArrayWrap(this.intArrayWrap);
        object.setCharArray(this.charArray);
        object.setCharArrayWrap(this.charArrayWrap);
        object.setLongArray(this.longArray);
        object.setDoubleArray(this.doubleArray);

        return object;
    }

    private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }
}

