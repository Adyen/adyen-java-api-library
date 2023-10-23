package com.adyen.notification;

import com.adyen.model.managementwebhooks.MerchantCreatedNotificationRequest;
import com.adyen.model.managementwebhooks.MerchantUpdatedNotificationRequest;
import com.adyen.model.managementwebhooks.PaymentMethodCreatedNotificationRequest;
import com.adyen.model.managementwebhooks.PaymentMethodRequestRemovedNotificationRequest;
import com.adyen.model.managementwebhooks.PaymentMethodScheduledForRemovalNotificationRequest;
import com.adyen.model.managementwebhooks.JSON;

import java.util.Optional;

public class ManagementWebhookHandler {
    private final String payload;

    public ManagementWebhookHandler(String payload) {
        this.payload = payload;
    }

    public Optional<MerchantCreatedNotificationRequest> getMerchantCreatedNotificationRequest() {
        return getOptionalField(MerchantCreatedNotificationRequest.class);
    }
    public Optional<MerchantUpdatedNotificationRequest> getMerchantUpdatedNotificationRequest() {
        return getOptionalField(MerchantUpdatedNotificationRequest.class);
    }

    public Optional<PaymentMethodCreatedNotificationRequest> getPaymentMethodCreatedNotificationRequest() {
        return getOptionalField(PaymentMethodCreatedNotificationRequest.class);
    }

    public Optional<PaymentMethodRequestRemovedNotificationRequest> getPaymentMethodRequestRemovedNotificationRequest() {
        return getOptionalField(PaymentMethodRequestRemovedNotificationRequest.class);
    }

    public Optional<PaymentMethodScheduledForRemovalNotificationRequest> getPaymentMethodScheduledForRemovalNotificationRequest() {
        return getOptionalField(PaymentMethodScheduledForRemovalNotificationRequest.class);
    }

    private <T> Optional<T> getOptionalField(Class<T> clazz) {
        try {
            T val = JSON.getMapper().readValue(payload, clazz);
            return Optional.ofNullable(val);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
