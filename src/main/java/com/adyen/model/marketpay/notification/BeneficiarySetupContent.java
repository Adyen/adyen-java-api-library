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
import com.google.gson.annotations.SerializedName;

public class BeneficiarySetupContent {
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

    @Override
    public String toString() {
        return "BeneficiarySetupContent{"
                + "sourceAccountHolderCode='"
                + sourceAccountHolderCode
                + '\''
                + ", sourceAccountCode='"
                + sourceAccountCode
                + '\''
                + ", destinationAccountHolderCode='"
                + destinationAccountHolderCode
                + '\''
                + ", destinationAccountCode='"
                + destinationAccountCode
                + '\''
                + ", merchantReference='"
                + merchantReference
                + '\''
                + ", transferDate="
                + transferDate
                + ", transferredTransactionCount="
                + transferredTransactionCount
                + '}';
    }
}
