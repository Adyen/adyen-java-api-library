<integration_test_guidelines>
## Scope

These instructions apply to files under `src/integration-test`.

## Before Writing a Test

- Read `src/integration-test/README.md`.
- Verify the public service method and model types in `src/main/java`.
- Do not edit generated production models or services to make an integration test pass.
- Determine whether the test is automated external coverage or requires manual infrastructure.

## Structure

- Mirror the production package under `src/integration-test/java`.
- Name integration-test classes `*IT` so Maven Failsafe discovers them.
- Extend `BaseIntegrationTest` and use its typed configuration accessors.
- Annotate external tests with `@Tag(IntegrationTestTags.EXTERNAL)`.
- Also annotate tests requiring a person, terminal, or other dedicated infrastructure with
  `@Tag(IntegrationTestTags.MANUAL)`.
- Use behavior-focused names such as `shouldReturnValidationErrorWhenReferenceIsMissing`.
- Keep one observable behavior per test and use Arrange, Act, Assert sections.
- Prefer explicit imports, response types, and checked exceptions. Do not use wildcard imports,
  `var`, or `throws Exception`.

## Reliability and Safety

- Generate unique references and idempotency keys for requests that create remote state.
- Do not share mutable state or depend on test execution order.
- Clean up remotely created resources when the API supports cleanup.
- For eventually consistent APIs, use bounded polling rather than fixed sleeps.
- Add a suitable timeout when an operation can otherwise wait indefinitely.
- Tests containing Adyen test cards or other TEST-only data must call `requireTestEnvironment()` in
  `@BeforeEach`.
- Do not use `@Disabled` as the normal opt-in mechanism. Use the Maven profiles and JUnit tags.
- Do not run an external integration test unless the user explicitly asks for that API call.

## Assertions and Comments

- Assert stable contract fields, identifiers, statuses, and documented error codes.
- Assert exact error messages only when the wording is part of the documented contract.
- Include assertion messages that explain the violated contract.
- Extract repeated request construction and response assertions into focused helpers.
- Keep comments limited to prerequisites, non-obvious API constraints, and Arrange, Act, Assert
  markers. Do not narrate straightforward Java.

## Validation

Validate generated tests without contacting Adyen:

```bash
mvn spotless:apply
mvn -Pintegration-tests -DskipTests test-compile
mvn spotless:check checkstyle:check -DskipTests
```

Use the opt-in execution commands from `src/integration-test/README.md` only when external execution
is explicitly requested.
</integration_test_guidelines>
