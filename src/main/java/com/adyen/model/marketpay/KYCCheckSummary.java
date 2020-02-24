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

package com.adyen.model.marketpay;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * KYCCheckSummary
 */
public class KYCCheckSummary {
    @SerializedName("kycCheckCode")
    private Integer kycCheckCode = null;

    @SerializedName("kycCheckDescription")
    private String kycCheckDescription = null;

    public KYCCheckSummary kycCheckCode(Integer kycCheckCode) {
        this.kycCheckCode = kycCheckCode;
        return this;
    }

    /**
     * The code of the check.
     *
     * @return kycCheckCode
     **/
    public Integer getKycCheckCode() {
        return kycCheckCode;
    }

    public void setKycCheckCode(Integer kycCheckCode) {
        this.kycCheckCode = kycCheckCode;
    }

    public KYCCheckSummary kycCheckDescription(String kycCheckDescription) {
        this.kycCheckDescription = kycCheckDescription;
        return this;
    }

    /**
     * A description of the check.
     *
     * @return kycCheckDescription
     **/
    public String getKycCheckDescription() {
        return kycCheckDescription;
    }

    public void setKycCheckDescription(String kycCheckDescription) {
        this.kycCheckDescription = kycCheckDescription;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        KYCCheckSummary kyCCheckSummary = (KYCCheckSummary) o;
        return Objects.equals(this.kycCheckCode, kyCCheckSummary.kycCheckCode) &&
                Objects.equals(this.kycCheckDescription, kyCCheckSummary.kycCheckDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kycCheckCode, kycCheckDescription);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class KYCCheckSummary {\n");

        sb.append("    kycCheckCode: ").append(toIndentedString(kycCheckCode)).append("\n");
        sb.append("    kycCheckDescription: ").append(toIndentedString(kycCheckDescription)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
