/*
 * Transfers API
 *
 * The version of the OpenAPI document: 4
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.transfers;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** TransferView */
@JsonPropertyOrder({
  TransferView.JSON_PROPERTY_CATEGORY_DATA,
  TransferView.JSON_PROPERTY_ID,
  TransferView.JSON_PROPERTY_REFERENCE
})
public class TransferView {
  public static final String JSON_PROPERTY_CATEGORY_DATA = "categoryData";
  private TransferCategoryData categoryData;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;

  public TransferView() {}

  /**
   * categoryData
   *
   * @param categoryData
   * @return the current {@code TransferView} instance, allowing for method chaining
   */
  public TransferView categoryData(TransferCategoryData categoryData) {
    this.categoryData = categoryData;
    return this;
  }

  /**
   * Get categoryData
   *
   * @return categoryData
   */
  @JsonProperty(JSON_PROPERTY_CATEGORY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TransferCategoryData getCategoryData() {
    return categoryData;
  }

  /**
   * categoryData
   *
   * @param categoryData
   */
  @JsonProperty(JSON_PROPERTY_CATEGORY_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCategoryData(TransferCategoryData categoryData) {
    this.categoryData = categoryData;
  }

  /**
   * The ID of the resource.
   *
   * @param id The ID of the resource.
   * @return the current {@code TransferView} instance, allowing for method chaining
   */
  public TransferView id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The ID of the resource.
   *
   * @return id The ID of the resource.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  /**
   * The ID of the resource.
   *
   * @param id The ID of the resource.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The
   * [&#x60;reference&#x60;](https://docs.adyen.com/api-explorer/#/transfers/latest/post/transfers__reqParam_reference)
   * from the &#x60;/transfers&#x60; request. If you haven&#39;t provided any, Adyen generates a
   * unique reference.
   *
   * @param reference The
   *     [&#x60;reference&#x60;](https://docs.adyen.com/api-explorer/#/transfers/latest/post/transfers__reqParam_reference)
   *     from the &#x60;/transfers&#x60; request. If you haven&#39;t provided any, Adyen generates a
   *     unique reference.
   * @return the current {@code TransferView} instance, allowing for method chaining
   */
  public TransferView reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * The
   * [&#x60;reference&#x60;](https://docs.adyen.com/api-explorer/#/transfers/latest/post/transfers__reqParam_reference)
   * from the &#x60;/transfers&#x60; request. If you haven&#39;t provided any, Adyen generates a
   * unique reference.
   *
   * @return reference The
   *     [&#x60;reference&#x60;](https://docs.adyen.com/api-explorer/#/transfers/latest/post/transfers__reqParam_reference)
   *     from the &#x60;/transfers&#x60; request. If you haven&#39;t provided any, Adyen generates a
   *     unique reference.
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReference() {
    return reference;
  }

  /**
   * The
   * [&#x60;reference&#x60;](https://docs.adyen.com/api-explorer/#/transfers/latest/post/transfers__reqParam_reference)
   * from the &#x60;/transfers&#x60; request. If you haven&#39;t provided any, Adyen generates a
   * unique reference.
   *
   * @param reference The
   *     [&#x60;reference&#x60;](https://docs.adyen.com/api-explorer/#/transfers/latest/post/transfers__reqParam_reference)
   *     from the &#x60;/transfers&#x60; request. If you haven&#39;t provided any, Adyen generates a
   *     unique reference.
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReference(String reference) {
    this.reference = reference;
  }

  /** Return true if this TransferView object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TransferView transferView = (TransferView) o;
    return Objects.equals(this.categoryData, transferView.categoryData)
        && Objects.equals(this.id, transferView.id)
        && Objects.equals(this.reference, transferView.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(categoryData, id, reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TransferView {\n");
    sb.append("    categoryData: ").append(toIndentedString(categoryData)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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
   * Create an instance of TransferView given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TransferView
   * @throws JsonProcessingException if the JSON string is invalid with respect to TransferView
   */
  public static TransferView fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, TransferView.class);
  }

  /**
   * Convert an instance of TransferView to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
