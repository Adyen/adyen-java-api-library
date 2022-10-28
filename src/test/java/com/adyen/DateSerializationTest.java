package com.adyen;

import com.adyen.httpclient.ClientInterface;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.checkout.CreateCheckoutSessionRequest;
import com.adyen.model.checkout.CreatePaymentLinkRequest;
import com.adyen.model.checkout.PaymentSessionRequest;
import com.adyen.model.checkout.PaymentsRequest;
import com.adyen.service.Checkout;
import com.adyen.service.PaymentLinks;
import com.adyen.service.exception.ApiException;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

public class DateSerializationTest extends BaseTest {

    /*
    Tests for checking if all models in the Checkout classes are actually serializing Date objects as ISO8601 strings

    (note: dateOfBirth also gets serialized to ISO8601 which is fine one API side)
    */
    private Date date() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, 5);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        return cal.getTime();
    }
    @Test
    public void TestCheckoutSessionDate() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/checkout/sessions-success.json");
        Checkout checkout = new Checkout(client);

        CreateCheckoutSessionRequest sessionsRequest = new CreateCheckoutSessionRequest();

        sessionsRequest.setDeliverAt(date());

        checkout.sessions(sessionsRequest);
        ClientInterface http = client.getHttpClient();

        String expected = "\"deliverAt\":\"2023-06-02T12:00:00";
        verify(http).request(anyString(), Mockito.contains(expected), any(), eq(true), isNull(), any());
    }

    @Test
    public void TestCreatePaymentLinkDate() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/checkout/sessions-success.json");
        PaymentLinks payment = new PaymentLinks(client);

        CreatePaymentLinkRequest paymentLinkRequest = new CreatePaymentLinkRequest();

        paymentLinkRequest.setDeliverAt(date());
        paymentLinkRequest.setDateOfBirth(date());

        payment.create(paymentLinkRequest);
        ClientInterface http = client.getHttpClient();

        String expected1 = "\"deliverAt\":\"2023-06-02T12:00:00";
        String expected2 = "\"dateOfBirth\":\"2023-06-02T12:00:00";
        verify(http).request(anyString(), Mockito.contains(expected1), any(), eq(true), isNull(), any());
        verify(http).request(anyString(), Mockito.contains(expected2), any(), eq(true), isNull(), any());
    }

    @Test
    public void TestPaymentSessionDate() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/checkout/sessions-success.json");
        Checkout checkout = new Checkout(client);

        PaymentSessionRequest request = new PaymentSessionRequest();

        request.setDateOfBirth(date());
        request.setDeliveryDate(date());

        checkout.paymentSession(request);
        ClientInterface http = client.getHttpClient();

        String expected1 = "\"deliveryDate\":\"2023-06-02T12:00:00";
        String expected2 = "\"dateOfBirth\":\"2023-06-02T12:00:00";
        verify(http).request(anyString(), Mockito.contains(expected1), any(), eq(true), isNull(), any());
        verify(http).request(anyString(), Mockito.contains(expected2), any(), eq(true), isNull(), any());
    }

    @Test
    public void TestCheckoutPaymentsDate() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/checkout/sessions-success.json");
        Checkout checkout = new Checkout(client);

        PaymentsRequest request = new PaymentsRequest();

        request.setDateOfBirth(date());
        request.setDeliveryDate(date());

        checkout.payments(request);
        ClientInterface http = client.getHttpClient();

        String expected1 = "\"deliveryDate\":\"2023-06-02T12:00:00";
        String expected2 = "\"dateOfBirth\":\"2023-06-02T12:00:00";
        verify(http).request(anyString(), Mockito.contains(expected1), any(), eq(true), isNull(), any());
        verify(http).request(anyString(), Mockito.contains(expected2), any(), eq(true), isNull(), any());
    }
}
