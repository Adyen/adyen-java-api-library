package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for ForceEntryModeType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="ForceEntryModeType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="RFID"/&gt;
 *     &lt;enumeration value="Keyed"/&gt;
 *     &lt;enumeration value="Manual"/&gt;
 *     &lt;enumeration value="File"/&gt;
 *     &lt;enumeration value="Scanned"/&gt;
 *     &lt;enumeration value="MagStripe"/&gt;
 *     &lt;enumeration value="ICC"/&gt;
 *     &lt;enumeration value="SynchronousICC"/&gt;
 *     &lt;enumeration value="Tapped"/&gt;
 *     &lt;enumeration value="Contactless"/&gt;
 *     &lt;enumeration value="CheckReader"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "ForceEntryModeType")
@XmlEnum
public enum ForceEntryModeType {


    /**
     * Payment instrument information are taken from RFID
     */
    RFID("RFID"),

    /**
     * Manual key entry
     */
    @XmlEnumValue("Keyed")
    KEYED("Keyed"),

    /**
     * Reading of embossing or OCR of printed data either at time of transaction or after the event.
     */
    @XmlEnumValue("Manual")
    MANUAL("Manual"),

    /**
     * Account data on file
     */
    @XmlEnumValue("File")
    FILE("File"),

    /**
     * Scanned by a bar code reader.
     */
    @XmlEnumValue("Scanned")
    SCANNED("Scanned"),

    /**
     * Magnetic stripe
     */
    @XmlEnumValue("MagStripe")
    MAG_STRIPE("MagStripe"),

    /**
     * Contact ICC (asynchronous)
     */
    ICC("ICC"),

    /**
     * Contact ICC (synchronous)
     */
    @XmlEnumValue("SynchronousICC")
    SYNCHRONOUS_ICC("SynchronousICC"),

    /**
     * Contactless card reader Magnetic Stripe
     */
    @XmlEnumValue("Tapped")
    TAPPED("Tapped"),

    /**
     * Contactless card reader conform to ISO 14443
     */
    @XmlEnumValue("Contactless")
    CONTACTLESS("Contactless"),

    /**
     * Check Reader
     */
    @XmlEnumValue("CheckReader")
    CHECK_READER("CheckReader");
    private final String value;

    ForceEntryModeType(String v) {
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
     * From value force entry mode type.
     *
     * @param v the v
     * @return the force entry mode type
     */
    public static ForceEntryModeType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
