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
import com.adyen.model.checkout.Address;
import com.adyen.model.checkout.Amount;
import com.adyen.model.checkout.PaymentLinkRequest;
import com.adyen.model.checkout.PaymentLinkResponse;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Tag(EXTERNAL)
@Timeout(60)
public class PaymentLinksApiIT extends BaseIntegrationTest {

  // Scenario: Create a payment link
  @Test
  public void shouldCreatePaymentLink() throws ApiException, IOException {
    // Arrange
    String reference = "payment-link-it-" + UUID.randomUUID();
    String shopperReference = "shopper-it-" + UUID.randomUUID();
    RequestOptions requestOptions =
        new RequestOptions().idempotencyKey(UUID.randomUUID().toString());
    Address address =
        new Address()
            .street("Roque Petroni Jr")
            .postalCode("59000060")
            .city("São Paulo")
            .houseNumberOrName("999")
            .country("BR")
            .stateOrProvince("SP");
    PaymentLinkRequest request =
        new PaymentLinkRequest()
            .reference(reference)
            .amount(new Amount().value(1250L).currency("BRL"))
            .countryCode("BR")
            .merchantAccount(getMerchantAccount())
            .shopperReference(shopperReference)
            .shopperEmail("test@email.com")
            .shopperLocale("pt-BR")
            .billingAddress(address)
            .deliveryAddress(address);
    PaymentLinksApi paymentLinksApi = new PaymentLinksApi(getClient());

    // Act
    PaymentLinkResponse response = paymentLinksApi.paymentLinks(request, requestOptions);

    // Assert
    assertNotNull(response.getId(), "The payment link must have an ID");
    assertFalse(response.getId().isBlank(), "The payment link ID must not be blank");
    assertEquals(
        PaymentLinkResponse.StatusEnum.ACTIVE,
        response.getStatus(),
        "The payment link must be active");
  }
}
