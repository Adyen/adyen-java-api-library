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

import com.adyen.httpclient.AdyenHttpClient;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.model.checkout.Amount;
import com.adyen.model.checkout.Address;
import com.adyen.model.checkout.LineItem;
import com.adyen.model.checkout.Name;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.KlarnaDetails;
import com.adyen.model.checkout.BrowserInfo;
import com.adyen.model.checkout.CardDetails;
import com.adyen.model.checkout.PaymentDonationRequestPaymentMethod;
import com.adyen.model.checkout.AfterpayDetails;
import com.adyen.model.checkout.CreatePaymentCaptureRequest;
import com.adyen.model.checkout.CreatePaymentRefundRequest;
import com.adyen.model.nexo.AmountsReq;
import com.adyen.model.nexo.MessageCategoryType;
import com.adyen.model.nexo.MessageClassType;
import com.adyen.model.nexo.MessageHeader;
import com.adyen.model.nexo.MessageType;
import com.adyen.model.nexo.PaymentTransaction;
import com.adyen.model.nexo.SaleData;
import com.adyen.model.nexo.SaleToPOIRequest;
import com.adyen.model.nexo.TransactionIdentification;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.util.DateUtil;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.*;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseTest {
    protected static final Gson PRETTY_PRINT_GSON = new GsonBuilder().setPrettyPrinting().create();
    protected static final Gson GSON = new Gson();
    protected static final ObjectMapper OBJECT_MAPPER =  new ObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);
    public static final String DUMMY_PROTOCOL_IMAGE_URL = "dummy_protocol/image_url/";
    public static final String DUMMY_PROTOCOL_PRODUCT_URL = "dummy_protocol/product_url/";

    /**
     * Returns a Client object that has a mocked response
     */
    protected Client createMockClientFromResponse(String response) {
        AdyenHttpClient adyenHttpClient = mock(AdyenHttpClient.class);
        try {
            when(adyenHttpClient.request(anyString(), anyString(), any(Config.class), anyBoolean(), any(RequestOptions.class))).thenReturn(response);
            when(adyenHttpClient.request(anyString(), anyString(), any(Config.class), anyBoolean(), isNull())).thenReturn(response);
            when(adyenHttpClient.request(anyString(), any(), any(Config.class), anyBoolean(), isNull(), any())).thenReturn(response);
            when(adyenHttpClient.request(anyString(), any(), any(Config.class), anyBoolean(), isNull(), any(), any())).thenReturn(response);

        } catch (IOException | HTTPClientException e) {
            e.printStackTrace();
        }
        Client client = new Client();
        client.setHttpClient(adyenHttpClient);

        Config config = new Config();
        config.setHmacKey("DFB1EB5485895CFA84146406857104ABB4CBCABDC8AAF103A624C8F6A3EAAB00");
        config.setCheckoutEndpoint(Client.CHECKOUT_ENDPOINT_TEST);
        client.setConfig(config);

        return client;
    }

    /**
     * Returns a Client object that has a mocked response from fileName
     */
    protected Client createMockClientFromFile(String fileName) {
        String response = getFileContents(fileName);

        return createMockClientFromResponse(response);
    }

    /**
     * Helper for file reading
     */
    public String getFileContents(String fileName) {
        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            byte[] buffer = new byte[1024];
            int length;
            InputStream fileStream = classLoader.getResourceAsStream(fileName);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            while ((length = fileStream.read(buffer)) != - 1) {
                outputStream.write(buffer, 0, length);
            }
            result = outputStream.toString(StandardCharsets.UTF_8.name());
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Populates the basic parameters (browser data, merchant account, shopper IP)
     */
    protected PaymentRequest createBasePaymentRequest(PaymentRequest paymentRequest) {
        BrowserInfo browserInfo = new BrowserInfo();
        browserInfo.setUserAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36");
        paymentRequest.setMerchantAccount("AMerchant");
        paymentRequest.setBrowserInfo(browserInfo);
        paymentRequest.setShopperIP("1.2.3.4");

        return paymentRequest;
    }

    /**
     * Returns a sample PaymentRequest opbject with full card data
     */
    protected PaymentRequest createFullCardPaymentRequest() {
        Amount amount = new Amount().currency("EUR").value(1000L);
        CardDetails cardDetails = new CardDetails();
        cardDetails.encryptedCardNumber("5136333333333335")
                .holderName("John Doe")
                .cvc("737")
                .encryptedExpiryMonth("08")
                .encryptedExpiryYear("2018");

        return createBasePaymentRequest(new PaymentRequest()).reference("123456")
                .amount(amount)
                .paymentMethod(new PaymentDonationRequestPaymentMethod(cardDetails));
    }

    protected PaymentRequest createAfterPayPaymentRequest() {

        PaymentRequest paymentsRequest = new PaymentRequest();
        paymentsRequest.setMerchantAccount("YOUR_MERCHANT_ACCOUNT");
        paymentsRequest.setCountryCode("NL");

        Amount amount = new Amount();
        amount.setCurrency("EUR");
        amount.setValue(1000L);

        paymentsRequest.setAmount(amount);
        paymentsRequest.setShopperReference("YOUR_UNIQUE_SHOPPER_ID");
        paymentsRequest.setReference("YOUR_ORDER_NUMBER");
        paymentsRequest.setChannel(PaymentRequest.ChannelEnum.WEB);

        AfterpayDetails afterpayDetails = new AfterpayDetails();
        afterpayDetails.setType(AfterpayDetails.TypeEnum.AFTERPAY_DEFAULT);

        afterpayDetails.setPersonalDetails("EndToEnd lastName 2000-02-02 +31612345678 SHOPPER@EMAIL_ADDRESS.COM");

        paymentsRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(afterpayDetails));

        Address billingAddress = new Address();
        billingAddress.setStreet("Simon Carmiggeltstraat");
        billingAddress.setHouseNumberOrName("136");
        billingAddress.setCity("Amsterdam");
        billingAddress.setPostalCode("1011DJ");
        billingAddress.setCountry("NL");

        paymentsRequest.setBillingAddress(billingAddress);
        paymentsRequest.setShopperIP("192.0.2.1");

        List<LineItem> lineItems = new ArrayList<>();

        lineItems.add(
                new LineItem()
                    .quantity(1L)
                    .amountExcludingTax(331L)
                    .taxPercentage(2100L)
                    .description("Shoes")
                    .id("Item #1")
                    .taxAmount(69L)
                    .amountIncludingTax(400L)
                    .imageUrl(DUMMY_PROTOCOL_IMAGE_URL)
                    .productUrl(DUMMY_PROTOCOL_PRODUCT_URL)
        );

        lineItems.add(
                new LineItem()
                .quantity(2L)
                .amountExcludingTax(248L)
                .taxPercentage(2100L)
                .description("Socks")
                .id("Item #2")
                .taxAmount(52L)
                .amountIncludingTax(300L)
                .imageUrl(DUMMY_PROTOCOL_IMAGE_URL)
                .productUrl(DUMMY_PROTOCOL_PRODUCT_URL)
        );

        paymentsRequest.setLineItems(lineItems);

        return paymentsRequest;

    }

    /**
     * Returns a sample PaymentRequest opbject with full OpenInvoice request
     */
    protected PaymentRequest createOpenInvoicePaymentRequest() {

        Date dateOfBirth = DateUtil.parseYmdDate("1970-07-10");
        Amount amount = new Amount().currency("EUR").value(200L);
        PaymentRequest paymentRequest = createBasePaymentRequest(new PaymentRequest()).reference("123456").amount(amount);

        // Set Shopper Data
        paymentRequest.setShopperEmail("youremail@email.com");
        paymentRequest.setDateOfBirth(dateOfBirth);
        paymentRequest.setTelephoneNumber("0612345678");
        paymentRequest.setShopperReference("4");

        // Set Shopper Info
        Name shopperName = new Name();
        shopperName.setFirstName("Testperson-nl");
        shopperName.setLastName("Approved");
        paymentRequest.setShopperName(shopperName);

        // Set Billing and Delivery address
        Address address = new Address();
        address.setCity("Gravenhage");
        address.setCountry("NL");
        address.setHouseNumberOrName("1");
        address.setPostalCode("2521VA");
        address.setStateOrProvince("Zuid-Holland");
        address.setStreet("Neherkade");
        paymentRequest.setDeliveryAddress(address);
        paymentRequest.setBillingAddress(address);

        // Use OpenInvoice Provider (klarna, ratepay)
        KlarnaDetails klarnaDetails = new KlarnaDetails();
        klarnaDetails.type(KlarnaDetails.TypeEnum.KLARNA);
        paymentRequest.setPaymentMethod(new PaymentDonationRequestPaymentMethod(klarnaDetails));

        Long itemAmount = 9000L;
        Long itemVatAmount = 1000L;
        Long itemVatPercentage = 1000L;

        List<LineItem> invoiceLines = new ArrayList<>();

        // invoiceLine1
        LineItem invoiceLine = new LineItem();
        invoiceLine.setDescription("Test product");
        invoiceLine.setQuantity(1L);
        invoiceLine.setAmountIncludingTax(itemAmount);
        invoiceLine.setTaxAmount(itemVatAmount);
        invoiceLine.setTaxPercentage(itemVatPercentage);
        invoiceLine.setId("1234");

        // invoiceLine2
        LineItem invoiceLine2 = new LineItem();
        invoiceLine2.setDescription("Test product 2");
        invoiceLine.setQuantity(1L);
        invoiceLine.setAmountIncludingTax(itemAmount);
        invoiceLine.setTaxAmount(itemVatAmount);
        invoiceLine.setTaxPercentage(itemVatPercentage);
        invoiceLine.setId("5678");

        invoiceLines.add(invoiceLine);
        invoiceLines.add(invoiceLine2);

        paymentRequest.lineItems(invoiceLines);

        return paymentRequest;
    }

    /**
     * Returns a sample PaymentRequest object with CSE data
     */
    protected PaymentRequest createCSEPaymentRequest() {
        Map<String, String> additionalData = new HashMap<>();
        additionalData.put("card.encrypted.json", "adyenjs_0_1_4p1$...");
        return createBasePaymentRequest(new PaymentRequest()).reference("123456")
                .amount(new Amount().value(1000L).currency("EUR"))
                .additionalData(additionalData);
    }


    /**
     * Returns a Client that has a mocked error response from fileName
     */
    protected Client createMockClientForErrors(int status, String fileName) {
        String response = getFileContents(fileName);

        AdyenHttpClient adyenHttpClient = mock(AdyenHttpClient.class);
        HTTPClientException httpClientException = new HTTPClientException(status, "An error occured", new HashMap<>(), response);
        try {
            when(adyenHttpClient.request(anyString(), anyString(), any(Config.class), anyBoolean(), isNull(), any())).thenThrow(httpClientException);
        } catch (IOException | HTTPClientException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        Client client = new Client();
        client.setHttpClient(adyenHttpClient);
        Config config = new Config();
        config.setCheckoutEndpoint(Client.CHECKOUT_ENDPOINT_TEST);
        client.setConfig(config);

        return client;
    }


    protected CreatePaymentCaptureRequest createCaptureRequest() {
        CreatePaymentCaptureRequest captureRequest = new CreatePaymentCaptureRequest();
        Amount amount = new Amount().currency("EUR").value(1500L);
        captureRequest.merchantAccount("AMerchant")
                .reference("originalReference")
                .amount(amount);

        return captureRequest;
    }

    protected CreatePaymentRefundRequest createRefundRequest() {
        Amount amount = new Amount().currency("EUR").value(1500L);

        return new CreatePaymentRefundRequest().amount(amount);
    }

    protected TerminalAPIRequest createTerminalAPIPaymentRequest() throws DatatypeConfigurationException {
        SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();

        MessageHeader messageHeader = new MessageHeader();
        messageHeader.setProtocolVersion("3.0");
        messageHeader.setMessageClass(MessageClassType.SERVICE);
        messageHeader.setMessageCategory(MessageCategoryType.PAYMENT);
        messageHeader.setMessageType(MessageType.REQUEST);
        messageHeader.setSaleID("001");
        messageHeader.setServiceID("001");
        messageHeader.setPOIID("P400Plus-123456789");

        saleToPOIRequest.setMessageHeader(messageHeader);

        com.adyen.model.nexo.PaymentRequest paymentRequest = new com.adyen.model.nexo.PaymentRequest();

        SaleData saleData = new SaleData();
        TransactionIdentification transactionIdentification = new TransactionIdentification();
        transactionIdentification.setTransactionID("001");
        XMLGregorianCalendar timestamp = DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar());
        transactionIdentification.setTimeStamp(timestamp);
        saleData.setSaleTransactionID(transactionIdentification);

        PaymentTransaction paymentTransaction = new PaymentTransaction();
        AmountsReq amountsReq = new AmountsReq();
        amountsReq.setCurrency("EUR");
        amountsReq.setRequestedAmount(BigDecimal.ONE);
        paymentTransaction.setAmountsReq(amountsReq);

        paymentRequest.setSaleData(saleData);
        paymentRequest.setPaymentTransaction(paymentTransaction);

        saleToPOIRequest.setPaymentRequest(paymentRequest);

        TerminalAPIRequest terminalAPIRequest = new TerminalAPIRequest();
        terminalAPIRequest.setSaleToPOIRequest(saleToPOIRequest);

        return terminalAPIRequest;
    }
}
