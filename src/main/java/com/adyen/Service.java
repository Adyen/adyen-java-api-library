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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.enums.Environment;

public class Service {
    private boolean isApiKeyRequired = false;
    private Client client;

    protected Service(Client client) {
        this.client = client;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public boolean isApiKeyRequired() {
        return isApiKeyRequired;
    }

    public void setApiKeyRequired(boolean apiKeyRequired) {
        isApiKeyRequired = apiKeyRequired;
    }

    protected String createBaseURL(String url) {
        Config config = this.getClient().getConfig();
        if (config.getEnvironment() != Environment.LIVE) {
            return url;
        }

        if (url.contains("pal-")) {
            if (config.getLiveEndpointUrlPrefix() == null) {
                throw new IllegalArgumentException("please provide a live url prefix in the client");
            }
            url = url.replaceFirst("https://pal-test.adyen.com/pal/servlet/",
                    "https://" + config.getLiveEndpointUrlPrefix() + "-pal-live.adyenpayments.com/pal/servlet/");
        }

        if (url.contains("checkout-")) {
            if (config.getLiveEndpointUrlPrefix() == null) {
                throw new IllegalArgumentException("please provide a live url prefix in the client");
            }
            url = url.replaceFirst("https://checkout-test.adyen.com/",
                    "https://" + config.getLiveEndpointUrlPrefix() + "-checkout-live.adyenpayments.com/checkout/");
        }
        return url.replaceFirst("-test", "-live");
    }
}
