package com.adyen;

import com.adyen.model.modification.CancelRequest;
import com.adyen.model.modification.CaptureRequest;
import com.adyen.model.modification.ModificationResult;
import com.adyen.model.modification.RefundRequest;
import com.adyen.service.Modification;
import com.adyen.service.exception.ApiException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ModificationTest extends BaseTest {
    /**
     * Test happy flow with capture-received response
     *
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
     *
     * @throws Exception
     */
    @Test
    public void TestCaptureError167() throws Exception {
        Client client = createMockClientForErrors(422, "mocks/capture-error-167.json");
        Modification modification = new Modification(client);

        CaptureRequest captureRequest = createCaptureRequest();

        try {
            ModificationResult modificationResult = modification.capture(captureRequest);
            assertTrue("Exception expected", false);
        } catch (ApiException e) {
            String errorCode = e.getError().getErrorCode();
            assertEquals("167", errorCode);

            int status = e.getError().getStatus();
            assertEquals(422, status);
        }
    }

    /**
     * Test happy flow with cancelOrRefund-received response
     *
     * @throws Exception
     */
    @Test
    public void TestCancelOrRefundReceived() throws Exception {
        Client client = createMockClientFromFile("mocks/cancelOrRefund-received.json");
        Modification modification = new Modification(client);

        CancelRequest cancelRequest = createBaseModificationRequest(new CancelRequest());

        ModificationResult modificationResult = modification.cancelOrRefund(cancelRequest);
        assertEquals(ModificationResult.ResponseEnum.CANCELORREFUND_RECEIVED_, modificationResult.getResponse());
    }

    /**
     * Test happy flow with refund-received response
     *
     * @throws Exception
     */
    @Test
    public void TestRefundReceived() throws Exception {
        Client client = createMockClientFromFile("mocks/refund-received.json");
        Modification modification = new Modification(client);

        RefundRequest refundRequest = createBaseModificationRequest(new RefundRequest());

        ModificationResult modificationResult = modification.refund(refundRequest);
        assertEquals(ModificationResult.ResponseEnum.REFUND_RECEIVED_, modificationResult.getResponse());
    }

    /**
     * Test happy flow with cancel-received response
     *
     * @throws Exception
     */
    @Test
    public void TestCancelReceived() throws Exception {
        Client client = createMockClientFromFile("mocks/cancel-received.json");
        Modification modification = new Modification(client);

        CancelRequest cancelRequest = createBaseModificationRequest(new CancelRequest());

        ModificationResult modificationResult = modification.cancel(cancelRequest);
        assertEquals(ModificationResult.ResponseEnum.CANCEL_RECEIVED_, modificationResult.getResponse());
    }
}
