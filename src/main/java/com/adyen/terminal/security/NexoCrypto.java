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

import static com.adyen.model.terminal.security.NexoDerivedKey.NEXO_IV_LENGTH;

import com.adyen.model.nexo.MessageHeader;
import com.adyen.model.terminal.security.NexoDerivedKey;
import com.adyen.model.terminal.security.SaleToPOISecuredMessage;
import com.adyen.model.terminal.security.SecurityKey;
import com.adyen.model.terminal.security.SecurityTrailer;
import com.adyen.terminal.security.exception.NexoCryptoException;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;

public class NexoCrypto {

  private final SecurityKey securityKey;
  private volatile NexoDerivedKey nexoDerivedKey;

  public NexoCrypto(SecurityKey securityKey) throws NexoCryptoException {
    // Validate security key to ensure it has the necessary properties
    validateSecurityKey(securityKey);
    this.securityKey = securityKey;
  }

  /**
   * Encrypts the SaleToPOI message using the provided message header and security key.
   *
   * @param saleToPoiMessageJson the JSON string representing the SaleToPOI message
   * @param messageHeader the message header for encryption
   * @return encrypted SaleToPOISecuredMessage
   */
  public SaleToPOISecuredMessage encrypt(String saleToPoiMessageJson, MessageHeader messageHeader)
      throws Exception {
    NexoDerivedKey derivedKey = getNexoDerivedKey();
    byte[] saleToPoiMessageByteArray = saleToPoiMessageJson.getBytes(StandardCharsets.UTF_8);

    // Generate a random initialization vector (IV) nonce
    byte[] ivNonce = generateRandomIvNonce();

    // Perform AES encryption
    byte[] encryptedSaleToPoiMessage =
        crypt(saleToPoiMessageByteArray, derivedKey, ivNonce, Cipher.ENCRYPT_MODE);

    // Generate HMAC for message authentication
    byte[] encryptedSaleToPoiMessageHmac = hmac(saleToPoiMessageByteArray, derivedKey);

    // Populate security trailer with metadata and HMAC
    SecurityTrailer securityTrailer = new SecurityTrailer();
    securityTrailer.setKeyVersion(securityKey.getKeyVersion());
    securityTrailer.setKeyIdentifier(securityKey.getKeyIdentifier());
    securityTrailer.setHmac(encryptedSaleToPoiMessageHmac);
    securityTrailer.setNonce(ivNonce);
    securityTrailer.setAdyenCryptoVersion(securityKey.getAdyenCryptoVersion());

    // Construct the secured message with the encrypted content and security trailer
    SaleToPOISecuredMessage saleToPoiSecuredMessage = new SaleToPOISecuredMessage();
    saleToPoiSecuredMessage.setMessageHeader(messageHeader);
    saleToPoiSecuredMessage.setNexoBlob(new String(Base64.encodeBase64(encryptedSaleToPoiMessage)));
    saleToPoiSecuredMessage.setSecurityTrailer(securityTrailer);

    return saleToPoiSecuredMessage;
  }

  /**
   * Decrypts the SaleToPOI secured message.
   *
   * @param saleToPoiSecuredMessage the encrypted message
   * @return the decrypted SaleToPOI message as a JSON string
   */
  public String decrypt(SaleToPOISecuredMessage saleToPoiSecuredMessage) throws Exception {
    NexoDerivedKey derivedKey = getNexoDerivedKey();

    // Decode the encrypted blob
    byte[] encryptedSaleToPoiMessageByteArray =
        Base64.decodeBase64(saleToPoiSecuredMessage.getNexoBlob().getBytes());

    // Retrieve the nonce (IV) from the security trailer
    byte[] ivNonce = saleToPoiSecuredMessage.getSecurityTrailer().getNonce();

    // Decrypt the message
    byte[] decryptedSaleToPoiMessageByteArray =
        crypt(encryptedSaleToPoiMessageByteArray, derivedKey, ivNonce, Cipher.DECRYPT_MODE);

    // Validate HMAC to ensure message integrity
    byte[] receivedHmac = saleToPoiSecuredMessage.getSecurityTrailer().getHmac();
    validateHmac(receivedHmac, decryptedSaleToPoiMessageByteArray, derivedKey);

    return new String(decryptedSaleToPoiMessageByteArray, StandardCharsets.UTF_8);
  }

  /**
   * Validates the security key to ensure all required fields are present.
   *
   * @param securityKey the security key to validate
   * @throws NexoCryptoException if the security key is invalid
   */
  private void validateSecurityKey(SecurityKey securityKey) throws NexoCryptoException {
    if (securityKey == null
        || securityKey.getPassphrase() == null
        || securityKey.getPassphrase().isEmpty()
        || securityKey.getKeyIdentifier() == null
        || securityKey.getKeyVersion() == null
        || securityKey.getAdyenCryptoVersion() == null) {
      throw new NexoCryptoException("Invalid Security Key");
    }
  }

  /**
   * Lazily initializes and retrieves the derived key material for encryption/decryption.
   *
   * @return the derived key material
   */
  private NexoDerivedKey getNexoDerivedKey() throws GeneralSecurityException {
    if (nexoDerivedKey == null) {
      synchronized (this) {
        if (nexoDerivedKey == null) {
          nexoDerivedKey = NexoDerivedKeyGenerator.deriveKeyMaterial(securityKey.getPassphrase());
        }
      }
    }
    return nexoDerivedKey;
  }

  /** Performs AES encryption/decryption using the derived key and provided IV. */
  private byte[] crypt(byte[] bytes, NexoDerivedKey dk, byte[] ivNonce, int mode)
      throws NoSuchAlgorithmException,
          NoSuchPaddingException,
          IllegalBlockSizeException,
          BadPaddingException,
          InvalidKeyException,
          InvalidAlgorithmParameterException {

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    SecretKeySpec secretKeySpec = new SecretKeySpec(dk.getCipherKey(), "AES");

    // Derive the actual IV by XORing the derived IV with the nonce
    byte[] iv = dk.getIv();
    byte[] actualIV = new byte[NEXO_IV_LENGTH];
    for (int i = 0; i < NEXO_IV_LENGTH; i++) {
      actualIV[i] = (byte) (iv[i] ^ ivNonce[i]);
    }

    IvParameterSpec ivParameterSpec = new IvParameterSpec(actualIV);
    cipher.init(mode, secretKeySpec, ivParameterSpec);
    return cipher.doFinal(bytes);
  }

  /** Generates an HMAC for message authentication. */
  private byte[] hmac(byte[] bytes, NexoDerivedKey derivedKey)
      throws NoSuchAlgorithmException, InvalidKeyException {
    Mac mac = Mac.getInstance("HmacSHA256");
    SecretKeySpec s = new SecretKeySpec(derivedKey.getHmacKey(), "HmacSHA256");

    mac.init(s);
    return mac.doFinal(bytes);
  }

  /** Validates the HMAC of a decrypted message to ensure data integrity. */
  private void validateHmac(byte[] receivedHmac, byte[] decryptedMessage, NexoDerivedKey derivedKey)
      throws NexoCryptoException, InvalidKeyException, NoSuchAlgorithmException {
    byte[] hmac = hmac(decryptedMessage, derivedKey);
    boolean valid = MessageDigest.isEqual(hmac, receivedHmac);

    if (!valid) {
      throw new NexoCryptoException("HMAC validation failed");
    }
  }

  /** Generates a random IV nonce using a secure random number generator. */
  private byte[] generateRandomIvNonce() {
    byte[] ivNonce = new byte[NEXO_IV_LENGTH];
    SecureRandom secureRandom;
    try {
      secureRandom = SecureRandom.getInstance("NativePRNGNonBlocking");
    } catch (Exception NoSuchAlgorithmException) {
      // Fallback to default SecureRandom implementation
      secureRandom = new SecureRandom();
    }
    secureRandom.nextBytes(ivNonce);
    return ivNonce;
  }
}
