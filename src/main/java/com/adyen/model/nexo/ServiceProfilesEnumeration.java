
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ServiceProfilesEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ServiceProfilesEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Synchro"/>
 *     &lt;enumeration value="Batch"/>
 *     &lt;enumeration value="OneTimeRes"/>
 *     &lt;enumeration value="Reservation"/>
 *     &lt;enumeration value="Loyalty"/>
 *     &lt;enumeration value="StoredValue"/>
 *     &lt;enumeration value="PIN"/>
 *     &lt;enumeration value="CardReader"/>
 *     &lt;enumeration value="Sound"/>
 *     &lt;enumeration value="Communication"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ServiceProfilesEnumeration")
@XmlEnum
public enum ServiceProfilesEnumeration {


    /**
     * CardAcquisition and EnableService could be requested by the Sale System to the POI System.
     * 
     */
    @XmlEnumValue("Synchro")
    SYNCHRO("Synchro"),

    /**
     * When the POI is unable to perform transactions without the Sale system, e.g. payment at delivery, the POI provides in a Batch the performed transactions, and
     * 
     */
    @XmlEnumValue("Batch")
    BATCH("Batch"),

    /**
     * One Time Reservation service could be requested by the Sale System (as petrol distribution)
     * 
     */
    @XmlEnumValue("OneTimeRes")
    ONE_TIME_RES("OneTimeRes"),

    /**
     * The Reservation services could be requested by the Sale System
     * 
     */
    @XmlEnumValue("Reservation")
    RESERVATION("Reservation"),

    /**
     * Loyalty services could be requested by the Sale System
     * 
     */
    @XmlEnumValue("Loyalty")
    LOYALTY("Loyalty"),

    /**
     * Stored Value service could be requested by the Sale System
     * 
     */
    @XmlEnumValue("StoredValue")
    STORED_VALUE("StoredValue"),

    /**
     * The Sale System could request the PIN validation services.
     * 
     */
    PIN("PIN"),

    /**
     * The Sale System could request Card Reader services.
     * 
     */
    @XmlEnumValue("CardReader")
    CARD_READER("CardReader"),

    /**
     * To produce various forms of sounds to a customer or an operator interface.
     * 
     */
    @XmlEnumValue("Sound")
    SOUND("Sound"),

    /**
     * The POI or Sale System could request communication through the Transmit device messages exchange.
     * 
     */
    @XmlEnumValue("Communication")
    COMMUNICATION("Communication");
    private final String value;

    ServiceProfilesEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ServiceProfilesEnumeration fromValue(String v) {
        for (ServiceProfilesEnumeration c: ServiceProfilesEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
