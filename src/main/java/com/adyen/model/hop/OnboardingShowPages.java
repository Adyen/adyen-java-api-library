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

package com.adyen.model.hop;

import java.util.Objects;

import com.google.gson.annotations.SerializedName;

import static com.adyen.util.Util.toIndentedString;

public class OnboardingShowPages {

    @SerializedName("welcomePage")
    private Boolean welcomePage = null;

    @SerializedName("individualDetailsSummaryPage")
    private Boolean individualDetailsSummaryPage = null;

    @SerializedName("businessDetailsSummaryPage")
    private Boolean businessDetailsSummaryPage = null;

    @SerializedName("bankDetailsSummaryPage")
    private Boolean bankDetailsSummaryPage = null;

    @SerializedName("shareholderDetailsSummaryPage")
    private Boolean shareholderDetailsSummaryPage = null;

    @SerializedName("legalArrangementsDetailsSummaryPage")
    private Boolean legalArrangementsDetailsSummaryPage = null;

    /**
     * Indicates whether the welcome page must be shown. Defaults to false.
     *
     * @return
     */
    public Boolean getWelcomePage() {
        return welcomePage;
    }

    public void setWelcomePage(Boolean welcomePage) {
        this.welcomePage = welcomePage;
    }

    public OnboardingShowPages welcomePage(Boolean welcomePage) {
        this.welcomePage = welcomePage;
        return this;
    }

    /**
     * Indicates whether the page with the individual's details must be shown. Defaults to true.
     *
     * @return
     */
    public Boolean getIndividualDetailsSummaryPage() {
        return individualDetailsSummaryPage;
    }

    public void setIndividualDetailsSummaryPage(Boolean individualDetailsSummaryPage) {
        this.individualDetailsSummaryPage = individualDetailsSummaryPage;
    }

    public OnboardingShowPages individualDetailsSummaryPage(Boolean individualDetailsSummaryPage) {
        this.individualDetailsSummaryPage = individualDetailsSummaryPage;
        return this;
    }

    /**
     * Indicates whether the page with bank account details must be shown. Defaults to true.
     *
     * @return
     */
    public Boolean getBusinessDetailsSummaryPage() {
        return businessDetailsSummaryPage;
    }

    public void setBusinessDetailsSummaryPage(Boolean businessDetailsSummaryPage) {
        this.businessDetailsSummaryPage = businessDetailsSummaryPage;
    }

    public OnboardingShowPages businessDetailsSummaryPage(Boolean businessDetailsSummaryPage) {
        this.businessDetailsSummaryPage = businessDetailsSummaryPage;
        return this;
    }

    /**
     * Indicates whether the page with bank account details must be shown. Defaults to true.
     *
     * @return
     */
    public Boolean getBankDetailsSummaryPage() {
        return bankDetailsSummaryPage;
    }

    public void setBankDetailsSummaryPage(Boolean bankDetailsSummaryPage) {
        this.bankDetailsSummaryPage = bankDetailsSummaryPage;
    }

    public OnboardingShowPages bankDetailsSummaryPage(Boolean bankDetailsSummaryPage) {
        this.bankDetailsSummaryPage = bankDetailsSummaryPage;
        return this;
    }

    /**
     * Indicates whether the page with the shareholders' details must be shown. Defaults to true.
     *
     * @return
     */
    public Boolean getShareholderDetailsSummaryPage() {
        return shareholderDetailsSummaryPage;
    }

    public void setShareholderDetailsSummaryPage(Boolean shareholderDetailsSummaryPage) {
        this.shareholderDetailsSummaryPage = shareholderDetailsSummaryPage;
    }

    public OnboardingShowPages shareholderDetailsSummaryPage(Boolean shareholderDetailsSummaryPage) {
        this.shareholderDetailsSummaryPage = shareholderDetailsSummaryPage;
        return this;
    }

    /**
     * Indicates whether the page with the legal arrangements' details must be shown. Defaults to true.
     *
     * @return
     */

    public Boolean getLegalArrangementsDetailsSummaryPage() {
        return legalArrangementsDetailsSummaryPage;
    }

    public void setLegalArrangementsDetailsSummaryPage(Boolean legalArrangementsDetailsSummaryPage) {
        this.legalArrangementsDetailsSummaryPage = legalArrangementsDetailsSummaryPage;
    }

    public OnboardingShowPages legalArrangementsDetailsSummaryPage(Boolean legalArrangementsDetailsSummaryPage) {
        this.legalArrangementsDetailsSummaryPage = legalArrangementsDetailsSummaryPage;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OnboardingShowPages that = (OnboardingShowPages) o;
        return Objects.equals(welcomePage, that.welcomePage) &&
            Objects.equals(individualDetailsSummaryPage, that.individualDetailsSummaryPage) &&
            Objects.equals(businessDetailsSummaryPage, that.businessDetailsSummaryPage) &&
            Objects.equals(bankDetailsSummaryPage, that.bankDetailsSummaryPage) &&
            Objects.equals(shareholderDetailsSummaryPage, that.shareholderDetailsSummaryPage) &&
            Objects.equals(legalArrangementsDetailsSummaryPage, that.legalArrangementsDetailsSummaryPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(welcomePage, individualDetailsSummaryPage, businessDetailsSummaryPage, bankDetailsSummaryPage, shareholderDetailsSummaryPage, legalArrangementsDetailsSummaryPage);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("class OnboardingShowPages {\n");

        sb.append("    welcomePage: ").append(toIndentedString(welcomePage)).append("\n");
        sb.append("    individualDetailsSummaryPage: ").append(toIndentedString(individualDetailsSummaryPage)).append("\n");
        sb.append("    businessDetailsSummaryPage: ").append(toIndentedString(businessDetailsSummaryPage)).append("\n");
        sb.append("    bankDetailsSummaryPage: ").append(toIndentedString(bankDetailsSummaryPage)).append("\n");
        sb.append("    shareholderDetailsSummaryPage: ").append(toIndentedString(shareholderDetailsSummaryPage)).append("\n");
        sb.append("    legalArrangementsDetailsSummaryPage: ").append(toIndentedString(legalArrangementsDetailsSummaryPage)).append("\n");
        sb.append('}');
        return sb.toString();
    }

}
