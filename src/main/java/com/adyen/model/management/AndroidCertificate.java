/*
 * Management API
 *
 * The version of the OpenAPI document: 3
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.management;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.OffsetDateTime;
import java.util.*;

/** AndroidCertificate */
@JsonPropertyOrder({
  AndroidCertificate.JSON_PROPERTY_DESCRIPTION,
  AndroidCertificate.JSON_PROPERTY_EXTENSION,
  AndroidCertificate.JSON_PROPERTY_ID,
  AndroidCertificate.JSON_PROPERTY_NAME,
  AndroidCertificate.JSON_PROPERTY_NOT_AFTER,
  AndroidCertificate.JSON_PROPERTY_NOT_BEFORE,
  AndroidCertificate.JSON_PROPERTY_STATUS
})
public class AndroidCertificate {
  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_EXTENSION = "extension";
  private String extension;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_NOT_AFTER = "notAfter";
  private OffsetDateTime notAfter;

  public static final String JSON_PROPERTY_NOT_BEFORE = "notBefore";
  private OffsetDateTime notBefore;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;

  public AndroidCertificate() {}

  /**
   * The description that was provided when uploading the certificate.
   *
   * @param description The description that was provided when uploading the certificate.
   * @return the current {@code AndroidCertificate} instance, allowing for method chaining
   */
  public AndroidCertificate description(String description) {
    this.description = description;
    return this;
  }

  /**
   * The description that was provided when uploading the certificate.
   *
   * @return description The description that was provided when uploading the certificate.
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDescription() {
    return description;
  }

  /**
   * The description that was provided when uploading the certificate.
   *
   * @param description The description that was provided when uploading the certificate.
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The file format of the certificate, as indicated by the file extension. For example, **.cert**
   * or **.pem**.
   *
   * @param extension The file format of the certificate, as indicated by the file extension. For
   *     example, **.cert** or **.pem**.
   * @return the current {@code AndroidCertificate} instance, allowing for method chaining
   */
  public AndroidCertificate extension(String extension) {
    this.extension = extension;
    return this;
  }

  /**
   * The file format of the certificate, as indicated by the file extension. For example, **.cert**
   * or **.pem**.
   *
   * @return extension The file format of the certificate, as indicated by the file extension. For
   *     example, **.cert** or **.pem**.
   */
  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getExtension() {
    return extension;
  }

  /**
   * The file format of the certificate, as indicated by the file extension. For example, **.cert**
   * or **.pem**.
   *
   * @param extension The file format of the certificate, as indicated by the file extension. For
   *     example, **.cert** or **.pem**.
   */
  @JsonProperty(JSON_PROPERTY_EXTENSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setExtension(String extension) {
    this.extension = extension;
  }

  /**
   * The unique identifier of the certificate.
   *
   * @param id The unique identifier of the certificate.
   * @return the current {@code AndroidCertificate} instance, allowing for method chaining
   */
  public AndroidCertificate id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the certificate.
   *
   * @return id The unique identifier of the certificate.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  /**
   * The unique identifier of the certificate.
   *
   * @param id The unique identifier of the certificate.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The file name of the certificate. For example, **mycert**.
   *
   * @param name The file name of the certificate. For example, **mycert**.
   * @return the current {@code AndroidCertificate} instance, allowing for method chaining
   */
  public AndroidCertificate name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The file name of the certificate. For example, **mycert**.
   *
   * @return name The file name of the certificate. For example, **mycert**.
   */
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getName() {
    return name;
  }

  /**
   * The file name of the certificate. For example, **mycert**.
   *
   * @param name The file name of the certificate. For example, **mycert**.
   */
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The date when the certificate stops to be valid.
   *
   * @param notAfter The date when the certificate stops to be valid.
   * @return the current {@code AndroidCertificate} instance, allowing for method chaining
   */
  public AndroidCertificate notAfter(OffsetDateTime notAfter) {
    this.notAfter = notAfter;
    return this;
  }

  /**
   * The date when the certificate stops to be valid.
   *
   * @return notAfter The date when the certificate stops to be valid.
   */
  @JsonProperty(JSON_PROPERTY_NOT_AFTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getNotAfter() {
    return notAfter;
  }

  /**
   * The date when the certificate stops to be valid.
   *
   * @param notAfter The date when the certificate stops to be valid.
   */
  @JsonProperty(JSON_PROPERTY_NOT_AFTER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotAfter(OffsetDateTime notAfter) {
    this.notAfter = notAfter;
  }

  /**
   * The date when the certificate starts to be valid.
   *
   * @param notBefore The date when the certificate starts to be valid.
   * @return the current {@code AndroidCertificate} instance, allowing for method chaining
   */
  public AndroidCertificate notBefore(OffsetDateTime notBefore) {
    this.notBefore = notBefore;
    return this;
  }

  /**
   * The date when the certificate starts to be valid.
   *
   * @return notBefore The date when the certificate starts to be valid.
   */
  @JsonProperty(JSON_PROPERTY_NOT_BEFORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getNotBefore() {
    return notBefore;
  }

  /**
   * The date when the certificate starts to be valid.
   *
   * @param notBefore The date when the certificate starts to be valid.
   */
  @JsonProperty(JSON_PROPERTY_NOT_BEFORE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNotBefore(OffsetDateTime notBefore) {
    this.notBefore = notBefore;
  }

  /**
   * The status of the certificate.
   *
   * @param status The status of the certificate.
   * @return the current {@code AndroidCertificate} instance, allowing for method chaining
   */
  public AndroidCertificate status(String status) {
    this.status = status;
    return this;
  }

  /**
   * The status of the certificate.
   *
   * @return status The status of the certificate.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStatus() {
    return status;
  }

  /**
   * The status of the certificate.
   *
   * @param status The status of the certificate.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(String status) {
    this.status = status;
  }

  /** Return true if this AndroidCertificate object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AndroidCertificate androidCertificate = (AndroidCertificate) o;
    return Objects.equals(this.description, androidCertificate.description)
        && Objects.equals(this.extension, androidCertificate.extension)
        && Objects.equals(this.id, androidCertificate.id)
        && Objects.equals(this.name, androidCertificate.name)
        && Objects.equals(this.notAfter, androidCertificate.notAfter)
        && Objects.equals(this.notBefore, androidCertificate.notBefore)
        && Objects.equals(this.status, androidCertificate.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, extension, id, name, notAfter, notBefore, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AndroidCertificate {\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    extension: ").append(toIndentedString(extension)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    notAfter: ").append(toIndentedString(notAfter)).append("\n");
    sb.append("    notBefore: ").append(toIndentedString(notBefore)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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
   * Create an instance of AndroidCertificate given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of AndroidCertificate
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     AndroidCertificate
   */
  public static AndroidCertificate fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, AndroidCertificate.class);
  }

  /**
   * Convert an instance of AndroidCertificate to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
