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
package com.adyen.model.dispute;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;
import static com.adyen.util.Util.toIndentedString;

/**
 * PaymentsRequest
 */
public class RetriveApplicableDefenseReasonsRequest {
    @SerializedName("disputePspReference")
    private String disputePspReference = null;
    @SerializedName("merchantAccountCode")
    private String merchantAccountCode = null;

    public RetriveApplicableDefenseReasonsRequest() {
    }
    public String getDisputePspReference() {
        return this.disputePspReference;
    }
    public void setDisputePspReference(String disputePspReference) {
        this.disputePspReference = disputePspReference;
    }
    public String getMerchantAccountCode() {
        return this.merchantAccountCode;
    }
    public void setMerchantAccountCode(String merchantAccountCode) {
        this.merchantAccountCode = merchantAccountCode;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RetriveApplicableDefenseReasonsRequest retriveApplicableDefenseReasonsRequest = (RetriveApplicableDefenseReasonsRequest) o;
        return Objects.equals(this.disputePspReference, retriveApplicableDefenseReasonsRequest.disputePspReference) &&
                Objects.equals(this.merchantAccountCode, retriveApplicableDefenseReasonsRequest.merchantAccountCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.disputePspReference, this.merchantAccountCode);

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RetriveApplicableDefenseReasonsRequest {\n");

        sb.append("    disputePspReference: ").append(toIndentedString(this.disputePspReference)).append("\n");
        sb.append("    merchantAccountCode: ").append(toIndentedString(this.merchantAccountCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}



