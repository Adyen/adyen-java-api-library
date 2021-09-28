/*
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


/**
 * CreateStandalonePaymentCancelRequest
 */
public class CreateStandalonePaymentCancelRequest {
  public static final String SERIALIZED_NAME_MERCHANT_ACCOUNT = "merchantAccount";
  @SerializedName(SERIALIZED_NAME_MERCHANT_ACCOUNT)
  private String merchantAccount;

  public static final String SERIALIZED_NAME_PAYMENT_REFERENCE = "paymentReference";
  @SerializedName(SERIALIZED_NAME_PAYMENT_REFERENCE)
  private String paymentReference;

  public static final String SERIALIZED_NAME_REFERENCE = "reference";
  @SerializedName(SERIALIZED_NAME_REFERENCE)
  private String reference;


  public CreateStandalonePaymentCancelRequest merchantAccount(String merchantAccount) {
    
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


  public CreateStandalonePaymentCancelRequest paymentReference(String paymentReference) {
    
    this.paymentReference = paymentReference;
    return this;
  }

   /**
   * The [&#x60;reference&#x60;](https://docs.adyen.com/api-explorer/#/CheckoutService/latest/post/payments__reqParam_reference) of the payment that you want to cancel.
   * @return paymentReference
  **/
  public String getPaymentReference() {
    return paymentReference;
  }


  public void setPaymentReference(String paymentReference) {
    this.paymentReference = paymentReference;
  }


  public CreateStandalonePaymentCancelRequest reference(String reference) {
    
    this.reference = reference;
    return this;
  }

   /**
   * Your reference for the cancel request. Maximum length: 80 characters.
   * @return reference
  **/
  public String getReference() {
    return reference;
  }


  public void setReference(String reference) {
    this.reference = reference;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateStandalonePaymentCancelRequest createStandalonePaymentCancelRequest = (CreateStandalonePaymentCancelRequest) o;
    return Objects.equals(this.merchantAccount, createStandalonePaymentCancelRequest.merchantAccount) &&
        Objects.equals(this.paymentReference, createStandalonePaymentCancelRequest.paymentReference) &&
        Objects.equals(this.reference, createStandalonePaymentCancelRequest.reference);
  }

  @Override
  public int hashCode() {
    return Objects.hash(merchantAccount, paymentReference, reference);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateStandalonePaymentCancelRequest {\n");
    sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
    sb.append("    paymentReference: ").append(toIndentedString(paymentReference)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
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

