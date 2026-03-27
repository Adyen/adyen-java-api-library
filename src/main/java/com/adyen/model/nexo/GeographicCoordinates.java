package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Location on the Earth specified by two numbers representing vertical and horizontal
 * position. -- Usage: Identifies the geographic location of a mobile phone.
 *
 * <p>Java class for GeographicCoordinates complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="GeographicCoordinates"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="Latitude" type="{}Latitude"/&gt;
 *         &lt;element name="Longitude" type="{}Longitude"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class GeographicCoordinates {

  /** The Latitude. */
  @SerializedName("Latitude")
  @Schema(
      description = "Angular distance of a location on the earth south or north of the equator.")
  protected String latitude;

  /** The Longitude. */
  @SerializedName("Longitude")
  @Schema(
      description =
          "Angular measurement of the distance of a location on the earth east or west of the Greenwich observatory.")
  protected String longitude;

  /**
   * Gets the value of the latitude property.
   *
   * @return possible object is {@link String }
   */
  public String getLatitude() {
    return latitude;
  }

  /**
   * Sets the value of the latitude property.
   *
   * @param value allowed object is {@link String }
   */
  public void setLatitude(String value) {
    this.latitude = value;
  }

  /**
   * Gets the value of the longitude property.
   *
   * @return possible object is {@link String }
   */
  public String getLongitude() {
    return longitude;
  }

  /**
   * Sets the value of the longitude property.
   *
   * @param value allowed object is {@link String }
   */
  public void setLongitude(String value) {
    this.longitude = value;
  }
}
