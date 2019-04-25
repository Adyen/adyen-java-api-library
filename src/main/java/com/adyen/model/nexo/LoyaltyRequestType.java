
package com.adyen.model.nexo;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Loyalty Request message. -- Usage: It conveys Information related to the Loyalty transaction to process
 * 
 * <p>Java class for LoyaltyRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="LoyaltyRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SaleData" type="{}SaleDataType"/>
 *         &lt;element name="LoyaltyTransaction" type="{}LoyaltyTransactionType"/>
 *         &lt;element name="LoyaltyData" type="{}LoyaltyDataType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyRequestType", propOrder = {
    "saleData",
    "loyaltyTransaction",
    "loyaltyData"
})
public class LoyaltyRequestType {

    @XmlElement(name = "SaleData", required = true)
    protected SaleDataType saleData;
    @XmlElement(name = "LoyaltyTransaction", required = true)
    protected LoyaltyTransactionType loyaltyTransaction;
    @XmlElement(name = "LoyaltyData")
    protected List<LoyaltyDataType> loyaltyData;

    /**
     * Gets the value of the saleData property.
     * 
     * @return
     *     possible object is
     *     {@link SaleDataType }
     *     
     */
    public SaleDataType getSaleData() {
        return saleData;
    }

    /**
     * Sets the value of the saleData property.
     * 
     * @param value
     *     allowed object is
     *     {@link SaleDataType }
     *     
     */
    public void setSaleData(SaleDataType value) {
        this.saleData = value;
    }

    /**
     * Gets the value of the loyaltyTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link LoyaltyTransactionType }
     *     
     */
    public LoyaltyTransactionType getLoyaltyTransaction() {
        return loyaltyTransaction;
    }

    /**
     * Sets the value of the loyaltyTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoyaltyTransactionType }
     *     
     */
    public void setLoyaltyTransaction(LoyaltyTransactionType value) {
        this.loyaltyTransaction = value;
    }

    /**
     * Gets the value of the loyaltyData property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyaltyData property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyaltyData().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyDataType }
     * 
     * 
     */
    public List<LoyaltyDataType> getLoyaltyData() {
        if (loyaltyData == null) {
            loyaltyData = new ArrayList<LoyaltyDataType>();
        }
        return this.loyaltyData;
    }

}
