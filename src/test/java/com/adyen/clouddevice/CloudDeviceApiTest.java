package com.adyen.clouddevice;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import com.adyen.model.clouddevice.*;
import com.adyen.security.clouddevice.EncryptionCredentialDetails;
import com.adyen.service.clouddevice.CloudDeviceApi;
import com.adyen.service.exception.CloudDeviceException;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;

public class CloudDeviceApiTest extends BaseTest {

  @Test
  public void sendSync() throws Exception {
    Client client = createMockClientFromFile("mocks/clouddevice/payment-sync-success.json");

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();

    var response =
        cloudDeviceApi.sendSync("myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);

    assertNotNull(response);
    assertNotNull(response.getSaleToPOIResponse());
    assertNotNull(response.getSaleToPOIResponse().getMessageHeader());
    assertEquals(
        "P400Plus-123456789", response.getSaleToPOIResponse().getMessageHeader().getPOIID());

    verify(client.getHttpClient())
        .request(
            "https://device-api-test.adyen.com/v1/merchants/myMerchant/devices/P400Plus-123456789/sync",
            cloudDeviceApiRequest.toJson(),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void sendAsync() throws Exception {
    Client client = createMockClientFromFile("mocks/clouddevice/payment-async-success.json");

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();

    var response =
        cloudDeviceApi.sendAsync("myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);

    assertNotNull(response);
    assertNotNull("ok", response);
    assertNull(response.getSaleToPOIRequest());

    verify(client.getHttpClient())
        .request(
            "https://device-api-test.adyen.com/v1/merchants/myMerchant/devices/P400Plus-123456789/async",
            cloudDeviceApiRequest.toJson(),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void sendAsyncReturningError() throws Exception {
    Client client = createMockClientFromFile("mocks/clouddevice/payment-async-error.json");

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();

    var response =
        cloudDeviceApi.sendAsync("myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);

    assertNotNull(response);
    assertNull(response.getResult());
    assertNotNull(response.getSaleToPOIRequest());

    assertEquals(
        "Invalid event",
        EventToNotifyType.REJECT,
        response.getSaleToPOIRequest().getEventNotification().getEventToNotify());

    verify(client.getHttpClient())
        .request(
            "https://device-api-test.adyen.com/v1/merchants/myMerchant/devices/P400Plus-123456789/async",
            cloudDeviceApiRequest.toJson(),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

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
        cloudDeviceApi.sendEncryptedSync(
            "TestMerchantAccount",
            "MX915-284251016",
            cloudDeviceApiRequest,
            encryptionCredentialDetails);

    assertNotNull(response);
    assertNotNull(response.getSaleToPOIResponse());
    assertNotNull(response.getSaleToPOIResponse().getMessageHeader());
    assertEquals("MX915-284251016", response.getSaleToPOIResponse().getMessageHeader().getPOIID());

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
        cloudDeviceApi.sendEncryptedAsync(
            "TestMerchantAccount",
            "MX915-284251016",
            cloudDeviceApiRequest,
            encryptionCredentialDetails);

    assertNotNull(response);
    assertEquals("ok", response);

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
  public void getConnectedDevices() throws Exception {
    Client client = createMockClientFromFile("mocks/clouddevice/connected-devices.json");
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    ConnectedDevicesResponse response = cloudDeviceApi.getConnectedDevices("myMerchant");

    assertNotNull(response);
    assertEquals(2, response.getUniqueDeviceIds().size());
    assertEquals("P400Plus-123456789", response.getUniqueDeviceIds().get(0));
    assertEquals("V400m-123456789", response.getUniqueDeviceIds().get(1));

    verify(client.getHttpClient())
        .request(
            "https://device-api-test.adyen.com/v1/merchants/myMerchant/connectedDevices",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  public void getConnectedDevicesWithStore() throws Exception {
    Client client = createMockClientFromFile("mocks/clouddevice/connected-devices.json");
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    ConnectedDevicesResponse response = cloudDeviceApi.getConnectedDevices("myMerchant", "myStore");

    assertNotNull(response);
    assertEquals(2, response.getUniqueDeviceIds().size());
    assertEquals("P400Plus-123456789", response.getUniqueDeviceIds().get(0));
    assertEquals("V400m-123456789", response.getUniqueDeviceIds().get(1));

    verify(client.getHttpClient())
        .request(
            "https://device-api-test.adyen.com/v1/merchants/myMerchant/connectedDevices",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            Map.of("store", "myStore"));
  }

  @Test
  public void getDeviceStatus() throws Exception {
    Client client = createMockClientFromFile("mocks/clouddevice/status-device.json");
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    DeviceStatusResponse response =
        cloudDeviceApi.getDeviceStatus("myMerchant", "AMS1-000168242800763");

    assertNotNull(response);
    assertEquals("AMS1-000168242800763", response.getDeviceId());
    assertEquals(DeviceStatus.ONLINE, response.getStatus());

    verify(client.getHttpClient())
        .request(
            "https://device-api-test.adyen.com/v1/merchants/myMerchant/devices/AMS1-000168242800763/status",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
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

    assertNotNull(response);
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

    Assert.assertThrows(
        CloudDeviceException.class,
        () -> cloudDeviceApi.decryptNotification(payload, encryptionCredentialDetails));
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
