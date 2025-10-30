package com.adyen;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.model.RequestOptions;
import com.adyen.model.balanceplatform.*;
import com.adyen.service.balanceplatform.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class BalancePlatformTest extends BaseTest {
  @Test
  public void GeneralRetrieveTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/BalancePlatformResponse.json");
    PlatformApi service = new PlatformApi(client);
    BalancePlatform response = service.getBalancePlatform("123456789");
    assertEquals("123456789", response.getId());
    assertEquals("active", response.getStatus());
  }

  @Test
  public void GeneralListAccountHoldersTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/PaginatedAccountHoldersResponse.json");
    PlatformApi service = new PlatformApi(client);
    PaginatedAccountHoldersResponse response =
        service.getAllAccountHoldersUnderBalancePlatform("LE322KT223222D5FJ7THR293F", 10, 10, null);
    assertEquals("123456789", response.getAccountHolders().get(0).getId());
    assertEquals(
        "LE322KT223222D5FJ7THR293F", response.getAccountHolders().get(0).getLegalEntityId());
  }

  @Test
  public void GetAllTransactionRulesForBalancePlatformTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRulesResponse.json");
    PlatformApi service = new PlatformApi(client);
    TransactionRulesResponse response =
        service.getAllTransactionRulesForBalancePlatform("123456789");
    assertNotNull(response);
    assertEquals(1, response.getTransactionRules().size());
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/balancePlatforms/123456789/transactionRules",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  public void AccountHoldersCreateTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/AccountHolderCreatedResponse.json");
    AccountHoldersApi service = new AccountHoldersApi(client);
    AccountHolderInfo request =
        new AccountHolderInfo()
            .balancePlatform("YOUR_BALANCE_PLATFORM")
            .description("S.Hopper - Staff 123")
            .legalEntityId("LE322KT223222D5FJ7THR293F")
            .contactDetails(
                new ContactDetails()
                    .email("s.hopper@example.com")
                    .phone(new Phone().number("+315551231234").type(Phone.TypeEnum.MOBILE))
                    .address(
                        new Address()
                            .city("Amsterdam")
                            .country("NL")
                            .street("Brannan Street")
                            .houseNumberOrName("274")
                            .postalCode("1020CD")));
    AccountHolder response = service.createAccountHolder(request);
    assertEquals("AH3227C223222B5CMD2SXFKGT", response.getId());
    assertEquals("LE322KT223222D5FJ7THR293F", response.getLegalEntityId());
  }

  @Test
  public void AccountHoldersRetrieveTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/AccountHolder.json");
    AccountHoldersApi service = new AccountHoldersApi(client);
    AccountHolder response = service.getAccountHolder("LE322KT223222D5FJ7THR293F");
    assertEquals("AH3227C223222B5CMD2SXFKGT", response.getId());
    assertEquals("LE322KT223222D5FJ7THR293F", response.getLegalEntityId());
  }

  @Test
  public void AccountHoldersUpdateTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/AccountHolder.json");
    AccountHoldersApi service = new AccountHoldersApi(client);
    AccountHolderUpdateRequest request =
        new AccountHolderUpdateRequest()
            .balancePlatform("YOUR_BALANCE_PLATFORM")
            .contactDetails(
                new ContactDetails()
                    .email("s.hopper@example.com")
                    .phone(new Phone().number("+315551231234").type(Phone.TypeEnum.MOBILE))
                    .address(
                        new Address()
                            .city("Amsterdam")
                            .country("NL")
                            .street("Brannan Street")
                            .houseNumberOrName("274")
                            .postalCode("1020CD")))
            .description("S.Hopper - Staff 123")
            .status(AccountHolderUpdateRequest.StatusEnum.ACTIVE);
    AccountHolder response = service.updateAccountHolder("AH3227C223222B5CMD2SXFKGT", request);
    assertEquals("AH3227C223222B5CMD2SXFKGT", response.getId());
    assertEquals("LE322KT223222D5FJ7THR293F", response.getLegalEntityId());
  }

  @Test
  public void AccountHolderListTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/PaginatedBalanceAccountsResponse.json");
    AccountHoldersApi service = new AccountHoldersApi(client);
    PaginatedBalanceAccountsResponse response =
        service.getAllBalanceAccountsOfAccountHolder("AH3227C223222B5CMD2SXFKGT", 10, 10, null);
    assertEquals(
        "AH32272223222B59K6ZKBBFNQ", response.getBalanceAccounts().get(0).getAccountHolderId());
    assertEquals("BA32272223222B59K6ZXHBFN6", response.getBalanceAccounts().get(0).getId());
    Map<String, String> queryMap = new HashMap<>();
    queryMap.put("offset", "10");
    queryMap.put("limit", "10");
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/accountHolders/AH3227C223222B5CMD2SXFKGT/balanceAccounts",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            queryMap);
  }

  @Test
  public void GetAllTransactionRulesForAccountHolderTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRulesResponse.json");
    AccountHoldersApi service = new AccountHoldersApi(client);
    TransactionRulesResponse response =
        service.getAllTransactionRulesForAccountHolder("AH3227C223222B5CMD2SXFKGT");
    assertNotNull(response);
    assertEquals(1, response.getTransactionRules().size());
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/accountHolders/AH3227C223222B5CMD2SXFKGT/transactionRules",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  public void BalanceAccountsCreateTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/BalanceAccount.json");
    BalanceAccountsApi service = new BalanceAccountsApi(client);
    BalanceAccountInfo request =
        new BalanceAccountInfo()
            .accountHolderId("AH32272223222B59K6ZKBBFNQ")
            .description("S.Hopper - Main balance account");
    BalanceAccount response = service.createBalanceAccount(request);
    assertEquals("AH32272223222B59K6ZKBBFNQ", response.getAccountHolderId());
    assertEquals("BA32272223222B59CZ3T52DKZ", response.getId());
  }

  @Test
  public void BalanceAccountsRetrieveTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/BalanceAccount.json");
    BalanceAccountsApi service = new BalanceAccountsApi(client);
    BalanceAccount response = service.getBalanceAccount("AH32272223222B59K6ZKBBFNQ");
    assertEquals("AH32272223222B59K6ZKBBFNQ", response.getAccountHolderId());
    assertEquals("BA32272223222B59CZ3T52DKZ", response.getId());
  }

  @Test
  public void BalanceAccountsUpdateTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/BalanceAccount.json");
    BalanceAccountsApi service = new BalanceAccountsApi(client);
    BalanceAccountUpdateRequest request =
        new BalanceAccountUpdateRequest()
            .accountHolderId("AH32272223222B59K6ZKBBFNQ")
            .reference("S.Hopper - Main balance account")
            .status(BalanceAccountUpdateRequest.StatusEnum.ACTIVE);
    BalanceAccount response = service.updateBalanceAccount("AH32272223222B59K6ZKBBFNQ", request);
    assertEquals("AH32272223222B59K6ZKBBFNQ", response.getAccountHolderId());
    assertEquals("BA32272223222B59CZ3T52DKZ", response.getId());
  }

  @Test
  public void BalanceAccountsListSweepsTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/BalanceSweepConfigurationsResponse.json");
    BalanceAccountsApi service = new BalanceAccountsApi(client);
    BalanceSweepConfigurationsResponse response =
        service.getAllSweepsForBalanceAccount("AH32272223222B59K6ZKBBFNQ");
    assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getSweeps().get(0).getId());
    assertEquals(
        "BA32272223222B5FTD2KR6TJD",
        response.getSweeps().get(0).getCounterparty().getBalanceAccountId());
  }

  @Test
  public void GetAllTransactionRulesForBalanceAccountTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRulesResponse.json");
    BalanceAccountsApi service = new BalanceAccountsApi(client);
    TransactionRulesResponse response =
        service.getAllTransactionRulesForBalanceAccount("BA32272223222B59CZ3T52DKZ");
    assertNotNull(response);
    assertEquals(1, response.getTransactionRules().size());
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/balanceAccounts/BA32272223222B59CZ3T52DKZ/transactionRules",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  public void BalanceAccountsCreateSweepTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/SweepConfigurationV2.json");
    BalanceAccountsApi service = new BalanceAccountsApi(client);
    CreateSweepConfigurationV2 request =
        new CreateSweepConfigurationV2()
            .counterparty(new SweepCounterparty().merchantAccount("YOUR_MERCHANT_ACCOUNT"))
            .triggerAmount(new Amount().currency("EUR").value(50000L))
            .currency("EUR")
            .schedule(new SweepSchedule().type(SweepSchedule.TypeEnum.BALANCE))
            .type(CreateSweepConfigurationV2.TypeEnum.PULL)
            .status(CreateSweepConfigurationV2.StatusEnum.ACTIVE);
    SweepConfigurationV2 response = service.createSweep("AH32272223222B59K6ZKBBFNQ", request);
    assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getId());
    assertEquals(SweepConfigurationV2.StatusEnum.ACTIVE, response.getStatus());
  }

  @Test
  public void sweepScheduleTest() throws Exception {
    // response -> from json
    SweepConfigurationV2 request =
        new SweepConfigurationV2()
            .counterparty(new SweepCounterparty().merchantAccount("YOUR_MERCHANT_ACCOUNT"))
            .currency("EUR")
            // .ignoredField("I'm not part of the specs yet, and that's OK") // This field is
            // ignored when using the builder
            .schedule(new SweepSchedule().type(SweepSchedule.TypeEnum.BALANCE));
    assertThat(request.getSchedule(), instanceOf(SweepSchedule.class));
    assertEquals(SweepSchedule.TypeEnum.BALANCE, request.getSchedule().getType());
  }

  @Test
  public void cronSweepScheduleTest() throws Exception {
    // response -> from json
    SweepConfigurationV2 request =
        new SweepConfigurationV2()
            .counterparty(new SweepCounterparty().merchantAccount("YOUR_MERCHANT_ACCOUNT"))
            .currency("EUR")
            .schedule(
                new SweepSchedule()
                    .type(SweepSchedule.TypeEnum.CRON)
                    .cronExpression("*/5 * * * *"));
    assertThat(request.getSchedule(), instanceOf(SweepSchedule.class));
    assertEquals(SweepSchedule.TypeEnum.CRON, request.getSchedule().getType());
    assertEquals("*/5 * * * *", request.getSchedule().getCronExpression());
  }

  @Test
  public void cronSweepScheduleToJsonTest() throws JsonProcessingException {
    SweepConfigurationV2 request = new SweepConfigurationV2();
    request.setType(SweepConfigurationV2.TypeEnum.PULL);
    SweepSchedule cron = new SweepSchedule();
    cron.setType(SweepSchedule.TypeEnum.CRON);
    cron.setCronExpression("6 6 6");
    request.setSchedule(cron);

    // request to json
    String json = request.toJson();

    assertEquals(
        "{\"schedule\":{\"cronExpression\":\"6 6 6\",\"type\":\"cron\"},\"type\":\"pull\"}", json);
  }

  @Test
  public void sweepScheduleToJsonTest() throws JsonProcessingException {
    SweepConfigurationV2 request = new SweepConfigurationV2();
    request.setType(SweepConfigurationV2.TypeEnum.PUSH);
    SweepSchedule schedule = new SweepSchedule();
    schedule.setType(SweepSchedule.TypeEnum.DAILY);
    request.setSchedule(schedule);

    // request to json
    String json = request.toJson();

    assertEquals("{\"schedule\":{\"type\":\"daily\"},\"type\":\"push\"}", json);
  }

  @Test
  public void BalanceAccountsDeleteSweepTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/BalanceSweepConfigurationsResponse.json");
    BalanceAccountsApi service = new BalanceAccountsApi(client);
    service.deleteSweep("AH32272223222B59K6ZKBBFNQ", "SWPC4227C224555B5FTD2NT2JV4WN5");
  }

  @Test
  public void BalanceAccountsRetrieveSweepTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/SweepConfigurationV2.json");
    BalanceAccountsApi service = new BalanceAccountsApi(client);
    SweepConfigurationV2 response =
        service.getSweep("AH32272223222B59K6ZKBBFNQ", "SWPC4227C224555B5FTD2NT2JV4WN5");
    assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getId());
    assertEquals("BA32272223222B5FTD2KR6TJD", response.getCounterparty().getBalanceAccountId());
  }

  @Test
  public void BalanceAccountsUpdateSweepTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/SweepConfigurationV2.json");
    BalanceAccountsApi service = new BalanceAccountsApi(client);
    UpdateSweepConfigurationV2 request =
        new UpdateSweepConfigurationV2()
            .counterparty(new SweepCounterparty().merchantAccount("YOUR_MERCHANT_ACCOUNT"))
            .triggerAmount(new Amount().currency("EUR").value(50000L))
            .currency("EUR")
            .schedule(new SweepSchedule().type(SweepSchedule.TypeEnum.BALANCE))
            .type(UpdateSweepConfigurationV2.TypeEnum.PULL)
            .status(UpdateSweepConfigurationV2.StatusEnum.ACTIVE);
    SweepConfigurationV2 response =
        service.updateSweep("AH32272223222B59K6ZKBBFNQ", "SWPC4227C224555B5FTD2NT2JV4WN5", request);
    assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getId());
    assertEquals("BA32272223222B5FTD2KR6TJD", response.getCounterparty().getBalanceAccountId());
  }

  @Test
  public void BalanceAccountsListPaymentInstrumentsTest() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/PaginatedPaymentInstrumentsResponse.json");
    BalanceAccountsApi service = new BalanceAccountsApi(client);
    PaginatedPaymentInstrumentsResponse response =
        service.getPaymentInstrumentsLinkedToBalanceAccount("AH32272223222B59K6ZKBBFNQ");
    assertEquals("PI32272223222B59M5TM658DT", response.getPaymentInstruments().get(0).getId());
    assertEquals(
        "BA32272223222B59CZ3T52DKZ", response.getPaymentInstruments().get(0).getBalanceAccountId());
  }

  @Test
  public void PaymentInstrumentsCreateTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrument.json");
    PaymentInstrumentsApi service = new PaymentInstrumentsApi(client);
    PaymentInstrumentInfo request =
        new PaymentInstrumentInfo()
            .type(PaymentInstrumentInfo.TypeEnum.BANKACCOUNT)
            .description("YOUR_DESCRIPTION")
            .balanceAccountId("BA3227C223222B5CTBLR8BWJB")
            .issuingCountryCode("NL");
    PaymentInstrument response = service.createPaymentInstrument(request);
    assertEquals("PI32272223222C5GXTDWH3TTN", response.getId());
    assertEquals("BA3227C223222B5FG88S28BGN", response.getBalanceAccountId());
  }

  @Test
  public void PaymentInstrumentsRetrieveTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrument.json");
    PaymentInstrumentsApi service = new PaymentInstrumentsApi(client);
    PaymentInstrument response = service.getPaymentInstrument("PI322LJ223222B5DJS7CD9LWL");
    assertEquals("PI32272223222C5GXTDWH3TTN", response.getId());
    assertEquals("BA3227C223222B5FG88S28BGN", response.getBalanceAccountId());
  }

  @Test
  public void PaymentInstrumentsUpdateTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrument.json");
    PaymentInstrumentsApi service = new PaymentInstrumentsApi(client);

    PaymentInstrumentUpdateRequest request =
        new PaymentInstrumentUpdateRequest().balanceAccountId("BA32272223222B5CM82WL892M");

    UpdatePaymentInstrument response =
        service.updatePaymentInstrument("PI322LJ223222B5DJS7CD9LWL", request);
    assertEquals("PI32272223222C5GXTDWH3TTN", response.getId());
    assertEquals("BA3227C223222B5FG88S28BGN", response.getBalanceAccountId());
  }

  @Test
  public void PaymentInstrumentsListTransactionRulesTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRulesResponse.json");
    PaymentInstrumentsApi service = new PaymentInstrumentsApi(client);
    TransactionRulesResponse response =
        service.getAllTransactionRulesForPaymentInstrument("TR3227C223222B5FCB756DV9H");
    assertEquals("TR3227C223222B5FCB756DV9H", response.getTransactionRules().get(0).getId());
    assertEquals(
        "PI3227C223222B5BPCMFXD2XG",
        response.getTransactionRules().get(0).getEntityKey().getEntityReference());
  }

  @Test
  public void PaymentInstrumentGroupsCreateTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrumentGroup.json");
    PaymentInstrumentGroupsApi service = new PaymentInstrumentGroupsApi(client);
    PaymentInstrumentGroupInfo request =
        new PaymentInstrumentGroupInfo().balancePlatform("YOUR_BALANCE_PLATFORM").txVariant("mc");
    PaymentInstrumentGroup response = service.createPaymentInstrumentGroup(request);
    assertEquals("PG3227C223222B5CMD3FJFKGZ", response.getId());
  }

  @Test
  public void PaymentInstrumentGroupsRetrieveTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrumentGroup.json");
    PaymentInstrumentGroupsApi service = new PaymentInstrumentGroupsApi(client);
    PaymentInstrumentGroup response =
        service.getPaymentInstrumentGroup("PG3227C223222B5CMD3FJFKGZ");
    assertEquals("PG3227C223222B5CMD3FJFKGZ", response.getId());
  }

  @Test
  public void PaymentInstrumentGroupsListTransactionRulesTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRulesResponse.json");
    PaymentInstrumentGroupsApi service = new PaymentInstrumentGroupsApi(client);
    TransactionRulesResponse response =
        service.getAllTransactionRulesForPaymentInstrumentGroup("TR3227C223222B5FCB756DV9H");
    assertEquals("TR3227C223222B5FCB756DV9H", response.getTransactionRules().get(0).getId());
    assertEquals(
        "PI3227C223222B5BPCMFXD2XG",
        response.getTransactionRules().get(0).getEntityKey().getEntityReference());
  }

  @Test
  public void TransactionRulesCreateTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRule.json");
    TransactionRulesApi service = new TransactionRulesApi(client);

    TransactionRuleInfo request =
        new TransactionRuleInfo()
            .description("Allow only point-of-sale transactions")
            .reference("YOUR_REFERENCE_4F7346")
            .entityKey(
                new TransactionRuleEntityKey()
                    .entityType("paymentInstrument")
                    .entityReference("PI3227C223222B5BPCMFXD2XG"))
            .status(TransactionRuleInfo.StatusEnum.ACTIVE)
            .interval(
                new TransactionRuleInterval().type(TransactionRuleInterval.TypeEnum.PERTRANSACTION))
            .ruleRestrictions(
                new TransactionRuleRestrictions()
                    .processingTypes(
                        new ProcessingTypesRestriction()
                            .operation("noneMatch")
                            .addValueItem(ProcessingTypesRestriction.ValueEnum.POS)))
            .type(TransactionRuleInfo.TypeEnum.BLOCKLIST);

    TransactionRule response = service.createTransactionRule(request);
    assertEquals("TR3227C223222B5FCB756DV9H", response.getId());
    assertEquals("PI3227C223222B5BPCMFXD2XG", response.getEntityKey().getEntityReference());
  }

  @Test
  public void TransactionRulesRetrieveTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRuleResponse.json");
    TransactionRulesApi service = new TransactionRulesApi(client);
    TransactionRuleResponse response = service.getTransactionRule("TR32272223222B5CMD3V73HXG");
    assertEquals("TR3227C223222B5FCB756DV9H", response.getTransactionRule().getId());
  }

  @Test
  public void TransactionRulesUpdateTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRule.json");
    TransactionRulesApi service = new TransactionRulesApi(client);

    TransactionRuleInfo request =
        new TransactionRuleInfo()
            .description("Allow only point-of-sale transactions")
            .reference("YOUR_REFERENCE_4F7346")
            .entityKey(
                new TransactionRuleEntityKey()
                    .entityType("paymentInstrument")
                    .entityReference("PI3227C223222B5BPCMFXD2XG"))
            .status(TransactionRuleInfo.StatusEnum.ACTIVE)
            .interval(
                new TransactionRuleInterval().type(TransactionRuleInterval.TypeEnum.PERTRANSACTION))
            .ruleRestrictions(
                new TransactionRuleRestrictions()
                    .processingTypes(
                        new ProcessingTypesRestriction()
                            .operation("noneMatch")
                            .addValueItem(ProcessingTypesRestriction.ValueEnum.POS)))
            .type(TransactionRuleInfo.TypeEnum.BLOCKLIST);

    TransactionRule response = service.updateTransactionRule("TR3227C223222B5FCB756DV9H", request);
    assertEquals("TR3227C223222B5FCB756DV9H", response.getId());
    assertEquals("PI3227C223222B5BPCMFXD2XG", response.getEntityKey().getEntityReference());
  }

  @Test
  public void TransactionRulesDeleteTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRule.json");
    TransactionRulesApi service = new TransactionRulesApi(client);
    service.deleteTransactionRule("TR3227C223222B5FCB756DV9H");
  }

  @Test
  public void ValidateBankAccountIdentificationTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRule.json");
    BankAccountValidationApi service = new BankAccountValidationApi(client);
    service.validateBankAccountIdentification(new BankAccountIdentificationValidationRequest());
    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/validateBankAccountIdentification",
            "{}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void CalculateTransferRoutesTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransferRoutesResponse.json");
    TransferRoutesApi service = new TransferRoutesApi(client);
    // def TransferRouteRequest
    TransferRouteRequest transferRouteRequest =
        new TransferRouteRequest()
            .balancePlatform("123456789")
            .currency("USD")
            .category(TransferRouteRequest.CategoryEnum.BANK)
            .counterparty(
                new Counterparty()
                    .bankAccount(
                        new BankAccount()
                            .accountIdentification(
                                new BankAccountAccountIdentification(
                                    new IbanAccountIdentification()
                                        .type(IbanAccountIdentification.TypeEnum.IBAN)
                                        .iban("NL91ABNA0417164300")))));

    TransferRouteResponse response = service.calculateTransferRoutes(transferRouteRequest);

    assertNotNull(response);
    assertEquals(2, response.getTransferRoutes().size());
    verify(client.getHttpClient())
        .request(
            eq("https://balanceplatform-api-test.adyen.com/bcl/v2/transferRoutes/calculate"),
            anyString(),
            eq(client.getConfig()),
            eq(false),
            eq(null),
            eq(ApiConstants.HttpMethod.POST),
            eq(null));
  }

  @Test
  public void CalculateTransferRoutesIbanAccountIdentificationRequirementTest() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/TransferRoutesResponse.json");
    TransferRoutesApi service = new TransferRoutesApi(client);
    // def TransferRouteRequest
    TransferRouteRequest transferRouteRequest =
        new TransferRouteRequest()
            .balancePlatform("123456789")
            .currency("USD")
            .category(TransferRouteRequest.CategoryEnum.BANK)
            .counterparty(
                new Counterparty()
                    .bankAccount(
                        new BankAccount()
                            .accountIdentification(
                                new BankAccountAccountIdentification(
                                    new IbanAccountIdentification()
                                        .type(IbanAccountIdentification.TypeEnum.IBAN)
                                        .iban("NL91ABNA0417164300")))));

    TransferRouteResponse response = service.calculateTransferRoutes(transferRouteRequest);

    assertNotNull(response);
    assertEquals(2, response.getTransferRoutes().size());
    verify(client.getHttpClient())
        .request(
            eq("https://balanceplatform-api-test.adyen.com/bcl/v2/transferRoutes/calculate"),
            anyString(),
            eq(client.getConfig()),
            eq(false),
            eq(null),
            eq(ApiConstants.HttpMethod.POST),
            eq(null));
  }

  @Test
  public void getWebhookSettings() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/BalanceWebhookSettingsResponse.json");
    BalancesApi service = new BalancesApi(client);

    String balancePlatformId = "123456789";
    String webhookId = "WH00000001";

    WebhookSettings response = service.getAllWebhookSettings(balancePlatformId, webhookId);

    assertNotNull(response);
    assertNotNull(response.getWebhookSettings());
    assertEquals(2, response.getWebhookSettings().size());
  }

  @Test
  public void getWebhookSettingById() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/BalanceWebhookSettingResponse.json");
    BalancesApi service = new BalancesApi(client);

    String balancePlatformId = "123456789";
    String webhookId = "WH00000001";
    String settingId = "BWHS00000000000000000000000001";

    WebhookSetting response = service.getWebhookSetting(balancePlatformId, webhookId, settingId);

    assertNotNull(response);
    assertEquals("BWHS00000000000000000000000001", response.getId());
    assertEquals("USD", response.getCurrency());
  }

  @Test
  public void createWebhookSetting() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/BalanceWebhookSettingResponse.json");
    BalancesApi service = new BalancesApi(client);

    String balancePlatformId = "123456789";
    String webhookId = "WH00000001";

    WebhookSetting response =
        service.createWebhookSetting(
            balancePlatformId,
            webhookId,
            new BalanceWebhookSettingInfo()
                .type(BalanceWebhookSettingInfo.TypeEnum.BALANCE)
                .target(
                    new Target()
                        .type(Target.TypeEnum.BALANCEACCOUNT)
                        .id("BA00000000000000000LIABLE"))
                .currency("USD")
                .status(BalanceWebhookSettingInfo.StatusEnum.ACTIVE)
                .addConditionsItem(
                    new Condition()
                        .balanceType(Condition.BalanceTypeEnum.AVAILABLE)
                        .conditionType(Condition.ConditionTypeEnum.LESSTHAN)
                        .value(50000L)));

    assertNotNull(response);
    assertNotNull(response.getId());
    assertEquals("USD", response.getCurrency());
  }

  @Test
  public void updateWebhookSetting() throws Exception {
    Client client =
        createMockClientFromFile("mocks/balancePlatform/BalanceWebhookSettingResponse.json");
    BalancesApi service = new BalancesApi(client);

    String balancePlatformId = "123456789";
    String webhookId = "WH00000001";
    String settingId = "BWHS00000000000000000000000001";

    WebhookSetting response =
        service.updateWebhookSetting(
            balancePlatformId,
            webhookId,
            settingId,
            new BalanceWebhookSettingInfoUpdate()
                .type(BalanceWebhookSettingInfoUpdate.TypeEnum.BALANCE)
                .target(
                    new TargetUpdate()
                        .type(TargetUpdate.TypeEnum.BALANCEACCOUNT)
                        .id("BA00000000000000000LIABLE"))
                .currency("USD")
                .status(BalanceWebhookSettingInfoUpdate.StatusEnum.ACTIVE)
                .addConditionsItem(
                    new Condition()
                        .balanceType(Condition.BalanceTypeEnum.AVAILABLE)
                        .conditionType(Condition.ConditionTypeEnum.LESSTHAN)
                        .value(50000L)));

    assertNotNull(response);
    assertNotNull(response.getId());
    assertEquals("USD", response.getCurrency());
  }

  @Test
  public void deleteAuthorisedCardUsersTest() throws Exception {
    Client client = createMockClientFromResponse("");
    AuthorizedCardUsersApi service = new AuthorizedCardUsersApi(client);
    service.deleteAuthorisedCardUsers("PI1234567890");

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/paymentInstruments/PI1234567890/authorisedCardUsers",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.DELETE,
            null);
  }

  @Test
  public void createAuthorisedCardUsersTest() throws Exception {
    Client client = createMockClientFromResponse("");
    AuthorizedCardUsersApi service = new AuthorizedCardUsersApi(client);
    service.createAuthorisedCardUsers(
        "PI1234567890", new AuthorisedCardUsers().addLegalEntityIdsItem("LE1234567890"));

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/paymentInstruments/PI1234567890/authorisedCardUsers",
            "{\"legalEntityIds\":[\"LE1234567890\"]}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void getAllAuthorisedCardUsers() throws Exception {
    Client client = createMockClientFromFile("mocks/balancePlatform/AuthorisedCardUsers.json");
    AuthorizedCardUsersApi service = new AuthorizedCardUsersApi(client);
    var response = service.getAllAuthorisedCardUsers("PI1234567890");

    assertNotNull(response);
    assertNotNull(response.getLegalEntityIds());
    assertEquals(1, response.getLegalEntityIds().size());

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/paymentInstruments/PI1234567890/authorisedCardUsers",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.GET,
            null);
  }

  @Test
  public void updateAuthorisedCardUsersTest() throws Exception {
    Client client = createMockClientFromResponse("");
    AuthorizedCardUsersApi service = new AuthorizedCardUsersApi(client);
    service.updateAuthorisedCardUsers(
        "PI1234567890", new AuthorisedCardUsers().addLegalEntityIdsItem("LE1234567890"));

    verify(client.getHttpClient())
        .request(
            "https://balanceplatform-api-test.adyen.com/bcl/v2/paymentInstruments/PI1234567890/authorisedCardUsers",
            "{\"legalEntityIds\":[\"LE1234567890\"]}",
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.PATCH,
            null);
  }

	@Test
	public void scaAssociationManagementApproveAssociationTest() throws Exception {
		Client client = createMockClientFromFile("mocks/balancePlatform/ScaAssociations.json");
		ScaAssociationManagementApi service = new ScaAssociationManagementApi(client);
		ApproveAssociationResponse response = service.approveAssociation(
				"1234567890ABCD", new ApproveAssociationRequest()
						.status(AssociationStatus.ACTIVE)
						.entityId("AH00000000000000000000001")
						.entityType(ScaEntityType.ACCOUNTHOLDER)
						.scaDeviceIds(List.of("BSDR42XV3223223S5N6CDQDGH53M8H")));

		assertNotNull(response);
		assertEquals(1, response.getScaAssociations().size());

		ArgumentCaptor<RequestOptions> optionsCaptor = ArgumentCaptor.forClass(RequestOptions.class);
		verify(client.getHttpClient())
				.request(
						eq("https://balanceplatform-api-test.adyen.com/bcl/v2/scaAssociations"),
						anyString(),
						eq(client.getConfig()),
						eq(false),
						optionsCaptor.capture(),
						eq(ApiConstants.HttpMethod.PATCH),
						eq(null));

		assertNotNull(optionsCaptor.getValue().getAdditionalServiceHeaders());
		assertEquals(1, optionsCaptor.getValue().getAdditionalServiceHeaders().size());
		assertEquals("1234567890ABCD", optionsCaptor.getValue().getAdditionalServiceHeaders().get("WWW-Authenticate"));
	}


}
