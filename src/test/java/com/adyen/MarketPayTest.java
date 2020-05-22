/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.adyen.model.FraudCheckResult;
import com.adyen.model.Name;
import com.adyen.model.PaymentRequest;
import com.adyen.model.PaymentResult;
import com.adyen.model.additionalData.SplitPayment;
import com.adyen.model.additionalData.SplitPaymentItem;
import com.adyen.model.marketpay.*;
import com.adyen.service.Account;
import com.adyen.service.Fund;
import com.adyen.service.Payment;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

import static com.adyen.model.marketpay.KYCCheckStatusData.CheckStatusEnum.AWAITING_DATA;
import static com.adyen.model.marketpay.KYCCheckStatusData.CheckStatusEnum.PASSED;
import static com.adyen.model.marketpay.KYCCheckStatusData.CheckTypeEnum.BANK_ACCOUNT_VERIFICATION;
import static com.adyen.model.marketpay.KYCCheckStatusData.CheckTypeEnum.COMPANY_VERIFICATION;
import static com.adyen.model.marketpay.KYCCheckStatusData.CheckTypeEnum.IDENTITY_VERIFICATION;
import static org.junit.Assert.*;

/**
 * Tests for /authorise and /authorise3d
 */
public class MarketPayTest extends BaseTest {
    /**
     * Test success flow for POST /authorise
     */
    @Test
    public void TestCreateSplitPayment() throws Exception {
        Client client = createMockClientFromFile("mocks/authorise-success.json");
        Payment payment = new Payment(client);

        PaymentRequest paymentRequest = createBasePaymentRequest(new PaymentRequest()).reference("123456")
                .setAmountData("6200", "EUR")
                .setCardData("5136333333333335", "John Doe", "08", "2018", "737");

        // splitPayment
        SplitPayment splitPayment = new SplitPayment();
        splitPayment.setApi(1);
        splitPayment.setTotalAmount(6200L);
        splitPayment.setCurrencyCode("EUR");

        List<SplitPaymentItem> splitPaymentItems = new ArrayList<>();

        // first split payment item
        SplitPaymentItem splitPaymentItem = new SplitPaymentItem();
        splitPaymentItem.setAmount(6000L);
        splitPaymentItem.setType("MarketPlace");
        splitPaymentItem.setAccount("151272963");
        splitPaymentItem.setReference("6124145");
        splitPaymentItem.setDescription("Porcelain Doll: Eliza (20cm)");
        splitPaymentItems.add(splitPaymentItem);

        // seconf split payment item
        SplitPaymentItem splitPaymentItem2 = new SplitPaymentItem();
        splitPaymentItem2.setAmount(200L);
        splitPaymentItem2.setType("Commission");
        splitPaymentItem2.setReference("6124146");
        splitPaymentItems.add(splitPaymentItem2);

        // add items to list
        splitPayment.setSplitPaymentItems(splitPaymentItems);

        // add it into the request
        paymentRequest.setSplitPayment(splitPayment);

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertTrue(paymentResult.isAuthorised());

        SimpleDateFormat format = new SimpleDateFormat("M/yyyy", Locale.ENGLISH);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));

        assertEquals("8/2018", format.format(paymentResult.getExpiryDate()));

        assertEquals("411111", paymentResult.getCardBin());
        assertEquals("1111", paymentResult.getCardSummary());
        assertEquals("Holder", paymentResult.getCardHolderName());
        assertTrue(paymentResult.get3DOffered());
        assertFalse(paymentResult.get3DAuthenticated());
        assertEquals("69746", paymentResult.getAuthCode());

        assertEquals(11, paymentResult.getFraudResult().getFraudCheckResults().size());

        FraudCheckResult fraudCheckResult = paymentResult.getFraudResult().getFraudCheckResults().get(0);
        assertEquals("CardChunkUsage", fraudCheckResult.getName());
        assertEquals(8, fraudCheckResult.getAccountScore().intValue());
        assertEquals(2, fraudCheckResult.getCheckId().intValue());
    }

    /**
     * Test success flow for POST /createAccountHolder
     */
    @Test
    public void TestCreateAccountHolderSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/create-account-holder-success.json");

        // use Account service
        Account account = new Account(client);

        // Create Account Holder Request
        CreateAccountHolderRequest createAccountHolderRequest = new CreateAccountHolderRequest();
        createAccountHolderRequest.setAccountHolderCode("TestAccountHolder781664");

        // create AcountHolderDetails
        AccountHolderDetails accountHolderDetails = new AccountHolderDetails();

        // Add address to AcountHolderDetails
        Address address = new Address();
        address.setCity("Amsterdam");
        address.setCountry("US");
        address.houseNumberOrName("10");
        address.postalCode("12345");
        address.stateOrProvince("NH");
        address.setStreet("Teststreet 1");
        accountHolderDetails.setAddress(address);

        // set BankAccountDetails
        BankAccountDetail bankAccountDetail = new BankAccountDetail();
        bankAccountDetail.setAccountNumber("12345678");
        bankAccountDetail.setBankAccountName("baName");
        bankAccountDetail.setBankBicSwift("BicSUSft");
        bankAccountDetail.setBankCity("city");
        bankAccountDetail.setBankName("bankName");
        bankAccountDetail.setBranchCode("122105155");
        bankAccountDetail.setCountryCode("US");
        bankAccountDetail.setCurrencyCode("EUR");
        bankAccountDetail.setIban("iban");
        bankAccountDetail.setOwnerCity("ownerCity");
        bankAccountDetail.setOwnerCountryCode("BE");
        bankAccountDetail.setOwnerDateOfBirth("1980-01-01"); // set datetime element
        bankAccountDetail.setOwnerHouseNumberOrName("houseNumberOrName");
        bankAccountDetail.setOwnerName("ownerName");
        bankAccountDetail.setOwnerNationality("AD");
        bankAccountDetail.setOwnerPostalCode("ownerPostalCode");
        bankAccountDetail.setOwnerState("ownerState");
        bankAccountDetail.setOwnerStreet("ownerStreet");
        bankAccountDetail.setPrimaryAccount(true);
        bankAccountDetail.setTaxId("bankTaxId");
        accountHolderDetails.addBankAccountDetailsItem(bankAccountDetail);
        accountHolderDetails.setEmail("test@adyen.com");

        // set individualDetails
        IndividualDetails individualDetails = new IndividualDetails();

        // set name inside individualDetails
        Name name = new Name();
        name.firstName("First name");
        name.lastName("Last Name");
        name.gender(Name.GenderEnum.MALE);
        individualDetails.setName(name);

        // set personal data inside individualDetails
        PersonalData personalData = new PersonalData();
        personalData.dateOfBirth("1970-01-01");
        personalData.setNationality("NL");
        //set id
        PersonalDocumentData personalDocumentData = new PersonalDocumentData();
        personalDocumentData.setNumber("1234567890");
        personalDocumentData.setType(PersonalDocumentData.TypeEnum.ID);
        personalData.setDocumentData(Collections.singletonList(personalDocumentData));
        individualDetails.setPersonalData(personalData);

        // attach individualDetails into accountHolderDetails
        accountHolderDetails.setIndividualDetails(individualDetails);
        accountHolderDetails.setMerchantCategoryCode("7999");
        accountHolderDetails.setFullPhoneNumber("+31 0612345678");

        final PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.setPhoneCountryCode("NL");
        phoneNumber.setPhoneNumber("0612345678");
        phoneNumber.setPhoneType(PhoneNumber.PhoneTypeEnum.MOBILE);

        accountHolderDetails.setWebAddress("http://www.adyen.com");

        // set accountHolderDetails
        createAccountHolderRequest.setAccountHolderDetails(accountHolderDetails);
        createAccountHolderRequest.setCreateDefaultAccount(true);
        createAccountHolderRequest.setLegalEntity(CreateAccountHolderRequest.LegalEntityEnum.INDIVIDUAL);

        // createAccountHolder
        CreateAccountHolderResponse createAccountHolderResponse = account.createAccountHolder(createAccountHolderRequest);

        assertEquals("140922935", createAccountHolderResponse.getAccountCode());
        assertEquals("681d5df6-cf38-4557-aecd-ac8ed0c04195", createAccountHolderResponse.getAccountHolderDetails().getBankAccountDetails().get(0).getBankAccountUUID());
        assertEquals(BANK_ACCOUNT_VERIFICATION, createAccountHolderResponse.getVerification().getBankAccounts().get(0).getChecks().get(0).getCheckType());
        assertEquals(PASSED, createAccountHolderResponse.getVerification().getBankAccounts().get(0).getChecks().get(0).getCheckStatus());
    }


    /**
     * Test success flow for POST /accountHolderBalance
     */
    @Test
    public void TestAccountHolderBalanceSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/fund/account-holder-balance-success.json");

        // use Fund service
        Fund fund = new Fund(client);

        // create AccountHolderBalance Request
        AccountHolderBalanceRequest accountHolderBalanceRequest = new AccountHolderBalanceRequest();
        accountHolderBalanceRequest.accountHolderCode("TestAccountHolder877209");
        AccountHolderBalanceResponse accountHolderBalanceResponse = fund.accountHolderBalance(accountHolderBalanceRequest);


        assertEquals(42058L, accountHolderBalanceResponse.getTotalBalance().getPendingBalance().get(0).getValue().longValue());
        assertEquals(77098L, accountHolderBalanceResponse.getTotalBalance().getOnHoldBalance().get(0).getValue().longValue());
        assertEquals(99792L, accountHolderBalanceResponse.getTotalBalance().getBalance().get(0).getValue().longValue());
        assertEquals(99792L, accountHolderBalanceResponse.getBalancePerAccount().get(0).getDetailBalance().getBalance().get(0).getValue().longValue());
    }

    @Test
    public void TestUpdateAccountHolderSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/update-account-holder-success.json");

        // use Account service
        Account account = new Account(client);

        // Update Account Holder Request
        UpdateAccountHolderRequest updateAccountHolderRequest = new UpdateAccountHolderRequest();
        updateAccountHolderRequest.setAccountHolderCode("TestAccountHolder414261");

        // create AcountHolderDetails
        AccountHolderDetails accountHolderDetails = new AccountHolderDetails();

        // Add address to AcountHolderDetails
        Address address = new Address();
        address.setCity("Amsterdam");
        address.setCountry("NL");
        address.houseNumberOrName("10");
        address.postalCode("12345");
        address.stateOrProvince("NH");
        address.setStreet("Teststreet 1");
        accountHolderDetails.setAddress(address);
        accountHolderDetails.setEmail("test@adyen.com");

        // set individualDetails
        IndividualDetails individualDetails = new IndividualDetails();

        // update name inside individualDetails
        Name name = new Name();
        name.firstName("First name");
        name.lastName("Last Name");
        name.gender(Name.GenderEnum.MALE);
        individualDetails.setName(name);

        // update personal data inside individualDetails
        PersonalData personalData = new PersonalData();
        personalData.dateOfBirth("1970-01-01");
        personalData.setNationality("NL");
        //set id
        PersonalDocumentData personalDocumentData = new PersonalDocumentData();
        personalDocumentData.setNumber("1234567890");
        personalDocumentData.setType(PersonalDocumentData.TypeEnum.ID);
        personalData.setDocumentData(Collections.singletonList(personalDocumentData));
        individualDetails.setPersonalData(personalData);

        // attach individualDetails into accountHolderDetails
        accountHolderDetails.setIndividualDetails(individualDetails);
        accountHolderDetails.setMerchantCategoryCode("7999");
        accountHolderDetails.setFullPhoneNumber("+31 0612345678");
        accountHolderDetails.setWebAddress("http://www.accountholderwebsite.com");

        // updateAccountHolder
        updateAccountHolderRequest.setAccountHolderDetails(accountHolderDetails);
        UpdateAccountHolderResponse updateAccountHolderResponse = account.updateAccountHolder(updateAccountHolderRequest);

        assertEquals(49999L, updateAccountHolderResponse.getAccountHolderStatus().getPayoutState().getPayoutLimit().getValue().longValue());
    }

    @Test
    public void TestGetIndividualAccountHolderSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/get-individual-account-holder-success.json");

        // use Account service
        Account account = new Account(client);

        // create GetAccountHolder Request
        GetAccountHolderRequest getAccountHolderRequest = new GetAccountHolderRequest();
        getAccountHolderRequest.setAccountHolderCode("TestAccountHolder3110");

        GetAccountHolderResponse getAccountHolderResponse = account.getAccountHolder(getAccountHolderRequest);

        assertEquals("6026a526-7863-aaaa-dddd-f8fadc47473e", getAccountHolderResponse.getAccountHolderDetails().getBankAccountDetails().get(0).getBankAccountUUID());
        assertEquals("115548513", getAccountHolderResponse.getAccounts().get(0).getAccountCode());
        assertEquals(IDENTITY_VERIFICATION, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getCheckType());
        assertEquals(AWAITING_DATA, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getCheckStatus());
        assertNotNull(getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getRequiredFields());
        assertEquals("AccountHolderDetails.Address.address", getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getRequiredFields().get(0));
        assertEquals("AccountHolderDetails.PhoneNumber.phoneNumber", getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getRequiredFields().get(1));

    }

    @Test
    public void TestGetBusinessAccountHolderSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/get-business-account-holder-success.json");

        // use Account service
        Account account = new Account(client);

        // create GetAccountHolder Request
        GetAccountHolderRequest getAccountHolderRequest = new GetAccountHolderRequest();
        getAccountHolderRequest.setAccountHolderCode("TestAccountHolder480834");

        GetAccountHolderResponse getAccountHolderResponse = account.getAccountHolder(getAccountHolderRequest);

        assertEquals("1abf8304-58c7-4a9e-8bd3-4d7eff9801e4", getAccountHolderResponse.getAccountHolderDetails().getBankAccountDetails().get(0).getBankAccountUUID());
        assertEquals("67890", getAccountHolderResponse.getAccountHolderDetails().getBusinessDetails().getShareholders().get(0).getAddress().getPostalCode());
        assertEquals("115548513", getAccountHolderResponse.getAccounts().get(0).getAccountCode());
        assertEquals(COMPANY_VERIFICATION, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getCheckType());
        assertEquals(PASSED, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getCheckStatus());
        assertEquals(1602, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getSummary().getKycCheckCode().intValue());
        assertEquals("Passed", getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getSummary().getKycCheckDescription());
    }

    @Test
    public void TestUploadDocumentSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/upload-document-success.json");

        // use Account service
        Account account = new Account(client);

        // Create UploadDocument Request
        UploadDocumentRequest uploadDocumentRequest = new UploadDocumentRequest();
        uploadDocumentRequest.setDocumentContent("dGVzdCBkb2N1bWVudCBjb250ZW50");

        // Create Document Detail
        DocumentDetail documentDetail = new DocumentDetail();
        documentDetail.setAccountHolderCode("TestAccountHolder534055");
        documentDetail.setDocumentType(DocumentDetail.DocumentTypeEnum.PASSPORT);
        documentDetail.setFilename("passport.png");
        documentDetail.setDescription("test passport description");

        // Set Document Detail
        uploadDocumentRequest.setDocumentDetail(documentDetail);

        UploadDocumentResponse uploadDocumentResponse = account.uploadDocument(uploadDocumentRequest);
        assertEquals(9999L, uploadDocumentResponse.getAccountHolderStatus().getProcessingState().getProcessedTo().getValue().longValue());

    }

    @Test
    public void TestTransferFundsSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/fund/transfer-funds-success.json");

        // use Fund service
        Fund fund = new Fund(client);

        // create TransferFunds Request
        TransferFundsRequest transferFundsRequest = new TransferFundsRequest();
        transferFundsRequest.setSourceAccountCode("100000000");
        transferFundsRequest.setDestinationAccountCode("190324759");

        // create Amount
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(2000L);
        transferFundsRequest.setAmount(amount);

        transferFundsRequest.setTransferCode("CODE_A");
        TransferFundsResponse transferFundsResponse = fund.transferFunds(transferFundsRequest);

        assertEquals("Received", transferFundsResponse.getResultCode());
    }

    @Test
    public void TestCreateAccountSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/create-account-success.json");

        // use Account service
        Account account = new Account(client);

        // create CreateAccount Request
        CreateAccountRequest createAccountRequest = new CreateAccountRequest();
        createAccountRequest.setAccountHolderCode("TestAccountHolder5691");

        CreateAccountResponse createAccountResponse = account.createAccount(createAccountRequest);
        assertEquals("TestAccountHolder5691", createAccountResponse.getAccountHolderCode());
        assertEquals("Success", createAccountResponse.getResultCode());
        assertEquals("9914913130220156", createAccountResponse.getPspReference());
        assertEquals("195920946", createAccountResponse.getAccountCode());
        assertEquals(CreateAccountResponse.StatusEnum.ACTIVE, createAccountResponse.getStatus());
    }

    @Test
    public void TestDeleteBankAccountSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/delete-bank-account-success.json");

        // use Account service
        Account account = new Account(client);

        // create DeleteBankAccount Request
        DeleteBankAccountRequest deleteBankAccountRequest = new DeleteBankAccountRequest();
        deleteBankAccountRequest.setAccountHolderCode("TestAccountHolder8843");
        deleteBankAccountRequest.addBankAccountUUIDsItem("eeb6ed22-3bae-483c-83b9-bc2097a75d40");

        DeleteBankAccountResponse deleteBankAccountResponse = account.deleteBankAccount(deleteBankAccountRequest);

        assertEquals("9914694372670551", deleteBankAccountResponse.getPspReference());
        assertEquals("Success", deleteBankAccountResponse.getResultCode());
    }

    @Test
    public void TestDeleteShareholderSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/delete-shareholder-success.json");

        // use Account service
        Account account = new Account(client);

        // create DeleteShareholder Request
        DeleteShareholderRequest deleteShareholderRequest = new DeleteShareholderRequest();
        deleteShareholderRequest.setAccountHolderCode("TestAccountHolder289429");
        deleteShareholderRequest.addShareholderCodesItem("9188218c-576e-4cbe-8e86-72722f453920");

        DeleteShareholderResponse deleteShareholderResponse = account.deleteShareholder(deleteShareholderRequest);
        assertEquals("9914694372990637", deleteShareholderResponse.getPspReference());
        assertEquals("Received", deleteShareholderResponse.getResultCode());

    }

    @Test
    public void TestSuspendAccountHolderSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/suspend-account-holder-success.json");

        // use Account service
        Account account = new Account(client);

        // create SuspendAccountHolder Request
        SuspendAccountHolderRequest suspendAccountHolderRequest = new SuspendAccountHolderRequest();
        suspendAccountHolderRequest.setAccountHolderCode("TestAccountHolder192192");

        SuspendAccountHolderResponse suspendAccountHolderResponse = account.suspendAccountHolder(suspendAccountHolderRequest);
        assertEquals(49999L, suspendAccountHolderResponse.getAccountHolderStatus().getPayoutState().getPayoutLimit().getValue().longValue());

    }

    @Test
    public void TestUnSuspendAccountHolderSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/un-suspend-account-holder-success.json");

        // use Account service
        Account account = new Account(client);

        // create UnSuspendAccountHolder Request
        UnSuspendAccountHolderRequest unSuspendAccountHolderRequest = new UnSuspendAccountHolderRequest();
        unSuspendAccountHolderRequest.setAccountHolderCode("TestAccountHolder192192");

        UnSuspendAccountHolderResponse unSuspendAccountHolderResponse = account.unSuspendAccountHolder(unSuspendAccountHolderRequest);
        assertEquals(49999L, unSuspendAccountHolderResponse.getAccountHolderStatus().getPayoutState().getPayoutLimit().getValue().longValue());
    }

    @Test
    public void TestUpdateAccountHolderStateSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/update-account-holder-state-success.json");

        // use Account service
        Account account = new Account(client);

        // create UpdateAccountHolderState Request
        UpdateAccountHolderStateRequest updateAccountHolderStateRequest = new UpdateAccountHolderStateRequest();
        updateAccountHolderStateRequest.setAccountHolderCode("TestAccountHolder215394");
        updateAccountHolderStateRequest.setDisable(true);
        updateAccountHolderStateRequest.setReason("test reason payout");
        updateAccountHolderStateRequest.stateType(UpdateAccountHolderStateRequest.StateTypeEnum.PAYOUT);

        UpdateAccountHolderStateResponse updateAccountHolderStateResponse = account.updateAccountHolderState(updateAccountHolderStateRequest);
        assertEquals(74999L, updateAccountHolderStateResponse.getAccountHolderStatus().getPayoutState().getPayoutLimit().getValue().longValue());
    }

    @Test
    public void TestCloseAccountSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/close-account-success.json");

        // use Account service
        Account account = new Account(client);

        // create CloseAccount Request
        CloseAccountRequest closeAccountRequest = new CloseAccountRequest();
        closeAccountRequest.setAccountCode("118731451");

        CloseAccountResponse closeAccountResponse = account.closeAccount(closeAccountRequest);
        assertEquals("9914913129290137", closeAccountResponse.getPspReference());
        assertEquals("Success", closeAccountResponse.getResultCode());
        assertEquals(CloseAccountResponse.StatusEnum.CLOSED, closeAccountResponse.getStatus());
    }

    @Test
    public void TestCloseAccountHolderSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/close-account-holder-success.json");

        // use Account service
        Account account = new Account(client);

        // create CloseAccountHolder Request
        CloseAccountHolderRequest closeAccountHolderRequest = new CloseAccountHolderRequest();
        closeAccountHolderRequest.setAccountHolderCode("TestAccountHolder1450");

        CloseAccountHolderResponse closeAccountHolderResponse = account.closeAccountHolder(closeAccountHolderRequest);
        assertEquals("9914713476670992", closeAccountHolderResponse.getPspReference());
        assertEquals("Success", closeAccountHolderResponse.getResultCode());
        assertEquals(AccountHolderStatus.StatusEnum.CLOSED, closeAccountHolderResponse.getAccountHolderStatus().getStatus());
    }

    @Test
    public void TestPayoutAccountHolderSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/fund/payout-account-holder-success.json");

        // use Fund service
        Fund fund = new Fund(client);

        // create PayoutAccountHolder Request
        PayoutAccountHolderRequest payoutAccountHolderRequest = new PayoutAccountHolderRequest();
        payoutAccountHolderRequest.setAccountCode("118731451");
        payoutAccountHolderRequest.setAccountHolderCode("TestAccountHolder877209");
        payoutAccountHolderRequest.setDescription("12345 – Test");
        payoutAccountHolderRequest.setBankAccountUUID("000b81aa-ae7e-4492-aa7e-72b2129dce0c");

        // create Amount
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(2000L);
        payoutAccountHolderRequest.setAmount(amount);

        PayoutAccountHolderResponse payoutAccountHolderResponse = fund.payoutAccountHolder(payoutAccountHolderRequest);
        assertEquals("testbankaccount", payoutAccountHolderResponse.getBankAccountUUID());
    }

    @Test
    public void TestUpdateAccountSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/update-account-success.json");

        // use Account service
        Account account = new Account(client);

        // create Update Account Request
        UpdateAccountRequest updateAccountRequest = new UpdateAccountRequest();
        updateAccountRequest.setAccountCode("198360329");

        UpdatePayoutScheduleRequest updatePayoutScheduleRequest = new UpdatePayoutScheduleRequest();
        updatePayoutScheduleRequest.setSchedule(UpdatePayoutScheduleRequest.ScheduleEnum.WEEKLY);
        updatePayoutScheduleRequest.setAction(UpdatePayoutScheduleRequest.ActionEnum.CLOSE);

        updateAccountRequest.setPayoutSchedule(updatePayoutScheduleRequest);

        UpdateAccountResponse updateAccountResponse = account.updateAccount(updateAccountRequest);
        assertEquals(PayoutScheduleResponse.ScheduleEnum.WEEKLY, updateAccountResponse.getPayoutSchedule().getSchedule());

    }

    @Test
    public void TestAccountHolderTransactionListSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/fund/account-holder-transaction-list-success.json");

        // use Fund service
        Fund fund = new Fund(client);

        // create AccountHolderTransactionList Request
        AccountHolderTransactionListRequest accountHolderTransactionListRequest = new AccountHolderTransactionListRequest();
        accountHolderTransactionListRequest.setAccountHolderCode("TestAccountHolder423978");
        accountHolderTransactionListRequest.addTransactionStatusesItem(AccountHolderTransactionListRequest.TransactionStatusesEnum.PENDINGCREDIT);
        accountHolderTransactionListRequest.addTransactionStatusesItem(AccountHolderTransactionListRequest.TransactionStatusesEnum.CREDITED);
        accountHolderTransactionListRequest.addTransactionStatusesItem(AccountHolderTransactionListRequest.TransactionStatusesEnum.DEBITED);
        TransactionListForAccount transactionListForAccount = new TransactionListForAccount();
        transactionListForAccount.setAccountCode("2e64b396-1200-4474-b848-0cb06b52b3c7");
        transactionListForAccount.setPage(2);
        accountHolderTransactionListRequest.addTransactionListsPerAccountItem(transactionListForAccount);
        AccountHolderTransactionListResponse accountHolderTransactionListResponse = fund.accountHolderTransactionList(accountHolderTransactionListRequest);

        assertEquals("118731451", accountHolderTransactionListResponse.getAccountTransactionLists().get(0).getAccountCode());
        assertEquals(4, accountHolderTransactionListResponse.getAccountTransactionLists().get(0).getTransactions().size());
        assertEquals("12345 - Test", accountHolderTransactionListResponse.getAccountTransactionLists().get(0).getTransactions().get(0).getDescription());
        assertEquals(Transaction.TransactionStatusEnum.PENDINGCREDIT, accountHolderTransactionListResponse.getAccountTransactionLists().get(0).getTransactions().get(0).getTransactionStatus());
        assertEquals("9914716081770032", accountHolderTransactionListResponse.getAccountTransactionLists().get(0).getTransactions().get(0).getPspReference());
        assertEquals(2300L, accountHolderTransactionListResponse.getAccountTransactionLists().get(0).getTransactions().get(0).getAmount().getValue().longValue());

    }

    @Test
    public void TestGetUploadedDocumentsSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/get-uploaded-documents-success.json");

        // use Account service
        Account account = new Account(client);

        // create GetUploadedDocuments request
        GetUploadedDocumentsRequest getUploadedDocumentsRequest = new GetUploadedDocumentsRequest();
        getUploadedDocumentsRequest.setAccountHolderCode("TestAccountHolder8031");
        getUploadedDocumentsRequest.setBankAccountUUID("EXAMPLE_UUID");

        GetUploadedDocumentsResponse getUploadedDocumentsResponse = account.getUploadedDocuments(getUploadedDocumentsRequest);
        assertEquals("bankstatement.png", getUploadedDocumentsResponse.getDocumentDetails().get(0).getFilename());
    }

    @Test
    public void TestRefundNotPaidOutTransfersSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/fund/refund-not-paid-out-transfers-success.json");

        // use Fund service
        Fund fund = new Fund(client);

        RefundNotPaidOutTransfersRequest refundNotPaidOutTransfersRequest = new RefundNotPaidOutTransfersRequest();
        refundNotPaidOutTransfersRequest.setAccountHolderCode("TestAccountHolder502924");
        refundNotPaidOutTransfersRequest.setAccountCode("189184578");

        RefundNotPaidOutTransfersResponse refundNotPaidOutTransfersResponse = fund.refundNotPaidOutTransfers(refundNotPaidOutTransfersRequest);
        assertEquals("Failed", refundNotPaidOutTransfersResponse.getResultCode());
    }

    @Test
    public void TestSetupBeneficiarySuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/fund/setup-beneficiary-success.json");

        // use Fund service
        Fund fund = new Fund(client);

        SetupBeneficiaryRequest setupBeneficiaryRequest = new SetupBeneficiaryRequest();
        setupBeneficiaryRequest.setDestinationAccountCode("128952522");
        setupBeneficiaryRequest.setMerchantReference("Test");
        setupBeneficiaryRequest.setSourceAccountCode("134498192");

        SetupBeneficiaryResponse setupBeneficiaryResponse = fund.setupBeneficiary(setupBeneficiaryRequest);
        assertEquals("Success", setupBeneficiaryResponse.getResultCode());
    }

    @Test
    public void TestCreateAccountHolderInvalid() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/create-account-holder-error-invalid-fields.json");

        // use Account service
        Account account = new Account(client);

        // Create Account Holder Request
        CreateAccountHolderRequest createAccountHolderRequest = new CreateAccountHolderRequest();

        CreateAccountHolderResponse createAccountHolderResponse = account.createAccountHolder(createAccountHolderRequest);

        assertEquals("8815089411506100", createAccountHolderResponse.getPspReference());
        assertEquals(1, createAccountHolderResponse.getInvalidFields().size());
        assertEquals(17, createAccountHolderResponse.getInvalidFields().get(0).getErrorCode().intValue());
        assertEquals("IBAN and accountNumber/branchCode/bankCode specified, please provide one or the other", createAccountHolderResponse.getInvalidFields().get(0).getErrorDescription());
        assertNotNull(createAccountHolderResponse.getInvalidFields().get(0).getFieldType());
        assertEquals("AccountHolderDetails.BankAccountDetails.iban", createAccountHolderResponse.getInvalidFields().get(0).getFieldType().getField());
        assertEquals(FieldType.FieldNameEnum.IBAN, createAccountHolderResponse.getInvalidFields().get(0).getFieldType().getFieldName());
    }

    @Test
    public void TestUpdateAccountHolderInvalid() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/update-account-holder-error-invalid-fields.json");

        // use Account service
        Account account = new Account(client);

        // Create Account Holder Request
        UpdateAccountHolderRequest updateAccountHolderRequest = new UpdateAccountHolderRequest();

        UpdateAccountHolderResponse updateAccountHolderResponse = account.updateAccountHolder(updateAccountHolderRequest);

        assertEquals(17, updateAccountHolderResponse.getInvalidFields().get(0).getErrorCode().intValue());
    }

    @Test
    public void TestCheckAccountHolderSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/account/check-account-holder-success.json");
        Account account = new Account(client);
        PerformVerificationRequest performVerificationRequest = new PerformVerificationRequest();
        performVerificationRequest.setAccountHolderCode("accountHolderCode");
        performVerificationRequest.setAccountStateType(PerformVerificationRequest.AccountStateTypeEnum.PAYOUT);
        performVerificationRequest.setTier(1);
        CheckAccountHolderResponse checkAccountHolderResponse = account.checkAccountHolder(performVerificationRequest);

        assertNotNull(checkAccountHolderResponse);
        assertEquals("Success", checkAccountHolderResponse.getResultCode());
        assertEquals("85158152328111154", checkAccountHolderResponse.getPspReference());
    }

    @Test
    public void TestDeletePayoutMethodsSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/account/delete-payout-methods-success.json");
        Account account = new Account(client);
        DeletePayoutMethodRequest deletePayoutMethodRequest = new DeletePayoutMethodRequest();
        deletePayoutMethodRequest.setAccountHolderCode("accountHolderCode");
        deletePayoutMethodRequest.addPayoutMethodCodesItem("payoutMethod");
        DeletePayoutMethodResponse deletePayoutMethodResponse = account.deletePayoutMethod(deletePayoutMethodRequest);

        assertNotNull(deletePayoutMethodResponse);
        assertEquals("Success", deletePayoutMethodResponse.getResultCode());
        assertEquals("85758192328222265", deletePayoutMethodResponse.getPspReference());
    }

    @Test
    public void TestDeletePayoutMethodsErrorInvalid() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/account/delete-payout-methods-error-invalid-fields.json");
        Account account = new Account(client);
        DeletePayoutMethodRequest deletePayoutMethodRequest = new DeletePayoutMethodRequest();
        deletePayoutMethodRequest.setAccountHolderCode("accountHolderCode");
        deletePayoutMethodRequest.addPayoutMethodCodesItem("payoutMethod");
        DeletePayoutMethodResponse deletePayoutMethodResponse = account.deletePayoutMethod(deletePayoutMethodRequest);

        assertNotNull(deletePayoutMethodResponse);
        assertEquals("8834084311503499", deletePayoutMethodResponse.getPspReference());
        assertEquals(1, deletePayoutMethodResponse.getInvalidFields().size());
        assertEquals(17, deletePayoutMethodResponse.getInvalidFields().get(0).getErrorCode().intValue());
        assertEquals("AccountHolderCode required", deletePayoutMethodResponse.getInvalidFields().get(0).getErrorDescription());
        assertNotNull(deletePayoutMethodResponse.getInvalidFields().get(0).getFieldType());
        assertEquals("accountHolderCode", deletePayoutMethodResponse.getInvalidFields().get(0).getFieldType().getField());
    }

    @Test
    public void TestRefundFundsTranferSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/fund/refund-funds-transfer-success.json");
        Fund fund = new Fund(client);
        RefundFundsTransferRequest refundFundsTransferRequest = new RefundFundsTransferRequest();
        refundFundsTransferRequest.setAmount(new Amount().value(1L).currency("EUR"));
        refundFundsTransferRequest.setMerchantReference("merchantReference");
        refundFundsTransferRequest.setOriginalReference("originalReference");
        RefundFundsTransferResponse refundFundsTransferResponse = fund.refundFundsTransfer(refundFundsTransferRequest);

        assertNotNull(refundFundsTransferResponse);
        assertEquals("Received", refundFundsTransferResponse.getResultCode());
        assertEquals("9115090773984130", refundFundsTransferResponse.getPspReference());
    }

    @Test
    public void TestRefundFundsTranferErrorInvalid() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/fund/refund-fund-transfer-error-invalid-fields.json");
        Fund fund = new Fund(client);
        RefundFundsTransferRequest refundFundsTransferRequest = new RefundFundsTransferRequest();
        refundFundsTransferRequest.setAmount(new Amount().value(1L).currency("EUR"));
        refundFundsTransferRequest.setMerchantReference("merchantReference");
        refundFundsTransferRequest.setOriginalReference("originalReference");
        RefundFundsTransferResponse refundFundsTransferResponse = fund.refundFundsTransfer(refundFundsTransferRequest);

        assertNotNull(refundFundsTransferResponse);
        assertEquals("8934084311505501", refundFundsTransferResponse.getPspReference());
        assertEquals(1, refundFundsTransferResponse.getInvalidFields().size());
        assertEquals(17, refundFundsTransferResponse.getInvalidFields().get(0).getErrorCode().intValue());
        assertEquals("MerchantReference required", refundFundsTransferResponse.getInvalidFields().get(0).getErrorDescription());
        assertNotNull(refundFundsTransferResponse.getInvalidFields().get(0).getFieldType());
        assertEquals("merchantReference", refundFundsTransferResponse.getInvalidFields().get(0).getFieldType().getField());
    }

    @Test
    public void TestTransferFundsErrorInvalid() throws Exception {
        // setup client
        Client client = createMockClientForErrors(400, "mocks/marketpay/fund/transfer-funds-error-invalid-fields.json");

        // use Fund service
        Fund fund = new Fund(client);

        // create TransferFunds Request
        TransferFundsRequest transferFundsRequest = new TransferFundsRequest();
        transferFundsRequest.setSourceAccountCode("invalidSourceAccount");
        transferFundsRequest.setDestinationAccountCode("invalidDestinationAccount");

        // create Amount
        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(2000L);
        transferFundsRequest.setAmount(amount);

        transferFundsRequest.setTransferCode("CODE_A");

        try {
            fund.transferFunds(transferFundsRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertEquals("8515898092864171", e.getError().getPspReference());
            List<ErrorFieldType> invalidFieldsList = e.getError().getInvalidFields();
            assertEquals(2, invalidFieldsList.size());
            assertEquals(new Integer(29), invalidFieldsList.get(0).getErrorCode());
            assertEquals("Account code does not exist or invalid", invalidFieldsList.get(0).getErrorDescription());
        }

    }
}
