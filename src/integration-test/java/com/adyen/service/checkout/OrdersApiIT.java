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

import com.adyen.BaseIntegrationTest;
import com.adyen.model.RequestOptions;
import com.adyen.model.checkout.Amount;
import com.adyen.model.checkout.CreateOrderRequest;
import com.adyen.model.checkout.CreateOrderResponse;
import com.adyen.service.exception.ApiException;
import java.io.IOException;
import java.util.UUID;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

@Tag(EXTERNAL)
@Timeout(60)
public class OrdersApiIT extends BaseIntegrationTest {

  // Scenario: Create an order
  @Test
  public void shouldCreateOrder() throws ApiException, IOException {
    // Arrange
    String reference = "order-it-" + UUID.randomUUID();
    RequestOptions requestOptions =
        new RequestOptions().idempotencyKey(UUID.randomUUID().toString());
    CreateOrderRequest request =
        new CreateOrderRequest()
            .reference(reference)
            .amount(new Amount().value(2500L).currency("EUR"))
            .merchantAccount(getMerchantAccount());
    OrdersApi ordersApi = new OrdersApi(getClient());

    // Act
    CreateOrderResponse response = ordersApi.orders(request, requestOptions);

    // Assert
    assertEquals(
        CreateOrderResponse.ResultCodeEnum.SUCCESS,
        response.getResultCode(),
        "The order must be created successfully");
  }
}
