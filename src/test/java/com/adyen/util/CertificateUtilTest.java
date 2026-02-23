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

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CertificateUtilTest {

  @Test
  public void testErrorLoadingCertificateFromPath() {
    Assertions.assertThrows(FileNotFoundException.class, () -> CertificateUtil.loadCertificate(""));
  }

  @Test
  public void testLoadCertificateFromPath() throws FileNotFoundException, CertificateException {
    String path = getClass().getClassLoader().getResource("adyen-terminalfleet-test.pem").getPath();
    Certificate certificate = CertificateUtil.loadCertificate(path);

    Assertions.assertNotNull(certificate);
  }

  @Test
  public void testLoadCertificateFromInputStream() throws CertificateException {
    InputStream stream =
        getClass().getClassLoader().getResourceAsStream("adyen-terminalfleet-test.pem");
    Certificate certificate = CertificateUtil.loadCertificate(stream);

    Assertions.assertNotNull(certificate);
  }

  @Test
  public void testLoadKeyStore()
      throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
    URL resource = getClass().getClassLoader().getResource("testStore.keystore");

    KeyStore keyStore =
        CertificateUtil.loadKeyStore(resource.getPath(), KeyStore.getDefaultType(), "test1234");

    Assertions.assertNotNull(keyStore);
    Assertions.assertTrue(keyStore.containsAlias("boguscert"));
  }

  @Test
  public void testLoadKeyStore_WithoutPassword()
      throws CertificateException, NoSuchAlgorithmException, KeyStoreException, IOException {
    URL resource = getClass().getClassLoader().getResource("testStore.keystore");

    KeyStore keyStore =
        CertificateUtil.loadKeyStore(resource.getPath(), KeyStore.getDefaultType(), null);

    Assertions.assertNotNull(keyStore);
    Assertions.assertTrue(keyStore.containsAlias("boguscert"));
  }

  @Test
  public void testLoadKeyStore_FileNotFoundErrorOnInvalidPath() {
    Assertions.assertThrows(
        FileNotFoundException.class,
        () -> CertificateUtil.loadKeyStore("xyz", KeyStore.getDefaultType(), ""));
  }

  @Test
  public void testLoadKeyStore_ErrorOnNullKeyStorePath() {
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> CertificateUtil.loadKeyStore(null, "JKS", ""));
  }

  @Test
  public void testLoadKeyStore_ErrorOnNullKeyStoreType() {
    Assertions.assertThrows(
        IllegalArgumentException.class, () -> CertificateUtil.loadKeyStore("xyz", null, ""));
  }
}
