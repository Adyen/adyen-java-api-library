package com.adyen;

import com.adyen.model.legalEntityManagement.BusinessLine;
import com.adyen.model.legalEntityManagement.BusinessLineInfo;
import com.adyen.model.legalEntityManagement.BusinessLines;
import com.adyen.model.legalEntityManagement.Document;
import com.adyen.model.legalEntityManagement.LegalEntity;
import com.adyen.model.legalEntityManagement.LegalEntityInfo;
import com.adyen.model.legalEntityManagement.OnboardingLink;
import com.adyen.model.legalEntityManagement.OnboardingLinkInfo;
import com.adyen.model.legalEntityManagement.OnboardingTheme;
import com.adyen.model.legalEntityManagement.OnboardingThemes;
import com.adyen.model.legalEntityManagement.TransferInstrument;
import com.adyen.model.legalEntityManagement.TransferInstrumentInfo;
import com.adyen.service.LegalEntityManagement.BusinessLineService;
import com.adyen.service.LegalEntityManagement.Documents;
import com.adyen.service.LegalEntityManagement.HostedOnboarding;
import com.adyen.service.LegalEntityManagement.LegalEntities;
import com.adyen.service.LegalEntityManagement.TransferInstruments;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class LegalEntityManagementTest extends BaseTest {

    @Test
    public void LegalEntitiesCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/LegalEntity.json");
        LegalEntities service = new LegalEntities(client);
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
        LegalEntity response = service.create(request);
        assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
        assertEquals("LE322JV223222D5GG42KN6869", response.getId());
    }

    @Test
    public void LegalEntitiesRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/LegalEntity.json");
        LegalEntities service = new LegalEntities(client);
        LegalEntity response = service.retrieve("LE322JV223222D5GG42KN6869");
        assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
        assertEquals("LE322JV223222D5GG42KN6869", response.getId());
    }

    @Test
    public void LegalEntitiesUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/LegalEntity.json");
        LegalEntities service = new LegalEntities(client);
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
        LegalEntity response = service.update("LE322JV223222D5GG42KN6869", request);
        assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
        assertEquals("LE322JV223222D5GG42KN6869", response.getId());
    }

    @Test
    public void LegalEntitiesListBusinessLinesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/BusinessLines.json");
        LegalEntities service = new LegalEntities(client);
        BusinessLines response = service.listBusinessLines("LE322JV223222D5GG42KN6869");
        assertEquals("LE322JV223222D5GG42KN6869", response.getBusinessLines().get(0).getId());
        assertEquals("LE664JV223222D5GG42KN6869", response.getBusinessLines().get(0).getLegalEntityId());
    }

    @Test
    public void TransferInstrumentsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/TransferInstrument.json");
        TransferInstruments service = new TransferInstruments(client);
        TransferInstrumentInfo request = TransferInstrumentInfo.fromJson("{\n" +
                "  \"legalEntityId\": \"LE322KH223222D5GG4C9J83RN\",\n" +
                "  \"type\": \"bankAccount\",\n" +
                "  \"bankAccount\": {\n" +
                "    \"countryCode\": \"NL\",\n" +
                "    \"currencyCode\": \"EUR\",\n" +
                "    \"iban\": \"NL62ABNA0000000123\"\n" +
                "  }\n" +
                "}");
        TransferInstrument response = service.create(request);
        assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
        assertEquals("SE576BH223222F5GJVKHH6BDT", response.getId());
    }

    @Test
    public void TransferInstrumentsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/TransferInstrument.json");
        TransferInstruments service = new TransferInstruments(client);
        TransferInstrument response = service.retrieve("SE576BH223222F5GJVKHH6BDT");
        assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
        assertEquals("SE576BH223222F5GJVKHH6BDT", response.getId());
    }

    @Test
    public void TransferInstrumentsUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/TransferInstrument.json");
        TransferInstruments service = new TransferInstruments(client);
        TransferInstrumentInfo request = TransferInstrumentInfo.fromJson("{\n" +
                "  \"legalEntityId\": \"LE322KH223222D5GG4C9J83RN\",\n" +
                "  \"type\": \"bankAccount\",\n" +
                "  \"bankAccount\": {\n" +
                "    \"countryCode\": \"NL\",\n" +
                "    \"currencyCode\": \"EUR\",\n" +
                "    \"iban\": \"NL62ABNA0000000123\"\n" +
                "  }\n" +
                "}");
        TransferInstrument response = service.update("SE576BH223222F5GJVKHH6BDT", request);
        assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
        assertEquals("SE576BH223222F5GJVKHH6BDT", response.getId());
    }

    @Test
    public void TransferInstrumentsDeleteTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/TransferInstrument.json");
        TransferInstruments service = new TransferInstruments(client);
        service.delete("SE576BH223222F5GJVKHH6BDT");
    }

    @Test
    public void BusinessLinesCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/BusinessLine.json");
        BusinessLineService service = new BusinessLineService(client);
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
        BusinessLine response = service.create(request);
        assertEquals("LE322JV223222D5FZ9N74BSGM", response.getLegalEntityId());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void BusinessLinesRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/BusinessLine.json");
        BusinessLineService service = new BusinessLineService(client);
        BusinessLine response = service.retrieve("SE322KT223222D5FJ7TJN2986");
        assertEquals("LE322JV223222D5FZ9N74BSGM", response.getLegalEntityId());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void BusinessLinesUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/BusinessLine.json");
        BusinessLineService service = new BusinessLineService(client);
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
        BusinessLine response = service.update("SE322KT223222D5FJ7TJN2986", request);
        assertEquals("LE322JV223222D5FZ9N74BSGM", response.getLegalEntityId());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void DocumentsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        Documents service = new Documents(client);
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
        Document response = service.create(request);
        assertEquals(Document.TypeEnum.DRIVERSLICENSE, response.getType());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void DocumentsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        Documents service = new Documents(client);
        Document response = service.retrieve("SE322KT223222D5FJ7TJN2986");
        assertEquals(Document.TypeEnum.DRIVERSLICENSE, response.getType());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void DocumentsUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        Documents service = new Documents(client);
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
        Document response = service.update("SE322KT223222D5FJ7TJN2986", request);
        assertEquals(Document.TypeEnum.DRIVERSLICENSE, response.getType());
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }

    @Test
    public void DocumentsDeleteTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
        Documents service = new Documents(client);
        service.delete("SE322KT223222D5FJ7TJN2986");
    }

    @Test
    public void HostedOnboardingPageCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/OnboardingLink.json");
        HostedOnboarding service = new HostedOnboarding(client);
        OnboardingLinkInfo request = OnboardingLinkInfo.fromJson("{\n" +
                "    \"locale\": \"cs-CZ\",\n" +
                "    \"redirectUrl\": \"https://your.redirect-url.com\",\n" +
                "    \"themeId\": \"123456789\"\n" +
                "}");
        OnboardingLink response = service.create("",request);
        assertEquals("https://your.redirect-url.com", response.getUrl());
    }

    @Test
    public void HostedOnboardingPageListThemesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/OnboardingThemes.json");
        HostedOnboarding service = new HostedOnboarding(client);
        OnboardingThemes response = service.listThemes();
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getThemes().get(0).getId());
    }

    @Test
    public void HostedOnboardingPageRetrieveThemesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/legalentitymanagement/OnboardingTheme.json");
        HostedOnboarding service = new HostedOnboarding(client);
        OnboardingTheme response = service.retrieveTheme("SE322KT223222D5FJ7TJN2986");
        assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
    }
}
