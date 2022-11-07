package com.adyen.service.balanceplatform;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.balanceplatform.JSON;
import com.adyen.model.balanceplatform.TransactionRule;
import com.adyen.model.balanceplatform.TransactionRuleInfo;
import com.adyen.model.balanceplatform.TransactionRuleResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.balanceplatform.BalancePlatformResource;

import java.io.IOException;

public class TransactionRules extends Service {

    public TransactionRules(Client client) {
        super(client);
        new JSON();
    }

    public TransactionRule create(TransactionRuleInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, "/transactionRules");
        String jsonResult = resource.request(jsonRequest);
        return TransactionRule.fromJson(jsonResult);
    }

    public TransactionRuleResponse retrieve(String transactionRuleId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/transactionRules/%s", transactionRuleId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return TransactionRuleResponse.fromJson(jsonResult);
    }

    public TransactionRule update(String transactionRuleId, TransactionRuleInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/transactionRules/%s", transactionRuleId));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.PATCH);
        return TransactionRule.fromJson(jsonResult);
    }

    public void delete(String transactionRuleId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/transactionRules/%s", transactionRuleId));
        resource.request(null, ApiConstants.HttpMethod.DELETE);
    }
}
