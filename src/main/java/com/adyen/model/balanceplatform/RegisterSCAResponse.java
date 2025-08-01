/*
 * Configuration API
 *
 * The version of the OpenAPI document: 2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.balanceplatform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** RegisterSCAResponse */
@JsonPropertyOrder({
  RegisterSCAResponse.JSON_PROPERTY_ID,
  RegisterSCAResponse.JSON_PROPERTY_PAYMENT_INSTRUMENT_ID,
  RegisterSCAResponse.JSON_PROPERTY_SDK_INPUT,
  RegisterSCAResponse.JSON_PROPERTY_SUCCESS
})
public class RegisterSCAResponse {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_PAYMENT_INSTRUMENT_ID = "paymentInstrumentId";
  private String paymentInstrumentId;

  public static final String JSON_PROPERTY_SDK_INPUT = "sdkInput";
  private String sdkInput;

  public static final String JSON_PROPERTY_SUCCESS = "success";
  private Boolean success;

  public RegisterSCAResponse() {}

  /**
   * The unique identifier of the SCA device you are registering.
   *
   * @param id The unique identifier of the SCA device you are registering.
   * @return the current {@code RegisterSCAResponse} instance, allowing for method chaining
   */
  public RegisterSCAResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the SCA device you are registering.
   *
   * @return id The unique identifier of the SCA device you are registering.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  /**
   * The unique identifier of the SCA device you are registering.
   *
   * @param id The unique identifier of the SCA device you are registering.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The unique identifier of the payment instrument for which you are registering the SCA device.
   *
   * @param paymentInstrumentId The unique identifier of the payment instrument for which you are
   *     registering the SCA device.
   * @return the current {@code RegisterSCAResponse} instance, allowing for method chaining
   */
  public RegisterSCAResponse paymentInstrumentId(String paymentInstrumentId) {
    this.paymentInstrumentId = paymentInstrumentId;
    return this;
  }

  /**
   * The unique identifier of the payment instrument for which you are registering the SCA device.
   *
   * @return paymentInstrumentId The unique identifier of the payment instrument for which you are
   *     registering the SCA device.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_INSTRUMENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPaymentInstrumentId() {
    return paymentInstrumentId;
  }

  /**
   * The unique identifier of the payment instrument for which you are registering the SCA device.
   *
   * @param paymentInstrumentId The unique identifier of the payment instrument for which you are
   *     registering the SCA device.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENT_INSTRUMENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPaymentInstrumentId(String paymentInstrumentId) {
    this.paymentInstrumentId = paymentInstrumentId;
  }

  /**
   * A string that you must pass to the authentication SDK to continue with the registration
   * process.
   *
   * @param sdkInput A string that you must pass to the authentication SDK to continue with the
   *     registration process.
   * @return the current {@code RegisterSCAResponse} instance, allowing for method chaining
   */
  public RegisterSCAResponse sdkInput(String sdkInput) {
    this.sdkInput = sdkInput;
    return this;
  }

  /**
   * A string that you must pass to the authentication SDK to continue with the registration
   * process.
   *
   * @return sdkInput A string that you must pass to the authentication SDK to continue with the
   *     registration process.
   */
  @JsonProperty(JSON_PROPERTY_SDK_INPUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSdkInput() {
    return sdkInput;
  }

  /**
   * A string that you must pass to the authentication SDK to continue with the registration
   * process.
   *
   * @param sdkInput A string that you must pass to the authentication SDK to continue with the
   *     registration process.
   */
  @JsonProperty(JSON_PROPERTY_SDK_INPUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSdkInput(String sdkInput) {
    this.sdkInput = sdkInput;
  }

  /**
   * Specifies if the registration was initiated successfully.
   *
   * @param success Specifies if the registration was initiated successfully.
   * @return the current {@code RegisterSCAResponse} instance, allowing for method chaining
   */
  public RegisterSCAResponse success(Boolean success) {
    this.success = success;
    return this;
  }

  /**
   * Specifies if the registration was initiated successfully.
   *
   * @return success Specifies if the registration was initiated successfully.
   */
  @JsonProperty(JSON_PROPERTY_SUCCESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getSuccess() {
    return success;
  }

  /**
   * Specifies if the registration was initiated successfully.
   *
   * @param success Specifies if the registration was initiated successfully.
   */
  @JsonProperty(JSON_PROPERTY_SUCCESS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSuccess(Boolean success) {
    this.success = success;
  }

  /** Return true if this RegisterSCAResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RegisterSCAResponse registerSCAResponse = (RegisterSCAResponse) o;
    return Objects.equals(this.id, registerSCAResponse.id)
        && Objects.equals(this.paymentInstrumentId, registerSCAResponse.paymentInstrumentId)
        && Objects.equals(this.sdkInput, registerSCAResponse.sdkInput)
        && Objects.equals(this.success, registerSCAResponse.success);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, paymentInstrumentId, sdkInput, success);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RegisterSCAResponse {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    paymentInstrumentId: ")
        .append(toIndentedString(paymentInstrumentId))
        .append("\n");
    sb.append("    sdkInput: ").append(toIndentedString(sdkInput)).append("\n");
    sb.append("    success: ").append(toIndentedString(success)).append("\n");
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
   * Create an instance of RegisterSCAResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of RegisterSCAResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     RegisterSCAResponse
   */
  public static RegisterSCAResponse fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, RegisterSCAResponse.class);
  }

  /**
   * Convert an instance of RegisterSCAResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
