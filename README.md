[![Build Status](https://travis-ci.org/Adyen/adyen-java-api-library.svg?branch=master)](https://travis-ci.org/Adyen/adyen-java-api-library)
[![Coverage Status](https://coveralls.io/repos/github/Adyen/adyen-java-api-library/badge.svg?branch=master)](https://coveralls.io/github/Adyen/adyen-java-api-library?branch=master)


# Adyen Java API Library

This is the officially supported Java library for using Adyen's APIs.
 
The library supports all APIs under the following services:
 
* [Checkout API](https://docs.adyen.com/api-explorer/#/CheckoutService/v68/overview): Our latest integration for accepting online payments. Current supported version: **v68**
* [Payments API](https://docs.adyen.com/api-explorer/#/Payment/v52/overview): Our classic integration for online payments. Current supported version: **v52**
* [Recurring API](https://docs.adyen.com/api-explorer/#/Recurring/v49/overview): Endpoints for managing saved payment details. Current supported version: **v49**
* [Payouts API](https://docs.adyen.com/api-explorer/#/Payout/v51/overview): Endpoints for sending funds to your customers. Current supported version: **v51**
* [Platforms APIs](https://docs.adyen.com/platforms/api): Set of APIs when using Adyen for Platforms. 
  * [Account API](https://docs.adyen.com/api-explorer/#/Account/v6/overview) Current supported version: **v6**
  * [Fund API](https://docs.adyen.com/api-explorer/#/Fund/v6/overview) Current supported version: **v6**
  * [Notification Configuration API](https://docs.adyen.com/api-explorer/#/NotificationConfigurationService/v1/overview) Current supported version: **v6**
  * [Hosted Onboarding API](https://docs.adyen.com/api-explorer/#/Hop/v6/overview) Current supported version: **v6**
* [Cloud-based Terminal API](https://docs.adyen.com/point-of-sale/terminal-api-reference): Our point-of-sale integration.
* [Local-based Terminal API](https://docs.adyen.com/point-of-sale/choose-your-architecture/local): Our point-of-sale integration.
* [BinLookup API](https://docs.adyen.com/api-explorer/#/BinLookup/v50/overview): Our integration for retrieving information, such as cost estimates, and 3D Secure supported version based on a given BIN.
* [POS Terminal Management API](https://docs.adyen.com/api-explorer/#/postfmapi/v1/overview): Endpoints for managing your point-of-sale payment terminals: **v1** 
* [Data Protection API](https://docs.adyen.com/development-resources/data-protection-api#): Endpoints to process Subject Erasure Requests as mandated in General Data Protection Regulation (GDPR): **v1** 
* [Stored Value API](https://docs.adyen.com/payment-methods/gift-cards/stored-value-api): Endpoints to manage gift cards and other stored-value cards: **v46** 

For more information, refer to our [documentation](https://docs.adyen.com/) or the [API Explorer](https://docs.adyen.com/api-explorer/).


## Prerequisites
 
* [Adyen test account](https://docs.adyen.com/get-started-with-adyen)
* [API key](https://docs.adyen.com/development-resources/api-credentials#generate-api-key). For testing, your API credential needs to have the [API PCI Payments role](https://docs.adyen.com/development-resources/api-credentials#roles).
* Java 8 or higher

## Installation

You can use Maven and add this dependency to your project's POM:

```
<dependency>
  <groupId>com.adyen</groupId>
  <artifactId>adyen-java-api-library</artifactId>
  <version>17.1.0</version>
</dependency>
```

Alternatively, you can download the [release on GitHub](https://github.com/Adyen/adyen-java-api-library/releases).

## Using the library
 
### General use with API key
 
Set up the client as a singleton resource; you'll use it for the API calls that you make to Adyen:
 
~~~~ java
// Setup Client and Service
Client client = new Client("Your X-API-KEY", Environment.TEST);
Checkout checkout = new Checkout(client);

// Create PaymentsRequest 
PaymentsRequest paymentsRequest = new PaymentsRequest();
paymentsRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
String encryptedCardNumber = "test_4111111111111111";
String encryptedExpiryMonth = "test_03";
String encryptedExpiryYear = "test_2030";
String encryptedSecurityCode = "test_737";
paymentsRequest.addEncryptedCardData(encryptedCardNumber,encryptedExpiryMonth, encryptedExpiryYear, encryptedSecurityCode);
Amount amount = new Amount();
amount.setCurrency("EUR");
amount.setValue(1000L);
paymentsRequest.setAmount(amount);
paymentsRequest.setReference("Your order number");
paymentsRequest.setReturnUrl("https://your-company.com/checkout?shopperOrder=12xy..");

// Make a call to the /payments endpoint
PaymentsResponse paymentsResponse = checkout.payments(paymentsRequest);

~~~~
 
### General use with API key for live environment
For requests on live environment, you need to pass the [Live URL Prefix](https://docs.adyen.com/development-resources/live-endpoints#live-url-prefix) to the Client object:
~~~~ java
// Setup Client and Service
Client client = new Client("Your X-API-KEY", Environment.LIVE, "Your live URL prefix");
Checkout checkout = new Checkout(client);

...
~~~~

 
### General use with basic auth
~~~~ java
 // Setup Client and Service
 Client client = new Client("Your username", "Your password", Environment.LIVE, "Your live URL prefix", "Your application name");
 Checkout checkout = new Checkout(client);
 
 ...
~~~~
### Using notification webhooks parser
~~~~ java
 String json = "The notification message sent to your webhook";
 NotificationHandler notificationHandler = new NotificationHandler();
 GenericNotification notificationMessage = notificationHandler.handleMarketpayNotificationJson(json);
 ...
~~~~

 
### Proxy configuration
You can configure a proxy connection by injecting your own AdyenHttpClient on your client instance.

Example:
~~~~ java
...
AdyenHttpClient adyenHttpClientWithProxy = new AdyenHttpClient();

Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("PROXY_HOST", PROXY_PORT));
adyenHttpClientWithProxy.setProxy(proxy);

client.setHttpClient(adyenHttpClientWithProxy);
~~~~

### Example integrations
 
For a closer look at how our Java library works, you can clone one of our example integrations:
* [Java Spark example integration](https://github.com/adyen-examples/adyen-java-spark-online-payments).
* [Java Spring Boot example integration](https://github.com/adyen-examples/adyen-java-spring-online-payments).
* [Kotlin Spring Boot example integration](https://github.com/adyen-examples/adyen-kotlin-spring-online-payments).

These include commented code, highlighting key features and concepts, and examples of API calls that can be made using the library.


## Contributing
 
 
We encourage you to contribute to this repository, so everyone can benefit from new features, bug fixes, and any other improvements.
 
 
Have a look at our [contributing guidelines](https://github.com/Adyen/adyen-java-api-library/blob/develop/CONTRIBUTING.md) to find out how to raise a pull request.
 
 
## Support
If you have a feature request, or spotted a bug or a technical problem, [create an issue here](https://github.com/Adyen/adyen-java-api-library/issues/new/choose).
 
For other questions, [contact our Support Team](https://www.adyen.help/hc/en-us/requests/new?ticket_form_id=360000705420).
 
 
## Licence
This repository is available under the [MIT license](https://github.com/Adyen/adyen-java-api-library/blob/master/LICENSE).
 
 
 
## See also
* Example integrations:
    * [Java Spark](https://github.com/adyen-examples/adyen-java-spark-online-payments)
    * [Java Spring Boot](https://github.com/adyen-examples/adyen-java-spring-online-payments)
    * [Kotlin Spring Boot](https://github.com/adyen-examples/adyen-kotlin-spring-online-payments)
* [Adyen docs](https://docs.adyen.com/)
* [API Explorer](https://docs.adyen.com/api-explorer/)
