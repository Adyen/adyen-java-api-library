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
        if (o == null || getClass() != o.getClass()) {
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
        sb.append("class TierConfiguration {\n");

        sb.append("    tiers: ").append(toIndentedString(tiers)).append("\n");
        sb.append("    countryCode: ").append(toIndentedString(countryCode)).append("\n");
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

