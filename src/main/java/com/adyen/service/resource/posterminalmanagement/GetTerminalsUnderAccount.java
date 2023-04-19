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

package com.adyen.service.resource.posterminalmanagement;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.service.resource.Resource;

import java.util.Arrays;

public class GetTerminalsUnderAccount extends Resource {

    public GetTerminalsUnderAccount(Service service) {
        super(service, service.getClient().getConfig().getPosTerminalManagementApiEndpoint() + "/" + Client.POS_TERMINAL_MANAGEMENT_VERSION + "/getTerminalsUnderAccount", Arrays.asList("companyAccount"));
    }
}
