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
 * AccountHolderTransactionListResponse
 */
public class AccountHolderTransactionListResponse {
    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("accountTransactionLists")
    private List<AccountTransactionListContainer> accountTransactionListContainers = null;

    private transient List<AccountTransactionList> accountTransactionLists = null;

    @SerializedName("resultCode")
    private String resultCode = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    public AccountHolderTransactionListResponse submittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
        return this;
    }

    /**
     * Get submittedAsync
     *
     * @return submittedAsync
     **/
    public Boolean getSubmittedAsync() {
        return submittedAsync;
    }

    public void setSubmittedAsync(Boolean submittedAsync) {
        this.submittedAsync = submittedAsync;
    }

    public AccountHolderTransactionListResponse accountTransactionListContainers(List<AccountTransactionListContainer> accountTransactionListContainers) {
        this.accountTransactionListContainers = accountTransactionListContainers;
        return this;
    }

    public AccountHolderTransactionListResponse addAccountTransactionListContainersItem(AccountTransactionListContainer accountTransactionListContainerItem) {
        this.accountTransactionListContainers.add(accountTransactionListContainerItem);
        return this;
    }

    /**
     * Populate the virtual accountTransactionLists to bypass the accountTransactionListContainers list
     *
     * @return accountTransactionLists
     **/
    public List<AccountTransactionList> getAccountTransactionLists() {
        if (accountTransactionLists == null) {
            accountTransactionLists = new ArrayList<AccountTransactionList>();
            if (accountTransactionListContainers != null && ! accountTransactionListContainers.isEmpty()) {
                for (AccountTransactionListContainer accountTransactionListContainer : accountTransactionListContainers) {
                    accountTransactionLists.add(accountTransactionListContainer.getAccountTransactionList());
                }
            }
        }
        return accountTransactionLists;
    }

    /**
     * Creating a new accountTransactionLists list
     * @param accountTransactionLists  AccountTransactionList

     */
    public void setAccountTransactionLists(List<AccountTransactionList> accountTransactionLists) {

        this.accountTransactionLists = accountTransactionLists;

        this.accountTransactionListContainers = new ArrayList<AccountTransactionListContainer>();

        for (AccountTransactionList accountTransactionList : accountTransactionLists) {

            AccountTransactionListContainer accountTransactionListContainer = new AccountTransactionListContainer(accountTransactionList);
            this.accountTransactionListContainers.add(accountTransactionListContainer);
        }

    }

    /**
     * Creating a new AccountHolderTransactionList Response
     *
     * @param accountTransactionList accountTransactionList
     * @return AccountHolderTransactionListResponse
     */
    public AccountHolderTransactionListResponse addAccountTransactionList(AccountTransactionList accountTransactionList) {
        AccountTransactionListContainer accountTransactionListContainer = new AccountTransactionListContainer(accountTransactionList);

        if (accountTransactionListContainers == null) {
            accountTransactionListContainers = new ArrayList<AccountTransactionListContainer>();
        }
        this.accountTransactionListContainers.add(accountTransactionListContainer);

        if (accountTransactionLists == null) {
            accountTransactionLists = new ArrayList<AccountTransactionList>();
        }
        this.accountTransactionLists.add(accountTransactionList);

        return this;
    }

    public AccountHolderTransactionListResponse resultCode(String resultCode) {
        this.resultCode = resultCode;
        return this;
    }

    /**
     * The result code
     *
     * @return resultCode
     **/
    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public AccountHolderTransactionListResponse pspReference(String pspReference) {
        this.pspReference = pspReference;
        return this;
    }

    /**
     * psp reference
     *
     * @return pspReference
     **/
    public String getPspReference() {
        return pspReference;
    }

    public void setPspReference(String pspReference) {
        this.pspReference = pspReference;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderTransactionListResponse accountHolderTransactionListResponse = (AccountHolderTransactionListResponse) o;
        return Objects.equals(this.submittedAsync, accountHolderTransactionListResponse.submittedAsync)
                && Objects.equals(this.accountTransactionListContainers,
                                  accountHolderTransactionListResponse.accountTransactionListContainers)
                && Objects.equals(this.resultCode, accountHolderTransactionListResponse.resultCode)
                && Objects.equals(this.pspReference, accountHolderTransactionListResponse.pspReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(submittedAsync, accountTransactionListContainers, resultCode, pspReference);
    }


    @Override
    public String toString() {
        // Populate the accountTransactionLists list to provide back in the toString() method
        this.getAccountTransactionLists();
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderTransactionListResponse {\n");

        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    accountTransactionLists: ").append(toIndentedString(accountTransactionLists)).append("\n");
        sb.append("    resultCode: ").append(toIndentedString(resultCode)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

