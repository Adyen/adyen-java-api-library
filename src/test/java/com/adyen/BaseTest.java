package com.adyen;

import com.adyen.enums.Environment;
import com.adyen.httpclient.HTTPClientException;
import com.adyen.httpclient.HttpURLConnectionClient;
import com.adyen.model.*;
import com.adyen.model.modification.AbstractModificationRequest;
import com.adyen.model.modification.CaptureRequest;
import org.apache.commons.io.IOUtils;
import org.junit.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

import static org.mockito.Mockito.*;

public class BaseTest {
    protected static Map<String, String> configurations;

    /**
     * Load configuration values
     */
    @BeforeClass
    public static void setUp() {
        try {
            File file = new File("src/test/java/com/adyen/config/test.properties");
            FileInputStream fileInput = new FileInputStream(file);
            Properties properties = new Properties();
            properties.load(fileInput);
            fileInput.close();

            configurations = new HashMap<String, String>();

            Enumeration<Object> enuKeys = properties.keys();
            while (enuKeys.hasMoreElements()) {
                String key = (String) enuKeys.nextElement();
                String value = properties.getProperty(key);
                configurations.put(key, value);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    protected Client createClientFromConfigurations() {
        Client client = new Client(
                configurations.get("username"),
                configurations.get("password"),
                Environment.TEST,
                "My Test Application"
        );
        return client;
    }

    protected String getMerchantAccount() {
        return configurations.get("merchantAccount");
    }

    /**
     * Returns a Client object that has a mocked response
     *
     * @param response
     * @return
     */
    protected Client createMockClientFromResponse(String response) {
        HttpURLConnectionClient httpURLConnectionClient = mock(HttpURLConnectionClient.class);
        try {
            when(httpURLConnectionClient.
                    request(any(String.class), any(String.class), any(Config.class))).
                    thenReturn(response);
        } catch (IOException | HTTPClientException e) {
            e.printStackTrace();
        }
        Client client = new Client();
        client.setHttpClient(httpURLConnectionClient);
        return client;
    }

    /**
     * Returns a Client object that has a mocked response from fileName
     *
     * @param fileName
     * @return
     */
    protected Client createMockClientFromFile(String fileName) {
        String response = getFileContents(fileName);

        return createMockClientFromResponse(response);
    }

    /**
     * Helper for file reading
     *
     * @param fileName
     * @return
     */
    private String getFileContents(String fileName) {
        String result = "";

        ClassLoader classLoader = getClass().getClassLoader();
        try {
            result = IOUtils.toString(classLoader.getResourceAsStream(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Populates the basic parameters (browser data, merchant account, shopper IP)
     *
     * @param abstractPaymentRequest
     * @param <T>
     * @return
     */
    protected <T extends AbstractPaymentRequest> T createBasePaymentRequest(T abstractPaymentRequest) {
        abstractPaymentRequest
                .merchantAccount("AMerchant")
                .setBrowserInfoData(
                        "User-Agent:Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.95 Safari/537.36",
                        "*/*"
                )
                .setShopperIP("1.2.3.4");

        return abstractPaymentRequest;
    }

    /**
     * Returns a sample PaymentRequest opbject with full card data
     *
     * @return
     */
    protected PaymentRequest createFullCardPaymentRequest() {
        PaymentRequest paymentRequest = createBasePaymentRequest(new PaymentRequest())
                .reference("123456")
                .setAmountData(
                        "1000",
                        "EUR"
                )
                .setCardData(
                        "5136333333333335",
                        "John Doe",
                        "08",
                        "2018",
                        "737"
                );

        return paymentRequest;
    }

    /**
     * Returns a sample PaymentRequest object with CSE data
     *
     * @return
     */
    protected PaymentRequest createCSEPaymentRequest() {
        PaymentRequest paymentRequest = createBasePaymentRequest(new PaymentRequest())
                .reference("123456")
                .setAmountData("1000", "EUR")
                .setCSEToken("adyenjs_0_1_4p1$...");

        return paymentRequest;
    }

    /**
     * Returns a PaymentRequest3d object for 3D secure authorisation
     *
     * @return
     */
    protected PaymentRequest3d create3DPaymentRequest() {
        PaymentRequest3d paymentRequest3d = createBasePaymentRequest(new PaymentRequest3d())
                .set3DRequestData("mdString", "paResString");

        return paymentRequest3d;
    }

    /**
     * Returns a Client that has a mocked error response from fileName
     *
     * @param status
     * @param fileName
     * @return
     */
    protected Client createMockClientForErrors(int status, String fileName) {
        String response = getFileContents(fileName);

        HttpURLConnectionClient httpURLConnectionClient = mock(HttpURLConnectionClient.class);
        HTTPClientException httpClientException = new HTTPClientException(
                status,
                "An error occured",
                new HashMap<String, List<String>>(),
                response);
        try {
            when(httpURLConnectionClient.
                    request(any(String.class), any(String.class), any(Config.class))).
                    thenThrow(httpClientException);
        } catch (IOException | HTTPClientException e) {
            e.printStackTrace();
        }
        Client client = new Client();
        client.setHttpClient(httpURLConnectionClient);
        return client;
    }

    protected <T extends AbstractModificationRequest> T createBaseModificationRequest(T modificationRequest) {
        modificationRequest
                .merchantAccount("AMerchant")
                .originalReference("originalReference")
                .reference("merchantReference");

        return modificationRequest;
    }

    protected CaptureRequest createCaptureRequest() {
        CaptureRequest captureRequest = createBaseModificationRequest(new CaptureRequest());

        captureRequest
                .setModificationAmountData(
                        "15.00",
                        "EUR"
                );

        return captureRequest;
    }
}
