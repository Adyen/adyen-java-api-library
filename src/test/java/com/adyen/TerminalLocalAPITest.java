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

import com.adyen.terminal.TerminalAPIRequest;
import com.adyen.terminal.TerminalAPIResponse;
import com.adyen.model.terminal.*;
import com.adyen.terminal.*;
import com.adyen.service.TerminalLocalAPI;
import com.adyen.service.TerminalLocalAPIUnencrypted;
import com.adyen.terminal.security.SecurityKey;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Tests for local Terminal API request
 */
public class TerminalLocalAPITest extends BaseTest {
// TODO fix this test (need to change the security details as the hmac validation throws an error because we changed the payload)

//    /**
//     * Test success flow for local request
//     */
//    @Test
//    public void syncPaymentRequestSuccess() throws Exception {
//        Client client = createMockClientFromFile("mocks/terminal-api/payment-local-success.json");
//        SecurityKey securityKey = new SecurityKey();
//        securityKey.setKeyVersion(1);
//        securityKey.setAdyenCryptoVersion(1);
//        securityKey.setKeyIdentifier("CryptoKeyIdentifier12345");
//        securityKey.setPassphrase("p@ssw0rd123456");
//        TerminalLocalAPI terminalLocalApi = new TerminalLocalAPI(client, securityKey);
//
//        TerminalAPIRequest terminalAPIPaymentRequest = createTerminalAPIPaymentRequest();
//        TerminalAPIResponse terminalAPIResponse = terminalLocalApi.request(terminalAPIPaymentRequest);
//
//        assertNotNull(terminalAPIResponse);
//        assertNotNull(terminalAPIResponse.getSaleToPOIResponse());
//
//        SaleToPOIResponse saleToPoiResponse = terminalAPIResponse.getSaleToPOIResponse();
//        assertNotNull(saleToPoiResponse.getMessageHeader());
//        assertNotNull(saleToPoiResponse.getPaymentResponse());
//
//        MessageHeader messageHeader = saleToPoiResponse.getMessageHeader();
//        assertEquals(MessageType.RESPONSE, messageHeader.getMessageType());
//        assertEquals(MessageClass.SERVICE, messageHeader.getMessageClass());
//        assertEquals(MessageCategory.PAYMENT, messageHeader.getMessageCategory());
//        assertEquals("3.0", messageHeader.getProtocolVersion());
//        assertEquals("325488592", messageHeader.getSaleID());
//        assertEquals("325488592", messageHeader.getServiceID());
//        assertEquals("P400Plus-275039202", messageHeader.getPOIID());
//
//        assertNotNull(saleToPoiResponse.getPaymentResponse().getResponse());
//        Response response = saleToPoiResponse.getPaymentResponse().getResponse();
//        assertEquals(Result.SUCCESS, response.getResult());
//        assertNotNull(response.getAdditionalResponse());
//
//        assertNotNull(saleToPoiResponse.getPaymentResponse().getPoIData());
//        POIData poiData = saleToPoiResponse.getPaymentResponse().getPoIData();
//        assertEquals("1000", poiData.getPoITransactionID());
//        assertNotNull(poiData.getPoITransactionID());
//        assertEquals("4r7i001557325515012.8815573255107661", poiData.getPoITransactionID().getTransactionID());
//        assertEquals("2019-05-08T14:25:15.000Z", poiData.getPoITransactionID().getTimeStamp().toString());
//
//        assertNotNull(saleToPoiResponse.getPaymentResponse().getSaleData());
//        SaleData saleData = saleToPoiResponse.getPaymentResponse().getSaleData();
//        assertNotNull(saleData.getSaleTransactionID());
//        assertEquals("999", saleData.getSaleTransactionID().getTransactionID());
//        assertEquals("2019-05-08T14:24:48.598Z", saleData.getSaleTransactionID().getTimeStamp().toString());
//
//        assertNotNull(saleToPoiResponse.getPaymentResponse().getPaymentReceipt());
//        assertFalse(saleToPoiResponse.getPaymentResponse().getPaymentReceipt().isEmpty());
//        List<PaymentReceipt> paymentReceiptList = saleToPoiResponse.getPaymentResponse().getPaymentReceipt();
//        for (PaymentReceipt paymentReceipt : paymentReceiptList) {
//            assertNotNull(paymentReceipt.getDocumentQualifier());
//            assertNotNull(paymentReceipt.getOutputContent());
//            assertEquals(OutputFormat.TEXT, paymentReceipt.getOutputContent().getOutputFormat());
//            assertNotNull(paymentReceipt.getOutputContent().getOutputText());
//            assertFalse(paymentReceipt.getOutputContent().getOutputText().isEmpty());
//            List<OutputText> outputTextList = paymentReceipt.getOutputContent().getOutputText();
//            for(OutputText outputText : outputTextList) {
//                assertNotNull(outputText.getText());
//            }
//        }
//
//        assertNotNull(saleToPoiResponse.getPaymentResponse().getPaymentResult());
//        PaymentResult paymentResult = saleToPoiResponse.getPaymentResponse().getPaymentResult();
//        assertTrue(paymentResult.getOnlineFlag());
//        assertNotNull(paymentResult.getPaymentAcquirerData());
//        assertEquals("P400Plus-275039202", paymentResult.getPaymentAcquirerData().getAcquirerPOIID());
//        assertEquals("123456", paymentResult.getPaymentAcquirerData().getApprovalCode());
//        assertEquals("TestMerchantRenatoTest", paymentResult.getPaymentAcquirerData().getMerchantID());
//        assertNotNull(paymentResult.getPaymentAcquirerData().getAcquirerTransactionID());
//        assertNotNull(paymentResult.getPaymentInstrumentData());
//        assertNotNull(paymentResult.getPaymentInstrumentData().getCardData());
//        assertEquals("mc", paymentResult.getPaymentInstrumentData().getCardData().getPaymentBrand());
//        assertEquals("541333 **** 0010", paymentResult.getPaymentInstrumentData().getCardData().getMaskedPan());
//        assertEquals(PaymentInstrumentType.CARD, paymentResult.getPaymentInstrumentData().getPaymentInstrumentType());
//        assertNotNull(paymentResult.getAmountsResp());
//        assertEquals("EUR", paymentResult.getAmountsResp().getCurrency());
//        assertEquals(BigDecimal.ONE, paymentResult.getAmountsResp().getAuthorizedAmount());
//    }

    /**
     * Test success flow for local request unencrypted
     */
    @Test
    public void unencryptedPaymentRequestSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/terminal-api/payment-sync-success.json");
        TerminalLocalAPIUnencrypted terminalLocalAPIUnencrypted = new TerminalLocalAPIUnencrypted(client);
        TerminalAPIResponse response = terminalLocalAPIUnencrypted.request(new TerminalAPIRequest());
        assertNotNull(response);
        assertNotNull(response.getSaleToPOIResponse());

        SaleToPOIResponse saleToPoiResponse = response.getSaleToPOIResponse();
        assertNotNull(saleToPoiResponse.getMessageHeader());
        assertNotNull(saleToPoiResponse.getPaymentResponse());
    }
}
