/*
 * Adyen Java API Library
 *
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.fasterxml.jackson.core.JsonLocation;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * Typed integration-test configuration read from a single JSON document.
 *
 * <p>The document is taken from the API_LIBRARIES_INTEGRATION_TEST_CONFIG environment variable or,
 * when that variable is absent or blank, from the /test-config.json classpath resource. Every field
 * is required and validated while loading; unknown fields are ignored so the document can grow over
 * time.
 */
final class IntegrationTestConfiguration {

  private static final String ENVIRONMENT_VARIABLE_NAME = "API_LIBRARIES_INTEGRATION_TEST_CONFIG";
  private static final String CONFIGURATION_RESOURCE = "/test-config.json";
  private static final ObjectMapper JSON_MAPPER = new ObjectMapper();

  private final String company;
  private final String merchantAccount;
  private final String balancePlatform;
  private final String apiKey;
  private final String lemApiKey;
  private final String bclApiKey;
  private final String givingCampaignId;
  private final String legalEntityId;
  private final String businessLineId;
  private final String documentId;
  private final String accountHolderId;
  private final String balanceAccountId;

  private IntegrationTestConfiguration(JsonNode root) {
    List<String> invalidFields = new ArrayList<>();
    // validate configuration: all expected variables must exist
    company = requiredTextField(root, "company", invalidFields);
    merchantAccount = requiredTextField(root, "merchantAccount", invalidFields);
    balancePlatform = requiredTextField(root, "balancePlatform", invalidFields);
    apiKey = requiredTextField(root, "apiKey", invalidFields);
    lemApiKey = requiredTextField(root, "lemApiKey", invalidFields);
    bclApiKey = requiredTextField(root, "bclApiKey", invalidFields);
    givingCampaignId = requiredTextField(root, "givingCampaignId", invalidFields);
    legalEntityId = requiredTextField(root, "legalEntityId", invalidFields);
    businessLineId = requiredTextField(root, "businessLineId", invalidFields);
    documentId = requiredTextField(root, "documentId", invalidFields);
    accountHolderId = requiredTextField(root, "accountHolderId", invalidFields);
    balanceAccountId = requiredTextField(root, "balanceAccountId", invalidFields);
    if (!invalidFields.isEmpty()) {
      throw new IllegalStateException(
          "Invalid integration test configuration: "
              + String.join(", ", invalidFields)
              + " must be non-blank JSON strings in the "
              + ENVIRONMENT_VARIABLE_NAME
              + " environment variable or in "
              + CONFIGURATION_RESOURCE);
    }
  }

  /** Loads the test configuration */
  static IntegrationTestConfiguration load() {
    return load(
        System.getenv(ENVIRONMENT_VARIABLE_NAME),
        () -> IntegrationTestConfiguration.class.getResourceAsStream(CONFIGURATION_RESOURCE));
  }

  /** Loads the configuration from an environment variable, fallback to local file */
  static IntegrationTestConfiguration load(
      String environmentValue, Supplier<InputStream> configurationResource) {
    if (environmentValue != null && !environmentValue.isBlank()) {
      return fromJson(environmentValue.trim());
    }
    try (InputStream resource = configurationResource.get()) {
      if (resource == null) {
        throw missingConfigurationException();
      }
      return fromJson(new String(resource.readAllBytes(), StandardCharsets.UTF_8));
    } catch (IOException exception) {
      throw new IllegalStateException(
          "Failed to read the integration test configuration resource " + CONFIGURATION_RESOURCE,
          exception);
    }
  }

  /** Parses and validates the configuration JSON. */
  static IntegrationTestConfiguration fromJson(String json) {
    JsonNode root;
    try {
      root = JSON_MAPPER.readTree(json);
    } catch (JsonProcessingException exception) {
      // The exception message can echo the raw JSON, so only the position is reported.
      JsonLocation location = exception.getLocation();
      String position =
          location == null
              ? ""
              : " at line " + location.getLineNr() + ", column " + location.getColumnNr();
      throw new IllegalStateException(
          "Failed to parse the integration test configuration JSON" + position);
    }
    if (root == null || !root.isObject()) {
      throw new IllegalStateException(
          "The integration test configuration must be a JSON object with string fields");
    }
    return new IntegrationTestConfiguration(root);
  }

  // variable must be a JSON string
  private static String requiredTextField(JsonNode root, String field, List<String> invalidFields) {
    JsonNode node = root.get(field);
    if (node == null || !node.isTextual()) {
      invalidFields.add(field);
      return null;
    }
    String value = node.asText().trim();
    if (value.isEmpty()) {
      invalidFields.add(field);
      return null;
    }
    return value;
  }

  private static IllegalStateException missingConfigurationException() {
    return new IllegalStateException(
        "Integration test configuration not found. Provide the JSON document through the "
            + ENVIRONMENT_VARIABLE_NAME
            + " environment variable, or copy src/integration-test/resources/test-config.example.json "
            + "to src/integration-test/resources/test-config.json and complete its values");
  }

  String getCompany() {
    return company;
  }

  String getMerchantAccount() {
    return merchantAccount;
  }

  String getBalancePlatform() {
    return balancePlatform;
  }

  String getApiKey() {
    return apiKey;
  }

  String getLemApiKey() {
    return lemApiKey;
  }

  String getBclApiKey() {
    return bclApiKey;
  }

  String getGivingCampaignId() {
    return givingCampaignId;
  }

  String getLegalEntityId() {
    return legalEntityId;
  }

  String getBusinessLineId() {
    return businessLineId;
  }

  String getDocumentId() {
    return documentId;
  }

  String getAccountHolderId() {
    return accountHolderId;
  }

  String getBalanceAccountId() {
    return balanceAccountId;
  }
}
