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

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * TierConfiguration
 */
public class TierConfiguration {
    @SerializedName("tiers")
    private List<Tier> tiers = new ArrayList<>();

    @SerializedName("countryCode")
    private String countryCode = null;

    public TierConfiguration tiers(List<Tier> tiers) {
        this.tiers = tiers;
        return this;
    }

    public TierConfiguration addTiersItem(Tier tiersItem) {
        this.tiers.add(tiersItem);
        return this;
    }

    /**
     * Get tiers
     *
     * @return tiers
     **/
    public List<Tier> getTiers() {
        return tiers;
    }

    public void setTiers(List<Tier> tiers) {
        this.tiers = tiers;
    }

    public TierConfiguration countryCode(String countryCode) {
        this.countryCode = countryCode;
        return this;
    }

    /**
     * Get countryCode
     *
     * @return countryCode
     **/
    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        TierConfiguration tierConfiguration = (TierConfiguration) o;
        return Objects.equals(this.tiers, tierConfiguration.tiers) && Objects.equals(this.countryCode, tierConfiguration.countryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tiers, countryCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TierConfiguration {").append(TextConstants.LINE_BREAK);

        sb.append("    tiers: ").append(Util.toIndentedString(tiers)).append(TextConstants.LINE_BREAK);
        sb.append("    countryCode: ").append(Util.toIndentedString(countryCode)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}

