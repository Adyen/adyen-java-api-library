package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Product that are payable by the payment card. */
@JsonPropertyOrder({"ProductLabel", "AdditionalProductInfo", "ProductCode", "EanUpc"})
public class AllowedProduct {

  @JsonProperty("ProductLabel")
  @Schema(description = "Product name of an item purchased with the transaction.")
  protected String productLabel;

  @JsonProperty("AdditionalProductInfo")
  @Schema(description = "Additionl information related to the line item.")
  protected String additionalProductInfo;

  @JsonProperty("ProductCode")
  @Schema(description = "Product code of item purchased with the transaction.")
  protected String productCode;

  @JsonProperty("EanUpc")
  @Schema(description = "Standard product code of item purchased with the transaction.")
  protected String eanUpc;

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
}
