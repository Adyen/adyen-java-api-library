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

package com.adyen.model.management;

import com.adyen.model.Amount;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;

import java.time.OffsetDateTime;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class CustomNotification {
    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("eventCode")
    private String eventCode = null;

    @SerializedName("eventDate")
    @JsonAdapter(OffsetDateTimeSerializer.class)
    private OffsetDateTime eventDate = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("paymentMethod")
    private String paymentMethod = null;

    @SerializedName("reason")
    private String reason = null;

    @SerializedName("success")
    private Boolean success = null;

    public CustomNotification amount(Amount amount) {
        this.amount = amount;
        return this;
    }

    /**
     * Get amount
     * @return amount
     **/
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public CustomNotification eventCode(String eventCode) {
        this.eventCode = eventCode;
        return this;
    }

    /**
     * Get eventCode
     * @return eventCode
     **/
    public String getEventCode() {
        return eventCode;
    }

    public void setEventCode(String eventCode) {
        this.eventCode = eventCode;
    }

    public CustomNotification eventDate(OffsetDateTime eventDate) {
        this.eventDate = eventDate;
        return this;
    }

    /**
     * Get eventDate
     * @return eventDate
     **/
    public OffsetDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(OffsetDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public CustomNotification merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * Get merchantReference
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    public CustomNotification paymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    /**
     * Get paymentMethod
     * @return paymentMethod
     **/
    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public CustomNotification reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * Get reason
     * @return reason
     **/
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public CustomNotification success(Boolean success) {
        this.success = success;
        return this;
    }

    /**
     * Get success
     * @return success
     **/
    public Boolean isSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomNotification customNotification = (CustomNotification) o;
        return Objects.equals(this.amount, customNotification.amount) &&
                Objects.equals(this.eventCode, customNotification.eventCode) &&
                Objects.equals(this.eventDate, customNotification.eventDate) &&
                Objects.equals(this.merchantReference, customNotification.merchantReference) &&
                Objects.equals(this.paymentMethod, customNotification.paymentMethod) &&
                Objects.equals(this.reason, customNotification.reason) &&
                Objects.equals(this.success, customNotification.success);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, eventCode, eventDate, merchantReference, paymentMethod, reason, success);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CustomNotification {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    eventCode: ").append(toIndentedString(eventCode)).append("\n");
        sb.append("    eventDate: ").append(toIndentedString(eventDate)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    success: ").append(toIndentedString(success)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
