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
 * BusinessDetails
 */
public class BusinessDetails {
    @SerializedName("shareholders")
    private List<ShareholderContactContainer> shareholderContactContainers = null;

    private transient List<ShareholderContact> shareholders = null;

    @SerializedName("doingBusinessAs")
    private String doingBusinessAs = null;

    @SerializedName("taxId")
    private String taxId = null;

    @SerializedName("legalBusinessName")
    private String legalBusinessName = null;

    @SerializedName("registrationNumber")
    private String registrationNumber = null;

    /**
     * Populate the virtual shareholders to bypass the shareholderContactContainers list
     *
     * @return shareholders
     **/
    public List<ShareholderContact> getShareholders() {
        if (shareholders == null) {
            shareholders = new ArrayList<ShareholderContact>();

            if (shareholderContactContainers != null && !shareholderContactContainers.isEmpty()) {
                for (ShareholderContactContainer shareholderContactContainer : shareholderContactContainers) {
                    shareholders.add((shareholderContactContainer.getShareholderContact()));
                }
            }
        }
        return shareholders;
    }


    /**
     * Creating a new shareholders list
     *
     * @param shareholders shareholders
     */
    public void setShareholders(List<ShareholderContact> shareholders) {
        this.shareholders = shareholders;

        // set as well the container list this will be send in the API request
        this.shareholderContactContainers = new ArrayList<ShareholderContactContainer>();
        for (ShareholderContact shareholderContact : shareholders) {

            ShareholderContactContainer shareholderContactContainer = new ShareholderContactContainer(shareholderContact);
            this.shareholderContactContainers.add(shareholderContactContainer);
        }
    }

    /**
     * Add shareholderContact to the shareholderContactContainers and shareholders list
     *
     * @param shareholderContact shareholderContact
     * @return BusinessDetails
     */
    public BusinessDetails addShareholderContact(ShareholderContact shareholderContact) {
        ShareholderContactContainer shareholderContactContainer = new ShareholderContactContainer(shareholderContact);

        if (shareholderContactContainers == null) {
            shareholderContactContainers = new ArrayList<ShareholderContactContainer>();
        }
        this.shareholderContactContainers.add(shareholderContactContainer);

        if (shareholders == null) {
            shareholders = new ArrayList<ShareholderContact>();
        }
        this.shareholders.add(shareholderContact);

        return this;
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

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
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
        return Objects.equals(this.shareholderContactContainers, businessDetails.shareholderContactContainers)
                && Objects.equals(this.doingBusinessAs, businessDetails.doingBusinessAs)
                && Objects.equals(this.taxId, businessDetails.taxId)
                && Objects.equals(this.legalBusinessName, businessDetails.legalBusinessName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shareholderContactContainers, doingBusinessAs, taxId, legalBusinessName);
    }


    @Override
    public String toString() {
        // Populate the shareholders list to provide back in the toString() method
        this.getShareholders();

        StringBuilder sb = new StringBuilder();
        sb.append("class BusinessDetails {\n");

        sb.append("    shareholders: ").append(toIndentedString(shareholders)).append("\n");
        sb.append("    doingBusinessAs: ").append(toIndentedString(doingBusinessAs)).append("\n");
        sb.append("    taxId: ").append(toIndentedString(taxId)).append("\n");
        sb.append("    legalBusinessName: ").append(toIndentedString(legalBusinessName)).append("\n");
        sb.append("    registrationNumber: ").append(toIndentedString(registrationNumber)).append("\n");
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