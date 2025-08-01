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
import java.util.*;

/** OrderItem */
@JsonPropertyOrder({
  OrderItem.JSON_PROPERTY_ID,
  OrderItem.JSON_PROPERTY_INSTALLMENTS,
  OrderItem.JSON_PROPERTY_NAME,
  OrderItem.JSON_PROPERTY_QUANTITY
})
public class OrderItem {
  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_INSTALLMENTS = "installments";
  private Long installments;

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;

  public static final String JSON_PROPERTY_QUANTITY = "quantity";
  private Integer quantity;

  public OrderItem() {}

  /**
   * The unique identifier of the product.
   *
   * @param id The unique identifier of the product.
   * @return the current {@code OrderItem} instance, allowing for method chaining
   */
  public OrderItem id(String id) {
    this.id = id;
    return this;
  }

  /**
   * The unique identifier of the product.
   *
   * @return id The unique identifier of the product.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  /**
   * The unique identifier of the product.
   *
   * @param id The unique identifier of the product.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  /**
   * The number of installments for the specified product &#x60;id&#x60;.
   *
   * @param installments The number of installments for the specified product &#x60;id&#x60;.
   * @return the current {@code OrderItem} instance, allowing for method chaining
   */
  public OrderItem installments(Long installments) {
    this.installments = installments;
    return this;
  }

  /**
   * The number of installments for the specified product &#x60;id&#x60;.
   *
   * @return installments The number of installments for the specified product &#x60;id&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Long getInstallments() {
    return installments;
  }

  /**
   * The number of installments for the specified product &#x60;id&#x60;.
   *
   * @param installments The number of installments for the specified product &#x60;id&#x60;.
   */
  @JsonProperty(JSON_PROPERTY_INSTALLMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setInstallments(Long installments) {
    this.installments = installments;
  }

  /**
   * The name of the product.
   *
   * @param name The name of the product.
   * @return the current {@code OrderItem} instance, allowing for method chaining
   */
  public OrderItem name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the product.
   *
   * @return name The name of the product.
   */
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getName() {
    return name;
  }

  /**
   * The name of the product.
   *
   * @param name The name of the product.
   */
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setName(String name) {
    this.name = name;
  }

  /**
   * The number of items with the specified product &#x60;id&#x60; included in the order.
   *
   * @param quantity The number of items with the specified product &#x60;id&#x60; included in the
   *     order.
   * @return the current {@code OrderItem} instance, allowing for method chaining
   */
  public OrderItem quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * The number of items with the specified product &#x60;id&#x60; included in the order.
   *
   * @return quantity The number of items with the specified product &#x60;id&#x60; included in the
   *     order.
   */
  @JsonProperty(JSON_PROPERTY_QUANTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getQuantity() {
    return quantity;
  }

  /**
   * The number of items with the specified product &#x60;id&#x60; included in the order.
   *
   * @param quantity The number of items with the specified product &#x60;id&#x60; included in the
   *     order.
   */
  @JsonProperty(JSON_PROPERTY_QUANTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  /** Return true if this OrderItem object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItem orderItem = (OrderItem) o;
    return Objects.equals(this.id, orderItem.id)
        && Objects.equals(this.installments, orderItem.installments)
        && Objects.equals(this.name, orderItem.name)
        && Objects.equals(this.quantity, orderItem.quantity);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, installments, name, quantity);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItem {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    installments: ").append(toIndentedString(installments)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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
   * Create an instance of OrderItem given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of OrderItem
   * @throws JsonProcessingException if the JSON string is invalid with respect to OrderItem
   */
  public static OrderItem fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, OrderItem.class);
  }

  /**
   * Convert an instance of OrderItem to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
