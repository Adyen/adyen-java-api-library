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
package com.adyen.service;

import com.adyen.BaseTest;
import com.adyen.Client;
import com.adyen.model.checkout.Address;
import com.adyen.model.checkout.Amount;
import com.adyen.model.checkout.CreatePaymentLinkRequest;
import com.adyen.model.checkout.PaymentLinkResponse;
import com.adyen.model.checkout.UpdatePaymentLinkRequest;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.io.IOException;
import java.util.Collections;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class PaymentLinksTest extends BaseTest {

    @Test
    public void TestCreatePaymentLinksSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/paymentlinks/create-payment-links-success.json");
        Checkout paymentLinks = new Checkout(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        PaymentLinkResponse paymentLink = paymentLinks.paymentLinks(createPaymentLinkRequest);
        assertPaymentLinkResponse(paymentLink, PaymentLinkResponse.StatusEnum.ACTIVE);
    }

    @Test
    public void TestCreatePaymentLinksErrorMerchantMissing() throws IOException {
        Client client = createMockClientForErrors(403, "mocks/paymentlinks/create-payment-links-error-merchant.json");
        Checkout paymentLinks = new Checkout(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        try {
            paymentLinks.paymentLinks(createPaymentLinkRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("901", e.getError().getErrorCode());
            assertEquals(403, e.getError().getStatus());
        }
    }

    @Test
    public void TestCreatePaymentLinksErrorAmountMissing() throws IOException {
        Client client = createMockClientForErrors(422, "mocks/paymentlinks/create-payment-links-error-amount.json");
        Checkout paymentLinks = new Checkout(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        try {
            paymentLinks.paymentLinks(createPaymentLinkRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("100", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
        }
    }

    @Test
    public void TestCreatePaymentLinksErrorReferenceMissing() throws IOException {
        Client client = createMockClientForErrors(422, "mocks/paymentlinks/create-payment-links-error-reference.json");
        Checkout paymentLinks = new Checkout(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        try {
            paymentLinks.paymentLinks(createPaymentLinkRequest);
            fail("Exception expected");
        } catch (ApiException e) {
            assertNotNull(e.getError());
            assertEquals("130", e.getError().getErrorCode());
            assertEquals(422, e.getError().getStatus());
        }
    }

    @Test
    public void TestGetPaymentLink() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/paymentlinks/get-payment-link-success.json");
        Checkout paymentLinks = new Checkout(client);
        PaymentLinkResponse paymentLink = paymentLinks.getPaymentLinks("id");
        assertPaymentLinkResponse(paymentLink, PaymentLinkResponse.StatusEnum.ACTIVE);
    }

    @Test
    public void TestUpdatePaymentLink() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/paymentlinks/update-payment-link-success.json");
        Checkout paymentLinks = new Checkout(client);
        UpdatePaymentLinkRequest updatePaymentLinkRequest = new UpdatePaymentLinkRequest();
        updatePaymentLinkRequest.setStatus(UpdatePaymentLinkRequest.StatusEnum.EXPIRED);
        PaymentLinkResponse paymentLink = paymentLinks.patchPaymentLinks("id", updatePaymentLinkRequest);
        assertPaymentLinkResponse(paymentLink, PaymentLinkResponse.StatusEnum.EXPIRED);
    }

    private void assertPaymentLinkResponse(PaymentLinkResponse paymentLink, PaymentLinkResponse.StatusEnum status) {
        assertNotNull(paymentLink);
        assertNotNull(paymentLink.getId());
        assertNotNull(paymentLink.getAmount());
        assertNotNull(paymentLink.getCountryCode());
        assertNotNull(paymentLink.getExpiresAt());
        assertNotNull(paymentLink.getMerchantAccount());
        assertNotNull(paymentLink.getReference());
        assertNotNull(paymentLink.getShopperLocale());
        assertNotNull(paymentLink.getShopperReference());
        assertNotNull(status.getValue(), paymentLink.getStatus());
        assertNotNull(paymentLink.getUrl());
    }

    /**
     * Returns a sample PaymentsRequest opbject with test data
     */
    private CreatePaymentLinkRequest createPaymentLinkRequest() {
        CreatePaymentLinkRequest createPaymentLinkRequest = new CreatePaymentLinkRequest();

        createPaymentLinkRequest.setReference("YOUR_ORDER_NUMBER");
        Amount amount = new Amount();
        amount.setValue(1000L);
        amount.setCurrency("BRL");
        createPaymentLinkRequest.setAmount(amount);
        createPaymentLinkRequest.setCountryCode("BR");
        createPaymentLinkRequest.setMerchantAccount("MagentoMerchantTest");
        createPaymentLinkRequest.setShopperReference("YOUR_UNIQUE_SHOPPER_ID");
        createPaymentLinkRequest.setShopperEmail("test@email.com");
        createPaymentLinkRequest.setShopperLocale("pt_BR");
        createPaymentLinkRequest.setExpiresAt("2019-12-17T10:05:29Z");
        createPaymentLinkRequest.setRequiredShopperFields(Collections.singletonList(CreatePaymentLinkRequest.RequiredShopperFieldsEnum.DELIVERYADDRESS));
        Address address = new Address();
        address.setStreet("Street");
        address.setPostalCode("59000060");
        address.setCity("City");
        address.setHouseNumberOrName("999");
        address.setCountry("BR");
        address.setStateOrProvince("SP");
        createPaymentLinkRequest.setBillingAddress(address);
        createPaymentLinkRequest.setDeliveryAddress(address);
        createPaymentLinkRequest.setStorePaymentMethodMode(CreatePaymentLinkRequest.StorePaymentMethodModeEnum.DISABLED);

        return createPaymentLinkRequest;
    }

    /**
     * Returns a sample Amount opbject with given currency and value
     */
    private Amount createAmountObject(String currency, Long value) {
        Amount amount = new Amount();
        amount.setCurrency(currency);
        amount.setValue(value);
        return amount;
    }
}
