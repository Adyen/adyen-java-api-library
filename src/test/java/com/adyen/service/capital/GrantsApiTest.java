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
import com.adyen.model.capital.*;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class GrantsApiTest extends BaseTest {

  @Test
  void testGetGrant() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/get-grant-success.json");
    GrantsApi grantsApi = new GrantsApi(client);
    Grant response = grantsApi.getGrant("GR00000000000000000000001");

    Assertions.assertNotNull(response);
    Assertions.assertEquals("GR00000000000000000000001", response.getId());
    Assertions.assertEquals("CG00000000000000000000001", response.getGrantAccountId());
    Assertions.assertEquals("GO00000000000000000000001", response.getGrantOfferId());
    Assertions.assertEquals(new Amount().currency("EUR").value(10000L), response.getAmount());
    Assertions.assertEquals(new Status().code(Status.CodeEnum.ACTIVE), response.getStatus());
    Assertions.assertEquals(
        new Balance().currency("EUR").principal(10000L).fee(1000L).total(11000L),
        response.getBalances());
    Assertions.assertEquals(
        new Counterparty()
            .accountHolderId("AH00000000000000000000001")
            .balanceAccountId("BA00000000000000000000001"),
        response.getCounterparty());

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/grants/GR00000000000000000000001",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  void testGetAllGrants() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/grants-success.json");
    GrantsApi grantsApi = new GrantsApi(client);
    Grants grants = grantsApi.getAllGrants("GR00000000000000000000001");
    Assertions.assertNotNull(grants);
    Assertions.assertEquals(1, grants.getGrants().size());
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/grants",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            Map.of("counterpartyAccountHolderId", "GR00000000000000000000001"));
  }

  @Disabled("Because we are not currently validating against required query parameters")
  @Test
  void testGetAllGrantsParams() {
    Client client = createMockClientFromFile("mocks/capital/grants-success.json");
    GrantsApi grantsApi = new GrantsApi(client);
    Assertions.assertThrows(IllegalArgumentException.class, () -> grantsApi.getAllGrants(null));
  }

  @Test
  void testRequestGrant() throws Exception {

    Client client = createMockClientFromFile("mocks/capital/request-grant.json");
    GrantsApi grantsApi = new GrantsApi(client);
    GrantInfo grantInfo = new GrantInfo().grantAccountId("GR00000000000000000000001");
    Grant response = grantsApi.requestGrant(grantInfo);

    Assertions.assertNotNull(response);
    Assertions.assertEquals("GR00000000000000000000001", response.getId());
    Assertions.assertEquals("CG00000000000000000000001", response.getGrantAccountId());
    Assertions.assertEquals("0000000000000001", response.getGrantOfferId());
    Assertions.assertEquals(new Amount().currency("EUR").value(1000000L), response.getAmount());
    Assertions.assertEquals(new Status().code(Status.CodeEnum.PENDING), response.getStatus());
    Assertions.assertEquals(
        new Balance().currency("EUR").principal(1000000L).fee(120000L).total(1120000L),
        response.getBalances());
    Assertions.assertEquals(
        new Counterparty()
            .accountHolderId("AH00000000000000000000001")
            .balanceAccountId("BA00000000000000000000001"),
        response.getCounterparty());
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/grants",
            "{\"grantAccountId\":\"GR00000000000000000000001\"}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  void testGetGrantDisbursement() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/get-grant-disbursement-success.json");
    GrantsApi grantsApi = new GrantsApi(client);
    Disbursement response =
        grantsApi.getGrantDisbursement("GR00000000000000000000001", "DI00000000000000000000001");
    Assertions.assertNotNull(response);
    Assertions.assertEquals("DI00000000000000000000001", response.getId());
    Assertions.assertEquals("GR00000000000000000000001", response.getGrantId());
    Assertions.assertEquals("AH00000000000000000000001", response.getAccountHolderId());
    Assertions.assertEquals("BA00000000000000000000001", response.getBalanceAccountId());
    Assertions.assertEquals(new Amount().currency("EUR").value(10000L), response.getAmount());
    Assertions.assertEquals(
        new Balance().currency("EUR").principal(10000L).fee(1000L).total(11000L),
        response.getBalances());
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/grants/GR00000000000000000000001/disbursements/DI00000000000000000000001",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  void testGetAllGrantDisbursements() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/get-grant-disbursements-success.json");
    GrantsApi grantsApi = new GrantsApi(client);
    Disbursements response = grantsApi.getAllGrantDisbursements("GR00000000000000000000001");
    Assertions.assertNotNull(response);
    Assertions.assertEquals(1, response.getDisbursements().size());
    Assertions.assertEquals(
        "DI00000000000000000000001", response.getDisbursements().get(0).getId());
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/grants/GR00000000000000000000001/disbursements",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  void testGetAllGrantDisbursementsParams() {
    Client client = createMockClientFromFile("mocks/capital/get-grant-disbursements-success.json");
    GrantsApi grantsApi = new GrantsApi(client);
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> grantsApi.getAllGrantDisbursements(null));
  }

  @Test
  void testUpdateGrantDisbursement() throws Exception {
    Client client =
        createMockClientFromFile("mocks/capital/update-grant-disbursement-success.json");
    GrantsApi grantsApi = new GrantsApi(client);
    DisbursementInfoUpdate disbursementInfoUpdate = new DisbursementInfoUpdate();
    Disbursement response =
        grantsApi.updateGrantDisbursement(
            "GR00000000000000000000001", "DI00000000000000000000001", disbursementInfoUpdate);
    Assertions.assertNotNull(response);
    Assertions.assertEquals("DI00000000000000000000001", response.getId());
    Assertions.assertEquals("GR00000000000000000000001", response.getGrantId());
    Assertions.assertEquals("AH00000000000000000000001", response.getAccountHolderId());
    Assertions.assertEquals("BA00000000000000000000001", response.getBalanceAccountId());
    Assertions.assertEquals(new Amount().currency("EUR").value(10000L), response.getAmount());
    Assertions.assertEquals(
        new Balance().currency("EUR").principal(10000L).fee(1000L).total(11000L),
        response.getBalances());
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/grants/GR00000000000000000000001/disbursements/DI00000000000000000000001",
            "{}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.PATCH,
            null);
  }

  @Test
  void testUpdateGrantDisbursementParams() throws Exception {
    Client client =
        createMockClientFromFile("mocks/capital/update-grant-disbursement-success.json");
    GrantsApi grantsApi = new GrantsApi(client);
    DisbursementInfoUpdate disbursementInfoUpdate = new DisbursementInfoUpdate();
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () ->
            grantsApi.updateGrantDisbursement(
                null, "DI00000000000000000000001", disbursementInfoUpdate));
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> grantsApi.updateGrantDisbursement("something", null, disbursementInfoUpdate));
  }
}
