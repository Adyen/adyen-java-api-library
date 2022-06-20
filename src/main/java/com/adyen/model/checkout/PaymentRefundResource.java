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
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * PaymentRefundResource
 */
public class PaymentRefundResource {
  @SerializedName("amount")
  private Amount amount = null;

  @SerializedName("lineItems")
  private List<LineItem> lineItems = null;

  @SerializedName("merchantAccount")
  private String merchantAccount = null;

  @SerializedName("paymentPspReference")
  private String paymentPspReference = null;

  @SerializedName("pspReference")
  private String pspReference = null;

  @SerializedName("reference")
  private String reference = null;

  @SerializedName("splits")
  private List<Split> splits = null;

  /**
   * The status of your request. This will always have the value **received**.
   */
  @JsonAdapter(StatusEnum.Adapter.class)
  public enum StatusEnum {
    RECEIVED("received");

    @JsonValue
    private final String value;

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
    public static StatusEnum fromValue(String input) {
      for (StatusEnum b : StatusEnum.values()) {
        if (b.value.equals(input)) {
          return b;
        }
      }
      return null;
    }
    public static class Adapter extends TypeAdapter<StatusEnum> {
      @Override
      public void write(final JsonWriter jsonWriter, final StatusEnum enumeration) throws IOException {
        jsonWriter.value(String.valueOf(enumeration.getValue()));
      }

      @Override
      public StatusEnum read(final JsonReader jsonReader) throws IOException {
        Object value = jsonReader.nextString();
        return StatusEnum.fromValue((String) (value));
      }
    }
  }  @SerializedName("status")
  private StatusEnum status = null;

  public PaymentRefundResource amount(Amount amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
   **/
  @Schema(required = true, description = "")
  public Amount getAmount() {
    return amount;
  }

  public void setAmount(Amount amount) {
    this.amount = amount;
  }

  public PaymentRefundResource lineItems(List<LineItem> lineItems) {
    this.lineItems = lineItems;
    return this;
  }

  public PaymentRefundResource addLineItemsItem(LineItem lineItemsItem) {
    if (this.lineItems == null) {
      this.lineItems = new ArrayList<LineItem>();
    }
    this.lineItems.add(lineItemsItem);
    return this;
  }

  /**
   * Price and product information of the refunded items, required for [partial refunds](https://docs.adyen.com/online-payments/refund#refund-a-payment). &gt; This field is required for partial refunds with 3x 4x Oney, Affirm, Afterpay, Clearpay, Klarna, Ratepay, Zip and Atome.
   * @return lineItems
   **/
  @Schema(description = "Price and product information of the refunded items, required for [partial refunds](https://docs.adyen.com/online-payments/refund#refund-a-payment). > This field is required for partial refunds with 3x 4x Oney, Affirm, Afterpay, Clearpay, Klarna, Ratepay, Zip and Atome.")
  public List<LineItem> getLineItems() {
    return lineItems;
  }

  public void setLineItems(List<LineItem> lineItems) {
    this.lineItems = lineItems;
  }

  public PaymentRefundResource merchantAccount(String merchantAccount) {
    this.merchantAccount = merchantAccount;
    return this;
  }

  /**
   * The merchant account that is used to process the payment.
   * @return merchantAccount
   **/
  @Schema(required = true, description = "The merchant account that is used to process the payment.")
  public String getMerchantAccount() {
    return merchantAccount;
  }

  public void setMerchantAccount(String merchantAccount) {
    this.merchantAccount = merchantAccount;
  }

  public PaymentRefundResource paymentPspReference(String paymentPspReference) {
    this.paymentPspReference = paymentPspReference;
    return this;
  }

  /**
   * The [&#x60;pspReference&#x60;](https://docs.adyen.com/api-explorer/#/CheckoutService/latest/post/payments__resParam_pspReference) of the payment to refund.
   * @return paymentPspReference
   **/
  @Schema(required = true, description = "The [`pspReference`](https://docs.adyen.com/api-explorer/#/CheckoutService/latest/post/payments__resParam_pspReference) of the payment to refund. ")
  public String getPaymentPspReference() {
    return paymentPspReference;
  }

  public void setPaymentPspReference(String paymentPspReference) {
    this.paymentPspReference = paymentPspReference;
  }

  public PaymentRefundResource pspReference(String pspReference) {
    this.pspReference = pspReference;
    return this;
  }

  /**
   * Adyen&#x27;s 16-character reference associated with the refund request.
   * @return pspReference
   **/
  @Schema(required = true, description = "Adyen's 16-character reference associated with the refund request.")
  public String getPspReference() {
    return pspReference;
  }

  public void setPspReference(String pspReference) {
    this.pspReference = pspReference;
  }

  public PaymentRefundResource reference(String reference) {
    this.reference = reference;
    return this;
  }

  /**
   * Your reference for the refund request.
   * @return reference
   **/
  @Schema(description = "Your reference for the refund request.")
  public String getReference() {
    return reference;
  }

  public void setReference(String reference) {
    this.reference = reference;
  }

  public PaymentRefundResource splits(List<Split> splits) {
    this.splits = splits;
    return this;
  }

  public PaymentRefundResource addSplitsItem(Split splitsItem) {
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
  @Schema(description = "An array of objects specifying how the amount should be split between accounts when using Adyen for Platforms. For details, refer to [Providing split information](https://docs.adyen.com/platforms/processing-payments#providing-split-information).")
  public List<Split> getSplits() {
    return splits;
  }

  public void setSplits(List<Split> splits) {
    this.splits = splits;
  }

  public PaymentRefundResource status(StatusEnum status) {
    this.status = status;
    return this;
  }

  /**
   * The status of your request. This will always have the value **received**.
   * @return status
   **/
  @Schema(required = true, description = "The status of your request. This will always have the value **received**.")
  public StatusEnum getStatus() {
    return status;
  }

  public void setStatus(StatusEnum status) {
    this.status = status;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentRefundResource paymentRefundResource = (PaymentRefundResource) o;
    return Objects.equals(this.amount, paymentRefundResource.amount) &&
            Objects.equals(this.lineItems, paymentRefundResource.lineItems) &&
            Objects.equals(this.merchantAccount, paymentRefundResource.merchantAccount) &&
            Objects.equals(this.paymentPspReference, paymentRefundResource.paymentPspReference) &&
            Objects.equals(this.pspReference, paymentRefundResource.pspReference) &&
            Objects.equals(this.reference, paymentRefundResource.reference) &&
            Objects.equals(this.splits, paymentRefundResource.splits) &&
            Objects.equals(this.status, paymentRefundResource.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, lineItems, merchantAccount, paymentPspReference, pspReference, reference, splits, status);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentRefundResource {\n");

    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    lineItems: ").append(toIndentedString(lineItems)).append("\n");
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
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}

