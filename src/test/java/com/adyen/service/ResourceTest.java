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
package com.adyen.service;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.httpclient.ClientInterface;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ResourceTest extends BaseTest {
  @Mock Service serviceMock;

  @Mock Client clientMock;

  @Mock ClientInterface clientInterfaceMock;

  @Before
  public void setUp() {
    when(clientMock.getHttpClient()).thenReturn(clientInterfaceMock);
    when(clientMock.getConfig()).thenReturn(null);
    when(serviceMock.getClient()).thenReturn(clientMock);
  }

  @Test
  public void testRequest() throws Exception {
    when(clientInterfaceMock.request(
            "", "request", null, false, null, ApiConstants.HttpMethod.POST, null))
        .thenReturn("response");

    Resource resource = new Resource(serviceMock, "", null);
    String response = resource.request("request");

    assertEquals("response", response);
  }

  @Test
  public void testRequestQueryString() throws Exception {
    Map<String, String> pathParams = Collections.singletonMap("companyId", "adyen");
    Map<String, String> queryString = Collections.singletonMap("pageSize", "10");
    Resource resource = new Resource(serviceMock, "/companies/{companyId}/merchants", null);

    resource.request(null, null, ApiConstants.HttpMethod.GET, pathParams, queryString);

    verify(clientInterfaceMock)
        .request(
            "/companies/adyen/merchants",
            null,
            null,
            false,
            null,
            ApiConstants.HttpMethod.GET,
            queryString);
  }

  @Test
  public void testNonJsonError() throws Exception {
    Map<String, String> pathParams = Collections.singletonMap("companyId", "adyen");
    Map<String, String> queryString = Collections.singletonMap("pageSize", "10");
    Resource resource = new Resource(serviceMock, "/companies/{companyId}/merchants", null);

    HTTPClientException error =
        new HTTPClientException(500, "error", Collections.emptyMap(), "not JSON");
    when(clientInterfaceMock.request(any(), any(), any(), anyBoolean(), any(), any(), any()))
        .thenThrow(error);

    ApiException thrown =
        assertThrows(
            ApiException.class,
            () ->
                resource.request(null, null, ApiConstants.HttpMethod.GET, pathParams, queryString));
    assertEquals("not JSON", thrown.getResponseBody());
    assertNull(thrown.getError());
  }

  @Test
  public void testRequestExceptionEmpty() throws IOException, HTTPClientException {
    try {
      when(clientInterfaceMock.request(
              "", "request", null, false, null, ApiConstants.HttpMethod.POST, null))
          .thenThrow(new HTTPClientException("message", 403, new HashMap<>(), null));

      Resource resource = new Resource(serviceMock, "", null);
      resource.request("request");

      fail("Expected exception");
    } catch (ApiException e) {
      assertEquals(403, e.getStatusCode());
      assertNull(e.getError());
    }
  }

  @Test
  public void testRequestException() throws IOException {
    Client client = createMockClientForErrors(403, "mocks/authorise-error-010.json");

    when(serviceMock.getClient()).thenReturn(client);
    try {
      Resource resource = new Resource(serviceMock, "", null);
      resource.request("request");

      fail("Expected exception");
    } catch (ApiException e) {
      assertEquals(403, e.getStatusCode());
      assertTrue(e.getResponseBody().contains("010"));
    }
  }

  @Test
  public void testValidationException() throws IOException {
    Client client = createMockClientForErrors(422, "mocks/response-validation-error.json");

    when(serviceMock.getClient()).thenReturn(client);
    try {
      Resource resource = new Resource(serviceMock, "", null);
      resource.request("request");

      fail("Expected exception");
    } catch (ApiException e) {
      assertEquals(422, e.getStatusCode());
      assertEquals("Required field 'reference' is not provided. ErrorCode: 130", e.getMessage());
      assertNotNull(e.getError());
      assertEquals("validation", e.getError().getErrorType());
      assertEquals("Required field 'reference' is not provided.", e.getError().getMessage());
    }
  }

  @Test
  public void testErrorRfc7807ValidationException() throws IOException {
    Client client = createMockClientForErrors(422, "mocks/response-validation-error-rfc7807.json");

    when(serviceMock.getClient()).thenReturn(client);
    try {
      Resource resource = new Resource(serviceMock, "", null);
      resource.request("request");

      fail("Expected exception");
    } catch (ApiException e) {
      assertEquals(422, e.getStatusCode());
      assertEquals("Invalid legal entity information provided ErrorCode: 30_102", e.getMessage());
      assertNotNull(e.getError());
      assertEquals("https://docs.adyen.com/errors/validation", e.getError().getErrorType());
      assertEquals("Invalid legal entity information provided", e.getError().getMessage());
      assertEquals(1, e.getError().getInvalidFields().size());
    }
  }

  // test error parsing when the JSON response is invalid
  @Test
  public void testValidationExceptionWithInvalidJsonResponse() throws IOException {
    Client client =
        createMockClientForErrors(422, "mocks/response-validation-error-invalid-json.json");

    when(serviceMock.getClient()).thenReturn(client);
    try {
      Resource resource = new Resource(serviceMock, "", null);
      resource.request("request");

      fail("Expected exception");
    } catch (ApiException e) {
      assertEquals(422, e.getStatusCode());
      assertNull(e.getError());
    }
  }
}
