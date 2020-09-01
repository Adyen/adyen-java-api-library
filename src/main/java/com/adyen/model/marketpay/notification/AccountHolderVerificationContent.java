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

package com.adyen.model.marketpay.notification;


import com.adyen.model.marketpay.KYCCheckStatusData;
import com.google.gson.annotations.SerializedName;

import static com.adyen.util.Util.toIndentedString;

public class AccountHolderVerificationContent {
    private String accountHolderCode;
    private String shareholderCode;
    private String bankAccountUUID;
    KYCCheckStatusData.CheckTypeEnum verificationType;
    KYCCheckStatusData.CheckStatusEnum verificationStatus;
    @SerializedName("kycCheckStatusData")
    private KYCCheckStatusData kycCheckStatusData = null;

    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public String getShareholderCode() {
        return shareholderCode;
    }

    public void setShareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
    }

    public String getBankAccountUUID() {
        return bankAccountUUID;
    }

    public void setBankAccountUUID(String bankAccountUUID) {
        this.bankAccountUUID = bankAccountUUID;
    }

    public KYCCheckStatusData.CheckTypeEnum getVerificationType() {
        return verificationType;
    }

    public void setVerificationType(KYCCheckStatusData.CheckTypeEnum verificationType) {
        this.verificationType = verificationType;
    }

    public KYCCheckStatusData.CheckStatusEnum getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(KYCCheckStatusData.CheckStatusEnum verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public KYCCheckStatusData getKycCheckStatusData() {
        return kycCheckStatusData;
    }

    public void setKycCheckStatusData(KYCCheckStatusData kycCheckStatusData) {
        this.kycCheckStatusData = kycCheckStatusData;
    }

    @Override
    public String toString() {
        return "AccountHolderVerificationContent{"
                + "accountHolderCode='"
                + accountHolderCode
                + '\''
                + ", shareholderCode='"
                + shareholderCode
                + '\''
                + ", bankAccountUUID='"
                + bankAccountUUID
                + '\''
                + ", verificationType="
                + verificationType
                + ", verificationStatus="
                + verificationStatus
                + ", statusSummary="
                + toIndentedString(kycCheckStatusData)
                + '}';
    }
}
