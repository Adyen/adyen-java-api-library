/**
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Card
 */
public class Card {
  @SerializedName("expiryMonth")
  private String expiryMonth = null;

  @SerializedName("expiryYear")
  private String expiryYear = null;

  @SerializedName("cvc")
  private String cvc = null;

  @SerializedName("holderName")
  private String holderName = null;

  @SerializedName("issueNumber")
  private String issueNumber = null;

  @SerializedName("number")
  private String number = null;

  @SerializedName("startMonth")
  private String startMonth = null;

  @SerializedName("startYear")
  private String startYear = null;

  public Card expiryMonth(String expiryMonth) {
    this.expiryMonth = expiryMonth;
    return this;
  }

   /**
   * the month component of the expiry date (may be left padded with 0 for single digits)
   * @return expiryMonth
  **/
  public String getExpiryMonth() {
    return expiryMonth;
  }

  public void setExpiryMonth(String expiryMonth) {
    this.expiryMonth = expiryMonth;
  }

  public Card expiryYear(String expiryYear) {
    this.expiryYear = expiryYear;
    return this;
  }

   /**
   * the year component of the expiry date
   * @return expiryYear
  **/
  public String getExpiryYear() {
    return expiryYear;
  }

  public void setExpiryYear(String expiryYear) {
    this.expiryYear = expiryYear;
  }

  public Card cvc(String cvc) {
    this.cvc = cvc;
    return this;
  }

   /**
   * the card security code which, depending on card brand, is referred to as CVV2/CVC2 (three digits) or CID (4 digits)
   * @return cvc
  **/
  public String getCvc() {
    return cvc;
  }

  public void setCvc(String cvc) {
    this.cvc = cvc;
  }

  public Card holderName(String holderName) {
    this.holderName = holderName;
    return this;
  }

   /**
   * the cardholder name as printed on the card
   * @return holderName
  **/
  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public Card issueNumber(String issueNumber) {
    this.issueNumber = issueNumber;
    return this;
  }

   /**
   * <i>for some UK debit cards only</i> the issue number of the card
   * @return issueNumber
  **/
  public String getIssueNumber() {
    return issueNumber;
  }

  public void setIssueNumber(String issueNumber) {
    this.issueNumber = issueNumber;
  }

  public Card number(String number) {
    this.number = number;
    return this;
  }

   /**
   * the card number (without separators)
   * @return number
  **/
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Card startMonth(String startMonth) {
    this.startMonth = startMonth;
    return this;
  }

   /**
   * <i>for some UK debit cards only</i> the month component of the start date
   * @return startMonth
  **/
  public String getStartMonth() {
    return startMonth;
  }

  public void setStartMonth(String startMonth) {
    this.startMonth = startMonth;
  }

  public Card startYear(String startYear) {
    this.startYear = startYear;
    return this;
  }

   /**
   * <i>for some UK debit cards only</i> the year component of the start date
   * @return startYear
  **/
  public String getStartYear() {
    return startYear;
  }

  public void setStartYear(String startYear) {
    this.startYear = startYear;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Card card = (Card) o;
    return Objects.equals(this.expiryMonth, card.expiryMonth) &&
        Objects.equals(this.expiryYear, card.expiryYear) &&
        Objects.equals(this.cvc, card.cvc) &&
        Objects.equals(this.holderName, card.holderName) &&
        Objects.equals(this.issueNumber, card.issueNumber) &&
        Objects.equals(this.number, card.number) &&
        Objects.equals(this.startMonth, card.startMonth) &&
        Objects.equals(this.startYear, card.startYear);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expiryMonth, expiryYear, cvc, holderName, issueNumber, number, startMonth, startYear);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Card {\n");

    sb.append("    expiryMonth: ").append(toIndentedString(expiryMonth)).append("\n");
    sb.append("    expiryYear: ").append(toIndentedString(expiryYear)).append("\n");
    sb.append("    cvc: ").append(toIndentedString(cvc)).append("\n");
    sb.append("    holderName: ").append(toIndentedString(holderName)).append("\n");
    sb.append("    issueNumber: ").append(toIndentedString(issueNumber)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    startMonth: ").append(toIndentedString(startMonth)).append("\n");
    sb.append("    startYear: ").append(toIndentedString(startYear)).append("\n");
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

