package com.adyen.security.clouddevice;

import com.adyen.BaseTest;
import com.adyen.model.clouddevice.*;
import org.apache.commons.codec.binary.Base64;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;

import static org.junit.Assert.*;

public class NexoSecurityManagerTest extends BaseTest {

    @Test
    public void testEncryptDecrypt() throws Exception {
        EncryptionCredentialDetails encryptionCredentialDetails = new EncryptionCredentialDetails()
                .adyenCryptoVersion(1)
                .keyIdentifier("SpecV2TestMACKey")
                .keyVersion(1)
                .passphrase("12345678901234567890123456789012");

        NexoSecurityManager nexoSecurityManager = new NexoSecurityManager(encryptionCredentialDetails);

        CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();

        // encrypt CloudDeviceApiRequest
        SaleToPOISecuredMessage saleToPoiSecuredMessage = nexoSecurityManager.encrypt(cloudDeviceApiRequest.toJson(), cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader());

        assertNotNull(saleToPoiSecuredMessage.getMessageHeader());
        assertNotNull(saleToPoiSecuredMessage.getNexoBlob());
        assertNotNull(saleToPoiSecuredMessage.getSecurityTrailer());
        assertNotNull(saleToPoiSecuredMessage.getSecurityTrailer().getHmac());

        // decrypt SaleToPOISecuredMessage
        String decryptedSaleToPoiMessageJson = nexoSecurityManager.decrypt(saleToPoiSecuredMessage);
        assertEquals(cloudDeviceApiRequest.toJson(), decryptedSaleToPoiMessageJson);
    }

    @Test
    public void testInvalidSecurityKey() {
        try {
            new NexoSecurityManager(null);
            fail("Expected exception");
        } catch (NexoSecurityException e) {
            assertEquals("Invalid Security Key", e.getMessage());
        }

        try {
            new NexoSecurityManager(new EncryptionCredentialDetails());
            fail("Expected exception");
        } catch (NexoSecurityException e) {
            assertEquals("Invalid Security Key", e.getMessage());
        }
    }

    @Test
    public void testInvalidHmac() throws Exception {
        EncryptionCredentialDetails encryptionCredentialDetails = new EncryptionCredentialDetails()
                .adyenCryptoVersion(1)
                .keyIdentifier("SpecV2TestMACKey")
                .keyVersion(1)
                .passphrase("12345678901234567890123456789012");

        NexoSecurityManager nexoSecurityManager = new NexoSecurityManager(encryptionCredentialDetails);

        CloudDeviceApiRequest cloudDeviceApiRequest = createCloudDeviceAPIPaymentRequest();


        SaleToPOISecuredMessage saleToPoiSecuredMessage = nexoSecurityManager.encrypt(cloudDeviceApiRequest.toJson(), cloudDeviceApiRequest.getSaleToPOIRequest().getMessageHeader());

        // Tamper with the HMAC
        saleToPoiSecuredMessage.getSecurityTrailer().setHmac("invalidhmac".getBytes());

        try {
            nexoSecurityManager.decrypt(saleToPoiSecuredMessage);
            fail("Expected exception");
        } catch (NexoSecurityException e) {
            assertEquals("HMAC validation failed", e.getMessage());
        }
    }

    @Test
    public void testHmac() throws  Exception {
        EncryptionCredentialDetails encryptionCredentialDetails = new EncryptionCredentialDetails()
            .adyenCryptoVersion(1)
            .keyIdentifier("SpecV2TestMACKey")
            .keyVersion(1)
            .passphrase("12345678901234567890123456789012");

        NexoSecurityManager nexoSecurityManager = new NexoSecurityManager(encryptionCredentialDetails);

        byte[] message = "0123456789abcdef0123456789abcdef".getBytes(StandardCharsets.UTF_8);

        byte[] actualHmac = nexoSecurityManager.hmac(message, nexoSecurityManager.getNexoDerivedKey());

        assertEquals("HMAC-SHA256 should produce 32 bytes", 32, actualHmac.length);
        assertEquals("HMAC signagtures don't match", "GWYcM3JVYrY3b9CSLCuJ+THMxclBG9jJ05n+RR6DkQE=", Base64.encodeBase64String(actualHmac));
    }

    protected CloudDeviceApiRequest createCloudDeviceAPIPaymentRequest() {
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

        PaymentRequest paymentRequest = new PaymentRequest();

        SaleData saleData = new SaleData();
        TransactionIdentification transactionIdentification = new TransactionIdentification();
        transactionIdentification.setTransactionID("001");
        OffsetDateTime timestamp = OffsetDateTime.now(ZoneOffset.UTC);
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

        CloudDeviceApiRequest cloudDeviceApiRequest = new CloudDeviceApiRequest();
        cloudDeviceApiRequest.setSaleToPOIRequest(saleToPOIRequest);

        return cloudDeviceApiRequest;
    }


}
