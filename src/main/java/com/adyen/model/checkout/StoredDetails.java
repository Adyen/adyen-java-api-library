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

import com.adyen.model.BankAccount;
import com.adyen.model.Card;
import com.google.gson.annotations.SerializedName;


import java.util.Objects;

/**
 * StoredDetails
 */
public class StoredDetails {

  @SerializedName("bank")
  private BankAccount bank = null;
  
  @SerializedName("card")
  private Card card = null;
  
  @SerializedName("emailAddress")
  private String emailAddress = null;
  
  public StoredDetails bank(BankAccount bank) {
    this.bank = bank;
    return this;
  }

  
  /**
  * Get bank
  * @return bank
  **/
    public BankAccount getBank() {
    return bank;
  }
  public void setBank(BankAccount bank) {
    this.bank = bank;
  }
  
  public StoredDetails card(Card card) {
    this.card = card;
    return this;
  }

  
  /**
  * Get card
  * @return card
  **/
    public Card getCard() {
    return card;
  }
  public void setCard(Card card) {
    this.card = card;
  }
  
  public StoredDetails emailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
    return this;
  }

  
  /**
  * The email associated with stored payment details.
  * @return emailAddress
  **/
    public String getEmailAddress() {
    return emailAddress;
  }
  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
  
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StoredDetails storedDetails = (StoredDetails) o;
    return Objects.equals(this.bank, storedDetails.bank) &&
        Objects.equals(this.card, storedDetails.card) &&
        Objects.equals(this.emailAddress, storedDetails.emailAddress);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bank, card, emailAddress);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StoredDetails {\n");

    sb.append("    bank: ").append(toIndentedString(bank)).append("\n");
    sb.append("    card: ").append(toIndentedString(card)).append("\n");
    sb.append("    emailAddress: ").append(toIndentedString(emailAddress)).append("\n");
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



