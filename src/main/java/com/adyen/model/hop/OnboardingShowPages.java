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

public class OnboardingShowPages {

    @SerializedName("welcomePage")
    private Boolean welcomePage = null;

    @SerializedName("homePage")
    private Boolean homePage = null;

    @SerializedName("individualDetailsSummaryPage")
    private Boolean individualDetailsSummaryPage = null;

    @SerializedName("businessDetailsSummaryPage")
    private Boolean businessDetailsSummaryPage = null;

    @SerializedName("bankDetailsSummaryPage")
    private Boolean bankDetailsSummaryPage = null;

    @SerializedName("shareholderDetailsSummaryPage")
    private Boolean shareholderDetailsSummaryPage = null;

    @SerializedName("bankVerificationOptionsPage")
    private Boolean bankVerificationOptionsPage = null;

    @SerializedName("identityDocumentPage")
    private Boolean identityDocumentPage = null;

    public OnboardingShowPages bankDetailsSummaryPage(Boolean bankDetailsSummaryPage) {
        this.bankDetailsSummaryPage = bankDetailsSummaryPage;
        return this;
    }

    public OnboardingShowPages shareholderDetailsSummaryPage(Boolean shareholderDetailsSummaryPage) {
        this.shareholderDetailsSummaryPage = shareholderDetailsSummaryPage;
        return this;
    }

    public OnboardingShowPages bankVerificationOptionsPage(Boolean bankVerificationOptionsPage) {
        this.bankVerificationOptionsPage = bankVerificationOptionsPage;
        return this;
    }

    public OnboardingShowPages identityDocumentPage(Boolean identityDocumentPage) {
        this.identityDocumentPage = identityDocumentPage;
        return this;
    }

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

    public Boolean getHomePage() {
        return homePage;
    }

    public void setHomePage(Boolean homePage) {
        this.homePage = homePage;
    }

    public OnboardingShowPages homePage(Boolean homePage) {
        this.homePage = homePage;
        return this;
    }

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

    public Boolean getBankDetailsSummaryPage() {
        return bankDetailsSummaryPage;
    }

    public void setBankDetailsSummaryPage(Boolean bankDetailsSummaryPage) {
        this.bankDetailsSummaryPage = bankDetailsSummaryPage;
    }

    public Boolean getShareholderDetailsSummaryPage() {
        return shareholderDetailsSummaryPage;
    }

    public void setShareholderDetailsSummaryPage(Boolean shareholderDetailsSummaryPage) {
        this.shareholderDetailsSummaryPage = shareholderDetailsSummaryPage;
    }

    public Boolean getBankVerificationOptionsPage() {
        return bankVerificationOptionsPage;
    }

    public void setBankVerificationOptionsPage(Boolean bankVerificationOptionsPage) {
        this.bankVerificationOptionsPage = bankVerificationOptionsPage;
    }

    public Boolean getIdentityDocumentPage() {
        return identityDocumentPage;
    }

    public void setIdentityDocumentPage(Boolean identityDocumentPage) {
        this.identityDocumentPage = identityDocumentPage;
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
            Objects.equals(homePage, that.homePage) &&
            Objects.equals(individualDetailsSummaryPage, that.individualDetailsSummaryPage) &&
            Objects.equals(businessDetailsSummaryPage, that.businessDetailsSummaryPage) &&
            Objects.equals(bankDetailsSummaryPage, that.bankDetailsSummaryPage) &&
            Objects.equals(shareholderDetailsSummaryPage, that.shareholderDetailsSummaryPage) &&
            Objects.equals(bankVerificationOptionsPage, that.bankVerificationOptionsPage) &&
            Objects.equals(identityDocumentPage, that.identityDocumentPage);
    }

    @Override
    public int hashCode() {
        return Objects.hash(welcomePage, homePage, individualDetailsSummaryPage, businessDetailsSummaryPage, bankDetailsSummaryPage, shareholderDetailsSummaryPage, bankVerificationOptionsPage, identityDocumentPage);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("class OnboardingShowPages{");
        sb.append("welcomePage=").append(welcomePage);
        sb.append(", homePage=").append(homePage);
        sb.append(", individualDetailsSummaryPage=").append(individualDetailsSummaryPage);
        sb.append(", businessDetailsSummaryPage=").append(businessDetailsSummaryPage);
        sb.append(", bankDetailsSummaryPage=").append(bankDetailsSummaryPage);
        sb.append(", shareholderDetailsSummaryPage=").append(shareholderDetailsSummaryPage);
        sb.append(", bankVerificationOptionsPage=").append(bankVerificationOptionsPage);
        sb.append(", identityDocumentPage=").append(identityDocumentPage);
        sb.append('}');
        return sb.toString();
    }

}
