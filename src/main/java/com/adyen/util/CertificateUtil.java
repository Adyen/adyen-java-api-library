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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
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

    /**
     * Load KeyStore from given path and type
     * @param keyStorePath file path
     * @param keyStoreType keystore type (JKS/PKCS12 etc)
     * @param keyStorePassword keystore password
     * @return
     * @throws KeyStoreException
     * @throws CertificateException
     * @throws NoSuchAlgorithmException
     * @throws IOException
     */
    public static KeyStore loadKeyStore(String keyStorePath, String keyStoreType, String keyStorePassword) throws KeyStoreException, CertificateException, NoSuchAlgorithmException, IOException {

        if (keyStorePath == null || keyStoreType == null) {
            throw new IllegalArgumentException();
        }

        KeyStore keyStore = KeyStore.getInstance(keyStoreType);

        char[] password = null;

        if (keyStorePassword != null && !keyStorePassword.isEmpty()) {
            password = keyStorePassword.toCharArray();
        }

        File file = new File(keyStorePath);

        if (!file.exists()) {
            throw new FileNotFoundException("Keystore file not found at path " + keyStorePath);
        }

        FileInputStream inputStream = new FileInputStream(file);
        keyStore.load(inputStream, password);
        inputStream.close();
        return keyStore;
    }
}
