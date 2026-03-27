package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Sensitive information related to the mobile phone. -- Usage: This data structure
 * could be CMS protected (EnvelopedData). In this case the data structure SensitiveMobileData is
 * replaced by the data structure ProtectedMobileData of type ContentInformationType. When this data
 * is protected, the exact
 *
 * <p>Java class for SensitiveMobileData complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SensitiveMobileData"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="MSISDN" use="required" type="{}MSISDN" /&gt;
 *       &lt;attribute name="IMSI" type="{}IMSI" /&gt;
 *       &lt;attribute name="IMEI" type="{}IMEI" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class SensitiveMobileData {

  /** The Msisdn. */
  @SerializedName("MSISDN")
  @Schema(
      description =
          "Mobile Subscriber Integrated Service Digital Network (i.e. mobile phone number of the SIM card).")
  protected String msisdn;

  /** The Imsi. */
  @SerializedName("IMSI")
  @Schema(description = "International Mobile Subscriber Identity. --Rule: If data available")
  protected String imsi;

  /** The Imei. */
  @SerializedName("IMEI")
  @Schema(description = "International Mobile Equipement Identity. --Rule: If data available")
  protected String imei;

  /**
   * Gets the value of the msisdn property.
   *
   * @return possible object is {@link String }
   */
  public String getMSISDN() {
    return msisdn;
  }

  /**
   * Sets the value of the msisdn property.
   *
   * @param value allowed object is {@link String }
   */
  public void setMSISDN(String value) {
    this.msisdn = value;
  }

  /**
   * Gets the value of the imsi property.
   *
   * @return possible object is {@link String }
   */
  public String getIMSI() {
    return imsi;
  }

  /**
   * Sets the value of the imsi property.
   *
   * @param value allowed object is {@link String }
   */
  public void setIMSI(String value) {
    this.imsi = value;
  }

  /**
   * Gets the value of the imei property.
   *
   * @return possible object is {@link String }
   */
  public String getIMEI() {
    return imei;
  }

  /**
   * Sets the value of the imei property.
   *
   * @param value allowed object is {@link String }
   */
  public void setIMEI(String value) {
    this.imei = value;
  }
}
