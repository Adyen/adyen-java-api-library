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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.SerializedName;

public class AccountEventContainer {
    @SerializedName("AccountEvent")
    @JsonProperty("AccountEvent")
    private AccountEvent accountEvent = null;

    public AccountEvent getAccountEvent() {
        return accountEvent;
    }

    public void setAccountEvent(AccountEvent accountEvent) {
        this.accountEvent = accountEvent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountEventContainer that = (AccountEventContainer) o;

        return accountEvent != null ? accountEvent.equals(that.accountEvent) : that.accountEvent == null;
    }

    @Override
    public int hashCode() {
        return accountEvent != null ? accountEvent.hashCode() : 0;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("AccountEventContainer{");
        sb.append("accountEvent=").append(accountEvent);
        sb.append('}');
        return sb.toString();
    }


}
