
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServicesEnabledEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServicesEnabledEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CardAcquisition"/>
 *     &lt;enumeration value="Payment"/>
 *     &lt;enumeration value="Loyalty"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ServicesEnabledEnumeration")
@XmlEnum
public enum ServicesEnabledEnumeration {


    /**
     * Enable the POI to process a card acquisition before the request of the Sale System (e.g. the same processing than the CardAcquisition command, but no more)
     * 
     */
    @XmlEnumValue("CardAcquisition")
    CARD_ACQUISITION("CardAcquisition"),

    /**
     * Enable the POI to start a payment transaction before the request of the Sale System (e.g. the same processing than the Payment command)
     * 
     */
    @XmlEnumValue("Payment")
    PAYMENT("Payment"),

    /**
     * Enable the POI to start a loyalty transaction before the request of the Sale System (e.g. the same processing than the Loyalty command)
     * 
     */
    @XmlEnumValue("Loyalty")
    LOYALTY("Loyalty");
    private final String value;

    ServicesEnabledEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServicesEnabledEnumeration fromValue(String v) {
        for (ServicesEnabledEnumeration c: ServicesEnabledEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
