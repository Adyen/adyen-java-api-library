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

import java.util.Objects;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;


/**
 * CashAppDetails
 */
@JsonPropertyOrder({
  CashAppDetails.JSON_PROPERTY_CASHTAG,
  CashAppDetails.JSON_PROPERTY_CHECKOUT_ATTEMPT_ID,
  CashAppDetails.JSON_PROPERTY_CUSTOMER_ID,
  CashAppDetails.JSON_PROPERTY_GRANT_ID,
  CashAppDetails.JSON_PROPERTY_ON_FILE_GRANT_ID,
  CashAppDetails.JSON_PROPERTY_RECURRING_DETAIL_REFERENCE,
  CashAppDetails.JSON_PROPERTY_REQUEST_ID,
  CashAppDetails.JSON_PROPERTY_STORED_PAYMENT_METHOD_ID,
  CashAppDetails.JSON_PROPERTY_SUBTYPE,
  CashAppDetails.JSON_PROPERTY_TYPE
})

public class CashAppDetails {
  public static final String JSON_PROPERTY_CASHTAG = "cashtag";
  private String cashtag;

  public static final String JSON_PROPERTY_CHECKOUT_ATTEMPT_ID = "checkoutAttemptId";
  private String checkoutAttemptId;

  public static final String JSON_PROPERTY_CUSTOMER_ID = "customerId";
  private String customerId;

  public static final String JSON_PROPERTY_GRANT_ID = "grantId";
  private String grantId;

  public static final String JSON_PROPERTY_ON_FILE_GRANT_ID = "onFileGrantId";
  private String onFileGrantId;

  public static final String JSON_PROPERTY_RECURRING_DETAIL_REFERENCE = "recurringDetailReference";
  @Deprecated
  private String recurringDetailReference;

  public static final String JSON_PROPERTY_REQUEST_ID = "requestId";
  private String requestId;

  public static final String JSON_PROPERTY_STORED_PAYMENT_METHOD_ID = "storedPaymentMethodId";
  private String storedPaymentMethodId;

  public static final String JSON_PROPERTY_SUBTYPE = "subtype";
  private String subtype;

  /**
   * cashapp
   */
  public enum TypeEnum {
    CASHAPP("cashapp");

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
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private TypeEnum type;

  public CashAppDetails() { 
  }

  public CashAppDetails cashtag(String cashtag) {
    this.cashtag = cashtag;
    return this;
  }

   /**
   * Cash App issued cashtag for recurring payment
   * @return cashtag
  **/
  @ApiModelProperty(value = "Cash App issued cashtag for recurring payment")
  @JsonProperty(JSON_PROPERTY_CASHTAG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCashtag() {
    return cashtag;
  }


 /**
  * Cash App issued cashtag for recurring payment
  *
  * @param cashtag
  */ 
  @JsonProperty(JSON_PROPERTY_CASHTAG)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCashtag(String cashtag) {
    this.cashtag = cashtag;
  }


  public CashAppDetails checkoutAttemptId(String checkoutAttemptId) {
    this.checkoutAttemptId = checkoutAttemptId;
    return this;
  }

   /**
   * The checkout attempt identifier.
   * @return checkoutAttemptId
  **/
  @ApiModelProperty(value = "The checkout attempt identifier.")
  @JsonProperty(JSON_PROPERTY_CHECKOUT_ATTEMPT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCheckoutAttemptId() {
    return checkoutAttemptId;
  }


 /**
  * The checkout attempt identifier.
  *
  * @param checkoutAttemptId
  */ 
  @JsonProperty(JSON_PROPERTY_CHECKOUT_ATTEMPT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCheckoutAttemptId(String checkoutAttemptId) {
    this.checkoutAttemptId = checkoutAttemptId;
  }


  public CashAppDetails customerId(String customerId) {
    this.customerId = customerId;
    return this;
  }

   /**
   * Cash App issued customerId for recurring payment
   * @return customerId
  **/
  @ApiModelProperty(value = "Cash App issued customerId for recurring payment")
  @JsonProperty(JSON_PROPERTY_CUSTOMER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getCustomerId() {
    return customerId;
  }


 /**
  * Cash App issued customerId for recurring payment
  *
  * @param customerId
  */ 
  @JsonProperty(JSON_PROPERTY_CUSTOMER_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }


  public CashAppDetails grantId(String grantId) {
    this.grantId = grantId;
    return this;
  }

   /**
   * Cash App issued grantId for one time payment
   * @return grantId
  **/
  @ApiModelProperty(value = "Cash App issued grantId for one time payment")
  @JsonProperty(JSON_PROPERTY_GRANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getGrantId() {
    return grantId;
  }


 /**
  * Cash App issued grantId for one time payment
  *
  * @param grantId
  */ 
  @JsonProperty(JSON_PROPERTY_GRANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setGrantId(String grantId) {
    this.grantId = grantId;
  }


  public CashAppDetails onFileGrantId(String onFileGrantId) {
    this.onFileGrantId = onFileGrantId;
    return this;
  }

   /**
   * Cash App issued onFileGrantId for recurring payment
   * @return onFileGrantId
  **/
  @ApiModelProperty(value = "Cash App issued onFileGrantId for recurring payment")
  @JsonProperty(JSON_PROPERTY_ON_FILE_GRANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getOnFileGrantId() {
    return onFileGrantId;
  }


 /**
  * Cash App issued onFileGrantId for recurring payment
  *
  * @param onFileGrantId
  */ 
  @JsonProperty(JSON_PROPERTY_ON_FILE_GRANT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOnFileGrantId(String onFileGrantId) {
    this.onFileGrantId = onFileGrantId;
  }


  @Deprecated
  public CashAppDetails recurringDetailReference(String recurringDetailReference) {
    this.recurringDetailReference = recurringDetailReference;
    return this;
  }

   /**
   * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
   * @return recurringDetailReference
   * @deprecated
  **/
  @Deprecated
  @ApiModelProperty(value = "This is the `recurringDetailReference` returned in the response when you created the token.")
  @JsonProperty(JSON_PROPERTY_RECURRING_DETAIL_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRecurringDetailReference() {
    return recurringDetailReference;
  }


 /**
  * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
  *
  * @param recurringDetailReference
  */ 
  @Deprecated
  @JsonProperty(JSON_PROPERTY_RECURRING_DETAIL_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRecurringDetailReference(String recurringDetailReference) {
    this.recurringDetailReference = recurringDetailReference;
  }


  public CashAppDetails requestId(String requestId) {
    this.requestId = requestId;
    return this;
  }

   /**
   * Cash App request id
   * @return requestId
  **/
  @ApiModelProperty(value = "Cash App request id")
  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getRequestId() {
    return requestId;
  }


 /**
  * Cash App request id
  *
  * @param requestId
  */ 
  @JsonProperty(JSON_PROPERTY_REQUEST_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRequestId(String requestId) {
    this.requestId = requestId;
  }


  public CashAppDetails storedPaymentMethodId(String storedPaymentMethodId) {
    this.storedPaymentMethodId = storedPaymentMethodId;
    return this;
  }

   /**
   * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
   * @return storedPaymentMethodId
  **/
  @ApiModelProperty(value = "This is the `recurringDetailReference` returned in the response when you created the token.")
  @JsonProperty(JSON_PROPERTY_STORED_PAYMENT_METHOD_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getStoredPaymentMethodId() {
    return storedPaymentMethodId;
  }


 /**
  * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
  *
  * @param storedPaymentMethodId
  */ 
  @JsonProperty(JSON_PROPERTY_STORED_PAYMENT_METHOD_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStoredPaymentMethodId(String storedPaymentMethodId) {
    this.storedPaymentMethodId = storedPaymentMethodId;
  }


  public CashAppDetails subtype(String subtype) {
    this.subtype = subtype;
    return this;
  }

   /**
   * The payment method subtype.
   * @return subtype
  **/
  @ApiModelProperty(value = "The payment method subtype.")
  @JsonProperty(JSON_PROPERTY_SUBTYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public String getSubtype() {
    return subtype;
  }


 /**
  * The payment method subtype.
  *
  * @param subtype
  */ 
  @JsonProperty(JSON_PROPERTY_SUBTYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSubtype(String subtype) {
    this.subtype = subtype;
  }


  public CashAppDetails type(TypeEnum type) {
    this.type = type;
    return this;
  }

   /**
   * cashapp
   * @return type
  **/
  @ApiModelProperty(value = "cashapp")
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)

  public TypeEnum getType() {
    return type;
  }


 /**
  * cashapp
  *
  * @param type
  */ 
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(TypeEnum type) {
    this.type = type;
  }


  /**
   * Return true if this CashAppDetails object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CashAppDetails cashAppDetails = (CashAppDetails) o;
    return Objects.equals(this.cashtag, cashAppDetails.cashtag) &&
        Objects.equals(this.checkoutAttemptId, cashAppDetails.checkoutAttemptId) &&
        Objects.equals(this.customerId, cashAppDetails.customerId) &&
        Objects.equals(this.grantId, cashAppDetails.grantId) &&
        Objects.equals(this.onFileGrantId, cashAppDetails.onFileGrantId) &&
        Objects.equals(this.recurringDetailReference, cashAppDetails.recurringDetailReference) &&
        Objects.equals(this.requestId, cashAppDetails.requestId) &&
        Objects.equals(this.storedPaymentMethodId, cashAppDetails.storedPaymentMethodId) &&
        Objects.equals(this.subtype, cashAppDetails.subtype) &&
        Objects.equals(this.type, cashAppDetails.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cashtag, checkoutAttemptId, customerId, grantId, onFileGrantId, recurringDetailReference, requestId, storedPaymentMethodId, subtype, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CashAppDetails {\n");
    sb.append("    cashtag: ").append(toIndentedString(cashtag)).append("\n");
    sb.append("    checkoutAttemptId: ").append(toIndentedString(checkoutAttemptId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    grantId: ").append(toIndentedString(grantId)).append("\n");
    sb.append("    onFileGrantId: ").append(toIndentedString(onFileGrantId)).append("\n");
    sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
    sb.append("    requestId: ").append(toIndentedString(requestId)).append("\n");
    sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
    sb.append("    subtype: ").append(toIndentedString(subtype)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

/**
   * Create an instance of CashAppDetails given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of CashAppDetails
   * @throws JsonProcessingException if the JSON string is invalid with respect to CashAppDetails
   */
  public static CashAppDetails fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, CashAppDetails.class);
  }
/**
  * Convert an instance of CashAppDetails to an JSON string
  *
  * @return JSON string
  */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
