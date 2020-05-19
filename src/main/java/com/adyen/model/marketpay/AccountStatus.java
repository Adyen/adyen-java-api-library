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
 * Copyright (c) 2017 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */
package com.adyen.model.marketpay;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * AccountStatus
 */
public class AccountStatus {
    @SerializedName("status")
    private String status = null;

    @SerializedName("states")
    private List<AccountState> states = new ArrayList<>();

    @SerializedName("accountEvents")
    private List<AccountEvent> accountEvents = new ArrayList<>();

    public AccountStatus status(String status) {
        this.status = status;
        return this;
    }

    /**
     * account status
     *
     * @return status
     **/
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public AccountStatus states(List<AccountState> states) {
        this.states = states;
        return this;
    }

    public AccountStatus addStatesItem(AccountState statesItem) {
        this.states.add(statesItem);
        return this;
    }

    /**
     * account states
     *
     * @return states
     **/
    public List<AccountState> getStates() {
        return states;
    }

    public void setStates(List<AccountState> states) {
        this.states = states;
    }

    public AccountStatus accountEvents(List<AccountEvent> accountEvents) {
        this.accountEvents = accountEvents;
        return this;
    }

    public AccountStatus addAccountEventsItem(AccountEvent accountEventsItem) {
        this.accountEvents.add(accountEventsItem);
        return this;
    }

    /**
     * account events
     *
     * @return accountEvents
     **/
    public List<AccountEvent> getAccountEvents() {
        return accountEvents;
    }

    public void setAccountEvents(List<AccountEvent> accountEvents) {
        this.accountEvents = accountEvents;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountStatus accountStatus = (AccountStatus) o;
        return Objects.equals(this.status, accountStatus.status) && Objects.equals(this.states, accountStatus.states) && Objects.equals(this.accountEvents, accountStatus.accountEvents);
    }

    @Override
    public int hashCode() {
        return Objects.hash(status, states, accountEvents);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountStatus {\n");

        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    states: ").append(toIndentedString(states)).append("\n");
        sb.append("    accountEvents: ").append(toIndentedString(accountEvents)).append("\n");
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

