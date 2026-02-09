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

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import com.adyen.enums.Environment;
import java.util.Arrays;
import java.util.Collection;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TerminalCommonNameValidatorTest {

  public static Collection<Object[]> data() {
    return Arrays.asList(
        new Object[][] {
          // Valid CNs and environment
          {
            "EMAILADDRESS=mock@adyen.com, CN=TG300-G10M257M70004.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            true
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=legacy-terminal-certificate.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            true
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=legacy-terminal-certificate.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.LIVE,
            true
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=P400-123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            true
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=P400-123456789.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.LIVE,
            true
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=S1E-000150123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            true
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=S1E-000150123456789.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.LIVE,
            true
          },
          // Wrong environment
          {
            "EMAILADDRESS=mock@adyen.com, CN=legacy-terminal-certificate.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.LIVE,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=P400-123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.LIVE,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=S1E-000150123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.LIVE,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=legacy-terminal-certificate.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=P400-123456789.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=S1E-000150123456789.live.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          // Invalid CN
          {
            "EMAILADDRESS=mock@adyen.com, CN=wrong-terminal-certificate.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=legacyy-terminal-certificate.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=legacy-terminaal-certificate.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=legacy-terminal-certificatee.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=P400.123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=P400123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=P4-123456789.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=P400-ABC.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=P400-123.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=P400-.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=-123.test.terminal.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=www.adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          {
            "EMAILADDRESS=mock@adyen.com, CN=ANY, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          },
          // Missing CN
          {
            "EMAILADDRESS=mock@adyen.com, OU=Mock, O=Mock, L=Mock, ST=MO, C=MO",
            Environment.TEST,
            false
          }
        });
  }

  @Mock private CertificateInfo certificateInfo;

  @ParameterizedTest
  @MethodSource("data")
  public void testValidateCertificate(
      String certificateName, Environment environment, boolean expectedResult) {
    when(certificateInfo.getSubjectName()).thenReturn(certificateName);

    boolean result = TerminalCommonNameValidator.validateCertificate(certificateInfo, environment);
    assertEquals(expectedResult, result);
  }
}
