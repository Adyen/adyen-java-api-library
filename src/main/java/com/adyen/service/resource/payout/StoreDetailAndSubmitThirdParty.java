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
package com.adyen.service.resource.payout;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.resource.Resource;

public class StoreDetailAndSubmitThirdParty extends Resource {
    public StoreDetailAndSubmitThirdParty(Service service) {
        super(service, service.getClient().getConfig().getEndpoint() + "/pal/servlet/Payout/" + Client.PAYOUT_API_VERSION + "/storeDetailAndSubmitThirdParty", null);
    }
}