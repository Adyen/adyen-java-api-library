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

import com.adyen.model.marketpay.Amount;
import com.adyen.model.marketpay.OperationStatus;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TransferFundsNotificationContent {
    @SerializedName("sourceAccountCode")
    private String sourceAccountCode;

    @SerializedName("destinationAccountCode")
    private String destinationAccountCode;

    @SerializedName("amount")
    private Amount amount;

    @SerializedName("transferCode")
    private String transferCode;

    @SerializedName("status")
    private OperationStatus status;

    @SerializedName("merchantReference")
    private String merchantReference;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    public String getSourceAccountCode() {
        return sourceAccountCode;
    }

    public void setSourceAccountCode(String sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
    }

    public String getDestinationAccountCode() {
        return destinationAccountCode;
    }

    public void setDestinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getTransferCode() {
        return transferCode;
    }

    public void setTransferCode(String transferCode) {
        this.transferCode = transferCode;
    }

    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    @Override
    public String toString() {
        String sb = "TransferFundsNotificationContent{" + "sourceAccountCode='" + sourceAccountCode + '\'' +
                ", destinationAccountCode='" + destinationAccountCode + '\'' +
                ", amount=" + amount +
                ", transferCode='" + transferCode + '\'' +
                ", status=" + status +
                ", merchantReference='" + merchantReference + '\'' +
                ", invalidFields=" + invalidFields +
                '}';
        return sb;
    }
}
