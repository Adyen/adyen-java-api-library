
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ResponseModeType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="ResponseModeType">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="NotRequired"/>
 *     &lt;enumeration value="Immediate"/>
 *     &lt;enumeration value="PrintEnd"/>
 *     &lt;enumeration value="SoundEnd"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 *
 */
@XmlType(name = "ResponseModeType")
@XmlEnum
public enum ResponseModeType {


    /**
     * The Message Response is not required, except in case of error.
     *
     */
    @XmlEnumValue("NotRequired")
    NOT_REQUIRED("NotRequired"),

    /**
     * The Message Response is immediate, after taking into account the request.
     *
     */
    @XmlEnumValue("Immediate")
    IMMEDIATE("Immediate"),

    /**
     * The Print Response is required at the end of print.
     *
     */
    @XmlEnumValue("PrintEnd")
    PRINT_END("PrintEnd"),

    /**
     * The Sound Response is required at the end of play.
     *
     */
    @XmlEnumValue("SoundEnd")
    SOUND_END("SoundEnd");
    private final String value;

    ResponseModeType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ResponseModeType fromValue(String v) {
        for (ResponseModeType c: ResponseModeType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
