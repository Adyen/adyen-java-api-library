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

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * TokenConnectIssuer
 */

public class TokenConnectIssuer {
    @SerializedName("id")
    private String id = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("redirectUrls")
    private RedirectUrls redirectUrls = null;

    public TokenConnectIssuer id(String id) {
        this.id = id;
        return this;
    }

    /**
     * A unique identifier of the Token Connect issuer.
     *
     * @return id
     **/
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public TokenConnectIssuer name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A localized name of the Token Connect issuer.
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TokenConnectIssuer redirectUrls(RedirectUrls redirectUrls) {
        this.redirectUrls = redirectUrls;
        return this;
    }

    /**
     * Get redirectUrls
     *
     * @return redirectUrls
     **/
    public RedirectUrls getRedirectUrls() {
        return redirectUrls;
    }

    public void setRedirectUrls(RedirectUrls redirectUrls) {
        this.redirectUrls = redirectUrls;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TokenConnectIssuer tokenConnectIssuer = (TokenConnectIssuer) o;
        return Objects.equals(this.id, tokenConnectIssuer.id) &&
                Objects.equals(this.name, tokenConnectIssuer.name) &&
                Objects.equals(this.redirectUrls, tokenConnectIssuer.redirectUrls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, redirectUrls);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TokenConnectIssuer {\n");

        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    redirectUrls: ").append(toIndentedString(redirectUrls)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
