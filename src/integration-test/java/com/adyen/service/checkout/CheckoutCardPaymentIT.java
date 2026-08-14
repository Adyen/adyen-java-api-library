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
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.adyen.BaseIntegrationTest;
import com.adyen.model.ApiError;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.Amount;
import com.adyen.model.checkout.CardDetails;
import com.adyen.model.checkout.CheckoutPaymentMethod;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.model.checkout.PaymentResponse;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * Example integration test that creates a card payment through Checkout API v72 in the Adyen TEST
 * environment.
 *
 * <p>See {@code src/integration-test/README.md} for configuration and execution instructions.
 */
@Tag(EXTERNAL)
@Timeout(60)
public class CheckoutCardPaymentIT extends BaseIntegrationTest {

  // Payment request
  private static final String PAYMENT_CURRENCY = "EUR";
  private static final long PAYMENT_AMOUNT = 1000L;
  private static final String PAYMENT_REFERENCE_PREFIX = "checkout-card-it-";
  private static final String PAYMENT_RETURN_URL = "https://example.com/checkout/return";

  // Adyen Mastercard test card
  private static final String TEST_CARD_NUMBER = "5555444433331111";
  private static final String TEST_CARD_EXPIRY_MONTH = "03";
  private static final String TEST_CARD_EXPIRY_YEAR = "2030";
  private static final String TEST_CARD_CVC = "737";
  private static final String TEST_CARD_HOLDER_NAME = "Checkout Integration Test";

  // Expected API responses
  private static final int HTTP_STATUS_UNPROCESSABLE_ENTITY = 422;
  private static final String VALIDATION_ERROR_TYPE = "validation";
  private static final String MISSING_REFERENCE_ERROR_CODE = "130";
  private static final String MISSING_REFERENCE_ERROR_MESSAGE =
      "Required field 'reference' is not provided.";

  @BeforeEach
  public void verifyTestEnvironment() {
    requireTestEnvironment();
  }

  @Test
  public void shouldCreateAuthorisedCardPayment() throws ApiException, IOException {
    // Given
    String idempotencyKey = UUID.randomUUID().toString();
    String merchantReference = PAYMENT_REFERENCE_PREFIX + idempotencyKey;
    PaymentRequest request = createBasePaymentRequest().reference(merchantReference);
    RequestOptions requestOptions = createRequestOptions(idempotencyKey);
    PaymentsApi paymentsApi = new PaymentsApi(getClient());

    // When
    PaymentResponse response = paymentsApi.payments(request, requestOptions);

    // Then
    assertAuthorisedPayment(response, merchantReference);
  }

  @Test
  public void shouldReturnUnprocessableEntityWhenReferenceIsMissing() {
    // Given
    PaymentRequest requestWithoutReference = createBasePaymentRequest();
    RequestOptions requestOptions = createRequestOptions(UUID.randomUUID().toString());
    PaymentsApi paymentsApi = new PaymentsApi(getClient());

    // When
    ApiException exception =
        assertThrows(
            ApiException.class,
            () -> paymentsApi.payments(requestWithoutReference, requestOptions));

    // Then
    assertMissingReferenceError(exception);
  }

  private PaymentRequest createBasePaymentRequest() {
    return new PaymentRequest()
        .amount(new Amount().currency(PAYMENT_CURRENCY).value(PAYMENT_AMOUNT))
        .merchantAccount(getMerchantAccount())
        .returnUrl(PAYMENT_RETURN_URL)
        .paymentMethod(new CheckoutPaymentMethod(createTestCardDetails()));
  }

  private static RequestOptions createRequestOptions(String idempotencyKey) {
    return new RequestOptions().idempotencyKey(idempotencyKey);
  }

  private static CardDetails createTestCardDetails() {
    return new CardDetails()
        .type(CardDetails.TypeEnum.SCHEME)
        .number(TEST_CARD_NUMBER)
        .expiryMonth(TEST_CARD_EXPIRY_MONTH)
        .expiryYear(TEST_CARD_EXPIRY_YEAR)
        .cvc(TEST_CARD_CVC)
        .holderName(TEST_CARD_HOLDER_NAME);
  }

  private static void assertAuthorisedPayment(
      PaymentResponse response, String expectedMerchantReference) {
    assertNotNull(response, "The Checkout API response must not be null");
    assertNotNull(response.getPspReference(), "A created payment must have a PSP reference");
    assertFalse(response.getPspReference().isBlank(), "The PSP reference must not be blank");
    assertEquals(
        expectedMerchantReference,
        response.getMerchantReference(),
        "The response must contain the request's merchant reference");
    assertEquals(
        PaymentResponse.ResultCodeEnum.AUTHORISED,
        response.getResultCode(),
        "The test card payment must be authorised");
  }

  private static void assertMissingReferenceError(ApiException exception) {
    assertEquals(
        HTTP_STATUS_UNPROCESSABLE_ENTITY,
        exception.getStatusCode(),
        "The API must return HTTP 422");

    ApiError error = exception.getError();
    assertNotNull(error, "The response body must deserialize to ApiError");
    assertNotNull(error.getStatus(), "ApiError must contain an HTTP status");
    assertEquals(
        HTTP_STATUS_UNPROCESSABLE_ENTITY,
        error.getStatus(),
        "ApiError must contain HTTP status 422");
    assertEquals(
        VALIDATION_ERROR_TYPE,
        error.getErrorType(),
        "The error type must identify a validation error");
    assertEquals(
        MISSING_REFERENCE_ERROR_CODE,
        error.getErrorCode(),
        "The API must return the missing-reference error code");
    assertEquals(
        MISSING_REFERENCE_ERROR_MESSAGE,
        error.getMessage(),
        "The API must explain that reference is required");
  }
}
