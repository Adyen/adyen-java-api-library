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
package com.adyen;

import static org.junit.Assert.*;

import com.adyen.model.managementwebhooks.ManagementWebhooksHandler;
import com.adyen.model.managementwebhooks.MerchantCreatedNotificationRequest;
import com.adyen.model.managementwebhooks.MerchantUpdatedNotificationRequest;
import com.adyen.model.managementwebhooks.PaymentMethodCreatedNotificationRequest;
import com.adyen.model.marketpaywebhooks.AccountHolderCreateNotification;
import com.adyen.model.nexo.DeviceType;
import com.adyen.model.nexo.DisplayOutput;
import com.adyen.model.nexo.EventNotification;
import com.adyen.model.nexo.EventToNotifyType;
import com.adyen.model.nexo.InfoQualifyType;
import com.adyen.model.notification.NotificationRequest;
import com.adyen.model.notification.NotificationRequestItem;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.notification.ClassicPlatformWebhookHandler;
import com.adyen.notification.WebhookHandler;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.JsonParser;
import java.io.IOException;
import java.security.SignatureException;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/** Tests notification messages */
public class WebhookTest extends BaseTest {

  private WebhookHandler webhookHandler;

  @Before
  public void init() {
    webhookHandler = new WebhookHandler();
  }

  @Test
  public void testAuthorisationSuccess() throws Exception {
    NotificationRequest notificationRequest =
        readNotificationRequestFromFile("mocks/notification/authorisation-true.json");

    assertEquals(1, notificationRequest.getNotificationItems().size());

    NotificationRequestItem notificationRequestItem =
        notificationRequest.getNotificationItems().get(0);
    assertEquals(
        NotificationRequestItem.EVENT_CODE_AUTHORISATION, notificationRequestItem.getEventCode());
    assertTrue(notificationRequestItem.isSuccess());
    assertEquals("123456789", notificationRequestItem.getPspReference());
  }

  @Test
  public void testCaptureSuccess() throws Exception {
    NotificationRequest notificationRequest =
        readNotificationRequestFromFile("mocks/notification/capture-true.json");

    assertEquals(1, notificationRequest.getNotificationItems().size());

    NotificationRequestItem notificationRequestItem =
        notificationRequest.getNotificationItems().get(0);
    assertEquals(
        NotificationRequestItem.EVENT_CODE_CAPTURE, notificationRequestItem.getEventCode());
    assertTrue(notificationRequestItem.isSuccess());
    assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
    assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
  }

  @Test
  public void testCaptureFail() throws Exception {
    NotificationRequest notificationRequest =
        readNotificationRequestFromFile("mocks/notification/capture-false.json");

    assertEquals(1, notificationRequest.getNotificationItems().size());

    NotificationRequestItem notificationRequestItem =
        notificationRequest.getNotificationItems().get(0);
    assertEquals(
        NotificationRequestItem.EVENT_CODE_CAPTURE, notificationRequestItem.getEventCode());
    assertFalse(notificationRequestItem.isSuccess());
    assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
    assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
  }

  @Test
  public void testRefundSuccess() throws Exception {
    NotificationRequest notificationRequest =
        readNotificationRequestFromFile("mocks/notification/refund-true.json");

    assertEquals(1, notificationRequest.getNotificationItems().size());

    NotificationRequestItem notificationRequestItem =
        notificationRequest.getNotificationItems().get(0);
    assertEquals(NotificationRequestItem.EVENT_CODE_REFUND, notificationRequestItem.getEventCode());
    assertTrue(notificationRequestItem.isSuccess());
    assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
    assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
    assertNotNull(notificationRequestItem.getEventDate());
  }

  @Test
  public void testRefundFail() throws Exception {
    NotificationRequest notificationRequest =
        readNotificationRequestFromFile("mocks/notification/refund-false.json");

    assertEquals(1, notificationRequest.getNotificationItems().size());

    NotificationRequestItem notificationRequestItem =
        notificationRequest.getNotificationItems().get(0);
    assertEquals(NotificationRequestItem.EVENT_CODE_REFUND, notificationRequestItem.getEventCode());
    assertFalse(notificationRequestItem.isSuccess());
    assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
    assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
    assertNotNull(notificationRequestItem.getEventDate());
  }

  @Test
  public void testChargeback() throws Exception {
    NotificationRequest notificationRequest =
        readNotificationRequestFromFile("mocks/notification/chargeback.json");

    assertEquals(1, notificationRequest.getNotificationItems().size());

    NotificationRequestItem notificationRequestItem =
        notificationRequest.getNotificationItems().get(0);
    assertEquals(
        NotificationRequestItem.EVENT_CODE_CHARGEBACK, notificationRequestItem.getEventCode());
    assertTrue(notificationRequestItem.isSuccess());
    assertEquals("9915555555555555", notificationRequestItem.getPspReference());
    assertEquals("9913333333333333", notificationRequestItem.getOriginalReference());
    assertNotNull(notificationRequestItem.getAmount());
    assertEquals("EUR", notificationRequestItem.getAmount().getCurrency());
    assertEquals(Long.valueOf(1000), notificationRequestItem.getAmount().getValue());

    assertNotNull(notificationRequestItem.getEventDate());
  }

  @Test
  public void testAuthorisationAdjustmentTrue() throws Exception {
    NotificationRequest notificationRequest =
        readNotificationRequestFromFile("mocks/notification/chargeback.json");

    assertEquals(1, notificationRequest.getNotificationItems().size());

    NotificationRequestItem notificationRequestItem =
        notificationRequest.getNotificationItems().get(0);
    assertEquals(
        NotificationRequestItem.EVENT_CODE_CHARGEBACK, notificationRequestItem.getEventCode());
    assertTrue(notificationRequestItem.isSuccess());
    assertEquals("9915555555555555", notificationRequestItem.getPspReference());
    assertEquals("9913333333333333", notificationRequestItem.getOriginalReference());
    assertNotNull(notificationRequestItem.getAmount());
    assertEquals("EUR", notificationRequestItem.getAmount().getCurrency());
    assertEquals(Long.valueOf(1000), notificationRequestItem.getAmount().getValue());

    assertNotNull(notificationRequestItem.getEventDate());
  }

  @Test
  public void testCancellationTrue() throws Exception {
    NotificationRequest notificationRequest =
        readNotificationRequestFromFile("mocks/notification/cancellation-true.json");

    assertEquals(1, notificationRequest.getNotificationItems().size());

    NotificationRequestItem notificationRequestItem =
        notificationRequest.getNotificationItems().get(0);
    assertEquals(
        NotificationRequestItem.EVENT_CODE_CANCELLATION, notificationRequestItem.getEventCode());
    assertTrue(notificationRequestItem.isSuccess());
    assertEquals("8412534564722331", notificationRequestItem.getPspReference());
    assertEquals("8313547924770610", notificationRequestItem.getOriginalReference());
    assertNotNull(notificationRequestItem.getAmount());
    assertEquals("EUR", notificationRequestItem.getAmount().getCurrency());
    assertEquals(Long.valueOf(500), notificationRequestItem.getAmount().getValue());

    assertNotNull(notificationRequestItem.getEventDate());
  }

  @Test
  public void testOfferClosed() throws Exception {
    NotificationRequest notificationRequest =
        readNotificationRequestFromFile("mocks/notification/offer-closed.json");

    assertEquals(1, notificationRequest.getNotificationItems().size());

    NotificationRequestItem notificationRequestItem =
        notificationRequest.getNotificationItems().get(0);
    assertEquals(
        NotificationRequestItem.EVENT_CODE_OFFER_CLOSED, notificationRequestItem.getEventCode());
    assertTrue(notificationRequestItem.isSuccess());
    assertEquals("8532565401975321", notificationRequestItem.getPspReference());
    assertEquals("ideal", notificationRequestItem.getPaymentMethod());
    assertNotNull(notificationRequestItem.getAmount());
    assertEquals("EUR", notificationRequestItem.getAmount().getCurrency());
    assertEquals(Long.valueOf(27211), notificationRequestItem.getAmount().getValue());

    assertNotNull(notificationRequestItem.getEventDate());
  }

  @Test
  public void testTerminalDisplayNotification() throws Exception {
    String json = getFileContents("mocks/notification/display-notification.json");
    TerminalAPIRequest notification = webhookHandler.handleTerminalNotificationJson(json);
    DisplayOutput displayOutput =
        notification.getSaleToPOIRequest().getDisplayRequest().getDisplayOutput().get(0);

    assertEquals(InfoQualifyType.STATUS, displayOutput.getInfoQualify());
    assertEquals(DeviceType.CASHIER_DISPLAY, displayOutput.getDevice());
    assertEquals(false, displayOutput.isResponseRequiredFlag());
  }

  @Test
  public void testTerminalEventNotification() throws Exception {
    String json = getFileContents("mocks/notification/event-notification.json");
    TerminalAPIRequest notification = webhookHandler.handleTerminalNotificationJson(json);
    EventNotification eventNotification = notification.getSaleToPOIRequest().getEventNotification();

    assertEquals("newstate=IDLE&oldstate=START", eventNotification.getEventDetails());
    assertEquals(EventToNotifyType.SHUTDOWN, eventNotification.getEventToNotify());
  }

  @Test
  public void testSetNotificationItem() throws Exception {
    NotificationRequest notificationRequest =
        readNotificationRequestFromFile("mocks/notification/authorisation-true.json");
    assertEquals("123456789", notificationRequest.getNotificationItems().get(0).getPspReference());
    NotificationRequestItem requestItem = new NotificationRequestItem();
    requestItem.setPspReference("987654321");
    ArrayList<NotificationRequestItem> notificationRequestItems =
        new ArrayList<NotificationRequestItem>();
    notificationRequestItems.add(requestItem);
    notificationRequest.setNotificationItems(notificationRequestItems);

    assertEquals(1, notificationRequest.getNotificationItems().size());
    assertEquals("987654321", notificationRequest.getNotificationItems().get(0).getPspReference());
  }

  private void assertJsonStringEquals(String firstInput, String secondInput) {
    JsonParser parser = new JsonParser();
    assertEquals(parser.parse(firstInput), parser.parse(secondInput));
  }

  private NotificationRequest readNotificationRequestFromFile(String resourcePath)
      throws IOException {
    String json = getFileContents(resourcePath);
    return webhookHandler.handleNotificationJson(json);
  }

  @Test
  public void testDonationWebhookJackson() throws SignatureException, IOException {
    String notification =
        "{\n"
            + "  \"live\": \"false\",\n"
            + "  \"notificationItems\": [\n"
            + "    {\n"
            + "      \"NotificationRequestItem\": {\n"
            + "        \"additionalData\": { \"originalMerchantAccountCode\": \"LengrandECOM\" },\n"
            + "        \"amount\": { \"currency\": \"EUR\", \"value\": 500 },\n"
            + "        \"eventCode\": \"DONATION\",\n"
            + "        \"eventDate\": \"2023-08-22T15:05:06+02:00\",\n"
            + "        \"merchantAccountCode\": \"MyCharity_Giving_TEST\",\n"
            + "        \"merchantReference\": \"9035b75a-e733-4247-a6f3-cda4c480db3d\",\n"
            + "        \"originalReference\": \"WJZ75L2RPV5X8N82\",\n"
            + "        \"paymentMethod\": \"mc\",\n"
            + "        \"pspReference\": \"FGLQR59BM3RZNN82\",\n"
            + "        \"reason\": \"062791:1115:03/2030\",\n"
            + "        \"success\": \"true\"\n"
            + "      }\n"
            + "    }\n"
            + "  ]\n"
            + "}";
    WebhookHandler webhookHolder = new WebhookHandler();
    NotificationRequest notificationRequest =
        webhookHolder.handleNotificationJsonJackson(notification);
    Assert.assertEquals(
        "EUR",
        notificationRequest
            .getNotificationItemContainers()
            .get(0)
            .getNotificationItem()
            .getAmount()
            .getCurrency());
    Assert.assertEquals(
        "LengrandECOM",
        notificationRequest
            .getNotificationItemContainers()
            .get(0)
            .getNotificationItem()
            .getAdditionalData()
            .get("originalMerchantAccountCode"));
  }

  @Test
  public void testManagementWebhookPaymentMethodCreatedParsing() {
    String notification =
        "{\n"
            + "  \"createdAt\": \"2022-01-24T14:59:11+01:00\",\n"
            + "  \"data\": {\n"
            + "    \"id\": \"PM3224R223224K5FH4M2K9B86\",\n"
            + "    \"merchantId\": \"MERCHANT_ACCOUNT\",\n"
            + "    \"result\": \"SUCCESS\",\n"
            + "    \"storeId\": \"ST322LJ223223K5F4SQNR9XL5\",\n"
            + "    \"type\": \"visa\"\n"
            + "  },\n"
            + "  \"environment\": \"test\",\n"
            + "  \"type\": \"paymentMethod.created\"\n"
            + "}";
    ManagementWebhooksHandler webhookHandler = new ManagementWebhooksHandler(notification);
    Assert.assertTrue(webhookHandler.getPaymentMethodCreatedNotificationRequest().isPresent());
    PaymentMethodCreatedNotificationRequest request =
        webhookHandler.getPaymentMethodCreatedNotificationRequest().get();
    Assert.assertEquals("PM3224R223224K5FH4M2K9B86", request.getData().getId());
    Assert.assertEquals(
        PaymentMethodCreatedNotificationRequest.TypeEnum.PAYMENTMETHOD_CREATED, request.getType());
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

  @Test
  public void testClassicPlatformParsing() throws JsonProcessingException {
    String notification =
        "{\n"
            + "  \"error\": {\n"
            + "    \"errorCode\": \"000\",\n"
            + "    \"message\": \"test error message\"\n"
            + "  },\n"
            + "  \"eventDate\": \"2019-01-02T01:00:00+01:00\",\n"
            + "  \"eventType\": \"ACCOUNT_HOLDER_CREATED\",\n"
            + "  \"executingUserKey\": \"executing-user-key\",\n"
            + "  \"live\": false,\n"
            + "  \"pspReference\": \"TSTPSPR0001\",\n"
            + "  \"content\": {\n"
            + "    \"invalidFields\": [\n"
            + "      {\n"
            + "        \"errorCode\": 1,\n"
            + "        \"errorDescription\": \"Field is missing\",\n"
            + "        \"fieldType\": {\n"
            + "          \"field\": \"AccountHolderDetails.BusinessDetails.Shareholders.unknown\",\n"
            + "          \"fieldName\": \"unknown\",\n"
            + "          \"shareholderCode\": \"SH00001\"\n"
            + "        }\n"
            + "      }\n"
            + "    ],\n"
            + "    \"pspReference\": \"TSTPSPR0001\",\n"
            + "    \"resultCode\": \"Success\",\n"
            + "    \"accountCode\": \"AC0000000001\",\n"
            + "    \"accountHolderCode\": \"AHC00000001\",\n"
            + "    \"accountHolderDetails\": {\n"
            + "      \"address\": {\n"
            + "        \"city\": \"Amsterdam\",\n"
            + "        \"country\": \"NL\",\n"
            + "        \"houseNumberOrName\": \"96/A\",\n"
            + "        \"postalCode\": \"1000AA\",\n"
            + "        \"stateOrProvince\": \"NH\",\n"
            + "        \"street\": \"Street\"\n"
            + "      },\n"
            + "      \"bankAccountDetails\": [\n"
            + "        {\n"
            + "          \"accountNumber\": \"00000000\",\n"
            + "          \"accountType\": \"checking\",\n"
            + "          \"bankAccountName\": \"Account name\",\n"
            + "          \"bankAccountReference\": \"Ref#000001\",\n"
            + "          \"bankAccountUUID\": \"00000000-0000-0000-0000-000000000000\",\n"
            + "          \"bankBicSwift\": \"BSWFT\",\n"
            + "          \"bankCity\": \"Amsterdam\",\n"
            + "          \"bankCode\": \"00000000\",\n"
            + "          \"bankName\": \"Bank Name Co\",\n"
            + "          \"branchCode\": \"00000000\",\n"
            + "          \"checkCode\": \"1234\",\n"
            + "          \"countryCode\": \"NL\",\n"
            + "          \"currencyCode\": \"EUR\",\n"
            + "          \"iban\": \"NL00NONE1234123412\",\n"
            + "          \"ownerCity\": \"Amsterdam\",\n"
            + "          \"ownerCountryCode\": \"NL\",\n"
            + "          \"ownerDateOfBirth\": \"1981-02-27\",\n"
            + "          \"ownerHouseNumberOrName\": \"32/B\",\n"
            + "          \"ownerName\": \"Owner Name\",\n"
            + "          \"ownerNationality\": \"NL\",\n"
            + "          \"ownerPostalCode\": \"1000AA\",\n"
            + "          \"ownerState\": \"NH\",\n"
            + "          \"ownerStreet\": \"Owner Street\",\n"
            + "          \"primaryAccount\": false,\n"
            + "          \"taxId\": \"OT#12345\",\n"
            + "          \"urlForVerification\": \"http://adyen.com\"\n"
            + "        }\n"
            + "      ],\n"
            + "      \"businessDetails\": {\n"
            + "        \"doingBusinessAs\": \"Business name\",\n"
            + "        \"legalBusinessName\": \"Legal Business Co\",\n"
            + "        \"registrationNumber\": \"Reg#1234\",\n"
            + "        \"shareholders\": [\n"
            + "          {\n"
            + "            \"address\": {\n"
            + "              \"city\": \"Amsterdam\",\n"
            + "              \"country\": \"NL\",\n"
            + "              \"houseNumberOrName\": \"96/A\",\n"
            + "              \"postalCode\": \"1000AA\",\n"
            + "              \"stateOrProvince\": \"NH\",\n"
            + "              \"street\": \"Street\"\n"
            + "            },\n"
            + "            \"email\": \"contact@merchant.com\",\n"
            + "            \"fullPhoneNumber\": \"+3112345678\",\n"
            + "            \"name\": {\n"
            + "              \"firstName\": \"Firstname\",\n"
            + "              \"gender\": \"UNKNOWN\",\n"
            + "              \"infix\": \"infix\",\n"
            + "              \"lastName\": \"Lastname\"\n"
            + "            },\n"
            + "            \"personalData\": {\n"
            + "              \"dateOfBirth\": \"1981-02-27\",\n"
            + "              \"documentData\": [\n"
            + "                {\n"
            + "                  \"expirationDate\": \"2030-12-31\",\n"
            + "                  \"issuerCountry\": \"NL\",\n"
            + "                  \"issuerState\": \"NH\",\n"
            + "                  \"number\": \"ID#123456\",\n"
            + "                  \"type\": \"ID\"\n"
            + "                }\n"
            + "              ],\n"
            + "              \"nationality\": \"NL\"\n"
            + "            },\n"
            + "            \"phoneNumber\": {\n"
            + "              \"phoneCountryCode\": \"NL\",\n"
            + "              \"phoneNumber\": \"858888138\",\n"
            + "              \"phoneType\": \"Landline\"\n"
            + "            },\n"
            + "            \"shareholderCode\": \"SH00001\",\n"
            + "            \"shareholderReference\": \"SHREF#0000001\",\n"
            + "            \"webAddress\": \"https://www.adyen.com/\"\n"
            + "          }\n"
            + "        ],\n"
            + "        \"taxId\": \"TaxID#1234\"\n"
            + "      },\n"
            + "      \"email\": \"contact@adyen.com\",\n"
            + "      \"fullPhoneNumber\": \"+31858888138\",\n"
            + "      \"individualDetails\": {\n"
            + "        \"name\": {\n"
            + "          \"firstName\": \"Firstname\",\n"
            + "          \"gender\": \"UNKNOWN\",\n"
            + "          \"infix\": \"infix\",\n"
            + "          \"lastName\": \"Lastname\"\n"
            + "        },\n"
            + "        \"personalData\": {\n"
            + "          \"dateOfBirth\": \"1981-02-27\",\n"
            + "          \"documentData\": [\n"
            + "            {\n"
            + "              \"expirationDate\": \"2030-12-31\",\n"
            + "              \"issuerCountry\": \"NL\",\n"
            + "              \"issuerState\": \"NH\",\n"
            + "              \"number\": \"ID#123456\",\n"
            + "              \"type\": \"ID\"\n"
            + "            }\n"
            + "          ],\n"
            + "          \"nationality\": \"NL\"\n"
            + "        }\n"
            + "      },\n"
            + "      \"merchantCategoryCode\": \"1212\",\n"
            + "      \"metadata\": {\n"
            + "        \"MetaKey\": \"MetaValue\"\n"
            + "      },\n"
            + "      \"phoneNumber\": {\n"
            + "        \"phoneCountryCode\": \"NL\",\n"
            + "        \"phoneNumber\": \"858888138\",\n"
            + "        \"phoneType\": \"Landline\"\n"
            + "      },\n"
            + "      \"webAddress\": \"https://adyen.com\"\n"
            + "    },\n"
            + "    \"accountHolderStatus\": {\n"
            + "      \"status\": \"Active\",\n"
            + "      \"statusReason\": \"Reason of status\",\n"
            + "      \"processingState\": {\n"
            + "        \"disabled\": true,\n"
            + "        \"disableReason\": \"Reason for disabled status\",\n"
            + "        \"processedFrom\": {\n"
            + "          \"currency\": \"EUR\",\n"
            + "          \"value\": 10\n"
            + "        },\n"
            + "        \"processedTo\": {\n"
            + "          \"currency\": \"EUR\",\n"
            + "          \"value\": 100\n"
            + "        },\n"
            + "        \"tierNumber\": 2\n"
            + "      },\n"
            + "      \"payoutState\": {\n"
            + "        \"allowPayout\": false,\n"
            + "        \"payoutLimit\": {\n"
            + "          \"currency\": \"EUR\",\n"
            + "          \"value\": 1000\n"
            + "        },\n"
            + "        \"disabled\": true,\n"
            + "        \"disableReason\": \"Reason for disabled status\",\n"
            + "        \"tierNumber\": 2,\n"
            + "        \"notAllowedReason\": \"Reason of not allowed\"\n"
            + "      },\n"
            + "      \"events\": [\n"
            + "        {\n"
            + "          \"event\": \"InactivateAccount\",\n"
            + "          \"executionDate\": \"2019-01-01T01:00:00+01:00\",\n"
            + "          \"reason\": \"Reason of event\"\n"
            + "        }\n"
            + "      ]\n"
            + "    },\n"
            + "    \"description\": \"Description for account holder\",\n"
            + "    \"legalEntity\": \"Business\",\n"
            + "    \"primaryCurrency\": \"EUR\",\n"
            + "    \"verification\": {\n"
            + "      \"accountHolder\": {\n"
            + "        \"checks\": [\n"
            + "          {\n"
            + "            \"type\": \"IDENTITY_VERIFICATION\",\n"
            + "            \"status\": \"PENDING\",\n"
            + "            \"summary\": {\n"
            + "              \"kycCheckCode\": 100,\n"
            + "              \"kycCheckDescription\": \"KYC check summary description\"\n"
            + "            },\n"
            + "            \"requiredFields\": [\n"
            + "              \"field.missing\"\n"
            + "            ]\n"
            + "          }\n"
            + "        ]\n"
            + "      },\n"
            + "      \"shareholders\": [\n"
            + "        {\n"
            + "          \"checks\": [\n"
            + "            {\n"
            + "              \"type\": \"IDENTITY_VERIFICATION\",\n"
            + "              \"status\": \"PENDING\",\n"
            + "              \"summary\": {\n"
            + "                \"kycCheckCode\": 100,\n"
            + "                \"kycCheckDescription\": \"KYC check summary description\"\n"
            + "              },\n"
            + "              \"requiredFields\": [\n"
            + "                \"field.missing\"\n"
            + "              ]\n"
            + "            }\n"
            + "          ],\n"
            + "          \"shareholderCode\": \"SH000001\"\n"
            + "        }\n"
            + "      ]\n"
            + "    }\n"
            + "  }\n"
            + "}";
    ClassicPlatformWebhookHandler webhookHandler = new ClassicPlatformWebhookHandler(notification);
    Assert.assertTrue(webhookHandler.getAccountHolderCreateNotification().isPresent());
    AccountHolderCreateNotification payload =
        webhookHandler.getAccountHolderCreateNotification().get();
    Assert.assertEquals("ACCOUNT_HOLDER_CREATED", payload.getEventType());
  }
}
