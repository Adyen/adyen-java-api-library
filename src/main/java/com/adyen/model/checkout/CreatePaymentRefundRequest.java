/*
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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.checkout;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;
import com.adyen.model.Amount;
import com.adyen.model.Split;
/**
 * CreatePaymentRefundRequest
 */
public class CreatePaymentRefundRequest {
  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Amount amount;

  public static final String SERIALIZED_NAME_MERCHANT_ACCOUNT = "merchantAccount";
  @SerializedName(SERIALIZED_NAME_MERCHANT_ACCOUNT)
  private String merchantAccount;

  public static final String SERIALIZED_NAME_REFERENCE = "reference";
  @SerializedName(SERIALIZED_NAME_REFERENCE)
  private String reference;

  public static final String SERIALIZED_NAME_SPLITS = "splits";
  @SerializedName(SERIALIZED_NAME_SPLITS)
  private List<Split> splits = null;


  public CreatePaymentRefundRequest amount(Amount amount) {

    this.amount = amount;
    return this;
  }

   /**
   * Get amount
   * @return amount
  **/
  public Amount getAmount() {
    return amount;
  }


  public void setAmount(Amount amount) {
    this.amount = amount;
  }


  public CreatePaymentRefundRequest merchantAccount(String merchantAccount) {

    this.merchantAccount = merchantAccount;
    return this;
  }

   /**
   * The merchant account that is used to process the payment.
   * @return merchantAccount
  **/
  public String getMerchantAccount() {
    return merchantAccount;
  }


  public void setMerchantAccount(String merchantAccount) {
    this.merchantAccount = merchantAccount;
  }


  public CreatePaymentRefundRequest reference(String reference) {

    this.reference = reference;
    return this;
  }

   /**
   * Your reference for the refund request. Maximum length: 80 characters.
   * @return reference
  **/
  public String getReference() {
    return reference;
  }


  public void setReference(String reference) {
    this.reference = reference;
  }


  public CreatePaymentRefundRequest splits(List<Split> splits) {

    this.splits = splits;
    return this;
  }

  public CreatePaymentRefundRequest addSplitsItem(Split splitsItem) {
    if (this.splits == null) {
      this.splits = new ArrayList<Split>();
    }
    this.splits.add(splitsItem);
    return this;
  }

   /**
   * An array of objects specifying how the amount should be split between accounts when using Adyen for Platforms. For details, refer to [Providing split information](https://docs.adyen.com/platforms/processing-payments#providing-split-information).
   * @return splits
  **/
  public List<Split> getSplits() {
    return splits;
  }


  public void setSplits(List<Split> splits) {
    this.splits = splits;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreatePaymentRefundRequest createPaymentRefundRequest = (CreatePaymentRefundRequest) o;
    return Objects.equals(this.amount, createPaymentRefundRequest.amount) &&
        Objects.equals(this.merchantAccount, createPaymentRefundRequest.merchantAccount) &&
        Objects.equals(this.reference, createPaymentRefundRequest.reference) &&
        Objects.equals(this.splits, createPaymentRefundRequest.splits);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, merchantAccount, reference, splits);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreatePaymentRefundRequest {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    splits: ").append(toIndentedString(splits)).append("\n");
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

