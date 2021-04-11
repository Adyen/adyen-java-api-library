package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for IdentificationSupportType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="IdentificationSupportType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="NoCard"/&gt;
 *     &lt;enumeration value="LoyaltyCard"/&gt;
 *     &lt;enumeration value="HybridCard"/&gt;
 *     &lt;enumeration value="LinkedCard"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "IdentificationSupportType")
@XmlEnum
public enum IdentificationSupportType {


    /**
     * The identification is not found on a card
     */
    @XmlEnumValue("NoCard")
    @Schema(description = "The identification is not found on a card")
    NO_CARD("NoCard"),

    /**
     * The identification is on a card dedicated to this loyalty brand.
     */
    @XmlEnumValue("LoyaltyCard")
    @Schema(description = "The identification is on a card dedicated to this loyalty brand.")
    LOYALTY_CARD("LoyaltyCard"),

    /**
     * The identification is on a card which might be used both for the loyalty and the payment.
     */
    @XmlEnumValue("HybridCard")
    @Schema(description = "The identification is on a card which might be used both for the loyalty and the payment.")
    HYBRID_CARD("HybridCard"),

    /**
     * The loyalty account is implicitly attached to the payment card. This is usually detected by the loyalty Acquirer.
     */
    @XmlEnumValue("LinkedCard")
    @Schema(description = "The loyalty account is implicitly attached to the payment card. This is usually detected by the loyalty Acquirer.")
    LINKED_CARD("LinkedCard");
    private final String value;

    IdentificationSupportType(String v) {
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
     * From value identification support type.
     *
     * @param v the v
     * @return the identification support type
     */
    public static IdentificationSupportType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
