package com.adyen.model.checkout.details;

import java.util.Objects;
import com.adyen.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;

public class UpiCollectDetails implements PaymentMethodDetails {

    public static final String UPI_COLLECT = "upi_collect";

    @SerializedName("billingSequenceNumber")
    private String billingSequenceNumber = null;

    @SerializedName("recurringDetailReference")
    private String recurringDetailReference = null;

    @SerializedName("shopperNotificationReference")
    private String shopperNotificationReference = null;

    @SerializedName("storedPaymentMethodId")
    private String storedPaymentMethodId = null;

    @SerializedName("virtualPaymentAddress")
    private String virtualPaymentAddress = null;

    @SerializedName("type")
    private String type = UPI_COLLECT;

    /**
     * **upi_collect**
     *
     * @return type
     **/
    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }

    public UpiCollectDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * The sequence number for the debit. For example, send **2** if this is the second debit for the subscription. The sequence number is included in the notification sent to the shopper.
     *
     * @return billingSequenceNumber
     **/
    public String getBillingSequenceNumber() {
        return billingSequenceNumber;
    }

    public void setBillingSequenceNumber(String billingSequenceNumber) {
        this.billingSequenceNumber = billingSequenceNumber;
    }

    public UpiCollectDetails billingSequenceNumber(String billingSequenceNumber) {
        this.billingSequenceNumber = billingSequenceNumber;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     *
     * @return recurringDetailReference
     **/
    public String getRecurringDetailReference() {
        return recurringDetailReference;
    }

    public void setRecurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
    }

    public UpiCollectDetails recurringDetailReference(String recurringDetailReference) {
        this.recurringDetailReference = recurringDetailReference;
        return this;
    }

    /**
     * The &#x60;shopperNotificationReference&#x60; returned in the response when you requested to notify the shopper. Used for recurring payment only.
     *
     * @return shopperNotificationReference
     **/
    public String getShopperNotificationReference() {
        return shopperNotificationReference;
    }

    public void setShopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
    }


    public UpiCollectDetails shopperNotificationReference(String shopperNotificationReference) {
        this.shopperNotificationReference = shopperNotificationReference;
        return this;
    }

    /**
     * This is the &#x60;recurringDetailReference&#x60; returned in the response when you created the token.
     *
     * @return storedPaymentMethodId
     **/
    public String getStoredPaymentMethodId() {
        return storedPaymentMethodId;
    }

    public void setStoredPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
    }

    public UpiCollectDetails storedPaymentMethodId(String storedPaymentMethodId) {
        this.storedPaymentMethodId = storedPaymentMethodId;
        return this;
    }

    /**
     * The virtual payment address for UPI.
     *
     * @return virtualPaymentAddress
     **/
    public String getVirtualPaymentAddress() {
        return virtualPaymentAddress;
    }

    public void setVirtualPaymentAddress(String virtualPaymentAddress) {
        this.virtualPaymentAddress = virtualPaymentAddress;
    }

    public UpiCollectDetails virtualPaymentAddress(String virtualPaymentAddress) {
        this.virtualPaymentAddress = virtualPaymentAddress;
        return this;
    }

    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UpiCollectDetails upiCollectDetails = (UpiCollectDetails) o;
        return Objects.equals(this.billingSequenceNumber, upiCollectDetails.billingSequenceNumber)
                && Objects.equals(this.recurringDetailReference, upiCollectDetails.recurringDetailReference)
                && Objects.equals(this.shopperNotificationReference, upiCollectDetails.shopperNotificationReference)
                && Objects.equals(this.storedPaymentMethodId, upiCollectDetails.storedPaymentMethodId)
                && Objects.equals(this.type, upiCollectDetails.type)
                && Objects.equals(this.virtualPaymentAddress, upiCollectDetails.virtualPaymentAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(billingSequenceNumber, recurringDetailReference, shopperNotificationReference, storedPaymentMethodId, type, virtualPaymentAddress);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class UpiCollectDetails {\n");

        sb.append("    billingSequenceNumber: ").append(billingSequenceNumber).append("\n");
        sb.append("    recurringDetailReference: ").append(recurringDetailReference).append("\n");
        sb.append("    shopperNotificationReference: ").append(shopperNotificationReference).append("\n");
        sb.append("    storedPaymentMethodId: ").append(storedPaymentMethodId).append("\n");
        sb.append("    type: ").append(type).append("\n");
        sb.append("    virtualPaymentAddress: ").append(virtualPaymentAddress).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
