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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.marketpay;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * UpdateAccountHolderRequest
 */
public class UpdateAccountHolderRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("accountHolderDetails")
    private AccountHolderDetails accountHolderDetails = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("primaryCurrency")
    private String primaryCurrency = null;

    @SerializedName("processingTier")
    private Integer processingTier = null;

    public UpdateAccountHolderRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * code of account holder to be updated
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public UpdateAccountHolderRequest accountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
        return this;
    }

    /**
     * account holder properties to be updated
     *
     * @return accountHolderDetails
     **/
    public AccountHolderDetails getAccountHolderDetails() {
        return accountHolderDetails;
    }

    public void setAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public void setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
    }

    public UpdateAccountHolderRequest processingTier(Integer processingTier) {
        this.processingTier = processingTier;
        return this;
    }

    /**
     * processing tier in which the account needs to start
     *
     * @return processingTier
     **/
    public Integer getProcessingTier() {
        return processingTier;
    }

    public void setProcessingTier(Integer processingTier) {
        this.processingTier = processingTier;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpdateAccountHolderRequest updateAccountHolderRequest = (UpdateAccountHolderRequest) o;
        return Objects.equals(this.accountHolderCode, updateAccountHolderRequest.accountHolderCode)
                && Objects.equals(this.accountHolderDetails, updateAccountHolderRequest.accountHolderDetails)
                && Objects.equals(this.description, updateAccountHolderRequest.description)
                && Objects.equals(this.primaryCurrency, updateAccountHolderRequest.primaryCurrency)
                && Objects.equals(this.processingTier, updateAccountHolderRequest.processingTier);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, accountHolderDetails, processingTier);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateAccountHolderRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    accountHolderDetails: ").append(toIndentedString(accountHolderDetails)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    primaryCurrency: ").append(toIndentedString(primaryCurrency)).append("\n");
        sb.append("    processingTier: ").append(toIndentedString(processingTier)).append("\n");
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

