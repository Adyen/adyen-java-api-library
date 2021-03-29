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

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * RefundFundsTransferNotificationContent
 */

public class RefundFundsTransferNotificationContent {
    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("originalReference")
    private String originalReference = null;

    @SerializedName("status")
    private OperationStatus status = null;

    public RefundFundsTransferNotificationContent amount(Amount amount) {
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

    public RefundFundsTransferNotificationContent invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public RefundFundsTransferNotificationContent addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<>();
        }
        this.invalidFields.add(invalidFieldsItem);
        return this;
    }

    /**
     * Invalid fields list.
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    public RefundFundsTransferNotificationContent merchantReference(String merchantReference) {
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

    public RefundFundsTransferNotificationContent originalReference(String originalReference) {
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

    public RefundFundsTransferNotificationContent status(OperationStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get status
     *
     * @return status
     **/
    public OperationStatus getStatus() {
        return status;
    }

    public void setStatus(OperationStatus status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RefundFundsTransferNotificationContent refundFundsTransferNotificationContent = (RefundFundsTransferNotificationContent) o;
        return Objects.equals(this.amount, refundFundsTransferNotificationContent.amount) &&
                Objects.equals(this.invalidFields, refundFundsTransferNotificationContent.invalidFields) &&
                Objects.equals(this.merchantReference, refundFundsTransferNotificationContent.merchantReference) &&
                Objects.equals(this.originalReference, refundFundsTransferNotificationContent.originalReference) &&
                Objects.equals(this.status, refundFundsTransferNotificationContent.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, invalidFields, merchantReference, originalReference, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RefundFundsTransferNotificationContent {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    originalReference: ").append(toIndentedString(originalReference)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
