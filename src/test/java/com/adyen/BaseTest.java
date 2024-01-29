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

import com.adyen.constants.ApiConstants;
import com.adyen.enums.VatCategory;
import com.adyen.httpclient.AdyenHttpClient;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.nexo.AmountsReq;
import com.adyen.model.nexo.MessageCategoryType;
import com.adyen.model.nexo.MessageClassType;
import com.adyen.model.nexo.MessageHeader;
import com.adyen.model.nexo.MessageType;
import com.adyen.model.nexo.PaymentTransaction;
import com.adyen.model.nexo.SaleData;
import com.adyen.model.nexo.SaleToPOIRequest;
import com.adyen.model.nexo.TransactionIdentification;
import com.adyen.model.payment.ApplicationInfo;
import com.adyen.model.payment.AuthenticationResultRequest;
import com.adyen.model.payment.BrowserInfo;
import com.adyen.model.payment.Card;
import com.adyen.model.payment.CommonField;
import com.adyen.model.payment.Name;
import com.adyen.model.payment.PaymentRequest3d;
import com.adyen.model.payment.PaymentRequest3ds2;
import com.adyen.model.payment.ThreeDS2RequestData;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.model.additionalData.InvoiceLine;
import com.adyen.model.payment.PaymentRequest;
import com.adyen.terminal.serialization.XMLGregorianCalendarTypeAdapter;
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
import java.time.OffsetDateTime;
import java.util.*;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseTest {
    protected final ApplicationInfo applicationInfo = new ApplicationInfo()
            .adyenLibrary(new CommonField().name(LIB_NAME).version(LIB_VERSION));
    protected static final Gson PRETTY_PRINT_GSON = new GsonBuilder()
            .registerTypeHierarchyAdapter(XMLGregorianCalendar.class, new XMLGregorianCalendarTypeAdapter())
            .setPrettyPrinting().create();
    public static final String USER_AGENT = "User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36";

    private static final String CHECKOUT_ENDPOINT_TEST = "https://checkout-test.adyen.com/checkout";
    /**
     * Returns a Client object that has a mocked response
     */
    protected Client createMockClientFromResponse(String response) {
        AdyenHttpClient adyenHttpClient = mock(AdyenHttpClient.class);
        try {
            when(adyenHttpClient.request(anyString(), anyString(), any(Config.class), anyBoolean(), isNull())).thenReturn(response);
            when(adyenHttpClient.request(anyString(), any(), any(Config.class), anyBoolean(), isNull(), any())).thenReturn(response);
            when(adyenHttpClient.request(anyString(), any(), any(Config.class), anyBoolean(), isNull(), any(), any())).thenReturn(response);

        } catch (IOException | HTTPClientException e) {
            e.printStackTrace();
        }
        Client client = new Client();
        client.setHttpClient(adyenHttpClient);

        Config config = new Config();
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
    protected PaymentRequest createBasePaymentRequest(PaymentRequest abstractPaymentRequest) {
        return abstractPaymentRequest.merchantAccount("AMerchant")
                .browserInfo(new BrowserInfo()
                        .userAgent(USER_AGENT)
                        .acceptHeader("*/*"))
                .shopperIP("1.2.3.4");
    }

    protected PaymentRequest3d createBasePaymentRequest(PaymentRequest3d abstractPaymentRequest) {
        return abstractPaymentRequest.merchantAccount("AMerchant")
                .browserInfo(new BrowserInfo()
                        .userAgent(USER_AGENT)
                        .acceptHeader("*/*"))
                .shopperIP("1.2.3.4");
    }

    protected PaymentRequest3ds2 createBasePaymentRequest(PaymentRequest3ds2 abstractPaymentRequest) {
        return abstractPaymentRequest.merchantAccount("AMerchant")
                .browserInfo(new BrowserInfo()
                        .userAgent(USER_AGENT)
                        .acceptHeader("*/*"))
                .shopperIP("1.2.3.4");
    }

    /**
     * Returns a sample PaymentRequest object with full card data
     */
    protected PaymentRequest createFullCardPaymentRequest() {
        Card card = new Card();
        card.setExpiryMonth("08");
        card.setExpiryYear("2018");
        card.setHolderName("John Doe");
        card.setNumber("5136333333333335");
        card.setCvc("737");
        return createBasePaymentRequest(new PaymentRequest()).reference("123456")
                .amount(new com.adyen.model.payment.Amount().value(100000L).currency("EUR"))
                .card(card);
    }

    /**
     * Returns a sample PaymentRequest opbject with full OpenInvoice request
     */
    protected PaymentRequest createOpenInvoicePaymentRequest() {

        OffsetDateTime date = OffsetDateTime.parse("1970-07-10T12:00:00+01:00");

        PaymentRequest paymentRequest = createBasePaymentRequest(new PaymentRequest()).reference("123456");
        paymentRequest.amount(new com.adyen.model.payment.Amount().value(200L).currency("EUR"));

        // Set Shopper Data
        paymentRequest.setShopperEmail("youremail@email.com");
        paymentRequest.setDateOfBirth(date.toLocalDate());
        paymentRequest.setTelephoneNumber("0612345678");
        paymentRequest.setShopperReference("4");

        // Set Shopper Info
        Name shopperName = new Name();
        shopperName.setFirstName("Testperson-nl");
        shopperName.setLastName("Approved");
        paymentRequest.setShopperName(shopperName);

        // Set Billing and Delivery address
        com.adyen.model.payment.Address address = new com.adyen.model.payment.Address();
        address.setCity("Gravenhage");
        address.setCountry("NL");
        address.setHouseNumberOrName("1");
        address.setPostalCode("2521VA");
        address.setStateOrProvince("Zuid-Holland");
        address.setStreet("Neherkade");
        paymentRequest.setDeliveryAddress(address);
        paymentRequest.setBillingAddress(address);

        // Use OpenInvoice Provider (klarna, ratepay)
        paymentRequest.selectedBrand("klarna");

        Long itemAmount = 9000L;
        Long itemVatAmount = 1000L;
        Long itemVatPercentage = 1000L;

        List<InvoiceLine> invoiceLines = new ArrayList<>();

        // invoiceLine1
        InvoiceLine invoiceLine = new InvoiceLine();
        invoiceLine.setCurrencyCode("EUR");
        invoiceLine.setDescription("Test product");
        invoiceLine.setItemAmount(itemAmount);
        invoiceLine.setItemVATAmount(itemVatAmount);
        invoiceLine.setItemVatPercentage(itemVatPercentage);
        invoiceLine.setVatCategory(VatCategory.NONE);
        invoiceLine.setNumberOfItems(1);
        invoiceLine.setItemId("1234");

        // invoiceLine2
        InvoiceLine invoiceLine2 = new InvoiceLine();
        invoiceLine2.setCurrencyCode("EUR");
        invoiceLine2.setDescription("Test product 2");
        invoiceLine2.setItemAmount(itemAmount);
        invoiceLine2.setItemVATAmount(itemVatAmount);
        invoiceLine2.setItemVatPercentage(itemVatPercentage);
        invoiceLine2.setVatCategory(VatCategory.NONE);
        invoiceLine2.setNumberOfItems(1);
        invoiceLine2.setItemId("4567");

        invoiceLines.add(invoiceLine);
        invoiceLines.add(invoiceLine2);

        setInvoiceLines(paymentRequest, invoiceLines);

        return paymentRequest;
    }

    protected void setInvoiceLines(PaymentRequest paymentRequest, List<InvoiceLine> invoiceLines) {
        Map<String, String> additionalData = paymentRequest.getAdditionalData() != null ?
                paymentRequest.getAdditionalData() : new HashMap<>();

        int count = 1;
        for (InvoiceLine invoiceLine : invoiceLines) {
            String lineNumber = "openinvoicedata.line" + count;

            additionalData.put(lineNumber + ".currencyCode", invoiceLine.getCurrencyCode());
            additionalData.put(lineNumber + ".description", invoiceLine.getDescription());
            additionalData.put(lineNumber + ".itemAmount", invoiceLine.getItemAmount().toString());
            additionalData.put(lineNumber + ".itemVatAmount", invoiceLine.getItemVATAmount().toString());
            additionalData.put(lineNumber + ".itemVatPercentage", invoiceLine.getItemVatPercentage().toString());
            additionalData.put(lineNumber + ".numberOfItems", Integer.toString(invoiceLine.getNumberOfItems()));
            additionalData.put(lineNumber + ".vatCategory", invoiceLine.getVatCategory().toString());

            // Additional field only for RatePay
            if (invoiceLine.getItemId() != null && ! invoiceLine.getItemId().isEmpty()) {
                additionalData.put(lineNumber + ".itemId", invoiceLine.getItemId());
            }

            count++;
        }

        additionalData.put("openinvoicedata.numberOfLines", Integer.toString(invoiceLines.size()));
        paymentRequest.setAdditionalData(additionalData);
    }

    /**
     * Returns a sample PaymentRequest object with CSE data
     */
    protected PaymentRequest createCSEPaymentRequest() {
        Map<String, String> additionalData = new HashMap<>();
        additionalData.put(ApiConstants.AdditionalData.Card.Encrypted.JSON, "adyenjs_0_1_4p1$...");
        return createBasePaymentRequest(new PaymentRequest()).reference("123456")
                .additionalData(additionalData)
                .amount(new com.adyen.model.payment.Amount().value(100000L).currency("EUR"));
    }

    /**
     * Returns a PaymentRequest3d object for 3D secure authorisation
     */
    protected PaymentRequest3d create3DPaymentRequest() {
        return createBasePaymentRequest(new PaymentRequest3d()).md("mdString").paResponse("paResString");
    }

    /**
     * Returns a PaymentRequest3d object for 3D secure authorisation
     */
    protected PaymentRequest3ds2 create3DS2PaymentRequest() {

        PaymentRequest3ds2 paymentRequest3ds2 = createBasePaymentRequest(new PaymentRequest3ds2());
        paymentRequest3ds2.setThreeDS2Token("— - BINARY DATA - -");
        paymentRequest3ds2.setThreeDS2RequestData(new ThreeDS2RequestData());
        paymentRequest3ds2.getThreeDS2RequestData().setThreeDSCompInd("Y");
        return paymentRequest3ds2;
    }

    /**
     * Returns a Client that has a mocked error response from fileName
     */
    protected Client createMockClientForErrors(int status, String fileName) {
        String response = getFileContents(fileName);

        AdyenHttpClient adyenHttpClient = mock(AdyenHttpClient.class);
        HTTPClientException httpClientException = new HTTPClientException(status, "An error occured", new HashMap<>(), response);
        try {
            when(adyenHttpClient.request(anyString(), anyString(), any(Config.class), anyBoolean(), isNull(), any(), any())).thenThrow(httpClientException);
        } catch (IOException | HTTPClientException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        Client client = new Client();
        client.setHttpClient(adyenHttpClient);
        Config config = new Config();
        client.setConfig(config);

        return client;
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

    protected AuthenticationResultRequest createAuthenticationResultRequest() {
        AuthenticationResultRequest authenticationResultRequest = new AuthenticationResultRequest();
        authenticationResultRequest.setMerchantAccount("AMerchant");
        authenticationResultRequest.setPspReference("APspReference");
        return authenticationResultRequest;
    }
}
