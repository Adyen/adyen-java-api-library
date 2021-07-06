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

public class ApiCredentialLinks extends Links {
    @SerializedName("allowedOrigins")
    private LinksElement allowedOrigins = null;

    @SerializedName("company")
    private LinksElement company = null;

    @SerializedName("generateApiKey")
    private LinksElement generateApiKey = null;

    @SerializedName("generateClientKey")
    private LinksElement generateClientKey = null;

    @SerializedName("merchant")
    private LinksElement merchant = null;

    public ApiCredentialLinks allowedOrigins(LinksElement allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
        return this;
    }

    /**
     * Get allowedOrigins
     * @return allowedOrigins
     **/
    public LinksElement getAllowedOrigins() {
        return allowedOrigins;
    }

    public void setAllowedOrigins(LinksElement allowedOrigins) {
        this.allowedOrigins = allowedOrigins;
    }

    public ApiCredentialLinks company(LinksElement company) {
        this.company = company;
        return this;
    }

    /**
     * Get company
     * @return company
     **/
    public LinksElement getCompany() {
        return company;
    }

    public void setCompany(LinksElement company) {
        this.company = company;
    }

    public ApiCredentialLinks generateApiKey(LinksElement generateApiKey) {
        this.generateApiKey = generateApiKey;
        return this;
    }

    /**
     * Get generateApiKey
     * @return generateApiKey
     **/
    public LinksElement getGenerateApiKey() {
        return generateApiKey;
    }

    public void setGenerateApiKey(LinksElement generateApiKey) {
        this.generateApiKey = generateApiKey;
    }

    public ApiCredentialLinks generateClientKey(LinksElement generateClientKey) {
        this.generateClientKey = generateClientKey;
        return this;
    }

    /**
     * Get generateClientKey
     * @return generateClientKey
     **/
    public LinksElement getGenerateClientKey() {
        return generateClientKey;
    }

    public void setGenerateClientKey(LinksElement generateClientKey) {
        this.generateClientKey = generateClientKey;
    }

    public ApiCredentialLinks merchant(LinksElement merchant) {
        this.merchant = merchant;
        return this;
    }

    /**
     * Get merchant
     * @return merchant
     **/
    public LinksElement getMerchant() {
        return merchant;
    }

    public void setMerchant(LinksElement merchant) {
        this.merchant = merchant;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApiCredentialLinks apiCredentialLinks = (ApiCredentialLinks) o;
        return Objects.equals(this.allowedOrigins, apiCredentialLinks.allowedOrigins) &&
                Objects.equals(this.company, apiCredentialLinks.company) &&
                Objects.equals(this.generateApiKey, apiCredentialLinks.generateApiKey) &&
                Objects.equals(this.generateClientKey, apiCredentialLinks.generateClientKey) &&
                Objects.equals(this.merchant, apiCredentialLinks.merchant) &&
                Objects.equals(this.getSelf(), apiCredentialLinks.getSelf());
    }

    @Override
    public int hashCode() {
        return Objects.hash(allowedOrigins, company, generateApiKey, generateClientKey, merchant, this.getSelf());
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiCredentialLinks {\n");

        sb.append("    allowedOrigins: ").append(toIndentedString(allowedOrigins)).append("\n");
        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    generateApiKey: ").append(toIndentedString(generateApiKey)).append("\n");
        sb.append("    generateClientKey: ").append(toIndentedString(generateClientKey)).append("\n");
        sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
        sb.append("    self: ").append(toIndentedString(this.getSelf())).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
