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

import org.junit.Assert;
import org.junit.Test;
import com.adyen.model.marketpay.AccountHolderStatus;
import com.adyen.model.marketpay.notification.AccountCreatedNotification;
import com.adyen.model.marketpay.notification.AccountHolderCreatedNotification;
import com.adyen.model.marketpay.notification.AccountHolderLimitReachedNotification;
import com.adyen.model.marketpay.notification.AccountHolderPayoutNotification;
import com.adyen.model.marketpay.notification.AccountHolderStatusChangeNotification;
import com.adyen.model.marketpay.notification.AccountHolderUpdatedNotification;
import com.adyen.model.marketpay.notification.AccountHolderVerificationNotification;
import com.adyen.model.marketpay.notification.BeneficiarySetupNotification;
import com.adyen.model.marketpay.notification.CompensateNegativeBalanceNotification;
import com.adyen.model.marketpay.notification.CreateNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.CreateNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.DeleteNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.DeleteNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.GenericNotification;
import com.adyen.model.marketpay.notification.GetNotificationConfigurationListResponse;
import com.adyen.model.marketpay.notification.GetNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.GetNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.NotificationEventConfiguration;
import com.adyen.model.marketpay.notification.PaymentFailureNotification;
import com.adyen.model.marketpay.notification.ReportAvailableNotification;
import com.adyen.model.marketpay.notification.ScheduledRefundsNotification;
import com.adyen.model.marketpay.notification.TestNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.TestNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.TransferFundsNotification;
import com.adyen.model.marketpay.notification.UpdateNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.UpdateNotificationConfigurationResponse;
import com.adyen.notification.NotificationHandler;
import com.adyen.service.Notification;
import static com.adyen.model.marketpay.KYCCheckStatusData.CheckStatusEnum.DATA_PROVIDED;
import static com.adyen.model.marketpay.KYCCheckStatusData.CheckTypeEnum.COMPANY_VERIFICATION;
import static com.adyen.model.marketpay.KYCCheckStatusData.CheckTypeEnum.IDENTITY_VERIFICATION;
import static com.adyen.model.marketpay.Transaction.TransactionStatusEnum.PENDINGCREDIT;
import static com.adyen.model.marketpay.notification.NotificationEventConfiguration.EventTypeEnum.ACCOUNT_HOLDER_STATUS_CHANGE;
import static com.adyen.model.marketpay.notification.NotificationEventConfiguration.IncludeModeEnum.INCLUDE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class MarketPayNotificationTest extends BaseTest {

    @Test
    public void TestCreateNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/create-notification-configuration-success.json");
        Notification notification = new Notification(client);

        CreateNotificationConfigurationRequest createNotificationConfigurationRequest = new CreateNotificationConfigurationRequest();
        CreateNotificationConfigurationResponse getNotificationConfigurationResponse = notification.createNotificationConfiguration(createNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);
    }

    @Test
    public void TestGetNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/get-notification-configuration-success.json");
        Notification notification = new Notification(client);

        GetNotificationConfigurationRequest getNotificationConfigurationRequest = new GetNotificationConfigurationRequest();
        GetNotificationConfigurationResponse getNotificationConfigurationResponse = notification.getNotificationConfiguration(getNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);
        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getIncludeMode(), INCLUDE);
    }

    @Test
    public void TestGetNotificationConfigurationList() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/get-notification-configuration-list-success.json");
        Notification notification = new Notification(client);
        GetNotificationConfigurationListResponse getNotificationConfigurationListResponse = notification.getNotificationConfigurationList();

        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(0).getNotificationId(), new Long(157));
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(0).getEventConfigs().get(0).getIncludeMode(), INCLUDE);
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(0).getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);


        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(1).getNotificationId(), new Long(161));
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(1).getEventConfigs().get(0).getIncludeMode(), INCLUDE);
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(1).getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);
    }

    @Test
    public void TestUpdateNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/update-notification-configuration-success.json");
        Notification notification = new Notification(client);

        UpdateNotificationConfigurationRequest updateNotificationConfigurationRequest = new UpdateNotificationConfigurationRequest();
        UpdateNotificationConfigurationResponse getNotificationConfigurationResponse = notification.updateNotificationConfiguration(updateNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getEventType(), NotificationEventConfiguration.EventTypeEnum.ACCOUNT_CREATED);
        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getIncludeMode(), NotificationEventConfiguration.IncludeModeEnum.INCLUDE);


        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(1).getEventType(),
                            NotificationEventConfiguration.EventTypeEnum.ACCOUNT_HOLDER_CREATED);
        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(1).getIncludeMode(), NotificationEventConfiguration.IncludeModeEnum.EXCLUDE);
    }

    @Test
    public void TestDeleteNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/delete-notification-configurations-success.json");
        Notification notification = new Notification(client);

        DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest = new DeleteNotificationConfigurationRequest();
        DeleteNotificationConfigurationResponse getNotificationConfigurationResponse = notification.deleteNotificationConfiguration(deleteNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getPspReference(), "8515078085249090");
        Assert.assertEquals(getNotificationConfigurationResponse.getSubmittedAsync(), false);
    }

    @Test
    public void TestNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/test-notification-configuration-success.json");
        Notification notification = new Notification(client);

        TestNotificationConfigurationRequest testNotificationConfigurationRequest = new TestNotificationConfigurationRequest();
        TestNotificationConfigurationResponse testNotificationConfigurationResponse = notification.testNotificationConfiguration(testNotificationConfigurationRequest);


        assertEquals("Number", testNotificationConfigurationResponse.getExchangeMessages().get(0).getMessageCode());
        assertEquals("1", testNotificationConfigurationResponse.getExchangeMessages().get(0).getMessageDescription());

        assertEquals("Title", testNotificationConfigurationResponse.getExchangeMessages().get(1).getMessageCode());
        assertEquals("Test 1: Test_ACCOUNT_CREATED", testNotificationConfigurationResponse.getExchangeMessages().get(1).getMessageDescription());
    }

    @Test
    public void testMarketPayAccountCreatedNotification() throws Exception {
        String json = getFileContents("mocks/marketpay/notification/account-created-success.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_CREATED, notificationMessage.getEventType());
        AccountCreatedNotification accountCreatedNotificationMessage = (AccountCreatedNotification) notificationMessage;
        assertNotNull(accountCreatedNotificationMessage.getContent());
        assertEquals("TestAccountHolder", accountCreatedNotificationMessage.getContent().getAccountHolderCode());
    }

    @Test
    public void testMarketPayAccountHolderCreatedNotification() throws Exception {
        String json = getFileContents("mocks/marketpay/notification/account-holder-created-success.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_CREATED, notificationMessage.getEventType());
        AccountHolderCreatedNotification accountHolderCreatedNotificationMessage = (AccountHolderCreatedNotification) notificationMessage;
        assertNotNull(accountHolderCreatedNotificationMessage.getContent());
        assertEquals("TestAccountHolder", accountHolderCreatedNotificationMessage.getContent().getAccountHolderCode());
    }

    @Test
    public void testMarketPayAccountHolderLimitReachedNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-limit-reached-success.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_LIMIT_REACHED, notificationMessage.getEventType());
        AccountHolderLimitReachedNotification notification = (AccountHolderLimitReachedNotification) notificationMessage;
        assertNotNull(notification.getContent());
        assertEquals("TestAccountHolder", notification.getContent().getAccountHolderCode());

        assertEquals(123L, notification.getContent().getTotalAmountBeforeLimit().getValue().longValue());
        assertEquals(123L, notification.getContent().getAmount().getValue().longValue());
        assertEquals(1, notification.getContent().getAccountState().getTierNumber().intValue());
    }

    @Test
    public void testMarketPayAccountHolderVerificationNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-verification.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_VERIFICATION, notificationMessage.getEventType());
        AccountHolderVerificationNotification notification = (AccountHolderVerificationNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals(DATA_PROVIDED, notification.getContent().getVerificationStatus());
        assertEquals(IDENTITY_VERIFICATION, notification.getContent().getVerificationType());
    }

    @Test
    public void testMarketPayAccountHolderStatusChangeNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-status-change.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_STATUS_CHANGE, notificationMessage.getEventType());
        AccountHolderStatusChangeNotification notification = (AccountHolderStatusChangeNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals("ah689", notification.getContent().getAccountHolderCode());
        assertNull(notification.getContent().getOldStatus().getProcessingState().getProcessedTo());
        assertEquals("GBP", notification.getContent().getNewStatus().getProcessingState().getProcessedTo().getCurrency());
    }

    @Test
    public void testMarketPayAccountHolderPayoutFailNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-payout-fail.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_PAYOUT, notificationMessage.getEventType());
        AccountHolderPayoutNotification notification = (AccountHolderPayoutNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals("accountCode", notification.getContent().getAccountCode());
        assertEquals(1, notification.getContent().getAmountList().size());
        assertEquals(1000L, notification.getContent().getAmountList().get(0).getValue().longValue());
        assertEquals("10_066", notification.getContent().getStatus().getMessage().getCode());
    }

    @Test
    public void testMarketPayAccountHolderUpdatedNotification() {
        String json = getFileContents("mocks/marketpay/notification/account-holder-updated.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.ACCOUNT_HOLDER_UPDATED, notificationMessage.getEventType());
        AccountHolderUpdatedNotification notification = (AccountHolderUpdatedNotification) notificationMessage;

        assertNotNull(notification.getContent());

        assertEquals("accountHolderCode", notification.getContent().getAccountHolderCode());
        assertEquals(AccountHolderStatus.StatusEnum.ACTIVE, notification.getContent().getAccountHolderStatus().getStatus());
        assertEquals(COMPANY_VERIFICATION, notification.getContent().getVerificationResult().getAccountHolder().getChecks().get(0).getCheckType());
        assertEquals(DATA_PROVIDED, notification.getContent().getVerificationResult().getAccountHolder().getChecks().get(0).getCheckStatus());
        assertEquals(DATA_PROVIDED, notification.getContent().getVerificationResult().getShareholders().get(0).getChecks().get(0).getCheckStatus());
    }

    @Test
    public void testMarketPayBeneficiarySetupNotification() {
        String json = getFileContents("mocks/marketpay/notification/beneficiary-setup.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.BENEFICIARY_SETUP, notificationMessage.getEventType());
        BeneficiarySetupNotification notification = (BeneficiarySetupNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals("136058999", notification.getContent().getSourceAccountCode());
        assertEquals("117001608", notification.getContent().getDestinationAccountCode());
    }

    @Test
    public void testMarketPayScheduledRefundsNotification() {
        String json = getFileContents("mocks/marketpay/notification/scheduled-refunds-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.SCHEDULED_REFUNDS, notificationMessage.getEventType());
        ScheduledRefundsNotification notification = (ScheduledRefundsNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals("1234567890", notification.getContent().getAccountCode());
        assertEquals(5000L, notification.getContent().getLastPayout().getAmount().getValue().longValue());
        assertEquals(PENDINGCREDIT, notification.getContent().getRefundResults().get(0).getRefundResult().getOriginalTransaction().getTransactionStatus());
    }

    @Test
    public void testMarketPayCompensateNegativeBalanceNotification() {
        String json = getFileContents("mocks/marketpay/notification/compensate-negative-balance-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.COMPENSATE_NEGATIVE_BALANCE, notificationMessage.getEventType());
        CompensateNegativeBalanceNotification notification = (CompensateNegativeBalanceNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals("testCirtualAccount", notification.getContent().getRecords().get(0).getCompensateNegativeBalanceNotificationRecord().getAccountCode());
        assertEquals(10000L, notification.getContent().getRecords().get(0).getCompensateNegativeBalanceNotificationRecord().getAmount().getValue().longValue());
    }

    @Test
    public void testMarketPayPaymentFailureNotification() {
        String json = getFileContents("mocks/marketpay/notification/payment-failure-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.PAYMENT_FAILURE, notificationMessage.getEventType());
        PaymentFailureNotification notification = (PaymentFailureNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals(1L, notification.getContent().getErrorFieldList().get(0).getErrorCode().longValue());
        assertEquals("10_062", notification.getContent().getErrorMessage().getCode());
    }

    @Test
    public void testMarketPayReportAvailableNotification() {
        String json = getFileContents("mocks/marketpay/notification/report-available-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.REPORT_AVAILABLE, notificationMessage.getEventType());
        ReportAvailableNotification notification = (ReportAvailableNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertNotNull(notification.getContent().getRemoteAccessUrl());
    }

    @Test
    public void testMarketPayTransferFundsNotification() {
        String json = getFileContents("mocks/marketpay/notification/transfer-funds-test.json");
        NotificationHandler notificationHandler = new NotificationHandler();

        GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);

        assertEquals(GenericNotification.EventTypeEnum.TRANSFER_FUNDS, notificationMessage.getEventType());
        TransferFundsNotification notification = (TransferFundsNotification) notificationMessage;
        assertNotNull(notification.getContent());

        assertEquals(1000L, notification.getContent().getAmount().getValue().longValue());
        assertEquals("testTransferCode", notification.getContent().getTransferCode());
    }
}
