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

package com.adyen.model.checkout.details;

import com.adyen.model.checkout.PaymentMethodDetails;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * AchDetails
 */

public class AchDetails implements PaymentMethodDetails {
    /**
     * Possible types
     */
    public static final String ACH = "ach";

    @SerializedName("bankAccountNumber")
    private String bankAccountNumber = null;

    @SerializedName("bankLocationId")
    private String bankLocationId = null;

    @SerializedName("encryptedBankAccountNumber")
    private String encryptedBankAccountNumber = null;

    @SerializedName("encryptedBankLocationId")
    private String encryptedBankLocationId = null;

    @SerializedName("ownerName")
    private String ownerName = null;

    @SerializedName("type")
    private String type = ACH;

    public AchDetails bankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
        return this;
    }

    /**
     * The bank account number (without separators).
     *
     * @return bankAccountNumber
     **/
    public String getBankAccountNumber() {
        return bankAccountNumber;
    }

    public void setBankAccountNumber(String bankAccountNumber) {
        this.bankAccountNumber = bankAccountNumber;
    }

    public AchDetails bankLocationId(String bankLocationId) {
        this.bankLocationId = bankLocationId;
        return this;
    }

    /**
     * The bank routing number of the account. The field value is &#x60;nil&#x60; in most cases.
     *
     * @return bankLocationId
     **/
    public String getBankLocationId() {
        return bankLocationId;
    }

    public void setBankLocationId(String bankLocationId) {
        this.bankLocationId = bankLocationId;
    }

    public AchDetails encryptedBankAccountNumber(String encryptedBankAccountNumber) {
        this.encryptedBankAccountNumber = encryptedBankAccountNumber;
        return this;
    }

    /**
     * Encrypted bank account number. The bank account number (without separators).
     *
     * @return encryptedBankAccountNumber
     **/
    public String getEncryptedBankAccountNumber() {
        return encryptedBankAccountNumber;
    }

    public void setEncryptedBankAccountNumber(String encryptedBankAccountNumber) {
        this.encryptedBankAccountNumber = encryptedBankAccountNumber;
    }

    public AchDetails encryptedBankLocationId(String encryptedBankLocationId) {
        this.encryptedBankLocationId = encryptedBankLocationId;
        return this;
    }

    /**
     * Encrypted location id. The bank routing number of the account. The field value is &#x60;nil&#x60; in most cases.
     *
     * @return encryptedBankLocationId
     **/
    public String getEncryptedBankLocationId() {
        return encryptedBankLocationId;
    }

    public void setEncryptedBankLocationId(String encryptedBankLocationId) {
        this.encryptedBankLocationId = encryptedBankLocationId;
    }

    public AchDetails ownerName(String ownerName) {
        this.ownerName = ownerName;
        return this;
    }

    /**
     * The name of the bank account holder. If you submit a name with non-Latin characters, we automatically replace some of them with corresponding Latin characters to meet the FATF recommendations. For example: * χ12 is converted to ch12. * üA is converted to euA. * Peter Møller is converted to Peter Mller, because banks don&#x27;t accept &#x27;ø&#x27;. After replacement, the ownerName must have at least three alphanumeric characters (A-Z, a-z, 0-9), and at least one of them must be a valid Latin character (A-Z, a-z). For example: * John17 - allowed. * J17 - allowed. * 171 - not allowed. * John-7 - allowed. &gt; If provided details don&#x27;t match the required format, the response returns the error message: 203 &#x27;Invalid bank account holder name&#x27;.
     *
     * @return ownerName
     **/
    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public AchDetails type(String type) {
        this.type = type;
        return this;
    }

    /**
     * **ach**
     *
     * @return type
     **/
    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AchDetails achDetails = (AchDetails) o;
        return Objects.equals(this.bankAccountNumber, achDetails.bankAccountNumber) &&
                Objects.equals(this.bankLocationId, achDetails.bankLocationId) &&
                Objects.equals(this.encryptedBankAccountNumber, achDetails.encryptedBankAccountNumber) &&
                Objects.equals(this.encryptedBankLocationId, achDetails.encryptedBankLocationId) &&
                Objects.equals(this.ownerName, achDetails.ownerName) &&
                Objects.equals(this.type, achDetails.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bankAccountNumber, bankLocationId, encryptedBankAccountNumber, encryptedBankLocationId, ownerName, type);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AchDetails {\n");

        sb.append("    bankAccountNumber: ").append(toIndentedString(bankAccountNumber)).append("\n");
        sb.append("    bankLocationId: ").append(toIndentedString(bankLocationId)).append("\n");
        sb.append("    encryptedBankAccountNumber: ").append(toIndentedString(encryptedBankAccountNumber)).append("\n");
        sb.append("    encryptedBankLocationId: ").append(toIndentedString(encryptedBankLocationId)).append("\n");
        sb.append("    ownerName: ").append(toIndentedString(ownerName)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
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
