package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.math.BigInteger;

/** The awarded amount that is attached to an item as a rebate. */
@JsonPropertyOrder({
    "UnitOfMeasure",
    "Quantity",
    "RebateLabel",
    "ItemID",
    "ProductCode",
    "EanUpc",
    "ItemAmount"
})
public class SaleItemRebate {

  @JsonProperty("UnitOfMeasure")
  @Schema(description = "Unit of measure of a quantity --Rule: if Quantity present")
  protected UnitOfMeasureType unitOfMeasure;

  @JsonProperty("Quantity")
  @Schema(description = "Product quantity --Rule: if rebate is additional units")
  protected BigDecimal quantity;

  @JsonProperty("RebateLabel")
  @Schema(
      description =
          "Short text to qualify a rebate on an line item. --Rule: If provided by the Acquirer")
  protected String rebateLabel;

  @JsonProperty("ItemID")
  @Schema(description = "Item identification inside a transaction (0 to n).")
  protected BigInteger itemID;

  @JsonProperty("ProductCode")
  @Schema(description = "Product code of item purchased with the transaction.")
  protected String productCode;

  @JsonProperty("EanUpc")
  @Schema(
      description =
          "Standard product code of item purchased with the transaction. --Rule: if present in the related SaleItem")
  protected String eanUpc;

  @JsonProperty("ItemAmount")
  @Schema(description = "Total amount of the item line. --Rule: if rebate on the line item amount")
  protected BigDecimal itemAmount;

  /**
   * Gets unit of measure.
   *
   * @return the unit of measure
   */
  public UnitOfMeasureType getUnitOfMeasure() {
    return unitOfMeasure;
  }

  /**
   * Sets unit of measure.
   *
   * @param unitOfMeasure the unit of measure
   */
  public void setUnitOfMeasure(UnitOfMeasureType unitOfMeasure) {
    this.unitOfMeasure = unitOfMeasure;
  }

  /**
   * Gets quantity.
   *
   * @return the quantity
   */
  public BigDecimal getQuantity() {
    return quantity;
  }

  /**
   * Sets quantity.
   *
   * @param quantity the quantity
   */
  public void setQuantity(BigDecimal quantity) {
    this.quantity = quantity;
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
   * Gets item id.
   *
   * @return the item id
   */
  public BigInteger getItemID() {
    return itemID;
  }

  /**
   * Sets item id.
   *
   * @param itemID the item id
   */
  public void setItemID(BigInteger itemID) {
    this.itemID = itemID;
  }

  /**
   * Gets product code.
   *
   * @return the product code
   */
  public String getProductCode() {
    return productCode;
  }

  /**
   * Sets product code.
   *
   * @param productCode the product code
   */
  public void setProductCode(String productCode) {
    this.productCode = productCode;
  }

  /**
   * Gets ean upc.
   *
   * @return the ean upc
   */
  public String getEanUpc() {
    return eanUpc;
  }

  /**
   * Sets ean upc.
   *
   * @param eanUpc the ean upc
   */
  public void setEanUpc(String eanUpc) {
    this.eanUpc = eanUpc;
  }

  /**
   * Gets item amount.
   *
   * @return the item amount
   */
  public BigDecimal getItemAmount() {
    return itemAmount;
  }

  /**
   * Sets item amount.
   *
   * @param itemAmount the item amount
   */
  public void setItemAmount(BigDecimal itemAmount) {
    this.itemAmount = itemAmount;
  }
}