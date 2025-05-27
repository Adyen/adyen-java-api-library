package com.adyen.notification;

import com.adyen.model.managementwebhooks.JSON;
import com.adyen.model.managementwebhooks.MerchantCreatedNotificationRequest;
import com.adyen.model.managementwebhooks.MerchantUpdatedNotificationRequest;
import com.adyen.model.managementwebhooks.PaymentMethodCreatedNotificationRequest;
import com.adyen.model.managementwebhooks.PaymentMethodRequestRemovedNotificationRequest;
import com.adyen.model.managementwebhooks.PaymentMethodScheduledForRemovalNotificationRequest;
import java.util.Optional;

/**
 * DEPRECATED
 *
 * <p>Centralised handler for de-serialising all (Management) webhook payloads.
 *
 * @deprecated Use instead com.adyen.model.managementwebhooks.ManagementWebhookHandler
 */
@Deprecated(since = "v37.0.0", forRemoval = true)
public class ManagementWebhookHandler {
  private final String payload;

  @Deprecated(
      since = "v37.0.0",
      forRemoval = true) // Use instead com.adyen.model.managementwebhooks.ManagementWebhookHandler
  public ManagementWebhookHandler(String payload) {
    this.payload = payload;
  }

  @Deprecated(
      since = "v37.0.0",
      forRemoval = true) // Use instead com.adyen.model.managementwebhooks.ManagementWebhookHandler
  public Optional<MerchantCreatedNotificationRequest> getMerchantCreatedNotificationRequest() {
    return getOptionalField(MerchantCreatedNotificationRequest.class);
  }

  @Deprecated(
      since = "v37.0.0",
      forRemoval = true) // Use instead com.adyen.model.managementwebhooks.ManagementWebhookHandler
  public Optional<MerchantUpdatedNotificationRequest> getMerchantUpdatedNotificationRequest() {
    return getOptionalField(MerchantUpdatedNotificationRequest.class);
  }

  @Deprecated(
      since = "v37.0.0",
      forRemoval = true) // Use instead com.adyen.model.managementwebhooks.ManagementWebhookHandler
  public Optional<PaymentMethodCreatedNotificationRequest>
      getPaymentMethodCreatedNotificationRequest() {
    return getOptionalField(PaymentMethodCreatedNotificationRequest.class);
  }

  @Deprecated(
      since = "v37.0.0",
      forRemoval = true) // Use instead com.adyen.model.managementwebhooks.ManagementWebhookHandler
  public Optional<PaymentMethodRequestRemovedNotificationRequest>
      getPaymentMethodRequestRemovedNotificationRequest() {
    return getOptionalField(PaymentMethodRequestRemovedNotificationRequest.class);
  }

  @Deprecated(
      since = "v37.0.0",
      forRemoval = true) // Use instead com.adyen.model.managementwebhooks.ManagementWebhookHandler
  public Optional<PaymentMethodScheduledForRemovalNotificationRequest>
      getPaymentMethodScheduledForRemovalNotificationRequest() {
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
