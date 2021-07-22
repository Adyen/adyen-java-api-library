package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Size of an area -- Usage: Contain the size of the pad area where the signature is written, given with the maximum abissa and ordinate values (X and Y). The maximum value is "FFFF".
 *
 * <p>Java class for AreaSize complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AreaSize"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="X" use="required" type="{}X" /&gt;
 *       &lt;attribute name="Y" use="required" type="{}Y" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AreaSize")
public class AreaSize {

    /**
     * The X.
     */
    @XmlElement(name = "X", required = true)
    @Schema(description = "Abscissa of a point coordinates.")
    protected String x;
    /**
     * The Y.
     */
    @XmlElement(name = "Y", required = true)
    @Schema(description = "Ordinate of a point coordinates.")
    protected String y;

    /**
     * Gets the value of the x property.
     *
     * @return possible      object is     {@link String }
     */
    public String getX() {
        return x;
    }

    /**
     * Sets the value of the x property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setX(String value) {
        this.x = value;
    }

    /**
     * Gets the value of the y property.
     *
     * @return possible      object is     {@link String }
     */
    public String getY() {
        return y;
    }

    /**
     * Sets the value of the y property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setY(String value) {
        this.y = value;
    }

}
