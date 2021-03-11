package com.adyen.model.checkout;

import com.adyen.model.Amount;
import com.adyen.model.FraudResult;
import com.adyen.model.ThreeDS2Result;
import com.adyen.util.DateUtil;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static com.adyen.constants.ApiConstants.AdditionalData.AUTH_CODE;
import static com.adyen.constants.ApiConstants.AdditionalData.AVS_RESULT;
import static com.adyen.constants.ApiConstants.AdditionalData.CARD_BIN;
import static com.adyen.constants.ApiConstants.AdditionalData.CARD_HOLDER_NAME;
import static com.adyen.constants.ApiConstants.AdditionalData.CARD_SUMMARY;
import static com.adyen.constants.ApiConstants.AdditionalData.EXPIRY_DATE;
import static com.adyen.constants.ApiConstants.AdditionalData.PAYMENT_METHOD;
import static com.adyen.constants.ApiConstants.AdditionalData.THREE_D_AUTHENTICATED;
import static com.adyen.constants.ApiConstants.AdditionalData.THREE_D_OFFERERED;
import static com.adyen.util.Util.toIndentedString;

public abstract class AbstractPaymentsResponse<T extends AbstractPaymentsResponse<T>> {
    @SerializedName("additionalData")
    private Map<String, String> additionalData = null;

    @SerializedName("fraudResult")
    private FraudResult fraudResult = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("refusalReason")
    private String refusalReason = null;

    @SerializedName("refusalReasonCode")
    private String refusalReasonCode = null;

    @SerializedName("resultCode")
    private PaymentsResponse.ResultCodeEnum resultCode = null;

    @SerializedName("serviceError")
    private ServiceError serviceError;

    @SerializedName("authResponse")
    private PaymentsResponse.ResultCodeEnum authResponse;

    @SerializedName("merchantReference")
    private String merchantReference;

    @SerializedName("threeDS2Result")
    private ThreeDS2Result threeDS2Result;

    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("order")
    private CheckoutOrderResponse order = null;

    @SerializedName("donationToken")
    private String donationToken;

    public T additionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
        return (T) this;
    }

    public T putAdditionalDataItem(String key, String additionalDataItem) {

        if (this.additionalData == null) {
            this.additionalData = new HashMap<>();
        }

        this.additionalData.put(key, additionalDataItem);
        return (T) this;
    }

    /**
     * This field contains additional data, which may be required to return in a particular payment response. To choose data fields to be returned, go to **Customer Area** &gt; **Settings** &gt; **API
     * and Response**.
     *
     * @return additionalData
     **/
    public Map<String, String> getAdditionalData() {
        return additionalData;
    }

    public void setAdditionalData(Map<String, String> additionalData) {
        this.additionalData = additionalData;
    }

    public String getAdditionalDataByKey(String key) {
        if (additionalData == null) {
            return null;
        }

        return additionalData.get(key);
    }

    public T fraudResult(FraudResult fraudResult) {
        this.fraudResult = fraudResult;
        return (T) this;
    }

    /**
     * Get fraudResult
     *
     * @return fraudResult
     **/
    public FraudResult getFraudResult() {
        return fraudResult;
    }

    public void setFraudResult(FraudResult fraudResult) {
        this.fraudResult = fraudResult;
    }

    public T pspReference(String pspReference) {
        this.pspReference = pspReference;
        return (T) this;
    }

    /**
     * Adyen&#x27;s 16-digit unique reference associated with the transaction/the request. This value is globally unique; quote it when communicating with us about this request.  &gt;
     * &#x60;pspReference&#x60; is returned only for non-redirect payment methods.
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }

    public T refusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
        return (T) this;
    }

    /**
     * If the payment&#x27;s authorisation is refused or an error occurs during authorisation, this field holds Adyen&#x27;s mapped reason for the refusal or a description of the error.  When a
     * transaction fails, the authorisation response includes &#x60;resultCode&#x60; and &#x60;refusalReason&#x60; values.
     *
     * @return refusalReason
     **/
    public String getRefusalReason() {
        return refusalReason;
    }

    public void setRefusalReason(String refusalReason) {
        this.refusalReason = refusalReason;
    }

    public T refusalReasonCode(String refusalReasonCode) {
        this.refusalReasonCode = refusalReasonCode;
        return (T) this;
    }

    public String getRefusalReasonCode() {
        return refusalReasonCode;
    }

    public void setRefusalReasonCode(String refusalReasonCode) {
        this.refusalReasonCode = refusalReasonCode;
    }

    public T resultCode(PaymentsResponse.ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
        return (T) this;
    }

    /**
     * The result of the payment. Possible values:  * **Authorised** – Indicates the payment authorisation was successfully completed. This state serves as an indicator to proceed with the delivery of
     * goods and services. This is a final state. * **Refused** – Indicates the payment was refused. The reason is given in the &#x60;refusalReason&#x60; field. This is a final state. *
     * **RedirectShopper** – Indicates the shopper should be redirected to an external web page or app to complete the authorisation. For more information on handling a redirect, refer to [Handling a
     * redirect](https://docs.adyen.com/developers/checkout/api-integration/payments#handlingaredirect). * **Received** – Indicates the payment has successfully been received by Adyen, and will be
     * processed. This is the initial state for all payments. * **Cancelled** – Indicates the payment has been cancelled (either by the shopper or the merchant) before processing was completed. This
     * is a final state. * **Pending** – Indicates that it is not possible to obtain the final status of the payment. This can happen if the systems providing final status information for the payment
     * are unavailable, or if the shopper needs to take further action to complete the payment. For more information on handling a pending payment, refer to [Payments with pending
     * status](https://docs.adyen.com/developers/development-resources/payments-with-pending-status). * **Error** – Indicates an error occurred during processing of the payment. The reason is given in
     * the &#x60;refusalReason&#x60; field. This is a final state.
     *
     * @return resultCode
     **/
    public PaymentsResponse.ResultCodeEnum getResultCode() {
        return resultCode;
    }

    public void setResultCode(PaymentsResponse.ResultCodeEnum resultCode) {
        this.resultCode = resultCode;
    }

    public ServiceError getServiceError() {
        return serviceError;
    }

    public void setServiceError(ServiceError serviceError) {
        this.serviceError = serviceError;
    }

    public PaymentsResponse.ResultCodeEnum getAuthResponse() {
        return authResponse;
    }

    public void setAuthResponse(PaymentsResponse.ResultCodeEnum authResponse) {
        this.authResponse = authResponse;
    }

    public String getMerchantReference() {
        return merchantReference;
    }

    public void setMerchantReference(String merchantReference) {
        this.merchantReference = merchantReference;
    }

    /**
     * Result of the 3D Secure 2 authentication.
     *
     * @return threeDS2Result
     **/
    public ThreeDS2Result getThreeDS2Result() {
        return threeDS2Result;
    }

    public void setThreeDS2Result(ThreeDS2Result threeDS2Result) {
        this.threeDS2Result = threeDS2Result;
    }

    public T threeDS2Result(ThreeDS2Result threeDS2Result) {
        this.threeDS2Result = threeDS2Result;
        return (T) this;
    }

    public T amount(Amount amount) {
        this.amount = amount;
        return (T) this;
    }

    /**
     * Get amount
     *
     * @return amount
     **/
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public T order(CheckoutOrderResponse order) {
        this.order = order;
        return (T) this;
    }

    /**
     * Get order
     * @return order
     **/
    public CheckoutOrderResponse getOrder() {
        return order;
    }

    public void setOrder(CheckoutOrderResponse order) {
        this.order = order;
    }

    /**
     * Donation Token containing payment details for Adyen Giving.
     * @return donationToken
     **/
    public String getDonationToken() {
        return donationToken;
    }

    public void setDonationToken(String donationToken) {
        this.donationToken = donationToken;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        AbstractPaymentsResponse response = (AbstractPaymentsResponse) o;
        return Objects.equals(this.additionalData, response.additionalData)
                && Objects.equals(this.fraudResult, response.fraudResult)
                && Objects.equals(this.pspReference, response.pspReference)
                && Objects.equals(this.refusalReason, response.refusalReason)
                && Objects.equals(this.refusalReasonCode, response.refusalReasonCode)
                && Objects.equals(this.resultCode, response.resultCode)
                && Objects.equals(this.serviceError, response.serviceError)
                && Objects.equals(this.authResponse, response.authResponse)
                && Objects.equals(this.merchantReference, response.merchantReference)
                && Objects.equals(this.threeDS2Result, response.threeDS2Result)
                && Objects.equals(this.amount, response.amount)
                && Objects.equals(this.order, response.order)
                && Objects.equals(this.donationToken, response.donationToken);
    }

    @Override
    public int hashCode() {
        return Objects.hash(additionalData, fraudResult, pspReference, refusalReason, resultCode, serviceError, authResponse, merchantReference, threeDS2Result, amount, order, donationToken);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("    additionalData: ").append(toIndentedString(additionalData)).append("\n");
        sb.append("    fraudResult: ").append(toIndentedString(fraudResult)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    refusalReason: ").append(toIndentedString(refusalReason)).append("\n");
        sb.append("    refusalReasonCode: ").append(toIndentedString(refusalReasonCode)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("    serviceError: ").append(toIndentedString(serviceError)).append("\n");
        sb.append("    authResponse: ").append(toIndentedString(authResponse)).append("\n");
        sb.append("    merchantReference: ").append(toIndentedString(merchantReference)).append("\n");
        sb.append("    threeDS2Result: ").append(toIndentedString(threeDS2Result)).append("\n");
        sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
        sb.append("    order: ").append(toIndentedString(order)).append("\n");
        sb.append("    donationToken: ").append(toIndentedString(donationToken)).append("\n");
        return sb.toString();
    }

    public String getCardBin() {
        return getAdditionalDataByKey(CARD_BIN);
    }

    public String getCardHolderName() {
        return getAdditionalDataByKey(CARD_HOLDER_NAME);
    }

    public String getCardSummary() {
        return getAdditionalDataByKey(CARD_SUMMARY);
    }

    public String getPaymentMethod() {
        return getAdditionalDataByKey(PAYMENT_METHOD);
    }

    public String getAvsResult() {
        return getAdditionalDataByKey(AVS_RESULT);
    }

    public boolean get3DOffered() {
        return "true".equals(getAdditionalDataByKey(THREE_D_OFFERERED));
    }

    public boolean get3DAuthenticated() {
        return "true".equals(getAdditionalDataByKey(THREE_D_AUTHENTICATED));
    }

    public String getAuthCode() {
        return getAdditionalDataByKey(AUTH_CODE);
    }

    public Date getExpiryDate() {
        String expiryDate = getAdditionalDataByKey(EXPIRY_DATE);
        return DateUtil.parseMYDate(expiryDate);
    }


}
