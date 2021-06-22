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

package com.adyen.model.management;

import com.google.gson.annotations.SerializedName;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

public class AdditionalSettings {
    @SerializedName("properties")
    private Map<String, Boolean> properties = null;

    public AdditionalSettings properties(Map<String, Boolean> properties) {
        this.properties = properties;
        return this;
    }

    public AdditionalSettings putPropertiesItem(String key, Boolean propertiesItem) {
        if (this.properties == null) {
            this.properties = new HashMap<String, Boolean>();
        }
        this.properties.put(key, propertiesItem);
        return this;
    }

    /**
     * Get properties
     * @return properties
     **/
    public Map<String, Boolean> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Boolean> properties) {
        this.properties = properties;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AdditionalSettings additionalSettings = (AdditionalSettings) o;
        return Objects.equals(this.properties, additionalSettings.properties);
    }

    @Override
    public int hashCode() {
        return Objects.hash(properties);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AdditionalSettings {\n");

        sb.append("    properties: ").append(toIndentedString(properties)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
