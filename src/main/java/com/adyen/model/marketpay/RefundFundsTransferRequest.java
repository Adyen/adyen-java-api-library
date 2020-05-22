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
import com.adyen.model.Amount;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * RefundFundsTransferRequest
 */

public class RefundFundsTransferRequest {
    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("originalReference")
    private String originalReference = null;

    public RefundFundsTransferRequest amount(Amount amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public RefundFundsTransferRequest merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * A value that can be supplied at the discretion of the executing user in order to link multiple transactions to one another.
     *
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public RefundFundsTransferRequest originalReference(String originalReference) {
        this.originalReference = originalReference;
        return this;
    }

    /**
     * A PSP reference of the original fund transfer.
     *
     * @return originalReference
     **/
    public String getOriginalReference() {
        return originalReference;
    }

    public void setOriginalReference(String originalReference) {
        this.originalReference = originalReference;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        RefundFundsTransferRequest refundFundsTransferRequest = (RefundFundsTransferRequest) o;
        return Objects.equals(this.amount, refundFundsTransferRequest.amount) &&
                Objects.equals(this.merchantReference, refundFundsTransferRequest.merchantReference) &&
                Objects.equals(this.originalReference, refundFundsTransferRequest.originalReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, merchantReference, originalReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RefundFundsTransferRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    amount: ").append(Util.toIndentedString(amount)).append(TextConstants.LINE_BREAK);
        sb.append("    merchantReference: ").append(Util.toIndentedString(merchantReference)).append(TextConstants.LINE_BREAK);
        sb.append("    originalReference: ").append(Util.toIndentedString(originalReference)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}
