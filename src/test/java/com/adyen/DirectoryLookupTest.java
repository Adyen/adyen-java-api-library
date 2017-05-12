/**
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
package com.adyen;

import java.io.IOException;
import java.security.SignatureException;
import java.util.List;
import java.util.SortedMap;
import org.junit.Test;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.hpp.DirectoryLookupRequest;
import com.adyen.model.hpp.Issuer;
import com.adyen.model.hpp.PaymentMethod;
import com.adyen.service.HostedPaymentPages;
import static com.adyen.constants.HPPConstants.Fields.CURRENCY_CODE;
import static com.adyen.constants.HPPConstants.Fields.MERCHANT_SIG;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests notification messages
 */
public class DirectoryLookupTest extends BaseTest {
    private DirectoryLookupRequest createDirectoryLookupRequest() {
        DirectoryLookupRequest directoryLookupRequest = new DirectoryLookupRequest()
                .setCountryCode("NL")
                .setMerchantReference("test:\\'test")
                .setPaymentAmount("1000")
                .setCurrencyCode("EUR");
        return directoryLookupRequest;
    }

    @Test
    public void testGetPostParameters() throws SignatureException {
        Client client = createMockClientFromResponse("");

        HostedPaymentPages hostedPaymentPages = new HostedPaymentPages(client);
        DirectoryLookupRequest directoryLookupRequest = createDirectoryLookupRequest();

        SortedMap<String, String> postParameters = hostedPaymentPages
                .getPostParametersFromDLRequest(directoryLookupRequest);
        assertEquals("EUR", postParameters.get(CURRENCY_CODE));
        assertEquals(44, postParameters.get(MERCHANT_SIG).length());
    }

    @Test
    public void testGetPaymentMethods() throws HTTPClientException, SignatureException, IOException {
        Client client = createMockClientFromFile("mocks/hpp/directoryLookup-success.json");

        HostedPaymentPages hostedPaymentPages = new HostedPaymentPages(client);
        DirectoryLookupRequest directoryLookupRequest = createDirectoryLookupRequest();

        List<PaymentMethod> paymentMethods = hostedPaymentPages.getPaymentMethods(directoryLookupRequest);

        assertEquals(8, paymentMethods.size());

        PaymentMethod ideal = paymentMethods.get(0);
        assertEquals("ideal", ideal.getBrandCode());
        assertEquals("iDEAL", ideal.getName());
        assertFalse(ideal.isCard());

        assertEquals(3, ideal.getIssuers().size());
        Issuer issuer1 = ideal.getIssuers().get(0);

        assertEquals("1121", issuer1.getIssuerId());
        assertEquals("Test Issuer", issuer1.getName());

        PaymentMethod visa = paymentMethods.get(1);
        assertEquals("visa", visa.getBrandCode());
        assertTrue(visa.isCard());
    }

}
