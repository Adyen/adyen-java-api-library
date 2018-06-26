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

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Objects;

/**
 * Recurring
 */
public class Recurring {

    @SerializedName("contract")
    private ContractEnum contract = null;
    @SerializedName("recurringDetailName")
    private String recurringDetailName = null;
    @SerializedName("tokenService")
    private TokenServiceEnum tokenService = null;

    public Recurring contract(ContractEnum contract) {
        this.contract = contract;
        return this;
    }

    /**
     * The type of recurring contract to be used. Possible values: * &#x60;ONECLICK&#x60; – Payment details can be used to initiate a one-click payment, where the shopper enters the [card security code (CVC/CVV)](https://docs.adyen.com/developers/payment-glossary#cardsecuritycodecvccvvcid). * &#x60;RECURRING&#x60; – Payment details can be used without the card security code to initiate [card-not-present transactions](https://docs.adyen.com/developers/payment-glossary#cardnotpresentcnp). * &#x60;ONECLICK,RECURRING&#x60; – Payment details can be used regardless of whether the shopper is on your site or not. * &#x60;PAYOUT&#x60; – Payment details can be used to [make a payout](https://docs.adyen.com/developers/features/third-party-payouts).
     *
     * @return contract
     **/
    public ContractEnum getContract() {
        return contract;
    }

    public void setContract(ContractEnum contract) {
        this.contract = contract;
    }

    public Recurring recurringDetailName(String recurringDetailName) {
        this.recurringDetailName = recurringDetailName;
        return this;
    }

    /**
     * A descriptive name for this detail.
     *
     * @return recurringDetailName
     **/
    public String getRecurringDetailName() {
        return recurringDetailName;
    }

    public void setRecurringDetailName(String recurringDetailName) {
        this.recurringDetailName = recurringDetailName;
    }

    public Recurring tokenService(TokenServiceEnum tokenService) {
        this.tokenService = tokenService;
        return this;
    }

    /**
     * The name of the token service.
     *
     * @return tokenService
     **/
    public TokenServiceEnum getTokenService() {
        return tokenService;
    }

    public void setTokenService(TokenServiceEnum tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Recurring recurring = (Recurring) o;
        return Objects.equals(this.contract, recurring.contract) &&
                Objects.equals(this.recurringDetailName, recurring.recurringDetailName) &&
                Objects.equals(this.tokenService, recurring.tokenService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contract, recurringDetailName, tokenService);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Recurring {\n");

        sb.append("    contract: ").append(toIndentedString(contract)).append("\n");
        sb.append("    recurringDetailName: ").append(toIndentedString(recurringDetailName)).append("\n");
        sb.append("    tokenService: ").append(toIndentedString(tokenService)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * The type of recurring contract to be used. Possible values: * &#x60;ONECLICK&#x60; – Payment details can be used to initiate a one-click payment, where the shopper enters the [card security code (CVC/CVV)](https://docs.adyen.com/developers/payment-glossary#cardsecuritycodecvccvvcid). * &#x60;RECURRING&#x60; – Payment details can be used without the card security code to initiate [card-not-present transactions](https://docs.adyen.com/developers/payment-glossary#cardnotpresentcnp). * &#x60;ONECLICK,RECURRING&#x60; – Payment details can be used regardless of whether the shopper is on your site or not. * &#x60;PAYOUT&#x60; – Payment details can be used to [make a payout](https://docs.adyen.com/developers/features/third-party-payouts).
     */
    @JsonAdapter(ContractEnum.Adapter.class)
    public enum ContractEnum {

        ONECLICK("ONECLICK"),
        RECURRING("RECURRING"),
        PAYOUT("PAYOUT");

        private String value;

        ContractEnum(String value) {
            this.value = value;
        }

        public static ContractEnum fromValue(String text) {
            for (ContractEnum b : ContractEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class Adapter extends TypeAdapter<ContractEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ContractEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ContractEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ContractEnum.fromValue(String.valueOf(value));
            }
        }
    }

    /**
     * The name of the token service.
     */
    @JsonAdapter(TokenServiceEnum.Adapter.class)
    public enum TokenServiceEnum {

        VISATOKENSERVICE("VISATOKENSERVICE"),
        MCTOKENSERVICE("MCTOKENSERVICE");

        private String value;

        TokenServiceEnum(String value) {
            this.value = value;
        }

        public static TokenServiceEnum fromValue(String text) {
            for (TokenServiceEnum b : TokenServiceEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static class Adapter extends TypeAdapter<TokenServiceEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final TokenServiceEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public TokenServiceEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return TokenServiceEnum.fromValue(String.valueOf(value));
            }
        }
    }


}



