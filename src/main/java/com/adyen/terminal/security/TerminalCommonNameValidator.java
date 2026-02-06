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

  // Precompiled regex for Terminal API CN format
  private static final Pattern TERMINAL_API_CN_TEST =
      Pattern.compile("[a-zA-Z0-9]{3,}-[a-zA-Z0-9]{9,15}\\.test\\.terminal\\.adyen\\.com");
  private static final Pattern TERMINAL_API_CN_LIVE =
      Pattern.compile("[a-zA-Z0-9]{3,}-[a-zA-Z0-9]{9,15}\\.live\\.terminal\\.adyen\\.com");

  // Exact strings for legacy format (no regex needed)
  private static final String TERMINAL_API_LEGACY_TEST =
      "legacy-terminal-certificate.test.terminal.adyen.com";
  private static final String TERMINAL_API_LEGACY_LIVE =
      "legacy-terminal-certificate.live.terminal.adyen.com";

  // Regex to extract CN from subject string
  private static final Pattern SUBJECT_ATTRIBUTE_PATTERN =
      Pattern.compile("(?:^|,\\s?)([A-Z]+)=((?:\"[^\"]+\")|[^,]+)");

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
    return validateCertificate(new X509CertificateInfo(certificate), environment);
  }

  /**
   * Validates the Common Name of the given {@link CertificateInfo} for the given {@link
   * Environment}.
   *
   * @param certificateInfo the {@link CertificateInfo} to validate.
   * @param environment the {@link Environment}.
   * @return true if the Common Name is valid, false otherwise.
   */
  static boolean validateCertificate(CertificateInfo certificateInfo, Environment environment) {
    String name = certificateInfo.getSubjectName();
    Matcher matcher = SUBJECT_ATTRIBUTE_PATTERN.matcher(name);

    while (matcher.find()) {
      String groupName = matcher.group(1);
      if ("CN".equals(groupName)) {
        String commonName = matcher.group(2);
        return isValidCommonName(commonName, environment);
      }
    }
    return false;
  }

  private static boolean isValidCommonName(String commonName, Environment environment) {
    if (commonName == null) {
      return false;
    }

    switch (environment) {
      case LIVE:
        return TERMINAL_API_CN_LIVE.matcher(commonName).matches()
            || TERMINAL_API_LEGACY_LIVE.equals(commonName);
      case TEST:
        return TERMINAL_API_CN_TEST.matcher(commonName).matches()
            || TERMINAL_API_LEGACY_TEST.equals(commonName);
      default:
        return false;
    }
  }
}
