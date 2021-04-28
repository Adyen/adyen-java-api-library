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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen;

import com.adyen.model.Card;
import com.adyen.model.recurring.DisableRequest;
import com.adyen.model.recurring.DisableResult;
import com.adyen.model.recurring.NotifyShopperRequest;
import com.adyen.model.recurring.NotifyShopperResult;
import com.adyen.model.recurring.RecurringDetail;
import com.adyen.model.recurring.RecurringDetailsRequest;
import com.adyen.model.recurring.RecurringDetailsResult;
import com.adyen.model.recurring.ScheduleAccountUpdaterRequest;
import com.adyen.model.recurring.ScheduleAccountUpdaterResult;
import com.adyen.model.recurring.StoreTokenRequest;
import com.adyen.model.recurring.StoreTokenResult;
import com.adyen.service.Recurring;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class RecurringTest extends BaseTest {
    private RecurringDetailsRequest createRecurringDetailsRequest() {
        RecurringDetailsRequest request = new RecurringDetailsRequest()
                .shopperReference("test-123")
                .merchantAccount("MerchantAccount")
                .selectOneClickContract();

        return request;
    }

    private DisableRequest createDisableRequest() {
        DisableRequest request = new DisableRequest()
                .shopperReference("test-123")
                .merchantAccount("MerchantAccount")
                .recurringDetailReference("reference");

        return request;
    }

    private StoreTokenRequest createStoreTokenRequest() {
        StoreTokenRequest request = new StoreTokenRequest()
                .shopperReference("test-123")
                .merchantAccount("MerchantAccount")
                .shopperEmail("johndoe@merchant.com")
                .shopperStatement("this is your statement")
                .shopperIP("192.168.1.1")
                .setContractToOneClick()
                .setCardData("5136333333333335", "John Doe", "08", "2018", "737");

        return request;
    }

    private ScheduleAccountUpdaterRequest createScheduleAccountUpdaterRequest() {
        Map<String, String> additionalData = new HashMap<>();
        additionalData.put("key", "value");

        ScheduleAccountUpdaterRequest request = new ScheduleAccountUpdaterRequest()
                .additionalData(additionalData)
                .card(new Card().cvc("123").expiryMonth("09").expiryYear("2020").holderName("johndoe").number("123"))
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
        Recurring recurring = new Recurring(client);

        RecurringDetailsRequest request = createRecurringDetailsRequest();

        RecurringDetailsResult result = recurring.listRecurringDetails(request);
        assertEquals(2, result.getDetails().size());
        assertEquals(2, result.getRecurringDetails().size());

        RecurringDetail recurringDetail = result.getRecurringDetails().get(0);
        assertEquals("recurringReference", recurringDetail.getRecurringDetailReference());
        assertEquals("cardAlias", recurringDetail.getAlias());
        assertEquals("1111", recurringDetail.getCard().getNumber());
        assertEquals("false", result.getInvalidOneClickContracts());

    }

    @Test
    public void testDisable() throws Exception {
        Client client = createMockClientFromFile("mocks/recurring/disable-success.json");
        Recurring recurring = new Recurring(client);

        DisableRequest request = createDisableRequest();

        DisableResult result = recurring.disable(request);
        assertEquals(1, result.getDetails().size());
        assertEquals("[detail-successfully-disabled]", result.getResponse());
    }

    @Test
    public void testDisable803() throws IOException {
        Client client = createMockClientForErrors(422, "mocks/recurring/disable-error-803.json");
        Recurring recurring = new Recurring(client);

        DisableRequest request = createDisableRequest();

        try {
            recurring.disable(request);
            fail("Exception expected!");
        } catch (ApiException e) {
            assertNotEquals(200, e.getStatusCode());
            assertEquals("803", e.getError().getErrorCode());
        }
    }

    @Test
    public void testStoreToken() throws Exception {
        Client client = createMockClientFromFile("mocks/recurring/storeToken-success.json");
        Recurring recurring = new Recurring(client);

        StoreTokenRequest request = createStoreTokenRequest();

        StoreTokenResult result = recurring.storeToken(request);
        assertNotNull(result);
        assertEquals("Success", result.getResult());
        assertEquals("Default", result.getAliasType());
        assertEquals("8815398995557524", result.getPspReference());
        assertEquals("8315398995429067", result.getRecurringDetailReference());
    }

    @Test
    public void testStoreToken101() throws IOException {
        Client client = createMockClientForErrors(422, "mocks/recurring/storeToken-error-101.json");
        Recurring recurring = new Recurring(client);

        StoreTokenRequest request = createStoreTokenRequest();

        try {
            recurring.storeToken(request);
            fail("Exception expected!");
        } catch (ApiException e) {
            assertNotEquals(200, e.getStatusCode());
            assertEquals("101", e.getError().getErrorCode());
        }
    }

    @Test
    public void testScheduleAccountUpdater() throws Exception {
        Client client = createMockClientFromFile("mocks/recurring/scheduleAccountUpdater-success.json");
        Recurring recurring = new Recurring(client);

        ScheduleAccountUpdaterRequest request = createScheduleAccountUpdaterRequest();

        ScheduleAccountUpdaterResult result = recurring.scheduleAccountUpdater(request);

        assertNotNull(result);
        assertEquals("Success", result.getResult());
        assertEquals("8815398995557524", result.getPspReference());
        assertFalse(result.isError());
        assertEquals("newAlias", result.getNewAlias());
        assertEquals("09", result.getNewExpiryMonth());
        assertEquals("2020", result.getNewExpiryYear());
        assertEquals("accountUpdaterAction", result.getAccountUpdaterAction());

        OffsetDateTime offsetDateTime = OffsetDateTime.parse("2020-09-15T13:43:35+02:00");
        Date expectedDate = Date.from(offsetDateTime.toInstant());
        assertEquals(expectedDate, result.getProcessedDate());
    }

    @Test
    public void testScheduleAccountUpdater130() throws IOException {
        Client client = createMockClientForErrors(422, "mocks/recurring/scheduleAccountUpdater-error-130.json");
        Recurring recurring = new Recurring(client);

        ScheduleAccountUpdaterRequest request = createScheduleAccountUpdaterRequest();

        try {
            recurring.scheduleAccountUpdater(request);
            fail("Exception expected!");
        } catch (ApiException e) {
            assertNotEquals(200, e.getStatusCode());
            assertEquals("130", e.getError().getErrorCode());
        }
    }

    @Test
    public void testNotifyShopper() throws IOException, ApiException {
        Client client = createMockClientFromFile("mocks/recurring/notifyShopper-success.json");
        Recurring recurring = new Recurring(client);

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
}
