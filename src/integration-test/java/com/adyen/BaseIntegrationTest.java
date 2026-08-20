/*
 * Adyen Java API Library
 *
 * Copyright (c) 2025 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.enums.Environment;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import org.junit.jupiter.api.AfterEach;

/** Shared client and local configuration access for integration tests. */
public abstract class BaseIntegrationTest {

  private static final String CONFIGURATION_RESOURCE = "/config.properties";
  private static final String API_KEY_PROPERTY = "API_LIBRARIES_ADYEN_API_KEY";
  private static final String LEM_API_KEY_PROPERTY = "API_LIBRARIES_ADYEN_LEM_API_KEY";
  private static final String BCL_API_KEY_PROPERTY = "API_LIBRARIES_ADYEN_BCL_API_KEY";
  private static final Properties PROPERTIES = loadProperties();
  private final Map<String, Client> clients = new HashMap<>();

  protected final Client getClient() {
    return getClient(API_KEY_PROPERTY);
  }

  protected final Client getLegalEntityManagementClient() {
    return getClient(LEM_API_KEY_PROPERTY);
  }

  protected final Client getBalancePlatformClient() {
    return getClient(BCL_API_KEY_PROPERTY);
  }

  private Client getClient(String apiKeyProperty) {
    return clients.computeIfAbsent(
        apiKeyProperty,
        property ->
            new Client(new Config().apiKey(getProperty(property)).environment(getEnvironment())));
  }

  @AfterEach
  public final void closeClients() throws IOException {
    IOException failure = null;
    for (Client client : clients.values()) {
      try {
        client.close();
      } catch (IOException exception) {
        if (failure == null) {
          failure = exception;
        } else {
          failure.addSuppressed(exception);
        }
      }
    }
    clients.clear();

    if (failure != null) {
      throw failure;
    }
  }

  protected final Environment getEnvironment() {
    return Environment.TEST;
  }

  protected final String getApiKey() {
    return getProperty(API_KEY_PROPERTY);
  }

  protected final String getMerchantAccount() {
    return getProperty("API_LIBRARIES_ADYEN_MERCHANT_ACCOUNT");
  }

  protected final String getBalancePlatformId() {
    return getProperty("API_LIBRARIES_ADYEN_BALANCE_PLATFORM_ID");
  }

  protected final String getTerminalDeviceId() {
    return getProperty("ADYEN_TERMINAL_DEVICE_ID");
  }

  protected final String getTerminalDeviceKeyIdentifier() {
    return getProperty("ADYEN_TERMINAL_DEVICE_KEY_IDENTIFIER");
  }

  protected final String getTerminalDevicePassphrase() {
    return getProperty("ADYEN_TERMINAL_DEVICE_PASSPHRASE");
  }

  private static Properties loadProperties() {
    Properties properties = new Properties();
    try (InputStream inputStream =
        BaseIntegrationTest.class.getResourceAsStream(CONFIGURATION_RESOURCE)) {
      if (inputStream != null) {
        properties.load(inputStream);
      }
    } catch (IOException exception) {
      throw new IllegalStateException(
          "Unable to load integration-test configuration from " + CONFIGURATION_RESOURCE,
          exception);
    }
    return properties;
  }

  private static String getProperty(String name) {
    String property = getOptionalProperty(name);

    if (property == null) {
      throw new IllegalStateException("Integration-test property " + name + " is not defined");
    }

    return property;
  }

  private static String getOptionalProperty(String name) {
    String property = System.getProperty(name);
    if (property == null || property.isBlank()) {
      property = System.getenv(name);
    }
    if (property == null || property.isBlank()) {
      property = PROPERTIES.getProperty(name);
    }
    return property == null || property.isBlank() ? null : property;
  }
}
