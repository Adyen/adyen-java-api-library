package com.adyen.service.balanceplatform;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.balanceplatform.JSON;
import com.adyen.model.balanceplatform.BankAccountIdentificationValidationRequest;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.balanceplatform.BalancePlatformResource;

import java.io.IOException;

public class BankAccountValidation extends Service {

    public BankAccountValidation(Client client) {
        super(client);
        new JSON();
    }

    public void validateBankAccountIdentification(BankAccountIdentificationValidationRequest bankAccountIdentificationValidationRequest) throws IOException, ApiException {
        String jsonRequest = bankAccountIdentificationValidationRequest.toJson();
        BalancePlatformResource resource = new BalancePlatformResource(this, "/validateBankAccountIdentification");
        resource.request(jsonRequest);
    }
}
