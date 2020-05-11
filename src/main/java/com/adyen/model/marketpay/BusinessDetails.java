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
 * BusinessDetails
 */
public class BusinessDetails {
    @SerializedName("doingBusinessAs")
    private String doingBusinessAs = null;

    @SerializedName("incorporatedAt")
    private String incorporatedAt = null;

    @SerializedName("legalBusinessName")
    private String legalBusinessName = null;

    @SerializedName("registrationNumber")
    private String registrationNumber = null;

    @SerializedName("shareholders")
    private List<ShareholderContact> shareholders = null;

    @SerializedName("taxId")
    private String taxId = null;

    public BusinessDetails doingBusinessAs(String doingBusinessAs) {
        this.doingBusinessAs = doingBusinessAs;
        return this;
    }

    /**
     * The registered name of the company (if it differs from the legal name of the company).
     *
     * @return doingBusinessAs
     **/
    public String getDoingBusinessAs() {
        return doingBusinessAs;
    }

    public void setDoingBusinessAs(String doingBusinessAs) {
        this.doingBusinessAs = doingBusinessAs;
    }

    public BusinessDetails incorporatedAt(String incorporatedAt) {
        this.incorporatedAt = incorporatedAt;
        return this;
    }

    /**
     * The jurisdiction of incorporation of the company.  &gt;Two (2) characters for a business in the USA or Canada, or a maximum of three (3) characters for an address in all other countries, or &#x27;FEDERAL&#x27;
     *
     * @return incorporatedAt
     **/
    public String getIncorporatedAt() {
        return incorporatedAt;
    }

    public void setIncorporatedAt(String incorporatedAt) {
        this.incorporatedAt = incorporatedAt;
    }

    public BusinessDetails legalBusinessName(String legalBusinessName) {
        this.legalBusinessName = legalBusinessName;
        return this;
    }

    /**
     * The legal name of the company.
     *
     * @return legalBusinessName
     **/
    public String getLegalBusinessName() {
        return legalBusinessName;
    }

    public void setLegalBusinessName(String legalBusinessName) {
        this.legalBusinessName = legalBusinessName;
    }

    public BusinessDetails registrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
        return this;
    }

    /**
     * The registration number of the company.
     *
     * @return registrationNumber
     **/
    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public BusinessDetails shareholders(List<ShareholderContact> shareholders) {
        this.shareholders = shareholders;
        return this;
    }

    public BusinessDetails addShareholdersItem(ShareholderContact shareholdersItem) {
        if (this.shareholders == null) {
            this.shareholders = new ArrayList<>();
        }
        this.shareholders.add(shareholdersItem);
        return this;
    }

    /**
     * Each of the shareholders associated with the company. Each array entry should represent one shareholder.
     *
     * @return shareholders
     **/
    public List<ShareholderContact> getShareholders() {
        return shareholders;
    }

    public void setShareholders(List<ShareholderContact> shareholders) {
        this.shareholders = shareholders;
    }

    public BusinessDetails taxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    /**
     * The tax ID of the company.
     *
     * @return taxId
     **/
    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BusinessDetails businessDetails = (BusinessDetails) o;
        return Objects.equals(this.doingBusinessAs, businessDetails.doingBusinessAs) &&
                Objects.equals(this.incorporatedAt, businessDetails.incorporatedAt) &&
                Objects.equals(this.legalBusinessName, businessDetails.legalBusinessName) &&
                Objects.equals(this.registrationNumber, businessDetails.registrationNumber) &&
                Objects.equals(this.shareholders, businessDetails.shareholders) &&
                Objects.equals(this.taxId, businessDetails.taxId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doingBusinessAs, incorporatedAt, legalBusinessName, registrationNumber, shareholders, taxId);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BusinessDetails {\n");

        sb.append("    doingBusinessAs: ").append(toIndentedString(doingBusinessAs)).append("\n");
        sb.append("    incorporatedAt: ").append(toIndentedString(incorporatedAt)).append("\n");
        sb.append("    legalBusinessName: ").append(toIndentedString(legalBusinessName)).append("\n");
        sb.append("    registrationNumber: ").append(toIndentedString(registrationNumber)).append("\n");
        sb.append("    shareholders: ").append(toIndentedString(shareholders)).append("\n");
        sb.append("    taxId: ").append(toIndentedString(taxId)).append("\n");
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
