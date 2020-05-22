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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.binlookup;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

/**
 * CostEstimateAssumptions
 */

public class CostEstimateAssumptions {

    @SerializedName("assume3DSecureAuthenticated")
    private Boolean assume3DSecureAuthenticated = null;

    @SerializedName("assumeLevel3Data")
    private Boolean assumeLevel3Data = null;

    @SerializedName("installments")
    private Integer installments = null;

    public CostEstimateAssumptions assume3DSecureAuthenticated(Boolean assume3DSecureAuthenticated) {
        this.assume3DSecureAuthenticated = assume3DSecureAuthenticated;
        return this;
    }


    /**
     * If true, the cardholder is expected to successfully authorise via 3D Secure.
     *
     * @return assume3DSecureAuthenticated
     **/
    public Boolean isAssume3DSecureAuthenticated() {
        return assume3DSecureAuthenticated;
    }

    public void setAssume3DSecureAuthenticated(Boolean assume3DSecureAuthenticated) {
        this.assume3DSecureAuthenticated = assume3DSecureAuthenticated;
    }

    public CostEstimateAssumptions assumeLevel3Data(Boolean assumeLevel3Data) {
        this.assumeLevel3Data = assumeLevel3Data;
        return this;
    }


    /**
     * If true, the transaction is expected to have valid Level 3 data.
     *
     * @return assumeLevel3Data
     **/
    public Boolean isAssumeLevel3Data() {
        return assumeLevel3Data;
    }

    public void setAssumeLevel3Data(Boolean assumeLevel3Data) {
        this.assumeLevel3Data = assumeLevel3Data;
    }

    public CostEstimateAssumptions installments(Integer installments) {
        this.installments = installments;
        return this;
    }


    /**
     * If not zero, the number of installments.
     *
     * @return installments
     **/
    public Integer getInstallments() {
        return installments;
    }

    public void setInstallments(Integer installments) {
        this.installments = installments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        CostEstimateAssumptions costEstimateAssumptions = (CostEstimateAssumptions) o;
        return Objects.equals(this.assume3DSecureAuthenticated, costEstimateAssumptions.assume3DSecureAuthenticated)
                && Objects.equals(this.assumeLevel3Data, costEstimateAssumptions.assumeLevel3Data)
                && Objects.equals(this.installments, costEstimateAssumptions.installments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(assume3DSecureAuthenticated, assumeLevel3Data, installments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CostEstimateAssumptions {").append(LINE_BREAK);

        sb.append("    assume3DSecureAuthenticated: ").append(toIndentedString(assume3DSecureAuthenticated)).append(LINE_BREAK);
        sb.append("    assumeLevel3Data: ").append(toIndentedString(assumeLevel3Data)).append(LINE_BREAK);
        sb.append("    installments: ").append(toIndentedString(installments)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}
