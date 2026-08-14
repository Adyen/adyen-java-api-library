# Cloud Device API terminal tests

These manual integration tests send requests to a physical payment terminal through the Cloud
Device API.

## Prerequisites

- The terminal is enabled, online, and associated with the configured merchant account.
- The terminal is available for the duration of the selected test.
- Encrypted tests have valid local encryption configuration.

## Running a test

Run exactly one test with the manual integration-test profile:

```bash
mvn verify -Pmanual-integration-tests -Dgpg.skip=true \
  -Dit.test=CloudDeviceApiTerminalIT#shouldSendSynchronousPaymentRequest
```

No source-code changes or `@Disabled` toggles are required.

> Run one terminal test at a time. A terminal can handle only one active request at a time.

## Available tests

| Test | Description |
|---|---|
| `shouldSendSynchronousPaymentRequest` | Sends a payment request and waits for the terminal response |
| `shouldSendAsynchronousPaymentRequest` | Sends a payment request for background terminal processing |
| `shouldSendEncryptedSynchronousPaymentRequest` | Sends a synchronous request with NexoSEC encryption |
| `shouldSendEncryptedAsynchronousPaymentRequest` | Sends an asynchronous request with NexoSEC encryption |
| `shouldListConnectedDevices` | Checks that the configured terminal is connected |
