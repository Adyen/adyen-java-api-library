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
package com.adyen.model.hpp;

import com.adyen.constants.BrandCodes;
import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.List;


import static com.adyen.util.Util.toIndentedString;

public class PaymentMethod {
    @SerializedName("brandCode")
    private String brandCode = null;

    @SerializedName("name")
    private String name = null;

    @SerializedName("issuers")
    private List<Issuer> issuers;

    public static List<String> cards = Arrays.asList(BrandCodes.MASTERCARD,
                                                     BrandCodes.VISA_DANKORT,
                                                     BrandCodes.VISA,
                                                     BrandCodes.AMEX,
                                                     BrandCodes.VIAS,
                                                     BrandCodes.DINERS,
                                                     BrandCodes.MAESTRO_UK,
                                                     BrandCodes.SOLO,
                                                     BrandCodes.LASER,
                                                     BrandCodes.DISCOVER,
                                                     BrandCodes.JCB,
                                                     BrandCodes.BCMC,
                                                     BrandCodes.BIJCARD,
                                                     BrandCodes.DANKORT,
                                                     BrandCodes.HIPERCARD,
                                                     BrandCodes.MAESTRO,
                                                     BrandCodes.ELO,
                                                     BrandCodes.UATP,
                                                     BrandCodes.CHINA_UNION_PAY,
                                                     BrandCodes.CARTEBANCAIRE,
                                                     BrandCodes.VISA_ALPHABANK_BONUS,
                                                     BrandCodes.MC_ALPHABANK_BONUS,
                                                     BrandCodes.KARENMILLEN,
                                                     BrandCodes.OASIS,
                                                     BrandCodes.WAREHOUSE);

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
        sb.append("    brandCode: ").append(toIndentedString(brandCode)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    issuers: ").append(toIndentedString(issuers)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
