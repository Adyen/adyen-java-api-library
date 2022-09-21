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

    /**
     * Indicates whether individual details must be collected. Default is true.
     *
     * @return
     */
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

    /**
     * Indicates whether business details must be collected. Default is true.
     *
     * @return
     */
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

    /**
     * Indicates whether bank account details must be collected. Default is true.
     *
     * @return
     */
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

    /**
     * Indicates whether legal arrangement details must be collected. Default is true.
     *
     * @return
     */
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

    /**
     * Indicates whether answers to a PCI questionnaire must be collected. Applies only to partner platforms. Default is true.
     *
     * @return
     */
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

    /**
     * Indicates whether shareholder details must be collected. Defaults to true.
     *
     * @return
     */
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
        final StringBuilder sb = new StringBuilder();
        sb.append("class OnboardingCollectInformation {\n");

        sb.append("    individualDetails: ").append(toIndentedString(individualDetails)).append("\n");
        sb.append("    businessDetails: ").append(toIndentedString(businessDetails)).append("\n");
        sb.append("    bankDetails: ").append(toIndentedString(bankDetails)).append("\n");
        sb.append("    legalArrangementDetails: ").append(toIndentedString(legalArrangementDetails)).append("\n");
        sb.append("    pciQuestionnaire: ").append(toIndentedString(pciQuestionnaire)).append("\n");
        sb.append("    shareholderDetails: ").append(toIndentedString(shareholderDetails)).append("\n");
        sb.append('}');
        return sb.toString();
    }

}
