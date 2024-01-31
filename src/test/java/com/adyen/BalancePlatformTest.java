package com.adyen;


import com.adyen.constants.ApiConstants;
import com.adyen.model.balanceplatform.*;

import com.adyen.service.balanceplatform.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.google.gson.JsonSyntaxException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class BalancePlatformTest extends BaseTest {
    @Test
    public void GeneralRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalancePlatformResponse.json");
        PlatformApi service = new PlatformApi(client);
        BalancePlatform response = service.getBalancePlatform("123456789");
        assertEquals("123456789" ,response.getId());
        assertEquals("active" ,response.getStatus());
    }

    @Test
    public void GeneralListAccountHoldersTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaginatedAccountHoldersResponse.json");
        PlatformApi service = new PlatformApi(client);
        PaginatedAccountHoldersResponse response = service.getAllAccountHoldersUnderBalancePlatform("LE322KT223222D5FJ7THR293F",10,10 ,null);
        assertEquals("123456789" ,response.getAccountHolders().get(0).getId());
        assertEquals("LE322KT223222D5FJ7THR293F" ,response.getAccountHolders().get(0).getLegalEntityId());
    }

    @Test
    public void AccountHoldersCreateTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/AccountHolderCreatedResponse.json");
        AccountHoldersApi service = new AccountHoldersApi(client);
        AccountHolderInfo request = AccountHolderInfo.fromJson("{\n" +
                "  \"balancePlatform\": \"YOUR_BALANCE_PLATFORM\",\n" +
                "  \"description\": \"S.Hopper - Staff 123\",\n" +
                "  \"legalEntityId\": \"LE322KT223222D5FJ7THR293F\",\n" +
                "  \"contactDetails\": {\n" +
                "    \"email\": \"s.hopper@example.com\",\n" +
                "    \"phone\": {\n" +
                "      \"number\": \"+315551231234\",\n" +
                "      \"type\": \"mobile\"\n" +
                "    },\n" +
                "    \"address\": {\n" +
                "      \"city\": \"Amsterdam\",\n" +
                "      \"country\": \"NL\",\n" +
                "      \"street\": \"Brannan Street\",\n" +
                "      \"houseNumberOrName\": \"274\",\n" +
                "      \"postalCode\": \"1020CD\"\n" +
                "    }\n" +
                "  }\n" +
                "}");
        AccountHolder response = service.createAccountHolder(request);
        assertEquals("AH3227C223222B5CMD2SXFKGT" ,response.getId());
        assertEquals("LE322KT223222D5FJ7THR293F" ,response.getLegalEntityId());
    }
    @Test
    public void AccountHoldersRetrieveTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/AccountHolder.json");
        AccountHoldersApi service = new AccountHoldersApi(client);
        AccountHolder response = service.getAccountHolder("LE322KT223222D5FJ7THR293F");
        assertEquals("AH3227C223222B5CMD2SXFKGT" ,response.getId());
        assertEquals("LE322KT223222D5FJ7THR293F" ,response.getLegalEntityId());
    }
    @Test
    public void AccountHoldersUpdateTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/AccountHolder.json");
        AccountHoldersApi service = new AccountHoldersApi(client);
        AccountHolderUpdateRequest request = AccountHolderUpdateRequest.fromJson("{\n" +
                "  \"balancePlatform\": \"YOUR_BALANCE_PLATFORM\",\n" +
                "  \"contactDetails\": {\n" +
                "    \"address\": {\n" +
                "      \"city\": \"Amsterdam\",\n" +
                "      \"country\": \"NL\",\n" +
                "      \"houseNumberOrName\": \"274\",\n" +
                "      \"postalCode\": \"1020CD\",\n" +
                "      \"street\": \"Brannan Street\"\n" +
                "    },\n" +
                "    \"email\": \"s.hopper@example.com\",\n" +
                "    \"phone\": {\n" +
                "      \"number\": \"+315551231234\",\n" +
                "      \"type\": \"mobile\"\n" +
                "    }\n" +
                "  },\n" +
                "  \"description\": \"S.Hopper - Staff 123\",\n" +
                "  \"legalEntityId\": \"LE322KT223222D5FJ7THR293F\",\n" +
                "  \"id\": \"AH32272223222B5CM4MWJ892H\",\n" +
                "  \"status\": \"active\"\n" +
                "}");
        AccountHolder response = service.updateAccountHolder("AH3227C223222B5CMD2SXFKGT", request);
        assertEquals("AH3227C223222B5CMD2SXFKGT" ,response.getId());
        assertEquals("LE322KT223222D5FJ7THR293F" ,response.getLegalEntityId());
    }
    @Test
    public void AccountHolderListTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaginatedBalanceAccountsResponse.json");
        AccountHoldersApi service = new AccountHoldersApi(client);
        PaginatedBalanceAccountsResponse response = service.getAllBalanceAccountsOfAccountHolder("AH3227C223222B5CMD2SXFKGT", 10, 10, null);
        assertEquals("AH32272223222B59K6ZKBBFNQ" ,response.getBalanceAccounts().get(0).getAccountHolderId());
        assertEquals("BA32272223222B59K6ZXHBFN6" ,response.getBalanceAccounts().get(0).getId());
        Map<String, String> queryMap = new HashMap<>();
        queryMap.put("offset", "10");
        queryMap.put("limit", "10");
        verify(client.getHttpClient()).request(
                "https://balanceplatform-api-test.adyen.com/bcl/v2/accountHolders/AH3227C223222B5CMD2SXFKGT/balanceAccounts",
                null,
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.GET,
                queryMap
        );
    }
    @Test
    public void BalanceAccountsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceAccount.json");
        BalanceAccountsApi service = new BalanceAccountsApi(client);
        BalanceAccountInfo request = BalanceAccountInfo.fromJson("{\n" +
                "  \"accountHolderId\": \"AH32272223222B59K6ZKBBFNQ\",\n" +
                "  \"description\": \"S.Hopper - Main balance account\"\n" +
                "}");
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
        BalanceAccountUpdateRequest request = BalanceAccountUpdateRequest.fromJson("{\n" +
                "  \"accountHolderId\": \"AH32272223222B59K6ZKBBFNQ\",\n" +
                "  \"defaultCurrencyCode\": \"EUR\",\n" +
                "  \"reference\": \"S.Hopper - Main balance account\",\n" +
                "  \"status\": \"active\"\n" +
                "}");
        BalanceAccount response = service.updateBalanceAccount("AH32272223222B59K6ZKBBFNQ", request);
        assertEquals("AH32272223222B59K6ZKBBFNQ", response.getAccountHolderId());
        assertEquals("BA32272223222B59CZ3T52DKZ", response.getId());
    }

    @Test
    public void BalanceAccountsListSweepsTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceSweepConfigurationsResponse.json");
        BalanceAccountsApi service = new BalanceAccountsApi(client);
        BalanceSweepConfigurationsResponse response = service.getAllSweepsForBalanceAccount("AH32272223222B59K6ZKBBFNQ");
        assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getSweeps().get(0).getId());
        assertEquals("BA32272223222B5FTD2KR6TJD", response.getSweeps().get(0).getCounterparty().getBalanceAccountId());
    }

    @Test
    public void BalanceAccountsCreateSweepTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/SweepConfigurationV2.json");
        BalanceAccountsApi service = new BalanceAccountsApi(client);
        CreateSweepConfigurationV2 request = CreateSweepConfigurationV2.fromJson("{\n" +
                "  \"counterparty\": {\n" +
                "    \"merchantAccount\": \"YOUR_MERCHANT_ACCOUNT\"\n" +
                "  },\n" +
                "  \"triggerAmount\": {\n" +
                "    \"currency\": \"EUR\",\n" +
                "    \"value\": 50000\n" +
                "  },\n" +
                "  \"currency\": \"EUR\",\n" +
                "  \"schedule\": {\n" +
                "    \"type\": \"balance\"\n" +
                "  },\n" +
                "  \"type\": \"pull\",\n" +
                "  \"id\": \"SWPC4227C224555B5FTD2NT2JV4WN5\",\n" +
                "  \"status\": \"active\"\n" +
                "}");
        SweepConfigurationV2 response = service.createSweep("AH32272223222B59K6ZKBBFNQ", request);
        assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getId());
        assertEquals(SweepConfigurationV2.StatusEnum.ACTIVE, response.getStatus());
    }

    @Test
    public void sweepScheduleTest() throws Exception {
        // response -> from json
        SweepConfigurationV2 request = SweepConfigurationV2.fromJson("{\n" +
                "  \"counterparty\": {\n" +
                "    \"merchantAccount\": \"YOUR_MERCHANT_ACCOUNT\"\n" +
                "  },\n" +
                "  \"currency\": \"EUR\",\n" +
                "  \"ignoredField\": \"I'm not part of the specs yet, and that's OK\",\n" +
                "  \"id\": \"SWPC4227C224555B5FTD2NT2JV4WN5\",\n" +
                "  \"schedule\": {\n" +
                "    \"type\": \"balance\"\n" +
                "  }\n" +
                "}");
        
        assertThat(request.getSchedule(), instanceOf(SweepSchedule.class));
        assertEquals(SweepSchedule.TypeEnum.BALANCE, request.getSchedule().getType());
    }

    @Test
    public void cronSweepScheduleTest() throws Exception {
        // response -> from json
        SweepConfigurationV2 request = SweepConfigurationV2.fromJson("{\n" +
                "  \"counterparty\": {\n" +
                "    \"merchantAccount\": \"YOUR_MERCHANT_ACCOUNT\"\n" +
                "  },\n" +
                "  \"currency\": \"EUR\",\n" +
                "  \"id\": \"SWPC4227C224555B5FTD2NT2JV4WN5\",\n" +
                "  \"schedule\": {\n" +
                "    \"type\": \"cron\",\n" +
                "    \"cronExpression\": \"*/5 * * * *\"\n" +
                "  }\n" +
                "}");
        
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
        
        assertEquals("{\"schedule\":{\"cronExpression\":\"6 6 6\",\"type\":\"cron\"},\"type\":\"pull\"}", json);
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
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceSweepConfigurationsResponse.json");
        BalanceAccountsApi service = new BalanceAccountsApi(client);
        service.deleteSweep("AH32272223222B59K6ZKBBFNQ", "SWPC4227C224555B5FTD2NT2JV4WN5");
    }

    @Test
    public void BalanceAccountsRetrieveSweepTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/SweepConfigurationV2.json");
        BalanceAccountsApi service = new BalanceAccountsApi(client);
        SweepConfigurationV2 response = service.getSweep("AH32272223222B59K6ZKBBFNQ", "SWPC4227C224555B5FTD2NT2JV4WN5");
        assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getId());
        assertEquals("BA32272223222B5FTD2KR6TJD", response.getCounterparty().getBalanceAccountId());
    }

    @Test
    public void BalanceAccountsUpdateSweepTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/SweepConfigurationV2.json");
        BalanceAccountsApi service = new BalanceAccountsApi(client);
        UpdateSweepConfigurationV2 request = UpdateSweepConfigurationV2.fromJson("{\n" +
                "  \"counterparty\": {\n" +
                "    \"merchantAccount\": \"YOUR_MERCHANT_ACCOUNT\"\n" +
                "  },\n" +
                "  \"triggerAmount\": {\n" +
                "    \"currency\": \"EUR\",\n" +
                "    \"value\": 50000\n" +
                "  },\n" +
                "  \"currency\": \"EUR\",\n" +
                "  \"schedule\": {\n" +
                "    \"type\": \"balance\"\n" +
                "  },\n" +
                "  \"type\": \"pull\",\n" +
                "  \"id\": \"SWPC4227C224555B5FTD2NT2JV4WN5\",\n" +
                "  \"status\": \"active\"\n" +
                "}");
        SweepConfigurationV2 response = service.updateSweep("AH32272223222B59K6ZKBBFNQ", "SWPC4227C224555B5FTD2NT2JV4WN5", request);
        assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getId());
        assertEquals("BA32272223222B5FTD2KR6TJD", response.getCounterparty().getBalanceAccountId());
    }

    @Test
    public void BalanceAccountsListPaymentInstrumentsTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaginatedPaymentInstrumentsResponse.json");
        BalanceAccountsApi service = new BalanceAccountsApi(client);
        PaginatedPaymentInstrumentsResponse response = service.getPaymentInstrumentsLinkedToBalanceAccount("AH32272223222B59K6ZKBBFNQ");
        assertEquals("PI32272223222B59M5TM658DT", response.getPaymentInstruments().get(0).getId());
        assertEquals("BA32272223222B59CZ3T52DKZ", response.getPaymentInstruments().get(0).getBalanceAccountId());
    }

    @Test
    public void PaymentInstrumentsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrument.json");
        PaymentInstrumentsApi service = new PaymentInstrumentsApi(client);
        PaymentInstrumentInfo request = PaymentInstrumentInfo.fromJson("{\n" +
                "  \"type\": \"bankAccount\",\n" +
                "  \"description\": \"YOUR_DESCRIPTION\",\n" +
                "  \"balanceAccountId\": \"BA3227C223222B5CTBLR8BWJB\",\n" +
                "  \"issuingCountryCode\": \"NL\"\n" +
                "}");
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
        PaymentInstrumentUpdateRequest request = PaymentInstrumentUpdateRequest.fromJson("{\n" +
                "  \"balanceAccountId\": \"BA32272223222B5CM82WL892M\"\n" +
                "}");
        UpdatePaymentInstrument response = service.updatePaymentInstrument("PI322LJ223222B5DJS7CD9LWL", request);
        assertEquals("PI32272223222C5GXTDWH3TTN", response.getId());
        assertEquals("BA3227C223222B5FG88S28BGN", response.getBalanceAccountId());
    }

    @Test
    public void PaymentInstrumentsListTransactionRulesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRulesResponse.json");
        PaymentInstrumentsApi service = new PaymentInstrumentsApi(client);
        TransactionRulesResponse response = service.getAllTransactionRulesForPaymentInstrument("TR3227C223222B5FCB756DV9H");
        assertEquals("TR3227C223222B5FCB756DV9H", response.getTransactionRules().get(0).getId());
        assertEquals("PI3227C223222B5BPCMFXD2XG", response.getTransactionRules().get(0).getEntityKey().getEntityReference());
    }

    @Test
    public void PaymentInstrumentGroupsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrumentGroup.json");
        PaymentInstrumentGroupsApi service = new PaymentInstrumentGroupsApi(client);
        PaymentInstrumentGroupInfo request = PaymentInstrumentGroupInfo.fromJson("{\n" +
                "  \"balancePlatform\": \"YOUR_BALANCE_PLATFORM\",\n" +
                "  \"txVariant\": \"mc\"\n" +
                "}");
        PaymentInstrumentGroup response = service.createPaymentInstrumentGroup(request);
        assertEquals("PG3227C223222B5CMD3FJFKGZ", response.getId());
    }

    @Test
    public void PaymentInstrumentGroupsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrumentGroup.json");
        PaymentInstrumentGroupsApi service = new PaymentInstrumentGroupsApi(client);
        PaymentInstrumentGroup response = service.getPaymentInstrumentGroup("PG3227C223222B5CMD3FJFKGZ");
        assertEquals("PG3227C223222B5CMD3FJFKGZ", response.getId());
    }

    @Test
    public void PaymentInstrumentGroupsListTransactionRulesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRulesResponse.json");
        PaymentInstrumentGroupsApi service = new PaymentInstrumentGroupsApi(client);
        TransactionRulesResponse response = service.getAllTransactionRulesForPaymentInstrumentGroup("TR3227C223222B5FCB756DV9H");
        assertEquals("TR3227C223222B5FCB756DV9H", response.getTransactionRules().get(0).getId());
        assertEquals("PI3227C223222B5BPCMFXD2XG", response.getTransactionRules().get(0).getEntityKey().getEntityReference());
    }

    @Test
    public void TransactionRulesCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRule.json");
        TransactionRulesApi service = new TransactionRulesApi(client);
        TransactionRuleInfo request = TransactionRuleInfo.fromJson("{\n" +
                "  \"description\": \"Allow only point-of-sale transactions\",\n" +
                "  \"reference\": \"YOUR_REFERENCE_4F7346\",\n" +
                "  \"entityKey\": {\n" +
                "    \"entityType\": \"paymentInstrument\",\n" +
                "    \"entityReference\": \"PI3227C223222B5BPCMFXD2XG\"\n" +
                "  },\n" +
                "  \"status\": \"active\",\n" +
                "  \"interval\": {\n" +
                "    \"type\": \"perTransaction\"\n" +
                "  },\n" +
                "  \"ruleRestrictions\": {\n" +
                "    \"processingTypes\": {\n" +
                "      \"operation\": \"noneMatch\",\n" +
                "      \"value\": [\n" +
                "        \"pos\"\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  \"type\": \"blockList\"\n" +
                "}");
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
        TransactionRuleInfo request = TransactionRuleInfo.fromJson("{\n" +
                "  \"description\": \"Allow only point-of-sale transactions\",\n" +
                "  \"reference\": \"YOUR_REFERENCE_4F7346\",\n" +
                "  \"entityKey\": {\n" +
                "    \"entityType\": \"paymentInstrument\",\n" +
                "    \"entityReference\": \"PI3227C223222B5BPCMFXD2XG\"\n" +
                "  },\n" +
                "  \"status\": \"active\",\n" +
                "  \"interval\": {\n" +
                "    \"type\": \"perTransaction\"\n" +
                "  },\n" +
                "  \"ruleRestrictions\": {\n" +
                "    \"processingTypes\": {\n" +
                "      \"operation\": \"noneMatch\",\n" +
                "      \"value\": [\n" +
                "        \"pos\"\n" +
                "      ]\n" +
                "    }\n" +
                "  },\n" +
                "  \"type\": \"blockList\"\n" +
                "}");
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
        verify(client.getHttpClient()).request(
                "https://balanceplatform-api-test.adyen.com/bcl/v2/validateBankAccountIdentification",
                "{}",
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
    }


}