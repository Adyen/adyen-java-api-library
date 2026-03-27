package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: State of a Host. -- Usage: Indicate the reachability of the host by the POI Terminal.
 *
 * <p>Java class for HostStatus complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="HostStatus"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="AcquirerID" use="required" type="{}AcquirerID" /&gt;
 *       &lt;attribute name="IsReachableFlag" type="{}IsReachableFlag" default="true" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class HostStatus {

  /** The Acquirer id. */
  @SerializedName("AcquirerID")
  @Schema(description = "Identification of the Acquirer")
  protected String acquirerID;

  /** The Is reachable flag. */
  @SerializedName("IsReachableFlag")
  @Schema(description = "Indicate if a Host is reachable")
  protected Boolean isReachableFlag;

  /**
   * Gets the value of the acquirerID property.
   *
   * @return possible object is {@link String }
   */
  public String getAcquirerID() {
    return acquirerID;
  }

  /**
   * Sets the value of the acquirerID property.
   *
   * @param value allowed object is {@link String }
   */
  public void setAcquirerID(String value) {
    this.acquirerID = value;
  }

  /**
   * Gets the value of the isReachableFlag property.
   *
   * @return possible object is {@link Boolean }
   */
  public boolean isIsReachableFlag() {
    if (isReachableFlag == null) {
      return true;
    } else {
      return isReachableFlag;
    }
  }

  /**
   * Sets the value of the isReachableFlag property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setIsReachableFlag(Boolean value) {
    this.isReachableFlag = value;
  }
}
