/**
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
package com.adyen.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import com.google.gson.annotations.SerializedName;

/**
 * GetAccountHolderResponse
 */
public class GetAccountHolderResponse {
    @SerializedName("accountStatus")
    private AccountStatus accountStatus = null;

    @SerializedName("verificationResult")
    private KYCVerificationResult verificationResult = null;

    @SerializedName("submittedAsync")
    private Boolean submittedAsync = null;

    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("virtualAccounts")
    private List<String> virtualAccounts = new ArrayList<String>();

    @SerializedName("requirementsForNextAccountState")
    private List<AccountStateRequirement> requirementsForNextAccountState = new ArrayList<AccountStateRequirement>();

    @SerializedName("accountHolderDetails")
    private AccountHolderDetails accountHolderDetails = null;

    @SerializedName("accountHolderStatus")
    private AccountHolderStatus accountHolderStatus = null;

    @SerializedName("accounts")
    private List<Account> accounts = new ArrayList<Account>();

    @SerializedName("pspReference")
    private String pspReference = null;

    @SerializedName("kycVerificationResults")
    private List<KYCVerificationResult> kycVerificationResults = new ArrayList<KYCVerificationResult>();

    /**
     * account holder legal entity type (Busines / Individual)
     */
    public enum LegalEntityEnum {
        @SerializedName("Business")
        BUSINESS("Business"),

        @SerializedName("Individual")
        INDIVIDUAL("Individual");

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

    public GetAccountHolderResponse accountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
        return this;
    }

    /**
     * account holder status
     *
     * @return accountStatus
     **/
    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public GetAccountHolderResponse verificationResult(KYCVerificationResult verificationResult) {
        this.verificationResult = verificationResult;
        return this;
    }

    /**
     * verification result
     *
     * @return verificationResult
     **/
    public KYCVerificationResult getVerificationResult() {
        return verificationResult;
    }

    public void setVerificationResult(KYCVerificationResult verificationResult) {
        this.verificationResult = verificationResult;
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

    public GetAccountHolderResponse virtualAccounts(List<String> virtualAccounts) {
        this.virtualAccounts = virtualAccounts;
        return this;
    }

    public GetAccountHolderResponse addVirtualAccountsItem(String virtualAccountsItem) {
        this.virtualAccounts.add(virtualAccountsItem);
        return this;
    }

    /**
     * account holder's accounts
     *
     * @return virtualAccounts
     **/
    public List<String> getVirtualAccounts() {
        return virtualAccounts;
    }

    public void setVirtualAccounts(List<String> virtualAccounts) {
        this.virtualAccounts = virtualAccounts;
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

    public GetAccountHolderResponse accounts(List<Account> accounts) {
        this.accounts = accounts;
        return this;
    }

    public GetAccountHolderResponse addAccountsItem(Account accountsItem) {
        this.accounts.add(accountsItem);
        return this;
    }

    /**
     * accounts
     *
     * @return accounts
     **/
    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
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

    public GetAccountHolderResponse kycVerificationResults(List<KYCVerificationResult> kycVerificationResults) {
        this.kycVerificationResults = kycVerificationResults;
        return this;
    }

    public GetAccountHolderResponse addKycVerificationResultsItem(KYCVerificationResult kycVerificationResultsItem) {
        this.kycVerificationResults.add(kycVerificationResultsItem);
        return this;
    }

    /**
     * Get kycVerificationResults
     *
     * @return kycVerificationResults
     **/
    public List<KYCVerificationResult> getKycVerificationResults() {
        return kycVerificationResults;
    }

    public void setKycVerificationResults(List<KYCVerificationResult> kycVerificationResults) {
        this.kycVerificationResults = kycVerificationResults;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GetAccountHolderResponse getAccountHolderResponse = (GetAccountHolderResponse) o;
        return Objects.equals(this.accountStatus, getAccountHolderResponse.accountStatus)
                && Objects.equals(this.verificationResult, getAccountHolderResponse.verificationResult)
                && Objects.equals(this.submittedAsync, getAccountHolderResponse.submittedAsync)
                && Objects.equals(this.accountHolderCode, getAccountHolderResponse.accountHolderCode)
                && Objects.equals(this.virtualAccounts, getAccountHolderResponse.virtualAccounts)
                && Objects.equals(this.requirementsForNextAccountState, getAccountHolderResponse.requirementsForNextAccountState)
                && Objects.equals(this.accountHolderDetails, getAccountHolderResponse.accountHolderDetails)
                && Objects.equals(this.accountHolderStatus, getAccountHolderResponse.accountHolderStatus)
                && Objects.equals(this.accounts, getAccountHolderResponse.accounts)
                && Objects.equals(this.pspReference, getAccountHolderResponse.pspReference)
                && Objects.equals(this.kycVerificationResults, getAccountHolderResponse.kycVerificationResults)
                && Objects.equals(this.legalEntity, getAccountHolderResponse.legalEntity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountStatus,
                            verificationResult,
                            submittedAsync,
                            accountHolderCode,
                            virtualAccounts,
                            requirementsForNextAccountState,
                            accountHolderDetails,
                            accountHolderStatus,
                            accounts,
                            pspReference,
                            kycVerificationResults,
                            legalEntity);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class GetAccountHolderResponse {\n");

        sb.append("    accountStatus: ").append(toIndentedString(accountStatus)).append("\n");
        sb.append("    verificationResult: ").append(toIndentedString(verificationResult)).append("\n");
        sb.append("    submittedAsync: ").append(toIndentedString(submittedAsync)).append("\n");
        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    virtualAccounts: ").append(toIndentedString(virtualAccounts)).append("\n");
        sb.append("    requirementsForNextAccountState: ").append(toIndentedString(requirementsForNextAccountState)).append("\n");
        sb.append("    accountHolderDetails: ").append(toIndentedString(accountHolderDetails)).append("\n");
        sb.append("    accountHolderStatus: ").append(toIndentedString(accountHolderStatus)).append("\n");
        sb.append("    accounts: ").append(toIndentedString(accounts)).append("\n");
        sb.append("    pspReference: ").append(toIndentedString(pspReference)).append("\n");
        sb.append("    kycVerificationResults: ").append(toIndentedString(kycVerificationResults)).append("\n");
        sb.append("    legalEntity: ").append(toIndentedString(legalEntity)).append("\n");
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

