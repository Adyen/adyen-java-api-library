/*
 * Notification Configuration API
 * This API is used for the classic integration. If you are just starting your implementation, refer to our [new integration guide](https://docs.adyen.com/marketplaces-and-platforms) instead.  The Notification Configuration API provides endpoints for setting up and testing notifications that inform you of events on your platform, for example when a verification check or a payout has been completed.  For more information, refer to our [documentation](https://docs.adyen.com/marketplaces-and-platforms/classic/notifications). ## Authentication Your Adyen contact will provide your API credential and an API key. To connect to the API, add an `X-API-Key` header with the API key as the value, for example:   ``` curl -H \"Content-Type: application/json\" \\ -H \"X-API-Key: YOUR_API_KEY\" \\ ... ```  Alternatively, you can use the username and password to connect to the API using basic authentication. For example:  ``` curl -U \"ws@MarketPlace.YOUR_PLATFORM_ACCOUNT\":\"YOUR_WS_PASSWORD\" \\ -H \"Content-Type: application/json\" \\ ... ``` When going live, you need to generate new web service user credentials to access the [live endpoints](https://docs.adyen.com/development-resources/live-endpoints).  ## Versioning The Notification Configuration API supports [versioning](https://docs.adyen.com/development-resources/versioning) using a version suffix in the endpoint URL. This suffix has the following format: \"vXX\", where XX is the version number.  For example: ``` https://cal-test.adyen.com/cal/services/Notification/v6/createNotificationConfiguration ```
 *
 * The version of the OpenAPI document: 6
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.service.classicplatforms;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;
import com.adyen.model.marketpayconfiguration.CreateNotificationConfigurationRequest;
import com.adyen.model.marketpayconfiguration.DeleteNotificationConfigurationRequest;
import com.adyen.model.marketpayconfiguration.GenericResponse;
import com.adyen.model.marketpayconfiguration.GetNotificationConfigurationListResponse;
import com.adyen.model.marketpayconfiguration.GetNotificationConfigurationRequest;
import com.adyen.model.marketpayconfiguration.GetNotificationConfigurationResponse;
import com.adyen.model.marketpayconfiguration.TestNotificationConfigurationRequest;
import com.adyen.model.marketpayconfiguration.TestNotificationConfigurationResponse;
import com.adyen.model.marketpayconfiguration.UpdateNotificationConfigurationRequest;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import java.io.IOException;

public class ClassicPlatformConfigurationApi extends Service {

  public static final String API_VERSION = "6";

  protected String baseURL;

  /**
   * General constructor in {@link com.adyen.service package}.
   *
   * @param client {@link Client } (required)
   */
  public ClassicPlatformConfigurationApi(Client client) {
    super(client);
    this.baseURL = createBaseURL("https://cal-test.adyen.com/cal/services/Notification/v6");
  }

  /**
   * General constructor in {@link com.adyen.service package}. Please use this constructor only if
   * you would like to pass along your own url for routing or testing purposes. The latest API
   * version is defined in this class as a constant.
   *
   * @param client {@link Client } (required)
   * @param baseURL {@link String } (required)
   */
  public ClassicPlatformConfigurationApi(Client client, String baseURL) {
    super(client);
    this.baseURL = baseURL;
  }

  /**
   * Subscribe to notifications
   *
   * @param createNotificationConfigurationRequest {@link CreateNotificationConfigurationRequest }
   *     (required)
   * @return {@link GetNotificationConfigurationResponse }
   * @throws ApiException if fails to make API call
   */
  public GetNotificationConfigurationResponse createNotificationConfiguration(
      CreateNotificationConfigurationRequest createNotificationConfigurationRequest)
      throws ApiException, IOException {
    return createNotificationConfiguration(createNotificationConfigurationRequest, null);
  }

  /**
   * Subscribe to notifications
   *
   * @param createNotificationConfigurationRequest {@link CreateNotificationConfigurationRequest }
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link GetNotificationConfigurationResponse }
   * @throws ApiException if fails to make API call
   */
  public GetNotificationConfigurationResponse createNotificationConfiguration(
      CreateNotificationConfigurationRequest createNotificationConfigurationRequest,
      RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = createNotificationConfigurationRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/createNotificationConfiguration", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return GetNotificationConfigurationResponse.fromJson(jsonResult);
  }

  /**
   * Delete a notification subscription configuration
   *
   * @param deleteNotificationConfigurationRequest {@link DeleteNotificationConfigurationRequest }
   *     (required)
   * @return {@link GenericResponse }
   * @throws ApiException if fails to make API call
   */
  public GenericResponse deleteNotificationConfigurations(
      DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest)
      throws ApiException, IOException {
    return deleteNotificationConfigurations(deleteNotificationConfigurationRequest, null);
  }

  /**
   * Delete a notification subscription configuration
   *
   * @param deleteNotificationConfigurationRequest {@link DeleteNotificationConfigurationRequest }
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link GenericResponse }
   * @throws ApiException if fails to make API call
   */
  public GenericResponse deleteNotificationConfigurations(
      DeleteNotificationConfigurationRequest deleteNotificationConfigurationRequest,
      RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = deleteNotificationConfigurationRequest.toJson();
    Resource resource =
        new Resource(this, this.baseURL + "/deleteNotificationConfigurations", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return GenericResponse.fromJson(jsonResult);
  }

  /**
   * Get a notification subscription configuration
   *
   * @param getNotificationConfigurationRequest {@link GetNotificationConfigurationRequest }
   *     (required)
   * @return {@link GetNotificationConfigurationResponse }
   * @throws ApiException if fails to make API call
   */
  public GetNotificationConfigurationResponse getNotificationConfiguration(
      GetNotificationConfigurationRequest getNotificationConfigurationRequest)
      throws ApiException, IOException {
    return getNotificationConfiguration(getNotificationConfigurationRequest, null);
  }

  /**
   * Get a notification subscription configuration
   *
   * @param getNotificationConfigurationRequest {@link GetNotificationConfigurationRequest }
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link GetNotificationConfigurationResponse }
   * @throws ApiException if fails to make API call
   */
  public GetNotificationConfigurationResponse getNotificationConfiguration(
      GetNotificationConfigurationRequest getNotificationConfigurationRequest,
      RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = getNotificationConfigurationRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/getNotificationConfiguration", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return GetNotificationConfigurationResponse.fromJson(jsonResult);
  }

  /**
   * Get a list of notification subscription configurations
   *
   * @return {@link GetNotificationConfigurationListResponse }
   * @throws ApiException if fails to make API call
   */
  public GetNotificationConfigurationListResponse getNotificationConfigurationList()
      throws ApiException, IOException {
    return getNotificationConfigurationList(null);
  }

  /**
   * Get a list of notification subscription configurations
   *
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link GetNotificationConfigurationListResponse }
   * @throws ApiException if fails to make API call
   */
  public GetNotificationConfigurationListResponse getNotificationConfigurationList(
      RequestOptions requestOptions) throws ApiException, IOException {

    Resource resource =
        new Resource(this, this.baseURL + "/getNotificationConfigurationList", null);
    String jsonResult = resource.request("{}", requestOptions, ApiConstants.HttpMethod.POST, null);
    return GetNotificationConfigurationListResponse.fromJson(jsonResult);
  }

  /**
   * Test a notification configuration
   *
   * @param testNotificationConfigurationRequest {@link TestNotificationConfigurationRequest }
   *     (required)
   * @return {@link TestNotificationConfigurationResponse }
   * @throws ApiException if fails to make API call
   */
  public TestNotificationConfigurationResponse testNotificationConfiguration(
      TestNotificationConfigurationRequest testNotificationConfigurationRequest)
      throws ApiException, IOException {
    return testNotificationConfiguration(testNotificationConfigurationRequest, null);
  }

  /**
   * Test a notification configuration
   *
   * @param testNotificationConfigurationRequest {@link TestNotificationConfigurationRequest }
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link TestNotificationConfigurationResponse }
   * @throws ApiException if fails to make API call
   */
  public TestNotificationConfigurationResponse testNotificationConfiguration(
      TestNotificationConfigurationRequest testNotificationConfigurationRequest,
      RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = testNotificationConfigurationRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/testNotificationConfiguration", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return TestNotificationConfigurationResponse.fromJson(jsonResult);
  }

  /**
   * Update a notification subscription configuration
   *
   * @param updateNotificationConfigurationRequest {@link UpdateNotificationConfigurationRequest }
   *     (required)
   * @return {@link GetNotificationConfigurationResponse }
   * @throws ApiException if fails to make API call
   */
  public GetNotificationConfigurationResponse updateNotificationConfiguration(
      UpdateNotificationConfigurationRequest updateNotificationConfigurationRequest)
      throws ApiException, IOException {
    return updateNotificationConfiguration(updateNotificationConfigurationRequest, null);
  }

  /**
   * Update a notification subscription configuration
   *
   * @param updateNotificationConfigurationRequest {@link UpdateNotificationConfigurationRequest }
   *     (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link GetNotificationConfigurationResponse }
   * @throws ApiException if fails to make API call
   */
  public GetNotificationConfigurationResponse updateNotificationConfiguration(
      UpdateNotificationConfigurationRequest updateNotificationConfigurationRequest,
      RequestOptions requestOptions)
      throws ApiException, IOException {

    String requestBody = updateNotificationConfigurationRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/updateNotificationConfiguration", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return GetNotificationConfigurationResponse.fromJson(jsonResult);
  }
}
