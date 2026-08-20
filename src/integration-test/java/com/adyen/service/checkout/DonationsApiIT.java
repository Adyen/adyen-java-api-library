/*
 * Adyen Java API Library
 *
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service.checkout;

import static com.adyen.IntegrationTestTags.EXTERNAL;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.adyen.BaseIntegrationTest;
import com.adyen.model.checkout.DonationCampaignsRequest;
import com.adyen.model.checkout.DonationCampaignsResponse;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Tag(EXTERNAL)
@Timeout(60)
public class DonationsApiIT extends BaseIntegrationTest {

  // Scenario: Get donation campaigns
  @Test
  public void shouldGetDonationCampaigns() throws ApiException, IOException {
    // Arrange
    DonationCampaignsRequest request =
        new DonationCampaignsRequest().merchantAccount(getMerchantAccount()).currency("EUR");
    DonationsApi donationsApi = new DonationsApi(getClient());

    // Act
    DonationCampaignsResponse response = donationsApi.donationCampaigns(request);

    // Assert
    assertNotNull(
        response.getDonationCampaigns(), "The donation campaigns response must contain an array");
  }
}
