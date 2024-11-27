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
        Environment environment = config.getEnvironment();

        // Handle non-live environment
        if (environment != Environment.LIVE) {
            return replaceLiveWithTest(url);
        }

        // Process PAL URLs
        if (isPalUrl(url)) {
            ensureLiveEndpointPrefixExists(config);
            url = replacePalTestWithLive(url, config.getLiveEndpointUrlPrefix());
        }

        // Process Checkout URLs
        if (isCheckoutUrl(url)) {
            ensureLiveEndpointPrefixExists(config);
            url = processCheckoutUrl(url, config.getLiveEndpointUrlPrefix());
        }

        // Final replacement for live environment
        return replaceTestWithLive(url);
    }

    private String replaceLiveWithTest(String url) {
        return url.replaceFirst("-live", "-test");
    }

    private String replaceTestWithLive(String url) {
        return url.replaceFirst("-test", "-live");
    }

    private boolean isPalUrl(String url) {
        return url.contains("pal-");
    }

    private boolean isCheckoutUrl(String url) {
        return url.contains("checkout-");
    }

    private void ensureLiveEndpointPrefixExists(Config config) {
        if (config.getLiveEndpointUrlPrefix() == null) {
            throw new IllegalArgumentException("Please provide a live URL prefix in the client");
        }
    }

    private String replacePalTestWithLive(String url, String liveEndpointUrlPrefix) {
        return url.replaceFirst(
                "https://pal-test.adyen.com/pal/servlet/",
                "https://" + liveEndpointUrlPrefix + "-pal-live.adyenpayments.com/pal/servlet/"
        );
    }

    private String processCheckoutUrl(String url, String liveEndpointUrlPrefix) {
        if (url.contains("/possdk/v68")) {
            // Temporary until they fix possdk
            return url.replaceFirst(
                    "https://checkout-test.adyen.com/",
                    "https://" + liveEndpointUrlPrefix + "-checkout-live.adyenpayments.com/"
            );
        }
        return url.replaceFirst(
                "https://checkout-test.adyen.com/",
                "https://" + liveEndpointUrlPrefix + "-checkout-live.adyenpayments.com/checkout/"
        );
    }

}
