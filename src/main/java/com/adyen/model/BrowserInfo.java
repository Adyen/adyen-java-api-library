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
 *
 */
package com.adyen.model;

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * BrowserInfo
 */
public class BrowserInfo {

    @SerializedName("userAgent")
    private String userAgent = null;

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

    @SerializedName("acceptHeader")
    private String acceptHeader = null;

    @SerializedName("javaScriptEnabled")
    private Boolean javaScriptEnabled = null;

    public BrowserInfo acceptHeader(String acceptHeader) {
        this.acceptHeader = acceptHeader;
        return this;
    }


    public String getAcceptHeader() {
        return acceptHeader;
    }

    public void setAcceptHeader(String acceptHeader) {
        this.acceptHeader = acceptHeader;
    }

    public BrowserInfo colorDepth(Integer colorDepth) {
        this.colorDepth = colorDepth;
        return this;
    }


    public Integer getColorDepth() {
        return colorDepth;
    }

    public void setColorDepth(Integer colorDepth) {
        this.colorDepth = colorDepth;
    }

    public BrowserInfo javaEnabled(Boolean javaEnabled) {
        this.javaEnabled = javaEnabled;
        return this;
    }

    public Boolean isJavaEnabled() {
        return javaEnabled;
    }

    public void setJavaEnabled(Boolean javaEnabled) {
        this.javaEnabled = javaEnabled;
    }

    public BrowserInfo language(String language) {
        this.language = language;
        return this;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public BrowserInfo screenHeight(Integer screenHeight) {
        this.screenHeight = screenHeight;
        return this;
    }

    public Integer getScreenHeight() {
        return screenHeight;
    }

    public void setScreenHeight(Integer screenHeight) {
        this.screenHeight = screenHeight;
    }

    public BrowserInfo screenWidth(Integer screenWidth) {
        this.screenWidth = screenWidth;
        return this;
    }


    public Integer getScreenWidth() {
        return screenWidth;
    }

    public void setScreenWidth(Integer screenWidth) {
        this.screenWidth = screenWidth;
    }

    public BrowserInfo timeZoneOffset(Integer timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
        return this;
    }

    public Integer getTimeZoneOffset() {
        return timeZoneOffset;
    }

    public void setTimeZoneOffset(Integer timeZoneOffset) {
        this.timeZoneOffset = timeZoneOffset;
    }

    public BrowserInfo userAgent(String userAgent) {
        this.userAgent = userAgent;
        return this;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public BrowserInfo javaScriptEnabled(Boolean javaScriptEnabled) {
        this.javaScriptEnabled = javaScriptEnabled;
        return this;
    }

    public Boolean isJavaScriptEnabled() {
        return javaScriptEnabled;
    }

    public void setJavaScriptEnabled(Boolean javaScriptEnabled) {
        this.javaScriptEnabled = javaScriptEnabled;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        BrowserInfo browserInfo = (BrowserInfo) o;
        return Objects.equals(this.acceptHeader, browserInfo.acceptHeader)
                && Objects.equals(this.colorDepth, browserInfo.colorDepth)
                && Objects.equals(this.javaEnabled, browserInfo.javaEnabled)
                && Objects.equals(this.language, browserInfo.language)
                && Objects.equals(this.screenHeight, browserInfo.screenHeight)
                && Objects.equals(this.screenWidth, browserInfo.screenWidth)
                && Objects.equals(this.timeZoneOffset, browserInfo.timeZoneOffset)
                && Objects.equals(this.userAgent, browserInfo.userAgent)
                && Objects.equals(this.javaScriptEnabled, browserInfo.javaScriptEnabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acceptHeader, colorDepth, javaEnabled, language, screenHeight, screenWidth, timeZoneOffset, userAgent, javaScriptEnabled);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BrowserInfo {").append(TextConstants.LINE_BREAK);
        sb.append("    userAgent: ").append(Util.toIndentedString(userAgent)).append(TextConstants.LINE_BREAK);
        sb.append("    colorDepth: ").append(Util.toIndentedString(colorDepth)).append(TextConstants.LINE_BREAK);
        sb.append("    javaEnabled: ").append(Util.toIndentedString(javaEnabled)).append(TextConstants.LINE_BREAK);
        sb.append("    language: ").append(Util.toIndentedString(language)).append(TextConstants.LINE_BREAK);
        sb.append("    screenHeight: ").append(Util.toIndentedString(screenHeight)).append(TextConstants.LINE_BREAK);
        sb.append("    screenWidth: ").append(Util.toIndentedString(screenWidth)).append(TextConstants.LINE_BREAK);
        sb.append("    timeZoneOffset: ").append(Util.toIndentedString(timeZoneOffset)).append(TextConstants.LINE_BREAK);
        sb.append("    acceptHeader: ").append(Util.toIndentedString(acceptHeader)).append(TextConstants.LINE_BREAK);
        sb.append("    javaScriptEnabled: ").append(Util.toIndentedString(javaScriptEnabled)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }
}



