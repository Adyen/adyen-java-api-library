package com.adyen.service.clouddevice;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.clouddevice.*;
import com.adyen.model.clouddevice.CloudDeviceApiAsyncResponse;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** Service of the Cloud Device API */
public class CloudDeviceApi extends Service {

  public static final String API_VERSION = "1";

  protected String baseURL;

  /**
   * CloudDeviceApi constructor in {@link com.adyen.service.clouddevice package}.
   *
   * @param client {@link Client } (required)
   */
  public CloudDeviceApi(Client client) {
    super(client);
    this.baseURL = createBaseURL("https://device-api-test.adyen.com/v1");
  }

  /**
   * CloudDeviceApi constructor in {@link com.adyen.service.clouddevice package}. Please use this
   * constructor only if you would like to pass along your own url for routing or testing purposes.
   * The latest API version is defined in this class as a constant.
   *
   * @param client {@link Client } (required)
   * @param baseURL {@link String } (required)
   */
  public CloudDeviceApi(Client client, String baseURL) {
    super(client);
    this.baseURL = baseURL;
  }

  /**
   * Send a synchronous payment request.
   *
   * @param merchantAccount The unique identifier of the merchant account
   * @param deviceId The unique identifier of the payment device that you send this request to (must
   *     match POIID in the MessageHeader).
   * @param cloudDeviceApiRequest The request to send.
   * @return instance of CloudDeviceApiResponse
   * @throws ApiException when an error occurs
   */
  public CloudDeviceApiResponse sync(
      String merchantAccount, String deviceId, CloudDeviceApiRequest cloudDeviceApiRequest)
      throws ApiException, IOException {

    // Add path params
    Map<String, String> pathParams = new HashMap<>();

    if (merchantAccount == null) {
      throw new IllegalArgumentException("Please provide the merchantAccount path parameter");
    }
    pathParams.put("merchantAccount", merchantAccount);

    if (deviceId == null) {
      throw new IllegalArgumentException("Please provide the deviceId path parameter");
    }
    pathParams.put("deviceId", deviceId);

    if (cloudDeviceApiRequest.getSaleToPOIRequest() == null
        || cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader() == null) {
      throw new IllegalArgumentException(
          "cloudDeviceApiRequest must contain a SaleToPOIRequest with a MessageHeader");
    }
    cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader().setPOIID(deviceId);

    String requestBody = cloudDeviceApiRequest.toJson();
    Resource resource =
        new Resource(
            this, this.baseURL + "/merchants/{merchantAccount}/devices/{deviceId}/sync", null);
    String response = resource.request(requestBody, null, ApiConstants.HttpMethod.POST, pathParams);

    return CloudDeviceApiResponse.fromJson(response);
  }

  /**
   * Send an asynchronous payment request.
   *
   * @param merchantAccount The unique identifier of the merchant account
   * @param deviceId The unique identifier of the device that you send this request to (must match
   *     POIID in the MessageHeader).
   * @param cloudDeviceApiRequest The request to send.
   * @return instance of CloudDeviceApiAsyncResponse wrapping the response (success or an
   *     EventNotification with error details)
   * @throws ApiException when an error occurs
   */
  public CloudDeviceApiAsyncResponse async(
      String merchantAccount, String deviceId, CloudDeviceApiRequest cloudDeviceApiRequest)
      throws ApiException, IOException {

    // Add path params
    Map<String, String> pathParams = new HashMap<>();

    if (merchantAccount == null) {
      throw new IllegalArgumentException("Please provide the merchantAccount path parameter");
    }
    pathParams.put("merchantAccount", merchantAccount);

    if (deviceId == null) {
      throw new IllegalArgumentException("Please provide the deviceId path parameter");
    }
    pathParams.put("deviceId", deviceId);

    if (cloudDeviceApiRequest.getSaleToPOIRequest() == null
        || cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader() == null) {
      throw new IllegalArgumentException(
          "cloudDeviceApiRequest must contain a SaleToPOIRequest with a MessageHeader");
    }
    cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader().setPOIID(deviceId);

    String requestBody = cloudDeviceApiRequest.toJson();
    Resource resource =
        new Resource(
            this, this.baseURL + "/merchants/{merchantAccount}/devices/{deviceId}/async", null);
    String response = resource.request(requestBody, null, ApiConstants.HttpMethod.POST, pathParams);

    CloudDeviceApiAsyncResponse cloudDeviceApiAsyncResponse = new CloudDeviceApiAsyncResponse();

    // Define response based on the outcome
    if ("ok".equalsIgnoreCase(response.trim())) {
      cloudDeviceApiAsyncResponse.setResult(response.trim());
    } else {
      CloudDeviceApiAsyncResponse errorResponse = CloudDeviceApiAsyncResponse.fromJson(response);
      cloudDeviceApiAsyncResponse.setSaleToPOIRequest(errorResponse.getSaleToPOIRequest());
    }

    return cloudDeviceApiAsyncResponse;
  }

  /**
   * Get a list of connected devices for a merchant account.
   *
   * @param merchantAccount The unique identifier of the merchant account.
   * @return An instance of ConnectedDevicesResponse.
   * @throws ApiException when an error occurs
   */
  public ConnectedDevicesResponse getConnectedDevices(String merchantAccount)
      throws ApiException, IOException {
    return getConnectedDevices(merchantAccount, null);
  }

  /**
   * Get a list of connected devices for a merchant account and store.
   *
   * @param merchantAccount The unique identifier of the merchant account.
   * @param store The unique identifier of the store.
   * @return An instance of ConnectedDevicesResponse.
   * @throws ApiException when an error occurs
   */
  public ConnectedDevicesResponse getConnectedDevices(String merchantAccount, String store)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();

    if (merchantAccount == null) {
      throw new IllegalArgumentException("Please provide the merchantAccount path parameter");
    }
    pathParams.put("merchantAccount", merchantAccount);

    Map<String, String> queryParams = null;
    if (store != null) {
      queryParams = new HashMap<>();
      queryParams.put("store", store);
    }

    Resource resource =
        new Resource(this, this.baseURL + "/merchants/{merchantAccount}/connectedDevices", null);
    String response =
        resource.request(null, null, ApiConstants.HttpMethod.GET, pathParams, queryParams);

    return ConnectedDevicesResponse.fromJson(response);
  }

  /**
   * Get the status of a device.
   *
   * @param merchantAccount The unique identifier of the merchant account.
   * @param deviceId The unique identifier of the device.
   * @return An instance of DeviceStatus.
   * @throws ApiException when an error occurs
   */
  public DeviceStatusResponse getDeviceStatus(String merchantAccount, String deviceId)
      throws ApiException, IOException {
    // Add path params
    Map<String, String> pathParams = new HashMap<>();

    if (merchantAccount == null) {
      throw new IllegalArgumentException("Please provide the merchantAccount path parameter");
    }
    pathParams.put("merchantAccount", merchantAccount);

    if (deviceId == null) {
      throw new IllegalArgumentException("Please provide the deviceId path parameter");
    }
    pathParams.put("deviceId", deviceId);

    Resource resource =
        new Resource(
            this, this.baseURL + "/merchants/{merchantAccount}/devices/{deviceId}/status", null);
    String response = resource.request(null, null, ApiConstants.HttpMethod.GET, pathParams, null);

    return DeviceStatusResponse.fromJson(response);
  }
}
