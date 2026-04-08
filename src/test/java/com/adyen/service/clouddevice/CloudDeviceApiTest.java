package com.adyen.service.clouddevice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.Config;
import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.enums.Region;
import com.adyen.model.clouddevice.*;
import com.adyen.model.tapi.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CloudDeviceApiTest extends BaseTest {

  @Test
  public void baseUrlOnTest() {
    Client client = new Client(new Config().apiKey("test").environment(Environment.TEST));

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);
    assertEquals(
        String.format("https://device-api-test.adyen.com/v%s", CloudDeviceApi.API_VERSION),
        cloudDeviceApi.baseURL);
  }

  @Test
  public void baseUrlOnLive() {
    Client client = new Client(new Config().apiKey("test").environment(Environment.LIVE));

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);
    assertEquals(
        String.format("https://device-api-live.adyen.com/v%s", CloudDeviceApi.API_VERSION),
        cloudDeviceApi.baseURL);
  }

  @Test
  public void baseUrlOnLivePreservesVersionPath() {
    Client client = new Client(new Config().apiKey("test").environment(Environment.LIVE));

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);
    assertEquals(
        String.format("https://device-api-live.adyen.com/v%s", CloudDeviceApi.API_VERSION),
        cloudDeviceApi.baseURL);
  }

  @Test
  public void baseUrlOnLiveWithEuRegion() {
    Client client =
        new Client(
            new Config().apiKey("test").environment(Environment.LIVE).terminalApiRegion(Region.EU));

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);
    assertEquals(
        String.format("https://device-api-live.adyen.com/v%s", CloudDeviceApi.API_VERSION),
        cloudDeviceApi.baseURL);
  }

  @Test
  public void baseUrlOnLiveWithRegion() {
    Client client =
        new Client(
            new Config().apiKey("test").environment(Environment.LIVE).terminalApiRegion(Region.US));

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);
    assertEquals(
        String.format("https://device-api-live-us.adyen.com/v%s", CloudDeviceApi.API_VERSION),
        cloudDeviceApi.baseURL);
  }

  @Test
  public void sendSync() throws Exception {
    Client client = createMockClientFromFile("mocks/clouddevice/payment-sync-success.json");

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();

    var response = cloudDeviceApi.sync("myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);

    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getSaleToPOIResponse());
    Assertions.assertNotNull(response.getSaleToPOIResponse().getMessageHeader());
    Assertions.assertEquals(
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

    var response = cloudDeviceApi.async("myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);

    Assertions.assertNotNull(response);
    Assertions.assertEquals("ok", response.getResult());
    Assertions.assertNull(response.getSaleToPOIRequest());

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

    var response = cloudDeviceApi.async("myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);

    Assertions.assertNotNull(response);
    Assertions.assertNull(response.getResult());
    Assertions.assertNotNull(response.getSaleToPOIRequest());

    Assertions.assertEquals(
        EventToNotify.REJECT,
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
  public void getConnectedDevices() throws Exception {
    Client client = createMockClientFromFile("mocks/clouddevice/connected-devices.json");
    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

    ConnectedDevicesResponse response = cloudDeviceApi.getConnectedDevices("myMerchant");

    Assertions.assertNotNull(response);
    Assertions.assertEquals(2, response.getUniqueDeviceIds().size());
    Assertions.assertEquals("P400Plus-123456789", response.getUniqueDeviceIds().get(0));
    Assertions.assertEquals("V400m-123456789", response.getUniqueDeviceIds().get(1));

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

    Assertions.assertNotNull(response);
    Assertions.assertEquals(2, response.getUniqueDeviceIds().size());
    Assertions.assertEquals("P400Plus-123456789", response.getUniqueDeviceIds().get(0));
    Assertions.assertEquals("V400m-123456789", response.getUniqueDeviceIds().get(1));

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

    Assertions.assertNotNull(response);
    Assertions.assertEquals("AMS1-000168242800763", response.getDeviceId());
    Assertions.assertEquals(DeviceStatus.ONLINE, response.getStatus());

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
