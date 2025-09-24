package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Balance Inquiry Response message. */
@JsonPropertyOrder({"Response", "PaymentAccountStatus", "LoyaltyAccountStatus"})
public class BalanceInquiryResponse {

  @JsonProperty("Response")
  @Schema(description = "Result of a message request processing.")
  protected Response response;

  @JsonProperty("PaymentAccountStatus")
  @Schema(
      description =
          "Data related to the result of a Balance Inquiry request. --Rule: If BalanceInquiryRequest. PaymentAccount present")
  protected PaymentAccountStatus paymentAccountStatus;

  @JsonProperty("LoyaltyAccountStatus")
  @Schema(
      description =
          "Data related to the result of a loyalty Balance Inquiry. --Rule: If BalanceInquiryRequest. LoyaltyData present")
  protected LoyaltyAccountStatus loyaltyAccountStatus;

  /**
   * Gets response.
   *
   * @return the response
   */
  public Response getResponse() {
    return response;
  }

  /**
   * Sets response.
   *
   * @param response the response
   */
  public void setResponse(Response response) {
    this.response = response;
  }

  /**
   * Gets payment account status.
   *
   * @return the payment account status
   */
  public PaymentAccountStatus getPaymentAccountStatus() {
    return paymentAccountStatus;
  }

  /**
   * Sets payment account status.
   *
   * @param paymentAccountStatus the payment account status
   */
  public void setPaymentAccountStatus(PaymentAccountStatus paymentAccountStatus) {
    this.paymentAccountStatus = paymentAccountStatus;
  }

  /**
   * Gets loyalty account status.
   *
   * @return the loyalty account status
   */
  public LoyaltyAccountStatus getLoyaltyAccountStatus() {
    return loyaltyAccountStatus;
  }

  /**
   * Sets loyalty account status.
   *
   * @param loyaltyAccountStatus the loyalty account status
   */
  public void setLoyaltyAccountStatus(LoyaltyAccountStatus loyaltyAccountStatus) {
    this.loyaltyAccountStatus = loyaltyAccountStatus;
  }
}
