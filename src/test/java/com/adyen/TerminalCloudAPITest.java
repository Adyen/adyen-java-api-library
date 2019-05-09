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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.nexo.MessageCategoryType;
import com.adyen.model.nexo.MessageClassType;
import com.adyen.model.nexo.MessageHeader;
import com.adyen.model.nexo.MessageType;
import com.adyen.model.nexo.OutputFormatType;
import com.adyen.model.nexo.OutputText;
import com.adyen.model.nexo.POIData;
import com.adyen.model.nexo.PaymentInstrumentType;
import com.adyen.model.nexo.PaymentReceipt;
import com.adyen.model.nexo.PaymentResult;
import com.adyen.model.nexo.Response;
import com.adyen.model.nexo.ResultType;
import com.adyen.model.nexo.SaleData;
import com.adyen.model.nexo.SaleToPOIResponse;
import com.adyen.model.terminal.TerminalAPIRequest;
import com.adyen.model.terminal.TerminalAPIResponse;
import com.adyen.service.TerminalCloudAPI;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
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

        TerminalAPIRequest terminalAPIPaymentRequest = createTerminalAPIPaymentRequest();

        String requestResponse = terminalCloudApi.async(terminalAPIPaymentRequest);

        assertNotNull(requestResponse);
        assertEquals("ok", requestResponse);
    }

    /**
     * Test success flow for POST /sync
     */
    @Test
    public void syncPaymentRequestSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/terminal-api/payment-sync-success.json");
        TerminalCloudAPI terminalCloudApi = new TerminalCloudAPI(client);

        TerminalAPIRequest terminalAPIPaymentRequest = createTerminalAPIPaymentRequest();

        TerminalAPIResponse terminalAPIResponse = terminalCloudApi.sync(terminalAPIPaymentRequest);

        assertNotNull(terminalAPIResponse);
        assertNotNull(terminalAPIResponse.getSaleToPOIResponse());

        SaleToPOIResponse saleToPoiResponse = terminalAPIResponse.getSaleToPOIResponse();
        assertNotNull(saleToPoiResponse.getMessageHeader());
        assertNotNull(saleToPoiResponse.getPaymentResponse());

        MessageHeader messageHeader = saleToPoiResponse.getMessageHeader();
        assertEquals(MessageType.RESPONSE, messageHeader.getMessageType());
        assertEquals(MessageClassType.SERVICE, messageHeader.getMessageClass());
        assertEquals(MessageCategoryType.PAYMENT, messageHeader.getMessageCategory());
        assertEquals("3.0", messageHeader.getProtocolVersion());
        assertEquals("001", messageHeader.getSaleID());
        assertEquals("1234567890", messageHeader.getServiceID());
        assertEquals("P400Plus-123456789", messageHeader.getPOIID());

        assertNotNull(saleToPoiResponse.getPaymentResponse().getResponse());
        Response response = saleToPoiResponse.getPaymentResponse().getResponse();
        assertEquals(ResultType.SUCCESS, response.getResult());
        assertNotNull(response.getAdditionalResponse());

        assertNotNull(saleToPoiResponse.getPaymentResponse().getPOIData());
        POIData poiData = saleToPoiResponse.getPaymentResponse().getPOIData();
        assertEquals("1000", poiData.getPOIReconciliationID());
        assertNotNull(poiData.getPOITransactionID());
        assertEquals("4r7i001556529591000.8515565295894301", poiData.getPOITransactionID().getTransactionID());
        assertEquals("2019-04-29T00:00:00.000Z", poiData.getPOITransactionID().getTimeStamp().toString());

        assertNotNull(saleToPoiResponse.getPaymentResponse().getSaleData());
        SaleData saleData = saleToPoiResponse.getPaymentResponse().getSaleData();
        assertNotNull(saleData.getSaleTransactionID());
        assertEquals("001", saleData.getSaleTransactionID().getTransactionID());
        assertEquals("2019-04-29T00:00:00.000Z", saleData.getSaleTransactionID().getTimeStamp().toString());

        assertNotNull(saleToPoiResponse.getPaymentResponse().getPaymentReceipt());
        assertFalse(saleToPoiResponse.getPaymentResponse().getPaymentReceipt().isEmpty());
        List<PaymentReceipt> paymentReceiptList = saleToPoiResponse.getPaymentResponse().getPaymentReceipt();
        for (PaymentReceipt paymentReceipt : paymentReceiptList) {
            assertNotNull(paymentReceipt.getDocumentQualifier());
            assertNotNull(paymentReceipt.getOutputContent());
            assertEquals(OutputFormatType.TEXT, paymentReceipt.getOutputContent().getOutputFormat());
            assertNotNull(paymentReceipt.getOutputContent().getOutputText());
            assertFalse(paymentReceipt.getOutputContent().getOutputText().isEmpty());
            List<OutputText> outputTextList = paymentReceipt.getOutputContent().getOutputText();
            for(OutputText outputText : outputTextList) {
                assertNotNull(outputText.getText());
            }
        }

        assertNotNull(saleToPoiResponse.getPaymentResponse().getPaymentResult());
        PaymentResult paymentResult = saleToPoiResponse.getPaymentResponse().getPaymentResult();
        assertTrue(paymentResult.isOnlineFlag());
        assertNotNull(paymentResult.getPaymentAcquirerData());
        assertEquals("P400Plus-123456789", paymentResult.getPaymentAcquirerData().getAcquirerPOIID());
        assertEquals("123456", paymentResult.getPaymentAcquirerData().getApprovalCode());
        assertEquals("TestMerchant", paymentResult.getPaymentAcquirerData().getMerchantID());
        assertNotNull(paymentResult.getPaymentAcquirerData().getAcquirerTransactionID());
        assertNotNull(paymentResult.getPaymentInstrumentData());
        assertNotNull(paymentResult.getPaymentInstrumentData().getCardData());
        assertEquals("mc", paymentResult.getPaymentInstrumentData().getCardData().getPaymentBrand());
        assertEquals("411111 **** 1111", paymentResult.getPaymentInstrumentData().getCardData().getMaskedPAN());
        assertEquals(PaymentInstrumentType.CARD, paymentResult.getPaymentInstrumentData().getPaymentInstrument());
        assertNotNull(paymentResult.getAmountsResp());
        assertEquals("EUR", paymentResult.getAmountsResp().getCurrency());
        assertEquals(BigDecimal.ONE, paymentResult.getAmountsResp().getAuthorizedAmount());
    }
}
