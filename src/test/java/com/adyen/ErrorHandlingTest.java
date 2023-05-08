package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.model.management.CreateAllowedOriginRequest;
import com.adyen.service.checkout.PaymentLinksApi;
import com.adyen.service.exception.ApiException;
import com.adyen.service.management.MyApiCredentialApi;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class ErrorHandlingTest extends BaseTest{
    @Test
    @Ignore("Integration test")
    public void addAllowedOriginFail() throws IOException, ApiException {
        Client client = new Client(System.getenv("API_KEY"), Environment.TEST);
        MyApiCredentialApi service = new MyApiCredentialApi(client);

        CreateAllowedOriginRequest createAllowedOriginRequest = new CreateAllowedOriginRequest();
        createAllowedOriginRequest.setDomain("https://google.com");
        try
        {
            service.addAllowedOrigin(createAllowedOriginRequest);
        } catch(ApiException e) {
            Assert.assertTrue(e.getResponseBody().contains("Invalid allowed origin information provided."));
        }
    }

    @Test
    @Ignore("Integration test")
    public void CheckoutErrorTest() throws IOException, ApiException {
        Client client = new Client(System.getenv("API_KEY"), Environment.TEST);
        PaymentLinksApi service = new PaymentLinksApi(client);
        try
        {
            service.getPaymentLink("1234");
        } catch(ApiException e) {
            Assert.assertTrue(e.getResponseBody().contains("Invalid payment link ID"));
        }
    }
}
