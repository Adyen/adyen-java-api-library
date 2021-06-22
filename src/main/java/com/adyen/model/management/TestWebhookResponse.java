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

public class TestWebhookResponse {
    @SerializedName("data")
    private List<TestOutput> data = null;

    public TestWebhookResponse data(List<TestOutput> data) {
        this.data = data;
        return this;
    }

    public TestWebhookResponse addDataItem(TestOutput dataItem) {
        if (this.data == null) {
            this.data = new ArrayList<TestOutput>();
        }
        this.data.add(dataItem);
        return this;
    }

    /**
     * List with test results. Each test webhook we send has a list element with the result.
     * @return data
     **/
    public List<TestOutput> getData() {
        return data;
    }

    public void setData(List<TestOutput> data) {
        this.data = data;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestWebhookResponse testWebhookResponse = (TestWebhookResponse) o;
        return Objects.equals(this.data, testWebhookResponse.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TestWebhookResponse {\n");

        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
