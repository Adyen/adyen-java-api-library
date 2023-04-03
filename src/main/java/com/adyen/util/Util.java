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

        // return result
        return sb.toString();
    }

    public static int getDecimalPlaces(String currencyCode) {
            Currency currency;
            switch (currencyCode) {
                case "CVE":
                    currency = new CveCurrency();
                    break;
                case "DJF":
                    currency = new DjfCurrency();
                    break;
                case "GNF":
                    currency = new GnfCurrency();
                    break;
                case "IDR":
                    currency = new IdrCurrency();
                    break;
                case "JPY":
                    currency = new JpyCurrency();
                    break;
                case "KMF":
                    currency = new KmfCurrency();
                    break;
                case "KRW":
                    currency = new KrwCurrency();
                    break;
                case "PYG":
                    currency = new PygCurrency();
                    break;
                case "RWF":
                    currency = new RwfCurrency();
                    break;
                case "UGX":
                    currency = new UgxCurrency();
                    break;
                case "VND":
                    currency = new VndCurrency();
                    break;
                case "VUV":
                    currency = new VuvCurrency();
                    break;
                case "XAF":
                    currency = new XafCurrency();
                    break;
                case "XOF":
                    currency = new XofCurrency();
                    break;
                case "XPF":
                    currency = new XpfCurrency();
                    break;
                case "BHD":
                    currency = new BhdCurrency();
                    break;
                case "IQD":
                    currency = new IqdCurrency();
                    break;
                case "JOD":
                    currency = new JodCurrency();
                    break;
                case "KWD":
                    currency = new KwdCurrency();
                    break;
                case "LYD":
                    currency = new LydCurrency();
                    break;
                case "OMR":
                    currency = new OmrCurrency();
                    break;
                case "TND":
                    currency = new TndCurrency();
                    break;

                default:
                    currency = new TwoDecimalCurrency();
                    break;
            }
            return currency.getDecimalPlaces();
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

