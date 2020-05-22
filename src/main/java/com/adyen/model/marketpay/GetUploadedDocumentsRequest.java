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
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * GetUploadedDocumentsRequest
 */
public class GetUploadedDocumentsRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("shareholderCode")
    private String shareholderCode = null;

    public GetUploadedDocumentsRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * account holder code, whose uploaded documents have to be retrieved
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public GetUploadedDocumentsRequest bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    /**
     * The unique identifier of the bank for which the stament needs to be retrieved
     *
     * @return bankAccountUUID
     **/
    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public GetUploadedDocumentsRequest shareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
        return this;
    }

    /**
     * shareholder code, whose uploaded documents have to be retrieved
     *
     * @return shareholderCode
     **/
    public String getShareholderCode() {
        return shareholderCode;
    }

    public void setShareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        GetUploadedDocumentsRequest getUploadedDocumentsRequest = (GetUploadedDocumentsRequest) o;
        return Objects.equals(this.accountHolderCode, getUploadedDocumentsRequest.accountHolderCode)
                && Objects.equals(this.bankAccountUUID, getUploadedDocumentsRequest.bankAccountUUID)
                && Objects.equals(this.shareholderCode, getUploadedDocumentsRequest.shareholderCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, bankAccountUUID, shareholderCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetUploadedDocumentsRequest {").append(TextConstants.LINE_BREAK);

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append(TextConstants.LINE_BREAK);
        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append(TextConstants.LINE_BREAK);
        sb.append("    shareholderCode: ").append(toIndentedString(shareholderCode)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}

