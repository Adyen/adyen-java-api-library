package com.adyen.service.balancePlatform;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.balanceplatform.BalanceAccount;
import com.adyen.model.balanceplatform.BalanceAccountInfo;
import com.adyen.model.balanceplatform.BalanceAccountUpdateRequest;
import com.adyen.model.balanceplatform.BalanceSweepConfigurationsResponse;
import com.adyen.model.balanceplatform.SweepConfigurationV2;
import com.adyen.model.balanceplatform.PaginatedPaymentInstrumentsResponse;
import com.adyen.model.balanceplatform.JSON;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.balancePlatform.BalancePlatformResource;

import java.io.IOException;
import java.util.Map;

public class BalanceAccounts extends Service {

    public BalanceAccounts(Client client) {
        super(client);
        new JSON();
    }

    public BalanceAccount create(BalanceAccountInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, "/balanceAccounts");
        String jsonResult = resource.request(jsonRequest);
        return BalanceAccount.fromJson(jsonResult);
    }

    public BalanceSweepConfigurationsResponse listSweeps(String id, Map<String, String> params) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/sweeps", id));
        String jsonResult = resource.request(null, null, ApiConstants.HttpMethod.GET, params);
        return BalanceSweepConfigurationsResponse.fromJson(jsonResult);
    }

    public BalanceSweepConfigurationsResponse createSweep(String id, SweepConfigurationV2 request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/sweeps", id));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.POST);
        return BalanceSweepConfigurationsResponse.fromJson(jsonResult);
    }

    public void deleteSweep(String id, String sweepId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/sweeps/%s", id, sweepId));
        resource.request(null, ApiConstants.HttpMethod.DELETE);
    }

    public SweepConfigurationV2 retrieveSweep(String id, String sweepId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/sweeps/%s", id, sweepId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return SweepConfigurationV2.fromJson(jsonResult);
    }

    public SweepConfigurationV2 updateSweep(String id, String sweepId, SweepConfigurationV2 request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/sweeps/%s", id, sweepId));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.PATCH);
        return SweepConfigurationV2.fromJson(jsonResult);
    }

    public BalanceAccount retrieve(String id) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s", id));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return BalanceAccount.fromJson(jsonResult);
    }

    public BalanceAccount update(String id, BalanceAccountUpdateRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s", id));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.PATCH);
        return BalanceAccount.fromJson(jsonResult);
    }

    public PaginatedPaymentInstrumentsResponse listPaymentInstruments(String id, Map<String, String> params) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/paymentInstruments", id));
        String jsonResult = resource.request(null, null, ApiConstants.HttpMethod.GET, params);
        return PaginatedPaymentInstrumentsResponse.fromJson(jsonResult);
    }
}
