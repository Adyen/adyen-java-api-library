package com.adyen;

import com.adyen.constants.ApiConstants;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.model.balancecontrol.BalanceTransferRequest;
import com.adyen.model.balancecontrol.BalanceTransferResponse;
import com.adyen.service.BalanceControlApi;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.io.IOException;
import java.time.OffsetDateTime;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;

public class BalanceControlTest extends BaseTest {

    @Test
    public void TestBalanceControlApi() throws IOException, ApiException, HTTPClientException {
        Client client = createMockClientFromFile("mocks/smallendpoints/balance-control.json");
        BalanceControlApi service = new BalanceControlApi(client);
        BalanceTransferResponse response = service.balanceTransfer(new BalanceTransferRequest());

        verify(client.getHttpClient()).request(
                "https://pal-test.adyen.com/pal/servlet/BalanceControl/v1/balanceTransfer",
                "{}",
                client.getConfig(),
                false,
                null,
                ApiConstants.HttpMethod.POST,
                null
        );
        assertEquals(response.getStatus(), BalanceTransferResponse.StatusEnum.TRANSFERRED);
        assertEquals(response.getCreatedAt(), OffsetDateTime.parse("2022-01-24T14:59:11+01:00"));
    }
}
