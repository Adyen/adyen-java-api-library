package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class TransactionToPerform {

  /** The Payment request. */
  @JsonProperty("PaymentRequest")
  @Schema(description = "Data related to the Payment transaction request.")
  protected PaymentRequest paymentRequest;

  /** The Loyalty request. */
  @JsonProperty("LoyaltyRequest")
  @Schema(description = "Data related to the Loyalty transaction request.")
  protected LoyaltyRequest loyaltyRequest;

  /** The Reversal request. */
  @JsonProperty("ReversalRequest")
  @Schema(description = "Data related to the Reveraal transaction request.")
  protected ReversalRequest reversalRequest;

  /**
   * Gets the value of the paymentRequest property.
   *
   * @return possible object is {@link PaymentRequest }
   */
  public PaymentRequest getPaymentRequest() {
    return paymentRequest;
  }

  /**
   * Sets the value of the paymentRequest property.
   *
   * @param value allowed object is {@link PaymentRequest }
   */
  public void setPaymentRequest(PaymentRequest value) {
    this.paymentRequest = value;
  }

  /**
   * Gets the value of the loyaltyRequest property.
   *
   * @return possible object is {@link LoyaltyRequest }
   */
  public LoyaltyRequest getLoyaltyRequest() {
    return loyaltyRequest;
  }

  /**
   * Sets the value of the loyaltyRequest property.
   *
   * @param value allowed object is {@link LoyaltyRequest }
   */
  public void setLoyaltyRequest(LoyaltyRequest value) {
    this.loyaltyRequest = value;
  }

  /**
   * Gets the value of the reversalRequest property.
   *
   * @return possible object is {@link ReversalRequest }
   */
  public ReversalRequest getReversalRequest() {
    return reversalRequest;
  }

  /**
   * Sets the value of the reversalRequest property.
   *
   * @param value allowed object is {@link ReversalRequest }
   */
  public void setReversalRequest(ReversalRequest value) {
    this.reversalRequest = value;
  }
}
