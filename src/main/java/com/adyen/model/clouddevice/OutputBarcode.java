package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** BarCode content to display or print. */
@JsonPropertyOrder({"BarcodeValue", "BarcodeType"})
public class OutputBarcode {

  @JsonProperty("BarcodeValue")
  @Schema(description = "Value with a BarCode coding.")
  protected String barcodeValue;

  @JsonProperty("BarcodeType")
  @Schema(description = "Type of BarCode coding.")
  protected BarcodeType barcodeType;

  /**
   * Gets barcode value.
   *
   * @return the barcode value
   */
  public String getBarcodeValue() {
    return barcodeValue;
  }

  /**
   * Sets barcode value.
   *
   * @param barcodeValue the barcode value
   */
  public void setBarcodeValue(String barcodeValue) {
    this.barcodeValue = barcodeValue;
  }

  /**
   * Gets barcode type.
   *
   * @return the barcode type
   */
  public BarcodeType getBarcodeType() {
    if (barcodeType == null) {
      return BarcodeType.EAN_13;
    } else {
      return barcodeType;
    }
  }

  /**
   * Sets barcode type.
   *
   * @param barcodeType the barcode type
   */
  public void setBarcodeType(BarcodeType barcodeType) {
    this.barcodeType = barcodeType;
  }
}