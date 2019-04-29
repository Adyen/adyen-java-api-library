
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResultType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Success"/>
 *     &lt;enumeration value="Failure"/>
 *     &lt;enumeration value="Partial"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "ResultType")
@XmlEnum
public enum ResultType {


    /**
     * Processing OK. Information related to the result of the processing is contained in other parts of the response messageType.
     *
     */
    @XmlEnumValue("Success")
    SUCCESS("Success"),

    /**
     * ErrorCondition
     *
     */
    @XmlEnumValue("Failure")
    FAILURE("Failure"),

    /**
     * The transaction has been processed successfully, but the success is not complete (e.g. only a partial amount is available for the payment, the format to be
     *
     */
    @XmlEnumValue("Partial")
    PARTIAL("Partial");
    private final String value;

    ResultType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResultType fromValue(String v) {
        for (ResultType c: ResultType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
