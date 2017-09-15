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
 * PayoutAccountHolderResponse
 */
public class PayoutAccountHolderResponse {
    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public PayoutAccountHolderResponse submittedAsync(Boolean submittedAsync) {
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

    public PayoutAccountHolderResponse bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    /**
     * the bankAccountUUID of the selected bank account
     *
     * @return bankAccountUUID
     **/
    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public PayoutAccountHolderResponse pspReference(String pspReference) {
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
        PayoutAccountHolderResponse payoutAccountHolderResponse = (PayoutAccountHolderResponse) o;
        return Objects.equals(this.submittedAsync, payoutAccountHolderResponse.submittedAsync) && Objects.equals(this.bankAccountUUID, payoutAccountHolderResponse.bankAccountUUID) && Objects.equals(
                this.pspReference,
                payoutAccountHolderResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submittedAsync, bankAccountUUID, pspReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PayoutAccountHolderResponse {\n");

        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append("\n");
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

