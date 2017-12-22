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
package com.adyen.model.recurring;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * Recurring
 */
public class Recurring {
  /**
   * how the recurring detail will be used, multiple values allowed as comma separated
   */
  public enum ContractEnum {
    @SerializedName("ONECLICK")
    ONECLICK("ONECLICK"),

    @SerializedName("ONECLICK,RECURRING")
    ONECLICK_RECURRING("ONECLICK,RECURRING"),
    
    @SerializedName("RECURRING")
    RECURRING("RECURRING"),
    
    @SerializedName("PAYOUT")
    PAYOUT("PAYOUT"),

    @SerializedName("ONECLICK,RECURRING,PAYOUT")
    ONECLICK_RECURRING_PAYOUT("ONECLICK,RECURRING,PAYOUT"),

    @SerializedName("ONECLICK,PAYOUT")
    ONECLICK_PAYOUT("ONECLICK,PAYOUT"),

    @SerializedName("RECURRING,PAYOUT")
    RECURRING_PAYOUT("RECURRING,PAYOUT");

    private String value;

    ContractEnum(String value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }
  }

  @SerializedName("contract")
  private ContractEnum contract = null;

  @SerializedName("recurringDetailName")
  private String recurringDetailName = null;

  public Recurring contract(ContractEnum contract) {
    this.contract = contract;
    return this;
  }

   /**
   * how the recurring detail will be used, multiple values allowed as comma separated
   * @return contract
  **/
  public ContractEnum getContract() {
    return contract;
  }

  public void setContract(ContractEnum contract) {
    this.contract = contract;
  }

  public Recurring recurringDetailName(String recurringDetailName) {
    this.recurringDetailName = recurringDetailName;
    return this;
  }

   /**
   * assign a descriptive name for this detail
   * @return recurringDetailName
  **/
  public String getRecurringDetailName() {
    return recurringDetailName;
  }

  public void setRecurringDetailName(String recurringDetailName) {
    this.recurringDetailName = recurringDetailName;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Recurring recurring = (Recurring) o;
    return Objects.equals(this.contract, recurring.contract) &&
        Objects.equals(this.recurringDetailName, recurring.recurringDetailName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(contract, recurringDetailName);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Recurring {\n");

    sb.append("    contract: ").append(toIndentedString(contract)).append("\n");
    sb.append("    recurringDetailName: ").append(toIndentedString(recurringDetailName)).append("\n");
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

