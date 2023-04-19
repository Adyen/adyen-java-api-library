/**
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
package com.adyen.model;

import com.adyen.model.marketpay.ErrorFieldType;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.List;

import static com.adyen.util.Util.toIndentedString;

/**
 * Represents the API error responses
 */
public class ApiError {
    @SerializedName("status")
    private int status;

    @SerializedName("errorCode")
    private String errorCode = null;

    @SerializedName("message")
    private String message = null;

    @SerializedName("errorType")
    private String errorType = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorType() {
        return errorType;
    }

    public void setErrorType(String errorType) {
        this.errorType = errorType;
    }

    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    /**
     * Create an instance of ApiError given an JSON string
     * @param jsonString
     * @return
     * @throws IOException
     */
    public static ApiError fromJson(String jsonString) throws IOException {

        Gson gson = new GsonBuilder()
                .registerTypeAdapter(ApiError.class, new ApiErrorAdapter())
                .create();

        return gson.fromJson(jsonString, ApiError.class);
    }

    // custom deserialization of ApiError to support both RFC7807 format and the existing ServiceError schema
    static class ApiErrorAdapter extends TypeAdapter<ApiError> {
        private final Gson gson = new Gson();

        @Override
        public void write(JsonWriter out, ApiError value) throws IOException {
            // nothing to do
        }

        @Override
        public ApiError read(JsonReader jsonReader) throws IOException {
            ApiError apiError;

            JsonObject jsonObject = gson.fromJson(jsonReader, JsonObject.class);
            JsonElement typeJsonElement = jsonObject.get("type");

            if (typeJsonElement != null) {
                // convert RFC7807 payload to ApiError
                apiError = new ApiError();
                apiError.errorType = getStringValue(jsonObject, "type");
                apiError.status = getIntValue(jsonObject, "status");
                apiError.message = getStringValue(jsonObject, "detail");
                apiError.invalidFields = getListValue(jsonObject, "invalidFields");
                apiError.errorCode = getStringValue(jsonObject, "errorCode");
            } else {
                // map ServiceError to ApiError
                apiError = gson.fromJson(jsonObject, ApiError.class);
            }

            return apiError;
        }

        String getStringValue(JsonObject jsonObject, String field) {
            return jsonObject.get(field) != null ? jsonObject.get(field).getAsString() : null;
        }

        Integer getIntValue(JsonObject jsonObject, String field) {
            return jsonObject.get(field) != null ? jsonObject.get(field).getAsInt() : null;
        }

        List getListValue(JsonObject jsonObject, String field) {
            return jsonObject.get(field) != null ? jsonObject.get(field).getAsJsonArray().asList() : null;
        }
    }


    @Override
    public String toString() {

        String sb = "class ApiError {\n" +
                "    status: " + toIndentedString(status) + "\n" +
                "    errorCode: " + toIndentedString(errorCode) + "\n" +
                "    message: " + toIndentedString(message) + "\n" +
                "    errorType: " + toIndentedString(errorType) + "\n" +
                "    pspReference: " + toIndentedString(pspReference) + "\n" +
                "    invalidFields: " + toIndentedString(invalidFields) + "\n" +
                "}";
        return sb;
    }


}
