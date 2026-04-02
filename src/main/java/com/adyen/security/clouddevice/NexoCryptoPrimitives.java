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

import static com.adyen.model.clouddevice.security.NexoDerivedKey.NEXO_IV_LENGTH;

import com.adyen.model.clouddevice.security.NexoDerivedKey;
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

/** Low-level AES/HMAC primitives shared by Nexo crypto implementations. */
final class NexoCryptoPrimitives {

  private NexoCryptoPrimitives() {}

  /** Performs AES-256-CBC encryption or decryption using the derived key and provided IV nonce. */
  static byte[] crypt(byte[] bytes, NexoDerivedKey dk, byte[] ivNonce, int mode)
      throws NoSuchAlgorithmException,
          NoSuchPaddingException,
          IllegalBlockSizeException,
          BadPaddingException,
          InvalidKeyException,
          InvalidAlgorithmParameterException {

    Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
    SecretKeySpec secretKeySpec = new SecretKeySpec(dk.getCipherKey(), "AES");

    byte[] iv = dk.getIv();
    byte[] actualIV = new byte[NEXO_IV_LENGTH];
    for (int i = 0; i < NEXO_IV_LENGTH; i++) {
      actualIV[i] = (byte) (iv[i] ^ ivNonce[i]);
    }

    IvParameterSpec ivParameterSpec = new IvParameterSpec(actualIV);
    cipher.init(mode, secretKeySpec, ivParameterSpec);
    return cipher.doFinal(bytes);
  }

  /** Generates an HMAC-SHA256 for message authentication. */
  static byte[] hmac(byte[] bytes, NexoDerivedKey derivedKey)
      throws NoSuchAlgorithmException, InvalidKeyException {
    Mac mac = Mac.getInstance("HmacSHA256");
    mac.init(new SecretKeySpec(derivedKey.getHmacKey(), "HmacSHA256"));
    return mac.doFinal(bytes);
  }

  /** Validates the HMAC of a decrypted message to ensure data integrity. */
  static void validateHmac(byte[] receivedHmac, byte[] decryptedMessage, NexoDerivedKey derivedKey)
      throws NexoSecurityException, InvalidKeyException, NoSuchAlgorithmException {
    if (!MessageDigest.isEqual(hmac(decryptedMessage, derivedKey), receivedHmac)) {
      throw new NexoSecurityException("HMAC validation failed");
    }
  }

  /** Generates a cryptographically random IV nonce. */
  static byte[] generateRandomIvNonce() {
    byte[] ivNonce = new byte[NEXO_IV_LENGTH];
    SecureRandom secureRandom;
    try {
      secureRandom = SecureRandom.getInstance("NativePRNGNonBlocking");
    } catch (NoSuchAlgorithmException ignored) {
      secureRandom = new SecureRandom();
    }
    secureRandom.nextBytes(ivNonce);
    return ivNonce;
  }
}
