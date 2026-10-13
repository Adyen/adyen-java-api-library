package com.adyen.service.checkout;

import static com.adyen.IntegrationTestTags.EXTERNAL;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adyen.BaseIntegrationTest;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.ListStoredPaymentMethodsResponse;
import com.adyen.model.checkout.OpiRequest;
import com.adyen.model.checkout.PaymentMethodToStore;
import com.adyen.model.checkout.StoredPaymentMethodRequest;
import com.adyen.model.checkout.StoredPaymentMethodResource;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

/**
 * Integration tests for stored payment method tokenization.
 *
 * <p>Prerequisite: the API key credential used by these tests must have the API tokenise payment
 * details role, shown as the Merchant Recurring role in the Customer Area.
 */
@Tag(EXTERNAL)
@Timeout(60)
public class RecurringApiIT extends BaseIntegrationTest {

  // Scenario: Tokenize a card as a stored payment method
  @Test
  public void shouldTokenizeCardAsStoredPaymentMethod() throws ApiException, IOException {
    // Arrange
    String shopperReference = "recurring-it-" + UUID.randomUUID();
    RecurringApi recurringApi = new RecurringApi(getClient());
    StoredPaymentMethodResource storedPaymentMethod = null;

    try {
      // Act
      storedPaymentMethod =
          recurringApi.storedPaymentMethods(
              createTokenizationRequest(shopperReference),
              new RequestOptions().idempotencyKey(UUID.randomUUID().toString()));

      // Assert
      assertNotNull(storedPaymentMethod.getId(), "The stored payment method must have an ID");
      assertFalse(
          storedPaymentMethod.getId().isBlank(), "The stored payment method ID must not be blank");
      assertEquals(
          "1111",
          storedPaymentMethod.getLastFour(),
          "The stored card must end on the test card's last four digits");
      assertEquals(
          shopperReference,
          storedPaymentMethod.getShopperReference(),
          "The stored payment method must reference the shopper");
    } finally {
      // Cleanup
      if (storedPaymentMethod != null && storedPaymentMethod.getId() != null) {
        recurringApi.deleteTokenForStoredPaymentDetails(
            storedPaymentMethod.getId(), shopperReference, getMerchantAccount());
      }
    }
  }

  // Scenario: List the stored payment methods of a shopper
  @Test
  public void shouldListStoredPaymentMethodsForShopper() throws ApiException, IOException {
    // Arrange
    String shopperReference = "recurring-it-" + UUID.randomUUID();
    RecurringApi recurringApi = new RecurringApi(getClient());
    StoredPaymentMethodResource storedPaymentMethod =
        recurringApi.storedPaymentMethods(
            createTokenizationRequest(shopperReference),
            new RequestOptions().idempotencyKey(UUID.randomUUID().toString()));

    try {
      // Act
      ListStoredPaymentMethodsResponse response =
          recurringApi.getTokensForStoredPaymentDetails(
              shopperReference, getMerchantAccount(), null);

      // Assert
      assertNotNull(
          response.getStoredPaymentMethods(),
          "The response must list the shopper's stored payment methods");
      assertTrue(
          response.getStoredPaymentMethods().stream()
              .anyMatch(item -> storedPaymentMethod.getId().equals(item.getId())),
          "The list must contain the newly tokenized stored payment method");
    } finally {
      // Cleanup
      if (storedPaymentMethod.getId() != null) {
        recurringApi.deleteTokenForStoredPaymentDetails(
            storedPaymentMethod.getId(), shopperReference, getMerchantAccount());
      }
    }
  }

  private StoredPaymentMethodRequest createTokenizationRequest(String shopperReference) {
    return new StoredPaymentMethodRequest()
        .merchantAccount(getMerchantAccount())
        .shopperReference(shopperReference)
        .recurringProcessingModel(
            StoredPaymentMethodRequest.RecurringProcessingModelEnum.CARDONFILE)
        .paymentMethod(
            new PaymentMethodToStore()
                .type("scheme")
                .encryptedCardNumber("test_4111111111111111")
                .encryptedExpiryMonth("test_03")
                .encryptedExpiryYear("test_2030")
                .encryptedSecurityCode("test_737")
                .holderName("S. Hopper"))
        .opi(new OpiRequest().includeIssuerId(true));
  }
}
