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

    String[] inLongArray = {"-9223372036854775807l",
                            "9223372036854775807L",
                            "-0l",
                            "0L",
                            "-3.402823e38",
                            "0.0",
                            "al"}
    long[] longArray = getLongArray(inLongArray);
    String longArrayName = "longArray";

    String[] inLongArrayWrap = {"-9223372036854775807l",
                                "9223372036854775807L",
                                "-0l",
                                "0L",
                                "-3.402823e38",
                                "-0.0",
                                "aL"};
    Long[] longArrayWrap = getLongArrayWrap(inLongArrayWrap);
    String longArrayWrapName = "longArrayWrap";

    String[] inFloatArray = {"-82233720368547758080000001f",
                            "100.0F",
                            "-123456789012345678901234567890123456789f",
                            "123456789012345678901234567890123456789F",
                            "-3.402823e38",
                            "0.0",
                            "af"};
    float[] floatArray = getFloatArray(inFloatArray);
    String floatArrayName = "floatArray";


    String[] inFloatArrayWrap = {"-1234567890123456789012345678901234567890.79769313486232d",
                                "1000.0D",
                                "-123456789012345678901234567890123456789d",
                                "123456789012345678901234567890123456789D",
                                "-3.402823e300d",
                                "-0.0",
                                "aF"};
    Float[] floatArrayWrap = getFloatArrayWrap(inFloatArrayWrap);
    String floatArrayWrapName = "floatArrayWrap";


    String[] inDoubleArray = {"-1234567890123456789012345678901234567890.79769313486232d",
                            "1000.0D",
                            "1234567890123456789012345678901234567890123456789012345678901234567890D",
                            "-2.12345678901234d",
                            "3.402823e307D",
                            "0.0",
                            "ad"};
    double[] doubleArray = getDoubleArray(inDoubleArray);
    String doubleArrayName = "doubleArray";


    String[] inDoubleArrayWrap = {"-1234567890123456789012345678901234567890.79769313486232d",
                                "1000.0D",
                                "1234567890123456789012345678901234567890123456789012345678901234567890D",
                                "-2.12345678901234d",
                                "3.402823e307D",
                                "-0.0",
                                "aD"};
    Double[] doubleArrayWrap = getDoubleArrayWrap(inDoubleArrayWrap);
    String doubleArrayWrapName = "doubleArrayWrap";


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

    public ArrayDataTypesBuilder setLongArrayWrap(final Long[] longArrayWrap) {
        this.longArrayWrap = longArrayWrap;
        return this;
    }

    public ArrayDataTypesBuilder setFloatArray(final float[] floatArray) {
        this.floatArray = floatArray;
        return this;
    }

    public ArrayDataTypesBuilder setFloatArrayWrap(final Float[] floatArrayWrap) {
        this.floatArrayWrap = floatArrayWrap;
        return this;
    }

    public ArrayDataTypesBuilder setDoubleArray(final double[] doubleArray) {
        this.doubleArray = doubleArray;
        return this;
    }

    public ArrayDataTypesBuilder setDoubleArrayWrap(final Double[] doubleArrayWrap) {
        this.doubleArrayWrap = doubleArrayWrap;
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

        if (Objects.nonNull(longArrayWrap)) {
            pactDslJsonBody.array(longArrayWrapName).stringValue(Arrays.toString(longArrayWrap)).closeArray();
        }

        if (Objects.nonNull(floatArray)) {
            pactDslJsonBody.array(floatArrayName).stringValue(Arrays.toString(floatArray)).closeArray();
        }

        if (Objects.nonNull(floatArrayWrap)) {
            pactDslJsonBody.array(floatArrayWrapName).stringValue(Arrays.toString(floatArrayWrap)).closeArray();
        }

        if (Objects.nonNull(doubleArray)) {
            pactDslJsonBody.array(doubleArrayName).stringValue(Arrays.toString(doubleArray)).closeArray();
        }

        if (Objects.nonNull(doubleArrayWrap)) {
            pactDslJsonBody.array(doubleArrayWrapName).stringValue(Arrays.toString(doubleArrayWrap)).closeArray();
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
        object.setLongArrayWrap(this.longArrayWrap);
        object.setFloatArray(this.floatArray);
        object.setFloatArrayWrap(this.floatArrayWrap);
        object.setDoubleArray(this.doubleArray);
        object.setDoubleArrayWrap(this.doubleArrayWrap);
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