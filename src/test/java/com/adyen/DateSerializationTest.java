package com.adyen;

import com.adyen.httpclient.ClientInterface;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.checkout.CreateCheckoutSessionRequest;
import com.adyen.model.checkout.CreatePaymentLinkRequest;
import com.adyen.model.checkout.PaymentSetupRequest;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.service.Checkout;
import com.adyen.service.exception.ApiException;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.time.OffsetDateTime;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;

public class DateSerializationTest extends BaseTest {

    /*
    Tests for checking if all models in the Checkout classes are actually serializing Date objects as ISO8601 strings

    (note: dateOfBirth also gets serialized to ISO8601 which is fine one API side)
    */
    private OffsetDateTime date() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2023);
        cal.set(Calendar.MONTH, 5);
        cal.set(Calendar.DAY_OF_MONTH, 2);
        cal.set(Calendar.HOUR_OF_DAY, 12);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
        cal.setTimeZone(TimeZone.getTimeZone("UTC"));
        OffsetDateTime date = OffsetDateTime.parse("2023-06-02T12:00:00+01:00");
        return date;
    }
    @Test
    public void TestCheckoutSessionDate() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/checkout/createSessionsResponse.json");
        Checkout checkout = new Checkout(client);

        CreateCheckoutSessionRequest sessionsRequest = new CreateCheckoutSessionRequest();

        sessionsRequest.setDeliverAt(date());

        checkout.sessions(sessionsRequest);
        ClientInterface http = client.getHttpClient();

        String expected = "\"deliverAt\":\"2023-06-02T12:00:00";
        verify(http).request(anyString(), Mockito.contains(expected), any(), eq(true), isNull(), any(), isNull());
    }

    @Test
    public void TestCreatePaymentLinkDate() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/checkout/paymentLinkResponse.json");
        Checkout checkout = new Checkout(client);

        CreatePaymentLinkRequest paymentLinkRequest = new CreatePaymentLinkRequest();

        paymentLinkRequest.setDeliverAt(date());
        paymentLinkRequest.setDateOfBirth(date());

        checkout.paymentLinks(paymentLinkRequest);
        ClientInterface http = client.getHttpClient();

        String expected1 = "\"deliverAt\":\"2023-06-02T12:00:00";
        String expected2 = "\"dateOfBirth\":\"2023-06-02T12:00:00";
        verify(http).request(anyString(), Mockito.contains(expected1), any(), eq(true), isNull(), any(), isNull());
        verify(http).request(anyString(), Mockito.contains(expected2), any(), eq(true), isNull(), any(), isNull());
    }

    @Test
    public void TestPaymentSessionDate() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/checkout/paymentSessionResponse.json");
        Checkout checkout = new Checkout(client);

        PaymentSetupRequest request = new PaymentSetupRequest();

        request.setDateOfBirth(date());
        request.setDeliveryDate(date());

        checkout.paymentSession(request);
        ClientInterface http = client.getHttpClient();

        String expected1 = "\"deliveryDate\":\"2023-06-02T12:00:00";
        String expected2 = "\"dateOfBirth\":\"2023-06-02T12:00:00";
        verify(http).request(anyString(), Mockito.contains(expected1), any(), eq(true), isNull(), any(), isNull());
        verify(http).request(anyString(), Mockito.contains(expected2), any(), eq(true), isNull(), any(), isNull());
    }

    @Test
    public void TestCheckoutPaymentsDate() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/checkout/paymentResponse.json");
        Checkout checkout = new Checkout(client);

        PaymentRequest request = new PaymentRequest();

        request.setDateOfBirth(date());
        request.setDeliveryDate(date());

        checkout.payments(request);
        ClientInterface http = client.getHttpClient();

        String expected1 = "\"deliveryDate\":\"2023-06-02T12:00:00";
        String expected2 = "\"dateOfBirth\":\"2023-06-02T12:00:00";
        verify(http).request(anyString(), Mockito.contains(expected1), any(), eq(true), isNull(), any(), isNull());
        verify(http).request(anyString(), Mockito.contains(expected2), any(), eq(true), isNull(), any(), isNull());
    }
}
