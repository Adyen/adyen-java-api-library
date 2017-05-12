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
package com.adyen.model.hpp;

import java.util.Arrays;
import java.util.List;
import com.adyen.Util.Util;
import com.google.gson.annotations.SerializedName;

public class PaymentMethod {
    @SerializedName("brandCode")
    private String brandCode = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("issuers")
    private List<Issuer> issuers;

    public static List<String> cards = Arrays.asList(
            "mc",
            "visadankort",
            "visa",
            "amex",
            "vias",
            "diners",
            "maestrouk",
            "solo",
            "laser",
            "discover",
            "jcb",
            "bcmc",
            "bijcard",
            "dankort",
            "hipercard",
            "maestro",
            "elo",
            "uatp",
            "cup",
            "cartebancaire",
            "visaalphabankbonus",
            "mcalphabankbonus",
            "karenmillen",
            "oasis",
            "warehouse"
    );

    public String getBrandCode() {
        return brandCode;
    }

    public void setBrandCode(String brandCode) {
        this.brandCode = brandCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Issuer> getIssuers() {
        return issuers;
    }

    public void setIssuers(List<Issuer> issuers) {
        this.issuers = issuers;
    }

    public boolean isCard() {
        return cards.contains(getBrandCode());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PaymentMethod {\n");

        sb.append("    brandCode: ").append(Util.toIndentedString(brandCode)).append("\n");
        sb.append("    name: ").append(Util.toIndentedString(name)).append("\n");
        sb.append("    issuers: ").append(Util.toIndentedString(issuers)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
