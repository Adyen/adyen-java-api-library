package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the requested Message Response. */
@JsonPropertyOrder({
    "MessageHeader",
    "LoyaltyResponse",
    "PaymentResponse",
    "ReversalResponse",
    "StoredValueResponse",
    "CardAcquisitionResponse",
    "CardReaderAPDUResponse"
})
public class RepeatedMessageResponse {

  @JsonProperty("MessageHeader")
  @Schema(description = "Message header of the Sale to POI protocol message.")
  protected MessageHeader messageHeader;

  @JsonProperty("LoyaltyResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  protected LoyaltyResponse loyaltyResponse;

  @JsonProperty("PaymentResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  protected PaymentResponse paymentResponse;

  @JsonProperty("ReversalResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  protected ReversalResponse reversalResponse;

  @JsonProperty("StoredValueResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  protected StoredValueResponse storedValueResponse;

  @JsonProperty("CardAcquisitionResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  protected CardAcquisitionResponse cardAcquisitionResponse;

  @JsonProperty("CardReaderAPDUResponse")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  protected CardReaderAPDUResponse cardReaderAPDUResponse;

  /**
   * Gets message header.
   *
   * @return the message header
   */
  public MessageHeader getMessageHeader() {
    return messageHeader;
  }

  /**
   * Sets message header.
   *
   * @param messageHeader the message header
   */
  public void setMessageHeader(MessageHeader messageHeader) {
    this.messageHeader = messageHeader;
  }

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