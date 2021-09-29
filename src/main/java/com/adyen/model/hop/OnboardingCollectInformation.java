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

public class OnboardingCollectInformation {

    @SerializedName("individualDetails")
    private Boolean individualDetails = null;

    @SerializedName("businessDetails")
    private Boolean businessDetails = null;

    @SerializedName("bankDetails")
    private Boolean bankDetails = null;

    @SerializedName("legalArrangementDetails")
    private Boolean legalArrangementDetails = null;

    @SerializedName("pciQuestionnaire")
    private Boolean pciQuestionnaire = null;

    @SerializedName("shareholderDetails")
    private Boolean shareholderDetails = null;

    public Boolean getIndividualDetails() {
        return individualDetails;
    }

    public void setIndividualDetails(Boolean individualDetails) {
        this.individualDetails = individualDetails;
    }

    public OnboardingCollectInformation individualDetails(Boolean individualDetails) {
        this.individualDetails = individualDetails;
        return this;
    }

    public Boolean getBusinessDetails() {
        return businessDetails;
    }

    public void setBusinessDetails(Boolean businessDetails) {
        this.businessDetails = businessDetails;
    }

    public OnboardingCollectInformation businessDetails(Boolean businessDetails) {
        this.businessDetails = businessDetails;
        return this;
    }

    public Boolean getBankDetails() {
        return bankDetails;
    }

    public void setBankDetails(Boolean bankDetails) {
        this.bankDetails = bankDetails;
    }

    public OnboardingCollectInformation bankDetails(Boolean bankDetails) {
        this.bankDetails = bankDetails;
        return this;
    }

    public Boolean getLegalArrangementDetails() {
        return legalArrangementDetails;
    }

    public void setLegalArrangementDetails(Boolean legalArrangementDetails) {
        this.legalArrangementDetails = legalArrangementDetails;
    }

    public OnboardingCollectInformation legalArrangementDetails(Boolean legalArrangementDetails) {
        this.legalArrangementDetails = legalArrangementDetails;
        return this;
    }

    public Boolean getPciQuestionnaire() {
        return pciQuestionnaire;
    }

    public void setPciQuestionnaire(Boolean pciQuestionnaire) {
        this.pciQuestionnaire = pciQuestionnaire;
    }

    public OnboardingCollectInformation pciQuestionnaire(Boolean pciQuestionnaire) {
        this.pciQuestionnaire = pciQuestionnaire;
        return this;
    }

    public Boolean getShareholderDetails() {
        return shareholderDetails;
    }

    public void setShareholderDetails(Boolean shareholderDetails) {
        this.shareholderDetails = shareholderDetails;
    }

    public OnboardingCollectInformation shareholderDetails(Boolean shareholderDetails) {
        this.shareholderDetails = shareholderDetails;
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
        OnboardingCollectInformation that = (OnboardingCollectInformation) o;
        return Objects.equals(individualDetails, that.individualDetails) &&
            Objects.equals(businessDetails, that.businessDetails) &&
            Objects.equals(bankDetails, that.bankDetails) &&
            Objects.equals(legalArrangementDetails, that.legalArrangementDetails) &&
            Objects.equals(pciQuestionnaire, that.pciQuestionnaire) &&
            Objects.equals(shareholderDetails, that.shareholderDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(individualDetails, businessDetails, bankDetails, legalArrangementDetails, pciQuestionnaire, shareholderDetails);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("OnboardingCollectInformation{");
        sb.append("individualDetails=").append(individualDetails);
        sb.append(", businessDetails=").append(businessDetails);
        sb.append(", bankDetails=").append(bankDetails);
        sb.append(", legalArrangementDetails=").append(legalArrangementDetails);
        sb.append(", pciQuestionnaire=").append(pciQuestionnaire);
        sb.append(", shareholderDetails=").append(shareholderDetails);
        sb.append('}');
        return sb.toString();
    }
}
