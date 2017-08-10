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

        String BOLETO_BARCODE_REFERENCE = "boletobancario.barCodeReference";
        String BOLETO_DATA = "boletobancario.data";
        String BOLETO_DUE_DATE = "boletobancario.dueDate";
        String BOLETO_URL = "boletobancario.url";
        String BOLETO_EXPIRATION_DATE = "boletobancario.expirationDate";


        interface Card {
            interface Encrypted {
                String JSON = "card.encrypted.json";
            }
        }
    }

    interface SelectedBrand {
        String BOLETO_SANTANDER = "boletobancario_santander";
    }
}
