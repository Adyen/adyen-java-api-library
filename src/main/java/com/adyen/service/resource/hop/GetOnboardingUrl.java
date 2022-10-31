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
package com.adyen.service.resource.hop;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.resource.Resource;

import java.util.Arrays;

public class GetOnboardingUrl extends Resource {
    public GetOnboardingUrl(Service service) {
        super(service, service.getClient().getConfig().getMarketPayEndpoint() + "/Hop/" + Client.MARKETPAY_HOP_API_VERSION + "/getOnboardingUrl", Arrays.asList("accountHolderCode"));
    }
}
