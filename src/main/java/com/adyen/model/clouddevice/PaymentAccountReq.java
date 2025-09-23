package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Data related to the account pointed by the payment card. */
@JsonPropertyOrder({"CardAcquisitionReference", "PaymentInstrumentData", "AccountType"})
public class PaymentAccountReq {

  @JsonProperty("CardAcquisitionReference")
  @Schema(
      description =
          "Reference to the last CardAcquisition, to use the same card. --Rule: if the card data comes from a previous CardAcquisition")
  protected TransactionIdentification cardAcquisitionReference;

  @JsonProperty("PaymentInstrumentData")
  @Schema(description = "Data related to the instrument of payment for the transaction.")
  protected PaymentInstrumentData paymentInstrumentData;

  @JsonProperty("AccountType")
  @Schema(description = "Type of cardholder account used for the transaction")
  protected AccountType accountType;

  /**
   * Gets card acquisition reference.
   *
   * @return the card acquisition reference
   */
  public TransactionIdentification getCardAcquisitionReference() {
    return cardAcquisitionReference;
  }

  /**
   * Sets card acquisition reference.
   *
   * @param cardAcquisitionReference the card acquisition reference
   */
  public void setCardAcquisitionReference(TransactionIdentification cardAcquisitionReference) {
    this.cardAcquisitionReference = cardAcquisitionReference;
  }

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
   * Gets account type.
   *
   * @return the account type
   */
  public AccountType getAccountType() {
    if (accountType == null) {
      return AccountType.DEFAULT;
    } else {
      return accountType;
    }
  }

  /**
   * Sets account type.
   *
   * @param accountType the account type
   */
  public void setAccountType(AccountType accountType) {
    this.accountType = accountType;
  }
}