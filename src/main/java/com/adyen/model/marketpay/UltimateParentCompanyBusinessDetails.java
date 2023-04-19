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

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * UltimateParentCompanyBusinessDetails
 */
public class UltimateParentCompanyBusinessDetails {
    @SerializedName("legalBusinessName")
    private String legalBusinessName = null;

    @SerializedName("registrationNumber")
    private String registrationNumber = null;

    @SerializedName("stockExchange")
    private String stockExchange = null;

    @SerializedName("stockNumber")
    private String stockNumber = null;

    @SerializedName("stockTicker")
    private String stockTicker = null;


    public UltimateParentCompanyBusinessDetails legalBusinessName(String legalBusinessName) {
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

    public UltimateParentCompanyBusinessDetails registrationNumber(String registrationNumber) {
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

    public UltimateParentCompanyBusinessDetails stockExchange(String stockExchange) {
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

    public UltimateParentCompanyBusinessDetails stockNumber(String stockNumber) {
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

    public UltimateParentCompanyBusinessDetails stockTicker(String stockTicker) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UltimateParentCompanyBusinessDetails businessDetails = (UltimateParentCompanyBusinessDetails) o;
        return Objects.equals(this.legalBusinessName, businessDetails.legalBusinessName) &&
                Objects.equals(this.registrationNumber, businessDetails.registrationNumber) &&
                Objects.equals(this.stockExchange, businessDetails.stockExchange) &&
                Objects.equals(this.stockNumber, businessDetails.stockNumber) &&
                Objects.equals(this.stockTicker, businessDetails.stockTicker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(legalBusinessName, registrationNumber, stockExchange, stockNumber, stockTicker);
    }

    @Override
    public String toString() {
        String sb = "class UltimateParentCompanyBusinessDetails {\n" +
                "    legalBusinessName: " + toIndentedString(legalBusinessName) + "\n" +
                "    registrationNumber: " + toIndentedString(registrationNumber) + "\n" +
                "    stockExchange: " + toIndentedString(stockExchange) + "\n" +
                "    stockNumber: " + toIndentedString(stockNumber) + "\n" +
                "    stockTicker: " + toIndentedString(stockTicker) + "\n" +
                "}";
        return sb;
    }


}
