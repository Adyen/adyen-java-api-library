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
import com.google.gson.Gson;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.TreeMap;




public final class Util {
    private Util() {
    }

    /**
     * Joins a list of items to a single string using "glue" as separator
     * If the item is null, it will add as empty
     *
     * @param glue separator
     * @param list list of elements to be joined
     * @param <T> type of elements
     * @return final string after concatenation
     */
    public static <T> String implode(String glue, List<T> list) {
        // list is empty, return empty string
        if (list == null || list.isEmpty()) {
            return "";
        }

        // init the builder
        StringBuilder sb = new StringBuilder();
        boolean addGlue = false;
        // concat each element
        for (T item : list) {
            if (addGlue) {
                sb.append(glue);
            } else {
                addGlue = true;
            }
            if (item != null) {
                sb.append(item);
            }
        }

        // return result
        return sb.toString();
    }


    /**
     * Returns an Amount struct to use on requests
     *
     * @param amount Defines the amount
     * @param currency Defines the amount currency
     * @return amount
     */
    public static Amount createAmount(String amount, String currency) {
        return createAmount(new BigDecimal(amount), currency);
    }

    /**
     * Returns an Amount struct to use on requests
     *
     * @param amount Defines the amount
     * @param currency Defines the amount currency
     * @return amount
     */
    public static Amount createAmount(BigDecimal amount, String currency) {
        Amount amountData = new Amount();
        amountData.setCurrency(currency);

        int scale = getDecimalPlaces(currency);
        Long amountValue = BigDecimal.TEN.pow(scale).multiply(amount.setScale(scale, RoundingMode.HALF_UP)).longValue();

        amountData.setValue(amountValue);

        return amountData;
    }

    public static int getDecimalPlaces(String currency) {
        switch (currency) {
            case "CVE":
            case "DJF":
            case "GNF":
            case "IDR":
            case "JPY":
            case "KMF":
            case "KRW":
            case "PYG":
            case "RWF":
            case "UGX":
            case "VND":
            case "VUV":
            case "XAF":
            case "XOF":
            case "XPF":
                return 0;
            case "BHD":
            case "IQD":
            case "JOD":
            case "KWD":
            case "LYD":
            case "OMR":
            case "TND":
                return 3;
            default:
                return 2;
        }
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     * @param o string
     * @return string target "\n" replacement with "\n    "
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

        DateFormat fmt = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX", Locale.ENGLISH);
        fmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        return fmt.format(sessionDate);
    }

    /**
     * Recursive helper function to convert nested JSONObject-like string to a nested TreeMap to allow deterministic comparison after casting to string.
     * @param input Nested JSONObject-like string to be converted.
     * @return Converted nested TreeMap.
     */
     public static Object jsonObjectStringToTreeMap(String input) {
         if (input.charAt(0) != '{') {
             return input;
         }
         Gson gson = new Gson();
         TreeMap<String, Object> map = gson.fromJson(input, TreeMap.class);
         for (String key : map.keySet()) {
             map.replace(key, jsonObjectStringToTreeMap(map.get(key).toString()));
         }
         return map;
     }
}
