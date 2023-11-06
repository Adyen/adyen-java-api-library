package com.adyen;

import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.disputes.*;
import com.adyen.service.DisputesApi;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class DisputesTest extends BaseTest{

    @Test
    public void acceptDispute() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/disputes/post-acceptDispute-accept-dispute-200.json");
        client.setEnvironment(Environment.TEST, null);
        DisputesApi disputesApiService = new DisputesApi(client);

        AcceptDisputeRequest request = new AcceptDisputeRequest();
        request.setDisputePspReference("DZ4DPSHB4WD2WN82");
        request.setMerchantAccountCode("YOUR_MERCHANT_ACCOUNT");
        AcceptDisputeResponse response = disputesApiService.acceptDispute(request);

        verify(client.getHttpClient()).request(
                "https://ca-test.adyen.com/ca/services/DisputeService/v" + DisputesApi.API_VERSION + "/acceptDispute",
                request.toJson(),
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
        assertNotNull(response.getDisputeServiceResult());
        assertTrue(response.getDisputeServiceResult().getSuccess());
    }

    @Test
    public void defendDispute() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/disputes/post-defendDispute-defend-dispute-200.json");
        client.setEnvironment(Environment.TEST, null);
        DisputesApi disputesApiService = new DisputesApi(client);

        DefendDisputeRequest request = new DefendDisputeRequest();
        request.setDefenseReasonCode("SupplyDefenseMaterial");
        request.setDisputePspReference("DZ4DPSHB4WD2WN82");
        request.setMerchantAccountCode("YOUR_MERCHANT_ACCOUNT");
        DefendDisputeResponse response = disputesApiService.defendDispute(request);

        verify(client.getHttpClient()).request(
                "https://ca-test.adyen.com/ca/services/DisputeService/v" + DisputesApi.API_VERSION + "/defendDispute",
                request.toJson(),
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
        assertNotNull(response.getDisputeServiceResult());
        assertTrue(response.getDisputeServiceResult().getSuccess());
    }

    @Test
    public void deleteDisputeDefenseDocument() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/disputes/post-deleteDisputeDefenseDocument-delete-dispute-defense-document-200.json");
        client.setEnvironment(Environment.TEST, null);
        DisputesApi disputesApiService = new DisputesApi(client);

        DeleteDefenseDocumentRequest request = new DeleteDefenseDocumentRequest();
        request.setDefenseDocumentType("DefenseMaterial");
        request.setDisputePspReference("DZ4DPSHB4WD2WN82");
        request.setMerchantAccountCode("YOUR_MERCHANT_ACCOUNT");
        DeleteDefenseDocumentResponse response = disputesApiService.deleteDisputeDefenseDocument(request);

        verify(client.getHttpClient()).request(
                "https://ca-test.adyen.com/ca/services/DisputeService/v" + DisputesApi.API_VERSION + "/deleteDisputeDefenseDocument",
                request.toJson(),
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
        assertNotNull(response.getDisputeServiceResult());
        assertTrue(response.getDisputeServiceResult().getSuccess());
    }

    @Test
    public void retrieveApplicableDefenseReasons() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/disputes/post-retrieveApplicableDefenseReasons-retrieve-defense-reasons-200.json");
        client.setEnvironment(Environment.TEST, null);
        DisputesApi disputesApiService = new DisputesApi(client);

        DefenseReasonsRequest request = new DefenseReasonsRequest();
        request.setDisputePspReference("DZ4DPSHB4WD2WN82");
        request.setMerchantAccountCode("YOUR_MERCHANT_ACCOUNT");
        DefenseReasonsResponse response = disputesApiService.retrieveApplicableDefenseReasons(request);

        verify(client.getHttpClient()).request(
                "https://ca-test.adyen.com/ca/services/DisputeService/v" + DisputesApi.API_VERSION + "/retrieveApplicableDefenseReasons",
                request.toJson(),
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
        assertNotNull(response.getDisputeServiceResult());
        assertTrue(response.getDisputeServiceResult().getSuccess());
        assertNotNull(response.getDefenseReasons());

        assertNotNull(response.getDefenseReasons().get(0));
        assertEquals("GoodsNotReturned", response.getDefenseReasons().get(0).getDefenseReasonCode());
        assertNotNull(response.getDefenseReasons().get(0).getDefenseDocumentTypes());
        assertFalse(response.getDefenseReasons().get(0).getDefenseDocumentTypes().get(0).getAvailable());
        assertEquals("TIDorInvoice", response.getDefenseReasons().get(0).getDefenseDocumentTypes().get(0).getDefenseDocumentTypeCode());
        assertEquals("Optional", response.getDefenseReasons().get(0).getDefenseDocumentTypes().get(0).getRequirementLevel());
        assertFalse(response.getDefenseReasons().get(0).getSatisfied());

        assertNotNull(response.getDefenseReasons().get(1));
        assertEquals("GoodsRepairedOrReplaced", response.getDefenseReasons().get(1).getDefenseReasonCode());
        assertNotNull(response.getDefenseReasons().get(1).getDefenseDocumentTypes());
        assertFalse(response.getDefenseReasons().get(1).getSatisfied());

        assertNotNull(response.getDefenseReasons().get(2));
        assertEquals("GoodsWereAsDescribed", response.getDefenseReasons().get(2).getDefenseReasonCode());
        assertNotNull(response.getDefenseReasons().get(2).getDefenseDocumentTypes());
        assertFalse(response.getDefenseReasons().get(2).getSatisfied());

        assertNotNull(response.getDefenseReasons().get(3));
        assertEquals("SupplyDefenseMaterial", response.getDefenseReasons().get(3).getDefenseReasonCode());
        assertNotNull(response.getDefenseReasons().get(3).getDefenseDocumentTypes());
        assertFalse(response.getDefenseReasons().get(3).getSatisfied());
    }

    @Test
    public void supplyDefenseDocument() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/disputes/post-supplyDefenseDocument-supply-defense-document-200.json");
        client.setEnvironment(Environment.TEST, null);
        DisputesApi disputesApiService = new DisputesApi(client);

        SupplyDefenseDocumentRequest request = new SupplyDefenseDocumentRequest();
        DefenseDocument defenseDocument = new DefenseDocument();
        defenseDocument.setContent("JVBERi0xLjQKJcOkw7zDtsOfCjIgMCBv+f/ub0j6JPRX+E3EmC==".getBytes());
        defenseDocument.setContentType("application/pdf");
        defenseDocument.setDefenseDocumentTypeCode("DefenseMaterial");
        request.setDefenseDocuments(Collections.singletonList(defenseDocument));
        request.setDisputePspReference("DZ4DPSHB4WD2WN82");
        request.setMerchantAccountCode("YOUR_MERCHANT_ACCOUNT");
        SupplyDefenseDocumentResponse response = disputesApiService.supplyDefenseDocument(request);

        verify(client.getHttpClient()).request(
                "https://ca-test.adyen.com/ca/services/DisputeService/v" + DisputesApi.API_VERSION + "/supplyDefenseDocument",
                request.toJson(),
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
        assertNotNull(response.getDisputeServiceResult());
        assertTrue(response.getDisputeServiceResult().getSuccess());
    }
}
