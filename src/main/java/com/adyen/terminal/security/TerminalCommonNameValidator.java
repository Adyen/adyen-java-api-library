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
import java.security.cert.X509Certificate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** Validates the Common Name of a terminal API certificate. */
public final class TerminalCommonNameValidator {

  // regex for Terminal API CN format
  private static final String TERMINAL_API_CN_TEST_ENVIRONMENT =
      "[a-zA-Z0-9]{3,}-[a-zA-Z0-9]{9,15}\\.test\\.terminal\\.adyen\\.com";
  private static final String TERMINAL_API_CN_LIVE_ENVIRONMENT =
      "[a-zA-Z0-9]{3,}-[a-zA-Z0-9]{9,15}\\.live\\.terminal\\.adyen\\.com";
  // regex for Legacy format
  private static final String TERMINAL_API_LEGACY_CN_TEST_ENVIRONMENT =
      "legacy-terminal-certificate.test.terminal.adyen.com";
  private static final String TERMINAL_API_LEGACY_CN_LIVE_ENVIRONMENT =
      "legacy-terminal-certificate.live.terminal.adyen.com";

  private TerminalCommonNameValidator() {}

  /**
   * Validates the Common Name of the given {@link X509Certificate} for the given {@link
   * Environment}.
   *
   * @param certificate the {@link X509Certificate} to validate.
   * @param environment the {@link Environment}.
   * @return true if the Common Name is valid, false otherwise.
   */
  public static boolean validateCertificate(X509Certificate certificate, Environment environment) {

    String name = certificate.getSubjectX500Principal().getName();
    String patternRegex = "(?:^|,\\s?)(?:([A-Z]+)=(\"(?:[^\"]|\"\")+\"|[^,]+))+";
    Pattern pattern = Pattern.compile(patternRegex);
    Matcher matcher = pattern.matcher(name);

    boolean valid = false;
    while (matcher.find() && !valid) {
      String groupName = matcher.group(1);
      if ("CN".equals(groupName)) {
        String commonName = matcher.group(2);
        valid =
            commonName != null
                &&
                // must match any of the regex
                (commonName.matches(getEnvironmentRegex(environment))
                    || commonName.equals(getEnvironmentRegexLegacy(environment)));
      }
    }
    return valid;
  }

  /**
   * Returns the regex for the given {@link Environment}.
   *
   * @param environment Environment
   * @return String with the regex
   */
  private static String getEnvironmentRegex(Environment environment) {
    if (environment == Environment.LIVE) {
      return TERMINAL_API_CN_LIVE_ENVIRONMENT;
    } else {
      return TERMINAL_API_CN_TEST_ENVIRONMENT;
    }
  }

  /**
   * Returns the LEGACY regex for the given {@link Environment}.
   *
   * @param environment Environment
   * @return String with the regex
   */
  private static String getEnvironmentRegexLegacy(Environment environment) {
    if (environment == Environment.LIVE) {
      return TERMINAL_API_LEGACY_CN_LIVE_ENVIRONMENT;
    } else {
      return TERMINAL_API_LEGACY_CN_TEST_ENVIRONMENT;
    }
  }
}
