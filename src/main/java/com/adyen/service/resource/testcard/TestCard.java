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
package com.adyen.service.resource.testcard;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.Resource;

public class TestCard extends Resource {

    public TestCard(Service service) {
        super(service,service.getClient().getConfig().getEndpoint() + Client.TEST_CARD_API_PAL_SUFFIX + Client.TEST_CARD_API_VERSION + "/createTestCardRanges", null);
    }
}
