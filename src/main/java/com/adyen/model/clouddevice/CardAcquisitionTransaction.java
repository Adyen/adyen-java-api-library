package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** Data related to the payment and loyalty card acquisition. */
@JsonPropertyOrder({
  "AllowedPaymentBrand",
  "AllowedLoyaltyBrand",
  "ForceEntryMode",
  "LoyaltyHandling",
  "CustomerLanguage",
  "ForceCustomerSelectionFlag",
  "TotalAmount",
  "PaymentType",
  "CashBackFlag"
})
public class CardAcquisitionTransaction {

  @JsonProperty("AllowedPaymentBrand")
  @Schema(
      description = "Card payment brands allowed by the Sale System for the payment transaction.")
  protected List<String> allowedPaymentBrand;

  @JsonProperty("AllowedLoyaltyBrand")
  @Schema(
      description =
          "Loyalty brands or programs allowed by the Sale System for the loyalty transaction.")
  protected List<String> allowedLoyaltyBrand;

  @JsonProperty("ForceEntryMode")
  @Schema(description = "Payment instrument entry mode requested by the Sale System.")
  protected List<ForceEntryModeType> forceEntryMode;

  @JsonProperty("LoyaltyHandling")
  @Schema(description = "Type of Loyalty processing requested by the Sale System.")
  protected LoyaltyHandlingType loyaltyHandling;

  @JsonProperty("CustomerLanguage")
  @Schema(
      description =
          "Language of the Customer --Rule: If the language is selected by the Sale System before the request to the POI.")
  protected String customerLanguage;

  @JsonProperty("ForceCustomerSelectionFlag")
  @Schema(description = "Indicates if the Customer realises the selection of the card application.")
  protected Boolean forceCustomerSelectionFlag;

  @JsonProperty("TotalAmount")
  @Schema(
      description =
          "Amount of a transaction. --Rule: Mandatory for contactless card, otherwise absent")
  protected BigDecimal totalAmount;

  @JsonProperty("PaymentType")
  @Schema(
      description =
          "Type of payment transaction. --Rule: Mandatory for contactless card, otherwise absent")
  protected PaymentType paymentType;

  @JsonProperty("CashBackFlag")
  @Schema(
      description =
          "Cash back has been requested with the payment transaction. --Rule: For contactless, True if cash back has been requested, default False. Otherwise absent.")
  protected Boolean cashBackFlag;

  /**
   * Gets allowed payment brand.
   *
   * @return the allowed payment brand
   */
  public List<String> getAllowedPaymentBrand() {
    if (allowedPaymentBrand == null) {
      allowedPaymentBrand = new ArrayList<>();
    }
    return this.allowedPaymentBrand;
  }

  /**
   * Sets allowed payment brand.
   *
   * @param allowedPaymentBrand the allowed payment brand
   */
  public void setAllowedPaymentBrand(List<String> allowedPaymentBrand) {
    this.allowedPaymentBrand = allowedPaymentBrand;
  }

  /**
   * Gets allowed loyalty brand.
   *
   * @return the allowed loyalty brand
   */
  public List<String> getAllowedLoyaltyBrand() {
    if (allowedLoyaltyBrand == null) {
      allowedLoyaltyBrand = new ArrayList<>();
    }
    return this.allowedLoyaltyBrand;
  }

  /**
   * Sets allowed loyalty brand.
   *
   * @param allowedLoyaltyBrand the allowed loyalty brand
   */
  public void setAllowedLoyaltyBrand(List<String> allowedLoyaltyBrand) {
    this.allowedLoyaltyBrand = allowedLoyaltyBrand;
  }

  /**
   * Gets force entry mode.
   *
   * @return the force entry mode
   */
  public List<ForceEntryModeType> getForceEntryMode() {
    if (forceEntryMode == null) {
      forceEntryMode = new ArrayList<>();
    }
    return this.forceEntryMode;
  }

  /**
   * Sets force entry mode.
   *
   * @param forceEntryMode the force entry mode
   */
  public void setForceEntryMode(List<ForceEntryModeType> forceEntryMode) {
    this.forceEntryMode = forceEntryMode;
  }

  /**
   * Gets loyalty handling.
   *
   * @return the loyalty handling
   */
  public LoyaltyHandlingType getLoyaltyHandling() {
    if (loyaltyHandling == null) {
      return LoyaltyHandlingType.ALLOWED;
    } else {
      return loyaltyHandling;
    }
  }

  /**
   * Sets loyalty handling.
   *
   * @param loyaltyHandling the loyalty handling
   */
  public void setLoyaltyHandling(LoyaltyHandlingType loyaltyHandling) {
    this.loyaltyHandling = loyaltyHandling;
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
   * Is force customer selection flag boolean.
   *
   * @return the boolean
   */
  public boolean isForceCustomerSelectionFlag() {
    if (forceCustomerSelectionFlag == null) {
      return false;
    } else {
      return forceCustomerSelectionFlag;
    }
  }

  /**
   * Sets force customer selection flag.
   *
   * @param forceCustomerSelectionFlag the force customer selection flag
   */
  public void setForceCustomerSelectionFlag(Boolean forceCustomerSelectionFlag) {
    this.forceCustomerSelectionFlag = forceCustomerSelectionFlag;
  }

  /**
   * Gets total amount.
   *
   * @return the total amount
   */
  public BigDecimal getTotalAmount() {
    return totalAmount;
  }

  /**
   * Sets total amount.
   *
   * @param totalAmount the total amount
   */
  public void setTotalAmount(BigDecimal totalAmount) {
    this.totalAmount = totalAmount;
  }

  /**
   * Gets payment type.
   *
   * @return the payment type
   */
  public PaymentType getPaymentType() {
    return paymentType;
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
   * Is cash back flag boolean.
   *
   * @return the boolean
   */
  public Boolean isCashBackFlag() {
    return cashBackFlag;
  }

  /**
   * Sets cash back flag.
   *
   * @param cashBackFlag the cash back flag
   */
  public void setCashBackFlag(Boolean cashBackFlag) {
    this.cashBackFlag = cashBackFlag;
  }
}
