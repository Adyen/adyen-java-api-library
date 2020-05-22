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

import com.adyen.constants.TextConstants;
import com.adyen.util.Util;
import com.google.gson.annotations.SerializedName;

import java.util.Objects;

/**
 * FieldType
 */
public class FieldType {
    /**
     * type of the field, that did not pass the validation
     */
    public enum FieldNameEnum {
        @SerializedName("accountHolderDetails")
        ACCOUNTHOLDERDETAILS("accountHolderDetails"),

        @SerializedName("accountNumber")
        ACCOUNTNUMBER("accountNumber"),

        @SerializedName("accountType")
        ACCOUNTTYPE("accountType"),

        @SerializedName("address")
        ADDRESS("address"),

        @SerializedName("bankAccount")
        BANKACCOUNT("bankAccount"),

        @SerializedName("bankBicSwift")
        BANKBICSWIFT("bankBicSwift"),

        @SerializedName("bankCity")
        BANKCITY("bankCity"),

        @SerializedName("bankCode")
        BANKCODE("bankCode"),

        @SerializedName("bankName")
        BANKNAME("bankName"),

        @SerializedName("bankStatement")
        BANKSTATEMENT("bankStatement"),

        @SerializedName("branchCode")
        BRANCHCODE("branchCode"),

        @SerializedName("businessContact")
        BUSINESSCONTACT("businessContact"),

        @SerializedName("checkCode")
        CHECKCODE("checkCode"),

        @SerializedName("city")
        CITY("city"),

        @SerializedName("country")
        COUNTRY("country"),

        @SerializedName("countryCode")
        COUNTRYCODE("countryCode"),

        @SerializedName("currencyCode")
        CURRENCYCODE("currencyCode"),

        @SerializedName("dateOfBirth")
        DATEOFBIRTH("dateOfBirth"),

        @SerializedName("document")
        DOCUMENT("document"),

        @SerializedName("drivingLicence")
        DRIVINGLICENCE("drivingLicence"),

        @SerializedName("drivingLicenceBack")
        DRIVINGLICENCEBACK("drivingLicenceBack"),

        @SerializedName("email")
        EMAIL("email"),

        @SerializedName("firstName")
        FIRSTNAME("firstName"),

        @SerializedName("fullPhoneNumber")
        FULLPHONENUMBER("fullPhoneNumber"),

        @SerializedName("gender")
        GENDER("gender"),

        @SerializedName("houseNumberOrName")
        HOUSENUMBERORNAME("houseNumberOrName"),

        @SerializedName("iban")
        IBAN("iban"),

        @SerializedName("idCard")
        IDCARD("idCard"),

        @SerializedName("idNumber")
        IDNUMBER("idNumber"),

        @SerializedName("identityDocument")
        IDENTITYDOCUMENT("identityDocument"),

        @SerializedName("lastName")
        LASTNAME("lastName"),

        @SerializedName("legalBusinessName")
        LEGALBUSINESSNAME("legalBusinessName"),

        @SerializedName("merchantCategoryCode")
        MERCHANTCATEGORYCODE("merchantCategoryCode"),

        @SerializedName("microDeposit")
        MICRODEPOSIT("microDeposit"),

        @SerializedName("name")
        NAME("name"),

        @SerializedName("nationality")
        NATIONALITY("nationality"),

        @SerializedName("ownerCity")
        OWNERCITY("ownerCity"),

        @SerializedName("ownerCountryCode")
        OWNERCOUNTRYCODE("ownerCountryCode"),

        @SerializedName("ownerHouseNumberOrName")
        OWNERHOUSENUMBERORNAME("ownerHouseNumberOrName"),

        @SerializedName("ownerName")
        OWNERNAME("ownerName"),

        @SerializedName("ownerPostalCode")
        OWNERPOSTALCODE("ownerPostalCode"),

        @SerializedName("ownerState")
        OWNERSTATE("ownerState"),

        @SerializedName("ownerStreet")
        OWNERSTREET("ownerStreet"),

        @SerializedName("passport")
        PASSPORT("passport"),

        @SerializedName("personalData")
        PERSONALDATA("personalData"),

        @SerializedName("phoneCountryCode")
        PHONECOUNTRYCODE("phoneCountryCode"),

        @SerializedName("phoneNumber")
        PHONENUMBER("phoneNumber"),

        @SerializedName("postalCode")
        POSTALCODE("postalCode"),

        @SerializedName("shareholder")
        SHAREHOLDER("shareholder"),

        @SerializedName("stateOrProvince")
        STATEORPROVINCE("stateOrProvince"),

        @SerializedName("street")
        STREET("street"),

        @SerializedName("taxId")
        TAXID("taxId"),

        @SerializedName("tierNumber")
        TIERNUMBER("tierNumber"),

        @SerializedName("unknown")
        UNKNOWN("unknown"),

        @SerializedName("virtualAccount")
        VIRTUALACCOUNT("virtualAccount"),

        @SerializedName("webAddress")
        WEBADDRESS("webAddress");

        private String value;

        FieldNameEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    @SerializedName("fieldName")
    private FieldNameEnum fieldName = null;

    @SerializedName("field")
    private String field = null;

    @SerializedName("shareholderCode")
    private String shareholderCode = null;

    public FieldType fieldName(FieldNameEnum fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    /**
     * type of the field, that did not pass the validation
     *
     * @return fieldName
     **/
    public FieldNameEnum getFieldName() {
        return fieldName;
    }

    public void setFieldName(FieldNameEnum fieldName) {
        this.fieldName = fieldName;
    }

    public FieldType field(String field) {
        this.field = field;
        return this;
    }

    /**
     * full name of the property, that did not pass the validation
     *
     * @return field
     **/
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public FieldType shareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
        return this;
    }

    /**
     * Code of the shareholder, if this field belongs to a shareholder. Empty, if this field belongs to an account holder.
     *
     * @return shareholderCode
     **/
    public String getShareholderCode() {
        return shareholderCode;
    }

    public void setShareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (Objects.isNull(o) || getClass() != o.getClass()) {
            return false;
        }
        FieldType fieldType = (FieldType) o;
        return Objects.equals(this.fieldName, fieldType.fieldName) && Objects.equals(this.field, fieldType.field) && Objects.equals(this.shareholderCode, fieldType.shareholderCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fieldName, field, shareholderCode);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FieldType {").append(TextConstants.LINE_BREAK);

        sb.append("    fieldName: ").append(Util.toIndentedString(fieldName)).append(TextConstants.LINE_BREAK);
        sb.append("    field: ").append(Util.toIndentedString(field)).append(TextConstants.LINE_BREAK);
        sb.append("    shareholderCode: ").append(Util.toIndentedString(shareholderCode)).append(TextConstants.LINE_BREAK);
        sb.append("}");
        return sb.toString();
    }

}

