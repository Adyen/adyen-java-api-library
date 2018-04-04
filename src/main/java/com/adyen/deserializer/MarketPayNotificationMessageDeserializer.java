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

package com.adyen.deserializer;

import java.lang.reflect.Type;
import com.adyen.model.marketpay.notification.AccountCreatedNotification;
import com.adyen.model.marketpay.notification.AccountHolderCreatedNotification;
import com.adyen.model.marketpay.notification.AccountHolderLimitReachedNotification;
import com.adyen.model.marketpay.notification.AccountHolderPayoutNotification;
import com.adyen.model.marketpay.notification.AccountHolderStatusChangeNotification;
import com.adyen.model.marketpay.notification.AccountHolderUpdatedNotification;
import com.adyen.model.marketpay.notification.AccountHolderVerificationNotification;
import com.adyen.model.marketpay.notification.BeneficiarySetupNotification;
import com.adyen.model.marketpay.notification.CompensateNegativeBalanceNotification;
import com.adyen.model.marketpay.notification.GenericNotification;
import com.adyen.model.marketpay.notification.PaymentFailureNotification;
import com.adyen.model.marketpay.notification.ReportAvailableNotification;
import com.adyen.model.marketpay.notification.ScheduledRefundsNotification;
import com.adyen.model.marketpay.notification.TransferFundsNotification;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class MarketPayNotificationMessageDeserializer implements JsonDeserializer<GenericNotification> {
    @Override
    public GenericNotification deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        JsonElement jsonType = jsonObject.get("eventType");
        String eventType = jsonType.getAsString();

        if (GenericNotification.EventTypeEnum.ACCOUNT_CREATED.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountCreatedNotification.class);
        }
        if (GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_CREATED.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderCreatedNotification.class);
        }
        if (GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_LIMIT_REACHED.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderLimitReachedNotification.class);
        }
        if (GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_VERIFICATION.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderVerificationNotification.class);
        }
        if (GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_STATUS_CHANGE.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderStatusChangeNotification.class);
        }
        if (GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_PAYOUT.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderPayoutNotification.class);
        }
        if (GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_UPDATED.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, AccountHolderUpdatedNotification.class);
        }
        if (GenericNotification.EventTypeEnum.BENEFICIARY_SETUP.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, BeneficiarySetupNotification.class);
        }
        if (GenericNotification.EventTypeEnum.SCHEDULED_REFUNDS.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, ScheduledRefundsNotification.class);
        }
        if (GenericNotification.EventTypeEnum.COMPENSATE_NEGATIVE_BALANCE.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, CompensateNegativeBalanceNotification.class);
        }
        if (GenericNotification.EventTypeEnum.PAYMENT_FAILURE.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, PaymentFailureNotification.class);
        }
        if (GenericNotification.EventTypeEnum.REPORT_AVAILABLE.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, ReportAvailableNotification.class);
        }
        if (GenericNotification.EventTypeEnum.TRANSFER_FUNDS.toString().equalsIgnoreCase(eventType)) {
            return jsonDeserializationContext.deserialize(jsonElement, TransferFundsNotification.class);
        }

        return jsonDeserializationContext.deserialize(jsonElement, GenericNotification.class);
    }
}
