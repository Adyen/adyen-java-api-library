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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

@JsonAdapter(PayoutSpeedEnum.Adapter.class)
public enum PayoutSpeedEnum {
    INSTANT("INSTANT"),
    SAME_DAY("SAME_DAY"),
    STANDARD("STANDARD");

    @JsonValue
    private final String value;

    PayoutSpeedEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return String.valueOf(value);
    }

    public static PayoutSpeedEnum fromValue(String text) {
        for (PayoutSpeedEnum b : PayoutSpeedEnum.values()) {
            if (String.valueOf(b.value).equals(text)) {
                return b;
            }
        }
        return null;
    }

    public static class Adapter extends TypeAdapter<PayoutSpeedEnum> {
        @Override
        public void write(final JsonWriter jsonWriter, final PayoutSpeedEnum enumeration) throws IOException {
            jsonWriter.value(enumeration.getValue());
        }

        @Override
        public PayoutSpeedEnum read(final JsonReader jsonReader) throws IOException {
            Object value = jsonReader.nextString();
            return PayoutSpeedEnum.fromValue(String.valueOf(value));
        }
    }
}
