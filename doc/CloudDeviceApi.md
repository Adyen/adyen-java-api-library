# Cloud device API

The [Cloud device API](https://docs.adyen.com/api-explorer/cloud-device-api/1/overview) is our solution to create best-in-class in-person payments integrations.

With the Cloud device API you can:

- send Terminal API requests to a cloud endpoint. You can use this communication method when it is not an option to send Terminal API requests over your local network directly to a payment terminal.
- check the cloud connection of a payment terminal or of a device used in a Mobile solution for in-person payments.

## Benefits of the Cloud device API

The Cloud device API offers the following benefits:
- access to API logs in the Customer Area for troubleshooting errors
- using a version strategy for the API endpoints for controlled and safer rollouts
- improved reliability and security (OAuth support)

New features and products will be released exclusively on the Cloud device API

## Use the Cloud device API

### Setup

First you must initialise the Client **setting the closest** [Region](https://docs.adyen.com/point-of-sale/design-your-integration/terminal-api/#cloud):
``` java
// Import the required classes
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.service.clouddevice.CloudDeviceApi;
import com.adyen.model.clouddevice.*;
import com.adyen.model.tapi.*;

// Setup Client and Service
Client client = new Client("YOUR_API_KEY", Environment.TEST);
CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

```

### Send a payment SYNC request

```java

SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

MessageHeader messageHeader = new MessageHeader();
    messageHeader.setProtocolVersion("3.0");
    messageHeader.setMessageClass(MessageClass.SERVICE);
    messageHeader.setMessageCategory(MessageCategory.PAYMENT);
    messageHeader.setMessageType(MessageType.REQUEST);
    messageHeader.setSaleID("001");
    messageHeader.setServiceID("001");
    // POIID is set automatically from the deviceId parameter
    saleToPOIRequest.setMessageHeader(messageHeader);

PaymentRequest paymentRequest = new PaymentRequest();

SaleData saleData = new SaleData();
TransactionIDType transactionIDType = new TransactionIDType();
    transactionIDType.setTransactionID("001");
OffsetDateTime timestamp = OffsetDateTime.now(ZoneOffset.UTC);
    transactionIDType.setTimeStamp(timestamp);
    saleData.setSaleTransactionID(transactionIDType);

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

CloudDeviceApiResponse response = cloudDeviceApi.sync("myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);

```


### Send a payment ASYNC request

If you choose to receive the response asynchronously, you only need to use a different method (`async`).
Don't forget to set up [event notifications](https://docs.adyen.com/point-of-sale/design-your-integration/notifications/event-notifications/) in the CA to be able to receive the Cloud device API responses.

```java

...

// define the request (same as per sync)
CloudDeviceApiRequest cloudDeviceApiRequest = new CloudDeviceApiRequest();
cloudDeviceApiRequest.setSaleToPOIRequest(saleToPOIRequest);

CloudDeviceApiAsyncResponse response = cloudDeviceApi.async("myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);

if ("ok".equals(response.getResult())) {
    // success	
} else {
    // request failed: see details in the EventNotification object
    EventNotification eventNotification = response.getSaleToPOIRequest().getEventNotification();
}
```

### Verify the status of the terminals


The Cloud device API allows your integration to check the status of the terminals.

```java

// list of payment terminals or SDK mobile installation IDs
ConnectedDevicesResponse connectedDevices = cloudDeviceApi.getConnectedDevices("myMerchant");
System.out.println(connectedDevices.getUniqueDeviceIds());

// check the payment terminal or SDK mobile installation ID 
DeviceStatusResponse deviceStatus = cloudDeviceApi.getDeviceStatus("myMerchant", "AMS1-000168242800763");
System.out.println(deviceStatus.getStatus());
```

### Protect cloud communication

The Adyen Java library supports encrypting request and response payloads, allowing you to secure communication between your integration and the cloud.

```java

//  Encryption credentials from the Terminal configuration on CA
EncryptionCredentialDetails encryptionCredentialDetails =
    new EncryptionCredentialDetails()
        .adyenCryptoVersion(0)
        .keyIdentifier("CryptoKeyIdentifier12345")
        .keyVersion(0)
        .passphrase("p@ssw0rd123456");

// Use EncryptedCloudDeviceApi instead of CloudDeviceApi
EncryptedCloudDeviceApi encryptedCloudDeviceApi =
    new EncryptedCloudDeviceApi(client, encryptionCredentialDetails);

CloudDeviceApiResponse response =
    encryptedCloudDeviceApi.sync(
        "TestMerchantAccount",
        "V400m-123456789",
        cloudDeviceApiRequest);

System.out.println(response);
```

In case of asynchronous integration, you can decrypt the payload of the event notifications using `decryptNotification()` method.

```java
// JSON with encrypted SaleToPOIResponse (for async responses) or SaleToPOIRequest (for event notifications) 
var payload = "...";

var decryptedPayload = encryptedCloudDeviceApi.decryptNotification(payload);
System.out.println(decryptedPayload);

```