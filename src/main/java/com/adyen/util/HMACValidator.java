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

import com.adyen.model.Amount;
import com.adyen.model.notification.NotificationRequestItem;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;

import static com.adyen.constants.ApiConstants.AdditionalData.HMAC_SIGNATURE;

public class HMACValidator {
    public static final String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    public static final String DATA_SEPARATOR = ":";

    // To calculate the HMAC SHA-256
    public String calculateHMAC(String data, String key) throws IllegalArgumentException, SignatureException {
        try {
            if (data == null || key == null) {
                throw new IllegalArgumentException();
            }

            byte[] rawKey = Hex.decodeHex(key.toCharArray());
            // Create an hmac_sha256 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(rawKey, HMAC_SHA256_ALGORITHM);

            // Get an hmac_sha256 Mac instance and initialize with the signing
            // key
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);

            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));

            // Base64-encode the hmac
            return new String(Base64.encodeBase64(rawHmac));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Missing data or key.");
        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
    }

    // To calculate the HMAC SHA-256
    public String calculateHMAC(NotificationRequestItem notificationRequestItem, String key) throws IllegalArgumentException, SignatureException {
        return calculateHMAC(getDataToSign(notificationRequestItem), key);
    }

    public boolean validateHMAC(NotificationRequestItem notificationRequestItem, String key) throws IllegalArgumentException, SignatureException {
        if (notificationRequestItem == null) {
            throw new IllegalArgumentException("Missing NotificationRequestItem.");
        }

        if (notificationRequestItem.getAdditionalData() == null
                || notificationRequestItem.getAdditionalData().get(HMAC_SIGNATURE) == null
                || notificationRequestItem.getAdditionalData().get(HMAC_SIGNATURE).isEmpty()) {
            throw new IllegalArgumentException("Missing " + HMAC_SIGNATURE);
        }
        final byte[] merchantSign = (notificationRequestItem.getAdditionalData().get(HMAC_SIGNATURE)).getBytes(StandardCharsets.UTF_8);
        final byte[] expectedSign = (calculateHMAC(notificationRequestItem, key)).getBytes(StandardCharsets.UTF_8);

        return MessageDigest.isEqual(merchantSign, expectedSign);
    }

    public String getDataToSign(NotificationRequestItem notificationRequestItem) throws IllegalArgumentException {
        if (notificationRequestItem == null) {
            throw new IllegalArgumentException("Missing NotificationRequestItem.");
        }

        List<String> signedDataList = new ArrayList<>(8);
        signedDataList.add(notificationRequestItem.getPspReference());
        signedDataList.add(notificationRequestItem.getOriginalReference());
        signedDataList.add(notificationRequestItem.getMerchantAccountCode());
        signedDataList.add(notificationRequestItem.getMerchantReference());

        Amount amount = notificationRequestItem.getAmount();

        //If the amount and value are not null, append them to the payload.
        if (amount != null && amount.getValue() != null) {
            signedDataList.add(amount.getValue().toString());
        } else {
            //Else append a null. Will appear as a empty string in the final payload.
            signedDataList.add(null);
        }

        //If the amount and currency are not null, append them to the payload.
        if (amount != null && amount.getCurrency() != null) {
            signedDataList.add(amount.getCurrency());
        } else {
            //Else append a null. Will appear as a empty string in the final payload.
            signedDataList.add(null);
        }


        signedDataList.add(notificationRequestItem.getEventCode());
        signedDataList.add(String.valueOf(notificationRequestItem.isSuccess()));

        return Util.implode(DATA_SEPARATOR, signedDataList);
    }

    public String getDataToSign(SortedMap<String, String> postParameters) {
        List<String> parts = new ArrayList<>();

        postParameters.keySet().stream().forEach(s -> parts.add(escapeVal(s)));
        postParameters.values().stream().forEach(s -> parts.add(escapeVal(s)));

        return Util.implode(DATA_SEPARATOR, parts);
    }

    private String escapeVal(String val) {
        if (val == null) {
            return "";
        }
        return val.replace("\\", "\\\\").replace(":", "\\:");
    }
}
