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

/**
 * LinksElement
 */

public class LinksElement {
    @SerializedName("href")
    private String href = null;

    public LinksElement href(String href) {
        this.href = href;
        return this;
    }

    /**
     * Get href
     *
     * @return href
     **/
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LinksElement linksElement = (LinksElement) o;
        return Objects.equals(this.href, linksElement.href);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class LinksElement {\n");

        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
