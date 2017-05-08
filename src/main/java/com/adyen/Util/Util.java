package com.adyen.Util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import com.adyen.model.Amount;

public class Util {
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
        return createAmount(new BigDecimal(amount), currency);
    }

    /**
     * Returns an Amount struct to use on requests
     *
     * @param amount
     * @param currency
     * @return
     */
    public static Amount createAmount(BigDecimal amount, String currency) {
        Amount amountData = new Amount();
        amountData.setCurrency(currency);
        Long amountValue;

        Integer scale = getDecimalPlaces(currency);
        amountValue = new BigDecimal(10)
                .pow(scale)
                .multiply(amount.setScale(scale, RoundingMode.HALF_UP))
                .longValue();

        amountData.setValue(amountValue);

        return amountData;
    }

    public static int getDecimalPlaces(String currency) {
        switch (currency) {
            case "JPY":
            case "IDR":
            case "KRW":
            case "BYR":
            case "VND":
            case "CVE":
            case "DJF":
            case "GNF":
            case "PYG":
            case "RWF":
            case "UGX":
            case "VUV":
            case "XAF":
            case "XOF":
            case "XPF":
            case "GHC":
            case "KMF":
                return 0;
            case "MRO":
                return 1;
            case "BHD":
            case "JOD":
            case "KWD":
            case "OMR":
            case "LYD":
            case "TND":
                return 3;
            default:
                return 2;
        }
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
