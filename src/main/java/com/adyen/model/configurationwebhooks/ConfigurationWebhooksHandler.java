/*
 * Configuration webhooks
 *
 * The version of the OpenAPI document: 2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.configurationwebhooks;

import java.util.Optional;
import java.util.logging.Logger;

/**
 * Handler for processing ConfigurationWebhooks.
 *
 * <p>This class provides functionality to deserialize the payload of ConfigurationWebhooks events.
 */
public class ConfigurationWebhooksHandler {

  private static final Logger LOG = Logger.getLogger(ConfigurationWebhooksHandler.class.getName());

  private final String payload;

  /**
   * Constructs a new handler for the given webhook payload
   *
   * @param payload the raw JSON payload from the webhook
   */
  public ConfigurationWebhooksHandler(String payload) {
    this.payload = payload;
  }

  /**
   * Attempts to deserialize the webhook payload into a AccountHolderNotificationRequest
   *
   * @return an Optional containing the deserialized object, or empty if deserialization fails
   */
  public Optional<AccountHolderNotificationRequest> getAccountHolderNotificationRequest() {
    return getOptionalField(AccountHolderNotificationRequest.class);
  }

  /**
   * Attempts to deserialize the webhook payload into a BalanceAccountNotificationRequest
   *
   * @return an Optional containing the deserialized object, or empty if deserialization fails
   */
  public Optional<BalanceAccountNotificationRequest> getBalanceAccountNotificationRequest() {
    return getOptionalField(BalanceAccountNotificationRequest.class);
  }

  /**
   * Attempts to deserialize the webhook payload into a CardOrderNotificationRequest
   *
   * @return an Optional containing the deserialized object, or empty if deserialization fails
   */
  public Optional<CardOrderNotificationRequest> getCardOrderNotificationRequest() {
    return getOptionalField(CardOrderNotificationRequest.class);
  }

  /**
   * Attempts to deserialize the webhook payload into a NetworkTokenNotificationRequest
   *
   * @return an Optional containing the deserialized object, or empty if deserialization fails
   */
  public Optional<NetworkTokenNotificationRequest> getNetworkTokenNotificationRequest() {
    return getOptionalField(NetworkTokenNotificationRequest.class);
  }

  /**
   * Attempts to deserialize the webhook payload into a PaymentNotificationRequest
   *
   * @return an Optional containing the deserialized object, or empty if deserialization fails
   */
  public Optional<PaymentNotificationRequest> getPaymentNotificationRequest() {
    return getOptionalField(PaymentNotificationRequest.class);
  }

  /**
   * Attempts to deserialize the webhook payload into a SweepConfigurationNotificationRequest
   *
   * @return an Optional containing the deserialized object, or empty if deserialization fails
   */
  public Optional<SweepConfigurationNotificationRequest>
      getSweepConfigurationNotificationRequest() {
    return getOptionalField(SweepConfigurationNotificationRequest.class);
  }

  /**
   * Deserializes the payload into the specified class type.
   *
   * @param clazz the class to deserialize into
   * @param <T> the type of the class
   * @return an Optional containing the deserialized object, or empty if an error occurs
   */
  private <T> Optional<T> getOptionalField(Class<T> clazz) {
    try {
      T val = JSON.getMapper().readValue(payload, clazz);
      return Optional.ofNullable(val);
    } catch (Exception e) {
      // an error has occurred during deserialization (object not found, deserialization error)
      LOG.warning("Object not found or unexpected error trying to access:  " + clazz.getName());
      LOG.warning("Deserialization error: " + e.getMessage());
      return Optional.empty();
    }
  }
}
