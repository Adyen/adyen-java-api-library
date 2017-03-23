package com.adyen.Util;

import com.adyen.model.Amount;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

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
