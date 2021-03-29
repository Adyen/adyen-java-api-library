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

package com.adyen.model.marketpay.notification;

import com.adyen.model.marketpay.Transaction;
import com.google.gson.annotations.SerializedName;

public class RefundResult {
    @SerializedName("response")
    private String response;

    @SerializedName("pspReference")
    private String pspReference;

    @SerializedName("originalTransaction")
    private Transaction originalTransaction;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public Transaction getOriginalTransaction() {
        return originalTransaction;
    }

    public void setOriginalTransaction(Transaction originalTransaction) {
        this.originalTransaction = originalTransaction;
    }

    @Override
    public String toString() {
        return "RefundResult{" + "response='" + response + '\'' + ", pspReference='" + pspReference + '\'' + ", originalTransaction=" + originalTransaction + '}';
    }
}
