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
 * DocumentDetailContainer
 */
public class DocumentDetailContainer {
    @SerializedName("DocumentDetail")
    private DocumentDetail documentDetail = null;

    public DocumentDetailContainer(DocumentDetail documentDetail) {
        this.documentDetail = documentDetail;
    }

    /**
     * documentDetail
     *
     * @return documentDetail
     */
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
        DocumentDetailContainer documentDetailContainer = (DocumentDetailContainer) o;
        return Objects.equals(this.documentDetail, documentDetailContainer.documentDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(documentDetail);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DocumentDetailContainer {\n");

        sb.append("    documentDetail: ").append(toIndentedString(documentDetail)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
