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
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Redirect
 */
public class Redirect {

    @SerializedName("data")
    private Map<String, String> data = null;
    @SerializedName("method")
    private MethodEnum method = null;
    @SerializedName("url")
    private String url = null;

    public Redirect data(Map<String, String> data) {
        this.data = data;
        return this;
    }

    public Redirect putDataItem(String key, String dataItem) {

        if (data == null) {
            data = new HashMap<>();
        }

        data.put(key, dataItem);
        return this;
    }

    /**
     * When the redirect URL must be accessed via POST, use this data to post to the redirect URL.
     *
     * @return data
     **/
    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data = data;
    }

    public Redirect method(MethodEnum method) {
        this.method = method;
        return this;
    }

    /**
     * The web method that you must use to access the redirect URL.  Possible values: GET, POST.
     *
     * @return method
     **/
    public MethodEnum getMethod() {
        return method;
    }

    public void setMethod(MethodEnum method) {
        this.method = method;
    }

    public Redirect url(String url) {
        this.url = url;
        return this;
    }

    /**
     * The URL, to which you must redirect a shopper to complete a payment.
     *
     * @return url
     **/
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Redirect redirect = (Redirect) o;
        return Objects.equals(data, redirect.data) &&
                Objects.equals(method, redirect.method) &&
                Objects.equals(url, redirect.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(data, method, url);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Redirect {\n");

        sb.append("    data: ").append(toIndentedString(data)).append("\n");
        sb.append("    method: ").append(toIndentedString(method)).append("\n");
        sb.append("    url: ").append(toIndentedString(url)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private static String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

    /**
     * The web method that you must use to access the redirect URL.  Possible values: GET, POST.
     */
    @JsonAdapter(MethodEnum.Adapter.class)
    public enum MethodEnum {

        GET("GET"),
        POST("POST");

        private final String value;

        MethodEnum(String value) {
            this.value = value;
        }

        public static MethodEnum fromValue(String text) {
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

        public static class Adapter extends TypeAdapter<MethodEnum> {
            @Override
            public void write(JsonWriter jsonWriter, MethodEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public MethodEnum read(JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return MethodEnum.fromValue(String.valueOf(value));
            }
        }
    }


}



