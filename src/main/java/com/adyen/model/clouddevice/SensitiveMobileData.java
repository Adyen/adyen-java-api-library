package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Sensitive information related to the mobile phone. */
@JsonPropertyOrder({"MSISDN", "IMSI", "IMEI"})
public class SensitiveMobileData {

  @JsonProperty("MSISDN")
  @Schema(
      description =
          "Mobile Subscriber Integrated Service Digital Network (i.e. mobile phone number of the SIM card).")
  protected String msisdn;

  @JsonProperty("IMSI")
  @Schema(description = "International Mobile Subscriber Identity. --Rule: If data available")
  protected String imsi;

  @JsonProperty("IMEI")
  @Schema(description = "International Mobile Equipement Identity. --Rule: If data available")
  protected String imei;

  /**
   * Gets msisdn.
   *
   * @return the msisdn
   */
  public String getMSISDN() {
    return msisdn;
  }

  /**
   * Sets msisdn.
   *
   * @param msisdn the msisdn
   */
  public void setMSISDN(String msisdn) {
    this.msisdn = msisdn;
  }

  /**
   * Gets imsi.
   *
   * @return the imsi
   */
  public String getIMSI() {
    return imsi;
  }

  /**
   * Sets imsi.
   *
   * @param imsi the imsi
   */
  public void setIMSI(String imsi) {
    this.imsi = imsi;
  }

  /**
   * Gets imei.
   *
   * @return the imei
   */
  public String getIMEI() {
    return imei;
  }

  /**
   * Sets imei.
   *
   * @param imei the imei
   */
  public void setIMEI(String imei) {
    this.imei = imei;
  }
}
