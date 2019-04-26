
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InstalmentType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="InstalmentType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="DeferredInstalments"/>
 *     &lt;enumeration value="EqualInstalments"/>
 *     &lt;enumeration value="InequalInstalments"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "InstalmentType")
@XmlEnum
public enum InstalmentType {


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

    InstalmentType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static InstalmentType fromValue(String v) {
        for (InstalmentType c: InstalmentType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
