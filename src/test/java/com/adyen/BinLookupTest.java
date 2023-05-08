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
 * Copyright (c) 2022 Adyen N.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.binlookup.*;
import com.adyen.service.BinLookupApi;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * Tests for
 * /get3dsAvailability
 * /getCostEstimate
 */
public class BinLookupTest extends BaseTest {


    @Test
    public void TestGet3dsAvailabilitySuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/binlookup/get3dsAvailability-200-success.json");
        BinLookupApi binLookup = new BinLookupApi(client);

        ThreeDSAvailabilityRequest threeDSAvailabilityRequest = new ThreeDSAvailabilityRequest();
        threeDSAvailabilityRequest.setMerchantAccount("merchantAccount");
        threeDSAvailabilityRequest.setCardNumber("4111111111111111");

        ThreeDSAvailabilityResponse threeDSAvailabilityResponse = binLookup.get3dsAvailability(threeDSAvailabilityRequest);
        assertEquals(true, threeDSAvailabilityResponse.getThreeDS1Supported());
        assertEquals(false, threeDSAvailabilityResponse.getThreeDS2supported());
        assertEquals(new ArrayList<ThreeDS2CardRangeDetail>(), threeDSAvailabilityResponse.getThreeDS2CardRangeDetails());
    }

    @Test
    public void TestGet3dsAvailabilityInvalidMerchantMocked() throws Exception {
        Client client = createMockClientForErrors(403, "mocks/binlookup/get3dsavailability-error-merchant.json");
        BinLookupApi binLookup = new BinLookupApi(client);

        ThreeDSAvailabilityRequest threeDSAvailabilityRequest = new ThreeDSAvailabilityRequest();
        threeDSAvailabilityRequest.setMerchantAccount(null);
        threeDSAvailabilityRequest.setCardNumber("4111111111111111");

        try {
            binLookup.get3dsAvailability(threeDSAvailabilityRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertEquals(403, e.getStatusCode());
        }
    }

    @Test
    public void TestGetCostEstimateSuccessMocked() throws Exception {

        Client client = createMockClientFromFile("mocks/binlookup/getCostEstimate-getCostEstimate-200.json");
        BinLookupApi binLookup = new BinLookupApi(client);

        CostEstimateRequest costEstimateRequest = new CostEstimateRequest();
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(Long.valueOf("1000"));
        costEstimateRequest.setAmount(amount);

        CostEstimateAssumptions costEstimateAssumptions = new CostEstimateAssumptions();
        costEstimateAssumptions.setAssumeLevel3Data(true);
        costEstimateAssumptions.setAssume3DSecureAuthenticated(true);

        costEstimateRequest.setAssumptions(costEstimateAssumptions);
        costEstimateRequest.setCardNumber("4111111111111111");
        costEstimateRequest.setMerchantAccount("merchantAccount");
        MerchantDetails merchantDetails = new MerchantDetails();
        merchantDetails.setCountryCode("NL");
        merchantDetails.setMcc("7411");
        merchantDetails.setEnrolledIn3DSecure(true);
        costEstimateRequest.setMerchantDetails(merchantDetails);
        costEstimateRequest.setShopperInteraction(CostEstimateRequest.ShopperInteractionEnum.ECOMMERCE);


        CostEstimateResponse costEstimateResponse = binLookup.getCostEstimate(costEstimateRequest);
        assertEquals("EUR", costEstimateResponse.getCostEstimateAmount().getCurrency());
        assertEquals(12L, costEstimateResponse.getCostEstimateAmount().getValue().longValue());
        assertEquals("Success", costEstimateResponse.getResultCode());
        assertEquals("PASSTHROUGH", costEstimateResponse.getSurchargeType());
    }

    @Test
    public void TestGetCostEstimateInvalidMerchantMocked() throws Exception {
        Client client = createMockClientForErrors(500, "mocks/binlookup/getcostestimate-error-merchant.json");
        BinLookupApi binLookup = new BinLookupApi(client);

        CostEstimateRequest costEstimateRequest = new CostEstimateRequest();
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(Long.valueOf("1000"));
        costEstimateRequest.setAmount(amount);

        CostEstimateAssumptions costEstimateAssumptions = new CostEstimateAssumptions();
        costEstimateAssumptions.setAssumeLevel3Data(true);
        costEstimateAssumptions.setAssume3DSecureAuthenticated(true);

        costEstimateRequest.setAssumptions(costEstimateAssumptions);
        costEstimateRequest.setCardNumber("4111111111111111");
        costEstimateRequest.setMerchantAccount(null);
        MerchantDetails merchantDetails = new MerchantDetails();
        merchantDetails.setCountryCode("NL");
        merchantDetails.setMcc("7411");
        merchantDetails.setEnrolledIn3DSecure(true);
        costEstimateRequest.setMerchantDetails(merchantDetails);
        costEstimateRequest.setShopperInteraction(CostEstimateRequest.ShopperInteractionEnum.ECOMMERCE);

        try {
            binLookup.getCostEstimate(costEstimateRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertEquals(500, e.getStatusCode());
        }
    }

    @Test
    public void TestGetCostEstimateInvalidCardNumberMocked() throws Exception {
        Client client = createMockClientForErrors(422, "mocks/binlookup/getcostestimate-error-cardnumber.json");
        BinLookupApi binLookup = new BinLookupApi(client);

        CostEstimateRequest costEstimateRequest = new CostEstimateRequest();
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(Long.valueOf("1000"));
        costEstimateRequest.setAmount(amount);

        CostEstimateAssumptions costEstimateAssumptions = new CostEstimateAssumptions();
        costEstimateAssumptions.setAssumeLevel3Data(true);
        costEstimateAssumptions.setAssume3DSecureAuthenticated(true);

        costEstimateRequest.setAssumptions(costEstimateAssumptions);
        costEstimateRequest.setCardNumber(null);
        costEstimateRequest.setMerchantAccount("merchantAccount");
        MerchantDetails merchantDetails = new MerchantDetails();
        merchantDetails.setCountryCode("NL");
        merchantDetails.setMcc("7411");
        merchantDetails.setEnrolledIn3DSecure(true);
        costEstimateRequest.setMerchantDetails(merchantDetails);
        costEstimateRequest.setShopperInteraction(CostEstimateRequest.ShopperInteractionEnum.ECOMMERCE);

        try {
            binLookup.getCostEstimate(costEstimateRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertEquals(422, e.getStatusCode());
        }
    }

    @Test
    public void TestGetCostEstimateInvalidAmountMocked() throws Exception {
        Client client = createMockClientForErrors(422, "mocks/binlookup/getcostestimate-error-amount.json");
        BinLookupApi binLookup = new BinLookupApi(client);

        CostEstimateRequest costEstimateRequest = new CostEstimateRequest();
        costEstimateRequest.setAmount(null);

        CostEstimateAssumptions costEstimateAssumptions = new CostEstimateAssumptions();
        costEstimateAssumptions.setAssumeLevel3Data(true);
        costEstimateAssumptions.setAssume3DSecureAuthenticated(true);

        costEstimateRequest.setAssumptions(costEstimateAssumptions);
        costEstimateRequest.setCardNumber("4111111111111111");
        costEstimateRequest.setMerchantAccount("merchantAccount");
        MerchantDetails merchantDetails = new MerchantDetails();
        merchantDetails.setCountryCode("NL");
        merchantDetails.setMcc("7411");
        merchantDetails.setEnrolledIn3DSecure(true);
        costEstimateRequest.setMerchantDetails(merchantDetails);
        costEstimateRequest.setShopperInteraction(CostEstimateRequest.ShopperInteractionEnum.ECOMMERCE);

        try {
            binLookup.getCostEstimate(costEstimateRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertEquals(422, e.getStatusCode());
        }
    }

}
