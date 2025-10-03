package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Information related to the software and hardware feature of the POI Terminal. */
@JsonPropertyOrder({"POICapabilities", "POIProfile", "TerminalEnvironment", "POISerialNumber"})
public class POITerminalData {

  @JsonProperty("POICapabilities")
  @Schema(description = "Hardware capabilities of the POI Terminal.")
  protected List<POICapabilitiesType> poiCapabilities;

  @JsonProperty("POIProfile")
  @Schema(
      description =
          "Functional profile of the POI Terminal. --Rule: If at least one element is present. The Sale System decides if it can continue or not.")
  protected POIProfile poiProfile;

  @JsonProperty("TerminalEnvironment")
  @Schema(description = "Environment of the Terminal.")
  protected TerminalEnvironmentType terminalEnvironment;

  @JsonProperty("POISerialNumber")
  @Schema(description = "Serial number of a POI Terminal")
  protected String poiSerialNumber;

  /**
   * Gets poi capabilities.
   *
   * @return the poi capabilities
   */
  public List<POICapabilitiesType> getPOICapabilities() {
    if (poiCapabilities == null) {
      poiCapabilities = new ArrayList<>();
    }
    return this.poiCapabilities;
  }

  /**
   * Sets poi capabilities.
   *
   * @param poiCapabilities the poi capabilities
   */
  public void setPOICapabilities(List<POICapabilitiesType> poiCapabilities) {
    this.poiCapabilities = poiCapabilities;
  }

  /**
   * Gets poi profile.
   *
   * @return the poi profile
   */
  public POIProfile getPOIProfile() {
    return poiProfile;
  }

  /**
   * Sets poi profile.
   *
   * @param poiProfile the poi profile
   */
  public void setPOIProfile(POIProfile poiProfile) {
    this.poiProfile = poiProfile;
  }

  /**
   * Gets terminal environment.
   *
   * @return the terminal environment
   */
  public TerminalEnvironmentType getTerminalEnvironment() {
    return terminalEnvironment;
  }

  /**
   * Sets terminal environment.
   *
   * @param terminalEnvironment the terminal environment
   */
  public void setTerminalEnvironment(TerminalEnvironmentType terminalEnvironment) {
    this.terminalEnvironment = terminalEnvironment;
  }

  /**
   * Gets poi serial number.
   *
   * @return the poi serial number
   */
  public String getPOISerialNumber() {
    return poiSerialNumber;
  }

  /**
   * Sets poi serial number.
   *
   * @param poiSerialNumber the poi serial number
   */
  public void setPOISerialNumber(String poiSerialNumber) {
    this.poiSerialNumber = poiSerialNumber;
  }
}
