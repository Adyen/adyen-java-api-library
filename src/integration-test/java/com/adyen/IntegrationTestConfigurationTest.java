/*
 * Adyen Java API Library
 *
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Offline validation of the typed integration-test configuration. */
class IntegrationTestConfigurationTest {

  static Stream<String> requiredFields() {
    return Stream.of(
        "company",
        "merchantAccount",
        "balancePlatform",
        "apiKey",
        "lemApiKey",
        "bclApiKey",
        "givingCampaignId",
        "legalEntityId",
        "businessLineId",
        "documentId",
        "accountHolderId",
        "balanceAccountId");
  }

  @Test
  public void shouldLoadEveryTypedFieldFromValidJson() {
    IntegrationTestConfiguration configuration =
        IntegrationTestConfiguration.fromJson(configurationJson(Collections.emptyMap()));

    assertEquals("TestCompany", configuration.getCompany());
    assertEquals("TestMerchantAccount", configuration.getMerchantAccount());
    assertEquals("TestBalancePlatform", configuration.getBalancePlatform());
    assertEquals("TestPspApiKey", configuration.getApiKey());
    assertEquals("TestLemApiKey", configuration.getLemApiKey());
    assertEquals("TestBclApiKey", configuration.getBclApiKey());
    assertEquals("TestGivingCampaignId", configuration.getGivingCampaignId());
    assertEquals("TestLegalEntityId", configuration.getLegalEntityId());
    assertEquals("TestBusinessLineId", configuration.getBusinessLineId());
    assertEquals("TestDocumentId", configuration.getDocumentId());
    assertEquals("TestAccountHolderId", configuration.getAccountHolderId());
    assertEquals("TestBalanceAccountId", configuration.getBalanceAccountId());
  }

  @Test
  public void shouldTrimSurroundingWhitespaceFromValues() {
    String json = configurationJson(Collections.singletonMap("company", "  TestCompany  "));

    assertEquals("TestCompany", IntegrationTestConfiguration.fromJson(json).getCompany());
  }

  @Test
  public void shouldIgnoreUnknownFieldsForForwardCompatibility() {
    String json = configurationJson(Collections.singletonMap("futureField", "FutureValue"));

    assertEquals("TestCompany", IntegrationTestConfiguration.fromJson(json).getCompany());
  }

  @Test
  public void shouldRejectMalformedJson() {
    IllegalStateException exception =
        assertThrows(IllegalStateException.class, () -> IntegrationTestConfiguration.fromJson("{"));

    assertTrue(
        exception.getMessage().contains("Failed to parse the integration test configuration"),
        exception.getMessage());
  }

  @Test
  public void shouldRejectJsonWhoseRootIsNotAnObject() {
    assertThrows(
        IllegalStateException.class,
        () -> IntegrationTestConfiguration.fromJson("[\"TestCompany\"]"));
    assertThrows(
        IllegalStateException.class,
        () -> IntegrationTestConfiguration.fromJson("\"TestCompany\""));
  }

  @ParameterizedTest(name = "should reject configuration without field {0}")
  @MethodSource("requiredFields")
  public void shouldRejectConfigurationWithMissingRequiredField(String field) {
    assertThrowsWithFieldListing(configurationJson(Collections.singletonMap(field, null)), field);
  }

  @ParameterizedTest(name = "should reject configuration with blank field {0}")
  @MethodSource("requiredFields")
  public void shouldRejectConfigurationWithBlankRequiredField(String field) {
    assertThrowsWithFieldListing(configurationJson(Collections.singletonMap(field, "   ")), field);
  }

  @Test
  public void shouldRejectConfigurationWithNonStringFieldValue() {
    assertThrowsWithFieldListing(
        configurationJson(Collections.singletonMap("company", 12345)), "company");
  }

  @Test
  public void shouldPreferTheEnvironmentVariableOverTheResource() {
    String environmentJson =
        configurationJson(Collections.singletonMap("company", "CompanyFromEnvironment"));

    IntegrationTestConfiguration configuration =
        IntegrationTestConfiguration.load(
            environmentJson,
            resourceSupplier(
                configurationJson(Collections.singletonMap("company", "CompanyFromResource"))));

    assertEquals("CompanyFromEnvironment", configuration.getCompany());
  }

  @Test
  public void shouldFallBackToTheResourceWhenTheEnvironmentVariableIsBlank() {
    Supplier<InputStream> resource =
        resourceSupplier(
            configurationJson(Collections.singletonMap("company", "CompanyFromResource")));

    IntegrationTestConfiguration configuration = IntegrationTestConfiguration.load("   ", resource);

    assertEquals("CompanyFromResource", configuration.getCompany());
  }

  @Test
  public void shouldFailWithGuidanceWhenNoConfigurationSourceIsAvailable() {
    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class, () -> IntegrationTestConfiguration.load(null, () -> null));

    assertTrue(
        exception.getMessage().contains("API_LIBRARIES_INTEGRATION_TEST_CONFIG"),
        exception.getMessage());
    assertTrue(exception.getMessage().contains("test-config.json"), exception.getMessage());
  }

  private static void assertThrowsWithFieldListing(String json, String field) {
    IllegalStateException exception =
        assertThrows(
            IllegalStateException.class, () -> IntegrationTestConfiguration.fromJson(json));

    assertTrue(
        exception.getMessage().contains(field),
        "Expected the error to list the field '" + field + "' but was: " + exception.getMessage());
  }

  private static Supplier<InputStream> resourceSupplier(String json) {
    return () -> new ByteArrayInputStream(json.getBytes(StandardCharsets.UTF_8));
  }

  private static String configurationJson(Map<String, ?> overrides) {
    Map<String, Object> values = new LinkedHashMap<>();
    values.put("company", "TestCompany");
    values.put("merchantAccount", "TestMerchantAccount");
    values.put("balancePlatform", "TestBalancePlatform");
    values.put("apiKey", "TestPspApiKey");
    values.put("lemApiKey", "TestLemApiKey");
    values.put("bclApiKey", "TestBclApiKey");
    values.put("givingCampaignId", "TestGivingCampaignId");
    values.put("legalEntityId", "TestLegalEntityId");
    values.put("businessLineId", "TestBusinessLineId");
    values.put("documentId", "TestDocumentId");
    values.put("accountHolderId", "TestAccountHolderId");
    values.put("balanceAccountId", "TestBalanceAccountId");
    overrides.forEach(
        (field, value) -> {
          if (value == null) {
            values.remove(field);
          } else {
            values.put(field, value);
          }
        });
    try {
      return new ObjectMapper().writeValueAsString(values);
    } catch (JsonProcessingException exception) {
      throw new IllegalStateException(
          "Failed to build the configuration JSON for the test", exception);
    }
  }
}
