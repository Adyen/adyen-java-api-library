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

import com.adyen.model.checkout.PaymentCompletionDetails;
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
import com.adyen.model.marketpay.notification.GenericNotification;
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
import java.util.HashMap;
import java.util.Map;

public class MarketPayNotificationMessageDeserializer implements JsonDeserializer<GenericNotification> {

    private static final Map<String, Class<? extends GenericNotification>> notificationTypeToClass = new HashMap<>();
    static {
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.ACCOUNT_CREATED.toString(), AccountCreateNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.ACCOUNT_CLOSED.toString(), AccountCloseNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.ACCOUNT_UPDATED.toString(), AccountUpdateNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.ACCOUNT_FUNDS_BELOW_THRESHOLD.toString(), AccountFundsBelowThresholdNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_CREATED.toString(), AccountHolderCreateNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_VERIFICATION.toString(), AccountHolderVerificationNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_STATUS_CHANGE.toString(), AccountHolderStatusChangeNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_PAYOUT.toString(), AccountHolderPayoutNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_UPDATED.toString(), AccountHolderUpdateNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_STORE_STATUS_CHANGE.toString(), AccountHolderStoreStatusChangeNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_UPCOMING_DEADLINE.toString(), AccountHolderUpcomingDeadlineNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.BENEFICIARY_SETUP.toString(), BeneficiarySetupNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.SCHEDULED_REFUNDS.toString(), ScheduledRefundsNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.COMPENSATE_NEGATIVE_BALANCE.toString(), CompensateNegativeBalanceNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.PAYMENT_FAILURE.toString(), PaymentFailureNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.REPORT_AVAILABLE.toString(), ReportAvailableNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.TRANSFER_FUNDS.toString(), TransferFundsNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.DIRECT_DEBIT_INITIATED.toString(), DirectDebitInitiatedNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.PAYOUT_CONFIRMED.toString(), AccountHolderPayoutNotification.class);
        notificationTypeToClass.put(GenericNotification.EventTypeEnum.REFUND_FUNDS_TRANSFER.toString(), RefundFundsTransferNotification.class);
    }

    @Override
    public GenericNotification deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        JsonElement jsonType = jsonObject.get("eventType");
        String eventType = jsonType.getAsString();

        Class<? extends GenericNotification> notificationClass = notificationTypeToClass.get(eventType);
        if (notificationClass != null) {
            return jsonDeserializationContext.deserialize(jsonElement, notificationClass);
        }

        return null;
    }
}