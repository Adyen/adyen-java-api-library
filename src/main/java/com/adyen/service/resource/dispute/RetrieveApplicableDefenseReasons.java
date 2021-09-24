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

package com.adyen.service.resource.dispute;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

import java.util.Arrays;

public class RetrieveApplicableDefenseReasons extends Resource {

    public RetrieveApplicableDefenseReasons(Service service) {
        super(service, service.getClient().getConfig().getCheckoutEndpoint() + "/" + Client.DISPUTE_API_VERSION + "/retrieveApplicableDefenseReasons",
                Arrays.asList("disputePspReference", "merchantAccountCode"));
    }
}
