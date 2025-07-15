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
package com.adyen.webhooks;

import static org.junit.Assert.assertEquals;

import com.adyen.BaseTest;
import com.adyen.model.tokenizationwebhooks.*;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/** Unit testing for Tokenization webhooks */
public class TokenizationWebhookTest extends BaseTest {

  @Test
  public void testTokenizationAlreadyExistingDetailsNotificationRequest() throws IOException {
    String json =
        getFileContents(
            "mocks/notification/tokenization-webhook-recurring-token-alreadyExisting.json");
    TokenizationWebhooksHandler webhookHandler = new TokenizationWebhooksHandler(json);
    Assert.assertTrue(
        webhookHandler.getTokenizationAlreadyExistingDetailsNotificationRequest().isPresent());

    var request = webhookHandler.getTokenizationAlreadyExistingDetailsNotificationRequest().get();
    assertEquals(
        TokenizationAlreadyExistingDetailsNotificationRequest.TypeEnum
            .RECURRING_TOKEN_ALREADYEXISTING,
        request.getType());
    assertEquals(
        TokenizationAlreadyExistingDetailsNotificationRequest.EnvironmentEnum.TEST,
        request.getEnvironment());

    Assert.assertEquals("YOUR_MERCHANT_ACCOUNT", request.getData().getMerchantAccount());
    Assert.assertEquals("M5N7TQ4TG5PFWR50", request.getData().getStoredPaymentMethodId());
  }

  @Test
  public void testTokenizationCreatedNotificationRequest() throws IOException {
    String json =
        getFileContents("mocks/notification/tokenization-webhook-recurring-token-created.json");
    TokenizationWebhooksHandler webhookHandler = new TokenizationWebhooksHandler(json);
    Assert.assertTrue(
        webhookHandler.getTokenizationCreatedDetailsNotificationRequest().isPresent());

    var request = webhookHandler.getTokenizationCreatedDetailsNotificationRequest().get();
    assertEquals(
        TokenizationCreatedDetailsNotificationRequest.TypeEnum.RECURRING_TOKEN_CREATED,
        request.getType());
    assertEquals(
        TokenizationCreatedDetailsNotificationRequest.EnvironmentEnum.TEST,
        request.getEnvironment());

    Assert.assertEquals("YOUR_MERCHANT_ACCOUNT", request.getData().getMerchantAccount());
    Assert.assertEquals("M5N7TQ4TG5PFWR50", request.getData().getStoredPaymentMethodId());
  }

  @Test
  public void testTokenizationDisabledNotificationRequest() throws IOException {
    String json =
        getFileContents("mocks/notification/tokenization-webhook-recurring-token-disabled.json");
    TokenizationWebhooksHandler webhookHandler = new TokenizationWebhooksHandler(json);
    Assert.assertTrue(
        webhookHandler.getTokenizationDisabledDetailsNotificationRequest().isPresent());

    var request = webhookHandler.getTokenizationDisabledDetailsNotificationRequest().get();
    assertEquals(
        TokenizationDisabledDetailsNotificationRequest.TypeEnum.RECURRING_TOKEN_DISABLED,
        request.getType());
    assertEquals(
        TokenizationDisabledDetailsNotificationRequest.EnvironmentEnum.TEST,
        request.getEnvironment());

    Assert.assertEquals("YOUR_MERCHANT_ACCOUNT", request.getData().getMerchantAccount());
    Assert.assertEquals("M5N7TQ4TG5PFWR50", request.getData().getStoredPaymentMethodId());
  }

  @Test
  public void testTokenizationUpdatedNotificationRequest() throws IOException {
    String json =
        getFileContents("mocks/notification/tokenization-webhook-recurring-token-updated.json");
    TokenizationWebhooksHandler webhookHandler = new TokenizationWebhooksHandler(json);
    Assert.assertTrue(
        webhookHandler.getTokenizationUpdatedDetailsNotificationRequest().isPresent());

    var request = webhookHandler.getTokenizationUpdatedDetailsNotificationRequest().get();
    assertEquals(
        TokenizationUpdatedDetailsNotificationRequest.TypeEnum.RECURRING_TOKEN_UPDATED,
        request.getType());
    assertEquals(
        TokenizationUpdatedDetailsNotificationRequest.EnvironmentEnum.TEST,
        request.getEnvironment());

    Assert.assertEquals("YOUR_MERCHANT_ACCOUNT", request.getData().getMerchantAccount());
    Assert.assertEquals("M5N7TQ4TG5PFWR50", request.getData().getStoredPaymentMethodId());
  }
}
