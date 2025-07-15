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

import com.adyen.BaseTest;
import com.adyen.model.managementwebhooks.*;
import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;

/** Unit testing for Management webhooks */
public class ManagementWebhookTest extends BaseTest {

  @Test
  public void testManagementWebhookPaymentMethodCreatedParsing() throws IOException {
    String json =
        getFileContents("mocks/notification/management-webhook-payment-method-created.json");
    ManagementWebhooksHandler webhookHandler = new ManagementWebhooksHandler(json);
    Assert.assertTrue(webhookHandler.getPaymentMethodCreatedNotificationRequest().isPresent());
    PaymentMethodCreatedNotificationRequest request =
        webhookHandler.getPaymentMethodCreatedNotificationRequest().get();
    Assert.assertEquals("PM1234567890000000", request.getData().getId());
    Assert.assertEquals(
        PaymentMethodCreatedNotificationRequest.TypeEnum.PAYMENTMETHOD_CREATED, request.getType());
    Assert.assertEquals(
        MidServiceNotificationData.StatusEnum.SUCCESS, request.getData().getStatus());
  }

  @Test
  public void testManagementWebhookPaymentMethodCreatedParsingWithUnknownEnum() throws IOException {
    String json =
        getFileContents(
            "mocks/notification/management-webhook-payment-method-created-unknown-enum.json");
    ManagementWebhooksHandler webhookHandler = new ManagementWebhooksHandler(json);
    Assert.assertTrue(webhookHandler.getPaymentMethodCreatedNotificationRequest().isPresent());
    PaymentMethodCreatedNotificationRequest request =
        webhookHandler.getPaymentMethodCreatedNotificationRequest().get();
    Assert.assertEquals("PM1234567890000000", request.getData().getId());
    Assert.assertEquals(
        PaymentMethodCreatedNotificationRequest.TypeEnum.PAYMENTMETHOD_CREATED, request.getType());
    Assert.assertNull(request.getData().getStatus());
  }

  @Test
  public void testManagementWebhookMerchantUpdatedParsing() {
    String notification =
        "{\n"
            + "   \"type\": \"merchant.updated\",\n"
            + "   \"environment\": \"test\",\n"
            + "   \"createdAt\": \"2022-09-20T13:42:31+02:00\",\n"
            + "   \"data\": {\n"
            + "      \"capabilities\": {\n"
            + "         \"receivePayments\": {\n"
            + "            \"allowed\": true,\n"
            + "            \"requested\": true,\n"
            + "            \"requestedLevel\": \"notApplicable\",\n"
            + "            \"verificationStatus\": \"valid\"\n"
            + "         }\n"
            + "      },\n"
            + "      \"legalEntityId\": \"LE322KH223222F5GNNW694PZN\",\n"
            + "      \"merchantId\": \"YOUR_MERCHANT_ID\",\n"
            + "      \"status\": \"PreActive\"\n"
            + "   }\n"
            + "}";
    ManagementWebhooksHandler webhookHandler = new ManagementWebhooksHandler(notification);
    Assert.assertTrue(webhookHandler.getMerchantUpdatedNotificationRequest().isPresent());
    MerchantUpdatedNotificationRequest request =
        webhookHandler.getMerchantUpdatedNotificationRequest().get();
    Assert.assertEquals("LE322KH223222F5GNNW694PZN", request.getData().getLegalEntityId());
    Assert.assertEquals(
        MerchantUpdatedNotificationRequest.TypeEnum.MERCHANT_UPDATED, request.getType());
  }

  @Test
  public void testManagementWebhookMerchantCreatedParsing() {
    String notification =
        "{\n"
            + "   \"type\": \"merchant.created\",\n"
            + "   \"environment\": \"test\",\n"
            + "   \"createdAt\": \"2022-08-12T10:50:01+02:00\",\n"
            + "   \"data\": {\n"
            + "      \"capabilities\": {\n"
            + "         \"sendToTransferInstrument\": {\n"
            + "            \"requested\": true,\n"
            + "            \"requestedLevel\": \"notApplicable\"\n"
            + "         }\n"
            + "      },\n"
            + "      \"companyId\": \"YOUR_COMPANY_ID\",\n"
            + "      \"merchantId\": \"MC3224X22322535GH8D537TJR\",\n"
            + "      \"status\": \"PreActive\"\n"
            + "   }\n"
            + "}";
    ManagementWebhooksHandler webhookHandler = new ManagementWebhooksHandler(notification);
    Assert.assertTrue(webhookHandler.getMerchantCreatedNotificationRequest().isPresent());
    MerchantCreatedNotificationRequest request =
        webhookHandler.getMerchantCreatedNotificationRequest().get();
    Assert.assertEquals("MC3224X22322535GH8D537TJR", request.getData().getMerchantId());
    Assert.assertEquals(
        MerchantCreatedNotificationRequest.TypeEnum.MERCHANT_CREATED, request.getType());
  }
}
