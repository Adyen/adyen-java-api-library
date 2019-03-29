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
package com.adyen.constants;

/**
 * Constants used in the API
 */
public interface ApiConstants {
    interface RefusalReason {
        String TRANSACTION_NOT_PERMITTED = "Transaction Not Permitted";
        String CVC_DECLINED = "CVC Declined";
        String RESTRICTED_CARD = "Restricted Card";
        String PAYMENT_DETAIL_NOT_FOUND = "803 PaymentDetail not found";
        String REFUSED = "Refused";
    }

    interface AdditionalData {
        String REFUSAL_REASON_RAW = "refusalReasonRaw";
        String PAYMENT_METHOD = "paymentMethod";
        String EXPIRY_DATE = "expiryDate";
        String CARD_BIN = "cardBin";
        String CARD_HOLDER_NAME = "cardHolderName";
        String CARD_SUMMARY = "cardSummary";
        String THREE_D_OFFERERED = "threeDOffered";
        String THREE_D_AUTHENTICATED = "threeDAuthenticated";
        String AVS_RESULT = "avsResult";
        String PAYMENT_TOKEN = "payment.token";
        String FRAUD_RESULT_TYPE = "fraudResultType";
        String FRAUD_MANUAL_REVIEW = "fraudManualReview";
        String AUTH_CODE = "authCode";

        String BOLETO_BARCODE_REFERENCE = "boletobancario.barCodeReference";
        String BOLETO_DATA = "boletobancario.data";
        String BOLETO_DUE_DATE = "boletobancario.dueDate";
        String BOLETO_URL = "boletobancario.url";
        String BOLETO_EXPIRATION_DATE = "boletobancario.expirationDate";

        String ENCRYPTED_CARD_NUMBER = "encryptedCardNumber";
        String ENCRYPTED_EXPIRY_MONTH = "encryptedExpiryMonth";
        String ENCRYPTED_EXPIRY_YEAR = "encryptedExpiryYear";
        String ENCRYPTED_SECURITY_CODE = "encryptedSecurityCode";

        String HMAC_SIGNATURE = "hmacSignature";

        interface Card {
            interface Encrypted {
                String JSON = "card.encrypted.json";
            }
        }
    }

    interface SelectedBrand {
        String BOLETO_SANTANDER = "boletobancario_santander";
    }

    interface PaymentMethod {

        String NUMBER = "number";
        String EXPIRY_MONTH = "expiryMonth";
        String EXPIRY_YEAR = "expiryYear";
        String CVC = "cvc";
        String ENCRYPTED_CARD_NUMBER = "encryptedCardNumber";
        String ENCRYPTED_EXPIRY_MONTH = "encryptedExpiryMonth";
        String ENCRYPTED_EXPIRY_YEAR = "encryptedExpiryYear";
        String ENCRYPTED_SECURITY_CODE = "encryptedSecurityCode";
        String METHOD_TYPE = "type";
        String HOLDER_NAME = "holderName";
        String RECURRING_DETAIL_REFERENCE = "recurringDetailReference";
        String STORE_DETAILS = "storeDetails";
    }

    interface Redirect {
        interface Data {
            String MD = "MD";
            String PAREQ = "PaReq";
        }
    }

    interface PaymentMethodType {
        String TYPE_SCHEME = "scheme";
        String TYPE_SEPA_DIRECT_DEBIT ="sepadirectdebit";
    }

    interface RequestProperty {
        String IDEMPOTENCY_KEY = "Idempotency-Key";
        String ACCEPT_CHARSET = "Accept-Charset";
        String USER_AGENT = "User-Agent";
        String METHOD_POST = "POST";
        String CONTENT_TYPE = "Content-Type";
        String API_KEY = "x-api-key";
        String APPLICATION_JSON_TYPE = "application/json";
    }
}
