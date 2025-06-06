/*
 * Adyen Checkout API
 *
 * The version of the OpenAPI document: 71
 *
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.service.checkout;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.ListStoredPaymentMethodsResponse;
import com.adyen.model.checkout.StoredPaymentMethodRequest;
import com.adyen.model.checkout.StoredPaymentMethodResource;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RecurringApi extends Service {

  public static final String API_VERSION = "71";

  protected String baseURL;

  /**
   * Recurring constructor in {@link com.adyen.service.checkout package}.
   *
   * @param client {@link Client } (required)
   */
  public RecurringApi(Client client) {
    super(client);
    this.baseURL = createBaseURL("https://checkout-test.adyen.com/v71");
  }

  /**
   * Recurring constructor in {@link com.adyen.service.checkout package}. Please use this
   * constructor only if you would like to pass along your own url for routing or testing purposes.
   * The latest API version is defined in this class as a constant.
   *
   * @param client {@link Client } (required)
   * @param baseURL {@link String } (required)
   */
  public RecurringApi(Client client, String baseURL) {
    super(client);
    this.baseURL = baseURL;
  }

  /**
   * Delete a token for stored payment details
   *
   * @param storedPaymentMethodId {@link String } The unique identifier of the token. (required)
   * @param shopperReference {@link String } Your reference to uniquely identify this shopper, for
   *     example user ID or account ID. Minimum length: 3 characters. &gt; Your reference must not
   *     include personally identifiable information (PII), for example name or email address.
   *     (required)
   * @param merchantAccount {@link String } Your merchant account. (required)
   * @throws ApiException if fails to make API call
   */
  public void deleteTokenForStoredPaymentDetails(
      String storedPaymentMethodId, String shopperReference, String merchantAccount)
      throws ApiException, IOException {
    deleteTokenForStoredPaymentDetails(
        storedPaymentMethodId, shopperReference, merchantAccount, null);
  }

  /**
   * Delete a token for stored payment details
   *
   * @param storedPaymentMethodId {@link String } The unique identifier of the token. (required)
   * @param shopperReference {@link String } Query: Your reference to uniquely identify this
   *     shopper, for example user ID or account ID. Minimum length: 3 characters. &gt; Your
   *     reference must not include personally identifiable information (PII), for example name or
   *     email address. (required)
   * @param merchantAccount {@link String } Query: Your merchant account. (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @throws ApiException if fails to make API call
   */
  public void deleteTokenForStoredPaymentDetails(
      String storedPaymentMethodId,
      String shopperReference,
      String merchantAccount,
      RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();
    if (storedPaymentMethodId == null) {
      throw new IllegalArgumentException("Please provide the storedPaymentMethodId path parameter");
    }
    pathParams.put("storedPaymentMethodId", storedPaymentMethodId);

    // Add query params
    Map<String, String> queryParams = new HashMap<>();
    if (shopperReference != null) {
      queryParams.put("shopperReference", shopperReference);
    }
    if (merchantAccount != null) {
      queryParams.put("merchantAccount", merchantAccount);
    }

    String requestBody = null;
    Resource resource =
        new Resource(this, this.baseURL + "/storedPaymentMethods/{storedPaymentMethodId}", null);
    resource.request(
        requestBody, requestOptions, ApiConstants.HttpMethod.DELETE, pathParams, queryParams);
  }

  /**
   * Get tokens for stored payment details
   *
   * @return {@link ListStoredPaymentMethodsResponse }
   * @throws ApiException if fails to make API call
   */
  public ListStoredPaymentMethodsResponse getTokensForStoredPaymentDetails()
      throws ApiException, IOException {
    return getTokensForStoredPaymentDetails(null, null, null);
  }

  /**
   * Get tokens for stored payment details
   *
   * @param shopperReference {@link String } Query: Your reference to uniquely identify this
   *     shopper, for example user ID or account ID. Minimum length: 3 characters. &gt; Your
   *     reference must not include personally identifiable information (PII), for example name or
   *     email address. (optional)
   * @param merchantAccount {@link String } Query: Your merchant account. (optional)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link ListStoredPaymentMethodsResponse }
   * @throws ApiException if fails to make API call
   */
  public ListStoredPaymentMethodsResponse getTokensForStoredPaymentDetails(
      String shopperReference, String merchantAccount, RequestOptions requestOptions)
      throws ApiException, IOException {
    // Add query params
    Map<String, String> queryParams = new HashMap<>();
    if (shopperReference != null) {
      queryParams.put("shopperReference", shopperReference);
    }
    if (merchantAccount != null) {
      queryParams.put("merchantAccount", merchantAccount);
    }

    String requestBody = null;
    Resource resource = new Resource(this, this.baseURL + "/storedPaymentMethods", null);
    String jsonResult =
        resource.request(
            requestBody, requestOptions, ApiConstants.HttpMethod.GET, null, queryParams);
    return ListStoredPaymentMethodsResponse.fromJson(jsonResult);
  }

  /**
   * Create a token to store payment details
   *
   * @param storedPaymentMethodRequest {@link StoredPaymentMethodRequest } (required)
   * @return {@link StoredPaymentMethodResource }
   * @throws ApiException if fails to make API call
   */
  public StoredPaymentMethodResource storedPaymentMethods(
      StoredPaymentMethodRequest storedPaymentMethodRequest) throws ApiException, IOException {
    return storedPaymentMethods(storedPaymentMethodRequest, null);
  }

  /**
   * Create a token to store payment details
   *
   * @param storedPaymentMethodRequest {@link StoredPaymentMethodRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link StoredPaymentMethodResource }
   * @throws ApiException if fails to make API call
   */
  public StoredPaymentMethodResource storedPaymentMethods(
      StoredPaymentMethodRequest storedPaymentMethodRequest, RequestOptions requestOptions)
      throws ApiException, IOException {
    String requestBody = storedPaymentMethodRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/storedPaymentMethods", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return StoredPaymentMethodResource.fromJson(jsonResult);
  }
}
