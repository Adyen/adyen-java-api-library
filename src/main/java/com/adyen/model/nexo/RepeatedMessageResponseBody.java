
/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.nexo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * The type Repeated message response body.
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RepeatedMessageResponseBody", propOrder = {
        "loyaltyResponse",
        "paymentResponse",
        "reversalResponse",
        "storedValueResponse",
        "cardAcquisitionResponse",
        "cardReaderAPDUResponse"
})
public class RepeatedMessageResponseBody {

    /**
     * The Loyalty response.
     */
    @XmlElement(name = "LoyaltyResponse")
    protected LoyaltyResponse loyaltyResponse;
    /**
     * The Payment response.
     */
    @XmlElement(name = "PaymentResponse")
    protected PaymentResponse paymentResponse;
    /**
     * The Reversal response.
     */
    @XmlElement(name = "ReversalResponse")
    protected ReversalResponse reversalResponse;
    /**
     * The Stored value response.
     */
    @XmlElement(name = "StoredValueResponse")
    protected StoredValueResponse storedValueResponse;
    /**
     * The Card acquisition response.
     */
    @XmlElement(name = "CardAcquisitionResponse")
    protected CardAcquisitionResponse cardAcquisitionResponse;
    /**
     * The Card reader apdu response.
     */
    @XmlElement(name = "CardReaderAPDUResponse")
    protected CardReaderAPDUResponse cardReaderAPDUResponse;

    /**
     * Gets the value of the loyaltyResponse property.
     *
     * @return possible object is {@link LoyaltyResponse }
     */
    public LoyaltyResponse getLoyaltyResponse() {
        return loyaltyResponse;
    }

    /**
     * Sets the value of the loyaltyResponse property.
     *
     * @param value allowed object is              {@link LoyaltyResponse }
     */
    public void setLoyaltyResponse(LoyaltyResponse value) {
        this.loyaltyResponse = value;
    }

    /**
     * Gets the value of the paymentResponse property.
     *
     * @return possible object is {@link PaymentResponse }
     */
    public PaymentResponse getPaymentResponse() {
        return paymentResponse;
    }

    /**
     * Sets the value of the paymentResponse property.
     *
     * @param value allowed object is              {@link PaymentResponse }
     */
    public void setPaymentResponse(PaymentResponse value) {
        this.paymentResponse = value;
    }

    /**
     * Gets the value of the reversalResponse property.
     *
     * @return possible object is {@link ReversalResponse }
     */
    public ReversalResponse getReversalResponse() {
        return reversalResponse;
    }

    /**
     * Sets the value of the reversalResponse property.
     *
     * @param value allowed object is              {@link ReversalResponse }
     */
    public void setReversalResponse(ReversalResponse value) {
        this.reversalResponse = value;
    }

    /**
     * Gets the value of the storedValueResponse property.
     *
     * @return possible object is {@link StoredValueResponse }
     */
    public StoredValueResponse getStoredValueResponse() {
        return storedValueResponse;
    }

    /**
     * Sets the value of the storedValueResponse property.
     *
     * @param value allowed object is              {@link StoredValueResponse }
     */
    public void setStoredValueResponse(StoredValueResponse value) {
        this.storedValueResponse = value;
    }

    /**
     * Gets the value of the cardAcquisitionResponse property.
     *
     * @return possible object is {@link CardAcquisitionResponse }
     */
    public CardAcquisitionResponse getCardAcquisitionResponse() {
        return cardAcquisitionResponse;
    }

    /**
     * Sets the value of the cardAcquisitionResponse property.
     *
     * @param value allowed object is              {@link CardAcquisitionResponse }
     */
    public void setCardAcquisitionResponse(CardAcquisitionResponse value) {
        this.cardAcquisitionResponse = value;
    }

    /**
     * Gets the value of the cardReaderAPDUResponse property.
     *
     * @return possible object is {@link CardReaderAPDUResponse }
     */
    public CardReaderAPDUResponse getCardReaderAPDUResponse() {
        return cardReaderAPDUResponse;
    }

    /**
     * Sets the value of the cardReaderAPDUResponse property.
     *
     * @param value allowed object is              {@link CardReaderAPDUResponse }
     */
    public void setCardReaderAPDUResponse(CardReaderAPDUResponse value) {
        this.cardReaderAPDUResponse = value;
    }

}
