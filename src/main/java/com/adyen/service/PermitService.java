package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.recurring.CreatePermitRequest;
import com.adyen.model.recurring.CreatePermitResult;
import com.adyen.model.recurring.DisablePermitRequest;
import com.adyen.model.recurring.DisablePermitResult;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.recurring.CreatePermit;
import com.adyen.service.resource.recurring.DisablePermit;

import java.io.IOException;

public class PermitService extends Service {
    private final CreatePermit createPermit;
    private final DisablePermit disablePermit;

    public PermitService(Client client) {
        super(client);

        createPermit = new CreatePermit(this);
        disablePermit = new DisablePermit(this);
    }

    /**
     * Issues a createPermit API call
     *
     * @param request CreatePermitRequest
     * @return CreatePermitResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public CreatePermitResult createPermit(CreatePermitRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        String jsonResult = createPermit.request(jsonRequest);
        return CreatePermitResult.fromJson(jsonResult);
    }

    /**
     * Issues a disablePermit API call
     *
     * @param request DisablePermitRequest
     * @return DisablePermitResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public DisablePermitResult disablePermit(DisablePermitRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        String jsonResult = disablePermit.request(jsonRequest);
        return DisablePermitResult.fromJson(jsonResult);
    }
}

