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

package com.adyen.model.management.links;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class MerchantLinks {
    @SerializedName("apiCredentials")
    private LinksElement apiCredentials = null;

    @SerializedName("self")
    private LinksElement self = null;

    @SerializedName("users")
    private LinksElement users = null;

    @SerializedName("webhooks")
    private LinksElement webhooks = null;

    public MerchantLinks apiCredentials(LinksElement apiCredentials) {
        this.apiCredentials = apiCredentials;
        return this;
    }

    /**
     * Get apiCredentials
     * @return apiCredentials
     **/
    public LinksElement getApiCredentials() {
        return apiCredentials;
    }

    public void setApiCredentials(LinksElement apiCredentials) {
        this.apiCredentials = apiCredentials;
    }

    public MerchantLinks self(LinksElement self) {
        this.self = self;
        return this;
    }

    /**
     * Get self
     * @return self
     **/
    public LinksElement getSelf() {
        return self;
    }

    public void setSelf(LinksElement self) {
        this.self = self;
    }

    public MerchantLinks users(LinksElement users) {
        this.users = users;
        return this;
    }

    /**
     * Get users
     * @return users
     **/
    public LinksElement getUsers() {
        return users;
    }

    public void setUsers(LinksElement users) {
        this.users = users;
    }

    public MerchantLinks webhooks(LinksElement webhooks) {
        this.webhooks = webhooks;
        return this;
    }

    /**
     * Get webhooks
     * @return webhooks
     **/
    public LinksElement getWebhooks() {
        return webhooks;
    }

    public void setWebhooks(LinksElement webhooks) {
        this.webhooks = webhooks;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        MerchantLinks merchantLinks = (MerchantLinks) o;
        return Objects.equals(this.apiCredentials, merchantLinks.apiCredentials) &&
                Objects.equals(this.self, merchantLinks.self) &&
                Objects.equals(this.users, merchantLinks.users) &&
                Objects.equals(this.webhooks, merchantLinks.webhooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(apiCredentials, self, users, webhooks);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class MerchantLinks {\n");

        sb.append("    apiCredentials: ").append(toIndentedString(apiCredentials)).append("\n");
        sb.append("    self: ").append(toIndentedString(self)).append("\n");
        sb.append("    users: ").append(toIndentedString(users)).append("\n");
        sb.append("    webhooks: ").append(toIndentedString(webhooks)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
