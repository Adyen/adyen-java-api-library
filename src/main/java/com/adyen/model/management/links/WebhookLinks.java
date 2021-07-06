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

public class WebhookLinks {
    @SerializedName("company")
    private LinksElement company = null;

    @SerializedName("generateHmac")
    private LinksElement generateHmac = null;

    @SerializedName("merchant")
    private LinksElement merchant = null;

    @SerializedName("self")
    private LinksElement self = null;

    @SerializedName("testWebhook")
    private LinksElement testWebhook = null;

    public WebhookLinks company(LinksElement company) {
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

    public WebhookLinks generateHmac(LinksElement generateHmac) {
        this.generateHmac = generateHmac;
        return this;
    }

    /**
     * Get generateHmac
     * @return generateHmac
     **/
    public LinksElement getGenerateHmac() {
        return generateHmac;
    }

    public void setGenerateHmac(LinksElement generateHmac) {
        this.generateHmac = generateHmac;
    }

    public WebhookLinks merchant(LinksElement merchant) {
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

    public WebhookLinks self(LinksElement self) {
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

    public WebhookLinks testWebhook(LinksElement testWebhook) {
        this.testWebhook = testWebhook;
        return this;
    }

    /**
     * Get testWebhook
     * @return testWebhook
     **/
    public LinksElement getTestWebhook() {
        return testWebhook;
    }

    public void setTestWebhook(LinksElement testWebhook) {
        this.testWebhook = testWebhook;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        WebhookLinks webhookLinks = (WebhookLinks) o;
        return Objects.equals(this.company, webhookLinks.company) &&
                Objects.equals(this.generateHmac, webhookLinks.generateHmac) &&
                Objects.equals(this.merchant, webhookLinks.merchant) &&
                Objects.equals(this.self, webhookLinks.self) &&
                Objects.equals(this.testWebhook, webhookLinks.testWebhook);
    }

    @Override
    public int hashCode() {
        return Objects.hash(company, generateHmac, merchant, self, testWebhook);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class WebhookLinks {\n");

        sb.append("    company: ").append(toIndentedString(company)).append("\n");
        sb.append("    generateHmac: ").append(toIndentedString(generateHmac)).append("\n");
        sb.append("    merchant: ").append(toIndentedString(merchant)).append("\n");
        sb.append("    self: ").append(toIndentedString(self)).append("\n");
        sb.append("    testWebhook: ").append(toIndentedString(testWebhook)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
