package com.adyen.model.marketpay.notification;

import com.adyen.model.marketpay.ErrorFieldType;
import com.adyen.model.marketpay.ErrorFieldTypeContainer;
import com.adyen.model.marketpay.FieldType;
import com.adyen.model.marketpay.Message;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.time.Instant;
import java.util.Collections;
import java.util.Date;

import static com.adyen.model.marketpay.FieldType.FieldNameEnum.FIRSTNAME;
import static org.junit.Assert.assertEquals;

public class PaymentFailureNotificationTest {

    @Test
    public void testPaymentFailureNotificationCanBeDeserialized() throws Exception {
        String json = "{\n" +
                "  \"eventType\":null,\n" +
                "  \"content\":{\n" +
                "    \"errorMessage\":{\n" +
                "      \"code\":\"message-code\",\n" +
                "      \"text\":\"message-text\"\n" +
                "    },\n" +
                "    \"modificationMerchantReference\":\"modification-merchant-reference\",\n" +
                "    \"modificationPspReference\":\"modification-psp-reference\",\n" +
                "    \"paymentMerchantReference\":\"payment-merchant-reference\",\n" +
                "    \"paymentPspReference\":\"TSTPSPR0001\",\n" +
                "    \"errorFieldList\":[\n" +
                "      {\n" +
                "        \"errorDescription\":\"error-description\",\n" +
                "        \"errorCode\":3,\n" +
                "        \"fieldType\":{\n" +
                "          \"fieldName\":\"firstName\",\n" +
                "          \"field\":\"field\",\n" +
                "          \"shareholderCode\":\"shareholder-code\"\n" +
                "        }\n" +
                "      }\n" +
                "    ],\n" +
                "    \"errorFields\":[\n" +
                "      {\n" +
                "        \"ErrorFieldType\":{\n" +
                "          \"errorDescription\":\"error-description\",\n" +
                "          \"errorCode\":3,\n" +
                "          \"fieldType\":{\n" +
                "            \"fieldName\":\"firstName\",\n" +
                "            \"field\":\"field\",\n" +
                "            \"shareholderCode\":\"shareholder-code\"\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  },\n" +
                "  \"error\":{\n" +
                "    \"errorCode\":\"error-code\",\n" +
                "    \"message\":\"error-message\"\n" +
                "  },\n" +
                "  \"eventDate\":0,\n" +
                "  \"executingUserKey\":\"executing-user-key\",\n" +
                "  \"live\":true,\n" +
                "  \"pspReference\":\"TSTPSPR0001\"\n" +
                "}";

        PaymentFailureNotification paymentFailureNotification = new ObjectMapper().reader().forType(PaymentFailureNotification.class).readValue(json);

        String pspReference = "TSTPSPR0001";
        PaymentFailureNotificationContent content = new PaymentFailureNotificationContent();
        content.setPaymentPspReference(pspReference);
        content.setPaymentMerchantReference("payment-merchant-reference");
        content.setModificationPspReference("modification-psp-reference");
        content.setModificationMerchantReference("modification-merchant-reference");
        Message errorMessage = new Message();
        errorMessage.setCode("message-code");
        errorMessage.setText("message-text");
        content.setErrorMessage(errorMessage);
        content.setErrorFieldTypeContainers(
                Collections.singletonList(
                        new ErrorFieldTypeContainer(
                                new ErrorFieldType()
                                        .errorCode(3)
                                        .fieldType(new FieldType().field("field").shareholderCode("shareholder-code").fieldName(FIRSTNAME))
                                        .errorDescription("error-description"))));
        assertEquals(paymentFailureNotification,
                new PaymentFailureNotification()
                        .error(new NotificationErrorContainer()
                                .errorCode("error-code")
                                .message("error-message"))
                        .eventDate(Date.from(Instant.EPOCH))
                        .executingUserKey("executing-user-key")
                        .live(true)
                        .pspReference(pspReference)
                        .content(content));
    }
}