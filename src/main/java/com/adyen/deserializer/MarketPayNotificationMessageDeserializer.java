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

package com.adyen.deserializer;

import com.adyen.model.marketpay.notification.AccountCloseNotification;
import com.adyen.model.marketpay.notification.AccountCreateNotification;
import com.adyen.model.marketpay.notification.AccountFundsBelowThresholdNotification;
import com.adyen.model.marketpay.notification.AccountHolderCreateNotification;
import com.adyen.model.marketpay.notification.AccountHolderPayoutNotification;
import com.adyen.model.marketpay.notification.AccountHolderStatusChangeNotification;
import com.adyen.model.marketpay.notification.AccountHolderStoreStatusChangeNotification;
import com.adyen.model.marketpay.notification.AccountHolderUpcomingDeadlineNotification;
import com.adyen.model.marketpay.notification.AccountHolderUpdateNotification;
import com.adyen.model.marketpay.notification.AccountHolderVerificationNotification;
import com.adyen.model.marketpay.notification.AccountUpdateNotification;
import com.adyen.model.marketpay.notification.BeneficiarySetupNotification;
import com.adyen.model.marketpay.notification.CompensateNegativeBalanceNotification;
import com.adyen.model.marketpay.notification.DirectDebitInitiatedNotification;
import com.adyen.model.marketpay.notification.GenericWebhook;
import com.adyen.model.marketpay.notification.PaymentFailureNotification;
import com.adyen.model.marketpay.notification.RefundFundsTransferNotification;
import com.adyen.model.marketpay.notification.ReportAvailableNotification;
import com.adyen.model.marketpay.notification.ScheduledRefundsNotification;
import com.adyen.model.marketpay.notification.TransferFundsNotification;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

public class MarketPayNotificationMessageDeserializer implements JsonDeserializer<GenericWebhook> {
    @Override
    public GenericWebhook deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonElement jsonType = jsonObject.get("eventType");
        String eventType = jsonType.getAsString();

        if (GenericWebhook.EventTypeEnum.ACCOUNT_CREATED.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountCreateNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.ACCOUNT_CLOSED.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountCloseNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.ACCOUNT_UPDATED.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountUpdateNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.ACCOUNT_FUNDS_BELOW_THRESHOLD.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountFundsBelowThresholdNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.ACCOUNT_HOLDER_CREATED.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderCreateNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.ACCOUNT_HOLDER_VERIFICATION.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderVerificationNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.ACCOUNT_HOLDER_STATUS_CHANGE.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderStatusChangeNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.ACCOUNT_HOLDER_PAYOUT.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderPayoutNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.ACCOUNT_HOLDER_UPDATED.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderUpdateNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.ACCOUNT_HOLDER_STORE_STATUS_CHANGE.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderStoreStatusChangeNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.ACCOUNT_HOLDER_UPCOMING_DEADLINE.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderUpcomingDeadlineNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.BENEFICIARY_SETUP.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, BeneficiarySetupNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.SCHEDULED_REFUNDS.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, ScheduledRefundsNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.COMPENSATE_NEGATIVE_BALANCE.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, CompensateNegativeBalanceNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.PAYMENT_FAILURE.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, PaymentFailureNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.REPORT_AVAILABLE.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, ReportAvailableNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.TRANSFER_FUNDS.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, TransferFundsNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.DIRECT_DEBIT_INITIATED.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, DirectDebitInitiatedNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.PAYOUT_CONFIRMED.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderPayoutNotification.class);
        }
        if (GenericWebhook.EventTypeEnum.REFUND_FUNDS_TRANSFER.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, RefundFundsTransferNotification.class);
        }
        return jsonDeserializationContext.deserialize(jsonElement, GenericWebhook.class);
    }
}
