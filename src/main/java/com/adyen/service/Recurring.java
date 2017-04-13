package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.recurring.DisableRequest;
import com.adyen.model.recurring.DisableResult;
import com.adyen.model.recurring.RecurringDetailsRequest;
import com.adyen.model.recurring.RecurringDetailsResult;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.recurring.Disable;
import com.adyen.service.resource.recurring.ListRecurringDetails;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Recurring extends Service {
    private ListRecurringDetails listRecurringDetails;
    private Disable disable;

    public Recurring(Client client) {
        super(client);

        listRecurringDetails = new ListRecurringDetails(this);
        disable = new Disable(this);
    }

    /**
     * Issues a listRecurringDetails API call
     *
     * @param request
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public RecurringDetailsResult listRecurringDetails(RecurringDetailsRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = listRecurringDetails.request(jsonRequest);

        RecurringDetailsResult result = GSON.fromJson(jsonResult, new TypeToken<RecurringDetailsResult>() {
        }.getType());
        return result;
    }

    /**
     * Issues a disable recurring contract API call
     * @param request
     * @return
     * @throws IOException
     * @throws ApiException
     */
    public DisableResult disable(DisableRequest request) throws IOException, ApiException {
        String jsonRequest = GSON.toJson(request);

        String jsonResult = disable.request(jsonRequest);

        DisableResult result = GSON.fromJson(jsonResult, new TypeToken<DisableResult>() {
        }.getType());
        return result;
    }
}
