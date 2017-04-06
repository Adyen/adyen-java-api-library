package com.adyen;

import com.adyen.model.recurring.RecurringDetail;
import com.adyen.model.recurring.RecurringDetailsRequest;
import com.adyen.model.recurring.RecurringDetailsResult;
import com.adyen.service.Recurring;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecurringTest extends BaseTest {
    private RecurringDetailsRequest createRecurringDetailsRequest() {
        RecurringDetailsRequest request = new RecurringDetailsRequest()
                .shopperReference("test-123")
                .merchantAccount("MerchantAccount")
                .selectOneClickContract();

        return request;
    }

    @Test
    public void testListRecurringDetails() throws Exception {
        Client client = createMockClientFromFile("mocks/recurring/listRecurringDetails-success.json");
        Recurring recurring = new Recurring(client);

        RecurringDetailsRequest request = createRecurringDetailsRequest();

        RecurringDetailsResult result = recurring.listRecurringDetails(request);
        assertEquals(1, result.getDetails().size());
        assertEquals(1, result.getRecurringDetails().size());

        RecurringDetail recurringDetail = result.getRecurringDetails().get(0);
        assertEquals("recurringReference", recurringDetail.getRecurringDetailReference());
        assertEquals("cardAlias", recurringDetail.getAlias());
        assertEquals("1111", recurringDetail.getCard().getNumber());
    }
}
