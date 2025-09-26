/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.enums.Environment;

/**
 * A generic service that provides shared functionality for all API services. It handles client and
 * configuration management.
 */
public class Service {
  private boolean isApiKeyRequired = false;
  private Client client;

  /**
   * Constructs a new Service.
   *
   * @param client The client used to make API calls.
   */
  protected Service(Client client) {
    this.client = client;
  }

  /**
   * Gets the client used by this service.
   *
   * @return The client.
   */
  public Client getClient() {
    return client;
  }

  /**
   * Sets the client to be used by this service.
   *
   * @param client The client.
   */
  public void setClient(Client client) {
    this.client = client;
  }

  /**
   * Returns true if the service requires an API key.
   *
   * @return A boolean indicating if an API key is required.
   */
  public boolean isApiKeyRequired() {
    return isApiKeyRequired;
  }

  /**
   * Sets if the service requires an API key.
   *
   * @param apiKeyRequired A boolean indicating if an API key is required.
   */
  public void setApiKeyRequired(boolean apiKeyRequired) {
    isApiKeyRequired = apiKeyRequired;
  }

  /**
   * Creates the base URL for a specific API endpoint. It dynamically constructs the URL based on
   * the client's configured {@link Environment}.
   *
   * @param url The base URL template.
   * @return The fully constructed base URL for the target environment.
   * @throws IllegalArgumentException if the live URL prefix is required but not configured.
   */
  protected String createBaseURL(String url) {
    Config config = this.getClient().getConfig();
    if (config.getEnvironment() != Environment.LIVE) {
      return url.replaceFirst("-live", "-test");
    }

    if (url.contains("pal-")) {
      if (config.getLiveEndpointUrlPrefix() == null) {
        throw new IllegalArgumentException("please provide a live url prefix in the client");
      }
      url =
          url.replaceFirst(
              "https://pal-test.adyen.com/pal/servlet/",
              "https://"
                  + config.getLiveEndpointUrlPrefix()
                  + "-pal-live.adyenpayments.com/pal/servlet/");
    }

    if (url.contains("checkout-")) {
      if (config.getLiveEndpointUrlPrefix() == null) {
        throw new IllegalArgumentException("please provide a live url prefix in the client");
      }
      if (url.contains("/possdk/v68")) {
        // Temporary until they fix possdk
        url =
            url.replaceFirst(
                "https://checkout-test.adyen.com/",
                "https://"
                    + config.getLiveEndpointUrlPrefix()
                    + "-checkout-live.adyenpayments.com/");
      } else {
        url =
            url.replaceFirst(
                "https://checkout-test.adyen.com/",
                "https://"
                    + config.getLiveEndpointUrlPrefix()
                    + "-checkout-live.adyenpayments.com/checkout/");
      }
    }

    return url.replaceFirst("-test", "-live");
  }
}
