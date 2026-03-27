package com.adyen.model.nexo;

import com.google.gson.annotations.SerializedName;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Definition: Content of the Logout Request messageType. -- Usage: Empty
 *
 * <p>Java class for LogoutRequest complex type.
 *
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * &lt;complexType name="LogoutRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;attribute name="MaintenanceAllowed" type="{}MaintenanceAllowed" default="false" /&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 */
public class LogoutRequest {

  /** The Maintenance allowed. */
  @SerializedName("MaintenanceAllowed")
  @Schema(
      description = "Indicates that the POI terminal is able to (or have to) go to maintenance.")
  protected Boolean maintenanceAllowed;

  /**
   * Gets the value of the maintenanceAllowed property.
   *
   * @return possible object is {@link Boolean }
   */
  public boolean isMaintenanceAllowed() {
    if (maintenanceAllowed == null) {
      return false;
    } else {
      return maintenanceAllowed;
    }
  }

  /**
   * Sets the value of the maintenanceAllowed property.
   *
   * @param value allowed object is {@link Boolean }
   */
  public void setMaintenanceAllowed(Boolean value) {
    this.maintenanceAllowed = value;
  }
}
