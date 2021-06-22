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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.management;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class TestWebhookRequest {
    @SerializedName("notification")
    private CustomNotification notification = null;

    @SerializedName("types")
    private List<String> types = new ArrayList<>();

    public TestWebhookRequest notification(CustomNotification notification) {
        this.notification = notification;
        return this;
    }

    /**
     * Get notification
     * @return notification
     **/
    public CustomNotification getNotification() {
        return notification;
    }

    public void setNotification(CustomNotification notification) {
        this.notification = notification;
    }

    public TestWebhookRequest types(List<String> types) {
        this.types = types;
        return this;
    }

    public TestWebhookRequest addTypesItem(String typesItem) {
        this.types.add(typesItem);
        return this;
    }

    /**
     * List of the types of test notification webhooks to be sent.  Currently supported values are: * **authorisation** * **chargeback_reversed** * **order_closed** * **order_opened** * **paidout_reversed** * **payout_thirdparty** * **refunded_reversed** * **refund_with_data** * **report_available**  These values correspond to the &#x60;eventCode&#x60; values from our [standard webhook notifications](/development-resources/webhooks/understand-notifications#event-codes).
     * @return types
     **/
    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestWebhookRequest testWebhookRequest = (TestWebhookRequest) o;
        return Objects.equals(this.notification, testWebhookRequest.notification) &&
                Objects.equals(this.types, testWebhookRequest.types);
    }

    @Override
    public int hashCode() {
        return Objects.hash(notification, types);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TestWebhookRequest {\n");

        sb.append("    notification: ").append(toIndentedString(notification)).append("\n");
        sb.append("    types: ").append(toIndentedString(types)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
