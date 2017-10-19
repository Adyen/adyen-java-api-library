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
package com.adyen;

import com.adyen.model.marketpay.notification.*;
import com.adyen.service.Notification;
import org.junit.Test;

public class MarketPayNotificationTest extends BaseTest {

    @Test
    public void TestCreateNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/createNotificationConfiguration.json");
        Notification notification = new Notification(client);

        CreateNotificationConfigurationRequest createNotificationConfigurationRequest = new CreateNotificationConfigurationRequest();
        CreateNotificationConfigurationResponse getNotificationConfigurationResponse = notification.createNotificationConfiguration(createNotificationConfigurationRequest);

        System.out.println(getNotificationConfigurationResponse);
    }

    @Test
    public void TestUpdateNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/updateNotificationConfiguration.json");
        Notification notification = new Notification(client);

        UpdateNotificationConfigurationRequest updateNotificationConfigurationRequest = new UpdateNotificationConfigurationRequest();
        UpdateNotificationConfigurationResponse getNotificationConfigurationResponse = notification.updateNotificationConfiguration(updateNotificationConfigurationRequest);

        System.out.println(getNotificationConfigurationResponse);
    }

    @Test
    public void TestGetNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/getNotificationConfiguration.json");
        Notification notification = new Notification(client);

        GetNotificationConfigurationRequest getNotificationConfigurationRequest = new GetNotificationConfigurationRequest();
        GetNotificationConfigurationResponse getNotificationConfigurationResponse = notification.getNotificationConfiguration(getNotificationConfigurationRequest);

        System.out.println(getNotificationConfigurationResponse);
    }

    @Test
    public void TestDeleteNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/deleteNotificationConfiguration.json");
        Notification notification = new Notification(client);

        DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest = new DeleteNotificationConfigurationRequest();
        DeleteNotificationConfigurationResponse getNotificationConfigurationResponse = notification.deleteNotificationConfiguration(deleteNotificationConfigurationRequest);

        System.out.println(getNotificationConfigurationResponse);
    }

    @Test
    public void TestGetNotificationConfigurationList() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/getNotificationConfigurationList.json");
        Notification notification = new Notification(client);
        GetNotificationConfigurationListResponse getNotificationConfigurationListResponse = notification.getNotificationConfigurationList();
        System.out.println(getNotificationConfigurationListResponse);
    }

    @Test
    public void TestNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/testNotificationConfiguration.json");
        Notification notification = new Notification(client);

        TestNotificationConfigurationRequest testNotificationConfigurationRequest = new TestNotificationConfigurationRequest();
        TestNotificationConfigurationResponse testNotificationConfigurationResponse = notification.testNotificationConfiguration(testNotificationConfigurationRequest);

        System.out.println(testNotificationConfigurationResponse);
    }
}
