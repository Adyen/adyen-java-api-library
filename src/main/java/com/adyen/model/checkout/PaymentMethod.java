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
import java.util.Map;
import java.util.Objects;

/**
 * PaymentMethod
 */
public class PaymentMethod {

  @SerializedName("configuration")
  private Map<String, String> _configuration = null;
  
  @SerializedName("details")
  private List<InputDetail> details = null;
  
  @SerializedName("group")
  private PaymentMethodGroup group = null;
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("paymentMethodData")
  private String paymentMethodData = null;
  
  @SerializedName("type")
  private String type = null;
  
  public PaymentMethod _configuration(Map<String, String> _configuration) {
    this._configuration = _configuration;
    return this;
  }

  public PaymentMethod putConfigurationItem(String key, String _configurationItem) {
    
    if (this._configuration == null) {
      this._configuration = null;
    }
    
    this._configuration.put(key, _configurationItem);
    return this;
  }
  /**
  * The configuration of the payment method.
  * @return _configuration
  **/
  public Map<String, String> getConfiguration() {
    return _configuration;
  }
  public void setConfiguration(Map<String, String> _configuration) {
    this._configuration = _configuration;
  }
  
  public PaymentMethod details(List<InputDetail> details) {
    this.details = details;
    return this;
  }

  public PaymentMethod addDetailsItem(InputDetail detailsItem) {
    
    if (this.details == null) {
      this.details = new ArrayList<InputDetail>();
    }
    
    this.details.add(detailsItem);
    return this;
  }
  
  /**
  * All input details to be provided to complete the payment with this payment method.
  * @return details
  **/
  public List<InputDetail> getDetails() {
    return details;
  }
  public void setDetails(List<InputDetail> details) {
    this.details = details;
  }
  
  public PaymentMethod group(PaymentMethodGroup group) {
    this.group = group;
    return this;
  }

  
  /**
  * Get group
  * @return group
  **/
  public PaymentMethodGroup getGroup() {
    return group;
  }
  public void setGroup(PaymentMethodGroup group) {
    this.group = group;
  }
  
  public PaymentMethod name(String name) {
    this.name = name;
    return this;
  }

  
  /**
  * The displayable name of this payment method.
  * @return name
  **/
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public PaymentMethod paymentMethodData(String paymentMethodData) {
    this.paymentMethodData = paymentMethodData;
    return this;
  }

  
  /**
  * Echo data required to send in next calls.
  * @return paymentMethodData
  **/
  public String getPaymentMethodData() {
    return paymentMethodData;
  }
  public void setPaymentMethodData(String paymentMethodData) {
    this.paymentMethodData = paymentMethodData;
  }
  
  public PaymentMethod type(String type) {
    this.type = type;
    return this;
  }

  
  /**
  * The unique payment method code.
  * @return type
  **/
  public String getType() {
    return type;
  }
  public void setType(String type) {
    this.type = type;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentMethod paymentMethod = (PaymentMethod) o;
    return Objects.equals(this._configuration, paymentMethod._configuration) &&
        Objects.equals(this.details, paymentMethod.details) &&
        Objects.equals(this.group, paymentMethod.group) &&
        Objects.equals(this.name, paymentMethod.name) &&
        Objects.equals(this.paymentMethodData, paymentMethod.paymentMethodData) &&
        Objects.equals(this.type, paymentMethod.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(_configuration, details, group, name, paymentMethodData, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentMethod {\n");

    sb.append("    _configuration: ").append(toIndentedString(_configuration)).append("\n");
    sb.append("    details: ").append(toIndentedString(details)).append("\n");
    sb.append("    group: ").append(toIndentedString(group)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    paymentMethodData: ").append(toIndentedString(paymentMethodData)).append("\n");
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

  
}



