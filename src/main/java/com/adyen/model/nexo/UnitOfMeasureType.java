package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;
import java.util.Arrays;


/**
 * <p>Java class for UnitOfMeasureType.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;simpleType name="UnitOfMeasureType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="Case"/&gt;
 *     &lt;enumeration value="Foot"/&gt;
 *     &lt;enumeration value="UKGallon"/&gt;
 *     &lt;enumeration value="USGallon"/&gt;
 *     &lt;enumeration value="Gram"/&gt;
 *     &lt;enumeration value="Inch"/&gt;
 *     &lt;enumeration value="Kilogram"/&gt;
 *     &lt;enumeration value="Pound"/&gt;
 *     &lt;enumeration value="Meter"/&gt;
 *     &lt;enumeration value="Centimetre"/&gt;
 *     &lt;enumeration value="Litre"/&gt;
 *     &lt;enumeration value="Centilitre"/&gt;
 *     &lt;enumeration value="Ounce"/&gt;
 *     &lt;enumeration value="Quart"/&gt;
 *     &lt;enumeration value="Pint"/&gt;
 *     &lt;enumeration value="Mile"/&gt;
 *     &lt;enumeration value="Kilometre"/&gt;
 *     &lt;enumeration value="Yard"/&gt;
 *     &lt;enumeration value="Other"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 */
@XmlType(name = "UnitOfMeasureType")
@XmlEnum
public enum UnitOfMeasureType {


    /**
     * Case or Carton
     */
    @XmlEnumValue("Case")
    @Schema(description = "Case or Carton")
    CASE("Case"),

    /**
     * Foot
     */
    @XmlEnumValue("Foot")
    @Schema(description = "Foot")
    FOOT("Foot"),

    /**
     * Gallon (UK)
     */
    @XmlEnumValue("UKGallon")
    @Schema(description = "Gallon (UK)")
    UK_GALLON("UKGallon"),

    /**
     * Gallon (US)
     */
    @XmlEnumValue("USGallon")
    @Schema(description = "Gallon (US)")
    US_GALLON("USGallon"),

    /**
     * Gram
     */
    @XmlEnumValue("Gram")
    @Schema(description = "Gram")
    GRAM("Gram"),

    /**
     * Inch
     */
    @XmlEnumValue("Inch")
    @Schema(description = "Inch")
    INCH("Inch"),

    /**
     * Kilogram
     */
    @XmlEnumValue("Kilogram")
    @Schema(description = "Kilogram")
    KILOGRAM("Kilogram"),

    /**
     * Pound
     */
    @XmlEnumValue("Pound")
    @Schema(description = "Pound")
    POUND("Pound"),

    /**
     * Meter
     */
    @XmlEnumValue("Meter")
    @Schema(description = "Meter")
    METER("Meter"),

    /**
     * Centimetre
     */
    @XmlEnumValue("Centimetre")
    @Schema(description = "Centimetre")
    CENTIMETRE("Centimetre"),

    /**
     * Litre
     */
    @XmlEnumValue("Litre")
    @Schema(description = "Litre")
    LITRE("Litre"),

    /**
     * Centilitre
     */
    @XmlEnumValue("Centilitre")
    @Schema(description = "Centilitre")
    CENTILITRE("Centilitre"),

    /**
     * Ounce
     */
    @XmlEnumValue("Ounce")
    @Schema(description = "Ounce")
    OUNCE("Ounce"),

    /**
     * Quart
     */
    @XmlEnumValue("Quart")
    @Schema(description = "Quart")
    QUART("Quart"),

    /**
     * Pint
     */
    @XmlEnumValue("Pint")
    @Schema(description = "Pint")
    PINT("Pint"),

    /**
     * Mile
     */
    @XmlEnumValue("Mile")
    @Schema(description = "Mile")
    MILE("Mile"),

    /**
     * Kilometre
     */
    @XmlEnumValue("Kilometre")
    @Schema(description = "Kilometre")
    KILOMETRE("Kilometre"),

    /**
     * Yard
     */
    @XmlEnumValue("Yard")
    @Schema(description = "Yard")
    YARD("Yard"),

    /**
     * Other unit than the previous one
     */
    @XmlEnumValue("Other")
    @Schema(description = "Other unit than the previous one")
    OTHER("Other");
    private final String value;

    UnitOfMeasureType(String v) {
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
     * From value unit of measure type.
     *
     * @param v the v
     * @return the unit of measure type
     */
    public static UnitOfMeasureType fromValue(String v) {
        return Arrays.stream(values()).
                filter(s -> s.value.equals(v)).
                findFirst().orElseThrow(() -> new IllegalArgumentException(v));
    }

}
