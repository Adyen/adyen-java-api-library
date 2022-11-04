/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.recurring.DisableRequest;
import com.adyen.model.recurring.DisableResult;
import com.adyen.model.recurring.JSON;
import com.adyen.model.recurring.NotifyShopperRequest;
import com.adyen.model.recurring.NotifyShopperResult;
import com.adyen.model.recurring.RecurringDetailsRequest;
import com.adyen.model.recurring.RecurringDetailsResult;
import com.adyen.model.recurring.ScheduleAccountUpdaterRequest;
import com.adyen.model.recurring.ScheduleAccountUpdaterResult;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.recurring.Disable;
import com.adyen.service.resource.recurring.ListRecurringDetails;
import com.adyen.service.resource.recurring.NotifyShopper;
import com.adyen.service.resource.recurring.ScheduleAccountUpdater;
import java.io.IOException;

public class Recurring extends Service {
    private final ListRecurringDetails listRecurringDetails;
    private final Disable disable;
    private final ScheduleAccountUpdater scheduleAccountUpdater;
    private final NotifyShopper notifyShopper;

    public Recurring(Client client) {
        super(client);

        listRecurringDetails = new ListRecurringDetails(this);
        disable = new Disable(this);
        scheduleAccountUpdater = new ScheduleAccountUpdater(this);
        notifyShopper = new NotifyShopper(this);
        new JSON();
    }

    /**
     * Issues a listRecurringDetails API call
     *
     * @param request RecurringDetailsResult
     * @return recurring details result
     * @throws IOException  IOException
     * @throws ApiException ApiException
     */
    public RecurringDetailsResult listRecurringDetails(RecurringDetailsRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        String jsonResult = listRecurringDetails.request(jsonRequest);
        return RecurringDetailsResult.fromJson(jsonResult);
    }

    /**
     * Issues a disable recurring contract API call
     *
     * @param request DisableRequest
     * @return DisableResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public DisableResult disable(DisableRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        String jsonResult = disable.request(jsonRequest);
        return DisableResult.fromJson(jsonResult);
    }

    /**
     * Issues a scheduleAccountUpdate API call
     *
     * @param request ScheduleAccountUpdaterRequest
     * @return ScheduleAccountUpdaterResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public ScheduleAccountUpdaterResult scheduleAccountUpdater(ScheduleAccountUpdaterRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        String jsonResult = scheduleAccountUpdater.request(jsonRequest);
        return ScheduleAccountUpdaterResult.fromJson(jsonResult);
    }

    /**
     * Issues a notifyShopper API call
     *
     * @param request ScheduleAccountUpdaterRequest
     * @return ScheduleAccountUpdaterResult
     * @throws IOException IOException
     * @throws ApiException ApiException
     */
    public NotifyShopperResult notifyShopper(NotifyShopperRequest request) throws IOException, ApiException {
        String jsonRequest = request.toJson();
        String jsonResult = notifyShopper.request(jsonRequest);
        return NotifyShopperResult.fromJson(jsonResult);
    }

}
