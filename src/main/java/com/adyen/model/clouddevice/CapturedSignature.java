package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Numeric value of a handwritten signature. */
@JsonPropertyOrder({"AreaSize", "SignaturePoint"})
public class CapturedSignature {

  @JsonProperty("AreaSize")
  @Schema(description = "Size of an area")
  protected AreaSize areaSize;

  @JsonProperty("SignaturePoint")
  @Schema(description = "Coordinates of a point where the pen changes direction or lift.")
  protected List<SignaturePoint> signaturePoint;

  /**
   * Gets area size.
   *
   * @return the area size
   */
  public AreaSize getAreaSize() {
    return areaSize;
  }

  /**
   * Sets area size.
   *
   * @param areaSize the area size
   */
  public void setAreaSize(AreaSize areaSize) {
    this.areaSize = areaSize;
  }

  /**
   * Gets signature point.
   *
   * @return the signature point
   */
  public List<SignaturePoint> getSignaturePoint() {
    if (signaturePoint == null) {
      signaturePoint = new ArrayList<>();
    }
    return this.signaturePoint;
  }

  /**
   * Sets signature point.
   *
   * @param signaturePoint the signature point
   */
  public void setSignaturePoint(List<SignaturePoint> signaturePoint) {
    this.signaturePoint = signaturePoint;
  }
}