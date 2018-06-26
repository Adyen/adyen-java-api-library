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

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * OriginKeysRequest
 */
public class OriginKeysRequest {

  @SerializedName("originDomains")
  private List<String> originDomains = new ArrayList<String>();
  
  public OriginKeysRequest originDomains(List<String> originDomains) {
    this.originDomains = originDomains;
    return this;
  }

  public OriginKeysRequest addOriginDomainsItem(String originDomainsItem) {
    
    this.originDomains.add(originDomainsItem);
    return this;
  }
  
  /**
  * The list of origin domains, for which origin keys are requested.
  * @return originDomains
  **/
  public List<String> getOriginDomains() {
    return originDomains;
  }
  public void setOriginDomains(List<String> originDomains) {
    this.originDomains = originDomains;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OriginKeysRequest originKeysRequest = (OriginKeysRequest) o;
    return Objects.equals(this.originDomains, originKeysRequest.originDomains);
  }

  @Override
  public int hashCode() {
    return Objects.hash(originDomains);
  }
  
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OriginKeysRequest {\n");
    
    sb.append("    originDomains: ").append(toIndentedString(originDomains)).append("\n");
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



