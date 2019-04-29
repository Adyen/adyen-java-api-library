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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.adyen.Util.DateUtil;
import com.adyen.Util.Util;
import com.adyen.enums.VatCategory;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.httpclient.HttpURLConnectionClient;
import com.adyen.model.AbstractPaymentRequest;
import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.adyen.model.Name;
import com.adyen.model.PaymentRequest;
import com.adyen.model.PaymentRequest3d;
import com.adyen.model.PaymentRequest3ds2;
import com.adyen.model.RequestOptions;
import com.adyen.model.ThreeDS2RequestData;
import com.adyen.model.additionalData.InvoiceLine;
import com.adyen.model.modification.AbstractModificationRequest;
import com.adyen.model.modification.CaptureRequest;
import com.adyen.model.modification.RefundRequest;
import com.adyen.model.nexo.AmountsReq;
import com.adyen.model.nexo.MessageCategoryType;
import com.adyen.model.nexo.MessageClassType;
import com.adyen.model.nexo.MessageHeader;
import com.adyen.model.nexo.MessageType;
import com.adyen.model.nexo.PaymentTransaction;
import com.adyen.model.nexo.SaleData;
import com.adyen.model.nexo.SaleToPOIRequest;
import com.adyen.model.nexo.TransactionIdentification;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import static org.junit.Assert.fail;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.isNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BaseTest {
    protected static final Gson PRETTY_PRINT_GSON = new GsonBuilder().setPrettyPrinting().create();

    /**
     * Returns a Client object that has a mocked response
     */
    protected Client createMockClientFromResponse(String response) {
        HttpURLConnectionClient httpURLConnectionClient = mock(HttpURLConnectionClient.class);
        try {
            when(httpURLConnectionClient.post(any(String.class), any(Map.class), any(Config.class))).thenReturn(response);
            when(httpURLConnectionClient.request(any(String.class), any(String.class), any(Config.class), anyBoolean(), any(RequestOptions.class))).thenReturn(response);
            when(httpURLConnectionClient.request(any(String.class), any(String.class), any(Config.class), anyBoolean(), (RequestOptions) isNull())).thenReturn(response);

        } catch (IOException | HTTPClientException e) {
            e.printStackTrace();
        }
        Client client = new Client();
        client.setHttpClient(httpURLConnectionClient);

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
    protected <T extends AbstractPaymentRequest> T createBasePaymentRequest(T abstractPaymentRequest) {
        abstractPaymentRequest.merchantAccount("AMerchant")
                              .setBrowserInfoData("User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36", "*/*")
                              .setShopperIP("1.2.3.4");

        return abstractPaymentRequest;
    }

    /**
     * Returns a sample PaymentRequest opbject with full card data
     */
    protected PaymentRequest createFullCardPaymentRequest() {
        PaymentRequest paymentRequest = createBasePaymentRequest(new PaymentRequest()).reference("123456")
                                                                                      .setAmountData("1000", "EUR")
                                                                                      .setCardData("5136333333333335", "John Doe", "08", "2018", "737");

        return paymentRequest;
    }

    /**
     * Returns a sample PaymentRequest opbject with full OpenInvoice request
     */
    protected PaymentRequest createOpenInvoicePaymentRequest() {

        Date dateOfBirth = DateUtil.parseYmdDate("1970-07-10");

        PaymentRequest paymentRequest = createBasePaymentRequest(new PaymentRequest()).reference("123456").setAmountData("200", "EUR");

        // Set Shopper Data
        paymentRequest.setShopperEmail("youremail@email.com");
        paymentRequest.setDateOfBirth(dateOfBirth);
        paymentRequest.setTelephoneNumber("0612345678");
        paymentRequest.setShopperReference("4");

        // Set Shopper Info
        Name shopperName = new Name();
        shopperName.setFirstName("Testperson-nl");
        shopperName.setLastName("Approved");
        shopperName.gender(Name.GenderEnum.MALE);
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
        paymentRequest.selectedBrand("klarna");

        Long itemAmount = new Long("9000");
        Long itemVatAmount = new Long("1000");
        Long itemVatPercentage = new Long("1000");

        List<InvoiceLine> invoiceLines = new ArrayList<InvoiceLine>();

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

        paymentRequest.setInvoiceLines(invoiceLines);

        return paymentRequest;
    }

    /**
     * Returns a sample PaymentRequest object with CSE data
     */
    protected PaymentRequest createCSEPaymentRequest() {
        PaymentRequest paymentRequest = createBasePaymentRequest(new PaymentRequest()).reference("123456").setAmountData("1000", "EUR").setCSEToken("adyenjs_0_1_4p1$...");

        return paymentRequest;
    }

    /**
     * Returns a PaymentRequest3d object for 3D secure authorisation
     */
    protected PaymentRequest3d create3DPaymentRequest() {
        PaymentRequest3d paymentRequest3d = createBasePaymentRequest(new PaymentRequest3d()).set3DRequestData("mdString", "paResString");

        return paymentRequest3d;
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

        HttpURLConnectionClient httpURLConnectionClient = mock(HttpURLConnectionClient.class);
        HTTPClientException httpClientException = new HTTPClientException(status, "An error occured", new HashMap<String, List<String>>(), response);
        try {
            when(httpURLConnectionClient.request(any(String.class), any(String.class), any(Config.class), anyBoolean(), (RequestOptions) isNull())).thenThrow(httpClientException);
        } catch (IOException | HTTPClientException e) {
            fail("Unexpected exception: " + e.getMessage());
        }
        Client client = new Client();
        client.setHttpClient(httpURLConnectionClient);
        return client;
    }

    protected <T extends AbstractModificationRequest> T createBaseModificationRequest(T modificationRequest) {
        modificationRequest.merchantAccount("AMerchant").originalReference("originalReference").reference("merchantReference");

        return modificationRequest;
    }

    protected CaptureRequest createCaptureRequest() {
        CaptureRequest captureRequest = createBaseModificationRequest(new CaptureRequest());

        captureRequest.fillAmount("15.00", "EUR");

        return captureRequest;
    }

    protected RefundRequest createRefundRequest() {
        Amount amount = Util.createAmount("15.00", "EUR");

        return createBaseModificationRequest(new RefundRequest()).modificationAmount(amount);
    }

    protected SaleToPOIRequest createSaleToPOIRequest() throws DatatypeConfigurationException {
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

        return saleToPOIRequest;
    }
}
