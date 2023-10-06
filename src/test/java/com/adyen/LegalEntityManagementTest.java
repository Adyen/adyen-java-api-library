package com.adyen;

import com.adyen.constants.ApiConstants;
import com.adyen.model.legalentitymanagement.*;
import com.adyen.service.legalentitymanagement.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class LegalEntityManagementTest extends BaseTest {
    @Test
    public void LegalEntitiesCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/response/LegalEntity.json");
        LegalEntitiesApi service = new LegalEntitiesApi(client);
        LegalEntityInfoRequiredType request = LegalEntityInfoRequiredType.fromJson(getFileContents("mocks/legalentitymanagement/request/LegalEntityInfoRequiredType.json"));
        LegalEntity response = service.createLegalEntity(request);
        assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
        assertEquals("string", response.getId());
    }

    @Test
    public void LegalEntitiesRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/response/LegalEntity.json");
        LegalEntitiesApi service = new LegalEntitiesApi(client);
        LegalEntity response = service.getLegalEntity("LE322JV223222D5GG42KN6869");
        assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
        assertEquals("string", response.getId());
    }

    @Test
    public void LegalEntitiesUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/response/LegalEntity.json");
        LegalEntitiesApi service = new LegalEntitiesApi(client);
        LegalEntityInfo request = LegalEntityInfo.fromJson("{\n" +
                "    \"type\": \"individual\",\n" +
                "    \"individual\": {\n" +
                "        \"residentialAddress\": {\n" +
                "            \"city\": \"San Francisco\",\n" +
                "            \"country\": \"US\",\n" +
                "            \"postalCode\": \"94107\",\n" +
                "            \"street\": \"Brannan Street 274\",\n" +
                "            \"stateOrProvince\": \"CA\"\n" +
                "        },\n" +
                "        \"phone\": {\n" +
                "            \"number\": \"5551231234\",\n" +
                "            \"type\": \"mobile\"\n" +
                "        },\n" +
                "        \"name\": {\n" +
                "            \"firstName\": \"Simone\",\n" +
                "            \"lastName\": \"Hopper\"\n" +
                "        },\n" +
                "        \"birthData\": {\n" +
                "            \"dateOfBirth\": \"1981-12-01\"\n" +
                "        },\n" +
                "        \"email\": \"s.hopper@example.com\"\n" +
                "    }\n" +
                "}");
        LegalEntity response = service.updateLegalEntity("LE322JV223222D5GG42KN6869", request);
        assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
        assertEquals("string", response.getId());
    }

    @Test
    public void LegalEntitiesListBusinessLinesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/response/BusinessLines.json");
        LegalEntitiesApi service = new LegalEntitiesApi(client);
        BusinessLines response = service.getAllBusinessLinesUnderLegalEntity("LE322JV223222D5GG42KN6869");
        assertEquals("string", response.getBusinessLines().get(0).getId());
        assertEquals("string", response.getBusinessLines().get(0).getLegalEntityId());
    }

    @Test
    public void TransferInstrumentsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/response/TransferInstrument.json");
        TransferInstrumentsApi service = new TransferInstrumentsApi(client);
        TransferInstrumentInfo request = TransferInstrumentInfo.fromJson(getFileContents("mocks/legalentitymanagement/request/TransferInstrumentInfo.json"));
        TransferInstrument response = service.createTransferInstrument(request);
        assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
        assertEquals("string", response.getId());
    }

    @Test
    public void TransferInstrumentsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/response/TransferInstrument.json");
        TransferInstrumentsApi service = new TransferInstrumentsApi(client);
        TransferInstrument response = service.getTransferInstrument("SE576BH223222F5GJVKHH6BDT");
        assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
        assertEquals("string", response.getId());
    }

    @Test
    public void TransferInstrumentsUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/response/TransferInstrument.json");
        TransferInstrumentsApi service = new TransferInstrumentsApi(client);
        TransferInstrumentInfo request = TransferInstrumentInfo.fromJson(getFileContents("mocks/legalentitymanagement/request/TransferInstrumentInfo.json"));
        TransferInstrument response = service.updateTransferInstrument("SE576BH223222F5GJVKHH6BDT", request);
        assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
        assertEquals("string", response.getId());
    }

    @Test
    public void TransferInstrumentsDeleteTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/response/TransferInstrument.json");
        TransferInstrumentsApi service = new TransferInstrumentsApi(client);
        service.deleteTransferInstrument("SE576BH223222F5GJVKHH6BDT");
    }

    @Test
    public void BusinessLinesCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/response/BusinessLine.json");
        BusinessLinesApi service = new BusinessLinesApi(client);
        BusinessLineInfo request = BusinessLineInfo.fromJson(getFileContents("mocks/legalentitymanagement/request/BusinessLineInfo.json"));
        BusinessLine response = service.createBusinessLine(request);
        assertEquals("string", response.getLegalEntityId());
        assertEquals("string", response.getId());
    }

    @Test
    public void BusinessLinesRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/response/BusinessLine.json");
        BusinessLinesApi service = new BusinessLinesApi(client);
        BusinessLine response = service.getBusinessLine("SE322KT223222D5FJ7TJN2986");
        assertEquals("string", response.getLegalEntityId());
        assertEquals("string", response.getId());
    }

    @Test
    public void BusinessLinesUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/response/BusinessLine.json");
        BusinessLinesApi service = new BusinessLinesApi(client);
        BusinessLineInfoUpdate request = BusinessLineInfoUpdate.fromJson(getFileContents("mocks/legalentitymanagement/request/BusinessLineInfoUpdate.json"));
        BusinessLine response = service.updateBusinessLine("SE322KT223222D5FJ7TJN2986", request);
        assertEquals("string", response.getLegalEntityId());
        assertEquals("string", response.getId());
        verify(client.getHttpClient()).request(
                "https://kyc-test.adyen.com/lem/v3/businessLines/SE322KT223222D5FJ7TJN2986",
                request.toJson(),
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.PATCH,
                null
        );
    }

    @Test
    public void DocumentsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        DocumentsApi service = new DocumentsApi(client);
        Document request = Document.fromJson("{\n" +
                "    \"attachment\": {\n" +
                "        \"content\": \"VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n\",\n" +
                "        \"contentType\": \"string\",\n" +
                "        \"filename\": \"string\",\n" +
                "        \"pageName\": \"string\",\n" +
                "        \"pageType\": \"string\"\n" +
                "    },\n" +
                "    \"attachments\": [{\n" +
                "        \"content\": \"VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n\",\n" +
                "        \"contentType\": \"string\",\n" +
                "        \"filename\": \"string\",\n" +
                "        \"pageName\": \"string\",\n" +
                "        \"pageType\": \"string\"\n" +
                "    }],\n" +
                "    \"description\": \"string\",\n" +
                "    \"expiryDate\": \"string\",\n" +
                "    \"fileName\": \"string\",\n" +
                "    \"id\": \"SE322KT223222D5FJ7TJN2986\",\n" +
                "    \"issuerCountry\": \"string\",\n" +
                "    \"issuerState\": \"string\",\n" +
                "    \"number\": \"string\",\n" +
                "    \"owner\": {\n" +
                "        \"id\": \"string\",\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"type\": \"bankStatement\"\n" +
                "}");
        Document response = service.uploadDocumentForVerificationChecks(request);
        assertEquals(Document.TypeEnum.DRIVERSLICENSE, response.getType());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void DocumentsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        DocumentsApi service = new DocumentsApi(client);
        Document response = service.getDocument("SE322KT223222D5FJ7TJN2986");
        assertEquals(Document.TypeEnum.DRIVERSLICENSE, response.getType());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void DocumentsUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        DocumentsApi service = new DocumentsApi(client);
        Document request = Document.fromJson("{\n" +
                "    \"attachment\": {\n" +
                "        \"content\": \"VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n\",\n" +
                "        \"contentType\": \"string\",\n" +
                "        \"filename\": \"string\",\n" +
                "        \"pageName\": \"string\",\n" +
                "        \"pageType\": \"string\"\n" +
                "    },\n" +
                "    \"attachments\": [{\n" +
                "        \"content\": \"VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n\",\n" +
                "        \"contentType\": \"string\",\n" +
                "        \"filename\": \"string\",\n" +
                "        \"pageName\": \"string\",\n" +
                "        \"pageType\": \"string\"\n" +
                "    }],\n" +
                "    \"description\": \"string\",\n" +
                "    \"expiryDate\": \"string\",\n" +
                "    \"fileName\": \"string\",\n" +
                "    \"id\": \"SE322KT223222D5FJ7TJN2986\",\n" +
                "    \"issuerCountry\": \"string\",\n" +
                "    \"issuerState\": \"string\",\n" +
                "    \"number\": \"string\",\n" +
                "    \"owner\": {\n" +
                "        \"id\": \"string\",\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"type\": \"bankStatement\"\n" +
                "}");
        Document response = service.updateDocument("SE322KT223222D5FJ7TJN2986", request);
        assertEquals(Document.TypeEnum.DRIVERSLICENSE, response.getType());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void DocumentsDeleteTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        DocumentsApi service = new DocumentsApi(client);
        service.deleteDocument("SE322KT223222D5FJ7TJN2986");
        verify(client.getHttpClient()).request(
                "https://kyc-test.adyen.com/lem/v3/documents/SE322KT223222D5FJ7TJN2986",
                null,
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.DELETE,
                null
        );
    }

    @Test
    public void HostedOnboardingPageCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/OnboardingLink.json");
        HostedOnboardingApi service = new HostedOnboardingApi(client);
        OnboardingLinkInfo request = OnboardingLinkInfo.fromJson("{\n" +
                "    \"locale\": \"cs-CZ\",\n" +
                "    \"redirectUrl\": \"https://your.redirect-url.com\",\n" +
                "    \"themeId\": \"123456789\"\n" +
                "}");
        OnboardingLink response = service.getLinkToAdyenhostedOnboardingPage("",request);
        assertEquals("https://your.redirect-url.com", response.getUrl());
    }

    @Test
    public void HostedOnboardingPageListThemesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/OnboardingThemes.json");
        HostedOnboardingApi service = new HostedOnboardingApi(client);
        OnboardingThemes response = service.listHostedOnboardingPageThemes();
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getThemes().get(0).getId());
    }

    @Test
    public void HostedOnboardingPageRetrieveThemesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/OnboardingTheme.json");
        HostedOnboardingApi service = new HostedOnboardingApi(client);
        OnboardingTheme response = service.getOnboardingLinkTheme("SE322KT223222D5FJ7TJN2986");
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
        verify(client.getHttpClient()).request(
                "https://kyc-test.adyen.com/lem/v3/themes/SE322KT223222D5FJ7TJN2986",
                null,
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.GET,
                null
        );
    }

    @Test
    public void TestBase64EncodedResponseToByteArray() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        DocumentsApi service = new DocumentsApi(client);
        Document request = Document.fromJson("{\n" +
                "    \"attachment\": {\n" +
                "        \"content\": \"VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n\",\n" +
                "        \"contentType\": \"string\",\n" +
                "        \"filename\": \"string\",\n" +
                "        \"pageName\": \"string\",\n" +
                "        \"pageType\": \"string\"\n" +
                "    },\n" +
                "    \"attachments\": [{\n" +
                "        \"content\": \"VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n\",\n" +
                "        \"contentType\": \"string\",\n" +
                "        \"filename\": \"string\",\n" +
                "        \"pageName\": \"string\",\n" +
                "        \"pageType\": \"string\"\n" +
                "    }],\n" +
                "    \"description\": \"string\",\n" +
                "    \"expiryDate\": \"string\",\n" +
                "    \"fileName\": \"string\",\n" +
                "    \"id\": \"SE322KT223222D5FJ7TJN2986\",\n" +
                "    \"issuerCountry\": \"string\",\n" +
                "    \"issuerState\": \"string\",\n" +
                "    \"number\": \"string\",\n" +
                "    \"owner\": {\n" +
                "        \"id\": \"string\",\n" +
                "        \"type\": \"string\"\n" +
                "    },\n" +
                "    \"type\": \"bankStatement\"\n" +
                "}");
        Document response = service.updateDocument("SE322KT223222D5FJ7TJN2986", request);
        assertEquals("Thisisanbase64encodedstring", new String(Base64.getDecoder().decode(response.getAttachments().get(0).getContent())));
    }

    @Test
    public void TestNewFieldsInResponseDoesNotThrowError() throws IOException {
        try {
            // turn of logger so it doesn't clutter the UT
            Logger.getLogger(BankAccountInfo.class.getName()).setLevel(Level.OFF);
            BankAccountInfo bankAccountInfo = BankAccountInfo.fromJson("{\n" +
                    "  \"accountIdentification\":{\n" +
                    "    \"type\":\"usLocal\",\n" +
                    "    \"accountNumber\":\"1234567835\",\n" +
                    "    \"accountType\":\"checking\",\n" +
                    "    \"routingNumber\":\"121202211\"\n" +
                    "  },\n" +
                    "  \"countryCode\":\"US\",\n" +
                    "  \"trustedSource\":false,\n" +
                    "  \"paramNotInSpec\":false\n " +
                    "}");
        } catch (Exception ex){
            Assert.fail();
        }
    }
}
