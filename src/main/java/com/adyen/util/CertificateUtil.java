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

/**
 * Utility class for loading X.509 certificates and Java KeyStores.
 */
public final class CertificateUtil {

    private CertificateUtil() {
    }

    /**
     * Loads an X.509 certificate from the given file path.
     * @param filePath Filepath of the certificate
     * @return instance of the certificate
     * @throws FileNotFoundException if file is not found
     * @throws CertificateException if any error occurred while reading the certificate
     */
    public static Certificate loadCertificate(String filePath) throws FileNotFoundException, CertificateException {
        return loadCertificate(new FileInputStream(filePath));
    }

    /**
     * Loads an X.509 certificate from an input stream.
     * @param inputStream InputStream containing the certificate.
     * @return instance of the certificate
     * @throws CertificateException if any error occurred while reading certificate from stream
     */
    public static Certificate loadCertificate(InputStream inputStream) throws CertificateException {
        CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
        return certificateFactory.generateCertificate(inputStream);
    }

    /**
     * Loads a KeyStore from the specified file path using the given type and password.
     * @param keyStorePath file path
     * @param keyStoreType keystore type (JKS/PKCS12 etc)
     * @param keyStorePassword keystore password
     * @return the loaded KeyStore instance.
     * @throws KeyStoreException if the keystore type is invalid.
     * @throws CertificateException if a certificate in the keystore could not be loaded.
     * @throws NoSuchAlgorithmException if the algorithm for checking the keystore integrity cannot be found.
     * @throws IOException if there is an I/O or format problem with the keystore data.
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

        try (FileInputStream inputStream = new FileInputStream(file)) {
            keyStore.load(inputStream, password);
        }

        return keyStore;
    }
}
