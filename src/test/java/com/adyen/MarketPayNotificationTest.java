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

import org.junit.Assert;
import org.junit.Test;
import com.adyen.model.marketpay.notification.CreateNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.CreateNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.DeleteNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.DeleteNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.GetNotificationConfigurationListResponse;
import com.adyen.model.marketpay.notification.GetNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.GetNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.NotificationEventConfiguration;
import com.adyen.model.marketpay.notification.TestNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.TestNotificationConfigurationResponse;
import com.adyen.model.marketpay.notification.UpdateNotificationConfigurationRequest;
import com.adyen.model.marketpay.notification.UpdateNotificationConfigurationResponse;
import com.adyen.service.Notification;
import static com.adyen.model.marketpay.notification.NotificationEventConfiguration.EventTypeEnum.ACCOUNT_HOLDER_STATUS_CHANGE;
import static com.adyen.model.marketpay.notification.NotificationEventConfiguration.IncludeModeEnum.INCLUDE;
import static org.junit.Assert.assertEquals;

public class MarketPayNotificationTest extends BaseTest {

    @Test
    public void TestCreateNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/create-notification-configuration-success.json");
        Notification notification = new Notification(client);

        CreateNotificationConfigurationRequest createNotificationConfigurationRequest = new CreateNotificationConfigurationRequest();
        CreateNotificationConfigurationResponse getNotificationConfigurationResponse = notification.createNotificationConfiguration(createNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);
    }

    @Test
    public void TestGetNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/get-notification-configuration-success.json");
        Notification notification = new Notification(client);

        GetNotificationConfigurationRequest getNotificationConfigurationRequest = new GetNotificationConfigurationRequest();
        GetNotificationConfigurationResponse getNotificationConfigurationResponse = notification.getNotificationConfiguration(getNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);
        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getIncludeMode(), INCLUDE);
    }

    @Test
    public void TestGetNotificationConfigurationList() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/get-notification-configuration-list-success.json");
        Notification notification = new Notification(client);
        GetNotificationConfigurationListResponse getNotificationConfigurationListResponse = notification.getNotificationConfigurationList();

        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(0).getNotificationId(), new Long(157));
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(0).getEventConfigs().get(0).getIncludeMode(), INCLUDE);
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(0).getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);


        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(1).getNotificationId(), new Long(161));
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(1).getEventConfigs().get(0).getIncludeMode(), INCLUDE);
        Assert.assertEquals(getNotificationConfigurationListResponse.getConfigurations().get(1).getEventConfigs().get(0).getEventType(), ACCOUNT_HOLDER_STATUS_CHANGE);
    }

    @Test
    public void TestUpdateNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/update-notification-configuration-success.json");
        Notification notification = new Notification(client);

        UpdateNotificationConfigurationRequest updateNotificationConfigurationRequest = new UpdateNotificationConfigurationRequest();
        UpdateNotificationConfigurationResponse getNotificationConfigurationResponse = notification.updateNotificationConfiguration(updateNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getEventType(), NotificationEventConfiguration.EventTypeEnum.ACCOUNT_CREATED);
        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(0).getIncludeMode(), NotificationEventConfiguration.IncludeModeEnum.INCLUDE);


        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(1).getEventType(),
                            NotificationEventConfiguration.EventTypeEnum.ACCOUNT_HOLDER_CREATED);
        Assert.assertEquals(getNotificationConfigurationResponse.getConfigurationDetails().getEventConfigs().get(1).getIncludeMode(), NotificationEventConfiguration.IncludeModeEnum.EXCLUDE);
    }

    @Test
    public void TestDeleteNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/delete-notification-configurations-success.json");
        Notification notification = new Notification(client);

        DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest = new DeleteNotificationConfigurationRequest();
        DeleteNotificationConfigurationResponse getNotificationConfigurationResponse = notification.deleteNotificationConfiguration(deleteNotificationConfigurationRequest);

        Assert.assertEquals(getNotificationConfigurationResponse.getPspReference(), "8515078085249090");
        Assert.assertEquals(getNotificationConfigurationResponse.getSubmittedAsync(), false);
    }

    @Test
    public void TestNotificationConfiguration() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/notification/test-notification-configuration-success.json");
        Notification notification = new Notification(client);

        TestNotificationConfigurationRequest testNotificationConfigurationRequest = new TestNotificationConfigurationRequest();
        TestNotificationConfigurationResponse testNotificationConfigurationResponse = notification.testNotificationConfiguration(testNotificationConfigurationRequest);


        assertEquals("Number", testNotificationConfigurationResponse.getExchangeMessages().get(0).getMessageCode());
        assertEquals("1", testNotificationConfigurationResponse.getExchangeMessages().get(0).getMessageDescription());

        assertEquals("Title", testNotificationConfigurationResponse.getExchangeMessages().get(1).getMessageCode());
        assertEquals("Test 1: Test_ACCOUNT_CREATED", testNotificationConfigurationResponse.getExchangeMessages().get(1).getMessageDescription());
    }
}
