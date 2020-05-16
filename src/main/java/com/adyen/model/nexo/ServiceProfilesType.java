package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for ServiceProfilesType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ServiceProfilesType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Synchro"/&gt;
 *     &lt;enumeration value="Batch"/&gt;
 *     &lt;enumeration value="OneTimeRes"/&gt;
 *     &lt;enumeration value="Reservation"/&gt;
 *     &lt;enumeration value="Loyalty"/&gt;
 *     &lt;enumeration value="StoredValue"/&gt;
 *     &lt;enumeration value="PIN"/&gt;
 *     &lt;enumeration value="CardReader"/&gt;
 *     &lt;enumeration value="Sound"/&gt;
 *     &lt;enumeration value="Communication"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ServiceProfilesType")
@XmlEnum
public enum ServiceProfilesType {


    /**
     * CardAcquisition and EnableService could be requested by the Sale System to the POI System.
     */
    @XmlEnumValue("Synchro")
    SYNCHRO("Synchro"),

    /**
     * When the POI is unable to perform transactions without the Sale system, e.g. payment at delivery, the POI provides in a Batch the performed transactions, and
     */
    @XmlEnumValue("Batch")
    BATCH("Batch"),

    /**
     * One Time Reservation service could be requested by the Sale System (as petrol distribution)
     */
    @XmlEnumValue("OneTimeRes")
    ONE_TIME_RES("OneTimeRes"),

    /**
     * The Reservation services could be requested by the Sale System
     */
    @XmlEnumValue("Reservation")
    RESERVATION("Reservation"),

    /**
     * Loyalty services could be requested by the Sale System
     */
    @XmlEnumValue("Loyalty")
    LOYALTY("Loyalty"),

    /**
     * Stored Value service could be requested by the Sale System
     */
    @XmlEnumValue("StoredValue")
    STORED_VALUE("StoredValue"),

    /**
     * The Sale System could request the PIN validation services.
     */
    PIN("PIN"),

    /**
     * The Sale System could request Card Reader services.
     */
    @XmlEnumValue("CardReader")
    CARD_READER("CardReader"),

    /**
     * To produce various forms of sounds to a customer or an operator interface.
     */
    @XmlEnumValue("Sound")
    SOUND("Sound"),

    /**
     * The POI or Sale System could request communication through the Transmit device messages exchange.
     */
    @XmlEnumValue("Communication")
    COMMUNICATION("Communication");
    private final String value;

    ServiceProfilesType(String v) {
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
     * From value service profiles type.
     *
     * @param v the v
     * @return the service profiles type
     */
    public static ServiceProfilesType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
