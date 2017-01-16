package com.adyen.Util;

import com.adyen.model.Amount;

import java.math.BigDecimal;
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
        switch (currency) {
            case "EUR":
            default:
                amountValue = new BigDecimal(100)
                        .multiply(new BigDecimal(amount))
                        .longValue();
                break;
        }

        amountData.setValue(amountValue);

        return amountData;
    }

}
