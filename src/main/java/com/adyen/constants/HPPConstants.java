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

        //Auth results
        String AUTH_RESULT_AUTHORISED = "AUTHORISED";
        String AUTH_RESULT_REFUSED = "REFUSED";
    }
}
