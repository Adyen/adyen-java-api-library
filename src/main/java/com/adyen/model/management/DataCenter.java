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
import java.util.Objects;
import static com.adyen.util.Util.toIndentedString;

public class DataCenter {
    @SerializedName("livePrefix")
    private String livePrefix = null;

    @SerializedName("name")
    private String name = null;

    public DataCenter livePrefix(String livePrefix) {
        this.livePrefix = livePrefix;
        return this;
    }

    /**
     * Get livePrefix
     * @return livePrefix
     **/
    public String getLivePrefix() {
        return livePrefix;
    }

    public void setLivePrefix(String livePrefix) {
        this.livePrefix = livePrefix;
    }

    public DataCenter name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     **/
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DataCenter dataCenter = (DataCenter) o;
        return Objects.equals(this.livePrefix, dataCenter.livePrefix) &&
                Objects.equals(this.name, dataCenter.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(livePrefix, name);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DataCenter {\n");

        sb.append("    livePrefix: ").append(toIndentedString(livePrefix)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
