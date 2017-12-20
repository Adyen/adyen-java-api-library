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

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * UploadDocumentRequest
 */
public class UploadDocumentRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("documentContent")
    private String documentContent = null;

    @SerializedName("shareholderCode")
    private String shareholderCode = null;

    @SerializedName("documentDetail")
    private DocumentDetail documentDetail = null;

    public UploadDocumentRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * code of account holder, whose document has to be uploaded
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public UploadDocumentRequest bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    /**
     * if a document is uploaded it is required to indicate for which bank account this is intended as multiple bank accounts can be linked
     *
     * @return bankAccountUUID
     **/
    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public UploadDocumentRequest documentContent(String documentContent) {
        this.documentContent = documentContent;
        return this;
    }

    /**
     * document content to be uploaded
     *
     * @return documentContent
     **/
    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public UploadDocumentRequest shareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
        return this;
    }

    /**
     * if account holder represents a business legal entity, the documents can be uploaded for the shareholders. Contains shareholder code, whose document has to be uploaded
     *
     * @return shareholderCode
     **/
    public String getShareholderCode() {
        return shareholderCode;
    }

    public void setShareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
    }

    public UploadDocumentRequest documentDetail(DocumentDetail documentDetail) {
        this.documentDetail = documentDetail;
        return this;
    }

    /**
     * properties of the document to be uploaded
     *
     * @return documentDetail
     **/
    public DocumentDetail getDocumentDetail() {
        return documentDetail;
    }

    public void setDocumentDetail(DocumentDetail documentDetail) {
        this.documentDetail = documentDetail;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UploadDocumentRequest uploadDocumentRequest = (UploadDocumentRequest) o;
        return Objects.equals(this.accountHolderCode, uploadDocumentRequest.accountHolderCode)
                && Objects.equals(this.bankAccountUUID, uploadDocumentRequest.bankAccountUUID)
                && Objects.equals(this.documentContent, uploadDocumentRequest.documentContent)
                && Objects.equals(this.shareholderCode, uploadDocumentRequest.shareholderCode)
                && Objects.equals(this.documentDetail, uploadDocumentRequest.documentDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, bankAccountUUID, documentContent, shareholderCode, documentDetail);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UploadDocumentRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append("\n");
        sb.append("    documentContent: ").append(toIndentedString(documentContent)).append("\n");
        sb.append("    shareholderCode: ").append(toIndentedString(shareholderCode)).append("\n");
        sb.append("    documentDetail: ").append(toIndentedString(documentDetail)).append("\n");
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

