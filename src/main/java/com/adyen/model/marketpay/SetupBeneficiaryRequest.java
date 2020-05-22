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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.marketpay;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * SetupBeneficiaryRequest
 */
public class SetupBeneficiaryRequest {
    @SerializedName("sourceAccountCode")
    private String sourceAccountCode = null;

    @SerializedName("destinationAccountCode")
    private String destinationAccountCode = null;

    @SerializedName("merchantReference")
    private String merchantReference = null;

    public SetupBeneficiaryRequest sourceAccountCode(String sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
        return this;
    }

    /**
     * The source account code. This account will be closed as a result of this operation
     *
     * @return sourceAccountCode
     **/
    public String getSourceAccountCode() {
        return sourceAccountCode;
    }

    public void setSourceAccountCode(String sourceAccountCode) {
        this.sourceAccountCode = sourceAccountCode;
    }

    public SetupBeneficiaryRequest destinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
        return this;
    }

    /**
     * The destination account code. This account will receive all transactions of the source account.
     *
     * @return destinationAccountCode
     **/
    public String getDestinationAccountCode() {
        return destinationAccountCode;
    }

    public void setDestinationAccountCode(String destinationAccountCode) {
        this.destinationAccountCode = destinationAccountCode;
    }

    public SetupBeneficiaryRequest merchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
        return this;
    }

    /**
     * A reference indicating why this action has occurred.
     *
     * @return merchantReference
     **/
    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        SetupBeneficiaryRequest setupBeneficiaryRequest = (SetupBeneficiaryRequest) o;
        return Objects.equals(this.sourceAccountCode, setupBeneficiaryRequest.sourceAccountCode)
                && Objects.equals(this.destinationAccountCode, setupBeneficiaryRequest.destinationAccountCode)
                && Objects.equals(this.merchantReference, setupBeneficiaryRequest.merchantReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sourceAccountCode, destinationAccountCode, merchantReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class SetupBeneficiaryRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    sourceAccountCode: ").append(Util.toIndentedString(sourceAccountCode)).append(TextConstants.LINE_BREAK);
        sb.append("    destinationAccountCode: ").append(Util.toIndentedString(destinationAccountCode)).append(TextConstants.LINE_BREAK);
        sb.append("    merchantReference: ").append(Util.toIndentedString(merchantReference)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}

