package com.adyen.constants;

/**
 * Constants used in the API
 */
public interface ApiConstants {
    interface AdditionalData {
        String REFUSAL_REASON_RAW = "refusalReasonRaw";

        interface Card {
            interface Encrypted {
                String JSON = "card.encrypted.json";
            }
        }
    }
}
