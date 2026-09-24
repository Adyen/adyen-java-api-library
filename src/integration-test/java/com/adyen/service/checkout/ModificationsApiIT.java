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
import com.adyen.model.checkout.Amount;
import com.adyen.model.checkout.CardDetails;
import com.adyen.model.checkout.CheckoutPaymentMethod;
import com.adyen.model.checkout.PaymentCaptureRequest;
import com.adyen.model.checkout.PaymentCaptureResponse;
import com.adyen.model.checkout.PaymentRequest;
import com.adyen.model.checkout.PaymentResponse;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Tag(EXTERNAL)
@Timeout(60)
public class ModificationsApiIT extends BaseIntegrationTest {

  // Scenario: Capture an authorised payment
  @Test
  public void shouldCaptureAuthorisedPayment() throws ApiException, IOException {
    // Arrange
    String paymentPspReference = createAuthorisedUncapturedPayment();
    String reference = "capture-it-" + UUID.randomUUID();
    PaymentCaptureRequest request =
        new PaymentCaptureRequest()
            .reference(reference)
            .merchantAccount(getMerchantAccount())
            .amount(new Amount().value(2000L).currency("EUR"));
    ModificationsApi modificationsApi = new ModificationsApi(getClient());

    // Act
    PaymentCaptureResponse response =
        modificationsApi.captureAuthorisedPayment(paymentPspReference, request);

    // Assert
    assertNotNull(response.getPspReference(), "The capture must have a PSP reference");
    assertFalse(
        response.getPspReference().isBlank(), "The capture PSP reference must not be blank");
    assertEquals(
        paymentPspReference,
        response.getPaymentPspReference(),
        "The capture must reference the authorised payment");
    assertEquals(
        PaymentCaptureResponse.StatusEnum.RECEIVED,
        response.getStatus(),
        "The capture request must be received");
  }

  private String createAuthorisedUncapturedPayment() throws ApiException, IOException {
    CardDetails cardDetails =
        new CardDetails()
            .type(CardDetails.TypeEnum.SCHEME)
            .encryptedCardNumber("test_4111111111111111")
            .encryptedExpiryMonth("test_03")
            .encryptedExpiryYear("test_2030")
            .encryptedSecurityCode("test_737");
    PaymentRequest request =
        new PaymentRequest()
            .amount(new Amount().value(2000L).currency("EUR"))
            .reference("capture-source-it-" + UUID.randomUUID())
            .paymentMethod(new CheckoutPaymentMethod(cardDetails))
            .returnUrl("https://example.com/checkout/return")
            .merchantAccount(getMerchantAccount())
            // Defer auto-capture so the payment stays in the authorised state for manual capture
            .captureDelayHours(72);
    PaymentResponse response = new PaymentsApi(getClient()).payments(request);

    assertEquals(
        PaymentResponse.ResultCodeEnum.AUTHORISED,
        response.getResultCode(),
        "The source payment must be authorised");
    assertNotNull(response.getPspReference(), "The source payment must have a PSP reference");
    assertFalse(
        response.getPspReference().isBlank(), "The source payment PSP reference must not be blank");
    return response.getPspReference();
  }
}
