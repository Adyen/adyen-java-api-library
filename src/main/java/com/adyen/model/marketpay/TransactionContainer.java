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
 * TransactionContainer
 */
public class TransactionContainer {
    @SerializedName("Transaction")
    private Transaction transaction = null;

    public TransactionContainer(Transaction transaction) {
        this.transaction = transaction;
    }

    /**
     * transaction
     *
     * @return transaction
     */
    public Transaction getTransaction() {
        return transaction;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        TransactionContainer transactionContainer = (TransactionContainer) o;
        return Objects.equals(this.transaction, transactionContainer.transaction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(transaction);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransactionContainer {\n");

        sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
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
