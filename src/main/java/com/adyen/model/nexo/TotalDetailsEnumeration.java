
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for TotalDetailsEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="TotalDetailsEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="POIID"/>
 *     &lt;enumeration value="SaleID"/>
 *     &lt;enumeration value="OperatorID"/>
 *     &lt;enumeration value="ShiftNumber"/>
 *     &lt;enumeration value="TotalsGroupID"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "TotalDetailsEnumeration")
@XmlEnum
public enum TotalDetailsEnumeration {


    /**
     * Give the totals result per POIID value.
     * 
     */
    POIID("POIID"),

    /**
     * Give the totals result per SaleID value.
     * 
     */
    @XmlEnumValue("SaleID")
    SALE_ID("SaleID"),

    /**
     * Give the totals result per OperatorID value.
     * 
     */
    @XmlEnumValue("OperatorID")
    OPERATOR_ID("OperatorID"),

    /**
     * Give the totals result per ShiftNumber value.
     * 
     */
    @XmlEnumValue("ShiftNumber")
    SHIFT_NUMBER("ShiftNumber"),

    /**
     * Give the totals result per TotalsGroupID value.
     * 
     */
    @XmlEnumValue("TotalsGroupID")
    TOTALS_GROUP_ID("TotalsGroupID");
    private final String value;

    TotalDetailsEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static TotalDetailsEnumeration fromValue(String v) {
        for (TotalDetailsEnumeration c: TotalDetailsEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
