package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.model.ApiError;
import com.adyen.model.management.CreateAllowedOriginRequest;
import com.adyen.service.checkout.PaymentLinksApi;
import com.adyen.service.exception.ApiException;
import com.adyen.service.management.MyApiCredentialApi;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class ErrorHandlingTest extends BaseTest {
  @Test
  @Disabled("Integration test")
  public void addAllowedOriginFail() throws IOException, ApiException {
    Client client = new Client(System.getenv("API_KEY"), Environment.TEST);
    MyApiCredentialApi service = new MyApiCredentialApi(client);

    CreateAllowedOriginRequest createAllowedOriginRequest = new CreateAllowedOriginRequest();
    createAllowedOriginRequest.setDomain("https://google.com");
    try {
      service.addAllowedOrigin(createAllowedOriginRequest);
    } catch (ApiException e) {
      Assertions.assertTrue(
          e.getResponseBody().contains("Invalid allowed origin information provided."));
    }
  }

  @Test
  @Disabled("Integration test")
  public void CheckoutErrorTest() throws IOException, ApiException {
    Client client = new Client(System.getenv("API_KEY"), Environment.TEST);
    PaymentLinksApi service = new PaymentLinksApi(client);
    try {
      service.getPaymentLink("1234");
    } catch (ApiException e) {
      Assertions.assertTrue(e.getResponseBody().contains("Invalid payment link ID"));
      ApiError apiError = e.getError();
      Assertions.assertEquals("Validation", apiError.getErrorType());
      Assertions.assertEquals("Invalid payment link ID", apiError.getMessage());
    }
  }
}
