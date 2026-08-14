/*
 * Adyen Java API Library
 *
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service.clouddevice;

import static com.adyen.IntegrationTestTags.EXTERNAL;
import static com.adyen.IntegrationTestTags.MANUAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adyen.BaseIntegrationTest;
import com.adyen.constants.ApiConstants;
import com.adyen.model.clouddevice.CloudDeviceApiAsyncResponse;
import com.adyen.model.clouddevice.CloudDeviceApiRequest;
import com.adyen.model.clouddevice.CloudDeviceApiResponse;
import com.adyen.model.clouddevice.ConnectedDevicesResponse;
import com.adyen.model.tapi.AmountsReq;
import com.adyen.model.tapi.MessageCategory;
import com.adyen.model.tapi.MessageClass;
import com.adyen.model.tapi.MessageHeader;
import com.adyen.model.tapi.MessageType;
import com.adyen.model.tapi.PaymentRequest;
import com.adyen.model.tapi.PaymentTransaction;
import com.adyen.model.tapi.SaleData;
import com.adyen.model.tapi.SaleToPOIRequest;
import com.adyen.model.tapi.TransactionIDType;
import com.adyen.security.clouddevice.EncryptionCredentialDetails;
import com.adyen.security.clouddevice.NexoSecurityException;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * Exercises Cloud Device API operations that require an enabled physical terminal.
 *
 * <p>See {@code src/integration-test/README.md} for shared conventions and {@code e2e-testing.md}
 * for terminal-specific prerequisites.
 */
@Tag(EXTERNAL)
@Tag(MANUAL)
@Timeout(value = 5, unit = TimeUnit.MINUTES)
public class CloudDeviceApiTerminalIT extends BaseIntegrationTest {

  private static final String PAYMENT_CURRENCY = "EUR";
  private static final BigDecimal PAYMENT_AMOUNT = BigDecimal.TEN;
  private static final String ASYNC_SUCCESS_RESULT = "ok";

  @BeforeEach
  public void verifyTestEnvironment() {
    requireTestEnvironment();
  }

  @Test
  public void shouldSendSynchronousPaymentRequest() throws ApiException, IOException {
    // Arrange
    String terminalDeviceId = getTerminalDeviceId();
    CloudDeviceApiRequest request = createPaymentRequest(terminalDeviceId);
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(getClient());

    // Act
    CloudDeviceApiResponse response =
        cloudDeviceApi.sync(getMerchantAccount(), terminalDeviceId, request);

    // Assert
    assertSynchronousResponse(response, terminalDeviceId);
  }

  @Test
  public void shouldSendAsynchronousPaymentRequest() throws ApiException, IOException {
    // Arrange
    String terminalDeviceId = getTerminalDeviceId();
    CloudDeviceApiRequest request = createPaymentRequest(terminalDeviceId);
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(getClient());

    // Act
    CloudDeviceApiAsyncResponse response =
        cloudDeviceApi.async(getMerchantAccount(), terminalDeviceId, request);

    // Assert
    assertAsynchronousResponseAccepted(response);
  }

  @Test
  public void shouldSendEncryptedSynchronousPaymentRequest()
      throws ApiException, IOException, NexoSecurityException {
    // Arrange
    String terminalDeviceId = getTerminalDeviceId();
    CloudDeviceApiRequest request = createPaymentRequest(terminalDeviceId);
    EncryptedCloudDeviceApi encryptedCloudDeviceApi = createEncryptedCloudDeviceApi();

    // Act
    CloudDeviceApiResponse response =
        encryptedCloudDeviceApi.sync(getMerchantAccount(), terminalDeviceId, request);

    // Assert
    assertSynchronousResponse(response, terminalDeviceId);
  }

  @Test
  public void shouldListConnectedDevices() throws ApiException, IOException {
    // Arrange
    String terminalDeviceId = getTerminalDeviceId();
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(getClient());

    // Act
    ConnectedDevicesResponse response = cloudDeviceApi.getConnectedDevices(getMerchantAccount());

    // Assert
    assertNotNull(response, "The Cloud Device API response must not be null");
    assertNotNull(response.getUniqueDeviceIds(), "The response must contain connected device IDs");
    assertTrue(
        response.getUniqueDeviceIds().contains(terminalDeviceId),
        "The configured terminal must be connected");
  }

  @Test
  public void shouldSendEncryptedAsynchronousPaymentRequest()
      throws ApiException, IOException, NexoSecurityException {
    // Arrange
    String terminalDeviceId = getTerminalDeviceId();
    CloudDeviceApiRequest request = createPaymentRequest(terminalDeviceId);
    EncryptedCloudDeviceApi encryptedCloudDeviceApi = createEncryptedCloudDeviceApi();

    // Act
    CloudDeviceApiAsyncResponse response =
        encryptedCloudDeviceApi.async(getMerchantAccount(), terminalDeviceId, request);

    // Assert
    assertAsynchronousResponseAccepted(response);
  }

  private EncryptedCloudDeviceApi createEncryptedCloudDeviceApi() throws NexoSecurityException {
    EncryptionCredentialDetails encryptionCredentials =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(1)
            .keyIdentifier(getTerminalDeviceKeyIdentifier())
            .keyVersion(1)
            .passphrase(getTerminalDevicePassphrase());

    return new EncryptedCloudDeviceApi(getClient(), encryptionCredentials);
  }

  private static CloudDeviceApiRequest createPaymentRequest(String terminalDeviceId) {
    String transactionId = createTransactionId();

    MessageHeader messageHeader =
        new MessageHeader()
            .protocolVersion(ApiConstants.TerminalAPI.PROTOCOL_VERSION)
            .messageClass(MessageClass.SERVICE)
            .messageCategory(MessageCategory.PAYMENT)
            .messageType(MessageType.REQUEST)
            .saleID(transactionId)
            .serviceID(transactionId)
            .POIID(terminalDeviceId);

    TransactionIDType transactionIdentification =
        new TransactionIDType()
            .transactionID(transactionId)
            .timeStamp(OffsetDateTime.now(ZoneOffset.UTC));
    SaleData saleData = new SaleData().saleTransactionID(transactionIdentification);
    AmountsReq amounts =
        new AmountsReq().currency(PAYMENT_CURRENCY).requestedAmount(PAYMENT_AMOUNT);
    PaymentTransaction paymentTransaction = new PaymentTransaction().amountsReq(amounts);
    PaymentRequest paymentRequest =
        new PaymentRequest().saleData(saleData).paymentTransaction(paymentTransaction);
    SaleToPOIRequest saleToPOIRequest =
        new SaleToPOIRequest().messageHeader(messageHeader).paymentRequest(paymentRequest);

    CloudDeviceApiRequest request = new CloudDeviceApiRequest();
    request.setSaleToPOIRequest(saleToPOIRequest);
    return request;
  }

  private static String createTransactionId() {
    return UUID.randomUUID().toString().replace("-", "").substring(0, 10);
  }

  private static void assertSynchronousResponse(
      CloudDeviceApiResponse response, String expectedTerminalDeviceId) {
    assertNotNull(response, "The Cloud Device API response must not be null");
    assertNotNull(response.getSaleToPOIResponse(), "The response must contain SaleToPOIResponse");
    assertNotNull(
        response.getSaleToPOIResponse().getMessageHeader(),
        "SaleToPOIResponse must contain a message header");
    assertEquals(
        expectedTerminalDeviceId,
        response.getSaleToPOIResponse().getMessageHeader().getPOIID(),
        "The response must identify the configured terminal");
  }

  private static void assertAsynchronousResponseAccepted(CloudDeviceApiAsyncResponse response) {
    assertNotNull(response, "The Cloud Device API response must not be null");
    assertEquals(
        ASYNC_SUCCESS_RESULT,
        response.getResult(),
        "The Cloud Device API must accept the asynchronous request");
  }
}
