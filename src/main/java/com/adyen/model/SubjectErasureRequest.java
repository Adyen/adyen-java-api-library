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

package com.adyen.model;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

/**
 * SubjectErasureRequest
 */

public class SubjectErasureRequest {
    @SerializedName("forceErasure")
    private Boolean forceErasure = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public SubjectErasureRequest forceErasure(Boolean forceErasure) {
        this.forceErasure = forceErasure;
        return this;
    }

    /**
     * Get forceErasure
     *
     * @return forceErasure
     **/
    public Boolean isForceErasure() {
        return forceErasure;
    }

    public void setForceErasure(Boolean forceErasure) {
        this.forceErasure = forceErasure;
    }

    public SubjectErasureRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    /**
     * Get merchantAccount
     *
     * @return merchantAccount
     **/
    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public SubjectErasureRequest pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * Get pspReference
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
        SubjectErasureRequest subjectErasureRequest = (SubjectErasureRequest) o;
        return Objects.equals(this.forceErasure, subjectErasureRequest.forceErasure) &&
                Objects.equals(this.merchantAccount, subjectErasureRequest.merchantAccount) &&
                Objects.equals(this.pspReference, subjectErasureRequest.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(forceErasure, merchantAccount, pspReference);
    }


    @Override
    public String toString() {
        return "class SubjectErasureRequest {\n" +
                "    forceErasure: " + toIndentedString(forceErasure) + "\n" +
                "    merchantAccount: " + toIndentedString(merchantAccount) + "\n" +
                "    pspReference: " + toIndentedString(pspReference) + "\n" +
                "}";
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