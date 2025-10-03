package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Data related to the result of a processed payment transaction. */
@JsonPropertyOrder({
  "PaymentInstrumentData",
  "AmountsResp",
  "Instalment",
  "CurrencyConversion",
  "CapturedSignature",
  "ProtectedSignature",
  "PaymentAcquirerData",
  "PaymentType",
  "MerchantOverrideFlag",
  "CustomerLanguage",
  "OnlineFlag",
  "AuthenticationMethod",
  "ValidityDate"
})
public class PaymentResult {

  @JsonProperty("PaymentInstrumentData")
  @Schema(
      description =
          "Data related to the instrument of payment for the transaction. --Rule: If a payment instrument is analysed by the POI")
  protected PaymentInstrumentData paymentInstrumentData;

  @JsonProperty("AmountsResp")
  @Schema(
      description =
          "Various amounts related to the payment response from the POI System. --Rule: If Result is Success or Partial")
  protected AmountsResp amountsResp;

  @JsonProperty("Instalment")
  @Schema(
      description =
          "Information related an instalment transaction. --Rule: Absent if PaymentType is not \"IssuerInstalment\"")
  protected Instalment instalment;

  @JsonProperty("CurrencyConversion")
  @Schema(
      description =
          "Information related to a currency conversion --Rule: If currency conversion the Sale needs to know")
  protected List<CurrencyConversion> currencyConversion;

  @JsonProperty("CapturedSignature")
  @Schema(
      description =
          "Numeric value of a handwritten signature. --Rule: If handwritten signature is captured on the POI by a signature capture device.")
  protected CapturedSignature capturedSignature;

  @JsonProperty("ProtectedSignature")
  @Schema(
      description =
          "Numeric value of a handwritten signature. --Rule: Encrypted handwritten signature captured on the POI by a signature capture device.")
  protected ContentInformation protectedSignature;

  @JsonProperty("PaymentAcquirerData")
  @Schema(
      description =
          "Data related to the response from the payment Acquirer. --Rule: If a card is analysed and data available")
  protected PaymentAcquirerData paymentAcquirerData;

  @JsonProperty("PaymentType")
  @Schema(description = "Type of payment transaction. --Rule: Copy")
  protected PaymentType paymentType;

  @JsonProperty("MerchantOverrideFlag")
  @Schema(
      description =
          "Indicate that the Merchant forced the result of the payment to successfull. --Rule: If payment forced by the Cashier")
  protected Boolean merchantOverrideFlag;

  @JsonProperty("CustomerLanguage")
  @Schema(
      description =
          "Language of the Customer --Rule: If the customer language is different from the default language or different from the CustomerLanguage of the")
  protected String customerLanguage;

  @JsonProperty("OnlineFlag")
  @Schema(
      description =
          "Indicate that the payment transaction processing has required the approval of a host. --Rule: \"True\" if the payment transaction processing has required the approval of a host.")
  protected Boolean onlineFlag;

  @JsonProperty("AuthenticationMethod")
  @Schema(
      description =
          "Method for customer authentication. --Rule: Method for customer authentication.")
  protected List<AuthenticationMethodType> authenticationMethod;

  @JsonProperty("ValidityDate")
  @Schema(
      description =
          "End of the validity period for the reservation. --Rule: if OneTimeReservation, FirstReservation or UpdateReservation")
  protected String validityDate;

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
   * Gets amounts resp.
   *
   * @return the amounts resp
   */
  public AmountsResp getAmountsResp() {
    return amountsResp;
  }

  /**
   * Sets amounts resp.
   *
   * @param amountsResp the amounts resp
   */
  public void setAmountsResp(AmountsResp amountsResp) {
    this.amountsResp = amountsResp;
  }

  /**
   * Gets instalment.
   *
   * @return the instalment
   */
  public Instalment getInstalment() {
    return instalment;
  }

  /**
   * Sets instalment.
   *
   * @param instalment the instalment
   */
  public void setInstalment(Instalment instalment) {
    this.instalment = instalment;
  }

  /**
   * Gets currency conversion.
   *
   * @return the currency conversion
   */
  public List<CurrencyConversion> getCurrencyConversion() {
    if (currencyConversion == null) {
      currencyConversion = new ArrayList<>();
    }
    return this.currencyConversion;
  }

  /**
   * Sets currency conversion.
   *
   * @param currencyConversion the currency conversion
   */
  public void setCurrencyConversion(List<CurrencyConversion> currencyConversion) {
    this.currencyConversion = currencyConversion;
  }

  /**
   * Gets captured signature.
   *
   * @return the captured signature
   */
  public CapturedSignature getCapturedSignature() {
    return capturedSignature;
  }

  /**
   * Sets captured signature.
   *
   * @param capturedSignature the captured signature
   */
  public void setCapturedSignature(CapturedSignature capturedSignature) {
    this.capturedSignature = capturedSignature;
  }

  /**
   * Gets protected signature.
   *
   * @return the protected signature
   */
  public ContentInformation getProtectedSignature() {
    return protectedSignature;
  }

  /**
   * Sets protected signature.
   *
   * @param protectedSignature the protected signature
   */
  public void setProtectedSignature(ContentInformation protectedSignature) {
    this.protectedSignature = protectedSignature;
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
   * Gets payment type.
   *
   * @return the payment type
   */
  public PaymentType getPaymentType() {
    if (paymentType == null) {
      return PaymentType.NORMAL;
    } else {
      return paymentType;
    }
  }

  /**
   * Sets payment type.
   *
   * @param paymentType the payment type
   */
  public void setPaymentType(PaymentType paymentType) {
    this.paymentType = paymentType;
  }

  /**
   * Is merchant override flag boolean.
   *
   * @return the boolean
   */
  public boolean isMerchantOverrideFlag() {
    if (merchantOverrideFlag == null) {
      return false;
    } else {
      return merchantOverrideFlag;
    }
  }

  /**
   * Sets merchant override flag.
   *
   * @param merchantOverrideFlag the merchant override flag
   */
  public void setMerchantOverrideFlag(Boolean merchantOverrideFlag) {
    this.merchantOverrideFlag = merchantOverrideFlag;
  }

  /**
   * Gets customer language.
   *
   * @return the customer language
   */
  public String getCustomerLanguage() {
    return customerLanguage;
  }

  /**
   * Sets customer language.
   *
   * @param customerLanguage the customer language
   */
  public void setCustomerLanguage(String customerLanguage) {
    this.customerLanguage = customerLanguage;
  }

  /**
   * Is online flag boolean.
   *
   * @return the boolean
   */
  public boolean isOnlineFlag() {
    if (onlineFlag == null) {
      return true;
    } else {
      return onlineFlag;
    }
  }

  /**
   * Sets online flag.
   *
   * @param onlineFlag the online flag
   */
  public void setOnlineFlag(Boolean onlineFlag) {
    this.onlineFlag = onlineFlag;
  }

  /**
   * Gets authentication method.
   *
   * @return the authentication method
   */
  public List<AuthenticationMethodType> getAuthenticationMethod() {
    if (authenticationMethod == null) {
      authenticationMethod = new ArrayList<>();
    }
    return this.authenticationMethod;
  }

  /**
   * Sets authentication method.
   *
   * @param authenticationMethod the authentication method
   */
  public void setAuthenticationMethod(List<AuthenticationMethodType> authenticationMethod) {
    this.authenticationMethod = authenticationMethod;
  }

  /**
   * Gets validity date.
   *
   * @return the validity date
   */
  public String getValidityDate() {
    return validityDate;
  }

  /**
   * Sets validity date.
   *
   * @param validityDate the validity date
   */
  public void setValidityDate(String validityDate) {
    this.validityDate = validityDate;
  }
}
