/*
 * Management API
 *
 * The version of the OpenAPI document: 3
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.service.management;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;
import com.adyen.model.management.Logo;
import com.adyen.model.management.TerminalSettings;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class TerminalSettingsMerchantLevelApi extends Service {

  public static final String API_VERSION = "3";

  protected String baseURL;

  /**
   * Terminal settings - merchant level constructor in {@link com.adyen.service.management package}.
   *
   * @param client {@link Client } (required)
   */
  public TerminalSettingsMerchantLevelApi(Client client) {
    super(client);
    this.baseURL = createBaseURL("https://management-test.adyen.com/v3");
  }

  /**
   * Terminal settings - merchant level constructor in {@link com.adyen.service.management package}.
   * Please use this constructor only if you would like to pass along your own url for routing or
   * testing purposes. The latest API version is defined in this class as a constant.
   *
   * @param client {@link Client } (required)
   * @param baseURL {@link String } (required)
   */
  public TerminalSettingsMerchantLevelApi(Client client, String baseURL) {
    super(client);
    this.baseURL = baseURL;
  }

  /**
   * Get the terminal logo
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param model {@link String } The terminal model. Possible values: E355, VX675WIFIBT, VX680,
   *     VX690, VX700, VX820, M400, MX925, P400Plus, UX300, UX410, V200cPlus, V240mPlus, V400cPlus,
   *     V400m, e280, e285, e285p, S1E, S1EL, S1F2, S1L, S1U, S7T. (required)
   * @return {@link Logo }
   * @throws ApiException if fails to make API call
   */
  public Logo getTerminalLogo(String merchantId, String model) throws ApiException, IOException {
    return getTerminalLogo(merchantId, model, null);
  }

  /**
   * Get the terminal logo
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param model {@link String } Query: The terminal model. Possible values: E355, VX675WIFIBT,
   *     VX680, VX690, VX700, VX820, M400, MX925, P400Plus, UX300, UX410, V200cPlus, V240mPlus,
   *     V400cPlus, V400m, e280, e285, e285p, S1E, S1EL, S1F2, S1L, S1U, S7T. (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link Logo }
   * @throws ApiException if fails to make API call
   */
  public Logo getTerminalLogo(String merchantId, String model, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);

    // Add query params
    Map<String, String> queryParams = new HashMap<>();
    if (model != null) {
      queryParams.put("model", model);
    }

    String requestBody = null;
    Resource resource =
        new Resource(this, this.baseURL + "/merchants/{merchantId}/terminalLogos", null);
    String jsonResult =
        resource.request(
            requestBody, requestOptions, ApiConstants.HttpMethod.GET, pathParams, queryParams);
    return Logo.fromJson(jsonResult);
  }

  /**
   * Get terminal settings
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @return {@link TerminalSettings }
   * @throws ApiException if fails to make API call
   */
  public TerminalSettings getTerminalSettings(String merchantId) throws ApiException, IOException {
    return getTerminalSettings(merchantId, null);
  }

  /**
   * Get terminal settings
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link TerminalSettings }
   * @throws ApiException if fails to make API call
   */
  public TerminalSettings getTerminalSettings(String merchantId, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);

    String requestBody = null;
    Resource resource =
        new Resource(this, this.baseURL + "/merchants/{merchantId}/terminalSettings", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.GET, pathParams);
    return TerminalSettings.fromJson(jsonResult);
  }

  /**
   * Update the terminal logo
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param model {@link String } The terminal model. Allowed values: E355, VX675WIFIBT, VX680,
   *     VX690, VX700, VX820, M400, MX925, P400Plus, UX300, UX410, V200cPlus, V240mPlus, V400cPlus,
   *     V400m, e280, e285, e285p, S1E, S1EL, S1F2, S1L, S1U, S7T. (required)
   * @param logo {@link Logo } (required)
   * @return {@link Logo }
   * @throws ApiException if fails to make API call
   */
  public Logo updateTerminalLogo(String merchantId, String model, Logo logo)
      throws ApiException, IOException {
    return updateTerminalLogo(merchantId, model, logo, null);
  }

  /**
   * Update the terminal logo
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param logo {@link Logo } (required)
   * @param model {@link String } Query: The terminal model. Allowed values: E355, VX675WIFIBT,
   *     VX680, VX690, VX700, VX820, M400, MX925, P400Plus, UX300, UX410, V200cPlus, V240mPlus,
   *     V400cPlus, V400m, e280, e285, e285p, S1E, S1EL, S1F2, S1L, S1U, S7T. (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link Logo }
   * @throws ApiException if fails to make API call
   */
  public Logo updateTerminalLogo(
      String merchantId, String model, Logo logo, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);

    // Add query params
    Map<String, String> queryParams = new HashMap<>();
    if (model != null) {
      queryParams.put("model", model);
    }

    String requestBody = logo.toJson();
    Resource resource =
        new Resource(this, this.baseURL + "/merchants/{merchantId}/terminalLogos", null);
    String jsonResult =
        resource.request(
            requestBody, requestOptions, ApiConstants.HttpMethod.PATCH, pathParams, queryParams);
    return Logo.fromJson(jsonResult);
  }

  /**
   * Update terminal settings
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param terminalSettings {@link TerminalSettings } (required)
   * @return {@link TerminalSettings }
   * @throws ApiException if fails to make API call
   */
  public TerminalSettings updateTerminalSettings(
      String merchantId, TerminalSettings terminalSettings) throws ApiException, IOException {
    return updateTerminalSettings(merchantId, terminalSettings, null);
  }

  /**
   * Update terminal settings
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param terminalSettings {@link TerminalSettings } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link TerminalSettings }
   * @throws ApiException if fails to make API call
   */
  public TerminalSettings updateTerminalSettings(
      String merchantId, TerminalSettings terminalSettings, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);

    String requestBody = terminalSettings.toJson();
    Resource resource =
        new Resource(this, this.baseURL + "/merchants/{merchantId}/terminalSettings", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.PATCH, pathParams);
    return TerminalSettings.fromJson(jsonResult);
  }
}
