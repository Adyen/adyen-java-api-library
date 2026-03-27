package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Location on the Earth specified by the Universal Transverse Mercator coordinate
 * system. -- Usage: Identifies the geographic location of a mobile phone by GPS using the WGS84
 * ellipsoid spatial reference system.
 *
 * <p>Java class for UTMCoordinates complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="UTMCoordinates"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="UTMZone" type="{}UTMZone"/&gt;
 *         &lt;element name="UTMEastward" type="{}UTMEastward"/&gt;
 *         &lt;element name="UTMNorthward" type="{}UTMNorthward"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class UTMCoordinates {

  /** The Utm zone. */
  @SerializedName("UTMZone")
  @Schema(
      description =
          "UTM grid zone combination of the longitude zone (1 to 60) and the latitude band (C to X, excluding I and O).")
  protected String utmZone;

  /** The Utm eastward. */
  @SerializedName("UTMEastward")
  @Schema(description = "X-coordinate of the Universal Transverse Mercator coordinate system.")
  protected String utmEastward;

  /** The Utm northward. */
  @SerializedName("UTMNorthward")
  @Schema(description = "Y-coordinate of the Universal Transverse Mercator coordinate system.")
  protected String utmNorthward;

  /**
   * Gets the value of the utmZone property.
   *
   * @return possible object is {@link String }
   */
  public String getUTMZone() {
    return utmZone;
  }

  /**
   * Sets the value of the utmZone property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUTMZone(String value) {
    this.utmZone = value;
  }

  /**
   * Gets the value of the utmEastward property.
   *
   * @return possible object is {@link String }
   */
  public String getUTMEastward() {
    return utmEastward;
  }

  /**
   * Sets the value of the utmEastward property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUTMEastward(String value) {
    this.utmEastward = value;
  }

  /**
   * Gets the value of the utmNorthward property.
   *
   * @return possible object is {@link String }
   */
  public String getUTMNorthward() {
    return utmNorthward;
  }

  /**
   * Sets the value of the utmNorthward property.
   *
   * @param value allowed object is {@link String }
   */
  public void setUTMNorthward(String value) {
    this.utmNorthward = value;
  }
}
