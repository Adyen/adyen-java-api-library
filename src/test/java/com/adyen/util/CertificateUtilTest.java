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

import org.junit.Assert;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;

public class CertificateUtilTest {

    @Test
    public void testErrorLoadingCertificateFromPath() {
        Assert.assertThrows(FileNotFoundException.class, () -> CertificateUtil.loadCertificate(""));
    }

    @Test
    public void testLoadCertificateFromPath() throws FileNotFoundException, CertificateException {
        String path = getClass().getClassLoader().getResource("adyen-terminalfleet-test.pem").getPath();
        Certificate certificate = CertificateUtil.loadCertificate(path);

        Assert.assertNotNull(certificate);
    }

    @Test
    public void testLoadCertificateFromInputStream() throws CertificateException {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("adyen-terminalfleet-test.pem");
        Certificate certificate = CertificateUtil.loadCertificate(stream);

        Assert.assertNotNull(certificate);
    }

    @Test
    public void testLoadKeyStore() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        URL resource = getClass().getClassLoader().getResource("testStore.keystore");

        KeyStore keyStore = CertificateUtil.loadKeyStore(resource.getPath(), KeyStore.getDefaultType(), "test1234");

        Assert.assertNotNull(keyStore);
        Assert.assertTrue(keyStore.containsAlias("boguscert"));
    }

    @Test
    public void testLoadKeyStore_WithoutPassword() throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
        URL resource = getClass().getClassLoader().getResource("testStore.keystore");

        KeyStore keyStore = CertificateUtil.loadKeyStore(resource.getPath(), KeyStore.getDefaultType(), null);

        Assert.assertNotNull(keyStore);
        Assert.assertTrue(keyStore.containsAlias("boguscert"));
    }

    @Test
    public void testLoadKeyStore_FileNotFoundErrorOnInvalidPath() {
        Assert.assertThrows(FileNotFoundException.class, () -> CertificateUtil.loadKeyStore("xyz", KeyStore.getDefaultType(), ""));
    }

    @Test
    public void testLoadKeyStore_ErrorOnNullKeyStorePath() {
        Assert.assertThrows(IllegalArgumentException.class, () -> CertificateUtil.loadKeyStore(null, "JKS", ""));
    }

    @Test
    public void testLoadKeyStore_ErrorOnNullKeyStoreType() {
        Assert.assertThrows(IllegalArgumentException.class, () -> CertificateUtil.loadKeyStore("xyz", null, ""));
    }
}