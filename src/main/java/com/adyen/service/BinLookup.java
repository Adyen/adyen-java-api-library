package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.constants.ApiConstants;
import com.adyen.model.binlookup.CostEstimateRequest;
import com.adyen.model.binlookup.CostEstimateResponse;
import com.adyen.model.binlookup.ThreeDSAvailabilityRequest;
import com.adyen.model.binlookup.ThreeDSAvailabilityResponse;
import com.adyen.service.resource.binlookup.Get3dsAvailability;
import com.adyen.service.resource.binlookup.GetCostEstimate;
import com.google.gson.reflect.TypeToken;

public class BinLookup extends ApiKeyAuthenticatedService {

    private final Get3dsAvailability get3dsAvailability;
    private final GetCostEstimate getCostEstimate;

    public BinLookup(Client client) {
        super(client);
        get3dsAvailability = new Get3dsAvailability(this);
        getCostEstimate = new GetCostEstimate(this);
    }


    public ThreeDSAvailabilityResponse get3dsAvailability(ThreeDSAvailabilityRequest threeDSAvailabilityRequest) throws Exception {
        String jsonRequest = GSON.toJson(threeDSAvailabilityRequest);

        String jsonResult = get3dsAvailability.request(jsonRequest, ApiConstants.HttpMethod.POST);

        return GSON.fromJson(jsonResult, new TypeToken<ThreeDSAvailabilityResponse>() {
        }.getType());
    }

    public CostEstimateResponse getCostEstimate(CostEstimateRequest costEstimateRequest) throws Exception {
        String jsonRequest = GSON.toJson(costEstimateRequest);

        String jsonResult = getCostEstimate.request(jsonRequest, ApiConstants.HttpMethod.POST);

        return GSON.fromJson(jsonResult, new TypeToken<CostEstimateResponse>() {
        }.getType());
    }

}
