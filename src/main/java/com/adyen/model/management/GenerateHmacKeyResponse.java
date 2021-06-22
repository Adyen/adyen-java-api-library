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

package com.adyen.model.management;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class GenerateHmacKeyResponse {
    @SerializedName("hmacKey")
    private String hmacKey = null;

    public GenerateHmacKeyResponse hmacKey(String hmacKey) {
        this.hmacKey = hmacKey;
        return this;
    }

    /**
     * The HMAC key generated for this webhook.
     * @return hmacKey
     **/
    public String getHmacKey() {
        return hmacKey;
    }

    public void setHmacKey(String hmacKey) {
        this.hmacKey = hmacKey;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GenerateHmacKeyResponse generateHmacKeyResponse = (GenerateHmacKeyResponse) o;
        return Objects.equals(this.hmacKey, generateHmacKeyResponse.hmacKey);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hmacKey);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GenerateHmacKeyResponse {\n");

        sb.append("    hmacKey: ").append(toIndentedString(hmacKey)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
