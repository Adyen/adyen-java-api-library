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

import com.adyen.model.Installments;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

public class ModelConfiguration {

    @SerializedName("avs")
    private Avs avs = null;

    /**
     * Determines whether the cardholder name should be provided or not.  Permitted values: * NONE * OPTIONAL * REQUIRED
     */
    @JsonAdapter(CardHolderNameEnum.Adapter.class)
    public enum CardHolderNameEnum {

        NONE("NONE"),
        OPTIONAL("OPTIONAL"),
        REQUIRED("REQUIRED");

        private String value;

        CardHolderNameEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static CardHolderNameEnum fromValue(String text) {
            return Arrays.stream(values()).
                    filter(s -> s.value.equals(text)).
                    findFirst().orElse(null);
        }

        public static class Adapter extends TypeAdapter<CardHolderNameEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final CardHolderNameEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public CardHolderNameEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return CardHolderNameEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("cardHolderName")
    private CardHolderNameEnum cardHolderName = null;

    @SerializedName("installments")
    private Installments installments = null;

    @SerializedName("shopperInput")
    private ShopperInput shopperInput = null;

    public ModelConfiguration avs(Avs avs) {
        this.avs = avs;
        return this;
    }


    public Avs getAvs() {
        return avs;
    }

    public void setAvs(Avs avs) {
        this.avs = avs;
    }

    public ModelConfiguration cardHolderName(CardHolderNameEnum cardHolderName) {
        this.cardHolderName = cardHolderName;
        return this;
    }


    public void setCardHolderName(CardHolderNameEnum cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public ModelConfiguration installments(Installments installments) {
        this.installments = installments;
        return this;
    }


    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    public ModelConfiguration shopperInput(ShopperInput shopperInput) {
        this.shopperInput = shopperInput;
        return this;
    }


    public ShopperInput getShopperInput() {
        return shopperInput;
    }

    public void setShopperInput(ShopperInput shopperInput) {
        this.shopperInput = shopperInput;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ModelConfiguration configuration = (ModelConfiguration) o;
        return Objects.equals(this.avs, configuration.avs)
                && Objects.equals(this.cardHolderName, configuration.cardHolderName)
                && Objects.equals(this.installments, configuration.installments)
                && Objects.equals(this.shopperInput, configuration.shopperInput);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avs, cardHolderName, installments, shopperInput);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModelConfiguration {\n");

        sb.append("    avs: ").append(toIndentedString(avs)).append("\n");
        sb.append("    cardHolderName: ").append(toIndentedString(cardHolderName)).append("\n");
        sb.append("    installments: ").append(toIndentedString(installments)).append("\n");
        sb.append("    shopperInput: ").append(toIndentedString(shopperInput)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}



