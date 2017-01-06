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

        interface Card {
            interface Encrypted {
                String JSON = "card.encrypted.json";
            }
        }
    }
}
