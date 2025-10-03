package com.adyen.clouddevice;

import static org.junit.Assert.assertNotNull;

import com.adyen.BaseIntegrationTest;
import com.adyen.model.clouddevice.*;
import com.adyen.security.clouddevice.EncryptionCredentialDetails;
import com.adyen.service.clouddevice.CloudDeviceApi;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.UUID;
import org.junit.Ignore;
import org.junit.Test;

/**
 * Verify Terminal integration: tests to send API requests to the Cloud Device API and test the
 * Terminal responds as expected.
 *
 * <p>Don't forget to: - Enable the terminal - Enable the test to run (by removing/comment
 * the @Ignore annotation) - Set required variables (ADYEN_API_KEY, ADYEN_MERCHANT_ACCOUNT,
 * ADYEN_TERMINAL_DEVICE_ID) creating the src/main/resources/config.properties file:
 *
 * <p># Adyen Test Credentials ADYEN_API_KEY=##### ADYEN_MERCHANT_ACCOUNT=MyMerchantAccount
 * ADYEN_TERMINAL_DEVICE_ID=V400m-1234567890 # Terminal configuration
 * ADYEN_TERMINAL_DEVICE_KEY_IDENTIFIER==##### ADYEN_TERMINAL_DEVICE_PASSPHRASE==#####
 *
 * <p>- Run one test at the time with `mvn test -Dtest=CloudDeviceApiTerminalTest#sendSync` -
 * Disable the test again
 */
public class CloudDeviceApiTerminalTest extends BaseIntegrationTest {

  @Ignore // enable when you want to test with the Terminal
  @Test
  public void sendSync() throws Exception {

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(getClient());

    CloudDeviceApiRequest cloudDeviceApiRequest =
        createCloudDeviceAPIPaymentRequest(getTerminalDeviceId());

    var response =
        cloudDeviceApi.sendSync(getMerchantAccount(), getTerminalDeviceId(), cloudDeviceApiRequest);

    assertNotNull(response);
    System.out.println("Response: " + response);
  }

  @Ignore // enable when you want to test with the Terminal
  @Test
  public void sendAsync() throws Exception {

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(getClient());

    CloudDeviceApiRequest cloudDeviceApiRequest =
        createCloudDeviceAPIPaymentRequest(getTerminalDeviceId());

    cloudDeviceApiRequest.getSaleToPOIRequest().setPaymentRequest(null);

    var response =
        cloudDeviceApi.sendAsync(
            getMerchantAccount(), getTerminalDeviceId(), cloudDeviceApiRequest);

    assertNotNull(response);
    System.out.println("Response: " + response);
  }

  @Ignore // enable when you want to test with the Terminal
  @Test
  public void sendEncryptedSync() throws Exception {

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(getClient());

    CloudDeviceApiRequest cloudDeviceApiRequest =
        createCloudDeviceAPIPaymentRequest(getTerminalDeviceId());

    EncryptionCredentialDetails encryptionCredentialDetails =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(1)
            .keyIdentifier(getTerminalDeviceKeyIdentifier())
            .keyVersion(1)
            .passphrase(getTerminalDevicePassphrase());

    var response =
        cloudDeviceApi.sendEncryptedSync(
            getMerchantAccount(),
            getTerminalDeviceId(),
            cloudDeviceApiRequest,
            encryptionCredentialDetails);

    assertNotNull(response);
    System.out.println("Response: " + response);
  }

  @Ignore // enable when you want to test with the Terminal
  @Test
  public void sendEncryptedAsync() throws Exception {

    CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(getClient());

    CloudDeviceApiRequest cloudDeviceApiRequest =
        createCloudDeviceAPIPaymentRequest(getTerminalDeviceId());

    EncryptionCredentialDetails encryptionCredentialDetails =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(1)
            .keyIdentifier(getTerminalDeviceKeyIdentifier())
            .keyVersion(1)
            .passphrase(getTerminalDevicePassphrase());

    var response =
        cloudDeviceApi.sendEncryptedAsync(
            getMerchantAccount(),
            getTerminalDeviceId(),
            cloudDeviceApiRequest,
            encryptionCredentialDetails);

    assertNotNull(response);
    System.out.println("Response: " + response);
  }

  protected CloudDeviceApiRequest createCloudDeviceAPIPaymentRequest(String deviceId) {
    SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

    var randomId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 10);

    MessageHeader messageHeader = new MessageHeader();
    messageHeader.setProtocolVersion("3.0");
    messageHeader.setMessageClass(MessageClassType.SERVICE);
    messageHeader.setMessageCategory(MessageCategoryType.PAYMENT);
    messageHeader.setMessageType(MessageType.REQUEST);
    messageHeader.setSaleID(randomId);
    messageHeader.setServiceID(randomId);
    messageHeader.setPOIID(deviceId);

    saleToPOIRequest.setMessageHeader(messageHeader);

    PaymentRequest paymentRequest = new PaymentRequest();

    SaleData saleData = new SaleData();
    TransactionIdentification transactionIdentification = new TransactionIdentification();
    transactionIdentification.setTransactionID(randomId);
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
