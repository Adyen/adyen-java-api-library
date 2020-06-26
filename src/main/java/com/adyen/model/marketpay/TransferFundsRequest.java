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

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * TransferFundsRequest
 */
public class TransferFundsRequest {
    @SerializedName("sourceAccountCode")
    private String sourceAccountCode = null;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("destinationAccountCode")
    private String destinationAccountCode = null;

    @SerializedName("transferCode")
    private String transferCode = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    public TransferFundsRequest sourceAccountCode(String sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
        return this;
    }

    /**
     * Get sourceAccountCode
     *
     * @return sourceAccountCode
     **/
    public String getSourceAccountCode() {
        return sourceAccountCode;
    }

    public void setSourceAccountCode(String sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
    }

    public TransferFundsRequest amount(Amount amount) {
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

    public TransferFundsRequest destinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
        return this;
    }

    /**
     * Get destinationAccountCode
     *
     * @return destinationAccountCode
     **/
    public String getDestinationAccountCode() {
        return destinationAccountCode;
    }

    public void setDestinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
    }

    public TransferFundsRequest transferCode(String transferCode) {
        this.transferCode = transferCode;
        return this;
    }

    /**
     * Get transferCode
     *
     * @return transferCode
     **/
    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }

    /**
     * get merchantReference
     *
     * @return merchantReference
     */
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransferFundsRequest transferFundsRequest = (TransferFundsRequest) o;
        return Objects.equals(this.sourceAccountCode, transferFundsRequest.sourceAccountCode)
                && Objects.equals(this.amount, transferFundsRequest.amount)
                && Objects.equals(this.destinationAccountCode,
                                  transferFundsRequest.destinationAccountCode)
                && Objects.equals(this.transferCode, transferFundsRequest.transferCode)
                && Objects.equals(this.merchantReference, transferFundsRequest.merchantReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceAccountCode, amount, destinationAccountCode, transferCode, merchantReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransferFundsRequest {\n");

        sb.append("    sourceAccountCode: ").append(toIndentedString(sourceAccountCode)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    destinationAccountCode: ").append(toIndentedString(destinationAccountCode)).append("\n");
        sb.append("    transferCode: ").append(toIndentedString(transferCode)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}

