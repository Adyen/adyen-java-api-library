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
 * ELV
 */
public class ELV {
  @SerializedName("bankName")
  private String bankName = null;

  @SerializedName("bankAccountNumber")
  private String bankAccountNumber = null;

  @SerializedName("bankLocationId")
  private String bankLocationId = null;

  @SerializedName("bankLocation")
  private String bankLocation = null;

  @SerializedName("accountHolderName")
  private String accountHolderName = null;

  public ELV bankName(String bankName) {
    this.bankName = bankName;
    return this;
  }

   /**
   * Get bankName
   * @return bankName
  **/
  public String getBankName() {
    return bankName;
  }

  public void setBankName(String bankName) {
    this.bankName = bankName;
  }

  public ELV bankAccountNumber(String bankAccountNumber) {
    this.bankAccountNumber = bankAccountNumber;
    return this;
  }

   /**
   * Get bankAccountNumber
   * @return bankAccountNumber
  **/
  public String getBankAccountNumber() {
    return bankAccountNumber;
  }

  public void setBankAccountNumber(String bankAccountNumber) {
    this.bankAccountNumber = bankAccountNumber;
  }

  public ELV bankLocationId(String bankLocationId) {
    this.bankLocationId = bankLocationId;
    return this;
  }

   /**
   * Get bankLocationId
   * @return bankLocationId
  **/
  public String getBankLocationId() {
    return bankLocationId;
  }

  public void setBankLocationId(String bankLocationId) {
    this.bankLocationId = bankLocationId;
  }

  public ELV bankLocation(String bankLocation) {
    this.bankLocation = bankLocation;
    return this;
  }

   /**
   * Get bankLocation
   * @return bankLocation
  **/
  public String getBankLocation() {
    return bankLocation;
  }

  public void setBankLocation(String bankLocation) {
    this.bankLocation = bankLocation;
  }

  public ELV accountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
    return this;
  }

   /**
   * Get accountHolderName
   * @return accountHolderName
  **/
  public String getAccountHolderName() {
    return accountHolderName;
  }

  public void setAccountHolderName(String accountHolderName) {
    this.accountHolderName = accountHolderName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ELV ELV = (ELV) o;
    return Objects.equals(this.bankName, ELV.bankName) &&
        Objects.equals(this.bankAccountNumber, ELV.bankAccountNumber) &&
        Objects.equals(this.bankLocationId, ELV.bankLocationId) &&
        Objects.equals(this.bankLocation, ELV.bankLocation) &&
        Objects.equals(this.accountHolderName, ELV.accountHolderName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(bankName, bankAccountNumber, bankLocationId, bankLocation, accountHolderName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ELV {\n");

    sb.append("    bankName: ").append(toIndentedString(bankName)).append("\n");
    sb.append("    bankAccountNumber: ").append(toIndentedString(bankAccountNumber)).append("\n");
    sb.append("    bankLocationId: ").append(toIndentedString(bankLocationId)).append("\n");
    sb.append("    bankLocation: ").append(toIndentedString(bankLocation)).append("\n");
    sb.append("    accountHolderName: ").append(toIndentedString(accountHolderName)).append("\n");
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

