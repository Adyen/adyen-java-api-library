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
 * BusinessDetails
 */
public class BusinessDetails {
    @SerializedName("shareholders")
    private List<ShareholderContact> shareholders = new ArrayList<ShareholderContact>();

    @SerializedName("doingBusinessAs")
    private String doingBusinessAs = null;

    @SerializedName("taxId")
    private String taxId = null;

    @SerializedName("legalBusinessName")
    private String legalBusinessName = null;

    public BusinessDetails shareholders(List<ShareholderContact> shareholders) {
        this.shareholders = shareholders;
        return this;
    }

    public BusinessDetails addShareholdersItem(ShareholderContact shareholdersItem) {
        this.shareholders.add(shareholdersItem);
        return this;
    }

    /**
     * the business legal entity shareholders
     *
     * @return shareholders
     **/
    public List<ShareholderContact> getShareholders() {
        return shareholders;
    }

    public void setShareholders(List<ShareholderContact> shareholders) {
        this.shareholders = shareholders;
    }

    public BusinessDetails doingBusinessAs(String doingBusinessAs) {
        this.doingBusinessAs = doingBusinessAs;
        return this;
    }

    /**
     * if the registered name of the business differs from the legal name
     *
     * @return doingBusinessAs
     **/
    public String getDoingBusinessAs() {
        return doingBusinessAs;
    }

    public void setDoingBusinessAs(String doingBusinessAs) {
        this.doingBusinessAs = doingBusinessAs;
    }

    public BusinessDetails taxId(String taxId) {
        this.taxId = taxId;
        return this;
    }

    /**
     * the account holder tax id
     *
     * @return taxId
     **/
    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public BusinessDetails legalBusinessName(String legalBusinessName) {
        this.legalBusinessName = legalBusinessName;
        return this;
    }

    /**
     * the legal name of the business
     *
     * @return legalBusinessName
     **/
    public String getLegalBusinessName() {
        return legalBusinessName;
    }

    public void setLegalBusinessName(String legalBusinessName) {
        this.legalBusinessName = legalBusinessName;
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
        return Objects.equals(this.shareholders, businessDetails.shareholders)
                && Objects.equals(this.doingBusinessAs, businessDetails.doingBusinessAs)
                && Objects.equals(this.taxId,
                                  businessDetails.taxId)
                && Objects.equals(this.legalBusinessName, businessDetails.legalBusinessName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shareholders, doingBusinessAs, taxId, legalBusinessName);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BusinessDetails {\n");

        sb.append("    shareholders: ").append(toIndentedString(shareholders)).append("\n");
        sb.append("    doingBusinessAs: ").append(toIndentedString(doingBusinessAs)).append("\n");
        sb.append("    taxId: ").append(toIndentedString(taxId)).append("\n");
        sb.append("    legalBusinessName: ").append(toIndentedString(legalBusinessName)).append("\n");
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

