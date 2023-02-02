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
package com.adyen.service.resource.storedvalue;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.resource.Resource;

import java.util.Arrays;


public class ChangeStatus extends Resource {

    public ChangeStatus(Service service) {
        super(service,
                service.getClient().getConfig().getEndpoint() + Client.STORED_VALUE_PAL_SUFFIX + Client.STORED_VALUE_API_VERSION + "/changeStatus",
                Arrays.asList("merchantAccount", "reference", "paymentMethod", "status"));
    }

}
