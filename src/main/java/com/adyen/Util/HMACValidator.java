/**
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
package com.adyen.Util;

import static com.adyen.constants.ApiConstants.AdditionalData.HMAC_SIGNATURE;

import com.adyen.model.Amount;
import com.adyen.model.notification.NotificationRequestItem;
import java.nio.charset.Charset;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;

public class HMACValidator {
    public final static String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    public final static Charset C_UTF8 = Charset.forName("UTF8");
    public static final String DATA_SEPARATOR = ":";

    // To calculate the HMAC SHA-256
    public String calculateHMAC(String data, String key) throws java.security.SignatureException {
        try {
            byte[] rawKey = Hex.decodeHex(key.toCharArray());
            // Create an hmac_sha256 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(rawKey, HMAC_SHA256_ALGORITHM);

            // Get an hmac_sha256 Mac instance and initialize with the signing
            // key
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);

            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes(C_UTF8));

            // Base64-encode the hmac
            return new String(Base64.encodeBase64(rawHmac));

        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
    }

    // To calculate the HMAC SHA-256
    public String calculateHMAC(NotificationRequestItem notificationRequestItem, String key)
      throws SignatureException {
        return calculateHMAC(getDataToSign(notificationRequestItem), key);
    }

    public boolean validateHMAC(NotificationRequestItem notificationRequestItem, String key)
      throws SignatureException {

        final String expectedSign = calculateHMAC(notificationRequestItem, key);
        final String merchantSign = notificationRequestItem.getAdditionalData().get(HMAC_SIGNATURE);

        return expectedSign.equals(merchantSign);
    }

    public String getDataToSign(NotificationRequestItem notificationRequestItem) {
        List<String> signedDataList = new ArrayList<>(8);
        signedDataList.add(notificationRequestItem.getPspReference());
        signedDataList.add(notificationRequestItem.getOriginalReference());
        signedDataList.add(notificationRequestItem.getMerchantAccountCode());
        signedDataList.add(notificationRequestItem.getMerchantReference());

        Amount amount = notificationRequestItem.getAmount();
        signedDataList.add(amount.getValue().toString());
        signedDataList.add(amount.getCurrency());

        signedDataList.add(notificationRequestItem.getEventCode());
        signedDataList.add(String.valueOf(notificationRequestItem.isSuccess()));

        return Util.implode(DATA_SEPARATOR, signedDataList);
    }

    public String getDataToSign(SortedMap<String, String> postParameters) {
        List<String> parts = new ArrayList<>();

        for (String key : postParameters.keySet()) {
            parts.add(escapeVal(key));
        }

        for (String value : postParameters.values()) {
            parts.add(escapeVal(value));
        }

        return Util.implode(DATA_SEPARATOR, parts);
    }

    private String escapeVal(String val) {
        if (val == null) {
            return "";
        }
        return val.replace("\\", "\\\\").replace(":", "\\:");
    }
}
