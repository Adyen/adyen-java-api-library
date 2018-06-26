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

import com.adyen.model.Amount;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;


import java.io.IOException;
import java.util.Objects;

/**
 * PaymentMethodsRequest
 */
public class PaymentMethodsRequest {

  @SerializedName("amount")
  private Amount amount = null;
  
  /**
   * The platform where a payment transaction takes place. This field can be used for filtering out payment methods that are only available on specific platforms. Possible values: * iOS * Android * Web
   */
  @JsonAdapter(ChannelEnum.Adapter.class)
  public enum ChannelEnum {
    
    IOS("iOS"),
    ANDROID("Android"),
    WEB("Web");

    private String value;

    ChannelEnum(String value) {
      this.value = value;
    }
    
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    
    public static ChannelEnum fromValue(String text) {
      for (ChannelEnum b : ChannelEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    
    public static class Adapter extends TypeAdapter<ChannelEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final ChannelEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public ChannelEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return ChannelEnum.fromValue(String.valueOf(value));
      }
    }
  }
  
  @SerializedName("channel")
  private ChannelEnum channel = null;
  
  @SerializedName("countryCode")
  private String countryCode = null;
  
  @SerializedName("merchantAccount")
  private String merchantAccount = null;
  
  @SerializedName("shopperLocale")
  private String shopperLocale = null;
  
  @SerializedName("shopperReference")
  private String shopperReference = null;
  
  public PaymentMethodsRequest amount(Amount amount) {
    this.amount = amount;
    return this;
  }

  
  /**
  * Get amount
  * @return amount
  **/
  public Amount getAmount() {
    return amount;
  }
  public void setAmount(Amount amount) {
    this.amount = amount;
  }
  
  public PaymentMethodsRequest channel(ChannelEnum channel) {
    this.channel = channel;
    return this;
  }

  
  /**
  * The platform where a payment transaction takes place. This field can be used for filtering out payment methods that are only available on specific platforms. Possible values: * iOS * Android * Web
  * @return channel
  **/
  public ChannelEnum getChannel() {
    return channel;
  }
  public void setChannel(ChannelEnum channel) {
    this.channel = channel;
  }
  
  public PaymentMethodsRequest countryCode(String countryCode) {
    this.countryCode = countryCode;
    return this;
  }

  
  /**
  * The shopper&#x27;s country code.
  * @return countryCode
  **/
  public String getCountryCode() {
    return countryCode;
  }
  public void setCountryCode(String countryCode) {
    this.countryCode = countryCode;
  }
  
  public PaymentMethodsRequest merchantAccount(String merchantAccount) {
    this.merchantAccount = merchantAccount;
    return this;
  }

  
  /**
  * The merchant account identifier, with which you want to process the transaction.
  * @return merchantAccount
  **/
  public String getMerchantAccount() {
    return merchantAccount;
  }
  public void setMerchantAccount(String merchantAccount) {
    this.merchantAccount = merchantAccount;
  }
  
  public PaymentMethodsRequest shopperLocale(String shopperLocale) {
    this.shopperLocale = shopperLocale;
    return this;
  }

  
  /**
  * The combination of a language code and a country code to specify the language to be used in the payment.
  * @return shopperLocale
  **/
  public String getShopperLocale() {
    return shopperLocale;
  }
  public void setShopperLocale(String shopperLocale) {
    this.shopperLocale = shopperLocale;
  }
  
  public PaymentMethodsRequest shopperReference(String shopperReference) {
    this.shopperReference = shopperReference;
    return this;
  }

  
  /**
  * The shopper&#x27;s reference to uniquely identify this shopper (e.g. user ID or account ID). &gt; This field is required for recurring payments.
  * @return shopperReference
  **/
  public String getShopperReference() {
    return shopperReference;
  }
  public void setShopperReference(String shopperReference) {
    this.shopperReference = shopperReference;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentMethodsRequest paymentMethodsRequest = (PaymentMethodsRequest) o;
    return Objects.equals(this.amount, paymentMethodsRequest.amount) &&
        Objects.equals(this.channel, paymentMethodsRequest.channel) &&
        Objects.equals(this.countryCode, paymentMethodsRequest.countryCode) &&
        Objects.equals(this.merchantAccount, paymentMethodsRequest.merchantAccount) &&
        Objects.equals(this.shopperLocale, paymentMethodsRequest.shopperLocale) &&
        Objects.equals(this.shopperReference, paymentMethodsRequest.shopperReference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, channel, countryCode, merchantAccount, shopperLocale, shopperReference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentMethodsRequest {\n");

    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    channel: ").append(toIndentedString(channel)).append("\n");
    sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
    sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
    sb.append("    shopperLocale: ").append(toIndentedString(shopperLocale)).append("\n");
    sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
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



