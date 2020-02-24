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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * GetUploadedDocumentsResponse
 */
public class GetUploadedDocumentsResponse {
    @SerializedName("documentDetails")
    private List<DocumentDetailContainer> documentDetailsContainers = null;

    private transient List<DocumentDetail> documentDetails = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    /**
     * Populate the virtual documentDetails to bypass the documentDetailsContainers list
     *
     * @return documentDetails
     **/
    public List<DocumentDetail> getDocumentDetails() {
        if (documentDetails == null) {
            documentDetails = new ArrayList<>();

            if (documentDetailsContainers != null && !documentDetailsContainers.isEmpty()) {
                for (DocumentDetailContainer documentDetailContainer : documentDetailsContainers) {
                    documentDetails.add(documentDetailContainer.getDocumentDetail());
                }
            }
        }

        return documentDetails;
    }

    /**
     * Creating a new documentDetails list
     *
     * @param documentDetails documentDetails
     */
    public void setDocumentDetails(List<DocumentDetail> documentDetails) {
        this.documentDetails = documentDetails;

        // set as well the container list this will be send in the API request
        this.documentDetailsContainers = new ArrayList<>();
        for (DocumentDetail documentDetail : documentDetails) {

            DocumentDetailContainer documentDetailContainer = new DocumentDetailContainer(documentDetail);
            this.documentDetailsContainers.add(documentDetailContainer);
        }

    }

    /**
     * Add documentDetail to the documentDetailsContainers and documentDetails list
     *
     * @param documentDetail documentDetail
     * @return UploadedDocumentsResponse
     */
    public GetUploadedDocumentsResponse addDocumentDetail(DocumentDetail documentDetail) {
        DocumentDetailContainer documentDetailContainer = new DocumentDetailContainer(documentDetail);

        if (documentDetailsContainers == null) {
            documentDetailsContainers = new ArrayList<>();
        }
        this.documentDetailsContainers.add(documentDetailContainer);

        if (documentDetails == null) {
            documentDetails = new ArrayList<>();
        }
        this.documentDetails.add(documentDetail);

        return this;
    }

    public GetUploadedDocumentsResponse invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public GetUploadedDocumentsResponse addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<ErrorFieldType>();
        }
        this.invalidFields.add(invalidFieldsItem);
        return this;
    }

    /**
     * Contains field validation errors that would prevent requests from being processed.
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    public GetUploadedDocumentsResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * The reference of a request.  Can be used to uniquely identify the request.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public GetUploadedDocumentsResponse resultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * The result code.
     *
     * @return resultCode
     **/
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetUploadedDocumentsResponse getUploadedDocumentsResponse = (GetUploadedDocumentsResponse) o;
        return Objects.equals(this.documentDetails, getUploadedDocumentsResponse.documentDetails) &&
                Objects.equals(this.invalidFields, getUploadedDocumentsResponse.invalidFields) &&
                Objects.equals(this.pspReference, getUploadedDocumentsResponse.pspReference) &&
                Objects.equals(this.resultCode, getUploadedDocumentsResponse.resultCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentDetails, invalidFields, pspReference, resultCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetUploadedDocumentsResponse {\n");

        sb.append("    documentDetails: ").append(toIndentedString(documentDetails)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
