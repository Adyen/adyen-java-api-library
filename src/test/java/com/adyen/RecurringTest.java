/**
 * Adyen Java API Library
 * Copyright (c) 2022 Adyen N.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.recurring.*;
import com.adyen.service.RecurringApi;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

public class RecurringTest extends BaseTest {
    private RecurringDetailsRequest createRecurringDetailsRequest() {
        RecurringDetailsRequest request = new RecurringDetailsRequest()
                .shopperReference("test-123")
                .merchantAccount("MerchantAccount")
                .recurring(new com.adyen.model.recurring.Recurring()
                        .contract(com.adyen.model.recurring.Recurring.ContractEnum.ONECLICK));

        return request;
    }

    private DisableRequest createDisableRequest() {
        DisableRequest request = new DisableRequest()
                .shopperReference("test-123")
                .merchantAccount("MerchantAccount")
                .recurringDetailReference("reference");

        return request;
    }

    private ScheduleAccountUpdaterRequest createScheduleAccountUpdaterRequest() {
        Map<String, String> additionalData = new HashMap<>();
        additionalData.put("key", "value");
        Card card = new Card()
                .cvc("123")
                .expiryMonth("09")
                .expiryYear("2020")
                .holderName("johndoe")
                .number("123");

        ScheduleAccountUpdaterRequest request = new ScheduleAccountUpdaterRequest()
                .additionalData(additionalData)
                .card(card)
                .merchantAccount("MerchantAccount")
                .reference("reference")
                .shopperReference("shopperReference")
                .selectedRecurringDetailReference("selectedRecurringDetailReference");

        return request;
    }

    private NotifyShopperRequest createNotifyShopperRequest() {
        NotifyShopperRequest notifyShopperRequest = new NotifyShopperRequest();
        notifyShopperRequest.setMerchantAccount("TestMerchant");
        notifyShopperRequest.setRecurringDetailReference("8316158654144897");
        notifyShopperRequest.setReference("Example reference");
        notifyShopperRequest.setShopperReference("1234567");
        notifyShopperRequest.setBillingDate("2021-03-31");
        notifyShopperRequest.setDisplayedReference("Example displayed reference");
        return notifyShopperRequest;
    }

    @Test
    public void testListRecurringDetails() throws Exception {
        Client client = createMockClientFromFile("mocks/recurring/listRecurringDetails-success.json");
        RecurringApi recurring = new RecurringApi(client);

        RecurringDetailsRequest request = createRecurringDetailsRequest();

        RecurringDetailsResult result = recurring.listRecurringDetails(request);
        assertEquals(2, result.getDetails().size());

        RecurringDetail recurringDetail = result.getDetails().get(0).getRecurringDetail();
        assertEquals("recurringReference", recurringDetail.getRecurringDetailReference());
        assertEquals("cardAlias", recurringDetail.getAlias());
        assertEquals("1111", recurringDetail.getCard().getNumber());
        OffsetDateTime expectedDate = OffsetDateTime.parse("2017-03-01T11:53:11+01:00");
        assertEquals(expectedDate, result.getCreationDate());
    }

    @Test
    public void testDisable() throws Exception {
        Client client = createMockClientFromFile("mocks/recurring/disable-success.json");
        RecurringApi recurring = new RecurringApi(client);

        DisableRequest request = createDisableRequest();

        DisableResult result = recurring.disable(request);
        assertEquals("[detail-successfully-disabled]", result.getResponse());
    }

    @Test
    public void testDisable803() throws IOException {
        Client client = createMockClientForErrors(422, "mocks/recurring/disable-error-803.json");
        RecurringApi recurring = new RecurringApi(client);

        DisableRequest request = createDisableRequest();

        try {
            recurring.disable(request);
            fail("Exception expected!");
        } catch (ApiException e) {
            assertNotEquals(200, e.getStatusCode());
            assertTrue(e.getResponseBody().contains("803"));
        }
    }

    @Test
    public void testScheduleAccountUpdater() throws Exception {
        Client client = createMockClientFromFile("mocks/recurring/scheduleAccountUpdater-success.json");
        RecurringApi recurring = new RecurringApi(client);

        ScheduleAccountUpdaterRequest request = createScheduleAccountUpdaterRequest();

        ScheduleAccountUpdaterResult result = recurring.scheduleAccountUpdater(request);

        assertNotNull(result);
        assertEquals("Success", result.getResult());
        assertEquals("8815398995557524", result.getPspReference());
    }

    @Test
    public void testScheduleAccountUpdater130() throws IOException {
        Client client = createMockClientForErrors(422, "mocks/recurring/scheduleAccountUpdater-error-130.json");
        RecurringApi recurring = new RecurringApi(client);

        ScheduleAccountUpdaterRequest request = createScheduleAccountUpdaterRequest();

        try {
            recurring.scheduleAccountUpdater(request);
            fail("Exception expected!");
        } catch (ApiException e) {
            assertNotEquals(200, e.getStatusCode());
            assertTrue(e.getResponseBody().contains("130"));
        }
    }

    @Test
    public void testNotifyShopper() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/recurring/notifyShopper-success.json");
        RecurringApi recurring = new RecurringApi(client);

        NotifyShopperRequest request = createNotifyShopperRequest();

        NotifyShopperResult result = recurring.notifyShopper(request);
        assertNotNull(result);
        assertEquals("Example displayed reference", result.getDisplayedReference());
        assertEquals("8516167336214570", result.getPspReference());
        assertEquals("Request processed successfully", result.getMessage());
        assertEquals("Example reference", result.getReference());
        assertEquals("Success", result.getResultCode());
        assertEquals("IA0F7500002462", result.getShopperNotificationReference());
    }

    @Test
    public void testCreatePermit() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/recurring/createPermit-success.json");
        RecurringApi recurring = new RecurringApi(client);

        CreatePermitRequest createPermitRequest = new CreatePermitRequest();
        createPermitRequest.setMerchantAccount("merchantAccount");
        Permit permit = new Permit();
        ArrayList permits = new ArrayList<Permit>();
        permits.add(permit);
        createPermitRequest.setPermits(permits);
        createPermitRequest.setRecurringDetailReference("recurringDetailReference");
        createPermitRequest.setShopperReference("shopperReference");

        CreatePermitResult result = recurring.createPermit(createPermitRequest);
        assertNotNull(result);
        assertEquals("1234qwer", result.getPspReference());
        assertEquals(1, result.getPermitResultList().size());
        assertEquals("token", result.getPermitResultList().get(0).getToken());
        assertEquals("resultKey", result.getPermitResultList().get(0).getResultKey());
    }

    @Test
    public void testDisablePermit() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/recurring/disablePermit-success.json");
        RecurringApi recurring = new RecurringApi(client);

        DisablePermitRequest disablePermitRequest = new DisablePermitRequest();
        disablePermitRequest.setMerchantAccount("merchantAccount");
        disablePermitRequest.setToken("token");

        DisablePermitResult result = recurring.disablePermit(disablePermitRequest);
        assertNotNull(result);
        assertEquals("1234qwer", result.getPspReference());
        assertEquals("disabled", result.getStatus());

    }
}
