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

package com.adyen.model.marketpay.notification;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DeleteNotificationConfigurationRequest
 */
public class DeleteNotificationConfigurationRequest {
    @SerializedName("notificationIds")
    private List<Long> notificationIds = new ArrayList<>();

    public DeleteNotificationConfigurationRequest notificationIds(List<Long> notificationIds) {
        this.notificationIds = notificationIds;
        return this;
    }

    public DeleteNotificationConfigurationRequest addNotificationIdsItem(Long notificationIdsItem) {
        this.notificationIds.add(notificationIdsItem);
        return this;
    }

    /**
     * IDs of the notification configurations to be deleted
     *
     * @return notificationIds
     **/
    public List<Long> getNotificationIds() {
        return notificationIds;
    }

    public void setNotificationIds(List<Long> notificationIds) {
        this.notificationIds = notificationIds;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest = (DeleteNotificationConfigurationRequest) o;
        return Objects.equals(this.notificationIds, deleteNotificationConfigurationRequest.notificationIds);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notificationIds);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeleteNotificationConfigurationRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    notificationIds: ").append(Util.toIndentedString(notificationIds)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}

