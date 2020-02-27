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

import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.Objects;

/**
 * Account
 */
public class Account {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("beneficiaryAccount")
    private String beneficiaryAccount = null;

    @SerializedName("beneficiaryMerchantReference")
    private String beneficiaryMerchantReference = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("metadata")
    private Map<String, String> metadata = null;

    @SerializedName("payoutSchedule")
    private PayoutScheduleResponse payoutSchedule = null;

    @SerializedName("status")
    private String status = null;

    public Account accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * The code of the account.
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public Account beneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
        return this;
    }

    /**
     * The beneficiary of the account.
     *
     * @return beneficiaryAccount
     **/
    public String getBeneficiaryAccount() {
        return beneficiaryAccount;
    }

    public void setBeneficiaryAccount(String beneficiaryAccount) {
        this.beneficiaryAccount = beneficiaryAccount;
    }

    public Account beneficiaryMerchantReference(String beneficiaryMerchantReference) {
        this.beneficiaryMerchantReference = beneficiaryMerchantReference;
        return this;
    }

    /**
     * The reason that a beneficiary has been set up for this account. This may have been supplied during the setup of a beneficiary at the discretion of the executing user.
     *
     * @return beneficiaryMerchantReference
     **/
    public String getBeneficiaryMerchantReference() {
        return beneficiaryMerchantReference;
    }

    public void setBeneficiaryMerchantReference(String beneficiaryMerchantReference) {
        this.beneficiaryMerchantReference = beneficiaryMerchantReference;
    }

    public Account description(String description) {
        this.description = description;
        return this;
    }

    /**
     * A description of the account.
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Account metadata(Map<String, String> metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * A set of key and value pairs for general use by the merchant. The keys do not have specific names and may be used for storing miscellaneous data as desired. &gt; Note that during an update of metadata, the omission of existing key-value pairs will result in the deletion of those key-value pairs.
     *
     * @return metadata
     **/
    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }

    public Account payoutSchedule(PayoutScheduleResponse payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
        return this;
    }

    /**
     * Get payoutSchedule
     *
     * @return payoutSchedule
     **/
    public PayoutScheduleResponse getPayoutSchedule() {
        return payoutSchedule;
    }

    public void setPayoutSchedule(PayoutScheduleResponse payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
    }

    public Account status(String status) {
        this.status = status;
        return this;
    }

    /**
     * The status of the account. Possible values: &#x60;Active&#x60;, &#x60;Inactive&#x60;, &#x60;Suspended&#x60;, &#x60;Closed&#x60;.
     *
     * @return status
     **/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
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
        Account account = (Account) o;
        return Objects.equals(this.accountCode, account.accountCode) &&
                Objects.equals(this.beneficiaryAccount, account.beneficiaryAccount) &&
                Objects.equals(this.beneficiaryMerchantReference, account.beneficiaryMerchantReference) &&
                Objects.equals(this.description, account.description) &&
                Objects.equals(this.metadata, account.metadata) &&
                Objects.equals(this.payoutSchedule, account.payoutSchedule) &&
                Objects.equals(this.status, account.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, beneficiaryAccount, beneficiaryMerchantReference, description, metadata, payoutSchedule, status);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Account {\n");

        sb.append("    accountCode: ").append(toIndentedString(accountCode)).append("\n");
        sb.append("    beneficiaryAccount: ").append(toIndentedString(beneficiaryAccount)).append("\n");
        sb.append("    beneficiaryMerchantReference: ").append(toIndentedString(beneficiaryMerchantReference)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
        sb.append("    payoutSchedule: ").append(toIndentedString(payoutSchedule)).append("\n");
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
