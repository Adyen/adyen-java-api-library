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
 * DeleteBankAccountRequest
 */
public class DeleteBankAccountRequest {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("bankAccountUUIDs")
    private List<String> bankAccountUUIDs = new ArrayList<>();

    public DeleteBankAccountRequest accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * account holder code, whose bank accounts have to be deleted
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public DeleteBankAccountRequest bankAccountUUIDs(List<String> bankAccountUUIDs) {
        this.bankAccountUUIDs = bankAccountUUIDs;
        return this;
    }

    public DeleteBankAccountRequest addBankAccountUUIDsItem(String bankAccountUUIDsItem) {
        this.bankAccountUUIDs.add(bankAccountUUIDsItem);
        return this;
    }

    /**
     * codes of the bank accounts to be deleted
     *
     * @return bankAccountUUIDs
     **/
    public List<String> getBankAccountUUIDs() {
        return bankAccountUUIDs;
    }

    public void setBankAccountUUIDs(List<String> bankAccountUUIDs) {
        this.bankAccountUUIDs = bankAccountUUIDs;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        DeleteBankAccountRequest deleteBankAccountRequest = (DeleteBankAccountRequest) o;
        return Objects.equals(this.accountHolderCode, deleteBankAccountRequest.accountHolderCode) && Objects.equals(this.bankAccountUUIDs, deleteBankAccountRequest.bankAccountUUIDs);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, bankAccountUUIDs);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DeleteBankAccountRequest {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    bankAccountUUIDs: ").append(toIndentedString(bankAccountUUIDs)).append("\n");
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

