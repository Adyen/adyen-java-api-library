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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.util;

import static com.adyen.constants.ApiConstants.AdditionalData.HMAC_SIGNATURE;

import com.adyen.model.notification.Amount;
import com.adyen.model.notification.NotificationRequestItem;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import org.apache.commons.codec.binary.Base64;

/** Utility class for generating and validating HMAC signatures used in Adyen webhooks. */
public class HMACValidator {
  /** The HMAC algorithm used. */
  public static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";

  /** Separator used when joining data for signature calculation. */
  public static final String DATA_SEPARATOR = ":";

  /**
   * Computes the HMAC SHA-256 signature for the given data using the provided hex-encoded HMAC key.
   *
   * @param data the data to sign
   * @param key the HMAC key in hexadecimal format
   * @return the Base64-encoded HMAC signature
   * @throws IllegalArgumentException if the data or key is null
   * @throws SignatureException if signature generation fails
   */
  public String calculateHMAC(String data, String key)
      throws IllegalArgumentException, SignatureException {
    try {
      if (data == null) {
        throw new IllegalArgumentException("payload data is not provided");
      }
      if (key == null) {
        throw new IllegalArgumentException("HMAC key is not provided");
      }

      byte[] rawKey = DatatypeConverter.parseHexBinary(key);
      SecretKeySpec signingKey = new SecretKeySpec(rawKey, HMAC_SHA256_ALGORITHM);

      Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);
      mac.init(signingKey);

      byte[] rawHmac = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
      return new String(Base64.encodeBase64(rawHmac));
    } catch (IllegalArgumentException e) {
      throw new IllegalArgumentException("Missing data or key: " + e.getMessage());
    } catch (Exception e) {
      throw new SignatureException("Failed to generate HMAC: " + e.getMessage());
    }
  }

  /**
   * Computes the HMAC SHA-256 signature for a given NotificationRequestItem.
   *
   * @param notificationRequestItem the notification to sign
   * @param key the HMAC key in hexadecimal format
   * @return the Base64-encoded HMAC signature
   * @throws IllegalArgumentException if the notification item or key is invalid
   * @throws SignatureException if signature generation fails
   */
  public String calculateHMAC(NotificationRequestItem notificationRequestItem, String key)
      throws IllegalArgumentException, SignatureException {
    return calculateHMAC(getDataToSign(notificationRequestItem), key);
  }

  /**
   * Validates an HMAC signature for generic webhooks (e.g. Banking, Management).
   *
   * @param hmacSignature the signature received in the webhook
   * @param hmacKey the configured HMAC key
   * @param payload the payload string used for HMAC calculation
   * @return {@code true} if the signature matches, {@code false} otherwise
   * @throws SignatureException if validation fails
   */
  public boolean validateHMAC(String hmacSignature, String hmacKey, String payload)
      throws SignatureException {
    String calculatedSign = calculateHMAC(payload, hmacKey);
    final byte[] expectedSign = calculatedSign.getBytes(StandardCharsets.UTF_8);
    final byte[] merchantSign = hmacSignature.getBytes(StandardCharsets.UTF_8);
    return MessageDigest.isEqual(expectedSign, merchantSign);
  }

  /**
   * Validates the HMAC signature of an NotificationRequestItem.
   *
   * @param notificationRequestItem the notification containing the HMAC signature
   * @param key the HMAC key in hexadecimal format
   * @return {@code true} if the signature matches, {@code false} otherwise
   * @throws IllegalArgumentException if the notification or signature is missing
   * @throws SignatureException if signature validation fails
   */
  public boolean validateHMAC(NotificationRequestItem notificationRequestItem, String key)
      throws IllegalArgumentException, SignatureException {
    if (notificationRequestItem == null) {
      throw new IllegalArgumentException("Missing NotificationRequestItem.");
    }

    if (notificationRequestItem.getAdditionalData() == null
        || notificationRequestItem.getAdditionalData().get(HMAC_SIGNATURE) == null
        || notificationRequestItem.getAdditionalData().get(HMAC_SIGNATURE).isEmpty()) {
      throw new IllegalArgumentException("Missing " + HMAC_SIGNATURE);
    }

    final byte[] merchantSign =
        notificationRequestItem
            .getAdditionalData()
            .get(HMAC_SIGNATURE)
            .getBytes(StandardCharsets.UTF_8);
    final byte[] expectedSign =
        calculateHMAC(notificationRequestItem, key).getBytes(StandardCharsets.UTF_8);

    return MessageDigest.isEqual(merchantSign, expectedSign);
  }

  /**
   * Builds the concatenated data string from a NotificationRequestItem to be used in HMAC signature
   * calculation.
   *
   * <p>The data string is composed of the following fields, separated by a colon (":"):
   *
   * <ul>
   *   <li>pspReference
   *   <li>originalReference
   *   <li>merchantAccountCode
   *   <li>merchantReference
   *   <li>amount.value
   *   <li>amount.currency
   *   <li>eventCode
   *   <li>success
   * </ul>
   *
   * <p>If any value is {@code null}, it is represented as an empty string in the final payload.
   *
   * @param notificationRequestItem the notification request item
   * @return the colon-separated string of fields
   * @throws IllegalArgumentException if the input is null
   */
  public String getDataToSign(NotificationRequestItem notificationRequestItem)
      throws IllegalArgumentException {
    if (notificationRequestItem == null) {
      throw new IllegalArgumentException("Missing NotificationRequestItem.");
    }

    List<String> signedDataList = new ArrayList<>(8);
    signedDataList.add(notificationRequestItem.getPspReference());
    signedDataList.add(notificationRequestItem.getOriginalReference());
    signedDataList.add(notificationRequestItem.getMerchantAccountCode());
    signedDataList.add(notificationRequestItem.getMerchantReference());

    Amount amount = notificationRequestItem.getAmount();
    signedDataList.add(
        amount != null && amount.getValue() != null ? amount.getValue().toString() : null);
    signedDataList.add(
        amount != null && amount.getCurrency() != null ? amount.getCurrency() : null);

    signedDataList.add(notificationRequestItem.getEventCode());
    signedDataList.add(String.valueOf(notificationRequestItem.isSuccess()));

    return Util.implode(DATA_SEPARATOR, signedDataList);
  }
}
