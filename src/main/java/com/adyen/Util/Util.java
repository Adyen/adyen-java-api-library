package com.adyen.Util;

import com.adyen.model.Amount;
import com.google.common.io.BaseEncoding;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.security.SignatureException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Util {
    private final static String HMAC_SHA256_ALGORITHM = "HmacSHA256";
    private final static Charset C_UTF8 = Charset.forName("UTF8");

    public static <T> String implode(String glue, List<T> list) {
        // list is empty, return empty string
        if (list == null || list.isEmpty()) {
            return "";
        }

        Iterator<T> iter = list.iterator();

        // init the builder with the first element
        StringBuilder sb = new StringBuilder();
        sb.append(iter.next());

        // concat each element
        while (iter.hasNext()) {
            sb.append(glue).append(iter.next());
        }

        // return result
        return sb.toString();
    }

    /**
     * Returns an Amount struct to use on requests
     *
     * @param amount
     * @param currency
     * @return
     */
    public static Amount createAmount(String amount, String currency) {
        Amount amountData = new Amount();
        amountData.setCurrency(currency);
        Long amountValue;

        //Adding decimal point depending on the currency
        amountValue = new BigDecimal(10)
                .pow(getDecimalPlaces(currency))
                .multiply(new BigDecimal(amount))
                .longValue();

        amountData.setValue(amountValue);

        return amountData;
    }

    public static int getDecimalPlaces(String currency) {
        switch (currency) {
            case "EUR":
            default:
                return 2;
        }
    }

    // To calculate the HMAC SHA-256
    public static String calculateHMAC(String data, String key) throws java.security.SignatureException {
        try {
            byte[] rawKey = BaseEncoding.base16().decode(key);
            // Create an hmac_sha256 key from the raw key bytes
            SecretKeySpec signingKey = new SecretKeySpec(rawKey, HMAC_SHA256_ALGORITHM);

            // Get an hmac_sha256 Mac instance and initialize with the signing
            // key
            Mac mac = Mac.getInstance(HMAC_SHA256_ALGORITHM);

            mac.init(signingKey);

            // Compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(data.getBytes(C_UTF8));

            // Base64-encode the hmac
            return BaseEncoding.base64().encode(rawHmac);

        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
    }

    private static String escapeVal(String val) {
        if (val == null) {
            return "";
        }
        return val.replace("\\", "\\\\").replace(":", "\\:");
    }

    public static String getDataToSign(SortedMap<String, String> postParameters) {
        String signedData = Stream.concat(postParameters.keySet().stream(), postParameters.values().stream())
                .map(Util::escapeVal)
                .collect(Collectors.joining(":"));

        return signedData;
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    public static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    public static String calculateSessionValidity() {
        Calendar calendar = Calendar.getInstance();
        //+1 day
        calendar.add(Calendar.DATE, 1);
        Date sessionDate = calendar.getTime();

        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX").format(sessionDate);
    }
}
