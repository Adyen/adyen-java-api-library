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

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

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
        if (Objects.isNull(o) || getClass() != o.getClass()) {
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
        sb.append("class BinDetail {").append(TextConstants.LINE_BREAK);
        sb.append("    issuerCountry: ").append(Util.toIndentedString(issuerCountry)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}
