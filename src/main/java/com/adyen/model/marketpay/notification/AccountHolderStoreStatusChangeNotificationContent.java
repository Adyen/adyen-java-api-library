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
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.adyen.util.Util.toIndentedString;

/**
 * AccountHolderStoreStatusChangeNotificationContent
 */

public class AccountHolderStoreStatusChangeNotificationContent {
    @SerializedName("accountHolderCode")
    private String accountHolderCode = null;

    @SerializedName("invalidFields")
    private List<ErrorFieldType> invalidFields = null;

    /**
     * The new status of the account holder.
     */
    @JsonAdapter(NewStatusEnum.Adapter.class)
    public enum NewStatusEnum {
        ACTIVE("Active"),
        CLOSED("Closed"),
        INACTIVE("Inactive"),
        INACTIVEWITHMODIFICATIONS("InactiveWithModifications"),
        PENDING("Pending");

        @JsonValue
        private final String value;

        NewStatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static NewStatusEnum fromValue(String text) {
            for (NewStatusEnum b : NewStatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<NewStatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final NewStatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public NewStatusEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return NewStatusEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("newStatus")
    private NewStatusEnum newStatus = null;

    /**
     * The former status of the account holder.
     */
    @JsonAdapter(OldStatusEnum.Adapter.class)
    public enum OldStatusEnum {
        ACTIVE("Active"),
        CLOSED("Closed"),
        INACTIVE("Inactive"),
        INACTIVEWITHMODIFICATIONS("InactiveWithModifications"),
        PENDING("Pending");

        @JsonValue
        private final String value;

        OldStatusEnum(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        public static OldStatusEnum fromValue(String text) {
            for (OldStatusEnum b : OldStatusEnum.values()) {
                if (String.valueOf(b.value).equals(text)) {
                    return b;
                }
            }
            return null;
        }

        public static class Adapter extends TypeAdapter<OldStatusEnum> {
            @Override
            public void write(final JsonWriter jsonWriter, final OldStatusEnum enumeration) throws IOException {
                jsonWriter.value(enumeration.getValue());
            }

            @Override
            public OldStatusEnum read(final JsonReader jsonReader) throws IOException {
                Object value = jsonReader.nextString();
                return OldStatusEnum.fromValue(String.valueOf(value));
            }
        }
    }

    @SerializedName("oldStatus")
    private OldStatusEnum oldStatus = null;

    @SerializedName("reason")
    private String reason = null;

    @SerializedName("store")
    private String store = null;

    @SerializedName("storeReference")
    private String storeReference = null;

    public AccountHolderStoreStatusChangeNotificationContent accountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
        return this;
    }

    /**
     * The code of the account holder.
     *
     * @return accountHolderCode
     **/
    public String getAccountHolderCode() {
        return accountHolderCode;
    }

    public void setAccountHolderCode(String accountHolderCode) {
        this.accountHolderCode = accountHolderCode;
    }

    public AccountHolderStoreStatusChangeNotificationContent invalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
        return this;
    }

    public AccountHolderStoreStatusChangeNotificationContent addInvalidFieldsItem(ErrorFieldType invalidFieldsItem) {
        if (this.invalidFields == null) {
            this.invalidFields = new ArrayList<ErrorFieldType>();
        }
        this.invalidFields.add(invalidFieldsItem);
        return this;
    }

    /**
     * In case the store status has not been updated, contains fields that did not pass the validation.
     *
     * @return invalidFields
     **/
    public List<ErrorFieldType> getInvalidFields() {
        return invalidFields;
    }

    public void setInvalidFields(List<ErrorFieldType> invalidFields) {
        this.invalidFields = invalidFields;
    }

    public AccountHolderStoreStatusChangeNotificationContent newStatus(NewStatusEnum newStatus) {
        this.newStatus = newStatus;
        return this;
    }

    /**
     * The new status of the account holder.
     *
     * @return newStatus
     **/
    public NewStatusEnum getNewStatus() {
        return newStatus;
    }

    public void setNewStatus(NewStatusEnum newStatus) {
        this.newStatus = newStatus;
    }

    public AccountHolderStoreStatusChangeNotificationContent oldStatus(OldStatusEnum oldStatus) {
        this.oldStatus = oldStatus;
        return this;
    }

    /**
     * The former status of the account holder.
     *
     * @return oldStatus
     **/
    public OldStatusEnum getOldStatus() {
        return oldStatus;
    }

    public void setOldStatus(OldStatusEnum oldStatus) {
        this.oldStatus = oldStatus;
    }

    public AccountHolderStoreStatusChangeNotificationContent reason(String reason) {
        this.reason = reason;
        return this;
    }

    /**
     * The reason for the status change.
     *
     * @return reason
     **/
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public AccountHolderStoreStatusChangeNotificationContent store(String store) {
        this.store = store;
        return this;
    }

    /**
     * Alphanumeric identifier of the store.
     *
     * @return store
     **/
    public String getStore() {
        return store;
    }

    public void setStore(String store) {
        this.store = store;
    }

    public AccountHolderStoreStatusChangeNotificationContent storeReference(String storeReference) {
        this.storeReference = storeReference;
        return this;
    }

    /**
     * Store store reference.
     *
     * @return storeReference
     **/
    public String getStoreReference() {
        return storeReference;
    }

    public void setStoreReference(String storeReference) {
        this.storeReference = storeReference;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AccountHolderStoreStatusChangeNotificationContent accountHolderStoreStatusChangeNotificationContent = (AccountHolderStoreStatusChangeNotificationContent) o;
        return Objects.equals(this.accountHolderCode, accountHolderStoreStatusChangeNotificationContent.accountHolderCode) &&
                Objects.equals(this.invalidFields, accountHolderStoreStatusChangeNotificationContent.invalidFields) &&
                Objects.equals(this.newStatus, accountHolderStoreStatusChangeNotificationContent.newStatus) &&
                Objects.equals(this.oldStatus, accountHolderStoreStatusChangeNotificationContent.oldStatus) &&
                Objects.equals(this.reason, accountHolderStoreStatusChangeNotificationContent.reason) &&
                Objects.equals(this.store, accountHolderStoreStatusChangeNotificationContent.store) &&
                Objects.equals(this.storeReference, accountHolderStoreStatusChangeNotificationContent.storeReference);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountHolderCode, invalidFields, newStatus, oldStatus, reason, store, storeReference);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class AccountHolderStoreStatusChangeNotificationContent {\n");

        sb.append("    accountHolderCode: ").append(toIndentedString(accountHolderCode)).append("\n");
        sb.append("    invalidFields: ").append(toIndentedString(invalidFields)).append("\n");
        sb.append("    newStatus: ").append(toIndentedString(newStatus)).append("\n");
        sb.append("    oldStatus: ").append(toIndentedString(oldStatus)).append("\n");
        sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    storeReference: ").append(toIndentedString(storeReference)).append("\n");
        sb.append("}");
        return sb.toString();
    }

}
