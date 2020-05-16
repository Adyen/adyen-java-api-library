package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for TotalDetailsType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="TotalDetailsType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="POIID"/&gt;
 *     &lt;enumeration value="SaleID"/&gt;
 *     &lt;enumeration value="OperatorID"/&gt;
 *     &lt;enumeration value="ShiftNumber"/&gt;
 *     &lt;enumeration value="TotalsGroupID"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "TotalDetailsType")
@XmlEnum
public enum TotalDetailsType {


    /**
     * Give the totals result per POIID value.
     */
    POIID("POIID"),

    /**
     * Give the totals result per SaleID value.
     */
    @XmlEnumValue("SaleID")
    SALE_ID("SaleID"),

    /**
     * Give the totals result per OperatorID value.
     */
    @XmlEnumValue("OperatorID")
    OPERATOR_ID("OperatorID"),

    /**
     * Give the totals result per ShiftNumber value.
     */
    @XmlEnumValue("ShiftNumber")
    SHIFT_NUMBER("ShiftNumber"),

    /**
     * Give the totals result per TotalsGroupID value.
     */
    @XmlEnumValue("TotalsGroupID")
    TOTALS_GROUP_ID("TotalsGroupID");
    private final String value;

    TotalDetailsType(String v) {
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
     * From value total details type.
     *
     * @param v the v
     * @return the total details type
     */
    public static TotalDetailsType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
