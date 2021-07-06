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

/**
 * Links
 */

public class Links {
    @SerializedName("allowedOrigins")
    private LinksElement allowedOrigins = null;

    @SerializedName("company")
    private LinksElement company = null;

    @SerializedName("dataCenters")
    private LinksElement dataCenters = null;

    @SerializedName("generateHmac")
    private LinksElement generateHmac = null;

    @SerializedName("merchant")
    private LinksElement merchant = null;

    @SerializedName("self")
    private LinksElement self = null;

    @SerializedName("testWebhook")
    private LinksElement testWebhook = null;

    @SerializedName("users")
    private LinksElement users = null;

    @SerializedName("webhooks")
    private LinksElement webhooks = null;

    public Links allowedOrigins(LinksElement allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
        return this;
    }

    /**
     * Get allowedOrigins
     *
     * @return allowedOrigins
     **/
    public LinksElement getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(LinksElement allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public Links company(LinksElement company) {
        this.company = company;
        return this;
    }

    /**
     * Get company
     *
     * @return company
     **/
    public LinksElement getCompany() {
        return company;
    }

    public void setCompany(LinksElement company) {
        this.company = company;
    }

    public Links dataCenters(LinksElement dataCenters) {
        this.dataCenters = dataCenters;
        return this;
    }

    /**
     * Get dataCenters
     *
     * @return dataCenters
     **/
    public LinksElement getDataCenters() {
        return dataCenters;
    }

    public void setDataCenters(LinksElement dataCenters) {
        this.dataCenters = dataCenters;
    }

    public Links generateHmac(LinksElement generateHmac) {
        this.generateHmac = generateHmac;
        return this;
    }

    /**
     * Get generateHmac
     *
     * @return generateHmac
     **/
    public LinksElement getGenerateHmac() {
        return generateHmac;
    }

    public void setGenerateHmac(LinksElement generateHmac) {
        this.generateHmac = generateHmac;
    }

    public Links merchant(LinksElement merchant) {
        this.merchant = merchant;
        return this;
    }

    /**
     * Get merchant
     *
     * @return merchant
     **/
    public LinksElement getMerchant() {
        return merchant;
    }

    public void setMerchant(LinksElement merchant) {
        this.merchant = merchant;
    }

    public Links self(LinksElement self) {
        this.self = self;
        return this;
    }

    /**
     * Get self
     *
     * @return self
     **/
    public LinksElement getSelf() {
        return self;
    }

    public void setSelf(LinksElement self) {
        this.self = self;
    }

    public Links testWebhook(LinksElement testWebhook) {
        this.testWebhook = testWebhook;
        return this;
    }

    /**
     * Get testWebhook
     *
     * @return testWebhook
     **/
    public LinksElement getTestWebhook() {
        return testWebhook;
    }

    public void setTestWebhook(LinksElement testWebhook) {
        this.testWebhook = testWebhook;
    }

    public Links users(LinksElement users) {
        this.users = users;
        return this;
    }

    /**
     * Get users
     *
     * @return users
     **/
    public LinksElement getUsers() {
        return users;
    }

    public void setUsers(LinksElement users) {
        this.users = users;
    }

    public Links webhooks(LinksElement webhooks) {
        this.webhooks = webhooks;
        return this;
    }

    /**
     * Get webhooks
     *
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
        Links links = (Links) o;
        return Objects.equals(this.allowedOrigins, links.allowedOrigins) &&
                Objects.equals(this.company, links.company) &&
                Objects.equals(this.dataCenters, links.dataCenters) &&
                Objects.equals(this.generateHmac, links.generateHmac) &&
                Objects.equals(this.merchant, links.merchant) &&
                Objects.equals(this.self, links.self) &&
                Objects.equals(this.testWebhook, links.testWebhook) &&
                Objects.equals(this.users, links.users) &&
                Objects.equals(this.webhooks, links.webhooks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowedOrigins, company, dataCenters, generateHmac, merchant, self, testWebhook, users, webhooks);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Links {\n");

        sb.append("    allowedOrigins: ").append(toIndentedString(allowedOrigins)).append("\n");
        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    dataCenters: ").append(toIndentedString(dataCenters)).append("\n");
        sb.append("    generateHmac: ").append(toIndentedString(generateHmac)).append("\n");
        sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
        sb.append("    self: ").append(toIndentedString(self)).append("\n");
        sb.append("    testWebhook: ").append(toIndentedString(testWebhook)).append("\n");
        sb.append("    users: ").append(toIndentedString(users)).append("\n");
        sb.append("    webhooks: ").append(toIndentedString(webhooks)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
