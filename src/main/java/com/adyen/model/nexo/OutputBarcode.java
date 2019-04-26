
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * Definition: BarCode content to display or print. -- Usage: Various usage of barcode
 *
 * <p>Java class for OutputBarcode complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OutputBarcode">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;>TextString">
 *       &lt;attribute name="Barcode" type="{}BarcodeType" default="EAN13" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputBarcode", propOrder = {
    "value"
})
public class OutputBarcode {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "Barcode")
    protected BarcodeType barcode;

    /**
     * Gets the value of the value property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the barcode property.
     *
     * @return
     *     possible object is
     *     {@link BarcodeType }
     *
     */
    public BarcodeType getBarcode() {
        if (barcode == null) {
            return BarcodeType.EAN_13;
        } else {
            return barcode;
        }
    }

    /**
     * Sets the value of the barcode property.
     *
     * @param value
     *     allowed object is
     *     {@link BarcodeType }
     *
     */
    public void setBarcode(BarcodeType value) {
        this.barcode = value;
    }

}
