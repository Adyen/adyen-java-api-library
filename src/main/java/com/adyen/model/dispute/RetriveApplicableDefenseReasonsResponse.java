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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.dispute;

import com.adyen.model.dispute.details.DefenseReason;
import com.adyen.model.dispute.details.DisputeServiceResult;
import com.google.gson.annotations.SerializedName;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * PaymentsResponse
 */
public class RetriveApplicableDefenseReasonsResponse {

    @SerializedName("defenseReasons")
    private DefenseReason[] defenseReasons;
    @SerializedName("disputeServiceResult")
    private DisputeServiceResult disputeServiceResult;

    public DefenseReason[] getDefenseReasons() {
        return this.defenseReasons;
    }
    public void setDefenseReasons(DefenseReason[] defenseReasons) {
        this.defenseReasons = defenseReasons;
    }
    public DisputeServiceResult getDisputeServiceResult() {
        return this.disputeServiceResult;
    }
    public void setDisputeServiceResult(DisputeServiceResult disputeServiceResult) {
        this.disputeServiceResult = disputeServiceResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RetriveApplicableDefenseReasonsResponse retriveApplicableDefenseReasonsResponse = (RetriveApplicableDefenseReasonsResponse) o;
        return Objects.equals(this.defenseReasons, retriveApplicableDefenseReasonsResponse.defenseReasons) &&
            Objects.equals(this.disputeServiceResult, retriveApplicableDefenseReasonsResponse.disputeServiceResult);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.defenseReasons, this.disputeServiceResult);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RetriveApplicableDefenseReasonsResponse {\n");
        sb.append("    defenseReasons: [").append("\n");
        for (DefenseReason dr : this.defenseReasons) {
            sb.append("    ").append(toIndentedString(dr)).append(",\n");
        }
        sb.append("    ").append(toIndentedString("]")).append("\n");
        sb.append("    disputeServiceResult: ").append(toIndentedString(this.disputeServiceResult)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}



