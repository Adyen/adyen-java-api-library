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
 * &lt;complexType name="OutputBarcode"&gt;
 *   &lt;simpleContent&gt;
 *     &lt;extension base="TextString"&gt;
 *       &lt;attribute name="Barcode" type="{}BarcodeType" default="EAN13" /&gt;
 *     &lt;/extension&gt;
 *   &lt;/simpleContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OutputBarcode", propOrder = {
        "value"
})
public class OutputBarcode {

    /**
     * The Value.
     */
    @XmlValue
    protected String value;
    /**
     * The Barcode.
     */
    @XmlAttribute(name = "BarcodeType")
    protected BarcodeType barcodeType;

    /**
     * Gets the value of the value property.
     *
     * @return possible      object is     {@link String }
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the barcodeType property.
     *
     * @return possible      object is     {@link BarcodeType }
     */
    public BarcodeType getBarcodeType() {
        if (barcodeType == null) {
            return BarcodeType.EAN_13;
        } else {
            return barcodeType;
        }
    }

    /**
     * Sets the value of the barcodeType property.
     *
     * @param value allowed object is     {@link BarcodeType }
     */
    public void setBarcodeType(BarcodeType value) {
        this.barcodeType = value;
    }

}
