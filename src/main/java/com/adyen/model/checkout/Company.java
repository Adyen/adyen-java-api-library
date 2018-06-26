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


import java.util.Objects;

/**
 * Company
 */
public class Company {

  @SerializedName("homepage")
  private String homepage = null;
  
  @SerializedName("name")
  private String name = null;
  
  @SerializedName("registrationNumber")
  private String registrationNumber = null;
  
  @SerializedName("registryLocation")
  private String registryLocation = null;
  
  @SerializedName("taxId")
  private String taxId = null;
  
  @SerializedName("type")
  private String type = null;
  
  public Company homepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  
  /**
  * The company website&#x27;s home page.
  * @return homepage
  **/
    public String getHomepage() {
    return homepage;
  }
  public void setHomepage(String homepage) {
    this.homepage = homepage;
  }
  
  public Company name(String name) {
    this.name = name;
    return this;
  }

  
  /**
  * The company name.
  * @return name
  **/
    public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  
  public Company registrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
    return this;
  }

  
  /**
  * Registration number of the company.
  * @return registrationNumber
  **/
    public String getRegistrationNumber() {
    return registrationNumber;
  }
  public void setRegistrationNumber(String registrationNumber) {
    this.registrationNumber = registrationNumber;
  }
  
  public Company registryLocation(String registryLocation) {
    this.registryLocation = registryLocation;
    return this;
  }

  
  /**
  * Registry location of the company.
  * @return registryLocation
  **/
    public String getRegistryLocation() {
    return registryLocation;
  }
  public void setRegistryLocation(String registryLocation) {
    this.registryLocation = registryLocation;
  }
  
  public Company taxId(String taxId) {
    this.taxId = taxId;
    return this;
  }

  
  /**
  * Tax ID of the company.
  * @return taxId
  **/
    public String getTaxId() {
    return taxId;
  }
  public void setTaxId(String taxId) {
    this.taxId = taxId;
  }
  
  public Company type(String type) {
    this.type = type;
    return this;
  }

  
  /**
  * The company type.
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
    Company company = (Company) o;
    return Objects.equals(this.homepage, company.homepage) &&
        Objects.equals(this.name, company.name) &&
        Objects.equals(this.registrationNumber, company.registrationNumber) &&
        Objects.equals(this.registryLocation, company.registryLocation) &&
        Objects.equals(this.taxId, company.taxId) &&
        Objects.equals(this.type, company.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(homepage, name, registrationNumber, registryLocation, taxId, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Company {\n");

    sb.append("    homepage: ").append(toIndentedString(homepage)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    registrationNumber: ").append(toIndentedString(registrationNumber)).append("\n");
    sb.append("    registryLocation: ").append(toIndentedString(registryLocation)).append("\n");
    sb.append("    taxId: ").append(toIndentedString(taxId)).append("\n");
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



