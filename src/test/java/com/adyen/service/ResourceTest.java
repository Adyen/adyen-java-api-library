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

import static org.junit.jupiter.api.Assertions.*;
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
import java.net.URI;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class ResourceTest extends BaseTest {
  @Mock Service serviceMock;

  @Mock Client clientMock;

  @Mock ClientInterface clientInterfaceMock;

  @BeforeEach
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

  static Stream<Arguments> pathParameterValues() {
    return Stream.of(
        Arguments.of("user-123", "user-123"),
        Arguments.of("../apiCredentials/credential-2", "%2E%2E%2FapiCredentials%2Fcredential-2"),
        Arguments.of("/leading/slash", "%2Fleading%2Fslash"),
        Arguments.of("user?admin=true", "user%3Fadmin%3Dtrue"),
        Arguments.of("user#fragment", "user%23fragment"),
        Arguments.of("user%2Fname", "user%252Fname"),
        Arguments.of("user name", "user%20name"),
        Arguments.of("user+name", "user%2Bname"),
        Arguments.of("user@domain", "user%40domain"),
        Arguments.of("user:admin", "user%3Aadmin"),
        Arguments.of(".", "%2E"),
        Arguments.of("..", "%2E%2E"),
        Arguments.of("café", "caf%C3%A9"));
  }

  @ParameterizedTest
  @MethodSource("pathParameterValues")
  public void testRequestEncodesPathParameterAsSingleSegment(
      String userId, String expectedEncodedUserId) throws Exception {
    Map<String, String> pathParams = new HashMap<>();
    pathParams.put("companyId", "adyen");
    pathParams.put("userId", userId);
    Resource resource = new Resource(serviceMock, "/companies/{companyId}/users/{userId}", null);

    resource.request(null, null, ApiConstants.HttpMethod.GET, pathParams, null);

    verify(clientInterfaceMock)
        .request(
            "/companies/adyen/users/" + expectedEncodedUserId,
            null,
            null,
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  public void testEncodedSlashDoesNotChangeThePathRoute() {
    URI rawPath =
        URI.create("/companies/adyen/users/../apiCredentials/credential-2").normalize();
    URI encodedPath =
        URI.create("/companies/adyen/users/%2E%2E%2FapiCredentials%2Fcredential-2").normalize();

    assertEquals("/companies/adyen/apiCredentials/credential-2", rawPath.getRawPath());
    assertEquals(
        "/companies/adyen/users/%2E%2E%2FapiCredentials%2Fcredential-2",
        encodedPath.getRawPath());
  }

  @Test
  public void testMultipartRequest() throws Exception {
    Map<String, Object> formParams = new LinkedHashMap<>();
    formParams.put("file", "document");
    Resource resource = new Resource(serviceMock, "/documents/{documentId}", null);
    Map<String, String> pathParams = Collections.singletonMap("documentId", "123");

    when(clientInterfaceMock.requestMultipart(
            "/documents/123", formParams, null, false, null, ApiConstants.HttpMethod.POST, null))
        .thenReturn("response");

    assertEquals(
        "response",
        resource.requestMultipart(
            formParams, null, ApiConstants.HttpMethod.POST, pathParams, null));
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

  @Test
  public void testRequestException401WithWWWAuthenticateHeader()
      throws IOException, HTTPClientException {
    try {
      Map<String, List<String>> responseHeaders = new HashMap<>();
      responseHeaders.put("WWW-Authenticate", Collections.singletonList("abcd-1234-xywx-5678"));

      when(clientInterfaceMock.request(
              "", "request", null, false, null, ApiConstants.HttpMethod.POST, null))
          .thenThrow(new HTTPClientException("Unauthorized", 401, responseHeaders, null));

      Resource resource = new Resource(serviceMock, "", null);
      resource.request("request");

      fail("Expected exception");
    } catch (ApiException e) {
      assertEquals(401, e.getStatusCode());
      assertNotNull(e.getResponseHeaders());
      assertTrue(e.getResponseHeaders().containsKey("WWW-Authenticate"));
      assertEquals(
          Collections.singletonList("abcd-1234-xywx-5678"),
          e.getResponseHeaders().get("WWW-Authenticate"));
      assertNull(e.getError());
    }
  }
}
