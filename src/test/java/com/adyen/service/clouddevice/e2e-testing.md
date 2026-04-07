# E2E Testing with a POS Terminal

`CloudDeviceApiTerminalIT` contains end-to-end tests that send real requests to a Cloud Device API terminal. All tests are disabled by default and must be enabled manually before running.

## Prerequisites

- A physical POS terminal connected and switched on
- An Adyen test account with the Cloud Device API enabled
- Terminal encryption credentials (key identifier and passphrase) for testing the encryption of payloads

## Configuration

Create `src/test/resources/config.properties` (excluded from version control):

```properties
ADYEN_API_KEY=
ADYEN_MERCHANT_ACCOUNT=MyMerchantAccount
ADYEN_TERMINAL_DEVICE_ID=V400m-1234567890
ADYEN_TERMINAL_DEVICE_KEY_IDENTIFIER=
ADYEN_TERMINAL_DEVICE_PASSPHRASE=
```

Alternatively, export the same keys as environment variables.

## Running a test

1. Remove the `@Disabled` annotation from the test you want to run.
2. Execute it individually:
   ```bash
   mvn test -Dtest=CloudDeviceApiTerminalIT#sendSync
   ```
3. Re-add the `@Disabled` annotation when done.

> Run one test at a time. The terminal can only handle one active request at a time.

## Available tests

| Test | Description |
|---|---|
| `sendSync` | Sends a payment request and waits for the terminal response |
| `sendAsync` | Sends a payment request asynchronously (terminal processes in background) |
| `sendEncryptedSync` | Same as `sendSync` with end-to-end NexoSEC encryption |
| `sendEncryptedAsync` | Same as `sendAsync` with end-to-end NexoSEC encryption |
| `getConnectedDevices` | Lists devices connected to the merchant account |
