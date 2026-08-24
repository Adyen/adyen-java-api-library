/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####( ######  ############   ############
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

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.NameValuePair;
import org.apache.hc.core5.http.message.BasicNameValuePair;
import org.apache.hc.core5.net.URLEncodedUtils;

/** Serializes multipart and URL-encoded request form data. */
public final class RequestForm {
  private static final String MULTIPART_FORM_DATA = "multipart/form-data";
  private static final String URL_ENCODED_FORM_DATA = "application/x-www-form-urlencoded";

  private final boolean multipart;
  private final List<NameValuePair> urlEncodedFields = new ArrayList<>();
  private final MultipartEntityBuilder multipartBuilder;
  private HttpEntity multipartEntity;

  private RequestForm(boolean multipart) {
    this.multipart = multipart;
    this.multipartBuilder = multipart ? MultipartEntityBuilder.create() : null;
  }

  /**
   * Creates a form encoder for an operation's supported content types.
   *
   * @param contentTypes media types accepted by the operation
   * @return a multipart or URL-encoded form encoder
   */
  public static RequestForm create(List<String> contentTypes) {
    boolean isMultipart =
        contentTypes.stream()
            .map(RequestForm::normalizeMediaType)
            .anyMatch(MULTIPART_FORM_DATA::equals);
    return new RequestForm(isMultipart);
  }

  /**
   * Adds a text form field.
   *
   * @param name field name
   * @param value field value
   */
  public void add(String name, String value) {
    if (multipart) {
      multipartBuilder.addTextBody(name, value, ContentType.TEXT_PLAIN);
    } else {
      urlEncodedFields.add(new BasicNameValuePair(name, value));
    }
  }

  /**
   * Adds a file form field.
   *
   * @param name field name
   * @param file file value
   * @throws IllegalStateException if the operation does not accept multipart form data
   */
  public void add(String name, HttpFile file) {
    if (!multipart) {
      throw new IllegalStateException("Files require a multipart/form-data request");
    }
    multipartBuilder.addBinaryBody(
        name, file.getData(), ContentType.DEFAULT_BINARY, file.getName());
  }

  /**
   * Serializes the form request body.
   *
   * @return encoded request body
   * @throws IOException if multipart serialization fails
   */
  public byte[] getRequestBody() throws IOException {
    if (!multipart) {
      return URLEncodedUtils.format(urlEncodedFields, StandardCharsets.UTF_8)
          .getBytes(StandardCharsets.UTF_8);
    }

    HttpEntity entity = getMultipartEntity();
    try (ByteArrayOutputStream output = new ByteArrayOutputStream()) {
      entity.writeTo(output);
      return output.toByteArray();
    }
  }

  /**
   * Gets the request content type, including its multipart boundary where applicable.
   *
   * @return form content type
   */
  public String getContentType() {
    if (!multipart) {
      return URL_ENCODED_FORM_DATA;
    }
    return getMultipartEntity().getContentType();
  }

  private static String normalizeMediaType(String contentType) {
    int parameterIndex = contentType.indexOf(';');
    return contentType
        .substring(0, parameterIndex < 0 ? contentType.length() : parameterIndex)
        .trim()
        .toLowerCase();
  }

  private HttpEntity getMultipartEntity() {
    if (multipartEntity == null) {
      multipartEntity = multipartBuilder.build();
    }
    return multipartEntity;
  }
}
