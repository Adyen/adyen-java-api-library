package com.adyen.webhooks;

import static org.junit.jupiter.api.Assertions.*;

import com.adyen.BaseTest;
import com.adyen.model.acswebhooks.AcsWebhooksHandler;
import com.adyen.model.acswebhooks.AuthenticationNotificationRequest;
import com.adyen.model.acswebhooks.RelayedAuthenticationRequest;
import com.adyen.model.balancewebhooks.BalanceAccountBalanceNotificationRequest;
import com.adyen.model.balancewebhooks.BalanceWebhooksHandler;
import com.adyen.model.balancewebhooks.ReleasedBlockedBalanceNotificationRequest;
import com.adyen.model.configurationwebhooks.*;
import com.adyen.model.disputewebhooks.DisputeNotificationRequest;
import com.adyen.model.disputewebhooks.DisputeWebhooksHandler;
import com.adyen.model.negativebalancewarningwebhooks.NegativeBalanceCompensationWarningNotificationRequest;
import com.adyen.model.negativebalancewarningwebhooks.NegativeBalanceWarningWebhooksHandler;
import com.adyen.model.reportwebhooks.ReportNotificationRequest;
import com.adyen.model.reportwebhooks.ReportWebhooksHandler;
import com.adyen.model.transactionwebhooks.TransactionNotificationRequestV4;
import com.adyen.model.transactionwebhooks.TransactionWebhooksHandler;
import com.adyen.model.transferwebhooks.PlatformPayment;
import com.adyen.model.transferwebhooks.TransferNotificationRequest;
import com.adyen.model.transferwebhooks.TransferWebhooksHandler;
import com.adyen.util.HMACValidator;
import java.security.SignatureException;
import java.util.Optional;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/** Unit testing for all AfP/Bank related webhooks */
public class BalancePlatformWebhooksTest extends BaseTest {

  // Test AccountHolder created with LEM API v1, v2
  @Test
  public void testAccountHolderCreatedLemV2() {
    String json =
        getFileContents(
            "mocks/balancePlatform-webhooks/configuration-accountHolder-created-lemv2.json");

    Optional<AccountHolderNotificationRequest> notificationRequest =
        new ConfigurationWebhooksHandler(json).getAccountHolderNotificationRequest();
    assertTrue(notificationRequest.isPresent());

    AccountHolderNotificationRequest accountHolderNotificationRequest = notificationRequest.get();
    assertEquals(
        AccountHolderNotificationRequest.TypeEnum.BALANCEPLATFORM_ACCOUNTHOLDER_CREATED,
        accountHolderNotificationRequest.getType());
    assertEquals("test", accountHolderNotificationRequest.getEnvironment());
    assertNotNull(accountHolderNotificationRequest.getTimestamp());

    assertNotNull(accountHolderNotificationRequest.getData());
    assertEquals(
        "YOUR_BALANCE_PLATFORM", accountHolderNotificationRequest.getData().getBalancePlatform());
    assertEquals(
        "AH00000000000000000001",
        accountHolderNotificationRequest.getData().getAccountHolder().getId());
    assertEquals(
        AccountHolder.StatusEnum.ACTIVE,
        accountHolderNotificationRequest.getData().getAccountHolder().getStatus());
    assertEquals(
        5, accountHolderNotificationRequest.getData().getAccountHolder().getCapabilities().size());
  }

  // Test AccountHolder created with LEM API v3+
  @Test
  public void testAccountHolderCreated() {
    String json =
        getFileContents("mocks/balancePlatform-webhooks/configuration-accountHolder-created.json");

    Optional<AccountHolderNotificationRequest> notificationRequest =
        new ConfigurationWebhooksHandler(json).getAccountHolderNotificationRequest();
    assertTrue(notificationRequest.isPresent());

    AccountHolderNotificationRequest accountHolderNotificationRequest = notificationRequest.get();
    assertEquals(
        AccountHolderNotificationRequest.TypeEnum.BALANCEPLATFORM_ACCOUNTHOLDER_CREATED,
        accountHolderNotificationRequest.getType());
    assertEquals("test", accountHolderNotificationRequest.getEnvironment());
    assertNotNull(accountHolderNotificationRequest.getTimestamp());

    assertNotNull(accountHolderNotificationRequest.getData());
    assertEquals(
        "YOUR_BALANCE_PLATFORM", accountHolderNotificationRequest.getData().getBalancePlatform());
    assertEquals(
        "AH00000000000000000001",
        accountHolderNotificationRequest.getData().getAccountHolder().getId());
    assertEquals(
        "YOUR_REFERENCE-2412C",
        accountHolderNotificationRequest.getData().getAccountHolder().getReference());
    assertEquals(
        AccountHolder.StatusEnum.ACTIVE,
        accountHolderNotificationRequest.getData().getAccountHolder().getStatus());
    assertEquals(
        1, accountHolderNotificationRequest.getData().getAccountHolder().getCapabilities().size());

    AccountHolderCapability accountHolderCapability =
        accountHolderNotificationRequest
            .getData()
            .getAccountHolder()
            .getCapabilities()
            .get("sendToTransferInstrument");
    assertNotNull(accountHolderCapability);
    assertNotNull(accountHolderCapability.getProblems());
    assertNotNull(accountHolderCapability.getTransferInstruments());
  }

  @Test
  public void testAccountHolderUpdated() {
    String json =
        getFileContents("mocks/balancePlatform-webhooks/configuration-accountHolder-updated.json");

    Optional<AccountHolderNotificationRequest> notificationRequest =
        new ConfigurationWebhooksHandler(json).getAccountHolderNotificationRequest();
    assertTrue(notificationRequest.isPresent());

    AccountHolderNotificationRequest accountHolderNotificationRequest = notificationRequest.get();
    assertEquals(
        AccountHolderNotificationRequest.TypeEnum.BALANCEPLATFORM_ACCOUNTHOLDER_UPDATED,
        accountHolderNotificationRequest.getType());
    assertEquals("test", accountHolderNotificationRequest.getEnvironment());
    assertNotNull(accountHolderNotificationRequest.getTimestamp());

    assertEquals(
        "YOUR_BALANCE_PLATFORM", accountHolderNotificationRequest.getData().getBalancePlatform());
    assertEquals(
        "AH00000000000000000001",
        accountHolderNotificationRequest.getData().getAccountHolder().getId());

    assertNotNull(
        accountHolderNotificationRequest.getData().getAccountHolder().getVerificationDeadlines());
    assertNotNull(
        accountHolderNotificationRequest
            .getData()
            .getAccountHolder()
            .getVerificationDeadlines()
            .get(0)
            .getCapabilities()
            .get(0));
    assertEquals(
        VerificationDeadline.CapabilitiesEnum.ISSUECHARGECARDCOMMERCIAL,
        accountHolderNotificationRequest
            .getData()
            .getAccountHolder()
            .getVerificationDeadlines()
            .get(0)
            .getCapabilities()
            .get(0));
  }

  @Test
  public void testReportCreated() {
    String json =
        getFileContents("mocks/balancePlatform-webhooks/balanceplatform-report-created.json");

    Optional<ReportNotificationRequest> notificationRequest =
        new ReportWebhooksHandler(json).getReportNotificationRequest();
    assertTrue(notificationRequest.isPresent());

    ReportNotificationRequest reportNotificationRequest = notificationRequest.get();
    assertEquals(
        ReportNotificationRequest.TypeEnum.BALANCEPLATFORM_REPORT_CREATED,
        reportNotificationRequest.getType());
    assertEquals("test", reportNotificationRequest.getEnvironment());
    assertNotNull(reportNotificationRequest.getTimestamp());

    assertNotNull(reportNotificationRequest.getData());
    assertEquals("YOUR_BALANCE_PLATFORM", reportNotificationRequest.getData().getBalancePlatform());
    assertEquals(
        "balanceplatform_accounting_report_2024_07_01.csv",
        reportNotificationRequest.getData().getId());
    assertEquals(
        "2024-07-02T02:01:08+02:00",
        reportNotificationRequest.getData().getCreationDate().toString());
    assertEquals(
        "balanceplatform_accounting_report", reportNotificationRequest.getData().getReportType());
  }

  @Test
  public void testBankingWebhook() {
    String jsonRequest =
        "{ \"data\": {\"balancePlatform\": \"YOUR_BALANCE_PLATFORM\",\"accountHolder\": {\"contactDetails\": {\"address\": {\"country\": \"NL\",\"houseNumberOrName\": \"274\",\"postalCode\": \"1020CD\",\"street\": \"Brannan Street\"},\"email\": \"s.hopper@example.com\",\"phone\": {\"number\": \"+315551231234\",\"type\": \"mobile\"}},\"description\": \"S.Hopper - Staff 123\",\"id\": \"AH00000000000000000000001\",\"status\": \"active\"}},\"environment\": \"test\",\"type\": \"balancePlatform.accountHolder.created\"}";
    ConfigurationWebhooksHandler webhookHandler = new ConfigurationWebhooksHandler(jsonRequest);

    Assertions.assertTrue(webhookHandler.getAccountHolderNotificationRequest().isPresent());

    AccountHolderNotificationRequest accountHolderNotificationRequest =
        webhookHandler.getAccountHolderNotificationRequest().get();
    Assertions.assertEquals(
        "AH00000000000000000000001",
        accountHolderNotificationRequest.getData().getAccountHolder().getId());
  }

  @Test
  public void testBankingWebhookCastException() {
    String json =
        getFileContents(
            "mocks/balancePlatform-webhooks/configuration-accountHolder-created-castexception.json");
    ConfigurationWebhooksHandler webhookHandler = new ConfigurationWebhooksHandler(json);
    Assertions.assertTrue(webhookHandler.getAccountHolderNotificationRequest().isPresent());
    // verify other event is not present
    Assertions.assertFalse(webhookHandler.getCardOrderNotificationRequest().isPresent());
    // verify other event is not present
    Assertions.assertFalse(webhookHandler.getBalanceAccountNotificationRequest().isPresent());
  }

  @Test
  public void testBankingWebhookInvalidPayload() {
    String jsonRequest = "{ invalid json ...";
    ConfigurationWebhooksHandler webhookHandler = new ConfigurationWebhooksHandler(jsonRequest);
    Assertions.assertTrue(webhookHandler.getAccountHolderNotificationRequest().isEmpty());
  }

  @Test
  public void testBankingWebhookHmacValidator() throws SignatureException {
    String notification =
        "{\"data\":{\"balancePlatform\":\"Integration_tools_test\",\"accountId\":\"BA32272223222H5HVKTBK4MLB\",\"sweep\":{\"id\":\"SWPC42272223222H5HVKV6H8C64DP5\",\"schedule\":{\"type\":\"balance\"},\"status\":\"active\",\"targetAmount\":{\"currency\":\"EUR\",\"value\":0},\"triggerAmount\":{\"currency\":\"EUR\",\"value\":0},\"type\":\"pull\",\"counterparty\":{\"balanceAccountId\":\"BA3227C223222H5HVKT3H9WLC\"},\"currency\":\"EUR\"}},\"environment\":\"test\",\"type\":\"balancePlatform.balanceAccountSweep.updated\"}";
    String signKey = "D7DD5BA6146493707BF0BE7496F6404EC7A63616B7158EC927B9F54BB436765F";
    String hmacKey = "9Qz9S/0xpar1klkniKdshxpAhRKbiSAewPpWoxKefQA=";
    HMACValidator hmacValidator = new HMACValidator();
    boolean response = hmacValidator.validateHMAC(hmacKey, signKey, notification);
    Assertions.assertTrue(response);
  }

  @Test
  public void testBankingWebhookAcsParsing() {
    String json =
        getFileContents(
            "mocks/balancePlatform-webhooks/balanceplatform-authentication-created.json");

    Optional<AuthenticationNotificationRequest> notificationRequest =
        new AcsWebhooksHandler(json).getAuthenticationNotificationRequest();
    assertTrue(notificationRequest.isPresent());

    AuthenticationNotificationRequest authenticationNotificationRequest = notificationRequest.get();
    assertEquals(
        AuthenticationNotificationRequest.TypeEnum.BALANCEPLATFORM_AUTHENTICATION_CREATED,
        authenticationNotificationRequest.getType());
    assertEquals("test", authenticationNotificationRequest.getEnvironment());
    assertNotNull(authenticationNotificationRequest.getTimestamp());
    assertEquals(
        "497f6eca-6276-4993-bfeb-53cbbbba6f08",
        authenticationNotificationRequest.getData().getId());
    assertEquals(
        "6a4c1709-a42e-4c7f-96c7-1043adacfc97",
        authenticationNotificationRequest.getData().getAuthentication().getAcsTransId());
  }

  @Test
  public void testTransactionWebhookParsing() {
    String json = getFileContents("mocks/notification/balancePlatform-transaction-created.json");
    TransactionWebhooksHandler webhookHandler = new TransactionWebhooksHandler(json);
    Assertions.assertTrue(webhookHandler.getTransactionNotificationRequestV4().isPresent());
    TransactionNotificationRequestV4 request =
        webhookHandler.getTransactionNotificationRequestV4().get();
    Assertions.assertEquals("EVJN42272224222B5JB8BRC84N686ZEUR", request.getData().getId());
  }

  @Test
  public void testNegativeBalanceCompensationWarning() {
    String json =
        getFileContents(
            "mocks/balancePlatform-webhooks/balanceplatform-negativeBalanceCompensationWarning-scheduled.json");

    Optional<NegativeBalanceCompensationWarningNotificationRequest> notificationRequest =
        new NegativeBalanceWarningWebhooksHandler(json)
            .getNegativeBalanceCompensationWarningNotificationRequest();
    assertTrue(notificationRequest.isPresent());

    NegativeBalanceCompensationWarningNotificationRequest
        negativeBalanceCompensationWarningNotificationRequest = notificationRequest.get();
    assertEquals(
        NegativeBalanceCompensationWarningNotificationRequest.TypeEnum
            .BALANCEPLATFORM_NEGATIVEBALANCECOMPENSATIONWARNING_SCHEDULED,
        negativeBalanceCompensationWarningNotificationRequest.getType());
    assertEquals("test", negativeBalanceCompensationWarningNotificationRequest.getEnvironment());
    assertNotNull(negativeBalanceCompensationWarningNotificationRequest.getTimestamp());

    assertNotNull(negativeBalanceCompensationWarningNotificationRequest.getData());
    assertEquals(
        "YOUR_BALANCE_PLATFORM",
        negativeBalanceCompensationWarningNotificationRequest.getData().getBalancePlatform());
    assertEquals(
        "BA00000000000000000001",
        negativeBalanceCompensationWarningNotificationRequest.getData().getId());
    assertEquals(
        "2024-07-02T02:01:08+02:00",
        negativeBalanceCompensationWarningNotificationRequest
            .getData()
            .getCreationDate()
            .toString());
  }

  @Test
  public void testRelayedAuthenticationRequest() {
    String json =
        getFileContents(
            "mocks/balancePlatform-webhooks/balanceplatform-relayed-authentication-request.json");

    Optional<RelayedAuthenticationRequest> relayedAuthenticationRequestOptional =
        new AcsWebhooksHandler(json).getRelayedAuthenticationRequest();
    assertTrue(relayedAuthenticationRequestOptional.isPresent());

    RelayedAuthenticationRequest relayedAuthenticationRequest =
        relayedAuthenticationRequestOptional.get();

    assertEquals("PI123ABCDEFGHIJKLMN45678", relayedAuthenticationRequest.getPaymentInstrumentId());
    assertNotNull(relayedAuthenticationRequest.getPurchase());
  }

  @Test
  public void testBalanceAccountBalanceNotificationRequest() {
    String json =
        getFileContents(
            "mocks/balancePlatform-webhooks/balanceplatform-balanceAccount-balance-updated.json");

    Optional<BalanceAccountBalanceNotificationRequest>
        balanceAccountBalanceNotificationRequestOptional =
            new BalanceWebhooksHandler(json).getBalanceAccountBalanceNotificationRequest();
    assertTrue(balanceAccountBalanceNotificationRequestOptional.isPresent());

    BalanceAccountBalanceNotificationRequest balanceAccountBalanceNotificationRequest =
        balanceAccountBalanceNotificationRequestOptional.get();
    assertNotNull(balanceAccountBalanceNotificationRequest.getData());

    assertEquals(
        "BWHS00000000000000000000000001",
        balanceAccountBalanceNotificationRequest.getData().getBalanceAccountId());
    assertNotNull(balanceAccountBalanceNotificationRequest.getData().getBalances());
    assertFalse(balanceAccountBalanceNotificationRequest.getData().getSettingIds().isEmpty());
  }

  @Test
  public void testBalanceAccountBalanceBlockReleasedNotificationRequest() {
    String json =
        getFileContents(
            "mocks/balancePlatform-webhooks/balancePlatform-balanceAccount-balance-block-released.json");

    Optional<ReleasedBlockedBalanceNotificationRequest>
        releasedBlockedBalanceNotificationRequestOptional =
            new BalanceWebhooksHandler(json).getReleasedBlockedBalanceNotificationRequest();
    assertTrue(releasedBlockedBalanceNotificationRequestOptional.isPresent());

    ReleasedBlockedBalanceNotificationRequest releasedBlockedBalanceNotificationRequest =
        releasedBlockedBalanceNotificationRequestOptional.get();
    assertNotNull(releasedBlockedBalanceNotificationRequest.getData());

    assertEquals(
        ReleasedBlockedBalanceNotificationRequest.TypeEnum
            .BALANCEPLATFORM_BALANCEACCOUNT_BALANCE_BLOCK_RELEASED,
        releasedBlockedBalanceNotificationRequest.getType());
    assertEquals(
        "BATCH_REF_20250925",
        releasedBlockedBalanceNotificationRequest.getData().getBatchReference());
    assertNotNull(releasedBlockedBalanceNotificationRequest.getData().getBalanceAccount());
    assertEquals(
        "BA00000000000000000001",
        releasedBlockedBalanceNotificationRequest.getData().getBalanceAccount().getId());
  }

  @Test
  public void testNetworkTokenCreatedNotificationRequest() {
    String json =
        getFileContents(
            "mocks/balancePlatform-webhooks/balanceplatform-balancePlatform-networkToken-created.json");

    Optional<NetworkTokenNotificationRequest> optionalNetworkTokenNotificationRequest =
        new ConfigurationWebhooksHandler(json).getNetworkTokenNotificationRequest();
    assertTrue(optionalNetworkTokenNotificationRequest.isPresent());

    NetworkTokenNotificationRequest networkTokenNotificationRequest =
        optionalNetworkTokenNotificationRequest.get();
    assertEquals(
        NetworkTokenNotificationRequest.TypeEnum.BALANCEPLATFORM_NETWORKTOKEN_CREATED,
        networkTokenNotificationRequest.getType());
    assertNotNull(networkTokenNotificationRequest.getData());
    assertEquals(
        "YOUR_BALANCE_PLATFORM", networkTokenNotificationRequest.getData().getBalancePlatform());
  }

  @Test
  public void testNetworkTokenUpdatedNotificationRequest() {
    String json =
        getFileContents(
            "mocks/balancePlatform-webhooks/balanceplatform-balancePlatform-networkToken-updated.json");

    Optional<NetworkTokenNotificationRequest> optionalNetworkTokenNotificationRequest =
        new ConfigurationWebhooksHandler(json).getNetworkTokenNotificationRequest();
    assertTrue(optionalNetworkTokenNotificationRequest.isPresent());

    NetworkTokenNotificationRequest networkTokenNotificationRequest =
        optionalNetworkTokenNotificationRequest.get();
    assertEquals(
        NetworkTokenNotificationRequest.TypeEnum.BALANCEPLATFORM_NETWORKTOKEN_UPDATED,
        networkTokenNotificationRequest.getType());
    assertNotNull(networkTokenNotificationRequest.getData());
    assertEquals(
        "YOUR_BALANCE_PLATFORM", networkTokenNotificationRequest.getData().getBalancePlatform());
  }

  @Test
  public void testTransferNotificationRequest() {
    String json = getFileContents("mocks/balancePlatform-webhooks/transfer-updated.json");

    Optional<TransferNotificationRequest> optionalTransferNotificationRequest =
        new TransferWebhooksHandler(json).getTransferNotificationRequest();
    assertTrue(optionalTransferNotificationRequest.isPresent());

    TransferNotificationRequest transferNotificationRequest =
        optionalTransferNotificationRequest.get();
    assertEquals(
        TransferNotificationRequest.TypeEnum.BALANCEPLATFORM_TRANSFER_UPDATED,
        transferNotificationRequest.getType());
    assertNotNull(transferNotificationRequest.getData());
    assertEquals(
        "YOUR_BALANCE_PLATFORM", transferNotificationRequest.getData().getBalancePlatform());

    assertNotNull(transferNotificationRequest.getData().getCategoryData().getPlatformPayment());
    assertEquals(
        PlatformPayment.PlatformPaymentTypeEnum.REMAINDER,
        transferNotificationRequest
            .getData()
            .getCategoryData()
            .getPlatformPayment()
            .getPlatformPaymentType());

    assertNotNull(transferNotificationRequest.getData().getBalances());
    assertEquals(1, transferNotificationRequest.getData().getBalances().size());
  }

  @Test
  public void testGetDisputeNotificationRequestSuccess() {

    String json = getFileContents("mocks/balancePlatform-webhooks/dispute-created.json");

    DisputeWebhooksHandler handler = new DisputeWebhooksHandler(json);
    Optional<DisputeNotificationRequest> optionalDisputeNotificationRequest =
        handler.getDisputeNotificationRequest();
    assertTrue(optionalDisputeNotificationRequest.isPresent());

    DisputeNotificationRequest request = optionalDisputeNotificationRequest.get();
    assertNotNull(request.getData());
    assertEquals(
        DisputeNotificationRequest.TypeEnum.BALANCEPLATFORM_DISPUTE_CREATED, request.getType());
    assertEquals("DS00000000000000000001", request.getData().getId());
  }

  @Test
  public void testGetDisputeNotificationRequestWithUnknownType() {
    String payload =
        "{\n"
            + "  \"type\": \"SomeUnknownEventType\",\n"
            + "  \"pspReference\": \"883585332216073C\"\n"
            + "}";

    DisputeWebhooksHandler handler = new DisputeWebhooksHandler(payload);
    Optional<DisputeNotificationRequest> result = handler.getDisputeNotificationRequest();
    assertFalse(result.isPresent());
  }

  @Test
  public void testGetDisputeNotificationRequestWithEmptyJson() {
    String payload = "{}";

    DisputeWebhooksHandler handler = new DisputeWebhooksHandler(payload);
    Optional<DisputeNotificationRequest> result = handler.getDisputeNotificationRequest();
    assertFalse(result.isPresent());
  }

  @Test
  public void testScoreNotificationRequest() {

    String json =
        getFileContents("mocks/balancePlatform-webhooks/balancePlatform-score-triggered.json");

    ConfigurationWebhooksHandler handler = new ConfigurationWebhooksHandler(json);
    Optional<ScoreNotificationRequest> optionalRequest = handler.getScoreNotificationRequest();

    assertTrue(optionalRequest.isPresent(), "The ScoreNotificationRequest should be present");

    ScoreNotificationRequest request = optionalRequest.get();
    assertEquals(
        ScoreNotificationRequest.TypeEnum.BALANCEPLATFORM_SCORE_TRIGGERED, request.getType());
    assertEquals("test", request.getEnvironment());

    BankScoreSignalTriggeredData data = request.getData();
    assertNotNull(data);
    assertEquals("2235e7be-fcb0-4b88-a79b-895b68cfb855", data.getId());
    assertEquals(Integer.valueOf(100), data.getRiskScore());

    assertNotNull(data.getAccountHolder());
    assertEquals("AH00000000000001", data.getAccountHolder().getId());

    assertNotNull(data.getScoreSignalsTriggered());
    assertEquals(2, data.getScoreSignalsTriggered().size());
    assertEquals("ChargebackCardholderDispute", data.getScoreSignalsTriggered().get(0));
    assertEquals("ChargebackNonReceipt", data.getScoreSignalsTriggered().get(1));
  }
}
