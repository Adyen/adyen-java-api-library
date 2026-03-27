package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: BarCode content to display or print. -- Usage: Various usage of barcode
 *
 * <p>Java class for OutputBarcode complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="OutputBarcode"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="BarcodeValue" use="required" type="{}BarcodeValue" /&gt;
 *       &lt;attribute name="BarcodeType" type="{}BarcodeType" default="EAN13" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class OutputBarcode {

  @SerializedName("BarcodeValue")
  @Schema(description = "Value with a BarCode coding.")
  protected String barcodeValue;

  @SerializedName("BarcodeType")
  @Schema(description = "Type of BarCode coding.")
  protected BarcodeType barcodeType;

  /**
   * Gets the value of the barcodeValue property.
   *
   * @return possible object is {@link String }
   */
  public String getBarcodeValue() {
    return barcodeValue;
  }

  /**
   * Sets the value of the barcodeValue property.
   *
   * @param value allowed object is {@link String }
   */
  public void setBarcodeValue(String value) {
    this.barcodeValue = value;
  }

  /**
   * Gets the value of the barcodeType property.
   *
   * @return possible object is {@link BarcodeType }
   */
  public BarcodeType getBarcodeType() {
    if (barcodeType == null) {
      return BarcodeType.EAN_13;
    } else {
      return barcodeType;
    }
  }

  /**
   * Sets the value of the barcodeType property.
   *
   * @param value allowed object is {@link BarcodeType }
   */
  public void setBarcodeType(BarcodeType value) {
    this.barcodeType = value;
  }
}
