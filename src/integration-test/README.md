# Integration tests

Integration tests exercise the public Java API library against an Adyen endpoint. Maven Failsafe
discovers classes ending in `IT`, and opt-in profiles keep external calls out of the default build.

## Quick start

From the repository root:

```bash
cp src/integration-test/resources/config.properties.example \
  src/integration-test/resources/config.properties

mvn -Pintegration-tests test-compile \
  failsafe:integration-test failsafe:verify
```

The first command creates the ignored local configuration. Complete the values needed by the tests
you plan to run. The Maven command compiles all test sources but executes only integration tests.

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
mvn -Pintegration-tests test-compile \
  failsafe:integration-test failsafe:verify
```

Run one class:

```bash
mvn -Pintegration-tests test-compile \
  failsafe:integration-test failsafe:verify \
  -Dit.test=LegalEntitiesApiIT
```

Run one method:

```bash
mvn -Pintegration-tests test-compile \
  failsafe:integration-test failsafe:verify \
  -Dit.test=LegalEntitiesApiIT#shouldCreateLegalEntityForIndividualResidingInTheNetherlands
```

Run multiple classes:

```bash
mvn -Pintegration-tests test-compile \
  failsafe:integration-test failsafe:verify \
  -Dit.test=LegalEntitiesApiIT,PlatformApiIT
```

`-Dit.test` is the Failsafe selector. Do not use Surefire's `-Dtest` selector for these tests.

## Running manual integration tests

Always select one manual test at a time unless its service-specific documentation explicitly
permits concurrency:

```bash
mvn -Pmanual-integration-tests test-compile \
  failsafe:integration-test failsafe:verify \
  -Dit.test=ExampleManualIT#shouldPerformManualOperation
```

There are currently no manual integration tests. This profile is reserved for future tests that
require a person, terminal, or dedicated infrastructure.

## Local configuration

The ignored local file is:

```text
src/integration-test/resources/config.properties
```

Start from
[`config.properties.example`](resources/config.properties.example). Environment variables take
precedence over values in the properties file. Java system properties take precedence over both.

Configuration lookup order:

1. Java system property, for example `-DAPI_LIBRARIES_ADYEN_LEM_API_KEY=...`
2. Environment variable
3. `src/integration-test/resources/config.properties`

Use environment variables or the ignored properties file for API keys. Command-line values may be
visible in shell history or process listings.

The current typed configuration properties are:

| Property | Used by |
|---|---|
| `API_LIBRARIES_ADYEN_API_KEY` | Checkout tests |
| `API_LIBRARIES_ADYEN_MERCHANT_ACCOUNT` | Checkout tests |
| `API_LIBRARIES_ADYEN_LEM_API_KEY` | Legal Entity Management tests |
| `API_LIBRARIES_ADYEN_BCL_API_KEY` | Balance Platform tests |
| `API_LIBRARIES_ADYEN_BALANCE_PLATFORM_ID` | Balance Platform tests |

All integration-test clients currently use the Adyen TEST environment. `BaseIntegrationTest`
caches one client per credential during a test and closes all clients after each test.

## Current coverage

### Automated tests

| Test | Behavior |
|---|---|
| `PaymentsApiIT` | Card payments, sessions, card brands, and available payment methods |
| `OrdersApiIT` | Creates a Checkout order |
| `PaymentLinksApiIT` | Creates a Checkout payment link |
| `DonationsApiIT` | Retrieves donation campaigns |
| `ModificationsApiIT` | Authorises and captures a payment |
| `LegalEntitiesApiIT` | Creates an individual legal entity |
| `PlatformApiIT` | Retrieves a balance platform |

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
11. Use the typed client accessor matching the API credential.
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
required by the selected test. Java system properties override environment variables, which
override the file.

### Checkout returns HTTP 403 with error code `010`

The API credential or merchant account is not allowed to perform the operation. This is an account
permission or merchant-access issue rather than a test compilation problem.

### The wrong API credential is used

Confirm the test uses the service-specific client accessor. Legal Entity Management tests use
`getLegalEntityManagementClient()`, and Balance Platform tests use `getBalancePlatformClient()`.
