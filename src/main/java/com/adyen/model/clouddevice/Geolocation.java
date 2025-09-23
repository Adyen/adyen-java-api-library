package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Geographic location specified by geographic or UTM coordinates. */
@JsonPropertyOrder({"GeographicCoordinates", "UTMCoordinates"})
public class Geolocation {

  @JsonProperty("GeographicCoordinates")
  @Schema(
      description =
          "Location on the Earth specified by two numbers representing vertical and horizontal position.")
  protected GeographicCoordinates geographicCoordinates;

  @JsonProperty("UTMCoordinates")
  @Schema(
      description =
          "Location on the Earth specified by the Universal Transverse Mercator coordinate system.")
  protected UTMCoordinates utmCoordinates;

  /**
   * Gets geographic coordinates.
   *
   * @return the geographic coordinates
   */
  public GeographicCoordinates getGeographicCoordinates() {
    return geographicCoordinates;
  }

  /**
   * Sets geographic coordinates.
   *
   * @param geographicCoordinates the geographic coordinates
   */
  public void setGeographicCoordinates(GeographicCoordinates geographicCoordinates) {
    this.geographicCoordinates = geographicCoordinates;
  }

  /**
   * Gets utm coordinates.
   *
   * @return the utm coordinates
   */
  public UTMCoordinates getUTMCoordinates() {
    return utmCoordinates;
  }

  /**
   * Sets utm coordinates.
   *
   * @param utmCoordinates the utm coordinates
   */
  public void setUTMCoordinates(UTMCoordinates utmCoordinates) {
    this.utmCoordinates = utmCoordinates;
  }
}