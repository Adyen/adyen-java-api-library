
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InstalmentTypeEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InstalmentTypeEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DeferredInstalments"/>
 *     &lt;enumeration value="EqualInstalments"/>
 *     &lt;enumeration value="InequalInstalments"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "InstalmentTypeEnumeration")
@XmlEnum
public enum InstalmentTypeEnumeration {


    /**
     * The payment of the service or goods is deferred.
     * 
     */
    @XmlEnumValue("DeferredInstalments")
    DEFERRED_INSTALMENTS("DeferredInstalments"),

    /**
     * The payment is split in several instalments of equal amounts.
     * 
     */
    @XmlEnumValue("EqualInstalments")
    EQUAL_INSTALMENTS("EqualInstalments"),

    /**
     * The payment is split in several instalments of different amounts.
     * 
     */
    @XmlEnumValue("InequalInstalments")
    INEQUAL_INSTALMENTS("InequalInstalments");
    private final String value;

    InstalmentTypeEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InstalmentTypeEnumeration fromValue(String v) {
        for (InstalmentTypeEnumeration c: InstalmentTypeEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
