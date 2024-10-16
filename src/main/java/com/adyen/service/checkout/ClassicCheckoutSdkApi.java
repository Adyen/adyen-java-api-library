/*
 * Adyen Checkout API
 *
 * The version of the OpenAPI document: 71
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.adyen.service.checkout;

import com.adyen.Client;
import com.adyen.Service;
import com.adyen.constants.ApiConstants;
import com.adyen.model.checkout.PaymentSetupRequest;
import com.adyen.model.checkout.PaymentSetupResponse;
import com.adyen.model.checkout.PaymentVerificationRequest;
import com.adyen.model.checkout.PaymentVerificationResponse;
import com.adyen.model.checkout.ServiceError;
import com.adyen.model.RequestOptions;
import com.adyen.service.exception.ApiException;
import com.adyen.service.resource.Resource;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ClassicCheckoutSdkApi extends Service {

    public static final String API_VERSION = "71";

    protected String baseURL;

    /**
    * Classic Checkout SDK constructor in {@link com.adyen.service.checkout package}.
    * @param client {@link Client } (required)
    */
    public ClassicCheckoutSdkApi(Client client) {
        super(client);
        this.baseURL = createBaseURL("https://checkout-test.adyen.com/v71");
    }

    /**
    * Classic Checkout SDK constructor in {@link com.adyen.service.checkout package}.
    * Please use this constructor only if you would like to pass along your own url for routing or testing purposes. The latest API version is defined in this class as a constant.
    * @param client {@link Client } (required)
    * @param baseURL {@link String } (required)
    */
    public ClassicCheckoutSdkApi(Client client, String baseURL) {
        super(client);
        this.baseURL = baseURL;
    }

    /**
    * Create a payment session
    *
    * @param paymentSetupRequest {@link PaymentSetupRequest }  (required)
    * @return {@link PaymentSetupResponse }
    * @throws ApiException if fails to make API call
    * @deprecated since Adyen Checkout API v37
    */
    @Deprecated
    public PaymentSetupResponse paymentSession(PaymentSetupRequest paymentSetupRequest) throws ApiException, IOException {
        return paymentSession(paymentSetupRequest, null);
    }

    /**
    * Create a payment session
    *
    * @param paymentSetupRequest {@link PaymentSetupRequest }  (required)
    * @param requestOptions {@link RequestOptions } Object to store additional data such as idempotency-keys (optional)
    * @return {@link PaymentSetupResponse }
    * @throws ApiException if fails to make API call
    * @deprecated since Adyen Checkout API v37
    */
   @Deprecated
    public PaymentSetupResponse paymentSession(PaymentSetupRequest paymentSetupRequest, RequestOptions requestOptions) throws ApiException, IOException {

        String requestBody = paymentSetupRequest.toJson();
        Resource resource = new Resource(this, this.baseURL + "/paymentSession", null);
        String jsonResult = resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
        return PaymentSetupResponse.fromJson(jsonResult);
    }

    /**
    * Verify a payment result
    *
    * @param paymentVerificationRequest {@link PaymentVerificationRequest }  (required)
    * @return {@link PaymentVerificationResponse }
    * @throws ApiException if fails to make API call
    * @deprecated since Adyen Checkout API v37
    */
    @Deprecated
    public PaymentVerificationResponse verifyPaymentResult(PaymentVerificationRequest paymentVerificationRequest) throws ApiException, IOException {
        return verifyPaymentResult(paymentVerificationRequest, null);
    }

    /**
    * Verify a payment result
    *
    * @param paymentVerificationRequest {@link PaymentVerificationRequest }  (required)
    * @param requestOptions {@link RequestOptions } Object to store additional data such as idempotency-keys (optional)
    * @return {@link PaymentVerificationResponse }
    * @throws ApiException if fails to make API call
    * @deprecated since Adyen Checkout API v37
    */
   @Deprecated
    public PaymentVerificationResponse verifyPaymentResult(PaymentVerificationRequest paymentVerificationRequest, RequestOptions requestOptions) throws ApiException, IOException {

        String requestBody = paymentVerificationRequest.toJson();
        Resource resource = new Resource(this, this.baseURL + "/payments/result", null);
        String jsonResult = resource.request(requestBody, requestOptions, ApiConstants.HttpMethod.POST, null);
        return PaymentVerificationResponse.fromJson(jsonResult);
    }
}
