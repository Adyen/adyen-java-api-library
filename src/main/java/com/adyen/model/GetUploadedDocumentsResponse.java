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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * GetUploadedDocumentsResponse
 */
public class GetUploadedDocumentsResponse {
    @SerializedName("documentDetails")
    private List<DocumentDetail> documentDetails = new ArrayList<DocumentDetail>();

    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public GetUploadedDocumentsResponse documentDetails(List<DocumentDetail> documentDetails) {
        this.documentDetails = documentDetails;
        return this;
    }

    public GetUploadedDocumentsResponse addDocumentDetailsItem(DocumentDetail documentDetailsItem) {
        this.documentDetails.add(documentDetailsItem);
        return this;
    }

    /**
     * details of uploaded documents
     *
     * @return documentDetails
     **/
    public List<DocumentDetail> getDocumentDetails() {
        return documentDetails;
    }

    public void setDocumentDetails(List<DocumentDetail> documentDetails) {
        this.documentDetails = documentDetails;
    }

    public GetUploadedDocumentsResponse submittedAsync(Boolean submittedAsync) {
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

    public GetUploadedDocumentsResponse pspReference(String pspReference) {
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
        GetUploadedDocumentsResponse getUploadedDocumentsResponse = (GetUploadedDocumentsResponse) o;
        return Objects.equals(this.documentDetails, getUploadedDocumentsResponse.documentDetails) && Objects.equals(this.submittedAsync, getUploadedDocumentsResponse.submittedAsync) && Objects.equals(
                this.pspReference,
                getUploadedDocumentsResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentDetails, submittedAsync, pspReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetUploadedDocumentsResponse {\n");

        sb.append("    documentDetails: ").append(toIndentedString(documentDetails)).append("\n");
        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
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

