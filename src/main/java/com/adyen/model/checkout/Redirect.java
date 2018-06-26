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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;


import java.io.IOException;
import java.util.Map;
import java.util.Objects;

/**
 * Redirect
 */
public class Redirect {

  @SerializedName("data")
  private Map<String, String> data = null;
  
  /**
   * The web method that you must use to access the redirect URL.  Possible values: GET, POST.
   */
  @JsonAdapter(MethodEnum.Adapter.class)
  public enum MethodEnum {
    
    GET("GET"),
    POST("POST");

    private String value;

    MethodEnum(String value) {
      this.value = value;
    }
    
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    
    public static MethodEnum fromValue(String text) {
      for (MethodEnum b : MethodEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    
    public static class Adapter extends TypeAdapter<MethodEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final MethodEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public MethodEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return MethodEnum.fromValue(String.valueOf(value));
      }
    }
  }
  
  @SerializedName("method")
  private MethodEnum method = null;
  
  @SerializedName("url")
  private String url = null;
  
  public Redirect data(Map<String, String> data) {
    this.data = data;
    return this;
  }

  public Redirect putDataItem(String key, String dataItem) {
    
    if (this.data == null) {
      this.data = null;
    }
    
    this.data.put(key, dataItem);
    return this;
  }
  /**
  * When the redirect URL must be accessed via POST, use this data to post to the redirect URL.
  * @return data
  **/
    public Map<String, String> getData() {
    return data;
  }
  public void setData(Map<String, String> data) {
    this.data = data;
  }
  
  public Redirect method(MethodEnum method) {
    this.method = method;
    return this;
  }

  
  /**
  * The web method that you must use to access the redirect URL.  Possible values: GET, POST.
  * @return method
  **/
    public MethodEnum getMethod() {
    return method;
  }
  public void setMethod(MethodEnum method) {
    this.method = method;
  }
  
  public Redirect url(String url) {
    this.url = url;
    return this;
  }

  
  /**
  * The URL, to which you must redirect a shopper to complete a payment.
  * @return url
  **/
    public String getUrl() {
    return url;
  }
  public void setUrl(String url) {
    this.url = url;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Redirect redirect = (Redirect) o;
    return Objects.equals(this.data, redirect.data) &&
        Objects.equals(this.method, redirect.method) &&
        Objects.equals(this.url, redirect.url);
  }

  @Override
  public int hashCode() {
    return Objects.hash(data, method, url);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Redirect {\n");

    sb.append("    data: ").append(toIndentedString(data)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    url: ").append(toIndentedString(url)).append("\n");
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



