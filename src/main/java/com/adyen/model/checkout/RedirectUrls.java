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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * RedirectUrls
 */

public class RedirectUrls {
    @SerializedName("android")
    private String android = null;

    @SerializedName("ios")
    private String ios = null;

    @SerializedName("web")
    private String web = null;

    public RedirectUrls android(String android) {
        this.android = android;
        return this;
    }

    /**
     * The redirect URL used on Android.
     *
     * @return android
     **/
    public String getAndroid() {
        return android;
    }

    public void setAndroid(String android) {
        this.android = android;
    }

    public RedirectUrls ios(String ios) {
        this.ios = ios;
        return this;
    }

    /**
     * The redirect URL used on iOS.
     *
     * @return ios
     **/
    public String getIos() {
        return ios;
    }

    public void setIos(String ios) {
        this.ios = ios;
    }

    public RedirectUrls web(String web) {
        this.web = web;
        return this;
    }

    /**
     * The redirect URL used on web.
     *
     * @return web
     **/
    public String getWeb() {
        return web;
    }

    public void setWeb(String web) {
        this.web = web;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        RedirectUrls redirectUrls = (RedirectUrls) o;
        return Objects.equals(this.android, redirectUrls.android) &&
                Objects.equals(this.ios, redirectUrls.ios) &&
                Objects.equals(this.web, redirectUrls.web);
    }

    @Override
    public int hashCode() {
        return Objects.hash(android, ios, web);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class RedirectUrls {\n");

        sb.append("    android: ").append(toIndentedString(android)).append("\n");
        sb.append("    ios: ").append(toIndentedString(ios)).append("\n");
        sb.append("    web: ").append(toIndentedString(web)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
