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

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Map;
import java.util.Objects;

/**
 * UpdateAccountRequest
 */
public class UpdateAccountRequest {
    @SerializedName("accountCode")
    private String accountCode = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("metadata")
    private Map<String, String> metadata = null;

    @SerializedName("payoutSchedule")
    private UpdatePayoutScheduleRequest payoutSchedule = null;

    public UpdateAccountRequest accountCode(String accountCode) {
        this.accountCode = accountCode;
        return this;
    }

    /**
     * The code of the account to update.
     *
     * @return accountCode
     **/
    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public UpdateAccountRequest description(String description) {
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

    public UpdateAccountRequest metadata(Map<String, String> metadata) {
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

    public UpdateAccountRequest payoutSchedule(UpdatePayoutScheduleRequest payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
        return this;
    }

    /**
     * Get payoutSchedule
     *
     * @return payoutSchedule
     **/
    public UpdatePayoutScheduleRequest getPayoutSchedule() {
        return payoutSchedule;
    }

    public void setPayoutSchedule(UpdatePayoutScheduleRequest payoutSchedule) {
        this.payoutSchedule = payoutSchedule;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        UpdateAccountRequest updateAccountRequest = (UpdateAccountRequest) o;
        return Objects.equals(this.accountCode, updateAccountRequest.accountCode) &&
                Objects.equals(this.description, updateAccountRequest.description) &&
                Objects.equals(this.metadata, updateAccountRequest.metadata) &&
                Objects.equals(this.payoutSchedule, updateAccountRequest.payoutSchedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountCode, description, metadata, payoutSchedule);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpdateAccountRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    accountCode: ").append(Util.toIndentedString(accountCode)).append(TextConstants.LINE_BREAK);
        sb.append("    description: ").append(Util.toIndentedString(description)).append(TextConstants.LINE_BREAK);
        sb.append("    metadata: ").append(Util.toIndentedString(metadata)).append(TextConstants.LINE_BREAK);
        sb.append("    payoutSchedule: ").append(Util.toIndentedString(payoutSchedule)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}
