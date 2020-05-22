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

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * CloseAccountHolderRequest
 */
public class CloseAccountHolderRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    public CloseAccountHolderRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * code of the account holder to be closed
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
        CloseAccountHolderRequest closeAccountHolderRequest = (CloseAccountHolderRequest) o;
        return Objects.equals(this.accountHolderCode, closeAccountHolderRequest.accountHolderCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CloseAccountHolderRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    accountHolderCode: ").append(Util.toIndentedString(accountHolderCode)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}

