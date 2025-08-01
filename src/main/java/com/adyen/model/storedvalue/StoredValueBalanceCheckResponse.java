/*
 * Adyen Stored Value API
 *
 * The version of the OpenAPI document: 46
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.storedvalue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.Arrays;
import java.util.logging.Logger;

/** StoredValueBalanceCheckResponse */
@JsonPropertyOrder({
  StoredValueBalanceCheckResponse.JSON_PROPERTY_CURRENT_BALANCE,
  StoredValueBalanceCheckResponse.JSON_PROPERTY_PSP_REFERENCE,
  StoredValueBalanceCheckResponse.JSON_PROPERTY_REFUSAL_REASON,
  StoredValueBalanceCheckResponse.JSON_PROPERTY_RESULT_CODE,
  StoredValueBalanceCheckResponse.JSON_PROPERTY_THIRD_PARTY_REFUSAL_REASON
})
public class StoredValueBalanceCheckResponse {
  public static final String JSON_PROPERTY_CURRENT_BALANCE = "currentBalance";
  private Amount currentBalance;

  public static final String JSON_PROPERTY_PSP_REFERENCE = "pspReference";
  private String pspReference;

  public static final String JSON_PROPERTY_REFUSAL_REASON = "refusalReason";
  private String refusalReason;

  /**
   * The result of the payment. Possible values: * **Success** – The operation has been completed
   * successfully. * **Refused** – The operation was refused. The reason is given in the
   * &#x60;refusalReason&#x60; field. * **Error** – There was an error when the operation was
   * processed. The reason is given in the &#x60;refusalReason&#x60; field. * **NotEnoughBalance** –
   * The amount on the payment method is lower than the amount given in the request. Only applicable
   * to balance checks.
   */
  public enum ResultCodeEnum {
    SUCCESS(String.valueOf("Success")),

    REFUSED(String.valueOf("Refused")),

    ERROR(String.valueOf("Error")),

    NOTENOUGHBALANCE(String.valueOf("NotEnoughBalance"));

    private static final Logger LOG = Logger.getLogger(ResultCodeEnum.class.getName());

    private String value;

    ResultCodeEnum(String value) {
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
    public static ResultCodeEnum fromValue(String value) {
      for (ResultCodeEnum b : ResultCodeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      // handling unexpected value
      LOG.warning(
          "ResultCodeEnum: unexpected enum value '"
              + value
              + "' - Supported values are "
              + Arrays.toString(ResultCodeEnum.values()));
      return null;
    }
  }

  public static final String JSON_PROPERTY_RESULT_CODE = "resultCode";
  private ResultCodeEnum resultCode;

  public static final String JSON_PROPERTY_THIRD_PARTY_REFUSAL_REASON = "thirdPartyRefusalReason";
  private String thirdPartyRefusalReason;

  public StoredValueBalanceCheckResponse() {}

  /**
   * currentBalance
   *
   * @param currentBalance
   * @return the current {@code StoredValueBalanceCheckResponse} instance, allowing for method
   *     chaining
   */
  public StoredValueBalanceCheckResponse currentBalance(Amount currentBalance) {
    this.currentBalance = currentBalance;
    return this;
  }

  /**
   * Get currentBalance
   *
   * @return currentBalance
   */
  @JsonProperty(JSON_PROPERTY_CURRENT_BALANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Amount getCurrentBalance() {
    return currentBalance;
  }

  /**
   * currentBalance
   *
   * @param currentBalance
   */
  @JsonProperty(JSON_PROPERTY_CURRENT_BALANCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCurrentBalance(Amount currentBalance) {
    this.currentBalance = currentBalance;
  }

  /**
   * Adyen&#39;s 16-character string reference associated with the transaction/request. This value
   * is globally unique; quote it when communicating with us about this request.
   *
   * @param pspReference Adyen&#39;s 16-character string reference associated with the
   *     transaction/request. This value is globally unique; quote it when communicating with us
   *     about this request.
   * @return the current {@code StoredValueBalanceCheckResponse} instance, allowing for method
   *     chaining
   */
  public StoredValueBalanceCheckResponse pspReference(String pspReference) {
    this.pspReference = pspReference;
    return this;
  }

  /**
   * Adyen&#39;s 16-character string reference associated with the transaction/request. This value
   * is globally unique; quote it when communicating with us about this request.
   *
   * @return pspReference Adyen&#39;s 16-character string reference associated with the
   *     transaction/request. This value is globally unique; quote it when communicating with us
   *     about this request.
   */
  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getPspReference() {
    return pspReference;
  }

  /**
   * Adyen&#39;s 16-character string reference associated with the transaction/request. This value
   * is globally unique; quote it when communicating with us about this request.
   *
   * @param pspReference Adyen&#39;s 16-character string reference associated with the
   *     transaction/request. This value is globally unique; quote it when communicating with us
   *     about this request.
   */
  @JsonProperty(JSON_PROPERTY_PSP_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPspReference(String pspReference) {
    this.pspReference = pspReference;
  }

  /**
   * If the transaction is refused or an error occurs, this field holds Adyen&#39;s mapped reason
   * for the refusal or a description of the error. When a transaction fails, the authorisation
   * response includes &#x60;resultCode&#x60; and &#x60;refusalReason&#x60; values.
   *
   * @param refusalReason If the transaction is refused or an error occurs, this field holds
   *     Adyen&#39;s mapped reason for the refusal or a description of the error. When a transaction
   *     fails, the authorisation response includes &#x60;resultCode&#x60; and
   *     &#x60;refusalReason&#x60; values.
   * @return the current {@code StoredValueBalanceCheckResponse} instance, allowing for method
   *     chaining
   */
  public StoredValueBalanceCheckResponse refusalReason(String refusalReason) {
    this.refusalReason = refusalReason;
    return this;
  }

  /**
   * If the transaction is refused or an error occurs, this field holds Adyen&#39;s mapped reason
   * for the refusal or a description of the error. When a transaction fails, the authorisation
   * response includes &#x60;resultCode&#x60; and &#x60;refusalReason&#x60; values.
   *
   * @return refusalReason If the transaction is refused or an error occurs, this field holds
   *     Adyen&#39;s mapped reason for the refusal or a description of the error. When a transaction
   *     fails, the authorisation response includes &#x60;resultCode&#x60; and
   *     &#x60;refusalReason&#x60; values.
   */
  @JsonProperty(JSON_PROPERTY_REFUSAL_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRefusalReason() {
    return refusalReason;
  }

  /**
   * If the transaction is refused or an error occurs, this field holds Adyen&#39;s mapped reason
   * for the refusal or a description of the error. When a transaction fails, the authorisation
   * response includes &#x60;resultCode&#x60; and &#x60;refusalReason&#x60; values.
   *
   * @param refusalReason If the transaction is refused or an error occurs, this field holds
   *     Adyen&#39;s mapped reason for the refusal or a description of the error. When a transaction
   *     fails, the authorisation response includes &#x60;resultCode&#x60; and
   *     &#x60;refusalReason&#x60; values.
   */
  @JsonProperty(JSON_PROPERTY_REFUSAL_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRefusalReason(String refusalReason) {
    this.refusalReason = refusalReason;
  }

  /**
   * The result of the payment. Possible values: * **Success** – The operation has been completed
   * successfully. * **Refused** – The operation was refused. The reason is given in the
   * &#x60;refusalReason&#x60; field. * **Error** – There was an error when the operation was
   * processed. The reason is given in the &#x60;refusalReason&#x60; field. * **NotEnoughBalance** –
   * The amount on the payment method is lower than the amount given in the request. Only applicable
   * to balance checks.
   *
   * @param resultCode The result of the payment. Possible values: * **Success** – The operation has
   *     been completed successfully. * **Refused** – The operation was refused. The reason is given
   *     in the &#x60;refusalReason&#x60; field. * **Error** – There was an error when the operation
   *     was processed. The reason is given in the &#x60;refusalReason&#x60; field. *
   *     **NotEnoughBalance** – The amount on the payment method is lower than the amount given in
   *     the request. Only applicable to balance checks.
   * @return the current {@code StoredValueBalanceCheckResponse} instance, allowing for method
   *     chaining
   */
  public StoredValueBalanceCheckResponse resultCode(ResultCodeEnum resultCode) {
    this.resultCode = resultCode;
    return this;
  }

  /**
   * The result of the payment. Possible values: * **Success** – The operation has been completed
   * successfully. * **Refused** – The operation was refused. The reason is given in the
   * &#x60;refusalReason&#x60; field. * **Error** – There was an error when the operation was
   * processed. The reason is given in the &#x60;refusalReason&#x60; field. * **NotEnoughBalance** –
   * The amount on the payment method is lower than the amount given in the request. Only applicable
   * to balance checks.
   *
   * @return resultCode The result of the payment. Possible values: * **Success** – The operation
   *     has been completed successfully. * **Refused** – The operation was refused. The reason is
   *     given in the &#x60;refusalReason&#x60; field. * **Error** – There was an error when the
   *     operation was processed. The reason is given in the &#x60;refusalReason&#x60; field. *
   *     **NotEnoughBalance** – The amount on the payment method is lower than the amount given in
   *     the request. Only applicable to balance checks.
   */
  @JsonProperty(JSON_PROPERTY_RESULT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ResultCodeEnum getResultCode() {
    return resultCode;
  }

  /**
   * The result of the payment. Possible values: * **Success** – The operation has been completed
   * successfully. * **Refused** – The operation was refused. The reason is given in the
   * &#x60;refusalReason&#x60; field. * **Error** – There was an error when the operation was
   * processed. The reason is given in the &#x60;refusalReason&#x60; field. * **NotEnoughBalance** –
   * The amount on the payment method is lower than the amount given in the request. Only applicable
   * to balance checks.
   *
   * @param resultCode The result of the payment. Possible values: * **Success** – The operation has
   *     been completed successfully. * **Refused** – The operation was refused. The reason is given
   *     in the &#x60;refusalReason&#x60; field. * **Error** – There was an error when the operation
   *     was processed. The reason is given in the &#x60;refusalReason&#x60; field. *
   *     **NotEnoughBalance** – The amount on the payment method is lower than the amount given in
   *     the request. Only applicable to balance checks.
   */
  @JsonProperty(JSON_PROPERTY_RESULT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setResultCode(ResultCodeEnum resultCode) {
    this.resultCode = resultCode;
  }

  /**
   * Raw refusal reason received from the third party, where available
   *
   * @param thirdPartyRefusalReason Raw refusal reason received from the third party, where
   *     available
   * @return the current {@code StoredValueBalanceCheckResponse} instance, allowing for method
   *     chaining
   */
  public StoredValueBalanceCheckResponse thirdPartyRefusalReason(String thirdPartyRefusalReason) {
    this.thirdPartyRefusalReason = thirdPartyRefusalReason;
    return this;
  }

  /**
   * Raw refusal reason received from the third party, where available
   *
   * @return thirdPartyRefusalReason Raw refusal reason received from the third party, where
   *     available
   */
  @JsonProperty(JSON_PROPERTY_THIRD_PARTY_REFUSAL_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getThirdPartyRefusalReason() {
    return thirdPartyRefusalReason;
  }

  /**
   * Raw refusal reason received from the third party, where available
   *
   * @param thirdPartyRefusalReason Raw refusal reason received from the third party, where
   *     available
   */
  @JsonProperty(JSON_PROPERTY_THIRD_PARTY_REFUSAL_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setThirdPartyRefusalReason(String thirdPartyRefusalReason) {
    this.thirdPartyRefusalReason = thirdPartyRefusalReason;
  }

  /** Return true if this StoredValueBalanceCheckResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoredValueBalanceCheckResponse storedValueBalanceCheckResponse =
        (StoredValueBalanceCheckResponse) o;
    return Objects.equals(this.currentBalance, storedValueBalanceCheckResponse.currentBalance)
        && Objects.equals(this.pspReference, storedValueBalanceCheckResponse.pspReference)
        && Objects.equals(this.refusalReason, storedValueBalanceCheckResponse.refusalReason)
        && Objects.equals(this.resultCode, storedValueBalanceCheckResponse.resultCode)
        && Objects.equals(
            this.thirdPartyRefusalReason, storedValueBalanceCheckResponse.thirdPartyRefusalReason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        currentBalance, pspReference, refusalReason, resultCode, thirdPartyRefusalReason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoredValueBalanceCheckResponse {\n");
    sb.append("    currentBalance: ").append(toIndentedString(currentBalance)).append("\n");
    sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
    sb.append("    refusalReason: ").append(toIndentedString(refusalReason)).append("\n");
    sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
    sb.append("    thirdPartyRefusalReason: ")
        .append(toIndentedString(thirdPartyRefusalReason))
        .append("\n");
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
   * Create an instance of StoredValueBalanceCheckResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of StoredValueBalanceCheckResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     StoredValueBalanceCheckResponse
   */
  public static StoredValueBalanceCheckResponse fromJson(String jsonString)
      throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, StoredValueBalanceCheckResponse.class);
  }

  /**
   * Convert an instance of StoredValueBalanceCheckResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
