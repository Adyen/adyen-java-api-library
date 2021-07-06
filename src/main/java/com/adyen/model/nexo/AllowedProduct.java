package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Product that are payable by the payment card. -- Usage: Restriction of product payable by a card.
 *
 * <p>Java class for AllowedProduct complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AllowedProduct"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ProductLabel" type="{}ProductLabel" minOccurs="0"/&gt;
 *         &lt;element name="AdditionalProductInfo" type="{}AdditionalProductInfo" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="ProductCode" use="required" type="{}ProductCode" /&gt;
 *       &lt;attribute name="EanUpc" type="{}EanUpc" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "AllowedProduct", propOrder = {
        "productLabel",
        "additionalProductInfo"
})
public class AllowedProduct {

    /**
     * The Product label.
     */
    @XmlElement(name = "ProductLabel")
    @Schema(description = "Product name of an item purchased with the transaction.")
    protected String productLabel;
    /**
     * The Additional product info.
     */
    @XmlElement(name = "AdditionalProductInfo")
    @Schema(description = "Additionl information related to the line item.")
    protected String additionalProductInfo;
    /**
     * The Product code.
     */
    @XmlElement(name = "ProductCode", required = true)
    @Schema(description = "Product code of item purchased with the transaction.")
    protected String productCode;
    /**
     * The Ean upc.
     */
    @XmlElement(name = "EanUpc")
    @Schema(description = "Standard product code of item purchased with the transaction.")
    protected String eanUpc;

    /**
     * Gets the value of the productLabel property.
     *
     * @return possible      object is     {@link String }
     */
    public String getProductLabel() {
        return productLabel;
    }

    /**
     * Sets the value of the productLabel property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setProductLabel(String value) {
        this.productLabel = value;
    }

    /**
     * Gets the value of the additionalProductInfo property.
     *
     * @return possible      object is     {@link String }
     */
    public String getAdditionalProductInfo() {
        return additionalProductInfo;
    }

    /**
     * Sets the value of the additionalProductInfo property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setAdditionalProductInfo(String value) {
        this.additionalProductInfo = value;
    }

    /**
     * Gets the value of the productCode property.
     *
     * @return possible      object is     {@link String }
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     * Sets the value of the productCode property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setProductCode(String value) {
        this.productCode = value;
    }

    /**
     * Gets the value of the eanUpc property.
     *
     * @return possible      object is     {@link String }
     */
    public String getEanUpc() {
        return eanUpc;
    }

    /**
     * Sets the value of the eanUpc property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setEanUpc(String value) {
        this.eanUpc = value;
    }

}
