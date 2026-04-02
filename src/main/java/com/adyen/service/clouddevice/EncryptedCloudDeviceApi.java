/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service.clouddevice;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.clouddevice.*;
import com.adyen.security.clouddevice.EncryptionCredentialDetails;
import com.adyen.security.clouddevice.NexoSecurityException;
import com.adyen.security.clouddevice.NexoSecurityManager;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/** Service of the Cloud Device API with encrypted payloads */
public class EncryptedCloudDeviceApi extends Service {

  public static final String API_VERSION = "1";

  protected String baseURL;
  private final NexoSecurityManager nexoSecurityManager;

  /**
   * EncryptedCloudDeviceApi constructor.
   *
   * @param client {@link Client } (required)
   * @param encryptionCredentialDetails {@link EncryptionCredentialDetails } (required)
   * @throws NexoSecurityException if the encryption credentials are invalid
   */
  public EncryptedCloudDeviceApi(
      Client client, EncryptionCredentialDetails encryptionCredentialDetails)
      throws NexoSecurityException {
    super(client);
    this.baseURL = createBaseURL("https://device-api-test.adyen.com/v1");
    this.nexoSecurityManager = new NexoSecurityManager(encryptionCredentialDetails);
  }

  /**
   * EncryptedCloudDeviceApi constructor with a custom base URL for routing or testing purposes.
   *
   * @param client {@link Client } (required)
   * @param baseURL {@link String } (required)
   * @param encryptionCredentialDetails {@link EncryptionCredentialDetails } (required)
   * @throws NexoSecurityException if the encryption credentials are invalid
   */
  public EncryptedCloudDeviceApi(
      Client client, String baseURL, EncryptionCredentialDetails encryptionCredentialDetails)
      throws NexoSecurityException {
    super(client);
    this.baseURL = baseURL;
    this.nexoSecurityManager = new NexoSecurityManager(encryptionCredentialDetails);
  }

  /**
   * Send a synchronous encrypted request.
   *
   * @param merchantAccount The unique identifier of the merchant account
   * @param deviceId The unique identifier of the device that you send this request to (must match
   *     POIID in the MessageHeader).
   * @param cloudDeviceApiRequest The request to send.
   * @return instance of CloudDeviceApiResponse
   * @throws ApiException when an error occurs
   * @throws IOException when an I/O error occurs
   * @throws NexoSecurityException when encryption or decryption fails
   */
  public CloudDeviceApiResponse sync(
      String merchantAccount, String deviceId, CloudDeviceApiRequest cloudDeviceApiRequest)
      throws ApiException, IOException, NexoSecurityException {

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

    SaleToPOISecuredMessage saleToPOISecuredRequest =
        nexoSecurityManager.encrypt(
            cloudDeviceApiRequest.toJson(),
            cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader());

    CloudDeviceApiSecuredRequest cloudDeviceApiSecuredRequest = new CloudDeviceApiSecuredRequest();
    cloudDeviceApiSecuredRequest.setSaleToPOIRequest(saleToPOISecuredRequest);

    Resource resource =
        new Resource(
            this, this.baseURL + "/merchants/{merchantAccount}/devices/{deviceId}/sync", null);
    String response =
        resource.request(
            cloudDeviceApiSecuredRequest.toJson(), null, ApiConstants.HttpMethod.POST, pathParams);

    CloudDeviceApiSecuredResponse cloudDeviceApiSecuredResponse =
        CloudDeviceApiSecuredResponse.fromJson(response);

    return CloudDeviceApiResponse.fromJson(
        nexoSecurityManager.decrypt(cloudDeviceApiSecuredResponse.getSaleToPOIResponse()));
  }

  /**
   * Send an asynchronous encrypted request.
   *
   * @param merchantAccount The unique identifier of the merchant account
   * @param deviceId The unique identifier of the device that you send this request to (must match
   *     POIID in the MessageHeader).
   * @param cloudDeviceApiRequest The request to send.
   * @return {@link CloudDeviceApiAsyncResponse} with result "ok" on success, or the decrypted
   *     EventNotification details on failure
   * @throws ApiException when an error occurs
   * @throws IOException when an I/O error occurs
   * @throws NexoSecurityException when encryption or decryption fails
   */
  public CloudDeviceApiAsyncResponse async(
      String merchantAccount, String deviceId, CloudDeviceApiRequest cloudDeviceApiRequest)
      throws ApiException, IOException, NexoSecurityException {

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

    SaleToPOISecuredMessage saleToPOISecuredRequest =
        nexoSecurityManager.encrypt(
            cloudDeviceApiRequest.toJson(),
            cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader());

    CloudDeviceApiSecuredRequest cloudDeviceApiSecuredRequest = new CloudDeviceApiSecuredRequest();
    cloudDeviceApiSecuredRequest.setSaleToPOIRequest(saleToPOISecuredRequest);

    Resource resource =
        new Resource(
            this, this.baseURL + "/merchants/{merchantAccount}/devices/{deviceId}/async", null);

    String response =
        resource.request(
            cloudDeviceApiSecuredRequest.toJson(), null, ApiConstants.HttpMethod.POST, pathParams);

    CloudDeviceApiAsyncResponse cloudDeviceApiAsyncResponse = new CloudDeviceApiAsyncResponse();

    if ("ok".equalsIgnoreCase(response.trim())) {
      cloudDeviceApiAsyncResponse.setResult(response.trim());
    } else {
      // Error response: an encrypted EventNotification wrapped in a SaleToPOIRequest envelope.
      // Decrypt it and surface the SaleToPOIRequest to the caller.
      CloudDeviceApiSecuredRequest encryptedError = CloudDeviceApiSecuredRequest.fromJson(response);
      String decryptedJson = nexoSecurityManager.decrypt(encryptedError.getSaleToPOIRequest());
      CloudDeviceApiAsyncResponse errorResponse =
          CloudDeviceApiAsyncResponse.fromJson(decryptedJson);
      cloudDeviceApiAsyncResponse.setSaleToPOIRequest(errorResponse.getSaleToPOIRequest());
    }

    return cloudDeviceApiAsyncResponse;
  }

  /**
   * Decrypt an event notification.
   *
   * @param payload Event notification in JSON string format: it can be SaleToPOIResponse (async
   *     response) or SaleToPOIRequest (event notification)
   * @return the decrypted payload
   * @throws NexoSecurityException when decryption fails
   */
  public String decryptNotification(String payload) throws NexoSecurityException {
    try {
      JsonNode jsonNode;

      try {
        jsonNode = com.adyen.model.tapi.JSON.getMapper().readTree(payload);
      } catch (Exception e) {
        throw new NexoSecurityException("Invalid payload");
      }

      if (jsonNode.has("SaleToPOIResponse")) {
        CloudDeviceApiSecuredResponse cloudDeviceApiSecuredResponse =
            CloudDeviceApiSecuredResponse.fromJson(payload);
        return nexoSecurityManager.decrypt(cloudDeviceApiSecuredResponse.getSaleToPOIResponse());
      } else if (jsonNode.has("SaleToPOIRequest")) {
        CloudDeviceApiSecuredRequest cloudDeviceApiSecuredRequest =
            CloudDeviceApiSecuredRequest.fromJson(payload);
        return nexoSecurityManager.decrypt(cloudDeviceApiSecuredRequest.getSaleToPOIRequest());
      } else {
        throw new NexoSecurityException(
            "Unexpected payload without SaleToPOIResponse or SaleToPOIRequest");
      }

    } catch (NexoSecurityException e) {
      throw e;
    } catch (Exception e) {
      throw new NexoSecurityException(e.getMessage(), e);
    }
  }
}
