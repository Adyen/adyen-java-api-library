package com.adyen.service.clouddevice;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import com.adyen.model.clouddevice.CloudDeviceApiRequest;
import com.adyen.model.clouddevice.CloudDeviceApiSecuredRequest;
import com.adyen.model.clouddevice.SaleToPOISecuredMessage;
import com.adyen.model.tapi.*;
import com.adyen.security.clouddevice.EncryptionCredentialDetails;
import com.adyen.security.clouddevice.NexoSecurityException;
import com.adyen.security.clouddevice.NexoSecurityManager;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class EncryptedCloudDeviceApiTest extends BaseTest {

  private static final EncryptionCredentialDetails DEFAULT_CREDENTIALS =
      new EncryptionCredentialDetails()
          .adyenCryptoVersion(0)
          .keyIdentifier("CryptoKeyIdentifier12345")
          .keyVersion(0)
          .passphrase("p@ssw0rd123456");

  @Test
  public void sendEncryptedSync() throws Exception {
    Client client =
        createMockClientFromFile("mocks/clouddevice/payment-sync-encrypted-success.json");
    EncryptedCloudDeviceApi api = new EncryptedCloudDeviceApi(client, DEFAULT_CREDENTIALS);

    var response =
        api.sync("TestMerchantAccount", "MX915-284251016", createCloudDeviceAPIPaymentRequest());

    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getSaleToPOIResponse());
    Assertions.assertNotNull(response.getSaleToPOIResponse().getMessageHeader());
    Assertions.assertEquals(
        "MX915-284251016", response.getSaleToPOIResponse().getMessageHeader().getPOIID());

    verify(client.getHttpClient())
        .request(
            eq(
                "https://device-api-test.adyen.com/v1/merchants/TestMerchantAccount/devices/MX915-284251016/sync"),
            argThat(
                json -> {
                  assertTrue(
                      json.contains("\"NexoBlob\":"), "JSON payload should contain NexoBlob field");
                  return true;
                }),
            eq(client.getConfig()),
            eq(false),
            isNull(),
            eq(ApiConstants.HttpMethod.POST),
            isNull());
  }

  @Test
  public void sendEncryptedAsync() throws Exception {
    Client client =
        createMockClientFromFile("mocks/clouddevice/payment-async-encrypted-success.json");
    EncryptedCloudDeviceApi api = new EncryptedCloudDeviceApi(client, DEFAULT_CREDENTIALS);

    var response =
        api.async("TestMerchantAccount", "MX915-284251016", createCloudDeviceAPIPaymentRequest());

    Assertions.assertNotNull(response);
    Assertions.assertEquals("ok", response.getResult());

    verify(client.getHttpClient())
        .request(
            eq(
                "https://device-api-test.adyen.com/v1/merchants/TestMerchantAccount/devices/MX915-284251016/async"),
            argThat(
                json -> {
                  assertTrue(
                      json.contains("\"NexoBlob\":"), "JSON payload should contain NexoBlob field");
                  return true;
                }),
            eq(client.getConfig()),
            eq(false),
            isNull(),
            eq(ApiConstants.HttpMethod.POST),
            isNull());
  }

  @Test
  public void asyncEncryptedEventNotification() throws Exception {
    // Simulate the terminal returning an encrypted EventNotification instead of "ok"
    NexoSecurityManager manager = new NexoSecurityManager(DEFAULT_CREDENTIALS);

    MessageHeader messageHeader = new MessageHeader();
    messageHeader.setMessageClass(MessageClass.EVENT);
    messageHeader.setMessageCategory(MessageCategory.EVENT);
    messageHeader.setMessageType(MessageType.NOTIFICATION);
    messageHeader.setSaleID("sale-001");
    messageHeader.setServiceID("svc-001");
    messageHeader.setPOIID("MX915-284251016");

    // The plaintext the terminal would encrypt: a SaleToPOIRequest envelope
    String plaintextJson =
        "{\"SaleToPOIRequest\":{\"MessageHeader\":{\"MessageCategory\":\"Event\","
            + "\"POIID\":\"MX915-284251016\"}}}";
    SaleToPOISecuredMessage encryptedMessage = manager.encrypt(plaintextJson, messageHeader);
    CloudDeviceApiSecuredRequest encryptedRequest = new CloudDeviceApiSecuredRequest();
    encryptedRequest.setSaleToPOIRequest(encryptedMessage);

    Client client = createMockClientFromResponse(encryptedRequest.toJson());
    EncryptedCloudDeviceApi api = new EncryptedCloudDeviceApi(client, DEFAULT_CREDENTIALS);

    var response =
        api.async("TestMerchantAccount", "MX915-284251016", createCloudDeviceAPIPaymentRequest());

    Assertions.assertNotNull(response);
    Assertions.assertNull(response.getResult());
    Assertions.assertNotNull(response.getSaleToPOIRequest());
    Assertions.assertNotNull(response.getSaleToPOIRequest().getMessageHeader());
    Assertions.assertEquals(
        "MX915-284251016", response.getSaleToPOIRequest().getMessageHeader().getPOIID());
  }

  @Test
  public void decryptNotification() throws Exception {
    Client client = createMockClientFromResponse("");
    EncryptedCloudDeviceApi api =
        new EncryptedCloudDeviceApi(
            client,
            new EncryptionCredentialDetails()
                .adyenCryptoVersion(1)
                .keyIdentifier("Key123456789crypt")
                .keyVersion(1)
                .passphrase("P@ssw0rd123456"));

    String payload = getFileContents("mocks/clouddevice/encrypted-event-notification.json");

    var response = api.decryptNotification(payload);

    Assertions.assertNotNull(response);
    assertFalse(response.contains("\"NexoBlob\":"));
    assertTrue(response.contains("\"PaymentResponse\":"));
  }

  @Test
  public void decryptNotificationInvalidPayload() throws Exception {
    Client client = createMockClientFromResponse("");
    EncryptedCloudDeviceApi api =
        new EncryptedCloudDeviceApi(
            client,
            new EncryptionCredentialDetails()
                .adyenCryptoVersion(1)
                .keyIdentifier("Key123456789crypt")
                .keyVersion(1)
                .passphrase("P@ssw0rd123456"));

    Assertions.assertThrows(NexoSecurityException.class, () -> api.decryptNotification("{...}"));
  }

  @Test
  public void decryptNotificationSaleToPOIRequest() throws Exception {
    Client client = createMockClientFromResponse("");
    EncryptionCredentialDetails creds =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(1)
            .keyIdentifier("CryptoKeyIdentifier12345")
            .keyVersion(1)
            .passphrase("p@ssw0rd123456");
    EncryptedCloudDeviceApi api = new EncryptedCloudDeviceApi(client, creds);
    NexoSecurityManager manager = new NexoSecurityManager(creds);

    String plaintextJson =
        "{\"SaleToPOIRequest\":{\"MessageHeader\":{\"MessageCategory\":\"Event\"}}}";
    MessageHeader messageHeader = new MessageHeader();
    messageHeader.setMessageClass(MessageClass.EVENT);
    messageHeader.setMessageCategory(MessageCategory.EVENT);
    messageHeader.setMessageType(MessageType.NOTIFICATION);
    messageHeader.setSaleID("sale-001");
    messageHeader.setServiceID("svc-001");
    messageHeader.setPOIID("MX915-000000001");

    SaleToPOISecuredMessage encryptedMessage = manager.encrypt(plaintextJson, messageHeader);
    CloudDeviceApiSecuredRequest securedRequest = new CloudDeviceApiSecuredRequest();
    securedRequest.setSaleToPOIRequest(encryptedMessage);

    String decrypted = api.decryptNotification(securedRequest.toJson());

    Assertions.assertNotNull(decrypted);
    Assertions.assertFalse(decrypted.contains("\"NexoBlob\":"));
    Assertions.assertTrue(decrypted.contains("\"MessageHeader\""));
  }

  @Test
  public void syncEncryptedSetsPoiIdInEncryptedPayload() throws Exception {
    Client client =
        createMockClientFromFile("mocks/clouddevice/payment-sync-encrypted-success.json");
    NexoSecurityManager manager = new NexoSecurityManager(DEFAULT_CREDENTIALS);
    EncryptedCloudDeviceApi api = new EncryptedCloudDeviceApi(client, DEFAULT_CREDENTIALS);

    CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();
    cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader().setPOIID(null);

    api.sync("TestMerchantAccount", "MX915-284251016", cloudDeviceApiRequest);

    ArgumentCaptor<String> bodyCaptor = ArgumentCaptor.forClass(String.class);
    verify(client.getHttpClient())
        .request(anyString(), bodyCaptor.capture(), any(), anyBoolean(), isNull(), any(), any());

    String capturedJson = bodyCaptor.getValue();
    CloudDeviceApiSecuredRequest securedRequest =
        CloudDeviceApiSecuredRequest.fromJson(capturedJson);
    String decryptedJson = manager.decrypt(securedRequest.getSaleToPOIRequest());

    Assertions.assertTrue(
        decryptedJson.contains("\"POIID\":\"MX915-284251016\""),
        "Encrypted payload must contain POIID set to deviceId, but was: " + decryptedJson);
  }

  @Test
  public void asyncEncryptedSetsPoiIdInEncryptedPayload() throws Exception {
    Client client = createMockClientFromFile("mocks/clouddevice/payment-async-success.json");
    NexoSecurityManager manager = new NexoSecurityManager(DEFAULT_CREDENTIALS);
    EncryptedCloudDeviceApi api = new EncryptedCloudDeviceApi(client, DEFAULT_CREDENTIALS);

    CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();
    cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader().setPOIID(null);

    api.async("TestMerchantAccount", "MX915-284251016", cloudDeviceApiRequest);

    ArgumentCaptor<String> bodyCaptor = ArgumentCaptor.forClass(String.class);
    verify(client.getHttpClient())
        .request(anyString(), bodyCaptor.capture(), any(), anyBoolean(), isNull(), any(), any());

    String capturedJson = bodyCaptor.getValue();
    CloudDeviceApiSecuredRequest securedRequest =
        CloudDeviceApiSecuredRequest.fromJson(capturedJson);
    String decryptedJson = manager.decrypt(securedRequest.getSaleToPOIRequest());

    Assertions.assertTrue(
        decryptedJson.contains("\"POIID\":\"MX915-284251016\""),
        "Encrypted payload must contain POIID set to deviceId, but was: " + decryptedJson);
  }

  protected CloudDeviceApiRequest createCloudDeviceAPIPaymentRequest() {
    SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

    MessageHeader messageHeader = new MessageHeader();
    messageHeader.setProtocolVersion("3.0");
    messageHeader.setMessageClass(MessageClass.SERVICE);
    messageHeader.setMessageCategory(MessageCategory.PAYMENT);
    messageHeader.setMessageType(MessageType.REQUEST);
    messageHeader.setSaleID("001");
    messageHeader.setServiceID("001");
    messageHeader.setPOIID("P400Plus-123456789");

    saleToPOIRequest.setMessageHeader(messageHeader);

    PaymentRequest paymentRequest = new PaymentRequest();

    SaleData saleData = new SaleData();
    TransactionIDType transactionIdentification = new TransactionIDType();
    transactionIdentification.setTransactionID("001");
    OffsetDateTime timestamp = OffsetDateTime.now(ZoneOffset.UTC);
    transactionIdentification.setTimeStamp(timestamp);
    saleData.setSaleTransactionID(transactionIdentification);

    PaymentTransaction paymentTransaction = new PaymentTransaction();
    AmountsReq amountsReq = new AmountsReq();
    amountsReq.setCurrency("EUR");
    amountsReq.setRequestedAmount(BigDecimal.ONE);
    paymentTransaction.setAmountsReq(amountsReq);

    paymentRequest.setSaleData(saleData);
    paymentRequest.setPaymentTransaction(paymentTransaction);

    saleToPOIRequest.setPaymentRequest(paymentRequest);

    CloudDeviceApiRequest cloudDeviceApiRequest = new CloudDeviceApiRequest();
    cloudDeviceApiRequest.setSaleToPOIRequest(saleToPOIRequest);

    return cloudDeviceApiRequest;
  }
}
