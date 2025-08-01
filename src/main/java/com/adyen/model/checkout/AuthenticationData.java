/*
 * Adyen Checkout API
 *
 * The version of the OpenAPI document: 71
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.checkout;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.Arrays;
import java.util.logging.Logger;

/** AuthenticationData */
@JsonPropertyOrder({
  AuthenticationData.JSON_PROPERTY_ATTEMPT_AUTHENTICATION,
  AuthenticationData.JSON_PROPERTY_AUTHENTICATION_ONLY,
  AuthenticationData.JSON_PROPERTY_THREE_D_S_REQUEST_DATA
})
public class AuthenticationData {
  /**
   * Indicates when 3D Secure authentication should be attempted. This overrides all other rules,
   * including [Dynamic 3D Secure
   * settings](https://docs.adyen.com/risk-management/dynamic-3d-secure). Possible values: *
   * **always**: Perform 3D Secure authentication. * **never**: Don&#39;t perform 3D Secure
   * authentication. If PSD2 SCA or other national regulations require authentication, the
   * transaction gets declined.
   */
  public enum AttemptAuthenticationEnum {
    ALWAYS(String.valueOf("always")),

    NEVER(String.valueOf("never"));

    private static final Logger LOG = Logger.getLogger(AttemptAuthenticationEnum.class.getName());

    private String value;

    AttemptAuthenticationEnum(String value) {
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
    public static AttemptAuthenticationEnum fromValue(String value) {
      for (AttemptAuthenticationEnum b : AttemptAuthenticationEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "AttemptAuthenticationEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(AttemptAuthenticationEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_ATTEMPT_AUTHENTICATION = "attemptAuthentication";
  private AttemptAuthenticationEnum attemptAuthentication;

  public static final String JSON_PROPERTY_AUTHENTICATION_ONLY = "authenticationOnly";
  private Boolean authenticationOnly;

  public static final String JSON_PROPERTY_THREE_D_S_REQUEST_DATA = "threeDSRequestData";
  private ThreeDSRequestData threeDSRequestData;

  public AuthenticationData() {}

  /**
   * Indicates when 3D Secure authentication should be attempted. This overrides all other rules,
   * including [Dynamic 3D Secure
   * settings](https://docs.adyen.com/risk-management/dynamic-3d-secure). Possible values: *
   * **always**: Perform 3D Secure authentication. * **never**: Don&#39;t perform 3D Secure
   * authentication. If PSD2 SCA or other national regulations require authentication, the
   * transaction gets declined.
   *
   * @param attemptAuthentication Indicates when 3D Secure authentication should be attempted. This
   *     overrides all other rules, including [Dynamic 3D Secure
   *     settings](https://docs.adyen.com/risk-management/dynamic-3d-secure). Possible values: *
   *     **always**: Perform 3D Secure authentication. * **never**: Don&#39;t perform 3D Secure
   *     authentication. If PSD2 SCA or other national regulations require authentication, the
   *     transaction gets declined.
   * @return the current {@code AuthenticationData} instance, allowing for method chaining
   */
  public AuthenticationData attemptAuthentication(AttemptAuthenticationEnum attemptAuthentication) {
    this.attemptAuthentication = attemptAuthentication;
    return this;
  }

  /**
   * Indicates when 3D Secure authentication should be attempted. This overrides all other rules,
   * including [Dynamic 3D Secure
   * settings](https://docs.adyen.com/risk-management/dynamic-3d-secure). Possible values: *
   * **always**: Perform 3D Secure authentication. * **never**: Don&#39;t perform 3D Secure
   * authentication. If PSD2 SCA or other national regulations require authentication, the
   * transaction gets declined.
   *
   * @return attemptAuthentication Indicates when 3D Secure authentication should be attempted. This
   *     overrides all other rules, including [Dynamic 3D Secure
   *     settings](https://docs.adyen.com/risk-management/dynamic-3d-secure). Possible values: *
   *     **always**: Perform 3D Secure authentication. * **never**: Don&#39;t perform 3D Secure
   *     authentication. If PSD2 SCA or other national regulations require authentication, the
   *     transaction gets declined.
   */
  @JsonProperty(JSON_PROPERTY_ATTEMPT_AUTHENTICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public AttemptAuthenticationEnum getAttemptAuthentication() {
    return attemptAuthentication;
  }

  /**
   * Indicates when 3D Secure authentication should be attempted. This overrides all other rules,
   * including [Dynamic 3D Secure
   * settings](https://docs.adyen.com/risk-management/dynamic-3d-secure). Possible values: *
   * **always**: Perform 3D Secure authentication. * **never**: Don&#39;t perform 3D Secure
   * authentication. If PSD2 SCA or other national regulations require authentication, the
   * transaction gets declined.
   *
   * @param attemptAuthentication Indicates when 3D Secure authentication should be attempted. This
   *     overrides all other rules, including [Dynamic 3D Secure
   *     settings](https://docs.adyen.com/risk-management/dynamic-3d-secure). Possible values: *
   *     **always**: Perform 3D Secure authentication. * **never**: Don&#39;t perform 3D Secure
   *     authentication. If PSD2 SCA or other national regulations require authentication, the
   *     transaction gets declined.
   */
  @JsonProperty(JSON_PROPERTY_ATTEMPT_AUTHENTICATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAttemptAuthentication(AttemptAuthenticationEnum attemptAuthentication) {
    this.attemptAuthentication = attemptAuthentication;
  }

  /**
   * Required to trigger the [authentication-only
   * flow](https://docs.adyen.com/online-payments/3d-secure/authentication-only/). If set to
   * **true**, you will only perform the 3D Secure 2 authentication, and will not proceed to the
   * payment authorization. Default: **false**.
   *
   * @param authenticationOnly Required to trigger the [authentication-only
   *     flow](https://docs.adyen.com/online-payments/3d-secure/authentication-only/). If set to
   *     **true**, you will only perform the 3D Secure 2 authentication, and will not proceed to the
   *     payment authorization. Default: **false**.
   * @return the current {@code AuthenticationData} instance, allowing for method chaining
   */
  public AuthenticationData authenticationOnly(Boolean authenticationOnly) {
    this.authenticationOnly = authenticationOnly;
    return this;
  }

  /**
   * Required to trigger the [authentication-only
   * flow](https://docs.adyen.com/online-payments/3d-secure/authentication-only/). If set to
   * **true**, you will only perform the 3D Secure 2 authentication, and will not proceed to the
   * payment authorization. Default: **false**.
   *
   * @return authenticationOnly Required to trigger the [authentication-only
   *     flow](https://docs.adyen.com/online-payments/3d-secure/authentication-only/). If set to
   *     **true**, you will only perform the 3D Secure 2 authentication, and will not proceed to the
   *     payment authorization. Default: **false**.
   */
  @JsonProperty(JSON_PROPERTY_AUTHENTICATION_ONLY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getAuthenticationOnly() {
    return authenticationOnly;
  }

  /**
   * Required to trigger the [authentication-only
   * flow](https://docs.adyen.com/online-payments/3d-secure/authentication-only/). If set to
   * **true**, you will only perform the 3D Secure 2 authentication, and will not proceed to the
   * payment authorization. Default: **false**.
   *
   * @param authenticationOnly Required to trigger the [authentication-only
   *     flow](https://docs.adyen.com/online-payments/3d-secure/authentication-only/). If set to
   *     **true**, you will only perform the 3D Secure 2 authentication, and will not proceed to the
   *     payment authorization. Default: **false**.
   */
  @JsonProperty(JSON_PROPERTY_AUTHENTICATION_ONLY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAuthenticationOnly(Boolean authenticationOnly) {
    this.authenticationOnly = authenticationOnly;
  }

  /**
   * threeDSRequestData
   *
   * @param threeDSRequestData
   * @return the current {@code AuthenticationData} instance, allowing for method chaining
   */
  public AuthenticationData threeDSRequestData(ThreeDSRequestData threeDSRequestData) {
    this.threeDSRequestData = threeDSRequestData;
    return this;
  }

  /**
   * Get threeDSRequestData
   *
   * @return threeDSRequestData
   */
  @JsonProperty(JSON_PROPERTY_THREE_D_S_REQUEST_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ThreeDSRequestData getThreeDSRequestData() {
    return threeDSRequestData;
  }

  /**
   * threeDSRequestData
   *
   * @param threeDSRequestData
   */
  @JsonProperty(JSON_PROPERTY_THREE_D_S_REQUEST_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setThreeDSRequestData(ThreeDSRequestData threeDSRequestData) {
    this.threeDSRequestData = threeDSRequestData;
  }

  /** Return true if this AuthenticationData object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AuthenticationData authenticationData = (AuthenticationData) o;
    return Objects.equals(this.attemptAuthentication, authenticationData.attemptAuthentication)
        && Objects.equals(this.authenticationOnly, authenticationData.authenticationOnly)
        && Objects.equals(this.threeDSRequestData, authenticationData.threeDSRequestData);
  }

  @Override
  public int hashCode() {
    return Objects.hash(attemptAuthentication, authenticationOnly, threeDSRequestData);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AuthenticationData {\n");
    sb.append("    attemptAuthentication: ")
        .append(toIndentedString(attemptAuthentication))
        .append("\n");
    sb.append("    authenticationOnly: ").append(toIndentedString(authenticationOnly)).append("\n");
    sb.append("    threeDSRequestData: ").append(toIndentedString(threeDSRequestData)).append("\n");
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
   * Create an instance of AuthenticationData given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AuthenticationData
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     AuthenticationData
   */
  public static AuthenticationData fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, AuthenticationData.class);
  }

  /**
   * Convert an instance of AuthenticationData to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
