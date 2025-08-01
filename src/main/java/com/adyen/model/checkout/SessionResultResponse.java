/*
 * Adyen Checkout API
 *
 * The version of the OpenAPI document: 71
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.checkout;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/** SessionResultResponse */
@JsonPropertyOrder({
  SessionResultResponse.JSON_PROPERTY_ADDITIONAL_DATA,
  SessionResultResponse.JSON_PROPERTY_ID,
  SessionResultResponse.JSON_PROPERTY_PAYMENTS,
  SessionResultResponse.JSON_PROPERTY_REFERENCE,
  SessionResultResponse.JSON_PROPERTY_STATUS
})
public class SessionResultResponse {
  public static final String JSON_PROPERTY_ADDITIONAL_DATA = "additionalData";
  private Map<String, String> additionalData;

  public static final String JSON_PROPERTY_ID = "id";
  private String id;

  public static final String JSON_PROPERTY_PAYMENTS = "payments";
  private List<Payment> payments;

  public static final String JSON_PROPERTY_REFERENCE = "reference";
  private String reference;

  /**
   * The status of the session. The status included in the response doesn&#39;t get updated.
   * Don&#39;t make the request again to check for payment status updates. Possible values: *
   * **completed**: the shopper completed the payment, and the payment was authorized. *
   * **paymentPending**: the shopper is in the process of making the payment. This applies to
   * payment methods with an asynchronous flow, like voucher payments where the shopper completes
   * the payment in a physical shop. * **refused**: the session has been refused, because of too
   * many refused payment attempts. The shopper can no longer complete the payment with this
   * session. * **canceled**: the shopper canceled the payment. * **expired**: the session expired.
   * The shopper can no longer complete the payment with this session. By default, the session
   * expires one hour after it is created.
   */
  public enum StatusEnum {
    ACTIVE(String.valueOf("active")),

    CANCELED(String.valueOf("canceled")),

    COMPLETED(String.valueOf("completed")),

    EXPIRED(String.valueOf("expired")),

    PAYMENTPENDING(String.valueOf("paymentPending")),

    REFUSED(String.valueOf("refused"));

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

  public SessionResultResponse() {}

  /**
   * Contains additional information about the payment. Some fields are included only if you enable
   * them. To enable these fields in your Customer Area, go to **Developers** &gt; **Additional
   * data**.
   *
   * @param additionalData Contains additional information about the payment. Some fields are
   *     included only if you enable them. To enable these fields in your Customer Area, go to
   *     **Developers** &gt; **Additional data**.
   * @return the current {@code SessionResultResponse} instance, allowing for method chaining
   */
  public SessionResultResponse additionalData(Map<String, String> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public SessionResultResponse putAdditionalDataItem(String key, String additionalDataItem) {
    if (this.additionalData == null) {
      this.additionalData = new HashMap<>();
    }
    this.additionalData.put(key, additionalDataItem);
    return this;
  }

  /**
   * Contains additional information about the payment. Some fields are included only if you enable
   * them. To enable these fields in your Customer Area, go to **Developers** &gt; **Additional
   * data**.
   *
   * @return additionalData Contains additional information about the payment. Some fields are
   *     included only if you enable them. To enable these fields in your Customer Area, go to
   *     **Developers** &gt; **Additional data**.
   */
  @JsonProperty(JSON_PROPERTY_ADDITIONAL_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Map<String, String> getAdditionalData() {
    return additionalData;
  }

  /**
   * Contains additional information about the payment. Some fields are included only if you enable
   * them. To enable these fields in your Customer Area, go to **Developers** &gt; **Additional
   * data**.
   *
   * @param additionalData Contains additional information about the payment. Some fields are
   *     included only if you enable them. To enable these fields in your Customer Area, go to
   *     **Developers** &gt; **Additional data**.
   */
  @JsonProperty(JSON_PROPERTY_ADDITIONAL_DATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAdditionalData(Map<String, String> additionalData) {
    this.additionalData = additionalData;
  }

  /**
   * A unique identifier of the session.
   *
   * @param id A unique identifier of the session.
   * @return the current {@code SessionResultResponse} instance, allowing for method chaining
   */
  public SessionResultResponse id(String id) {
    this.id = id;
    return this;
  }

  /**
   * A unique identifier of the session.
   *
   * @return id A unique identifier of the session.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getId() {
    return id;
  }

  /**
   * A unique identifier of the session.
   *
   * @param id A unique identifier of the session.
   */
  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setId(String id) {
    this.id = id;
  }

  /**
   * A list of all authorised payments done for this session.
   *
   * @param payments A list of all authorised payments done for this session.
   * @return the current {@code SessionResultResponse} instance, allowing for method chaining
   */
  public SessionResultResponse payments(List<Payment> payments) {
    this.payments = payments;
    return this;
  }

  public SessionResultResponse addPaymentsItem(Payment paymentsItem) {
    if (this.payments == null) {
      this.payments = new ArrayList<>();
    }
    this.payments.add(paymentsItem);
    return this;
  }

  /**
   * A list of all authorised payments done for this session.
   *
   * @return payments A list of all authorised payments done for this session.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<Payment> getPayments() {
    return payments;
  }

  /**
   * A list of all authorised payments done for this session.
   *
   * @param payments A list of all authorised payments done for this session.
   */
  @JsonProperty(JSON_PROPERTY_PAYMENTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setPayments(List<Payment> payments) {
    this.payments = payments;
  }

  /**
   * The unique reference that you provided in the original &#x60;/sessions&#x60; request. This
   * identifies the payment and is used in all communication with you about the payment status.
   *
   * @param reference The unique reference that you provided in the original &#x60;/sessions&#x60;
   *     request. This identifies the payment and is used in all communication with you about the
   *     payment status.
   * @return the current {@code SessionResultResponse} instance, allowing for method chaining
   */
  public SessionResultResponse reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * The unique reference that you provided in the original &#x60;/sessions&#x60; request. This
   * identifies the payment and is used in all communication with you about the payment status.
   *
   * @return reference The unique reference that you provided in the original &#x60;/sessions&#x60;
   *     request. This identifies the payment and is used in all communication with you about the
   *     payment status.
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getReference() {
    return reference;
  }

  /**
   * The unique reference that you provided in the original &#x60;/sessions&#x60; request. This
   * identifies the payment and is used in all communication with you about the payment status.
   *
   * @param reference The unique reference that you provided in the original &#x60;/sessions&#x60;
   *     request. This identifies the payment and is used in all communication with you about the
   *     payment status.
   */
  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReference(String reference) {
    this.reference = reference;
  }

  /**
   * The status of the session. The status included in the response doesn&#39;t get updated.
   * Don&#39;t make the request again to check for payment status updates. Possible values: *
   * **completed**: the shopper completed the payment, and the payment was authorized. *
   * **paymentPending**: the shopper is in the process of making the payment. This applies to
   * payment methods with an asynchronous flow, like voucher payments where the shopper completes
   * the payment in a physical shop. * **refused**: the session has been refused, because of too
   * many refused payment attempts. The shopper can no longer complete the payment with this
   * session. * **canceled**: the shopper canceled the payment. * **expired**: the session expired.
   * The shopper can no longer complete the payment with this session. By default, the session
   * expires one hour after it is created.
   *
   * @param status The status of the session. The status included in the response doesn&#39;t get
   *     updated. Don&#39;t make the request again to check for payment status updates. Possible
   *     values: * **completed**: the shopper completed the payment, and the payment was authorized.
   *     * **paymentPending**: the shopper is in the process of making the payment. This applies to
   *     payment methods with an asynchronous flow, like voucher payments where the shopper
   *     completes the payment in a physical shop. * **refused**: the session has been refused,
   *     because of too many refused payment attempts. The shopper can no longer complete the
   *     payment with this session. * **canceled**: the shopper canceled the payment. * **expired**:
   *     the session expired. The shopper can no longer complete the payment with this session. By
   *     default, the session expires one hour after it is created.
   * @return the current {@code SessionResultResponse} instance, allowing for method chaining
   */
  public SessionResultResponse status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * The status of the session. The status included in the response doesn&#39;t get updated.
   * Don&#39;t make the request again to check for payment status updates. Possible values: *
   * **completed**: the shopper completed the payment, and the payment was authorized. *
   * **paymentPending**: the shopper is in the process of making the payment. This applies to
   * payment methods with an asynchronous flow, like voucher payments where the shopper completes
   * the payment in a physical shop. * **refused**: the session has been refused, because of too
   * many refused payment attempts. The shopper can no longer complete the payment with this
   * session. * **canceled**: the shopper canceled the payment. * **expired**: the session expired.
   * The shopper can no longer complete the payment with this session. By default, the session
   * expires one hour after it is created.
   *
   * @return status The status of the session. The status included in the response doesn&#39;t get
   *     updated. Don&#39;t make the request again to check for payment status updates. Possible
   *     values: * **completed**: the shopper completed the payment, and the payment was authorized.
   *     * **paymentPending**: the shopper is in the process of making the payment. This applies to
   *     payment methods with an asynchronous flow, like voucher payments where the shopper
   *     completes the payment in a physical shop. * **refused**: the session has been refused,
   *     because of too many refused payment attempts. The shopper can no longer complete the
   *     payment with this session. * **canceled**: the shopper canceled the payment. * **expired**:
   *     the session expired. The shopper can no longer complete the payment with this session. By
   *     default, the session expires one hour after it is created.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public StatusEnum getStatus() {
    return status;
  }

  /**
   * The status of the session. The status included in the response doesn&#39;t get updated.
   * Don&#39;t make the request again to check for payment status updates. Possible values: *
   * **completed**: the shopper completed the payment, and the payment was authorized. *
   * **paymentPending**: the shopper is in the process of making the payment. This applies to
   * payment methods with an asynchronous flow, like voucher payments where the shopper completes
   * the payment in a physical shop. * **refused**: the session has been refused, because of too
   * many refused payment attempts. The shopper can no longer complete the payment with this
   * session. * **canceled**: the shopper canceled the payment. * **expired**: the session expired.
   * The shopper can no longer complete the payment with this session. By default, the session
   * expires one hour after it is created.
   *
   * @param status The status of the session. The status included in the response doesn&#39;t get
   *     updated. Don&#39;t make the request again to check for payment status updates. Possible
   *     values: * **completed**: the shopper completed the payment, and the payment was authorized.
   *     * **paymentPending**: the shopper is in the process of making the payment. This applies to
   *     payment methods with an asynchronous flow, like voucher payments where the shopper
   *     completes the payment in a physical shop. * **refused**: the session has been refused,
   *     because of too many refused payment attempts. The shopper can no longer complete the
   *     payment with this session. * **canceled**: the shopper canceled the payment. * **expired**:
   *     the session expired. The shopper can no longer complete the payment with this session. By
   *     default, the session expires one hour after it is created.
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(StatusEnum status) {
    this.status = status;
  }

  /** Return true if this SessionResultResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SessionResultResponse sessionResultResponse = (SessionResultResponse) o;
    return Objects.equals(this.additionalData, sessionResultResponse.additionalData)
        && Objects.equals(this.id, sessionResultResponse.id)
        && Objects.equals(this.payments, sessionResultResponse.payments)
        && Objects.equals(this.reference, sessionResultResponse.reference)
        && Objects.equals(this.status, sessionResultResponse.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalData, id, payments, reference, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SessionResultResponse {\n");
    sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    payments: ").append(toIndentedString(payments)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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
   * Create an instance of SessionResultResponse given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of SessionResultResponse
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     SessionResultResponse
   */
  public static SessionResultResponse fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, SessionResultResponse.class);
  }

  /**
   * Convert an instance of SessionResultResponse to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
