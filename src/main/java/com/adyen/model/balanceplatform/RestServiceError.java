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
import java.util.ArrayList;
import java.util.List;

/** RestServiceError */
@JsonPropertyOrder({
  RestServiceError.JSON_PROPERTY_DETAIL,
  RestServiceError.JSON_PROPERTY_ERROR_CODE,
  RestServiceError.JSON_PROPERTY_INSTANCE,
  RestServiceError.JSON_PROPERTY_INVALID_FIELDS,
  RestServiceError.JSON_PROPERTY_REQUEST_ID,
  RestServiceError.JSON_PROPERTY_RESPONSE,
  RestServiceError.JSON_PROPERTY_STATUS,
  RestServiceError.JSON_PROPERTY_TITLE,
  RestServiceError.JSON_PROPERTY_TYPE
})
public class RestServiceError {
  public static final String JSON_PROPERTY_DETAIL = "detail";
  private String detail;

  public static final String JSON_PROPERTY_ERROR_CODE = "errorCode";
  private String errorCode;

  public static final String JSON_PROPERTY_INSTANCE = "instance";
  private String instance;

  public static final String JSON_PROPERTY_INVALID_FIELDS = "invalidFields";
  private List<InvalidField> invalidFields;

  public static final String JSON_PROPERTY_REQUEST_ID = "requestId";
  private String requestId;

  public static final String JSON_PROPERTY_RESPONSE = "response";
  private Object response;

  public static final String JSON_PROPERTY_STATUS = "status";
  private Integer status;

  public static final String JSON_PROPERTY_TITLE = "title";
  private String title;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public RestServiceError() {}

  /**
   * A human-readable explanation specific to this occurrence of the problem.
   *
   * @param detail A human-readable explanation specific to this occurrence of the problem.
   * @return the current {@code RestServiceError} instance, allowing for method chaining
   */
  public RestServiceError detail(String detail) {
    this.detail = detail;
    return this;
  }

  /**
   * A human-readable explanation specific to this occurrence of the problem.
   *
   * @return detail A human-readable explanation specific to this occurrence of the problem.
   */
  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDetail() {
    return detail;
  }

  /**
   * A human-readable explanation specific to this occurrence of the problem.
   *
   * @param detail A human-readable explanation specific to this occurrence of the problem.
   */
  @JsonProperty(JSON_PROPERTY_DETAIL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDetail(String detail) {
    this.detail = detail;
  }

  /**
   * A code that identifies the problem type.
   *
   * @param errorCode A code that identifies the problem type.
   * @return the current {@code RestServiceError} instance, allowing for method chaining
   */
  public RestServiceError errorCode(String errorCode) {
    this.errorCode = errorCode;
    return this;
  }

  /**
   * A code that identifies the problem type.
   *
   * @return errorCode A code that identifies the problem type.
   */
  @JsonProperty(JSON_PROPERTY_ERROR_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getErrorCode() {
    return errorCode;
  }

  /**
   * A code that identifies the problem type.
   *
   * @param errorCode A code that identifies the problem type.
   */
  @JsonProperty(JSON_PROPERTY_ERROR_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setErrorCode(String errorCode) {
    this.errorCode = errorCode;
  }

  /**
   * A unique URI that identifies the specific occurrence of the problem.
   *
   * @param instance A unique URI that identifies the specific occurrence of the problem.
   * @return the current {@code RestServiceError} instance, allowing for method chaining
   */
  public RestServiceError instance(String instance) {
    this.instance = instance;
    return this;
  }

  /**
   * A unique URI that identifies the specific occurrence of the problem.
   *
   * @return instance A unique URI that identifies the specific occurrence of the problem.
   */
  @JsonProperty(JSON_PROPERTY_INSTANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInstance() {
    return instance;
  }

  /**
   * A unique URI that identifies the specific occurrence of the problem.
   *
   * @param instance A unique URI that identifies the specific occurrence of the problem.
   */
  @JsonProperty(JSON_PROPERTY_INSTANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstance(String instance) {
    this.instance = instance;
  }

  /**
   * Detailed explanation of each validation error, when applicable.
   *
   * @param invalidFields Detailed explanation of each validation error, when applicable.
   * @return the current {@code RestServiceError} instance, allowing for method chaining
   */
  public RestServiceError invalidFields(List<InvalidField> invalidFields) {
    this.invalidFields = invalidFields;
    return this;
  }

  public RestServiceError addInvalidFieldsItem(InvalidField invalidFieldsItem) {
    if (this.invalidFields == null) {
      this.invalidFields = new ArrayList<>();
    }
    this.invalidFields.add(invalidFieldsItem);
    return this;
  }

  /**
   * Detailed explanation of each validation error, when applicable.
   *
   * @return invalidFields Detailed explanation of each validation error, when applicable.
   */
  @JsonProperty(JSON_PROPERTY_INVALID_FIELDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<InvalidField> getInvalidFields() {
    return invalidFields;
  }

  /**
   * Detailed explanation of each validation error, when applicable.
   *
   * @param invalidFields Detailed explanation of each validation error, when applicable.
   */
  @JsonProperty(JSON_PROPERTY_INVALID_FIELDS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInvalidFields(List<InvalidField> invalidFields) {
    this.invalidFields = invalidFields;
  }

  /**
   * A unique reference for the request, essentially the same as &#x60;pspReference&#x60;.
   *
   * @param requestId A unique reference for the request, essentially the same as
   *     &#x60;pspReference&#x60;.
   * @return the current {@code RestServiceError} instance, allowing for method chaining
   */
  public RestServiceError requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

  /**
   * A unique reference for the request, essentially the same as &#x60;pspReference&#x60;.
   *
   * @return requestId A unique reference for the request, essentially the same as
   *     &#x60;pspReference&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRequestId() {
    return requestId;
  }

  /**
   * A unique reference for the request, essentially the same as &#x60;pspReference&#x60;.
   *
   * @param requestId A unique reference for the request, essentially the same as
   *     &#x60;pspReference&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }

  /**
   * response
   *
   * @param response
   * @return the current {@code RestServiceError} instance, allowing for method chaining
   */
  public RestServiceError response(Object response) {
    this.response = response;
    return this;
  }

  /**
   * Get response
   *
   * @return response
   */
  @JsonProperty(JSON_PROPERTY_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Object getResponse() {
    return response;
  }

  /**
   * response
   *
   * @param response
   */
  @JsonProperty(JSON_PROPERTY_RESPONSE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResponse(Object response) {
    this.response = response;
  }

  /**
   * The HTTP status code.
   *
   * @param status The HTTP status code.
   * @return the current {@code RestServiceError} instance, allowing for method chaining
   */
  public RestServiceError status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * The HTTP status code.
   *
   * @return status The HTTP status code.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getStatus() {
    return status;
  }

  /**
   * The HTTP status code.
   *
   * @param status The HTTP status code.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(Integer status) {
    this.status = status;
  }

  /**
   * A short, human-readable summary of the problem type.
   *
   * @param title A short, human-readable summary of the problem type.
   * @return the current {@code RestServiceError} instance, allowing for method chaining
   */
  public RestServiceError title(String title) {
    this.title = title;
    return this;
  }

  /**
   * A short, human-readable summary of the problem type.
   *
   * @return title A short, human-readable summary of the problem type.
   */
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getTitle() {
    return title;
  }

  /**
   * A short, human-readable summary of the problem type.
   *
   * @param title A short, human-readable summary of the problem type.
   */
  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTitle(String title) {
    this.title = title;
  }

  /**
   * A URI that identifies the problem type, pointing to human-readable documentation on this
   * problem type.
   *
   * @param type A URI that identifies the problem type, pointing to human-readable documentation on
   *     this problem type.
   * @return the current {@code RestServiceError} instance, allowing for method chaining
   */
  public RestServiceError type(String type) {
    this.type = type;
    return this;
  }

  /**
   * A URI that identifies the problem type, pointing to human-readable documentation on this
   * problem type.
   *
   * @return type A URI that identifies the problem type, pointing to human-readable documentation
   *     on this problem type.
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getType() {
    return type;
  }

  /**
   * A URI that identifies the problem type, pointing to human-readable documentation on this
   * problem type.
   *
   * @param type A URI that identifies the problem type, pointing to human-readable documentation on
   *     this problem type.
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
  }

  /** Return true if this RestServiceError object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RestServiceError restServiceError = (RestServiceError) o;
    return Objects.equals(this.detail, restServiceError.detail)
        && Objects.equals(this.errorCode, restServiceError.errorCode)
        && Objects.equals(this.instance, restServiceError.instance)
        && Objects.equals(this.invalidFields, restServiceError.invalidFields)
        && Objects.equals(this.requestId, restServiceError.requestId)
        && Objects.equals(this.response, restServiceError.response)
        && Objects.equals(this.status, restServiceError.status)
        && Objects.equals(this.title, restServiceError.title)
        && Objects.equals(this.type, restServiceError.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        detail, errorCode, instance, invalidFields, requestId, response, status, title, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RestServiceError {\n");
    sb.append("    detail: ").append(toIndentedString(detail)).append("\n");
    sb.append("    errorCode: ").append(toIndentedString(errorCode)).append("\n");
    sb.append("    instance: ").append(toIndentedString(instance)).append("\n");
    sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    response: ").append(toIndentedString(response)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
   * Create an instance of RestServiceError given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of RestServiceError
   * @throws JsonProcessingException if the JSON string is invalid with respect to RestServiceError
   */
  public static RestServiceError fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, RestServiceError.class);
  }

  /**
   * Convert an instance of RestServiceError to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
