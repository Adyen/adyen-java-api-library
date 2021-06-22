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

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class TestOutput {
    @SerializedName("merchantId")
    private String merchantId = null;

    @SerializedName("output")
    private String output = null;

    @SerializedName("requestSent")
    private String requestSent = null;

    @SerializedName("responseCode")
    private String responseCode = null;

    @SerializedName("responseTime")
    private String responseTime = null;

    @SerializedName("status")
    private String status = null;

    public TestOutput merchantId(String merchantId) {
        this.merchantId = merchantId;
        return this;
    }

    /**
     * Unique identifier for the merchant account that the notification is about.
     * @return merchantId
     **/
    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

    public TestOutput output(String output) {
        this.output = output;
        return this;
    }

    /**
     * The response your server returned for the test webhook.  Your server must respond with **[accepted]** for the test webhook to be successful (&#x60;data.status&#x60;: **success**). Find out more about [accepting notifications](https://docs.adyen.com/development-resources/webhooks#accept-notifications)  You can use the value of this field together with the [&#x60;responseCode&#x60;](https://docs.adyen.com/api-explorer/#/ManagementService/v1/post/merchants/{merchantId}/webhooks/{id}/test__resParam_data-responseCode) value to troubleshoot unsuccessful test webhooks.
     * @return output
     **/
    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }

    public TestOutput requestSent(String requestSent) {
        this.requestSent = requestSent;
        return this;
    }

    /**
     * The [body of the notification webhook](https://docs.adyen.com/development-resources/webhooks/understand-notifications#notification-structure) that was sent to your server.
     * @return requestSent
     **/
    public String getRequestSent() {
        return requestSent;
    }

    public void setRequestSent(String requestSent) {
        this.requestSent = requestSent;
    }

    public TestOutput responseCode(String responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    /**
     * The HTTP response code for your server&#x27;s response to the test webhook.  You can use the value of this field together with the the [&#x60;output&#x60;](https://docs.adyen.com/api-explorer/#/ManagementService/v1/post/merchants/{merchantId}/webhooks/{id}/test__resParam_data-output) field value to troubleshoot failed test webhooks.
     * @return responseCode
     **/
    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public TestOutput responseTime(String responseTime) {
        this.responseTime = responseTime;
        return this;
    }

    /**
     * The time between sending the test webhook and receiving the response from your server. You can use it as an indication of how long your server takes to process a webhook notification. Measured in milliseconds, for example **304 ms**.
     * @return responseTime
     **/
    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public TestOutput status(String status) {
        this.status = status;
        return this;
    }

    /**
     * The status of the test request. Possible values are: * **success**, if &#x60;data.output&#x60;: **[accepted]** and &#x60;data.responseCode&#x60;: **200**. * **failed**, in all other cases.  You can use the value of the [&#x60;output&#x60;](https://docs.adyen.com/api-explorer/#/ManagementService/v1/post/merchants/{merchantId}/webhooks/{id}/test__resParam_data-output) field together with the [&#x60;responseCode&#x60;](https://docs.adyen.com/api-explorer/#/ManagementService/v1/post/merchants/{merchantId}/webhooks/{id}/test__resParam_data-responseCode) value to troubleshoot failed test webhooks.
     * @return status
     **/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TestOutput testOutput = (TestOutput) o;
        return Objects.equals(this.merchantId, testOutput.merchantId) &&
                Objects.equals(this.output, testOutput.output) &&
                Objects.equals(this.requestSent, testOutput.requestSent) &&
                Objects.equals(this.responseCode, testOutput.responseCode) &&
                Objects.equals(this.responseTime, testOutput.responseTime) &&
                Objects.equals(this.status, testOutput.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, output, requestSent, responseCode, responseTime, status);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TestOutput {\n");

        sb.append("    merchantId: ").append(toIndentedString(merchantId)).append("\n");
        sb.append("    output: ").append(toIndentedString(output)).append("\n");
        sb.append("    requestSent: ").append(toIndentedString(requestSent)).append("\n");
        sb.append("    responseCode: ").append(toIndentedString(responseCode)).append("\n");
        sb.append("    responseTime: ").append(toIndentedString(responseTime)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
