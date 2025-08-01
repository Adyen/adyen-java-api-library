/*
 * Configuration API
 *
 * The version of the OpenAPI document: 2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.balanceplatform;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** BankAccountDetails */
@JsonPropertyOrder({
  BankAccountDetails.JSON_PROPERTY_ACCOUNT_NUMBER,
  BankAccountDetails.JSON_PROPERTY_ACCOUNT_TYPE,
  BankAccountDetails.JSON_PROPERTY_BRANCH_NUMBER,
  BankAccountDetails.JSON_PROPERTY_FORM_FACTOR,
  BankAccountDetails.JSON_PROPERTY_IBAN,
  BankAccountDetails.JSON_PROPERTY_ROUTING_NUMBER,
  BankAccountDetails.JSON_PROPERTY_SORT_CODE,
  BankAccountDetails.JSON_PROPERTY_TYPE
})
public class BankAccountDetails {
  public static final String JSON_PROPERTY_ACCOUNT_NUMBER = "accountNumber";
  private String accountNumber;

  public static final String JSON_PROPERTY_ACCOUNT_TYPE = "accountType";
  private String accountType;

  public static final String JSON_PROPERTY_BRANCH_NUMBER = "branchNumber";
  private String branchNumber;

  public static final String JSON_PROPERTY_FORM_FACTOR = "formFactor";
  private String formFactor;

  public static final String JSON_PROPERTY_IBAN = "iban";
  private String iban;

  public static final String JSON_PROPERTY_ROUTING_NUMBER = "routingNumber";
  private String routingNumber;

  public static final String JSON_PROPERTY_SORT_CODE = "sortCode";
  private String sortCode;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;

  public BankAccountDetails() {}

  /**
   * The bank account number, without separators or whitespace.
   *
   * @param accountNumber The bank account number, without separators or whitespace.
   * @return the current {@code BankAccountDetails} instance, allowing for method chaining
   */
  public BankAccountDetails accountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
    return this;
  }

  /**
   * The bank account number, without separators or whitespace.
   *
   * @return accountNumber The bank account number, without separators or whitespace.
   */
  @JsonProperty(JSON_PROPERTY_ACCOUNT_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAccountNumber() {
    return accountNumber;
  }

  /**
   * The bank account number, without separators or whitespace.
   *
   * @param accountNumber The bank account number, without separators or whitespace.
   */
  @JsonProperty(JSON_PROPERTY_ACCOUNT_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  /**
   * The bank account type. Possible values: **checking** or **savings**. Defaults to **checking**.
   *
   * @param accountType The bank account type. Possible values: **checking** or **savings**.
   *     Defaults to **checking**.
   * @return the current {@code BankAccountDetails} instance, allowing for method chaining
   */
  public BankAccountDetails accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * The bank account type. Possible values: **checking** or **savings**. Defaults to **checking**.
   *
   * @return accountType The bank account type. Possible values: **checking** or **savings**.
   *     Defaults to **checking**.
   */
  @JsonProperty(JSON_PROPERTY_ACCOUNT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAccountType() {
    return accountType;
  }

  /**
   * The bank account type. Possible values: **checking** or **savings**. Defaults to **checking**.
   *
   * @param accountType The bank account type. Possible values: **checking** or **savings**.
   *     Defaults to **checking**.
   */
  @JsonProperty(JSON_PROPERTY_ACCOUNT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }

  /**
   * The bank account branch number, without separators or whitespace
   *
   * @param branchNumber The bank account branch number, without separators or whitespace
   * @return the current {@code BankAccountDetails} instance, allowing for method chaining
   */
  public BankAccountDetails branchNumber(String branchNumber) {
    this.branchNumber = branchNumber;
    return this;
  }

  /**
   * The bank account branch number, without separators or whitespace
   *
   * @return branchNumber The bank account branch number, without separators or whitespace
   */
  @JsonProperty(JSON_PROPERTY_BRANCH_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getBranchNumber() {
    return branchNumber;
  }

  /**
   * The bank account branch number, without separators or whitespace
   *
   * @param branchNumber The bank account branch number, without separators or whitespace
   */
  @JsonProperty(JSON_PROPERTY_BRANCH_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setBranchNumber(String branchNumber) {
    this.branchNumber = branchNumber;
  }

  /**
   * Business accounts with a &#x60;formFactor&#x60; value of **physical** are business accounts
   * issued under the central bank of that country. The default value is **physical** for NL, US,
   * and UK business accounts. Adyen creates a local IBAN for business accounts when the
   * &#x60;formFactor&#x60; value is set to **virtual**. The local IBANs that are supported are for
   * DE and FR, which reference a physical NL account, with funds being routed through the central
   * bank of NL.
   *
   * @param formFactor Business accounts with a &#x60;formFactor&#x60; value of **physical** are
   *     business accounts issued under the central bank of that country. The default value is
   *     **physical** for NL, US, and UK business accounts. Adyen creates a local IBAN for business
   *     accounts when the &#x60;formFactor&#x60; value is set to **virtual**. The local IBANs that
   *     are supported are for DE and FR, which reference a physical NL account, with funds being
   *     routed through the central bank of NL.
   * @return the current {@code BankAccountDetails} instance, allowing for method chaining
   */
  public BankAccountDetails formFactor(String formFactor) {
    this.formFactor = formFactor;
    return this;
  }

  /**
   * Business accounts with a &#x60;formFactor&#x60; value of **physical** are business accounts
   * issued under the central bank of that country. The default value is **physical** for NL, US,
   * and UK business accounts. Adyen creates a local IBAN for business accounts when the
   * &#x60;formFactor&#x60; value is set to **virtual**. The local IBANs that are supported are for
   * DE and FR, which reference a physical NL account, with funds being routed through the central
   * bank of NL.
   *
   * @return formFactor Business accounts with a &#x60;formFactor&#x60; value of **physical** are
   *     business accounts issued under the central bank of that country. The default value is
   *     **physical** for NL, US, and UK business accounts. Adyen creates a local IBAN for business
   *     accounts when the &#x60;formFactor&#x60; value is set to **virtual**. The local IBANs that
   *     are supported are for DE and FR, which reference a physical NL account, with funds being
   *     routed through the central bank of NL.
   */
  @JsonProperty(JSON_PROPERTY_FORM_FACTOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getFormFactor() {
    return formFactor;
  }

  /**
   * Business accounts with a &#x60;formFactor&#x60; value of **physical** are business accounts
   * issued under the central bank of that country. The default value is **physical** for NL, US,
   * and UK business accounts. Adyen creates a local IBAN for business accounts when the
   * &#x60;formFactor&#x60; value is set to **virtual**. The local IBANs that are supported are for
   * DE and FR, which reference a physical NL account, with funds being routed through the central
   * bank of NL.
   *
   * @param formFactor Business accounts with a &#x60;formFactor&#x60; value of **physical** are
   *     business accounts issued under the central bank of that country. The default value is
   *     **physical** for NL, US, and UK business accounts. Adyen creates a local IBAN for business
   *     accounts when the &#x60;formFactor&#x60; value is set to **virtual**. The local IBANs that
   *     are supported are for DE and FR, which reference a physical NL account, with funds being
   *     routed through the central bank of NL.
   */
  @JsonProperty(JSON_PROPERTY_FORM_FACTOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFormFactor(String formFactor) {
    this.formFactor = formFactor;
  }

  /**
   * The international bank account number as defined in the
   * [ISO-13616](https://www.iso.org/standard/81090.html) standard.
   *
   * @param iban The international bank account number as defined in the
   *     [ISO-13616](https://www.iso.org/standard/81090.html) standard.
   * @return the current {@code BankAccountDetails} instance, allowing for method chaining
   */
  public BankAccountDetails iban(String iban) {
    this.iban = iban;
    return this;
  }

  /**
   * The international bank account number as defined in the
   * [ISO-13616](https://www.iso.org/standard/81090.html) standard.
   *
   * @return iban The international bank account number as defined in the
   *     [ISO-13616](https://www.iso.org/standard/81090.html) standard.
   */
  @JsonProperty(JSON_PROPERTY_IBAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getIban() {
    return iban;
  }

  /**
   * The international bank account number as defined in the
   * [ISO-13616](https://www.iso.org/standard/81090.html) standard.
   *
   * @param iban The international bank account number as defined in the
   *     [ISO-13616](https://www.iso.org/standard/81090.html) standard.
   */
  @JsonProperty(JSON_PROPERTY_IBAN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setIban(String iban) {
    this.iban = iban;
  }

  /**
   * The [routing number](https://en.wikipedia.org/wiki/ABA_routing_transit_number), without
   * separators or whitespace.
   *
   * @param routingNumber The [routing
   *     number](https://en.wikipedia.org/wiki/ABA_routing_transit_number), without separators or
   *     whitespace.
   * @return the current {@code BankAccountDetails} instance, allowing for method chaining
   */
  public BankAccountDetails routingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
    return this;
  }

  /**
   * The [routing number](https://en.wikipedia.org/wiki/ABA_routing_transit_number), without
   * separators or whitespace.
   *
   * @return routingNumber The [routing
   *     number](https://en.wikipedia.org/wiki/ABA_routing_transit_number), without separators or
   *     whitespace.
   */
  @JsonProperty(JSON_PROPERTY_ROUTING_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRoutingNumber() {
    return routingNumber;
  }

  /**
   * The [routing number](https://en.wikipedia.org/wiki/ABA_routing_transit_number), without
   * separators or whitespace.
   *
   * @param routingNumber The [routing
   *     number](https://en.wikipedia.org/wiki/ABA_routing_transit_number), without separators or
   *     whitespace.
   */
  @JsonProperty(JSON_PROPERTY_ROUTING_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRoutingNumber(String routingNumber) {
    this.routingNumber = routingNumber;
  }

  /**
   * The [sort code](https://en.wikipedia.org/wiki/Sort_code), without separators or whitespace.
   *
   * @param sortCode The [sort code](https://en.wikipedia.org/wiki/Sort_code), without separators or
   *     whitespace.
   * @return the current {@code BankAccountDetails} instance, allowing for method chaining
   */
  public BankAccountDetails sortCode(String sortCode) {
    this.sortCode = sortCode;
    return this;
  }

  /**
   * The [sort code](https://en.wikipedia.org/wiki/Sort_code), without separators or whitespace.
   *
   * @return sortCode The [sort code](https://en.wikipedia.org/wiki/Sort_code), without separators
   *     or whitespace.
   */
  @JsonProperty(JSON_PROPERTY_SORT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getSortCode() {
    return sortCode;
  }

  /**
   * The [sort code](https://en.wikipedia.org/wiki/Sort_code), without separators or whitespace.
   *
   * @param sortCode The [sort code](https://en.wikipedia.org/wiki/Sort_code), without separators or
   *     whitespace.
   */
  @JsonProperty(JSON_PROPERTY_SORT_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSortCode(String sortCode) {
    this.sortCode = sortCode;
  }

  /**
   * **iban** or **usLocal** or **ukLocal**
   *
   * @param type **iban** or **usLocal** or **ukLocal**
   * @return the current {@code BankAccountDetails} instance, allowing for method chaining
   */
  public BankAccountDetails type(String type) {
    this.type = type;
    return this;
  }

  /**
   * **iban** or **usLocal** or **ukLocal**
   *
   * @return type **iban** or **usLocal** or **ukLocal**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getType() {
    return type;
  }

  /**
   * **iban** or **usLocal** or **ukLocal**
   *
   * @param type **iban** or **usLocal** or **ukLocal**
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
  }

  /** Return true if this BankAccountDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BankAccountDetails bankAccountDetails = (BankAccountDetails) o;
    return Objects.equals(this.accountNumber, bankAccountDetails.accountNumber)
        && Objects.equals(this.accountType, bankAccountDetails.accountType)
        && Objects.equals(this.branchNumber, bankAccountDetails.branchNumber)
        && Objects.equals(this.formFactor, bankAccountDetails.formFactor)
        && Objects.equals(this.iban, bankAccountDetails.iban)
        && Objects.equals(this.routingNumber, bankAccountDetails.routingNumber)
        && Objects.equals(this.sortCode, bankAccountDetails.sortCode)
        && Objects.equals(this.type, bankAccountDetails.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        accountNumber, accountType, branchNumber, formFactor, iban, routingNumber, sortCode, type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BankAccountDetails {\n");
    sb.append("    accountNumber: ").append(toIndentedString(accountNumber)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    branchNumber: ").append(toIndentedString(branchNumber)).append("\n");
    sb.append("    formFactor: ").append(toIndentedString(formFactor)).append("\n");
    sb.append("    iban: ").append(toIndentedString(iban)).append("\n");
    sb.append("    routingNumber: ").append(toIndentedString(routingNumber)).append("\n");
    sb.append("    sortCode: ").append(toIndentedString(sortCode)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Create an instance of BankAccountDetails given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of BankAccountDetails
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     BankAccountDetails
   */
  public static BankAccountDetails fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, BankAccountDetails.class);
  }

  /**
   * Convert an instance of BankAccountDetails to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
