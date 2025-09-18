/*
 *                       ######
 *                       ######
 * ############    ####( ######  #####. ######  ############   ############
 * #############  #####( ######  #####. ######  #############  #############
 *        ######  #####( ######  #####. ######  #####  ######  #####  ######
 * ###### ######  #####( ######  #####. ######  #####  #####   #####  ######
 * ###### ######  #####( ######  #####. ######  #####          #####  ######
 * #############  #############  #############  #############  #####  ######
 *  ############   ############  #############   ############  #####  ######
 *                                      ######
 *                               #############
 *                               ############
 *
 * Adyen Java API Library
 *
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.checkout.*;
import com.adyen.service.checkout.PaymentLinksApi;
import com.adyen.service.checkout.PaymentsApi;
import org.junit.Test;

import static org.junit.Assert.*;

public class CheckoutIT extends BaseIntegrationTest {

  @Test
  public void getPaymentMethods() throws Exception {
    var checkout = new PaymentsApi(getClient());

    PaymentMethodsRequest paymentMethodsRequest =
        new PaymentMethodsRequest().merchantAccount(getMerchantAccount());

    PaymentMethodsResponse paymentMethodsResponse = checkout.paymentMethods(paymentMethodsRequest);

    assertNotNull(paymentMethodsResponse);
    assertNotNull(paymentMethodsResponse.getPaymentMethods());
    assertFalse(paymentMethodsResponse.getPaymentMethods().isEmpty());
  }

  @Test
  public void makeCardPayments() throws Exception {

    var checkout = new PaymentsApi(getClient());

    var cardDetails =
        new CardDetails()
            .type(CardDetails.TypeEnum.SCHEME)
            .encryptedCardNumber("test_4111111111111111")
            .holderName("John Doe")
            .encryptedSecurityCode("test_737")
            .encryptedExpiryMonth("test_03")
            .encryptedExpiryYear("test_2030");
    var paymentRequest =
        new PaymentRequest()
            .merchantAccount(getMerchantAccount())
            .reference("YOUR_REFERENCE")
            .amount(new Amount().currency("EUR").value(1000L))
            .returnUrl("https://your-company.example.org/checkout?shopperOrder=12xy..")
            .paymentMethod(new CheckoutPaymentMethod(cardDetails));

    var paymentResponse = checkout.payments(paymentRequest);

    assertNotNull(paymentResponse);
    assertNotNull(paymentResponse.getPspReference());
  }

  @Test
  public void createPaymentLink() throws Exception {
    var paymentLinksApi = new PaymentLinksApi(getClient());

    var paymentLinkResponse = paymentLinksApi.paymentLinks(
        new PaymentLinkRequest()
            .merchantAccount(getMerchantAccount())
            .reference("YOUR_REFERENCE")
            .amount(new Amount().currency("EUR").value(1000L))
            .countryCode("NL")
            .shopperReference("shopper ref")
    );

    assertNotNull(paymentLinkResponse);
    assertNotNull(paymentLinkResponse.getStatus());

  }

}
