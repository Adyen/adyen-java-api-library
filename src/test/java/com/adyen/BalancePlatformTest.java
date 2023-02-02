package com.adyen;


import com.adyen.model.balanceplatform.AccountHolder;
import com.adyen.model.balanceplatform.AccountHolderInfo;
import com.adyen.model.balanceplatform.BalanceAccount;
import com.adyen.model.balanceplatform.BalanceAccountInfo;
import com.adyen.model.balanceplatform.BalanceAccountUpdateRequest;
import com.adyen.model.balanceplatform.BalancePlatform;
import com.adyen.model.balanceplatform.BalanceSweepConfigurationsResponse;
import com.adyen.model.balanceplatform.PaginatedAccountHoldersResponse;
import com.adyen.model.balanceplatform.PaginatedBalanceAccountsResponse;
import com.adyen.model.balanceplatform.PaginatedPaymentInstrumentsResponse;
import com.adyen.model.balanceplatform.PaymentInstrument;
import com.adyen.model.balanceplatform.PaymentInstrumentGroup;
import com.adyen.model.balanceplatform.PaymentInstrumentGroupInfo;
import com.adyen.model.balanceplatform.PaymentInstrumentInfo;
import com.adyen.model.balanceplatform.PaymentInstrumentUpdateRequest;
import com.adyen.model.balanceplatform.SweepConfigurationV2;
import com.adyen.model.balanceplatform.TransactionRule;
import com.adyen.model.balanceplatform.TransactionRuleInfo;
import com.adyen.model.balanceplatform.TransactionRuleResponse;
import com.adyen.model.balanceplatform.TransactionRulesResponse;
import com.adyen.service.balanceplatform.AccountHolders;
import com.adyen.service.balanceplatform.BalanceAccounts;
import com.adyen.service.balanceplatform.General;
import com.adyen.service.balanceplatform.PaymentInstrumentGroups;
import com.adyen.service.balanceplatform.PaymentInstruments;
import com.adyen.service.balanceplatform.TransactionRules;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalancePlatformTest extends BaseTest {
    @Test
    public void GeneralRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalancePlatformResponse.json");
        General service = new General(client);
        BalancePlatform response = service.retrieve("123456789");
        assertEquals("123456789" ,response.getId());
        assertEquals("active" ,response.getStatus());
    }

    @Test
    public void GeneralListAccountHoldersTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaginatedAccountHoldersResponse.json");
        General service = new General(client);
        PaginatedAccountHoldersResponse response = service.listAccountHolders("LE322KT223222D5FJ7THR293F", null);
        assertEquals("123456789" ,response.getAccountHolders().get(0).getId());
        assertEquals("LE322KT223222D5FJ7THR293F" ,response.getAccountHolders().get(0).getLegalEntityId());
    }

    @Test
    public void AccountHoldersCreateTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/AccountHolderCreatedResponse.json");
        AccountHolders service = new AccountHolders(client);
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
        AccountHolder response = service.create(request);
        assertEquals("AH3227C223222B5CMD2SXFKGT" ,response.getId());
        assertEquals("LE322KT223222D5FJ7THR293F" ,response.getLegalEntityId());
    }
    @Test
    public void AccountHoldersRetrieveTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/AccountHolder.json");
        AccountHolders service = new AccountHolders(client);
        AccountHolder response = service.retrieve("LE322KT223222D5FJ7THR293F");
        assertEquals("AH3227C223222B5CMD2SXFKGT" ,response.getId());
        assertEquals("LE322KT223222D5FJ7THR293F" ,response.getLegalEntityId());
    }
    @Test
    public void AccountHoldersUpdateTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/AccountHolder.json");
        AccountHolders service = new AccountHolders(client);
        AccountHolder request = AccountHolder.fromJson("{\n" +
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
        AccountHolder response = service.update("AH3227C223222B5CMD2SXFKGT", request);
        assertEquals("AH3227C223222B5CMD2SXFKGT" ,response.getId());
        assertEquals("LE322KT223222D5FJ7THR293F" ,response.getLegalEntityId());
    }
    @Test
    public void AccountHolderListTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaginatedBalanceAccountsResponse.json");
        AccountHolders service = new AccountHolders(client);
        PaginatedBalanceAccountsResponse response = service.list("AH3227C223222B5CMD2SXFKGT", null);
        assertEquals("AH32272223222B59K6ZKBBFNQ" ,response.getBalanceAccounts().get(0).getAccountHolderId());
        assertEquals("BA32272223222B59K6ZXHBFN6" ,response.getBalanceAccounts().get(0).getId());
    }
    @Test
    public void BalanceAccountsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceAccount.json");
        BalanceAccounts service = new BalanceAccounts(client);
        BalanceAccountInfo request = BalanceAccountInfo.fromJson("{\n" +
                "  \"accountHolderId\": \"AH32272223222B59K6ZKBBFNQ\",\n" +
                "  \"description\": \"S.Hopper - Main balance account\"\n" +
                "}");
        BalanceAccount response = service.create(request);
        assertEquals("AH32272223222B59K6ZKBBFNQ", response.getAccountHolderId());
        assertEquals("BA32272223222B59CZ3T52DKZ", response.getId());
    }

    @Test
    public void BalanceAccountsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceAccount.json");
        BalanceAccounts service = new BalanceAccounts(client);
        BalanceAccount response = service.retrieve("AH32272223222B59K6ZKBBFNQ");
        assertEquals("AH32272223222B59K6ZKBBFNQ", response.getAccountHolderId());
        assertEquals("BA32272223222B59CZ3T52DKZ", response.getId());
    }

    @Test
    public void BalanceAccountsUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceAccount.json");
        BalanceAccounts service = new BalanceAccounts(client);
        BalanceAccountUpdateRequest request = BalanceAccountUpdateRequest.fromJson("{\n" +
                "  \"accountHolderId\": \"AH32272223222B59K6ZKBBFNQ\",\n" +
                "  \"defaultCurrencyCode\": \"EUR\",\n" +
                "  \"reference\": \"S.Hopper - Main balance account\",\n" +
                "  \"status\": \"active\"\n" +
                "}");
        BalanceAccount response = service.update("AH32272223222B59K6ZKBBFNQ", request);
        assertEquals("AH32272223222B59K6ZKBBFNQ", response.getAccountHolderId());
        assertEquals("BA32272223222B59CZ3T52DKZ", response.getId());
    }

    @Test
    public void BalanceAccountsListSweepsTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceSweepConfigurationsResponse.json");
        BalanceAccounts service = new BalanceAccounts(client);
        BalanceSweepConfigurationsResponse response = service.listSweeps("AH32272223222B59K6ZKBBFNQ", null);
        assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getSweeps().get(0).getId());
        assertEquals("BA32272223222B5FTD2KR6TJD", response.getSweeps().get(0).getCounterparty().getBalanceAccountId());
    }

    @Test
    public void BalanceAccountsCreateSweepTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceSweepConfigurationsResponse.json");
        BalanceAccounts service = new BalanceAccounts(client);
        SweepConfigurationV2 request = SweepConfigurationV2.fromJson("{\n" +
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
        BalanceSweepConfigurationsResponse response = service.createSweep("AH32272223222B59K6ZKBBFNQ", request);
        assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getSweeps().get(0).getId());
        assertEquals("BA32272223222B5FTD2KR6TJD", response.getSweeps().get(0).getCounterparty().getBalanceAccountId());
    }

    @Test
    public void BalanceAccountsDeleteSweepTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceSweepConfigurationsResponse.json");
        BalanceAccounts service = new BalanceAccounts(client);
        service.deleteSweep("AH32272223222B59K6ZKBBFNQ", "SWPC4227C224555B5FTD2NT2JV4WN5");
    }

    @Test
    public void BalanceAccountsRetrieveSweepTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/SweepConfigurationV2.json");
        BalanceAccounts service = new BalanceAccounts(client);
        SweepConfigurationV2 response = service.retrieveSweep("AH32272223222B59K6ZKBBFNQ", "SWPC4227C224555B5FTD2NT2JV4WN5");
        assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getId());
        assertEquals("BA32272223222B5FTD2KR6TJD", response.getCounterparty().getBalanceAccountId());
    }

    @Test
    public void BalanceAccountsUpdateSweepTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/SweepConfigurationV2.json");
        BalanceAccounts service = new BalanceAccounts(client);
        SweepConfigurationV2 request = SweepConfigurationV2.fromJson("{\n" +
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
        BalanceAccounts service = new BalanceAccounts(client);
        PaginatedPaymentInstrumentsResponse response = service.listPaymentInstruments("AH32272223222B59K6ZKBBFNQ", null);
        assertEquals("PI32272223222B59M5TM658DT", response.getPaymentInstruments().get(0).getId());
        assertEquals("BA32272223222B59CZ3T52DKZ", response.getPaymentInstruments().get(0).getBalanceAccountId());
    }

    @Test
    public void PaymentInstrumentsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrument.json");
        PaymentInstruments service = new PaymentInstruments(client);
        PaymentInstrumentInfo request = PaymentInstrumentInfo.fromJson("{\n" +
                "  \"type\": \"bankAccount\",\n" +
                "  \"description\": \"YOUR_DESCRIPTION\",\n" +
                "  \"balanceAccountId\": \"BA3227C223222B5CTBLR8BWJB\",\n" +
                "  \"issuingCountryCode\": \"NL\"\n" +
                "}");
        PaymentInstrument response = service.create(request);
        assertEquals("PI322LJ223222B5DJS7CD9LWL", response.getId());
        assertEquals("BA3227C223222B5CTBLR8BWJB", response.getBalanceAccountId());
    }

    @Test
    public void PaymentInstrumentsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrument.json");
        PaymentInstruments service = new PaymentInstruments(client);
        PaymentInstrument response = service.retrieve("PI322LJ223222B5DJS7CD9LWL");
        assertEquals("PI322LJ223222B5DJS7CD9LWL", response.getId());
        assertEquals("BA3227C223222B5CTBLR8BWJB", response.getBalanceAccountId());
    }

    @Test
    public void PaymentInstrumentsUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrument.json");
        PaymentInstruments service = new PaymentInstruments(client);
        PaymentInstrumentUpdateRequest request = PaymentInstrumentUpdateRequest.fromJson("{\n" +
                "  \"balanceAccountId\": \"BA32272223222B5CM82WL892M\"\n" +
                "}");
        PaymentInstrument response = service.update("PI322LJ223222B5DJS7CD9LWL", request);
        assertEquals("PI322LJ223222B5DJS7CD9LWL", response.getId());
        assertEquals("BA3227C223222B5CTBLR8BWJB", response.getBalanceAccountId());
    }

    @Test
    public void PaymentInstrumentsListTransactionRulesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRulesResponse.json");
        PaymentInstruments service = new PaymentInstruments(client);
        TransactionRulesResponse response = service.listTransactionRules("TR3227C223222B5FCB756DV9H");
        assertEquals("TR3227C223222B5FCB756DV9H", response.getTransactionRules().get(0).getId());
        assertEquals("PI3227C223222B5BPCMFXD2XG", response.getTransactionRules().get(0).getEntityKey().getEntityReference());
    }

    @Test
    public void PaymentInstrumentGroupsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrumentGroup.json");
        PaymentInstrumentGroups service = new PaymentInstrumentGroups(client);
        PaymentInstrumentGroupInfo request = PaymentInstrumentGroupInfo.fromJson("{\n" +
                "  \"balancePlatform\": \"YOUR_BALANCE_PLATFORM\",\n" +
                "  \"txVariant\": \"mc\"\n" +
                "}");
        PaymentInstrumentGroup response = service.create(request);
        assertEquals("PG3227C223222B5CMD3FJFKGZ", response.getId());
    }

    @Test
    public void PaymentInstrumentGroupsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrumentGroup.json");
        PaymentInstrumentGroups service = new PaymentInstrumentGroups(client);
        PaymentInstrumentGroup response = service.retrieve("PG3227C223222B5CMD3FJFKGZ");
        assertEquals("PG3227C223222B5CMD3FJFKGZ", response.getId());
    }

    @Test
    public void PaymentInstrumentGroupsListTransactionRulesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRulesResponse.json");
        PaymentInstrumentGroups service = new PaymentInstrumentGroups(client);
        TransactionRulesResponse response = service.listTransactionRules("TR3227C223222B5FCB756DV9H");
        assertEquals("TR3227C223222B5FCB756DV9H", response.getTransactionRules().get(0).getId());
        assertEquals("PI3227C223222B5BPCMFXD2XG", response.getTransactionRules().get(0).getEntityKey().getEntityReference());
    }

    @Test
    public void TransactionRulesCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRule.json");
        TransactionRules service = new TransactionRules(client);
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
        TransactionRule response = service.create(request);
        assertEquals("TR3227C223222B5FCB756DV9H", response.getId());
        assertEquals("PI3227C223222B5BPCMFXD2XG", response.getEntityKey().getEntityReference());
    }

    @Test
    public void TransactionRulesRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRuleResponse.json");
        TransactionRules service = new TransactionRules(client);
        TransactionRuleResponse response = service.retrieve("TR32272223222B5CMD3V73HXG");
        assertEquals("TR3227C223222B5FCB756DV9H", response.getTransactionRule().getId());
    }

    @Test
    public void TransactionRulesUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRule.json");
        TransactionRules service = new TransactionRules(client);
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
        TransactionRule response = service.update("TR3227C223222B5FCB756DV9H", request);
        assertEquals("TR3227C223222B5FCB756DV9H", response.getId());
        assertEquals("PI3227C223222B5BPCMFXD2XG", response.getEntityKey().getEntityReference());
    }

    @Test
    public void TransactionRulesDeleteTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRule.json");
        TransactionRules service = new TransactionRules(client);
        service.delete("TR3227C223222B5FCB756DV9H");
    }
}