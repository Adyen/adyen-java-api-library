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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.httpclient;

import com.adyen.Config;
import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;
import java.io.Closeable;
import java.io.IOException;
import java.util.Map;

/**
 * Interface for HTTP client implementations used to make Adyen API requests. All API services
 * delegate HTTP communication to an implementation of this interface.
 *
 * <p>Implements {@link Closeable} to allow releasing underlying resources (e.g. connection pools).
 * A default no-op {@link #close()} is provided for backward compatibility with existing custom
 * implementations.
 *
 * @see com.adyen.httpclient.AdyenHttpClient
 */
public interface ClientInterface extends Closeable {

  /** Default no-op close for backward compatibility with custom implementations. */
  @Override
  default void close() throws IOException {}

  /**
   * Sends an HTTP POST request to the given endpoint.
   *
   * @param endpoint the full URL of the API endpoint
   * @param requestBody the JSON request body
   * @param config the client configuration containing authentication and timeout settings
   * @return the JSON response body
   * @throws IOException if a network error occurs
   * @throws HTTPClientException if the server returns a non-2xx status code
   */
  String request(String endpoint, String requestBody, Config config)
      throws IOException, HTTPClientException;

  /**
   * Sends an HTTP POST request with optional API key authentication.
   *
   * @param endpoint the full URL of the API endpoint
   * @param requestBody the JSON request body
   * @param config the client configuration
   * @param isApiKeyRequired whether API key authentication is mandatory for this request
   * @return the JSON response body
   * @throws IOException if a network error occurs
   * @throws HTTPClientException if the server returns a non-2xx status code
   */
  String request(String endpoint, String requestBody, Config config, boolean isApiKeyRequired)
      throws IOException, HTTPClientException;

  /**
   * Sends an HTTP POST request with optional API key authentication and request options.
   *
   * @param endpoint the full URL of the API endpoint
   * @param requestBody the JSON request body
   * @param config the client configuration
   * @param isApiKeyRequired whether API key authentication is mandatory
   * @param requestOptions additional request options (idempotency key, custom headers)
   * @return the JSON response body
   * @throws IOException if a network error occurs
   * @throws HTTPClientException if the server returns a non-2xx status code
   */
  String request(
      String endpoint,
      String requestBody,
      Config config,
      boolean isApiKeyRequired,
      RequestOptions requestOptions)
      throws IOException, HTTPClientException;

  /**
   * Sends an HTTP request with the specified method, authentication, and request options.
   *
   * @param endpoint the full URL of the API endpoint
   * @param requestBody the JSON request body (may be null for GET/DELETE)
   * @param config the client configuration
   * @param isApiKeyRequired whether API key authentication is mandatory
   * @param requestOptions additional request options (idempotency key, custom headers)
   * @param httpMethod the HTTP method (GET, POST, PATCH, DELETE)
   * @return the JSON response body
   * @throws IOException if a network error occurs
   * @throws HTTPClientException if the server returns a non-2xx status code
   */
  String request(
      String endpoint,
      String requestBody,
      Config config,
      boolean isApiKeyRequired,
      RequestOptions requestOptions,
      ApiConstants.HttpMethod httpMethod)
      throws IOException, HTTPClientException;

  /**
   * Sends an HTTP request with the specified method, authentication, request options, and query
   * string parameters. This is the most complete overload used by all API service classes.
   *
   * @param endpoint the full URL of the API endpoint
   * @param requestBody the JSON request body (may be null for GET/DELETE)
   * @param config the client configuration
   * @param isApiKeyRequired whether API key authentication is mandatory
   * @param requestOptions additional request options (idempotency key, custom headers)
   * @param httpMethod the HTTP method (GET, POST, PATCH, DELETE)
   * @param params query string parameters appended to the URL
   * @return the JSON response body
   * @throws IOException if a network error occurs
   * @throws HTTPClientException if the server returns a non-2xx status code
   */
  String request(
      String endpoint,
      String requestBody,
      Config config,
      boolean isApiKeyRequired,
      RequestOptions requestOptions,
      ApiConstants.HttpMethod httpMethod,
      Map<String, String> params)
      throws IOException, HTTPClientException;
}
