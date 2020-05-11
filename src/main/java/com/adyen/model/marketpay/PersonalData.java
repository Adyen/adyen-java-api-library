
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
 * PersonalData
 */
public class PersonalData {
    @SerializedName("dateOfBirth")
    private String dateOfBirth = null;

    @SerializedName("documentData")
    private List<PersonalDocumentData> documentData = null;

    @SerializedName("nationality")
    private String nationality = null;

    public PersonalData dateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * The date of birth of the person. The date should be in ISO-8601 format yyyy-mm-dd (e.g. 2000-01-31).
     *
     * @return dateOfBirth
     **/
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PersonalData documentData(List<PersonalDocumentData> documentData) {
        this.documentData = documentData;
        return this;
    }

    public PersonalData addDocumentDataItem(PersonalDocumentData documentDataItem) {
        if (this.documentData == null) {
            this.documentData = new ArrayList<>();
        }
        this.documentData.add(documentDataItem);
        return this;
    }

    /**
     * Key value pairs of document type and identify numbers
     *
     * @return documentData
     **/
    public List<PersonalDocumentData> getDocumentData() {
        return documentData;
    }

    public void setDocumentData(List<PersonalDocumentData> documentData) {
        this.documentData = documentData;
    }

    public PersonalData nationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    /**
     * The nationality of the person represented by a two-character country code. &gt;The permitted country codes are defined in ISO-3166-1 alpha-2 (e.g. &#x27;NL&#x27;).
     *
     * @return nationality
     **/
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PersonalData personalData = (PersonalData) o;
        return Objects.equals(this.dateOfBirth, personalData.dateOfBirth) &&
                Objects.equals(this.documentData, personalData.documentData) &&
                Objects.equals(this.nationality, personalData.nationality);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateOfBirth, documentData, nationality);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PersonalData {\n");

        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    documentData: ").append(toIndentedString(documentData)).append("\n");
        sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
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
