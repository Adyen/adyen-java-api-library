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
 * GetTaxFormRequest
 */

public class GetTaxFormRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("formType")
    private String formType = null;

    @SerializedName("year")
    private Integer year = null;

    public GetTaxFormRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The account holder code you provided when you created the account holder.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public GetTaxFormRequest formType(String formType) {
        this.formType = formType;
        return this;
    }

    /**
     * Type of the requested tax form. For example, 1099-K.
     *
     * @return formType
     **/
    public String getFormType() {
        return formType;
    }

    public void setFormType(String formType) {
        this.formType = formType;
    }

    public GetTaxFormRequest year(Integer year) {
        this.year = year;
        return this;
    }

    /**
     * Applicable tax year in the YYYY format.
     *
     * @return year
     **/
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetTaxFormRequest getTaxFormRequest = (GetTaxFormRequest) o;
        return Objects.equals(this.accountHolderCode, getTaxFormRequest.accountHolderCode) &&
                Objects.equals(this.formType, getTaxFormRequest.formType) &&
                Objects.equals(this.year, getTaxFormRequest.year);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, formType, year);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetTaxFormRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    formType: ").append(toIndentedString(formType)).append("\n");
        sb.append("    year: ").append(toIndentedString(year)).append("\n");
        sb.append("}");
        return sb.toString();
    }


}
