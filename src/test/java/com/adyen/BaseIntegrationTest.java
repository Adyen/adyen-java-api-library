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
import java.util.Properties;

/**
 * Base class for Integration tests
 *
 * <p>Define in src/test/resources the configuration for the tests
 *
 * <p>``` ADYEN_API_KEY= ADYEN_MERCHANT_ACCOUNT= ADYEN_TERMINAL_DEVICE_ID=
 * ADYEN_TERMINAL_DEVICE_KEY_IDENTIFIER= ADYEN_TERMINAL_DEVICE_PASSPHRASE= ```
 */
public class BaseIntegrationTest {

  private static Properties properties = null;

  protected Client getClient() {
    return new Client(new Config().apiKey(getApiKey()).environment(Environment.TEST));
  }

  protected String getApiKey() {
    return getProperty("ADYEN_API_KEY");
  }

  protected String getMerchantAccount() {
    return getProperty("ADYEN_MERCHANT_ACCOUNT");
  }

  protected String getTerminalDeviceId() {
    return getProperty("ADYEN_TERMINAL_DEVICE_ID");
  }

  protected String getTerminalDeviceKeyIdentifier() {
    return getProperty("ADYEN_TERMINAL_DEVICE_KEY_IDENTIFIER");
  }

  protected String getTerminalDevicePassphrase() {
    return getProperty("ADYEN_TERMINAL_DEVICE_PASSPHRASE");
  }

  private Properties getProperties() {
    if (properties == null) {
      properties = new Properties();
      try (InputStream inputStream =
          BaseIntegrationTest.class.getClassLoader().getResourceAsStream("config.properties")) {
        if (inputStream != null) {
          properties.load(inputStream);
        }
      } catch (IOException e) {
        // Do nothing, properties will be empty
      }
    }

    return properties;
  }

  private String getProperty(String name) {
    String property = System.getenv(name);

    if (property != null && !property.isEmpty()) {
      return property;
    }
    property = getProperties().getProperty(name);

    if (property == null || property.isEmpty()) {
      throw new RuntimeException("Property " + name + " not defined");
    }

    return property;
  }
}
