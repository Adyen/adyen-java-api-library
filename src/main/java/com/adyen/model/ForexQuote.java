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

import java.util.Date;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * ForexQuote
 */
public class ForexQuote {
  @SerializedName("reference")
  private String reference = null;

  @SerializedName("interbank")
  private Amount interbank = null;

  @SerializedName("sell")
  private Amount sell = null;

  @SerializedName("buy")
  private Amount buy = null;

  @SerializedName("validTill")
  private Date validTill = null;

  @SerializedName("basePoints")
  private Integer basePoints = null;

  @SerializedName("source")
  private String source = null;

  @SerializedName("signature")
  private String signature = null;

  @SerializedName("type")
  private String type = null;

  @SerializedName("baseAmount")
  private Amount baseAmount = null;

  @SerializedName("account")
  private String account = null;

  @SerializedName("accountType")
  private String accountType = null;

  public ForexQuote reference(String reference) {
    this.reference = reference;
    return this;
  }

   /**
   * the reference assigned to the forex quote request
   * @return reference
  **/
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public ForexQuote interbank(Amount interbank) {
    this.interbank = interbank;
    return this;
  }

   /**
   * Get interbank
   * @return interbank
  **/
  public Amount getInterbank() {
    return interbank;
  }

  public void setInterbank(Amount interbank) {
    this.interbank = interbank;
  }

  public ForexQuote sell(Amount sell) {
    this.sell = sell;
    return this;
  }

   /**
   * the sell rate
   * @return sell
  **/
  public Amount getSell() {
    return sell;
  }

  public void setSell(Amount sell) {
    this.sell = sell;
  }

  public ForexQuote buy(Amount buy) {
    this.buy = buy;
    return this;
  }

   /**
   * the buy rate
   * @return buy
  **/
  public Amount getBuy() {
    return buy;
  }

  public void setBuy(Amount buy) {
    this.buy = buy;
  }

  public ForexQuote validTill(Date validTill) {
    this.validTill = validTill;
    return this;
  }

   /**
   * Get validTill
   * @return validTill
  **/
  public Date getValidTill() {
    return validTill;
  }

  public void setValidTill(Date validTill) {
    this.validTill = validTill;
  }

  public ForexQuote basePoints(Integer basePoints) {
    this.basePoints = basePoints;
    return this;
  }

   /**
   * Get basePoints
   * @return basePoints
  **/
  public Integer getBasePoints() {
    return basePoints;
  }

  public void setBasePoints(Integer basePoints) {
    this.basePoints = basePoints;
  }

  public ForexQuote source(String source) {
    this.source = source;
    return this;
  }

   /**
   * the source of the forex quote
   * @return source
  **/
  public String getSource() {
    return source;
  }

  public void setSource(String source) {
    this.source = source;
  }

  public ForexQuote signature(String signature) {
    this.signature = signature;
    return this;
  }

   /**
   * the signature to validate the integrity
   * @return signature
  **/
  public String getSignature() {
    return signature;
  }

  public void setSignature(String signature) {
    this.signature = signature;
  }

  public ForexQuote type(String type) {
    this.type = type;
    return this;
  }

   /**
   * the type of forex
   * @return type
  **/
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public ForexQuote baseAmount(Amount baseAmount) {
    this.baseAmount = baseAmount;
    return this;
  }

   /**
   * the base amount
   * @return baseAmount
  **/
  public Amount getBaseAmount() {
    return baseAmount;
  }

  public void setBaseAmount(Amount baseAmount) {
    this.baseAmount = baseAmount;
  }

  public ForexQuote account(String account) {
    this.account = account;
    return this;
  }

   /**
   * the account name
   * @return account
  **/
  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public ForexQuote accountType(String accountType) {
    this.accountType = accountType;
    return this;
  }

   /**
   * the account type
   * @return accountType
  **/
  public String getAccountType() {
    return accountType;
  }

  public void setAccountType(String accountType) {
    this.accountType = accountType;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ForexQuote forexQuote = (ForexQuote) o;
    return Objects.equals(this.reference, forexQuote.reference) &&
        Objects.equals(this.interbank, forexQuote.interbank) &&
        Objects.equals(this.sell, forexQuote.sell) &&
        Objects.equals(this.buy, forexQuote.buy) &&
        Objects.equals(this.validTill, forexQuote.validTill) &&
        Objects.equals(this.basePoints, forexQuote.basePoints) &&
        Objects.equals(this.source, forexQuote.source) &&
        Objects.equals(this.signature, forexQuote.signature) &&
        Objects.equals(this.type, forexQuote.type) &&
        Objects.equals(this.baseAmount, forexQuote.baseAmount) &&
        Objects.equals(this.account, forexQuote.account) &&
        Objects.equals(this.accountType, forexQuote.accountType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(reference, interbank, sell, buy, validTill, basePoints, source, signature, type, baseAmount, account, accountType);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ForexQuote {\n");

    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    interbank: ").append(toIndentedString(interbank)).append("\n");
    sb.append("    sell: ").append(toIndentedString(sell)).append("\n");
    sb.append("    buy: ").append(toIndentedString(buy)).append("\n");
    sb.append("    validTill: ").append(toIndentedString(validTill)).append("\n");
    sb.append("    basePoints: ").append(toIndentedString(basePoints)).append("\n");
    sb.append("    source: ").append(toIndentedString(source)).append("\n");
    sb.append("    signature: ").append(toIndentedString(signature)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    baseAmount: ").append(toIndentedString(baseAmount)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
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

