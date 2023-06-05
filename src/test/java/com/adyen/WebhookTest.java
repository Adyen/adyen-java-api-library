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

import com.adyen.model.configurationNotification.AccountHolderNotificationRequest;
import com.adyen.model.configurationNotification.BalanceAccountNotificationRequest;
import com.adyen.model.nexo.DeviceType;
import com.adyen.model.nexo.DisplayOutput;
import com.adyen.model.nexo.EventNotification;
import com.adyen.model.nexo.EventToNotifyType;
import com.adyen.model.nexo.InfoQualifyType;
import com.adyen.model.notification.NotificationRequest;
import com.adyen.model.notification.NotificationRequestItem;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.notification.BankingWebhookHandler;
import com.adyen.notification.WebhookHandler;
import com.adyen.util.HMACValidator;
import com.google.gson.JsonParser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;

import java.io.IOException;
import java.security.SignatureException;
import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Tests notification messages
 */
public class WebhookTest extends BaseTest {

    private WebhookHandler webhookHandler;

    @Before
    public void init() {
        webhookHandler = new WebhookHandler();
    }

    @Test
    public void testAuthorisationSuccess() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/authorisation-true.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_AUTHORISATION, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("123456789", notificationRequestItem.getPspReference());
    }

    @Test
    public void testCaptureSuccess() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/capture-true.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CAPTURE, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
        assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
    }

    @Test
    public void testCaptureFail() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/capture-false.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CAPTURE, notificationRequestItem.getEventCode());
        assertFalse(notificationRequestItem.isSuccess());
        assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
        assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
    }

    @Test
    public void testRefundSuccess() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/refund-true.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_REFUND, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
        assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testRefundFail() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/refund-false.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_REFUND, notificationRequestItem.getEventCode());
        assertFalse(notificationRequestItem.isSuccess());
        assertEquals("PSP_REFERENCE", notificationRequestItem.getPspReference());
        assertEquals("ORIGINAL_PSP", notificationRequestItem.getOriginalReference());
        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testChargeback() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/chargeback.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CHARGEBACK, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("9915555555555555", notificationRequestItem.getPspReference());
        assertEquals("9913333333333333", notificationRequestItem.getOriginalReference());
        assertNotNull(notificationRequestItem.getAmount());
        assertEquals("EUR", notificationRequestItem.getAmount().getCurrency());
        assertEquals(new Long(1000), notificationRequestItem.getAmount().getValue());

        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testAuthorisationAdjustmentTrue() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/chargeback.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CHARGEBACK, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("9915555555555555", notificationRequestItem.getPspReference());
        assertEquals("9913333333333333", notificationRequestItem.getOriginalReference());
        assertNotNull(notificationRequestItem.getAmount());
        assertEquals("EUR", notificationRequestItem.getAmount().getCurrency());
        assertEquals(new Long(1000), notificationRequestItem.getAmount().getValue());

        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testCancellationTrue() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/cancellation-true.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_CANCELLATION, notificationRequestItem.getEventCode());
        assertTrue(notificationRequestItem.isSuccess());
        assertEquals("8412534564722331", notificationRequestItem.getPspReference());
        assertEquals("8313547924770610", notificationRequestItem.getOriginalReference());
        assertNotNull(notificationRequestItem.getAmount());
        assertEquals("EUR", notificationRequestItem.getAmount().getCurrency());
        assertEquals(new Long(500), notificationRequestItem.getAmount().getValue());

        assertNotNull(notificationRequestItem.getEventDate());
    }

    @Test
    public void testOfferClosed() throws Exception {
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/offer-closed.json");

        assertEquals(1, notificationRequest.getNotificationItems().size());

        NotificationRequestItem notificationRequestItem = notificationRequest.getNotificationItems().get(0);
        assertEquals(NotificationRequestItem.EVENT_CODE_OFFER_CLOSED, notificationRequestItem.getEventCode());
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
        TerminalAPIRequest notification = webhookHandler
                .handleTerminalNotificationJson(json);
        DisplayOutput displayOutput = notification.getSaleToPOIRequest().getDisplayRequest().getDisplayOutput().get(0);

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
        NotificationRequest notificationRequest = readNotificationRequestFromFile("mocks/notification/authorisation-true.json");
        assertEquals("123456789", notificationRequest.getNotificationItems().get(0).getPspReference());
        NotificationRequestItem requestItem = new NotificationRequestItem();
        requestItem.setPspReference("987654321");
        ArrayList<NotificationRequestItem> notificationRequestItems = new ArrayList<NotificationRequestItem>();
        notificationRequestItems.add(requestItem);
        notificationRequest.setNotificationItems(notificationRequestItems);

        assertEquals(1, notificationRequest.getNotificationItems().size());
        assertEquals("987654321", notificationRequest.getNotificationItems().get(0).getPspReference());
    }

    private void assertJsonStringEquals(String firstInput, String secondInput) {
        JsonParser parser = new JsonParser();
        assertEquals(parser.parse(firstInput), parser.parse(secondInput));
    }

    private NotificationRequest readNotificationRequestFromFile(String resourcePath) throws IOException {
        String json = getFileContents(resourcePath);
        return webhookHandler.handleNotificationJson(json);
    }

    @Test
    public void testBankingWebhook() {
        BankingWebhookHandler webhookHandler = new BankingWebhookHandler();
        AccountHolderNotificationRequest accountHolderNotificationRequest = webhookHandler.getAccountHolderNotificationRequest("{ \"data\": {\"balancePlatform\": \"YOUR_BALANCE_PLATFORM\",\"accountHolder\": {\"contactDetails\": {\"address\": {\"country\": \"NL\",\"houseNumberOrName\": \"274\",\"postalCode\": \"1020CD\",\"street\": \"Brannan Street\"},\"email\": \"s.hopper@example.com\",\"phone\": {\"number\": \"+315551231234\",\"type\": \"Mobile\"}},\"description\": \"S.Hopper - Staff 123\",\"id\": \"AH00000000000000000000001\",\"status\": \"Active\"}},\"environment\": \"test\",\"type\": \"balancePlatform.accountHolder.created\"}");
        Assert.assertEquals(accountHolderNotificationRequest.getData().getBalancePlatform(), "YOUR_BALANCE_PLATFORM");
    }

    @Test
    public void testBankingWebhookClassCastExceptionCast() {
        BankingWebhookHandler webhookHandler = new BankingWebhookHandler();
        assertThrows(ClassCastException.class, () -> webhookHandler.getBalanceAccountNotificationRequest("{ \"data\": {\"balancePlatform\": \"YOUR_BALANCE_PLATFORM\",\"accountHolder\": {\"contactDetails\": {\"address\": {\"country\": \"NL\",\"houseNumberOrName\": \"274\",\"postalCode\": \"1020CD\",\"street\": \"Brannan Street\"},\"email\": \"s.hopper@example.com\",\"phone\": {\"number\": \"+315551231234\",\"type\": \"Mobile\"}},\"description\": \"S.Hopper - Staff 123\",\"id\": \"AH00000000000000000000001\",\"status\": \"Active\"}},\"environment\": \"test\",\"type\": \"balancePlatform.accountHolder.created\"}"));
    }

    @Test
    public void testBankingWebhookHmacValidator() throws SignatureException {
        String notification = "{\"data\":{\"balancePlatform\":\"Integration_tools_test\",\"accountId\":\"BA32272223222H5HVKTBK4MLB\",\"sweep\":{\"id\":\"SWPC42272223222H5HVKV6H8C64DP5\",\"schedule\":{\"type\":\"balance\"},\"status\":\"active\",\"targetAmount\":{\"currency\":\"EUR\",\"value\":0},\"triggerAmount\":{\"currency\":\"EUR\",\"value\":0},\"type\":\"pull\",\"counterparty\":{\"balanceAccountId\":\"BA3227C223222H5HVKT3H9WLC\"},\"currency\":\"EUR\"}},\"environment\":\"test\",\"type\":\"balancePlatform.balanceAccountSweep.updated\"}";
        String signKey = "D7DD5BA6146493707BF0BE7496F6404EC7A63616B7158EC927B9F54BB436765F";
        String hmacKey = "9Qz9S/0xpar1klkniKdshxpAhRKbiSAewPpWoxKefQA=";
        HMACValidator hmacValidator = new HMACValidator();
        boolean response = hmacValidator.validateHMAC(hmacKey, signKey, notification);
        Assert.assertTrue(response);
    }

}
