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
package com.adyen.model.applicationinfo;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

public class CommonField {
    @SerializedName("name")
    private String name = null;

    @SerializedName("version")
    private String version = null;

    public String getName() {
        return name;
    }

    public CommonField name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommonField version(String version) {
        this.version = version;
        return this;
    }


    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        CommonField commonField = (CommonField) o;
        return Objects.equals(this.name, commonField.name) && Objects.equals(this.version, commonField.version);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, version);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CommonField {").append(TextConstants.LINE_BREAK);

        sb.append("    name: ").append(Util.toIndentedString(name)).append(TextConstants.LINE_BREAK);
        sb.append("    version: ").append(Util.toIndentedString(version)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}
