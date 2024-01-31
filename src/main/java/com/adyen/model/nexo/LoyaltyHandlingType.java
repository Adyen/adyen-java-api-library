package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for LoyaltyHandlingType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="LoyaltyHandlingType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Forbidden"/&gt;
 *     &lt;enumeration value="Processed"/&gt;
 *     &lt;enumeration value="Allowed"/&gt;
 *     &lt;enumeration value="Proposed"/&gt;
 *     &lt;enumeration value="Required"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "LoyaltyHandlingType")
@XmlEnum
public enum LoyaltyHandlingType {


    /**
     * No loyalty card to read and loyalty transaction to process. Any attempt to enter a pure loyalty card is rejected.
     */
    @XmlEnumValue("Forbidden")
    @Schema(description = "No loyalty card to read and loyalty transaction to process. Any attempt to enter a pure loyalty card is rejected.")
    FORBIDDEN("Forbidden"),

    /**
     * The loyalty transaction is already processed, no loyalty card or loyalty transaction to process.
     */
    @XmlEnumValue("Processed")
    @Schema(description = "The loyalty transaction is already processed, no loyalty card or loyalty transaction to process.")
    PROCESSED("Processed"),

    /**
     * The loyalty is accepted, but the POI has not to require or ask a loyalty card. The loyalty is involved by the payment card (e.g. an hybrid or linked card).
     */
    @XmlEnumValue("Allowed")
    @Schema(description = "The loyalty is accepted, but the POI has not to require or ask a loyalty card. The loyalty is involved by the payment card (e.g. an hybrid or linked card).")
    ALLOWED("Allowed"),

    /**
     * The loyalty is accepted, and the POI has to ask a loyalty card. If the Customer does not enter a loyalty card, no loyalty transaction is realised.
     */
    @XmlEnumValue("Proposed")
    @Schema(description = "The loyalty is accepted, and the POI has to ask a loyalty card. If the Customer does not enter a loyalty card, no loyalty transaction is realised.")
    PROPOSED("Proposed"),

    /**
     * The loyalty is required, and the POI refuses the processing of the messageType request if the cardholder does not entre a loyalty card
     */
    @XmlEnumValue("Required")
    @Schema(description = "The loyalty is required, and the POI refuses the processing of the message request if the cardholder does not entre a loyalty card")
    REQUIRED("Required");
    private final String value;

    LoyaltyHandlingType(String v) {
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
     * From value loyalty handling type.
     *
     * @param v the v
     * @return the loyalty handling type
     */
    public static LoyaltyHandlingType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
