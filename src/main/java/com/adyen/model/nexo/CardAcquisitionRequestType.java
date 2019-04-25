
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Card Acquisition Request message. -- Usage: It conveys Information related to the payment and loyalty cards to read and analyse. This message pair is usually followed by a message pair (e.g. payment or loyalty) which refers to this Card Acquisition message pair. The Card Acquisition
 * 
 * <p>Java class for CardAcquisitionRequestType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="CardAcquisitionRequestType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SaleData" type="{}SaleDataType"/>
 *         &lt;element name="CardAcquisitionTransaction" type="{}CardAcquisitionTransactionType"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardAcquisitionRequestType", propOrder = {
    "saleData",
    "cardAcquisitionTransaction"
})
public class CardAcquisitionRequestType {

    @XmlElement(name = "SaleData", required = true)
    protected SaleDataType saleData;
    @XmlElement(name = "CardAcquisitionTransaction", required = true)
    protected CardAcquisitionTransactionType cardAcquisitionTransaction;

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
     * Gets the value of the cardAcquisitionTransaction property.
     * 
     * @return
     *     possible object is
     *     {@link CardAcquisitionTransactionType }
     *     
     */
    public CardAcquisitionTransactionType getCardAcquisitionTransaction() {
        return cardAcquisitionTransaction;
    }

    /**
     * Sets the value of the cardAcquisitionTransaction property.
     * 
     * @param value
     *     allowed object is
     *     {@link CardAcquisitionTransactionType }
     *     
     */
    public void setCardAcquisitionTransaction(CardAcquisitionTransactionType value) {
        this.cardAcquisitionTransaction = value;
    }

}
