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

import com.adyen.model.marketpay.ErrorFieldType;
import com.adyen.model.marketpay.ErrorFieldTypeContainer;
import com.adyen.model.marketpay.Message;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class PaymentFailureContent {
    @SerializedName("errorFields")
    public List<ErrorFieldTypeContainer> errorFieldTypeContainers;

    @SerializedName("errorMessage")
    public Message errorMessage;

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

    @Override
    public String toString() {
        return "PaymentFailureContent{" + "errorFieldTypeContainers=" + errorFieldTypeContainers + ", errorMessage=" + errorMessage + '}';
    }
}
