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

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.Mockito.verify;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;
import com.adyen.model.capital.Amount;
import com.adyen.model.capital.CalculateGrantOfferRequest;
import com.adyen.model.capital.CalculatedGrantOffer;
import com.adyen.model.capital.CreateGrantOfferRequest;
import com.adyen.model.capital.FinancingType;
import com.adyen.model.capital.GetDynamicOffersResponse;
import com.adyen.model.capital.GrantOffer;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

public class DynamicOffersApiTest extends BaseTest {

  @Test
  void testGetAllDynamicOffers() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/get-dynamic-offers-success.json");
    DynamicOffersApi dynamicOffersApi = new DynamicOffersApi(client);
    GetDynamicOffersResponse response =
        dynamicOffersApi.getAllDynamicOffers("AH00000000000000000000001");

    Assertions.assertNotNull(response);
    Assertions.assertEquals(1, response.getDynamicOffers().size());
    Assertions.assertEquals(
        "DO00000000000000000000001", response.getDynamicOffers().get(0).getId());
    Assertions.assertEquals(
        "AH00000000000000000000001", response.getDynamicOffers().get(0).getAccountHolderId());

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/dynamicOffers",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            Map.of("accountHolderId", "AH00000000000000000000001"));
  }

  @Test
  void testGetAllDynamicOffersWithFinancingType() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/get-dynamic-offers-success.json");
    DynamicOffersApi dynamicOffersApi = new DynamicOffersApi(client);
    GetDynamicOffersResponse response =
        dynamicOffersApi.getAllDynamicOffers(
            "AH00000000000000000000001", FinancingType.BUSINESSFINANCING, null);

    Assertions.assertNotNull(response);
    Assertions.assertEquals(1, response.getDynamicOffers().size());

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/dynamicOffers",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            Map.of(
                "accountHolderId", "AH00000000000000000000001",
                "financingType", "businessFinancing"));
  }

  @Test
  void testGetAllDynamicOffersWithRequestOptions() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/get-dynamic-offers-success.json");
    DynamicOffersApi dynamicOffersApi = new DynamicOffersApi(client);
    RequestOptions requestOptions =
        new RequestOptions().idempotencyKey("99361789-5204-4576-b123-4f9a1b2c3d45");
    GetDynamicOffersResponse response =
        dynamicOffersApi.getAllDynamicOffers("AH00000000000000000000001", null, requestOptions);

    Assertions.assertNotNull(response);

    ArgumentCaptor<RequestOptions> optionsCaptor = ArgumentCaptor.forClass(RequestOptions.class);
    verify(client.getHttpClient())
        .request(
            eq("https://balanceplatform-api-test.adyen.com/capital/v1/dynamicOffers"),
            eq(null),
            eq(client.getConfig()),
            eq(false),
            optionsCaptor.capture(),
            eq(ApiConstants.HttpMethod.GET),
            eq(Map.of("accountHolderId", "AH00000000000000000000001")));
    Assertions.assertEquals(
        "99361789-5204-4576-b123-4f9a1b2c3d45", optionsCaptor.getValue().getIdempotencyKey());
  }

  @Test
  void testCalculatePreliminaryOfferFromDynamicOffer() throws Exception {
    Client client =
        createMockClientFromFile("mocks/capital/calculate-preliminary-offer-success.json");
    DynamicOffersApi dynamicOffersApi = new DynamicOffersApi(client);
    CalculateGrantOfferRequest request =
        new CalculateGrantOfferRequest().amount(new Amount().currency("EUR").value(10000L));
    CalculatedGrantOffer response =
        dynamicOffersApi.calculatePreliminaryOfferFromDynamicOffer(
            "DO00000000000000000000001", request);

    Assertions.assertNotNull(response);
    Assertions.assertEquals("AH00000000000000000000001", response.getAccountHolderId());
    Assertions.assertEquals(new Amount().currency("EUR").value(10000L), response.getAmount());

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/dynamicOffers/DO00000000000000000000001/calculate",
            "{\"amount\":{\"currency\":\"EUR\",\"value\":10000}}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  void testCalculatePreliminaryOfferFromDynamicOfferWithRequestOptions() throws Exception {
    Client client =
        createMockClientFromFile("mocks/capital/calculate-preliminary-offer-success.json");
    DynamicOffersApi dynamicOffersApi = new DynamicOffersApi(client);
    CalculateGrantOfferRequest request =
        new CalculateGrantOfferRequest().amount(new Amount().currency("EUR").value(10000L));
    RequestOptions requestOptions =
        new RequestOptions().idempotencyKey("99361789-5204-4576-b123-4f9a1b2c3d45");
    CalculatedGrantOffer response =
        dynamicOffersApi.calculatePreliminaryOfferFromDynamicOffer(
            "DO00000000000000000000001", request, requestOptions);

    Assertions.assertNotNull(response);

    ArgumentCaptor<RequestOptions> optionsCaptor = ArgumentCaptor.forClass(RequestOptions.class);
    verify(client.getHttpClient())
        .request(
            eq(
                "https://balanceplatform-api-test.adyen.com/capital/v1/dynamicOffers/DO00000000000000000000001/calculate"),
            eq("{\"amount\":{\"currency\":\"EUR\",\"value\":10000}}"),
            eq(client.getConfig()),
            eq(false),
            optionsCaptor.capture(),
            eq(ApiConstants.HttpMethod.POST),
            isNull());
    Assertions.assertEquals(
        "99361789-5204-4576-b123-4f9a1b2c3d45", optionsCaptor.getValue().getIdempotencyKey());
  }

  @Test
  void testCalculatePreliminaryOfferFailsWhenMissingId() {
    Client client =
        createMockClientFromFile("mocks/capital/calculate-preliminary-offer-success.json");
    DynamicOffersApi dynamicOffersApi = new DynamicOffersApi(client);
    CalculateGrantOfferRequest request = new CalculateGrantOfferRequest();
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> dynamicOffersApi.calculatePreliminaryOfferFromDynamicOffer(null, request));
  }

  @Test
  void testCreateStaticOfferFromDynamicOffer() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/create-static-offer-success.json");
    DynamicOffersApi dynamicOffersApi = new DynamicOffersApi(client);
    CreateGrantOfferRequest request =
        new CreateGrantOfferRequest().amount(new Amount().currency("EUR").value(10000L));
    GrantOffer response =
        dynamicOffersApi.createStaticOfferFromDynamicOffer("DO00000000000000000000001", request);

    Assertions.assertNotNull(response);
    Assertions.assertEquals("GO00000000000000000000002", response.getId());
    Assertions.assertEquals("AH00000000000000000000001", response.getAccountHolderId());
    Assertions.assertEquals(new Amount().currency("EUR").value(10000L), response.getAmount());

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/capital/v1/dynamicOffers/DO00000000000000000000001/grantOffer",
            "{\"amount\":{\"currency\":\"EUR\",\"value\":10000}}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  void testCreateStaticOfferFromDynamicOfferWithRequestOptions() throws Exception {
    Client client = createMockClientFromFile("mocks/capital/create-static-offer-success.json");
    DynamicOffersApi dynamicOffersApi = new DynamicOffersApi(client);
    CreateGrantOfferRequest request =
        new CreateGrantOfferRequest().amount(new Amount().currency("EUR").value(10000L));
    RequestOptions requestOptions =
        new RequestOptions().idempotencyKey("99361789-5204-4576-b123-4f9a1b2c3d45");
    GrantOffer response =
        dynamicOffersApi.createStaticOfferFromDynamicOffer(
            "DO00000000000000000000001", request, requestOptions);

    Assertions.assertNotNull(response);

    ArgumentCaptor<RequestOptions> optionsCaptor = ArgumentCaptor.forClass(RequestOptions.class);
    verify(client.getHttpClient())
        .request(
            eq(
                "https://balanceplatform-api-test.adyen.com/capital/v1/dynamicOffers/DO00000000000000000000001/grantOffer"),
            eq("{\"amount\":{\"currency\":\"EUR\",\"value\":10000}}"),
            eq(client.getConfig()),
            eq(false),
            optionsCaptor.capture(),
            eq(ApiConstants.HttpMethod.POST),
            isNull());
    Assertions.assertEquals(
        "99361789-5204-4576-b123-4f9a1b2c3d45", optionsCaptor.getValue().getIdempotencyKey());
  }

  @Test
  void testCreateStaticOfferFailsWhenMissingId() {
    Client client = createMockClientFromFile("mocks/capital/create-static-offer-success.json");
    DynamicOffersApi dynamicOffersApi = new DynamicOffersApi(client);
    CreateGrantOfferRequest request = new CreateGrantOfferRequest();
    Assertions.assertThrows(
        IllegalArgumentException.class,
        () -> dynamicOffersApi.createStaticOfferFromDynamicOffer(null, request));
  }
}
