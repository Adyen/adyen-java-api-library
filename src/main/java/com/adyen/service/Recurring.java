package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.recurring.RecurringDetailsRequest;
import com.adyen.model.recurring.RecurringDetailsResult;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.recurring.ListRecurringDetails;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;

public class Recurring extends Service {
    private ListRecurringDetails listRecurringDetails;

    public Recurring(Client client) {
        super(client);

        listRecurringDetails = new ListRecurringDetails(this);
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
        Gson gson = new Gson();

        String jsonRequest = gson.toJson(request);

        String jsonResult = listRecurringDetails.request(jsonRequest);

        RecurringDetailsResult result = gson.fromJson(jsonResult, new TypeToken<RecurringDetailsResult>() {
        }.getType());
        return result;
    }
}
