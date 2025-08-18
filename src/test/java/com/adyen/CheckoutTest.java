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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

import com.adyen.constants.ApiConstants;
import com.adyen.enums.Environment;
import com.adyen.model.checkout.*;
import com.adyen.service.checkout.*;
import com.fasterxml.jackson.databind.JsonNode;
import java.time.OffsetDateTime;
import java.util.*;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

public class CheckoutTest extends BaseTest {

  /** Should make a payment */
  @Test
  public void TestPaymentSuccess() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/paymentResponse.json");
    Amount amount = new Amount().currency("EUR").value(1000L);
    CardDetails cardDetails = new CardDetails();
    cardDetails
        .encryptedCardNumber("5136333333333335")
        .holderName("John Doe")
        .cvc("737")
        .encryptedExpiryMonth("08")
        .encryptedExpiryYear("2018");
    cardDetails.setType(CardDetails.TypeEnum.SCHEME);
    PaymentRequest paymentRequest = new PaymentRequest();
    paymentRequest.setAmount(amount);
    paymentRequest.setPaymentMethod(new CheckoutPaymentMethod(cardDetails));
    PaymentsApi checkout = new PaymentsApi(client);
    PaymentResponse paymentResponse = checkout.payments(paymentRequest);
    assertEquals("993617895204576J", paymentResponse.getPspReference());
    assertEquals(
        CheckoutRedirectAction.TypeEnum.REDIRECT,
        paymentResponse.getAction().getCheckoutRedirectAction().getType());
    assertEquals(
        "https://checkoutshopper-test.adyen.com/checkoutshopper/threeDS/redirect?MD=M2R...",
        paymentResponse.getAction().getCheckoutRedirectAction().getUrl());
  }

  /**
   * Should be able to stringify and parse paymentMethod in CheckoutPaymentRequest (test oneOf
   * serialization and deserialization)
   */
  @Test
  public void TestDeserializePaymentRequestIdeal() throws Exception {
    String paymentRequestJson = getFileContents("mocks/checkout/paymentRequestIdeal.json");

    PaymentRequest parsedCheckoutPaymentRequest = PaymentRequest.fromJson(paymentRequestJson);

    // paymentMethod
    assertEquals(
        IdealDetails.TypeEnum.IDEAL,
        parsedCheckoutPaymentRequest.getPaymentMethod().getIdealDetails().getType());
    // amount
    assertEquals(1000L, parsedCheckoutPaymentRequest.getAmount().getValue().longValue());
    assertEquals("EUR", parsedCheckoutPaymentRequest.getAmount().getCurrency());
    // merchant account
    assertEquals("myMerchantAccount", parsedCheckoutPaymentRequest.getMerchantAccount());
    // reference
    assertEquals("merchantReference", parsedCheckoutPaymentRequest.getReference());
    // return url
    assertEquals("https://your-company.com/..", parsedCheckoutPaymentRequest.getReturnUrl());
  }

  /** Deserialise CardDetails (scheme) */
  @Test
  public void TestDeserializePaymentRequestScheme() throws Exception {
    String paymentRequestJson = getFileContents("mocks/checkout/paymentRequestScheme.json");

    PaymentRequest parsedCheckoutPaymentRequest = PaymentRequest.fromJson(paymentRequestJson);
    assertNotNull(parsedCheckoutPaymentRequest.getPaymentMethod());
    assertEquals(
        CardDetails.TypeEnum.SCHEME,
        parsedCheckoutPaymentRequest.getPaymentMethod().getCardDetails().getType());
    assertEquals(
        "2.4.2",
        parsedCheckoutPaymentRequest.getPaymentMethod().getCardDetails().getThreeDS2SdkVersion());
    // verify un-encrypted fields are empty
    assertNull(parsedCheckoutPaymentRequest.getPaymentMethod().getCardDetails().getNumber());
    assertNull(parsedCheckoutPaymentRequest.getPaymentMethod().getCardDetails().getCvc());
    // verify encrypted fields are correct
    assertNotNull(
        parsedCheckoutPaymentRequest.getPaymentMethod().getCardDetails().getEncryptedCardNumber());
    assertEquals(
        "eyJhbGciOiJSU0EtT0FFUC0yNTYiLCJlbmMiOiJBMjU2Q0JDLUhTNTEyIiwidmVyc2lvbiI6IjEifQ.DXQDEl3M"
            + "dyyW_ZrJoF2Kt3P1H2wWaP1z-FgI6SuDv96lN7e_0ki0mUkI8AL2USS_iiMbG5W4NtD4Ut5TqCBPlgOZfN6vDyM8O6Df-"
            + "qNbX7rnW9iQQUue_21oo6U9K2tpFEQ9rYgUVIFhfLdFmLZ4q8ejmXFSGuTh-iC06APs2zWdUn0v-S4q4ltAzhee_5yOvff"
            + "oSCWOWiGltUqViVOnrllheH-POp4qfL9GbaIkjixPyLNLRizQTrOO_j3m0gczeiORcrjXI2NSouSkPP9M1K9nwUWX-jpVTf"
            + "1PkqLTYRzGQwZCoL9JU9HabRXYdM_eLMtNaIfiBo_4wPq5Iocmww",
        parsedCheckoutPaymentRequest.getPaymentMethod().getCardDetails().getEncryptedCardNumber());
  }

  /** Should make paymentMethods call */
  @Test
  public void TestPaymentMethodsSuccess() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/paymentMethodsResponse.json");
    PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
    paymentMethodsRequest.setMerchantAccount("myMerchantAccount");
    PaymentsApi checkout = new PaymentsApi(client);
    PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);
    assertEquals(1, paymentMethodsResponse.getPaymentMethods().size());
    assertEquals("klarna", paymentMethodsResponse.getPaymentMethods().get(0).getType());
  }

  /** Should make paymentLink call */
  @Test
  public void TestPaymentLinkSuccess() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/paymentLinkResponse.json");
    PaymentLinkRequest createPaymentLinkRequest = new PaymentLinkRequest();
    Amount amount = new Amount().currency("EUR").value(500L);
    createPaymentLinkRequest.setAmount(amount);
    createPaymentLinkRequest.setMerchantAccount("myMerchantAccount");
    createPaymentLinkRequest.setReference("merchantReference");
    LineItem lineItem = new LineItem();
    lineItem.setBrand("brand");
    lineItem.setColor("color");
    List<LineItem> lineItemList = new ArrayList<>();
    lineItemList.add(lineItem);
    createPaymentLinkRequest.setLineItems(lineItemList);
    PaymentLinksApi checkout = new PaymentLinksApi(client);
    PaymentLinkResponse paymentLinkResponse = checkout.paymentLinks(createPaymentLinkRequest);
    assertEquals("https://test.adyen.link/PL6DB3157D27FFBBCF", paymentLinkResponse.getUrl());
    assertEquals(PaymentLinkResponse.StatusEnum.ACTIVE, paymentLinkResponse.getStatus());
  }

  /** Should make paymentLink get call */
  @Test
  public void TestGetPaymentLinkSuccess() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/getPaymentLinkResponse.json");

    PaymentLinksApi checkout = new PaymentLinksApi(client);
    PaymentLinkResponse paymentLinkResponse = checkout.getPaymentLink("linkId");
    assertEquals("shopper-reference", paymentLinkResponse.getReference());
    assertEquals(PaymentLinkResponse.StatusEnum.EXPIRED, paymentLinkResponse.getStatus());
  }

  /** Should make paymentLink patch call */
  @Test
  public void TestPatchPaymentLinkSuccess() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/patchPaymentLinkResponse.json");

    UpdatePaymentLinkRequest updatePaymentLinkRequest = new UpdatePaymentLinkRequest();
    updatePaymentLinkRequest.setStatus(UpdatePaymentLinkRequest.StatusEnum.EXPIRED);
    PaymentLinksApi checkout = new PaymentLinksApi(client);
    PaymentLinkResponse paymentLinkResponse =
        checkout.updatePaymentLink("linkId", updatePaymentLinkRequest);
    assertEquals("shopper-reference", paymentLinkResponse.getReference());
    assertEquals(PaymentLinkResponse.StatusEnum.EXPIRED, paymentLinkResponse.getStatus());
  }

  /** Should make payments/details call */
  @Test
  public void TestPaymentDetailsSuccess() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/paymentDetailsResponse.json");
    PaymentDetailsRequest detailsRequest = new PaymentDetailsRequest();
    detailsRequest.setPaymentData("STATE_DATA");
    PaymentsApi checkout = new PaymentsApi(client);
    PaymentDetailsResponse paymentDetailsResponse = checkout.paymentsDetails(detailsRequest);
    assertEquals(
        PaymentDetailsResponse.ResultCodeEnum.AUTHORISED, paymentDetailsResponse.getResultCode());
    assertEquals("V4HZ4RBFJGXXGN82", paymentDetailsResponse.getPspReference());
  }

  @Test
  public void TestPaymentDetailsWithThreeDSRequestorChallengeInd() throws Exception {
    Client client =
        createMockClientFromFile(
            "mocks/checkout/paymentDetailsResponseThreeDSRequestorChallengeInd.json");
    PaymentDetailsRequest detailsRequest = new PaymentDetailsRequest();
    detailsRequest.setPaymentData("STATE_DATA");
    PaymentsApi checkout = new PaymentsApi(client);

    PaymentDetailsResponse paymentDetailsResponse = checkout.paymentsDetails(detailsRequest);

    assertEquals(
        PaymentDetailsResponse.ResultCodeEnum.REFUSED, paymentDetailsResponse.getResultCode());
    assertEquals(
        ThreeDS2Result.ThreeDSRequestorChallengeIndEnum._01,
        paymentDetailsResponse.getThreeDS2Result().getThreeDSRequestorChallengeInd());
  }

  @Test
  public void TestPaymentDetailsWithThreeDS2Action() throws Exception {
    Client client =
        createMockClientFromFile("mocks/checkout/paymentDetailsResponseThreeDS2Action.json");
    PaymentDetailsRequest detailsRequest = new PaymentDetailsRequest();
    detailsRequest.setPaymentData("STATE_DATA");
    PaymentsApi checkout = new PaymentsApi(client);
    PaymentDetailsResponse paymentDetailsResponse = checkout.paymentsDetails(detailsRequest);
    assertEquals(
        PaymentDetailsResponse.ResultCodeEnum.CHALLENGESHOPPER,
        paymentDetailsResponse.getResultCode());
    assertNotNull(paymentDetailsResponse.getAction());
    assertNotNull(paymentDetailsResponse.getAction().getCheckoutThreeDS2Action());
    assertEquals(
        CheckoutThreeDS2Action.TypeEnum.THREEDS2,
        paymentDetailsResponse.getAction().getCheckoutThreeDS2Action().getType());
    assertEquals(
        "challenge", paymentDetailsResponse.getAction().getCheckoutThreeDS2Action().getSubtype());
  }

  /** Should make sessions call */
  @Test
  public void TestCreateSessionsSuccessCall() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/createSessionsResponse.json");
    CreateCheckoutSessionRequest sessionRequest = new CreateCheckoutSessionRequest();
    sessionRequest.setReturnUrl("https://your-company.com/checkout?shopperOrder=12xy..");
    sessionRequest.setCountryCode("NL");
    sessionRequest.setReference("YOUR_PAYMENT_REFERENCE");
    sessionRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
    Amount amount = new Amount().currency("EUR").value(100L);
    sessionRequest.setAmount(amount);
    PaymentsApi checkout = new PaymentsApi(client);
    CreateCheckoutSessionResponse createCheckoutSessionResponse = checkout.sessions(sessionRequest);
    assertEquals(
        "Ab02b4c0!BFHSPFBQTEwM0NBNTM3RfCf5", createCheckoutSessionResponse.getSessionData());
    assertEquals("CS1453E3730C313478", createCheckoutSessionResponse.getId());
    assertEquals(
        CreateCheckoutSessionResponse.ModeEnum.EMBEDDED, createCheckoutSessionResponse.getMode());
    assertEquals(
        CreateCheckoutSessionResponse.StorePaymentMethodModeEnum.ASKFORCONSENT,
        createCheckoutSessionResponse.getStorePaymentMethodMode());
  }

  /** Should make orders call */
  @Test
  public void TestCreateOrderSuccessCall() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/createOrderResponse.json");
    CreateOrderRequest checkoutCreateOrderRequest = new CreateOrderRequest();
    Amount amount = new Amount().currency("EUR").value(2500L);
    checkoutCreateOrderRequest.setAmount(amount);
    checkoutCreateOrderRequest.setReference("YOUR_ORDER_REFERENCE");
    checkoutCreateOrderRequest.setMerchantAccount("YOUR_MERCHANT_ACOUNT");
    OrdersApi checkout = new OrdersApi(client);
    CreateOrderResponse checkoutCreateOrderResponse = checkout.orders(checkoutCreateOrderRequest);
    assertEquals("8616178914061985", checkoutCreateOrderResponse.getPspReference());
    assertEquals("Abzt3JH4wnzErMnOZwSdgA==", checkoutCreateOrderResponse.getOrderData());
  }

  @Test
  public void TestCancelOrderSuccessCall() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/cancelOrderResponse.json");
    CancelOrderRequest checkoutCancelOrderRequest = new CancelOrderRequest();
    checkoutCancelOrderRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
    EncryptedOrderData encryptedOrderData = new EncryptedOrderData();
    encryptedOrderData.setPspReference("8815517812932012");
    encryptedOrderData.setOrderData("823fh892f8f18f4...148f13f9f3f");
    checkoutCancelOrderRequest.setOrder(encryptedOrderData);
    OrdersApi checkout = new OrdersApi(client);
    CancelOrderResponse checkoutCancelOrderResponse =
        checkout.cancelOrder(checkoutCancelOrderRequest);
    assertEquals(
        CancelOrderResponse.ResultCodeEnum.RECEIVED, checkoutCancelOrderResponse.getResultCode());
    assertEquals("8816178914079738", checkoutCancelOrderResponse.getPspReference());
  }

  /** Should make applePaySessions call */
  @Test
  public void TestApplePaySessionsSuccessCall() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/applePaySessionsResponse.json");
    ApplePaySessionRequest createApplePaySessionRequest = new ApplePaySessionRequest();
    createApplePaySessionRequest.setDisplayName("YOUR_MERCHANT_NAME");
    createApplePaySessionRequest.setDomainName("YOUR_DOMAIN_NAME");
    createApplePaySessionRequest.setMerchantIdentifier("YOUR_MERCHANT_ID");
    UtilityApi checkout = new UtilityApi(client);
    ApplePaySessionResponse applePaySessionResponse =
        checkout.getApplePaySession(createApplePaySessionRequest);
    assertEquals("eyJ2Z", applePaySessionResponse.getData());
  }

  /** Should make donations call */
  @Test
  public void TestDonationsSuccessCall() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/donationResponse.json");
    DonationPaymentRequest paymentDonationRequest = new DonationPaymentRequest();
    Amount amount = new Amount().currency("EUR").value(1000L);
    paymentDonationRequest.setAmount(amount);
    paymentDonationRequest.setDonationAccount("YOUR_DONATION_ACCOUNT");
    paymentDonationRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
    CardDonations cardDetails = new CardDonations().type(CardDonations.TypeEnum.SCHEME);
    paymentDonationRequest.paymentMethod(new DonationPaymentMethod(cardDetails));
    paymentDonationRequest.setReference("YOUR_MERCHANT_REFERENCE");
    paymentDonationRequest.setReturnUrl("https://your-company.com/...");
    DonationsApi donationsApi = new DonationsApi(client);
    DonationPaymentResponse donationResponse = donationsApi.donations(paymentDonationRequest);
    assertEquals(
        PaymentResponse.ResultCodeEnum.AUTHORISED, donationResponse.getPayment().getResultCode());
    assertEquals("UNIQUE_RESOURCE_ID", donationResponse.getId());
    assertEquals(DonationPaymentResponse.StatusEnum.COMPLETED, donationResponse.getStatus());
  }

  /** Should make paymentUpdateAmount call */
  @Test
  public void TestPaymenUpdateAmountSuccessCall() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/paymentUpdateAmountResponse.json");
    ModificationsApi checkout = new ModificationsApi(client);
    PaymentAmountUpdateRequest createPaymentAmountUpdateRequest = new PaymentAmountUpdateRequest();
    createPaymentAmountUpdateRequest.setIndustryUsage(
        PaymentAmountUpdateRequest.IndustryUsageEnum.DELAYEDCHARGE);
    PaymentAmountUpdateResponse paymentAmountUpdateResource =
        checkout.updateAuthorisedAmount("pspRef", createPaymentAmountUpdateRequest);
    assertEquals(
        PaymentAmountUpdateResponse.IndustryUsageEnum.DELAYEDCHARGE,
        paymentAmountUpdateResource.getIndustryUsage());
    assertEquals("1234567890", paymentAmountUpdateResource.getPaymentPspReference());
    assertEquals(
        PaymentAmountUpdateResponse.StatusEnum.RECEIVED, paymentAmountUpdateResource.getStatus());
  }

  /** Should make cardDetails call */
  @Test
  public void TestCardDetailsRequestSuccess() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/cardDetailsResponse.json");
    CardDetailsRequest cardDetailsRequest = new CardDetailsRequest();
    cardDetailsRequest.setCardNumber("123412341234");
    cardDetailsRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
    PaymentsApi checkout = new PaymentsApi(client);
    CardDetailsResponse cardDetailsResponse = checkout.cardDetails(cardDetailsRequest);
    assertEquals(2, cardDetailsResponse.getBrands().size());
    assertEquals("visa", cardDetailsResponse.getBrands().get(0).getType());
    assertEquals(true, cardDetailsResponse.getBrands().get(0).getSupported());
  }

  /** Should properly (de)serialize Dates */
  @Test
  public void TestDateSerialization() throws Exception {
    BalanceCheckRequest checkoutBalanceCheckRequest = new BalanceCheckRequest();
    OffsetDateTime date =
        OffsetDateTime.parse(
            "2022-10-11T15:08:27.000Z"); // Tuesday, October 11, 2022 5:08:27 PM GMT+02:00 DST
    checkoutBalanceCheckRequest.setDateOfBirth(date.toLocalDate());
    Amount amount = new Amount().currency("EUR").value(1000L);
    checkoutBalanceCheckRequest.setAmount(amount);
    checkoutBalanceCheckRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
    checkoutBalanceCheckRequest.setReference("YOUR_MERCHANT_REFERENCE");
    Map<String, String> paymentMethod = new HashMap<>();
    checkoutBalanceCheckRequest.setPaymentMethod(paymentMethod);
    String checkoutBalanceRequestJson = checkoutBalanceCheckRequest.toJson();
    assert (checkoutBalanceRequestJson.contains("\"dateOfBirth\":\"2022-10-11\""));
    assertEquals(
        date.toLocalDate(),
        BalanceCheckRequest.fromJson(checkoutBalanceRequestJson).getDateOfBirth());
  }

  /** Should get StoredPaymentMethods */
  @Test
  public void TestGetStoredPaymentMethods() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/getStoredPaymentMethodResponse.json");
    RecurringApi checkout = new RecurringApi(client);
    ListStoredPaymentMethodsResponse response =
        checkout.getTokensForStoredPaymentDetails("test-1234", "TestMerchantAccount", null);
    Assert.assertEquals("merchantAccount", response.getMerchantAccount());
    Assert.assertEquals("string", response.getStoredPaymentMethods().get(0).getBrand());
  }

  /** Should delete StoredPaymentMethods */
  @Test
  public void TestDeleteStoredPaymentMethods() throws Exception {
    Client client =
        createMockClientFromFile("mocks/checkout/deleteStoredPaymentMethodResponse.json");
    RecurringApi checkout = new RecurringApi(client);
    checkout.deleteTokenForStoredPaymentDetails("recurringId", "test-1234", "TestMerchantAccount");
  }

  /** Should delete StoredPaymentMethods */
  @Test
  public void TestLiveURLCheckout() throws Exception {
    Config config = new Config();
    config.setLiveEndpointUrlPrefix("prefix");
    config.setEnvironment(Environment.LIVE);
    Client client =
        createMockClientFromFile("mocks/checkout/deleteStoredPaymentMethodResponse.json");
    client.setConfig(config);
    RecurringApi checkout = new RecurringApi(client);
    checkout.deleteTokenForStoredPaymentDetails("recurringId", "test-1234", "TestMerchantAccount");
    HashMap<String, String> queryParams = new HashMap<>();
    queryParams.put("merchantAccount", "TestMerchantAccount");
    queryParams.put("shopperReference", "test-1234");

    verify(client.getHttpClient())
        .request(
            "https://prefix-checkout-live.adyenpayments.com/checkout/v71/storedPaymentMethods/recurringId",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.DELETE,
            queryParams);
  }

  @Test
  public void TestLiveURLCheckoutWithSetEnviroment() throws Exception {
    Client client =
        createMockClientFromFile("mocks/checkout/deleteStoredPaymentMethodResponse.json");
    client.setEnvironment(Environment.LIVE, "prefix");
    RecurringApi checkout = new RecurringApi(client);
    checkout.deleteTokenForStoredPaymentDetails("recurringId", "test-1234", "TestMerchantAccount");
    HashMap<String, String> queryParams = new HashMap<>();
    queryParams.put("merchantAccount", "TestMerchantAccount");
    queryParams.put("shopperReference", "test-1234");

    verify(client.getHttpClient())
        .request(
            "https://prefix-checkout-live.adyenpayments.com/checkout/v71/storedPaymentMethods/recurringId",
            null,
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.DELETE,
            queryParams);
  }

  @Test
  public void TestCheckoutPaymentMethodSerialisation() throws Exception {
    // Checks that unknown parameters (in this case googlePayCardNetwork) in oneOf classes are not
    // strict and will
    // not throw an error.
    CheckoutPaymentMethod checkoutPaymentMethodGoogle =
        CheckoutPaymentMethod.fromJson(
            "{\n"
                + "    \"type\": \"paywithgoogle\",\n"
                + "    \"googlePayToken\": \"==Payload as retrieved from Google Pay response==\",\n"
                + "    \"googlePayCardNetwork\": \"not supposed to be here\"\n"
                + "  }");

    CheckoutPaymentMethod checkoutPaymentMethodScheme =
        CheckoutPaymentMethod.fromJson(
            "{\n"
                + "    \"type\": \"scheme\",\n"
                + "    \"number\": \"4111111111111111\",\n"
                + "    \"cvc\": \"737\",\n"
                + "    \"expiryMonth\": \"03\",\n"
                + "    \"expiryYear\": \"2030\",\n"
                + "    \"holderName\": \"John Smith\",\n"
                + "    \"someMumboJumbo\": \"value\"\n"
                + "  }");

    CheckoutPaymentMethod checkoutPaymentMethodApple =
        CheckoutPaymentMethod.fromJson(
            "{\n"
                + "    \"type\": \"applepay\",\n"
                + "    \"applePayToken\": \"VNRWtuNlNEWkRCSm1xWndjMDFFbktkQU...\"\n"
                + "  }");

    Assert.assertTrue(checkoutPaymentMethodGoogle.toJson().contains("paywithgoogle"));
    Assert.assertTrue(checkoutPaymentMethodGoogle.toJson().contains("googlePayToken"));
    Assert.assertTrue(checkoutPaymentMethodScheme.toJson().contains("scheme"));
    Assert.assertTrue(
        checkoutPaymentMethodApple.toJson().contains("NRWtuNlNEWkRCSm1xWndjMDFFbktkQU"));
  }

  @Test
  public void TestPaymentWithRatepay() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/paymentResponseRatepay.json");

    RatepayDetails ratepayDetails =
        new RatepayDetails().type(RatepayDetails.TypeEnum.RATEPAY_DIRECTDEBIT);

    PaymentRequest paymentRequest =
        new PaymentRequest()
            .paymentMethod(new CheckoutPaymentMethod(ratepayDetails))
            .amount(new Amount().currency("EUR").value(700L))
            .shopperName(new Name().firstName("Simon").lastName("Hopper"))
            .telephoneNumber("+31858888138")
            .shopperEmail("s.hopper@example.com")
            .billingAddress(
                new BillingAddress()
                    .country("NL")
                    .city("Amsterdam")
                    .houseNumberOrName("6-50")
                    .street("Simon Carmiggeltstraat")
                    .postalCode("1011 DJ"))
            .deviceFingerprint("eyJ2ZXJzaW9uIjoiMS4wLjAiLCJkZXZ...")
            .lineItems(
                Arrays.asList(
                    new LineItem()
                        .quantity(1L)
                        .amountExcludingTax(331L)
                        .taxPercentage(2100L)
                        .description("Shoes")
                        .id("Item #1")
                        .taxAmount(69L)
                        .amountIncludingTax(400L),
                    new LineItem()
                        .quantity(2L)
                        .amountExcludingTax(248L)
                        .taxPercentage(2100L)
                        .description("Socks")
                        .id("Item #2")
                        .taxAmount(52L)
                        .amountIncludingTax(300L)))
            .bankAccount(
                new CheckoutBankAccount()
                    .countryCode("NL")
                    .iban("NL13TEST0123456789")
                    .ownerName("Simon Hopper"));
    paymentRequest.setPaymentMethod(new CheckoutPaymentMethod(ratepayDetails));
    PaymentsApi checkout = new PaymentsApi(client);
    PaymentResponse paymentResponse = checkout.payments(paymentRequest);

    assertEquals("881567437271705K", paymentResponse.getPspReference());
    assertEquals(PaymentResponse.ResultCodeEnum.AUTHORISED, paymentResponse.getResultCode());
    assertNotNull(paymentResponse.getAdditionalData());

    verify(client.getHttpClient())
        .request(
            "https://checkout-test.adyen.com/v71/payments",
            paymentRequest.toJson(),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void TestPaymentWithRiverty() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/paymentResponseRiverty.json");

    RivertyDetails rivertyDetails =
        new RivertyDetails()
            .type(RivertyDetails.TypeEnum.SEPADIRECTDEBIT_RIVERTY)
            .iban("NL13TEST0123456789");

    PaymentRequest paymentRequest =
        new PaymentRequest()
            .paymentMethod(new CheckoutPaymentMethod(rivertyDetails))
            .amount(new Amount().currency("EUR").value(700L))
            .shopperName(new Name().firstName("Simon").lastName("Hopper"))
            .telephoneNumber("+31858888138")
            .shopperIP("123.123.123.123")
            .shopperEmail("s.hopper@example.com")
            .billingAddress(
                new BillingAddress()
                    .country("NL")
                    .city("Amsterdam")
                    .houseNumberOrName("6-50")
                    .street("Simon Carmiggeltstraat")
                    .postalCode("1011 DJ"))
            .deliveryAddress(
                new DeliveryAddress()
                    .country("NL")
                    .city("Amsterdam")
                    .houseNumberOrName("6-50")
                    .street("Simon Carmiggeltstraat")
                    .postalCode("1011 DJ"))
            .deviceFingerprint("eyJ2ZXJzaW9uIjoiMS4wLjAiLCJkZXZ...")
            .lineItems(
                Arrays.asList(
                    new LineItem()
                        .quantity(1L)
                        .amountExcludingTax(331L)
                        .taxPercentage(2100L)
                        .description("Shoes")
                        .id("Item #1")
                        .taxAmount(69L)
                        .amountIncludingTax(400L),
                    new LineItem()
                        .quantity(2L)
                        .amountExcludingTax(248L)
                        .taxPercentage(2100L)
                        .description("Socks")
                        .id("Item #2")
                        .taxAmount(52L)
                        .amountIncludingTax(300L)));
    PaymentsApi checkout = new PaymentsApi(client);
    PaymentResponse paymentResponse = checkout.payments(paymentRequest);

    assertNull(paymentResponse.getPspReference());
    assertEquals(PaymentResponse.ResultCodeEnum.REDIRECTSHOPPER, paymentResponse.getResultCode());
    assertEquals(
        CheckoutRedirectAction.TypeEnum.REDIRECT,
        paymentResponse.getAction().getCheckoutRedirectAction().getType());
    assertEquals(
        "https://checkoutshopper-test.adyen.com/checkoutshopper…",
        paymentResponse.getAction().getCheckoutRedirectAction().getUrl());

    verify(client.getHttpClient())
        .request(
            "https://checkout-test.adyen.com/v71/payments",
            paymentRequest.toJson(),
            client.getConfig(),
            false,
            null,
            ApiConstants.HttpMethod.POST,
            null);
  }

  @Test
  public void TestPaymentMethodsNullLists() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/paymentMethodsResponse.json");
    PaymentMethodsRequest paymentMethodsRequest = new PaymentMethodsRequest();
    paymentMethodsRequest.setMerchantAccount("myMerchantAccount");
    PaymentsApi checkout = new PaymentsApi(client);
    PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);

    assertEquals(1, paymentMethodsResponse.getPaymentMethods().size());
    // verify storedPaymentMethods list is null
    assertNull(paymentMethodsResponse.getStoredPaymentMethods());
  }

  @Test
  public void TestSessionsCheckDefaultValues() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/createSessionsResponse.json");
    CreateCheckoutSessionRequest sessionRequest = new CreateCheckoutSessionRequest();
    sessionRequest.setReturnUrl("https://your-company.com/checkout?shopperOrder=12xy..");
    sessionRequest.setCountryCode("NL");
    sessionRequest.setReference("YOUR_PAYMENT_REFERENCE");
    sessionRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
    Amount amount = new Amount().currency("EUR").value(100L);
    sessionRequest.setAmount(amount);
    PaymentsApi checkout = new PaymentsApi(client);
    CreateCheckoutSessionResponse createCheckoutSessionResponse = checkout.sessions(sessionRequest);
    assertEquals("CS1453E3730C313478", createCheckoutSessionResponse.getId());

    // check no attributes with default values are included (i.e. threeDSAuthenticationOnly)
    String EXPECTED_REQUEST_PAYLOAD =
        "{\"amount\":{\"currency\":\"EUR\",\"value\":100},"
            + "\"countryCode\":\"NL\",\"merchantAccount\":\"YOUR_MERCHANT_ACCOUNT\","
            + "\"reference\":\"YOUR_PAYMENT_REFERENCE\","
            + "\"returnUrl\":\"https://your-company.com/checkout?shopperOrder=12xy..\"}";

    final ArgumentCaptor<String> captor = ArgumentCaptor.forClass(String.class);
    verify(client.getHttpClient())
        .request(
            eq("https://checkout-test.adyen.com/v71/sessions"),
            captor.capture(),
            any(com.adyen.Config.class),
            eq(false),
            isNull(),
            eq(ApiConstants.HttpMethod.POST),
            isNull());

    // Comparing JSON
    final com.fasterxml.jackson.databind.ObjectMapper mapper =
        new com.fasterxml.jackson.databind.ObjectMapper();
    final JsonNode expected = mapper.readTree(EXPECTED_REQUEST_PAYLOAD);
    final JsonNode actual = mapper.readTree(captor.getValue());
    assertEquals(expected, actual);
  }

  @Test
  public void TestBccm() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/paymentResponseBcmc.json");
    PaymentRequest paymentRequest = new PaymentRequest();
    paymentRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
    paymentRequest.setReference("YOUR_ORDER_NUMBER");
    paymentRequest.setAmount(new Amount().currency("EUR").value(1000L));
    paymentRequest.setPaymentMethod(
        new CheckoutPaymentMethod(
            new CardDetails()
                .type(CardDetails.TypeEnum.BCMC)
                .holderName("Ms Smith")
                .encryptedCardNumber("...")
                .encryptedExpiryMonth("...")
                .encryptedExpiryYear("...")
                .brand("bcmc")
                .checkoutAttemptId("...")));
    PaymentsApi checkout = new PaymentsApi(client);
    PaymentResponse paymentResponse = checkout.payments(paymentRequest);
    assertEquals(PaymentResponse.ResultCodeEnum.REDIRECTSHOPPER, paymentResponse.getResultCode());
    assertNotNull(paymentResponse.getAction());
  }

  @Test
  public void TestBccmMobile() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/paymentResponseBcmcMobile.json");
    PaymentRequest paymentRequest = new PaymentRequest();
    paymentRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
    paymentRequest.setReference("YOUR_ORDER_NUMBER");
    paymentRequest.setAmount(new Amount().currency("EUR").value(1000L));
    paymentRequest.setPaymentMethod(
        new CheckoutPaymentMethod(
            new StoredPaymentMethodDetails()
                .type(StoredPaymentMethodDetails.TypeEnum.BCMC_MOBILE)));
    PaymentsApi checkout = new PaymentsApi(client);
    PaymentResponse paymentResponse = checkout.payments(paymentRequest);
    assertEquals(PaymentResponse.ResultCodeEnum.PENDING, paymentResponse.getResultCode());
    assertNotNull(paymentResponse.getAction());
  }

  @Test
  public void testPixActionQrCode() throws Exception {
    Client client = createMockClientFromFile("mocks/checkout/pixQrCodeResponse.json");

    PaymentRequest paymentRequest = new PaymentRequest();
    paymentRequest.setAmount(new Amount().currency("EUR").value(100000L));
    paymentRequest.lineItems(
        Arrays.asList(
            new LineItem().id("Item 1").amountIncludingTax(40000L),
            new LineItem().id("Item 2").amountIncludingTax(60000L)));
    paymentRequest.shopperName(new Name().firstName("Jose").lastName("Silva"));
    paymentRequest.setPaymentMethod(
        new CheckoutPaymentMethod(new PixDetails().type(PixDetails.TypeEnum.PIX)));
    PaymentsApi checkout = new PaymentsApi(client);
    PaymentResponse paymentResponse = checkout.payments(paymentRequest);
    assertEquals("8815658961765250", paymentResponse.getPspReference());
    assertEquals(PaymentResponse.ResultCodeEnum.PENDING, paymentResponse.getResultCode());

    assertNotNull(paymentResponse.getAction());
    final CheckoutQrCodeAction qrCodeAction = paymentResponse.getAction().getCheckoutQrCodeAction();
    assertNotNull(qrCodeAction);
    assertEquals(CheckoutQrCodeAction.TypeEnum.QRCODE, qrCodeAction.getType());
    assertEquals("pix", qrCodeAction.getPaymentMethodType());
    assertEquals("DMhpN90TFR2e7TzwHYRFkhw4brxm2wHBg", qrCodeAction.getQrCodeData());
  }
}
