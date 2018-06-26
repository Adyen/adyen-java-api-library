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
import java.util.Objects;

/**
 * Avs
 */
public class Avs {

  @SerializedName("addressEditable")
  private Boolean addressEditable = null;
  
  /**
   * Specifies whether the shopper should enter their billing address during checkout.  Allowed values: * yes — Perform AVS checks for every card payment. * automatic — Perform AVS checks only when required to optimize the conversion rate. * no — Do not perform AVS checks.
   */
  @JsonAdapter(EnabledEnum.Adapter.class)
  public enum EnabledEnum {
    
    YES("yes"),
    NO("no"),
    AUTOMATIC("automatic");

    private String value;

    EnabledEnum(String value) {
      this.value = value;
    }
    
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
    
    public static EnabledEnum fromValue(String text) {
      for (EnabledEnum b : EnabledEnum.values()) {
        if (String.valueOf(b.value).equals(text)) {
          return b;
        }
      }
      return null;
    }
    
    public static class Adapter extends TypeAdapter<EnabledEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final EnabledEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public EnabledEnum read(final JsonReader jsonReader) throws IOException {
        String value = jsonReader.nextString();
        return EnabledEnum.fromValue(String.valueOf(value));
      }
    }
  }
  
  @SerializedName("enabled")
  private EnabledEnum enabled = null;
  
  public Avs addressEditable(Boolean addressEditable) {
    this.addressEditable = addressEditable;
    return this;
  }

  
  /**
  * Indicates whether the shopper is allowed to modify the billing address for the current payment request.
  * @return addressEditable
  **/
 public Boolean isAddressEditable() {
    return addressEditable;
  }
  public void setAddressEditable(Boolean addressEditable) {
    this.addressEditable = addressEditable;
  }
  
  public Avs enabled(EnabledEnum enabled) {
    this.enabled = enabled;
    return this;
  }

  
  /**
  * Specifies whether the shopper should enter their billing address during checkout.  Allowed values: * yes — Perform AVS checks for every card payment. * automatic — Perform AVS checks only when required to optimize the conversion rate. * no — Do not perform AVS checks.
  * @return enabled
  **/
  public EnabledEnum getEnabled() {
    return enabled;
  }
  public void setEnabled(EnabledEnum enabled) {
    this.enabled = enabled;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Avs avs = (Avs) o;
    return Objects.equals(this.addressEditable, avs.addressEditable) &&
        Objects.equals(this.enabled, avs.enabled);
  }

  @Override
  public int hashCode() {
    return Objects.hash(addressEditable, enabled);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Avs {\n");

    sb.append("    addressEditable: ").append(toIndentedString(addressEditable)).append("\n");
    sb.append("    enabled: ").append(toIndentedString(enabled)).append("\n");
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



