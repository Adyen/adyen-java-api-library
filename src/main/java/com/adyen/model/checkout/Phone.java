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
 * Copyright (c) 2022 Adyen N.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.checkout;

import com.google.gson.annotations.SerializedName;
import java.util.Objects;

public class Phone {
    @SerializedName("cc")
    private String cc = null;

    @SerializedName("subscriber")
    private String subscriber = null;

    public Phone cc(String cc) {
        this.cc = cc;
        return this;
    }

    /**
     * Country code. Length: 1–3 characters.
     * @return cc
     **/
    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public Phone subscriber(String subscriber) {
        this.subscriber = subscriber;
        return this;
    }

    /**
     * Subscriber number. Maximum length: 15 characters.
     * @return subscriber
     **/
    public String getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(String subscriber) {
        this.subscriber = subscriber;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Phone phone = (Phone) o;
        return Objects.equals(this.cc, phone.cc) &&
                Objects.equals(this.subscriber, phone.subscriber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cc, subscriber);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Phone {\n");

        sb.append("    cc: ").append(toIndentedString(cc)).append("\n");
        sb.append("    subscriber: ").append(toIndentedString(subscriber)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(java.lang.Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}
