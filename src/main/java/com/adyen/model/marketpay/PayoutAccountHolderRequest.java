
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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay;

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * PayoutAccountHolderRequest
 */
public class PayoutAccountHolderRequest {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("payoutMethodCode")
    private String payoutMethodCode = null;

    public PayoutAccountHolderRequest accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * The code of the account from which the payout is to be made.
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public PayoutAccountHolderRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The code of the Account Holder who owns the account from which the payout is to be made. The Account Holder is the party to which the payout will be made.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public PayoutAccountHolderRequest amount(Amount amount) {
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

    public PayoutAccountHolderRequest bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    /**
     * The unique ID of the Bank Account held by the Account Holder to which the payout is to be made. If left blank, a bank account is automatically selected.
     *
     * @return bankAccountUUID
     **/
    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public PayoutAccountHolderRequest description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the payout. Maximum 35 characters. Allowed: **abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789/?:().,&#x27;+ \&quot;;**
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PayoutAccountHolderRequest merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * A value that can be supplied at the discretion of the executing user in order to link multiple transactions to one another.
     *
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public PayoutAccountHolderRequest payoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
        return this;
    }

    /**
     * The unique ID of the payout method held by the Account Holder to which the payout is to be made. If left blank, a payout instrument is automatically selected.
     *
     * @return payoutMethodCode
     **/
    public String getPayoutMethodCode() {
        return payoutMethodCode;
    }

    public void setPayoutMethodCode(String payoutMethodCode) {
        this.payoutMethodCode = payoutMethodCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PayoutAccountHolderRequest payoutAccountHolderRequest = (PayoutAccountHolderRequest) o;
        return Objects.equals(this.accountCode, payoutAccountHolderRequest.accountCode) &&
                Objects.equals(this.accountHolderCode, payoutAccountHolderRequest.accountHolderCode) &&
                Objects.equals(this.amount, payoutAccountHolderRequest.amount) &&
                Objects.equals(this.bankAccountUUID, payoutAccountHolderRequest.bankAccountUUID) &&
                Objects.equals(this.description, payoutAccountHolderRequest.description) &&
                Objects.equals(this.merchantReference, payoutAccountHolderRequest.merchantReference) &&
                Objects.equals(this.payoutMethodCode, payoutAccountHolderRequest.payoutMethodCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, accountHolderCode, amount, bankAccountUUID, description, merchantReference, payoutMethodCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayoutAccountHolderRequest {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    payoutMethodCode: ").append(toIndentedString(payoutMethodCode)).append("\n");
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
