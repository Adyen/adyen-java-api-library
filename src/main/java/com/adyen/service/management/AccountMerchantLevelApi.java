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
import com.adyen.model.management.CreateMerchantRequest;
import com.adyen.model.management.CreateMerchantResponse;
import com.adyen.model.management.ListMerchantResponse;
import com.adyen.model.management.Merchant;
import com.adyen.model.management.RequestActivationResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AccountMerchantLevelApi extends Service {

  public static final String API_VERSION = "3";

  protected String baseURL;

  /**
   * Account - merchant level constructor in {@link com.adyen.service.management package}.
   *
   * @param client {@link Client } (required)
   */
  public AccountMerchantLevelApi(Client client) {
    super(client);
    this.baseURL = createBaseURL("https://management-test.adyen.com/v3");
  }

  /**
   * Account - merchant level constructor in {@link com.adyen.service.management package}. Please
   * use this constructor only if you would like to pass along your own url for routing or testing
   * purposes. The latest API version is defined in this class as a constant.
   *
   * @param client {@link Client } (required)
   * @param baseURL {@link String } (required)
   */
  public AccountMerchantLevelApi(Client client, String baseURL) {
    super(client);
    this.baseURL = baseURL;
  }

  /**
   * Create a merchant account
   *
   * @param createMerchantRequest {@link CreateMerchantRequest } (required)
   * @return {@link CreateMerchantResponse }
   * @throws ApiException if fails to make API call
   */
  public CreateMerchantResponse createMerchantAccount(CreateMerchantRequest createMerchantRequest)
      throws ApiException, IOException {
    return createMerchantAccount(createMerchantRequest, null);
  }

  /**
   * Create a merchant account
   *
   * @param createMerchantRequest {@link CreateMerchantRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link CreateMerchantResponse }
   * @throws ApiException if fails to make API call
   */
  public CreateMerchantResponse createMerchantAccount(
      CreateMerchantRequest createMerchantRequest, RequestOptions requestOptions)
      throws ApiException, IOException {
    String requestBody = createMerchantRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/merchants", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return CreateMerchantResponse.fromJson(jsonResult);
  }

  /**
   * Get a merchant account
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @return {@link Merchant }
   * @throws ApiException if fails to make API call
   */
  public Merchant getMerchantAccount(String merchantId) throws ApiException, IOException {
    return getMerchantAccount(merchantId, null);
  }

  /**
   * Get a merchant account
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link Merchant }
   * @throws ApiException if fails to make API call
   */
  public Merchant getMerchantAccount(String merchantId, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);

    String requestBody = null;
    Resource resource = new Resource(this, this.baseURL + "/merchants/{merchantId}", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.GET, pathParams);
    return Merchant.fromJson(jsonResult);
  }

  /**
   * Get a list of merchant accounts
   *
   * @return {@link ListMerchantResponse }
   * @throws ApiException if fails to make API call
   */
  public ListMerchantResponse listMerchantAccounts() throws ApiException, IOException {
    return listMerchantAccounts(null, null, null);
  }

  /**
   * Get a list of merchant accounts
   *
   * @param pageNumber {@link Integer } Query: The number of the page to fetch. (optional)
   * @param pageSize {@link Integer } Query: The number of items to have on a page, maximum 100. The
   *     default is 10 items on a page. (optional)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link ListMerchantResponse }
   * @throws ApiException if fails to make API call
   */
  public ListMerchantResponse listMerchantAccounts(
      Integer pageNumber, Integer pageSize, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add query params
    Map<String, String> queryParams = new HashMap<>();
    if (pageNumber != null) {
      queryParams.put("pageNumber", pageNumber.toString());
    }
    if (pageSize != null) {
      queryParams.put("pageSize", pageSize.toString());
    }

    String requestBody = null;
    Resource resource = new Resource(this, this.baseURL + "/merchants", null);
    String jsonResult =
        resource.request(
            requestBody, requestOptions, ApiConstants.HttpMethod.GET, null, queryParams);
    return ListMerchantResponse.fromJson(jsonResult);
  }

  /**
   * Request to activate a merchant account
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @return {@link RequestActivationResponse }
   * @throws ApiException if fails to make API call
   */
  public RequestActivationResponse requestToActivateMerchantAccount(String merchantId)
      throws ApiException, IOException {
    return requestToActivateMerchantAccount(merchantId, null);
  }

  /**
   * Request to activate a merchant account
   *
   * @param merchantId {@link String } The unique identifier of the merchant account. (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link RequestActivationResponse }
   * @throws ApiException if fails to make API call
   */
  public RequestActivationResponse requestToActivateMerchantAccount(
      String merchantId, RequestOptions requestOptions) throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (merchantId == null) {
      throw new IllegalArgumentException("Please provide the merchantId path parameter");
    }
    pathParams.put("merchantId", merchantId);

    String requestBody = null;
    Resource resource = new Resource(this, this.baseURL + "/merchants/{merchantId}/activate", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, pathParams);
    return RequestActivationResponse.fromJson(jsonResult);
  }
}
