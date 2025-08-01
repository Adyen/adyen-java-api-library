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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.Arrays;
import java.util.logging.Logger;

/** TerminalAssignment */
@JsonPropertyOrder({
  TerminalAssignment.JSON_PROPERTY_COMPANY_ID,
  TerminalAssignment.JSON_PROPERTY_MERCHANT_ID,
  TerminalAssignment.JSON_PROPERTY_REASSIGNMENT_TARGET,
  TerminalAssignment.JSON_PROPERTY_STATUS,
  TerminalAssignment.JSON_PROPERTY_STORE_ID
})
public class TerminalAssignment {
  public static final String JSON_PROPERTY_COMPANY_ID = "companyId";
  private String companyId;

  public static final String JSON_PROPERTY_MERCHANT_ID = "merchantId";
  private String merchantId;

  public static final String JSON_PROPERTY_REASSIGNMENT_TARGET = "reassignmentTarget";
  private TerminalReassignmentTarget reassignmentTarget;

  /**
   * The status of the reassignment. Possible values: * &#x60;reassignmentInProgress&#x60;: the
   * terminal was boarded and is now scheduled to remove the configuration. Wait for the terminal to
   * synchronize with the Adyen platform. * &#x60;deployed&#x60;: the terminal is deployed and
   * reassigned. * &#x60;inventory&#x60;: the terminal is in inventory and cannot process
   * transactions. * &#x60;boarded&#x60;: the terminal is boarded to a store, or a merchant account
   * representing a store, and can process transactions.
   */
  public enum StatusEnum {
    BOARDED(String.valueOf("boarded")),

    DEPLOYED(String.valueOf("deployed")),

    INVENTORY(String.valueOf("inventory")),

    REASSIGNMENTINPROGRESS(String.valueOf("reassignmentInProgress"));

    private static final Logger LOG = Logger.getLogger(StatusEnum.class.getName());

    private String value;

    StatusEnum(String value) {
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
    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "StatusEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(StatusEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_STATUS = "status";
  private StatusEnum status;

  public static final String JSON_PROPERTY_STORE_ID = "storeId";
  private String storeId;

  public TerminalAssignment() {}

  /**
   * The unique identifier of the company account to which terminal is assigned.
   *
   * @param companyId The unique identifier of the company account to which terminal is assigned.
   * @return the current {@code TerminalAssignment} instance, allowing for method chaining
   */
  public TerminalAssignment companyId(String companyId) {
    this.companyId = companyId;
    return this;
  }

  /**
   * The unique identifier of the company account to which terminal is assigned.
   *
   * @return companyId The unique identifier of the company account to which terminal is assigned.
   */
  @JsonProperty(JSON_PROPERTY_COMPANY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCompanyId() {
    return companyId;
  }

  /**
   * The unique identifier of the company account to which terminal is assigned.
   *
   * @param companyId The unique identifier of the company account to which terminal is assigned.
   */
  @JsonProperty(JSON_PROPERTY_COMPANY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCompanyId(String companyId) {
    this.companyId = companyId;
  }

  /**
   * The unique identifier of the merchant account to which terminal is assigned.
   *
   * @param merchantId The unique identifier of the merchant account to which terminal is assigned.
   * @return the current {@code TerminalAssignment} instance, allowing for method chaining
   */
  public TerminalAssignment merchantId(String merchantId) {
    this.merchantId = merchantId;
    return this;
  }

  /**
   * The unique identifier of the merchant account to which terminal is assigned.
   *
   * @return merchantId The unique identifier of the merchant account to which terminal is assigned.
   */
  @JsonProperty(JSON_PROPERTY_MERCHANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMerchantId() {
    return merchantId;
  }

  /**
   * The unique identifier of the merchant account to which terminal is assigned.
   *
   * @param merchantId The unique identifier of the merchant account to which terminal is assigned.
   */
  @JsonProperty(JSON_PROPERTY_MERCHANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMerchantId(String merchantId) {
    this.merchantId = merchantId;
  }

  /**
   * reassignmentTarget
   *
   * @param reassignmentTarget
   * @return the current {@code TerminalAssignment} instance, allowing for method chaining
   */
  public TerminalAssignment reassignmentTarget(TerminalReassignmentTarget reassignmentTarget) {
    this.reassignmentTarget = reassignmentTarget;
    return this;
  }

  /**
   * Get reassignmentTarget
   *
   * @return reassignmentTarget
   */
  @JsonProperty(JSON_PROPERTY_REASSIGNMENT_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TerminalReassignmentTarget getReassignmentTarget() {
    return reassignmentTarget;
  }

  /**
   * reassignmentTarget
   *
   * @param reassignmentTarget
   */
  @JsonProperty(JSON_PROPERTY_REASSIGNMENT_TARGET)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReassignmentTarget(TerminalReassignmentTarget reassignmentTarget) {
    this.reassignmentTarget = reassignmentTarget;
  }

  /**
   * The status of the reassignment. Possible values: * &#x60;reassignmentInProgress&#x60;: the
   * terminal was boarded and is now scheduled to remove the configuration. Wait for the terminal to
   * synchronize with the Adyen platform. * &#x60;deployed&#x60;: the terminal is deployed and
   * reassigned. * &#x60;inventory&#x60;: the terminal is in inventory and cannot process
   * transactions. * &#x60;boarded&#x60;: the terminal is boarded to a store, or a merchant account
   * representing a store, and can process transactions.
   *
   * @param status The status of the reassignment. Possible values: *
   *     &#x60;reassignmentInProgress&#x60;: the terminal was boarded and is now scheduled to remove
   *     the configuration. Wait for the terminal to synchronize with the Adyen platform. *
   *     &#x60;deployed&#x60;: the terminal is deployed and reassigned. * &#x60;inventory&#x60;: the
   *     terminal is in inventory and cannot process transactions. * &#x60;boarded&#x60;: the
   *     terminal is boarded to a store, or a merchant account representing a store, and can process
   *     transactions.
   * @return the current {@code TerminalAssignment} instance, allowing for method chaining
   */
  public TerminalAssignment status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * The status of the reassignment. Possible values: * &#x60;reassignmentInProgress&#x60;: the
   * terminal was boarded and is now scheduled to remove the configuration. Wait for the terminal to
   * synchronize with the Adyen platform. * &#x60;deployed&#x60;: the terminal is deployed and
   * reassigned. * &#x60;inventory&#x60;: the terminal is in inventory and cannot process
   * transactions. * &#x60;boarded&#x60;: the terminal is boarded to a store, or a merchant account
   * representing a store, and can process transactions.
   *
   * @return status The status of the reassignment. Possible values: *
   *     &#x60;reassignmentInProgress&#x60;: the terminal was boarded and is now scheduled to remove
   *     the configuration. Wait for the terminal to synchronize with the Adyen platform. *
   *     &#x60;deployed&#x60;: the terminal is deployed and reassigned. * &#x60;inventory&#x60;: the
   *     terminal is in inventory and cannot process transactions. * &#x60;boarded&#x60;: the
   *     terminal is boarded to a store, or a merchant account representing a store, and can process
   *     transactions.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public StatusEnum getStatus() {
    return status;
  }

  /**
   * The status of the reassignment. Possible values: * &#x60;reassignmentInProgress&#x60;: the
   * terminal was boarded and is now scheduled to remove the configuration. Wait for the terminal to
   * synchronize with the Adyen platform. * &#x60;deployed&#x60;: the terminal is deployed and
   * reassigned. * &#x60;inventory&#x60;: the terminal is in inventory and cannot process
   * transactions. * &#x60;boarded&#x60;: the terminal is boarded to a store, or a merchant account
   * representing a store, and can process transactions.
   *
   * @param status The status of the reassignment. Possible values: *
   *     &#x60;reassignmentInProgress&#x60;: the terminal was boarded and is now scheduled to remove
   *     the configuration. Wait for the terminal to synchronize with the Adyen platform. *
   *     &#x60;deployed&#x60;: the terminal is deployed and reassigned. * &#x60;inventory&#x60;: the
   *     terminal is in inventory and cannot process transactions. * &#x60;boarded&#x60;: the
   *     terminal is boarded to a store, or a merchant account representing a store, and can process
   *     transactions.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  /**
   * The unique identifier of the store to which terminal is assigned.
   *
   * @param storeId The unique identifier of the store to which terminal is assigned.
   * @return the current {@code TerminalAssignment} instance, allowing for method chaining
   */
  public TerminalAssignment storeId(String storeId) {
    this.storeId = storeId;
    return this;
  }

  /**
   * The unique identifier of the store to which terminal is assigned.
   *
   * @return storeId The unique identifier of the store to which terminal is assigned.
   */
  @JsonProperty(JSON_PROPERTY_STORE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getStoreId() {
    return storeId;
  }

  /**
   * The unique identifier of the store to which terminal is assigned.
   *
   * @param storeId The unique identifier of the store to which terminal is assigned.
   */
  @JsonProperty(JSON_PROPERTY_STORE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStoreId(String storeId) {
    this.storeId = storeId;
  }

  /** Return true if this TerminalAssignment object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    TerminalAssignment terminalAssignment = (TerminalAssignment) o;
    return Objects.equals(this.companyId, terminalAssignment.companyId)
        && Objects.equals(this.merchantId, terminalAssignment.merchantId)
        && Objects.equals(this.reassignmentTarget, terminalAssignment.reassignmentTarget)
        && Objects.equals(this.status, terminalAssignment.status)
        && Objects.equals(this.storeId, terminalAssignment.storeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(companyId, merchantId, reassignmentTarget, status, storeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class TerminalAssignment {\n");
    sb.append("    companyId: ").append(toIndentedString(companyId)).append("\n");
    sb.append("    merchantId: ").append(toIndentedString(merchantId)).append("\n");
    sb.append("    reassignmentTarget: ").append(toIndentedString(reassignmentTarget)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    storeId: ").append(toIndentedString(storeId)).append("\n");
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
   * Create an instance of TerminalAssignment given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of TerminalAssignment
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     TerminalAssignment
   */
  public static TerminalAssignment fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, TerminalAssignment.class);
  }

  /**
   * Convert an instance of TerminalAssignment to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
