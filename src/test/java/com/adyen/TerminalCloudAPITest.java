package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.httpclient.TerminalLocalAPIHostnameVerifier;
import com.adyen.model.applicationinfo.ApplicationInfo;
import com.adyen.model.applicationinfo.CommonField;
import com.adyen.service.TerminalCloudAPI;
import com.adyen.service.TerminalLocalAPI;
import com.adyen.service.TerminalLocalAPIUnencrypted;
import com.adyen.service.exception.ApiException;
import com.adyen.terminal.*;
import com.adyen.model.terminal.*;
import com.adyen.terminal.TerminalAPIRequest;
import com.adyen.terminal.TerminalAPIResponse;
import com.adyen.terminal.security.SecurityKey;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Test;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.security.KeyStore;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for /sync and /async
 */
public class TerminalCloudAPITest extends BaseTest {

    /**
     * Test success flow for POST /async
     */
    @Test
    public void asyncPaymentRequestSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/terminal-api/payment-async-success");
        TerminalCloudAPI terminalCloudApi = new TerminalCloudAPI(client);

        String requestResponse = terminalCloudApi.async(new TerminalAPIRequest());
        assertEquals("ok", requestResponse);
    }

    /**
     * Test success flow for POST /sync
     */
    @Test
    public void syncPaymentRequestSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/terminal-api/payment-sync-success.json");
        TerminalCloudAPI terminalCloudApi = new TerminalCloudAPI(client);

        TerminalAPIRequest terminalAPIPaymentRequest = new TerminalAPIRequest();

        // add some data
        SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();
        PaymentRequest paymentRequest = new PaymentRequest();
        SaleData saleDataRequest = new SaleData();
        saleDataRequest.setSaleToAcquirerData("saleToAcquirerData");
        paymentRequest.setSaleData(saleDataRequest);
        saleToPOIRequest.setPaymentRequest(paymentRequest);
        terminalAPIPaymentRequest.setSaleToPOIRequest(saleToPOIRequest);

        TerminalAPIResponse terminalAPIResponse = terminalCloudApi.sync(terminalAPIPaymentRequest);

        assertNotNull(terminalAPIResponse);
        assertNotNull(terminalAPIResponse.getSaleToPOIResponse());

        SaleToPOIResponse saleToPoiResponse = terminalAPIResponse.getSaleToPOIResponse();
        assertNotNull(saleToPoiResponse.getMessageHeader());
        assertNotNull(saleToPoiResponse.getPaymentResponse());

        MessageHeader messageHeader = saleToPoiResponse.getMessageHeader();
        assertEquals(MessageType.RESPONSE, messageHeader.getMessageType());
        assertEquals(MessageClass.SERVICE, messageHeader.getMessageClass());
        assertEquals(MessageCategory.PAYMENT, messageHeader.getMessageCategory());
        assertEquals("3.0", messageHeader.getProtocolVersion());
        assertEquals("001", messageHeader.getSaleID());
        assertEquals("1234567890", messageHeader.getServiceID());
        assertEquals("P400Plus-123456789", messageHeader.getPOIID());

        assertNotNull(saleToPoiResponse.getPaymentResponse().getResponse());
        Response response = saleToPoiResponse.getPaymentResponse().getResponse();
        assertEquals(Result.SUCCESS, response.getResult());
        assertNotNull(response.getAdditionalResponse());

        assertNotNull(saleToPoiResponse.getPaymentResponse().getPoIData());
        POIData poiData = saleToPoiResponse.getPaymentResponse().getPoIData();
        assertEquals(1000, poiData.getPoIReconciliationID().intValue());
        assertNotNull(poiData.getPoITransactionID());
        assertEquals("4r7i001556529591000.8515565295894301", poiData.getPoITransactionID().getTransactionID());
        assertEquals("2019-04-29T00:00Z", poiData.getPoITransactionID().getTimeStamp().toString());

        assertNotNull(saleToPoiResponse.getPaymentResponse().getSaleData());
        SaleData saleData = saleToPoiResponse.getPaymentResponse().getSaleData();
        assertNotNull(saleData.getSaleTransactionID());
        assertEquals("001", saleData.getSaleTransactionID().getTransactionID());
        assertEquals("2019-04-29T00:00Z", saleData.getSaleTransactionID().getTimeStamp().toString());

        assertNotNull(saleToPoiResponse.getPaymentResponse().getPaymentReceipt());
        assertFalse(saleToPoiResponse.getPaymentResponse().getPaymentReceipt().isEmpty());
        List<PaymentReceipt> paymentReceiptList = saleToPoiResponse.getPaymentResponse().getPaymentReceipt();
        for (PaymentReceipt paymentReceipt : paymentReceiptList) {
            assertNotNull(paymentReceipt.getDocumentQualifier());
            assertNotNull(paymentReceipt.getOutputContent());
            assertEquals(OutputFormat.TEXT, paymentReceipt.getOutputContent().getOutputFormat());
            assertNotNull(paymentReceipt.getOutputContent().getOutputText());
            assertFalse(paymentReceipt.getOutputContent().getOutputText().isEmpty());
            List<OutputText> outputTextList = paymentReceipt.getOutputContent().getOutputText();

            outputTextList.forEach(outputText -> assertNotNull(outputText.getText()));
        }

        assertNotNull(saleToPoiResponse.getPaymentResponse().getPaymentResult());
        PaymentResult paymentResult = saleToPoiResponse.getPaymentResponse().getPaymentResult();
        assertTrue(paymentResult.getOnlineFlag());
        assertNotNull(paymentResult.getPaymentAcquirerData());
        assertEquals("P400Plus-123456789", paymentResult.getPaymentAcquirerData().getAcquirerPOIID());
        assertEquals("123456", paymentResult.getPaymentAcquirerData().getApprovalCode());
        assertEquals("TestMerchant", paymentResult.getPaymentAcquirerData().getMerchantID());
        assertNotNull(paymentResult.getPaymentAcquirerData().getAcquirerTransactionID());
        assertNotNull(paymentResult.getPaymentInstrumentData());
        assertNotNull(paymentResult.getPaymentInstrumentData().getCardData());
        assertEquals("mc", paymentResult.getPaymentInstrumentData().getCardData().getPaymentBrand());
        assertEquals("411111 **** 1111", paymentResult.getPaymentInstrumentData().getCardData().getMaskedPan());
        assertEquals(PaymentInstrumentType.CARD, paymentResult.getPaymentInstrumentData().getPaymentInstrumentType());
        assertNotNull(paymentResult.getAmountsResp());
        assertEquals("EUR", paymentResult.getAmountsResp().getCurrency());
        assertEquals(BigDecimal.ONE, paymentResult.getAmountsResp().getAuthorizedAmount());

        assertNotNull(paymentResult.getCurrencyConversion());
        assertNotNull(paymentResult.getCurrencyConversion().get(0));
        assertTrue(paymentResult.getCurrencyConversion().get(0).getCustomerApprovedFlag());
        assertEquals("3", paymentResult.getCurrencyConversion().get(0).getMarkup());
        assertEquals("0.035", paymentResult.getCurrencyConversion().get(0).getRate());
        assertNotNull(paymentResult.getCurrencyConversion().get(0).getConvertedAmount());
        assertEquals(new BigDecimal("48.32"), paymentResult.getCurrencyConversion().get(0).getConvertedAmount().getAmountValue());
        assertEquals("EUR", paymentResult.getCurrencyConversion().get(0).getConvertedAmount().getCurrency());

    }

    /**
     * Test error flow for POST /sync
     */
    @Test
    public void syncPaymentRequestErrorEmptyBody() throws Exception {
        Client client = createMockClientFromFile("mocks/terminal-api/payment-sync-error-empty.json");
        TerminalCloudAPI terminalCloudApi = new TerminalCloudAPI(client);

        TerminalAPIResponse terminalAPIResponse = terminalCloudApi.sync(new TerminalAPIRequest());

        assertNotNull(terminalAPIResponse);
        assertNotNull(terminalAPIResponse.getSaleToPOIRequest());
    }

    /**
     * Test error flow for POST /sync
     */
    @Test
    public void syncAbortRequestSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/terminal-api/abort-sync-success");
        TerminalCloudAPI terminalCloudApi = new TerminalCloudAPI(client);

        TerminalAPIRequest terminalAPIAbortRequest = new TerminalAPIRequest();

        TerminalAPIResponse terminalAPIResponse = terminalCloudApi.sync(terminalAPIAbortRequest);

        assertNull(terminalAPIResponse);
    }

    /**
     * Test success flow for Input Request on POST /sync
     */
    @Test
    public void syncInputRequestSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/terminal-api/input-request-success.json");
        TerminalCloudAPI terminalCloudApi = new TerminalCloudAPI(client);

        TerminalAPIResponse requestResponse = terminalCloudApi.sync(new TerminalAPIRequest());

        assertNotNull(requestResponse);
        assertNotNull(requestResponse.getSaleToPOIResponse());
        assertNotNull(requestResponse.getSaleToPOIResponse().getInputResponse());
        assertNotNull(requestResponse.getSaleToPOIResponse().getInputResponse().getInputResult());
        assertNotNull(requestResponse.getSaleToPOIResponse().getInputResponse().getInputResult().getInput());
        assertNotNull(requestResponse.getSaleToPOIResponse().getInputResponse().getInputResult().getInput().getMenuEntryNumber());
        assertEquals(2, requestResponse.getSaleToPOIResponse().getInputResponse().getInputResult().getInput().getMenuEntryNumber().size());
    }

    /**
     * Mocked response for stored value type for POST /sync
     */
    @Test
    public void syncPaymentRequestStoredValueSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/terminal-api/payment-sync-success-storedvalue.json");
        TerminalCloudAPI terminalCloudApi = new TerminalCloudAPI(client);

        TerminalAPIRequest terminalAPIPaymentRequest = new TerminalAPIRequest();

        // add some data
        SaleToPOIRequest saleToPOIRequest = new SaleToPOIRequest();
        PaymentRequest paymentRequest = new PaymentRequest();
        SaleData saleDataRequest = new SaleData();
        saleDataRequest.setSaleToAcquirerData("Base64string");
        paymentRequest.setSaleData(saleDataRequest);
        saleToPOIRequest.setPaymentRequest(paymentRequest);
        terminalAPIPaymentRequest.setSaleToPOIRequest(saleToPOIRequest);

        TerminalAPIResponse terminalAPIResponse = terminalCloudApi.sync(terminalAPIPaymentRequest);

        assertNotNull(terminalAPIResponse);
        assertNotNull(terminalAPIResponse.getSaleToPOIResponse());

        SaleToPOIResponse saleToPoiResponse = terminalAPIResponse.getSaleToPOIResponse();
        assertNotNull(saleToPoiResponse.getMessageHeader());
        assertNotNull(saleToPoiResponse.getStoredValueResponse());

        MessageHeader messageHeader = saleToPoiResponse.getMessageHeader();
        assertEquals(MessageType.RESPONSE, messageHeader.getMessageType());
        assertEquals(MessageClass.SERVICE, messageHeader.getMessageClass());
        assertEquals(MessageCategory.STOREDVALUE, messageHeader.getMessageCategory());
        assertEquals("3.0", messageHeader.getProtocolVersion());
        assertEquals("001", messageHeader.getSaleID());
        assertEquals("1234567890", messageHeader.getServiceID());
        assertEquals("P400Plus-123456789", messageHeader.getPOIID());

        assertNotNull(saleToPoiResponse.getStoredValueResponse().getResponse());
        Response response = saleToPoiResponse.getStoredValueResponse().getResponse();
        assertEquals(Result.SUCCESS, response.getResult());
        assertNotNull(response.getAdditionalResponse());

        assertNotNull(saleToPoiResponse.getStoredValueResponse().getPoIData());
        POIData poiData = saleToPoiResponse.getStoredValueResponse().getPoIData();
        assertEquals(1000, poiData.getPoIReconciliationID().intValue());
        assertNotNull(poiData.getPoIReconciliationID());
        assertEquals("4r7i001556529591000.8515565295894301", poiData.getPoITransactionID().getTransactionID());
        assertEquals("2019-04-29T00:00Z", poiData.getPoITransactionID().getTimeStamp().toString());

        assertNotNull(saleToPoiResponse.getStoredValueResponse().getSaleData());
        SaleData saleData = saleToPoiResponse.getStoredValueResponse().getSaleData();
        assertNotNull(saleData.getSaleTransactionID());
        assertEquals("001", saleData.getSaleTransactionID().getTransactionID());
        assertEquals("2019-04-29T00:00Z", saleData.getSaleTransactionID().getTimeStamp().toString());

        assertNotNull(saleToPoiResponse.getStoredValueResponse().getPaymentReceipt());
        assertFalse(saleToPoiResponse.getStoredValueResponse().getPaymentReceipt().isEmpty());
        List<PaymentReceipt> paymentReceiptList = saleToPoiResponse.getStoredValueResponse().getPaymentReceipt();
        for (PaymentReceipt paymentReceipt : paymentReceiptList) {
            assertNotNull(paymentReceipt.getDocumentQualifier());
            assertNotNull(paymentReceipt.getOutputContent());
            assertEquals(OutputFormat.TEXT, paymentReceipt.getOutputContent().getOutputFormat());
            assertNotNull(paymentReceipt.getOutputContent().getOutputText());
            assertFalse(paymentReceipt.getOutputContent().getOutputText().isEmpty());
            List<OutputText> outputTextList = paymentReceipt.getOutputContent().getOutputText();

            outputTextList.forEach(outputText -> assertNotNull(outputText.getText()));
        }
    }
}
