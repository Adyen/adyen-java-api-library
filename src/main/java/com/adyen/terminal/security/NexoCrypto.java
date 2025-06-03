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

/**
 * Provides encryption and decryption for NEXO SaleToPOI messages using AES-CBC and HMAC-SHA256.
 * <p>
 * This class derives cryptographic keys from a passphrase once per application lifecycle,
 * encrypts messages with a unique IV per call, and authenticates them using HMAC.
 * The derived key is lazily initialized and shared across all instances.
 * </p>
 *
 */
public class NexoCrypto {

  private final SecurityKey securityKey;
  private static volatile NexoDerivedKey nexoDerivedKey;

    public NexoCrypto(SecurityKey securityKey) throws NexoCryptoException {
    // Validate security key to ensure it has the necessary properties
    validateSecurityKey(securityKey);
    this.securityKey = securityKey;
  }

  /**
   * Encrypts a plaintext SaleToPOI message using AES and signs it using HMAC.
   *
   * @param saleToPoiMessageJson the SaleToPOI JSON string to encrypt
   * @param messageHeader the message header to add to SaleToPOISecuredMessage
   * @return encrypted SaleToPOISecuredMessage
   * @throws Exception if encryption or HMAC generation fails
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
   * Decrypts and validated an encrypted SaleToPOI secured message.
   *
   * @param saleToPoiSecuredMessage the message to decrypt
   * @return the decrypted SaleToPOI message as a JSON string
   * @throws Exception if decryption or HMAC validation fails
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
   * Validates the Security Key to ensure all required fields are present.
   *
   * @param securityKey the security key to validate
   * @throws NexoCryptoException if any required field is null or empty
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
   * Lazily initializes and returns the NexoDerivedKey.
   *
   * @return the derived key material
   * @throws GeneralSecurityException if key derivation fails
   */
  NexoDerivedKey getNexoDerivedKey() throws GeneralSecurityException {
    if (nexoDerivedKey == null) {
      synchronized (NexoCrypto.class) {
        if (nexoDerivedKey == null) {
          byte[] salt = generateRandomSalt();
          nexoDerivedKey = NexoDerivedKeyGenerator.deriveKeyMaterial(securityKey.getPassphrase(), salt);
        }
      }
    }

    return nexoDerivedKey;
  }

  /**
   * Generates a new random salt for key derivation.
   *
   * @return a byte array containing a securely generated salt
   */
  private static byte[] generateRandomSalt() {
    byte[] salt = new byte[16]; // 128-bit salt
    new SecureRandom().nextBytes(salt);
    return salt;
  }

  /**
   * Performs AES/CBC encryption or decryption based on the mode.
   *
   * @param bytes   the input data (plaintext or ciphertext)
   * @param dk      the derived key containing the cipher key and IV base
   * @param ivNonce a random IV nonce used to compute the final IV
   * @param mode    {@link Cipher#ENCRYPT_MODE} or {@link Cipher#DECRYPT_MODE}
   * @return the resulting ciphertext or plaintext
   * @throws NoSuchAlgorithmException           if the AES algorithm is not available
   * @throws NoSuchPaddingException             if the specified padding scheme is not available
   * @throws IllegalBlockSizeException          if the data is not a multiple of the block size
   * @throws BadPaddingException                if the padding is incorrect (e.g., during decryption)
   * @throws InvalidKeyException                if the derived cipher key is invalid
   * @throws InvalidAlgorithmParameterException if the computed IV is invalid
   */
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

  /**
   * Computes a HMAC-SHA256 over the given data using the derived key.
   *
   * @param bytes       the input data to authenticate
   * @param derivedKey  the key to use for HMAC generation
   * @return the computed HMAC
   * @throws NoSuchAlgorithmException if HMAC algorithm is unavailable
   * @throws InvalidKeyException      if the key is invalid
   */
  private byte[] hmac(byte[] bytes, NexoDerivedKey derivedKey)
      throws NoSuchAlgorithmException, InvalidKeyException {
    Mac mac = Mac.getInstance("HmacSHA256");
    SecretKeySpec s = new SecretKeySpec(derivedKey.getHmacKey(), "HmacSHA256");

    mac.init(s);
    return mac.doFinal(bytes);
  }

  /**
   * Validates the received HMAC against a newly computed one to ensure integrity.
   *
   * @param receivedHmac       the HMAC received with the message
   * @param decryptedMessage   the decrypted message to verify
   * @param derivedKey         the shared derived key used for HMAC
   * @throws NexoCryptoException     if the computed and received HMACs do not match
   * @throws NoSuchAlgorithmException if the HMAC algorithm (HmacSHA256) is not available
   * @throws InvalidKeyException      if the derived HMAC key is invalid
   */
  private void validateHmac(byte[] receivedHmac, byte[] decryptedMessage, NexoDerivedKey derivedKey)
      throws NexoCryptoException, InvalidKeyException, NoSuchAlgorithmException {
    byte[] hmac = hmac(decryptedMessage, derivedKey);
    boolean valid = MessageDigest.isEqual(hmac, receivedHmac);

    if (!valid) {
      throw new NexoCryptoException("HMAC validation failed");
    }
  }

  /**
   * Generates a cryptographically secure random IV nonce for use in AES encryption.
   *
   * @return a random nonce of length {@code NEXO_IV_LENGTH}
   */
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
