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

import com.adyen.model.clouddevice.SaleToPOISecuredMessage;
import com.adyen.model.clouddevice.security.NexoDerivedKey;
import com.adyen.model.clouddevice.security.SecurityTrailer;
import com.adyen.model.tapi.MessageHeader;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import javax.crypto.Cipher;
import org.apache.commons.codec.binary.Base64;

/**
 * Handles encryption, decryption, and integrity validation for Nexo SaleToPOI messages using AES
 * and HMAC.
 *
 * <p>- Derives keys from EncryptionCredentialDetails - Encrypts and decrypts Nexo messages
 * (AES-256-CBC) - Generates and validates HMAC (SHA-256) - Constructs and validates SecurityTrailer
 */
public class NexoSecurityManager {

  private final EncryptionCredentialDetails encryptionCredentialDetails;
  private volatile NexoDerivedKey nexoDerivedKey;

  public NexoSecurityManager(EncryptionCredentialDetails encryptionCredentialDetails)
      throws NexoSecurityException {
    validateSecurityKey(encryptionCredentialDetails);
    this.encryptionCredentialDetails = encryptionCredentialDetails;
  }

  /**
   * Encrypts the SaleToPOI message using the provided message header and security key.
   *
   * @param saleToPoiMessageJson the JSON string representing the SaleToPOI message
   * @param messageHeader the message header for encryption
   * @return encrypted SaleToPOISecuredMessage
   * @throws NexoSecurityException if encryption fails
   */
  public SaleToPOISecuredMessage encrypt(String saleToPoiMessageJson, MessageHeader messageHeader)
      throws NexoSecurityException {

    try {
      NexoDerivedKey derivedKey = getNexoDerivedKey();
      byte[] saleToPoiMessageByteArray = saleToPoiMessageJson.getBytes(StandardCharsets.UTF_8);

      // Generate a random initialization vector (IV) nonce
      byte[] ivNonce = NexoCryptoPrimitives.generateRandomIvNonce();

      // Perform AES encryption
      byte[] encryptedSaleToPoiMessage =
          NexoCryptoPrimitives.crypt(
              saleToPoiMessageByteArray, derivedKey, ivNonce, Cipher.ENCRYPT_MODE);

      // Generate HMAC for message authentication
      byte[] hmacSignature = NexoCryptoPrimitives.hmac(saleToPoiMessageByteArray, derivedKey);

      // Populate security trailer with metadata and HMAC
      SecurityTrailer securityTrailer = new SecurityTrailer();
      securityTrailer.setAdyenCryptoVersion(
          this.encryptionCredentialDetails.getAdyenCryptoVersion());
      securityTrailer.setKeyIdentifier(this.encryptionCredentialDetails.getKeyIdentifier());
      securityTrailer.setKeyVersion(this.encryptionCredentialDetails.getKeyVersion());
      // SecurityTrailer.nonce and .hmac are byte[] fields serialized by ByteArraySerializer as a
      // plain UTF-8 string (not re-encoded). Storing Base64String.getBytes() means the JSON will
      // contain the Base64 string directly, which is what the API expects. On deserialization,
      // ByteArrayDeserializer recovers these UTF-8 bytes, and decrypt() Base64-decodes them back
      // to raw bytes. Do not change this to raw bytes without updating decrypt() accordingly.
      securityTrailer.setNonce(Base64.encodeBase64String(ivNonce).getBytes());
      securityTrailer.setHmac(Base64.encodeBase64String(hmacSignature).getBytes());

      // Construct the secured message with the encrypted content and securityTrailer
      SaleToPOISecuredMessage saleToPoiSecuredMessage = new SaleToPOISecuredMessage();
      saleToPoiSecuredMessage.setMessageHeader(messageHeader);
      saleToPoiSecuredMessage.setNexoBlob(Base64.encodeBase64String(encryptedSaleToPoiMessage));
      saleToPoiSecuredMessage.setSecurityTrailer(securityTrailer);

      return saleToPoiSecuredMessage;

    } catch (Exception e) {
      throw new NexoSecurityException("Cannot encrypt the SaleToPOISecuredMessage", e);
    }
  }

  /**
   * Decrypts the SaleToPOI secured message.
   *
   * @param saleToPoiSecuredMessage the encrypted message
   * @return the decrypted SaleToPOI message as a JSON string
   * @throws NexoSecurityException if decryption fails
   */
  public String decrypt(SaleToPOISecuredMessage saleToPoiSecuredMessage)
      throws NexoSecurityException {
    try {
      NexoDerivedKey derivedKey = getNexoDerivedKey();

      // Decode the encrypted blob
      byte[] encryptedSaleToPoiMessageByteArray =
          Base64.decodeBase64(saleToPoiSecuredMessage.getNexoBlob().getBytes());

      // Retrieve the nonce (IV) from the securityTrailer
      byte[] ivNonceB64 = saleToPoiSecuredMessage.getSecurityTrailer().getNonce();
      String nonceString = new String(ivNonceB64, StandardCharsets.UTF_8);
      byte[] ivNonce = Base64.decodeBase64(nonceString);

      // Decrypt the message
      byte[] decryptedSaleToPoiMessageByteArray =
          NexoCryptoPrimitives.crypt(
              encryptedSaleToPoiMessageByteArray, derivedKey, ivNonce, Cipher.DECRYPT_MODE);

      // Validate HMAC to ensure message integrity
      byte[] receivedHmac = saleToPoiSecuredMessage.getSecurityTrailer().getHmac();

      String hmacString = new String(receivedHmac, StandardCharsets.UTF_8);
      byte[] hmacBytes = Base64.decodeBase64(hmacString);
      NexoCryptoPrimitives.validateHmac(hmacBytes, decryptedSaleToPoiMessageByteArray, derivedKey);

      return new String(decryptedSaleToPoiMessageByteArray, StandardCharsets.UTF_8);

    } catch (Exception e) {
      throw new NexoSecurityException("Cannot decrypt the SaleToPOISecuredMessage", e);
    }
  }

  /**
   * Validates the encryptionCredentialDetails to ensure all required fields are present.
   *
   * @param encryptionCredentialDetails the encryptionCredentialDetails to validate
   * @throws NexoSecurityException if the security key is invalid
   */
  private void validateSecurityKey(EncryptionCredentialDetails encryptionCredentialDetails)
      throws NexoSecurityException {
    if (encryptionCredentialDetails == null
        || encryptionCredentialDetails.getPassphrase() == null
        || encryptionCredentialDetails.getPassphrase().isEmpty()
        || encryptionCredentialDetails.getKeyIdentifier() == null
        || encryptionCredentialDetails.getKeyVersion() == null
        || encryptionCredentialDetails.getAdyenCryptoVersion() == null) {
      throw new NexoSecurityException("Invalid Security Key");
    }
  }

  /**
   * Lazily initializes and retrieves the derived key material for encryption/decryption.
   *
   * @return the derived key material
   */
  NexoDerivedKey getNexoDerivedKey() throws GeneralSecurityException {
    if (nexoDerivedKey == null) {
      synchronized (this) {
        if (nexoDerivedKey == null) {
          nexoDerivedKey =
              NexoDerivedKeyGenerator.deriveKeyMaterial(
                  this.encryptionCredentialDetails.getPassphrase());
        }
      }
    }
    return nexoDerivedKey;
  }
}
