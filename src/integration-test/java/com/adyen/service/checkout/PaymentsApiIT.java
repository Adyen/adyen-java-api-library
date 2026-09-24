/*
 * Adyen Java API Library
 *
 * Copyright (c) 2026 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.service.checkout;

import static com.adyen.IntegrationTestTags.EXTERNAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.adyen.BaseIntegrationTest;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.Amount;
import com.adyen.model.checkout.CardBrandDetails;
import com.adyen.model.checkout.CardDetails;
import com.adyen.model.checkout.CardDetailsRequest;
import com.adyen.model.checkout.CardDetailsResponse;
import com.adyen.model.checkout.CheckoutPaymentMethod;
import com.adyen.model.checkout.CreateCheckoutSessionRequest;
import com.adyen.model.checkout.CreateCheckoutSessionResponse;
import com.adyen.model.checkout.PaymentMethodsRequest;
import com.adyen.model.checkout.PaymentMethodsResponse;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.model.checkout.PaymentResponse;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Tag(EXTERNAL)
@Timeout(60)
public class PaymentsApiIT extends BaseIntegrationTest {

  private static final String RETURN_URL = "https://example.com/checkout/return";

  // Scenario: Make a successful card payment
  @Test
  public void shouldMakeSuccessfulCardPayment() throws ApiException, IOException {
    // Arrange
    String reference = "payment-it-" + UUID.randomUUID();
    CardDetails cardDetails =
        new CardDetails()
            .type(CardDetails.TypeEnum.SCHEME)
            .encryptedCardNumber("test_4111111111111111")
            .encryptedExpiryMonth("test_03")
            .encryptedExpiryYear("test_2030")
            .encryptedSecurityCode("test_737");
    PaymentRequest request =
        new PaymentRequest()
            .amount(new Amount().currency("USD").value(1000L))
            .reference(reference)
            .paymentMethod(new CheckoutPaymentMethod(cardDetails))
            .returnUrl(RETURN_URL)
            .merchantAccount(getMerchantAccount());
    PaymentsApi paymentsApi = new PaymentsApi(getClient());

    // Act
    PaymentResponse response = paymentsApi.payments(request);

    // Assert
    assertNotNull(response.getPspReference(), "The payment must have a PSP reference");
    assertFalse(response.getPspReference().isBlank(), "The PSP reference must not be blank");
    assertEquals(
        PaymentResponse.ResultCodeEnum.AUTHORISED,
        response.getResultCode(),
        "The payment must be authorised");
  }

  // Scenario: Create a payment session
  @Test
  public void shouldCreatePaymentSession() throws ApiException, IOException {
    // Arrange
    String reference = "session-it-" + UUID.randomUUID();
    RequestOptions requestOptions =
        new RequestOptions().idempotencyKey(UUID.randomUUID().toString());
    CreateCheckoutSessionRequest request =
        new CreateCheckoutSessionRequest()
            .merchantAccount(getMerchantAccount())
            .amount(new Amount().value(100L).currency("EUR"))
            .returnUrl(RETURN_URL)
            .reference(reference)
            .countryCode("NL");
    PaymentsApi paymentsApi = new PaymentsApi(getClient());

    // Act
    CreateCheckoutSessionResponse response = paymentsApi.sessions(request, requestOptions);

    // Assert
    assertNotNull(response.getId(), "The payment session must have an ID");
    assertFalse(response.getId().isBlank(), "The payment session ID must not be blank");
  }

  // Scenario: List brands for a card
  @Test
  public void shouldListBrandsForCard() throws ApiException, IOException {
    // Arrange
    RequestOptions requestOptions =
        new RequestOptions().idempotencyKey(UUID.randomUUID().toString());
    CardDetailsRequest request =
        new CardDetailsRequest().merchantAccount(getMerchantAccount()).cardNumber("411111");
    PaymentsApi paymentsApi = new PaymentsApi(getClient());

    // Act
    CardDetailsResponse response = paymentsApi.cardDetails(request, requestOptions);

    // Assert
    assertNotNull(response.getBrands(), "The response must contain card brands");
    assertFalse(response.getBrands().isEmpty(), "The card brands must not be empty");
    assertEquals("visa", response.getBrands().get(0).getType(), "The first brand must be Visa");
  }

  // Scenario: List supported brands for a card
  @Test
  public void shouldListSupportedBrandsForCard() throws ApiException, IOException {
    // Arrange
    RequestOptions requestOptions =
        new RequestOptions().idempotencyKey(UUID.randomUUID().toString());
    CardDetailsRequest request =
        new CardDetailsRequest()
            .merchantAccount(getMerchantAccount())
            .cardNumber("411111")
            .supportedBrands(List.of("visa", "mc", "amex"));
    PaymentsApi paymentsApi = new PaymentsApi(getClient());

    // Act
    CardDetailsResponse response = paymentsApi.cardDetails(request, requestOptions);

    // Assert
    assertNotNull(response.getBrands(), "The response must contain card brands");
    assertFalse(response.getBrands().isEmpty(), "The card brands must not be empty");
    CardBrandDetails firstBrand = response.getBrands().get(0);
    assertEquals("visa", firstBrand.getType(), "The first brand must be Visa");
    assertEquals(Boolean.TRUE, firstBrand.getSupported(), "Visa must be supported");
  }

  // Scenario: List available payment methods
  @Test
  public void shouldListAvailablePaymentMethods() throws ApiException, IOException {
    // Arrange
    RequestOptions requestOptions =
        new RequestOptions().idempotencyKey(UUID.randomUUID().toString());
    PaymentMethodsRequest request =
        new PaymentMethodsRequest().merchantAccount(getMerchantAccount());
    PaymentsApi paymentsApi = new PaymentsApi(getClient());

    // Act
    PaymentMethodsResponse response = paymentsApi.paymentMethods(request, requestOptions);

    // Assert
    assertNotNull(response.getPaymentMethods(), "The response must contain payment methods");
    assertFalse(response.getPaymentMethods().isEmpty(), "The payment methods must not be empty");
  }
}
