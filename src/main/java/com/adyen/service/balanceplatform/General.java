package com.adyen.service.balanceplatform;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.balanceplatform.BalancePlatform;
import com.adyen.model.balanceplatform.JSON;
import com.adyen.model.balanceplatform.PaginatedAccountHoldersResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.balanceplatform.BalancePlatformResource;

import java.io.IOException;
import java.util.Map;

public class General extends Service {

    public General(Client client) {
        super(client);
        new JSON();
    }

    public BalancePlatform retrieve(String platformId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balancePlatforms/%s", platformId));
        String jsonResult = resource.request(null, null, ApiConstants.HttpMethod.GET, null);
        return BalancePlatform.fromJson(jsonResult);
    }

    public PaginatedAccountHoldersResponse listAccountHolders(String platformId, Map<String, String> queryString) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/balancePlatforms/%s/accountHolders", platformId));
        String jsonResult = resource.request(null, null, ApiConstants.HttpMethod.GET, null, queryString);
        return PaginatedAccountHoldersResponse.fromJson(jsonResult);
    }
}
