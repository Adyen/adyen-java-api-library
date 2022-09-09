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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.constants.ApiConstants;
import com.adyen.model.payments.*;
import com.google.gson.JsonParser;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.Assert.assertEquals;

public class PaymentRequestBuilderTest extends BaseTest {
    @Test
    public void TestCCPaymentRequest() {
        String integratorName = "TestIntegrator";
        PaymentRequest paymentRequest = createFullCardPaymentRequest();
        paymentRequest.setApplicationInfo(applicationInfo);
        ExternalPlatform externalPlatform = new ExternalPlatform();
        externalPlatform.setIntegrator(integratorName);
        paymentRequest.getApplicationInfo().setExternalPlatform(externalPlatform);

        // Test metadata
        paymentRequest.setMetadata(new HashMap<>());
        paymentRequest.getMetadata().put("key", "value");

        // Test recurring processing model
        paymentRequest.setRecurringProcessingModel(PaymentRequest.RecurringProcessingModelEnum.CARDONFILE);

        String paymentRequestJson = PRETTY_PRINT_GSON.toJson(paymentRequest);

        String expected = "{\n"
                + "  \"card\": {\n"
                + "    \"expiryMonth\": \"08\",\n"
                + "    \"expiryYear\": \"2018\",\n"
                + "    \"cvc\": \"737\",\n"
                + "    \"holderName\": \"John Doe\",\n"
                + "    \"number\": \"5136333333333335\"\n"
                + "  },\n"
                + "  \"recurringProcessingModel\": \"CardOnFile\",\n"
                + "  \"amount\": {\n"
                + "    \"value\": 100000,\n"
                + "    \"currency\": \"EUR\"\n"
                + "  },\n"
                + "  \"reference\": \"123456\",\n"
                + "  \"shopperIP\": \"1.2.3.4\",\n"
                + "  \"threeDSAuthenticationOnly\": false,\n"
                + "  \"merchantAccount\": \"AMerchant\",\n"
                + "  \"browserInfo\": {\n"
                + "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n"
                + "    \"acceptHeader\": \"*/*\",\n"
                + "    \"javaScriptEnabled\": true\n"
                + "  },\n"
                + "  \"metadata\": {\n"
                + "    \"key\": \"value\"\n"
                + "  },\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    },\n"
                + "    \"externalPlatform\": {\n"
                + "      \"integrator\": \""
                + integratorName
                + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}";

        assertJsonStringEquals(expected, paymentRequestJson);
    }

    @Test
    public void TestCSEPaymentRequest() {
        PaymentRequest paymentRequest = createCSEPaymentRequest();
        paymentRequest.setApplicationInfo(applicationInfo);

        String paymentRequestJson = PRETTY_PRINT_GSON.toJson(paymentRequest);

        String expected = "{\n"
                + "  \"amount\": {\n"
                + "    \"value\": 100000,\n"
                + "    \"currency\": \"EUR\"\n"
                + "  },\n"
                + "  \"reference\": \"123456\",\n"
                + "  \"shopperIP\": \"1.2.3.4\",\n"
                + "  \"threeDSAuthenticationOnly\": false,\n"
                + "  \"merchantAccount\": \"AMerchant\",\n"
                + "  \"browserInfo\": {\n"
                + "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n"
                + "    \"acceptHeader\": \"*/*\",\n"
                + "    \"javaScriptEnabled\": true\n"
                + "  },\n"
                + "  \"additionalData\": {\n"
                + "    \"card.encrypted.json\": \"adyenjs_0_1_4p1$...\"\n"
                + "  },\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}";

        assertJsonStringEquals(expected, paymentRequestJson);
    }

    @Test
    public void Test3DSecureRequest() {
        PaymentRequest3d paymentRequest3d = create3DPaymentRequest();
        paymentRequest3d.setApplicationInfo(applicationInfo);

        String paymentRequestJson = PRETTY_PRINT_GSON.toJson(paymentRequest3d);
        String expected = "{\n"
                + "  \"md\": \"mdString\",\n"
                + "  \"paResponse\": \"paResString\",\n"
                + "  \"shopperIP\": \"1.2.3.4\",\n"
                + "  \"threeDSAuthenticationOnly\": false,\n"
                + "  \"merchantAccount\": \"AMerchant\",\n"
                + "  \"browserInfo\": {\n"
                + "    \"userAgent\": \"User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36\",\n"
                + "    \"acceptHeader\": \"*/*\",\n"
                + "    \"javaScriptEnabled\": true\n"
                + "  },\n"
                + "  \"applicationInfo\": {\n"
                + "    \"adyenLibrary\": {\n"
                + "      \"name\": \"" + LIB_NAME + "\",\n"
                + "      \"version\": \"" + LIB_VERSION + "\"\n"
                + "    }\n"
                + "  }\n"
                + "}";

        assertJsonStringEquals(expected, paymentRequestJson);
    }

    @Test
    public void TestSecuredFieldsPaymentRequest() {
        PaymentRequest paymentRequest = new PaymentRequest();
        Card card = new Card();
        card.setHolderName("cardHolder");
        paymentRequest.setCard(card);
        Map<String, String> additionalData = new HashMap<>();
        additionalData.put(ApiConstants.AdditionalData.ENCRYPTED_CARD_NUMBER, "encryptedCardNumber");
        additionalData.put(ApiConstants.AdditionalData.ENCRYPTED_EXPIRY_MONTH, "encryptedExpiryMonth");
        additionalData.put(ApiConstants.AdditionalData.ENCRYPTED_EXPIRY_YEAR, "encryptedExpiryYear");
        additionalData.put(ApiConstants.AdditionalData.ENCRYPTED_SECURITY_CODE, "encryptedSecurityCode");
        paymentRequest.setAdditionalData(additionalData);

        assertEquals(additionalData, paymentRequest.getAdditionalData());
        assertEquals("cardHolder", paymentRequest.getCard().getHolderName());
    }

    private void assertJsonStringEquals(String firstInput, String secondInput) {
        JsonParser parser = new JsonParser();
        assertEquals(parser.parse(firstInput), parser.parse(secondInput));
    }
}
