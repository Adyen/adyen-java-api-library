package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Information related to the software of the POI System which manages the Sale to POI protocol. */
@JsonPropertyOrder({"ManufacturerID", "ApplicationName", "SoftwareVersion", "CertificationCode"})
public class POISoftware {

  @JsonProperty("ManufacturerID")
  @Schema(description = "Identification of the Manufacturer")
  protected String manufacturerID;

  @JsonProperty("ApplicationName")
  @Schema(description = "Name of the software product.")
  protected String applicationName;

  @JsonProperty("SoftwareVersion")
  @Schema(description = "Version of the software product")
  protected String softwareVersion;

  @JsonProperty("CertificationCode")
  @Schema(
      description = "Certification code of the software which manages the Sale to POI protocol.")
  protected String certificationCode;

  /**
   * Gets manufacturer id.
   *
   * @return the manufacturer id
   */
  public String getManufacturerID() {
    return manufacturerID;
  }

  /**
   * Sets manufacturer id.
   *
   * @param manufacturerID the manufacturer id
   */
  public void setManufacturerID(String manufacturerID) {
    this.manufacturerID = manufacturerID;
  }

  /**
   * Gets application name.
   *
   * @return the application name
   */
  public String getApplicationName() {
    return applicationName;
  }

  /**
   * Sets application name.
   *
   * @param applicationName the application name
   */
  public void setApplicationName(String applicationName) {
    this.applicationName = applicationName;
  }

  /**
   * Gets software version.
   *
   * @return the software version
   */
  public String getSoftwareVersion() {
    return softwareVersion;
  }

  /**
   * Sets software version.
   *
   * @param softwareVersion the software version
   */
  public void setSoftwareVersion(String softwareVersion) {
    this.softwareVersion = softwareVersion;
  }

  /**
   * Gets certification code.
   *
   * @return the certification code
   */
  public String getCertificationCode() {
    return certificationCode;
  }

  /**
   * Sets certification code.
   *
   * @param certificationCode the certification code
   */
  public void setCertificationCode(String certificationCode) {
    this.certificationCode = certificationCode;
  }
}
