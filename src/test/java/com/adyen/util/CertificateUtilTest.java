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

import static org.mockito.Mockito.mockConstruction;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.withSettings;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.MockedConstruction;
import org.mockito.stubbing.Answer;

public class CertificateUtilTest {

  private static final String CERTIFICATE_RESOURCE = "adyen-terminalfleet-test.pem";

  @BeforeAll
  static void loadCertificateFactory() throws CertificateException {
    // Initialise the X.509 provider before any FileInputStream construction is intercepted.
    CertificateFactory.getInstance("X.509");
  }

  @Test
  public void testLoadCertificateFromPathClosesFileOnSuccess() throws Exception {
    byte[] certificateBytes = Files.readAllBytes(resourcePath(CERTIFICATE_RESOURCE));

    try (MockedConstruction<FileInputStream> fileStreams =
        mockConstruction(
            FileInputStream.class,
            withSettings()
                .defaultAnswer(delegatingTo(new ByteArrayInputStream(certificateBytes))))) {
      Certificate certificate = CertificateUtil.loadCertificate("certificate.pem");

      Assertions.assertNotNull(certificate);
      Assertions.assertEquals(1, fileStreams.constructed().size());
      verify(fileStreams.constructed().get(0)).close();
    }
  }

  @Test
  public void testLoadCertificateFromPathClosesFileOnFailure() throws Exception {
    byte[] invalidCertificate = "not a certificate".getBytes(StandardCharsets.UTF_8);

    try (MockedConstruction<FileInputStream> fileStreams =
        mockConstruction(
            FileInputStream.class,
            withSettings()
                .defaultAnswer(delegatingTo(new ByteArrayInputStream(invalidCertificate))))) {
      Assertions.assertThrows(
          CertificateException.class, () -> CertificateUtil.loadCertificate("invalid.pem"));

      Assertions.assertEquals(1, fileStreams.constructed().size());
      verify(fileStreams.constructed().get(0)).close();
    }
  }

  private java.nio.file.Path resourcePath(String name) throws URISyntaxException {
    return Paths.get(getClass().getClassLoader().getResource(name).toURI());
  }

  /** Forwards every {@link InputStream} method of the mocked file stream to {@code target}. */
  private static Answer<Object> delegatingTo(InputStream target) {
    return invocation -> {
      Method method = invocation.getMethod();
      Method targetMethod;
      try {
        targetMethod = InputStream.class.getMethod(method.getName(), method.getParameterTypes());
      } catch (NoSuchMethodException e) {
        return Answers.RETURNS_DEFAULTS.answer(invocation);
      }
      try {
        return targetMethod.invoke(target, invocation.getArguments());
      } catch (InvocationTargetException e) {
        throw e.getCause();
      }
    };
  }

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
