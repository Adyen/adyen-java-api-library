/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############  #############  ######
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
package com.adyen.httpclient;

import java.util.Arrays;

/** Contains a binary request payload and its content type. */
public final class BinaryRequestBody {
  private final byte[] data;
  private final String contentType;

  /**
   * Creates a binary request payload.
   *
   * @param data request body data
   * @param contentType request content type
   */
  public BinaryRequestBody(byte[] data, String contentType) {
    this.data = Arrays.copyOf(data, data.length);
    this.contentType = contentType;
  }

  /**
   * Gets a copy of the request body data.
   *
   * @return request body data
   */
  public byte[] getData() {
    return Arrays.copyOf(data, data.length);
  }

  /**
   * Gets the request content type.
   *
   * @return request content type
   */
  public String getContentType() {
    return contentType;
  }
}
