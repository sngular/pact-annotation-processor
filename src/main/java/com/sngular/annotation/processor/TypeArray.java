package com.sngular.annotation.processor;

import java.util.Arrays;
import java.util.Optional;

/** Represents an enum of array types.
 * @author Miguel Angel Escobar
 * @version 1.0
 */
public enum TypeArray {

    /**
     * An array type {@code String[]}.
     */
    STRING_ARRAY("","String[]"),
    /**
     * An array type {@code boolean[]}.
     */
    BOOLEAN_ARRAY("boolean[]","Boolean[]"),

    /**
     * An array type {@code byte[]}.
     */
    BYTE_ARRAY("byte[]","Byte[]"),

    /**
     * An array type {@code short[]}.
     */
    SHORT_ARRAY("short[]","Short[]"),

    /**
     * An array type {@code int[]}.
     */
    INT_ARRAY("int[]","Integer[]"),

    /**
     * An array type {@code long[]}.
     */
    LONG_ARRAY("long[]","Long[]"),

    /**
     * An array type {@code char[]}.
     */
    CHAR_ARRAY("char[]","Character[]"),

    /**
     * An array type {@code float[]}.
     */
    FLOAT_ARRAY("float[]","Float[]"),

    /**
     * An array type {@code double[]}.
     */
    DOUBLE_ARRAY("double[]","Double[]"),

    /**
     * An array type {@code BigInteger[]}.
     */
    BIG_INTEGER_ARRAY("","BigInteger[]"),

    /**
     * An array type {@code BigDecimal[]}.
     */
    BIG_DECIMAL_ARRAY("","BigDecimal[]"),

    /**
     * An array type {@code ZonedDateTime[]}.
     */
    ZONED_DATE_TIME_ARRAY("","ZonedDateTime[]"),

    /**
     * An array type {@code Date[]}.
     */
    DATE_ARRAY("","Date[]");

    private String primitiveName;
    private String objectName;

    TypeArray(String primitiveName, String objectName) {
        this.primitiveName = primitiveName;
        this.objectName = objectName;
    }
    /**
     * {@return primitive name}
     */
    public String getPrimitiveName() {
        return primitiveName;
    }

    /**
     * {@return object name}
     */
    public String getobjectName() {
        return objectName;
    }

    /**
     * {@return TypeArray value that matches typeString}
     */
    public static TypeArray get(String typeString) {
        Optional<TypeArray> op = Arrays.stream(TypeArray.values())
                .filter(typeArray -> typeArray.primitiveName.equals(typeString)
                        || typeArray.objectName.equals(typeString))
                .findFirst();

        return op.get();
    }
}
