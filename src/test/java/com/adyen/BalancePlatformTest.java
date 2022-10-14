package com.adyen;


import com.adyen.model.balanceplatform.BalancePlatform;
import com.adyen.service.BalancePlatformService;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

public class BalancePlatformTest extends BaseTest {
    @Test
    public void GeneralTestRetrieve() throws Exception {
        Client client = createMockClientFromFile("mocks/binlookup/get3dsavailability-success.json");
        BalancePlatformService service = new BalancePlatformService(client);
        BalancePlatform response = service.general.retrieve("12345");
        assertEquals("123456",response.getId());

    }
}
