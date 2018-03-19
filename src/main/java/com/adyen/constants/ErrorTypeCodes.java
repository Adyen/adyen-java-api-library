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
    Integer EMAIL_ADDRESS_INVALID = 2;
    Integer COUNTRY_CODE_INVALID = 3;
    Integer ILLEGAL_CHARACTERS = 4;
    Integer URL_INVALID = 5;
    Integer DATE_FORMAT_INVALID = 6;
    Integer DATE_RANGE_INVALID = 7;
    Integer BANK_DETAILS_INVALID = 8;
    Integer POSTAL_CODE_INVALID = 9;
    Integer PHONENUMBER_REDUNDANT = 12;
    Integer FULLPHONENUMBER_INVALID = 13;
    Integer PHONENUMBER_INVALID = 14;
    Integer COUNTRY_NOT_SUPPORTED = 15;
    Integer CURRENCY_INVALID = 16;
    Integer IBAN_ACCOUNTNUMBER_BRANCHCODE_BANKCODE_REDUNDANT = 17;
}
