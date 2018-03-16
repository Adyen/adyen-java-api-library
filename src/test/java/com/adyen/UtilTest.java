package com.adyen;

import static com.adyen.constants.HPPConstants.Fields.CURRENCY_CODE;
import static com.adyen.constants.HPPConstants.Fields.MERCHANT_ACCOUNT;
import static org.junit.Assert.assertEquals;

import com.adyen.Util.HMACValidator;
import com.adyen.Util.Util;
import com.adyen.model.Amount;
import java.math.BigDecimal;
import java.security.SignatureException;
import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;
import org.junit.Test;

/**
 * Tests for Util class
 */
public class UtilTest {
    @Test
    public void testAmountDecimals() {
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(new Long("1000"));

        assertEquals(0, new BigDecimal("10.00").compareTo(amount.getDecimalValue()));
    }

    @Test
    public void testCreateAmount() {
        Amount amount = Util.createAmount("12.345234", "EUR");
        Amount amountJPY = Util.createAmount("1234", "JPY");
        Amount amountMRO = Util.createAmount("123.45234", "MRO");
        Amount amountBHD = Util.createAmount("1.2345234", "BHD");

        assertEquals(new Long("1235"), amount.getValue());
        assertEquals(new Long("1234"), amountJPY.getValue());
        assertEquals(new Long("1235"), amountMRO.getValue());
        assertEquals(new Long("1235"), amountBHD.getValue());
    }

    @Test
    public void testGetDataToSign() {
        SortedMap<String, String> postParameters;

        postParameters = new TreeMap<>();
        postParameters.put(MERCHANT_ACCOUNT, "ACC");
        postParameters.put(CURRENCY_CODE, "EUR");

        HMACValidator hmacValidator = new HMACValidator();
        String dataToSign = hmacValidator.getDataToSign(postParameters);
        assertEquals("currencyCode:merchantAccount:EUR:ACC", dataToSign);

        //Test escaping and sorting
        postParameters = new TreeMap<>();
        postParameters.put(CURRENCY_CODE, "EUR");
        postParameters.put(MERCHANT_ACCOUNT, "ACC:\\'");

        dataToSign = hmacValidator.getDataToSign(postParameters);
        assertEquals("currencyCode:merchantAccount:EUR:ACC\\:\\\\'", dataToSign);
    }

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
        String ecnrypted = hmacValidator.calculateHMAC(data, key);
        assertEquals("34oR8T1whkQWTv9P+SzKyp8zhusf9n0dpqrm9nsqSJs=", ecnrypted);
    }
}
