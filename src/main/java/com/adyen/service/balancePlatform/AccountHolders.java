package com.adyen.service.balancePlatform;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.balanceplatform.AccountHolder;
import com.adyen.model.balanceplatform.AccountHolderInfo;
import com.adyen.model.balanceplatform.JSON;
import com.adyen.model.balanceplatform.PaginatedBalanceAccountsResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.balancePlatform.BalancePlatformResource;

import java.io.IOException;
import java.util.Map;

public class AccountHolders extends Service {

    public AccountHolders(Client client) {
        super(client);
        new JSON();
    }

    public AccountHolder create(AccountHolderInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, "/accountHolders");
        String jsonResult = resource.request(jsonRequest);
        return AccountHolder.fromJson(jsonResult);

    }

    public AccountHolder retrieve(String id) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/accountHolders/%s", id));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return AccountHolder.fromJson(jsonResult);
    }

    public AccountHolder update(String id) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/accountHolders/%s", id));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.PATCH);
        return AccountHolder.fromJson(jsonResult);
    }

    public PaginatedBalanceAccountsResponse list(String id, Map<String, String> params) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/accountHolders/%s/balanceAccounts", id));
        String jsonResult = resource.request(null, null, ApiConstants.HttpMethod.GET, params);
        return PaginatedBalanceAccountsResponse.fromJson(jsonResult);
    }



}
