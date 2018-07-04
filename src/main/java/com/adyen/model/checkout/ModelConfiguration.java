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
 * Copyright (c) 2018 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout;

import com.adyen.model.Installments;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * ModelConfiguration
 */
public class ModelConfiguration {

    @SerializedName("avs")
    private Avs avs = null;

    @SerializedName("cardHolderNameRequired")
    private Boolean cardHolderNameRequired = null;

    @SerializedName("installments")
    private Installments installments = null;

    public ModelConfiguration avs(Avs avs) {
        this.avs = avs;
        return this;
    }


    /**
     * Get avs
     *
     * @return avs
     **/
    public Avs getAvs() {
        return avs;
    }

    public void setAvs(Avs avs) {
        this.avs = avs;
    }

    public ModelConfiguration cardHolderNameRequired(Boolean cardHolderNameRequired) {
        this.cardHolderNameRequired = cardHolderNameRequired;
        return this;
    }


    /**
     * When set to true, the shopper has to provide the cardholder name for card payments.
     *
     * @return cardHolderNameRequired
     **/
    public Boolean isCardHolderNameRequired() {
        return cardHolderNameRequired;
    }

    public void setCardHolderNameRequired(Boolean cardHolderNameRequired) {
        this.cardHolderNameRequired = cardHolderNameRequired;
    }

    public ModelConfiguration installments(Installments installments) {
        this.installments = installments;
        return this;
    }


    /**
     * Get installments
     *
     * @return installments
     **/
    public Installments getInstallments() {
        return installments;
    }

    public void setInstallments(Installments installments) {
        this.installments = installments;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ModelConfiguration _configuration = (ModelConfiguration) o;
        return Objects.equals(this.avs, _configuration.avs) &&
                Objects.equals(this.cardHolderNameRequired, _configuration.cardHolderNameRequired) &&
                Objects.equals(this.installments, _configuration.installments);
    }

    @Override
    public int hashCode() {
        return Objects.hash(avs, cardHolderNameRequired, installments);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ModelConfiguration {\n");

        sb.append("    avs: ").append(toIndentedString(avs)).append("\n");
        sb.append("    cardHolderNameRequired: ").append(toIndentedString(cardHolderNameRequired)).append("\n");
        sb.append("    installments: ").append(toIndentedString(installments)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }


}



