# Adyen Java API Library

[![Maven Central](https://img.shields.io/maven-central/v/com.adyen/adyen-java-api-library)](https://central.sonatype.com/artifact/com.adyen/adyen-java-api-library/)
[![Build Status](https://github.com/Adyen/adyen-java-api-library/actions/workflows/javaci.yml/badge.svg)](https://github.com/Adyen/adyen-java-api-library/actions/workflows/javaci.yml)

This is the officially supported Java library for using Adyen's APIs.

## Supported API versions

| API | Description | Service Name | Supported version |
| --- | --- | --- | --- |
| [BinLookup API](https://docs.adyen.com/api-explorer/BinLookup/54/overview) |  | BinLookup | **v54** |
| [Checkout API](https://docs.adyen.com/api-explorer/Checkout/71/overview) | Our latest integration for accepting online payments. | Checkout | **v71** |
| [Configuration API](https://docs.adyen.com/api-explorer/balanceplatform/2/overview) |  | BalancePlatform | **v2** |
| [DataProtection API](https://docs.adyen.com/development-resources/data-protection-api) | Endpoint for requesting data erasure. | DataProtection | **v1** |
| [Legal Entity Management API](https://docs.adyen.com/api-explorer/legalentity/3/overview) |  | LegalEntityManagement | **v3** |
| [Management API](https://docs.adyen.com/api-explorer/Management/3/overview) | Configure and manage your Adyen company and merchant accounts, stores, and payment terminals. | Management | **v3** |
| [Payments API](https://docs.adyen.com/api-explorer/Payment/68/overview) | Our classic integration for online payments. | Payments | **v68** |
| [Payouts API](https://docs.adyen.com/api-explorer/Payout/68/overview) | Endpoints for sending funds to your customers. | Payouts | **v68** |
| [POS Mobile API](https://docs.adyen.com/api-explorer/possdk/68/overview) | Endpoints for POS Mobile | POSMobile | **v68** |
| [Recurring API](https://docs.adyen.com/api-explorer/Recurring/68/overview) | Endpoints for managing saved payment details. | Recurring | **v68** |
| [Stored Value API](https://docs.adyen.com/payment-methods/gift-cards/stored-value-api) | Manage both physical and digital gift cards. | StoredValue | **v46** |
| [Terminal API](https://docs.adyen.com/point-of-sale/design-your-integration/terminal-api/terminal-api-reference/) | Our point-of-sale integration. | Terminal | - |
| [Transfers API](https://docs.adyen.com/api-explorer/transfers/4/overview) | The Transfers API provides endpoints that you can use to get information about all your transactions, move funds within your balance platform or send funds from your balance platform to a transfer instrument. | Transfers | **v4** |

For more information, refer to our [documentation](https://docs.adyen.com/) or the [API Explorer](https://docs.adyen.com/api-explorer/).

## Prerequisites

* [Adyen test account](https://docs.adyen.com/get-started-with-adyen)
* [API key](https://docs.adyen.com/development-resources/api-credentials#generate-api-key). For testing, your API
  credential needs to have
  the [API PCI Payments role](https://docs.adyen.com/development-resources/api-credentials#roles).
* Java 21 or higher (library targets Java 21 LTS as of v42.0.0; see TTYAI-1)

## Installation

You can use Maven and add this dependency to your project's POM:

```xml
<dependency>
  <groupId>com.adyen</groupId>
  <artifactId>adyen-java-api-library</artifactId>
  <version>42.0.0</version>
</dependency>
```

Alternatively, you can download the [release on GitHub](https://github.com/Adyen/adyen-java-api-library/releases).

## Using the library

### General use with API key

Set up the client as a singleton resource; you'll use it for the lifecycle of your application:

```java
// Setup Client and Config
Client client = new Client();
client.setXApiKey("Your X-Api-Key");
client.setEnvironment(Environment.TEST, null);
```

### Custom HTTP client configuration

You can configure the HTTP client by passing a custom `Config` object:

```java
Config config = new Config();
config.setConnectTimeoutMillis(3000);
config.setReadTimeoutMillis(6000);
client = new Client(config);
```

### Using the services

```java
// Use one of the services, for example Checkout
Checkout checkout = new Checkout(client);

// Create a request
PaymentRequest paymentRequest = new PaymentRequest();

// Set the necessary parameters for the request
// ...

// Make the call to the Adyen API
PaymentResponse paymentResponse = checkout.payments(paymentRequest);
```

## Example integrations

For a closer look at how our Java library works, clone our [example integration](https://github.com/adyen-examples/adyen-java-spring-online-payments).

This repository includes an example of each payment method available through our Java library.

## Feedback

We value your input! Help us enhance our API Libraries and improve the integration experience by providing feedback. Please use the [GitHub Issue](https://github.com/Adyen/adyen-java-api-library/issues) to share your thoughts.

## Support

If you have a feature request, or spotted a bug or a technical problem, [create an issue here](https://github.com/Adyen/adyen-java-api-library/issues/new/choose).

For other questions, [contact our Support Team](https://docs.adyen.com/support).

## Contributing

We strongly encourage you to join us in contributing to this repository so everyone can benefit from:

* New features and functionality
* Resolved bug fixes and issues
* Any general improvements

Read our [**contribution guidelines**](CONTRIBUTING.md) to find out how.

## Licence

MIT license. For more information, see the **LICENSE** file.
