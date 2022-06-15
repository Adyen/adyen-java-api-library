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
 * Copyright (c) 2021 Adyen B.V.
 * This file is open source and available under the MIT license.
 * See the LICENSE file for more info.
 */

package com.adyen.model.marketpay.notification;

import com.fasterxml.jackson.annotation.JsonValue;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * FieldType
 */

public class FieldType {
    @SerializedName("field")
    private String field = null;

    /**
     * The type of the field.
     */
    @JsonAdapter(FieldNameEnum.Adapter.class)
    public enum FieldNameEnum {
        ACCOUNTCODE("accountCode"),
        ACCOUNTHOLDERCODE("accountHolderCode"),
        ACCOUNTHOLDERDETAILS("accountHolderDetails"),
        ACCOUNTNUMBER("accountNumber"),
        ACCOUNTSTATETYPE("accountStateType"),
        ACCOUNTSTATUS("accountStatus"),
        ACCOUNTTYPE("accountType"),
        ADDRESS("address"),
        BANKACCOUNT("bankAccount"),
        BANKACCOUNTCODE("bankAccountCode"),
        BANKACCOUNTNAME("bankAccountName"),
        BANKACCOUNTUUID("bankAccountUUID"),
        BANKBICSWIFT("bankBicSwift"),
        BANKCITY("bankCity"),
        BANKCODE("bankCode"),
        BANKNAME("bankName"),
        BANKSTATEMENT("bankStatement"),
        BRANCHCODE("branchCode"),
        BUSINESSCONTACT("businessContact"),
        CARDTOKEN("cardToken"),
        CHECKCODE("checkCode"),
        CITY("city"),
        COMPANYREGISTRATION("companyRegistration"),
        CONSTITUTIONALDOCUMENT("constitutionalDocument"),
        COUNTRY("country"),
        COUNTRYCODE("countryCode"),
        CURRENCY("currency"),
        CURRENCYCODE("currencyCode"),
        DATEOFBIRTH("dateOfBirth"),
        DESCRIPTION("description"),
        DESTINATIONACCOUNTCODE("destinationAccountCode"),
        DOCUMENT("document"),
        DOCUMENTEXPIRATIONDATE("documentExpirationDate"),
        DOCUMENTISSUERCOUNTRY("documentIssuerCountry"),
        DOCUMENTISSUERSTATE("documentIssuerState"),
        DOCUMENTNAME("documentName"),
        DOCUMENTNUMBER("documentNumber"),
        DOCUMENTTYPE("documentType"),
        DOINGBUSINESSAS("doingBusinessAs"),
        DRIVINGLICENCE("drivingLicence"),
        DRIVINGLICENCEBACK("drivingLicenceBack"),
        DRIVINGLICENSE("drivingLicense"),
        EMAIL("email"),
        FIRSTNAME("firstName"),
        FORMTYPE("formType"),
        FULLPHONENUMBER("fullPhoneNumber"),
        GENDER("gender"),
        HOPWEBSERVICEUSER("hopWebserviceUser"),
        HOUSENUMBERORNAME("houseNumberOrName"),
        IBAN("iban"),
        IDCARD("idCard"),
        IDCARDBACK("idCardBack"),
        IDCARDFRONT("idCardFront"),
        IDNUMBER("idNumber"),
        IDENTITYDOCUMENT("identityDocument"),
        INDIVIDUALDETAILS("individualDetails"),
        JOBTITLE("jobTitle"),
        LASTNAME("lastName"),
        LEGALARRANGEMENT("legalArrangement"),
        LEGALARRANGEMENTCODE("legalArrangementCode"),
        LEGALARRANGEMENTENTITY("legalArrangementEntity"),
        LEGALARRANGEMENTENTITYCODE("legalArrangementEntityCode"),
        LEGALARRANGEMENTLEGALFORM("legalArrangementLegalForm"),
        LEGALARRANGEMENTMEMBER("legalArrangementMember"),
        LEGALARRANGEMENTNAME("legalArrangementName"),
        LEGALARRANGEMENTREFERENCE("legalArrangementReference"),
        LEGALARRANGEMENTREGISTRATIONNUMBER("legalArrangementRegistrationNumber"),
        LEGALARRANGEMENTTAXNUMBER("legalArrangementTaxNumber"),
        LEGALARRANGEMENTTYPE("legalArrangementType"),
        LEGALBUSINESSNAME("legalBusinessName"),
        LEGALENTITY("legalEntity"),
        LEGALENTITYTYPE("legalEntityType"),
        MERCHANTACCOUNT("merchantAccount"),
        MERCHANTCATEGORYCODE("merchantCategoryCode"),
        MERCHANTREFERENCE("merchantReference"),
        MICRODEPOSIT("microDeposit"),
        NAME("name"),
        NATIONALITY("nationality"),
        ORIGINALREFERENCE("originalReference"),
        OWNERCITY("ownerCity"),
        OWNERCOUNTRYCODE("ownerCountryCode"),
        OWNERHOUSENUMBERORNAME("ownerHouseNumberOrName"),
        OWNERNAME("ownerName"),
        OWNERPOSTALCODE("ownerPostalCode"),
        OWNERSTATE("ownerState"),
        OWNERSTREET("ownerStreet"),
        PASSPORT("passport"),
        PASSPORTNUMBER("passportNumber"),
        PAYOUTMETHODCODE("payoutMethodCode"),
        PERSONALDATA("personalData"),
        PHONECOUNTRYCODE("phoneCountryCode"),
        PHONENUMBER("phoneNumber"),
        POSTALCODE("postalCode"),
        PRIMARYCURRENCY("primaryCurrency"),
        REASON("reason"),
        REGISTRATIONNUMBER("registrationNumber"),
        RETURNURL("returnUrl"),
        SCHEDULE("schedule"),
        SHAREHOLDER("shareholder"),
        SHAREHOLDERCODE("shareholderCode"),
        SHAREHOLDERTYPE("shareholderType"),
        SHOPPERINTERACTION("shopperInteraction"),
        SIGNATORY("signatory"),
        SIGNATORYCODE("signatoryCode"),
        SOCIALSECURITYNUMBER("socialSecurityNumber"),
        SOURCEACCOUNTCODE("sourceAccountCode"),
        SPLITACCOUNT("splitAccount"),
        SPLITCURRENCY("splitCurrency"),
        SPLITVALUE("splitValue"),
        SPLITS("splits"),
        STATEORPROVINCE("stateOrProvince"),
        STATUS("status"),
        STOCKEXCHANGE("stockExchange"),
        STOCKNUMBER("stockNumber"),
        STOCKTICKER("stockTicker"),
        STORE("store"),
        STOREDETAIL("storeDetail"),
        STORENAME("storeName"),
        STOREREFERENCE("storeReference"),
        STREET("street"),
        TAXID("taxId"),
        TIER("tier"),
        TIERNUMBER("tierNumber"),
        TRANSFERCODE("transferCode"),
        UNKNOWN("unknown"),
        VALUE("value"),
        VERIFICATIONTYPE("verificationType"),
        VIRTUALACCOUNT("virtualAccount"),
        VISANUMBER("visaNumber"),
        WEBADDRESS("webAddress"),
        YEAR("year");

        @JsonValue
        private final String value;

        FieldNameEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static FieldNameEnum fromValue(String text) {
            for (FieldNameEnum b : FieldNameEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<FieldNameEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final FieldNameEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public FieldNameEnum read(final JsonReader jsonReader) throws IOException {
                String value = jsonReader.nextString();
                return FieldNameEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("fieldName")
    private FieldNameEnum fieldName = null;

    @SerializedName("shareholderCode")
    private String shareholderCode = null;

    public FieldType field(String field) {
        this.field = field;
        return this;
    }

    /**
     * The full name of the property.
     *
     * @return field
     **/
    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public FieldType fieldName(FieldNameEnum fieldName) {
        this.fieldName = fieldName;
        return this;
    }

    /**
     * The type of the field.
     *
     * @return fieldName
     **/
    public FieldNameEnum getFieldName() {
        return fieldName;
    }

    public void setFieldName(FieldNameEnum fieldName) {
        this.fieldName = fieldName;
    }

    public FieldType shareholderCode(String shareholderCode) {
        this.shareholderCode = shareholderCode;
        return this;
    }

    /**
     * The code of the shareholder that the field belongs to. If empty, the field belongs to an account holder.
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
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        FieldType fieldType = (FieldType) o;
        return Objects.equals(this.field, fieldType.field) &&
                Objects.equals(this.fieldName, fieldType.fieldName) &&
                Objects.equals(this.shareholderCode, fieldType.shareholderCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, fieldName, shareholderCode);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class FieldType {\n");

        sb.append("    field: ").append(toIndentedString(field)).append("\n");
        sb.append("    fieldName: ").append(toIndentedString(fieldName)).append("\n");
        sb.append("    shareholderCode: ").append(toIndentedString(shareholderCode)).append("\n");
        sb.append("}");
        return sb.toString();
    }
}
