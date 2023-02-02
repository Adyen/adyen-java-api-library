package com.adyen.service.balanceplatform;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.balanceplatform.AccountHolder;
import com.adyen.model.balanceplatform.AccountHolderInfo;
import com.adyen.model.balanceplatform.JSON;
import com.adyen.model.balanceplatform.PaginatedBalanceAccountsResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.balanceplatform.BalancePlatformResource;

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

    public AccountHolder retrieve(String accountHolderId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/accountHolders/%s", accountHolderId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return AccountHolder.fromJson(jsonResult);
    }

    public AccountHolder update(String accountHolderId, AccountHolder request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/accountHolders/%s", accountHolderId));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.PATCH);
        return AccountHolder.fromJson(jsonResult);
    }

    public PaginatedBalanceAccountsResponse list(String accountHolderId, Map<String, String> queryString) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/accountHolders/%s/balanceAccounts", accountHolderId));
        String jsonResult = resource.request(null, null, ApiConstants.HttpMethod.GET, null, queryString);
        return PaginatedBalanceAccountsResponse.fromJson(jsonResult);
    }
}
