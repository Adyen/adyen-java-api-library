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

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * DocumentDetail
 */
public class DocumentDetail {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("bankAccountUUID")
    private String bankAccountUUID = null;

    @SerializedName("filename")
    private String filename = null;

    /**
     * document type
     */
    public enum DocumentTypeEnum {
        @SerializedName("BANK_STATEMENT")
        BANK_STATEMENT("BANK_STATEMENT"),

        @SerializedName("BSN")
        BSN("BSN"),

        @SerializedName("COMPANY_REGISTRATION_SCREENING")
        COMPANY_REGISTRATION_SCREENING("COMPANY_REGISTRATION_SCREENING"),

        @SerializedName("CONSTITUTIONAL_DOCUMENT")
        CONSTITUTIONAL_DOCUMENT("CONSTITUTIONAL_DOCUMENT"),

        @SerializedName("DRIVING_LICENCE")
        DRIVING_LICENCE("DRIVING_LICENCE"),

        @SerializedName("DRIVING_LICENCE_BACK")
        DRIVING_LICENCE_BACK("DRIVING_LICENCE_BACK"),

        @SerializedName("DRIVING_LICENCE_FRONT")
        DRIVING_LICENCE_FRONT("DRIVING_LICENCE_FRONT"),

        @SerializedName("ID_CARD")
        ID_CARD("ID_CARD"),

        @SerializedName("ID_CARD_BACK")
        ID_CARD_BACK("ID_CARD_BACK"),

        @SerializedName("ID_CARD_FRONT")
        ID_CARD_FRONT("ID_CARD_FRONT"),

        @SerializedName("NHIS")
        NHIS("NHIS"),

        @SerializedName("PASSPORT")
        PASSPORT("PASSPORT"),

        @SerializedName("SSN")
        SSN("SSN"),

        @SerializedName("SUPPORTING_DOCUMENTS")
        SUPPORTING_DOCUMENTS("SUPPORTING_DOCUMENTS");

        @JsonValue
        private final String value;

        DocumentTypeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("documentType")
    private DocumentTypeEnum documentType = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("shareholderCode")
    private String shareholderCode = null;

    @SerializedName("signatoryCode")
    private String signatoryCode = null;

    public DocumentDetail accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * account holder code
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public DocumentDetail bankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
        return this;
    }

    /**
     * account holder's bank account UUID. Populated only if the document is a bank statement and it is uploaded for a bank account
     *
     * @return bankAccountUUID
     **/
    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public DocumentDetail filename(String filename) {
        this.filename = filename;
        return this;
    }

    /**
     * document name
     *
     * @return filename
     **/
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public DocumentDetail documentType(DocumentTypeEnum documentType) {
        this.documentType = documentType;
        return this;
    }

    /**
     * document type
     *
     * @return documentType
     **/
    public DocumentTypeEnum getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentTypeEnum documentType) {
        this.documentType = documentType;
    }

    public DocumentDetail description(String description) {
        this.description = description;
        return this;
    }

    /**
     * document description
     *
     * @return description
     **/
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public DocumentDetail shareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
        return this;
    }

    /**
     * account holder's shareholder code. Populated only if the document is uploaded for a shareholder
     *
     * @return shareholderCode
     **/
    public String getShareholderCode() {
        return shareholderCode;
    }

    public void setShareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
    }

    /**
     * The Adyen-generated signatoryCode to which the document must be linked.
     * Populated only if the document is uploaded for a signatory.
     *
     * @return signatoryCode
     **/
    public String getSignatoryCode() {
        return signatoryCode;
    }

    public void setSignatoryCode(String signatoryCode) {
        this.signatoryCode = signatoryCode;
    }

    public DocumentDetail signatoryCode(String signatoryCode) {
        this.signatoryCode = signatoryCode;
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
        DocumentDetail documentDetail = (DocumentDetail) o;
        return Objects.equals(this.accountHolderCode, documentDetail.accountHolderCode)
                && Objects.equals(this.bankAccountUUID, documentDetail.bankAccountUUID)
                && Objects.equals(this.filename,
                                  documentDetail.filename)
                && Objects.equals(this.documentType, documentDetail.documentType)
                && Objects.equals(this.description, documentDetail.description)
                && Objects.equals(this.shareholderCode, documentDetail.shareholderCode)
                && Objects.equals(this.signatoryCode, documentDetail.signatoryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, bankAccountUUID, filename, documentType, description, shareholderCode, signatoryCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DocumentDetail {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    bankAccountUUID: ").append(toIndentedString(bankAccountUUID)).append("\n");
        sb.append("    filename: ").append(toIndentedString(filename)).append("\n");
        sb.append("    documentType: ").append(toIndentedString(documentType)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    shareholderCode: ").append(toIndentedString(shareholderCode)).append("\n");
        sb.append("    signatoryCode: ").append(toIndentedString(signatoryCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}

