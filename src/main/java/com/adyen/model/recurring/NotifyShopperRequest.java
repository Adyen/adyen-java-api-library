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

package com.adyen.model.recurring;

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * NotifyShopperRequest
 */

public class NotifyShopperRequest {
    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("billingDate")
    private String billingDate = null;

    @SerializedName("billingSequenceNumber")
    private String billingSequenceNumber = null;

    @SerializedName("displayedReference")
    private String displayedReference = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    public NotifyShopperRequest amount(Amount amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public NotifyShopperRequest billingDate(String billingDate) {
        this.billingDate = billingDate;
        return this;
    }

    /**
     * Date on which the subscription amount will be debited from the shopper. In YYYY-MM-DD format
     *
     * @return billingDate
     **/
    public String getBillingDate() {
        return billingDate;
    }

    public void setBillingDate(String billingDate) {
        this.billingDate = billingDate;
    }

    public NotifyShopperRequest billingSequenceNumber(String billingSequenceNumber) {
        this.billingSequenceNumber = billingSequenceNumber;
        return this;
    }

    /**
     * Sequence of the debit. Depends on Frequency and Billing Attempts Rule.
     *
     * @return billingSequenceNumber
     **/
    public String getBillingSequenceNumber() {
        return billingSequenceNumber;
    }

    public void setBillingSequenceNumber(String billingSequenceNumber) {
        this.billingSequenceNumber = billingSequenceNumber;
    }

    public NotifyShopperRequest displayedReference(String displayedReference) {
        this.displayedReference = displayedReference;
        return this;
    }

    /**
     * Reference of Pre-debit notification that is displayed to the shopper. Optional field. Maps to reference if missing
     *
     * @return displayedReference
     **/
    public String getDisplayedReference() {
        return displayedReference;
    }

    public void setDisplayedReference(String displayedReference) {
        this.displayedReference = displayedReference;
    }

    public NotifyShopperRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * The merchant account identifier with which you want to process the transaction.
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public NotifyShopperRequest recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     *
     * @return recurringDetailReference
     **/
    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public NotifyShopperRequest reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * Pre-debit notification reference sent by the merchant. This is a mandatory field
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public NotifyShopperRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    /**
     * The ID that uniquely identifies the shopper.  This &#x60;shopperReference&#x60; must be the same as the &#x60;shopperReference&#x60; used in the initial payment.
     *
     * @return shopperReference
     **/
    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }

    public NotifyShopperRequest storedPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     *
     * @return storedPaymentMethodId
     **/
    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotifyShopperRequest notifyShopperRequest = (NotifyShopperRequest) o;
        return Objects.equals(this.amount, notifyShopperRequest.amount) &&
                Objects.equals(this.billingDate, notifyShopperRequest.billingDate) &&
                Objects.equals(this.billingSequenceNumber, notifyShopperRequest.billingSequenceNumber) &&
                Objects.equals(this.displayedReference, notifyShopperRequest.displayedReference) &&
                Objects.equals(this.merchantAccount, notifyShopperRequest.merchantAccount) &&
                Objects.equals(this.recurringDetailReference, notifyShopperRequest.recurringDetailReference) &&
                Objects.equals(this.reference, notifyShopperRequest.reference) &&
                Objects.equals(this.shopperReference, notifyShopperRequest.shopperReference) &&
                Objects.equals(this.storedPaymentMethodId, notifyShopperRequest.storedPaymentMethodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, billingDate, billingSequenceNumber, displayedReference, merchantAccount, recurringDetailReference, reference, shopperReference, storedPaymentMethodId);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotifyShopperRequest {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    billingDate: ").append(toIndentedString(billingDate)).append("\n");
        sb.append("    billingSequenceNumber: ").append(toIndentedString(billingSequenceNumber)).append("\n");
        sb.append("    displayedReference: ").append(toIndentedString(displayedReference)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    recurringDetailReference: ").append(toIndentedString(recurringDetailReference)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
