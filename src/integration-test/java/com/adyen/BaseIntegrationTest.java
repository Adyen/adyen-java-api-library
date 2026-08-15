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
import java.util.Locale;
import java.util.Properties;

/** Shared client and local configuration access for integration tests. */
public abstract class BaseIntegrationTest {

  private static final String CONFIGURATION_RESOURCE = "config.properties";
  private static final String ENVIRONMENT_PROPERTY = "Adyen_Environment";
  private static final String LIVE_ENDPOINT_URL_PREFIX_PROPERTY = "ADYEN_LIVE_ENDPOINT_URL_PREFIX";
  private static final Properties PROPERTIES = loadProperties();

  protected final Client getClient() {
    Environment environment = getEnvironment();
    Config config = new Config().apiKey(getApiKey()).environment(environment);

    String liveEndpointUrlPrefix = getOptionalProperty(LIVE_ENDPOINT_URL_PREFIX_PROPERTY);
    if (environment == Environment.LIVE && liveEndpointUrlPrefix != null) {
      config.liveEndpointUrlPrefix(liveEndpointUrlPrefix);
    }

    return new Client(config);
  }

  protected final Environment getEnvironment() {
    Environment adyenEnvironment = Environment.valueOf("TEST"); // set TEST as default

    try {
      // override if needed
      String configuredEnvironment = getProperty(ENVIRONMENT_PROPERTY);
      adyenEnvironment = Environment.valueOf(configuredEnvironment.trim().toUpperCase(Locale.ROOT));
    } catch (IllegalStateException exception) {
      // use default
    }

    return adyenEnvironment;
  }

  protected final void requireTestEnvironment() {
    if (getEnvironment() != Environment.TEST) {
      throw new IllegalStateException(
          getClass().getSimpleName() + " uses TEST-only data and cannot run against LIVE");
    }
  }

  protected final String getApiKey() {
    return getProperty("ADYEN_API_KEY");
  }

  protected final String getMerchantAccount() {
    return getProperty("ADYEN_MERCHANT_ACCOUNT");
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
        BaseIntegrationTest.class.getClassLoader().getResourceAsStream(CONFIGURATION_RESOURCE)) {
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
    String property = System.getenv(name);
    if (property == null || property.isBlank()) {
      property = PROPERTIES.getProperty(name);
    }
    return property == null || property.isBlank() ? null : property;
  }
}
