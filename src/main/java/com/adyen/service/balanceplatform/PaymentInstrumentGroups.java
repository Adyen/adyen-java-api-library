package com.adyen.service.balanceplatform;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.balanceplatform.JSON;
import com.adyen.model.balanceplatform.PaymentInstrumentGroup;
import com.adyen.model.balanceplatform.PaymentInstrumentGroupInfo;
import com.adyen.model.balanceplatform.TransactionRulesResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.balanceplatform.BalancePlatformResource;

import java.io.IOException;

public class PaymentInstrumentGroups extends Service {
    public PaymentInstrumentGroups(Client client) {
        super(client);
        new JSON();
    }

    public PaymentInstrumentGroup create(PaymentInstrumentGroupInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, "/paymentInstrumentsGroups");
        String jsonResult = resource.request(jsonRequest);
        return PaymentInstrumentGroup.fromJson(jsonResult);
    }

    public PaymentInstrumentGroup retrieve(String instrumentGroupId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/paymentInstrumentsGroups/%s", instrumentGroupId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return PaymentInstrumentGroup.fromJson(jsonResult);
    }

    public TransactionRulesResponse listTransactionRules(String instrumentGroupId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/paymentInstrumentsGroups/%s/transactionRules", instrumentGroupId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return TransactionRulesResponse.fromJson(jsonResult);
    }
}
