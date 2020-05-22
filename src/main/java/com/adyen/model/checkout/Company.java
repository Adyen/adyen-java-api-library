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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

/**
 * Company
 */
public class Company {

    @SerializedName("homepage")
    private String homepage = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("registrationNumber")
    private String registrationNumber = null;

    @SerializedName("registryLocation")
    private String registryLocation = null;

    @SerializedName("taxId")
    private String taxId = null;

    @SerializedName("type")
    private String type = null;

    public Company homepage(String homepage) {
        this.homepage = homepage;
        return this;
    }


    /**
     * The company website&#x27;s home page.
     *
     * @return homepage
     **/
    public String getHomepage() {
        return homepage;
    }

    public void setHomepage(String homepage) {
        this.homepage = homepage;
    }

    public Company name(String name) {
        this.name = name;
        return this;
    }


    /**
     * The company name.
     *
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Company registrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }


    /**
     * Registration number of the company.
     *
     * @return registrationNumber
     **/
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Company registryLocation(String registryLocation) {
        this.registryLocation = registryLocation;
        return this;
    }


    /**
     * Registry location of the company.
     *
     * @return registryLocation
     **/
    public String getRegistryLocation() {
        return registryLocation;
    }

    public void setRegistryLocation(String registryLocation) {
        this.registryLocation = registryLocation;
    }

    public Company taxId(String taxId) {
        this.taxId = taxId;
        return this;
    }


    /**
     * Tax ID of the company.
     *
     * @return taxId
     **/
    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public Company type(String type) {
        this.type = type;
        return this;
    }


    /**
     * The company type.
     *
     * @return type
     **/
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        Company company = (Company) o;
        return Objects.equals(this.homepage, company.homepage) &&
                Objects.equals(this.name, company.name) &&
                Objects.equals(this.registrationNumber, company.registrationNumber) &&
                Objects.equals(this.registryLocation, company.registryLocation) &&
                Objects.equals(this.taxId, company.taxId) &&
                Objects.equals(this.type, company.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homepage, name, registrationNumber, registryLocation, taxId, type);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Company {").append(LINE_BREAK);

        sb.append("    homepage: ").append(toIndentedString(homepage)).append(LINE_BREAK);
        sb.append("    name: ").append(toIndentedString(name)).append(LINE_BREAK);
        sb.append("    registrationNumber: ").append(toIndentedString(registrationNumber)).append(LINE_BREAK);
        sb.append("    registryLocation: ").append(toIndentedString(registryLocation)).append(LINE_BREAK);
        sb.append("    taxId: ").append(toIndentedString(taxId)).append(LINE_BREAK);
        sb.append("    type: ").append(toIndentedString(type)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }




}



