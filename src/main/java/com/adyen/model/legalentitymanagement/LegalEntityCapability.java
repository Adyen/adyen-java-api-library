/*
 * Legal Entity Management API
 *
 * The version of the OpenAPI document: 3
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.legalentitymanagement;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/** LegalEntityCapability */
@JsonPropertyOrder({
  LegalEntityCapability.JSON_PROPERTY_ALLOWED,
  LegalEntityCapability.JSON_PROPERTY_ALLOWED_LEVEL,
  LegalEntityCapability.JSON_PROPERTY_ALLOWED_SETTINGS,
  LegalEntityCapability.JSON_PROPERTY_REQUESTED,
  LegalEntityCapability.JSON_PROPERTY_REQUESTED_LEVEL,
  LegalEntityCapability.JSON_PROPERTY_REQUESTED_SETTINGS,
  LegalEntityCapability.JSON_PROPERTY_TRANSFER_INSTRUMENTS,
  LegalEntityCapability.JSON_PROPERTY_VERIFICATION_STATUS
})
public class LegalEntityCapability {
  public static final String JSON_PROPERTY_ALLOWED = "allowed";
  private Boolean allowed;

  /**
   * The capability level that is allowed for the legal entity. Possible values: **notApplicable**,
   * **low**, **medium**, **high**.
   */
  public enum AllowedLevelEnum {
    HIGH(String.valueOf("high")),

    LOW(String.valueOf("low")),

    MEDIUM(String.valueOf("medium")),

    NOTAPPLICABLE(String.valueOf("notApplicable"));

    private static final Logger LOG = Logger.getLogger(AllowedLevelEnum.class.getName());

    private String value;

    AllowedLevelEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static AllowedLevelEnum fromValue(String value) {
      for (AllowedLevelEnum b : AllowedLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "AllowedLevelEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(AllowedLevelEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_ALLOWED_LEVEL = "allowedLevel";
  private AllowedLevelEnum allowedLevel;

  public static final String JSON_PROPERTY_ALLOWED_SETTINGS = "allowedSettings";
  private CapabilitySettings allowedSettings;

  public static final String JSON_PROPERTY_REQUESTED = "requested";
  private Boolean requested;

  /**
   * The requested level of the capability. Some capabilities, such as those used in [card
   * issuing](https://docs.adyen.com/issuing/add-capabilities#capability-levels), have different
   * levels. Levels increase the capability, but also require additional checks and increased
   * monitoring. Possible values: **notApplicable**, **low**, **medium**, **high**.
   */
  public enum RequestedLevelEnum {
    HIGH(String.valueOf("high")),

    LOW(String.valueOf("low")),

    MEDIUM(String.valueOf("medium")),

    NOTAPPLICABLE(String.valueOf("notApplicable"));

    private static final Logger LOG = Logger.getLogger(RequestedLevelEnum.class.getName());

    private String value;

    RequestedLevelEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static RequestedLevelEnum fromValue(String value) {
      for (RequestedLevelEnum b : RequestedLevelEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "RequestedLevelEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(RequestedLevelEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_REQUESTED_LEVEL = "requestedLevel";
  private RequestedLevelEnum requestedLevel;

  public static final String JSON_PROPERTY_REQUESTED_SETTINGS = "requestedSettings";
  private CapabilitySettings requestedSettings;

  public static final String JSON_PROPERTY_TRANSFER_INSTRUMENTS = "transferInstruments";
  private List<SupportingEntityCapability> transferInstruments;

  public static final String JSON_PROPERTY_VERIFICATION_STATUS = "verificationStatus";
  private String verificationStatus;

  public LegalEntityCapability() {}

  @JsonCreator
  public LegalEntityCapability(
      @JsonProperty(JSON_PROPERTY_ALLOWED) Boolean allowed,
      @JsonProperty(JSON_PROPERTY_ALLOWED_LEVEL) AllowedLevelEnum allowedLevel,
      @JsonProperty(JSON_PROPERTY_REQUESTED) Boolean requested,
      @JsonProperty(JSON_PROPERTY_REQUESTED_LEVEL) RequestedLevelEnum requestedLevel,
      @JsonProperty(JSON_PROPERTY_TRANSFER_INSTRUMENTS)
          List<SupportingEntityCapability> transferInstruments,
      @JsonProperty(JSON_PROPERTY_VERIFICATION_STATUS) String verificationStatus) {
    this();
    this.allowed = allowed;
    this.allowedLevel = allowedLevel;
    this.requested = requested;
    this.requestedLevel = requestedLevel;
    this.transferInstruments = transferInstruments;
    this.verificationStatus = verificationStatus;
  }

  /**
   * Indicates whether the capability is allowed. Adyen sets this to **true** if the verification is
   * successful.
   *
   * @return allowed Indicates whether the capability is allowed. Adyen sets this to **true** if the
   *     verification is successful.
   */
  @JsonProperty(JSON_PROPERTY_ALLOWED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getAllowed() {
    return allowed;
  }

  /**
   * The capability level that is allowed for the legal entity. Possible values: **notApplicable**,
   * **low**, **medium**, **high**.
   *
   * @return allowedLevel The capability level that is allowed for the legal entity. Possible
   *     values: **notApplicable**, **low**, **medium**, **high**.
   */
  @JsonProperty(JSON_PROPERTY_ALLOWED_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public AllowedLevelEnum getAllowedLevel() {
    return allowedLevel;
  }

  /**
   * allowedSettings
   *
   * @param allowedSettings
   * @return the current {@code LegalEntityCapability} instance, allowing for method chaining
   */
  public LegalEntityCapability allowedSettings(CapabilitySettings allowedSettings) {
    this.allowedSettings = allowedSettings;
    return this;
  }

  /**
   * Get allowedSettings
   *
   * @return allowedSettings
   */
  @JsonProperty(JSON_PROPERTY_ALLOWED_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public CapabilitySettings getAllowedSettings() {
    return allowedSettings;
  }

  /**
   * allowedSettings
   *
   * @param allowedSettings
   */
  @JsonProperty(JSON_PROPERTY_ALLOWED_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAllowedSettings(CapabilitySettings allowedSettings) {
    this.allowedSettings = allowedSettings;
  }

  /**
   * Indicates whether the capability is requested. To check whether the legal entity is permitted
   * to use the capability, refer to the &#x60;allowed&#x60; field.
   *
   * @return requested Indicates whether the capability is requested. To check whether the legal
   *     entity is permitted to use the capability, refer to the &#x60;allowed&#x60; field.
   */
  @JsonProperty(JSON_PROPERTY_REQUESTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getRequested() {
    return requested;
  }

  /**
   * The requested level of the capability. Some capabilities, such as those used in [card
   * issuing](https://docs.adyen.com/issuing/add-capabilities#capability-levels), have different
   * levels. Levels increase the capability, but also require additional checks and increased
   * monitoring. Possible values: **notApplicable**, **low**, **medium**, **high**.
   *
   * @return requestedLevel The requested level of the capability. Some capabilities, such as those
   *     used in [card issuing](https://docs.adyen.com/issuing/add-capabilities#capability-levels),
   *     have different levels. Levels increase the capability, but also require additional checks
   *     and increased monitoring. Possible values: **notApplicable**, **low**, **medium**,
   *     **high**.
   */
  @JsonProperty(JSON_PROPERTY_REQUESTED_LEVEL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public RequestedLevelEnum getRequestedLevel() {
    return requestedLevel;
  }

  /**
   * requestedSettings
   *
   * @param requestedSettings
   * @return the current {@code LegalEntityCapability} instance, allowing for method chaining
   */
  public LegalEntityCapability requestedSettings(CapabilitySettings requestedSettings) {
    this.requestedSettings = requestedSettings;
    return this;
  }

  /**
   * Get requestedSettings
   *
   * @return requestedSettings
   */
  @JsonProperty(JSON_PROPERTY_REQUESTED_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public CapabilitySettings getRequestedSettings() {
    return requestedSettings;
  }

  /**
   * requestedSettings
   *
   * @param requestedSettings
   */
  @JsonProperty(JSON_PROPERTY_REQUESTED_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRequestedSettings(CapabilitySettings requestedSettings) {
    this.requestedSettings = requestedSettings;
  }

  /**
   * The capability status of transfer instruments associated with the legal entity.
   *
   * @return transferInstruments The capability status of transfer instruments associated with the
   *     legal entity.
   */
  @JsonProperty(JSON_PROPERTY_TRANSFER_INSTRUMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<SupportingEntityCapability> getTransferInstruments() {
    return transferInstruments;
  }

  /**
   * The status of the verification checks for the capability. Possible values: * **pending**: Adyen
   * is running the verification. * **invalid**: The verification failed. Check if the
   * &#x60;errors&#x60; array contains more information. * **valid**: The verification has been
   * successfully completed. * **rejected**: Adyen has verified the information, but found reasons
   * to not allow the capability.
   *
   * @return verificationStatus The status of the verification checks for the capability. Possible
   *     values: * **pending**: Adyen is running the verification. * **invalid**: The verification
   *     failed. Check if the &#x60;errors&#x60; array contains more information. * **valid**: The
   *     verification has been successfully completed. * **rejected**: Adyen has verified the
   *     information, but found reasons to not allow the capability.
   */
  @JsonProperty(JSON_PROPERTY_VERIFICATION_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getVerificationStatus() {
    return verificationStatus;
  }

  /** Return true if this LegalEntityCapability object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LegalEntityCapability legalEntityCapability = (LegalEntityCapability) o;
    return Objects.equals(this.allowed, legalEntityCapability.allowed)
        && Objects.equals(this.allowedLevel, legalEntityCapability.allowedLevel)
        && Objects.equals(this.allowedSettings, legalEntityCapability.allowedSettings)
        && Objects.equals(this.requested, legalEntityCapability.requested)
        && Objects.equals(this.requestedLevel, legalEntityCapability.requestedLevel)
        && Objects.equals(this.requestedSettings, legalEntityCapability.requestedSettings)
        && Objects.equals(this.transferInstruments, legalEntityCapability.transferInstruments)
        && Objects.equals(this.verificationStatus, legalEntityCapability.verificationStatus);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        allowed,
        allowedLevel,
        allowedSettings,
        requested,
        requestedLevel,
        requestedSettings,
        transferInstruments,
        verificationStatus);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LegalEntityCapability {\n");
    sb.append("    allowed: ").append(toIndentedString(allowed)).append("\n");
    sb.append("    allowedLevel: ").append(toIndentedString(allowedLevel)).append("\n");
    sb.append("    allowedSettings: ").append(toIndentedString(allowedSettings)).append("\n");
    sb.append("    requested: ").append(toIndentedString(requested)).append("\n");
    sb.append("    requestedLevel: ").append(toIndentedString(requestedLevel)).append("\n");
    sb.append("    requestedSettings: ").append(toIndentedString(requestedSettings)).append("\n");
    sb.append("    transferInstruments: ")
        .append(toIndentedString(transferInstruments))
        .append("\n");
    sb.append("    verificationStatus: ").append(toIndentedString(verificationStatus)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Create an instance of LegalEntityCapability given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of LegalEntityCapability
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     LegalEntityCapability
   */
  public static LegalEntityCapability fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, LegalEntityCapability.class);
  }

  /**
   * Convert an instance of LegalEntityCapability to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
