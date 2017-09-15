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
 * SuspendAccountHolderResponse
 */
public class SuspendAccountHolderResponse {
    @SerializedName("accountStatus")
    private AccountStatus accountStatus = null;

    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("accountHolderStatus")
    private AccountHolderStatus accountHolderStatus = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public SuspendAccountHolderResponse accountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    /**
     * account holder status after account holder suspension
     *
     * @return accountStatus
     **/
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public SuspendAccountHolderResponse submittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
        return this;
    }

    /**
     * Get submittedAsync
     *
     * @return submittedAsync
     **/
    public Boolean getSubmittedAsync() {
        return submittedAsync;
    }

    public void setSubmittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
    }

    public SuspendAccountHolderResponse accountHolderStatus(AccountHolderStatus accountHolderStatus) {
        this.accountHolderStatus = accountHolderStatus;
        return this;
    }

    /**
     * account holder status after account holder suspension
     *
     * @return accountHolderStatus
     **/
    public AccountHolderStatus getAccountHolderStatus() {
        return accountHolderStatus;
    }

    public void setAccountHolderStatus(AccountHolderStatus accountHolderStatus) {
        this.accountHolderStatus = accountHolderStatus;
    }

    public SuspendAccountHolderResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * psp reference
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SuspendAccountHolderResponse suspendAccountHolderResponse = (SuspendAccountHolderResponse) o;
        return Objects.equals(this.accountStatus, suspendAccountHolderResponse.accountStatus)
                && Objects.equals(this.submittedAsync, suspendAccountHolderResponse.submittedAsync)
                && Objects.equals(this.accountHolderStatus, suspendAccountHolderResponse.accountHolderStatus)
                && Objects.equals(this.pspReference, suspendAccountHolderResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountStatus, submittedAsync, accountHolderStatus, pspReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SuspendAccountHolderResponse {\n");

        sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    accountHolderStatus: ").append(toIndentedString(accountHolderStatus)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
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

