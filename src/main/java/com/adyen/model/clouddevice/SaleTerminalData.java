package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Information related to the software and hardware feature of the Sale Terminal. */
@JsonPropertyOrder({"SaleCapabilities", "SaleProfile", "TerminalEnvironment", "TotalsGroupID"})
public class SaleTerminalData {

  @JsonProperty("SaleCapabilities")
  @Schema(description = "Hardware capabilities of the Sale Terminal.")
  protected List<SaleCapabilitiesType> saleCapabilities;

  @JsonProperty("SaleProfile")
  @Schema(
      description =
          "Functional profile of the Sale Terminal. --Rule: If at least one element is present")
  protected SaleProfile saleProfile;

  @JsonProperty("TerminalEnvironment")
  @Schema(description = "Environment of the Terminal.")
  protected TerminalEnvironmentType terminalEnvironment;

  @JsonProperty("TotalsGroupID")
  @Schema(
      description =
          "Identification of a group of transaction on a POI Terminal, having the same Sale features. --Rule: If present, default value for all transaction.")
  protected String totalsGroupID;

  /**
   * Gets sale capabilities.
   *
   * @return the sale capabilities
   */
  public List<SaleCapabilitiesType> getSaleCapabilities() {
    if (saleCapabilities == null) {
      saleCapabilities = new ArrayList<>();
    }
    return this.saleCapabilities;
  }

  /**
   * Sets sale capabilities.
   *
   * @param saleCapabilities the sale capabilities
   */
  public void setSaleCapabilities(List<SaleCapabilitiesType> saleCapabilities) {
    this.saleCapabilities = saleCapabilities;
  }

  /**
   * Gets sale profile.
   *
   * @return the sale profile
   */
  public SaleProfile getSaleProfile() {
    return saleProfile;
  }

  /**
   * Sets sale profile.
   *
   * @param saleProfile the sale profile
   */
  public void setSaleProfile(SaleProfile saleProfile) {
    this.saleProfile = saleProfile;
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
   * Gets totals group id.
   *
   * @return the totals group id
   */
  public String getTotalsGroupID() {
    return totalsGroupID;
  }

  /**
   * Sets totals group id.
   *
   * @param totalsGroupID the totals group id
   */
  public void setTotalsGroupID(String totalsGroupID) {
    this.totalsGroupID = totalsGroupID;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("SaleTerminalData{");
    sb.append("saleCapabilities=").append(saleCapabilities);
    sb.append(", saleProfile=").append(saleProfile);
    sb.append(", terminalEnvironment=").append(terminalEnvironment);
    sb.append(", totalsGroupID='").append(totalsGroupID).append('\'');
    sb.append('}');
    return sb.toString();
  }
}
