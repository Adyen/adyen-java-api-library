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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.notification;

import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;
import java.util.Map;


import static com.adyen.util.Util.toIndentedString;

/**
 * NotificationRequestItem model class
 */
public class NotificationRequestItem {
    public static final String EVENT_CODE_AUTHORISATION = "AUTHORISATION";

    //Standard Event codes
    public static final String EVENT_CODE_AUTHORISATION_ADJUSTMENT = "AUTHORISATION_ADJUSTMENT";
    public static final String EVENT_CODE_CANCELLATION = "CANCELLATION";
    public static final String EVENT_CODE_REFUND = "REFUND";
    public static final String EVENT_CODE_CANCEL_OR_REFUND = "CANCEL_OR_REFUND";
    public static final String EVENT_CODE_CAPTURE = "CAPTURE";
    public static final String EVENT_CODE_CAPTURE_FAILED = "CAPTURE_FAILED";
    public static final String EVENT_CODE_REFUND_FAILED = "REFUND_FAILED";
    public static final String EVENT_CODE_REFUND_WITH_DATA = "REFUND_WITH_DATA";
    public static final String EVENT_CODE_REFUNDED_REVERSED = "REFUNDED_REVERSED";
    public static final String EVENT_CODE_HANDLED_EXTERNALLY = "HANDLED_EXTERNALLY";
    public static final String EVENT_CODE_ORDER_OPENED = "ORDER_OPENED";
    public static final String EVENT_CODE_ORDER_CLOSED = "ORDER_CLOSED";
    public static final String EVENT_CODE_PENDING = "PENDING";
    public static final String EVENT_CODE_PROCESS_RETRY = "PROCESS_RETRY";
    public static final String EVENT_CODE_REPORT_AVAILABLE = "REPORT_AVAILABLE";
    public static final String EVENT_CODE_VOID_PENDING_REFUND = "VOID_PENDING_REFUND";

    //Dispute Event Codes
    public static final String EVENT_CODE_CHARGEBACK = "CHARGEBACK";
    public static final String EVENT_CODE_CHARGEBACK_REVERSED = "CHARGEBACK_REVERSED";
    public static final String EVENT_CODE_NOTIFICATION_OF_CHARGEBACK = "NOTIFICATION_OF_CHARGEBACK";
    public static final String EVENT_CODE_NOTIFICATION_OF_FRAUD = "NOTIFICATION_OF_FRAUD";
    public static final String EVENT_CODE_PREARBITRATION_LOST = "PREARBITRATION_LOST";
    public static final String EVENT_CODE_PREARBITRATION_WON = "PREARBITRATION_WON";
    public static final String EVENT_CODE_REQUEST_FOR_INFORMATION = "REQUEST_FOR_INFORMATION";
    public static final String EVENT_CODE_SECOND_CHARGEBACK = "SECOND_CHARGEBACK";

    //Payout Event Codes
    public static final String EVENT_CODE_PAYOUT_EXPIRE = "PAYOUT_EXPIRE";
    public static final String EVENT_CODE_PAYOUT_DECLINE = "PAYOUT_DECLINE";
    public static final String EVENT_CODE_PAYOUT_THIRDPARTY = "PAYOUT_THIRDPARTY";
    public static final String EVENT_CODE_PAIDOUT_REVERSED = "PAIDOUT_REVERSED";

    //Additional Data
    public static final String ADDITIONAL_DATA_TOTAL_FRAUD_SCORE = "totalFraudScore";
    public static final String ADDITIONAL_DATA_FRAUD_CHECK_PATTERN = "fraudCheck-(\\d+)-([A-Za-z0-9]+)";

    //Additional Configuration
    public static final String EVENT_CODE_AUTORESCUE = "AUTORESCUE";
    public static final String EVENT_CODE_CANCEL_AUTORESCUE = "CANCEL_AUTORESCUE";
    public static final String EVENT_CODE_RECURRING_CONTRACT = "RECURRING_CONTRACT";
    public static final String EVENT_CODE_OFFER_CLOSED = "OFFER_CLOSED";
    public static final String EVENT_CODE_MANUAL_REVIEW_ACCEPT = "MANUAL_REVIEW_ACCEPT";
    public static final String EVENT_CODE_MANUAL_REVIEW_REJECT = "MANUAL_REVIEW_REJECT";

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("eventCode")
    private String eventCode = null;

    @SerializedName("eventDate")
    private Date eventDate = null;

    @SerializedName("merchantAccountCode")
    private String merchantAccountCode = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    @SerializedName("originalReference")
    private String originalReference = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("reason")
    private String reason = null;

    @SerializedName("success")
    private boolean success;

    @SerializedName("paymentMethod")
    private String paymentMethod;

    @SerializedName("operations")
    private List<String> operations;

    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    public Amount getAmount() {
        return amount;
    }


    public NotificationRequestItem setAmount(Amount amount) {
        this.amount = amount;
        return this;
    }

    public String getEventCode() {
        return eventCode;
    }

    public NotificationRequestItem setEventCode(String eventCode) {
        this.eventCode = eventCode;
        return this;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public NotificationRequestItem setEventDate(Date eventDate) {
        this.eventDate = eventDate;
        return this;
    }

    public String getMerchantAccountCode() {
        return merchantAccountCode;
    }

    public NotificationRequestItem setMerchantAccountCode(String merchantAccountCode) {
        this.merchantAccountCode = merchantAccountCode;
        return this;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public NotificationRequestItem setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    public String getOriginalReference() {
        return originalReference;
    }

    public NotificationRequestItem setOriginalReference(String originalReference) {
        this.originalReference = originalReference;
        return this;
    }

    public String getPspReference() {
        return pspReference;
    }

    public NotificationRequestItem setPspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    public String getReason() {
        return reason;
    }

    public NotificationRequestItem setReason(String reason) {
        this.reason = reason;
        return this;
    }

    public boolean isSuccess() {
        return success;
    }

    public NotificationRequestItem setSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public NotificationRequestItem setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public List<String> getOperations() {
        return operations;
    }

    public NotificationRequestItem setOperations(List<String> operations) {
        this.operations = operations;
        return this;
    }

    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public NotificationRequestItem setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class NotificationRequestItem {\n");

        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    eventCode: ").append(toIndentedString(eventCode)).append("\n");
        sb.append("    eventDate: ").append(toIndentedString(eventDate)).append("\n");
        sb.append("    merchantAccountCode: ").append(toIndentedString(merchantAccountCode)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    originalReference: ").append(toIndentedString(originalReference)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    success: ").append(toIndentedString(success)).append("\n");
        sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
        sb.append("    operations: ").append(toIndentedString(operations)).append("\n");
        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
