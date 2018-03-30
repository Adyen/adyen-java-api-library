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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.constants;

public interface ErrorTypeCodes {
    Integer FIELD_MISSING = 1;
    Integer EMAIL_INVALID = 2;
    Integer COUNTRY_INVALID = 3;
    Integer CONTAINS_NUMBERS = 4;
    Integer WEB_ADDRESS_INVALID = 5;
    Integer INVALID_DATE_FORMAT = 6;
    Integer DATE_OUT_OF_RANGE = 7;
    Integer BANK_DETAILS_INVALID = 8;
    Integer POSTAL_CODE_INVALID = 9;
    Integer STATE_CODE_INVALID = 10;
    Integer STATE_CODE_UNKNOWN = 11;
    Integer PHONE_NUMBER_OBJECT = 12;
    Integer PHONE_NUMBER_INVALID = 13;
    Integer PHONE_NUMBER_TOO_SHORT = 14;
    Integer COUNTRY_NOT_SUPPORTED = 15;
    Integer INVALID_CURRENCY = 16;
    Integer IBAN_AND_ACCOUNT_NUMBER = 17;
    Integer BANK_CODE_UNKNOWN = 18;
    Integer TIER_NUMBER_INVALID = 19;
    Integer FORBIDDEN_FIELD = 20;
    Integer INVALID_ACCOUNT_DESCRIPTION = 21;
}
