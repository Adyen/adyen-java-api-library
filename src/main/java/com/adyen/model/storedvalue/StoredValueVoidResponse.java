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
package com.adyen.model.storedvalue;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

import com.adyen.model.Amount;

/**
 * StoredValueVoidResponse
 */

public class StoredValueVoidResponse {
    @SerializedName("currentBalance")
    private Amount currentBalance = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("refusalReason")
    private String refusalReason = null;

    /**
     * The result of the payment. Possible values:  * **Success** – The operation has been completed successfully.  * **Refused** – The operation was refused. The reason is given in the &#x60;refusalReason&#x60; field.  * **Error** – There was an error when the operation was processed. The reason is given in the &#x60;refusalReason&#x60; field.  * **NotEnoughBalance** – The amount on the payment method is lower than the amount given in the request. Only applicable to balance checks.
     */
    @JsonAdapter(ResultCodeEnum.Adapter.class)
    public enum ResultCodeEnum {
        SUCCESS("Success"),
        REFUSED("Refused"),
        ERROR("Error"),
        NOTENOUGHBALANCE("NotEnoughBalance");

        @JsonValue
        private final String value;

        ResultCodeEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static ResultCodeEnum fromValue(String text) {
            for (ResultCodeEnum b : ResultCodeEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
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

    @SerializedName("resultCode")
    private ResultCodeEnum resultCode = null;

    @SerializedName("thirdPartyRefusalReason")
    private String thirdPartyRefusalReason = null;

    public StoredValueVoidResponse currentBalance(Amount currentBalance) {
        this.currentBalance = currentBalance;
        return this;
    }

    /**
     * Get currentBalance
     *
     * @return currentBalance
     **/
    public Amount getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Amount currentBalance) {
        this.currentBalance = currentBalance;
    }

    public StoredValueVoidResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * Adyen&#x27;s 16-character string reference associated with the transaction/request. This value is globally unique; quote it when communicating with us about this request.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public StoredValueVoidResponse refusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
        return this;
    }

    /**
     * If the transaction is refused or an error occurs, this field holds Adyen&#x27;s mapped reason for the refusal or a description of the error.  When a transaction fails, the authorisation response includes &#x60;resultCode&#x60; and &#x60;refusalReason&#x60; values.
     *
     * @return refusalReason
     **/
    public String getRefusalReason() {
        return refusalReason;
    }

    public void setRefusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
    }

    public StoredValueVoidResponse resultCode(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * The result of the payment. Possible values:  * **Success** – The operation has been completed successfully.  * **Refused** – The operation was refused. The reason is given in the &#x60;refusalReason&#x60; field.  * **Error** – There was an error when the operation was processed. The reason is given in the &#x60;refusalReason&#x60; field.  * **NotEnoughBalance** – The amount on the payment method is lower than the amount given in the request. Only applicable to balance checks.
     *
     * @return resultCode
     **/
    public ResultCodeEnum getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
    }

    public StoredValueVoidResponse thirdPartyRefusalReason(String thirdPartyRefusalReason) {
        this.thirdPartyRefusalReason = thirdPartyRefusalReason;
        return this;
    }

    /**
     * Raw refusal reason received from the third party, where available
     *
     * @return thirdPartyRefusalReason
     **/
    public String getThirdPartyRefusalReason() {
        return thirdPartyRefusalReason;
    }

    public void setThirdPartyRefusalReason(String thirdPartyRefusalReason) {
        this.thirdPartyRefusalReason = thirdPartyRefusalReason;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StoredValueVoidResponse storedValueVoidResponse = (StoredValueVoidResponse) o;
        return Objects.equals(this.currentBalance, storedValueVoidResponse.currentBalance) &&
                Objects.equals(this.pspReference, storedValueVoidResponse.pspReference) &&
                Objects.equals(this.refusalReason, storedValueVoidResponse.refusalReason) &&
                Objects.equals(this.resultCode, storedValueVoidResponse.resultCode) &&
                Objects.equals(this.thirdPartyRefusalReason, storedValueVoidResponse.thirdPartyRefusalReason);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentBalance, pspReference, refusalReason, resultCode, thirdPartyRefusalReason);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class StoredValueVoidResponse {\n");

        sb.append("    currentBalance: ").append(toIndentedString(currentBalance)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    refusalReason: ").append(toIndentedString(refusalReason)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("    thirdPartyRefusalReason: ").append(toIndentedString(thirdPartyRefusalReason)).append("\n");
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

}
