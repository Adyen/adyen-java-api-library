/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####   ######
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

/** Represents a file uploaded as part of a multipart request. */
public class HttpFile {
  private final byte[] data;
  private final String name;

  /**
   * Creates a file for a multipart request.
   *
   * @param data file contents
   * @param name file name sent to the API
   */
  public HttpFile(byte[] data, String name) {
    this.data = Arrays.copyOf(data, data.length);
    this.name = name;
  }

  /**
   * Gets a copy of the file contents.
   *
   * @return file contents
   */
  public byte[] getData() {
    return Arrays.copyOf(data, data.length);
  }

  /**
   * Gets the file name.
   *
   * @return file name
   */
  public String getName() {
    return name;
  }
}
