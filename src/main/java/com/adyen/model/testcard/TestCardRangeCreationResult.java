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
package com.adyen.model.testcard;

import com.google.gson.annotations.SerializedName;

public class TestCardRangeCreationResult {
    @SerializedName("cardNumberRangeStart")
    private String cardNumberRangeStart = null;

    @SerializedName("cardNumberRangeEnd")
    private String cardNumberRangeEnd = null;

    @SerializedName("creationResultCode")
    private CreationResult creationResultCode = null;

    public enum CreationResult {
        CREATED,
        ALREADY_EXISTS,
        ERROR
    }

    public String getCardNumberRangeStart() {
        return cardNumberRangeStart;
    }

    public void setCardNumberRangeStart(String cardNumberRangeStart) {
        this.cardNumberRangeStart = cardNumberRangeStart;
    }

    public String getCardNumberRangeEnd() {
        return cardNumberRangeEnd;
    }

    public void setCardNumberRangeEnd(String cardNumberRangeEnd) {
        this.cardNumberRangeEnd = cardNumberRangeEnd;
    }

    public CreationResult getCreationResultCode() {
        return creationResultCode;
    }

    public void setCreationResultCode(CreationResult creationResultCode) {
        this.creationResultCode = creationResultCode;
    }

    @Override
    public String toString() {
        return "TestCardRangeCreationResult{" +
                "cardNumberRangeStart='" + cardNumberRangeStart + '\'' +
                ", cardNumberRangeEnd='" + cardNumberRangeEnd + '\'' +
                ", creationResultCode=" + creationResultCode +
                '}';
    }
}
