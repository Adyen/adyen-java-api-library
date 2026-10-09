/*
 * Adyen Java API Library
 *
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service.balanceplatform;

import static com.adyen.IntegrationTestTags.EXTERNAL;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.adyen.BaseIntegrationTest;
import com.adyen.model.balanceplatform.BalancePlatform;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Tag(EXTERNAL)
@Timeout(60)
public class PlatformApiIT extends BaseIntegrationTest {

  // Scenario: Retrieve a balance platform
  @Test
  public void shouldRetrieveBalancePlatform() throws ApiException, IOException {
    // Arrange
    String balancePlatformId = getBalancePlatformId();
    PlatformApi platformApi = new PlatformApi(getBalancePlatformClient());

    // Act
    BalancePlatform response = platformApi.getBalancePlatform(balancePlatformId);

    // Assert
    assertEquals(
        balancePlatformId,
        response.getId(),
        "The response must contain the requested balance platform ID");
  }
}
