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

import com.google.gson.annotations.SerializedName;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * PaymentSetupResponse
 */
public class PaymentSetupResponse {

  @SerializedName("company")
  private Company company = null;
  
  @SerializedName("disableRecurringDetailUrl")
  private String disableRecurringDetailUrl = null;
  
  @SerializedName("generationtime")
  private String generationtime = null;
  
  @SerializedName("html")
  private String html = null;
  
  @SerializedName("initiationUrl")
  private String initiationUrl = null;
  
  @SerializedName("lineItems")
  private List<LineItem> lineItems = null;
  
  @SerializedName("logoBaseUrl")
  private String logoBaseUrl = null;
  
  @SerializedName("oneClickPaymentMethods")
  private List<RecurringDetail> oneClickPaymentMethods = null;
  
  @SerializedName("origin")
  private String origin = null;
  
  @SerializedName("originKey")
  private String originKey = null;
  
  @SerializedName("payment")
  private PaymentDetails payment = null;
  
  @SerializedName("paymentData")
  private String paymentData = null;
  
  @SerializedName("paymentMethods")
  private List<PaymentMethod> paymentMethods = null;
  
  @SerializedName("paymentSession")
  private String paymentSession = null;
  
  @SerializedName("publicKey")
  private String publicKey = null;
  
  @SerializedName("publicKeyToken")
  private String publicKeyToken = null;
  
  @SerializedName("sdkVersion")
  private String sdkVersion = null;
  
  public PaymentSetupResponse company(Company company) {
    this.company = company;
    return this;
  }

  
  /**
  * Get company
  * @return company
  **/
    public Company getCompany() {
    return company;
  }
  public void setCompany(Company company) {
    this.company = company;
  }
  
  public PaymentSetupResponse disableRecurringDetailUrl(String disableRecurringDetailUrl) {
    this.disableRecurringDetailUrl = disableRecurringDetailUrl;
    return this;
  }

  
  /**
  * The URL to disable recurring details.
  * @return disableRecurringDetailUrl
  **/
    public String getDisableRecurringDetailUrl() {
    return disableRecurringDetailUrl;
  }
  public void setDisableRecurringDetailUrl(String disableRecurringDetailUrl) {
    this.disableRecurringDetailUrl = disableRecurringDetailUrl;
  }
  
  public PaymentSetupResponse generationtime(String generationtime) {
    this.generationtime = generationtime;
    return this;
  }

  
  /**
  * The generationtime of this request, required for encryption.
  * @return generationtime
  **/
    public String getGenerationtime() {
    return generationtime;
  }
  public void setGenerationtime(String generationtime) {
    this.generationtime = generationtime;
  }
  
  public PaymentSetupResponse html(String html) {
    this.html = html;
    return this;
  }

  
  /**
  * The stream with html logic, if the html flag was set in the request.
  * @return html
  **/
    public String getHtml() {
    return html;
  }
  public void setHtml(String html) {
    this.html = html;
  }
  
  public PaymentSetupResponse initiationUrl(String initiationUrl) {
    this.initiationUrl = initiationUrl;
    return this;
  }

  
  /**
  * The URL for the initiation call.
  * @return initiationUrl
  **/
    public String getInitiationUrl() {
    return initiationUrl;
  }
  public void setInitiationUrl(String initiationUrl) {
    this.initiationUrl = initiationUrl;
  }
  
  public PaymentSetupResponse lineItems(List<LineItem> lineItems) {
    this.lineItems = lineItems;
    return this;
  }

  public PaymentSetupResponse addLineItemsItem(LineItem lineItemsItem) {
    
    if (this.lineItems == null) {
      this.lineItems = new ArrayList<LineItem>();
    }
    
    this.lineItems.add(lineItemsItem);
    return this;
  }
  
  /**
  * Line items that are required for some payment methods.
  * @return lineItems
  **/
    public List<LineItem> getLineItems() {
    return lineItems;
  }
  public void setLineItems(List<LineItem> lineItems) {
    this.lineItems = lineItems;
  }
  
  public PaymentSetupResponse logoBaseUrl(String logoBaseUrl) {
    this.logoBaseUrl = logoBaseUrl;
    return this;
  }

  
  /**
  * The base URL for payment method logos.
  * @return logoBaseUrl
  **/
    public String getLogoBaseUrl() {
    return logoBaseUrl;
  }
  public void setLogoBaseUrl(String logoBaseUrl) {
    this.logoBaseUrl = logoBaseUrl;
  }
  
  public PaymentSetupResponse oneClickPaymentMethods(List<RecurringDetail> oneClickPaymentMethods) {
    this.oneClickPaymentMethods = oneClickPaymentMethods;
    return this;
  }

  public PaymentSetupResponse addOneClickPaymentMethodsItem(RecurringDetail oneClickPaymentMethodsItem) {
    
    if (this.oneClickPaymentMethods == null) {
      this.oneClickPaymentMethods = new ArrayList<RecurringDetail>();
    }
    
    this.oneClickPaymentMethods.add(oneClickPaymentMethodsItem);
    return this;
  }
  
  /**
  * The detailed list of stored payment details required to generate payment forms. Will be empty if &#x60;enableOneClick&#x60; is set to false in the request.
  * @return oneClickPaymentMethods
  **/
    public List<RecurringDetail> getOneClickPaymentMethods() {
    return oneClickPaymentMethods;
  }
  public void setOneClickPaymentMethods(List<RecurringDetail> oneClickPaymentMethods) {
    this.oneClickPaymentMethods = oneClickPaymentMethods;
  }
  
  public PaymentSetupResponse origin(String origin) {
    this.origin = origin;
    return this;
  }

  
  /**
  * The user origin.
  * @return origin
  **/
    public String getOrigin() {
    return origin;
  }
  public void setOrigin(String origin) {
    this.origin = origin;
  }
  
  public PaymentSetupResponse originKey(String originKey) {
    this.originKey = originKey;
    return this;
  }

  
  /**
  * The encrypted user origin.
  * @return originKey
  **/
    public String getOriginKey() {
    return originKey;
  }
  public void setOriginKey(String originKey) {
    this.originKey = originKey;
  }
  
  public PaymentSetupResponse payment(PaymentDetails payment) {
    this.payment = payment;
    return this;
  }

  
  /**
  * Get payment
  * @return payment
  **/
    public PaymentDetails getPayment() {
    return payment;
  }
  public void setPayment(PaymentDetails payment) {
    this.payment = payment;
  }
  
  public PaymentSetupResponse paymentData(String paymentData) {
    this.paymentData = paymentData;
    return this;
  }

  
  /**
  * The data blob required to be sent in every future session call.
  * @return paymentData
  **/
    public String getPaymentData() {
    return paymentData;
  }
  public void setPaymentData(String paymentData) {
    this.paymentData = paymentData;
  }
  
  public PaymentSetupResponse paymentMethods(List<PaymentMethod> paymentMethods) {
    this.paymentMethods = paymentMethods;
    return this;
  }

  public PaymentSetupResponse addPaymentMethodsItem(PaymentMethod paymentMethodsItem) {
    
    if (this.paymentMethods == null) {
      this.paymentMethods = new ArrayList<PaymentMethod>();
    }
    
    this.paymentMethods.add(paymentMethodsItem);
    return this;
  }
  
  /**
  * The detailed list of payment methods required to generate payment forms.
  * @return paymentMethods
  **/
    public List<PaymentMethod> getPaymentMethods() {
    return paymentMethods;
  }
  public void setPaymentMethods(List<PaymentMethod> paymentMethods) {
    this.paymentMethods = paymentMethods;
  }
  
  public PaymentSetupResponse paymentSession(String paymentSession) {
    this.paymentSession = paymentSession;
    return this;
  }

  
  /**
  * Base64-encoded version of this response.
  * @return paymentSession
  **/
    public String getPaymentSession() {
    return paymentSession;
  }
  public void setPaymentSession(String paymentSession) {
    this.paymentSession = paymentSession;
  }
  
  public PaymentSetupResponse publicKey(String publicKey) {
    this.publicKey = publicKey;
    return this;
  }

  
  /**
  * The public key required to encrypt sensitive data.
  * @return publicKey
  **/
    public String getPublicKey() {
    return publicKey;
  }
  public void setPublicKey(String publicKey) {
    this.publicKey = publicKey;
  }
  
  public PaymentSetupResponse publicKeyToken(String publicKeyToken) {
    this.publicKeyToken = publicKeyToken;
    return this;
  }

  
  /**
  * The public key token.
  * @return publicKeyToken
  **/
    public String getPublicKeyToken() {
    return publicKeyToken;
  }
  public void setPublicKeyToken(String publicKeyToken) {
    this.publicKeyToken = publicKeyToken;
  }
  
  public PaymentSetupResponse sdkVersion(String sdkVersion) {
    this.sdkVersion = sdkVersion;
    return this;
  }

  
  /**
  * SDK version for the Web SDK. The value will be used for validation on Web SDK.
  * @return sdkVersion
  **/
    public String getSdkVersion() {
    return sdkVersion;
  }
  public void setSdkVersion(String sdkVersion) {
    this.sdkVersion = sdkVersion;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentSetupResponse paymentSetupResponse = (PaymentSetupResponse) o;
    return Objects.equals(this.company, paymentSetupResponse.company) &&
        Objects.equals(this.disableRecurringDetailUrl, paymentSetupResponse.disableRecurringDetailUrl) &&
        Objects.equals(this.generationtime, paymentSetupResponse.generationtime) &&
        Objects.equals(this.html, paymentSetupResponse.html) &&
        Objects.equals(this.initiationUrl, paymentSetupResponse.initiationUrl) &&
        Objects.equals(this.lineItems, paymentSetupResponse.lineItems) &&
        Objects.equals(this.logoBaseUrl, paymentSetupResponse.logoBaseUrl) &&
        Objects.equals(this.oneClickPaymentMethods, paymentSetupResponse.oneClickPaymentMethods) &&
        Objects.equals(this.origin, paymentSetupResponse.origin) &&
        Objects.equals(this.originKey, paymentSetupResponse.originKey) &&
        Objects.equals(this.payment, paymentSetupResponse.payment) &&
        Objects.equals(this.paymentData, paymentSetupResponse.paymentData) &&
        Objects.equals(this.paymentMethods, paymentSetupResponse.paymentMethods) &&
        Objects.equals(this.paymentSession, paymentSetupResponse.paymentSession) &&
        Objects.equals(this.publicKey, paymentSetupResponse.publicKey) &&
        Objects.equals(this.publicKeyToken, paymentSetupResponse.publicKeyToken) &&
        Objects.equals(this.sdkVersion, paymentSetupResponse.sdkVersion);
  }

  @Override
  public int hashCode() {
    return Objects.hash(company, disableRecurringDetailUrl, generationtime, html, initiationUrl, lineItems, logoBaseUrl, oneClickPaymentMethods, origin, originKey, payment, paymentData, paymentMethods, paymentSession, publicKey, publicKeyToken, sdkVersion);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentSetupResponse {\n");

    sb.append("    company: ").append(toIndentedString(company)).append("\n");
    sb.append("    disableRecurringDetailUrl: ").append(toIndentedString(disableRecurringDetailUrl)).append("\n");
    sb.append("    generationtime: ").append(toIndentedString(generationtime)).append("\n");
    sb.append("    html: ").append(toIndentedString(html)).append("\n");
    sb.append("    initiationUrl: ").append(toIndentedString(initiationUrl)).append("\n");
    sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
    sb.append("    logoBaseUrl: ").append(toIndentedString(logoBaseUrl)).append("\n");
    sb.append("    oneClickPaymentMethods: ").append(toIndentedString(oneClickPaymentMethods)).append("\n");
    sb.append("    origin: ").append(toIndentedString(origin)).append("\n");
    sb.append("    originKey: ").append(toIndentedString(originKey)).append("\n");
    sb.append("    payment: ").append(toIndentedString(payment)).append("\n");
    sb.append("    paymentData: ").append(toIndentedString(paymentData)).append("\n");
    sb.append("    paymentMethods: ").append(toIndentedString(paymentMethods)).append("\n");
    sb.append("    paymentSession: ").append(toIndentedString(paymentSession)).append("\n");
    sb.append("    publicKey: ").append(toIndentedString(publicKey)).append("\n");
    sb.append("    publicKeyToken: ").append(toIndentedString(publicKeyToken)).append("\n");
    sb.append("    sdkVersion: ").append(toIndentedString(sdkVersion)).append("\n");
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



