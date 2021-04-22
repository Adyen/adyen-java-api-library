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
import com.adyen.model.Address;
import com.adyen.model.Amount;
import com.adyen.model.checkout.CreatePaymentLinkRequest;
import com.adyen.model.checkout.PaymentLinkResource;
import com.adyen.model.checkout.UpdatePaymentLinkRequest;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class PaymentLinksTest extends BaseTest {

    @Test
    public void TestCreatePaymentLinksSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/paymentlinks/get-payment-link-success.json");
        PaymentLinks paymentLinks = new PaymentLinks(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        PaymentLinkResource paymentLink = paymentLinks.create(createPaymentLinkRequest);
        assertPaymentLinkResource(paymentLink, PaymentLinkResource.StatusEnum.ACTIVE);
    }

    @Test
    public void TestCreatePaymentLinksErrorMerchantMissing() throws IOException {
        Client client = createMockClientForErrors(403, "mocks/paymentlinks/create-payment-links-error-merchant.json");
        PaymentLinks paymentLinks = new PaymentLinks(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        try {
            paymentLinks.create(createPaymentLinkRequest);
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
        PaymentLinks paymentLinks = new PaymentLinks(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        try {
            paymentLinks.create(createPaymentLinkRequest);
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
        PaymentLinks paymentLinks = new PaymentLinks(client);
        CreatePaymentLinkRequest createPaymentLinkRequest = createPaymentLinkRequest();
        try {
            paymentLinks.create(createPaymentLinkRequest);
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
        PaymentLinks paymentLinks = new PaymentLinks(client);
        PaymentLinkResource paymentLink = paymentLinks.get("id");
        assertPaymentLinkResource(paymentLink, PaymentLinkResource.StatusEnum.ACTIVE);
    }

    @Test
    public void TestUpdatePaymentLink() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/paymentlinks/update-payment-link-success.json");
        PaymentLinks paymentLinks = new PaymentLinks(client);
        UpdatePaymentLinkRequest updatePaymentLinkRequest = new UpdatePaymentLinkRequest();
        updatePaymentLinkRequest.setStatus(UpdatePaymentLinkRequest.StatusEnum.EXPIRED);
        PaymentLinkResource paymentLink = paymentLinks.update("id", updatePaymentLinkRequest);
        assertPaymentLinkResource(paymentLink, PaymentLinkResource.StatusEnum.EXPIRED);
    }

    private void assertPaymentLinkResource(PaymentLinkResource paymentLink, PaymentLinkResource.StatusEnum status) {
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
        createPaymentLinkRequest.setAmount(createAmountObject("BRL", 1000L));
        createPaymentLinkRequest.setCountryCode("BR");
        createPaymentLinkRequest.setMerchantAccount("MagentoMerchantTest");
        createPaymentLinkRequest.setShopperReference("YOUR_UNIQUE_SHOPPER_ID");
        createPaymentLinkRequest.setShopperEmail("test@email.com");
        createPaymentLinkRequest.setShopperLocale("pt_BR");
        createPaymentLinkRequest.setExpiresAt("2019-12-17T10:05:29Z");
        Address address = new Address();
        address.setStreet("Street");
        address.setPostalCode("59000060");
        address.setCity("City");
        address.setHouseNumberOrName("999");
        address.setCountry("BR");
        address.setStateOrProvince("SP");
        createPaymentLinkRequest.setBillingAddress(address);
        createPaymentLinkRequest.setDeliveryAddress(address);

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