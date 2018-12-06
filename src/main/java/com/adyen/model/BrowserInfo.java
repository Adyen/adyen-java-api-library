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
package com.adyen.model;

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * BrowserInfo
 */
public class BrowserInfo {
    @SerializedName("userAgent")
    private String userAgent = null;

    @SerializedName("acceptHeader")
    private String acceptHeader = null;

    @SerializedName("colorDepth")
    private Integer colorDepth = null;

    @SerializedName("javaEnabled")
    private Boolean javaEnabled = null;

    @SerializedName("language")
    private String language = null;

    @SerializedName("screenHeight")
    private Integer screenHeight = null;

    @SerializedName("screenWidth")
    private Integer screenWidth = null;

    @SerializedName("timeZoneOffset")
    private Integer timeZoneOffset = null;

    public BrowserInfo userAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public Integer getColorDepth() {
        return colorDepth;
    }

    public void setColorDepth(Integer colorDepth) {
        this.colorDepth = colorDepth;

    }

    public Boolean getJavaEnabled() {
        return javaEnabled;
    }

    public void setJavaEnabled(Boolean javaEnabled) {
        this.javaEnabled = javaEnabled;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Integer getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(Integer screenHeight) {
        this.screenHeight = screenHeight;
    }

    public Integer getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(Integer screenWidth) {
        this.screenWidth = screenWidth;
    }

    public Integer getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public void setTimeZoneOffset(Integer timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    /**
     * the user agent value of the shopper's browser
     *
     * @return userAgent
     **/
    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public BrowserInfo acceptHeader(String acceptHeader) {
        this.acceptHeader = acceptHeader;
        return this;
    }

    /**
     * the accept header value of the shopper's browser
     *
     * @return acceptHeader
     **/
    public String getAcceptHeader() {
        return acceptHeader;
    }

    public void setAcceptHeader(String acceptHeader) {
        this.acceptHeader = acceptHeader;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BrowserInfo browserInfo = (BrowserInfo) o;
        return Objects.equals(this.userAgent, browserInfo.userAgent) && Objects.equals(this.acceptHeader, browserInfo.acceptHeader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userAgent, acceptHeader);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BrowserInfo {\n");
        sb.append("    acceptHeader: ").append(toIndentedString(acceptHeader)).append("\n");
        sb.append("    colorDepth: ").append(toIndentedString(colorDepth)).append("\n");
        sb.append("    javaEnabled: ").append(toIndentedString(javaEnabled)).append("\n");
        sb.append("    language: ").append(toIndentedString(language)).append("\n");
        sb.append("    screenHeight: ").append(toIndentedString(screenHeight)).append("\n");
        sb.append("    screenWidth: ").append(toIndentedString(screenWidth)).append("\n");
        sb.append("    timeZoneOffset: ").append(toIndentedString(timeZoneOffset)).append("\n");
        sb.append("    userAgent: ").append(toIndentedString(userAgent)).append("\n");
  sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

