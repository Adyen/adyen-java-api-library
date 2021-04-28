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

package com.adyen.model.checkout;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * PaymentsResponse
 */
public class PaymentsResponse extends AbstractPaymentsResponse<PaymentsResponse> {

    @SerializedName("action")
    private CheckoutPaymentsAction action;

    /**
     * Action to be taken for completing the payment.
     *
     * @return action
     **/
    public CheckoutPaymentsAction getAction() {
        return action;
    }

    public void setAction(CheckoutPaymentsAction action) {
        this.action = action;
    }

    public PaymentsResponse action(CheckoutPaymentsAction action) {
        this.action = action;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PaymentsResponse paymentsResponse = (PaymentsResponse) o;
        return super.equals(paymentsResponse) && Objects.equals(this.action, paymentsResponse.action);
    }

    @Override
    public int hashCode() {
        return Objects.hash(action, super.hashCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentsResponse {\n");
        sb.append(super.toString());
        sb.append("    action: ").append(toIndentedString(action)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * The result of the payment. Possible values:
     * * **AuthenticationFinished** – The payment has been successfully authenticated with 3D Secure 2. Returned for 3D Secure 2 authentication-only transactions.
     * * **Authorised** – The payment was successfully authorised. This state serves as an indicator to proceed with the delivery of goods and services. This is a final state.
     * * **Cancelled** – Indicates the payment has been cancelled (either by the shopper or the merchant) before processing was completed. This is a final state.
     * * **ChallengeShopper** – The issuer requires further shopper interaction before the payment can be authenticated. Returned for 3D Secure 2 transactions.
     * * **Error** – There was an error when the payment was being processed. The reason is given in the `refusalReason` field. This is a final state.
     * * **IdentifyShopper** – The issuer requires the shopper's device fingerprint before the payment can be authenticated. Returned for 3D Secure 2 transactions.
     * * **Pending** – Indicates that it is not possible to obtain the final status of the payment. This can happen if the systems providing final status information for the payment are unavailable, or if the shopper needs to take further action to complete the payment. For more information on handling a pending payment, refer to [Payments with pending status](https://docs.adyen.com/development-resources/payments-with-pending-status).
     * * **Received** – Indicates the payment has successfully been received by Adyen, and will be processed. This is the initial state for all payments.
     * * **RedirectShopper** – Indicates the shopper should be redirected to an external web page or app to complete the authorisation.
     * * **Refused** – Indicates the payment was refused. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state.
     */
    @JsonAdapter(ResultCodeEnum.Adapter.class)
    public enum ResultCodeEnum {

        AUTHENTICATIONFINISHED("AuthenticationFinished"),
        AUTHENTICATIONNOTREQUIRED("AuthenticationNotRequired"),
        AUTHORISED("Authorised"),
        CANCELLED("Cancelled"),
        CHALLENGESHOPPER("ChallengeShopper"),
        ERROR("Error"),
        IDENTIFYSHOPPER("IdentifyShopper"),
        PENDING("Pending"),
        RECEIVED("Received"),
        REDIRECTSHOPPER("RedirectShopper"),
        REFUSED("Refused"),
        PARTIALLYAUTHORISED("PartiallyAuthorised"),
        PRESENTTOSHOPPER("PresentToShopper"),
        UNKNOWN("Unknown"); //applicable for payments/details

        @JsonValue
        private String value;

        ResultCodeEnum(String value) {
            this.value = value;
        }

        public static ResultCodeEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class Adapter extends TypeAdapter<ResultCodeEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ResultCodeEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ResultCodeEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ResultCodeEnum.fromValue(String.valueOf(value));
            }
        }
    }
}



