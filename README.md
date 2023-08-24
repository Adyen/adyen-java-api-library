![Java](https://user-images.githubusercontent.com/62436079/207377920-a87d7662-bc6a-496b-8d02-27c0a425e947.png)

# Adyen Java API Library

[![Maven Central](https://img.shields.io/maven-central/v/com.adyen/adyen-java-api-library)](https://central.sonatype.com/artifact/com.adyen/adyen-java-api-library/)

This is the officially supported Java library for using Adyen's APIs.

## Supported API versions

The Library supports all APIs under the following services:

| API                                                                                           | Description                                                                                                                                                                                                                                                                                                       | Service Name                             | Supported version |
|-----------------------------------------------------------------------------------------------|-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|------------------------------------------|-------------------|
| [BIN lookup API](https://docs.adyen.com/api-explorer/BinLookup/54/overview)                   | The BIN Lookup API provides endpoints for retrieving information based on a given BIN.                                                                                                                                                                                                                            | BinLookup                                | **v54**           |
| [Capital API](https://docs.adyen.com/api-explorer/capital/3/overview)                         | Adyen Capital allows you to build an embedded financing offering for your users to serve their operational needs.                                                                                                                                                                                                 | Capital                                  | **v3**            |
| [Checkout API](https://docs.adyen.com/api-explorer/Checkout/70/overview)                      | Our latest integration for accepting online payments.                                                                                                                                                                                                                                                             | Checkout                                 | **v70**           |
| [Configuration API](https://docs.adyen.com/api-explorer/balanceplatform/2/overview)           | The Configuration API enables you to create a platform where you can onboard your users as account holders and create balance accounts, cards, and business accounts.                                                                                                                                             | balanceplatform package subclasses       | **v2**            |
| [DataProtection API](https://docs.adyen.com/development-resources/data-protection-api)        | Adyen Data Protection API provides a way for you to process [Subject Erasure Requests](https://gdpr-info.eu/art-17-gdpr/) as mandated in GDPR. Use our API to submit a request to delete shopper's data, including payment details and other related information (for example, delivery address or shopper email) | DataProtection                           | **v1**            |
| [Legal Entity Management API](https://docs.adyen.com/api-explorer/legalentity/3/overview)     | Manage legal entities that contain information required for verification.                                                                                                                                                                                                                                         | legalentitymanagement package subclasses | **v3**            |
| [Local/Cloud-based Terminal API](https://docs.adyen.com/point-of-sale/terminal-api-reference) | Our point-of-sale integration.                                                                                                                                                                                                                                                                                    | TerminalLocalAPI or TerminalCloudAPI     | -                 |
| [Management API](https://docs.adyen.com/api-explorer/Management/3/overview)                   | Configure and manage your Adyen company and merchant accounts, stores, and payment terminals.                                                                                                                                                                                                                     | management package subclasses            | **v3**            |
| [Payments API](https://docs.adyen.com/api-explorer/Payment/68/overview)                       | Our classic integration for online payments.                                                                                                                                                                                                                                                                      | Payment                                  | **v68**           |
| [Payouts API](https://docs.adyen.com/api-explorer/Payout/68/overview)                         | Endpoints for sending funds to your customers.                                                                                                                                                                                                                                                                    | Payout                                   | **v68**           |
| [POS Terminal Management API](https://docs.adyen.com/api-explorer/postfmapi/1/overview)       | Endpoints for managing your point-of-sale payment terminals.                                                                                                                                                                                                                                                      | TerminalManagement                       | **v1**            |
| [Recurring API](https://docs.adyen.com/api-explorer/Recurring/68/overview)                    | Endpoints for managing saved payment details.                                                                                                                                                                                                                                                                     | Recurring                                | **v68**           |
| [Stored Value API](https://docs.adyen.com/payment-methods/gift-cards/stored-value-api)        | Manage both online and point-of-sale gift cards and other stored-value cards.                                                                                                                                                                                                                                     | StoredValue                              | **v46**           |
| [Transfers API](https://docs.adyen.com/api-explorer/transfers/4/overview)                     | The Transfers API provides endpoints that can be used to get information about all your transactions, move funds within your balance platform or send funds from your balance platform to a transfer instrument.                                                                                                  | Transfers                                | **v4**            |
| [Webhooks](https://docs.adyen.com/api-explorer/Webhooks/1/overview)                           | Adyen uses webhooks to send notifications about payment status updates, newly available reports, and other events that can be subscribed to. For more information, refer to our [documentation](https://docs.adyen.com/development-resources/webhooks).                                                           | *Models only*                            | **v1**            |
## Supported Webhook versions
The library supports all webhooks under the following model directories:

| Webhooks                                                                                          | Description                                                                                                                                                                             | Model Name                                                                           | Supported Version |
|---------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|--------------------------------------------------------------------------------------|-------------------|
| [Configuration Webhooks](https://docs.adyen.com/api-explorer/balanceplatform-webhooks/1/overview) | You can use these webhooks to build your implementation. For example, you can use this information to update internal statuses when the status of a capability is changed.              | [ConfigurationNotification](src/main/java/com/adyen/model/configurationNotification) | **v1**            |
| [Transfer Webhooks](https://docs.adyen.com/api-explorer/transfer-webhooks/4/overview)             | You can use these webhooks to build your implementation. For example, you can use this information to update balances in your own dashboards or to keep track of incoming funds.        | [TransferNotification](src/main/java/com/adyen/model/transferNotification)           | **v4**            |
| [Report Webhooks](https://docs.adyen.com/api-explorer/report-webhooks/1/overview)                 | You can download reports programmatically by making an HTTP GET request, or manually from your Balance Platform Customer Area                                                           | [ReportNotification](src/main/java/com/adyen/model/reportNotification)               | **v1**            |
| [Notification Webhooks](https://docs.adyen.com/api-explorer/Webhooks/1/overview)                  | We use webhooks to send you updates about payment status updates, newly available reports, and other events that you can subscribe to. For more information, refer to our documentation | [Notification](src/main/java/com/adyen/model/notification)                           | **v1**            |

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
  <version>21.1.0</version>
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
Or if you would like to deserialize the Banking Webhooks, first check if the payload is authentic: 
~~~~ java
String payload = "WEBHOOK_PAYLOAD";
String signKey = "SIGNATURE_RETRIEVED_FROM_CA";
String hmacKey = "HMAC_KEY_RETRIEVED_FROM_WEBHOOK_HEADER";
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
