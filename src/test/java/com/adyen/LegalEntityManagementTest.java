package com.adyen;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.model.legalentitymanagement.*;
import com.adyen.service.legalentitymanagement.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.codec.binary.Base64;
import org.junit.Assert;
import org.junit.Test;

public class LegalEntityManagementTest extends BaseTest {
  @Test
  public void LegalEntitiesCreateTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/legalentitymanagement/response/LegalEntity.json");
    LegalEntitiesApi service = new LegalEntitiesApi(client);

    LegalEntityInfoRequiredType request = new LegalEntityInfoRequiredType()
            .type(LegalEntityInfoRequiredType.TypeEnum.INDIVIDUAL) // Using the enum for type
            .reference("string")
            .individual(new Individual()
                    .birthData(new BirthData()
                            .dateOfBirth("string")) 
                    .email("string") 
                    .identificationData(new IdentificationData()
                            .cardNumber("string") 
                            .issuerState("string") 
                            .nationalIdExempt(true) 
                            .number("string") 
                            .type(IdentificationData.TypeEnum.NATIONALIDNUMBER))
                    .name(new Name()
                            .firstName("string") 
                            .infix("string") 
                            .lastName("string")) 
                    .nationality("string") 
                    .phone(new PhoneNumber()
                            .number("string") 
                            .type("string"))
                    .residentialAddress(new Address()
                            .city("string") 
                            .country("string") 
                            .postalCode("string") 
                            .stateOrProvince("string") 
                            .street("string") 
                            .street2("string")) 
                    .addTaxInformationItem(new TaxInformation()
                            .country("st") 
                            .number("string") 
                            .type("string"))
                    .webData(new WebData()
                            .webAddress("string"))) 
            .addEntityAssociationsItem(new LegalEntityAssociation()
                    .jobTitle("string") 
                    .legalEntityId("string") 
                    .type(LegalEntityAssociation.TypeEnum.PCISIGNATORY));

    // Note: The JSON also includes 'organization' and 'soleProprietorship' objects,
    // but since the top-level type is 'individual', only the 'individual' object
    // is typically populated for this specific request type.
    // The builder pattern naturally allows you to omit the others.

    LegalEntity response = service.createLegalEntity(request);
    assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
    assertEquals("string", response.getId());
  }

  @Test
  public void LegalEntitiesRetrieveTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/legalentitymanagement/response/LegalEntity.json");
    LegalEntitiesApi service = new LegalEntitiesApi(client);
    LegalEntity response = service.getLegalEntity("LE322JV223222D5GG42KN6869");
    assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
    assertEquals("string", response.getId());
  }

  @Test
  public void LegalEntitieInvalidEnumTest() throws Exception {
    Client client =
            createMockClientFromFile("mocks/legalentitymanagement/response/LegalEntityInvalidEnum.json");
    LegalEntitiesApi service = new LegalEntitiesApi(client);
    LegalEntity response = service.getLegalEntity("LE322JV223222D5GG42KN6869");
    assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
    assertEquals("string", response.getId());
  }

  @Test
  public void LegalEntitiesUpdateTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/legalentitymanagement/response/LegalEntity.json");
    LegalEntitiesApi service = new LegalEntitiesApi(client);

    LegalEntityInfo request = new LegalEntityInfo()
            .type(LegalEntityInfo.TypeEnum.INDIVIDUAL)
            .individual(new Individual()
                    .residentialAddress(new Address()
                            .city("San Francisco")
                            .country("US")
                            .postalCode("94107")
                            .street("Brannan Street 274")
                            .stateOrProvince("CA"))
                    .phone(new PhoneNumber()
                            .number("5551231234")
                            .type("mobile"))
                    .name(new Name()
                            .firstName("Simone")
                            .lastName("Hopper"))
                    .birthData(new BirthData()
                            .dateOfBirth("1981-12-01"))
                    .email("s.hopper@example.com"));    LegalEntity response = service.updateLegalEntity("LE322JV223222D5GG42KN6869", request);
    assertEquals(LegalEntity.TypeEnum.INDIVIDUAL, response.getType());
    assertEquals("string", response.getId());
  }

  @Test
  public void LegalEntitiesListBusinessLinesTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/legalentitymanagement/response/BusinessLines.json");
    LegalEntitiesApi service = new LegalEntitiesApi(client);
    BusinessLines response =
        service.getAllBusinessLinesUnderLegalEntity("LE322JV223222D5GG42KN6869");
    assertEquals("string", response.getBusinessLines().get(0).getId());
    assertEquals("string", response.getBusinessLines().get(0).getLegalEntityId());
  }

  @Test
  public void TransferInstrumentsCreateTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/legalentitymanagement/response/TransferInstrument.json");
    TransferInstrumentsApi service = new TransferInstrumentsApi(client);

    TransferInstrumentInfo request = new TransferInstrumentInfo()
            .type(TransferInstrumentInfo.TypeEnum.BANKACCOUNT)
            .legalEntityId("string")
            .bankAccount(new BankAccountInfo()
                    .accountIdentification(new BankAccountInfoAccountIdentification(
                            new AULocalAccountIdentification()
                                    .accountNumber("string")
                                    .bsbCode("string")
                    ))
            );

    TransferInstrument response = service.createTransferInstrument(request);
    assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
    assertEquals("string", response.getId());
  }

  @Test
  public void TransferInstrumentsRetrieveTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/legalentitymanagement/response/TransferInstrument.json");
    TransferInstrumentsApi service = new TransferInstrumentsApi(client);
    TransferInstrument response = service.getTransferInstrument("SE576BH223222F5GJVKHH6BDT");
    assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
    assertEquals("string", response.getId());
  }

  @Test
  public void TransferInstrumentsUpdateTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/legalentitymanagement/response/TransferInstrument.json");
    TransferInstrumentsApi service = new TransferInstrumentsApi(client);

    TransferInstrumentInfo request = new TransferInstrumentInfo()
            .type(TransferInstrumentInfo.TypeEnum.BANKACCOUNT)
            .legalEntityId("string")
            .bankAccount(new BankAccountInfo()
                    .accountIdentification(new BankAccountInfoAccountIdentification(
                            new AULocalAccountIdentification()
                                    .accountNumber("string")
                                    .bsbCode("string")
                    ))
            );

    TransferInstrument response =
        service.updateTransferInstrument("SE576BH223222F5GJVKHH6BDT", request);
    assertEquals(TransferInstrument.TypeEnum.BANKACCOUNT, response.getType());
    assertEquals("string", response.getId());
  }

  @Test
  public void TransferInstrumentsDeleteTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/legalentitymanagement/response/TransferInstrument.json");
    TransferInstrumentsApi service = new TransferInstrumentsApi(client);
    service.deleteTransferInstrument("SE576BH223222F5GJVKHH6BDT");
  }

  @Test
  public void BusinessLinesCreateTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/legalentitymanagement/response/BusinessLine.json");
    BusinessLinesApi service = new BusinessLinesApi(client);

    BusinessLineInfo request = new BusinessLineInfo()
            .industryCode("string")
            .service(BusinessLineInfo.ServiceEnum.PAYMENTPROCESSING)
            .addSalesChannelsItem("string")
            .sourceOfFunds(new SourceOfFunds()
                    .adyenProcessedFunds(true))
            .legalEntityId("LE0000001")
            .addWebDataItem(new WebData()
                    .webAddress("string"))
            .webDataExemption(new WebDataExemption()
                    .reason(WebDataExemption.ReasonEnum.NOONLINEPRESENCE));

    BusinessLine response = service.createBusinessLine(request);
    assertEquals("string", response.getLegalEntityId());
    assertEquals("string", response.getId());
  }

  @Test
  public void BusinessLinesRetrieveTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/legalentitymanagement/response/BusinessLine.json");
    BusinessLinesApi service = new BusinessLinesApi(client);
    BusinessLine response = service.getBusinessLine("SE322KT223222D5FJ7TJN2986");
    assertEquals("string", response.getLegalEntityId());
    assertEquals("string", response.getId());
  }

  @Test
  public void BusinessLinesUpdateTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/legalentitymanagement/response/BusinessLine.json");
    BusinessLinesApi service = new BusinessLinesApi(client);

    BusinessLineInfoUpdate request = new BusinessLineInfoUpdate()
            .industryCode("string")
            .addSalesChannelsItem("string")
            .sourceOfFunds(new SourceOfFunds()
                    .adyenProcessedFunds(true)
                    .description("string")
                    .type(SourceOfFunds.TypeEnum.BUSINESS))
            .addWebDataItem(new WebData()
                    .webAddress("string"))
            .webDataExemption(new WebDataExemption()
                    .reason(WebDataExemption.ReasonEnum.NOONLINEPRESENCE));

    BusinessLine response = service.updateBusinessLine("SE322KT223222D5FJ7TJN2986", request);
    assertEquals("string", response.getLegalEntityId());
    assertEquals("string", response.getId());
    verify(client.getHttpClient())
        .request(
            "https://kyc-test.adyen.com/lem/v3/businessLines/SE322KT223222D5FJ7TJN2986",
            request.toJson(),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.PATCH,
            null);
  }

  @Test
  public void DocumentsCreateTest() throws Exception {
    Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
    DocumentsApi service = new DocumentsApi(client);

    Document request = new Document()
            .attachment(new Attachment()
                    .content("VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n".getBytes(StandardCharsets.UTF_8)) // "64 encoded string"
                    .contentType("string")
                    .filename("string")
                    .pageName("string")
                    .pageType("string"))
            .addAttachmentsItem(new Attachment() // Assuming 'addAttachmentsItem' or similar for list
                    .content("VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n".getBytes(StandardCharsets.UTF_8)) // "64 encoded string"
                    .contentType("string")
                    .filename("string")
                    .pageName("string")
                    .pageType("string"))
            .description("string")
            .expiryDate("string")
            .fileName("string")
            .issuerCountry("string")
            .issuerState("string")
            .number("string")
            .owner(new OwnerEntity()
                    .id("string")
                    .type("string")) // If Owner has an enum for type, use that e.g., .type(Owner.TypeEnum.YOUR_TYPE)
            .type(Document.TypeEnum.BANKSTATEMENT); // Using the enum for type

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

    Document request = new Document()
            .attachment(new Attachment()
                    .content("VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n".getBytes(StandardCharsets.UTF_8)) // "64 encoded string"
                    .contentType("string")
                    .filename("string")
                    .pageName("string")
                    .pageType("string"))
            .addAttachmentsItem(new Attachment() // Assuming 'addAttachmentsItem' or similar for list
                    .content("VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n".getBytes(StandardCharsets.UTF_8)) // "64 encoded string"
                    .contentType("string")
                    .filename("string")
                    .pageName("string")
                    .pageType("string"))
            .description("string")
            .expiryDate("string")
            .fileName("string")
            .issuerCountry("string")
            .issuerState("string")
            .number("string")
            .owner(new OwnerEntity()
                    .id("string")
                    .type("string")) // If Owner has an enum for type, use that e.g., .type(Owner.TypeEnum.YOUR_TYPE)
            .type(Document.TypeEnum.BANKSTATEMENT); // Using the enum for type

    Document response = service.updateDocument("SE322KT223222D5FJ7TJN2986", request);
    assertEquals(Document.TypeEnum.DRIVERSLICENSE, response.getType());
    assertEquals("SE322KT223222D5FJ7TJN2986", response.getId());
  }

  @Test
  public void DocumentsDeleteTest() throws Exception {
    Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
    DocumentsApi service = new DocumentsApi(client);
    service.deleteDocument("SE322KT223222D5FJ7TJN2986");
    verify(client.getHttpClient())
        .request(
            "https://kyc-test.adyen.com/lem/v3/documents/SE322KT223222D5FJ7TJN2986",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.DELETE,
            null);
  }

  @Test
  public void HostedOnboardingPageCreateTest() throws Exception {
    Client client = createMockClientFromFile("mocks/legalentitymanagement/OnboardingLink.json");
    HostedOnboardingApi service = new HostedOnboardingApi(client);

    OnboardingLinkInfo request = new OnboardingLinkInfo()
            .locale("cs-CZ")
            .redirectUrl("https://example.com")
            .themeId("123456789");

    OnboardingLink response = service.getLinkToAdyenhostedOnboardingPage("", request);
    assertEquals("https://example.com", response.getUrl());
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
    verify(client.getHttpClient())
        .request(
            "https://kyc-test.adyen.com/lem/v3/themes/SE322KT223222D5FJ7TJN2986",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  public void TestBase64EncodedResponseToByteArray() throws Exception {
    Client client = createMockClientFromFile("mocks/legalentitymanagement/Document.json");
    DocumentsApi service = new DocumentsApi(client);

    Document request = new Document()
            .attachment(new Attachment()
                    .content("VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n".getBytes(StandardCharsets.UTF_8)) // "64 encoded string"
                    .contentType("string")
                    .filename("string")
                    .pageName("string")
                    .pageType("string"))
            .addAttachmentsItem(new Attachment() // Assuming 'addAttachmentsItem' or similar for list
                    .content("VGhpc2lzYW5iYXNlNjRlbmNvZGVkc3RyaW5n".getBytes(StandardCharsets.UTF_8)) // "64 encoded string"
                    .contentType("string")
                    .filename("string")
                    .pageName("string")
                    .pageType("string"))
            .description("string")
            .expiryDate("string")
            .fileName("string")
            .issuerCountry("string")
            .issuerState("string")
            .number("string")
            .owner(new OwnerEntity()
                    .id("string")
                    .type("string")) // If Owner has an enum for type, use that e.g., .type(Owner.TypeEnum.YOUR_TYPE)
            .type(Document.TypeEnum.BANKSTATEMENT); // Using the enum for type

    Document response = service.updateDocument("SE322KT223222D5FJ7TJN2986", request);
    assertEquals(
        "Thisisanbase64encodedstring",
        new String(Base64.decodeBase64(response.getAttachments().get(0).getContent())));
  }

  @Test
  public void TestNewFieldsInResponseDoesNotThrowError() throws IOException {
    try {
      // turn of logger so it doesn't clutter the UT
      Logger.getLogger(BankAccountInfo.class.getName()).setLevel(Level.OFF);

      // The field "paramNotInSpec":false from the JSON will be ignored
      // as there's no corresponding builder method for it, which is expected.
      BankAccountInfo bankAccountInfo =
          BankAccountInfo.fromJson(
              "{\n"
                  + "  \"accountIdentification\":{\n"
                  + "    \"type\":\"usLocal\",\n"
                  + "    \"accountNumber\":\"1234567835\",\n"
                  + "    \"accountType\":\"checking\",\n"
                  + "    \"routingNumber\":\"121202211\"\n"
                  + "  },\n"
                  + "  \"countryCode\":\"US\",\n"
                  + "  \"trustedSource\":false,\n"
                  + "  \"paramNotInSpec\":false\n "
                  + "}");
    } catch (Exception ex) {
      Assert.fail();
    }
  }
}
