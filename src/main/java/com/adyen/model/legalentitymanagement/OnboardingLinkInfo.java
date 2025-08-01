/*
 * Legal Entity Management API
 *
 * The version of the OpenAPI document: 3
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.model.legalentitymanagement;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.*;

/** OnboardingLinkInfo */
@JsonPropertyOrder({
  OnboardingLinkInfo.JSON_PROPERTY_LOCALE,
  OnboardingLinkInfo.JSON_PROPERTY_REDIRECT_URL,
  OnboardingLinkInfo.JSON_PROPERTY_SETTINGS,
  OnboardingLinkInfo.JSON_PROPERTY_THEME_ID
})
public class OnboardingLinkInfo {
  public static final String JSON_PROPERTY_LOCALE = "locale";
  private String locale;

  public static final String JSON_PROPERTY_REDIRECT_URL = "redirectUrl";
  private String redirectUrl;

  public static final String JSON_PROPERTY_SETTINGS = "settings";
  private OnboardingLinkSettings settings;

  public static final String JSON_PROPERTY_THEME_ID = "themeId";
  private String themeId;

  public OnboardingLinkInfo() {}

  /**
   * The language that will be used for the page, specified by a combination of two letter [ISO
   * 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) language and [ISO 3166-1
   * alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) country codes. See possible
   * valuesfor
   * [marketplaces](https://docs.adyen.com/marketplaces/onboard-users/hosted#supported-languages) or
   * [platforms](https://docs.adyen.com/platforms/onboard-users/hosted#supported-languages). If not
   * specified in the request or if the language is not supported, the page uses the browser
   * language. If the browser language is not supported, the page uses **en-US** by default.
   *
   * @param locale The language that will be used for the page, specified by a combination of two
   *     letter [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) language and [ISO
   *     3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) country codes. See
   *     possible valuesfor
   *     [marketplaces](https://docs.adyen.com/marketplaces/onboard-users/hosted#supported-languages)
   *     or [platforms](https://docs.adyen.com/platforms/onboard-users/hosted#supported-languages).
   *     If not specified in the request or if the language is not supported, the page uses the
   *     browser language. If the browser language is not supported, the page uses **en-US** by
   *     default.
   * @return the current {@code OnboardingLinkInfo} instance, allowing for method chaining
   */
  public OnboardingLinkInfo locale(String locale) {
    this.locale = locale;
    return this;
  }

  /**
   * The language that will be used for the page, specified by a combination of two letter [ISO
   * 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) language and [ISO 3166-1
   * alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) country codes. See possible
   * valuesfor
   * [marketplaces](https://docs.adyen.com/marketplaces/onboard-users/hosted#supported-languages) or
   * [platforms](https://docs.adyen.com/platforms/onboard-users/hosted#supported-languages). If not
   * specified in the request or if the language is not supported, the page uses the browser
   * language. If the browser language is not supported, the page uses **en-US** by default.
   *
   * @return locale The language that will be used for the page, specified by a combination of two
   *     letter [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) language and [ISO
   *     3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) country codes. See
   *     possible valuesfor
   *     [marketplaces](https://docs.adyen.com/marketplaces/onboard-users/hosted#supported-languages)
   *     or [platforms](https://docs.adyen.com/platforms/onboard-users/hosted#supported-languages).
   *     If not specified in the request or if the language is not supported, the page uses the
   *     browser language. If the browser language is not supported, the page uses **en-US** by
   *     default.
   */
  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getLocale() {
    return locale;
  }

  /**
   * The language that will be used for the page, specified by a combination of two letter [ISO
   * 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) language and [ISO 3166-1
   * alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) country codes. See possible
   * valuesfor
   * [marketplaces](https://docs.adyen.com/marketplaces/onboard-users/hosted#supported-languages) or
   * [platforms](https://docs.adyen.com/platforms/onboard-users/hosted#supported-languages). If not
   * specified in the request or if the language is not supported, the page uses the browser
   * language. If the browser language is not supported, the page uses **en-US** by default.
   *
   * @param locale The language that will be used for the page, specified by a combination of two
   *     letter [ISO 639-1](https://en.wikipedia.org/wiki/List_of_ISO_639-1_codes) language and [ISO
   *     3166-1 alpha-2](https://en.wikipedia.org/wiki/ISO_3166-1_alpha-2) country codes. See
   *     possible valuesfor
   *     [marketplaces](https://docs.adyen.com/marketplaces/onboard-users/hosted#supported-languages)
   *     or [platforms](https://docs.adyen.com/platforms/onboard-users/hosted#supported-languages).
   *     If not specified in the request or if the language is not supported, the page uses the
   *     browser language. If the browser language is not supported, the page uses **en-US** by
   *     default.
   */
  @JsonProperty(JSON_PROPERTY_LOCALE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setLocale(String locale) {
    this.locale = locale;
  }

  /**
   * The URL where the user is redirected after they complete hosted onboarding.
   *
   * @param redirectUrl The URL where the user is redirected after they complete hosted onboarding.
   * @return the current {@code OnboardingLinkInfo} instance, allowing for method chaining
   */
  public OnboardingLinkInfo redirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
    return this;
  }

  /**
   * The URL where the user is redirected after they complete hosted onboarding.
   *
   * @return redirectUrl The URL where the user is redirected after they complete hosted onboarding.
   */
  @JsonProperty(JSON_PROPERTY_REDIRECT_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRedirectUrl() {
    return redirectUrl;
  }

  /**
   * The URL where the user is redirected after they complete hosted onboarding.
   *
   * @param redirectUrl The URL where the user is redirected after they complete hosted onboarding.
   */
  @JsonProperty(JSON_PROPERTY_REDIRECT_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRedirectUrl(String redirectUrl) {
    this.redirectUrl = redirectUrl;
  }

  /**
   * settings
   *
   * @param settings
   * @return the current {@code OnboardingLinkInfo} instance, allowing for method chaining
   */
  public OnboardingLinkInfo settings(OnboardingLinkSettings settings) {
    this.settings = settings;
    return this;
  }

  /**
   * Get settings
   *
   * @return settings
   */
  @JsonProperty(JSON_PROPERTY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OnboardingLinkSettings getSettings() {
    return settings;
  }

  /**
   * settings
   *
   * @param settings
   */
  @JsonProperty(JSON_PROPERTY_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSettings(OnboardingLinkSettings settings) {
    this.settings = settings;
  }

  /**
   * The unique identifier of the hosted onboarding theme.
   *
   * @param themeId The unique identifier of the hosted onboarding theme.
   * @return the current {@code OnboardingLinkInfo} instance, allowing for method chaining
   */
  public OnboardingLinkInfo themeId(String themeId) {
    this.themeId = themeId;
    return this;
  }

  /**
   * The unique identifier of the hosted onboarding theme.
   *
   * @return themeId The unique identifier of the hosted onboarding theme.
   */
  @JsonProperty(JSON_PROPERTY_THEME_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getThemeId() {
    return themeId;
  }

  /**
   * The unique identifier of the hosted onboarding theme.
   *
   * @param themeId The unique identifier of the hosted onboarding theme.
   */
  @JsonProperty(JSON_PROPERTY_THEME_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setThemeId(String themeId) {
    this.themeId = themeId;
  }

  /** Return true if this OnboardingLinkInfo object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OnboardingLinkInfo onboardingLinkInfo = (OnboardingLinkInfo) o;
    return Objects.equals(this.locale, onboardingLinkInfo.locale)
        && Objects.equals(this.redirectUrl, onboardingLinkInfo.redirectUrl)
        && Objects.equals(this.settings, onboardingLinkInfo.settings)
        && Objects.equals(this.themeId, onboardingLinkInfo.themeId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(locale, redirectUrl, settings, themeId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OnboardingLinkInfo {\n");
    sb.append("    locale: ").append(toIndentedString(locale)).append("\n");
    sb.append("    redirectUrl: ").append(toIndentedString(redirectUrl)).append("\n");
    sb.append("    settings: ").append(toIndentedString(settings)).append("\n");
    sb.append("    themeId: ").append(toIndentedString(themeId)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  /**
   * Create an instance of OnboardingLinkInfo given an JSON string
   *
   * @param jsonString JSON string
   * @return An instance of OnboardingLinkInfo
   * @throws JsonProcessingException if the JSON string is invalid with respect to
   *     OnboardingLinkInfo
   */
  public static OnboardingLinkInfo fromJson(String jsonString) throws JsonProcessingException {
    return JSON.getMapper().readValue(jsonString, OnboardingLinkInfo.class);
  }

  /**
   * Convert an instance of OnboardingLinkInfo to an JSON string
   *
   * @return JSON string
   */
  public String toJson() throws JsonProcessingException {
    return JSON.getMapper().writeValueAsString(this);
  }
}
