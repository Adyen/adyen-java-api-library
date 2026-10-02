# Integration tests

Integration tests exercise the public Java API library against an Adyen endpoint. Maven Failsafe
discovers classes ending in `IT`, and opt-in profiles keep external calls out of the default build.

## Quick start

From the repository root:

```bash
cp src/integration-test/resources/test-config.example.json \
  src/integration-test/resources/test-config.json

mvn -Pintegration-tests test-compile \
  failsafe:integration-test failsafe:verify
```

The first command creates the ignored local configuration. Complete every JSON value before
running the tests. The Maven command compiles all test sources but executes only integration
tests.

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

## Configuration

Integration tests read a single JSON document with typed fields. Two sources are supported, in
this order:

1. The `API_LIBRARIES_INTEGRATION_TEST_CONFIG` environment variable containing the raw JSON
2. The ignored local file `src/integration-test/resources/test-config.json`

Java system properties are not consulted. Start from
[`test-config.example.json`](resources/test-config.example.json), copy it to `test-config.json`,
and complete every value.

Every field is required and validated once at startup. A field that is missing, blank, or not a
JSON string fails the run before any test executes and lists the offending field names. Values are
never included in error messages. Unknown fields are ignored, so the document can grow without
breaking the run.

The JSON fields are:

| Field | Used by |
|---|---|
| `company` | Company account, reserved for future tests |
| `merchantAccount` | Checkout tests |
| `balancePlatform` | Balance Platform tests |
| `apiKey` | Checkout tests |
| `lemApiKey` | Legal Entity Management tests |
| `bclApiKey` | Balance Platform tests |
| `givingCampaignId` | Giving campaigns, reserved for future tests |
| `legalEntityId` | Legal Entity Management, reserved for future tests |
| `businessLineId` | Legal Entity Management, reserved for future tests |
| `documentId` | Legal Entity Management, reserved for future tests |
| `accountHolderId` | Balance Platform, reserved for future tests |
| `balanceAccountId` | Balance Platform, reserved for future tests |

Keep API keys in the environment variable or the ignored JSON file. Do not put credentials in
command-line arguments, tracked files, or logs.

On GitHub Actions, store the same JSON document once as a repository secret and expose it to the
test job:

```yaml
env:
  API_LIBRARIES_INTEGRATION_TEST_CONFIG: ${{ secrets.API_LIBRARIES_INTEGRATION_TEST_CONFIG }}
```

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

The configuration tests are offline and safe to execute:

```bash
mvn -Pintegration-tests test -Dtest=IntegrationTestConfigurationTest
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
│   ├── IntegrationTestConfiguration.java
│   ├── IntegrationTestConfigurationTest.java
│   ├── IntegrationTestTags.java
│   └── service/<service>/*IT.java
└── resources/
    ├── test-config.example.json
    └── test-config.json
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

### A required configuration field is missing or invalid

The run fails before any test executes and lists the offending JSON field names. Complete the
fields in `src/integration-test/resources/test-config.json`, or provide the whole document through
the `API_LIBRARIES_INTEGRATION_TEST_CONFIG` environment variable.

### No configuration source is available

Set the `API_LIBRARIES_INTEGRATION_TEST_CONFIG` environment variable to the JSON document, or
copy `test-config.example.json` to `src/integration-test/resources/test-config.json` and complete
its values.

### Checkout returns HTTP 403 with error code `010`

The API credential or merchant account is not allowed to perform the operation. This is an account
permission or merchant-access issue rather than a test compilation problem.

### The wrong API credential is used

Confirm the test uses the service-specific client accessor. Legal Entity Management tests use
`getLegalEntityManagementClient()`, and Balance Platform tests use `getBalancePlatformClient()`.
