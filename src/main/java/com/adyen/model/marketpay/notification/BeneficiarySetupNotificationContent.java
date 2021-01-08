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

package com.adyen.model.marketpay.notification;

import java.util.Date;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BeneficiarySetupNotificationContent {
    @SerializedName("sourceAccountHolderCode")
    private String sourceAccountHolderCode;

    @SerializedName("sourceAccountCode")
    private String sourceAccountCode;

    @SerializedName("destinationAccountHolderCode")
    private String destinationAccountHolderCode;

    @SerializedName("destinationAccountCode")
    private String destinationAccountCode;

    @SerializedName("merchantReference")
    private String merchantReference;

    @SerializedName("transferDate")
    private Date transferDate;

    @SerializedName("transferredTransactionCount")
    private int transferredTransactionCount;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    public String getSourceAccountHolderCode() {
        return sourceAccountHolderCode;
    }

    public void setSourceAccountHolderCode(String sourceAccountHolderCode) {
        this.sourceAccountHolderCode = sourceAccountHolderCode;
    }

    public String getSourceAccountCode() {
        return sourceAccountCode;
    }

    public void setSourceAccountCode(String sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
    }

    public String getDestinationAccountHolderCode() {
        return destinationAccountHolderCode;
    }

    public void setDestinationAccountHolderCode(String destinationAccountHolderCode) {
        this.destinationAccountHolderCode = destinationAccountHolderCode;
    }

    public String getDestinationAccountCode() {
        return destinationAccountCode;
    }

    public void setDestinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public Date getTransferDate() {
        return transferDate;
    }

    public void setTransferDate(Date transferDate) {
        this.transferDate = transferDate;
    }

    public int getTransferredTransactionCount() {
        return transferredTransactionCount;
    }

    public void setTransferredTransactionCount(int transferredTransactionCount) {
        this.transferredTransactionCount = transferredTransactionCount;
    }

    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BeneficiarySetupNotificationContent{");
        sb.append("sourceAccountHolderCode='").append(sourceAccountHolderCode).append('\'');
        sb.append(", sourceAccountCode='").append(sourceAccountCode).append('\'');
        sb.append(", destinationAccountHolderCode='").append(destinationAccountHolderCode).append('\'');
        sb.append(", destinationAccountCode='").append(destinationAccountCode).append('\'');
        sb.append(", merchantReference='").append(merchantReference).append('\'');
        sb.append(", transferDate=").append(transferDate);
        sb.append(", transferredTransactionCount=").append(transferredTransactionCount);
        sb.append(", invalidFields=").append(invalidFields);
        sb.append('}');
        return sb.toString();
    }
}
