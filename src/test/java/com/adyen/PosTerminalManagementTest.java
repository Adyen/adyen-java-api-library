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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen;

import com.adyen.model.posterminalmanagement.*;
import com.adyen.service.PosTerminalManagementApi;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PosTerminalManagementTest extends BaseTest {

    @Test
    public void testAssignTerminalsSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/posterminalmanagement/assign-terminals-success.json");
        PosTerminalManagementApi posTerminalManagement = new PosTerminalManagementApi(client);

        AssignTerminalsRequest request = new AssignTerminalsRequest();
        request.setCompanyAccount("companyAccount");
        List<String> terminalsList = new ArrayList<>();
        terminalsList.add("P400Plus-275479597");
        request.setTerminals(terminalsList);
        AssignTerminalsResponse result = posTerminalManagement.assignTerminals(request);
        assertEquals("RemoveConfigScheduled", result.getResults().get("P400Plus-275479597"));
    }

    @Test
    public void testFindTerminalSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/posterminalmanagement/find-terminal-success.json");
        PosTerminalManagementApi posTerminalManagement = new PosTerminalManagementApi(client);

        FindTerminalRequest request = new FindTerminalRequest();
        request.setTerminal("P400Plus-375039202");
        FindTerminalResponse result = posTerminalManagement.findTerminal(request);

        assertEquals("DemoCompany", result.getCompanyAccount());
        assertEquals("TestMerchant", result.getMerchantAccount());
        assertEquals("MyStore", result.getStore());
        assertEquals("P400Plus-375039202", result.getTerminal());
    }

    @Test
    public void testGetTerminalsUnderAccountSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/posterminalmanagement/get-terminals-under-account-success.json");
        PosTerminalManagementApi posTerminalManagement = new PosTerminalManagementApi(client);

        GetTerminalsUnderAccountRequest request = new GetTerminalsUnderAccountRequest();
        request.setCompanyAccount("DemoCompany");
        GetTerminalsUnderAccountResponse result = posTerminalManagement.getTerminalsUnderAccount(request);

        assertEquals("DemoCompany", result.getCompanyAccount());
        assertEquals("TestMerchant", result.getMerchantAccounts().get(0).getMerchantAccount());
        assertEquals("MyStore", result.getMerchantAccounts().get(0).getStores().get(0).getStore());
        assertEquals("P400Plus-375039202", result.getMerchantAccounts().get(0).getStores().get(0).getInStoreTerminals().get(0));
    }

    @Test
    public void testGetStoresUnderAccountSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/posterminalmanagement/get-stores-under-account-success.json");
        PosTerminalManagementApi posTerminalManagement = new PosTerminalManagementApi(client);

        GetStoresUnderAccountRequest request = new GetStoresUnderAccountRequest();
        request.setCompanyAccount("DemoCompany");
        GetStoresUnderAccountResponse result = posTerminalManagement.getStoresUnderAccount(request);
        Store store = result.getStores().get(0);
        assertEquals("DemoStore", store.getStore());
        assertEquals("TestMerchant", store.getMerchantAccountCode());
        assertEquals("DemoStore", store.getDescription());
        assertEquals("Active", store.getStatus());
        assertEquals("Amsterdam", store.getAddress().getCity());
        assertEquals("NL", store.getAddress().getCountryCode());
        assertEquals("1011", store.getAddress().getPostalCode());
        assertEquals("test street", store.getAddress().getStreetAddress());
    }

    @Test
    public void testGetTerminalDetailsSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/posterminalmanagement/get-terminal-details-success.json");
        PosTerminalManagementApi posTerminalManagement = new PosTerminalManagementApi(client);

        GetTerminalDetailsRequest request = new GetTerminalDetailsRequest();
        request.setTerminal("P400Plus-375039202");
        GetTerminalDetailsResponse result = posTerminalManagement.getTerminalDetails(request);
        assertEquals("DemoCompany", result.getCompanyAccount());
        assertEquals("NETHERLANDS", result.getCountry());
        assertEquals("P400Plus", result.getDeviceModel());
        assertEquals("61:c7:98:a6:55:7a", result.getEthernetMac());
        assertEquals("192.168.12.12", result.getWifiIp());
        assertEquals("MyStore", result.getStoreDetails().getStore());
    }
}
