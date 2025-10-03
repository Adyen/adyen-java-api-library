### Using the Terminal API
For In-Person Payments integrations with the [Cloud Terminal API](https://docs.adyen.com/point-of-sale/design-your-integration/choose-your-architecture/cloud/), you must initialise the Client **setting the closest** [Region](https://docs.adyen.com/point-of-sale/design-your-integration/terminal-api/#cloud):
``` java
// Step 1: Import the required classes
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.service.TerminalCloudAPI;
import com.adyen.model.nexo.*;
import com.adyen.model.terminal.*;

// Step 2: Initialize the client object
Client client = new Client("Your YOUR_API_KEY", Environment.TEST);

// for LIVE environment use
// Config config = new Config();
// config.setEnvironment(Environment.LIVE);
// config.setTerminalApiRegion(Region.EU);
// Client client = new Client(config);

// Step 3: Initialize the API object
TerminalCloudAPI terminalCloudApi = new TerminalCloudAPI(client);

// Step 4: Create the request object
String serviceID = "123456789";
String saleID = "POS-SystemID12345";
String POIID = "Your Device Name(eg V400m-123456789)";

// Use a unique transaction for every other transaction you perform
String transactionID = "TransactionID";
TerminalAPIRequest terminalAPIRequest = new TerminalAPIRequest();
SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

MessageHeader messageHeader = new MessageHeader();
messageHeader.setMessageClass(MessageClassType.SERVICE);
messageHeader.setMessageCategory(MessageCategoryType.PAYMENT);
messageHeader.setMessageType(MessageType.REQUEST);
messageHeader.setProtocolVersion("3.0");
messageHeader.setServiceID(serviceID);
messageHeader.setSaleID(saleID);        
messageHeader.setPOIID(POIID);        

saleToPOIRequest.setMessageHeader(messageHeader);
        
com.adyen.model.nexo.PaymentRequest paymentRequest = new com.adyen.model.nexo.PaymentRequest();   
SaleData saleData = new SaleData();
TransactionIdentification transactionIdentification = new TransactionIdentification();
transactionIdentification.setTransactionID("001");
XMLGregorianCalendar timestamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
transactionIdentification.setTimeStamp(timestamp);
saleData.setSaleTransactionID(transactionIdentification);
      
SaleToAcquirerData saleToAcquirerData = new SaleToAcquirerData();
ApplicationInfo applicationInfo = new ApplicationInfo();
CommonField merchantApplication = new CommonField();
merchantApplication.setVersion("1");
merchantApplication.setName("Test");
applicationInfo.setMerchantApplication(merchantApplication);
saleToAcquirerData.setApplicationInfo(applicationInfo);
saleData.setSaleToAcquirerData(saleToAcquirerData);
      
PaymentTransaction paymentTransaction = new PaymentTransaction();
AmountsReq amountsReq = new AmountsReq();
amountsReq.setCurrency("EUR");
amountsReq.setRequestedAmount(BigDecimal.valueOf(1000));
paymentTransaction.setAmountsReq(amountsReq);
    
paymentRequest.setPaymentTransaction(paymentTransaction);
paymentRequest.setSaleData(saleData);

saleToPOIRequest.setPaymentRequest(paymentRequest);
  
terminalAPIRequest.setSaleToPOIRequest(saleToPOIRequest);

// Step 5: Make the request
TerminalAPIResponse terminalAPIResponse = terminalCloudApi.sync(terminalAPIRequest);
```

#### Optional: perform an abort request

To perform an [abort request](https://docs.adyen.com/point-of-sale/basic-tapi-integration/cancel-a-transaction/) you can use the following example:
``` java
TerminalAPIRequest terminalAPIRequest = new TerminalAPIRequest();
SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

MessageHeader messageHeader = new MessageHeader();
messageHeader.setMessageClass(MessageClassType.SERVICE);
messageHeader.setMessageCategory(MessageCategoryType.ABORT);
messageHeader.setMessageType(MessageType.REQUEST);
messageHeader.setProtocolVersion("3.0");
messageHeader.setServiceID("Different service ID");
messageHeader.setSaleID(saleID);        
messageHeader.setPOIID(POIID);

AbortRequest abortRequest = new AbortRequest();
abortRequest.setAbortReason("MerchantAbort");
MessageReference messageReference = new MessageReference();
messageReference.setMessageCategory(MessageCategoryType.PAYMENT);
messageReference.setSaleID(saleID);
messageReference.setPOIID(POIID);
// Service ID of the payment you're aborting
messageReference.setServiceID(serviceID);
abortRequest.setMessageReference(messageReference);

saleToPOIRequest.setAbortRequest(abortRequest);
saleToPOIRequest.setMessageHeader(messageHeader);

terminalAPIRequest.setSaleToPOIRequest(saleToPOIRequest);

TerminalAPIResponse terminalAPIResponse = terminalCloudApi.sync(terminalAPIRequest);
```

#### Optional: perform a status request

To perform a [status request](https://docs.adyen.com/point-of-sale/basic-tapi-integration/verify-transaction-status/) you can use the following example:
``` java
TerminalAPIRequest terminalAPIRequest = new TerminalAPIRequest();
SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

MessageHeader messageHeader = new MessageHeader();
messageHeader.setMessageClass(MessageClassType.SERVICE);
messageHeader.setMessageCategory(MessageCategoryType.TRANSACTION_STATUS);
messageHeader.setMessageType(MessageType.REQUEST);
messageHeader.setProtocolVersion("3.0");
messageHeader.setServiceID("Different service ID");
messageHeader.setSaleID(saleID);        
messageHeader.setPOIID(POIID);

TransactionStatusRequest transactionStatusRequest = new TransactionStatusRequest();
transactionStatusRequest.setReceiptReprintFlag(true);
transactionStatusRequest.getDocumentQualifier().add(DocumentQualifierType.CASHIER_RECEIPT);
transactionStatusRequest.getDocumentQualifier().add(DocumentQualifierType.CUSTOMER_RECEIPT);
MessageReference messageReference = new MessageReference();
messageReference.setMessageCategory(MessageCategoryType.PAYMENT);
messageReference.setSaleID(saleID);
// serviceID of the transaction you want the status update from
messageReference.setServiceID(serviceID);
transactionStatusRequest.setMessageReference(messageReference);

saleToPOIRequest.setTransactionStatusRequest(transactionStatusRequest);
saleToPOIRequest.setMessageHeader(messageHeader);

terminalAPIRequest.setSaleToPOIRequest(saleToPOIRequest);

TerminalAPIResponse terminalAPIResponse = terminalCloudApi.sync(terminalAPIRequest);
```
### Helper classes

Use `PredefinedContentHelper` to parse Display notification types which you find in `PredefinedContent->ReferenceID`
```java
PredefinedContentHelper helper = new PredefinedContentHelper(predefinedContent.getReferenceID());

// Safely extract and use the event type with Optional
helper.getEvent().ifPresent(event -> {
        System.out.println("Received event: " + event);
    if (event == PredefinedContentHelper.DisplayNotificationEvent.PIN_ENTERED) {
        // Handle PIN entry event
        System.out.println("The user has entered their PIN.");
    }
});
```

### Using the Local Terminal API Integration
The procedure to send In-Person requests using [Terminal API over Local Connection](https://docs.adyen.com/point-of-sale/design-your-integration/choose-your-architecture/local/) is similar to the Cloud Terminal API one, however, additional encryption details are required to perform the requests. Make sure to [install the certificate as described here](https://docs.adyen.com/point-of-sale/design-your-integration/choose-your-architecture/local/#protect-communications)
#### Local terminal API Using Keystore
```java
// Import the required classes
import com.adyen.Client;
import com.adyen.Config;
import com.adyen.enums.Environment;
import com.adyen.httpclient.TerminalLocalAPIHostnameVerifier;
import com.adyen.service.TerminalLocalAPI;
import com.adyen.model.terminal.security.*;
import com.adyen.model.terminal.*;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.security.KeyStore;
import java.security.SecureRandom;

// Create a KeyStore for the terminal certificate
KeyStore keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
keyStore.load(null, null);
keyStore.setCertificateEntry("adyenRootCertificate", adyenRootCertificate);

// Create a TrustManagerFactory that trusts the CAs in our KeyStore
TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
trustManagerFactory.init(keyStore);

// Create an SSLContext with the desired protocol that uses our TrustManagers
SSLContext sslContext = SSLContext.getInstance("SSL");
sslContext.init(null, trustManagerFactory.getTrustManagers(), new SecureRandom());

// Configure a client for TerminalLocalAPI
Config config = new Config();
config.setEnvironment(environment);
config.setTerminalApiLocalEndpoint("https://" + terminalIpAddress);
config.setSSLContext(sslContext);
config.setHostnameVerifier(new TerminalLocalAPIHostnameVerifier(environment));
Client client = new Client(config);

// Create your SecurityKey object used for encrypting the payload (keyIdentifier/passphrase you set up beforehand in CA)
SecurityKey securityKey = new SecurityKey();
securityKey.setKeyVersion(1);
securityKey.setAdyenCryptoVersion(1);
securityKey.setKeyIdentifier("keyIdentifier");
securityKey.setPassphrase("passphrase");

// Use TerminalLocalAPI
TerminalLocalAPI terminalLocalAPI = new TerminalLocalAPI(client, securityKey);
TerminalAPIResponse terminalAPIResponse = terminalLocalAPI.request(terminalAPIRequest);
```

#### Using the Local Terminal API Integration without Encryption (Only on TEST)
If you wish to develop the Local Terminal API integration parallel to your encryption implementation, you can opt for the unencrypted version. Be sure to remove any encryption details from the CA terminal config page. Consider this ONLY for development and testing on localhost.

```java
// Step 1: Import the required classes
import com.adyen.service.TerminalLocalAPI;
import com.adyen.model.nexo.*;
import com.adyen.model.terminal.*;
import javax.net.ssl.SSLContext;

// Step 2: Add your Certificate Path and Local Endpoint to the config path.
Client client = new Client();
client.getConfig().setTerminalApiLocalEndpoint("The IP of your terminal (eg https://192.168.47.169)");
client.getConfig().setEnvironment(Environment.TEST);
config.setSSLContext(createTrustSSLContext()); // Trust all certificates for testing only
client.setConfig(config);

// Step 3: Create an SSL context that accepts all certificates (Use in TEST only).
SSLContext createTrustSSLContext() throws Exception {
    TrustManager[] trustAllCerts = new TrustManager[]{
            new X509TrustManager() {
                java.security.cert.X509Certificate[] getAcceptedIssuers() { return null; }
                checkClientTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
                checkServerTrusted(java.security.cert.X509Certificate[] certs, String authType) {}
            }
    };
    SSLContext sc = SSLContext.getInstance("SSL");
    sc.init(null, trustAllCerts, new java.security.SecureRandom());
    return sc;
}

// Step 4: Construct a TerminalAPIRequest object
Gson gson = new GsonBuilder().create();
TerminalAPIRequest terminalAPIPaymentRequest = new TerminalAPIRequest();

// Step 5: Make the request
TerminalAPIResponse terminalAPIResponse = terminalLocalAPI.request(terminalAPIRequest);
```