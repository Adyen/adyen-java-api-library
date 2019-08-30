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
package com.adyen.model.terminal;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * Connected Terminals Request
 */
public class ConnectedTerminalsRequest {

    @SerializedName("merchantAccount")
    private String merchantAccount;

    @SerializedName("store")
    private String store;

    @SerializedName("uniqueTerminalId")
    private String uniqueTerminalId;



    public String getMerchantAccount() {
        return merchantAccount;
    }

    public void setMerchantAccount(String merchantAccount) {
        this.merchantAccount = merchantAccount;
    }

    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public String getUniqueTerminalId() {
        return uniqueTerminalId;
    }

    public void setUniqueTerminalId(String uniqueTerminalId) {
        this.uniqueTerminalId = uniqueTerminalId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectedTerminalsRequest that = (ConnectedTerminalsRequest) o;
        return Objects.equals(merchantAccount, that.merchantAccount) &&
                Objects.equals(store, that.store) &&
                Objects.equals(uniqueTerminalId, that.uniqueTerminalId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantAccount, store, uniqueTerminalId);
    }

    @Override
    public String toString() {
        return "ConnectedTerminalsRequest{" +
                "merchantAccount='" + merchantAccount + '\'' +
                ", store='" + store + '\'' +
                ", uniqueTerminalId='" + uniqueTerminalId + '\'' +
                '}';
    }
}
