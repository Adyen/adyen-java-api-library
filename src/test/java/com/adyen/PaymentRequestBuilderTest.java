package com.adyen;

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

    @Test
    public void TestOpenInvoiceRequest() {

        PaymentRequest paymentRequestOpenInvoice = createOpenInvoicePaymentRequest();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String paymentRequestJson = gson.toJson(paymentRequestOpenInvoice);
        String expected = "{\n" +
                "  \"amount\": {\n" +
                "    \"value\": 20000,\n" +
                "    \"currency\": \"EUR\"\n" +
                "  },\n" +
                "  \"reference\": \"123456\",\n" +
                "  \"billingAddress\": {\n" +
                "    \"city\": \"Gravenhage\",\n" +
                "    \"country\": \"NL\",\n" +
                "    \"houseNumberOrName\": \"1\",\n" +
                "    \"postalCode\": \"2521VA\",\n" +
                "    \"stateOrProvince\": \"Zuid-Holland\",\n" +
                "    \"street\": \"Neherkade\"\n" +
                "  },\n" +
                "  \"shopperIP\": \"1.2.3.4\",\n" +
                "  \"merchantAccount\": \"AMerchant\",\n" +
                "  \"browserInfo\": {\n" +
                "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n" +
                "    \"acceptHeader\": \"*/*\"\n" +
                "  },\n" +
                "  \"shopperEmail\": \"youremail@email.com\",\n" +
                "  \"shopperReference\": \"4\",\n" +
                "  \"additionalData\": {\n" +
                "    \"openinvoicedata.numberOfLines\": \"2\",\n" +
                "    \"openinvoicedata.line2.itemAmount\": \"9000\",\n" +
                "    \"openinvoicedata.line1.numberOfItems\": \"1\",\n" +
                "    \"openinvoicedata.line2.currencyCode\": \"EUR\",\n" +
                "    \"openinvoicedata.line2.itemVatPercentage\": \"1000\",\n" +
                "    \"openinvoicedata.line2.numberOfItems\": \"1\",\n" +
                "    \"openinvoicedata.line1.itemVatAmount\": \"1000\",\n" +
                "    \"openinvoicedata.line1.description\": \"Test product\",\n" +
                "    \"openinvoicedata.line2.itemVatAmount\": \"1000\",\n" +
                "    \"openinvoicedata.line1.itemVatPercentage\": \"1000\",\n" +
                "    \"openinvoicedata.line2.description\": \"Test product 2\",\n" +
                "    \"openinvoicedata.line1.itemAmount\": \"9000\",\n" +
                "    \"openinvoicedata.line2.vatCategory\": \"None\",\n" +
                "    \"openinvoicedata.line1.vatCategory\": \"None\",\n" +
                "    \"openinvoicedata.line1.currencyCode\": \"EUR\"\n" +
                "  },\n" +
                "  \"shopperName\": {\n" +
                "    \"gender\": \"MALE\",\n" +
                "    \"lastName\": \"Approved\",\n" +
                "    \"firstName\": \"Testperson-nl\"\n" +
                "  },\n" +
                "  \"selectedBrand\": \"klarna\",\n" +
                "  \"deliveryAddress\": {\n" +
                "    \"city\": \"Gravenhage\",\n" +
                "    \"country\": \"NL\",\n" +
                "    \"houseNumberOrName\": \"1\",\n" +
                "    \"postalCode\": \"2521VA\",\n" +
                "    \"stateOrProvince\": \"Zuid-Holland\",\n" +
                "    \"street\": \"Neherkade\"\n" +
                "  },\n" +
                "  \"dateOfBirth\": \"1970-07-10\",\n" +
                "  \"telephoneNumber\": \"0612345678\"\n" +
                "}";

        assertEquals(expected, paymentRequestJson);
    }
}
