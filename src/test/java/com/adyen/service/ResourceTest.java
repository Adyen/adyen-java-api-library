package com.adyen.service;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.Service;
import com.adyen.httpclient.ClientInterface;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.service.exception.ApiException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ResourceTest extends BaseTest {
    @Mock
    Service serviceMock;

    @Mock
    Client clientMock;

    @Mock
    ClientInterface clientInterfaceMock;

    @Before
    public void setUp() {
        when(clientMock.getHttpClient()).thenReturn(clientInterfaceMock);
        when(clientMock.getConfig()).thenReturn(null);
        when(serviceMock.getClient()).thenReturn(clientMock);
    }

    @Test
    public void testRequest() throws Exception {
        when(clientInterfaceMock.request("", "request", null)).thenReturn("response");

        Resource resource = new Resource(serviceMock, "", null);
        String response = resource.request("request");

        assertEquals("response", response);
    }

    @Test
    public void testRequestExceptionEmpty() throws IOException, HTTPClientException {
        try {
            when(clientInterfaceMock.request("", "request", null))
                    .thenThrow(new HTTPClientException("message", 403, new HashMap<String, List<String>>(), null));

            Resource resource = new Resource(serviceMock, "", null);
            String response = resource.request("request");

            assertTrue("Expected exception", false);
        } catch (ApiException e) {
            assertEquals(403, e.getStatusCode());
            assertNull(e.getError());
        }
    }

    @Test
    public void testRequestException() throws IOException, HTTPClientException {
        Client client = createMockClientForErrors(403, "mocks/authorise-error-010.json");

        when(serviceMock.getClient()).thenReturn(client);
        try {
            Resource resource = new Resource(serviceMock, "", null);
            String response = resource.request("request");

            assertTrue("Expected exception", false);
        } catch (ApiException e) {
            assertEquals(403, e.getStatusCode());
            assertEquals("010", e.getError().getErrorCode());
        }
    }
}
