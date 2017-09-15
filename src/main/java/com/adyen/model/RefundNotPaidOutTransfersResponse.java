/**
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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * RefundNotPaidOutTransfersResponse
 */
public class RefundNotPaidOutTransfersResponse {
    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public RefundNotPaidOutTransfersResponse submittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
        return this;
    }

    /**
     * Get submittedAsync
     *
     * @return submittedAsync
     **/
    public Boolean getSubmittedAsync() {
        return submittedAsync;
    }

    public void setSubmittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
    }

    public RefundNotPaidOutTransfersResponse resultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * The result code
     *
     * @return resultCode
     **/
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public RefundNotPaidOutTransfersResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * psp reference
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RefundNotPaidOutTransfersResponse refundNotPaidOutTransfersResponse = (RefundNotPaidOutTransfersResponse) o;
        return Objects.equals(this.submittedAsync, refundNotPaidOutTransfersResponse.submittedAsync) && Objects.equals(this.resultCode, refundNotPaidOutTransfersResponse.resultCode) && Objects.equals(
                this.pspReference,
                refundNotPaidOutTransfersResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submittedAsync, resultCode, pspReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RefundNotPaidOutTransfersResponse {\n");

        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
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

