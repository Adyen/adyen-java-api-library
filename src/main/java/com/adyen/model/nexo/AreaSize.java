package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Size of an area -- Usage: Contain the size of the pad area where the signature is
 * written, given with the maximum abissa and ordinate values (X and Y). The maximum value is
 * "FFFF".
 *
 * <p>Java class for AreaSize complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="AreaSize"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="X" use="required" type="{}X" /&gt;
 *       &lt;attribute name="Y" use="required" type="{}Y" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class AreaSize {

  /** The X. */
  @SerializedName("X")
  @Schema(description = "Abscissa of a point coordinates.")
  protected String x;

  /** The Y. */
  @SerializedName("Y")
  @Schema(description = "Ordinate of a point coordinates.")
  protected String y;

  /**
   * Gets the value of the x property.
   *
   * @return possible object is {@link String }
   */
  public String getX() {
    return x;
  }

  /**
   * Sets the value of the x property.
   *
   * @param value allowed object is {@link String }
   */
  public void setX(String value) {
    this.x = value;
  }

  /**
   * Gets the value of the y property.
   *
   * @return possible object is {@link String }
   */
  public String getY() {
    return y;
  }

  /**
   * Sets the value of the y property.
   *
   * @param value allowed object is {@link String }
   */
  public void setY(String value) {
    this.y = value;
  }
}
