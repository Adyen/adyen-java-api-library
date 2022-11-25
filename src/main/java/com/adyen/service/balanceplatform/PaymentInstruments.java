package com.adyen.service.balanceplatform;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.balanceplatform.PaymentInstrument;
import com.adyen.model.balanceplatform.PaymentInstrumentInfo;
import com.adyen.model.balanceplatform.PaymentInstrumentUpdateRequest;
import com.adyen.model.balanceplatform.JSON;
import com.adyen.model.balanceplatform.TransactionRulesResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.balanceplatform.BalancePlatformResource;

import java.io.IOException;

public class PaymentInstruments extends Service {
    public PaymentInstruments(Client client) {
        super(client);
        new JSON();
    }

    public PaymentInstrument create(PaymentInstrumentInfo request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, "/paymentInstruments");
        String jsonResult = resource.request(jsonRequest);
        return PaymentInstrument.fromJson(jsonResult);
    }

    public PaymentInstrument retrieve(String paymentInstrumentId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/paymentInstruments/%s", paymentInstrumentId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return PaymentInstrument.fromJson(jsonResult);
    }

    public PaymentInstrument update(String paymentInstrumentId, PaymentInstrumentUpdateRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/paymentInstruments/%s", paymentInstrumentId));
        String jsonResult = resource.request(jsonRequest, ApiConstants.HttpMethod.PATCH);
        return PaymentInstrument.fromJson(jsonResult);
    }

    public TransactionRulesResponse listTransactionRules(String paymentInstrumentId) throws IOException, ApiException {
        BalancePlatformResource resource = new BalancePlatformResource(this, String.format("/paymentInstruments/%s/transactionRules", paymentInstrumentId));
        String jsonResult = resource.request(null, ApiConstants.HttpMethod.GET);
        return TransactionRulesResponse.fromJson(jsonResult);
    }
}
