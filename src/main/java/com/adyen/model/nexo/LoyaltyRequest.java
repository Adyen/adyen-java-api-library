
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
 * <p>Java class for LoyaltyRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SaleData" type="{}SaleData"/>
 *         &lt;element name="LoyaltyTransaction" type="{}LoyaltyTransaction"/>
 *         &lt;element name="LoyaltyData" type="{}LoyaltyData" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyRequest", propOrder = {
    "saleData",
    "loyaltyTransaction",
    "loyaltyData"
})
public class LoyaltyRequest {

    @XmlElement(name = "SaleData", required = true)
    protected SaleData saleData;
    @XmlElement(name = "LoyaltyTransaction", required = true)
    protected LoyaltyTransaction loyaltyTransaction;
    @XmlElement(name = "LoyaltyData")
    protected List<LoyaltyData> loyaltyData;

    /**
     * Gets the value of the saleData property.
     *
     * @return
     *     possible object is
     *     {@link SaleData }
     *
     */
    public SaleData getSaleData() {
        return saleData;
    }

    /**
     * Sets the value of the saleData property.
     *
     * @param value
     *     allowed object is
     *     {@link SaleData }
     *
     */
    public void setSaleData(SaleData value) {
        this.saleData = value;
    }

    /**
     * Gets the value of the loyaltyTransaction property.
     *
     * @return
     *     possible object is
     *     {@link LoyaltyTransaction }
     *
     */
    public LoyaltyTransaction getLoyaltyTransaction() {
        return loyaltyTransaction;
    }

    /**
     * Sets the value of the loyaltyTransaction property.
     *
     * @param value
     *     allowed object is
     *     {@link LoyaltyTransaction }
     *
     */
    public void setLoyaltyTransaction(LoyaltyTransaction value) {
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
     * {@link LoyaltyData }
     *
     *
     */
    public List<LoyaltyData> getLoyaltyData() {
        if (loyaltyData == null) {
            loyaltyData = new ArrayList<LoyaltyData>();
        }
        return this.loyaltyData;
    }

}
