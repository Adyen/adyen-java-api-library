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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.binlookup;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * BinDetail
 */
public class BinDetail {

    @SerializedName("issuerCountry")
    private String issuerCountry = null;

    public BinDetail issuerCountry(String issuerCountry) {
        this.issuerCountry = issuerCountry;
        return this;
    }

    /**
     * The country where the card was issued.
     *
     * @return issuerCountry
     **/
    public String getIssuerCountry() {
        return issuerCountry;
    }

    public void setIssuerCountry(String issuerCountry) {
        this.issuerCountry = issuerCountry;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BinDetail binDetail = (BinDetail) o;
        return Objects.equals(this.issuerCountry, binDetail.issuerCountry);
    }

    @Override
    public int hashCode() {
        return Objects.hash(issuerCountry);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BinDetail {\n");
        sb.append("    issuerCountry: ").append(toIndentedString(issuerCountry)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
