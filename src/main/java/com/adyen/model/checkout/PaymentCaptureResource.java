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

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.adyen.model.Amount;
import com.adyen.model.Split;

/**
 * PaymentCaptureResource
 */
public class PaymentCaptureResource {
  public static final String SERIALIZED_NAME_AMOUNT = "amount";
  @SerializedName(SERIALIZED_NAME_AMOUNT)
  private Amount amount;

  public static final String SERIALIZED_NAME_MERCHANT_ACCOUNT = "merchantAccount";
  @SerializedName(SERIALIZED_NAME_MERCHANT_ACCOUNT)
  private String merchantAccount;

  public static final String SERIALIZED_NAME_PAYMENT_PSP_REFERENCE = "paymentPspReference";
  @SerializedName(SERIALIZED_NAME_PAYMENT_PSP_REFERENCE)
  private String paymentPspReference;

  public static final String SERIALIZED_NAME_PSP_REFERENCE = "pspReference";
  @SerializedName(SERIALIZED_NAME_PSP_REFERENCE)
  private String pspReference;

  public static final String SERIALIZED_NAME_REFERENCE = "reference";
  @SerializedName(SERIALIZED_NAME_REFERENCE)
  private String reference;

  public static final String SERIALIZED_NAME_SPLITS = "splits";
  @SerializedName(SERIALIZED_NAME_SPLITS)
  private List<Split> splits = null;

  /**
   * The status of your request. This will always have the value **received**.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    RECEIVED("received");

    @JsonValue
    private String value;

    StatusEnum(String value) {
      this.value = value;
    }

    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    public static StatusEnum fromValue(String value) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      throw new IllegalArgumentException("Unexpected value '" + value + "'");
    }

    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(enumeration.getValue());
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        String value =  jsonReader.nextString();
        return StatusEnum.fromValue(value);
      }
    }
  }

  public static final String SERIALIZED_NAME_STATUS = "status";
  @SerializedName(SERIALIZED_NAME_STATUS)
  private StatusEnum status;


  public PaymentCaptureResource amount(Amount amount) {

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


  public PaymentCaptureResource merchantAccount(String merchantAccount) {

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


  public PaymentCaptureResource paymentPspReference(String paymentPspReference) {

    this.paymentPspReference = paymentPspReference;
    return this;
  }

   /**
   * The [&#x60;pspReference&#x60;](https://docs.adyen.com/api-explorer/#/CheckoutService/latest/post/payments__resParam_pspReference) of the payment to capture.
   * @return paymentPspReference
  **/
  public String getPaymentPspReference() {
    return paymentPspReference;
  }


  public void setPaymentPspReference(String paymentPspReference) {
    this.paymentPspReference = paymentPspReference;
  }


  public PaymentCaptureResource pspReference(String pspReference) {

    this.pspReference = pspReference;
    return this;
  }

   /**
   * Adyen&#39;s 16-character reference associated with the capture request.
   * @return pspReference
  **/
  public String getPspReference() {
    return pspReference;
  }


  public void setPspReference(String pspReference) {
    this.pspReference = pspReference;
  }


  public PaymentCaptureResource reference(String reference) {

    this.reference = reference;
    return this;
  }

   /**
   * Your reference for the capture request.
   * @return reference
  **/
  public String getReference() {
    return reference;
  }


  public void setReference(String reference) {
    this.reference = reference;
  }


  public PaymentCaptureResource splits(List<Split> splits) {

    this.splits = splits;
    return this;
  }

  public PaymentCaptureResource addSplitsItem(Split splitsItem) {
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


  public PaymentCaptureResource status(StatusEnum status) {

    this.status = status;
    return this;
  }

   /**
   * The status of your request. This will always have the value **received**.
   * @return status
  **/
  public StatusEnum getStatus() {
    return status;
  }


  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentCaptureResource paymentCaptureResource = (PaymentCaptureResource) o;
    return Objects.equals(this.amount, paymentCaptureResource.amount) &&
        Objects.equals(this.merchantAccount, paymentCaptureResource.merchantAccount) &&
        Objects.equals(this.paymentPspReference, paymentCaptureResource.paymentPspReference) &&
        Objects.equals(this.pspReference, paymentCaptureResource.pspReference) &&
        Objects.equals(this.reference, paymentCaptureResource.reference) &&
        Objects.equals(this.splits, paymentCaptureResource.splits) &&
        Objects.equals(this.status, paymentCaptureResource.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, merchantAccount, paymentPspReference, pspReference, reference, splits, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentCaptureResource {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
    sb.append("    paymentPspReference: ").append(toIndentedString(paymentPspReference)).append("\n");
    sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    splits: ").append(toIndentedString(splits)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

