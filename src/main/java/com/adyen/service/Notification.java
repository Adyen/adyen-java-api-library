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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.model.marketpay.notification.CreateNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.CreateNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.DeleteNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.DeleteNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.GetNotificationConfigurationListResponse;
import com.adyen.model.marketpay.notification.GetNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.GetNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.TestNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.TestNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.UpdateNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.UpdateNotificationConfigurationResponse;
import com.adyen.service.resource.notification.CreateNotificationConfiguration;
import com.adyen.service.resource.notification.DeleteNotificationConfigurations;
import com.adyen.service.resource.notification.GetNotificationConfiguration;
import com.adyen.service.resource.notification.GetNotificationConfigurationList;
import com.adyen.service.resource.notification.TestNotificationConfiguration;
import com.adyen.service.resource.notification.UpdateNotificationConfiguration;
import com.google.gson.reflect.TypeToken;

public class Notification extends Service {

    private CreateNotificationConfiguration createNotificationConfiguration;
    private UpdateNotificationConfiguration updateNotificationConfiguration;
    private GetNotificationConfiguration getNotificationConfiguration;
    private DeleteNotificationConfigurations deleteNotificationConfiguration;
    private TestNotificationConfiguration testNotificationConfiguration;
    private GetNotificationConfigurationList getNotificationConfigurationList;


    public Notification(Client client) {
        super(client);
        this.createNotificationConfiguration = new CreateNotificationConfiguration(this);
        this.updateNotificationConfiguration = new UpdateNotificationConfiguration(this);
        this.getNotificationConfiguration = new GetNotificationConfiguration(this);
        this.deleteNotificationConfiguration = new DeleteNotificationConfigurations(this);
        this.testNotificationConfiguration = new TestNotificationConfiguration(this);
        this.getNotificationConfigurationList = new GetNotificationConfigurationList(this);
    }

    public CreateNotificationConfigurationResponse createNotificationConfiguration(CreateNotificationConfigurationRequest createNotificationConfigurationRequest) throws Exception {
        String jsonRequest = GSON.toJson(createNotificationConfigurationRequest);
        String jsonResult = createNotificationConfiguration.request(jsonRequest);
        CreateNotificationConfigurationResponse createNotificationConfigurationResponse = GSON.fromJson(jsonResult, new TypeToken<CreateNotificationConfigurationResponse>() {
        }.getType());

        return createNotificationConfigurationResponse;
    }

    public UpdateNotificationConfigurationResponse updateNotificationConfiguration(UpdateNotificationConfigurationRequest updateNotificationConfigurationRequest) throws Exception {
        String jsonRequest = GSON.toJson(updateNotificationConfigurationRequest);
        String jsonResult = updateNotificationConfiguration.request(jsonRequest);
        UpdateNotificationConfigurationResponse updateNotificationConfigurationResponse = GSON.fromJson(jsonResult, new TypeToken<UpdateNotificationConfigurationResponse>() {
        }.getType());

        return updateNotificationConfigurationResponse;
    }

    public GetNotificationConfigurationResponse getNotificationConfiguration(GetNotificationConfigurationRequest getNotificationConfigurationRequest) throws Exception {
        String jsonRequest = GSON.toJson(getNotificationConfigurationRequest);
        String jsonResult = getNotificationConfiguration.request(jsonRequest);
        GetNotificationConfigurationResponse getNotificationConfigurationResponse = GSON.fromJson(jsonResult, new TypeToken<GetNotificationConfigurationResponse>() {
        }.getType());

        return getNotificationConfigurationResponse;
    }

    public DeleteNotificationConfigurationResponse deleteNotificationConfiguration(DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest) throws Exception {
        String jsonRequest = GSON.toJson(deleteNotificationConfigurationRequest);
        String jsonResult = deleteNotificationConfiguration.request(jsonRequest);
        DeleteNotificationConfigurationResponse deleteNotificationConfigurationResponse = GSON.fromJson(jsonResult, new TypeToken<DeleteNotificationConfigurationResponse>() {
        }.getType());

        return deleteNotificationConfigurationResponse;
    }

    public TestNotificationConfigurationResponse testNotificationConfiguration(TestNotificationConfigurationRequest testNotificationConfigurationRequest) throws Exception {
        String jsonRequest = GSON.toJson(testNotificationConfigurationRequest);
        String jsonResult = testNotificationConfiguration.request(jsonRequest);

        TestNotificationConfigurationResponse testNotificationConfigurationResponse = GSON.fromJson(jsonResult, new TypeToken<TestNotificationConfigurationResponse>() {
        }.getType());

        return testNotificationConfigurationResponse;
    }

    public GetNotificationConfigurationListResponse getNotificationConfigurationList() throws Exception {
        String jsonResult = getNotificationConfigurationList.request("{}");
        GetNotificationConfigurationListResponse getNotificationConfigurationListResponse = GSON.fromJson(jsonResult, new TypeToken<GetNotificationConfigurationListResponse>() {
        }.getType());

        return getNotificationConfigurationListResponse;
    }


}