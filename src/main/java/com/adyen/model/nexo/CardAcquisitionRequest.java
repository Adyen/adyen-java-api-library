
package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Card Acquisition Request message. -- Usage: It conveys Information related to the payment and loyalty cards to read and analyse. This message pair is usually followed by a message pair (e.g. payment or loyalty) which refers to this Card Acquisition message pair. The Card Acquisition
 *
 * <p>Java class for CardAcquisitionRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardAcquisitionRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="SaleData" type="{}SaleData"/>
 *         &lt;element name="CardAcquisitionTransaction" type="{}CardAcquisitionTransaction"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 *
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardAcquisitionRequest", propOrder = {
    "saleData",
    "cardAcquisitionTransaction"
})
public class CardAcquisitionRequest {

    @XmlElement(name = "SaleData", required = true)
    protected SaleData saleData;
    @XmlElement(name = "CardAcquisitionTransaction", required = true)
    protected CardAcquisitionTransaction cardAcquisitionTransaction;

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
     * Gets the value of the cardAcquisitionTransaction property.
     *
     * @return
     *     possible object is
     *     {@link CardAcquisitionTransaction }
     *
     */
    public CardAcquisitionTransaction getCardAcquisitionTransaction() {
        return cardAcquisitionTransaction;
    }

    /**
     * Sets the value of the cardAcquisitionTransaction property.
     *
     * @param value
     *     allowed object is
     *     {@link CardAcquisitionTransaction }
     *
     */
    public void setCardAcquisitionTransaction(CardAcquisitionTransaction value) {
        this.cardAcquisitionTransaction = value;
    }

}
