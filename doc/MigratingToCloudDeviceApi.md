# Migrating from Terminal (Cloud) API to Cloud device API

## Introduction

The Adyen Java API Library now includes the [Cloud device API](https://docs.adyen.com/api-explorer/cloud-device-api/1/overview), a modern replacement for the [Terminal (Cloud) API](https://docs.adyen.com/api-explorer/terminal-api/1/overview) for In-Person Payments cloud integrations.

The Terminal (Cloud) API (`TerminalCloudAPI`) was built manually with hand-crafted models in the `com.adyen.model.nexo` package. The Cloud device API (`CloudDeviceApi`) is generated from the [Adyen OpenAPI specification](https://github.com/Adyen/adyen-openapi), just like all other services in this library. This means the models and service classes are always in sync with the API, follow the same patterns as the rest of the library (Jackson serialization, fluent setters, `fromJson()`/`toJson()` methods), and benefit from the automated update process.

Because the Cloud device API models are generated from the spec rather than hand-crafted, there are differences in class names, enum naming conventions, field types, and accessor methods. This guide describes these differences and what to be aware of when adopting the Cloud device API.

### Who should migrate?

- **New integrations**: use the Cloud device API from the start. See the [Cloud device API documentation](CloudDeviceApi.md).
- **Updating your cloud integration**: you should consider migrating to the Cloud device API to benefit from the improvements listed below.
- **Not making changes**: you can continue using the Terminal (Cloud) API. It remains functional, but you will miss out on the benefits of the Cloud device API.

## Benefits of the Cloud device API

The Cloud device API introduces several improvements over the Terminal (Cloud) API:

- **API logs in the Customer Area**: troubleshoot errors using the API logs available in your Adyen Customer Area.
- **Versioned endpoints**: the API uses a version strategy for controlled and safer rollouts.
- **Improved security**: supports OAuth authentication alongside API key authentication.
- **Device management endpoints**: query connected devices and check their status directly from your integration.
- **New features**: future In-Person Payments features and products will be released exclusively on the Cloud device API.
- **Generated from the OpenAPI specification**: unlike the hand-crafted Terminal (Cloud) API models, the Cloud device API is auto-generated from the [Adyen OpenAPI spec](https://github.com/Adyen/adyen-openapi). This brings consistency with every other service in the library (Checkout, Management, Transfers, etc.), ensures the models stay in sync with the API, and provides built-in `fromJson()`/`toJson()` serialization, fluent setters, and Jackson support out of the box.

## Key differences

The following sections describe the key differences between the Terminal (Cloud) API and the Cloud device API.

### Service class and endpoints

The Cloud device API uses the `CloudDeviceApi` service class instead of `TerminalCloudAPI`:

| | Terminal (Cloud) API | Cloud device API |
|---|---|---|
| Service class | `com.adyen.service.TerminalCloudAPI` | `com.adyen.service.clouddevice.CloudDeviceApi` |
| Request wrapper | `com.adyen.model.terminal.TerminalAPIRequest` | `com.adyen.model.clouddevice.CloudDeviceApiRequest` |
| Response wrapper | `com.adyen.model.terminal.TerminalAPIResponse` | `com.adyen.model.clouddevice.CloudDeviceApiResponse` |

The Cloud device API `sync` and `async` endpoints require `merchantAccount` and `deviceId` as path parameters, in addition to the request body. The library automatically sets the `POIID` in the `MessageHeader` to match the `deviceId`.

**Cloud device API:**
```java
// make a sync request
CloudDeviceApiResponse response = cloudDeviceApi.sync("myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);

// get the list of connected devices for a given merchant account. 
ConnectedDevicesResponse response = cloudDeviceApi.getConnectedDevices("myMerchant");
```

### Model package

The Terminal (Cloud) API uses hand-crafted models in `com.adyen.model.nexo`. The Cloud device API uses models generated from the OpenAPI specification in `com.adyen.model.tapi`.

| Terminal (Cloud) API | Cloud device API |
|---|---|
| `com.adyen.model.nexo.SaleToPOIRequest` | `com.adyen.model.tapi.SaleToPOIRequest` |
| `com.adyen.model.nexo.MessageHeader` | `com.adyen.model.tapi.MessageHeader` |
| `com.adyen.model.nexo.MessageCategoryType` | `com.adyen.model.tapi.MessageCategory` (renamed, see below) |
| `com.adyen.model.nexo.PaymentRequest` | `com.adyen.model.tapi.PaymentRequest` |
| `com.adyen.model.nexo.AmountsReq` | `com.adyen.model.tapi.AmountsReq` |

### Renamed classes and enums

#### Enum classes (dropped `Type` suffix)

Several enum classes are named differently in the Cloud device API to match the OpenAPI specification. The `Type` suffix has been dropped:

| Old name (nexo)             | New name (tapi)           |
|-----------------------------|---------------------------|
| `MessageCategoryType`       | `MessageCategory`         |
| `MessageClassType`          | `MessageClass`            |
| `ErrorConditionType`        | `ErrorCondition`          |
| `ResultType`                | `Result`                  |
| `EventToNotifyType`         | `EventToNotify`           |
| `GlobalStatusType`          | `GlobalStatus`            |
| `InfoQualifyType`           | `InfoQualify`             |
| `DeviceType`                | `Device`                  |
| `AlignmentType`             | `Alignment`               |
| `CharacterHeightType`       | `CharacterHeight`         |
| `CharacterStyleType`        | `CharacterStyle`          |
| `CharacterWidthType`        | `CharacterWidth`          |
| `DocumentQualifierType`     | `DocumentQualifier`       |
| `IdentificationSupportType` | `IdentificationSupport`   |
| `InputCommandType`          | `InputCommand`            |
| `LoyaltyHandlingType`       | `LoyaltyHandling`         |
| `MenuEntryTagType`          | `MenuEntryTag`            |
| `OutputFormatType`          | `OutputFormat`            |
| `PeriodUnitType`            | `PeriodUnit`              |
| `PINFormatType`             | `PINFormat`               |
| `PrinterStatusType`         | `PrinterStatus`           |
| `ResponseModeType`          | `ResponseMode`            |
| `ReversalReasonType`        | `ReversalReason`          |
| `SoundActionType`           | `SoundAction`             |
| `SoundFormatType`           | `SoundFormat`             |
| `TrackFormatType`           | `TrackFormat`             |
| `TransactionActionType`     | `TransactionAction`       |

**Note**: enums that already end with `Type` in the spec (e.g. `MessageType`, `TokenRequestedType`, `AccountType`) are **not** renamed.

#### Model classes

Some classes are also renamed to adopt the name of the model in the OpenAPI specification.

| Terminal (Cloud) API (nexo)      | Cloud device API (tapi)   |
|--------------------------------|---------------------------|
| `TransactionIdentification`   | `TransactionIDType`       |

#### Setter/getter naming

Some attribute accessors differ due to the way the code generator handles certain naming patterns (specifically attributes starting with acronyms like `POI`):

| Class      | Terminal (Cloud) API (nexo)   | Cloud device API (tapi)     |
|------------|-----------------------------|-----------------------------|
| `POIData`  | `getPOITransactionID()`     | `getPoITransactionID()`     |
| `POIData`  | `setPOITransactionID()`     | `setPoITransactionID()`     |
| `POIData`  | `getPOIReconciliationID()`  | `getPoIReconciliationID()`  |
| `POIData`  | `setPOIReconciliationID()`  | `setPoIReconciliationID()`  |
| `CardData` | `getMaskedPAN()`            | `getMaskedPan()`            |

### Type changes

Some field types differ in the generated models.

#### Timestamp fields: `XMLGregorianCalendar` -> `OffsetDateTime`

The most common change. The Cloud device API models use `java.time.OffsetDateTime` for timestamp fields, whereas the Terminal (Cloud) API models use `XMLGregorianCalendar`.

**Terminal (Cloud) API:**
```java
import javax.xml.datatype.XMLGregorianCalendar;

TransactionIdentification transactionIdentification = new TransactionIdentification();
transactionIdentification.setTimeStamp(xmlGregorianCalendarInstance);
```

**Cloud device API:**
```java
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

TransactionIDType transactionIDType = new TransactionIDType();
transactionIDType.setTimeStamp(OffsetDateTime.now(ZoneOffset.UTC));
```

#### Date fields: `String` -> `LocalDate`

Some date fields (e.g. `Instalment.firstPaymentDate`) use `java.time.LocalDate` in the Cloud device API instead of `String`.

**Terminal (Cloud) API:**
```java
instalment.setFirstPaymentDate("2025-01-15");
```

**Cloud device API:**
```java
import java.time.LocalDate;
instalment.setFirstPaymentDate(LocalDate.of(2025, 1, 15));
```

#### Numeric fields

- `BigInteger` fields are `Integer` in the Cloud device API
- In `CurrencyConversion`: the `rate` and `markup` fields are `String` instead of `BigDecimal`
- In `POIData`: `poIReconciliationID` is `Integer` instead of `String`

#### Boolean helper methods

The Terminal (Cloud) API `nexo` models include boolean helper methods with default values (e.g. `PaymentResult.isOnlineFlag()` defaulting to `true`). The Cloud device API `tapi` models do not include these convenience methods, so null checks are needed.

**Terminal (Cloud) API:**
```java
boolean isOnline = paymentResult.isOnlineFlag(); // defaults to true when null
```

**Cloud device API:**
```java
Boolean onlineFlag = paymentResult.getOnlineFlag();
boolean isOnline = (onlineFlag != null) ? onlineFlag : true;
```

### Serialization: Gson vs Jackson

The Terminal (Cloud) API `nexo` models use Gson annotations (`@SerializedName`), while the Cloud device API `tapi` models use Jackson annotations (`@JsonProperty`). If you perform custom serialization/deserialization of the Terminal API models, this is an important difference to be aware of.

The Cloud device API `tapi` models include built-in `fromJson()` and `toJson()` methods:

```java
String json = saleToPOIRequest.toJson();
SaleToPOIRequest request = SaleToPOIRequest.fromJson(jsonString);
```

### Fluent setters

The Cloud device API `tapi` models support a fluent API for building objects, which is not available in the `nexo` models.

**Terminal (Cloud) API:**
```java
MessageHeader messageHeader = new MessageHeader();
messageHeader.setProtocolVersion("3.0");
messageHeader.setMessageClass(MessageClassType.SERVICE);
messageHeader.setMessageCategory(MessageCategoryType.PAYMENT);
messageHeader.setMessageType(MessageType.REQUEST);
messageHeader.setSaleID("001");
messageHeader.setServiceID("001");
```

**Cloud device API:**
```java
MessageHeader messageHeader = new MessageHeader()
    .protocolVersion("3.0")
    .messageClass(MessageClass.SERVICE)
    .messageCategory(MessageCategory.PAYMENT)
    .messageType(MessageType.REQUEST)
    .saleID("001")
    .serviceID("001");
```

### Async response handling

The async response handling differs between the two APIs. The Terminal (Cloud) API `async` method returns a plain `String`. The Cloud device API wraps the response in `CloudDeviceApiAsyncResponse`.

**Terminal (Cloud) API:**
```java
String response = terminalCloudAPI.async(terminalAPIRequest);
// response is "ok" on success or null
```

**Cloud device API:**
```java
CloudDeviceApiAsyncResponse response = cloudDeviceApi.async("myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);

if ("ok".equals(response.getResult())) {
    // success
} else {
    // request failed: check EventNotification for error details
    EventNotification eventNotification = response.getSaleToPOIRequest().getEventNotification();
}
```

### Device management (new)

The Cloud device API includes endpoints for device management that are not available in the Terminal (Cloud) API:

```java
// List connected devices for a merchant account
ConnectedDevicesResponse devices = cloudDeviceApi.getConnectedDevices("myMerchant");
System.out.println(devices.getUniqueDeviceIds());

// Check the status of a specific device
DeviceStatusResponse status = cloudDeviceApi.getDeviceStatus("myMerchant", "P400Plus-123456789");
System.out.println(status.getStatus());
```

## Side-by-side comparison

### Terminal (Cloud) API
```java
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.service.TerminalCloudAPI;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.model.terminal.TerminalAPIResponse;
import com.adyen.model.nexo.*;

Client client = new Client("Your X-API-KEY", Environment.TEST);
TerminalCloudAPI terminalCloudAPI = new TerminalCloudAPI(client);

SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

MessageHeader messageHeader = new MessageHeader();
messageHeader.setProtocolVersion("3.0");
messageHeader.setMessageClass(MessageClassType.SERVICE);
messageHeader.setMessageCategory(MessageCategoryType.PAYMENT);
messageHeader.setMessageType(MessageType.REQUEST);
messageHeader.setSaleID("001");
messageHeader.setServiceID("001");
messageHeader.setPOIID("P400Plus-123456789");
saleToPOIRequest.setMessageHeader(messageHeader);

PaymentRequest paymentRequest = new PaymentRequest();
SaleData saleData = new SaleData();
TransactionIdentification transactionIdentification = new TransactionIdentification();
transactionIdentification.setTransactionID("001");
// Using XMLGregorianCalendar
XMLGregorianCalendar timestamp = DatatypeFactory.newInstance()
    .newXMLGregorianCalendar(new GregorianCalendar());
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

TerminalAPIRequest terminalAPIRequest = new TerminalAPIRequest();
terminalAPIRequest.setSaleToPOIRequest(saleToPOIRequest);

TerminalAPIResponse response = terminalCloudAPI.sync(terminalAPIRequest);
```

### Cloud device API
```java
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.service.clouddevice.CloudDeviceApi;
import com.adyen.model.clouddevice.CloudDeviceApiRequest;
import com.adyen.model.clouddevice.CloudDeviceApiResponse;
import com.adyen.model.tapi.*;

Client client = new Client("Your X-API-KEY", Environment.TEST);
CloudDeviceApi cloudDeviceApi = new CloudDeviceApi(client);

SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

MessageHeader messageHeader = new MessageHeader()
    .protocolVersion("3.0")
    .messageClass(MessageClass.SERVICE)
    .messageCategory(MessageCategory.PAYMENT)
    .messageType(MessageType.REQUEST)
    .saleID("001")
    .serviceID("001");
saleToPOIRequest.setMessageHeader(messageHeader);

PaymentRequest paymentRequest = new PaymentRequest();
SaleData saleData = new SaleData();
TransactionIDType transactionIDType = new TransactionIDType()
    .transactionID("001")
    .timeStamp(OffsetDateTime.now(ZoneOffset.UTC));
saleData.setSaleTransactionID(transactionIDType);

PaymentTransaction paymentTransaction = new PaymentTransaction();
AmountsReq amountsReq = new AmountsReq()
    .currency("EUR")
    .requestedAmount(BigDecimal.ONE);
paymentTransaction.setAmountsReq(amountsReq);

paymentRequest.setSaleData(saleData);
paymentRequest.setPaymentTransaction(paymentTransaction);
saleToPOIRequest.setPaymentRequest(paymentRequest);

CloudDeviceApiRequest cloudDeviceApiRequest = new CloudDeviceApiRequest();
cloudDeviceApiRequest.setSaleToPOIRequest(saleToPOIRequest);

// Note: POIID is set automatically from the deviceId parameter
CloudDeviceApiResponse response = cloudDeviceApi.sync(
    "myMerchant", "P400Plus-123456789", cloudDeviceApiRequest);
```

## Models not yet available in the Cloud device API

Some models present in the `nexo` package are not available in the `tapi` package because they are not part of the current OpenAPI specification. These represent features that were never supported by the Terminal (Cloud) API:

- `BatchRequest` / `BatchResponse`
- `LoyaltyRequest`
- `PINRequest` / `PINResponse`
- `CardReaderInitRequest` / `CardReaderInitResponse`
- `CardReaderPowerOffRequest` / `CardReaderPowerOffResponse`
- `SoundRequest` / `SoundResponse`
- `TransmitRequest` / `TransmitResponse`
- `ContentInformation`

If your integration uses these models, they are not yet supported in the Cloud device API. Contact [Adyen Support](https://www.adyen.help/hc/en-us/requests/new) for guidance.

### Helper classes

You can use `PredefinedContentHelper` to parse Display notification types which you find in `PredefinedContent->ReferenceID`
```java
import com.adyen.util.tapi.PredefinedContentHelper;

// Parse ReferenceID (i.e. key1=value1&key2=value2)
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
You shouldn't use `PredefinedContentHelper` from the (legacy) `nexo` folder.

## Testing and validation
Perform a thorough validation of the migration.

### 1. Unit tests

- Verify that your request objects serialize to the same JSON structure with the new models. Use `toJson()` on the `tapi` models and compare with the expected JSON payloads from your existing test data.
- Pay special attention to the renamed fields and type changes described above.

### 2. Integration tests on TEST environment

- Point the `CloudDeviceApi` to the test environment (`Environment.TEST`).
- Run your most common payment flows: payment, reversal, refund, and reconciliation.
- Verify that the response structure is parsed correctly, especially the fields with type changes (`OffsetDateTime`, `LocalDate`, `Integer`).
- Test your async flow to confirm event notifications are received and can be parsed.
- Test with a POS terminal.

### 3. Validate response handling

- Check that `PaymentResponse`, `ReversalResponse`, and other response models deserialize without errors.
- Verify that the accessor name changes (e.g. `getPoITransactionID()`) are correctly updated in your business logic.
- Confirm that boolean field handling works correctly without the old default-value helpers.

### 4. Device management (new)

- Use `getConnectedDevices()` and `getDeviceStatus()` to validate your terminal connectivity before running transaction tests.

### 5. Rollout strategy

- Consider running the Cloud device API integration in parallel with your existing Terminal (Cloud) API integration.
- Observe traffic (with the Customer Area API Logs or your own observability tools) to validate the API requests and responses.
- Compare the results of both integrations to ensure functional equivalence.

## Further resources

- [Cloud device API documentation](CloudDeviceApi.md)
- [Cloud device API Explorer](https://docs.adyen.com/api-explorer/cloud-device-api/1/overview)
- [Terminal API documentation](TerminalApi.md)
- [In-Person Payments documentation](https://docs.adyen.com/point-of-sale/)
