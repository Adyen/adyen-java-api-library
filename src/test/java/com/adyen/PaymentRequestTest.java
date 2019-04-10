/**
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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.applicationinfo.ApplicationInfo;
import org.junit.Test;
import com.adyen.enums.VatCategory;
import com.adyen.model.PaymentRequest;

import static com.adyen.Client.LIB_NAME;
import static com.adyen.Client.LIB_VERSION;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class PaymentRequestTest extends BaseTest {

    @Test
    public void TestOpenInvoiceRequest() {
        PaymentRequest paymentRequestOpenInvoice = createOpenInvoicePaymentRequest();
        assertEquals("2", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.numberOfLines"));

        assertEquals("EUR", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line1.currencyCode"));
        assertEquals("Test product", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line1.description"));
        assertEquals("9000", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line1.itemAmount"));
        assertEquals("1000", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line1.itemVatAmount"));
        assertEquals("1000", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line1.itemVatPercentage"));
        assertEquals("1", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line1.numberOfItems"));
        assertEquals(VatCategory.NONE.toString(), paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line1.vatCategory"));
        assertEquals("1234", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line1.itemId"));

        assertEquals("EUR", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line2.currencyCode"));
        assertEquals("Test product 2", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line2.description"));
        assertEquals("9000", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line2.itemAmount"));
        assertEquals("1000", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line2.itemVatAmount"));
        assertEquals("1000", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line2.itemVatPercentage"));
        assertEquals("1", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line2.numberOfItems"));
        assertEquals(VatCategory.NONE.toString(), paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line2.vatCategory"));
        assertEquals("4567", paymentRequestOpenInvoice.getAdditionalData().get("openinvoicedata.line2.itemId"));
    }

    @Test
    public void TestPaypalEcsRequest() {
        PaymentRequest paymentRequest = createBasePaymentRequest(new PaymentRequest()).reference("123456").setAmountData("23.45", "EUR").setPaymentToken("apaymenttoken");

        assertEquals("123456", paymentRequest.getReference());
        assertEquals(new Long("2345"), paymentRequest.getAmount().getValue());
        assertEquals("EUR", paymentRequest.getAmount().getCurrency());
        assertEquals("apaymenttoken", paymentRequest.getAdditionalData().get("payment.token"));
    }

    @Test
    public void TestDefaultApplicationInfoAdyenLibrary() {
        PaymentRequest paymentRequest = new PaymentRequest();

        assertNotNull(paymentRequest.getApplicationInfo());
        assertNotNull(paymentRequest.getApplicationInfo().getAdyenLibrary());
        assertNotNull(paymentRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertEquals(LIB_NAME, paymentRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertNotNull(paymentRequest.getApplicationInfo().getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, paymentRequest.getApplicationInfo().getAdyenLibrary().getVersion());
    }

    @Test
    public void TestCustomApplicationInfoAdyenLibrary() {
        PaymentRequest paymentRequest = new PaymentRequest();
        ApplicationInfo applicationInfo = new ApplicationInfo();
        paymentRequest.setApplicationInfo(applicationInfo);

        assertNotNull(paymentRequest.getApplicationInfo());
        assertNotNull(paymentRequest.getApplicationInfo().getAdyenLibrary());
        assertNotNull(paymentRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertEquals(LIB_NAME, paymentRequest.getApplicationInfo().getAdyenLibrary().getName());
        assertNotNull(paymentRequest.getApplicationInfo().getAdyenLibrary().getVersion());
        assertEquals(LIB_VERSION, paymentRequest.getApplicationInfo().getAdyenLibrary().getVersion());
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestNullApplicationInfoAdyenLibrary() {
        PaymentRequest paymentRequest = new PaymentRequest();
        paymentRequest.setApplicationInfo(null);
    }
}