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

    public ArrayDataTypesBuilder setStringArray(final String[] stringArray) {
        this.stringArray = stringArray;
        return this;
      }

    public DslPart build() {
        PactDslJsonBody pactDslJsonBody = new PactDslJsonBody();

        if (Objects.nonNull(stringArray)) {
            pactDslJsonBody.array(stringArrayName).stringValue(Arrays.toString(stringArray)).closeArray();
        }
        return pactDslJsonBody;
    }

    public ArrayDataTypes buildExpectedInstance() {
        ArrayDataTypes object = new ArrayDataTypes();
        object.setStringArray(this.stringArray);
        return object;
    }

    private static void applyCustomModifiers(PactDslJsonBody pactDslJsonBody) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    }
}

