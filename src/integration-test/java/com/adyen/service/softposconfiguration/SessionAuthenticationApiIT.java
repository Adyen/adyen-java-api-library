/*
 * Adyen Java API Library
 *
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service.softposconfiguration;

import static com.adyen.IntegrationTestTags.EXTERNAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.adyen.BaseIntegrationTest;
import com.adyen.Client;
import com.adyen.enums.Environment;
import com.adyen.enums.Region;
import com.adyen.model.softposconfiguration.CertificateLoadingRequest;
import com.adyen.service.exception.ApiException;
import java.util.UUID;
import java.util.stream.Stream;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

@Tag(EXTERNAL)
@Timeout(60)
public class SessionAuthenticationApiIT extends BaseIntegrationTest {

  private static final String TEST_BASE_URL =
      "https://softposconfig-test.adyen.com/softposconfig/v3";
  // The service maps an invalid setup token to its INTERNAL error type, which is returned as 500.
  private static final int INVALID_SETUP_TOKEN_STATUS = 500;
  private static final String INVALID_SETUP_TOKEN_ERROR_CODE = "1029_720";

  // A valid setup token is a signed JWT issued by the Mobile SDK on a device, so automated runs
  // can only exercise the rejection path of this endpoint.
  // Scenario: Reject a certificate request with an invalid setup token
  @Test
  public void shouldRejectCertificateRequestWhenSetupTokenIsInvalid() {
    // Arrange
    CertificateLoadingRequest request =
        new CertificateLoadingRequest()
            .merchantAccount(getMerchantAccount())
            .setupToken("invalid-setup-token-" + UUID.randomUUID());
    SessionAuthenticationApi sessionAuthenticationApi = new SessionAuthenticationApi(getClient());

    // Act
    ApiException exception =
        assertThrows(
            ApiException.class,
            () -> sessionAuthenticationApi.issueCertificates(request),
            "An invalid setup token must be rejected");

    // Assert
    assertEquals(
        INVALID_SETUP_TOKEN_STATUS,
        exception.getStatusCode(),
        "An invalid setup token must return the invalid setup token error status");
    assertNotNull(exception.getError(), "The error response must contain an error body");
    assertEquals(
        INVALID_SETUP_TOKEN_ERROR_CODE,
        exception.getError().getErrorCode(),
        "An invalid setup token must return the invalid setup token error code");
  }

  // Scenario: Use the SoftPOS configuration TEST endpoint
  @Test
  public void shouldUseTestEndpointWhenEnvironmentIsTest() {
    // Act
    SessionAuthenticationApi sessionAuthenticationApi = new SessionAuthenticationApi(getClient());

    // Assert
    assertEquals(
        TEST_BASE_URL,
        sessionAuthenticationApi.baseURL,
        "The TEST environment must use the SoftPOS configuration test endpoint");
  }

  static Stream<Arguments> liveRegionToBaseUrl() {
    return Stream.of(
        Arguments.of(null, "https://softposconfig-live.adyen.com/softposconfig/v3"),
        Arguments.of(Region.EU, "https://softposconfig-live.adyen.com/softposconfig/v3"),
        Arguments.of(Region.AU, "https://softposconfig-live-au.adyen.com/softposconfig/v3"),
        Arguments.of(Region.US, "https://softposconfig-live-us.adyen.com/softposconfig/v3"),
        Arguments.of(Region.APSE, "https://softposconfig-live-apse.adyen.com/softposconfig/v3"),
        Arguments.of(Region.NEA, "https://softposconfig-live-nea.adyen.com/softposconfig/v3"));
  }

  // Only resolves the base URL: no request is sent to a LIVE endpoint.
  // Scenario: Use the regional SoftPOS configuration LIVE endpoint
  @ParameterizedTest
  @MethodSource("liveRegionToBaseUrl")
  public void shouldUseRegionalLiveEndpointWhenRegionIsConfigured(
      Region region, String expectedBaseUrl) {
    // Arrange
    Client client = getClient();
    client.getConfig().setEnvironment(Environment.LIVE);
    client.getConfig().setTerminalApiRegion(region);

    // Act
    SessionAuthenticationApi sessionAuthenticationApi = new SessionAuthenticationApi(client);

    // Assert
    assertEquals(
        expectedBaseUrl,
        sessionAuthenticationApi.baseURL,
        "The LIVE environment must use the endpoint of the configured region");
  }
}
