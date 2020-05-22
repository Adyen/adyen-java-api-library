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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

/**
 * SuspendAccountHolderRequest
 */
public class SuspendAccountHolderRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    public SuspendAccountHolderRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * code of the account holder to be suspended
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        SuspendAccountHolderRequest suspendAccountHolderRequest = (SuspendAccountHolderRequest) o;
        return Objects.equals(this.accountHolderCode, suspendAccountHolderRequest.accountHolderCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SuspendAccountHolderRequest {").append(LINE_BREAK);

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}

