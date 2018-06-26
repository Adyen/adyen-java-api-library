/*
 * Adyen Checkout Service
 * Adyen Checkout API provides a simple and flexible way to initiate and authorise online payments. You can use the same integration for payments made with cards (including One-Click and 3D Secure), mobile wallets, and local payment methods (e.g. iDEAL and Sofort).  This API reference provides information on available endpoints and how to interact with them. To learn more about the API, visit [Checkout documentation](https://docs.adyen.com/developers/checkout).  ## Authentication Each request to the Checkout API must be signed with an API key. For this, obtain an API Key from your Customer Area, as described in [How to get the Checkout API key](https://docs.adyen.com/developers/user-management/how-to-get-the-checkout-api-key). Then set this key to the `X-API-Key` header value, for example:  ``` curl -H \"Content-Type: application/json\" \\ -H \"X-API-Key: Your_Checkout_API_key\" \\ ... ``` Note that when going live, you need to generate a new API Key to access the [live endpoints](https://docs.adyen.com/developers/api-reference/live-endpoints).  ## Versioning Checkout API supports versioning of its endpoints through a version suffix in the endpoint URL. This suffix has the following format: \"vXX\", where XX is the version number.  For example: ``` https://checkout-test.adyen.com/v32/payments ```
 *
 * OpenAPI spec version: 32
 * Contact: support@adyen.com
 *
 * Do not edit the class manually.
 */


package com.adyen.model.checkout;

import com.adyen.model.FraudResult;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * PaymentsResponse
 */
public class PaymentsResponse {

  @SerializedName("additionalData")
  private Map<String, String> additionalData = null;
  
  @SerializedName("details")
  private List<InputDetail> details = null;
  
  @SerializedName("fraudResult")
  private FraudResult fraudResult = null;
  
  @SerializedName("paymentData")
  private String paymentData = null;
  
  @SerializedName("pspReference")
  private String pspReference = null;
  
  @SerializedName("redirect")
  private Redirect redirect = null;
  
  @SerializedName("refusalReason")
  private String refusalReason = null;
  
  /**
   * The result of the payment. Possible values:  * **Authorised** – Indicates the payment authorisation was successfully completed. This state serves as an indicator to proceed with the delivery of goods and services. This is a final state. * **Refused** – Indicates the payment was refused. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state. * **RedirectShopper** – Indicates the shopper should be redirected to an external web page or app to complete the authorisation. For more information on handling a redirect, refer to [Handling a redirect](https://docs.adyen.com/developers/checkout/api-integration/payments#handlingaredirect). * **Received** – Indicates the payment has successfully been received by Adyen, and will be processed. This is the initial state for all payments. * **Cancelled** – Indicates the payment has been cancelled (either by the shopper or the merchant) before processing was completed. This is a final state. * **Pending** – Indicates that it is not possible to obtain the final status of the payment. This can happen if the systems providing final status information for the payment are unavailable, or if the shopper needs to take further action to complete the payment. For more information on handling a pending payment, refer to [Payments with pending status](https://docs.adyen.com/developers/development-resources/payments-with-pending-status). * **Error** – Indicates an error occurred during processing of the payment. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state.
   */
  @JsonAdapter(ResultCodeEnum.Adapter.class)
  public enum ResultCodeEnum {
    
    AUTHORISED("Authorised"),
    PARTIALLYAUTHORISED("PartiallyAuthorised"),
    REFUSED("Refused"),
    ERROR("Error"),
    CANCELLED("Cancelled"),
    RECEIVED("Received"),
    REDIRECTSHOPPER("RedirectShopper");

    private String value;

    ResultCodeEnum(String value) {
      this.value = value;
    }
    
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    
    public static ResultCodeEnum fromValue(String text) {
      for (ResultCodeEnum b : ResultCodeEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    
    public static class Adapter extends TypeAdapter<ResultCodeEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ResultCodeEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ResultCodeEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ResultCodeEnum.fromValue(String.valueOf(value));
      }
    }
  }
  
  @SerializedName("resultCode")
  private ResultCodeEnum resultCode = null;

  public PaymentsResponse additionalData(Map<String, String> additionalData) {
    this.additionalData = additionalData;
    return this;
  }

  public PaymentsResponse putAdditionalDataItem(String key, String additionalDataItem) {
    
    if (this.additionalData == null) {
      this.additionalData = null;
    }
    
    this.additionalData.put(key, additionalDataItem);
    return this;
  }
  /**
  * This field contains additional data, which may be required to return in a particular payment response. To choose data fields to be returned, go to **Customer Area** &gt; **Settings** &gt; **API and Response**.
  * @return additionalData
  **/
  public Map<String, String> getAdditionalData() {
    return additionalData;
  }
  public void setAdditionalData(Map<String, String> additionalData) {
    this.additionalData = additionalData;
  }

  public PaymentsResponse details(List<InputDetail> details) {
    this.details = details;
    return this;
  }

  public PaymentsResponse addDetailsItem(InputDetail detailsItem) {
    
    if (this.details == null) {
      this.details = new ArrayList<InputDetail>();
    }
    
    this.details.add(detailsItem);
    return this;
  }
  
  /**
  * When non-empty, contains all the fields that you must submit to the &#x60;/payments/details&#x60; endpoint.
  * @return details
  **/
  public List<InputDetail> getDetails() {
    return details;
  }
  public void setDetails(List<InputDetail> details) {
    this.details = details;
  }

  public PaymentsResponse fraudResult(FraudResult fraudResult) {
    this.fraudResult = fraudResult;
    return this;
  }

  
  /**
  * Get fraudResult
  * @return fraudResult
  **/
  public FraudResult getFraudResult() {
    return fraudResult;
  }
  public void setFraudResult(FraudResult fraudResult) {
    this.fraudResult = fraudResult;
  }

  public PaymentsResponse paymentData(String paymentData) {
    this.paymentData = paymentData;
    return this;
  }

  
  /**
  * When non-empty, contains a value that you must submit to the &#x60;/payments/details&#x60; endpoint.
  * @return paymentData
  **/
  public String getPaymentData() {
    return paymentData;
  }
  public void setPaymentData(String paymentData) {
    this.paymentData = paymentData;
  }

  public PaymentsResponse pspReference(String pspReference) {
    this.pspReference = pspReference;
    return this;
  }

  
  /**
  * Adyen&#x27;s 16-digit unique reference associated with the transaction/the request. This value is globally unique; quote it when communicating with us about this request.  &gt; &#x60;pspReference&#x60; is returned only for non-redirect payment methods.
  * @return pspReference
  **/
  public String getPspReference() {
    return pspReference;
  }
  public void setPspReference(String pspReference) {
    this.pspReference = pspReference;
  }

  public PaymentsResponse redirect(Redirect redirect) {
    this.redirect = redirect;
    return this;
  }

  
  /**
  * Get redirect
  * @return redirect
  **/
  public Redirect getRedirect() {
    return redirect;
  }
  public void setRedirect(Redirect redirect) {
    this.redirect = redirect;
  }

  public PaymentsResponse refusalReason(String refusalReason) {
    this.refusalReason = refusalReason;
    return this;
  }

  
  /**
  * If the payment&#x27;s authorisation is refused or an error occurs during authorisation, this field holds Adyen&#x27;s mapped reason for the refusal or a description of the error.  When a transaction fails, the authorisation response includes &#x60;resultCode&#x60; and &#x60;refusalReason&#x60; values.
  * @return refusalReason
  **/
  public String getRefusalReason() {
    return refusalReason;
  }
  public void setRefusalReason(String refusalReason) {
    this.refusalReason = refusalReason;
  }

  public PaymentsResponse resultCode(ResultCodeEnum resultCode) {
    this.resultCode = resultCode;
    return this;
  }

  
  /**
  * The result of the payment. Possible values:  * **Authorised** – Indicates the payment authorisation was successfully completed. This state serves as an indicator to proceed with the delivery of goods and services. This is a final state. * **Refused** – Indicates the payment was refused. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state. * **RedirectShopper** – Indicates the shopper should be redirected to an external web page or app to complete the authorisation. For more information on handling a redirect, refer to [Handling a redirect](https://docs.adyen.com/developers/checkout/api-integration/payments#handlingaredirect). * **Received** – Indicates the payment has successfully been received by Adyen, and will be processed. This is the initial state for all payments. * **Cancelled** – Indicates the payment has been cancelled (either by the shopper or the merchant) before processing was completed. This is a final state. * **Pending** – Indicates that it is not possible to obtain the final status of the payment. This can happen if the systems providing final status information for the payment are unavailable, or if the shopper needs to take further action to complete the payment. For more information on handling a pending payment, refer to [Payments with pending status](https://docs.adyen.com/developers/development-resources/payments-with-pending-status). * **Error** – Indicates an error occurred during processing of the payment. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state.
  * @return resultCode
  **/
  public ResultCodeEnum getResultCode() {
    return resultCode;
  }
  public void setResultCode(ResultCodeEnum resultCode) {
    this.resultCode = resultCode;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentsResponse paymentsResponse = (PaymentsResponse) o;
    return Objects.equals(this.additionalData, paymentsResponse.additionalData) &&
            Objects.equals(this.details, paymentsResponse.details) &&
            Objects.equals(this.fraudResult, paymentsResponse.fraudResult) &&
            Objects.equals(this.paymentData, paymentsResponse.paymentData) &&
            Objects.equals(this.pspReference, paymentsResponse.pspReference) &&
            Objects.equals(this.redirect, paymentsResponse.redirect) &&
            Objects.equals(this.refusalReason, paymentsResponse.refusalReason) &&
            Objects.equals(this.resultCode, paymentsResponse.resultCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(additionalData, details, fraudResult, paymentData, pspReference, redirect, refusalReason, resultCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentsResponse {\n");

    sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    fraudResult: ").append(toIndentedString(fraudResult)).append("\n");
    sb.append("    paymentData: ").append(toIndentedString(paymentData)).append("\n");
    sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
    sb.append("    redirect: ").append(toIndentedString(redirect)).append("\n");
    sb.append("    refusalReason: ").append(toIndentedString(refusalReason)).append("\n");
    sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
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

  
}



