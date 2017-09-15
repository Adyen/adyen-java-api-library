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

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * PersonalData
 */
public class PersonalData {
    @SerializedName("nationality")
    private String nationality = null;

    @SerializedName("dateOfBirth")
    private String dateOfBirth = null;

    @SerializedName("idNumber")
    private String idNumber = null;

    public PersonalData nationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    /**
     * The person's nationality represented by an ISO two-character country code (e.g. \"NL\").
     *
     * @return nationality
     **/
    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public PersonalData dateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        return this;
    }

    /**
     * The person's date of birth. The date should be in ISO format yyyy-mm-dd (e.g. 2000-01-31).
     *
     * @return dateOfBirth
     **/
    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public PersonalData idNumber(String idNumber) {
        this.idNumber = idNumber;
        return this;
    }

    /**
     * The person's ID number.
     *
     * @return idNumber
     **/
    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
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
        return Objects.equals(this.nationality, personalData.nationality) && Objects.equals(this.dateOfBirth, personalData.dateOfBirth) && Objects.equals(this.idNumber, personalData.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nationality, dateOfBirth, idNumber);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PersonalData {\n");

        sb.append("    nationality: ").append(toIndentedString(nationality)).append("\n");
        sb.append("    dateOfBirth: ").append(toIndentedString(dateOfBirth)).append("\n");
        sb.append("    idNumber: ").append(toIndentedString(idNumber)).append("\n");
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

