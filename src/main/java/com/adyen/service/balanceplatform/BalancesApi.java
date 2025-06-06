/*
 * Configuration API
 *
 * The version of the OpenAPI document: 2
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.service.balanceplatform;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;
import com.adyen.model.balanceplatform.BalanceWebhookSettingInfo;
import com.adyen.model.balanceplatform.BalanceWebhookSettingInfoUpdate;
import com.adyen.model.balanceplatform.WebhookSetting;
import com.adyen.model.balanceplatform.WebhookSettings;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BalancesApi extends Service {

  public static final String API_VERSION = "2";

  protected String baseURL;

  /**
   * Balances constructor in {@link com.adyen.service.balanceplatform package}.
   *
   * @param client {@link Client } (required)
   */
  public BalancesApi(Client client) {
    super(client);
    this.baseURL = createBaseURL("https://balanceplatform-api-test.adyen.com/bcl/v2");
  }

  /**
   * Balances constructor in {@link com.adyen.service.balanceplatform package}. Please use this
   * constructor only if you would like to pass along your own url for routing or testing purposes.
   * The latest API version is defined in this class as a constant.
   *
   * @param client {@link Client } (required)
   * @param baseURL {@link String } (required)
   */
  public BalancesApi(Client client, String baseURL) {
    super(client);
    this.baseURL = baseURL;
  }

  /**
   * Create a balance webhook setting
   *
   * @param balancePlatformId {@link String } The unique identifier of the balance platform.
   *     (required)
   * @param webhookId {@link String } The unique identifier of the balance webhook. (required)
   * @param balanceWebhookSettingInfo {@link BalanceWebhookSettingInfo } (required)
   * @param balanceWebhookSettingInfo {@link BalanceWebhookSettingInfo } (required)
   * @return {@link WebhookSetting }
   * @throws ApiException if fails to make API call
   */
  public WebhookSetting createWebhookSetting(
      String balancePlatformId,
      String webhookId,
      BalanceWebhookSettingInfo balanceWebhookSettingInfo)
      throws ApiException, IOException {
    return createWebhookSetting(balancePlatformId, webhookId, balanceWebhookSettingInfo, null);
  }

  /**
   * Create a balance webhook setting
   *
   * @param balancePlatformId {@link String } The unique identifier of the balance platform.
   *     (required)
   * @param webhookId {@link String } The unique identifier of the balance webhook. (required)
   * @param balanceWebhookSettingInfo {@link BalanceWebhookSettingInfo } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link WebhookSetting }
   * @throws ApiException if fails to make API call
   */
  public WebhookSetting createWebhookSetting(
      String balancePlatformId,
      String webhookId,
      BalanceWebhookSettingInfo balanceWebhookSettingInfo,
      RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (balancePlatformId == null) {
      throw new IllegalArgumentException("Please provide the balancePlatformId path parameter");
    }
    pathParams.put("balancePlatformId", balancePlatformId);
    if (webhookId == null) {
      throw new IllegalArgumentException("Please provide the webhookId path parameter");
    }
    pathParams.put("webhookId", webhookId);

    String requestBody = balanceWebhookSettingInfo.toJson();
    Resource resource =
        new Resource(
            this,
            this.baseURL + "/balancePlatforms/{balancePlatformId}/webhooks/{webhookId}/settings",
            null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, pathParams);
    return WebhookSetting.fromJson(jsonResult);
  }

  /**
   * Delete a balance webhook setting by id
   *
   * @param balancePlatformId {@link String } The unique identifier of the balance platform.
   *     (required)
   * @param webhookId {@link String } The unique identifier of the balance webhook. (required)
   * @param settingId {@link String } The unique identifier of the balance webhook setting.
   *     (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteWebhookSetting(String balancePlatformId, String webhookId, String settingId)
      throws ApiException, IOException {
    deleteWebhookSetting(balancePlatformId, webhookId, settingId, null);
  }

  /**
   * Delete a balance webhook setting by id
   *
   * @param balancePlatformId {@link String } The unique identifier of the balance platform.
   *     (required)
   * @param webhookId {@link String } The unique identifier of the balance webhook. (required)
   * @param settingId {@link String } The unique identifier of the balance webhook setting.
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @throws ApiException if fails to make API call
   */
  public void deleteWebhookSetting(
      String balancePlatformId, String webhookId, String settingId, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (balancePlatformId == null) {
      throw new IllegalArgumentException("Please provide the balancePlatformId path parameter");
    }
    pathParams.put("balancePlatformId", balancePlatformId);
    if (webhookId == null) {
      throw new IllegalArgumentException("Please provide the webhookId path parameter");
    }
    pathParams.put("webhookId", webhookId);
    if (settingId == null) {
      throw new IllegalArgumentException("Please provide the settingId path parameter");
    }
    pathParams.put("settingId", settingId);

    String requestBody = null;
    Resource resource =
        new Resource(
            this,
            this.baseURL
                + "/balancePlatforms/{balancePlatformId}/webhooks/{webhookId}/settings/{settingId}",
            null);
    resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.DELETE, pathParams);
  }

  /**
   * Get all balance webhook settings
   *
   * @param balancePlatformId {@link String } The unique identifier of the balance platform.
   *     (required)
   * @param webhookId {@link String } The unique identifier of the balance webhook. (required)
   * @return {@link WebhookSettings }
   * @throws ApiException if fails to make API call
   */
  public WebhookSettings getAllWebhookSettings(String balancePlatformId, String webhookId)
      throws ApiException, IOException {
    return getAllWebhookSettings(balancePlatformId, webhookId, null);
  }

  /**
   * Get all balance webhook settings
   *
   * @param balancePlatformId {@link String } The unique identifier of the balance platform.
   *     (required)
   * @param webhookId {@link String } The unique identifier of the balance webhook. (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link WebhookSettings }
   * @throws ApiException if fails to make API call
   */
  public WebhookSettings getAllWebhookSettings(
      String balancePlatformId, String webhookId, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (balancePlatformId == null) {
      throw new IllegalArgumentException("Please provide the balancePlatformId path parameter");
    }
    pathParams.put("balancePlatformId", balancePlatformId);
    if (webhookId == null) {
      throw new IllegalArgumentException("Please provide the webhookId path parameter");
    }
    pathParams.put("webhookId", webhookId);

    String requestBody = null;
    Resource resource =
        new Resource(
            this,
            this.baseURL + "/balancePlatforms/{balancePlatformId}/webhooks/{webhookId}/settings",
            null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.GET, pathParams);
    return WebhookSettings.fromJson(jsonResult);
  }

  /**
   * Get a balance webhook setting by id
   *
   * @param balancePlatformId {@link String } The unique identifier of the balance platform.
   *     (required)
   * @param webhookId {@link String } The unique identifier of the balance webhook. (required)
   * @param settingId {@link String } The unique identifier of the balance webhook setting.
   *     (required)
   * @return {@link WebhookSetting }
   * @throws ApiException if fails to make API call
   */
  public WebhookSetting getWebhookSetting(
      String balancePlatformId, String webhookId, String settingId)
      throws ApiException, IOException {
    return getWebhookSetting(balancePlatformId, webhookId, settingId, null);
  }

  /**
   * Get a balance webhook setting by id
   *
   * @param balancePlatformId {@link String } The unique identifier of the balance platform.
   *     (required)
   * @param webhookId {@link String } The unique identifier of the balance webhook. (required)
   * @param settingId {@link String } The unique identifier of the balance webhook setting.
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link WebhookSetting }
   * @throws ApiException if fails to make API call
   */
  public WebhookSetting getWebhookSetting(
      String balancePlatformId, String webhookId, String settingId, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (balancePlatformId == null) {
      throw new IllegalArgumentException("Please provide the balancePlatformId path parameter");
    }
    pathParams.put("balancePlatformId", balancePlatformId);
    if (webhookId == null) {
      throw new IllegalArgumentException("Please provide the webhookId path parameter");
    }
    pathParams.put("webhookId", webhookId);
    if (settingId == null) {
      throw new IllegalArgumentException("Please provide the settingId path parameter");
    }
    pathParams.put("settingId", settingId);

    String requestBody = null;
    Resource resource =
        new Resource(
            this,
            this.baseURL
                + "/balancePlatforms/{balancePlatformId}/webhooks/{webhookId}/settings/{settingId}",
            null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.GET, pathParams);
    return WebhookSetting.fromJson(jsonResult);
  }

  /**
   * Update a balance webhook setting by id
   *
   * @param balancePlatformId {@link String } The unique identifier of the balance platform.
   *     (required)
   * @param webhookId {@link String } The unique identifier of the balance webhook. (required)
   * @param settingId {@link String } The unique identifier of the balance webhook setting.
   *     (required)
   * @param balanceWebhookSettingInfoUpdate {@link BalanceWebhookSettingInfoUpdate } (required)
   * @param balanceWebhookSettingInfoUpdate {@link BalanceWebhookSettingInfoUpdate } (required)
   * @return {@link WebhookSetting }
   * @throws ApiException if fails to make API call
   */
  public WebhookSetting updateWebhookSetting(
      String balancePlatformId,
      String webhookId,
      String settingId,
      BalanceWebhookSettingInfoUpdate balanceWebhookSettingInfoUpdate)
      throws ApiException, IOException {
    return updateWebhookSetting(
        balancePlatformId, webhookId, settingId, balanceWebhookSettingInfoUpdate, null);
  }

  /**
   * Update a balance webhook setting by id
   *
   * @param balancePlatformId {@link String } The unique identifier of the balance platform.
   *     (required)
   * @param webhookId {@link String } The unique identifier of the balance webhook. (required)
   * @param settingId {@link String } The unique identifier of the balance webhook setting.
   *     (required)
   * @param balanceWebhookSettingInfoUpdate {@link BalanceWebhookSettingInfoUpdate } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link WebhookSetting }
   * @throws ApiException if fails to make API call
   */
  public WebhookSetting updateWebhookSetting(
      String balancePlatformId,
      String webhookId,
      String settingId,
      BalanceWebhookSettingInfoUpdate balanceWebhookSettingInfoUpdate,
      RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (balancePlatformId == null) {
      throw new IllegalArgumentException("Please provide the balancePlatformId path parameter");
    }
    pathParams.put("balancePlatformId", balancePlatformId);
    if (webhookId == null) {
      throw new IllegalArgumentException("Please provide the webhookId path parameter");
    }
    pathParams.put("webhookId", webhookId);
    if (settingId == null) {
      throw new IllegalArgumentException("Please provide the settingId path parameter");
    }
    pathParams.put("settingId", settingId);

    String requestBody = balanceWebhookSettingInfoUpdate.toJson();
    Resource resource =
        new Resource(
            this,
            this.baseURL
                + "/balancePlatforms/{balancePlatformId}/webhooks/{webhookId}/settings/{settingId}",
            null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.PATCH, pathParams);
    return WebhookSetting.fromJson(jsonResult);
  }
}
