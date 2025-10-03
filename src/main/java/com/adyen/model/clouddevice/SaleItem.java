package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import java.math.BigInteger;

/** Sale items of a transaction. */
@JsonPropertyOrder({
  "UnitOfMeasure",
  "Quantity",
  "UnitPrice",
  "TaxCode",
  "SaleChannel",
  "ProductLabel",
  "AdditionalProductInfo",
  "ItemID",
  "ProductCode",
  "EanUpc",
  "ItemAmount"
})
public class SaleItem {

  @JsonProperty("UnitOfMeasure")
  @Schema(description = "Unit of measure of a quantity --Rule: if Quantity present")
  protected UnitOfMeasureType unitOfMeasure;

  @JsonProperty("Quantity")
  @Schema(
      description =
          "Product quantity --Rule: If data sent, POI has to store it and send it if the host protocol allows it")
  protected BigDecimal quantity;

  @JsonProperty("UnitPrice")
  @Schema(description = "Price per unit of product --Rule: if Quantity present")
  protected BigDecimal unitPrice;

  @JsonProperty("TaxCode")
  @Schema(
      description =
          "Type of taxes associated to the line item. --Rule: If data sent, POI has to store it and send it if the host protocol allows it")
  protected String taxCode;

  @JsonProperty("SaleChannel")
  @Schema(
      description =
          "Commercial or distribution channel associated to the line item. --Rule: If data sent, POI has to store it and send it if the host protocol allows it")
  protected String saleChannel;

  @JsonProperty("ProductLabel")
  @Schema(description = "Product name of an item purchased with the transaction.")
  protected String productLabel;

  @JsonProperty("AdditionalProductInfo")
  @Schema(
      description =
          "Additionl information related to the line item. --Rule: If data sent, POI has to store it and send it if the host protocol allows it")
  protected String additionalProductInfo;

  @JsonProperty("ItemID")
  @Schema(description = "Item identification inside a transaction (0 to n).")
  protected BigInteger itemID;

  @JsonProperty("ProductCode")
  @Schema(description = "Product code of item purchased with the transaction.")
  protected String productCode;

  @JsonProperty("EanUpc")
  @Schema(
      description =
          "Standard product code of item purchased with the transaction. --Rule: If data sent, POI has to store it and send it if the host protocol allows it")
  protected String eanUpc;

  @JsonProperty("ItemAmount")
  @Schema(description = "Total amount of the item line.")
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
   * Gets unit price.
   *
   * @return the unit price
   */
  public BigDecimal getUnitPrice() {
    return unitPrice;
  }

  /**
   * Sets unit price.
   *
   * @param unitPrice the unit price
   */
  public void setUnitPrice(BigDecimal unitPrice) {
    this.unitPrice = unitPrice;
  }

  /**
   * Gets tax code.
   *
   * @return the tax code
   */
  public String getTaxCode() {
    return taxCode;
  }

  /**
   * Sets tax code.
   *
   * @param taxCode the tax code
   */
  public void setTaxCode(String taxCode) {
    this.taxCode = taxCode;
  }

  /**
   * Gets sale channel.
   *
   * @return the sale channel
   */
  public String getSaleChannel() {
    return saleChannel;
  }

  /**
   * Sets sale channel.
   *
   * @param saleChannel the sale channel
   */
  public void setSaleChannel(String saleChannel) {
    this.saleChannel = saleChannel;
  }

  /**
   * Gets product label.
   *
   * @return the product label
   */
  public String getProductLabel() {
    return productLabel;
  }

  /**
   * Sets product label.
   *
   * @param productLabel the product label
   */
  public void setProductLabel(String productLabel) {
    this.productLabel = productLabel;
  }

  /**
   * Gets additional product info.
   *
   * @return the additional product info
   */
  public String getAdditionalProductInfo() {
    return additionalProductInfo;
  }

  /**
   * Sets additional product info.
   *
   * @param additionalProductInfo the additional product info
   */
  public void setAdditionalProductInfo(String additionalProductInfo) {
    this.additionalProductInfo = additionalProductInfo;
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
