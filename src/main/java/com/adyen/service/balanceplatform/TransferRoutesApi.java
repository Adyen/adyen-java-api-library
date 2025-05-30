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
import com.adyen.model.balanceplatform.TransferRouteRequest;
import com.adyen.model.balanceplatform.TransferRouteResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import java.io.IOException;

public class TransferRoutesApi extends Service {

  public static final String API_VERSION = "2";

  protected String baseURL;

  /**
   * Transfer routes constructor in {@link com.adyen.service.balanceplatform package}.
   *
   * @param client {@link Client } (required)
   */
  public TransferRoutesApi(Client client) {
    super(client);
    this.baseURL = createBaseURL("https://balanceplatform-api-test.adyen.com/bcl/v2");
  }

  /**
   * Transfer routes constructor in {@link com.adyen.service.balanceplatform package}. Please use
   * this constructor only if you would like to pass along your own url for routing or testing
   * purposes. The latest API version is defined in this class as a constant.
   *
   * @param client {@link Client } (required)
   * @param baseURL {@link String } (required)
   */
  public TransferRoutesApi(Client client, String baseURL) {
    super(client);
    this.baseURL = baseURL;
  }

  /**
   * Calculate transfer routes
   *
   * @param transferRouteRequest {@link TransferRouteRequest } (required)
   * @return {@link TransferRouteResponse }
   * @throws ApiException if fails to make API call
   */
  public TransferRouteResponse calculateTransferRoutes(TransferRouteRequest transferRouteRequest)
      throws ApiException, IOException {
    return calculateTransferRoutes(transferRouteRequest, null);
  }

  /**
   * Calculate transfer routes
   *
   * @param transferRouteRequest {@link TransferRouteRequest } (required)
   * @param requestOptions {@link RequestOptions } Object to store additional data such as
   *     idempotency-keys (optional)
   * @return {@link TransferRouteResponse }
   * @throws ApiException if fails to make API call
   */
  public TransferRouteResponse calculateTransferRoutes(
      TransferRouteRequest transferRouteRequest, RequestOptions requestOptions)
      throws ApiException, IOException {
    String requestBody = transferRouteRequest.toJson();
    Resource resource = new Resource(this, this.baseURL + "/transferRoutes/calculate", null);
    String jsonResult =
        resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
    return TransferRouteResponse.fromJson(jsonResult);
  }
}
