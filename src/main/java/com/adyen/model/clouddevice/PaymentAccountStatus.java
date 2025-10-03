package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;

/** Data related to the result of a Balance Inquiry request. */
@JsonPropertyOrder({
  "PaymentInstrumentData",
  "PaymentAcquirerData",
  "LoyaltyAccountStatus",
  "Currency",
  "CurrentBalance"
})
public class PaymentAccountStatus {

  @JsonProperty("PaymentInstrumentData")
  @Schema(
      description =
          "Data related to the instrument of payment for the transaction. --Rule: If a payment instrument is analysed")
  protected PaymentInstrumentData paymentInstrumentData;

  @JsonProperty("PaymentAcquirerData")
  @Schema(
      description =
          "Data related to the response from the payment Acquirer. --Rule: If a card is analysed")
  protected PaymentAcquirerData paymentAcquirerData;

  @JsonProperty("LoyaltyAccountStatus")
  @Schema(
      description =
          "Data related to the result of a loyalty Balance Inquiry. --Rule: If PaymentInstrumentData absent and Result is Success")
  protected LoyaltyAccountStatus loyaltyAccountStatus;

  @JsonProperty("Currency")
  @Schema(
      description =
          "Currency of a monetary amount. --Rule: If PaymentInstrumentData present and Result is Success")
  protected String currency;

  @JsonProperty("CurrentBalance")
  @Schema(
      description =
          "Balance of an account. --Rule: If PaymentInstrumentData present and Result is Success")
  protected BigDecimal currentBalance;

  /**
   * Gets payment instrument data.
   *
   * @return the payment instrument data
   */
  public PaymentInstrumentData getPaymentInstrumentData() {
    return paymentInstrumentData;
  }

  /**
   * Sets payment instrument data.
   *
   * @param paymentInstrumentData the payment instrument data
   */
  public void setPaymentInstrumentData(PaymentInstrumentData paymentInstrumentData) {
    this.paymentInstrumentData = paymentInstrumentData;
  }

  /**
   * Gets payment acquirer data.
   *
   * @return the payment acquirer data
   */
  public PaymentAcquirerData getPaymentAcquirerData() {
    return paymentAcquirerData;
  }

  /**
   * Sets payment acquirer data.
   *
   * @param paymentAcquirerData the payment acquirer data
   */
  public void setPaymentAcquirerData(PaymentAcquirerData paymentAcquirerData) {
    this.paymentAcquirerData = paymentAcquirerData;
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

  /**
   * Gets currency.
   *
   * @return the currency
   */
  public String getCurrency() {
    return currency;
  }

  /**
   * Sets currency.
   *
   * @param currency the currency
   */
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  /**
   * Gets current balance.
   *
   * @return the current balance
   */
  public BigDecimal getCurrentBalance() {
    return currentBalance;
  }

  /**
   * Sets current balance.
   *
   * @param currentBalance the current balance
   */
  public void setCurrentBalance(BigDecimal currentBalance) {
    this.currentBalance = currentBalance;
  }
}
