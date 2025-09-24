package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;

/** Content of the Logout Request message. */
@JsonPropertyOrder({"MaintenanceAllowed"})
public class LogoutRequest {

  @JsonProperty("MaintenanceAllowed")
  @Schema(
      description = "Indicates that the POI terminal is able to (or have to) go to maintenance.")
  protected Boolean maintenanceAllowed;

  /**
   * Is maintenance allowed boolean.
   *
   * @return the boolean
   */
  public boolean isMaintenanceAllowed() {
    if (maintenanceAllowed == null) {
      return false;
    } else {
      return maintenanceAllowed;
    }
  }

  /**
   * Sets maintenance allowed.
   *
   * @param maintenanceAllowed the maintenance allowed
   */
  public void setMaintenanceAllowed(Boolean maintenanceAllowed) {
    this.maintenanceAllowed = maintenanceAllowed;
  }
}
