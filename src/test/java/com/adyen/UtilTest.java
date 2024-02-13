package com.adyen;

import com.adyen.model.notification.Amount;
import com.adyen.model.notification.NotificationRequestItem;
import com.adyen.util.HMACValidator;
import com.adyen.util.Util;
import org.junit.Test;

import java.math.BigDecimal;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

import static com.adyen.constants.ApiConstants.AdditionalData.HMAC_SIGNATURE;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Tests for Util class
 */
public class UtilTest {
    @Test
    public void testImplode() {
        List<String> data = new ArrayList<>();
        data.add(null);
        data.add(null);
        data.add("NL");
        data.add(null);
        data.add("reference");
        data.add(null);
        data.add("merchantAccount");

        String dataToSign = Util.implode(":", data);
        assertEquals("::NL::reference::merchantAccount", dataToSign);
    }

    @Test
    public void testHmac() throws SignatureException {
        String data = "countryCode:currencyCode:merchantAccount:merchantReference:paymentAmount:sessionValidity:skinCode:NL:EUR:MagentoMerchantTest2:TEST-PAYMENT-2017-02-01-14\\:02\\:05:199:2017-02-02T14\\:02\\:05+01\\:00:PKz2KML1";
        String key = "DFB1EB5485895CFA84146406857104ABB4CBCABDC8AAF103A624C8F6A3EAAB00";
        HMACValidator hmacValidator = new HMACValidator();
        String encrypted = hmacValidator.calculateHMAC(data, key);
        assertEquals("34oR8T1whkQWTv9P+SzKyp8zhusf9n0dpqrm9nsqSJs=", encrypted);
    }

    @Test
    public void testNotificationHmac() throws SignatureException {
        NotificationRequestItem notificationRequestItem = new NotificationRequestItem();
        notificationRequestItem.setPspReference("pspReference");
        notificationRequestItem.setOriginalReference("originalReference");
        notificationRequestItem.setMerchantAccountCode("merchantAccount");
        notificationRequestItem.setMerchantReference("reference");
        notificationRequestItem.setAmount(new Amount().currency("EUR").value(1000l));
        notificationRequestItem.setEventCode("EVENT");
        notificationRequestItem.setSuccess(true);

        String expectedSign = "ipnxGCaUZ4l8TUW75a71/ghd2Fe5ffvX0pV4TLTntIc=";
        Map<String, String> additionalData = new HashMap<>();
        notificationRequestItem.setAdditionalData(additionalData);
        additionalData.put(HMAC_SIGNATURE, expectedSign);

        HMACValidator hmacValidator = new HMACValidator();
        String data = hmacValidator.getDataToSign(notificationRequestItem);
        assertEquals("pspReference:originalReference:merchantAccount:reference:1000:EUR:EVENT:true", data);

        String key = "DFB1EB5485895CFA84146406857104ABB4CBCABDC8AAF103A624C8F6A3EAAB00";
        String encrypted = hmacValidator.calculateHMAC(notificationRequestItem, key);
        assertEquals(expectedSign, encrypted);
        assertTrue(hmacValidator.validateHMAC(notificationRequestItem, key));

        additionalData.put(HMAC_SIGNATURE, "notValidSign");
        assertFalse(hmacValidator.validateHMAC(notificationRequestItem, key));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testValidateHMACException() throws SignatureException {
        NotificationRequestItem notificationRequestItem = new NotificationRequestItem();
        HMACValidator hmacValidator = new HMACValidator();
        String key = "DFB1EB5485895CFA84146406857104ABB4CBCABDC8AAF103A624C8F6A3EAAB00";
        hmacValidator.validateHMAC(notificationRequestItem, key);
    }

    @Test
    public void testValidateHMACWithEmptyHmacException() throws SignatureException {
        NotificationRequestItem notificationRequestItem = new NotificationRequestItem();
        Map<String, String> additionalData = new HashMap<>();
        additionalData.put(HMAC_SIGNATURE, "");
        notificationRequestItem.setAdditionalData(additionalData);
        HMACValidator hmacValidator = new HMACValidator();
        String key = "DFB1EB5485895CFA84146406857104ABB4CBCABDC8AAF103A624C8F6A3EAAB00";
        try {
            hmacValidator.validateHMAC(notificationRequestItem, key);
        } catch (IllegalArgumentException e) {
            assertEquals("Missing hmacSignature", e.getMessage());
        }
    }
}
