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

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * GetUploadedDocumentsResponse
 */
public class GetUploadedDocumentsResponse {
    @SerializedName("documentDetails")
    private List<DocumentDetailContainer> documentDetailsContainers = null;

    private transient List<DocumentDetail> documentDetails = null;

    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    /**
     * Populate the virtual documentDetails to bypass the documentDetailsContainers list
     *
     * @return documentDetails
     **/
    public List<DocumentDetail> getDocumentDetails() {
        if (documentDetails == null) {
            documentDetails = new ArrayList<DocumentDetail>();

            if (documentDetailsContainers != null && ! documentDetailsContainers.isEmpty()) {
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
        this.documentDetailsContainers = new ArrayList<DocumentDetailContainer>();
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
            documentDetailsContainers = new ArrayList<DocumentDetailContainer>();
        }
        this.documentDetailsContainers.add(documentDetailContainer);

        if (documentDetails == null) {
            documentDetails = new ArrayList<DocumentDetail>();
        }
        this.documentDetails.add(documentDetail);

        return this;
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
        return Objects.equals(this.documentDetailsContainers, getUploadedDocumentsResponse.documentDetails)
                && Objects.equals(this.submittedAsync, getUploadedDocumentsResponse.submittedAsync)
                && Objects.equals(this.pspReference, getUploadedDocumentsResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentDetailsContainers, submittedAsync, pspReference);
    }


    @Override
    public String toString() {
        // Populate the documentDetails list to provide back in the toString() method
        this.getDocumentDetails();

        StringBuilder sb = new StringBuilder();
        sb.append("class GetUploadedDocumentsResponse {\n");

        sb.append("    documentDetails: ").append(toIndentedString(documentDetails)).append("\n");
        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

