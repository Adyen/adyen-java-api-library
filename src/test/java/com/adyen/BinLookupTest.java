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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.Amount;
import com.adyen.model.binlookup.CostEstimateAssumptions;
import com.adyen.model.binlookup.CostEstimateRequest;
import com.adyen.model.binlookup.CostEstimateResponse;
import com.adyen.model.binlookup.MerchantDetails;
import com.adyen.model.binlookup.ThreeDSAvailabilityRequest;
import com.adyen.model.binlookup.ThreeDSAvailabilityResponse;
import com.adyen.service.BinLookup;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

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
        Client client = createMockClientFromFile("mocks/binlookup/get3dsavailability-success.json");
        BinLookup binLookup = new BinLookup(client);

        ThreeDSAvailabilityRequest threeDSAvailabilityRequest = new ThreeDSAvailabilityRequest();
        threeDSAvailabilityRequest.setMerchantAccount("merchantAccount");
        threeDSAvailabilityRequest.setCardNumber("4111111111111111");

        ThreeDSAvailabilityResponse threeDSAvailabilityResponse = binLookup.get3dsAvailability(threeDSAvailabilityRequest);
        assertEquals("visa", threeDSAvailabilityResponse.getDsPublicKeys().get(0).getBrand());
        assertEquals("visa", threeDSAvailabilityResponse.getThreeDS2CardRangeDetails().get(0).getBrandCode());
        assertEquals(true, threeDSAvailabilityResponse.isThreeDS1Supported());
    }

    @Test
    public void TestGet3dsAvailabilityInvalidMerchantMocked() throws Exception {
        Client client = createMockClientForErrors(403,"mocks/binlookup/get3dsavailability-error-merchant.json");
        BinLookup binLookup = new BinLookup(client);

        ThreeDSAvailabilityRequest threeDSAvailabilityRequest = new ThreeDSAvailabilityRequest();
        threeDSAvailabilityRequest.setMerchantAccount(null);
        threeDSAvailabilityRequest.setCardNumber("4111111111111111");

        try {
            binLookup.get3dsAvailability(threeDSAvailabilityRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("901", e.getError().getErrorCode());
            assertEquals(403, e.getError().getStatus());
        }
    }

    @Test
    public void TestGetCostEstimateSuccessMocked() throws Exception {

        Client client = createMockClientFromFile("mocks/binlookup/getcostestimate-success.json");
        BinLookup binLookup = new BinLookup(client);

        CostEstimateRequest costEstimateRequest = new CostEstimateRequest();
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(new Long("1000"));
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
        assertEquals("1111", costEstimateResponse.getCardBin().getSummary());
        assertEquals("Unsupported", costEstimateResponse.getResultCode());
        assertEquals("ZERO", costEstimateResponse.getSurchargeType());
    }

    @Test
    public void TestGetCostEstimateInvalidMerchantMocked() throws Exception {
        Client client = createMockClientForErrors(500,"mocks/binlookup/getcostestimate-error-merchant.json");
        BinLookup binLookup = new BinLookup(client);

        CostEstimateRequest costEstimateRequest = new CostEstimateRequest();
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(new Long("1000"));
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
            assertNotNull(e.getError());
            assertEquals("901", e.getError().getErrorCode());
            assertEquals(500, e.getError().getStatus());
        }
    }

    @Test
    public void TestGetCostEstimateInvalidCardNumberMocked() throws Exception {
        Client client = createMockClientForErrors(422,"mocks/binlookup/getcostestimate-error-cardnumber.json");
        BinLookup binLookup = new BinLookup(client);

        CostEstimateRequest costEstimateRequest = new CostEstimateRequest();
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(new Long("1000"));
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
            assertNotNull(e.getError());
            assertEquals("000", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
        }
    }

    @Test
    public void TestGetCostEstimateInvalidAmountMocked() throws Exception {
        Client client = createMockClientForErrors(422,"mocks/binlookup/getcostestimate-error-amount.json");
        BinLookup binLookup = new BinLookup(client);

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
            assertNotNull(e.getError());
            assertEquals("100", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
        }
    }

}