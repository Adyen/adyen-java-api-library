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

package com.adyen.model.checkout;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * TokenConnectStoringMethod
 */

public class TokenConnectStoringMethod {

    public static final String TOKENCONNECT = "tokenconnect";

    @SerializedName("issuers")
    private List<TokenConnectIssuer> issuers = new ArrayList<>();

    @SerializedName("type")
    private String type = TOKENCONNECT;

    public TokenConnectStoringMethod issuers(List<TokenConnectIssuer> issuers) {
        this.issuers = issuers;
        return this;
    }

    public TokenConnectStoringMethod addIssuersItem(TokenConnectIssuer issuersItem) {
        this.issuers.add(issuersItem);
        return this;
    }

    /**
     * The available Token Connect issuers.
     *
     * @return issuers
     **/
    public List<TokenConnectIssuer> getIssuers() {
        return issuers;
    }

    public void setIssuers(List<TokenConnectIssuer> issuers) {
        this.issuers = issuers;
    }

    public TokenConnectStoringMethod type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The unique storing method code.
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TokenConnectStoringMethod tokenConnectStoringMethod = (TokenConnectStoringMethod) o;
        return Objects.equals(this.issuers, tokenConnectStoringMethod.issuers) &&
                Objects.equals(this.type, tokenConnectStoringMethod.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuers, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TokenConnectStoringMethod {\n");

        sb.append("    issuers: ").append(toIndentedString(issuers)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
