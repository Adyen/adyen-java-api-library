package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Information related to the payment card used for the transaction. */
@JsonPropertyOrder({
    "ProtectedCardData",
    "SensitiveCardData",
    "AllowedProductCode",
    "AllowedProduct",
    "PaymentToken",
    "CustomerOrder",
    "PaymentBrand",
    "MaskedPan",
    "PaymentAccountRef",
    "EntryMode",
    "CardCountryCode"
})
public class CardData {

  @JsonProperty("ProtectedCardData")
  @Schema(
      description =
          "Sensitive information related to the payment card, protected by CMS. --Rule: SensitiveCardData protected by CMS EnvelopedData")
  protected ContentInformation protectedCardData;

  @JsonProperty("SensitiveCardData")
  @Schema(
      description =
          "Sensitive information related to the payment card, entered or read by the Sale System. --Rule: If structure non empty and unprotected")
  protected SensitiveCardData sensitiveCardData;

  @JsonProperty("AllowedProductCode")
  @Schema(
      description =
          "Product codes that are payable by the payment card. --Rule: If ErrorCondition is \"PaymentRestriction\", some products are not payable by the payment card (payment response).",
      minLength = 1,
      maxLength = 20)
  protected List<String> allowedProductCode;

  @JsonProperty("AllowedProduct")
  @Schema(
      description =
          "Product that are payable by the payment card. --Rule: If the card has restrictions on product that can be purchased (card acquisition or balance inquiry response).")
  protected List<AllowedProduct> allowedProduct;

  @JsonProperty("PaymentToken")
  @Schema(
      description =
          "Surrogate of the PAN (Primary Account Number) of the payment card to identify the payment mean of the customer. --Rule: Present in If requested in CardAcquisitionResponse or PaymentResponse if requested in the request or in the Login")
  protected PaymentToken paymentToken;

  @JsonProperty("CustomerOrder")
  @Schema(
      description =
          "Customer order attached to a card, recorded in the POI system. --Rule: If the list of customer orders has been requested.")
  protected List<CustomerOrder> customerOrder;

  @JsonProperty("PaymentBrand")
  @Schema(description = "Type of payment card --Rule: If card PAN is readable ")
  protected String paymentBrand;

  @JsonProperty("MaskedPan")
  protected String maskedPAN;

  @JsonProperty("PaymentAccountRef")
  @Schema(
      description =
          "Reference of the PAN, which identifies the PAN or the card uniquely, named also PAR (Payment Account Reference). This --Rule: Mandatory if available.")
  protected String paymentAccountRef;

  @JsonProperty("EntryMode")
  @Schema(
      description =
          "Entry mode of the payment instrument information --Rule: Mandatory in the request")
  protected List<EntryModeType> entryMode;

  @JsonProperty("CardCountryCode")
  @Schema(
      description =
          "Country Code attached to the card (3 numerics). --Rule: If available in the card",
      minLength = 3,
      maxLength = 3)
  protected String cardCountryCode;

  /**
   * Gets protected card data.
   *
   * @return the protected card data
   */
  public ContentInformation getProtectedCardData() {
    return protectedCardData;
  }

  /**
   * Sets protected card data.
   *
   * @param protectedCardData the protected card data
   */
  public void setProtectedCardData(ContentInformation protectedCardData) {
    this.protectedCardData = protectedCardData;
  }

  /**
   * Gets sensitive card data.
   *
   * @return the sensitive card data
   */
  public SensitiveCardData getSensitiveCardData() {
    return sensitiveCardData;
  }

  /**
   * Sets sensitive card data.
   *
   * @param sensitiveCardData the sensitive card data
   */
  public void setSensitiveCardData(SensitiveCardData sensitiveCardData) {
    this.sensitiveCardData = sensitiveCardData;
  }

  /**
   * Gets allowed product code.
   *
   * @return the allowed product code
   */
  public List<String> getAllowedProductCode() {
    if (allowedProductCode == null) {
      allowedProductCode = new ArrayList<>();
    }
    return this.allowedProductCode;
  }

  /**
   * Sets allowed product code.
   *
   * @param allowedProductCode the allowed product code
   */
  public void setAllowedProductCode(List<String> allowedProductCode) {
    this.allowedProductCode = allowedProductCode;
  }

  /**
   * Gets allowed product.
   *
   * @return the allowed product
   */
  public List<AllowedProduct> getAllowedProduct() {
    if (allowedProduct == null) {
      allowedProduct = new ArrayList<>();
    }
    return this.allowedProduct;
  }

  /**
   * Sets allowed product.
   *
   * @param allowedProduct the allowed product
   */
  public void setAllowedProduct(List<AllowedProduct> allowedProduct) {
    this.allowedProduct = allowedProduct;
  }

  /**
   * Gets payment token.
   *
   * @return the payment token
   */
  public PaymentToken getPaymentToken() {
    return paymentToken;
  }

  /**
   * Sets payment token.
   *
   * @param paymentToken the payment token
   */
  public void setPaymentToken(PaymentToken paymentToken) {
    this.paymentToken = paymentToken;
  }

  /**
   * Gets customer order.
   *
   * @return the customer order
   */
  public List<CustomerOrder> getCustomerOrder() {
    if (customerOrder == null) {
      customerOrder = new ArrayList<>();
    }
    return this.customerOrder;
  }

  /**
   * Sets customer order.
   *
   * @param customerOrder the customer order
   */
  public void setCustomerOrder(List<CustomerOrder> customerOrder) {
    this.customerOrder = customerOrder;
  }

  /**
   * Gets payment brand.
   *
   * @return the payment brand
   */
  public String getPaymentBrand() {
    return paymentBrand;
  }

  /**
   * Sets payment brand.
   *
   * @param paymentBrand the payment brand
   */
  public void setPaymentBrand(String paymentBrand) {
    this.paymentBrand = paymentBrand;
  }

  /**
   * Gets masked pan.
   *
   * @return the masked pan
   */
  public String getMaskedPAN() {
    return maskedPAN;
  }

  /**
   * Sets masked pan.
   *
   * @param maskedPAN the masked pan
   */
  public void setMaskedPAN(String maskedPAN) {
    this.maskedPAN = maskedPAN;
  }

  /**
   * Gets payment account ref.
   *
   * @return the payment account ref
   */
  public String getPaymentAccountRef() {
    return paymentAccountRef;
  }

  /**
   * Sets payment account ref.
   *
   * @param paymentAccountRef the payment account ref
   */
  public void setPaymentAccountRef(String paymentAccountRef) {
    this.paymentAccountRef = paymentAccountRef;
  }

  /**
   * Gets entry mode.
   *
   * @return the entry mode
   */
  public List<EntryModeType> getEntryMode() {
    if (entryMode == null) {
      entryMode = new ArrayList<>();
    }
    return this.entryMode;
  }

  /**
   * Sets entry mode.
   *
   * @param entryMode the entry mode
   */
  public void setEntryMode(List<EntryModeType> entryMode) {
    this.entryMode = entryMode;
  }

  /**
   * Gets card country code.
   *
   * @return the card country code
   */
  public String getCardCountryCode() {
    return cardCountryCode;
  }

  /**
   * Sets card country code.
   *
   * @param cardCountryCode the card country code
   */
  public void setCardCountryCode(String cardCountryCode) {
    this.cardCountryCode = cardCountryCode;
  }
}