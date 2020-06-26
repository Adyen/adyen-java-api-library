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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkoututility;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * OriginKeysRequest
 */
public class OriginKeysRequest {

    @SerializedName("originDomains")
    private List<String> originDomains = new ArrayList<>();

    public OriginKeysRequest originDomains(List<String> originDomains) {
        this.originDomains = originDomains;
        return this;
    }

    public OriginKeysRequest addOriginDomainsItem(String originDomainsItem) {

        this.originDomains.add(originDomainsItem);
        return this;
    }

    /**
     * The list of origin domains, for which origin keys are requested.
     *
     * @return originDomains
     **/
    public List<String> getOriginDomains() {
        return originDomains;
    }

    public void setOriginDomains(List<String> originDomains) {
        this.originDomains = originDomains;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        OriginKeysRequest originKeysRequest = (OriginKeysRequest) o;
        return Objects.equals(this.originDomains, originKeysRequest.originDomains);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originDomains);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OriginKeysRequest {\n");

        sb.append("    originDomains: ").append(toIndentedString(originDomains)).append("\n");
        sb.append("}");
        return sb.toString();
    }




}



