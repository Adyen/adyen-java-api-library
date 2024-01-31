package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Stored Value Request messageType. -- Usage: It conveys Information related to the Stored Value transaction to process
 *
 * <p>Java class for StoredValueRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="StoredValueRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SaleData" type="{}SaleData"/&gt;
 *         &lt;element name="StoredValueData" type="{}StoredValueData" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *       &lt;attribute name="CustomerLanguage" type="{}ISOLanguage2A" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "StoredValueRequest", propOrder = {
        "saleData",
        "storedValueData"
})
public class StoredValueRequest {

    /**
     * The Sale data.
     */
    @XmlElement(name = "SaleData", required = true)
    @Schema(description = "Data related to the Sale System.")
    protected SaleData saleData;
    /**
     * The Stored value data.
     */
    @XmlElement(name = "StoredValueData", required = true)
    @Schema(description = "Data related to the stored value card.")
    protected List<StoredValueData> storedValueData;
    /**
     * The Customer language.
     */
    @XmlElement(name = "CustomerLanguage")
    @Schema(description = "Language of the Customer --Rule: If the language is selected by the Sale System before the request to the POI.")
    protected String customerLanguage;

    /**
     * Gets the value of the saleData property.
     *
     * @return possible      object is     {@link SaleData }
     */
    public SaleData getSaleData() {
        return saleData;
    }

    /**
     * Sets the value of the saleData property.
     *
     * @param value allowed object is     {@link SaleData }
     */
    public void setSaleData(SaleData value) {
        this.saleData = value;
    }

    /**
     * Gets the value of the storedValueData property.
     * <p>
     * <p>
     * <p>
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the storedValueData property.
     * <p>
     * <p>
     * <p>
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getStoredValueData().add(newItem);
     * </pre>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StoredValueData }
     *
     * @return the stored value data
     */
    public List<StoredValueData> getStoredValueData() {
        if (storedValueData == null) {
            storedValueData = new ArrayList<>();
        }
        return this.storedValueData;
    }

    /**
     * Gets the value of the customerLanguage property.
     *
     * @return possible      object is     {@link String }
     */
    public String getCustomerLanguage() {
        return customerLanguage;
    }

    /**
     * Sets the value of the customerLanguage property.
     *
     * @param value allowed object is     {@link String }
     */
    public void setCustomerLanguage(String value) {
        this.customerLanguage = value;
    }

}
