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

/**
 * Utility class for parsing date strings into java.util.Date objects using specified formats.
 */
public final class DateUtil {

    // Private constructor to prevent instantiation
    private DateUtil() {
    }

    /**
     * Parses a date string using the given date format.
     * Returns {@code null} if the input is {@code null} or parsing fails.
     *
     * @param dateString the date string to parse
     * @param format     the format pattern to use for parsing (e.g., {@code "yyyy-MM-dd"})
     * @return the parsed Date, or {@code null} if parsing fails
     */
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

    /**
     * Parses a date string in {@code yyyy-MM-dd} format.
     * Returns {@code null} if the input is {@code null} or parsing fails.
     *
     * @param dateString the date string to parse
     * @return the parsed {@link Date}, or {@code null} if parsing fails
     */
    public static Date parseYmdDate(String dateString) {
        return parseDateToFormat(dateString, "yyyy-MM-dd");
    }

    /**
     * Parses a date string in {@code M/yyyy} format.
     * Returns {@code null} if the input is {@code null} or parsing fails.
     *
     * @param dateString the date string to parse
     * @return the parsed {@link Date}, or {@code null} if parsing fails
     */
    public static Date parseMYDate(String dateString) {
        return parseDateToFormat(dateString, "M/yyyy");
    }
}
