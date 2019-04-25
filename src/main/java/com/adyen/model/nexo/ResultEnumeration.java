
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResultEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResultEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Success"/>
 *     &lt;enumeration value="Failure"/>
 *     &lt;enumeration value="Partial"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ResultEnumeration")
@XmlEnum
public enum ResultEnumeration {


    /**
     * Processing OK. Information related to the result of the processing is contained in other parts of the response message.
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

    ResultEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResultEnumeration fromValue(String v) {
        for (ResultEnumeration c: ResultEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
