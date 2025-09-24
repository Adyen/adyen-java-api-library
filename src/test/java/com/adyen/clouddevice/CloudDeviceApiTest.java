package com.adyen.clouddevice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.verify;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import com.adyen.model.clouddevice.*;
import com.adyen.service.clouddevice.CloudDeviceApi;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Map;
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
