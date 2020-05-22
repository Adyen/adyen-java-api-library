/*
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
 * Copyright (c) 2019 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.checkout;

import com.adyen.model.Amount;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

import static com.adyen.constants.TextConstants.LINE_BREAK;
import static com.adyen.util.Util.toIndentedString;

/**
 * CreatePaymentLinkResponse
 */
public class CreatePaymentLinkResponse {
    @SerializedName("amount")
    private Amount amount = null;

    @SerializedName("expiresAt")
    private String expiresAt = null;

    @SerializedName("reference")
    private String reference = null;

    @SerializedName("url")
    private String url = null;

    public CreatePaymentLinkResponse amount(Amount amount) {
        this.amount = amount;
        return this;
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

    public CreatePaymentLinkResponse expiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
        return this;
    }

    /**
     * The date that the Pay By Link expires; e.g. 2019-03-23T12:25:28Z.
     *
     * @return expiresAt
     **/
    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }

    public CreatePaymentLinkResponse reference(String reference) {
        this.reference = reference;
        return this;
    }

    /**
     * The reference that was specified when the Pay By Link URL was created.
     *
     * @return reference
     **/
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public CreatePaymentLinkResponse url(String url) {
        this.url = url;
        return this;
    }

    /**
     * The URL at which the shopper can complete the payment.
     *
     * @return url
     **/
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        CreatePaymentLinkResponse createPaymentLinkResponse = (CreatePaymentLinkResponse) o;
        return Objects.equals(this.amount, createPaymentLinkResponse.amount) &&
                Objects.equals(this.expiresAt, createPaymentLinkResponse.expiresAt) &&
                Objects.equals(this.reference, createPaymentLinkResponse.reference) &&
                Objects.equals(this.url, createPaymentLinkResponse.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(amount, expiresAt, reference, url);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class CreatePaymentLinkResponse {").append(LINE_BREAK);

        sb.append("    amount: ").append(toIndentedString(amount)).append(LINE_BREAK);
        sb.append("    expiresAt: ").append(toIndentedString(expiresAt)).append(LINE_BREAK);
        sb.append("    reference: ").append(toIndentedString(reference)).append(LINE_BREAK);
        sb.append("    url: ").append(toIndentedString(url)).append(LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }



}
