package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

public class TotalFilter {

  /** The Poiid. */
  @JsonProperty("POIID")
  @Schema(
      description =
          "Identification of a POI System or a POI Terminal for the Sale to POI protocol --Rule: If totals in the response have to be computed only for this particular value of POIID")
  protected String poiid;

  /** The Sale id. */
  @JsonProperty("SaleID")
  @Schema(
      description =
          "Identification of a Sale System or a Sale Terminal for the Sale to POI protocol --Rule: If totals in the response have to be computed only for this particular value of SaleID")
  protected String saleID;

  /** The Operator id. */
  @JsonProperty("OperatorID")
  @Schema(
      description =
          "Identification of the Cashier or Operator. --Rule: If totals in the response have to be computed only for this particular value of OperatorID")
  protected String operatorID;

  /** The Shift number. */
  @JsonProperty("ShiftNumber")
  @Schema(
      description =
          "Shift number. --Rule: If totals in the response have to be computed only for this particular value of ShiftNumber")
  protected String shiftNumber;

  /** The Totals group id. */
  @JsonProperty("TotalsGroupID")
  @Schema(
      description =
          "Identification of a group of transaction on a POI Terminal, having the same Sale features. --Rule: If totals in the response have to be computed only for this particular value of TotalsGroupID",
      minLength = 1,
      maxLength = 16)
  protected String totalsGroupID;

  /**
   * Gets the value of the poiid property.
   *
   * @return possible object is {@link String }
   */
  public String getPOIID() {
    return poiid;
  }

  /**
   * Sets the value of the poiid property.
   *
   * @param value allowed object is {@link String }
   */
  public void setPOIID(String value) {
    this.poiid = value;
  }

  /**
   * Gets the value of the saleID property.
   *
   * @return possible object is {@link String }
   */
  public String getSaleID() {
    return saleID;
  }

  /**
   * Sets the value of the saleID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setSaleID(String value) {
    this.saleID = value;
  }

  /**
   * Gets the value of the operatorID property.
   *
   * @return possible object is {@link String }
   */
  public String getOperatorID() {
    return operatorID;
  }

  /**
   * Sets the value of the operatorID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setOperatorID(String value) {
    this.operatorID = value;
  }

  /**
   * Gets the value of the shiftNumber property.
   *
   * @return possible object is {@link String }
   */
  public String getShiftNumber() {
    return shiftNumber;
  }

  /**
   * Sets the value of the shiftNumber property.
   *
   * @param value allowed object is {@link String }
   */
  public void setShiftNumber(String value) {
    this.shiftNumber = value;
  }

  /**
   * Gets the value of the totalsGroupID property.
   *
   * @return possible object is {@link String }
   */
  public String getTotalsGroupID() {
    return totalsGroupID;
  }

  /**
   * Sets the value of the totalsGroupID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setTotalsGroupID(String value) {
    this.totalsGroupID = value;
  }
}
