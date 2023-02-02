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

import com.adyen.model.payments.Card;
import com.adyen.model.payments.FraudCheckResult;
import com.adyen.model.payments.PaymentRequest;
import com.adyen.model.payments.PaymentResult;
import com.adyen.model.additionalData.SplitPayment;
import com.adyen.model.additionalData.SplitPaymentItem;
import com.adyen.model.hop.GetOnboardingUrlRequest;
import com.adyen.model.hop.GetOnboardingUrlResponse;
import com.adyen.model.hop.OnboardingCollectInformation;
import com.adyen.model.hop.OnboardingShowPages;
import com.adyen.model.marketpay.*;
import com.adyen.service.Account;
import com.adyen.service.Fund;
import com.adyen.service.Hop;
import com.adyen.service.Payment;
import com.adyen.service.exception.ApiException;
import com.adyen.util.DateUtil;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.*;

import static com.adyen.constants.ApiConstants.AdditionalData.*;
import static com.adyen.model.marketpay.AccountEvent.EventEnum.INACTIVATEACCOUNT;
import static com.adyen.model.marketpay.KYCCheckStatusData.StatusEnum.AWAITING_DATA;
import static com.adyen.model.marketpay.KYCCheckStatusData.StatusEnum.PASSED;
import static com.adyen.model.marketpay.KYCCheckStatusData.TypeEnum.BANK_ACCOUNT_VERIFICATION;
import static com.adyen.model.marketpay.KYCCheckStatusData.TypeEnum.COMPANY_VERIFICATION;
import static com.adyen.model.marketpay.KYCCheckStatusData.TypeEnum.IDENTITY_VERIFICATION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

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

        PaymentRequest paymentRequest = createBasePaymentRequest(new PaymentRequest()).reference("123456");
        paymentRequest.setAmount(new com.adyen.model.payments.Amount().value(6200L).currency("EUR"));
        Card card = new Card();
        card.setExpiryMonth("08");
        card.setExpiryYear("2018");
        card.setHolderName("John Doe");
        card.setNumber("5136333333333335");
        card.setCvc("737");
        paymentRequest.setCard(card);

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

        // second split payment item
        SplitPaymentItem splitPaymentItem2 = new SplitPaymentItem();
        splitPaymentItem2.setAmount(200L);
        splitPaymentItem2.setType("Commission");
        splitPaymentItem2.setReference("6124146");
        splitPaymentItems.add(splitPaymentItem2);

        // add items to list
        splitPayment.setSplitPaymentItems(splitPaymentItems);

        // add it into the request
        setSplitPayment(paymentRequest, splitPayment);

        PaymentResult paymentResult = payment.authorise(paymentRequest);

        assertEquals("2", paymentRequest.getAdditionalData().get("split.nrOfItems"));
        assertEquals(PaymentResult.ResultCodeEnum.AUTHORISED, paymentResult.getResultCode());

        SimpleDateFormat format = new SimpleDateFormat("M/yyyy", Locale.ENGLISH);
        format.setTimeZone(TimeZone.getTimeZone("GMT"));

        Map<String, String> additionalData =  paymentResult.getAdditionalData();

        String expiryDate = additionalData.get(EXPIRY_DATE);
        assertEquals("8/2018", format.format(DateUtil.parseMYDate(expiryDate)));

        assertEquals("411111", additionalData.get(CARD_BIN));
        assertEquals("1111", additionalData.get(CARD_SUMMARY));
        assertEquals("Holder", additionalData.get(CARD_HOLDER_NAME));
        assertEquals("true", additionalData.get(THREE_D_OFFERERED));
        assertEquals("false", additionalData.get(THREE_D_AUTHENTICATED));
        assertEquals("69746", paymentResult.getAuthCode());

        assertEquals(11, paymentResult.getFraudResult().getResults().size());

        FraudCheckResult fraudCheckResult = paymentResult.getFraudResult().getResults().get(0);
        assertEquals("CardChunkUsage", fraudCheckResult.getName());
        assertEquals(8, fraudCheckResult.getAccountScore().intValue());
        assertEquals(2, fraudCheckResult.getCheckId().intValue());
    }

    /**
     * TODO publish this method in com.adyen.model.additionalData.SplitPayment?
     */
    protected void setSplitPayment(PaymentRequest paymentRequest, SplitPayment splitPayment) {
        Map<String, String> additionalData = paymentRequest.getAdditionalData() != null ?
                paymentRequest.getAdditionalData() : new HashMap<>();
        additionalData.put("split.api", splitPayment.getApi().toString());
        additionalData.put("split.totalAmount", splitPayment.getTotalAmount().toString());
        additionalData.put("split.currencyCode", splitPayment.getCurrencyCode());

        int count = 1;
        for (SplitPaymentItem splitPaymentItem : splitPayment.getSplitPaymentItems()) {
            String lineNumber = "split.item" + count;

            additionalData.put(lineNumber + ".amount", splitPaymentItem.getAmount().toString());
            additionalData.put(lineNumber + ".type", splitPaymentItem.getType());
            additionalData.put(lineNumber + ".account", splitPaymentItem.getAccount());
            additionalData.put(lineNumber + ".reference", splitPaymentItem.getReference());
            additionalData.put(lineNumber + ".description", splitPaymentItem.getDescription());

            count++;
        }
        additionalData.put("split.nrOfItems", Integer.toString(splitPayment.getSplitPaymentItems().size()));
        paymentRequest.setAdditionalData(additionalData);
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
        assertEquals(BANK_ACCOUNT_VERIFICATION, createAccountHolderResponse.getVerification().getBankAccounts().get(0).getChecks().get(0).getType());
        assertEquals(PASSED, createAccountHolderResponse.getVerification().getBankAccounts().get(0).getChecks().get(0).getStatus());
        assertEquals("705c2619-a9fb-48da-a121-c83fc37ee1cf", createAccountHolderResponse.getVerificationProfile());
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
        updateAccountHolderRequest.setVerificationProfile("a3029731-77ec-4cad-ae7d-9b9c38851ad6");

        UpdateAccountHolderResponse updateAccountHolderResponse = account.updateAccountHolder(updateAccountHolderRequest);

        assertEquals(49999L, updateAccountHolderResponse.getAccountHolderStatus().getPayoutState().getPayoutLimit().getValue().longValue());
        assertEquals("a3029731-77ec-4cad-ae7d-9b9c38851ad6", updateAccountHolderResponse.getVerificationProfile());
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
        assertEquals(IDENTITY_VERIFICATION, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getType());
        assertEquals(AWAITING_DATA, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getStatus());
        assertNotNull(getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getRequiredFields());
        assertEquals("AccountHolderDetails.Address.address", getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getRequiredFields().get(0));
        assertEquals("AccountHolderDetails.PhoneNumber.phoneNumber", getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getRequiredFields().get(1));
        assertEquals("d3d149a1-e39c-4b3a-8de3-da7b8f2cb3aa", getAccountHolderResponse.getVerificationProfile());
        assertEquals("6dc80830-c165-4087-aedc-afb53d2601a8", getAccountHolderResponse.getAccountHolderDetails().getBankAggregatorDataReference());
        assertEquals("Amsterdam", getAccountHolderResponse.getAccountHolderDetails().getPrincipalBusinessAddress().getCity());
        assertEquals("NL", getAccountHolderResponse.getAccountHolderDetails().getPrincipalBusinessAddress().getCountry());
        assertEquals("12345", getAccountHolderResponse.getAccountHolderDetails().getPrincipalBusinessAddress().getPostalCode());
        assertEquals("TestMerchant1", getAccountHolderResponse.getAccountHolderDetails().getStoreDetails().get(0).getMerchantAccount());
        assertEquals("Other", getAccountHolderResponse.getAccountHolderDetails().getStoreDetails().get(0).getMerchantCategoryCode());
        assertEquals("611223344", getAccountHolderResponse.getAccountHolderDetails().getStoreDetails().get(0).getPhoneNumber().getPhoneNumber());
        assertEquals(INACTIVATEACCOUNT, getAccountHolderResponse.getAccountHolderStatus().getEvents().get(0).getEvent());
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
        assertEquals("69620", getAccountHolderResponse.getAccountHolderDetails().getBusinessDetails().getSignatories().get(0).getAddress().getPostalCode());
        assertEquals("115548513", getAccountHolderResponse.getAccounts().get(0).getAccountCode());
        assertEquals(COMPANY_VERIFICATION, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getType());
        assertEquals(PASSED, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getStatus());
        assertEquals(1602, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getSummary().getKycCheckCode().intValue());
        assertEquals("Passed", getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getSummary().getKycCheckDescription());
        assertEquals("FBAR", getAccountHolderResponse.getAccountHolderDetails().getBusinessDetails().getStockExchange());
        assertEquals("F1234", getAccountHolderResponse.getAccountHolderDetails().getBusinessDetails().getStockNumber());
        assertEquals("TCOM", getAccountHolderResponse.getAccountHolderDetails().getBusinessDetails().getStockTicker());
        assertEquals("b8d970ca-8951-4997-afc1-c6de204ec561", getAccountHolderResponse.getAccounts().get(0).getBankAccountUUID());
        assertEquals("a8f392d1-7846-4a31-8c58-1b2e6abe8bb0", getAccountHolderResponse.getAccounts().get(0).getPayoutMethodCode());
        assertEquals(PayoutSpeedEnum.STANDARD, getAccountHolderResponse.getAccounts().get(0).getPayoutSpeed());
        assertEquals("Director", getAccountHolderResponse.getAccountHolderDetails().getBusinessDetails().getShareholders().get(0).getJobTitle());
        assertEquals("Director", getAccountHolderResponse.getAccountHolderDetails().getBusinessDetails().getSignatories().get(0).getJobTitle());
        assertEquals(ShareholderContact.ShareholderTypeEnum.CONTROLLER, getAccountHolderResponse.getAccountHolderDetails().getBusinessDetails().getShareholders().get(0).getShareholderType());
    }

    @Test
    public void TestGetBusinessAccountHolderWithParentSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/get-business-account-holder-with-parent-success.json");

        // use Account service
        Account account = new Account(client);

        // create GetAccountHolder Request
        GetAccountHolderRequest getAccountHolderRequest = new GetAccountHolderRequest();
        getAccountHolderRequest.setAccountHolderCode("TestAccountHolderUltimateParentCompany");

        GetAccountHolderResponse getAccountHolderResponse = account.getAccountHolder(getAccountHolderRequest);

        assertEquals("TestAccountHolderUltimateParentCompany", getAccountHolderResponse.getAccountHolderCode());
        assertEquals("25aee067-3560-4e16-83d6-0b6aa96e7e85", getAccountHolderResponse.getAccountHolderDetails().getBusinessDetails().getListedUltimateParentCompany().get(0).getUltimateParentCompanyCode());
        assertEquals("UPC Test Street", getAccountHolderResponse.getAccountHolderDetails().getBusinessDetails().getListedUltimateParentCompany().get(0).getAddress().getStreet());

        assertEquals(COMPANY_VERIFICATION, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getType());
        assertEquals(PASSED, getAccountHolderResponse.getVerification().getAccountHolder().getChecks().get(0).getStatus());

        assertEquals(COMPANY_VERIFICATION, getAccountHolderResponse.getVerification().getUltimateParentCompany().get(0).getChecks().get(0).getType());
        assertEquals(PASSED, getAccountHolderResponse.getVerification().getUltimateParentCompany().get(0).getChecks().get(0).getStatus());
        assertEquals("25aee067-3560-4e16-83d6-0b6aa96e7e85", getAccountHolderResponse.getVerification().getUltimateParentCompany().get(0).getUltimateParentCompanyCode());
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
        createAccountRequest.setBankAccountUUID("b8d970ca-8951-4997-afc1-c6de204ec561");
        createAccountRequest.setPayoutMethodCode("a8f392d1-7846-4a31-8c58-1b2e6abe8bb0");
        createAccountRequest.setPayoutSpeed(PayoutSpeedEnum.STANDARD);

        CreateAccountResponse createAccountResponse = account.createAccount(createAccountRequest);
        assertEquals("TestAccountHolder5691", createAccountResponse.getAccountHolderCode());
        assertEquals("Success", createAccountResponse.getResultCode());
        assertEquals("9914913130220156", createAccountResponse.getPspReference());
        assertEquals("195920946", createAccountResponse.getAccountCode());
        assertEquals(CreateAccountResponse.StatusEnum.ACTIVE, createAccountResponse.getStatus());
        assertEquals("b8d970ca-8951-4997-afc1-c6de204ec561", createAccountResponse.getBankAccountUUID());
        assertEquals("a8f392d1-7846-4a31-8c58-1b2e6abe8bb0", createAccountResponse.getPayoutMethodCode());
        assertEquals(PayoutSpeedEnum.STANDARD, createAccountResponse.getPayoutSpeed());
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
    public void TestDeleteSignatoriesSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/delete-signatories-success.json");

        // use Account service
        Account account = new Account(client);

        // create DeleteSignatories Request
        DeleteSignatoriesRequest deleteSignatoriesRequest = new DeleteSignatoriesRequest();
        deleteSignatoriesRequest.setAccountHolderCode("TestAccountHolder289429");
        deleteSignatoriesRequest.addSignatoryCodesItem("39b57c2d-d73b-400c-93de-708a51cd1f20");

        DeleteSignatoriesResponse deleteSignatoriesResponse = account.deleteSignatories(deleteSignatoriesRequest);
        assertEquals("8516284978974831", deleteSignatoriesResponse.getPspReference());
    }

    @Test
    public void TestDeleteSignatoriesInvalid() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/delete-signatories-error-invalid-fields.json");

        // use Account service
        Account account = new Account(client);

        // create DeleteSignatories Request
        DeleteSignatoriesRequest deleteSignatoriesRequest = new DeleteSignatoriesRequest();
        deleteSignatoriesRequest.setAccountHolderCode("TestAccountHolder289429");
        deleteSignatoriesRequest.addSignatoryCodesItem("9a2deb52-9832-45eb-8233-9bd8cc3ebb69");

        DeleteSignatoriesResponse deleteSignatoriesResponse = account.deleteSignatories(deleteSignatoriesRequest);
        assertEquals("8516284974139611", deleteSignatoriesResponse.getPspReference());
        assertEquals(1, deleteSignatoriesResponse.getInvalidFields().size());
        assertEquals(137, deleteSignatoriesResponse.getInvalidFields().get(0).getErrorCode().intValue());
        assertEquals("Signatory does not exist for signatoryCode: [9a2deb52-9832-45eb-8233-9bd8cc3ebb69]", deleteSignatoriesResponse.getInvalidFields().get(0).getErrorDescription());
        assertEquals("AccountHolderDetails.BusinessDetails.signatory", deleteSignatoriesResponse.getInvalidFields().get(0).getFieldType().getField());
        assertEquals(FieldType.FieldNameEnum.SIGNATORY, deleteSignatoriesResponse.getInvalidFields().get(0).getFieldType().getFieldName());
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
        assertEquals("118731451", closeAccountResponse.getAccountCode());
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
    public void TestCloseStoresSuccess() throws Exception {
        // setup client
        Client client = createMockClientFromFile("mocks/marketpay/account/close-stores-success.json");

        // use account service
        Account account = new Account(client);

        // create CloseStores Request
        CloseStoresRequest closeStoresRequest = new CloseStoresRequest();
        closeStoresRequest.setAccountHolderCode("TestAccountHolder1998");

        GenericResponse genericResponse = account.closeStores(closeStoresRequest);
        assertEquals("9918713476670992", genericResponse.getPspReference());
        assertEquals("Success", genericResponse.getResultCode());
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

        payoutAccountHolderRequest.setPayoutSpeed(PayoutSpeedEnum.STANDARD);

        PayoutAccountHolderResponse payoutAccountHolderResponse = fund.payoutAccountHolder(payoutAccountHolderRequest);
        assertEquals("testbankaccount", payoutAccountHolderResponse.getBankAccountUUID());
        assertEquals(PayoutSpeedEnum.STANDARD, payoutAccountHolderResponse.getPayoutSpeed());
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

        updateAccountRequest.setBankAccountUUID("b8d970ca-8951-4997-afc1-c6de204ec561");
        updateAccountRequest.setPayoutMethodCode("a8f392d1-7846-4a31-8c58-1b2e6abe8bb0");
        updateAccountRequest.setPayoutSpeed(PayoutSpeedEnum.STANDARD);

        UpdateAccountResponse updateAccountResponse = account.updateAccount(updateAccountRequest);
        assertEquals(PayoutScheduleResponse.ScheduleEnum.WEEKLY, updateAccountResponse.getPayoutSchedule().getSchedule());
        assertEquals("b8d970ca-8951-4997-afc1-c6de204ec561", updateAccountResponse.getBankAccountUUID());
        assertEquals("a8f392d1-7846-4a31-8c58-1b2e6abe8bb0", updateAccountResponse.getPayoutMethodCode());
        assertEquals(PayoutSpeedEnum.STANDARD, updateAccountResponse.getPayoutSpeed());

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

    @Test
    public void TestGetOnboardingUrlSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/hop/get-onboarding-url-success.json");
        Hop hop = new Hop(client);
        GetOnboardingUrlRequest getOnboardingUrlRequest = new GetOnboardingUrlRequest();
        getOnboardingUrlRequest.setAccountHolderCode("accountHolderCode");
        getOnboardingUrlRequest.setReturnUrl("myReturnUrl");
        getOnboardingUrlRequest.setShopperLocale("en_GB");

        OnboardingShowPages onboardingShowPages = new OnboardingShowPages();
        onboardingShowPages.setWelcomePage(true);
        onboardingShowPages.setIndividualDetailsSummaryPage(true);
        onboardingShowPages.setBusinessDetailsSummaryPage(true);
        onboardingShowPages.setBankDetailsSummaryPage(false);
        onboardingShowPages.setShareholderDetailsSummaryPage(false);
        onboardingShowPages.setLegalArrangementsDetailsSummaryPage(true);
        getOnboardingUrlRequest.setShowPages(onboardingShowPages);

        OnboardingCollectInformation onboardingCollectInformation = new OnboardingCollectInformation();
        onboardingCollectInformation.setIndividualDetails(true);
        onboardingCollectInformation.setBusinessDetails(true);
        onboardingCollectInformation.setBankDetails(false);
        onboardingCollectInformation.setLegalArrangementDetails(false);
        onboardingCollectInformation.setPciQuestionnaire(false);
        onboardingCollectInformation.setShareholderDetails(false);
        getOnboardingUrlRequest.setCollectInformation(onboardingCollectInformation);

        GetOnboardingUrlResponse getOnboardingUrlResponse = hop.getOnboardingUrl(getOnboardingUrlRequest);

        assertEquals("8115977378312467", getOnboardingUrlResponse.getPspReference());
        assertEquals("Success", getOnboardingUrlResponse.getResultCode());
        assertEquals("https://hop-test.adyen.com/hop/view/?token=4RM8ODUVTPR9qvpICDgShWhmB...", getOnboardingUrlResponse.getRedirectUrl());
    }

    @Test
    public void TestGetTaxFormSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/marketpay/account/get-tax-form-success.json");
        Account account = new Account(client);
        GetTaxFormRequest getTaxFormRequest = new GetTaxFormRequest();
        getTaxFormRequest.setAccountHolderCode("accountHolderCode");
        getTaxFormRequest.setFormType("myReturnUrl");
        getTaxFormRequest.setYear(2020);
        GetTaxFormResponse getTaxFormResponse = account.getTaxForm(getTaxFormRequest);

        assertEquals("JVBERi0xLjMNCjEgMCBvYmoNCjw8D....", getTaxFormResponse.getContent());
        assertEquals("8115977378312467", getTaxFormResponse.getPspReference());
        assertEquals("application/pdf", getTaxFormResponse.getContentType());
    }
}
