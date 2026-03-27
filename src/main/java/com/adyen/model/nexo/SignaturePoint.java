package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Coordinates of a point where the pen changes direction or lift. -- Usage: Contain the
 * Coordinates of a point of the written signature where the pen changes direction or lift where (X
 * and Y).When the signer lifts the pen, both X and Y have the value "FFFF".
 *
 * <p>Java class for SignaturePoint complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="SignaturePoint"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="X" use="required" type="{}X" /&gt;
 *       &lt;attribute name="Y" use="required" type="{}Y" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class SignaturePoint {

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
