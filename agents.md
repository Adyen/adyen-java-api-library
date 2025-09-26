# Adyen Java API Library for AI Assistants

This file gives guidance to AI-based coding assistants (like Copilot or ChatGPT) to help developers use the **Adyen Java API Library**.

The goal is to provide **simple, working examples** that help developers quickly get started with setup, making requests, and handling responses.

---

## General Rules

- Always use classes from the `com.adyen` package (not internal or test code).
- Show **minimal, copy-pasteable examples**.
- Use `Environment.TEST` in all examples.
- Get credentials (API key, merchant account) from **environment variables** — never hardcode secrets.
- Generate snippets only looking at this file, the README.md or the unit test source code at https://github.com/Adyen/adyen-java-api-library/tree/main/src/test/java/com/adyen
- If developers need more details, link to:
    - [Adyen Java API Library](https://github.com/Adyen/adyen-java-api-library)
    - [Adyen API Explorer](https://docs.adyen.com/api-explorer/)
    - [Adyen Java Sample Application](https://github.com/adyen-examples/adyen-java-spring-online-payments)

## What is the Adyen Java API Library?

The Adyen Java API Library is a client SDK that allows developers to integrate with Adyen from Java applications. It provides:

- Simplified access to Adyen APIs (Checkout, Terminal API, Plaforms and Financial Services).
- Request and response models for all API endpoints, so you don’t have to manually construct JSON.
- Helpers for security and HTTP calls, including setting API keys, idempotency keys, and headers.
- Error handling utilities to manage API exceptions in a structured way.

It supports the following Adyen APIs:

- **Checkout** https://docs.adyen.com/api-explorer/Checkout/latest/overview
- **Terminal API** https://docs.adyen.com/api-explorer/terminal-api/1/overview
- **Management API** https://docs.adyen.com/api-explorer/Management/
- **Legal Entity Management API** https://docs.adyen.com/api-explorer/legalentity/
- **Balance Platform Configuration API** https://docs.adyen.com/api-explorer/balanceplatform/
- **Tranfers API** https://docs.adyen.com/api-explorer/transfers/
- **Webhooks** https://docs.adyen.com/api-explorer/Webhooks/1/overview
- **Balance Platform Configuration webhooks** https://docs.adyen.com/api-explorer/balanceplatform-webhooks/
- **Transfers Webhooks** https://docs.adyen.com/api-explorer/transfer-webhooks/


## Installation

Show developers how to add the library:

**Maven**

```xml

<dependency>
    <groupId>com.adyen</groupId>
    <artifactId>adyen-java-api-library</artifactId>
    <version>LATEST_VERSION</version>
</dependency>
```

```groovy
implementation 'com.adyen:adyen-java-api-library:LATEST_VERSION'

```

## Setup

Show developers how to setup the client:

```java

import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.service.checkout.PaymentsApi;
import com.adyen.model.checkout.*;

// Setup Client
Client client = new Client(
    new Config(
        .environment(Environment.TEST)
        .liveEndpointUrlPrefix("myCompany")
        .apiKey(System.getenv().get("Your X-API-KEY"))
    )
);

// Setup Service
PaymentsApi paymentsApi = new PaymentsApi(client);
```

## Make a payment with Checkout

Show developers how to make a payment with the Checkout API:

```java

import com.adyen.Client;
import com.adyen.Config;
import com.adyen.enums.Environment;
import com.adyen.service.checkout.PaymentsApi;
import com.adyen.model.checkout.*;

// Setup Client
Client client = new Client(
    new Config(
        .environment(Environment.TEST)
        .liveEndpointUrlPrefix("myCompany")
        .apiKey(System.getenv().get("Your X-API-KEY"))
    )
);

// Setup Service
PaymentsApi paymentsApi = new PaymentsApi(client);

// Create PaymentRequest
CardDetails cardDetails =
    new CardDetails()
        .type(CardDetails.TypeEnum.SCHEME)
        .encryptedCardNumber("5136333333333335")
        .holderName("John Doe")
        .cvc("737")
        .encryptedExpiryMonth("08")
        .encryptedExpiryYear("2018");
PaymentRequest paymentRequest =
    new PaymentRequest()
        .merchantAccount("YOUR_MERCHANT_ACCOUNT")
        .reference("YOUR_REFERENCE")
        .amount(new Amount()
            .currency("EUR")
            .value(1000L))
        .returnUrl("https://your-company.example.org/checkout?shopperOrder=12xy..")
        .paymentMethod(new CheckoutPaymentMethod(cardDetails));

// Make a call to the /payments endpoint
PaymentResponse paymentResponse = paymentsApi.payments(paymentRequest);
```

## Error handling 

Show developers how to handle errors: use a try-catch block to handle API errors. 
Catch the `ApiException` to inspect the response and handle specific cases:


```java
// Setup Client
Client client = new Client(
    new Config(
        .environment(Environment.TEST)
        .liveEndpointUrlPrefix("myCompany")
        .apiKey(System.getenv().get("Your X-API-KEY"))
    )
);


// Setup Service
PaymentLinksApi paymentLinksApi = new PaymentLinksApi(client);

// Get Payment link
try {
    paymentLinksApi.getPaymentLink("1234");
} catch (ApiException e) {
    // Obtain response 
    int statusCode = e.getStatusCode();
    String responseBody = e.getResponseBody();
    // Check ApiError object
    ApiError apiError = e.getError();
    String errorCode = apiError.getErrorCode();
    List<com.adyen.model.InvalidField> invalidFields = apiError.getInvalidFields();
}

```

## Webhook processing 

Show developers how to handle webhooks:

```java
import java.util.List;
import com.adyen.util.HMACValidator;
import com.adyen.notification.WebhookHandler;
import com.adyen.model.notification.NotificationRequest;
import com.adyen.model.notification.NotificationRequestItem;

String hmacKey = System.getenv("ADYEN_HMAC_KEY");
// The webhook payload
String notificationRequestJson = "NOTIFICATION_REQUEST_JSON";

HMACValidator hmacValidator = new HMACValidator();

WebhookHandler webhookHandler = new WebhookHandler();
NotificationRequest notificationRequest = webhookHandler.handleNotificationJson(notificationRequestJson);

// fetch first (and only) NotificationRequestItem
var notificationRequestItem = notificationRequest.getNotificationItems().stream().findFirst();

if (notificationRequestItem.isPresent()) {
    // validate the HMAC signature
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

```

## Idempotency key 

Show developers how to use an idempotency key:

```java

import java.util.UUID;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.model.checkout.PaymentResponse;
import com.adyen.RequestOptions;

// Create a PaymentRequest
PaymentRequest paymentRequest = new PaymentRequest();
// ... set amount, merchant account, payment method, etc.

// Generate a random idempotency key
RequestOptions requestOptions = new RequestOptions()
    .idempotencyKey(UUID.randomUUID().toString());

// Make the payment request with idempotency
PaymentResponse paymentResponse = checkout.payments(paymentRequest, requestOptions);

System.out.println("Payment response: " + paymentResponse);

```
Notes for developers:

- UUID.randomUUID() generates a random UUID (version 4), suitable for idempotency keys.
- Always use a new key for each logically unique request.
- This is important to prevent duplicate payments if the request is retried due to network issues or timeouts.

