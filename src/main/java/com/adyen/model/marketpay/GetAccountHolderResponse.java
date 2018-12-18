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
 * GetAccountHolderResponse
 */
public class GetAccountHolderResponse {
    @SerializedName("verification")
    private KYCVerificationResult verification = null;

    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("requirementsForNextAccountState")
    private List<AccountStateRequirement> requirementsForNextAccountState = new ArrayList<AccountStateRequirement>();

    @SerializedName("accountHolderDetails")
    private AccountHolderDetails accountHolderDetails = null;

    @SerializedName("accountHolderStatus")
    private AccountHolderStatus accountHolderStatus = null;

    @SerializedName("accounts")
    private List<AccountContainer> accountContainers = null;

    private transient List<Account> accounts = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("pspReference")
    private String pspReference = null;

    /**
     * account holder legal entity type (Busines / Individual)
     */
    public enum LegalEntityEnum {
        @SerializedName("Business") BUSINESS("Business"),

        @SerializedName("Individual") INDIVIDUAL("Individual");

        private String value;

        LegalEntityEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("legalEntity")
    private LegalEntityEnum legalEntity = null;

    @SerializedName("primaryCurrency")
    private String primaryCurrency = null;

    public GetAccountHolderResponse verificationResult(KYCVerificationResult verificationResult) {
        this.verification = verificationResult;
        return this;
    }

    /**
     * verification result
     *
     * @return verificationResult
     * @deprecated
     **/
    public KYCVerificationResult getVerificationResult() {
        return verification;
    }

    /**
     * verification result
     *
     * @return verification
     **/
    public KYCVerificationResult getVerification() {
        return verification;
    }

    public void setVerification(KYCVerificationResult verification) {
        this.verification = verification;
    }

    public GetAccountHolderResponse submittedAsync(Boolean submittedAsync) {
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

    public GetAccountHolderResponse accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * account holder code
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public GetAccountHolderResponse requirementsForNextAccountState(List<AccountStateRequirement> requirementsForNextAccountState) {
        this.requirementsForNextAccountState = requirementsForNextAccountState;
        return this;
    }

    public GetAccountHolderResponse addRequirementsForNextAccountStateItem(AccountStateRequirement requirementsForNextAccountStateItem) {
        this.requirementsForNextAccountState.add(requirementsForNextAccountStateItem);
        return this;
    }

    /**
     * account holder properties that must be provided, in order for the account holder to reach the next processing state level
     *
     * @return requirementsForNextAccountState
     **/
    public List<AccountStateRequirement> getRequirementsForNextAccountState() {
        return requirementsForNextAccountState;
    }

    public void setRequirementsForNextAccountState(List<AccountStateRequirement> requirementsForNextAccountState) {
        this.requirementsForNextAccountState = requirementsForNextAccountState;
    }

    public GetAccountHolderResponse accountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
        return this;
    }

    /**
     * account holder properties
     *
     * @return accountHolderDetails
     **/
    public AccountHolderDetails getAccountHolderDetails() {
        return accountHolderDetails;
    }

    public void setAccountHolderDetails(AccountHolderDetails accountHolderDetails) {
        this.accountHolderDetails = accountHolderDetails;
    }

    public GetAccountHolderResponse accountHolderStatus(AccountHolderStatus accountHolderStatus) {
        this.accountHolderStatus = accountHolderStatus;
        return this;
    }

    /**
     * account holder status
     *
     * @return accountHolderStatus
     **/
    public AccountHolderStatus getAccountHolderStatus() {
        return accountHolderStatus;
    }

    public void setAccountHolderStatus(AccountHolderStatus accountHolderStatus) {
        this.accountHolderStatus = accountHolderStatus;
    }

    /**
     * Populate the virtual accounts to bypass the accountContainers list
     *
     * @return accounts
     */
    public List<Account> getAccounts() {
        if (accounts == null) {
            accounts = new ArrayList<Account>();
            if (accountContainers != null && !accountContainers.isEmpty()) {
                for (AccountContainer accountContainer : accountContainers) {
                    accounts.add(accountContainer.getAccount());
                }
            }
        }
        return accounts;
    }

    /**
     * Creating a new accounts list
     *
     * @param accounts accounts
     */
    public void setAccounts(List<Account> accounts) {

        this.accounts = accounts;

        // set as well the container list this will be send in the API request
        this.accountContainers = new ArrayList<AccountContainer>();

        for (Account account : accounts) {

            AccountContainer accountContainer = new AccountContainer(account);
            this.accountContainers.add(accountContainer);
        }
    }

    /**
     * Add account to the accountContainers and accounts lists
     *
     * @param account Account
     * @return AccountHolderResponse
     */
    public GetAccountHolderResponse addAccount(Account account) {
        AccountContainer accountContainer = new AccountContainer(account);

        if (accountContainers == null) {
            accountContainers = new ArrayList<AccountContainer>();
        }
        this.accountContainers.add(accountContainer);

        if (accounts == null) {
            accounts = new ArrayList<Account>();
        }

        this.accounts.add(account);

        return this;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public GetAccountHolderResponse pspReference(String pspReference) {
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

    public GetAccountHolderResponse legalEntity(LegalEntityEnum legalEntity) {
        this.legalEntity = legalEntity;
        return this;
    }

    /**
     * account holder legal entity type (Busines / Individual)
     *
     * @return legalEntity
     **/
    public LegalEntityEnum getLegalEntity() {
        return legalEntity;
    }

    public void setLegalEntity(LegalEntityEnum legalEntity) {
        this.legalEntity = legalEntity;
    }


    public String getPrimaryCurrency() {
        return primaryCurrency;
    }

    public void setPrimaryCurrency(String primaryCurrency) {
        this.primaryCurrency = primaryCurrency;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetAccountHolderResponse getAccountHolderResponse = (GetAccountHolderResponse) o;
        return Objects.equals(this.verification, getAccountHolderResponse.verification)
                && Objects.equals(this.submittedAsync, getAccountHolderResponse.submittedAsync)
                && Objects.equals(this.accountHolderCode, getAccountHolderResponse.accountHolderCode)
                && Objects.equals(this.requirementsForNextAccountState, getAccountHolderResponse.requirementsForNextAccountState)
                && Objects.equals(this.accountHolderDetails, getAccountHolderResponse.accountHolderDetails)
                && Objects.equals(this.accountHolderStatus, getAccountHolderResponse.accountHolderStatus)
                && Objects.equals(this.accountContainers, getAccountHolderResponse.accountContainers)
                && Objects.equals(this.description, getAccountHolderResponse.description)
                && Objects.equals(this.pspReference, getAccountHolderResponse.pspReference)
                && Objects.equals(this.legalEntity, getAccountHolderResponse.legalEntity)
                && Objects.equals(this.primaryCurrency, getAccountHolderResponse.primaryCurrency);
    }

    @Override
    public int hashCode() {
        return Objects.hash(verification,
                            submittedAsync,
                            accountHolderCode,
                            requirementsForNextAccountState,
                            accountHolderDetails,
                            accountHolderStatus,
                            accountContainers,
                            description,
                            pspReference,
                            legalEntity,
                            primaryCurrency);
    }


    @Override
    public String toString() {
        // Populate the accounts list to provide back in the toString() method
        this.getAccounts();

        StringBuilder sb = new StringBuilder();
        sb.append("class GetAccountHolderResponse {\n");
        sb.append("    verification: ").append(toIndentedString(verification)).append("\n");
        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    requirementsForNextAccountState: ").append(toIndentedString(requirementsForNextAccountState)).append("\n");
        sb.append("    accountHolderDetails: ").append(toIndentedString(accountHolderDetails)).append("\n");
        sb.append("    accountHolderStatus: ").append(toIndentedString(accountHolderStatus)).append("\n");
        sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    legalEntity: ").append(toIndentedString(legalEntity)).append("\n");
        sb.append("    primaryCurrency: ").append(toIndentedString(primaryCurrency)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces (except the first line).
     *
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }

}

