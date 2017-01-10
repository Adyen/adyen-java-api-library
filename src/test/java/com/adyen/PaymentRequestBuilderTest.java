package com.adyen;

import com.adyen.BaseTest;
import com.adyen.model.PaymentRequest;
import com.adyen.model.PaymentRequest3d;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PaymentRequestBuilderTest extends BaseTest {
    @Test
    public void TestCCPaymentRequest() {
        PaymentRequest paymentRequest = createFullCardPaymentRequest();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String paymentRequestJson = gson.toJson(paymentRequest);

        String expected = "{\n" +
                "  \"card\": {\n" +
                "    \"expiryMonth\": \"08\",\n" +
                "    \"expiryYear\": \"2018\",\n" +
                "    \"cvc\": \"737\",\n" +
                "    \"holderName\": \"John Doe\",\n" +
                "    \"number\": \"5136333333333335\"\n" +
                "  },\n" +
                "  \"amount\": {\n" +
                "    \"value\": 100000,\n" +
                "    \"currency\": \"EUR\"\n" +
                "  },\n" +
                "  \"reference\": \"123456\",\n" +
                "  \"shopperIP\": \"1.2.3.4\",\n" +
                "  \"merchantAccount\": \"AMerchant\",\n" +
                "  \"browserInfo\": {\n" +
                "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n" +
                "    \"acceptHeader\": \"*/*\"\n" +
                "  }\n" +
                "}";

        assertEquals(expected, paymentRequestJson);
    }

    @Test
    public void TestCSEPaymentRequest() {
        PaymentRequest paymentRequest = createCSEPaymentRequest();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String paymentRequestJson = gson.toJson(paymentRequest);

        String expected = "{\n" +
                "  \"amount\": {\n" +
                "    \"value\": 100000,\n" +
                "    \"currency\": \"EUR\"\n" +
                "  },\n" +
                "  \"reference\": \"123456\",\n" +
                "  \"shopperIP\": \"1.2.3.4\",\n" +
                "  \"merchantAccount\": \"AMerchant\",\n" +
                "  \"browserInfo\": {\n" +
                "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n" +
                "    \"acceptHeader\": \"*/*\"\n" +
                "  },\n" +
                "  \"additionalData\": {\n" +
                "    \"card.encrypted.json\": \"adyenjs_0_1_4p1$...\"\n" +
                "  }\n" +
                "}";

        assertEquals(expected, paymentRequestJson);
    }

    @Test
    public void Test3DSecureRequest() {
        PaymentRequest3d paymentRequest3d = create3DPaymentRequest();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String paymentRequestJson = gson.toJson(paymentRequest3d);
        String expected = "{\n" +
                "  \"md\": \"mdString\",\n" +
                "  \"paResponse\": \"paResString\",\n" +
                "  \"shopperIP\": \"1.2.3.4\",\n" +
                "  \"merchantAccount\": \"AMerchant\",\n" +
                "  \"browserInfo\": {\n" +
                "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n" +
                "    \"acceptHeader\": \"*/*\"\n" +
                "  }\n" +
                "}";

        assertEquals(expected, paymentRequestJson);
    }
}
