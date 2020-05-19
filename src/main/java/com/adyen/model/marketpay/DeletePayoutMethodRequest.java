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
 * Copyright (c) 2020 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * DeletePayoutMethodRequest
 */
public class DeletePayoutMethodRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("payoutMethodCodes")
    private List<String> payoutMethodCodes = new ArrayList<>();

    public DeletePayoutMethodRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The code of the account holder, from which to delete the payout methods.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public DeletePayoutMethodRequest payoutMethodCodes(List<String> payoutMethodCodes) {
        this.payoutMethodCodes = payoutMethodCodes;
        return this;
    }

    public DeletePayoutMethodRequest addPayoutMethodCodesItem(String payoutMethodCodesItem) {
        this.payoutMethodCodes.add(payoutMethodCodesItem);
        return this;
    }

    /**
     * The codes of the payout methods to be deleted.
     *
     * @return payoutMethodCodes
     **/
    public List<String> getPayoutMethodCodes() {
        return payoutMethodCodes;
    }

    public void setPayoutMethodCodes(List<String> payoutMethodCodes) {
        this.payoutMethodCodes = payoutMethodCodes;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeletePayoutMethodRequest deletePayoutMethodRequest = (DeletePayoutMethodRequest) o;
        return Objects.equals(this.accountHolderCode, deletePayoutMethodRequest.accountHolderCode) &&
                Objects.equals(this.payoutMethodCodes, deletePayoutMethodRequest.payoutMethodCodes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, payoutMethodCodes);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeletePayoutMethodRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    payoutMethodCodes: ").append(toIndentedString(payoutMethodCodes)).append("\n");
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
