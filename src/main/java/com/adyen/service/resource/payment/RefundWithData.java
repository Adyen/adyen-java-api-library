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
package com.adyen.service.resource.payment;

import java.util.Arrays;
import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

public class RefundWithData extends Resource {
    public RefundWithData(Service service) {
        super(service,
              service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payment/" + Client.API_VERSION + "/refundWithData",
              Arrays.asList("merchantAccount", "amount.value", "amount.currency", "reference"));
    }
}
