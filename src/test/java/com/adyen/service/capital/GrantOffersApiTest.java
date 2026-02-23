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
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service.capital;

import static org.mockito.Mockito.verify;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import com.adyen.model.capital.Amount;
import com.adyen.model.capital.GrantOffer;
import com.adyen.model.capital.GrantOffers;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrantOffersApiTest extends BaseTest {

  @Test
  void testGetAllGrantOffersWithQueryParam() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/grant-offers-success.json");
    GrantOffersApi grantOffersApi = new GrantOffersApi(client);
    GrantOffers response = grantOffersApi.getAllGrantOffers("AH00000000000000000000001", null);

    Assertions.assertNotNull(response);
    Assertions.assertEquals(1, response.getGrantOffers().size());
    Assertions.assertEquals("GO00000000000000000000001", response.getGrantOffers().get(0).getId());

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/grantOffers",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            Map.of("accountHolderId", "AH00000000000000000000001"));
  }

  @Test
  void testGetAllGrantOffers() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/grant-offers-success.json");
    GrantOffersApi grantOffersApi = new GrantOffersApi(client);
    GrantOffers response = grantOffersApi.getAllGrantOffers();

    Assertions.assertNotNull(response);
    Assertions.assertEquals(1, response.getGrantOffers().size());
    Assertions.assertEquals("GO00000000000000000000001", response.getGrantOffers().get(0).getId());

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/grantOffers",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            Map.of());
  }

  @Test
  void testGetGrantOffer() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/get-grant-offer-success.json");
    GrantOffersApi grantOffersApi = new GrantOffersApi(client);
    GrantOffer response = grantOffersApi.getGrantOffer("GO00000000000000000000001");

    Assertions.assertNotNull(response);
    Assertions.assertEquals("GO00000000000000000000001", response.getId());
    Assertions.assertEquals("AH00000000000000000000001", response.getAccountHolderId());
    Assertions.assertEquals(new Amount().currency("EUR").value(10000L), response.getAmount());

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/grantOffers/GO00000000000000000000001",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  void testGetGrantOfferParams() {
    Client client = createMockClientFromFile("mocks/capital/get-grant-offer-success.json");
    GrantOffersApi grantOffersApi = new GrantOffersApi(client);
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> grantOffersApi.getGrantOffer(null));
  }
}
