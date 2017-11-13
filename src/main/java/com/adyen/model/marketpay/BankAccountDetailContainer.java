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

import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * BankAccountDetail Container
 */
public class BankAccountDetailContainer {
    @SerializedName("BankAccountDetail")
    private BankAccountDetail bankAccountDetail = null;

    public BankAccountDetailContainer(BankAccountDetail bankAccountDetail) {
        this.bankAccountDetail = bankAccountDetail;
    }

    /**
     * bankAccountDetail
     *
     * @return bankAccountDetail
     */
    public BankAccountDetail getBankAccountDetail() {
        return bankAccountDetail;
    }

    public void setBankAccountDetail(BankAccountDetail bankAccountDetail) {
        this.bankAccountDetail = bankAccountDetail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BankAccountDetailContainer bankAccountDetailContainer = (BankAccountDetailContainer) o;
        return Objects.equals(this.bankAccountDetail, bankAccountDetailContainer.bankAccountDetail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountDetail);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class BankAccountDetailContainer {\n");

        sb.append("    bankAccountDetail: ").append(toIndentedString(bankAccountDetail)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
