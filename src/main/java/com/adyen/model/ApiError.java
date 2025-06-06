/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2025 Adyen B.V.
 * See the LICENSE file for more info.
 */
package com.adyen.model;

import com.adyen.model.checkout.JSON;
import com.fasterxml.jackson.annotation.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.annotations.ApiModelProperty;
import java.util.*;

/**
 * Class that defines the API error model returned when an error (401. 403, 422, etc..) is returned
 * by the API Based on the RFC-7807 standard
 */
@JsonPropertyOrder({
  ApiError.JSON_PROPERTY_INVALID_FIELDS,
  ApiError.JSON_PROPERTY_ADDITIONAL_DATA,
  ApiError.JSON_PROPERTY_ERROR_CODE,
  ApiError.JSON_PROPERTY_ERROR_TYPE,
  ApiError.JSON_PROPERTY_MESSAGE,
  ApiError.JSON_PROPERTY_PSP_REFERENCE,
  ApiError.JSON_PROPERTY_STATUS,
  ApiError.JSON_PROPERTY_TITLE
})
public class ApiError {
  public static final String JSON_PROPERTY_INVALID_FIELDS = "invalidFields";
  private List<InvalidField> invalidFields = null;

  public static final String JSON_PROPERTY_ADDITIONAL_DATA = "additionalData";
  private Map<String, String> additionalData = null;

  public static final String JSON_PROPERTY_ERROR_CODE = "errorCode";
  private String errorCode;

  public static final String JSON_PROPERTY_ERROR_TYPE = "errorType";
  private String errorType;

  public static final String JSON_PROPERTY_MESSAGE = "message";
  private String message;

  public static final String JSON_PROPERTY_PSP_REFERENCE = "pspReference";
  private String pspReference;

  public static final String JSON_PROPERTY_STATUS = "status";
  private Integer status;

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;

  public ApiError() {}

  public ApiError invalidFields(List<InvalidField> invalidFields) {
    this.invalidFields = invalidFields;
    return this;
  }

  public ApiError addInvalidFieldsItem(InvalidField invalidFieldsItem) {
    if (this.invalidFields == null) {
      this.invalidFields = new ArrayList<>();
    }
    this.invalidFields.add(invalidFieldsItem);
    return this;
  }

  /**
   * Detailed explanation of each validation error, when applicable.
   *
   * @return invalidFields
   */
  @ApiModelProperty(value = "Detailed explanation of each validation error, when applicable.")
  @JsonProperty(JSON_PROPERTY_INVALID_FIELDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<InvalidField> getInvalidFields() {
    return invalidFields;
  }

  @JsonProperty(JSON_PROPERTY_INVALID_FIELDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInvalidFields(List<InvalidField> invalidFields) {
    this.invalidFields = invalidFields;
  }

  public ApiError additionalData(Map<String, String> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public ApiError putAdditionalDataItem(String key, String additionalDataItem) {
    if (this.additionalData == null) {
      this.additionalData = new HashMap<>();
    }
    this.additionalData.put(key, additionalDataItem);
    return this;
  }

  /**
   * Contains additional information about the payment. Some data fields are included only if you
   * select them first. Go to **Customer Area** &gt; **Developers** &gt; **Additional data**.
   *
   * @return additionalData
   */
  @ApiModelProperty(
      value =
          "Contains additional information about the payment. Some data fields are included only if you select them first. Go to **Customer Area** > **Developers** > **Additional data**.")
  @JsonProperty(JSON_PROPERTY_ADDITIONAL_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Map<String, String> getAdditionalData() {
    return additionalData;
  }

  @JsonProperty(JSON_PROPERTY_ADDITIONAL_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdditionalData(Map<String, String> additionalData) {
    this.additionalData = additionalData;
  }

  public ApiError errorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * The error code mapped to the error message.
   *
   * @return errorCode
   */
  @ApiModelProperty(value = "The error code mapped to the error message.")
  @JsonProperty(JSON_PROPERTY_ERROR_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getErrorCode() {
    return errorCode;
  }

  @JsonProperty(JSON_PROPERTY_ERROR_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  public ApiError errorType(String errorType) {
    this.errorType = errorType;
    return this;
  }

  /**
   * The category of the error.
   *
   * @return errorType
   */
  @ApiModelProperty(value = "The category of the error.")
  @JsonProperty(JSON_PROPERTY_ERROR_TYPE)
  @JsonAlias("type")
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getErrorType() {
    return errorType;
  }

  @JsonProperty(JSON_PROPERTY_ERROR_TYPE)
  @JsonAlias("type")
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErrorType(String errorType) {
    this.errorType = errorType;
  }

  public ApiError message(String message) {
    this.message = message;
    return this;
  }

  /**
   * A short explanation of the issue.
   *
   * @return message
   */
  @ApiModelProperty(value = "A short explanation of the issue.")
  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonAlias("detail")
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMessage() {
    return message;
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE)
  @JsonAlias("detail")
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessage(String message) {
    this.message = message;
  }

  public ApiError pspReference(String pspReference) {
    this.pspReference = pspReference;
    return this;
  }

  /**
   * The PSP reference of the payment.
   *
   * @return pspReference
   */
  @ApiModelProperty(value = "The PSP reference of the payment.")
  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPspReference() {
    return pspReference;
  }

  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPspReference(String pspReference) {
    this.pspReference = pspReference;
  }

  public ApiError status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * The HTTP response status.
   *
   * @return status
   */
  @ApiModelProperty(value = "The HTTP response status.")
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getStatus() {
    return status;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * Set title and return the object
   *
   * @param title
   * @return
   */
  public ApiError title(String title) {
    this.title = title;
    return this;
  }

  /**
   * The human-readable summary of the problem type
   *
   * @return status
   */
  @ApiModelProperty(value = "The HTTP response status.")
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getTitle() {
    return title;
  }

  /**
   * Set title
   *
   * @param title
   */
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitle(String title) {
    this.title = title;
  }

  /** Return true if this ServiceError object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiError apiError = (ApiError) o;
    return Objects.equals(this.additionalData, apiError.additionalData)
        && Objects.equals(this.errorCode, apiError.errorCode)
        && Objects.equals(this.errorType, apiError.errorType)
        && Objects.equals(this.message, apiError.message)
        && Objects.equals(this.pspReference, apiError.pspReference)
        && Objects.equals(this.status, apiError.status)
        && Objects.equals(this.title, apiError.title);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalData, errorCode, errorType, message, pspReference, status, title);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiError {\n");
    sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
    sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    errorType: ").append(toIndentedString(errorType)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
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
   * Create an instance of ApiError given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of ServiceError
   * @throws JsonProcessingException if the JSON string is invalid with respect to ServiceError
   */
  public static ApiError fromJson(String jsonString) throws JsonProcessingException {
    if (jsonString == null) {
      return null;
    }
    return JSON.getMapper().readValue(jsonString, ApiError.class);
  }

  /**
   * Convert an instance of ApiError to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
