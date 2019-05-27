package com.adyen;

import com.adyen.model.PaymentResult;
import com.google.gson.Gson;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class PaymentResultTest extends BaseTest {

    @Test
    public void TestAuthenticationFinishedResultCodeDeserialization() {
        Gson gson = new Gson();
        String response = "{\"resultCode\": \"AuthenticationFinished\"}";
        PaymentResult result = gson.fromJson(response, PaymentResult.class);
        assertNotNull(result.getResultCode());
    }
}
