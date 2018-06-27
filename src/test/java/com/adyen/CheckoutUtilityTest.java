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

import com.adyen.model.checkoututility.OriginKeysRequest;
import com.adyen.model.checkoututility.OriginKeysResponse;
import com.adyen.service.CheckoutUtility;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Tests for
 * /originKeys
 */
public class CheckoutUtilityTest extends BaseTest {
    /**
     * Test success flow for
     * POST /originKeys
     */
    @Test
    public void TestOriginKeysSuccessMocked() throws Exception {
        Client client = createMockClientFromFile("mocks/checkoututility/originkeys-success.json");
        CheckoutUtility checkoutUtility = new CheckoutUtility(client);
        OriginKeysRequest originKeysRequest = new OriginKeysRequest();
        originKeysRequest.setOriginDomains(new ArrayList<String>(Arrays.asList("www.test.com", "https://www.your-domain2.com")));
        OriginKeysResponse originKeysResponse = checkoutUtility.originKeys(originKeysRequest);
        assertEquals("pub.v2.7814286629520534.aHR0cHM6Ly93d3cueW91ci1kb21haW4xLmNvbQ.UEwIBmW9-c_uXo5wSEr2w8Hz8hVIpujXPHjpcEse3xI", originKeysResponse.getOriginKeys().get("https://www.your-domain1.com"));
    }
}
