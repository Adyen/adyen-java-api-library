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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.util;

import java.util.Arrays;

public final class MaskUtil {

    private static final char MASK_CHAR = '*';
    private static final int MASK_FIXED_BLOCK_SIZE = 4;
    private static final String MASKED_BLOCK;
    private static final int CARD_NUMBER_UNMASK_LAST_BLOCK_SIZE = 4;

    static {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MASK_FIXED_BLOCK_SIZE; i++) {
            sb.append(MASK_CHAR);
        }
        MASKED_BLOCK = sb.toString();
    }

    private MaskUtil() {
    }

    /**
     * Masks the given string with a fixed size string of mask characters
     * Return an empty string in case input is null or empty
     *
     * @param strToMask string to mask
     * @return masked string
     */
    public static String mask(String strToMask) {
        if (strToMask == null || strToMask.isEmpty()) {
            return "";
        }

        return MASKED_BLOCK;
    }

    /**
     * Masks the given card number
     * Return an empty string in case input is null, empty or has too less digits
     *
     * @param cardNumber card number to mask
     * @return masked card number
     */
    public static String maskCardNumber(String cardNumber) {
        if (cardNumber == null || cardNumber.isEmpty()) {
            return "";
        }

        String cardNumberOnlyDigits = cardNumber.replaceAll("[^\\d]", "");
        if (cardNumberOnlyDigits.length() < CARD_NUMBER_UNMASK_LAST_BLOCK_SIZE) {
            return "";
        }
        char[] maskedChars = cardNumberOnlyDigits.toCharArray();
        Arrays.fill(maskedChars, 0, cardNumberOnlyDigits.length() - CARD_NUMBER_UNMASK_LAST_BLOCK_SIZE, MASK_CHAR);

        return new String(maskedChars);
    }
}
