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

/** Links */
@JsonPropertyOrder({Links.JSON_PROPERTY_NEXT, Links.JSON_PROPERTY_PREV})
public class Links {
  public static final String JSON_PROPERTY_NEXT = "next";
  private Link next;

  public static final String JSON_PROPERTY_PREV = "prev";
  private Link prev;

  public Links() {}

  /**
   * next
   *
   * @param next
   * @return the current {@code Links} instance, allowing for method chaining
   */
  public Links next(Link next) {
    this.next = next;
    return this;
  }

  /**
   * Get next
   *
   * @return next
   */
  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Link getNext() {
    return next;
  }

  /**
   * next
   *
   * @param next
   */
  @JsonProperty(JSON_PROPERTY_NEXT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNext(Link next) {
    this.next = next;
  }

  /**
   * prev
   *
   * @param prev
   * @return the current {@code Links} instance, allowing for method chaining
   */
  public Links prev(Link prev) {
    this.prev = prev;
    return this;
  }

  /**
   * Get prev
   *
   * @return prev
   */
  @JsonProperty(JSON_PROPERTY_PREV)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Link getPrev() {
    return prev;
  }

  /**
   * prev
   *
   * @param prev
   */
  @JsonProperty(JSON_PROPERTY_PREV)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPrev(Link prev) {
    this.prev = prev;
  }

  /** Return true if this Links object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Links links = (Links) o;
    return Objects.equals(this.next, links.next) && Objects.equals(this.prev, links.prev);
  }

  @Override
  public int hashCode() {
    return Objects.hash(next, prev);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Links {\n");
    sb.append("    next: ").append(toIndentedString(next)).append("\n");
    sb.append("    prev: ").append(toIndentedString(prev)).append("\n");
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
   * Create an instance of Links given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Links
   * @throws JsonProcessingException if the JSON string is invalid with respect to Links
   */
  public static Links fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, Links.class);
  }

  /**
   * Convert an instance of Links to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
