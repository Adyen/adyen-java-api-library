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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model;

import java.util.Objects;

import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * SubjectErasureResponse
 */
public class SubjectErasureResponse {
    /**
     * Gets or Sets result
     */
    @JsonAdapter(ResultEnum.Adapter.class)
    public enum ResultEnum {
        ACTIVE_RECURRING_TOKEN_EXISTS("ACTIVE_RECURRING_TOKEN_EXISTS"),
        ALREADY_PROCESSED("ALREADY_PROCESSED"),
        PAYMENT_NOT_FOUND("PAYMENT_NOT_FOUND"),
        SUCCESS("SUCCESS");

        private final String value;

        ResultEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ResultEnum fromValue(String text) {
            for (ResultEnum b : ResultEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<ResultEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final ResultEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public ResultEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return ResultEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("result")
    private ResultEnum result = null;

    public SubjectErasureResponse result(ResultEnum result) {
        this.result = result;
        return this;
    }

    /**
     * Get result
     *
     * @return result
     **/
    public ResultEnum getResult() {
        return result;
    }

    public void setResult(ResultEnum result) {
        this.result = result;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SubjectErasureResponse subjectErasureResponse = (SubjectErasureResponse) o;
        return Objects.equals(this.result, subjectErasureResponse.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(result);
    }


    @Override
    public String toString() {
        return "class SubjectErasureResponse {\n" +
                "    result: " + toIndentedString(result) + "\n" +
                "}";
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

}