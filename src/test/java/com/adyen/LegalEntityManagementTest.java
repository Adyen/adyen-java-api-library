package com.adyen;

import com.adyen.model.legalentitymanagement.BusinessLine;
import com.adyen.model.legalentitymanagement.BusinessLineInfo;
import com.adyen.model.legalentitymanagement.BusinessLines;
import com.adyen.model.legalentitymanagement.Document;
import com.adyen.model.legalentitymanagement.LegalEntity;
import com.adyen.model.legalentitymanagement.LegalEntityInfo;
import com.adyen.model.legalentitymanagement.OnboardingLink;
import com.adyen.model.legalentitymanagement.OnboardingLinkInfo;
import com.adyen.model.legalentitymanagement.OnboardingTheme;
import com.adyen.model.legalentitymanagement.OnboardingThemes;
import com.adyen.model.legalentitymanagement.TransferInstrument;
import com.adyen.model.legalentitymanagement.TransferInstrumentInfo;
import com.adyen.service.LegalEntityManagementService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LegalEntityManagementTest extends BaseTest {

    @Test
    public void LegalEntitiesCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/LegalEntity.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
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
        LegalEntity response = service.legalEntities.create(request);
        assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
        assertEquals("LE322JV223222D5GG42KN6869", response.getId());
    }

    @Test
    public void LegalEntitiesRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/LegalEntity.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        LegalEntity response = service.legalEntities.retrieve("LE322JV223222D5GG42KN6869");
        assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
        assertEquals("LE322JV223222D5GG42KN6869", response.getId());
    }

    @Test
    public void LegalEntitiesUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/LegalEntity.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
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
        LegalEntity response = service.legalEntities.update("LE322JV223222D5GG42KN6869", request);
        assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
        assertEquals("LE322JV223222D5GG42KN6869", response.getId());
    }

    @Test
    public void LegalEntitiesListBusinessLinesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/BusinessLines.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        BusinessLines response = service.legalEntities.listBusinessLines("LE322JV223222D5GG42KN6869");
        assertEquals("LE322JV223222D5GG42KN6869", response.getBusinessLines().get(0).getId());
        assertEquals("LE664JV223222D5GG42KN6869", response.getBusinessLines().get(0).getLegalEntityId());
    }

    @Test
    public void TransferInstrumentsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/TransferInstrument.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        TransferInstrumentInfo request = TransferInstrumentInfo.fromJson("{\n" +
                "  \"legalEntityId\": \"LE322KH223222D5GG4C9J83RN\",\n" +
                "  \"type\": \"bankAccount\",\n" +
                "  \"bankAccount\": {\n" +
                "    \"countryCode\": \"NL\",\n" +
                "    \"currencyCode\": \"EUR\",\n" +
                "    \"iban\": \"NL62ABNA0000000123\"\n" +
                "  }\n" +
                "}");
        TransferInstrument response = service.transferInstruments.create(request);
        assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
        assertEquals("SE576BH223222F5GJVKHH6BDT", response.getId());
    }

    @Test
    public void TransferInstrumentsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/TransferInstrument.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        TransferInstrument response = service.transferInstruments.retrieve("SE576BH223222F5GJVKHH6BDT");
        assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
        assertEquals("SE576BH223222F5GJVKHH6BDT", response.getId());
    }

    @Test
    public void TransferInstrumentsUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/TransferInstrument.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        TransferInstrumentInfo request = TransferInstrumentInfo.fromJson("{\n" +
                "  \"legalEntityId\": \"LE322KH223222D5GG4C9J83RN\",\n" +
                "  \"type\": \"bankAccount\",\n" +
                "  \"bankAccount\": {\n" +
                "    \"countryCode\": \"NL\",\n" +
                "    \"currencyCode\": \"EUR\",\n" +
                "    \"iban\": \"NL62ABNA0000000123\"\n" +
                "  }\n" +
                "}");
        TransferInstrument response = service.transferInstruments.update("SE576BH223222F5GJVKHH6BDT", request);
        assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
        assertEquals("SE576BH223222F5GJVKHH6BDT", response.getId());
    }

    @Test
    public void TransferInstrumentsDeleteTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/TransferInstrument.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        service.transferInstruments.delete("SE576BH223222F5GJVKHH6BDT");
    }

    @Test
    public void BusinessLinesCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/BusinessLine.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        BusinessLineInfo request = BusinessLineInfo.fromJson("{\n" +
                "  \"capability\": \"issueBankAccount\",\n" +
                "  \"industryCode\": \"55\",\n" +
                "  \"webData\": [\n" +
                "    {\n" +
                "      \"webAddress\": \"https://www.adyen.com\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"legalEntityId\": \"LE322JV223222D5FZ9N74BSGM\",\n" +
                "  \"sourceOfFunds\": {\n" +
                "    \"type\": \"business\",\n" +
                "    \"adyenProcessedFunds\": \"false\",\n" +
                "    \"description\": \"Funds from my flower shop business\"\n" +
                "  }\n" +
                "}");
        BusinessLine response = service.businessLineService.create(request);
        assertEquals("LE322JV223222D5FZ9N74BSGM", response.getLegalEntityId());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void BusinessLinesRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/BusinessLine.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        BusinessLine response = service.businessLineService.retrieve("SE322KT223222D5FJ7TJN2986");
        assertEquals("LE322JV223222D5FZ9N74BSGM", response.getLegalEntityId());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void BusinessLinesUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/BusinessLine.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        BusinessLineInfo request = BusinessLineInfo.fromJson("{\n" +
                "  \"capability\": \"issueBankAccount\",\n" +
                "  \"industryCode\": \"55\",\n" +
                "  \"webData\": [\n" +
                "    {\n" +
                "      \"webAddress\": \"https://www.adyen.com\"\n" +
                "    }\n" +
                "  ],\n" +
                "  \"legalEntityId\": \"LE322JV223222D5FZ9N74BSGM\",\n" +
                "  \"sourceOfFunds\": {\n" +
                "    \"type\": \"business\",\n" +
                "    \"adyenProcessedFunds\": \"false\",\n" +
                "    \"description\": \"Funds from my flower shop business\"\n" +
                "  }\n" +
                "}");
        BusinessLine response = service.businessLineService.update("SE322KT223222D5FJ7TJN2986", request);
        assertEquals("LE322JV223222D5FZ9N74BSGM", response.getLegalEntityId());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void DocumentsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        Document request = Document.fromJson("{\n" +
                "    \"attachment\": {\n" +
                "        \"content\": \"string\",\n" +
                "        \"contentType\": \"string\",\n" +
                "        \"filename\": \"string\",\n" +
                "        \"pageName\": \"string\",\n" +
                "        \"pageType\": \"string\"\n" +
                "    },\n" +
                "    \"attachments\": [{\n" +
                "        \"content\": \"string\",\n" +
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
        Document response = service.documents.create(request);
        assertEquals(Document.TypeEnum.DRIVERSLICENSE, response.getType());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void DocumentsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        Document response = service.documents.retrieve("SE322KT223222D5FJ7TJN2986");
        assertEquals(Document.TypeEnum.DRIVERSLICENSE, response.getType());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void DocumentsUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        Document request = Document.fromJson("{\n" +
                "    \"attachment\": {\n" +
                "        \"content\": \"string\",\n" +
                "        \"contentType\": \"string\",\n" +
                "        \"filename\": \"string\",\n" +
                "        \"pageName\": \"string\",\n" +
                "        \"pageType\": \"string\"\n" +
                "    },\n" +
                "    \"attachments\": [{\n" +
                "        \"content\": \"string\",\n" +
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
        Document response = service.documents.update("SE322KT223222D5FJ7TJN2986", request);
        assertEquals(Document.TypeEnum.DRIVERSLICENSE, response.getType());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void DocumentsDeleteTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        service.documents.delete("SE322KT223222D5FJ7TJN2986");
    }

    @Test
    public void HostedOnboardingPageCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/OnboardingLink.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        OnboardingLinkInfo request = OnboardingLinkInfo.fromJson("{\n" +
                "    \"locale\": \"cs-CZ\",\n" +
                "    \"redirectUrl\": \"https://your.redirect-url.com\",\n" +
                "    \"themeId\": \"123456789\"\n" +
                "}");
        OnboardingLink response = service.hostedOnboarding.create("",request);
        assertEquals("https://your.redirect-url.com", response.getUrl());
    }

    @Test
    public void HostedOnboardingPageListThemesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/OnboardingThemes.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        OnboardingThemes response = service.hostedOnboarding.listThemes();
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getThemes().get(0).getId());
    }

    @Test
    public void HostedOnboardingPageRetrieveThemesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/OnboardingTheme.json");
        LegalEntityManagementService service = new LegalEntityManagementService(client);
        OnboardingTheme response = service.hostedOnboarding.retrieveTheme("SE322KT223222D5FJ7TJN2986");
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }
}
