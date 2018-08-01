/**
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
package com.adyen.constants;

/**
 * Constants used in HPP
 */
public interface HPPConstants {
    interface Fields {
        String MERCHANT_REFERENCE = "merchantReference";
        String PAYMENT_AMOUNT = "paymentAmount";
        String CURRENCY_CODE = "currencyCode";
        String SHIP_BEFORE_DATE = "shipBeforeDate";
        String SKIN_CODE = "skinCode";
        String MERCHANT_ACCOUNT = "merchantAccount";
        String SESSION_VALIDITY = "sessionValidity";
        String MERCHANT_SIG = "merchantSig";
        String COUNTRY_CODE = "countryCode";
        String BRAND_CODE = "brandCode";
        String ISSUER_ID = "issuerId";
        String RES_URL = "resURL";
    }
    interface Response {
        String AUTH_RESULT = "authResult";
        String MERCHANT_REFERENCE = "merchantReference";
        String MERCHANT_SIG = "merchantSig";
        String PAYMENT_METHOD = "paymentMethod";
        String PSP_REFERENCE = "pspReference";
        String SHOPPER_LOCALE = "shopperLocale";
        String SKIN_CODE = "skinCode";
        String MERCHANT_RETURN_DATA = "merchantReturnData";

        /*
         authResult Returns the outcome of the payment.
         It can take one of the following values:
         AUTHORISED: the payment authorisation was successfully completed
         REFUSED: the payment was refused. Payment authorisation was unsuccessful.
         CANCELLED: the payment was cancelled by the shopper before completion, or the shopper returned to the merchant's site before completing the transaction.
         PENDING: it is not possible to obtain the final status of the payment.
         This can happen if the systems providing final status information for the payment are unavailable, or if the shopper needs to take further action to complete the payment.
         ERROR: an error occurred during the payment processing.
         */
        String AUTH_RESULT_AUTHORISED = "AUTHORISED";
        String AUTH_RESULT_REFUSED = "REFUSED";
        String AUTH_RESULT_CANCELLED = "CANCELLED";
        String AUTH_RESULT_PENDING = "PENDING";
        String AUTH_RESULT_ERROR = "ERROR";
    }
}
