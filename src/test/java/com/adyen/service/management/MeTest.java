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

package com.adyen.service.management;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.model.management.AllowedOrigin;
import com.adyen.model.management.AllowedOriginsResponse;
import com.adyen.model.management.ApiCredential;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class MeTest extends BaseTest {

    @Test
    public void testRetrieveMeSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/management/retrieve-me-success.json");
        Me me = new Me(client);

        ApiCredential apiCredential = me.retrieveMe();

        assertEquals(1, apiCredential.getRoles().size());
        assertEquals("ws@Company.JavaAPILibrary", apiCredential.getUsername());
        assertEquals("client_key", apiCredential.getClientKey());
        assertTrue(apiCredential.isActive());
        assertEquals("id", apiCredential.getId());
        assertEquals("https://management-test.adyen.com/v1/me", apiCredential.getLinks().getSelf().getHref());
        assertEquals("https://management-test.adyen.com/v1/me/allowedOrigins", apiCredential.getLinks().getAllowedOrigins().getHref());
    }

    @Test
    public void testRetrieveMeErrorNotAllowed() {
        Client client = createMockClientForErrors(403, "mocks/management/not-allowed-response.json");
        Me me = new Me(client);

        ApiException thrown = assertThrows(ApiException.class, me::retrieveMe);

        assertNotNull(thrown.getError());
        assertEquals("00_403", thrown.getError().getErrorCode());
        assertEquals(403, thrown.getError().getStatus());
        assertEquals("Not allowed", thrown.getError().getMessage());
    }

    @Test
    public void testRetrieveMeErrorUnauthorized() {
        Client client = createMockClientForErrors(401, "mocks/management/unauthorized-response.json");
        Me me = new Me(client);

        ApiException thrown = assertThrows(ApiException.class, me::retrieveMe);

        assertNotNull(thrown.getError());
        assertEquals("00_401", thrown.getError().getErrorCode());
        assertEquals(401, thrown.getError().getStatus());
    }

    @Test
    public void testListAllowedOriginsSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/management/list-allowed-origins-success.json");
        Me me = new Me(client);

        AllowedOriginsResponse allowedOriginsResponse = me.listAllowedOrigins();

        assertNotNull(allowedOriginsResponse.getData());
        assertEquals(1, allowedOriginsResponse.getData().size());
        assertAllowedOrigin(allowedOriginsResponse.getData().get(0));
    }

    @Test
    public void testRetrieveAllowedOriginSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/management/allowed-origin-response.json");
        Me me = new Me(client);

        AllowedOrigin allowedOrigin = me.retrieveAllowedOrigin("id");

        assertNotNull(allowedOrigin);
        assertAllowedOrigin(allowedOrigin);
    }

    @Test
    public void testRetrieveAllowedOriginErrorNotFound() {
        Client client = createMockClientForErrors(422, "mocks/management/allowed-origin-not-found.json");
        Me me = new Me(client);

        ApiException thrown = assertThrows(ApiException.class, () -> me.retrieveAllowedOrigin("id"));

        assertNotNull(thrown.getError());
        assertEquals("30_112", thrown.getError().getErrorCode());
        assertEquals(422, thrown.getError().getStatus());
        assertEquals("REQUEST_ID", thrown.getError().getPspReference());
        assertEquals("The origin id is invalid or does not exist.", thrown.getError().getMessage());
        assertEquals("https://docs.adyen.com/errors/general/not-found", thrown.getError().getErrorType());
    }

    @Test
    public void testCreateAllowedOriginSuccess() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/management/allowed-origin-response.json");
        Me me = new Me(client);

        AllowedOrigin allowedOrigin = me.createAllowedOrigin("https://www.adyen.com");

        assertNotNull(allowedOrigin);
        assertAllowedOrigin(allowedOrigin);
    }

    @Test
    public void testCreateAllowedOriginErrorAlreadyExists() {
        Client client = createMockClientForErrors(422, "mocks/management/allowed-origin-already-exists.json");
        Me me = new Me(client);

        ApiException thrown = assertThrows(ApiException.class, () -> me.createAllowedOrigin("https://www.adyen.com"));

        assertNotNull(thrown.getError());
        assertEquals("31_004", thrown.getError().getErrorCode());
        assertEquals(422, thrown.getError().getStatus());
        assertEquals("REQUEST_ID", thrown.getError().getPspReference());
    }

    @Test
    public void testCreateAllowedOriginErrorInvalidDomain() {
        Client client = createMockClientForErrors(422, "mocks/management/allowed-origin-invalid-domain.json");
        Me me = new Me(client);

        ApiException thrown = assertThrows(ApiException.class, () -> me.createAllowedOrigin("invalid"));

        assertNotNull(thrown.getError());
        assertEquals("31_004", thrown.getError().getErrorCode());
        assertEquals(422, thrown.getError().getStatus());
        assertEquals("REQUEST_ID", thrown.getError().getPspReference());
    }

    @Test
    public void testDeleteAllowedOriginSuccess() throws IOException, ApiException {
        Client client = createMockClientFromResponse(null);
        Me me = new Me(client);
        me.deleteAllowedOrigin("id");
    }

    private void assertAllowedOrigin(AllowedOrigin allowedOrigin) {
        assertEquals("https://www.adyen.com", allowedOrigin.getDomain());
        assertEquals("id", allowedOrigin.getId());
        assertEquals("https://management-test.adyen.com/v1/me/allowedOrigins/id", allowedOrigin.getLinks().getSelf().getHref());
    }
}
