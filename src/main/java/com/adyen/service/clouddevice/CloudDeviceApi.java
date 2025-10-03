package com.adyen.service.clouddevice;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.clouddevice.*;
import com.adyen.security.clouddevice.EncryptionCredentialDetails;
import com.adyen.security.clouddevice.NexoSecurityManager;
import com.adyen.service.exception.CloudDeviceException;
import com.adyen.service.resource.Resource;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Map;

/**
 * Cloud Device API service
 *
 * <p>With the Cloud device API you can: - send Terminal API requests to the Adyen cloud endpoints.
 * - check the cloud connection of a payment terminal or of a device used in a Mobile solution for
 * in-person payments.
 */
public class CloudDeviceApi extends Service {

  public static final String API_VERSION = "1";

  protected String baseURL;

  private final ObjectMapper objectMapper = new ObjectMapper();

  /**
   * CloudDeviceApi constructor in {@link com.adyen.service.clouddevice package}.
   *
   * @param client {@link Client } (required)
   */
  public CloudDeviceApi(Client client) {
    super(client);
    this.baseURL = createBaseURL("https://device-api-test.adyen.com/v" + API_VERSION);
  }

  /**
   * Send a synchronous payment request.
   *
   * @param merchantAccount The unique identifier of the merchant account
   * @param deviceId The unique identifier of the payment device that you send this request to (must
   *     match POIID in the MessageHeader).
   * @param cloudDeviceApiRequest The request to send.
   * @return instance of CloudDeviceApiResponse
   * @throws CloudDeviceException when an error occurs
   */
  public CloudDeviceApiResponse sendSync(
      String merchantAccount, String deviceId, CloudDeviceApiRequest cloudDeviceApiRequest)
      throws CloudDeviceException {

    try {
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

      // set deviceId
      cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader().setPOIID(deviceId);

      String requestBody = cloudDeviceApiRequest.toJson();
      Resource resource =
          new Resource(
              this, this.baseURL + "/merchants/{merchantAccount}/devices/{deviceId}/sync", null);
      String response =
          resource.request(requestBody, null, ApiConstants.HttpMethod.POST, pathParams);

      return CloudDeviceApiResponse.fromJson(response);

    } catch (Exception e) {
      throw new CloudDeviceException(e.getMessage(), e);
    }
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
   * @throws CloudDeviceException when an error occurs
   */
  public CloudDeviceApiAsyncResponse sendAsync(
      String merchantAccount, String deviceId, CloudDeviceApiRequest cloudDeviceApiRequest)
      throws CloudDeviceException {

    try {
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

      // set deviceId
      cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader().setPOIID(deviceId);

      String requestBody = cloudDeviceApiRequest.toJson();
      Resource resource =
          new Resource(
              this, this.baseURL + "/merchants/{merchantAccount}/devices/{deviceId}/async", null);
      String response =
          resource.request(requestBody, null, ApiConstants.HttpMethod.POST, pathParams);

      CloudDeviceApiAsyncResponse cloudDeviceApiAsyncResponse = new CloudDeviceApiAsyncResponse();

      // Define response based on the outcome
      if ("ok".equals(response)) {
        cloudDeviceApiAsyncResponse.setResult(response);
      } else {
        CloudDeviceApiResponse errorResponse = CloudDeviceApiResponse.fromJson(response);
        cloudDeviceApiAsyncResponse.setSaleToPOIRequest(errorResponse.getSaleToPOIRequest());
      }

      return cloudDeviceApiAsyncResponse;

    } catch (Exception e) {
      throw new CloudDeviceException(e.getMessage(), e);
    }
  }

  /**
   * Get a list of connected devices for a merchant account.
   *
   * @param merchantAccount The unique identifier of the merchant account.
   * @return An instance of ConnectedDevicesResponse.
   * @throws CloudDeviceException when an error occurs
   */
  public ConnectedDevicesResponse getConnectedDevices(String merchantAccount)
      throws CloudDeviceException {
    return getConnectedDevices(merchantAccount, null);
  }

  /**
   * Get a list of connected devices for a merchant account and store.
   *
   * @param merchantAccount The unique identifier of the merchant account.
   * @param store The unique identifier of the store.
   * @return An instance of ConnectedDevicesResponse.
   * @throws CloudDeviceException when an error occurs
   */
  public ConnectedDevicesResponse getConnectedDevices(String merchantAccount, String store)
      throws CloudDeviceException {

    try {
      // Add path params
      Map<String, String> pathParams = new HashMap<>();

      if (merchantAccount == null) {
        throw new IllegalArgumentException("Please provide the merchantAccount path parameter");
      }
      pathParams.put("merchantAccount", merchantAccount);

      // Add query params
      Map<String, String> queryParams = new HashMap<>();
      if (store != null) {
        queryParams.put("store", store);
      }

      Resource resource =
          new Resource(this, this.baseURL + "/merchants/{merchantAccount}/connectedDevices", null);
      String response =
          resource.request(
              null,
              null,
              ApiConstants.HttpMethod.GET,
              pathParams,
              queryParams.isEmpty() ? null : queryParams);

      return ConnectedDevicesResponse.fromJson(response);

    } catch (Exception e) {
      throw new CloudDeviceException(e.getMessage(), e);
    }
  }

  /**
   * Get the status of a device.
   *
   * @param merchantAccount The unique identifier of the merchant account.
   * @param deviceId The unique identifier of the device.
   * @return An instance of DeviceStatus.
   * @throws CloudDeviceException when an error occurs
   */
  public DeviceStatusResponse getDeviceStatus(String merchantAccount, String deviceId)
      throws CloudDeviceException {

    try {
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

    } catch (Exception e) {
      throw new CloudDeviceException(e.getMessage(), e);
    }
  }

  /**
   * Send a synchronous encrypted payment request.
   *
   * @param merchantAccount The unique identifier of the merchant account
   * @param deviceId The unique identifier of the payment device that you send this request to (must
   *     match POIID in the MessageHeader).
   * @param cloudDeviceApiRequest The request to send.
   * @return instance of CloudDeviceApiResponse
   * @throws CloudDeviceException when an error occurs
   */
  public CloudDeviceApiResponse sendEncryptedSync(
      String merchantAccount,
      String deviceId,
      CloudDeviceApiRequest cloudDeviceApiRequest,
      EncryptionCredentialDetails encryptionCredentialDetails)
      throws CloudDeviceException {

    try {
      NexoSecurityManager nexoSecurityManager =
          new NexoSecurityManager(encryptionCredentialDetails);

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

      // set deviceId
      cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader().setPOIID(deviceId);

      // encrypt payload
      SaleToPOISecuredMessage saleToPOISecuredRequest =
          nexoSecurityManager.encrypt(
              cloudDeviceApiRequest.toJson(),
              cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader());

      CloudDeviceApiSecuredRequest cloudDeviceApiSecuredRequest =
          new CloudDeviceApiSecuredRequest();
      cloudDeviceApiSecuredRequest.setSaleToPOIRequest(saleToPOISecuredRequest);

      String encryptedJson = cloudDeviceApiSecuredRequest.toJson();

      // perform API call
      Resource resource =
          new Resource(
              this, this.baseURL + "/merchants/{merchantAccount}/devices/{deviceId}/sync", null);
      String response =
          resource.request(encryptedJson, null, ApiConstants.HttpMethod.POST, pathParams);

      CloudDeviceApiSecuredResponse cloudDeviceApiSecuredResponse =
          CloudDeviceApiSecuredResponse.fromJson(response);

      String jsonDecryptedResponse =
          nexoSecurityManager.decrypt(cloudDeviceApiSecuredResponse.getSaleToPOIResponse());

      return CloudDeviceApiResponse.fromJson(jsonDecryptedResponse);

    } catch (Exception e) {
      throw new CloudDeviceException(e.getMessage(), e);
    }
  }

  /**
   * Send an asynchronous encrypted payment request.
   *
   * @param merchantAccount The unique identifier of the merchant account
   * @param deviceId The unique identifier of the payment device that you send this request to (must
   *     match POIID in the MessageHeader).
   * @param cloudDeviceApiRequest The request to send.
   * @return instance of CloudDeviceApiResponse
   * @throws CloudDeviceException when an error occurs
   */
  public String sendEncryptedAsync(
      String merchantAccount,
      String deviceId,
      CloudDeviceApiRequest cloudDeviceApiRequest,
      EncryptionCredentialDetails encryptionCredentialDetails)
      throws CloudDeviceException {

    try {
      NexoSecurityManager nexoSecurityManager =
          new NexoSecurityManager(encryptionCredentialDetails);

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

      // set deviceId
      cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader().setPOIID(deviceId);

      // encrypt payload
      SaleToPOISecuredMessage saleToPOISecuredRequest =
          nexoSecurityManager.encrypt(
              cloudDeviceApiRequest.toJson(),
              cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader());

      CloudDeviceApiSecuredRequest cloudDeviceApiSecuredRequest =
          new CloudDeviceApiSecuredRequest();
      cloudDeviceApiSecuredRequest.setSaleToPOIRequest(saleToPOISecuredRequest);

      String encryptedJson = cloudDeviceApiSecuredRequest.toJson();

      // perform API call
      Resource resource =
          new Resource(
              this, this.baseURL + "/merchants/{merchantAccount}/devices/{deviceId}/async", null);
      String response =
          resource.request(encryptedJson, null, ApiConstants.HttpMethod.POST, pathParams);

      return response;

    } catch (Exception e) {
      throw new CloudDeviceException(e.getMessage(), e);
    }
  }

  /**
   * Decrypt an event notification
   *
   * @param payload Event notification in JSON string format: it can be SaleToPOIResponse (async
   *     response) or SaleToPOIRequest (event notification)
   * @param encryptionCredentialDetails The details of the encryption credential used for decrypting
   *     the payload (nexoBlob)
   * @return the decrypted payload
   * @throws CloudDeviceException when an error occurs
   */
  public String decryptNotification(
      String payload, EncryptionCredentialDetails encryptionCredentialDetails)
      throws CloudDeviceException {

    try {
      NexoSecurityManager nexoSecurityManager =
          new NexoSecurityManager(encryptionCredentialDetails);

      ObjectMapper objectMapper = new ObjectMapper();
      JsonNode jsonNode;

      try {
        jsonNode = objectMapper.readTree(payload);
      } catch (Exception e) {
        throw new CloudDeviceException("Invalid payload");
      }

      String decryptedMessage;
      if (jsonNode.has("SaleToPOIResponse")) {
        // async response received
        var cloudDeviceApiSecuredResponse = CloudDeviceApiSecuredResponse.fromJson(payload);
        decryptedMessage =
            nexoSecurityManager.decrypt(cloudDeviceApiSecuredResponse.getSaleToPOIResponse());
      } else if (jsonNode.has("SaleToPOIRequest")) {
        var cloudDeviceApiSecuredRequest = CloudDeviceApiSecuredRequest.fromJson(payload);
        decryptedMessage =
            nexoSecurityManager.decrypt(cloudDeviceApiSecuredRequest.getSaleToPOIRequest());
      } else {
        throw new CloudDeviceException(
            "Unexpected payload without SaleToPOIResponse or SaleToPOIRequest");
      }

      return decryptedMessage;

    } catch (Exception e) {
      throw new CloudDeviceException(e.getMessage(), e);
    }
  }
}
