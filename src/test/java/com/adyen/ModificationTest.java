package com.adyen;

import com.adyen.model.CaptureRequest;
import com.adyen.model.ModificationResult;
import com.adyen.service.Modification;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class ModificationTest extends BaseTest {

    @Test
    public void TestCancelModification() {

        // do payment call
        PaymentTest paymentTest = new PaymentTest();
        Map<String, Object> paymentResult = paymentTest.doPaymentCall();

        Object pspReference = paymentResult.get("pspReference");

        Client client = this.createClientFromConfigurations();

        // define parameters
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("merchantAccount", this.getMerchantAccount());
        params.put("originalReference", pspReference);


        Modification modification = new Modification(client);

//		Map<String, Object> result = modification.cancel(params);
//
//		System.out.println(result);


    }

    /**
     * Test happy flow with capture-received response
     * @throws Exception
     */
    @Test
    public void TestCaptureSuccess() throws Exception {
        Client client = createMockClientFromFile("mocks/capture-success.json");
        Modification modification = new Modification(client);

        CaptureRequest captureRequest = createCaptureRequest();

        ModificationResult modificationResult = modification.capture(captureRequest);
        assertEquals(ModificationResult.ResponseEnum.CAPTURE_RECEIVED_, modificationResult.getResponse());
    }

    /**
     * Test error response
     * @throws Exception
     */
    @Test
    public void TestCaptureError167() throws Exception {
        Client client = createMockClientFromFile("mocks/capture-error-167.json");
        Modification modification = new Modification(client);

        CaptureRequest captureRequest = createCaptureRequest();

        try {
            ModificationResult modificationResult = modification.capture(captureRequest);
        } catch (ApiException e) {
            String errorCode = e.getError().getErrorCode();
            assertEquals("167", errorCode);

            int status = e.getError().getStatus();
            assertEquals(422, status);
        }
    }

}
