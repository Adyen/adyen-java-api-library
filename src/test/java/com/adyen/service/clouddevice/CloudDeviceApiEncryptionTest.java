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

public class CloudDeviceApiEncryptionTest extends BaseTest {

  @Test
  public void sendEncryptedSync() throws Exception {
    Client client =
        createMockClientFromFile("mocks/clouddevice/payment-sync-encrypted-success.json");

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();

    EncryptionCredentialDetails encryptionCredentialDetails =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(0)
            .keyIdentifier("CryptoKeyIdentifier12345")
            .keyVersion(0)
            .passphrase("p@ssw0rd123456");

    var response =
        cloudDeviceApi.syncEncrypted(
            "TestMerchantAccount",
            "MX915-284251016",
            cloudDeviceApiRequest,
            encryptionCredentialDetails);

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
    Client client = createMockClientFromFile("mocks/clouddevice/payment-async-success.json");

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();

    EncryptionCredentialDetails encryptionCredentialDetails =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(0)
            .keyIdentifier("CryptoKeyIdentifier12345")
            .keyVersion(0)
            .passphrase("p@ssw0rd123456");

    var response =
        cloudDeviceApi.asyncEncrypted(
            "TestMerchantAccount",
            "MX915-284251016",
            cloudDeviceApiRequest,
            encryptionCredentialDetails);

    Assertions.assertNotNull(response);
    Assertions.assertEquals("ok", response);

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
  public void decryptNotification() throws Exception {

    Client client = createMockClientFromResponse(""); // nop client
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    String payload = getFileContents("mocks/clouddevice/encrypted-event-notification.json");

    EncryptionCredentialDetails encryptionCredentialDetails =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(1)
            .keyIdentifier("Key123456789crypt")
            .keyVersion(1)
            .passphrase("P@ssw0rd123456");

    var response = cloudDeviceApi.decryptNotification(payload, encryptionCredentialDetails);

    Assertions.assertNotNull(response);
    assertFalse(response.contains("\"NexoBlob\":"));
    assertTrue(response.contains("\"PaymentResponse\":"));
  }

  @Test
  public void decryptNotificationInvalidPayload() throws Exception {

    Client client = createMockClientFromResponse(""); // nop client
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    String payload = "{...}";

    EncryptionCredentialDetails encryptionCredentialDetails =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(1)
            .keyIdentifier("Key123456789crypt")
            .keyVersion(1)
            .passphrase("P@ssw0rd123456");

    Assertions.assertThrows(
        NexoSecurityException.class,
        () -> cloudDeviceApi.decryptNotification(payload, encryptionCredentialDetails));
  }

  /** Point 8: decryptNotification must handle a SaleToPOIRequest envelope (event notification). */
  @Test
  public void decryptNotificationSaleToPOIRequest() throws Exception {
    Client client = createMockClientFromResponse("");
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    EncryptionCredentialDetails encryptionCredentialDetails =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(1)
            .keyIdentifier("CryptoKeyIdentifier12345")
            .keyVersion(1)
            .passphrase("p@ssw0rd123456");

    // Build a plaintext SaleToPOIRequest, encrypt it, and wrap it in the request envelope.
    String plaintextJson =
        "{\"SaleToPOIRequest\":{\"MessageHeader\":{\"MessageCategory\":\"Event\"}}}";
    MessageHeader messageHeader = new MessageHeader();
    messageHeader.setMessageClass(MessageClassType.EVENT);
    messageHeader.setMessageCategory(MessageCategoryType.EVENT);
    messageHeader.setMessageType(MessageType.NOTIFICATION);
    messageHeader.setSaleID("sale-001");
    messageHeader.setServiceID("svc-001");
    messageHeader.setPOIID("MX915-000000001");

    NexoSecurityManager manager = new NexoSecurityManager(encryptionCredentialDetails);
    SaleToPOISecuredMessage encryptedMessage = manager.encrypt(plaintextJson, messageHeader);

    CloudDeviceApiSecuredRequest securedRequest = new CloudDeviceApiSecuredRequest();
    securedRequest.setSaleToPOIRequest(encryptedMessage);
    String payload = securedRequest.toJson();

    String decrypted = cloudDeviceApi.decryptNotification(payload, encryptionCredentialDetails);

    Assertions.assertNotNull(decrypted);
    Assertions.assertFalse(decrypted.contains("\"NexoBlob\":"));
    Assertions.assertTrue(decrypted.contains("\"MessageHeader\""));
  }

  @Test
  public void syncEncryptedSetsPoiIdInEncryptedPayload() throws Exception {
    Client client =
        createMockClientFromFile("mocks/clouddevice/payment-sync-encrypted-success.json");
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    EncryptionCredentialDetails encryptionCredentialDetails =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(0)
            .keyIdentifier("CryptoKeyIdentifier12345")
            .keyVersion(0)
            .passphrase("p@ssw0rd123456");

    // Request has no POIID set — syncEncrypted must set it from deviceId before encrypting
    CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();
    cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader().setPOIID(null);

    cloudDeviceApi.syncEncrypted(
        "TestMerchantAccount",
        "MX915-284251016",
        cloudDeviceApiRequest,
        encryptionCredentialDetails);

    ArgumentCaptor<String> bodyCaptor = ArgumentCaptor.forClass(String.class);
    verify(client.getHttpClient())
        .request(anyString(), bodyCaptor.capture(), any(), anyBoolean(), isNull(), any(), any());

    // Decrypt the captured request body to inspect the plain MessageHeader
    String capturedJson = bodyCaptor.getValue();
    CloudDeviceApiSecuredRequest securedRequest =
        CloudDeviceApiSecuredRequest.fromJson(capturedJson);
    NexoSecurityManager manager = new NexoSecurityManager(encryptionCredentialDetails);
    String decryptedJson = manager.decrypt(securedRequest.getSaleToPOIRequest());

    Assertions.assertTrue(
        decryptedJson.contains("\"POIID\":\"MX915-284251016\""),
        "Encrypted payload must contain POIID set to deviceId, but was: " + decryptedJson);
  }

  @Test
  public void asyncEncryptedSetsPoiIdInEncryptedPayload() throws Exception {
    Client client = createMockClientFromFile("mocks/clouddevice/payment-async-success.json");
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    EncryptionCredentialDetails encryptionCredentialDetails =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(0)
            .keyIdentifier("CryptoKeyIdentifier12345")
            .keyVersion(0)
            .passphrase("p@ssw0rd123456");

    // Request has no POIID set — asyncEncrypted must set it from deviceId before encrypting
    CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();
    cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader().setPOIID(null);

    cloudDeviceApi.asyncEncrypted(
        "TestMerchantAccount",
        "MX915-284251016",
        cloudDeviceApiRequest,
        encryptionCredentialDetails);

    ArgumentCaptor<String> bodyCaptor = ArgumentCaptor.forClass(String.class);
    verify(client.getHttpClient())
        .request(anyString(), bodyCaptor.capture(), any(), anyBoolean(), isNull(), any(), any());

    // Decrypt the captured request body to inspect the plain MessageHeader
    String capturedJson = bodyCaptor.getValue();
    CloudDeviceApiSecuredRequest securedRequest =
        CloudDeviceApiSecuredRequest.fromJson(capturedJson);
    NexoSecurityManager manager = new NexoSecurityManager(encryptionCredentialDetails);
    String decryptedJson = manager.decrypt(securedRequest.getSaleToPOIRequest());

    Assertions.assertTrue(
        decryptedJson.contains("\"POIID\":\"MX915-284251016\""),
        "Encrypted payload must contain POIID set to deviceId, but was: " + decryptedJson);
  }

  protected CloudDeviceApiRequest createCloudDeviceAPIPaymentRequest() {
    SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

    MessageHeader messageHeader = new MessageHeader();
    messageHeader.setProtocolVersion("3.0");
    messageHeader.setMessageClass(MessageClassType.SERVICE);
    messageHeader.setMessageCategory(MessageCategoryType.PAYMENT);
    messageHeader.setMessageType(MessageType.REQUEST);
    messageHeader.setSaleID("001");
    messageHeader.setServiceID("001");
    messageHeader.setPOIID("P400Plus-123456789");

    saleToPOIRequest.setMessageHeader(messageHeader);

    PaymentRequest paymentRequest = new PaymentRequest();

    SaleData saleData = new SaleData();
    TransactionIdentification transactionIdentification = new TransactionIdentification();
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
