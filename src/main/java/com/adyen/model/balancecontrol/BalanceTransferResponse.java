/*
 * Adyen Balance Control API
 *
 * The version of the OpenAPI document: 1
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.balancecontrol;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.Arrays;
import java.util.logging.Logger;

/** BalanceTransferResponse */
@JsonPropertyOrder({
  BalanceTransferResponse.JSON_PROPERTY_AMOUNT,
  BalanceTransferResponse.JSON_PROPERTY_CREATED_AT,
  BalanceTransferResponse.JSON_PROPERTY_DESCRIPTION,
  BalanceTransferResponse.JSON_PROPERTY_FROM_MERCHANT,
  BalanceTransferResponse.JSON_PROPERTY_PSP_REFERENCE,
  BalanceTransferResponse.JSON_PROPERTY_REFERENCE,
  BalanceTransferResponse.JSON_PROPERTY_STATUS,
  BalanceTransferResponse.JSON_PROPERTY_TO_MERCHANT,
  BalanceTransferResponse.JSON_PROPERTY_TYPE
})
public class BalanceTransferResponse {
  public static final String JSON_PROPERTY_AMOUNT = "amount";
  private Amount amount;

  public static final String JSON_PROPERTY_CREATED_AT = "createdAt";
  private OffsetDateTime createdAt;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;

  public static final String JSON_PROPERTY_FROM_MERCHANT = "fromMerchant";
  private String fromMerchant;

  public static final String JSON_PROPERTY_PSP_REFERENCE = "pspReference";
  private String pspReference;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;

  /**
   * The status of the balance transfer. Possible values: **transferred**, **failed**, **error**,
   * and **notEnoughBalance**.
   */
  public enum StatusEnum {
    ERROR(String.valueOf("error")),

    FAILED(String.valueOf("failed")),

    NOTENOUGHBALANCE(String.valueOf("notEnoughBalance")),

    TRANSFERRED(String.valueOf("transferred"));

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

  public static final String JSON_PROPERTY_TO_MERCHANT = "toMerchant";
  private String toMerchant;

  /**
   * The type of balance transfer. Possible values: **tax**, **fee**, **terminalSale**, **credit**,
   * **debit**, and **adjustment**.
   */
  public enum TypeEnum {
    TAX(String.valueOf("tax")),

    FEE(String.valueOf("fee")),

    TERMINALSALE(String.valueOf("terminalSale")),

    CREDIT(String.valueOf("credit")),

    DEBIT(String.valueOf("debit")),

    ADJUSTMENT(String.valueOf("adjustment"));

    private static final Logger LOG = Logger.getLogger(TypeEnum.class.getName());

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "TypeEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(TypeEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  public BalanceTransferResponse() {}

  /**
   * amount
   *
   * @param amount
   * @return the current {@code BalanceTransferResponse} instance, allowing for method chaining
   */
  public BalanceTransferResponse amount(Amount amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   *
   * @return amount
   */
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Amount getAmount() {
    return amount;
  }

  /**
   * amount
   *
   * @param amount
   */
  @JsonProperty(JSON_PROPERTY_AMOUNT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAmount(Amount amount) {
    this.amount = amount;
  }

  /**
   * The date when the balance transfer was requested.
   *
   * @param createdAt The date when the balance transfer was requested.
   * @return the current {@code BalanceTransferResponse} instance, allowing for method chaining
   */
  public BalanceTransferResponse createdAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
    return this;
  }

  /**
   * The date when the balance transfer was requested.
   *
   * @return createdAt The date when the balance transfer was requested.
   */
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getCreatedAt() {
    return createdAt;
  }

  /**
   * The date when the balance transfer was requested.
   *
   * @param createdAt The date when the balance transfer was requested.
   */
  @JsonProperty(JSON_PROPERTY_CREATED_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCreatedAt(OffsetDateTime createdAt) {
    this.createdAt = createdAt;
  }

  /**
   * A human-readable description for the transfer. You can use alphanumeric characters and hyphens.
   * We recommend sending a maximum of 140 characters, otherwise the description may be truncated.
   *
   * @param description A human-readable description for the transfer. You can use alphanumeric
   *     characters and hyphens. We recommend sending a maximum of 140 characters, otherwise the
   *     description may be truncated.
   * @return the current {@code BalanceTransferResponse} instance, allowing for method chaining
   */
  public BalanceTransferResponse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * A human-readable description for the transfer. You can use alphanumeric characters and hyphens.
   * We recommend sending a maximum of 140 characters, otherwise the description may be truncated.
   *
   * @return description A human-readable description for the transfer. You can use alphanumeric
   *     characters and hyphens. We recommend sending a maximum of 140 characters, otherwise the
   *     description may be truncated.
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDescription() {
    return description;
  }

  /**
   * A human-readable description for the transfer. You can use alphanumeric characters and hyphens.
   * We recommend sending a maximum of 140 characters, otherwise the description may be truncated.
   *
   * @param description A human-readable description for the transfer. You can use alphanumeric
   *     characters and hyphens. We recommend sending a maximum of 140 characters, otherwise the
   *     description may be truncated.
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * The unique identifier of the source merchant account from which funds are deducted.
   *
   * @param fromMerchant The unique identifier of the source merchant account from which funds are
   *     deducted.
   * @return the current {@code BalanceTransferResponse} instance, allowing for method chaining
   */
  public BalanceTransferResponse fromMerchant(String fromMerchant) {
    this.fromMerchant = fromMerchant;
    return this;
  }

  /**
   * The unique identifier of the source merchant account from which funds are deducted.
   *
   * @return fromMerchant The unique identifier of the source merchant account from which funds are
   *     deducted.
   */
  @JsonProperty(JSON_PROPERTY_FROM_MERCHANT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getFromMerchant() {
    return fromMerchant;
  }

  /**
   * The unique identifier of the source merchant account from which funds are deducted.
   *
   * @param fromMerchant The unique identifier of the source merchant account from which funds are
   *     deducted.
   */
  @JsonProperty(JSON_PROPERTY_FROM_MERCHANT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFromMerchant(String fromMerchant) {
    this.fromMerchant = fromMerchant;
  }

  /**
   * Adyen&#39;s 16-character string reference associated with the balance transfer.
   *
   * @param pspReference Adyen&#39;s 16-character string reference associated with the balance
   *     transfer.
   * @return the current {@code BalanceTransferResponse} instance, allowing for method chaining
   */
  public BalanceTransferResponse pspReference(String pspReference) {
    this.pspReference = pspReference;
    return this;
  }

  /**
   * Adyen&#39;s 16-character string reference associated with the balance transfer.
   *
   * @return pspReference Adyen&#39;s 16-character string reference associated with the balance
   *     transfer.
   */
  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPspReference() {
    return pspReference;
  }

  /**
   * Adyen&#39;s 16-character string reference associated with the balance transfer.
   *
   * @param pspReference Adyen&#39;s 16-character string reference associated with the balance
   *     transfer.
   */
  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPspReference(String pspReference) {
    this.pspReference = pspReference;
  }

  /**
   * A reference for the balance transfer. If you don&#39;t provide this in the request, Adyen
   * generates a unique reference. Maximum length: 80 characters.
   *
   * @param reference A reference for the balance transfer. If you don&#39;t provide this in the
   *     request, Adyen generates a unique reference. Maximum length: 80 characters.
   * @return the current {@code BalanceTransferResponse} instance, allowing for method chaining
   */
  public BalanceTransferResponse reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * A reference for the balance transfer. If you don&#39;t provide this in the request, Adyen
   * generates a unique reference. Maximum length: 80 characters.
   *
   * @return reference A reference for the balance transfer. If you don&#39;t provide this in the
   *     request, Adyen generates a unique reference. Maximum length: 80 characters.
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReference() {
    return reference;
  }

  /**
   * A reference for the balance transfer. If you don&#39;t provide this in the request, Adyen
   * generates a unique reference. Maximum length: 80 characters.
   *
   * @param reference A reference for the balance transfer. If you don&#39;t provide this in the
   *     request, Adyen generates a unique reference. Maximum length: 80 characters.
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReference(String reference) {
    this.reference = reference;
  }

  /**
   * The status of the balance transfer. Possible values: **transferred**, **failed**, **error**,
   * and **notEnoughBalance**.
   *
   * @param status The status of the balance transfer. Possible values: **transferred**, **failed**,
   *     **error**, and **notEnoughBalance**.
   * @return the current {@code BalanceTransferResponse} instance, allowing for method chaining
   */
  public BalanceTransferResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * The status of the balance transfer. Possible values: **transferred**, **failed**, **error**,
   * and **notEnoughBalance**.
   *
   * @return status The status of the balance transfer. Possible values: **transferred**,
   *     **failed**, **error**, and **notEnoughBalance**.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public StatusEnum getStatus() {
    return status;
  }

  /**
   * The status of the balance transfer. Possible values: **transferred**, **failed**, **error**,
   * and **notEnoughBalance**.
   *
   * @param status The status of the balance transfer. Possible values: **transferred**, **failed**,
   *     **error**, and **notEnoughBalance**.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  /**
   * The unique identifier of the destination merchant account from which funds are transferred.
   *
   * @param toMerchant The unique identifier of the destination merchant account from which funds
   *     are transferred.
   * @return the current {@code BalanceTransferResponse} instance, allowing for method chaining
   */
  public BalanceTransferResponse toMerchant(String toMerchant) {
    this.toMerchant = toMerchant;
    return this;
  }

  /**
   * The unique identifier of the destination merchant account from which funds are transferred.
   *
   * @return toMerchant The unique identifier of the destination merchant account from which funds
   *     are transferred.
   */
  @JsonProperty(JSON_PROPERTY_TO_MERCHANT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getToMerchant() {
    return toMerchant;
  }

  /**
   * The unique identifier of the destination merchant account from which funds are transferred.
   *
   * @param toMerchant The unique identifier of the destination merchant account from which funds
   *     are transferred.
   */
  @JsonProperty(JSON_PROPERTY_TO_MERCHANT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setToMerchant(String toMerchant) {
    this.toMerchant = toMerchant;
  }

  /**
   * The type of balance transfer. Possible values: **tax**, **fee**, **terminalSale**, **credit**,
   * **debit**, and **adjustment**.
   *
   * @param type The type of balance transfer. Possible values: **tax**, **fee**, **terminalSale**,
   *     **credit**, **debit**, and **adjustment**.
   * @return the current {@code BalanceTransferResponse} instance, allowing for method chaining
   */
  public BalanceTransferResponse type(TypeEnum type) {
    this.type = type;
    return this;
  }

  /**
   * The type of balance transfer. Possible values: **tax**, **fee**, **terminalSale**, **credit**,
   * **debit**, and **adjustment**.
   *
   * @return type The type of balance transfer. Possible values: **tax**, **fee**, **terminalSale**,
   *     **credit**, **debit**, and **adjustment**.
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public TypeEnum getType() {
    return type;
  }

  /**
   * The type of balance transfer. Possible values: **tax**, **fee**, **terminalSale**, **credit**,
   * **debit**, and **adjustment**.
   *
   * @param type The type of balance transfer. Possible values: **tax**, **fee**, **terminalSale**,
   *     **credit**, **debit**, and **adjustment**.
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }

  /** Return true if this BalanceTransferResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BalanceTransferResponse balanceTransferResponse = (BalanceTransferResponse) o;
    return Objects.equals(this.amount, balanceTransferResponse.amount)
        && Objects.equals(this.createdAt, balanceTransferResponse.createdAt)
        && Objects.equals(this.description, balanceTransferResponse.description)
        && Objects.equals(this.fromMerchant, balanceTransferResponse.fromMerchant)
        && Objects.equals(this.pspReference, balanceTransferResponse.pspReference)
        && Objects.equals(this.reference, balanceTransferResponse.reference)
        && Objects.equals(this.status, balanceTransferResponse.status)
        && Objects.equals(this.toMerchant, balanceTransferResponse.toMerchant)
        && Objects.equals(this.type, balanceTransferResponse.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        amount,
        createdAt,
        description,
        fromMerchant,
        pspReference,
        reference,
        status,
        toMerchant,
        type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BalanceTransferResponse {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    fromMerchant: ").append(toIndentedString(fromMerchant)).append("\n");
    sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    toMerchant: ").append(toIndentedString(toMerchant)).append("\n");
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
   * Create an instance of BalanceTransferResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of BalanceTransferResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     BalanceTransferResponse
   */
  public static BalanceTransferResponse fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, BalanceTransferResponse.class);
  }

  /**
   * Convert an instance of BalanceTransferResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
