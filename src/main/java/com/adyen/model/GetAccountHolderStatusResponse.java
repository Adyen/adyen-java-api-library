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
 * GetAccountHolderStatusResponse
 */
public class GetAccountHolderStatusResponse {
    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("accountHolderStatus")
    private AccountHolderStatus accountHolderStatus = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("status")
    private AccountStatus status = null;

    public GetAccountHolderStatusResponse submittedAsync(Boolean submittedAsync) {
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

    public GetAccountHolderStatusResponse accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * account holder code
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public GetAccountHolderStatusResponse accountHolderStatus(AccountHolderStatus accountHolderStatus) {
        this.accountHolderStatus = accountHolderStatus;
        return this;
    }

    /**
     * account holder status
     *
     * @return accountHolderStatus
     **/
    public AccountHolderStatus getAccountHolderStatus() {
        return accountHolderStatus;
    }

    public void setAccountHolderStatus(AccountHolderStatus accountHolderStatus) {
        this.accountHolderStatus = accountHolderStatus;
    }

    public GetAccountHolderStatusResponse pspReference(String pspReference) {
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

    public GetAccountHolderStatusResponse status(AccountStatus status) {
        this.status = status;
        return this;
    }

    /**
     * account holder status
     *
     * @return status
     **/
    public AccountStatus getStatus() {
        return status;
    }

    public void setStatus(AccountStatus status) {
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
        GetAccountHolderStatusResponse getAccountHolderStatusResponse = (GetAccountHolderStatusResponse) o;
        return Objects.equals(this.submittedAsync, getAccountHolderStatusResponse.submittedAsync)
                && Objects.equals(this.accountHolderCode, getAccountHolderStatusResponse.accountHolderCode)
                && Objects.equals(this.accountHolderStatus, getAccountHolderStatusResponse.accountHolderStatus)
                && Objects.equals(this.pspReference, getAccountHolderStatusResponse.pspReference)
                && Objects.equals(this.status, getAccountHolderStatusResponse.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submittedAsync, accountHolderCode, accountHolderStatus, pspReference, status);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetAccountHolderStatusResponse {\n");

        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    accountHolderStatus: ").append(toIndentedString(accountHolderStatus)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
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

