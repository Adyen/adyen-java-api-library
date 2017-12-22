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
 * CloseAccountResponse
 */
public class CloseAccountResponse {
    @SerializedName("accountStatus")
    private AccountStatus accountStatus = null;

    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    /**
     * account holder's account status after account closure
     */
    public enum StatusEnum {
        @SerializedName("Active")
        ACTIVE("Active"),

        @SerializedName("Closed")
        CLOSED("Closed"),

        @SerializedName("Inactive")
        INACTIVE("Inactive"),

        @SerializedName("Suspended")
        SUSPENDED("Suspended");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("status")
    private StatusEnum status = null;

    public CloseAccountResponse accountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    /**
     * account holder's account status after account closure
     *
     * @return accountStatus
     **/
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public CloseAccountResponse submittedAsync(Boolean submittedAsync) {
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

    public CloseAccountResponse pspReference(String pspReference) {
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

    public CloseAccountResponse status(StatusEnum status) {
        this.status = status;
        return this;
    }

    /**
     * account holder's account status after account closure
     *
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
        CloseAccountResponse closeAccountResponse = (CloseAccountResponse) o;
        return Objects.equals(this.accountStatus, closeAccountResponse.accountStatus)
                && Objects.equals(this.submittedAsync, closeAccountResponse.submittedAsync)
                && Objects.equals(this.pspReference,
                                  closeAccountResponse.pspReference)
                && Objects.equals(this.status, closeAccountResponse.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountStatus, submittedAsync, pspReference, status);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CloseAccountResponse {\n");

        sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
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

