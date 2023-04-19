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

import static com.adyen.util.Util.toIndentedString;

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

    @SerializedName("signatories")
    private List<SignatoryContact> signatories = null;

    @SerializedName("stockExchange")
    private String stockExchange = null;

    @SerializedName("stockNumber")
    private String stockNumber = null;

    @SerializedName("stockTicker")
    private String stockTicker = null;

    @SerializedName("taxId")
    private String taxId = null;

    @SerializedName("listedUltimateParentCompany")
    private List<UltimateParentCompany> listedUltimateParentCompany = null;

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

    public BusinessDetails signatories(List<SignatoryContact> signatories) {
        this.signatories = signatories;
        return this;
    }

    public BusinessDetails addSignatoriesItem(SignatoryContact signatoriesItem) {
        if (this.signatories == null) {
            this.signatories = new ArrayList<>();
        }
        this.signatories.add(signatoriesItem);
        return this;
    }

    /**
     * Each of the signatories associated with the company. Each array entry should represent one shareholder.
     *
     * @return signatories
     **/
    public List<SignatoryContact> getSignatories() {
        return signatories;
    }

    public void setSignatories(List<SignatoryContact> signatories) {
        this.signatories = signatories;
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

    public BusinessDetails stockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
        return this;
    }

    /**
     * Market Identifier Code (MIC)
     *
     * @return stockExchange
     */
    public String getStockExchange() {
        return stockExchange;
    }

    public void setStockExchange(String stockExchange) {
        this.stockExchange = stockExchange;
    }

    public BusinessDetails stockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
        return this;
    }

    /**
     * International Securities Identification Number (ISIN)
     *
     * @return stockNumber
     */
    public String getStockNumber() {
        return stockNumber;
    }

    public void setStockNumber(String stockNumber) {
        this.stockNumber = stockNumber;
    }

    public BusinessDetails stockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
        return this;
    }

    /**
     * Stock Ticker symbol.
     *
     * @return stockTicker
     */
    public String getStockTicker() {
        return stockTicker;
    }

    public void setStockTicker(String stockTicker) {
        this.stockTicker = stockTicker;
    }

    /**
     * Information about the parent public company. Required if the account holder is 100% owned by a publicly listed
     * company.
     *
     * @return listedUltimateParentCompany
     */
    public List<UltimateParentCompany> getListedUltimateParentCompany() {
        return listedUltimateParentCompany;
    }

    public void setListedUltimateParentCompany(List<UltimateParentCompany> listedUltimateParentCompany) {
        this.listedUltimateParentCompany = listedUltimateParentCompany;
    }

    public BusinessDetails listedUltimateParentCompany(List<UltimateParentCompany> listedUltimateParentCompany) {
        this.listedUltimateParentCompany = listedUltimateParentCompany;
        return this;
    }

    public BusinessDetails addListedUltimateParentCompanyItem(UltimateParentCompany listedUltimateParentCompanyItem) {
        if (this.listedUltimateParentCompany == null) {
            this.listedUltimateParentCompany = new ArrayList<>();
        }
        this.listedUltimateParentCompany.add(listedUltimateParentCompanyItem);
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
        BusinessDetails businessDetails = (BusinessDetails) o;
        return Objects.equals(this.doingBusinessAs, businessDetails.doingBusinessAs) &&
                Objects.equals(this.incorporatedAt, businessDetails.incorporatedAt) &&
                Objects.equals(this.legalBusinessName, businessDetails.legalBusinessName) &&
                Objects.equals(this.registrationNumber, businessDetails.registrationNumber) &&
                Objects.equals(this.shareholders, businessDetails.shareholders) &&
                Objects.equals(this.signatories, businessDetails.signatories) &&
                Objects.equals(this.stockExchange, businessDetails.stockExchange) &&
                Objects.equals(this.stockNumber, businessDetails.stockNumber) &&
                Objects.equals(this.stockTicker, businessDetails.stockTicker) &&
                Objects.equals(this.taxId, businessDetails.taxId) &&
                Objects.equals(this.listedUltimateParentCompany, businessDetails.listedUltimateParentCompany);
    }

    @Override
    public int hashCode() {
        return Objects.hash(doingBusinessAs, incorporatedAt, legalBusinessName, registrationNumber, shareholders, signatories, stockExchange, stockNumber, stockTicker, taxId, listedUltimateParentCompany);
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
        sb.append("    signatories: ").append(toIndentedString(signatories)).append("\n");
        sb.append("    stockExchange: ").append(toIndentedString(stockExchange)).append("\n");
        sb.append("    stockNumber: ").append(toIndentedString(stockNumber)).append("\n");
        sb.append("    stockTicker: ").append(toIndentedString(stockTicker)).append("\n");
        sb.append("    taxId: ").append(toIndentedString(taxId)).append("\n");
        sb.append("    listedUltimateParentCompany: ").append(toIndentedString(listedUltimateParentCompany)).append("\n");
        sb.append("}");
        return sb.toString();
    }


}
