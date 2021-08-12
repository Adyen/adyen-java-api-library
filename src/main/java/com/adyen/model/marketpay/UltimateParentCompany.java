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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay;

import com.adyen.model.Address;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * UltimateParentCompany
 */
public class UltimateParentCompany {
    @SerializedName("address")
    private Address address = null;

    @SerializedName("businessDetails")
    private UltimateParentCompanyBusinessDetails businessDetails = null;

    @SerializedName("ultimateParentCompanyCode")
    private String ultimateParentCompanyCode = null;

    /**
     * Address of the ultimate parent company.
     *
     * @return address
     */
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public UltimateParentCompany address(Address address) {
        this.address = address;
        return this;
    }

    /**
     * Details about the ultimate parent company's business.
     *
     * @return businessDetails
     */
    public UltimateParentCompanyBusinessDetails getBusinessDetails() {
        return businessDetails;
    }

    public void setBusinessDetails(UltimateParentCompanyBusinessDetails businessDetails) {
        this.businessDetails = businessDetails;
    }

    public UltimateParentCompany businessDetails(UltimateParentCompanyBusinessDetails businessDetails) {
        this.businessDetails = businessDetails;
        return this;
    }

    /**
     * Adyen-generated unique alphanumeric identifier (UUID) for the entry, returned in the response when you create an
     * ultimate parent company. Required when updating an existing entry in an /updateAccountHolder request.
     *
     * @return ultimateParentCompanyCode
     */
    public String getUltimateParentCompanyCode() {
        return ultimateParentCompanyCode;
    }

    public void setUltimateParentCompanyCode(String ultimateParentCompanyCode) {
        this.ultimateParentCompanyCode = ultimateParentCompanyCode;
    }

    public UltimateParentCompany ultimateParentCompanyCode(String ultimateParentCompanyCode) {
        this.ultimateParentCompanyCode = ultimateParentCompanyCode;
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
        UltimateParentCompany ultimateParentCompany = (UltimateParentCompany) o;
        return Objects.equals(this.address, ultimateParentCompany.address) &&
                Objects.equals(this.businessDetails, ultimateParentCompany.businessDetails) &&
                Objects.equals(this.ultimateParentCompanyCode, ultimateParentCompany.ultimateParentCompanyCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, businessDetails, ultimateParentCompanyCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UltimateParentCompany {\n");

        sb.append("    address: ").append(toIndentedString(address)).append("\n");
        sb.append("    businessDetails: ").append(toIndentedString(businessDetails)).append("\n");
        sb.append("    ultimateParentCompanyCode: ").append(toIndentedString(ultimateParentCompanyCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
