package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Data related to the instrument of payment for the transaction. */
@JsonPropertyOrder({
  "CardData",
  "CheckData",
  "MobileData",
  "PaymentInstrumentType",
  "StoredValueAccountID",
  "ProtectedCardData"
})
public class PaymentInstrumentData {

  @JsonProperty("CardData")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(
      description =
          "Information related to the payment card used for the transaction. --Rule: If PaymentInstrumentType is \"Card\"")
  protected CardData cardData;

  @JsonProperty("CheckData")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(
      description =
          "Information related to the paper check used for the transaction. --Rule: If PaymentInstrumentType is \"Check\"")
  protected CheckData checkData;

  @JsonProperty("MobileData")
  @JsonInclude(JsonInclude.Include.NON_NULL)
  @Schema(
      description =
          "Information related to the mobile for the payment transaction. --Rule: If PaymentInstrumentType is \"Mobile\"")
  protected MobileData mobileData;

  @JsonProperty("PaymentInstrumentType")
  @Schema(description = "Type of payment instrument.")
  protected PaymentInstrumentType paymentInstrumentType;

  @JsonProperty("StoredValueAccountID")
  protected StoredValueAccountID storedValueAccountID;

  @JsonProperty("ProtectedCardData")
  protected String protectedCardData;

  /**
   * Gets card data.
   *
   * @return the card data
   */
  public CardData getCardData() {
    return cardData;
  }

  /**
   * Sets card data.
   *
   * @param cardData the card data
   */
  public void setCardData(CardData cardData) {
    this.cardData = cardData;
  }

  /**
   * Gets check data.
   *
   * @return the check data
   */
  public CheckData getCheckData() {
    return checkData;
  }

  /**
   * Sets check data.
   *
   * @param checkData the check data
   */
  public void setCheckData(CheckData checkData) {
    this.checkData = checkData;
  }

  /**
   * Gets mobile data.
   *
   * @return the mobile data
   */
  public MobileData getMobileData() {
    return mobileData;
  }

  /**
   * Sets mobile data.
   *
   * @param mobileData the mobile data
   */
  public void setMobileData(MobileData mobileData) {
    this.mobileData = mobileData;
  }

  /**
   * Gets payment instrument type.
   *
   * @return the payment instrument type
   */
  public PaymentInstrumentType getPaymentInstrumentType() {
    return paymentInstrumentType;
  }

  /**
   * Sets payment instrument type.
   *
   * @param paymentInstrumentType the payment instrument type
   */
  public void setPaymentInstrumentType(PaymentInstrumentType paymentInstrumentType) {
    this.paymentInstrumentType = paymentInstrumentType;
  }

  /**
   * Gets stored value account id.
   *
   * @return the stored value account id
   */
  public StoredValueAccountID getStoredValueAccountID() {
    return storedValueAccountID;
  }

  /**
   * Sets stored value account id.
   *
   * @param storedValueAccountID the stored value account id
   */
  public void setStoredValueAccountID(StoredValueAccountID storedValueAccountID) {
    this.storedValueAccountID = storedValueAccountID;
  }

  /**
   * Gets protected card data.
   *
   * @return the protected card data
   */
  public String getProtectedCardData() {
    return protectedCardData;
  }

  /**
   * Sets protected card data.
   *
   * @param protectedCardData the protected card data
   */
  public void setProtectedCardData(String protectedCardData) {
    this.protectedCardData = protectedCardData;
  }
}
