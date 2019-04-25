
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for UnitOfMeasureEnumeration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="UnitOfMeasureEnumeration">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="Case"/>
 *     &lt;enumeration value="Foot"/>
 *     &lt;enumeration value="UKGallon"/>
 *     &lt;enumeration value="USGallon"/>
 *     &lt;enumeration value="Gram"/>
 *     &lt;enumeration value="Inch"/>
 *     &lt;enumeration value="Kilogram"/>
 *     &lt;enumeration value="Pound"/>
 *     &lt;enumeration value="Meter"/>
 *     &lt;enumeration value="Centimetre"/>
 *     &lt;enumeration value="Litre"/>
 *     &lt;enumeration value="Centilitre"/>
 *     &lt;enumeration value="Ounce"/>
 *     &lt;enumeration value="Quart"/>
 *     &lt;enumeration value="Pint"/>
 *     &lt;enumeration value="Mile"/>
 *     &lt;enumeration value="Kilometre"/>
 *     &lt;enumeration value="Yard"/>
 *     &lt;enumeration value="Other"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "UnitOfMeasureEnumeration")
@XmlEnum
public enum UnitOfMeasureEnumeration {


    /**
     * Case or Carton
     * 
     */
    @XmlEnumValue("Case")
    CASE("Case"),

    /**
     * Foot
     * 
     */
    @XmlEnumValue("Foot")
    FOOT("Foot"),

    /**
     * Gallon (UK)
     * 
     */
    @XmlEnumValue("UKGallon")
    UK_GALLON("UKGallon"),

    /**
     * Gallon (US)
     * 
     */
    @XmlEnumValue("USGallon")
    US_GALLON("USGallon"),

    /**
     * Gram
     * 
     */
    @XmlEnumValue("Gram")
    GRAM("Gram"),

    /**
     * Inch
     * 
     */
    @XmlEnumValue("Inch")
    INCH("Inch"),

    /**
     * Kilogram
     * 
     */
    @XmlEnumValue("Kilogram")
    KILOGRAM("Kilogram"),

    /**
     * Pound
     * 
     */
    @XmlEnumValue("Pound")
    POUND("Pound"),

    /**
     * Meter
     * 
     */
    @XmlEnumValue("Meter")
    METER("Meter"),

    /**
     * Centimetre
     * 
     */
    @XmlEnumValue("Centimetre")
    CENTIMETRE("Centimetre"),

    /**
     * Litre
     * 
     */
    @XmlEnumValue("Litre")
    LITRE("Litre"),

    /**
     * Centilitre
     * 
     */
    @XmlEnumValue("Centilitre")
    CENTILITRE("Centilitre"),

    /**
     * Ounce
     * 
     */
    @XmlEnumValue("Ounce")
    OUNCE("Ounce"),

    /**
     * Quart
     * 
     */
    @XmlEnumValue("Quart")
    QUART("Quart"),

    /**
     * Pint
     * 
     */
    @XmlEnumValue("Pint")
    PINT("Pint"),

    /**
     * Mile
     * 
     */
    @XmlEnumValue("Mile")
    MILE("Mile"),

    /**
     * Kilometre
     * 
     */
    @XmlEnumValue("Kilometre")
    KILOMETRE("Kilometre"),

    /**
     * Yard
     * 
     */
    @XmlEnumValue("Yard")
    YARD("Yard"),

    /**
     * Other unit than the previous one
     * 
     */
    @XmlEnumValue("Other")
    OTHER("Other");
    private final String value;

    UnitOfMeasureEnumeration(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static UnitOfMeasureEnumeration fromValue(String v) {
        for (UnitOfMeasureEnumeration c: UnitOfMeasureEnumeration.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
