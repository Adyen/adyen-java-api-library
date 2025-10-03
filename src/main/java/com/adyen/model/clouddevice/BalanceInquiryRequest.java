package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Balance Inquiry Request message. */
@JsonPropertyOrder({"PaymentAccountReq", "LoyaltyAccountReq"})
public class BalanceInquiryRequest {

  @JsonProperty("PaymentAccountReq")
  @Schema(description = "Data related to the account pointed by the payment card")
  protected PaymentAccountReq paymentAccountReq;

  @JsonProperty("LoyaltyAccountReq")
  @Schema(description = "Data related to a requested Loyalty program or account.")
  protected LoyaltyAccountReq loyaltyAccountReq;

  /**
   * Gets payment account req.
   *
   * @return the payment account req
   */
  public PaymentAccountReq getPaymentAccountReq() {
    return paymentAccountReq;
  }

  /**
   * Sets payment account req.
   *
   * @param paymentAccountReq the payment account req
   */
  public void setPaymentAccountReq(PaymentAccountReq paymentAccountReq) {
    this.paymentAccountReq = paymentAccountReq;
  }

  /**
   * Gets loyalty account req.
   *
   * @return the loyalty account req
   */
  public LoyaltyAccountReq getLoyaltyAccountReq() {
    return loyaltyAccountReq;
  }

  /**
   * Sets loyalty account req.
   *
   * @param loyaltyAccountReq the loyalty account req
   */
  public void setLoyaltyAccountReq(LoyaltyAccountReq loyaltyAccountReq) {
    this.loyaltyAccountReq = loyaltyAccountReq;
  }
}
