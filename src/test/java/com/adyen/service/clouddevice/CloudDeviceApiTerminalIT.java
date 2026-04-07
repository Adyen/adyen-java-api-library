package com.adyen.service.clouddevice;

import com.adyen.BaseIntegrationTest;
import com.adyen.model.clouddevice.*;
import com.adyen.model.tapi.*;
import com.adyen.security.clouddevice.EncryptionCredentialDetails;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

/**
 * Verify Terminal integration: tests to send API requests to the Cloud Device API and test the
 * Terminal responds as expected.
 *
 * <p>Don't forget to:
 *
 * <ul>
 *   <li>Enable the terminal
 *   <li>Enable the test to run (by removing/commenting the {@code @Disabled} annotation)
 *   <li>Set required variables by creating {@code src/test/resources/config.properties}:
 * </ul>
 *
 * <pre>{@code
 * # Example of config.properties
 * ADYEN_API_KEY=
 * ADYEN_MERCHANT_ACCOUNT=MyMerchantAccount
 * ADYEN_TERMINAL_DEVICE_ID=V400m-1234567890
 * ADYEN_TERMINAL_DEVICE_KEY_IDENTIFIER=
 * ADYEN_TERMINAL_DEVICE_PASSPHRASE=
 * }</pre>
 *
 * <ul>
 *   <li>Run one test at a time with {@code mvn test -Dtest=CloudDeviceApiTerminalIT#sendSync}
 *   <li>Disable the test again
 * </ul>
 */
public class CloudDeviceApiTerminalIT extends BaseIntegrationTest {

  @Disabled("Enable when you want to test with the Terminal")
  @Test
  public void sendSync() throws Exception {

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(getClient());

    CloudDeviceApiRequest cloudDeviceApiRequest =
        createCloudDeviceAPIPaymentRequest(getTerminalDeviceId());

    var response =
        cloudDeviceApi.sync(getMerchantAccount(), getTerminalDeviceId(), cloudDeviceApiRequest);

    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getSaleToPOIResponse());
    Assertions.assertEquals(getTerminalDeviceId(), response.getSaleToPOIResponse().getMessageHeader().getPOIID());
  }

  @Disabled("Enable when you want to test with the Terminal")
  @Test
  public void sendAsync() throws Exception {

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(getClient());

    CloudDeviceApiRequest cloudDeviceApiRequest =
        createCloudDeviceAPIPaymentRequest(getTerminalDeviceId());

    var response =
        cloudDeviceApi.async(getMerchantAccount(), getTerminalDeviceId(), cloudDeviceApiRequest);

    Assertions.assertNotNull(response);
    Assertions.assertEquals("ok", response.getResult());
  }

  @Disabled("Enable when you want to test with the Terminal")
  @Test
  public void sendEncryptedSync() throws Exception {

    CloudDeviceApiRequest cloudDeviceApiRequest =
        createCloudDeviceAPIPaymentRequest(getTerminalDeviceId());

    EncryptionCredentialDetails encryptionCredentialDetails =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(1)
            .keyIdentifier(getTerminalDeviceKeyIdentifier())
            .keyVersion(1)
            .passphrase(getTerminalDevicePassphrase());

    EncryptedCloudDeviceApi encryptedCloudDeviceApi =
        new EncryptedCloudDeviceApi(getClient(), encryptionCredentialDetails);

    var response =
        encryptedCloudDeviceApi.sync(
            getMerchantAccount(), getTerminalDeviceId(), cloudDeviceApiRequest);

    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getSaleToPOIResponse());
    Assertions.assertEquals(getTerminalDeviceId(), response.getSaleToPOIResponse().getMessageHeader().getPOIID());
  }

  @Disabled("Enable when you want to test with the Terminal")
  @Test
  public void getConnectedDevices() throws Exception {

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(getClient());

    var response = cloudDeviceApi.getConnectedDevices(getMerchantAccount());

    Assertions.assertNotNull(response);
    Assertions.assertNotNull(response.getUniqueDeviceIds());
    Assertions.assertTrue(response.getUniqueDeviceIds().contains(getTerminalDeviceId()));
  }

  @Disabled("Enable when you want to test with the Terminal")
  @Test
  public void sendEncryptedAsync() throws Exception {

    CloudDeviceApiRequest cloudDeviceApiRequest =
        createCloudDeviceAPIPaymentRequest(getTerminalDeviceId());

    EncryptionCredentialDetails encryptionCredentialDetails =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(1)
            .keyIdentifier(getTerminalDeviceKeyIdentifier())
            .keyVersion(1)
            .passphrase(getTerminalDevicePassphrase());

    EncryptedCloudDeviceApi encryptedCloudDeviceApi =
        new EncryptedCloudDeviceApi(getClient(), encryptionCredentialDetails);

    var response =
        encryptedCloudDeviceApi.async(
            getMerchantAccount(), getTerminalDeviceId(), cloudDeviceApiRequest);

    Assertions.assertNotNull(response);
    Assertions.assertEquals("ok", response.getResult());
  }

  protected CloudDeviceApiRequest createCloudDeviceAPIPaymentRequest(String deviceId) {
    SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

    var randomId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);

    MessageHeader messageHeader = new MessageHeader();
    messageHeader.setProtocolVersion("3.0");
    messageHeader.setMessageClass(MessageClass.SERVICE);
    messageHeader.setMessageCategory(MessageCategory.PAYMENT);
    messageHeader.setMessageType(MessageType.REQUEST);
    messageHeader.setSaleID(randomId);
    messageHeader.setServiceID(randomId);
    messageHeader.setPOIID(deviceId);

    saleToPOIRequest.setMessageHeader(messageHeader);

    PaymentRequest paymentRequest = new PaymentRequest();

    SaleData saleData = new SaleData();
    TransactionIDType transactionIdentification = new TransactionIDType();
    transactionIdentification.setTransactionID(randomId);
    OffsetDateTime timestamp = OffsetDateTime.now(ZoneOffset.UTC);
    transactionIdentification.setTimeStamp(timestamp);
    saleData.setSaleTransactionID(transactionIdentification);

    PaymentTransaction paymentTransaction = new PaymentTransaction();
    AmountsReq amountsReq = new AmountsReq();
    amountsReq.setCurrency("EUR");
    amountsReq.setRequestedAmount(BigDecimal.TEN);
    paymentTransaction.setAmountsReq(amountsReq);

    paymentRequest.setSaleData(saleData);
    paymentRequest.setPaymentTransaction(paymentTransaction);

    saleToPOIRequest.setPaymentRequest(paymentRequest);

    CloudDeviceApiRequest cloudDeviceApiRequest = new CloudDeviceApiRequest();
    cloudDeviceApiRequest.setSaleToPOIRequest(saleToPOIRequest);

    return cloudDeviceApiRequest;
  }
}
