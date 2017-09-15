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
 * PayoutAccountHolderRequest
 */
public class PayoutAccountHolderRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("description")
    private String description = null;

    public PayoutAccountHolderRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * Get accountHolderCode
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public PayoutAccountHolderRequest accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * Get accountCode
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
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
     * the bankAccountUUID of the Bank Account to use. If not set, a default is automatically selected.
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
     * Get description
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        return Objects.equals(this.accountHolderCode, payoutAccountHolderRequest.accountHolderCode)
                && Objects.equals(this.accountCode, payoutAccountHolderRequest.accountCode)
                && Objects.equals(this.amount, payoutAccountHolderRequest.amount)
                && Objects.equals(this.bankAccountUUID, payoutAccountHolderRequest.bankAccountUUID)
                && Objects.equals(this.description, payoutAccountHolderRequest.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, accountCode, amount, bankAccountUUID, description);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayoutAccountHolderRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

