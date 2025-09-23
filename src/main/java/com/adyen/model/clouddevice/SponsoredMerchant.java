package com.adyen.model.clouddevice;

import io.swagger.v3.oas.annotations.media.Schema;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SponsoredMerchant {

  /** The Merchant name. */
  @JsonProperty("MerchantName")
  @Schema(description = "Unformatted name of the merchant.")
  protected String merchantName;

  /** The Merchant address. */
  @JsonProperty("MerchantAddress")
  @Schema(description = "Unformatted address of the merchant.")
  protected String merchantAddress;

  /** The Merchant country. */
  @JsonProperty("MerchantCountry")
  @Schema(description = "Country of the merchant.")
  protected String merchantCountry;

  /** The Merchant category code. */
  @JsonProperty("MerchantCategoryCode")
  @Schema(description = "The code which identifies the category of the transaction (MCC).")
  protected String merchantCategoryCode;

  /** The Registration id. */
  @JsonProperty("RegistrationID")
  @Schema(description = "Identification of a registered entity.")
  protected String registrationID;

  /**
   * Gets the value of the merchantName property.
   *
   * @return possible object is {@link String }
   */
  public String getMerchantName() {
    return merchantName;
  }

  /**
   * Sets the value of the merchantName property.
   *
   * @param value allowed object is {@link String }
   */
  public void setMerchantName(String value) {
    this.merchantName = value;
  }

  /**
   * Gets the value of the merchantAddress property.
   *
   * @return possible object is {@link String }
   */
  public String getMerchantAddress() {
    return merchantAddress;
  }

  /**
   * Sets the value of the merchantAddress property.
   *
   * @param value allowed object is {@link String }
   */
  public void setMerchantAddress(String value) {
    this.merchantAddress = value;
  }

  /**
   * Gets the value of the merchantCountry property.
   *
   * @return possible object is {@link String }
   */
  public String getMerchantCountry() {
    return merchantCountry;
  }

  /**
   * Sets the value of the merchantCountry property.
   *
   * @param value allowed object is {@link String }
   */
  public void setMerchantCountry(String value) {
    this.merchantCountry = value;
  }

  /**
   * Gets the value of the merchantCategoryCode property.
   *
   * @return possible object is {@link String }
   */
  public String getMerchantCategoryCode() {
    return merchantCategoryCode;
  }

  /**
   * Sets the value of the merchantCategoryCode property.
   *
   * @param value allowed object is {@link String }
   */
  public void setMerchantCategoryCode(String value) {
    this.merchantCategoryCode = value;
  }

  /**
   * Gets the value of the registrationID property.
   *
   * @return possible object is {@link String }
   */
  public String getRegistrationID() {
    return registrationID;
  }

  /**
   * Sets the value of the registrationID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setRegistrationID(String value) {
    this.registrationID = value;
  }
}
