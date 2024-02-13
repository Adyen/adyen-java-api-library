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

public final class TerminalCommonNameValidator {

    private static final String ENVIRONMENT_WILDCARD = "{ENVIRONMENT}";
    private static final String TERMINAL_API_CN_REGEX = "[a-zA-Z0-9]{3,}-[0-9]{9,15}\\." + ENVIRONMENT_WILDCARD + "\\.terminal\\.adyen\\.com";
    private static final String TERMINAL_API_LEGACY_CN = "legacy-terminal-certificate." + ENVIRONMENT_WILDCARD + ".terminal.adyen.com";

    private TerminalCommonNameValidator() {
    }

    public static boolean validateCertificate(X509Certificate certificate, Environment environment) {
        String environmentName = environment.name().toLowerCase();
        String name = certificate.getSubjectX500Principal().getName();
        String patternRegex = "(?:^|,\\s?)(?:([A-Z]+)=(\"(?:[^\"]|\"\")+\"|[^,]+))+";
        Pattern pattern = Pattern.compile(patternRegex);
        Matcher matcher = pattern.matcher(name);
        boolean valid = false;
        while (matcher.find() && !valid) {
            String groupName = matcher.group(1);
            if ("CN".equals(groupName)) {
                String commonName = matcher.group(2);
                valid = commonName != null
                        && (commonName.matches(TERMINAL_API_CN_REGEX.replace(ENVIRONMENT_WILDCARD, environmentName))
                        || commonName.equals(TERMINAL_API_LEGACY_CN.replace(ENVIRONMENT_WILDCARD, environmentName)));
            }
        }

        return valid;
    }
}
