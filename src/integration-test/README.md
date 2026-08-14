# Integration tests

Integration tests exercise the public Java API library against an Adyen endpoint. Maven Failsafe
discovers classes ending in `IT`, and opt-in profiles keep external calls out of the default build.

## Quick start

From the repository root:

```bash
cp src/integration-test/resources/config.properties.example \
  src/integration-test/resources/config.properties

mvn verify -Pintegration-tests -Dgpg.skip=true
```

The first command creates the ignored local configuration. Complete the values needed by the tests
you plan to run.

## Test profiles

| Profile | Included tests | Purpose |
|---|---|---|
| none | No integration tests | Normal build and unit tests |
| `integration-tests` | Tagged `external`, excluding `manual` | Automated tests that call Adyen |
| `manual-integration-tests` | Tagged `manual` | Tests requiring a terminal, person, or dedicated infrastructure |

The default lifecycle is safe from integration-test execution:

```bash
mvn verify
```

## Running automated integration tests

Run all automated integration tests:

```bash
mvn verify -Pintegration-tests -Dgpg.skip=true
```

Run one class:

```bash
mvn verify -Pintegration-tests -Dgpg.skip=true \
  -Dit.test=CheckoutCardPaymentIT
```

Run one method:

```bash
mvn verify -Pintegration-tests -Dgpg.skip=true \
  -Dit.test=CheckoutCardPaymentIT#shouldCreateAuthorisedCardPayment
```

Run multiple classes:

```bash
mvn verify -Pintegration-tests -Dgpg.skip=true \
  -Dit.test=FirstIntegrationIT,SecondIntegrationIT
```

`-Dit.test` is the Failsafe selector. Do not use Surefire's `-Dtest` selector for these tests.

## Running manual integration tests

Always select one manual test at a time unless its service-specific documentation explicitly
permits concurrency:

```bash
mvn verify -Pmanual-integration-tests -Dgpg.skip=true \
  -Dit.test=CloudDeviceApiTerminalIT#shouldListConnectedDevices
```

Cloud Device terminal prerequisites and available operations are documented in
[`java/com/adyen/service/clouddevice/e2e-testing.md`](java/com/adyen/service/clouddevice/e2e-testing.md).
No `@Disabled` annotation needs to be removed.

## Local configuration

The ignored local file is:

```text
src/integration-test/resources/config.properties
```

Start from
[`config.properties.example`](resources/config.properties.example). Environment variables take
precedence over values in the properties file.

Select the client environment with:

```properties
Adyen_Environment=TEST
```

For a test designed to support LIVE:

```properties
Adyen_Environment=LIVE
ADYEN_LIVE_ENDPOINT_URL_PREFIX=your-live-prefix
```

The existing Checkout card and Cloud Device payment tests contain TEST-only data and call
`requireTestEnvironment()`. They fail before making a request when configured for LIVE.

## Current coverage

### Automated Checkout tests

| Test | Behavior |
|---|---|
| `CheckoutCardPaymentIT#shouldCreateAuthorisedCardPayment` | Creates an authorised Checkout v72 test-card payment |
| `CheckoutCardPaymentIT#shouldReturnUnprocessableEntityWhenReferenceIsMissing` | Verifies the parsed HTTP 422 validation error |

### Manual Cloud Device tests

| Test | Behavior |
|---|---|
| `CloudDeviceApiTerminalIT#shouldSendSynchronousPaymentRequest` | Sends a payment and waits for the terminal response |
| `CloudDeviceApiTerminalIT#shouldSendAsynchronousPaymentRequest` | Submits a payment for background terminal processing |
| `CloudDeviceApiTerminalIT#shouldSendEncryptedSynchronousPaymentRequest` | Sends a synchronous request with NexoSEC encryption |
| `CloudDeviceApiTerminalIT#shouldSendEncryptedAsynchronousPaymentRequest` | Sends an asynchronous request with NexoSEC encryption |
| `CloudDeviceApiTerminalIT#shouldListConnectedDevices` | Checks that the configured terminal is connected |

## Validation without external calls

Format and compile integration-test sources without executing them:

```bash
mvn spotless:apply
mvn -Pintegration-tests -DskipTests test-compile
mvn spotless:check checkstyle:check -DskipTests
```

`-DskipTests` is required for offline validation. Do not run an integration-test profile without it
unless the external API calls are intentional.

Failsafe writes execution reports to:

```text
target/failsafe-reports/
```

## Project layout

```text
src/integration-test/
├── AGENTS.md
├── README.md
├── java/com/adyen/
│   ├── BaseIntegrationTest.java
│   ├── IntegrationTestTags.java
│   └── service/<service>/*IT.java
└── resources/
    ├── config.properties.example
    └── config.properties
```

Packages mirror production packages under `src/main/java`.

## Conventions for new tests

1. Name classes `*IT` and methods with behavior-focused `should...When...` names.
2. Extend `BaseIntegrationTest`.
3. Tag external classes with `external`; add `manual` when dedicated infrastructure is required.
4. Keep one observable behavior per test and use Arrange, Act, Assert sections.
5. Generate unique references and idempotency keys for requests that create remote state.
6. Use explicit imports, response types, and checked exceptions.
7. Assert stable response fields and documented error codes.
8. Extract repeated request construction and contract assertions into focused private helpers.
9. Keep tests independent and clean up remote resources where supported.
10. Use bounded polling and suitable timeouts instead of fixed sleeps or unbounded waits.
11. Call `requireTestEnvironment()` in `@BeforeEach` when a test contains TEST-only data.
12. Never execute external tests during routine agent validation.

More specific agent instructions are in [`AGENTS.md`](AGENTS.md).

## Minimal template

```java
package com.adyen.service.example;

import static com.adyen.IntegrationTestTags.EXTERNAL;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.adyen.BaseIntegrationTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag(EXTERNAL)
public class ExampleOperationIT extends BaseIntegrationTest {

  @Test
  public void shouldReturnExpectedResultWhenRequestIsValid() throws ApiException, IOException {
    // Arrange
    ExampleRequest request = createRequest();
    ExampleApi exampleApi = new ExampleApi(getClient());

    // Act
    ExampleResponse response = exampleApi.exampleOperation(request);

    // Assert
    assertNotNull(response, "The API response must not be null");
  }
}
```

Add the concrete model, service, and exception imports required by the API under test.

## Troubleshooting

### No integration tests were discovered

- Activate the correct profile.
- Confirm the class name ends in `IT`.
- Confirm automated tests use the `external` tag and manual tests use the `manual` tag.
- Use `-Dit.test`, not `-Dtest`.

### A required property is not defined

Confirm `src/integration-test/resources/config.properties` exists and contains the local values
required by the selected test. Environment-variable values override the file.

### Checkout returns HTTP 403 with error code `010`

The API credential or merchant account is not allowed to perform the operation. This is an account
permission or merchant-access issue rather than a test compilation problem.

### A TEST-only test rejects LIVE

Set `Adyen_Environment=TEST`. Tests guarded by `requireTestEnvironment()` intentionally cannot run
against LIVE.

### A LIVE endpoint prefix is missing

Set `ADYEN_LIVE_ENDPOINT_URL_PREFIX` for APIs that use an account-specific LIVE hostname.

### A terminal test times out

Confirm the terminal is online, connected to the configured account, and not processing another
request. Terminal tests have a five-minute timeout and must run sequentially.
