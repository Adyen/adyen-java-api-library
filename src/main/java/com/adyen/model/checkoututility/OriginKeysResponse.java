/*
 * Adyen Checkout Utility Service
 * A web service containing utility functions available for merchants integrating with Checkout APIs. ## Authentication Each request to the Checkout Utility API must be signed with an API key. For this, obtain an API Key from your Customer Area, as described in [How to get the Checkout API key](https://docs.adyen.com/developers/user-management/how-to-get-the-checkout-api-key). Then set this key to the `X-API-Key` header value, for example:  ``` curl -H \"Content-Type: application/json\" \\ -H \"X-API-Key: Your_Checkout_API_key\" \\ ... ``` Note that when going live, you need to generate a new API Key to access the [live endpoints](https://docs.adyen.com/developers/api-reference/live-endpoints).  ## Versioning Checkout API supports versioning of its endpoints through a version suffix in the endpoint URL. This suffix has the following format: \"vXX\", where XX is the version number.  For example: ``` https://checkout-test.adyen.com/v1/originKeys ```
 *
 * OpenAPI spec version: 1
 * Contact: support@adyen.com
 *
 * Do not edit the class manually.
 */


package com.adyen.model.checkoututility;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import java.util.Map;

/**
 * OriginKeysResponse
 */
public class OriginKeysResponse {

  @SerializedName("originKeys")
  private Map<String, String> originKeys = null;
  
  public OriginKeysResponse originKeys(Map<String, String> originKeys) {
    this.originKeys = originKeys;
    return this;
  }

  public OriginKeysResponse putOriginKeysItem(String key, String originKeysItem) {
    
    if (this.originKeys == null) {
      this.originKeys = null;
    }
    
    this.originKeys.put(key, originKeysItem);
    return this;
  }
  /**
  * The list of origin keys for all requested domains. For each list item, the key is the domain and the value is the origin key.
  * @return originKeys
  **/
  public Map<String, String> getOriginKeys() {
    return originKeys;
  }
  public void setOriginKeys(Map<String, String> originKeys) {
    this.originKeys = originKeys;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OriginKeysResponse originKeysResponse = (OriginKeysResponse) o;
    return Objects.equals(this.originKeys, originKeysResponse.originKeys);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originKeys);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OriginKeysResponse {\n");
    
    sb.append("    originKeys: ").append(toIndentedString(originKeys)).append("\n");
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



