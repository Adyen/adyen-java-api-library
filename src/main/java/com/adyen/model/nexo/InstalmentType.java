package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for InstalmentType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="InstalmentType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="DeferredInstalments"/&gt;
 *     &lt;enumeration value="EqualInstalments"/&gt;
 *     &lt;enumeration value="InequalInstalments"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "InstalmentType")
@XmlEnum
public enum InstalmentType {


    /**
     * The payment of the service or goods is deferred.
     */
    @XmlEnumValue("DeferredInstalments")
    @Schema(description = "The payment of the service or goods is deferred.")
    DEFERRED_INSTALMENTS("DeferredInstalments"),

    /**
     * The payment is split in several instalments of equal amounts.
     */
    @XmlEnumValue("EqualInstalments")
    @Schema(description = "The payment is split in several instalments of equal amounts.")
    EQUAL_INSTALMENTS("EqualInstalments"),

    /**
     * The payment is split in several instalments of different amounts.
     */
    @XmlEnumValue("InequalInstalments")
    @Schema(description = "The payment is split in several instalments of different amounts.")
    INEQUAL_INSTALMENTS("InequalInstalments");
    private final String value;

    InstalmentType(String v) {
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
     * From value instalment type.
     *
     * @param v the v
     * @return the instalment type
     */
    public static InstalmentType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
