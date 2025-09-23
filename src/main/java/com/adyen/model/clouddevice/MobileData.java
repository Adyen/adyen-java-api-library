package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Information related to the mobile for the payment transaction. */
@JsonPropertyOrder({
    "MobileCountryCode",
    "Geolocation",
    "ProtectedMobileData",
    "SensitiveMobileData",
    "MobileNetworkCode",
    "MaskedMSISDN"
})
public class MobileData {

  @JsonProperty("MobileCountryCode")
  @Schema(
      description = "Identifies the country of a mobile phone operator. --Rule: If data available",
      minLength = 3,
      maxLength = 3)
  protected String mobileCountryCode;

  @JsonProperty("Geolocation")
  @Schema(
      description =
          "Geographic location specified by geographic or UTM coordinates. --Rule: If data available")
  protected Geolocation geolocation;

  @JsonProperty("ProtectedMobileData")
  @Schema(
      description =
          "Sensitive information related to the mobile phone, protected by CMS. --Rule: SensitiveMobileData")
  protected ContentInformation protectedMobileData;

  @JsonProperty("SensitiveMobileData")
  @Schema(
      description =
          "Sensitive information related to the mobile phone. --Rule: If unprotected mobile data")
  protected SensitiveMobileData sensitiveMobileData;

  @JsonProperty("MobileNetworkCode")
  @Schema(
      description =
          "Identifies the mobile phone operator inside a country. --Rule: If data available",
      minLength = 2,
      maxLength = 3)
  protected String mobileNetworkCode;

  @JsonProperty("MaskedMSISDN")
  @Schema(
      description =
          "Masked Mobile Subscriber Integrated Service Digital Network. --Rule: If data available")
  protected String maskedMSISDN;

  /**
   * Gets mobile country code.
   *
   * @return the mobile country code
   */
  public String getMobileCountryCode() {
    return mobileCountryCode;
  }

  /**
   * Sets mobile country code.
   *
   * @param mobileCountryCode the mobile country code
   */
  public void setMobileCountryCode(String mobileCountryCode) {
    this.mobileCountryCode = mobileCountryCode;
  }

  /**
   * Gets geolocation.
   *
   * @return the geolocation
   */
  public Geolocation getGeolocation() {
    return geolocation;
  }

  /**
   * Sets geolocation.
   *
   * @param geolocation the geolocation
   */
  public void setGeolocation(Geolocation geolocation) {
    this.geolocation = geolocation;
  }

  /**
   * Gets protected mobile data.
   *
   * @return the protected mobile data
   */
  public ContentInformation getProtectedMobileData() {
    return protectedMobileData;
  }

  /**
   * Sets protected mobile data.
   *
   * @param protectedMobileData the protected mobile data
   */
  public void setProtectedMobileData(ContentInformation protectedMobileData) {
    this.protectedMobileData = protectedMobileData;
  }

  /**
   * Gets sensitive mobile data.
   *
   * @return the sensitive mobile data
   */
  public SensitiveMobileData getSensitiveMobileData() {
    return sensitiveMobileData;
  }

  /**
   * Sets sensitive mobile data.
   *
   * @param sensitiveMobileData the sensitive mobile data
   */
  public void setSensitiveMobileData(SensitiveMobileData sensitiveMobileData) {
    this.sensitiveMobileData = sensitiveMobileData;
  }

  /**
   * Gets mobile network code.
   *
   * @return the mobile network code
   */
  public String getMobileNetworkCode() {
    return mobileNetworkCode;
  }

  /**
   * Sets mobile network code.
   *
   * @param mobileNetworkCode the mobile network code
   */
  public void setMobileNetworkCode(String mobileNetworkCode) {
    this.mobileNetworkCode = mobileNetworkCode;
  }

  /**
   * Gets masked msisdn.
   *
   * @return the masked msisdn
   */
  public String getMaskedMSISDN() {
    return maskedMSISDN;
  }

  /**
   * Sets masked msisdn.
   *
   * @param maskedMSISDN the masked msisdn
   */
  public void setMaskedMSISDN(String maskedMSISDN) {
    this.maskedMSISDN = maskedMSISDN;
  }
}