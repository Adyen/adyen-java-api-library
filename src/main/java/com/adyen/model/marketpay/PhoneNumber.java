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

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;


import static com.adyen.util.Util.toIndentedString;

/**
 * PhoneNumber
 */
public class PhoneNumber {
    /**
     * Gets or Sets phoneType
     */
    public enum PhoneTypeEnum {
        @SerializedName("Fax")
        FAX("Fax"),

        @SerializedName("Landline")
        LANDLINE("Landline"),

        @SerializedName("Mobile")
        MOBILE("Mobile"),

        @SerializedName("SIP")
        SIP("SIP");

        @JsonValue
        private final String value;

        PhoneTypeEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("phoneType")
    private PhoneTypeEnum phoneType = null;

    @SerializedName("phoneNumber")
    private String phoneNumber = null;

    @SerializedName("phoneCountryCode")
    private String phoneCountryCode = null;

    public PhoneNumber phoneType(PhoneTypeEnum phoneType) {
        this.phoneType = phoneType;
        return this;
    }

    /**
     * Get phoneType
     *
     * @return phoneType
     **/
    public PhoneTypeEnum getPhoneType() {
        return phoneType;
    }

    public void setPhoneType(PhoneTypeEnum phoneType) {
        this.phoneType = phoneType;
    }

    public PhoneNumber phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    /**
     * Get phoneNumber
     *
     * @return phoneNumber
     **/
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public PhoneNumber phoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
        return this;
    }

    /**
     * Get phoneCountryCode
     *
     * @return phoneCountryCode
     **/
    public String getPhoneCountryCode() {
        return phoneCountryCode;
    }

    public void setPhoneCountryCode(String phoneCountryCode) {
        this.phoneCountryCode = phoneCountryCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PhoneNumber phoneNumber = (PhoneNumber) o;
        return Objects.equals(this.phoneType, phoneNumber.phoneType) && Objects.equals(this.phoneNumber, phoneNumber.phoneNumber) && Objects.equals(this.phoneCountryCode,
                                                                                                                                                    phoneNumber.phoneCountryCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneType, phoneNumber, phoneCountryCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class PhoneNumber {\n");

        sb.append("    phoneType: ").append(toIndentedString(phoneType)).append("\n");
        sb.append("    phoneNumber: ").append(toIndentedString(phoneNumber)).append("\n");
        sb.append("    phoneCountryCode: ").append(toIndentedString(phoneCountryCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }



}

