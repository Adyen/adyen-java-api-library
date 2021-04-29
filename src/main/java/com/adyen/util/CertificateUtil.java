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
package com.adyen.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

public final class CertificateUtil {

    private CertificateUtil() {
    }

    /**
     * Load Certificate from system file path
     * @param filePath Path of certificate file
     * @return Certificate
     * @throws FileNotFoundException if file is not found
     * @throws CertificateException if any error occurred while reading certificate
     */
    public static Certificate loadCertificate(String filePath) throws FileNotFoundException, CertificateException {
        return loadCertificate(new FileInputStream(filePath));
    }

    /**
     * Load Certificate from a input stream
     * @param inputStream InputStream containing certificate data
     * @return Certificate
     * @throws CertificateException if any error occurred while reading certificate from stream
     */
    public static Certificate loadCertificate(InputStream inputStream) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        return certificateFactory.generateCertificate(inputStream);
    }
}
