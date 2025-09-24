package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/** Rebate form to an award. */
@JsonPropertyOrder({"TotalRebate", "RebateLabel", "SaleItemRebate"})
public class Rebates {

  @JsonProperty("TotalRebate")
  @Schema(
      description =
          "The global awarded amount that is not attached to an item. --Rule: If rebate on the total amount for this loyalty program")
  protected BigDecimal totalRebate;

  @JsonProperty("RebateLabel")
  @Schema(
      description =
          "Short text to qualify a rebate on an line item. --Rule: If provided by the Acquirer")
  protected String rebateLabel;

  @JsonProperty("SaleItemRebate")
  @Schema(
      description =
          "The awarded amount that is attached to an item as a rebate. --Rule: only items with rebate (identified by ItemID)")
  protected List<SaleItemRebate> saleItemRebate;

  /**
   * Gets total rebate.
   *
   * @return the total rebate
   */
  public BigDecimal getTotalRebate() {
    return totalRebate;
  }

  /**
   * Sets total rebate.
   *
   * @param totalRebate the total rebate
   */
  public void setTotalRebate(BigDecimal totalRebate) {
    this.totalRebate = totalRebate;
  }

  /**
   * Gets rebate label.
   *
   * @return the rebate label
   */
  public String getRebateLabel() {
    return rebateLabel;
  }

  /**
   * Sets rebate label.
   *
   * @param rebateLabel the rebate label
   */
  public void setRebateLabel(String rebateLabel) {
    this.rebateLabel = rebateLabel;
  }

  /**
   * Gets sale item rebate.
   *
   * @return the sale item rebate
   */
  public List<SaleItemRebate> getSaleItemRebate() {
    if (saleItemRebate == null) {
      saleItemRebate = new ArrayList<>();
    }
    return this.saleItemRebate;
  }

  /**
   * Sets sale item rebate.
   *
   * @param saleItemRebate the sale item rebate
   */
  public void setSaleItemRebate(List<SaleItemRebate> saleItemRebate) {
    this.saleItemRebate = saleItemRebate;
  }
}
