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
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;

/** Shared typed configuration and clients for integration tests. */
public abstract class BaseIntegrationTest {

  private static IntegrationTestConfiguration configuration;

  // Clients cache by credential label (e.g. "balancePlatform")
  private final Map<String, Client> clients = new HashMap<>();

  @BeforeAll
  static void loadConfiguration() {
    configuration = IntegrationTestConfiguration.load();
  }

  protected final Client getClient() {
    return getClient("psp", configuration.getApiKey());
  }

  protected final Client getLegalEntityManagementClient() {
    return getClient("legalEntityManagement", configuration.getLemApiKey());
  }

  protected final Client getBalancePlatformClient() {
    return getClient("balancePlatform", configuration.getBclApiKey());
  }

  private Client getClient(String clientName, String apiKey) {
    return clients.computeIfAbsent(
        clientName, name -> new Client(new Config().apiKey(apiKey).environment(getEnvironment())));
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

  protected final String getCompany() {
    return configuration.getCompany();
  }

  protected final String getApiKey() {
    return configuration.getApiKey();
  }

  protected final String getMerchantAccount() {
    return configuration.getMerchantAccount();
  }

  protected final String getBalancePlatformId() {
    return configuration.getBalancePlatform();
  }

  protected final String getGivingCampaignId() {
    return configuration.getGivingCampaignId();
  }

  protected final String getLegalEntityId() {
    return configuration.getLegalEntityId();
  }

  protected final String getBusinessLineId() {
    return configuration.getBusinessLineId();
  }

  protected final String getDocumentId() {
    return configuration.getDocumentId();
  }

  protected final String getAccountHolderId() {
    return configuration.getAccountHolderId();
  }

  protected final String getBalanceAccountId() {
    return configuration.getBalanceAccountId();
  }
}
