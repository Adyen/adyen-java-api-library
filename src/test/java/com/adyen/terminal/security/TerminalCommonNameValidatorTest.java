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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.terminal.security;

import com.adyen.enums.Environment;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.mockito.Mock;

import javax.security.auth.x500.X500Principal;
import java.security.cert.X509Certificate;
import java.security.Principal;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Parameterized.class)
public class TerminalCommonNameValidatorTest {

    @Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                // Valid CNs and environment
                { "EMAILADDRESS=mock@adyen.com, CN=legacy-terminal-certificate.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, true },
                { "EMAILADDRESS=mock@adyen.com, CN=legacy-terminal-certificate.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.LIVE, true },
                { "EMAILADDRESS=mock@adyen.com, CN=P400-123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, true },
                { "EMAILADDRESS=mock@adyen.com, CN=P400-123456789.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.LIVE, true },
                { "EMAILADDRESS=mock@adyen.com, CN=S1E-000150123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, true },
                { "EMAILADDRESS=mock@adyen.com, CN=S1E-000150123456789.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.LIVE, true },
                // Wrong environment
                { "EMAILADDRESS=mock@adyen.com, CN=legacy-terminal-certificate.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.LIVE, false },
                { "EMAILADDRESS=mock@adyen.com, CN=P400-123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.LIVE, false },
                { "EMAILADDRESS=mock@adyen.com, CN=S1E-000150123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.LIVE, false },
                { "EMAILADDRESS=mock@adyen.com, CN=legacy-terminal-certificate.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=P400-123456789.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=S1E-000150123456789.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                // Invalid CN
                { "EMAILADDRESS=mock@adyen.com, CN=wrong-terminal-certificate.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=legacyy-terminal-certificate.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=legacy-terminaal-certificate.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=legacy-terminal-certificatee.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=P400.123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=P400123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=P4-123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=P400-ABC.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=P400-123.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=P400-.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=-123.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=www.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                { "EMAILADDRESS=mock@adyen.com, CN=ANY, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false },
                // Missing CN
                { "EMAILADDRESS=mock@adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO", Environment.TEST, false }

        });
    }

    private final String certificateName;
    private final Environment environment;
    private final boolean expectedResult;

    @Mock
    private X509Certificate certificate;
    @Mock
    private X500Principal principal;

    public TerminalCommonNameValidatorTest(String certificateName, Environment environment, boolean expectedResult) {
        this.certificateName = certificateName;
        this.environment = environment;
        this.expectedResult = expectedResult;
    }

    @Before
    public void setUp() {
        initMocks(this);
    }

    @Test
    public void testSerialize() {
        when(certificate.getSubjectX500Principal()).thenReturn(principal);
        when(principal.getName()).thenReturn(certificateName);

        boolean result = TerminalCommonNameValidator.validateCertificate(certificate, environment);
        assertEquals(expectedResult, result);
    }
}
