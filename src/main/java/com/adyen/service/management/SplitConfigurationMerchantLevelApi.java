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
import com.adyen.model.management.SplitConfiguration;
import com.adyen.model.management.SplitConfigurationList;
import com.adyen.model.management.SplitConfigurationRule;
import com.adyen.model.management.UpdateSplitConfigurationLogicRequest;
import com.adyen.model.management.UpdateSplitConfigurationRequest;
import com.adyen.model.management.UpdateSplitConfigurationRuleRequest;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class SplitConfigurationMerchantLevelApi extends Service {

  public static final String API_VERSION = "3";

  protected String baseURL;

  /**
   * Split configuration - merchant level constructor in {@link com.adyen.service.management
   * package}.
   *
   * @param client {@link Client } (required)
   */
  public SplitConfigurationMerchantLevelApi(Client client) {
    super(client);
    this.baseURL = createBaseURL("https://management-test.adyen.com/v3");
  }

  /**
   * Split configuration - merchant level constructor in {@link com.adyen.service.management
   * package}. Please use this constructor only if you would like to pass along your own url for
   * routing or testing purposes. The latest API version is defined in this class as a constant.
   *
   * @param client {@link Client } (required)
   * @param baseURL {@link String } (required)
   */
  public SplitConfigurationMerchantLevelApi(Client client, String baseURL) {
    super(client);
    this.baseURL = baseURL;
  }

  /**
   * Create a rule
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @param splitConfigurationRule {@link SplitConfigurationRule } (required)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration createRule(
      String merchantId, String splitConfigurationId, SplitConfigurationRule splitConfigurationRule)
      throws ApiException, IOException {
    return createRule(merchantId, splitConfigurationId, splitConfigurationRule, null);
  }

  /**
   * Create a rule
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @param splitConfigurationRule {@link SplitConfigurationRule } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration createRule(
      String merchantId,
      String splitConfigurationId,
      SplitConfigurationRule splitConfigurationRule,
      RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);
    if (splitConfigurationId == null) {
      throw new IllegalArgumentException("Please provide the splitConfigurationId path parameter");
    }
    pathParams.put("splitConfigurationId", splitConfigurationId);

    String requestBody = splitConfigurationRule.toJson();
    Resource resource =
        new Resource(
            this,
            this.baseURL + "/merchants/{merchantId}/splitConfigurations/{splitConfigurationId}",
            null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, pathParams);
    return SplitConfiguration.fromJson(jsonResult);
  }

  /**
   * Create a split configuration
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfiguration {@link SplitConfiguration } (required)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration createSplitConfiguration(
      String merchantId, SplitConfiguration splitConfiguration) throws ApiException, IOException {
    return createSplitConfiguration(merchantId, splitConfiguration, null);
  }

  /**
   * Create a split configuration
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfiguration {@link SplitConfiguration } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration createSplitConfiguration(
      String merchantId, SplitConfiguration splitConfiguration, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);

    String requestBody = splitConfiguration.toJson();
    Resource resource =
        new Resource(this, this.baseURL + "/merchants/{merchantId}/splitConfigurations", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, pathParams);
    return SplitConfiguration.fromJson(jsonResult);
  }

  /**
   * Delete a split configuration
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration deleteSplitConfiguration(String merchantId, String splitConfigurationId)
      throws ApiException, IOException {
    return deleteSplitConfiguration(merchantId, splitConfigurationId, null);
  }

  /**
   * Delete a split configuration
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration deleteSplitConfiguration(
      String merchantId, String splitConfigurationId, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);
    if (splitConfigurationId == null) {
      throw new IllegalArgumentException("Please provide the splitConfigurationId path parameter");
    }
    pathParams.put("splitConfigurationId", splitConfigurationId);

    String requestBody = null;
    Resource resource =
        new Resource(
            this,
            this.baseURL + "/merchants/{merchantId}/splitConfigurations/{splitConfigurationId}",
            null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.DELETE, pathParams);
    return SplitConfiguration.fromJson(jsonResult);
  }

  /**
   * Delete a split configuration rule
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @param ruleId {@link String } (required)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration deleteSplitConfigurationRule(
      String merchantId, String splitConfigurationId, String ruleId)
      throws ApiException, IOException {
    return deleteSplitConfigurationRule(merchantId, splitConfigurationId, ruleId, null);
  }

  /**
   * Delete a split configuration rule
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @param ruleId {@link String } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration deleteSplitConfigurationRule(
      String merchantId, String splitConfigurationId, String ruleId, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);
    if (splitConfigurationId == null) {
      throw new IllegalArgumentException("Please provide the splitConfigurationId path parameter");
    }
    pathParams.put("splitConfigurationId", splitConfigurationId);
    if (ruleId == null) {
      throw new IllegalArgumentException("Please provide the ruleId path parameter");
    }
    pathParams.put("ruleId", ruleId);

    String requestBody = null;
    Resource resource =
        new Resource(
            this,
            this.baseURL
                + "/merchants/{merchantId}/splitConfigurations/{splitConfigurationId}/rules/{ruleId}",
            null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.DELETE, pathParams);
    return SplitConfiguration.fromJson(jsonResult);
  }

  /**
   * Get a split configuration
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration getSplitConfiguration(String merchantId, String splitConfigurationId)
      throws ApiException, IOException {
    return getSplitConfiguration(merchantId, splitConfigurationId, null);
  }

  /**
   * Get a split configuration
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration getSplitConfiguration(
      String merchantId, String splitConfigurationId, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);
    if (splitConfigurationId == null) {
      throw new IllegalArgumentException("Please provide the splitConfigurationId path parameter");
    }
    pathParams.put("splitConfigurationId", splitConfigurationId);

    String requestBody = null;
    Resource resource =
        new Resource(
            this,
            this.baseURL + "/merchants/{merchantId}/splitConfigurations/{splitConfigurationId}",
            null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.GET, pathParams);
    return SplitConfiguration.fromJson(jsonResult);
  }

  /**
   * Get a list of split configurations
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @return {@link SplitConfigurationList }
   * @throws ApiException if fails to make API call
   */
  public SplitConfigurationList listSplitConfigurations(String merchantId)
      throws ApiException, IOException {
    return listSplitConfigurations(merchantId, null);
  }

  /**
   * Get a list of split configurations
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link SplitConfigurationList }
   * @throws ApiException if fails to make API call
   */
  public SplitConfigurationList listSplitConfigurations(
      String merchantId, RequestOptions requestOptions) throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);

    String requestBody = null;
    Resource resource =
        new Resource(this, this.baseURL + "/merchants/{merchantId}/splitConfigurations", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.GET, pathParams);
    return SplitConfigurationList.fromJson(jsonResult);
  }

  /**
   * Update split conditions
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The identifier of the split configuration.
   *     (required)
   * @param ruleId {@link String } The unique identifier of the split configuration rule. (required)
   * @param updateSplitConfigurationRuleRequest {@link UpdateSplitConfigurationRuleRequest }
   *     (required)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration updateSplitConditions(
      String merchantId,
      String splitConfigurationId,
      String ruleId,
      UpdateSplitConfigurationRuleRequest updateSplitConfigurationRuleRequest)
      throws ApiException, IOException {
    return updateSplitConditions(
        merchantId, splitConfigurationId, ruleId, updateSplitConfigurationRuleRequest, null);
  }

  /**
   * Update split conditions
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The identifier of the split configuration.
   *     (required)
   * @param ruleId {@link String } The unique identifier of the split configuration rule. (required)
   * @param updateSplitConfigurationRuleRequest {@link UpdateSplitConfigurationRuleRequest }
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration updateSplitConditions(
      String merchantId,
      String splitConfigurationId,
      String ruleId,
      UpdateSplitConfigurationRuleRequest updateSplitConfigurationRuleRequest,
      RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);
    if (splitConfigurationId == null) {
      throw new IllegalArgumentException("Please provide the splitConfigurationId path parameter");
    }
    pathParams.put("splitConfigurationId", splitConfigurationId);
    if (ruleId == null) {
      throw new IllegalArgumentException("Please provide the ruleId path parameter");
    }
    pathParams.put("ruleId", ruleId);

    String requestBody = updateSplitConfigurationRuleRequest.toJson();
    Resource resource =
        new Resource(
            this,
            this.baseURL
                + "/merchants/{merchantId}/splitConfigurations/{splitConfigurationId}/rules/{ruleId}",
            null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.PATCH, pathParams);
    return SplitConfiguration.fromJson(jsonResult);
  }

  /**
   * Update split configuration description
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @param updateSplitConfigurationRequest {@link UpdateSplitConfigurationRequest } (required)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration updateSplitConfigurationDescription(
      String merchantId,
      String splitConfigurationId,
      UpdateSplitConfigurationRequest updateSplitConfigurationRequest)
      throws ApiException, IOException {
    return updateSplitConfigurationDescription(
        merchantId, splitConfigurationId, updateSplitConfigurationRequest, null);
  }

  /**
   * Update split configuration description
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @param updateSplitConfigurationRequest {@link UpdateSplitConfigurationRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration updateSplitConfigurationDescription(
      String merchantId,
      String splitConfigurationId,
      UpdateSplitConfigurationRequest updateSplitConfigurationRequest,
      RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);
    if (splitConfigurationId == null) {
      throw new IllegalArgumentException("Please provide the splitConfigurationId path parameter");
    }
    pathParams.put("splitConfigurationId", splitConfigurationId);

    String requestBody = updateSplitConfigurationRequest.toJson();
    Resource resource =
        new Resource(
            this,
            this.baseURL + "/merchants/{merchantId}/splitConfigurations/{splitConfigurationId}",
            null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.PATCH, pathParams);
    return SplitConfiguration.fromJson(jsonResult);
  }

  /**
   * Update the split logic
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @param ruleId {@link String } The unique identifier of the split configuration rule. (required)
   * @param splitLogicId {@link String } The unique identifier of the split configuration split.
   *     (required)
   * @param updateSplitConfigurationLogicRequest {@link UpdateSplitConfigurationLogicRequest }
   *     (required)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration updateSplitLogic(
      String merchantId,
      String splitConfigurationId,
      String ruleId,
      String splitLogicId,
      UpdateSplitConfigurationLogicRequest updateSplitConfigurationLogicRequest)
      throws ApiException, IOException {
    return updateSplitLogic(
        merchantId,
        splitConfigurationId,
        ruleId,
        splitLogicId,
        updateSplitConfigurationLogicRequest,
        null);
  }

  /**
   * Update the split logic
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param splitConfigurationId {@link String } The unique identifier of the split configuration.
   *     (required)
   * @param ruleId {@link String } The unique identifier of the split configuration rule. (required)
   * @param splitLogicId {@link String } The unique identifier of the split configuration split.
   *     (required)
   * @param updateSplitConfigurationLogicRequest {@link UpdateSplitConfigurationLogicRequest }
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link SplitConfiguration }
   * @throws ApiException if fails to make API call
   */
  public SplitConfiguration updateSplitLogic(
      String merchantId,
      String splitConfigurationId,
      String ruleId,
      String splitLogicId,
      UpdateSplitConfigurationLogicRequest updateSplitConfigurationLogicRequest,
      RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);
    if (splitConfigurationId == null) {
      throw new IllegalArgumentException("Please provide the splitConfigurationId path parameter");
    }
    pathParams.put("splitConfigurationId", splitConfigurationId);
    if (ruleId == null) {
      throw new IllegalArgumentException("Please provide the ruleId path parameter");
    }
    pathParams.put("ruleId", ruleId);
    if (splitLogicId == null) {
      throw new IllegalArgumentException("Please provide the splitLogicId path parameter");
    }
    pathParams.put("splitLogicId", splitLogicId);

    String requestBody = updateSplitConfigurationLogicRequest.toJson();
    Resource resource =
        new Resource(
            this,
            this.baseURL
                + "/merchants/{merchantId}/splitConfigurations/{splitConfigurationId}/rules/{ruleId}/splitLogic/{splitLogicId}",
            null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.PATCH, pathParams);
    return SplitConfiguration.fromJson(jsonResult);
  }
}
