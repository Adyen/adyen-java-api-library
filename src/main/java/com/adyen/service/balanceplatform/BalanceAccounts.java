package com.adyen.service.balanceplatform;

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
import com.adyen.service.resource.balanceplatform.BalancePlatformResource;

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

    public BalanceSweepConfigurationsResponse listSweeps(String balanceAccountId, Map<String, String> queryString) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/sweeps", balanceAccountId));
        String jsonResult = resource.request(null, null, ApiConstants.HttpMethod.GET, null, queryString);
        return BalanceSweepConfigurationsResponse.fromJson(jsonResult);
    }

    public BalanceSweepConfigurationsResponse createSweep(String balanceAccountId, SweepConfigurationV2 request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/sweeps", balanceAccountId));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.POST);
        return BalanceSweepConfigurationsResponse.fromJson(jsonResult);
    }

    public void deleteSweep(String balanceAccountId, String sweepId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/sweeps/%s", balanceAccountId, sweepId));
        resource.request(null, ApiConstants.HttpMethod.DELETE);
    }

    public SweepConfigurationV2 retrieveSweep(String balanceAccountId, String sweepId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/sweeps/%s", balanceAccountId, sweepId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return SweepConfigurationV2.fromJson(jsonResult);
    }

    public SweepConfigurationV2 updateSweep(String balanceAccountId, String sweepId, SweepConfigurationV2 request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/sweeps/%s", balanceAccountId, sweepId));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.PATCH);
        return SweepConfigurationV2.fromJson(jsonResult);
    }

    public BalanceAccount retrieve(String balanceAccountId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s", balanceAccountId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return BalanceAccount.fromJson(jsonResult);
    }

    public BalanceAccount update(String balanceAccountId, BalanceAccountUpdateRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s", balanceAccountId));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.PATCH);
        return BalanceAccount.fromJson(jsonResult);
    }

    public PaginatedPaymentInstrumentsResponse listPaymentInstruments(String balanceAccountId, Map<String, String> queryString) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balanceAccounts/%s/paymentInstruments", balanceAccountId));
        String jsonResult = resource.request(null, null, ApiConstants.HttpMethod.GET, null, queryString);
        return PaginatedPaymentInstrumentsResponse.fromJson(jsonResult);
    }
}
