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

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.HashSet;
import java.util.Set;



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

    private static final Set<String> ZERO_DECIMAL_CURRENCIES = new HashSet<>();
    private static final Set<String> THREE_DECIMAL_CURRENCIES = new HashSet<>();

    static {
        ZERO_DECIMAL_CURRENCIES.add("CVE");
        ZERO_DECIMAL_CURRENCIES.add("DJF");
        ZERO_DECIMAL_CURRENCIES.add("GNF");
        ZERO_DECIMAL_CURRENCIES.add("IDR");
        ZERO_DECIMAL_CURRENCIES.add("JPY");
        ZERO_DECIMAL_CURRENCIES.add("KMF");
        ZERO_DECIMAL_CURRENCIES.add("KRW");
        ZERO_DECIMAL_CURRENCIES.add("PYG");
        ZERO_DECIMAL_CURRENCIES.add("RWF");
        ZERO_DECIMAL_CURRENCIES.add("UGX");
        ZERO_DECIMAL_CURRENCIES.add("VND");
        ZERO_DECIMAL_CURRENCIES.add("VUV");
        ZERO_DECIMAL_CURRENCIES.add("XAF");
        ZERO_DECIMAL_CURRENCIES.add("XOF");
        ZERO_DECIMAL_CURRENCIES.add("XPF");

        THREE_DECIMAL_CURRENCIES.add("BHD");
        THREE_DECIMAL_CURRENCIES.add("IQD");
        THREE_DECIMAL_CURRENCIES.add("JOD");
        THREE_DECIMAL_CURRENCIES.add("KWD");
        THREE_DECIMAL_CURRENCIES.add("LYD");
        THREE_DECIMAL_CURRENCIES.add("OMR");
        THREE_DECIMAL_CURRENCIES.add("TND");
    }

    public static int getDecimalPlaces(String currency) {
        if (ZERO_DECIMAL_CURRENCIES.contains(currency)) {
            return 0;
        }
        if (THREE_DECIMAL_CURRENCIES.contains(currency)) {
            return 3;
        }
        return 2;
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
}
