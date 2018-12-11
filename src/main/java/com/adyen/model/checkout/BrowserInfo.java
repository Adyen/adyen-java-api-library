package com.adyen.model.checkout;

import java.util.Objects;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * BrowserInfo
 */
@javax.annotation.Generated(value = "io.swagger.codegen.languages.java.JavaClientCodegen", date = "2018-11-08T13:12:01.900Z[GMT]")
public class BrowserInfo {

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

    @SerializedName("userAgent")
    private String userAgent = null;

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

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BrowserInfo browserInfo = (BrowserInfo) o;
        return Objects.equals(this.acceptHeader, browserInfo.acceptHeader) &&
                Objects.equals(this.colorDepth, browserInfo.colorDepth) &&
                Objects.equals(this.javaEnabled, browserInfo.javaEnabled) &&
                Objects.equals(this.language, browserInfo.language) &&
                Objects.equals(this.screenHeight, browserInfo.screenHeight) &&
                Objects.equals(this.screenWidth, browserInfo.screenWidth) &&
                Objects.equals(this.timeZoneOffset, browserInfo.timeZoneOffset) &&
                Objects.equals(this.userAgent, browserInfo.userAgent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(acceptHeader, colorDepth, javaEnabled, language, screenHeight, screenWidth, timeZoneOffset, userAgent);
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
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}



