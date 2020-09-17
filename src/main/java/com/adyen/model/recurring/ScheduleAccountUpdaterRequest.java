/**
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
package com.adyen.model.recurring;

import java.util.Objects;

import com.adyen.model.Card;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;

import static com.adyen.util.Util.toIndentedString;

public class ScheduleAccountUpdaterRequest {
    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("card")
    private Card card = null;

    @SerializedName("merchantAccount")
    private String merchantAccount = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("selectedRecurringDetailReference")
    private String selectedRecurringDetailReference = null;

    @SerializedName("shopperReference")
    private String shopperReference = null;

    public ScheduleAccountUpdaterRequest additionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    public ScheduleAccountUpdaterRequest putAdditionalDataItem(String key, String additionalDataItem) {
        if (this.additionalData == null) {
            this.additionalData = new HashMap<String, String>();
        }
        this.additionalData.put(key, additionalDataItem);
        return this;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public ScheduleAccountUpdaterRequest card(Card card) {
        this.card = card;
        return this;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public ScheduleAccountUpdaterRequest merchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
        return this;
    }

    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public ScheduleAccountUpdaterRequest reference(String reference) {
        this.reference = reference;
        return this;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public ScheduleAccountUpdaterRequest selectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
        return this;
    }

    public String getSelectedRecurringDetailReference() {
        return selectedRecurringDetailReference;
    }

    public void setSelectedRecurringDetailReference(String selectedRecurringDetailReference) {
        this.selectedRecurringDetailReference = selectedRecurringDetailReference;
    }

    public ScheduleAccountUpdaterRequest shopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
        return this;
    }

    public String getShopperReference() {
        return shopperReference;
    }

    public void setShopperReference(String shopperReference) {
        this.shopperReference = shopperReference;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ScheduleAccountUpdaterRequest scheduleAccountUpdaterRequest = (ScheduleAccountUpdaterRequest) o;
        return Objects.equals(this.additionalData, scheduleAccountUpdaterRequest.additionalData) &&
                Objects.equals(this.card, scheduleAccountUpdaterRequest.card) &&
                Objects.equals(this.merchantAccount, scheduleAccountUpdaterRequest.merchantAccount) &&
                Objects.equals(this.reference, scheduleAccountUpdaterRequest.reference) &&
                Objects.equals(this.selectedRecurringDetailReference, scheduleAccountUpdaterRequest.selectedRecurringDetailReference) &&
                Objects.equals(this.shopperReference, scheduleAccountUpdaterRequest.shopperReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalData, card, merchantAccount, reference, selectedRecurringDetailReference, shopperReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ScheduleAccountUpdaterRequest {\n");

        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    card: ").append(toIndentedString(card)).append("\n");
        sb.append("    merchantAccount: ").append(toIndentedString(merchantAccount)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    selectedRecurringDetailReference: ").append(toIndentedString(selectedRecurringDetailReference)).append("\n");
        sb.append("    shopperReference: ").append(toIndentedString(shopperReference)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
