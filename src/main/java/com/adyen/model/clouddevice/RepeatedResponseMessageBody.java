package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/** The type Repeated message response body. */
@JsonPropertyOrder({
    "LoyaltyResponse",
    "PaymentResponse",
    "ReversalResponse",
    "StoredValueResponse",
    "CardAcquisitionResponse",
    "CardReaderAPDUResponse"
})
public class RepeatedResponseMessageBody {

  @JsonProperty("LoyaltyResponse")
  protected LoyaltyResponse loyaltyResponse;

  @JsonProperty("PaymentResponse")
  protected PaymentResponse paymentResponse;

  @JsonProperty("ReversalResponse")
  protected ReversalResponse reversalResponse;

  @JsonProperty("StoredValueResponse")
  protected StoredValueResponse storedValueResponse;

  @JsonProperty("CardAcquisitionResponse")
  protected CardAcquisitionResponse cardAcquisitionResponse;

  @JsonProperty("CardReaderAPDUResponse")
  protected CardReaderAPDUResponse cardReaderAPDUResponse;

  /**
   * Gets loyalty response.
   *
   * @return the loyalty response
   */
  public LoyaltyResponse getLoyaltyResponse() {
    return loyaltyResponse;
  }

  /**
   * Sets loyalty response.
   *
   * @param loyaltyResponse the loyalty response
   */
  public void setLoyaltyResponse(LoyaltyResponse loyaltyResponse) {
    this.loyaltyResponse = loyaltyResponse;
  }

  /**
   * Gets payment response.
   *
   * @return the payment response
   */
  public PaymentResponse getPaymentResponse() {
    return paymentResponse;
  }

  /**
   * Sets payment response.
   *
   * @param paymentResponse the payment response
   */
  public void setPaymentResponse(PaymentResponse paymentResponse) {
    this.paymentResponse = paymentResponse;
  }

  /**
   * Gets reversal response.
   *
   * @return the reversal response
   */
  public ReversalResponse getReversalResponse() {
    return reversalResponse;
  }

  /**
   * Sets reversal response.
   *
   * @param reversalResponse the reversal response
   */
  public void setReversalResponse(ReversalResponse reversalResponse) {
    this.reversalResponse = reversalResponse;
  }

  /**
   * Gets stored value response.
   *
   * @return the stored value response
   */
  public StoredValueResponse getStoredValueResponse() {
    return storedValueResponse;
  }

  /**
   * Sets stored value response.
   *
   * @param storedValueResponse the stored value response
   */
  public void setStoredValueResponse(StoredValueResponse storedValueResponse) {
    this.storedValueResponse = storedValueResponse;
  }

  /**
   * Gets card acquisition response.
   *
   * @return the card acquisition response
   */
  public CardAcquisitionResponse getCardAcquisitionResponse() {
    return cardAcquisitionResponse;
  }

  /**
   * Sets card acquisition response.
   *
   * @param cardAcquisitionResponse the card acquisition response
   */
  public void setCardAcquisitionResponse(CardAcquisitionResponse cardAcquisitionResponse) {
    this.cardAcquisitionResponse = cardAcquisitionResponse;
  }

  /**
   * Gets card reader apdu response.
   *
   * @return the card reader apdu response
   */
  public CardReaderAPDUResponse getCardReaderAPDUResponse() {
    return cardReaderAPDUResponse;
  }

  /**
   * Sets card reader apdu response.
   *
   * @param cardReaderAPDUResponse the card reader apdu response
   */
  public void setCardReaderAPDUResponse(CardReaderAPDUResponse cardReaderAPDUResponse) {
    this.cardReaderAPDUResponse = cardReaderAPDUResponse;
  }
}