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
 * Copyright (c) 2022 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model;

import java.util.HashMap;

/**
 * Container for optional HTTP headers that can be included in API requests.
 * These options can be used to specify headers such as the Idempotency-Key, WWW-Authenticate
 * or other custom headers.
 */
public class RequestOptions {
  private String idempotencyKey;
  private String requestedVerificationCodeHeader;
  private String wwwAuthenticateHeader;
  private HashMap<String, String> additionalServiceHeaders;

  /**
   * Set the Idempotency-Key header for the request.
   *
   * @param idempotencyKey The idempotency key.
   * @return This {@link RequestOptions} instance.
   */
  public RequestOptions idempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
    return this;
  }

  /**
   * Set the Requested-Verification-Code header for the request.
   *
   * @param requestedVerificationCodeHeader The requested verification code.
   * @return This {@link RequestOptions} instance.
   */
  public RequestOptions requestedVerificationCodeHeader(String requestedVerificationCodeHeader) {
    this.requestedVerificationCodeHeader = requestedVerificationCodeHeader;
    return this;
  }

  /**
   * Set the WWW-Authenticate header for the request.
   *
   * @param wwwAuthenticateHeader The WWW-Authenticate header value.
   * @return This {@link RequestOptions} instance.
   */
  public RequestOptions wwwAuthenticateHeader(String wwwAuthenticateHeader) {
    this.wwwAuthenticateHeader = wwwAuthenticateHeader;
    return this;
  }

  /**
   * Set additional headers for the request.
   *
   * @param additionalServiceHeaders A map of additional headers.
   * @return This {@link RequestOptions} instance.
   */
  public RequestOptions additionalServiceHeaders(HashMap<String, String> additionalServiceHeaders) {
    this.additionalServiceHeaders = additionalServiceHeaders;
    return this;
  }

  /**
   * Add an additional header to the request.
   *
   * @param key The key of the header.
   * @param value The value of the header.
   * @return This {@link RequestOptions} instance.
   */
  public RequestOptions addAdditionalServiceHeader(String key, String value) {
    if (this.additionalServiceHeaders == null) {
      this.additionalServiceHeaders = new HashMap<>();
    }
    this.additionalServiceHeaders.put(key, value);
    return this;
  }

  /**
   * Get the value of the Idempotency-Key header.
   *
   * @return The idempotency key.
   */
  public String getIdempotencyKey() {
    return idempotencyKey;
  }

  /**
   * Sets idempotency key.
   *
   * @param idempotencyKey the idempotency key
   */
  public void setIdempotencyKey(String idempotencyKey) {
    this.idempotencyKey = idempotencyKey;
  }

  /**
   * Gets requested verification code header.
   *
   * @return the requested verification code header
   */
  public String getRequestedVerificationCodeHeader() {
    return requestedVerificationCodeHeader;
  }

  /**
   * Sets requested verification code header.
   *
   * @param requestedVerificationCodeHeader the requested verification code header
   */
  public void setRequestedVerificationCodeHeader(String requestedVerificationCodeHeader) {
    this.requestedVerificationCodeHeader = requestedVerificationCodeHeader;
  }

  /**
   * Gets additional headers.
   *
   * @return the additional headers
   */
  public HashMap<String, String> getAdditionalServiceHeaders() {
    return additionalServiceHeaders;
  }

  /**
   * Sets additional headers.
   *
   * @param additionalServiceHeaders the additional headers
   */
  public void setAdditionalServiceHeaders(HashMap<String, String> additionalServiceHeaders) {
    this.additionalServiceHeaders = additionalServiceHeaders;
  }

  /**
   * Gets www authenticate header.
   *
   * @return the www authenticate header
   */
  public String getWwwAuthenticateHeader() {
    return wwwAuthenticateHeader;
  }

  /**
   * Sets www authenticate header.
   *
   * @param wwwAuthenticateHeader the www authenticate header
   */
  public void setWwwAuthenticateHeader(String wwwAuthenticateHeader) {
    this.wwwAuthenticateHeader = wwwAuthenticateHeader;
  }

  @Override
  public String toString() {
    return "RequestOptions{"
        + "idempotencyKey='"
        + idempotencyKey
        + '\''
        + ", requestedVerificationCodeHeader='"
        + requestedVerificationCodeHeader
        + '\''
        + ", wwwAuthenticateHeader='"
        + wwwAuthenticateHeader
        + '\''
        + ", additionalServiceHeaders="
        + additionalServiceHeaders
        + '}';
  }
}
