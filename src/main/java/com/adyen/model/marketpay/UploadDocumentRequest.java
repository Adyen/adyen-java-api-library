
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
 * UploadDocumentRequest
 */
public class UploadDocumentRequest {
    @SerializedName("documentContent")
    private String documentContent = null;

    @SerializedName("documentDetail")
    private DocumentDetail documentDetail = null;

    public UploadDocumentRequest documentContent(String documentContent) {
        this.documentContent = documentContent;
        return this;
    }

    /**
     * The content of the document as represented by a Base64-encoded string.  To learn about requirements, see [Bank account check](https://docs.adyen.com/marketpay/onboarding-and-verification/verification-checks/bank-account-check#requirements) and [Photo ID check](https://docs.adyen.com/marketpay/onboarding-and-verification/verification-checks/photo-id-check#requirements).
     *
     * @return documentContent
     **/
    public String getDocumentContent() {
        return documentContent;
    }

    public void setDocumentContent(String documentContent) {
        this.documentContent = documentContent;
    }

    public UploadDocumentRequest documentDetail(DocumentDetail documentDetail) {
        this.documentDetail = documentDetail;
        return this;
    }

    /**
     * Get documentDetail
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
        return Objects.equals(this.documentContent, uploadDocumentRequest.documentContent) &&
                Objects.equals(this.documentDetail, uploadDocumentRequest.documentDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentContent, documentDetail);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UploadDocumentRequest {\n");

        sb.append("    documentContent: ").append(toIndentedString(documentContent)).append("\n");
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
