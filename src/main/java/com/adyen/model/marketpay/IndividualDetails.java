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
import com.adyen.model.Name;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * IndividualDetails
 */
public class IndividualDetails {
    @SerializedName("personalData")
    private PersonalData personalData = null;

    @SerializedName("name")
    private Name name = null;

    public IndividualDetails personalData(PersonalData personalData) {
        this.personalData = personalData;
        return this;
    }

    /**
     * the account holder personal data
     *
     * @return personalData
     **/
    public PersonalData getPersonalData() {
        return personalData;
    }

    public void setPersonalData(PersonalData personalData) {
        this.personalData = personalData;
    }

    public IndividualDetails name(Name name) {
        this.name = name;
        return this;
    }

    /**
     * thea account holder name
     *
     * @return name
     **/
    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        IndividualDetails individualDetails = (IndividualDetails) o;
        return Objects.equals(this.personalData, individualDetails.personalData) && Objects.equals(this.name, individualDetails.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(personalData, name);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class IndividualDetails {").append(TextConstants.LINE_BREAK);

        sb.append("    personalData: ").append(Util.toIndentedString(personalData)).append(TextConstants.LINE_BREAK);
        sb.append("    name: ").append(Util.toIndentedString(name)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}

