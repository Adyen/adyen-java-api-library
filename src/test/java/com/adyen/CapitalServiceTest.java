package com.adyen;

import com.adyen.model.capital.*;import com.adyen.service.BinLookupApi;
import com.adyen.service.capital.GrantsApi;
import org.junit.Test;

import static org.junit.Assert.*;

public class CapitalServiceTest extends BaseTest {

    @Test
    public void testGetAllGrants() throws Exception {

        Client client = createMockClientFromFile("mocks/capital/get-grants-200.json");
        GrantsApi grantsApi = new GrantsApi(client);

        Grants grants = grantsApi.getAllGrants("AH000000001");
        assertNotNull(grants);
        assertEquals(1, grants.getGrants().size());

    }

    @Test
    public void getGetGrant() throws Exception {

        Client client = createMockClientFromFile("mocks/capital/get-grant-200.json");
        GrantsApi grantsApi = new GrantsApi(client);

        Grant grant = grantsApi.getGrant("AH000000001");
        assertNotNull(grant);
        assertEquals("EUR",grant.getAmount().getCurrency());

    }

    @Test
    public void testGetGrantDisbursement() throws Exception {

        Client client = createMockClientFromFile("mocks/capital/get-grants-disbursement-200.json");
        GrantsApi grantsApi = new GrantsApi(client);

        PatchableDisbursement patchableDisbursement = new PatchableDisbursement()
                .repayment(new PatchableDisbursementRepayment()
                        .basisPoints(100));

        Disbursement disbursement = grantsApi.updateGrantDisbursement("0000001", "0000002", patchableDisbursement);
        assertNotNull(disbursement);
        assertEquals(1, disbursement.getFundsCollections().size());
    }

    @Test
    public void testRequestGrant() throws Exception {

        Client client = createMockClientFromFile("mocks/capital/request-grant-200.json");
        GrantsApi grantsApi = new GrantsApi(client);

        GrantInfo grantInfo = new GrantInfo()
                .grantAccountId("AH000000001")
                .grantOfferId("AH000000001")
                .amount(new Amount()
                        .currency("EUR")
                        .value(1000L));

        Grant grant = grantsApi.requestGrant(grantInfo);
        assertNotNull(grant);
        assertEquals("GR00000000000000000000001", grant.getId());
    }

}
