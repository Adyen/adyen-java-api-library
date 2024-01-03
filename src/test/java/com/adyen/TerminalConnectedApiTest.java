package com.adyen;

import com.adyen.service.TerminalConnectedApi;
import com.adyen.service.exception.ApiException;
import com.adyen.terminal.ConnectedTerminalsRequest;
import com.adyen.terminal.ConnectedTerminalsResponse;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class TerminalConnectedApiTest extends BaseTest {

    @Test
    public void testConnectedTerminalsSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/pos/connectedTerminals-success.json");
        TerminalConnectedApi terminalConnectedApi = new TerminalConnectedApi(client);

        ConnectedTerminalsRequest request = new ConnectedTerminalsRequest();
        ConnectedTerminalsResponse result = terminalConnectedApi.connectedTerminals(request);

        assertEquals(2, result.getUniqueTerminalIds().size());
    }

    @Test
    public void testConnectedTerminalsErrorInvalidMerchant() throws Exception {
        Client client = createMockClientForErrors(403, "mocks/pos/connectedTerminals-error-403.json");
        TerminalConnectedApi terminalConnectedApi = new TerminalConnectedApi(client);

        ConnectedTerminalsRequest request = new ConnectedTerminalsRequest();

        try {
            terminalConnectedApi.connectedTerminals(request);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertTrue(e.getResponseBody().contains("901"));
            assertEquals(403, e.getStatusCode());
        }
    }

    @Test
    public void testConnectedTerminalsErrorMissingMerchant() throws Exception {
        Client client = createMockClientForErrors(500, "mocks/pos/connectedTerminals-error-500.json");
        TerminalConnectedApi terminalConnectedApi = new TerminalConnectedApi(client);

        ConnectedTerminalsRequest request = new ConnectedTerminalsRequest();

        try {
            terminalConnectedApi.connectedTerminals(request);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getResponseBody());
            assertTrue(e.getResponseBody().contains("702"));
            assertEquals(500, e.getStatusCode());
        }
    }
}
