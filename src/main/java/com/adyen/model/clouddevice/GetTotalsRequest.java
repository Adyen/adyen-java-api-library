package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Content of the Get Totals Request message. */
@JsonPropertyOrder({"TotalDetails", "TotalFilter"})
public class GetTotalsRequest {

  @JsonProperty("TotalDetails")
  @Schema(
      description =
          "Indicates the hierarchical structure of the reconciliation result of the Sale to POI reconciliation. --Rule: Require to present totals per value of element included in this cluster (POI Terminal, Sale Terminal, Cashier, Shift,")
  protected List<TotalDetailsType> totalDetails;

  @JsonProperty("TotalFilter")
  @Schema(description = "Filter to compute the totals. --Rule: If structure is not empty")
  protected TotalFilter totalFilter;

  /**
   * Gets total details.
   *
   * @return the total details
   */
  public List<TotalDetailsType> getTotalDetails() {
    if (totalDetails == null) {
      totalDetails = new ArrayList<>();
    }
    return this.totalDetails;
  }

  /**
   * Sets total details.
   *
   * @param totalDetails the total details
   */
  public void setTotalDetails(List<TotalDetailsType> totalDetails) {
    this.totalDetails = totalDetails;
  }

  /**
   * Gets total filter.
   *
   * @return the total filter
   */
  public TotalFilter getTotalFilter() {
    return totalFilter;
  }

  /**
   * Sets total filter.
   *
   * @param totalFilter the total filter
   */
  public void setTotalFilter(TotalFilter totalFilter) {
    this.totalFilter = totalFilter;
  }
}