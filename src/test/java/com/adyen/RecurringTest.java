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

import java.io.IOException;
import org.junit.Test;
import com.adyen.model.recurring.DisableRequest;
import com.adyen.model.recurring.DisableResult;
import com.adyen.model.recurring.RecurringDetail;
import com.adyen.model.recurring.RecurringDetailsRequest;
import com.adyen.model.recurring.RecurringDetailsResult;
import com.adyen.model.recurring.StoreTokenRequest;
import com.adyen.model.recurring.StoreTokenResult;
import com.adyen.service.Recurring;
import com.adyen.service.exception.ApiException;
import static org.junit.Assert.assertEquals;
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

        DisableResult result = null;
        try {
            result = recurring.disable(request);
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

		@SuppressWarnings("unused")
		StoreTokenResult result = null;
		try {
			result = recurring.storeToken(request);
			fail("Exception expected!");
		} catch (ApiException e) {
			assertNotEquals(200, e.getStatusCode());
			assertEquals("101", e.getError().getErrorCode());
		}
	}

}
