package com.adyen.model.clouddevice;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.ArrayList;
import java.util.List;

/** Functional profile of the Sale Terminal. */
@JsonPropertyOrder({"ServiceProfiles", "GenericProfile"})
public class SaleProfile {

  @JsonProperty("ServiceProfiles")
  @Schema(
      description =
          "Service profiles of the Sale to POI protocol. --Rule: If a service profile could be requested")
  protected List<ServiceProfilesType> serviceProfiles;

  @JsonProperty("GenericProfile")
  @Schema(description = "Functional profile of the Sale to POI protocol.")
  protected GenericProfileType genericProfile;

  /**
   * Gets service profiles.
   *
   * @return the service profiles
   */
  public List<ServiceProfilesType> getServiceProfiles() {
    if (serviceProfiles == null) {
      serviceProfiles = new ArrayList<>();
    }
    return this.serviceProfiles;
  }

  /**
   * Sets service profiles.
   *
   * @param serviceProfiles the service profiles
   */
  public void setServiceProfiles(List<ServiceProfilesType> serviceProfiles) {
    this.serviceProfiles = serviceProfiles;
  }

  /**
   * Gets generic profile.
   *
   * @return the generic profile
   */
  public GenericProfileType getGenericProfile() {
    if (genericProfile == null) {
      return GenericProfileType.STANDARD;
    } else {
      return genericProfile;
    }
  }

  /**
   * Sets generic profile.
   *
   * @param genericProfile the generic profile
   */
  public void setGenericProfile(GenericProfileType genericProfile) {
    this.genericProfile = genericProfile;
  }
}