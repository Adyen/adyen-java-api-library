/*
 * Adyen Recurring API
 *
 * The version of the OpenAPI document: 68
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.recurring;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.OffsetDateTime;
import java.util.*;

/** Permit */
@JsonPropertyOrder({
  Permit.JSON_PROPERTY_PARTNER_ID,
  Permit.JSON_PROPERTY_PROFILE_REFERENCE,
  Permit.JSON_PROPERTY_RESTRICTION,
  Permit.JSON_PROPERTY_RESULT_KEY,
  Permit.JSON_PROPERTY_VALID_TILL_DATE
})
public class Permit {
  public static final String JSON_PROPERTY_PARTNER_ID = "partnerId";
  private String partnerId;

  public static final String JSON_PROPERTY_PROFILE_REFERENCE = "profileReference";
  private String profileReference;

  public static final String JSON_PROPERTY_RESTRICTION = "restriction";
  private PermitRestriction restriction;

  public static final String JSON_PROPERTY_RESULT_KEY = "resultKey";
  private String resultKey;

  public static final String JSON_PROPERTY_VALID_TILL_DATE = "validTillDate";
  private OffsetDateTime validTillDate;

  public Permit() {}

  /**
   * Partner ID (when using the permit-per-partner token sharing model).
   *
   * @param partnerId Partner ID (when using the permit-per-partner token sharing model).
   * @return the current {@code Permit} instance, allowing for method chaining
   */
  public Permit partnerId(String partnerId) {
    this.partnerId = partnerId;
    return this;
  }

  /**
   * Partner ID (when using the permit-per-partner token sharing model).
   *
   * @return partnerId Partner ID (when using the permit-per-partner token sharing model).
   */
  @JsonProperty(JSON_PROPERTY_PARTNER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPartnerId() {
    return partnerId;
  }

  /**
   * Partner ID (when using the permit-per-partner token sharing model).
   *
   * @param partnerId Partner ID (when using the permit-per-partner token sharing model).
   */
  @JsonProperty(JSON_PROPERTY_PARTNER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPartnerId(String partnerId) {
    this.partnerId = partnerId;
  }

  /**
   * The profile to apply to this permit (when using the shared permits model).
   *
   * @param profileReference The profile to apply to this permit (when using the shared permits
   *     model).
   * @return the current {@code Permit} instance, allowing for method chaining
   */
  public Permit profileReference(String profileReference) {
    this.profileReference = profileReference;
    return this;
  }

  /**
   * The profile to apply to this permit (when using the shared permits model).
   *
   * @return profileReference The profile to apply to this permit (when using the shared permits
   *     model).
   */
  @JsonProperty(JSON_PROPERTY_PROFILE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getProfileReference() {
    return profileReference;
  }

  /**
   * The profile to apply to this permit (when using the shared permits model).
   *
   * @param profileReference The profile to apply to this permit (when using the shared permits
   *     model).
   */
  @JsonProperty(JSON_PROPERTY_PROFILE_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProfileReference(String profileReference) {
    this.profileReference = profileReference;
  }

  /**
   * restriction
   *
   * @param restriction
   * @return the current {@code Permit} instance, allowing for method chaining
   */
  public Permit restriction(PermitRestriction restriction) {
    this.restriction = restriction;
    return this;
  }

  /**
   * Get restriction
   *
   * @return restriction
   */
  @JsonProperty(JSON_PROPERTY_RESTRICTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public PermitRestriction getRestriction() {
    return restriction;
  }

  /**
   * restriction
   *
   * @param restriction
   */
  @JsonProperty(JSON_PROPERTY_RESTRICTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRestriction(PermitRestriction restriction) {
    this.restriction = restriction;
  }

  /**
   * The key to link permit requests to permit results.
   *
   * @param resultKey The key to link permit requests to permit results.
   * @return the current {@code Permit} instance, allowing for method chaining
   */
  public Permit resultKey(String resultKey) {
    this.resultKey = resultKey;
    return this;
  }

  /**
   * The key to link permit requests to permit results.
   *
   * @return resultKey The key to link permit requests to permit results.
   */
  @JsonProperty(JSON_PROPERTY_RESULT_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getResultKey() {
    return resultKey;
  }

  /**
   * The key to link permit requests to permit results.
   *
   * @param resultKey The key to link permit requests to permit results.
   */
  @JsonProperty(JSON_PROPERTY_RESULT_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResultKey(String resultKey) {
    this.resultKey = resultKey;
  }

  /**
   * The expiry date for this permit.
   *
   * @param validTillDate The expiry date for this permit.
   * @return the current {@code Permit} instance, allowing for method chaining
   */
  public Permit validTillDate(OffsetDateTime validTillDate) {
    this.validTillDate = validTillDate;
    return this;
  }

  /**
   * The expiry date for this permit.
   *
   * @return validTillDate The expiry date for this permit.
   */
  @JsonProperty(JSON_PROPERTY_VALID_TILL_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getValidTillDate() {
    return validTillDate;
  }

  /**
   * The expiry date for this permit.
   *
   * @param validTillDate The expiry date for this permit.
   */
  @JsonProperty(JSON_PROPERTY_VALID_TILL_DATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setValidTillDate(OffsetDateTime validTillDate) {
    this.validTillDate = validTillDate;
  }

  /** Return true if this Permit object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Permit permit = (Permit) o;
    return Objects.equals(this.partnerId, permit.partnerId)
        && Objects.equals(this.profileReference, permit.profileReference)
        && Objects.equals(this.restriction, permit.restriction)
        && Objects.equals(this.resultKey, permit.resultKey)
        && Objects.equals(this.validTillDate, permit.validTillDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(partnerId, profileReference, restriction, resultKey, validTillDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Permit {\n");
    sb.append("    partnerId: ").append(toIndentedString(partnerId)).append("\n");
    sb.append("    profileReference: ").append(toIndentedString(profileReference)).append("\n");
    sb.append("    restriction: ").append(toIndentedString(restriction)).append("\n");
    sb.append("    resultKey: ").append(toIndentedString(resultKey)).append("\n");
    sb.append("    validTillDate: ").append(toIndentedString(validTillDate)).append("\n");
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
   * Create an instance of Permit given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Permit
   * @throws JsonProcessingException if the JSON string is invalid with respect to Permit
   */
  public static Permit fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, Permit.class);
  }

  /**
   * Convert an instance of Permit to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
