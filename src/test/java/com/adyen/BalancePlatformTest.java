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
import com.adyen.service.BalancePlatformService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BalancePlatformTest extends BaseTest {
    @Test
    public void GeneralRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/balancePlatformResponse.json");
        BalancePlatformService service = new BalancePlatformService(client);
        BalancePlatform response = service.general.retrieve("123456789");
        assertEquals("123456789" ,response.getId());
    }

    @Test
    public void GeneralListAccountHoldersTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaginatedAccountHoldersResponse.json");
        BalancePlatformService service = new BalancePlatformService(client);
        PaginatedAccountHoldersResponse response = service.general.listAccountHolders("AH32272223222B59DJ7QBCMPN", null);
        assertEquals("123456789" ,response.getAccountHolders().get(0).getId());
    }

    @Test
    public void AccountHoldersCreateTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/AccountHolderCreatedResponse.json");
        BalancePlatformService service = new BalancePlatformService(client);
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
        AccountHolder response = service.accountHolders.create(request);
        assertEquals("AH3227C223222B5CMD2SXFKGT" ,response.getId());
    }
    @Test
    public void AccountHoldersRetrieveTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/AccountHolder.json");
        BalancePlatformService service = new BalancePlatformService(client);
        AccountHolder response = service.accountHolders.retrieve("AH3227C223222B5CMD2SXFKGT");
        assertEquals("AH3227C223222B5CMD2SXFKGT" ,response.getId());
    }
    @Test
    public void AccountHoldersUpdateTest() throws  Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/AccountHolder.json");
        BalancePlatformService service = new BalancePlatformService(client);
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
        AccountHolder response = service.accountHolders.update("AH3227C223222B5CMD2SXFKGT", request);
        assertEquals("AH3227C223222B5CMD2SXFKGT" ,response.getId());
    }
    @Test
    public void AccountHolderListTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaginatedBalanceAccountsResponse.json");
        BalancePlatformService service = new BalancePlatformService(client);
        PaginatedBalanceAccountsResponse response = service.accountHolders.list("AH3227C223222B5CMD2SXFKGT", null);
        assertEquals("AH32272223222B59K6ZKBBFNQ" ,response.getBalanceAccounts().get(0).getAccountHolderId());
    }
    @Test
    public void BalanceAccountsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceAccount.json");
        BalancePlatformService service = new BalancePlatformService(client);
        BalanceAccountInfo request = BalanceAccountInfo.fromJson("{\n" +
                "  \"accountHolderId\": \"AH32272223222B59K6ZKBBFNQ\",\n" +
                "  \"description\": \"S.Hopper - Main balance account\"\n" +
                "}");
        BalanceAccount response = service.balanceAccounts.create(request);
        assertEquals("AH32272223222B59K6ZKBBFNQ", response.getAccountHolderId());
    }

    @Test
    public void BalanceAccountsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceAccount.json");
        BalancePlatformService service = new BalancePlatformService(client);
        BalanceAccount response = service.balanceAccounts.retrieve("AH32272223222B59K6ZKBBFNQ");
        assertEquals("AH32272223222B59K6ZKBBFNQ", response.getAccountHolderId());
    }

    @Test
    public void BalanceAccountsUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceAccount.json");
        BalancePlatformService service = new BalancePlatformService(client);
        BalanceAccountUpdateRequest request = BalanceAccountUpdateRequest.fromJson("{\n" +
                "  \"accountHolderId\": \"AH32272223222B59K6ZKBBFNQ\",\n" +
                "  \"defaultCurrencyCode\": \"EUR\",\n" +
                "  \"reference\": \"S.Hopper - Main balance account\",\n" +
                "  \"status\": \"active\"\n" +
                "}");
        BalanceAccount response = service.balanceAccounts.update("AH32272223222B59K6ZKBBFNQ", request);
        assertEquals("AH32272223222B59K6ZKBBFNQ", response.getAccountHolderId());
    }

    @Test
    public void BalanceAccountsListSweepsTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceSweepConfigurationsResponse.json");
        BalancePlatformService service = new BalancePlatformService(client);
        BalanceSweepConfigurationsResponse response = service.balanceAccounts.listSweeps("AH32272223222B59K6ZKBBFNQ", null);
        assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getSweeps().get(0).getId());
    }

    @Test
    public void BalanceAccountsCreateSweepTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceSweepConfigurationsResponse.json");
        BalancePlatformService service = new BalancePlatformService(client);
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
        BalanceSweepConfigurationsResponse response = service.balanceAccounts.createSweep("AH32272223222B59K6ZKBBFNQ", request);
        assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getSweeps().get(0).getId());
    }

    @Test
    public void BalanceAccountsDeleteSweepTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/BalanceSweepConfigurationsResponse.json");
        BalancePlatformService service = new BalancePlatformService(client);
        service.balanceAccounts.deleteSweep("AH32272223222B59K6ZKBBFNQ", "SWPC4227C224555B5FTD2NT2JV4WN5");
    }

    @Test
    public void BalanceAccountsRetrieveSweepTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/SweepConfigurationV2.json");
        BalancePlatformService service = new BalancePlatformService(client);
        SweepConfigurationV2 response = service.balanceAccounts.retrieveSweep("AH32272223222B59K6ZKBBFNQ", "SWPC4227C224555B5FTD2NT2JV4WN5");
        assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getId());
    }

    @Test
    public void BalanceAccountsUpdateSweepTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/SweepConfigurationV2.json");
        BalancePlatformService service = new BalancePlatformService(client);
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
        SweepConfigurationV2 response = service.balanceAccounts.updateSweep("AH32272223222B59K6ZKBBFNQ", "SWPC4227C224555B5FTD2NT2JV4WN5", request);
        assertEquals("SWPC4227C224555B5FTD2NT2JV4WN5", response.getId());
    }

    @Test
    public void BalanceAccountsListPaymentInstrumentsTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaginatedPaymentInstrumentsResponse.json");
        BalancePlatformService service = new BalancePlatformService(client);
        PaginatedPaymentInstrumentsResponse response = service.balanceAccounts.listPaymentInstruments("AH32272223222B59K6ZKBBFNQ", null);
        assertEquals("PI32272223222B59M5TM658DT", response.getPaymentInstruments().get(0).getId());
    }

    @Test
    public void PaymentInstrumentsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrument.json");
        BalancePlatformService service = new BalancePlatformService(client);
        PaymentInstrumentInfo request = PaymentInstrumentInfo.fromJson("{\n" +
                "  \"type\": \"bankAccount\",\n" +
                "  \"description\": \"YOUR_DESCRIPTION\",\n" +
                "  \"balanceAccountId\": \"BA3227C223222B5CTBLR8BWJB\",\n" +
                "  \"issuingCountryCode\": \"NL\"\n" +
                "}");
        PaymentInstrument response = service.paymentInstruments.create(request);
        assertEquals("PI322LJ223222B5DJS7CD9LWL", response.getId());
    }

    @Test
    public void PaymentInstrumentsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrument.json");
        BalancePlatformService service = new BalancePlatformService(client);
        PaymentInstrument response = service.paymentInstruments.retrieve("PI322LJ223222B5DJS7CD9LWL");
        assertEquals("PI322LJ223222B5DJS7CD9LWL", response.getId());
    }

    @Test
    public void PaymentInstrumentsUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrument.json");
        BalancePlatformService service = new BalancePlatformService(client);
        PaymentInstrumentUpdateRequest request = PaymentInstrumentUpdateRequest.fromJson("{\n" +
                "  \"balanceAccountId\": \"BA32272223222B5CM82WL892M\"\n" +
                "}");
        PaymentInstrument response = service.paymentInstruments.update("PI322LJ223222B5DJS7CD9LWL", request);
        assertEquals("PI322LJ223222B5DJS7CD9LWL", response.getId());
    }

    @Test
    public void PaymentInstrumentsListTransactionRulesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRulesResponse.json");
        BalancePlatformService service = new BalancePlatformService(client);
        TransactionRulesResponse response = service.paymentInstruments.listTransactionRules("TR3227C223222B5FCB756DV9H");
        assertEquals("TR3227C223222B5FCB756DV9H", response.getTransactionRules().get(0).getId());
    }

    @Test
    public void PaymentInstrumentGroupsCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrumentGroup.json");
        BalancePlatformService service = new BalancePlatformService(client);
        PaymentInstrumentGroupInfo request = PaymentInstrumentGroupInfo.fromJson("{\n" +
                "  \"balancePlatform\": \"YOUR_BALANCE_PLATFORM\",\n" +
                "  \"txVariant\": \"mc\"\n" +
                "}");
        PaymentInstrumentGroup response = service.paymentsInstrumentGroups.create(request);
        assertEquals("PG3227C223222B5CMD3FJFKGZ", response.getId());
    }

    @Test
    public void PaymentInstrumentGroupsRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/PaymentInstrumentGroup.json");
        BalancePlatformService service = new BalancePlatformService(client);
        PaymentInstrumentGroup response = service.paymentsInstrumentGroups.retrieve("PG3227C223222B5CMD3FJFKGZ");
        assertEquals("PG3227C223222B5CMD3FJFKGZ", response.getId());
    }

    @Test
    public void PaymentInstrumentGroupsListTransactionRulesTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRulesResponse.json");
        BalancePlatformService service = new BalancePlatformService(client);
        TransactionRulesResponse response = service.paymentsInstrumentGroups.listTransactionRules("TR3227C223222B5FCB756DV9H");
        assertEquals("TR3227C223222B5FCB756DV9H", response.getTransactionRules().get(0).getId());
    }

    @Test
    public void TransactionRulesCreateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRule.json");
        BalancePlatformService service = new BalancePlatformService(client);
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
        TransactionRule response = service.transactionRules.create(request);
        assertEquals("TR3227C223222B5FCB756DV9H", response.getId());
    }

    @Test
    public void TransactionRulesRetrieveTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRuleResponse.json");
        BalancePlatformService service = new BalancePlatformService(client);
        TransactionRuleResponse response = service.transactionRules.retrieve("TR32272223222B5CMD3V73HXG");
        assertEquals("TR3227C223222B5FCB756DV9H", response.getTransactionRule().getId());
    }

    @Test
    public void TransactionRulesUpdateTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRule.json");
        BalancePlatformService service = new BalancePlatformService(client);
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
        TransactionRule response = service.transactionRules.update("TR3227C223222B5FCB756DV9H", request);
        assertEquals("TR3227C223222B5FCB756DV9H", response.getId());
    }

    @Test
    public void TransactionRulesDeleteTest() throws Exception {
        Client client = createMockClientFromFile("mocks/balancePlatform/TransactionRule.json");
        BalancePlatformService service = new BalancePlatformService(client);
        service.transactionRules.delete("TR3227C223222B5FCB756DV9H");
    }
}