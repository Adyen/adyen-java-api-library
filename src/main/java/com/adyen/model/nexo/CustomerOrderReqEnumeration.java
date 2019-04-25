
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for CustomerOrderReqEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="CustomerOrderReqEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Open"/>
 *     &lt;enumeration value="Closed"/>
 *     &lt;enumeration value="Both"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "CustomerOrderReqEnumeration")
@XmlEnum
public enum CustomerOrderReqEnumeration {


    /**
     * Customer order not completed.
     * 
     */
    @XmlEnumValue("Open")
    OPEN("Open"),

    /**
     * Completed customer orders.
     * 
     */
    @XmlEnumValue("Closed")
    CLOSED("Closed"),

    /**
     * All type of CustomerOrder should be listed
     * 
     */
    @XmlEnumValue("Both")
    BOTH("Both");
    private final String value;

    CustomerOrderReqEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CustomerOrderReqEnumeration fromValue(String v) {
        for (CustomerOrderReqEnumeration c: CustomerOrderReqEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
