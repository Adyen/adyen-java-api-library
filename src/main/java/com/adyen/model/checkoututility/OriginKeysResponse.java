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

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * OriginKeysResponse
 */
public class OriginKeysResponse {

    @SerializedName("originKeys")
    private Map<String, String> originKeys = null;

    public OriginKeysResponse originKeys(Map<String, String> originKeys) {
        this.originKeys = originKeys;
        return this;
    }

    public OriginKeysResponse putOriginKeysItem(String key, String originKeysItem) {

        if (originKeys == null) {
            originKeys = new HashMap<>();
        }

        originKeys.put(key, originKeysItem);
        return this;
    }

    /**
     * The list of origin keys for all requested domains. For each list item, the key is the domain and the value is the origin key.
     *
     * @return originKeys
     **/
    public Map<String, String> getOriginKeys() {
        return originKeys;
    }

    public void setOriginKeys(Map<String, String> originKeys) {
        this.originKeys = originKeys;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        OriginKeysResponse originKeysResponse = (OriginKeysResponse) o;
        return Objects.equals(originKeys, originKeysResponse.originKeys);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originKeys);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class OriginKeysResponse {").append(TextConstants.LINE_BREAK);

        sb.append("    originKeys: ").append(Util.toIndentedString(originKeys)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}



