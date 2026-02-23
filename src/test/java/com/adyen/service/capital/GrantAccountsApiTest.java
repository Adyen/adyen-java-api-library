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
import com.adyen.model.capital.GrantAccount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GrantAccountsApiTest extends BaseTest {

  @Test
  void testGetGrantAccount() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/get-grant-account-success.json");
    GrantAccountsApi grantAccountsApi = new GrantAccountsApi(client);
    GrantAccount response =
        grantAccountsApi.getGrantAccountInformation("CG00000000000000000000001");

    Assertions.assertNotNull(response);
    Assertions.assertEquals("CG00000000000000000000001", response.getId());
    Assertions.assertEquals("BA00000000000000000000001", response.getFundingBalanceAccountId());
    Assertions.assertEquals(1, response.getLimits().size());
    Assertions.assertEquals(1, response.getBalances().size());

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/grantAccounts/CG00000000000000000000001",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  void testGetGrantAccountRequiredParams() {
    Client client = createMockClientFromFile("mocks/capital/get-grant-account-success.json");
    GrantAccountsApi grantAccountsApi = new GrantAccountsApi(client);
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> grantAccountsApi.getGrantAccountInformation(null));
  }
}
