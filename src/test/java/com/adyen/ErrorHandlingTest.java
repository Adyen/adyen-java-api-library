package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.model.checkout.PaymentLinkResponse;
import com.adyen.model.management.AllowedOriginsResponse;
import com.adyen.model.management.CreateAllowedOriginRequest;
import com.adyen.service.Checkout;
import com.adyen.service.exception.ApiException;
import com.adyen.service.management.MyApiCredential;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

public class ErrorHandlingTest extends BaseTest{
    @Test
    @Ignore("Integration test")
    public void addAllowedOriginFail() throws IOException, ApiException {
        Client client = new Client(System.getenv("API_KEY"), Environment.TEST);
        MyApiCredential service = new MyApiCredential(client);

        CreateAllowedOriginRequest createAllowedOriginRequest = new CreateAllowedOriginRequest();
        createAllowedOriginRequest.setDomain("https://google.com");
        try
        {
            AllowedOriginsResponse response = service.addAllowedOrigin(createAllowedOriginRequest);
        } catch(ApiException e) {
            Assert.assertTrue(e.getMessage().contains("Invalid allowed origin information provided."));
        }
    }

    @Test
    @Ignore("Integration test")
    public void CheckoutErrorTest() throws IOException, ApiException {
        Client client = new Client(System.getenv("API_KEY"), Environment.TEST);
        Checkout service = new Checkout(client);
        try
        {
            PaymentLinkResponse response = service.getPaymentLinks("1234");
        } catch(ApiException e) {
            Assert.assertTrue(e.getMessage().contains("Invalid payment link ID"));
        }
    }
}
