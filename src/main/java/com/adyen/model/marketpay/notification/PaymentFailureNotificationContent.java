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

import com.adyen.model.marketpay.ErrorFieldType;
import com.adyen.model.marketpay.ErrorFieldTypeContainer;
import com.adyen.model.marketpay.Message;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PaymentFailureNotificationContent {
    @SerializedName("errorFields")
    @JsonProperty("errorFields")
    public List<ErrorFieldTypeContainer> errorFieldTypeContainers;

    @SerializedName("errorMessage")
    public Message errorMessage;

    @SerializedName("modificationMerchantReference")
    public String modificationMerchantReference;
    @SerializedName("modificationPspReference")
    public String modificationPspReference;
    @SerializedName("paymentMerchantReference")
    public String paymentMerchantReference;
    @SerializedName("paymentPspReference")
    public String paymentPspReference;

    public List<ErrorFieldType> getErrorFieldList() {
        List<ErrorFieldType> errorFieldTypeList = new ArrayList<>();

        if (errorFieldTypeContainers == null) {
            return errorFieldTypeList;
        }

        errorFieldTypeContainers.stream().forEach(s -> errorFieldTypeList.add(s.getErrorFieldType()));

        return errorFieldTypeList;
    }

    public List<ErrorFieldTypeContainer> getErrorFieldTypeContainers() {
        return errorFieldTypeContainers;
    }

    public void setErrorFieldTypeContainers(List<ErrorFieldTypeContainer> errorFieldTypeContainers) {
        this.errorFieldTypeContainers = errorFieldTypeContainers;
    }

    public Message getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Message errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getModificationMerchantReference() {
        return modificationMerchantReference;
    }

    public void setModificationMerchantReference(String modificationMerchantReference) {
        this.modificationMerchantReference = modificationMerchantReference;
    }

    public String getModificationPspReference() {
        return modificationPspReference;
    }

    public void setModificationPspReference(String modificationPspReference) {
        this.modificationPspReference = modificationPspReference;
    }

    public String getPaymentMerchantReference() {
        return paymentMerchantReference;
    }

    public void setPaymentMerchantReference(String paymentMerchantReference) {
        this.paymentMerchantReference = paymentMerchantReference;
    }

    public String getPaymentPspReference() {
        return paymentPspReference;
    }

    public void setPaymentPspReference(String paymentPspReference) {
        this.paymentPspReference = paymentPspReference;
    }

    @Override
    public String toString() {
        return "PaymentFailureContent{" + "errorFieldTypeContainers=" + errorFieldTypeContainers + ", errorMessage=" + errorMessage + ", modificationMerchantReference=" + modificationMerchantReference + ", modificationPspReference=" + modificationPspReference + ", paymentMerchantReference=" + paymentMerchantReference + ", paymentPspReference=" + paymentPspReference + '}';
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentFailureNotificationContent that = (PaymentFailureNotificationContent) o;
        return Objects.equals(errorFieldTypeContainers, that.errorFieldTypeContainers) &&
                Objects.equals(errorMessage, that.errorMessage) &&
                Objects.equals(modificationMerchantReference, that.modificationMerchantReference) &&
                Objects.equals(modificationPspReference, that.modificationPspReference) &&
                Objects.equals(paymentMerchantReference, that.paymentMerchantReference) &&
                Objects.equals(paymentPspReference, that.paymentPspReference);
    }

    @Override public int hashCode() {
        return Objects.hash(errorFieldTypeContainers,
                errorMessage,
                modificationMerchantReference,
                modificationPspReference,
                paymentMerchantReference,
                paymentPspReference);
    }
}
