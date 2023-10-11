![Java](https://user-images.githubusercontent.com/62436079/207377920-a87d7662-bc6a-496b-8d02-27c0a425e947.png)

# Adyen Java API Library

[![Maven Central](https://img.shields.io/maven-central/v/com.adyen/adyen-java-api-library)](https://central.sonatype.com/artifact/com.adyen/adyen-java-api-library/)

This is the officially supported Java library for using Adyen's APIs.

## Supported API versions

The Library supports all APIs under the following services:

| API                                                                                                                          | Description                                                                                                                                                                                                                                                                                                       | Service Name                             | Supported version |
|------------------------------------------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------|-------------------|
| [BIN lookup API](https://docs.adyen.com/api-explorer/BinLookup/54/overview)                                                  | The BIN Lookup API provides endpoints for retrieving information based on a given BIN.                                                                                                                                                                                                                            | BinLookup                                | **v54**           |
| [Capital API](https://docs.adyen.com/api-explorer/capital/3/overview)                                                        | Adyen Capital allows you to build an embedded financing offering for your users to serve their operational needs.                                                                                                                                                                                                 | Capital                                  | **v3**            |
| [Checkout API](https://docs.adyen.com/api-explorer/Checkout/70/overview)                                                     | Our latest integration for accepting online payments.                                                                                                                                                                                                                                                             | Checkout                                 | **v70**           |
| [Configuration API](https://docs.adyen.com/api-explorer/balanceplatform/2/overview)                                          | The Configuration API enables you to create a platform where you can onboard your users as account holders and create balance accounts, cards, and business accounts.                                                                                                                                             | balanceplatform package subclasses       | **v2**            |
| [DataProtection API](https://docs.adyen.com/development-resources/data-protection-api)                                       | Adyen Data Protection API provides a way for you to process [Subject Erasure Requests](https://gdpr-info.eu/art-17-gdpr/) as mandated in GDPR. Use our API to submit a request to delete shopper's data, including payment details and other related information (for example, delivery address or shopper email) | DataProtection                           | **v1**            |
| [Legal Entity Management API](https://docs.adyen.com/api-explorer/legalentity/3/overview)                                    | Manage legal entities that contain information required for verification.                                                                                                                                                                                                                                         | legalentitymanagement package subclasses | **v3**            |
| [Local/Cloud-based Terminal API](https://docs.adyen.com/point-of-sale/terminal-api-reference)                                | Our point-of-sale integration.                                                                                                                                                                                                                                                                                    | TerminalLocalAPI or TerminalCloudAPI     | -                 |
| [Management API](https://docs.adyen.com/api-explorer/Management/1/overview)                                                  | Configure and manage your Adyen company and merchant accounts, stores, and payment terminals.                                                                                                                                                                                                                     | management package subclasses            | **v1**            |
| [Payments API](https://docs.adyen.com/api-explorer/Payment/68/overview)                                                      | Our classic integration for online payments.                                                                                                                                                                                                                                                                      | Payment                                  | **v68**           |
| [Payouts API](https://docs.adyen.com/api-explorer/Payout/68/overview)                                                        | Endpoints for sending funds to your customers.                                                                                                                                                                                                                                                                    | Payout                                   | **v68**           |
| [POS Terminal Management API](https://docs.adyen.com/api-explorer/postfmapi/1/overview)                                      | Endpoints for managing your point-of-sale payment terminals.                                                                                                                                                                                                                                                      | TerminalManagement                       | **v1**            |
| [Recurring API](https://docs.adyen.com/api-explorer/Recurring/68/overview)                                                   | Endpoints for managing saved payment details.                                                                                                                                                                                                                                                                     | Recurring                                | **v68**           |
| [Stored Value API](https://docs.adyen.com/payment-methods/gift-cards/stored-value-api)                                       | Manage both online and point-of-sale gift cards and other stored-value cards.                                                                                                                                                                                                                                     | StoredValue                              | **v46**           |
| [Transfers API](https://docs.adyen.com/api-explorer/transfers/3/overview)                                                    | The Transfers API provides endpoints that can be used to get information about all your transactions, move funds within your balance platform or send funds from your balance platform to a transfer instrument.                                                                                                  | Transfers                                | **v3**            |
| [Webhooks](https://docs.adyen.com/api-explorer/Webhooks/1/overview)                                                          | Adyen uses webhooks to send notifications about payment status updates, newly available reports, and other events that can be subscribed to. For more information, refer to our [documentation](https://docs.adyen.com/development-resources/webhooks).                                                           | *Models only*                            | **v1**            |
| [Classic Platforms Account API](https://docs.adyen.com/api-explorer/Account/6/overview)                                      | This API is used for the classic integration. If you are just starting your implementation, refer to our new integration guide instead.                                                                                                                                                                           | ClassicPlatformAccountApi                | **v6**            |
| [Classic Platforms Fund API](https://docs.adyen.com/api-explorer/Fund/6/overview)                                            | This API is used for the classic integration. If you are just starting your implementation, refer to our new integration guide instead.                                                                                                                                                                           | ClassicPlatformFundApi                   | **v6**            |
| [Classic Platforms Hosted Onboarding Page API](https://docs.adyen.com/api-explorer/Hop/6/overview)                           | This API is used for the classic integration. If you are just starting your implementation, refer to our new integration guide instead.                                                                                                                                                                           | ClassicPlatformHopApi                    | **v6**            |
| [Classic Platforms Notification Configuration API](https://docs.adyen.com/api-explorer/NotificationConfiguration/6/overview) | This API is used for the classic integration. If you are just starting your implementation, refer to our new integration guide instead.                                                                                                                                                                           | ClassicPlatformConfigurationApi          | **v6**            |

## Supported Webhook versions
The library supports all webhooks under the following model directories:

| Webhooks                                                                                          | Description                                                                                                                                                                                | Model Name                                                                   | Supported Version |
|---------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------------------------------------------|-------------------|
| [Authentication Webhooks](https://docs.adyen.com/api-explorer/acs-webhook/1/overview)             | Adyen sends this webhook when the process of cardholder authentication is finalized, whether it is completed successfully, fails, or expires.                                              | [acswebhooks](src/main/java/com/adyen/model/acswebhooks)                     | **v1**            |
| [Configuration Webhooks](https://docs.adyen.com/api-explorer/balanceplatform-webhooks/1/overview) | You can use these webhooks to build your implementation. For example, you can use this information to update internal statuses when the status of a capability is changed.                 | [configurationwebhooks](src/main/java/com/adyen/model/configurationwebhooks) | **v1**            |
| [Transfer Webhooks](https://docs.adyen.com/api-explorer/transfer-webhooks/3/overview)             | You can use these webhooks to build your implementation. For example, you can use this information to update balances in your own dashboards or to keep track of incoming funds.           | [transferwebhooks](src/main/java/com/adyen/model/transferwebhooks)           | **v3**            |
| [Report Webhooks](https://docs.adyen.com/api-explorer/report-webhooks/1/overview)                 | You can download reports programmatically by making an HTTP GET request, or manually from your Balance Platform Customer Area                                                              | [reportwebhooks](src/main/java/com/adyen/model/reportwebhooks)               | **v1**            |
| [Notification Webhooks](https://docs.adyen.com/api-explorer/Webhooks/1/overview)                  | We use webhooks to send you updates about payment status updates, newly available reports, and other events that you can subscribe to. For more information, refer to our documentation    | [notification](src/main/java/com/adyen/model/notification)                   | **v1**            |
| [Management Webhooks](https://docs.adyen.com/api-explorer/ManagementNotification/1/overview)      | Adyen uses webhooks to inform your system about events that happen with your Adyen company and merchant accounts, stores, payment terminals, and payment methods when using Management API | [managementwebhooks](src/main/java/com/adyen/model/managementwebhooks)       | **v1**            |

For more information, refer to our [documentation](https://docs.adyen.com/) or
the [API Explorer](https://docs.adyen.com/api-explorer/).

## Prerequisites

* [Adyen test account](https://docs.adyen.com/get-started-with-adyen)
* [API key](https://docs.adyen.com/development-resources/api-credentials#generate-api-key). For testing, your API
  credential needs to have
  the [API PCI Payments role](https://docs.adyen.com/development-resources/api-credentials#roles).
* Java 11 or higher

## Installation

You can use Maven and add this dependency to your project's POM:

```
<dependency>
  <groupId>com.adyen</groupId>
  <artifactId>adyen-java-api-library</artifactId>
  <version>21.5.0</version>
</dependency>
```

Alternatively, you can download the [release on GitHub](https://github.com/Adyen/adyen-java-api-library/releases).

## Using the library

### General use with API key

Every API the library supports is represented by a service object. The name of the service matching the corresponding
API is listed in the [Supported API versions](#supported-api-versions) section of this document.

~~~~ java
// Import the required classes
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.service.checkout.PaymentsApi;
import com.adyen.model.checkout.*;

// Setup Client and Service
Client client = new Client("Your X-API-KEY", Environment.TEST);
PaymentsApi paymentsApi = new PaymentsApi(client);

// Create PaymentRequest 
PaymentRequest paymentRequest = new PaymentRequest();
paymentRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
CardDetails cardDetails = new CardDetails();
    cardDetails.encryptedCardNumber("test_4111111111111111")
        .encryptedSecurityCode("test_737")
        .encryptedExpiryMonth("test_03")
        .encryptedExpiryYear("test_2030");
paymentRequest.setPaymentMethod(new CheckoutPaymentMethod(cardDetails));
Amount amount = new Amount().currency("EUR").value(1000L);
paymentRequest.setAmount(amount);
paymentRequest.setReference("Your order number");
paymentRequest.setReturnUrl("https://your-company.com/checkout?shopperOrder=12xy..");

// Make a call to the /payments endpoint
PaymentResponse paymentResponse = paymentsApi.payments(paymentRequest);

~~~~
 
### General use with API key for live environment
For requests on live environment, you need to pass the [Live URL Prefix](https://docs.adyen.com/development-resources/live-endpoints#live-url-prefix) to the Client object:
~~~~ java
// Import the required classes
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.service.checkout.ModificationsApi

// Setup Client and Service
Client client = new Client("Your X-API-KEY", Environment.LIVE, "Your live URL prefix");
ModificationsApi modificationsApi = new ModificationsApi(client);

...
~~~~
### General use with basic auth
~~~~ java
// Import the required classes
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.service.checkout.PaymentLinksApi

// Setup Client and Service
Client client = new Client("Your username", "Your password", Environment.LIVE, "Your live URL prefix", "Your application name");
PaymentLinksApi paymentLinksApi = new PaymentLinksApi(client);
 
...
~~~~
### Using notification webhooks parser
~~~~ java
// Import the required classes
import java.util.List;
import com.adyen.util.HMACValidator;
import com.adyen.notification.WebhookHandler;
import com.adyen.model.notification.NotificationRequest;
import com.adyen.model.notification.NotificationRequestItem;

// YOUR_HMAC_KEY from the Customer Area
String hmacKey = "YOUR_HMAC_KEY";
String notificationRequestJson = "NOTIFICATION_REQUEST_JSON";
HMACValidator hmacValidator = new HMACValidator();

WebhookHandler webhookHandler = new WebhookHandler();
NotificationRequest notificationRequest = webhookHandler.handleNotificationJson(notificationRequestJson);

// fetch first (and only) NotificationRequestItem
var notificationRequestItem = notificationRequest.getNotificationItems().stream().findFirst();

if (notificationRequestItem.isPresent()) {
    if ( hmacValidator.validateHMAC(notificationRequestItem, hmacKey) ) {
      // Process the notification based on the eventCode
      log.info("Received webhook with event {} : \n" +
        "Merchant Reference: {}\n" +
        "Alias : {}\n" +
        "PSP reference : {}", 
        notificationRequestItem.getEventCode(), 
        notificationRequestItem.getMerchantReference(),
        notificationRequestItem.getAdditionalData().get("alias"),
        notificationRequestItem.getPspReference());
    } else {
      // Non valid NotificationRequest
	  throw new RuntimeException("Invalid HMAC signature");
    }
}
~~~~
If you would like to deserialize the Banking Webhooks, first check if the payload is authentic: 
~~~~ java
String payload = "WEBHOOK_PAYLOAD";
String signKey = "SIGNATURE_RETREIVED_FROM_CA";
String hmacKey = "HMACKEY_RETREIVED_FROM_WEBHOOK_HEADER";
HMACValidator hmacValidator = new HMACValidator();
boolean authenticity = hmacValidator.validateHMAC(hmacKey, signKey, payload);
~~~~
If this bool returns true, one can proceed to deserialize against the desired webhook type:
~~~~ java
BankingWebhookHandler webhookHandler = new BankingWebhookHandler(payload);
// onAccountHolderNotificationRequest
webhookHandler.getAccountHolderNotificationRequest().ifPresent((AccountHolderNotificationRequest event) -> {
    System.out.println(event.getData().getBalancePlatform());
});
// onBalanceAccountNotificationRequest
webhookHandler.getBalanceAccountNotificationRequest().ifPresent((BalanceAccountNotificationRequest event) -> {
    System.out.println(event.getData().getBalanceAccount());
});

~~~~
To deserialize Management Webhooks instead, please use the specific webhook handler:
~~~~ java
ManagementWebhookHandler webhookHandler = new ManagementWebhookHandler(payload);
// onMerchantCreatedNotificationRequest
webhookHandler.getMerchantCreatedNotificationRequest().isPresent((MerchantCreatedNotificationRequest event) -> {
System.out.println(event.getData().getMerchantId());
});
~~~~

### Proxy configuration
You can configure a proxy connection by injecting your own AdyenHttpClient on your client instance.

Example:
~~~~ java
...
// Import the required classes
import com.adyen.httpclient.AdyenHttpClient;
import java.net.InetSocketAddress;
import java.net.Proxy;

// Set http proxy
AdyenHttpClient adyenHttpClientWithProxy = new AdyenHttpClient();

Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("PROXY_HOST", PROXY_PORT));
adyenHttpClientWithProxy.setProxy(proxy);

client.setHttpClient(adyenHttpClientWithProxy);
~~~~

If your proxy requires authentication, set all the settings as system properties instead (don't mix with previous approach), for example: 

~~~~ java
System.setProperty("https.proxyHost", "127.0.0.1");
System.setProperty("https.proxyPort", "3128");
System.setProperty("https.proxyUser", "squid");
System.setProperty("https.proxyPassword", "ward");
~~~~

## Using the Cloud Terminal API Integration
In order to submit In-Person requests with [Terminal API over Cloud](https://docs.adyen.com/point-of-sale/design-your-integration/choose-your-architecture/cloud/) you need to initialize the client in a similar way as the steps listed above for Ecommerce transactions, but make sure to include `TerminalCloudAPI`:
``` java
// Step 1: Import the required classes
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.service.TerminalCloudAPI;
import com.adyen.model.nexo.*;
import com.adyen.model.terminal.*;

// Step 2: Initialize the client object
Client client = new Client("Your YOUR_API_KEY", Environment.TEST);

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

### Optional: perform an abort request

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

### Optional: perform a status request

To perform a [status request](https://docs.adyen.com/point-of-sale/basic-tapi-integration/verify-transaction-status/) you can use the following example:
```java
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

## Using the Local Terminal API Integration
The request and response payloads are identical to the Cloud Terminal API, however, additional encryption details are required to perform the requests.
```java
// Step 1: Import the required classes
import com.adyen.service.TerminalLocalAPI;
import com.adyen.model.nexo.*;
import com.adyen.model.terminal.*;

// Step 2: Add your Certificate Path and Local Endpoint to the config path. Install the certificate from [here](https://docs.adyen.com/point-of-sale/choose-your-architecture/local#protect-communications).
Client client = new Client();
client.getConfig().setTerminalApiLocalEndpoint("The IP of your terminal (eg https://192.168.47.169)");
client.getConfig().setEnvironment(Environment.TEST);
client.getConfig().setTerminalCertificate("YOUR_CERTIFICATE_PATH");

// Step 3: Setup a security password for you terminal in CA, and import the security key object:
SecurityKey securityKey = new SecurityKey();
securityKey.setKeyVersion(1);
securityKey.setAdyenCryptoVersion(1);
securityKey.setKeyIdentifier("keyIdentifier");
securityKey.setPassphrase("passphrase");

// Step 4 Initialize the API object
TerminalLocalAPI terminalLocalAPI = new TerminalLocalAPI(client, securityKey);

// Step 5: Create the request object
TerminalAPIRequest terminalAPIRequest = ///....same as the one used for Cloud API ;

// Step 6: Make the request
TerminalAPIResponse terminalAPIResponse = terminalLocalApi.request(terminalAPIRequest);
```

## Using the Local Terminal API Integration without Encryption (Only on TEST)
If you wish to develop the Local Terminal API integration parallel to your encryption implementation, you can opt for the unencrypted version. Be sure to remove any encryption details from the CA terminal config page.
```java
// Step 1: Import the required classes
import com.adyen.service.TerminalLocalAPIUnencrypted;
import com.adyen.model.nexo.*;
import com.adyen.model.terminal.*;

// Step 2: Add your Certificate Path and Local Endpoint to the config path.
Client client = new Client();
client.getConfig().setTerminalApiLocalEndpoint("The IP of your terminal (eg https://192.168.47.169)");
client.getConfig().setEnvironment(Environment.TEST);
client.getConfig().setTerminalCertificate("YOUR_CERTIFICATE_PATH");

// Step 3 Initialize the client and the API objects;
TerminalLocalAPIUnencrypted terminalLocalAPIUnencrypted = new TerminalLocalAPIUnencrypted(client);

// Step 4: Create the request object
TerminalAPIRequest terminalAPIPaymentRequest = ///....same as the one used in the other examples;

// Step 5: Make the request
TerminalAPIResponse terminalAPIResponse = terminalLocalAPIUnencrypted.request(terminalAPIPaymentRequest);
```


### Example integrations
 
For a closer look at how our Java library works, you can clone one of our example integrations:
* [Java Spring Boot example integration](https://github.com/adyen-examples/adyen-java-spring-online-payments).
* [Kotlin Spring Boot example integration](https://github.com/adyen-examples/adyen-kotlin-spring-online-payments).

These include commented code, highlighting key features and concepts, and examples of API calls that can be made using the library.

## Feedback
We value your input! Help us enhance our API Libraries and improve the integration experience by providing your feedback. Please take a moment to fill out [our feedback form](https://forms.gle/A4EERrR6CWgKWe5r9) to share your thoughts, suggestions or ideas. 

## Contributing
 
 
We encourage you to contribute to this repository, so everyone can benefit from new features, bug fixes, and any other improvements.
 
 
Have a look at our [contributing guidelines](https://github.com/Adyen/adyen-java-api-library/blob/develop/CONTRIBUTING.md) to find out how to raise a pull request.
 
 
## Support
If you have a feature request, or spotted a bug or a technical problem, [create an issue here](https://github.com/Adyen/adyen-java-api-library/issues/new/choose).
 
For other questions, [contact our Support Team](https://www.adyen.help/hc/en-us/requests/new?ticket_form_id=360000705420).
 
 
## Licence
This repository is available under the [MIT license](https://github.com/Adyen/adyen-java-api-library/blob/main/LICENSE).
 
 
 
## See also
* Example integrations:
    * [Java Spring Boot](https://github.com/adyen-examples/adyen-java-spring-online-payments)
    * [Kotlin Spring Boot](https://github.com/adyen-examples/adyen-kotlin-spring-online-payments)
* [Adyen docs](https://docs.adyen.com/)
* [API Explorer](https://docs.adyen.com/api-explorer/)
