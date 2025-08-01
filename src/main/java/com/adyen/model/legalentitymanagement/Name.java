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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** Name */
@JsonPropertyOrder({
  Name.JSON_PROPERTY_FIRST_NAME,
  Name.JSON_PROPERTY_INFIX,
  Name.JSON_PROPERTY_LAST_NAME
})
public class Name {
  public static final String JSON_PROPERTY_FIRST_NAME = "firstName";
  private String firstName;

  public static final String JSON_PROPERTY_INFIX = "infix";
  private String infix;

  public static final String JSON_PROPERTY_LAST_NAME = "lastName";
  private String lastName;

  public Name() {}

  /**
   * The individual&#39;s first name. Must not be blank.
   *
   * @param firstName The individual&#39;s first name. Must not be blank.
   * @return the current {@code Name} instance, allowing for method chaining
   */
  public Name firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * The individual&#39;s first name. Must not be blank.
   *
   * @return firstName The individual&#39;s first name. Must not be blank.
   */
  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getFirstName() {
    return firstName;
  }

  /**
   * The individual&#39;s first name. Must not be blank.
   *
   * @param firstName The individual&#39;s first name. Must not be blank.
   */
  @JsonProperty(JSON_PROPERTY_FIRST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * The infix in the individual&#39;s name, if any.
   *
   * @param infix The infix in the individual&#39;s name, if any.
   * @return the current {@code Name} instance, allowing for method chaining
   */
  public Name infix(String infix) {
    this.infix = infix;
    return this;
  }

  /**
   * The infix in the individual&#39;s name, if any.
   *
   * @return infix The infix in the individual&#39;s name, if any.
   */
  @JsonProperty(JSON_PROPERTY_INFIX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getInfix() {
    return infix;
  }

  /**
   * The infix in the individual&#39;s name, if any.
   *
   * @param infix The infix in the individual&#39;s name, if any.
   */
  @JsonProperty(JSON_PROPERTY_INFIX)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInfix(String infix) {
    this.infix = infix;
  }

  /**
   * The individual&#39;s last name. Must not be blank.
   *
   * @param lastName The individual&#39;s last name. Must not be blank.
   * @return the current {@code Name} instance, allowing for method chaining
   */
  public Name lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * The individual&#39;s last name. Must not be blank.
   *
   * @return lastName The individual&#39;s last name. Must not be blank.
   */
  @JsonProperty(JSON_PROPERTY_LAST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLastName() {
    return lastName;
  }

  /**
   * The individual&#39;s last name. Must not be blank.
   *
   * @param lastName The individual&#39;s last name. Must not be blank.
   */
  @JsonProperty(JSON_PROPERTY_LAST_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /** Return true if this Name object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name = (Name) o;
    return Objects.equals(this.firstName, name.firstName)
        && Objects.equals(this.infix, name.infix)
        && Objects.equals(this.lastName, name.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, infix, lastName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Name {\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    infix: ").append(toIndentedString(infix)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
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
   * Create an instance of Name given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of Name
   * @throws JsonProcessingException if the JSON string is invalid with respect to Name
   */
  public static Name fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, Name.class);
  }

  /**
   * Convert an instance of Name to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
