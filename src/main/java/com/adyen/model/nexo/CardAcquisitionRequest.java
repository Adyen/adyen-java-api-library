package com.adyen.model.nexo;

import io.swagger.v3.oas.annotations.media.Schema;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * Definition: Content of the Card Acquisition Request messageType. -- Usage: It conveys Information related to the payment and loyalty cards to read and analyse. This messageType pair is usually followed by a messageType pair (e.g. payment or loyalty) which refers to this Card Acquisition messageType pair. The Card Acquisition
 *
 * <p>Java class for CardAcquisitionRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="CardAcquisitionRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="SaleData" type="{}SaleData"/&gt;
 *         &lt;element name="CardAcquisitionTransaction" type="{}CardAcquisitionTransaction"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "CardAcquisitionRequest", propOrder = {
        "saleData",
        "cardAcquisitionTransaction"
})
public class CardAcquisitionRequest {

    /**
     * The Sale data.
     */
    @XmlElement(name = "SaleData", required = true)
    @Schema(description = "Data related to the Sale System.")
    protected SaleData saleData;
    /**
     * The Card acquisition transaction.
     */
    @XmlElement(name = "CardAcquisitionTransaction", required = true)
    @Schema(description = "Data related to the payment and loyalty card acquisition.")
    protected CardAcquisitionTransaction cardAcquisitionTransaction;

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
     * Gets the value of the cardAcquisitionTransaction property.
     *
     * @return possible      object is     {@link CardAcquisitionTransaction }
     */
    public CardAcquisitionTransaction getCardAcquisitionTransaction() {
        return cardAcquisitionTransaction;
    }

    /**
     * Sets the value of the cardAcquisitionTransaction property.
     *
     * @param value allowed object is     {@link CardAcquisitionTransaction }
     */
    public void setCardAcquisitionTransaction(CardAcquisitionTransaction value) {
        this.cardAcquisitionTransaction = value;
    }

}
