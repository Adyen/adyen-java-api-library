package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;


/**
 * Definition: Content of the Loyalty Request messageType. -- Usage: It conveys Information related to the Loyalty transaction to process
 *
 * <p>Java class for LoyaltyRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LoyaltyRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SaleData" type="{}SaleData"/&gt;
 *         &lt;element name="LoyaltyTransaction" type="{}LoyaltyTransaction"/&gt;
 *         &lt;element name="LoyaltyData" type="{}LoyaltyData" maxOccurs="unbounded" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "LoyaltyRequest", propOrder = {
        "saleData",
        "loyaltyTransaction",
        "loyaltyData"
})
public class LoyaltyRequest {

    /**
     * The Sale data.
     */
    @XmlElement(name = "SaleData", required = true)
    protected SaleData saleData;
    /**
     * The Loyalty transaction.
     */
    @XmlElement(name = "LoyaltyTransaction", required = true)
    protected LoyaltyTransaction loyaltyTransaction;
    /**
     * The Loyalty data.
     */
    @XmlElement(name = "LoyaltyData")
    protected List<LoyaltyData> loyaltyData;

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
     * Gets the value of the loyaltyTransaction property.
     *
     * @return possible      object is     {@link LoyaltyTransaction }
     */
    public LoyaltyTransaction getLoyaltyTransaction() {
        return loyaltyTransaction;
    }

    /**
     * Sets the value of the loyaltyTransaction property.
     *
     * @param value allowed object is     {@link LoyaltyTransaction }
     */
    public void setLoyaltyTransaction(LoyaltyTransaction value) {
        this.loyaltyTransaction = value;
    }

    /**
     * Gets the value of the loyaltyData property.
     *
     *
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the loyaltyData property.
     *
     *
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLoyaltyData().add(newItem);
     * </pre>
     *
     *
     *
     * Objects of the following type(s) are allowed in the list
     * {@link LoyaltyData }
     *
     * @return the loyalty data
     */
    public List<LoyaltyData> getLoyaltyData() {
        if (loyaltyData == null) {
            loyaltyData = new ArrayList<>();
        }
        return this.loyaltyData;
    }

}
