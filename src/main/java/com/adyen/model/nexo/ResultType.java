package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for ResultType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ResultType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Success"/&gt;
 *     &lt;enumeration value="Failure"/&gt;
 *     &lt;enumeration value="Partial"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ResultType")
@XmlEnum
public enum ResultType {


    /**
     * Processing OK. Information related to the result of the processing is contained in other parts of the response messageType.
     */
    @XmlEnumValue("Success")
    @Schema(description = "Processing OK. Information related to the result of the processing is contained in other parts of the response message.")
    SUCCESS("Success"),

    /**
     * ErrorCondition
     */
    @XmlEnumValue("Failure")
    @Schema(description = "ErrorCondition")
    FAILURE("Failure"),

    /**
     * The transaction has been processed successfully, but the success is not complete (e.g. only a partial amount is available for the payment, the format to be
     */
    @XmlEnumValue("Partial")
    @Schema(description = "The transaction has been processed successfully, but the success is not complete (e.g. only a partial amount is available for the payment, the format to be")
    PARTIAL("Partial");
    private final String value;

    ResultType(String v) {
        value = v;
    }

    /**
     * Value string.
     *
     * @return the string
     */
    public String value() {
        return value;
    }

    /**
     * From value result type.
     *
     * @param v the v
     * @return the result type
     */
    public static ResultType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
