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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.marketpay;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * DeleteSignatoriesRequest
 */
public class DeleteSignatoriesRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("signatoryCodes")
    private List<String> signatoryCodes = new ArrayList<>();

    public DeleteSignatoriesRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * account holder code, whose signatories have to be deleted
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public DeleteSignatoriesRequest signatoryCodes(List<String> signatoryCodes) {
        this.signatoryCodes = signatoryCodes;
        return this;
    }

    public DeleteSignatoriesRequest addSignatoryCodesItem(String signatoryCodesItem) {
        this.signatoryCodes.add(signatoryCodesItem);
        return this;
    }

    /**
     * codes of the signatories to be deleted
     *
     * @return signatoryCodes
     **/
    public List<String> getSignatoryCodes() {
        return signatoryCodes;
    }

    public void setSignatoryCodes(List<String> signatoryCodes) {
        this.signatoryCodes = signatoryCodes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeleteSignatoriesRequest deleteSignatoriesRequest = (DeleteSignatoriesRequest) o;
        return Objects.equals(this.accountHolderCode, deleteSignatoriesRequest.accountHolderCode) && Objects.equals(this.signatoryCodes, deleteSignatoriesRequest.signatoryCodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, signatoryCodes);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeleteSignatoriesRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    signatoryCodes: ").append(toIndentedString(signatoryCodes)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}

