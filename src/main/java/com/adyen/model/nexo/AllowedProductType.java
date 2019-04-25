
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Product that are payable by the payment card. -- Usage: Restriction of product payable by a card.
 * 
 * <p>Java class for AllowedProductType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="AllowedProductType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ProductLabel" type="{}ProductLabelType" minOccurs="0"/>
 *         &lt;element name="AdditionalProductInfo" type="{}AdditionalProductInfoType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="ProductCode" use="required" type="{}ProductCodeType" />
 *       &lt;attribute name="EanUpc" type="{}EanUpcType" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllowedProductType", propOrder = {
    "productLabel",
    "additionalProductInfo"
})
public class AllowedProductType {

    @XmlElement(name = "ProductLabel")
    protected String productLabel;
    @XmlElement(name = "AdditionalProductInfo")
    protected String additionalProductInfo;
    @XmlAttribute(name = "ProductCode", required = true)
    protected String productCode;
    @XmlAttribute(name = "EanUpc")
    protected String eanUpc;

    /**
     * Gets the value of the productLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductLabel() {
        return productLabel;
    }

    /**
     * Sets the value of the productLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductLabel(String value) {
        this.productLabel = value;
    }

    /**
     * Gets the value of the additionalProductInfo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAdditionalProductInfo() {
        return additionalProductInfo;
    }

    /**
     * Sets the value of the additionalProductInfo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAdditionalProductInfo(String value) {
        this.additionalProductInfo = value;
    }

    /**
     * Gets the value of the productCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the eanUpc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEanUpc() {
        return eanUpc;
    }

    /**
     * Sets the value of the eanUpc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEanUpc(String value) {
        this.eanUpc = value;
    }

}
