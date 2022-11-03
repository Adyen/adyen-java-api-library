package com.adyen.service;

import com.adyen.ApiKeyAuthenticatedService;
import com.adyen.Client;
import com.adyen.model.binlookup.*;
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
        new JSON();
    }


    public ThreeDSAvailabilityResponse get3dsAvailability(ThreeDSAvailabilityRequest threeDSAvailabilityRequest) throws Exception {
        String jsonRequest = threeDSAvailabilityRequest.toJson();
        String jsonResult = get3dsAvailability.request(jsonRequest);
        return ThreeDSAvailabilityResponse.fromJson(jsonResult);
    }

    public CostEstimateResponse getCostEstimate(CostEstimateRequest costEstimateRequest) throws Exception {
        String jsonRequest = costEstimateRequest.toJson();
        String jsonResult = getCostEstimate.request(jsonRequest);
        return CostEstimateResponse.fromJson(jsonResult);
    }
}
