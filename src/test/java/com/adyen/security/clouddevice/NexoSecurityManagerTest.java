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
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.security.clouddevice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adyen.model.clouddevice.SaleToPOISecuredMessage;
import com.adyen.model.tapi.MessageCategoryType;
import com.adyen.model.tapi.MessageClassType;
import com.adyen.model.tapi.MessageHeader;
import com.adyen.model.tapi.MessageType;
import java.nio.charset.StandardCharsets;
import org.apache.commons.codec.binary.Base64;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/** Tests for NexoSecurityManager encryption/decryption. */
public class NexoSecurityManagerTest {

  private static EncryptionCredentialDetails credentials;
  private static MessageHeader messageHeader;

  @BeforeAll
  public static void setUp() {
    credentials =
        new EncryptionCredentialDetails()
            .adyenCryptoVersion(1)
            .keyIdentifier("CryptoKeyIdentifier12345")
            .keyVersion(1)
            .passphrase("p@ssw0rd123456");

    messageHeader = new MessageHeader();
    messageHeader.setProtocolVersion("3.0");
    messageHeader.setMessageClass(MessageClassType.SERVICE);
    messageHeader.setMessageCategory(MessageCategoryType.PAYMENT);
    messageHeader.setMessageType(MessageType.REQUEST);
    messageHeader.setSaleID("001");
    messageHeader.setServiceID("001");
    messageHeader.setPOIID("MX915-000000001");
  }

  static EncryptionCredentialDetails[] invalidCredentials() {
    return new EncryptionCredentialDetails[] {
      null,
      new EncryptionCredentialDetails(),
      new EncryptionCredentialDetails()
          .passphrase(null)
          .keyIdentifier("k")
          .keyVersion(1)
          .adyenCryptoVersion(1),
      new EncryptionCredentialDetails()
          .passphrase("")
          .keyIdentifier("k")
          .keyVersion(1)
          .adyenCryptoVersion(1),
      new EncryptionCredentialDetails()
          .passphrase("p")
          .keyIdentifier(null)
          .keyVersion(1)
          .adyenCryptoVersion(1),
      new EncryptionCredentialDetails()
          .passphrase("p")
          .keyIdentifier("k")
          .keyVersion(null)
          .adyenCryptoVersion(1),
      new EncryptionCredentialDetails()
          .passphrase("p")
          .keyIdentifier("k")
          .keyVersion(1)
          .adyenCryptoVersion(null),
    };
  }

  /** Point 7: invalid or incomplete credentials must be rejected in the constructor. */
  @ParameterizedTest
  @MethodSource("invalidCredentials")
  public void testInvalidCredentialsThrowOnConstruction(EncryptionCredentialDetails creds) {
    assertThrows(NexoSecurityException.class, () -> new NexoSecurityManager(creds));
  }

  /** Point 9: tampered HMAC must cause decryption to throw NexoSecurityException. */
  @Test
  public void testTamperedHmacFailsDecryption() throws Exception {
    NexoSecurityManager manager = new NexoSecurityManager(credentials);
    String plaintext = "{\"SaleToPOIRequest\":{\"MessageHeader\":{}}}";

    SaleToPOISecuredMessage encrypted = manager.encrypt(plaintext, messageHeader);

    // Replace the HMAC with a different Base64 value (stored as UTF-8 bytes per ByteArraySerializer
    // convention).
    byte[] tamperedHmac =
        Base64.encodeBase64String(
                "tampered-hmac-value-000000000000".getBytes(StandardCharsets.UTF_8))
            .getBytes(StandardCharsets.UTF_8);
    encrypted.getSecurityTrailer().setHmac(tamperedHmac);

    assertThrows(NexoSecurityException.class, () -> manager.decrypt(encrypted));
  }

  /**
   * Confirms that encrypt() followed by decrypt() is internally self-consistent. This establishes a
   * baseline before demonstrating the interoperability bug.
   */
  @Test
  public void testEncryptDecryptRoundTripIsInternallyConsistent() throws Exception {
    NexoSecurityManager manager = new NexoSecurityManager(credentials);
    String plaintext = "{\"SaleToPOIRequest\":{\"MessageHeader\":{}}}";

    SaleToPOISecuredMessage encrypted = manager.encrypt(plaintext, messageHeader);
    String decrypted = manager.decrypt(encrypted);

    assertTrue(decrypted.equals(plaintext));
  }

  /**
   * Verifies that encrypt → JSON serialization → JSON deserialization → decrypt round-trips
   * correctly. This exercises the actual code path used by the API (through the custom
   * ByteArraySerializer/ByteArrayDeserializer), confirming that nonce and HMAC survive the JSON
   * round-trip intact.
   */
  @Test
  public void testEncryptDecryptRoundTripViaJsonSerialization() throws Exception {
    NexoSecurityManager manager = new NexoSecurityManager(credentials);
    String plaintext = "{\"SaleToPOIRequest\":{\"MessageHeader\":{}}}";

    SaleToPOISecuredMessage encrypted = manager.encrypt(plaintext, messageHeader);

    // Simulate what happens when the encrypted message travels over the wire:
    // serialize to JSON then deserialize back (as the API layer does).
    String json = encrypted.toJson();
    SaleToPOISecuredMessage deserialized = SaleToPOISecuredMessage.fromJson(json);

    String decrypted = manager.decrypt(deserialized);
    assertEquals(plaintext, decrypted);
  }
}
