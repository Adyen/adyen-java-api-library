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

package com.adyen.model.recurring;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * NotifyShopperResult
 */

public class NotifyShopperResult {
    @SerializedName("displayedReference")
    private String displayedReference = null;

    @SerializedName("message")
    private String message = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    @SerializedName("shopperNotificationReference")
    private String shopperNotificationReference = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    public NotifyShopperResult displayedReference(String displayedReference) {
        this.displayedReference = displayedReference;
        return this;
    }

    /**
     * Reference of Pre-debit notification that is displayed to the shopper
     *
     * @return displayedReference
     **/
    public String getDisplayedReference() {
        return displayedReference;
    }

    public void setDisplayedReference(String displayedReference) {
        this.displayedReference = displayedReference;
    }

    public NotifyShopperResult message(String message) {
        this.message = message;
        return this;
    }

    /**
     * A simple description of the &#x60;resultCode&#x60;.
     *
     * @return message
     **/
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NotifyShopperResult pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * The unique reference that is associated with the request.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public NotifyShopperResult reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * Reference of Pre-debit notification sent in my the merchant
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public NotifyShopperResult resultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * The code indicating the status of notification.
     *
     * @return resultCode
     **/
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public NotifyShopperResult shopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
        return this;
    }

    /**
     * The unique reference for the request sent downstream.
     *
     * @return shopperNotificationReference
     **/
    public String getShopperNotificationReference() {
        return shopperNotificationReference;
    }

    public void setShopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
    }

    public NotifyShopperResult storedPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
        return this;
    }

    /**
     * This is the recurringDetailReference returned in the response when token was created
     *
     * @return storedPaymentMethodId
     **/
    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NotifyShopperResult notifyShopperResult = (NotifyShopperResult) o;
        return Objects.equals(this.displayedReference, notifyShopperResult.displayedReference) &&
                Objects.equals(this.message, notifyShopperResult.message) &&
                Objects.equals(this.pspReference, notifyShopperResult.pspReference) &&
                Objects.equals(this.reference, notifyShopperResult.reference) &&
                Objects.equals(this.resultCode, notifyShopperResult.resultCode) &&
                Objects.equals(this.shopperNotificationReference, notifyShopperResult.shopperNotificationReference) &&
                Objects.equals(this.storedPaymentMethodId, notifyShopperResult.storedPaymentMethodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(displayedReference, message, pspReference, reference, resultCode, shopperNotificationReference, storedPaymentMethodId);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotifyShopperResult {\n");

        sb.append("    displayedReference: ").append(toIndentedString(displayedReference)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("    shopperNotificationReference: ").append(toIndentedString(shopperNotificationReference)).append("\n");
        sb.append("    storedPaymentMethodId: ").append(toIndentedString(storedPaymentMethodId)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
