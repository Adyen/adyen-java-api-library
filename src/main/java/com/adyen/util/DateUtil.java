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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public final class DateUtil {
    private DateUtil() {
    }

    public static Date parseDateToFormat(String dateString, String format) {
        if (dateString == null) {
            return null;
        }

        SimpleDateFormat fmt = new SimpleDateFormat(format, Locale.ENGLISH);
        fmt.setTimeZone(TimeZone.getTimeZone("GMT"));

        try {
            return fmt.parse(dateString);
        } catch (ParseException ignored) {
        }

        return null;
    }

    public static Date parseYmdDate(String dateString) {
        return parseDateToFormat(dateString, "yyyy-MM-dd");
    }

    public static Date parseMYDate(String dateString) {
        return parseDateToFormat(dateString, "M/yyyy");
    }
}
