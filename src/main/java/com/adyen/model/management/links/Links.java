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
package com.adyen.model.management.links;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * Links
 */

public class Links {

    @SerializedName("self")
    private LinksElement self = null;

    public Links self(LinksElement self) {
        this.self = self;
        return this;
    }

    /**
     * Get self
     *
     * @return self
     **/
    public LinksElement getSelf() {
        return self;
    }

    public void setSelf(LinksElement self) {
        this.self = self;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Links links = (Links) o;
        return Objects.equals(this.self, links.self);
    }

    @Override
    public int hashCode() {
        return Objects.hash(self);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Links {\n");
        sb.append("    self: ").append(toIndentedString(self)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
