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

        return sb.toString();
    }


    /**
     * Returns the number of decimal places typically used for a given currency code.
     * For example, JPY returns 0, USD returns 2, and BHD returns 3.
     *
     * @param currency the ISO 4217 currency code
     * @return the number of decimal places used for the currency
     */
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
     * Converts an object to a string and indents every new line by 4 spaces,
     * except the first line. Useful for generating indented logs or formatted output.
     *
     * @param o the object to convert
     * @return the indented string representation of the object; returns "null" if the object is null
     */
    public static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }

        return o.toString().replace("\n", "\n    ");
    }

    /**
     * Calculates a session validity timestamp exactly 24 hours in the future
     * from the current time, formatted as an ISO 8601 string in GMT.
     *
     * @return a string representing the session validity time in the format "yyyy-MM-dd'T'HH:mm:ssXXX"
     */
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
